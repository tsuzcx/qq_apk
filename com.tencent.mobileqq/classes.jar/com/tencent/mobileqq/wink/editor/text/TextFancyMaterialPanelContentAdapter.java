package com.tencent.mobileqq.wink.editor.text;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.util.DisplayUtil;
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

public class TextFancyMaterialPanelContentAdapter
  extends WinkMaterialPanelContentAdapter
{
  private final int a;
  private final int b;
  
  public TextFancyMaterialPanelContentAdapter(@NonNull Context paramContext)
  {
    super(paramContext, 2);
    this.a = DisplayUtil.a(paramContext, 14.0F);
    this.b = DisplayUtil.a(paramContext, 12.0F);
  }
  
  private void a(View paramView, MetaMaterial paramMetaMaterial, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (MetaMaterialKt.d(paramMetaMaterial).equals("CATEGORY_TEXT_PATTERN"))
    {
      localHashMap.put("xsj_char_art_name", paramMetaMaterial.id);
      a(paramView, "em_xsj_char_art_item", localHashMap, paramInt, String.valueOf(paramMetaMaterial.hashCode()));
      WinkDatongCurrentParams.put("xsj_char_art_name", paramMetaMaterial.id);
      return;
    }
    if (MetaMaterialKt.d(paramMetaMaterial).equals("CATEGORY_TEXT_DECOR"))
    {
      localHashMap.put("xsj_char_pattern_name", paramMetaMaterial.id);
      a(paramView, "em_xsj_char_pattern_item", localHashMap, paramInt, String.valueOf(paramMetaMaterial.hashCode()));
      WinkDatongCurrentParams.put("xsj_char_pattern_name", paramMetaMaterial.id);
    }
  }
  
  private void a(View paramView, String paramString1, Map<String, Object> paramMap, int paramInt, String paramString2)
  {
    VideoReport.setElementId(paramView, paramString1);
    VideoReport.setElementReuseIdentifier(paramView, paramString2);
    paramString1 = WinkDTParamBuilder.buildElementParams();
    paramString1.putAll(paramMap);
    paramString1.put("xsj_camera_clck_ref_pgid", WinkDatongCurrentParams.params.get("xsj_camera_clck_ref_pgid"));
    VideoReport.setElementParams(paramView, paramString1);
    VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
  }
  
  protected WinkMaterialPanelContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new WinkMaterialPanelContentAdapter.ContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628263, paramViewGroup, false));
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.itemView.getLayoutParams();
    paramInt &= 0xF;
    if (paramInt == 1)
    {
      localLayoutParams.topMargin = this.a;
      localLayoutParams.bottomMargin = this.b;
      return paramViewGroup;
    }
    if (paramInt == 3)
    {
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = 12;
      return paramViewGroup;
    }
    localLayoutParams.topMargin = 0;
    localLayoutParams.bottomMargin = this.b;
    return paramViewGroup;
  }
  
  protected void a(WinkMaterialPanelContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    super.a(paramContentItemVH, paramInt, paramMetaMaterial);
    a(paramContentItemVH.itemView, paramMetaMaterial, paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < 4) {
      return 1;
    }
    int i = (int)Math.ceil(getItemCount() * 1.0F / 4.0F);
    if ((int)Math.ceil((paramInt + 1) * 1.0F / 4.0F) == i) {
      return 3;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.text.TextFancyMaterialPanelContentAdapter
 * JD-Core Version:    0.7.0.1
 */