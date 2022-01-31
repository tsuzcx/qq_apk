package com.tencent.mobileqq.shortvideo.pkvideo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class PKFilter
  extends QQBaseFilter
{
  public static String TAG = "PKFilter";
  public static final String TAG_ENCODE = TAG + "_encode";
  private boolean havePrepared = false;
  private boolean isDebug = false;
  private boolean isPKdecoderNeedWaitStart;
  private boolean isRepeat;
  private String mAudioPath;
  private DecodePlayer mDecodePlayer;
  private long mFilterDecodeTimeStamp;
  private int mHeight;
  private boolean mIsEncode;
  private boolean mIsSurfaceCreated;
  private int mLastOutputTexture = -1;
  private float[] mMvpMatrix = new float[16];
  private long mOrigVideoDurationMS = -1L;
  private String mPKCoverPath;
  private int mPKCoverTextureID = -1;
  private PKFilter.PKDecodeListener mPKDecodeListener;
  private String mPKTitleBmgPath;
  private int mPKTitleTextureID = -1;
  private long mPKVideoDecodeTimeStamp;
  private long mPkVideoDurationMs = -1L;
  private RenderBuffer mRenderFBO;
  private int mRivalTextureID = -1;
  private SurfaceTexture mSurfaceTexture;
  private TextureRender mTextureRender;
  private String mVideoPath;
  private int mWidth;
  private PKFilter.OnFrameAvailableListener onFrameAvailableListener;
  
  public PKFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(183, paramQQFilterRenderManager);
  }
  
  private void assertFailed(String paramString)
  {
    doAssert(true, paramString);
  }
  
  private void doAssert(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      return;
    }
    if (!this.isDebug)
    {
      SLog.e(TAG, paramString);
      return;
    }
    throw new RuntimeException(paramString);
  }
  
  private int drawPKFrame(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mRenderFBO.bind();
    int i = GLES20.glCheckFramebufferStatus(36160);
    if (i != 36053)
    {
      assertFailed("fbo is not ready plz fix it error:" + i);
      return this.mLastOutputTexture;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    if (paramInt3 >= 0)
    {
      Matrix.setIdentityM(this.mMvpMatrix, 0);
      Matrix.translateM(this.mMvpMatrix, 0, 0.0F, 0.5F, 0.0F);
      Matrix.scaleM(this.mMvpMatrix, 0, 1.0F, 0.25F, 1.0F);
      this.mTextureRender.drawTexture(3553, paramInt3, null, this.mMvpMatrix);
    }
    if (paramInt2 >= 0)
    {
      Matrix.setIdentityM(this.mMvpMatrix, 0);
      Matrix.translateM(this.mMvpMatrix, 0, 0.5F, -0.24F, 0.0F);
      Matrix.scaleM(this.mMvpMatrix, 0, 0.5F, 0.5F, 1.0F);
      if (this.mSurfaceTexture != null) {
        break label253;
      }
      this.mTextureRender.drawTexture(3553, paramInt2, null, this.mMvpMatrix);
    }
    for (;;)
    {
      if (paramInt1 >= 0)
      {
        Matrix.setIdentityM(this.mMvpMatrix, 0);
        Matrix.translateM(this.mMvpMatrix, 0, -0.5F, -0.24F, 0.0F);
        Matrix.scaleM(this.mMvpMatrix, 0, 0.5F, 0.5F, 1.0F);
        this.mTextureRender.drawTexture(3553, paramInt1, null, this.mMvpMatrix);
      }
      this.mRenderFBO.unbind();
      this.mOutputTextureID = this.mRenderFBO.getTexId();
      return this.mOutputTextureID;
      label253:
      this.mTextureRender.drawTexture(36197, paramInt2, null, this.mMvpMatrix);
    }
  }
  
  private void syncDecoderStartTime(long paramLong) {}
  
  public void config(String paramString1, String paramString2, String paramString3, long paramLong, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      assertFailed("config the pk video file path and cover both null!!");
    }
    do
    {
      return;
      SLog.e(TAG, "config pk video path = " + paramString1 + ", cover= " + paramString2 + ",mOrigVideoDurationMS = " + paramLong + ",isEncode=" + paramBoolean);
      this.mIsEncode = paramBoolean;
      this.mVideoPath = paramString1;
      this.mPKCoverPath = paramString2;
      this.mPKTitleBmgPath = paramString3;
      this.mOrigVideoDurationMS = paramLong;
      this.mPKDecodeListener = new PKFilter.PKDecodeListener(this, null);
      if (this.mDecodePlayer != null) {
        this.mDecodePlayer.stopPlay();
      }
    } while (!FileUtil.fileExistsAndNotEmpty(paramString1));
    this.mDecodePlayer = new DecodePlayer();
    this.mDecodePlayer.setRepeat(false);
    if (paramBoolean)
    {
      this.mDecodePlayer.setNOSleep(true);
      this.mDecodePlayer.setSyncDecode(true);
    }
    this.mDecodePlayer.setFilePath(this.mVideoPath, null);
    this.mDecodePlayer.setDecodeListener(this.mPKDecodeListener);
    this.mDecodePlayer.setSpeedType(0);
  }
  
  public void enableDebug(boolean paramBoolean)
  {
    this.isDebug = paramBoolean;
  }
  
  public String getPKCoverPath()
  {
    return this.mPKCoverPath;
  }
  
  public HWVideoDecoder getPKDecoder()
  {
    if (this.mDecodePlayer == null) {
      return null;
    }
    return this.mDecodePlayer.getDecoder();
  }
  
  public String getPKTitleBmgPath()
  {
    return this.mPKTitleBmgPath;
  }
  
  public String getPKVideoPath()
  {
    return this.mVideoPath;
  }
  
  public long getPkVideoDurationMs()
  {
    return this.mPkVideoDurationMs;
  }
  
  public boolean isFilterWork()
  {
    return this.mIsSurfaceCreated;
  }
  
  public void onDrawFrame()
  {
    long l1 = System.currentTimeMillis();
    this.mFilterDecodeTimeStamp = getQQFilterRenderManager().getBusinessOperation().getPresentTimeStamp();
    int i = this.mPKCoverTextureID;
    if (this.mSurfaceTexture != null)
    {
      this.mSurfaceTexture.updateTexImage();
      i = this.mRivalTextureID;
    }
    for (;;)
    {
      super.onDrawFrame();
      int j = drawPKFrame(this.mInputTextureID, i, this.mPKTitleTextureID);
      i = j;
      if (j < 0)
      {
        SLog.e(TAG, "out is fushu!!!");
        i = this.mInputTextureID;
      }
      this.mLastOutputTexture = i;
      this.mOutputTextureID = i;
      long l2 = System.currentTimeMillis();
      SLog.e(TAG, "PKFilter draw frame cost=" + (l2 - l1));
      return;
      SLog.e(TAG, "mSurfaceTexture is null!!!");
    }
  }
  
  public void onFilterDecodeRepeat()
  {
    SLog.e(TAG, "filter decoder onDecodeRepeat");
    this.mFilterDecodeTimeStamp = 0L;
    if (this.mDecodePlayer != null) {
      this.mDecodePlayer.startPlay(this.mRivalTextureID, this.onFrameAvailableListener);
    }
  }
  
  public void onFilterPlayStart() {}
  
  public void onSurfaceCreate()
  {
    super.onSurfaceCreate();
    SLog.d(TAG, "init");
    if (!this.havePrepared) {
      prepare();
    }
    if (this.mTextureRender == null) {
      this.mTextureRender = new TextureRender();
    }
    this.mWidth = getQQFilterRenderManager().getFilterWidth();
    this.mHeight = getQQFilterRenderManager().getFilterHeight();
    if (this.mWidth > 720)
    {
      this.mHeight = (this.mHeight * 720 / this.mWidth);
      this.mWidth = 720;
    }
    if ((this.mWidth == 0) || (this.mHeight == 0))
    {
      assertFailed("error:: get filter width=" + this.mWidth + " and mHeight=" + this.mHeight);
      this.mWidth = 720;
      this.mHeight = 1280;
    }
    if (this.mRenderFBO == null) {
      this.mRenderFBO = new RenderBuffer(this.mWidth, this.mHeight, 33984);
    }
    if ((this.mPKCoverTextureID < 0) && (FileUtil.fileExistsAndNotEmpty(this.mPKCoverPath))) {}
    try
    {
      localBitmap = BitmapFactory.decodeFile(this.mPKCoverPath);
      this.mPKCoverTextureID = GlUtil.createTexture(3553, localBitmap);
      localBitmap.recycle();
      if (this.mPKCoverTextureID < 0) {
        SLog.e(TAG, "create the pk cover texture failed");
      }
      if ((this.mPKTitleTextureID >= 0) || (!FileUtil.fileExistsAndNotEmpty(this.mPKTitleBmgPath))) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(this.mPKTitleBmgPath);
        this.mPKTitleTextureID = GlUtil.createTexture(3553, localBitmap);
        localBitmap.recycle();
        if (this.mPKTitleTextureID < 0) {
          SLog.e(TAG, "create the pk title texture failed");
        }
        this.mIsSurfaceCreated = true;
        return;
        localOutOfMemoryError1 = localOutOfMemoryError1;
        SLog.e(TAG, "create the pk cover texture out of memory:" + localOutOfMemoryError1);
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        for (;;)
        {
          SLog.e(TAG, "create the pk title texture out of memory:" + localOutOfMemoryError2);
        }
      }
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    SLog.d(TAG, "onSurfaceDestroy");
    this.isPKdecoderNeedWaitStart = false;
    if (this.mDecodePlayer != null) {
      this.mDecodePlayer.stopPlay();
    }
    this.havePrepared = false;
    if (this.mRenderFBO != null) {
      this.mRenderFBO.destroy();
    }
    this.mRenderFBO = null;
    if (this.mTextureRender != null) {
      this.mTextureRender.release();
    }
    this.mTextureRender = null;
    this.mSurfaceTexture = null;
    this.mIsSurfaceCreated = false;
    this.mPKCoverTextureID = -1;
    this.mPKTitleTextureID = -1;
  }
  
  public void prepare()
  {
    if (this.onFrameAvailableListener != null) {
      this.onFrameAvailableListener.disable();
    }
    this.onFrameAvailableListener = new PKFilter.OnFrameAvailableListener(this);
    this.mSurfaceTexture = null;
    if (this.mRivalTextureID > 0) {
      GLES20.glDeleteTextures(1, new int[] { this.mRivalTextureID }, 0);
    }
    if (!FileUtil.fileExistsAndNotEmpty(this.mVideoPath))
    {
      if (!FileUtil.fileExistsAndNotEmpty(this.mPKCoverPath))
      {
        assertFailed("failed to prepare the filter when video path and cover is both no exists!");
        return;
      }
      SLog.e(TAG, "prepare pk video file is not ready , cover= " + this.mPKCoverPath);
      this.mRivalTextureID = GlUtil.createTexture(3553, BitmapFactory.decodeFile(this.mPKCoverPath));
      this.havePrepared = true;
      return;
    }
    this.mRivalTextureID = GlUtil.createTexture(36197);
    this.isPKdecoderNeedWaitStart = true;
    this.mDecodePlayer.startPlay(this.mRivalTextureID, this.onFrameAvailableListener);
    this.havePrepared = true;
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.pkvideo.PKFilter
 * JD-Core Version:    0.7.0.1
 */