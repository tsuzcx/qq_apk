package com.tencent.mobileqq.wink.editor.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.view.WinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.WinkMaterialPanelContentAdapter.ContentItemVH;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class VideoTemplateMaterialPanelContentAdapter
  extends WinkMaterialPanelContentAdapter
{
  public VideoTemplateMaterialPanelContentAdapter(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected WinkMaterialPanelContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WinkMaterialPanelContentAdapter.ContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628265, paramViewGroup, false));
  }
  
  protected void a(WinkMaterialPanelContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull @NotNull MetaMaterial paramMetaMaterial)
  {
    super.a(paramContentItemVH, paramInt, paramMetaMaterial);
    VideoReport.setElementId(paramContentItemVH.itemView, "em_xsj_template_item");
    VideoReport.setElementReuseIdentifier(paramContentItemVH.itemView, String.valueOf(paramMetaMaterial.hashCode()));
    Map localMap = WinkDTParamBuilder.buildElementParams();
    localMap.put("xsj_template_name", MetaMaterialKt.b(paramMetaMaterial));
    localMap.put("xsj_template_category", MetaMaterialKt.d(paramMetaMaterial));
    VideoReport.setElementParams(paramContentItemVH.itemView, localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.template.VideoTemplateMaterialPanelContentAdapter
 * JD-Core Version:    0.7.0.1
 */