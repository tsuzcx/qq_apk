package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.Param.TextureParam;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
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
import java.io.File;
import java.util.List;
import java.util.Map;

public class StaticGestureFilter
  extends VideoFilterBase
{
  protected int a;
  protected long a;
  protected Param.TextureBitmapParam a;
  private AudioUtils.Player jdField_a_of_type_ComTencentTtpicUtilAudioUtils$Player;
  protected String a;
  private boolean jdField_a_of_type_Boolean = false;
  float[] jdField_a_of_type_ArrayOfFloat = { -1.0F, 1.0F, 1.0F, -1.0F };
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  public int b;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "qheart";
  private boolean jdField_b_of_type_Boolean = false;
  public int c;
  private boolean c;
  public int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = 0;
  
  public StaticGestureFilter(StickerItem paramStickerItem, String paramString)
  {
    super(VideoFilterUtil.VERTEX_SHADER_COMMON, VideoFilterUtil.FRAGMENT_SHADER_COMMON, null);
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.dataPath = paramString;
    paramStickerItem.playCount = 1;
    this.jdField_a_of_type_JavaLangString = VideoMaterialUtil.getMaterialId(paramString);
    a(paramStickerItem, 0);
    setDrawPartial(true);
    initParams();
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
    if (this.item.playCount == 0) {}
    int i = (int)((paramLong - this.jdField_a_of_type_Long) / Math.max(this.item.frameDuration, 1.0D));
    if (i >= this.item.frames * (this.jdField_a_of_type_Int + 1)) {
      this.jdField_a_of_type_Int += 1;
    }
    return i % Math.max(this.item.frames, 1);
  }
  
  private void a(long paramLong)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_Boolean = false;
    this.g = -1;
    this.e = -1;
    this.f = -1;
  }
  
  public static void a(String paramString)
  {
    if (SLog.a()) {
      SLog.c("StaticGestureFilter", paramString);
    }
  }
  
  private void b(long paramLong)
  {
    int i = a(paramLong);
    if (i == this.e)
    {
      a("updateTextureParam return! + lastImageIndex:" + this.e + ";count is" + i + ":timestamp:=" + paramLong + ":framestartTimes " + this.jdField_a_of_type_Long);
      return;
    }
    a("updateTextureParam" + i);
    addParam(new Param.TextureParam("inputImageTexture2", a(i), 33986));
    this.e = i;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
  }
  
  public void OnDrawFrameGLSL()
  {
    super.OnDrawFrameGLSL();
  }
  
  public String a()
  {
    return "mGestureAnimType:=" + this.jdField_b_of_type_Int + ";" + this.jdField_c_of_type_Int + ";" + this.d;
  }
  
  public void a()
  {
    setPositions(AlgoUtils.calPositions(0.0F, 100.0F, 100.0F, 0.0F, 100, 100));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.d = paramInt3;
  }
  
  public void a(StickerItem paramStickerItem, int paramInt)
  {
    this.item = paramStickerItem;
    this.e = -1;
    this.f = -1;
    this.jdField_a_of_type_Int = 0;
    this.g = 0;
    this.jdField_c_of_type_Boolean = false;
    c();
    ImageMemoryManager.getInstance().reset(paramStickerItem.id);
    a("currentItem id:" + this.item.id);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong - this.jdField_a_of_type_Long > this.item.frames * this.item.frameDuration;
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
    this.e = -1;
    this.f = -1;
    this.jdField_c_of_type_Boolean = false;
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
    this.jdField_b_of_type_Long = 0L;
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
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
  
  public boolean setRenderMode(int paramInt)
  {
    return super.setRenderMode(paramInt);
  }
  
  public void updatePreview(List paramList, float[] paramArrayOfFloat, Map paramMap, float paramFloat, long paramLong)
  {
    int j = 1;
    if ((this.item.triggerType == 1001) && (this.item.type == 1)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramList = GestureMgrRecognize.a().a();
        if ((paramList != null) && (paramList.jdField_a_of_type_Boolean) && (paramList.jdField_a_of_type_JavaLangString.equalsIgnoreCase(GestureFilterManager.jdField_a_of_type_JavaLangString)))
        {
          if (this.jdField_b_of_type_Long == 0L) {
            this.jdField_a_of_type_Long = paramLong;
          }
          this.jdField_b_of_type_Long = paramLong;
          i = j;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          if (a(paramLong)) {
            a(paramLong);
          }
          a();
          b(paramLong);
        }
        do
        {
          return;
          if ((a(paramLong)) || (this.jdField_a_of_type_Long == 0L))
          {
            b();
            this.jdField_a_of_type_Long = 0L;
            this.jdField_b_of_type_Long = 0L;
            return;
          }
          a();
          b(paramLong);
        } while (!SLog.a());
        SLog.d("StaticGestureFilter", "updatePreview continue");
        return;
        i = 0;
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    setPositions(VideoFilterUtil.EMPTY_POSITIONS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.StaticGestureFilter
 * JD-Core Version:    0.7.0.1
 */