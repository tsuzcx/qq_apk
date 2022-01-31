package com.tencent.mobileqq.shortvideo.ptvfilter;

import aihl;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.Param.TextureParam;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureListener;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.cache.ImageMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.AudioUtils;
import com.tencent.ttpic.util.AudioUtils.Player;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.io.File;
import java.util.List;
import java.util.Map;

public class NonFit2DFilter
  extends VideoFilterBase
{
  private double jdField_a_of_type_Double = 0.0D;
  protected int a;
  protected long a;
  PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  protected Param.TextureBitmapParam a;
  private GLGestureListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureGLGestureListener = new aihl(this);
  private AudioUtils.Player jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player;
  protected String a;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  protected NonFitItem[] a;
  private double jdField_b_of_type_Double = 0.0D;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = 0L;
  public PointF b;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private PointF jdField_c_of_type_AndroidGraphicsPointF = new PointF();
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = true;
  private int f = 0;
  
  public NonFit2DFilter(NonFitItem[] paramArrayOfNonFitItem, String paramString)
  {
    super(VideoFilterUtil.VERTEX_SHADER_COMMON, VideoFilterUtil.FRAGMENT_SHADER_COMMON, null);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_a_of_type_Boolean = false;
    if ((paramArrayOfNonFitItem == null) || (paramArrayOfNonFitItem.length == 0)) {
      throw new IllegalArgumentException("items length error!");
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem = paramArrayOfNonFitItem;
    this.jdField_e_of_type_Int = paramArrayOfNonFitItem.length;
    this.dataPath = paramString;
    this.jdField_a_of_type_JavaLangString = VideoMaterialUtil.getMaterialId(paramString);
    if ((Float.compare((float)paramArrayOfNonFitItem[0].position[0], 0.0F) == 0) && (Float.compare((float)paramArrayOfNonFitItem[0].position[1], 0.0F) == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      a(paramArrayOfNonFitItem[0], 0);
      a("dataPath:" + paramString + ", materialId:" + this.jdField_a_of_type_JavaLangString + ", ItemLength:" + this.jdField_e_of_type_Int);
      setDrawPartial(true);
      initParams();
      GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureGLGestureListener);
      return;
    }
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
  }
  
  private int a(int paramInt)
  {
    boolean bool2 = true;
    Object localObject = ImageMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if (localObject == null)
    {
      localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
      localObject = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (VideoBitmapUtil.isLegal((Bitmap)localObject))
      {
        GlUtil.loadTexture(this.jdField_a_of_type_ArrayOfInt[0], (Bitmap)localObject);
        if (paramInt != 0) {
          ((Bitmap)localObject).recycle();
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = new StringBuilder().append("getNextFrame load cache:");
        if (paramInt == 0) {}
        for (;;)
        {
          a(bool2 + ", updateTexture:" + bool1);
          return this.jdField_a_of_type_ArrayOfInt[0];
          bool2 = false;
        }
      }
    }
  }
  
  private int a(long paramLong)
  {
    int j;
    if (this.item.playCount == 0)
    {
      i = 1;
      j = (int)((paramLong - this.jdField_a_of_type_Long) / Math.max(this.item.frameDuration, 1.0D));
      if (j >= this.item.frames * (this.jdField_a_of_type_Int + 1)) {
        this.jdField_a_of_type_Int += 1;
      }
      j %= Math.max(this.item.frames, 1);
      if (i != 0) {
        break label280;
      }
      if ((!this.jdField_d_of_type_Boolean) && (j >= this.f)) {
        break label274;
      }
    }
    label274:
    for (int i = this.item.frames - 1;; i = j)
    {
      this.f = i;
      j = i;
      if (i >= this.item.frames - 1)
      {
        j = i;
        if (!this.jdField_a_of_type_Boolean)
        {
          i = this.item.frames - 1;
          this.jdField_d_of_type_Boolean = true;
          int k = this.jdField_d_of_type_Int + 1;
          NonFitItem localNonFitItem = this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem[(k % this.jdField_e_of_type_Int)];
          j = i;
          if (localNonFitItem.jdField_a_of_type_Int == 0)
          {
            j = i;
            if (k % this.jdField_e_of_type_Int != 0)
            {
              this.jdField_a_of_type_Boolean = true;
              a("set needChange, itemIndex" + k % this.jdField_e_of_type_Int + ", triggerMode:" + localNonFitItem.jdField_a_of_type_Int + ", clickMode:" + localNonFitItem.jdField_b_of_type_Int);
              j = i;
            }
          }
        }
      }
      return j;
      i = 0;
      break;
    }
    label280:
    return j;
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static DisplayMetrics a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long > 500L)
    {
      this.jdField_b_of_type_Long = l;
      if ((!this.jdField_c_of_type_Boolean) || (!a())) {
        break label86;
      }
      this.jdField_b_of_type_AndroidGraphicsPointF.x = paramFloat1;
      this.jdField_b_of_type_AndroidGraphicsPointF.y = paramFloat2;
      a("onClick init_position x:" + paramFloat1 + ", y" + paramFloat2);
    }
    label86:
    while ((!a(paramFloat1, paramFloat2)) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    a("onClick set needChange!");
  }
  
  public static void a(String paramString)
  {
    if (SLog.a()) {
      SLog.c("NonFit2DFilter", paramString);
    }
  }
  
  private void b(long paramLong)
  {
    int i = a(paramLong);
    if (i == this.jdField_b_of_type_Int)
    {
      a("updateTextureParam return!");
      return;
    }
    a("updateTextureParam" + i);
    addParam(new Param.TextureParam("inputImageTexture2", a(i), 33986));
    this.jdField_b_of_type_Int = i;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam != null)
    {
      this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam.clear();
      this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam = null;
    }
    setPositions(VideoFilterUtil.EMPTY_POSITIONS);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Int = 0;
    a("clearTextureParam!");
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      return;
    }
    if (this.width / this.height >= 0.75D)
    {
      paramDouble1 = this.width / 720.0D;
      j = (int)(this.width / 0.75D);
      int k = (int)(j * this.item.position[1]);
      i = (int)(this.width * this.item.position[0]);
      j = k - (j - this.height) / 2;
      setPositions(AlgoUtils.calPositions(i, (float)(j + this.item.height * paramDouble1), (float)(i + this.item.width * paramDouble1), j, this.width, this.height));
      this.jdField_a_of_type_AndroidGraphicsPointF.x = ((float)(i + this.item.width * paramDouble1 / 2.0D));
      this.jdField_a_of_type_AndroidGraphicsPointF.y = ((float)(j + this.item.height * paramDouble1 / 2.0D));
      return;
    }
    paramDouble1 = this.height / 960.0D;
    int j = (int)(this.height * 0.75D);
    int i = (int)(this.height * this.item.position[1]);
    j = (int)(j * this.item.position[0]) - (j - this.width) / 2;
    setPositions(AlgoUtils.calPositions(j, (float)(i + this.item.height * paramDouble1), (float)(j + this.item.width * paramDouble1), i, this.width, this.height));
    this.jdField_a_of_type_AndroidGraphicsPointF.x = ((float)(j + this.item.width * paramDouble1 / 2.0D));
    this.jdField_a_of_type_AndroidGraphicsPointF.y = ((float)(i + this.item.height * paramDouble1 / 2.0D));
  }
  
  protected void a(long paramLong)
  {
    boolean bool = true;
    if (this.item != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        break label212;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Long = paramLong;
    }
    for (;;)
    {
      String str;
      if ((!TextUtils.isEmpty(this.dataPath)) && (!TextUtils.isEmpty(this.item.id)) && (!TextUtils.isEmpty(this.item.audio))) {
        if ((this.jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player == null) && (!VideoPrefsUtil.getMaterialMute()))
        {
          str = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
          if (!str.startsWith("assets://")) {
            break label179;
          }
        }
      }
      label179:
      for (this.jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player = AudioUtils.createPlayerFromAssets(VideoGlobalContext.getContext(), str.replace("assets://", ""), false);; this.jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player = AudioUtils.createPlayerFromUri(VideoGlobalContext.getContext(), str, false))
      {
        a("mPlayer init!");
        if (!VideoPrefsUtil.getMaterialMute()) {
          break;
        }
        AudioUtils.stopPlayer(this.jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player);
        return;
      }
      AudioUtils.startPlayer(this.jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player, bool);
      return;
      AudioUtils.stopPlayer(this.jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player);
      return;
      label212:
      bool = false;
    }
  }
  
  public void a(NonFitItem paramNonFitItem, int paramInt)
  {
    this.item = paramNonFitItem;
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Int = 0;
    this.f = 0;
    this.jdField_d_of_type_Boolean = false;
    b();
    ImageMemoryManager.getInstance().reset(paramNonFitItem.id);
    if ((paramInt == 0) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_b_of_type_AndroidGraphicsPointF.x = 0.0F;
      this.jdField_b_of_type_AndroidGraphicsPointF.y = 0.0F;
    }
    a("currentItem id:" + this.item.id);
  }
  
  protected void a(List paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    c();
  }
  
  public boolean a()
  {
    return (Float.compare(this.jdField_b_of_type_AndroidGraphicsPointF.x, 0.0F) == 0) && (Float.compare(this.jdField_b_of_type_AndroidGraphicsPointF.y, 0.0F) == 0);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool3 = false;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem == null) {
      return true;
    }
    if ((this.jdField_d_of_type_Int < this.jdField_e_of_type_Int - 1) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem[(this.jdField_d_of_type_Int + 1)].jdField_a_of_type_Int == 0)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (this.jdField_d_of_type_Int == this.jdField_e_of_type_Int - 1)
      {
        bool2 = bool1;
        if (((NonFitItem)this.item).playCount == 1)
        {
          bool2 = bool1;
          if (this.f != this.item.frames - 1) {
            bool2 = false;
          }
        }
      }
      if ((bool2) && (((NonFitItem)this.item).jdField_b_of_type_Int == 0))
      {
        a("check area if in model");
        DisplayMetrics localDisplayMetrics = a(SdkContext.a().a());
        if (localDisplayMetrics != null)
        {
          float f1 = this.width / localDisplayMetrics.widthPixels;
          float f2 = this.height / localDisplayMetrics.heightPixels;
          f1 = Math.abs(f1 * paramFloat1 - this.jdField_a_of_type_AndroidGraphicsPointF.x);
          paramFloat2 = Math.abs(f2 * paramFloat2 - this.jdField_a_of_type_AndroidGraphicsPointF.y);
          if (this.width / this.height >= 0.75D)
          {
            paramFloat1 = this.width / 720.0F;
            if ((f1 <= this.item.width / 2 * paramFloat1) && (paramFloat2 <= paramFloat1 * (this.item.height / 2))) {
              break label314;
            }
            a("outside model");
          }
        }
      }
      label314:
      for (bool1 = bool3;; bool1 = bool2)
      {
        a("can click result: " + bool1);
        return bool1;
        paramFloat1 = this.height / 960.0F;
        break;
      }
    }
  }
  
  public void b()
  {
    a("destroyAudio!");
    AudioUtils.destroyPlayer(this.jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player);
    this.jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player = null;
  }
  
  public void c()
  {
    d();
    if (!this.jdField_c_of_type_Boolean)
    {
      a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
      return;
    }
    e();
  }
  
  public void clearGLSLSelf()
  {
    a("clearGLSLSelf!");
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureGLGestureListener);
    a();
    b();
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
  }
  
  void d()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      DisplayMetrics localDisplayMetrics = a(SdkContext.a().a());
      if ((!a()) && (localDisplayMetrics != null))
      {
        float f1 = this.width / localDisplayMetrics.widthPixels;
        float f2 = this.height / localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_AndroidGraphicsPointF.x = (f1 * this.jdField_b_of_type_AndroidGraphicsPointF.x);
        this.jdField_a_of_type_AndroidGraphicsPointF.y = (f2 * this.jdField_b_of_type_AndroidGraphicsPointF.y);
      }
      return;
    }
    this.jdField_a_of_type_Double = this.item.position[0];
    this.jdField_b_of_type_Double = this.item.position[1];
  }
  
  public void e()
  {
    if (this.width / this.height >= 0.75D) {}
    for (double d1 = this.width / 720.0D;; d1 = this.height / 960.0D)
    {
      float f1 = this.jdField_a_of_type_AndroidGraphicsPointF.x - (float)(this.item.width * d1) / 2.0F;
      float f2 = this.jdField_a_of_type_AndroidGraphicsPointF.y - (float)(this.item.height * d1) / 2.0F;
      float f3 = (float)(f1 + this.item.width * d1);
      double d2 = f2;
      setPositions(AlgoUtils.calPositions(f1, (float)(d1 * this.item.height + d2), f3, f2, this.width, this.height));
      return;
    }
  }
  
  public void initParams()
  {
    addParam(new Param.IntParam("texNeedTransform", -1));
    addParam(new Param.IntParam("blendMode", this.item.blendMode));
    addParam(new Param.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_c_of_type_Boolean) && (a()))
    {
      a("renderTexture position empty!");
      return true;
    }
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void updatePreview(List paramList, float[] paramArrayOfFloat, Map paramMap, float paramFloat, long paramLong)
  {
    a("initialized:" + this.jdField_b_of_type_Boolean + ", frameStartTime:" + this.jdField_a_of_type_Long + ", needChange:" + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_d_of_type_Int + 1;
      this.jdField_d_of_type_Int = i;
      this.jdField_d_of_type_Int = (i % this.jdField_e_of_type_Int);
      a(this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem[this.jdField_d_of_type_Int], this.jdField_d_of_type_Int);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      setDrawPartial(true);
      initParams();
    }
    if ((this.jdField_c_of_type_Boolean) && (a()))
    {
      a("position empty!");
      return;
    }
    a(paramLong);
    a(paramList, paramArrayOfFloat, paramFloat);
    b(paramLong);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.NonFit2DFilter
 * JD-Core Version:    0.7.0.1
 */