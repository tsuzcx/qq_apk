package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListPlayerListenerCallback
  implements PlayerListenerCallback
{
  private final CopyOnWriteArrayList<PlayerListenerCallback> mCallbacks = new CopyOnWriteArrayList();
  
  public void add(PlayerListenerCallback paramPlayerListenerCallback)
  {
    try
    {
      this.mCallbacks.add(paramPlayerListenerCallback);
      return;
    }
    finally
    {
      paramPlayerListenerCallback = finally;
      throw paramPlayerListenerCallback;
    }
  }
  
  public void add(ListPlayerListenerCallback paramListPlayerListenerCallback)
  {
    try
    {
      this.mCallbacks.addAll(paramListPlayerListenerCallback.toCollection());
      return;
    }
    finally
    {
      paramListPlayerListenerCallback = finally;
      throw paramListPlayerListenerCallback;
    }
  }
  
  public void addAll(List<PlayerListenerCallback> paramList)
  {
    try
    {
      this.mCallbacks.addAll(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void clear()
  {
    try
    {
      this.mCallbacks.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onBufferingUpdate(paramBaseMediaPlayer, paramInt);
    }
  }
  
  public void onCompletion(BaseMediaPlayer paramBaseMediaPlayer)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onCompletion(paramBaseMediaPlayer);
    }
  }
  
  public void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onError(paramBaseMediaPlayer, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onPrepared(paramBaseMediaPlayer);
    }
  }
  
  public void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onSeekComplete(paramBaseMediaPlayer, paramInt);
    }
  }
  
  public void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onStarted(paramBaseMediaPlayer);
    }
  }
  
  public void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onStateChanged(paramBaseMediaPlayer, paramInt);
    }
  }
  
  public void remove(PlayerListenerCallback paramPlayerListenerCallback)
  {
    try
    {
      this.mCallbacks.remove(paramPlayerListenerCallback);
      return;
    }
    finally
    {
      paramPlayerListenerCallback = finally;
      throw paramPlayerListenerCallback;
    }
  }
  
  public List<PlayerListenerCallback> toCollection()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.mCallbacks);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback
 * JD-Core Version:    0.7.0.1
 */