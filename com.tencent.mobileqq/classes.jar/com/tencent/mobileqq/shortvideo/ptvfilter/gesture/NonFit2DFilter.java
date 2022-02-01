package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.io.File;
import java.util.List;

public class NonFit2DFilter
  extends VideoFilterBase
{
  private static final String TAG = "NonFit2DFilter";
  private int ItemLength = 0;
  PointF anchor = new PointF();
  private int currentIndex = 0;
  private double distanceX = 0.0D;
  private double distanceY = 0.0D;
  protected long frameStartTime;
  volatile boolean hasCleared = false;
  private boolean initialized = false;
  private StickerItem item;
  private int lastDecodeImageIndex = -1;
  private int lastImageIndex = -1;
  private long lastMills = 0L;
  private boolean mAlwayslastFrame = false;
  private int mItemCount = 0;
  private boolean mNeedSetPosition = false;
  private PlayerUtil.Player mPlayer;
  float mScaleFactor = 0.5F;
  PointF mShowPosition = new PointF();
  protected UniformParam.TextureBitmapParam mTextureParam;
  protected String materialId;
  protected StickerItem nonFitItems;
  protected int playCount = 0;
  private int realHeight;
  private int realWidth;
  public long startTime;
  private int[] tex = new int[1];
  
  public NonFit2DFilter(StickerItem paramStickerItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
    if (paramStickerItem == null) {
      throw new IllegalArgumentException("items length error!");
    }
    this.nonFitItems = paramStickerItem;
    this.ItemLength = 1;
    this.dataPath = paramString;
    this.materialId = VideoMaterialUtil.getMaterialId(paramString);
    this.mNeedSetPosition = true;
    this.nonFitItems.playCount = 1;
    setCurrentItem(paramStickerItem, 0);
    this.realWidth = paramStickerItem.width;
    this.realHeight = paramStickerItem.height;
    filterLog("dataPath:" + paramString + ", materialId:" + this.materialId + ", ItemLength:" + this.ItemLength);
    initParams();
    if (paramStickerItem.anchorPoint != null) {
      this.anchor = new PointF(paramStickerItem.anchorPoint[0], paramStickerItem.anchorPoint[1]);
    }
  }
  
  public static void filterLog(String paramString)
  {
    if (SLog.isEnable()) {
      SLog.i("NonFit2DFilter", paramString);
    }
  }
  
  private int getCount(long paramLong)
  {
    int j;
    if (this.nonFitItems.playCount == 0)
    {
      i = 1;
      j = (int)((paramLong - this.frameStartTime) / Math.max(this.item.frameDuration, 1.0D));
      if (j >= this.item.frames * (this.playCount + 1)) {
        this.playCount += 1;
      }
      j %= Math.max(this.item.frames, 1);
      if (i != 0) {
        break label160;
      }
      if ((!this.mAlwayslastFrame) && (j >= this.mItemCount)) {
        break label154;
      }
    }
    label154:
    for (int i = this.item.frames - 1;; i = j)
    {
      this.mItemCount = i;
      j = i;
      if (i >= this.item.frames - 1)
      {
        j = this.item.frames - 1;
        this.mAlwayslastFrame = true;
      }
      return j;
      i = 0;
      break;
    }
    label160:
    return j;
  }
  
  private static float getDist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
  }
  
  private int getNextFrame(int paramInt)
  {
    boolean bool2 = true;
    Object localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if ((localObject == null) || (!BitmapUtils.isLegal((Bitmap)localObject)))
    {
      localObject = FileUtils.genSeperateFileDir(this.dataPath) + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (BitmapUtils.isLegal((Bitmap)localObject))
      {
        GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
        if (paramInt != 0) {
          ((Bitmap)localObject).recycle();
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("getNextFrame load cache:");
        if (paramInt == 0) {}
        for (;;)
        {
          filterLog(bool2 + ", updateTexture:" + bool1 + ",bitmap content:" + BitmapUtils.isLegal((Bitmap)localObject));
          return this.tex[0];
          bool2 = false;
        }
      }
    }
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static DisplayMetrics getScreenWH(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics();
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private void updateTextureParam(long paramLong)
  {
    int i = getCount(paramLong);
    if (i == this.lastImageIndex)
    {
      filterLog("updateTextureParam return!");
      return;
    }
    filterLog("updateTextureParam" + i);
    addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(i), 33986));
    this.lastImageIndex = i;
  }
  
  public void ApplyGLSLFilter()
  {
    filterLog("TimGestureLog: ApplyGLSLFilter Create Shader");
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
  }
  
  public PointF ScreenPonitToGLPoint(float paramFloat1, float paramFloat2)
  {
    PointF localPointF = new PointF();
    DisplayMetrics localDisplayMetrics = getScreenWH(SdkContext.getInstance().getApplication());
    float f1 = this.width / localDisplayMetrics.widthPixels;
    float f2 = this.height / localDisplayMetrics.heightPixels;
    localPointF.x = (f1 * paramFloat1);
    localPointF.y = (f2 * paramFloat2);
    return localPointF;
  }
  
  public void adjustPosition()
  {
    if (this.width / this.height >= 0.75D) {}
    for (double d1 = this.width / 720.0D;; d1 = this.height / 960.0D)
    {
      this.mScaleFactor = (this.item.scaleFactor / 960.0F);
      if (this.mScaleFactor == 0.0F) {
        this.mScaleFactor = 1.0F;
      }
      this.mScaleFactor *= 1.2F;
      float f1 = this.mShowPosition.x - (float)(this.anchor.x * d1 * this.mScaleFactor);
      float f2 = this.mShowPosition.y - (float)(this.anchor.y * d1 * this.mScaleFactor);
      float f3 = (float)(f1 + this.item.width * d1 * this.mScaleFactor);
      double d2 = f2;
      float f4 = (float)(d1 * this.item.height * this.mScaleFactor + d2);
      float f5 = f1 / this.width;
      f5 = f4 / this.height;
      f5 = f3 / this.width;
      f5 = f2 / this.height;
      setPositions(AlgoUtils.calPositions(f1, f4, f3, f2, this.width, this.height));
      return;
    }
  }
  
  public void adjustPosition(double paramDouble1, double paramDouble2)
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2)) {
      setPositions(GlUtil.EMPTY_POSITIONS);
    }
    for (;;)
    {
      return;
      int j;
      int i;
      if (this.width / this.height >= 0.75D)
      {
        paramDouble1 = this.width / 720.0D;
        j = (int)(this.width / 0.75D);
        int k = (int)(j * this.item.position[1]);
        i = (int)(this.width * this.item.position[0]);
        j = k - (j - this.height) / 2;
        setPositions(AlgoUtils.calPositions(i, (float)(j + this.item.height * paramDouble1), (float)(i + this.item.width * paramDouble1), j, this.width, this.height));
        this.anchor.x = ((float)(i + this.item.width * paramDouble1 / 2.0D));
      }
      for (this.anchor.y = ((float)(j + this.item.height * paramDouble1 / 2.0D)); SLog.isEnable(); this.anchor.y = ((float)(i + this.item.height * paramDouble1 / 2.0D)))
      {
        SLog.d("GestureTestUse", "should nerver run this clause");
        return;
        paramDouble1 = this.height / 960.0D;
        j = (int)(this.height * 0.75D);
        i = (int)(this.height * this.item.position[1]);
        j = (int)(j * this.item.position[0]) - (j - this.width) / 2;
        setPositions(AlgoUtils.calPositions(j, (float)(i + this.item.height * paramDouble1), (float)(j + this.item.width * paramDouble1), i, this.width, this.height));
        this.anchor.x = ((float)(j + this.item.width * paramDouble1 / 2.0D));
      }
    }
  }
  
  public boolean canUseBlendMode()
  {
    return true;
  }
  
  public void clearGLSLSelf()
  {
    this.hasCleared = true;
    filterLog("clearGLSLSelf!");
    filterLog("TimGestureLog: clearGLSLSelf Clear Shader");
    clearTextureParam();
    destroyAudio();
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
  }
  
  public void clearTextureParam()
  {
    if (this.mTextureParam != null)
    {
      this.mTextureParam.clear();
      this.mTextureParam = null;
    }
    setPositions(GlUtil.EMPTY_POSITIONS);
    this.initialized = false;
    this.lastImageIndex = -1;
    this.lastDecodeImageIndex = -1;
    this.playCount = 0;
    filterLog("clearTextureParam!");
  }
  
  public void destroyAudio()
  {
    filterLog("destroyAudio!");
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("texNeedTransform", -1));
    addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.Float2fParam("displacement", 0.0F, 0.0F));
    addParam(new UniformParam.IntParam("displacementEnableLut", 0));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("texScale", 1.0F));
    addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("alpha", 1.0F));
    addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public void initPositionAdjusted()
  {
    initScale();
    if (!this.mNeedSetPosition)
    {
      adjustPosition(this.distanceX, this.distanceY);
      return;
    }
    adjustPosition();
  }
  
  void initScale()
  {
    if (this.mNeedSetPosition) {
      return;
    }
    this.distanceX = this.item.position[0];
    this.distanceY = this.item.position[1];
  }
  
  public boolean isAnimationPlay(long paramLong)
  {
    if (this.frameStartTime == 0L) {}
    while (paramLong - this.frameStartTime <= this.item.frames * this.item.frameDuration) {
      return true;
    }
    return false;
  }
  
  public boolean isHasCleared()
  {
    return this.hasCleared;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void resetAnimationEndStatus()
  {
    setCurrentItem(this.nonFitItems, 0);
    this.frameStartTime = 0L;
    this.initialized = false;
  }
  
  public void setCurrentItem(StickerItem paramStickerItem, int paramInt)
  {
    this.item = paramStickerItem;
    this.currentIndex = paramInt;
    this.lastImageIndex = -1;
    this.lastDecodeImageIndex = -1;
    this.playCount = 0;
    this.mItemCount = 0;
    this.mAlwayslastFrame = false;
    this.initialized = false;
    destroyAudio();
    VideoMemoryManager.getInstance().reset(paramStickerItem.id);
    filterLog("currentItem id:" + this.item.id);
  }
  
  protected void updateActionTriggered(long paramLong)
  {
    boolean bool = true;
    if (this.item != null)
    {
      if (this.initialized) {
        break label212;
      }
      this.initialized = true;
      this.frameStartTime = paramLong;
    }
    for (;;)
    {
      String str;
      if ((!TextUtils.isEmpty(this.dataPath)) && (!TextUtils.isEmpty(this.item.id)) && (!TextUtils.isEmpty(this.item.audio))) {
        if ((this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute()))
        {
          str = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
          if (!str.startsWith("assets://")) {
            break label179;
          }
        }
      }
      label179:
      for (this.mPlayer = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), str.replace("assets://", ""), false);; this.mPlayer = PlayerUtil.createPlayerFromUri(AEModule.getContext(), str, false))
      {
        filterLog("mPlayer init!");
        if (!VideoPrefsUtil.getMaterialMute()) {
          break;
        }
        PlayerUtil.stopPlayer(this.mPlayer);
        return;
      }
      PlayerUtil.startPlayer(this.mPlayer, bool);
      return;
      PlayerUtil.stopPlayer(this.mPlayer);
      return;
      label212:
      bool = false;
    }
  }
  
  public void updateFilterPosition(PointF paramPointF)
  {
    this.mShowPosition = paramPointF;
  }
  
  public void updateFilterWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.realWidth = paramInt1;
    this.realHeight = paramInt2;
  }
  
  public void updatePointAndScale(PointF paramPointF, float paramFloat)
  {
    this.anchor.x = paramPointF.x;
    this.anchor.y = paramPointF.y;
    this.mScaleFactor = paramFloat;
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    initPositionAdjusted();
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo)) {}
    for (paramObject = (PTDetectInfo)paramObject; paramObject == null; paramObject = null) {
      return;
    }
    filterLog("initialized:" + this.initialized + ", frameStartTime:" + this.frameStartTime + ", needChange:");
    updateActionTriggered(paramObject.timestamp);
    updatePositions(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle);
    updateTextureParam(paramObject.timestamp);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.NonFit2DFilter
 * JD-Core Version:    0.7.0.1
 */