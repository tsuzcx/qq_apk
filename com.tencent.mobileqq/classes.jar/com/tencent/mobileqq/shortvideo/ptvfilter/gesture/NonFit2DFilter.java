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
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
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
    if (paramStickerItem != null)
    {
      this.nonFitItems = paramStickerItem;
      this.ItemLength = 1;
      this.dataPath = paramString;
      this.materialId = VideoMaterial.getMaterialId(paramString);
      this.mNeedSetPosition = true;
      this.nonFitItems.playCount = 1;
      setCurrentItem(paramStickerItem, 0);
      this.realWidth = paramStickerItem.width;
      this.realHeight = paramStickerItem.height;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dataPath:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", materialId:");
      localStringBuilder.append(this.materialId);
      localStringBuilder.append(", ItemLength:");
      localStringBuilder.append(this.ItemLength);
      filterLog(localStringBuilder.toString());
      initParams();
      if (paramStickerItem.anchorPoint != null) {
        this.anchor = new PointF(paramStickerItem.anchorPoint[0], paramStickerItem.anchorPoint[1]);
      }
      return;
    }
    throw new IllegalArgumentException("items length error!");
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
    if (this.nonFitItems.playCount == 0) {
      j = 1;
    } else {
      j = 0;
    }
    double d1 = paramLong - this.frameStartTime;
    double d2 = Math.max(this.item.frameDuration, 1.0D);
    Double.isNaN(d1);
    int i = (int)(d1 / d2);
    int k = this.item.frames;
    int m = this.playCount;
    if (i >= k * (m + 1)) {
      this.playCount = (m + 1);
    }
    k = i % Math.max(this.item.frames, 1);
    i = k;
    if (j == 0)
    {
      if (!this.mAlwayslastFrame)
      {
        j = k;
        if (k >= this.mItemCount) {}
      }
      else
      {
        j = this.item.frames - 1;
      }
      this.mItemCount = j;
      i = j;
      if (j >= this.item.frames - 1)
      {
        i = this.item.frames - 1;
        this.mAlwayslastFrame = true;
      }
    }
    return i;
  }
  
  private static float getDist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private int getNextFrame(int paramInt)
  {
    Object localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if ((localObject != null) && (BitmapUtils.isLegal((Bitmap)localObject)))
    {
      paramInt = 0;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileUtils.genSeperateFileDir(this.dataPath));
      ((StringBuilder)localObject).append(this.item.subFolder);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.item.id);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      paramInt = 1;
    }
    boolean bool;
    if (BitmapUtils.isLegal((Bitmap)localObject))
    {
      GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
      if (paramInt != 0) {
        ((Bitmap)localObject).recycle();
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getNextFrame load cache:");
    localStringBuilder.append(paramInt ^ 0x1);
    localStringBuilder.append(", updateTexture:");
    localStringBuilder.append(bool);
    localStringBuilder.append(",bitmap content:");
    localStringBuilder.append(BitmapUtils.isLegal((Bitmap)localObject));
    filterLog(localStringBuilder.toString());
    return this.tex[0];
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateTextureParam");
    localStringBuilder.append(i);
    filterLog(localStringBuilder.toString());
    addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(i), 33986));
    this.lastImageIndex = i;
  }
  
  public void ApplyGLSLFilter()
  {
    filterLog("TimGestureLog: ApplyGLSLFilter Create Shader");
    super.ApplyGLSLFilter();
    int[] arrayOfInt = this.tex;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public PointF ScreenPonitToGLPoint(float paramFloat1, float paramFloat2)
  {
    PointF localPointF = new PointF();
    DisplayMetrics localDisplayMetrics = getScreenWH(SdkContext.getInstance().getApplication());
    float f1 = this.width / localDisplayMetrics.widthPixels;
    float f2 = this.height / localDisplayMetrics.heightPixels;
    localPointF.x = (paramFloat1 * f1);
    localPointF.y = (paramFloat2 * f2);
    return localPointF;
  }
  
  public void adjustPosition()
  {
    double d1 = this.width;
    double d2 = this.height;
    Double.isNaN(d1);
    Double.isNaN(d2);
    if (d1 / d2 >= 0.75D)
    {
      d1 = this.width;
      d2 = 720.0D;
      Double.isNaN(d1);
    }
    else
    {
      d1 = this.height;
      d2 = 960.0D;
      Double.isNaN(d1);
    }
    d1 /= d2;
    this.mScaleFactor = (this.item.scaleFactor / 960.0F);
    if (this.mScaleFactor == 0.0F) {
      this.mScaleFactor = 1.0F;
    }
    this.mScaleFactor *= 1.2F;
    float f1 = this.mShowPosition.x;
    d2 = this.anchor.x;
    Double.isNaN(d2);
    double d3 = this.mScaleFactor;
    Double.isNaN(d3);
    f1 -= (float)(d2 * d1 * d3);
    float f2 = this.mShowPosition.y;
    d2 = this.anchor.y;
    Double.isNaN(d2);
    d3 = this.mScaleFactor;
    Double.isNaN(d3);
    f2 -= (float)(d2 * d1 * d3);
    d2 = f1;
    d3 = this.item.width;
    Double.isNaN(d3);
    double d4 = this.mScaleFactor;
    Double.isNaN(d4);
    Double.isNaN(d2);
    float f3 = (float)(d2 + d3 * d1 * d4);
    d2 = f2;
    d3 = this.item.height;
    Double.isNaN(d3);
    d4 = this.mScaleFactor;
    Double.isNaN(d4);
    Double.isNaN(d2);
    float f4 = (float)(d2 + d3 * d1 * d4);
    int i = this.width;
    i = this.height;
    i = this.width;
    i = this.height;
    setPositions(AlgoUtils.calPositions(f1, f4, f3, f2, this.width, this.height));
  }
  
  public void adjustPosition(double paramDouble1, double paramDouble2)
  {
    Object localObject = this.item;
    if ((localObject != null) && (((StickerItem)localObject).position != null) && (this.item.position.length >= 2))
    {
      paramDouble1 = this.width;
      paramDouble2 = this.height;
      Double.isNaN(paramDouble1);
      Double.isNaN(paramDouble2);
      int j;
      double d1;
      int i;
      float f1;
      float f2;
      double d2;
      if (paramDouble1 / paramDouble2 >= 0.75D)
      {
        paramDouble1 = this.width;
        Double.isNaN(paramDouble1);
        paramDouble1 /= 720.0D;
        paramDouble2 = this.width;
        Double.isNaN(paramDouble2);
        j = (int)(paramDouble2 / 0.75D);
        paramDouble2 = j;
        d1 = this.item.position[1];
        Double.isNaN(paramDouble2);
        int k = (int)(paramDouble2 * d1);
        paramDouble2 = this.width;
        d1 = this.item.position[0];
        Double.isNaN(paramDouble2);
        i = (int)(paramDouble2 * d1);
        j = k - (j - this.height) / 2;
        f1 = i;
        paramDouble2 = j;
        d1 = this.item.height;
        Double.isNaN(d1);
        Double.isNaN(paramDouble2);
        f2 = (float)(d1 * paramDouble1 + paramDouble2);
        d1 = i;
        d2 = this.item.width;
        Double.isNaN(d2);
        Double.isNaN(d1);
        setPositions(AlgoUtils.calPositions(f1, f2, (float)(d2 * paramDouble1 + d1), j, this.width, this.height));
        localObject = this.anchor;
        d2 = this.item.width;
        Double.isNaN(d2);
        d2 = d2 * paramDouble1 / 2.0D;
        Double.isNaN(d1);
        ((PointF)localObject).x = ((float)(d1 + d2));
        localObject = this.anchor;
        d1 = this.item.height;
        Double.isNaN(d1);
        paramDouble1 = d1 * paramDouble1 / 2.0D;
        Double.isNaN(paramDouble2);
        ((PointF)localObject).y = ((float)(paramDouble2 + paramDouble1));
      }
      else
      {
        paramDouble1 = this.height;
        Double.isNaN(paramDouble1);
        paramDouble1 /= 960.0D;
        paramDouble2 = this.height;
        Double.isNaN(paramDouble2);
        j = (int)(paramDouble2 * 0.75D);
        paramDouble2 = this.height;
        d1 = this.item.position[1];
        Double.isNaN(paramDouble2);
        i = (int)(paramDouble2 * d1);
        paramDouble2 = j;
        d1 = this.item.position[0];
        Double.isNaN(paramDouble2);
        j = (int)(paramDouble2 * d1) - (j - this.width) / 2;
        f1 = j;
        paramDouble2 = i;
        d1 = this.item.height;
        Double.isNaN(d1);
        Double.isNaN(paramDouble2);
        f2 = (float)(d1 * paramDouble1 + paramDouble2);
        d1 = j;
        d2 = this.item.width;
        Double.isNaN(d2);
        Double.isNaN(d1);
        setPositions(AlgoUtils.calPositions(f1, f2, (float)(d2 * paramDouble1 + d1), i, this.width, this.height));
        localObject = this.anchor;
        d2 = this.item.width;
        Double.isNaN(d2);
        d2 = d2 * paramDouble1 / 2.0D;
        Double.isNaN(d1);
        ((PointF)localObject).x = ((float)(d1 + d2));
        localObject = this.anchor;
        d1 = this.item.height;
        Double.isNaN(d1);
        paramDouble1 = d1 * paramDouble1 / 2.0D;
        Double.isNaN(paramDouble2);
        ((PointF)localObject).y = ((float)(paramDouble2 + paramDouble1));
      }
      if (SLog.isEnable()) {
        SLog.d("GestureTestUse", "should nerver run this clause");
      }
      return;
    }
    setPositions(GlUtil.EMPTY_POSITIONS);
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
    int[] arrayOfInt = this.tex;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void clearTextureParam()
  {
    UniformParam.TextureBitmapParam localTextureBitmapParam = this.mTextureParam;
    if (localTextureBitmapParam != null)
    {
      localTextureBitmapParam.clear();
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
    long l = this.frameStartTime;
    if (l == 0L) {
      return true;
    }
    double d1 = paramLong - l;
    double d2 = this.item.frames;
    double d3 = this.item.frameDuration;
    Double.isNaN(d2);
    return d1 <= d2 * d3;
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
    paramStickerItem = new StringBuilder();
    paramStickerItem.append("currentItem id:");
    paramStickerItem.append(this.item.id);
    filterLog(paramStickerItem.toString());
  }
  
  protected void updateActionTriggered(long paramLong)
  {
    if (this.item != null)
    {
      boolean bool2 = this.initialized;
      boolean bool1 = true;
      if (!bool2)
      {
        this.initialized = true;
        this.frameStartTime = paramLong;
      }
      else
      {
        bool1 = false;
      }
      if ((!TextUtils.isEmpty(this.dataPath)) && (!TextUtils.isEmpty(this.item.id)) && (!TextUtils.isEmpty(this.item.audio)))
      {
        if ((this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute()))
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.dataPath);
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append(this.item.id);
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append(this.item.audio);
          localObject = ((StringBuilder)localObject).toString();
          if (((String)localObject).startsWith("assets://")) {
            this.mPlayer = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), ((String)localObject).replace("assets://", ""), false);
          } else {
            this.mPlayer = PlayerUtil.createPlayerFromUri(AEModule.getContext(), (String)localObject, false);
          }
          filterLog("mPlayer init!");
        }
        if (VideoPrefsUtil.getMaterialMute())
        {
          PlayerUtil.stopPlayer(this.mPlayer);
          return;
        }
        PlayerUtil.startPlayer(this.mPlayer, bool1);
      }
    }
    else
    {
      PlayerUtil.stopPlayer(this.mPlayer);
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
    if ((paramObject instanceof PTDetectInfo)) {
      paramObject = (PTDetectInfo)paramObject;
    } else {
      paramObject = null;
    }
    if (paramObject == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initialized:");
    localStringBuilder.append(this.initialized);
    localStringBuilder.append(", frameStartTime:");
    localStringBuilder.append(this.frameStartTime);
    localStringBuilder.append(", needChange:");
    filterLog(localStringBuilder.toString());
    updateActionTriggered(paramObject.timestamp);
    updatePositions(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle);
    updateTextureParam(paramObject.timestamp);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.NonFit2DFilter
 * JD-Core Version:    0.7.0.1
 */