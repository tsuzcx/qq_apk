package com.tencent.ttpic;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.algo.PtuFilterFactory;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.filter.VideoFlipFilter;
import com.tencent.ttpic.model.CameraFilterParamSDK;
import com.tencent.ttpic.recorder.RetrieveDataListener;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.VideoDeviceInstance;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.ApiHelper;
import com.tencent.util.PhoneProperty;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class FilterProcessBaseNew
{
  private static final String TAG = FilterProcessBaseNew.class.getSimpleName();
  protected final boolean cannotReuseFrameBuffer = PhoneProperty.instance().isCannotReuseFrameBuffer();
  private int effectIndex = 0;
  private int filterId = 0;
  protected int flipX = 0;
  protected int flipY = 0;
  protected int height;
  protected double mAspectRatio = 0.75D;
  BaseFilter mBeautyFilter = PtuFilterFactory.createFilter(224);
  BaseFilter mBeautyLastFilter = null;
  BaseFilter mBeautyZeroFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  BaseFilter mBlendFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame mBlendFrame = new Frame();
  private int mFaceDetectCount;
  BaseFilter mFilter = PtuFilterFactory.createFilter(0);
  VideoFlipFilter mFlipFilter = VideoFlipFilter.createVideoFlipFilter();
  Frame mFlipFrame = new Frame();
  private int mFrameCount;
  int[] mFrameForOutput = new int[1];
  private SurfaceTexture mInputSurfaceTexture;
  private CameraFilterParamSDK mParam = new CameraFilterParamSDK();
  BaseFilter mPreviewFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame mPreviewFrame = new Frame();
  protected int[] mPreviewTextureId = new int[2];
  protected final SparseArray<Set<RetrieveDataListener>> mRetrieveDataListener = new SparseArray();
  private int mSrcIndex = -1;
  Frame mTempFrame = new Frame();
  protected int[] mTempTextureId = new int[3];
  protected final float[] mTransformMatrix = new float[16];
  VideoFilterList mVideoFilters;
  BaseFilter mViewFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame mViewFrame = new Frame();
  protected int onceTex;
  protected int rotation = 0;
  private float scaleFact = 1.0F;
  protected int showOnceTexCount;
  protected int videoHeight;
  protected int videoWidth;
  protected int width;
  private double windowScale = 1.0D;
  
  private void setScale(float[] paramArrayOfFloat, double paramDouble1, double paramDouble2)
  {
    paramArrayOfFloat[0] = ((float)(1.0D / paramDouble1));
    paramArrayOfFloat[5] = ((float)(1.0D / paramDouble2));
    paramArrayOfFloat[12] = ((float)(1.0D - 1.0D / paramDouble1) / 2.0F);
    paramArrayOfFloat[13] = ((float)(1.0D - 1.0D / paramDouble2) / 2.0F);
  }
  
  public void addRetrieveDatalistener(int paramInt, RetrieveDataListener paramRetrieveDataListener)
  {
    if ((!RetrieveDataManager.getInstance().isValid(paramInt)) || (paramRetrieveDataListener == null)) {
      return;
    }
    Set localSet = (Set)this.mRetrieveDataListener.get(paramInt);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.mRetrieveDataListener.put(paramInt, localObject);
    }
    ((Set)localObject).add(paramRetrieveDataListener);
  }
  
  public void beautyLowEnergy(boolean paramBoolean)
  {
    int i = this.mParam.smoothLevel;
    this.mParam.enableLowEnergy(paramBoolean);
    setupSmoothLevel(0);
    setupSmoothLevel(i);
  }
  
  public boolean changeFilter(BaseFilter paramBaseFilter)
  {
    Frame localFrame = VideoFilterUtil.getSecondLastFrame(this.mPreviewFrame);
    if (localFrame != null)
    {
      this.onceTex = localFrame.getTextureId();
      localFrame.setTextureId(0);
    }
    clearFilterChainFrames();
    if (this.mFilter != null) {
      this.mFilter.ClearGLSL();
    }
    this.mFilter = paramBaseFilter;
    this.mFilter.ApplyGLSLFilter(true, this.width, this.height);
    this.mViewFrame.clear();
    this.mBeautyLastFilter.setNextFilter(this.mFilter, null);
    return true;
  }
  
  public boolean changeFilter(String paramString, int paramInt1, int paramInt2)
  {
    Frame localFrame = VideoFilterUtil.getSecondLastFrame(this.mPreviewFrame);
    if (localFrame != null)
    {
      this.onceTex = localFrame.getTextureId();
      localFrame.setTextureId(0);
    }
    clearFilterChainFrames();
    this.mParam.flagId = paramString;
    this.mParam.filterId = paramInt1;
    this.mParam.effectIndex = paramInt2;
    createFilter(paramString, paramInt1, paramInt2);
    this.mViewFrame.clear();
    this.mBeautyLastFilter.setNextFilter(this.mFilter, null);
    return true;
  }
  
  public void changeSize(int paramInt1, int paramInt2)
  {
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    clearFilterChainFrames();
  }
  
  public void changeVideoFilter(VideoFilterList paramVideoFilterList)
  {
    Frame localFrame = VideoFilterUtil.getSecondLastFrame(this.mPreviewFrame);
    if (localFrame != null)
    {
      this.onceTex = localFrame.getTextureId();
      localFrame.setTextureId(0);
    }
    clearFilterChainFrames();
    this.mTempFrame.clear();
    this.mFlipFrame.clear();
    if ((this.mVideoFilters != null) && (this.mVideoFilters.isValid()))
    {
      this.mVideoFilters.destroy();
      this.mVideoFilters = null;
    }
    if ((paramVideoFilterList != null) && (paramVideoFilterList.isValid()))
    {
      this.mVideoFilters = paramVideoFilterList;
      this.mVideoFilters.ApplyGLSLFilter();
      this.mVideoFilters.updateVideoSize(this.width, this.height, this.windowScale);
    }
  }
  
  public void clear()
  {
    this.mPreviewFrame.clear();
    this.mViewFrame.clear();
    this.mFlipFrame.clear();
    this.mTempFrame.clear();
    this.mBlendFrame.clear();
    GLES20.glDeleteTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    GLES20.glDeleteTextures(this.mTempTextureId.length, this.mTempTextureId, 0);
    this.mPreviewFilter.ClearGLSL();
    this.mFlipFilter.ClearGLSL();
    this.mViewFilter.ClearGLSL();
    this.mBeautyFilter.ClearGLSL();
    this.mBeautyZeroFilter.ClearGLSL();
    GLES20.glDeleteFramebuffers(1, this.mFrameForOutput, 0);
    if ((this.mVideoFilters != null) && (this.mVideoFilters.isValid()))
    {
      this.mVideoFilters.destroy();
      this.mVideoFilters = null;
    }
    this.filterId = 0;
    this.effectIndex = 0;
    RetrieveDataManager.getInstance().clear();
    this.mRetrieveDataListener.clear();
  }
  
  public void clearFilterChainFrames()
  {
    this.showOnceTexCount = 0;
    this.mPreviewFrame.clear();
  }
  
  public void clearSurfaceTexture()
  {
    if ((ApiHelper.HAS_RELEASE_SURFACE_TEXTURE) && (this.mInputSurfaceTexture != null))
    {
      this.mInputSurfaceTexture.release();
      this.mInputSurfaceTexture = null;
    }
  }
  
  public void clearVideoFilterResource()
  {
    if ((this.mVideoFilters != null) && (this.mVideoFilters.isValid())) {
      this.mVideoFilters.destroyAudio();
    }
    VideoPreviewFaceOutlineDetector.getInstance().destroy();
  }
  
  public void createFilter(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mFilter != null) {
      this.mFilter.ClearGLSL();
    }
    this.filterId = paramInt1;
    this.effectIndex = paramInt2;
    this.mFilter = PtuFilterFactory.createFilter(this.filterId);
    this.mFilter.needFlipBlend = true;
    this.mFilter.setSrcFilterIndex(this.mSrcIndex);
    this.mFilter.setEffectIndex(paramInt2);
    this.mFilter.ApplyGLSLFilter(true, this.width, this.height);
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public SurfaceTexture getInputSurfaceTexture()
  {
    return this.mInputSurfaceTexture;
  }
  
  protected int getSecondLastTextureId(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (paramFrame == null) {
      return 0;
    }
    while ((localFrame.nextFrame != null) && (localFrame.nextFrame.nextFrame != null) && (localFrame.nextFrame.nextFrame.getTextureId() != 0)) {
      localFrame = localFrame.nextFrame;
    }
    return localFrame.getTextureId();
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  protected abstract void initPreviewFilter();
  
  public void initial()
  {
    clear();
    initPreviewFilter();
    GLES20.glGenTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    GLES20.glGenTextures(this.mTempTextureId.length, this.mTempTextureId, 0);
    this.mInputSurfaceTexture = new SurfaceTexture(this.mPreviewTextureId[0]);
    this.mPreviewFilter.ApplyGLSLFilter(true, this.width, this.height);
    this.mFlipFilter.ApplyGLSLFilter();
    this.mViewFilter.ApplyGLSLFilter();
    this.mBeautyFilter.ApplyGLSLFilter(true, this.width, this.height);
    this.mBeautyLastFilter = this.mBeautyFilter.getLastFilter();
    this.mParam.smoothLevel = 1;
    Map localMap = this.mParam.getSmoothMap();
    this.mBeautyFilter.setParameterDic(localMap);
    localMap.clear();
    this.mPreviewFilter.setNextFilter(this.mBeautyFilter, null);
    this.mBeautyZeroFilter.ApplyGLSLFilter();
    this.mFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    this.mFilter.ApplyGLSLFilter(true, this.width, this.height);
    this.mBeautyLastFilter.setNextFilter(this.mFilter, null);
    this.mBlendFilter.ApplyGLSLFilter();
    GLES20.glGenFramebuffers(1, this.mFrameForOutput, 0);
    this.mFaceDetectCount = 1;
  }
  
  public void initialWithSize(int paramInt1, int paramInt2)
  {
    changeSize(paramInt1, paramInt2);
    initial();
  }
  
  protected boolean needFaceDetect()
  {
    boolean bool = false;
    this.mFrameCount += 1;
    if (this.mFrameCount >= this.mFaceDetectCount)
    {
      this.mFrameCount = 0;
      bool = true;
    }
    return bool;
  }
  
  public void openShareBuffer(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.tencent.view.FilterDefault.currentShareIndex = 0;
      return;
    }
    com.tencent.view.FilterDefault.currentShareIndex = -1;
  }
  
  public void releaseSurfaceTexture()
  {
    if (this.mInputSurfaceTexture != null) {
      this.mInputSurfaceTexture.release();
    }
  }
  
  public void removeRetrieveDatalistener(RetrieveDataListener paramRetrieveDataListener)
  {
    if (paramRetrieveDataListener == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mRetrieveDataListener.size())
      {
        ((Set)this.mRetrieveDataListener.valueAt(i)).remove(paramRetrieveDataListener);
        i += 1;
      }
    }
  }
  
  public void setAspectRatio(double paramDouble)
  {
    this.mAspectRatio = paramDouble;
  }
  
  public void setFaceDetectRate(int paramInt)
  {
    this.mFaceDetectCount = Math.max(1, paramInt);
  }
  
  public void setRotationAndFlip(int paramInt1, int paramInt2, int paramInt3)
  {
    this.rotation = paramInt1;
    this.flipX = paramInt2;
    this.flipY = paramInt3;
  }
  
  public void setupSmoothLevel(int paramInt)
  {
    if (this.mParam.smoothLevel == paramInt) {
      return;
    }
    if (paramInt == 0)
    {
      this.mBeautyLastFilter.setNextFilter(null, null);
      this.mPreviewFilter.setNextFilter(this.mBeautyZeroFilter, null);
      this.mBeautyLastFilter = this.mBeautyZeroFilter;
      this.mBeautyLastFilter.setNextFilter(this.mFilter, null);
    }
    for (;;)
    {
      this.mParam.smoothLevel = paramInt;
      Map localMap = this.mParam.getSmoothMap();
      this.mBeautyFilter.setParameterDic(localMap);
      localMap.clear();
      clearFilterChainFrames();
      return;
      if ((paramInt > 0) && (this.mParam.smoothLevel == 0))
      {
        this.mBeautyLastFilter.setNextFilter(null, null);
        this.mPreviewFilter.setNextFilter(this.mBeautyFilter, null);
        this.mBeautyLastFilter = this.mBeautyFilter.getLastFilter();
        this.mBeautyLastFilter.setNextFilter(this.mFilter, null);
      }
    }
  }
  
  public abstract void showPreview(int paramInt1, int paramInt2);
  
  public byte[] showPreviewAndReturnRGBA(int paramInt1, int paramInt2)
  {
    showPreview(paramInt1, paramInt2);
    return RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, this.mBlendFrame.getLastRenderTextureId(), this.videoWidth, this.videoHeight);
  }
  
  public void update()
  {
    try
    {
      if (this.mInputSurfaceTexture != null)
      {
        this.mInputSurfaceTexture.updateTexImage();
        this.mInputSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void updatePreviewRotationAndFlip(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 180;
    int i;
    if (paramBoolean1)
    {
      i = 180;
      if (!paramBoolean2) {
        break label34;
      }
    }
    for (;;)
    {
      setRotationAndFlip(paramInt, i, j);
      return;
      i = 0;
      break;
      label34:
      j = 0;
    }
  }
  
  public void updatePreviewRotationAndFlip(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = VideoDeviceInstance.getInstance().getDeviceTypeName();
      if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase("MOTOROLA_Nexus_6")))
      {
        setRotationAndFlip(270, 180, 180);
        return;
      }
      setRotationAndFlip(270, 0, 0);
      return;
    }
    setRotationAndFlip(90, 0, 180);
  }
  
  public void updatePreviewSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    float f = Math.min(720.0F / Math.min(paramInt1, paramInt2), 1.0F);
    this.width = ((int)(this.width * f));
    this.height = ((int)(this.height * f));
    if (VideoFilterUtil.isValid(this.mVideoFilters)) {
      this.mVideoFilters.updateVideoSize(this.width, this.height, this.windowScale);
    }
    clearFilterChainFrames();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.FilterProcessBaseNew
 * JD-Core Version:    0.7.0.1
 */