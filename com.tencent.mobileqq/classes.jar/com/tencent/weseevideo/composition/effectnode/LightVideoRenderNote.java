package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.Nullable;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.weseevideo.composition.interfaces.OnNodeRenderListener;
import org.light.LightAsset;
import org.light.LightEngine;

public class LightVideoRenderNote
  implements TAVVideoEffect
{
  private OnNodeRenderListener jdField_a_of_type_ComTencentWeseevideoCompositionInterfacesOnNodeRenderListener;
  private final String jdField_a_of_type_JavaLangString;
  private LightAsset jdField_a_of_type_OrgLightLightAsset;
  private final LightEngine jdField_a_of_type_OrgLightLightEngine;
  
  public LightVideoRenderNote(LightEngine paramLightEngine)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LightVideoRenderNote@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_OrgLightLightEngine = paramLightEngine;
  }
  
  public void a(OnNodeRenderListener paramOnNodeRenderListener)
  {
    this.jdField_a_of_type_ComTencentWeseevideoCompositionInterfacesOnNodeRenderListener = paramOnNodeRenderListener;
  }
  
  public void a(LightAsset paramLightAsset)
  {
    this.jdField_a_of_type_OrgLightLightAsset = paramLightAsset;
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new LightVideoRenderNote.LightVideoRenderFilter(this.jdField_a_of_type_OrgLightLightEngine, this.jdField_a_of_type_ComTencentWeseevideoCompositionInterfacesOnNodeRenderListener, this.jdField_a_of_type_OrgLightLightAsset);
  }
  
  @Nullable
  public String effectId()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.LightVideoRenderNote
 * JD-Core Version:    0.7.0.1
 */