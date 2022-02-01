package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class GLViewContext
  implements SoundPool.OnLoadCompleteListener
{
  private BgmPlayer mBgmPlayer;
  private final ArrayList<GLViewContext.LoadItem> mLoadItemList = new ArrayList();
  private ArrayList<GLViewContext.AudioItem> mPlayCommandList = new ArrayList();
  private float[] mProjectMatrix = new float[16];
  public BoyDataReport mReport = new BoyDataReport();
  private SoundPool mSoundPool;
  private HashMap<String, GLViewContext.AudioItem> mSoundPoolIdCache = new HashMap();
  private CopyOnWriteArrayList<Integer> mStreamIdCache = new CopyOnWriteArrayList();
  private Rect mSurfaceViewSize;
  private float mVideoResolveRatio;
  private Rect mViewPort;
  private float mViewPortRatio;
  
  public GLViewContext()
  {
    Matrix.setIdentityM(this.mProjectMatrix, 0);
    this.mBgmPlayer = new BgmPlayer();
  }
  
  private void calledInGlThread(int paramInt1, int paramInt2)
  {
    Object localObject = this.mSoundPoolIdCache.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localAudioItem = (GLViewContext.AudioItem)((Iterator)localObject).next();
      if (localAudioItem.sampleId == paramInt1)
      {
        localAudioItem.loaded = true;
        localAudioItem.status = paramInt2;
      }
    }
    GLViewContext.AudioItem localAudioItem = null;
    Iterator localIterator = this.mPlayCommandList.iterator();
    do
    {
      localObject = localAudioItem;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (GLViewContext.AudioItem)localIterator.next();
    } while (((GLViewContext.AudioItem)localObject).sampleId != paramInt1);
    playAudioItem((GLViewContext.AudioItem)localObject);
    if (localObject != null) {
      this.mPlayCommandList.remove(localObject);
    }
  }
  
  public static void filterCullBegin()
  {
    GLES20.glEnable(2884);
    if (GlView.ENABLE_X_INVERSE) {
      GLES20.glFrontFace(2304);
    } else {
      GLES20.glFrontFace(2305);
    }
    GLES20.glCullFace(1029);
  }
  
  public static void filterCullEnd()
  {
    GLES20.glDisable(2884);
  }
  
  private void playAudioItem(GLViewContext.AudioItem paramAudioItem)
  {
    if (paramAudioItem.loaded)
    {
      if (paramAudioItem.status == 0)
      {
        int i = this.mSoundPool.play(paramAudioItem.sampleId, 1.0F, 1.0F, paramAudioItem.priority, paramAudioItem.loop, 1.0F);
        this.mStreamIdCache.add(Integer.valueOf(i));
      }
    }
    else if (!this.mPlayCommandList.contains(paramAudioItem)) {
      this.mPlayCommandList.add(paramAudioItem);
    }
  }
  
  private void playSoundInternal(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mSoundPool == null) {
      return;
    }
    if (!this.mSoundPoolIdCache.containsKey(paramString))
    {
      GLViewContext.AudioItem localAudioItem = new GLViewContext.AudioItem(this.mSoundPool.load(paramString, 1));
      this.mSoundPoolIdCache.put(paramString, localAudioItem);
    }
    paramString = (GLViewContext.AudioItem)this.mSoundPoolIdCache.get(paramString);
    paramString.loop = paramInt1;
    paramString.priority = paramInt2;
    playAudioItem(paramString);
  }
  
  public void allPauseAudio()
  {
    Object localObject = this.mSoundPool;
    if (localObject != null) {
      ((SoundPool)localObject).autoPause();
    }
    localObject = this.mBgmPlayer;
    if (localObject != null) {
      ((BgmPlayer)localObject).pauseAudio();
    }
  }
  
  public void allResumeAudio()
  {
    Object localObject = this.mSoundPool;
    if (localObject != null) {
      ((SoundPool)localObject).autoResume();
    }
    localObject = this.mBgmPlayer;
    if (localObject != null) {
      ((BgmPlayer)localObject).resumeAudio();
    }
  }
  
  public void executeDraw()
  {
    if (this.mLoadItemList.size() > 0) {
      synchronized (this.mLoadItemList)
      {
        GLViewContext.LoadItem[] arrayOfLoadItem = new GLViewContext.LoadItem[this.mLoadItemList.size()];
        this.mLoadItemList.toArray(arrayOfLoadItem);
        this.mLoadItemList.clear();
        int j = arrayOfLoadItem.length;
        int i = 0;
        if (i < j)
        {
          ??? = arrayOfLoadItem[i];
          if (??? != null) {
            calledInGlThread(???.sampleId, ???.status);
          }
          i += 1;
        }
      }
    }
  }
  
  public float[] getProjectMatrix()
  {
    return this.mProjectMatrix;
  }
  
  public float getRealVideoRatio()
  {
    return this.mVideoResolveRatio;
  }
  
  public final Rect getSurfaceViewSize()
  {
    return this.mSurfaceViewSize;
  }
  
  public final Rect getViewPort()
  {
    return this.mViewPort;
  }
  
  public float getViewPortRatio()
  {
    return this.mViewPortRatio;
  }
  
  public void loadSoundResource(List<String> paramList)
  {
    if ((this.mSoundPool == null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      this.mSoundPoolIdCache.clear();
      this.mStreamIdCache.clear();
      int i = 0;
      this.mSoundPool = new SoundPool(3, 3, 0);
      this.mSoundPool.setOnLoadCompleteListener(this);
      while (i < paramList.size())
      {
        GLViewContext.AudioItem localAudioItem = new GLViewContext.AudioItem(this.mSoundPool.load((String)paramList.get(i), 1));
        this.mSoundPoolIdCache.put(paramList.get(i), localAudioItem);
        i += 1;
      }
    }
  }
  
  public final void mapNormalRegion(RectF paramRectF)
  {
    float f = getViewPortRatio();
    paramRectF.set(paramRectF.left * f, paramRectF.top * f, paramRectF.right * f, paramRectF.bottom * f);
  }
  
  public void onLoadComplete(SoundPool arg1, int paramInt1, int paramInt2)
  {
    GLViewContext.LoadItem localLoadItem = new GLViewContext.LoadItem();
    localLoadItem.sampleId = paramInt1;
    localLoadItem.status = paramInt2;
    synchronized (this.mLoadItemList)
    {
      this.mLoadItemList.add(localLoadItem);
      return;
    }
  }
  
  public void playBackGroundSound(String paramString)
  {
    BgmPlayer localBgmPlayer = this.mBgmPlayer;
    if (localBgmPlayer != null) {
      localBgmPlayer.playAsync(paramString);
    }
  }
  
  public void playBackGroundSoundPool(String paramString)
  {
    playSoundInternal(paramString, -1, 5);
  }
  
  public void playSound(String paramString)
  {
    playSoundInternal(paramString, 0, 1);
  }
  
  public void playSoundCount(String paramString, int paramInt)
  {
    playSoundInternal(paramString, paramInt, 1);
  }
  
  public void releaseSoundResource()
  {
    if (this.mSoundPool == null) {
      return;
    }
    Object localObject1 = this.mStreamIdCache.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Integer)((Iterator)localObject1).next()).intValue();
      this.mSoundPool.stop(i);
    }
    this.mStreamIdCache.clear();
    localObject1 = this.mSoundPoolIdCache.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (GLViewContext.AudioItem)this.mSoundPoolIdCache.get(localObject2);
      this.mSoundPool.unload(((GLViewContext.AudioItem)localObject2).sampleId);
    }
    this.mSoundPoolIdCache.clear();
    this.mSoundPool.release();
    this.mSoundPool = null;
    localObject1 = this.mBgmPlayer;
    if (localObject1 != null)
    {
      ((BgmPlayer)localObject1).releaseResource();
      this.mBgmPlayer = null;
    }
  }
  
  public final void setSurfaceSize(Rect paramRect)
  {
    this.mSurfaceViewSize = paramRect;
  }
  
  public final void setViewPort(Rect paramRect)
  {
    this.mViewPort = paramRect;
    Matrix.orthoM(this.mProjectMatrix, 0, 0.0F, this.mViewPort.width(), this.mViewPort.height(), 0.0F, 0.0F, 1.0F);
    this.mViewPortRatio = (this.mViewPort.width() * 1.0F / this.mSurfaceViewSize.width());
    this.mVideoResolveRatio = (this.mViewPort.width() / 750.0F);
  }
  
  public void stopAllSound()
  {
    if (this.mSoundPool != null)
    {
      localObject = this.mStreamIdCache.iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        this.mSoundPool.stop(i);
      }
      this.mStreamIdCache.clear();
    }
    Object localObject = this.mBgmPlayer;
    if (localObject != null) {
      ((BgmPlayer)localObject).stop();
    }
  }
  
  public final void unmapNormalRegion(RectF paramRectF)
  {
    float f = getViewPortRatio();
    paramRectF.set(paramRectF.left / f, paramRectF.top / f, paramRectF.right / f, paramRectF.bottom / f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext
 * JD-Core Version:    0.7.0.1
 */