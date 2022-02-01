package com.tencent.mobileqq.wink.editor.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.view.WinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.WinkMaterialPanelContentAdapter.ContentItemVH;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class FilterMaterialPanelContentAdapter
  extends WinkMaterialPanelContentAdapter
{
  public FilterMaterialPanelContentAdapter(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected WinkMaterialPanelContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WinkMaterialPanelContentAdapter.ContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628260, paramViewGroup, false));
  }
  
  protected void a(WinkMaterialPanelContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull @NotNull MetaMaterial paramMetaMaterial)
  {
    super.a(paramContentItemVH, paramInt, paramMetaMaterial);
    VideoReport.setElementId(paramContentItemVH.itemView, "em_xsj_filter_item");
    VideoReport.setElementReuseIdentifier(paramContentItemVH.itemView, String.valueOf(paramMetaMaterial.hashCode()));
    Map localMap = WinkDTParamBuilder.buildElementParams();
    localMap.put("xsj_filter_name", MetaMaterialKt.b(paramMetaMaterial));
    localMap.put("xsj_camera_clck_ref_pgid", WinkDatongCurrentParams.params.get("xsj_camera_clck_ref_pgid"));
    localMap.put("xsj_filter_category", MetaMaterialKt.d(paramMetaMaterial));
    VideoReport.setElementParams(paramContentItemVH.itemView, localMap);
    VideoReport.setElementEndExposePolicy(paramContentItemVH.itemView, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramContentItemVH.itemView, ClickPolicy.REPORT_ALL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.filter.FilterMaterialPanelContentAdapter
 * JD-Core Version:    0.7.0.1
 */