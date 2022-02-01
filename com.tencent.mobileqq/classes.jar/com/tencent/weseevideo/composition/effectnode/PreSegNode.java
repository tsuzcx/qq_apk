package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.Nullable;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.tavcut.aekit.PreSegModel;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.weseevideo.model.effect.CropModel;

public class PreSegNode
  implements TAVVideoEffect
{
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private PreSegModel jdField_a_of_type_ComTencentTavcutAekitPreSegModel;
  private PreSegNode.PicSaveDelegate jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode$PicSaveDelegate;
  private CropModel jdField_a_of_type_ComTencentWeseevideoModelEffectCropModel;
  private final String jdField_a_of_type_JavaLangString;
  private String b;
  
  public PreSegNode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreSegNode");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.b = "PreSegNode";
  }
  
  public void a(AEFilterManager paramAEFilterManager)
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = paramAEFilterManager;
  }
  
  public void a(PreSegModel paramPreSegModel)
  {
    this.jdField_a_of_type_ComTencentTavcutAekitPreSegModel = paramPreSegModel;
  }
  
  public void a(PreSegNode.PicSaveDelegate paramPicSaveDelegate)
  {
    this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode$PicSaveDelegate = paramPicSaveDelegate;
  }
  
  public void a(CropModel paramCropModel)
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectCropModel = paramCropModel;
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    Logger.i("PreSegNode", "createFilter---");
    return new PreSegNode.AEKitFilter(this, null);
  }
  
  @Nullable
  public String effectId()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.PreSegNode
 * JD-Core Version:    0.7.0.1
 */