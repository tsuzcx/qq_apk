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
    Object localObject1 = this.mSoundPoolIdCache.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (GLViewContext.AudioItem)((Iterator)localObject1).next();
      if (((GLViewContext.AudioItem)localObject2).sampleId == paramInt1)
      {
        ((GLViewContext.AudioItem)localObject2).loaded = true;
        ((GLViewContext.AudioItem)localObject2).status = paramInt2;
      }
    }
    Object localObject2 = this.mPlayCommandList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (GLViewContext.AudioItem)((Iterator)localObject2).next();
      if (((GLViewContext.AudioItem)localObject1).sampleId == paramInt1) {
        playAudioItem((GLViewContext.AudioItem)localObject1);
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.mPlayCommandList.remove(localObject1);
      }
      return;
      localObject1 = null;
    }
  }
  
  public static void filterCullBegin()
  {
    GLES20.glEnable(2884);
    if (GlView.ENABLE_X_INVERSE) {
      GLES20.glFrontFace(2304);
    }
    for (;;)
    {
      GLES20.glCullFace(1029);
      return;
      GLES20.glFrontFace(2305);
    }
  }
  
  public static void filterCullEnd()
  {
    GLES20.glDisable(2884);
  }
  
  private void playAudioItem(GLViewContext.AudioItem paramAudioItem)
  {
    if (paramAudioItem.loaded) {
      if (paramAudioItem.status == 0)
      {
        i = this.mSoundPool.play(paramAudioItem.sampleId, 1.0F, 1.0F, paramAudioItem.priority, paramAudioItem.loop, 1.0F);
        this.mStreamIdCache.add(Integer.valueOf(i));
      }
    }
    while (this.mPlayCommandList.contains(paramAudioItem))
    {
      int i;
      return;
    }
    this.mPlayCommandList.add(paramAudioItem);
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
    if (this.mSoundPool != null) {
      this.mSoundPool.autoPause();
    }
    if (this.mBgmPlayer != null) {
      this.mBgmPlayer.pauseAudio();
    }
  }
  
  public void allResumeAudio()
  {
    if (this.mSoundPool != null) {
      this.mSoundPool.autoResume();
    }
    if (this.mBgmPlayer != null) {
      this.mBgmPlayer.resumeAudio();
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
    if ((this.mSoundPool != null) || (paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      this.mSoundPoolIdCache.clear();
      this.mStreamIdCache.clear();
      this.mSoundPool = new SoundPool(3, 3, 0);
      this.mSoundPool.setOnLoadCompleteListener(this);
      int i = 0;
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
    paramRectF.set(paramRectF.left * f, paramRectF.top * f, paramRectF.right * f, f * paramRectF.bottom);
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
    if (this.mBgmPlayer != null) {
      this.mBgmPlayer.playAsync(paramString);
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
    if (this.mSoundPool == null) {}
    do
    {
      return;
      Iterator localIterator = this.mStreamIdCache.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.mSoundPool.stop(i);
      }
      this.mStreamIdCache.clear();
      localIterator = this.mSoundPoolIdCache.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (GLViewContext.AudioItem)this.mSoundPoolIdCache.get(localObject);
        this.mSoundPool.unload(((GLViewContext.AudioItem)localObject).sampleId);
      }
      this.mSoundPoolIdCache.clear();
      this.mSoundPool.release();
      this.mSoundPool = null;
    } while (this.mBgmPlayer == null);
    this.mBgmPlayer.releaseResource();
    this.mBgmPlayer = null;
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
      Iterator localIterator = this.mStreamIdCache.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.mSoundPool.stop(i);
      }
      this.mStreamIdCache.clear();
    }
    if (this.mBgmPlayer != null) {
      this.mBgmPlayer.stop();
    }
  }
  
  public final void unmapNormalRegion(RectF paramRectF)
  {
    float f = getViewPortRatio();
    paramRectF.set(paramRectF.left / f, paramRectF.top / f, paramRectF.right / f, paramRectF.bottom / f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext
 * JD-Core Version:    0.7.0.1
 */