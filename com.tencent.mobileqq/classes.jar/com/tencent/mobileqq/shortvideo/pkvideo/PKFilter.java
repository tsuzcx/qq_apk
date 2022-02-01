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
  public static final String TAG_ENCODE;
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
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append("_encode");
    TAG_ENCODE = localStringBuilder.toString();
  }
  
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fbo is not ready plz fix it error:");
      localStringBuilder.append(i);
      assertFailed(localStringBuilder.toString());
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
      if (this.mSurfaceTexture == null) {
        this.mTextureRender.drawTexture(3553, paramInt2, null, this.mMvpMatrix);
      } else {
        this.mTextureRender.drawTexture(36197, paramInt2, null, this.mMvpMatrix);
      }
    }
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
  }
  
  private void syncDecoderStartTime(long paramLong) {}
  
  public void config(String paramString1, String paramString2, String paramString3, long paramLong, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      assertFailed("config the pk video file path and cover both null!!");
      return;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config pk video path = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", cover= ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",mOrigVideoDurationMS = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",isEncode=");
    localStringBuilder.append(paramBoolean);
    SLog.e(str, localStringBuilder.toString());
    this.mIsEncode = paramBoolean;
    this.mVideoPath = paramString1;
    this.mPKCoverPath = paramString2;
    this.mPKTitleBmgPath = paramString3;
    this.mOrigVideoDurationMS = paramLong;
    this.mPKDecodeListener = new PKFilter.PKDecodeListener(this, null);
    paramString2 = this.mDecodePlayer;
    if (paramString2 != null) {
      paramString2.stopPlay();
    }
    if (FileUtil.fileExistsAndNotEmpty(paramString1))
    {
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
    DecodePlayer localDecodePlayer = this.mDecodePlayer;
    if (localDecodePlayer == null) {
      return null;
    }
    return localDecodePlayer.getDecoder();
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
    Object localObject = this.mSurfaceTexture;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).updateTexImage();
      i = this.mRivalTextureID;
    }
    else
    {
      SLog.e(TAG, "mSurfaceTexture is null!!!");
    }
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
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PKFilter draw frame cost=");
    localStringBuilder.append(l2 - l1);
    SLog.e((String)localObject, localStringBuilder.toString());
  }
  
  public void onFilterDecodeRepeat()
  {
    SLog.e(TAG, "filter decoder onDecodeRepeat");
    this.mFilterDecodeTimeStamp = 0L;
    DecodePlayer localDecodePlayer = this.mDecodePlayer;
    if (localDecodePlayer != null) {
      localDecodePlayer.startPlay(this.mRivalTextureID, this.onFrameAvailableListener);
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
    int i = this.mWidth;
    if (i > 720)
    {
      this.mHeight = (this.mHeight * 720 / i);
      this.mWidth = 720;
    }
    Object localObject;
    if ((this.mWidth == 0) || (this.mHeight == 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error:: get filter width=");
      ((StringBuilder)localObject).append(this.mWidth);
      ((StringBuilder)localObject).append(" and mHeight=");
      ((StringBuilder)localObject).append(this.mHeight);
      assertFailed(((StringBuilder)localObject).toString());
      this.mWidth = 720;
      this.mHeight = 1280;
    }
    if (this.mRenderFBO == null) {
      this.mRenderFBO = new RenderBuffer(this.mWidth, this.mHeight, 33984);
    }
    String str;
    StringBuilder localStringBuilder;
    if ((this.mPKCoverTextureID < 0) && (FileUtil.fileExistsAndNotEmpty(this.mPKCoverPath)))
    {
      try
      {
        localObject = BitmapFactory.decodeFile(this.mPKCoverPath);
        this.mPKCoverTextureID = GlUtil.createTexture(3553, (Bitmap)localObject);
        ((Bitmap)localObject).recycle();
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("create the pk cover texture out of memory:");
        localStringBuilder.append(localOutOfMemoryError1);
        SLog.e(str, localStringBuilder.toString());
      }
      if (this.mPKCoverTextureID < 0) {
        SLog.e(TAG, "create the pk cover texture failed");
      }
    }
    if ((this.mPKTitleTextureID < 0) && (FileUtil.fileExistsAndNotEmpty(this.mPKTitleBmgPath)))
    {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(this.mPKTitleBmgPath);
        this.mPKTitleTextureID = GlUtil.createTexture(3553, localBitmap);
        localBitmap.recycle();
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("create the pk title texture out of memory:");
        localStringBuilder.append(localOutOfMemoryError2);
        SLog.e(str, localStringBuilder.toString());
      }
      if (this.mPKTitleTextureID < 0) {
        SLog.e(TAG, "create the pk title texture failed");
      }
    }
    this.mIsSurfaceCreated = true;
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    SLog.d(TAG, "onSurfaceDestroy");
    this.isPKdecoderNeedWaitStart = false;
    Object localObject = this.mDecodePlayer;
    if (localObject != null) {
      ((DecodePlayer)localObject).stopPlay();
    }
    this.havePrepared = false;
    localObject = this.mRenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    this.mRenderFBO = null;
    localObject = this.mTextureRender;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
    this.mTextureRender = null;
    this.mSurfaceTexture = null;
    this.mIsSurfaceCreated = false;
    this.mPKCoverTextureID = -1;
    this.mPKTitleTextureID = -1;
  }
  
  public void prepare()
  {
    Object localObject = this.onFrameAvailableListener;
    if (localObject != null) {
      ((PKFilter.OnFrameAvailableListener)localObject).disable();
    }
    this.onFrameAvailableListener = new PKFilter.OnFrameAvailableListener(this);
    this.mSurfaceTexture = null;
    int i = this.mRivalTextureID;
    if (i > 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
    }
    if (!FileUtil.fileExistsAndNotEmpty(this.mVideoPath))
    {
      if (!FileUtil.fileExistsAndNotEmpty(this.mPKCoverPath))
      {
        assertFailed("failed to prepare the filter when video path and cover is both no exists!");
        return;
      }
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepare pk video file is not ready , cover= ");
      localStringBuilder.append(this.mPKCoverPath);
      SLog.e((String)localObject, localStringBuilder.toString());
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