package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.audio.AudioDataManager;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.List;
import java.util.Set;

public class CustomVideoFilter
  extends VideoFilterBase
{
  private static final String TAG = "CustomVideoFilter";
  private long frameStartTime;
  private List<RenderItem> normalRenderItems;
  private PTFaceAttr.PTExpression triggerType;
  
  public CustomVideoFilter(String paramString1, String paramString2, List<String> paramList, PTFaceAttr.PTExpression paramPTExpression, String paramString3)
  {
    super(BaseFilter.nativeDecrypt(paramString1), BaseFilter.nativeDecrypt(paramString2));
    this.dataPath = paramString3;
    this.triggerType = paramPTExpression;
    if (this.triggerType == null) {
      this.triggerType = PTFaceAttr.PTExpression.UNKNOW;
    }
    initParams();
    initTextureParams(paramList);
  }
  
  private void initTextureParams(List<String> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (String)paramList.get(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.dataPath);
      localStringBuilder.append(File.separator);
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
      if (((String)localObject).startsWith("assets://")) {
        localObject = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath((String)localObject), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
      } else {
        localObject = BitmapUtils.decodeSampledBitmapFromFile((String)localObject, MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
      }
      if (BitmapUtils.isLegal((Bitmap)localObject))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("inputImageTexture");
        localStringBuilder.append(i + 1);
        addParam(new UniformParam.TextureBitmapParam(localStringBuilder.toString(), (Bitmap)localObject, 33985 + i, true));
      }
      i += 1;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setTexCords(GlUtil.ORIGIN_TEX_COORDS);
    this.frameStartTime = System.currentTimeMillis();
  }
  
  public float[] getElementDurations(long paramLong)
  {
    boolean bool = CollectionUtils.isEmpty(this.normalRenderItems);
    int i = 0;
    if (bool) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[this.normalRenderItems.size()];
    while (i < this.normalRenderItems.size())
    {
      AEFilterI localAEFilterI = ((RenderItem)this.normalRenderItems.get(i)).filter;
      if ((localAEFilterI instanceof NormalVideoFilter)) {
        arrayOfFloat[i] = ((NormalVideoFilter)localAEFilterI).getFrameDuration(paramLong);
      }
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public void initParams()
  {
    addParam(new UniformParam.Float2fParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.CANVAS_SIZE), 0.0F, 0.0F));
    addParam(new UniformParam.Float2fParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.FACE_DETECT_IMAGE_SIZE), 0.0F, 0.0F));
    addParam(new UniformParam.Float1sParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.FACE_POINT), new float[0]));
    addParam(new UniformParam.IntParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.FACE_ACTION_TYPE), 0));
    addParam(new UniformParam.FloatParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.FRAME_DURATION), 0.0F));
    addParam(new UniformParam.Float1sParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.ELEMENT_DURATIONS), new float[0]));
    addParam(new UniformParam.FloatParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.AUDIO_POWER_SCALE), 0.0F));
  }
  
  public void setNormalRenderItems(List<RenderItem> paramList)
  {
    this.normalRenderItems = paramList;
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      boolean bool = paramObject.triggeredExpression.contains(Integer.valueOf(this.triggerType.value));
      int j = 0;
      int i;
      if (bool) {
        i = this.triggerType.value;
      } else if (paramObject.triggeredExpression.contains(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value))) {
        i = PTFaceAttr.PTExpression.FACE_DETECT.value;
      } else {
        i = 0;
      }
      addParam(new UniformParam.IntParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.FACE_ACTION_TYPE), i));
      addParam(new UniformParam.FloatParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.FRAME_DURATION), (float)(System.currentTimeMillis() - this.frameStartTime) / 1000.0F));
      float[] arrayOfFloat;
      if (paramObject.facePoints != null)
      {
        arrayOfFloat = VideoMaterial.toFlatArray(paramObject.facePoints);
        if (arrayOfFloat != null)
        {
          String str = CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.FACE_POINT);
          double d1 = this.height;
          double d2 = this.mFaceDetScale;
          Double.isNaN(d1);
          addParam(new UniformParam.Float1sParam(str, VideoMaterial.flipYPoints(arrayOfFloat, (int)(d1 * d2))));
        }
      }
      else
      {
        arrayOfFloat = new float['´'];
        i = j;
        while (i < arrayOfFloat.length)
        {
          arrayOfFloat[i] = 0.0F;
          i += 1;
        }
        addParam(new UniformParam.Float1sParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.FACE_POINT), arrayOfFloat));
      }
      addParam(new UniformParam.Float1sParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.ELEMENT_DURATIONS), getElementDurations(paramObject.timestamp)));
      addParam(new UniformParam.FloatParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.AUDIO_POWER_SCALE), AudioDataManager.getInstance().getDecibel() / 120.0F));
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam(CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.CANVAS_SIZE), paramInt1, paramInt2));
    String str = CustomVideoFilter.SHADER_FIELD.access$000(CustomVideoFilter.SHADER_FIELD.FACE_DETECT_IMAGE_SIZE);
    paramDouble = this.width;
    double d = this.mFaceDetScale;
    Double.isNaN(paramDouble);
    float f = (float)(paramDouble * d);
    paramDouble = this.height;
    d = this.mFaceDetScale;
    Double.isNaN(paramDouble);
    addParam(new UniformParam.Float2fParam(str, f, (float)(paramDouble * d)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.CustomVideoFilter
 * JD-Core Version:    0.7.0.1
 */