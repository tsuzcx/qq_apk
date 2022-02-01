package com.tencent.mobileqq.wink.editor.text;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
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

public class TextFontMaterialPanelContentAdapter
  extends WinkMaterialPanelContentAdapter
{
  private void a(View paramView, String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    VideoReport.setElementId(paramView, paramString1);
    VideoReport.setElementReuseIdentifier(paramView, paramString2);
    paramString1 = WinkDTParamBuilder.buildElementParams();
    paramString1.putAll(paramMap);
    VideoReport.setElementParams(paramView, paramString1);
    VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
  }
  
  protected WinkMaterialPanelContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new TextContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628264, paramViewGroup, false));
  }
  
  protected void a(WinkMaterialPanelContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    super.a(paramContentItemVH, paramInt, paramMetaMaterial);
    paramContentItemVH.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    if ((paramContentItemVH instanceof TextContentItemVH)) {
      if (!TextUtils.isEmpty(MetaMaterialKt.i(paramMetaMaterial))) {
        ((TextContentItemVH)paramContentItemVH).a.setText(MetaMaterialKt.i(paramMetaMaterial));
      } else {
        ((TextContentItemVH)paramContentItemVH).a.setText("");
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("xsj_char_form_name", paramMetaMaterial.id);
    WinkDatongCurrentParams.put("xsj_char_form_name", paramMetaMaterial.id);
    a(paramContentItemVH.itemView, "em_xsj_char_form_item", localHashMap, String.valueOf(paramMetaMaterial.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.text.TextFontMaterialPanelContentAdapter
 * JD-Core Version:    0.7.0.1
 */