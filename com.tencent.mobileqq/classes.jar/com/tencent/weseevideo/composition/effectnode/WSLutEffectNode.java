package com.tencent.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.weseevideo.model.effect.LutModel;

public class WSLutEffectNode
  implements TAVVideoEffect
{
  private Bitmap mLutBitmap;
  private LutModel mLutModel;
  protected String reportKey;
  private final String sEffectId;
  
  public WSLutEffectNode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSLutEffectNode");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.sEffectId = localStringBuilder.toString();
    this.reportKey = "WSLutEffectNode";
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new WSLutEffectNode.WSLutEffectFilter(this);
  }
  
  @Nullable
  public String effectId()
  {
    if (this.mLutModel == null) {
      return "";
    }
    return this.sEffectId;
  }
  
  public void setLutMode(LutModel paramLutModel)
  {
    if ((!TextUtils.isEmpty(paramLutModel.getLutBitmap())) && ((this.mLutModel == null) || (!paramLutModel.getLutBitmap().equals(this.mLutModel.getLutBitmap())))) {
      this.mLutBitmap = BitmapFactory.decodeFile(paramLutModel.getLutBitmap());
    }
    this.mLutModel = paramLutModel;
  }
  
  public void setReportKey(String paramString)
  {
    this.reportKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSLutEffectNode
 * JD-Core Version:    0.7.0.1
 */