package com.tencent.thumbplayer.core.connection;

import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.player.TPNativePlayer;

public class TPNativePlayerConnectionMgr
{
  private boolean mInited = false;
  private boolean mIsLibLoaded = false;
  private long mNativeContext = 0L;
  
  public TPNativePlayerConnectionMgr()
  {
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      this.mIsLibLoaded = true;
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      localUnsupportedOperationException.printStackTrace();
      this.mIsLibLoaded = false;
    }
  }
  
  private native int _activeAllConnections();
  
  private native int _activeConnection(int paramInt);
  
  private native int _addConnection(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  private native int _addConnectionWithAddr(long paramLong1, Object paramObject1, long paramLong2, Object paramObject2);
  
  private native void _deactiveAllConnections();
  
  private native void _deactiveConnection(int paramInt);
  
  private native void _init();
  
  private native void _removeConnection(int paramInt);
  
  private native void _unInit();
  
  public int activeAllConnections()
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to addConnection due to invalid state.");
    }
    return _activeAllConnections();
  }
  
  public int activeConnection(int paramInt)
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to addConnection due to invalid state.");
    }
    return _activeConnection(paramInt);
  }
  
  public int addConnection(long paramLong1, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode1, long paramLong2, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode2)
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to addConnection due to invalid state.");
    }
    return _addConnectionWithAddr(paramLong1, paramTPNativePlayerConnectionNode1, paramLong2, paramTPNativePlayerConnectionNode2);
  }
  
  public int addConnection(TPNativePlayer paramTPNativePlayer1, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode1, TPNativePlayer paramTPNativePlayer2, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode2)
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to addConnection due to invalid state.");
    }
    return _addConnection(paramTPNativePlayer1, paramTPNativePlayerConnectionNode1, paramTPNativePlayer2, paramTPNativePlayerConnectionNode2);
  }
  
  public void deactiveAllConnections()
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to addConnection due to invalid state.");
    }
    _deactiveAllConnections();
  }
  
  public void deactiveConnection(int paramInt)
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to addConnection due to invalid state.");
    }
    _deactiveConnection(paramInt);
  }
  
  public void init()
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (this.mInited) {
      throw new IllegalStateException("Failed to init due to invalid state.");
    }
    this.mInited = true;
    _init();
  }
  
  public void removeConnection(int paramInt)
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to addConnection due to invalid state.");
    }
    _removeConnection(paramInt);
  }
  
  public void unInit()
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      return;
    }
    this.mInited = false;
    _unInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionMgr
 * JD-Core Version:    0.7.0.1
 */