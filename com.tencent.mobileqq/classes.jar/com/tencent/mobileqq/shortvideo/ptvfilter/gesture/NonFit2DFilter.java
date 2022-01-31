package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.Param.TextureParam;
import com.tencent.sveffects.SLog;
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
  float jdField_a_of_type_Float = 0.5F;
  protected int a;
  protected long a;
  PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  protected Param.TextureBitmapParam a;
  protected StickerItem a;
  private AudioUtils.Player jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player;
  protected String a;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private double jdField_b_of_type_Double = 0.0D;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = 0L;
  PointF jdField_b_of_type_AndroidGraphicsPointF = new PointF();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = 0;
  private int e = 0;
  private int f;
  private int g;
  private int h = 0;
  
  public NonFit2DFilter(StickerItem paramStickerItem, String paramString)
  {
    super(VideoFilterUtil.VERTEX_SHADER_COMMON, VideoFilterUtil.FRAGMENT_SHADER_COMMON, null);
    this.jdField_a_of_type_Int = 0;
    if (paramStickerItem == null) {
      throw new IllegalArgumentException("items length error!");
    }
    this.jdField_a_of_type_ComTencentTtpicModelStickerItem = paramStickerItem;
    this.e = 1;
    this.dataPath = paramString;
    this.jdField_a_of_type_JavaLangString = VideoMaterialUtil.getMaterialId(paramString);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentTtpicModelStickerItem.playCount = 1;
    a(paramStickerItem, 0);
    this.f = this.item.width;
    this.g = this.item.height;
    a("dataPath:" + paramString + ", materialId:" + this.jdField_a_of_type_JavaLangString + ", ItemLength:" + this.e);
    setDrawPartial(true);
    initParams();
    if (paramStickerItem.anchorPoint != null) {
      this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramStickerItem.anchorPoint[0], paramStickerItem.anchorPoint[1]);
    }
  }
  
  private int a(int paramInt)
  {
    boolean bool2 = true;
    Object localObject = ImageMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if ((localObject == null) || (!VideoBitmapUtil.isLegal((Bitmap)localObject)))
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
        StringBuilder localStringBuilder = new StringBuilder().append("getNextFrame load cache:");
        if (paramInt == 0) {}
        for (;;)
        {
          a(bool2 + ", updateTexture:" + bool1 + ",bitmap content:" + VideoBitmapUtil.isLegal((Bitmap)localObject));
          return this.jdField_a_of_type_ArrayOfInt[0];
          bool2 = false;
        }
      }
    }
  }
  
  private int a(long paramLong)
  {
    int j;
    if (this.jdField_a_of_type_ComTencentTtpicModelStickerItem.playCount == 0)
    {
      i = 1;
      j = (int)((paramLong - this.jdField_a_of_type_Long) / Math.max(this.item.frameDuration, 1.0D));
      if (j >= this.item.frames * (this.jdField_a_of_type_Int + 1)) {
        this.jdField_a_of_type_Int += 1;
      }
      j %= Math.max(this.item.frames, 1);
      if (i != 0) {
        break label160;
      }
      if ((!this.jdField_c_of_type_Boolean) && (j >= this.h)) {
        break label154;
      }
    }
    label154:
    for (int i = this.item.frames - 1;; i = j)
    {
      this.h = i;
      j = i;
      if (i >= this.item.frames - 1)
      {
        j = this.item.frames - 1;
        this.jdField_c_of_type_Boolean = true;
      }
      return j;
      i = 0;
      break;
    }
    label160:
    return j;
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
    a(this.jdField_a_of_type_ComTencentTtpicModelStickerItem, 0);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2)) {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
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
        this.jdField_a_of_type_AndroidGraphicsPointF.x = ((float)(i + this.item.width * paramDouble1 / 2.0D));
      }
      for (this.jdField_a_of_type_AndroidGraphicsPointF.y = ((float)(j + this.item.height * paramDouble1 / 2.0D)); SLog.a(); this.jdField_a_of_type_AndroidGraphicsPointF.y = ((float)(i + this.item.height * paramDouble1 / 2.0D)))
      {
        SLog.d("GestureTestUse", "should nerver run this clause");
        return;
        paramDouble1 = this.height / 960.0D;
        j = (int)(this.height * 0.75D);
        i = (int)(this.height * this.item.position[1]);
        j = (int)(j * this.item.position[0]) - (j - this.width) / 2;
        setPositions(AlgoUtils.calPositions(j, (float)(i + this.item.height * paramDouble1), (float)(j + this.item.width * paramDouble1), i, this.width, this.height));
        this.jdField_a_of_type_AndroidGraphicsPointF.x = ((float)(j + this.item.width * paramDouble1 / 2.0D));
      }
    }
  }
  
  protected void a(long paramLong)
  {
    boolean bool = true;
    if (this.item != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        break label212;
      }
      this.jdField_a_of_type_Boolean = true;
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
  
  public void a(PointF paramPointF)
  {
    this.jdField_b_of_type_AndroidGraphicsPointF = paramPointF;
  }
  
  public void a(StickerItem paramStickerItem, int paramInt)
  {
    this.item = paramStickerItem;
    this.d = paramInt;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Int = 0;
    this.h = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    c();
    ImageMemoryManager.getInstance().reset(paramStickerItem.id);
    a("currentItem id:" + this.item.id);
  }
  
  protected void a(List paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    d();
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Long == 0L) {}
    while (paramLong - this.jdField_a_of_type_Long <= this.item.frames * this.item.frameDuration) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam != null)
    {
      this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam.clear();
      this.jdField_a_of_type_ComTencentFilterParam$TextureBitmapParam = null;
    }
    setPositions(VideoFilterUtil.EMPTY_POSITIONS);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Int = 0;
    a("clearTextureParam!");
  }
  
  public void c()
  {
    a("destroyAudio!");
    AudioUtils.destroyPlayer(this.jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player);
    this.jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player = null;
  }
  
  public void clearGLSLSelf()
  {
    a("clearGLSLSelf!");
    b();
    c();
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
  }
  
  public void d()
  {
    e();
    if (!this.jdField_b_of_type_Boolean)
    {
      a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
      return;
    }
    f();
  }
  
  void e()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Double = this.item.position[0];
    this.jdField_b_of_type_Double = this.item.position[1];
  }
  
  public void f()
  {
    if (this.width / this.height >= 0.75D) {}
    for (double d1 = this.width / 720.0D;; d1 = this.height / 960.0D)
    {
      this.jdField_a_of_type_Float = (this.item.scaleFactor / 960.0F);
      if (this.jdField_a_of_type_Float == 0.0F) {
        this.jdField_a_of_type_Float = 1.0F;
      }
      this.jdField_a_of_type_Float *= 1.2F;
      float f1 = this.jdField_b_of_type_AndroidGraphicsPointF.x - (float)(this.jdField_a_of_type_AndroidGraphicsPointF.x * d1 * this.jdField_a_of_type_Float);
      float f2 = this.jdField_b_of_type_AndroidGraphicsPointF.y - (float)(this.jdField_a_of_type_AndroidGraphicsPointF.y * d1 * this.jdField_a_of_type_Float);
      float f3 = (float)(f1 + this.item.width * d1 * this.jdField_a_of_type_Float);
      double d2 = f2;
      float f4 = (float)(d1 * this.item.height * this.jdField_a_of_type_Float + d2);
      float f5 = f1 / this.width;
      f5 = f4 / this.height;
      f5 = f3 / this.width;
      f5 = f2 / this.height;
      setPositions(AlgoUtils.calPositions(f1, f4, f3, f2, this.width, this.height));
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
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void updatePreview(List paramList, float[] paramArrayOfFloat, Map paramMap, float paramFloat, long paramLong)
  {
    a("initialized:" + this.jdField_a_of_type_Boolean + ", frameStartTime:" + this.jdField_a_of_type_Long + ", needChange:");
    a(paramLong);
    a(paramList, paramArrayOfFloat, paramFloat);
    b(paramLong);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.NonFit2DFilter
 * JD-Core Version:    0.7.0.1
 */