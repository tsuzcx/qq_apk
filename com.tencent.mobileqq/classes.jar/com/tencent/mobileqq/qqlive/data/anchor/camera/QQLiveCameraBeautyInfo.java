package com.tencent.mobileqq.qqlive.data.anchor.camera;

import androidx.annotation.IntRange;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.ArrayList;
import java.util.List;

public class QQLiveCameraBeautyInfo
{
  @IntRange(from=0L, to=100L)
  public int customValue;
  @IntRange(from=0L, to=100L)
  public int defaultValue;
  public String desc;
  public boolean isSelected;
  public int itemId;
  public String name;
  
  public QQLiveCameraBeautyInfo() {}
  
  public QQLiveCameraBeautyInfo(int paramInt, String paramString)
  {
    this.itemId = paramInt;
    this.name = paramString;
  }
  
  public QQLiveCameraBeautyInfo(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.itemId = paramInt1;
    this.name = paramString1;
    this.desc = paramString2;
    this.defaultValue = paramInt2;
  }
  
  private static QQLiveCameraBeautyInfo getBeautyInfo(BeautyRealConfig.TYPE paramTYPE)
  {
    if (paramTYPE == BeautyRealConfig.TYPE.BEAUTY) {
      return new QQLiveCameraBeautyInfo(paramTYPE.value, paramTYPE.name(), "美颜", 8);
    }
    if (paramTYPE == BeautyRealConfig.TYPE.EYE_LIGHTEN) {
      return new QQLiveCameraBeautyInfo(paramTYPE.value, paramTYPE.name(), "亮眼", 10);
    }
    if (paramTYPE == BeautyRealConfig.TYPE.TOOTH_WHITEN) {
      return new QQLiveCameraBeautyInfo(paramTYPE.value, paramTYPE.name(), "白牙", 0);
    }
    if (paramTYPE == BeautyRealConfig.TYPE.REMOVE_POUNCH) {
      return new QQLiveCameraBeautyInfo(paramTYPE.value, paramTYPE.name(), "祛眼袋", 8);
    }
    if (paramTYPE == BeautyRealConfig.TYPE.COLOR_TONE) {
      return new QQLiveCameraBeautyInfo(paramTYPE.value, paramTYPE.name(), "肤色", 8);
    }
    if (paramTYPE == BeautyRealConfig.TYPE.EYE) {
      return new QQLiveCameraBeautyInfo(paramTYPE.value, paramTYPE.name(), "大眼", 8);
    }
    if (paramTYPE == BeautyRealConfig.TYPE.FACE_THIN) {
      return new QQLiveCameraBeautyInfo(paramTYPE.value, paramTYPE.name(), "瘦脸", 8);
    }
    if (paramTYPE == BeautyRealConfig.TYPE.BASIC3) {
      return new QQLiveCameraBeautyInfo(paramTYPE.value, paramTYPE.name(), "全脸调整", 8);
    }
    return null;
  }
  
  public static List<QQLiveCameraBeautyInfo> getDefaultBeauty()
  {
    ArrayList localArrayList = new ArrayList();
    BeautyRealConfig.TYPE[] arrayOfTYPE = BeautyRealConfig.TYPE.values();
    int j = arrayOfTYPE.length;
    int i = 0;
    while (i < j)
    {
      QQLiveCameraBeautyInfo localQQLiveCameraBeautyInfo = getBeautyInfo(arrayOfTYPE[i]);
      if (localQQLiveCameraBeautyInfo != null) {
        localArrayList.add(localQQLiveCameraBeautyInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveCameraBeautyInfo
 * JD-Core Version:    0.7.0.1
 */