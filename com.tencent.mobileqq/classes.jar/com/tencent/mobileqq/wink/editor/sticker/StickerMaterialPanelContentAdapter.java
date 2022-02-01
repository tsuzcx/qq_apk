package com.tencent.mobileqq.wink.editor.sticker;

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

public class StickerMaterialPanelContentAdapter
  extends WinkMaterialPanelContentAdapter
{
  private final int a;
  private final int b;
  private final int c;
  private int d;
  
  public StickerMaterialPanelContentAdapter(@NonNull Context paramContext)
  {
    super(paramContext, 2);
    this.a = DisplayUtil.a(paramContext, 14.0F);
    this.b = DisplayUtil.a(paramContext, 24.0F);
    this.c = DisplayUtil.a(paramContext, 12.0F);
  }
  
  private void a(View paramView, String paramString1, Map<String, Object> paramMap, String paramString2)
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
    WinkMaterialPanelContentAdapter.ContentItemVH localContentItemVH = new WinkMaterialPanelContentAdapter.ContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628262, paramViewGroup, false));
    if (this.d == 0) {
      this.d = ((paramViewGroup.getWidth() - this.b * 2) / 4);
    }
    paramViewGroup = (RecyclerView.LayoutParams)localContentItemVH.itemView.getLayoutParams();
    int i = this.d;
    paramViewGroup.width = i;
    paramViewGroup.height = i;
    paramInt &= 0xF;
    if (paramInt == 1)
    {
      paramViewGroup.topMargin = this.a;
      paramViewGroup.bottomMargin = this.c;
    }
    else if (paramInt == 3)
    {
      paramViewGroup.topMargin = 0;
      paramViewGroup.bottomMargin = this.c;
    }
    else
    {
      paramViewGroup.topMargin = 0;
      paramViewGroup.bottomMargin = this.c;
    }
    localContentItemVH.itemView.setScaleX(0.8F);
    localContentItemVH.itemView.setScaleY(0.8F);
    return localContentItemVH;
  }
  
  protected void a(WinkMaterialPanelContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    super.a(paramContentItemVH, paramInt, paramMetaMaterial);
    HashMap localHashMap = new HashMap();
    localHashMap.put("xsj_paste_name", paramMetaMaterial.id);
    localHashMap.put("xsj_paste_category", MetaMaterialKt.d(paramMetaMaterial));
    WinkDatongCurrentParams.put("xsj_paste_name", paramMetaMaterial.id);
    a(paramContentItemVH.itemView, "em_xsj_paste_item", localHashMap, String.valueOf(paramMetaMaterial.hashCode()));
  }
  
  public int getItemViewType(int paramInt)
  {
    int i;
    if (paramInt < 4)
    {
      i = 1;
    }
    else
    {
      i = (int)Math.ceil(getItemCount() * 1.0F / 4.0F);
      if ((int)Math.ceil((paramInt + 1) * 1.0F / 4.0F) == i) {
        i = 3;
      } else {
        i = 2;
      }
    }
    if (paramInt % 4 == 0) {
      return i | 0x10;
    }
    if ((paramInt + 1) % 4 == 0) {
      return i | 0x30;
    }
    return i | 0x20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.StickerMaterialPanelContentAdapter
 * JD-Core Version:    0.7.0.1
 */