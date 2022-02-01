package com.tencent.mobileqq.wink.editor.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel.EditMode;
import com.tencent.mobileqq.wink.editor.WinkTavCutDelegate;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BottomDashboardMenuPart
  extends Part
{
  private final String a = getClass().getSimpleName();
  private LinearLayout b;
  private WinkEditorViewModel c;
  
  private String a(MenuItem paramMenuItem)
  {
    switch (BottomDashboardMenuPart.1.a[paramMenuItem.ordinal()])
    {
    default: 
      return "";
    case 6: 
      return "em_xsj_template_button";
    case 5: 
      return "em_xsj_paste_button";
    case 4: 
      return "em_xsj_char_button";
    case 3: 
      return "em_xsj_filter_button";
    case 2: 
      return "em_xsj_transpic_button";
    }
    return "em_xsj_transvideo_button";
  }
  
  private void a(View paramView, String paramString)
  {
    VideoReport.setElementId(paramView, paramString);
    Map localMap = WinkDTParamBuilder.buildElementParams();
    localMap.put("xsj_camera_clck_ref_pgid", WinkDatongCurrentParams.params.get("xsj_camera_clck_ref_pgid"));
    if (paramString.equals("em_xsj_transvideo_button")) {
      localMap.put("xsj_custom_pgid", "pg_xsj_pic_edit_page");
    } else if (paramString.equals("em_xsj_transpic_button")) {
      localMap.put("xsj_custom_pgid", "pg_xsj_edit_page");
    }
    VideoReport.setElementParams(paramView, localMap);
    VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_ALL);
  }
  
  private void a(MenuType paramMenuType)
  {
    MenuType localMenuType = MenuType.TO_VIDEO;
    boolean bool = true;
    if ((paramMenuType == localMenuType) && (!AECameraPrefsUtil.a().b(AECameraPrefsUtil.u, false, 0)) && (d() != null) && (d().k())) {}
    try
    {
      AECameraPrefsUtil.a().a(AECameraPrefsUtil.u, true, 0);
      DialogUtil.a(g(), 230).setMessage(g().getResources().getString(2131914003)).setPositiveButton(g().getString(2131914002), new -..Lambda.BottomDashboardMenuPart.NPQnNZ89f3bskN1nKmgEd7uhRyE(this, paramMenuType)).setNegativeButton(g().getString(2131914001), -..Lambda.BottomDashboardMenuPart.AtKEEyp0beaYfBxT4zivmax9EEQ.INSTANCE).show();
      return;
    }
    catch (Throwable paramMenuType) {}
    this.c.a(paramMenuType);
    if (this.c.n() != WinkEditorViewModel.EditMode.Video) {
      bool = false;
    }
    b(bool);
    return;
  }
  
  private void b(boolean paramBoolean)
  {
    VideoReport.addToDetectionWhitelist(c());
    String str1;
    if (paramBoolean) {
      str1 = "pg_xsj_edit_page";
    } else {
      str1 = "pg_xsj_pic_edit_page";
    }
    VideoReport.setPageId(F(), str1);
    VideoReport.setPageParams(F(), new WinkDTParamBuilder().buildPageParams(null));
    String str2 = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDaTongRegister subPage: ");
    localStringBuilder.append(a());
    localStringBuilder.append(", pageId: ");
    localStringBuilder.append(str1);
    QLog.i(str2, 1, localStringBuilder.toString());
  }
  
  private WinkTavCutDelegate d()
  {
    if ((j() instanceof WinkEditorFragment)) {
      return ((WinkEditorFragment)j()).h();
    }
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((LinearLayout)paramView.findViewById(2131429627));
    this.c = ((WinkEditorViewModel)a(WinkEditorViewModel.class));
    boolean bool;
    if (this.c.n() == WinkEditorViewModel.EditMode.Video) {
      bool = true;
    } else {
      bool = false;
    }
    b(bool);
  }
  
  public void a(List<MenuItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (paramList.size() > 5) {
      i = DisplayUtil.a(g(), 20.0F);
    } else {
      i = DisplayUtil.a(g(), 26.0F);
    }
    this.b.setPadding(i, 0, i, 0);
    this.b.removeAllViews();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = (MenuItem)paramList.get(i);
      View localView = LayoutInflater.from(g()).inflate(2131628238, this.b, false);
      ((TextView)localView.findViewById(2131438102)).setText(localMenuItem.getName());
      ((ImageView)localView.findViewById(2131438099)).setImageResource(localMenuItem.getIcon());
      localView.setOnClickListener(new -..Lambda.BottomDashboardMenuPart.jMfXom4s9a0OeGRyWEhOplX_XVU(this, localMenuItem));
      this.b.addView(localView, new LinearLayout.LayoutParams(-2, -1));
      if (i != j - 1) {
        this.b.addView(new View(g()), new LinearLayout.LayoutParams(0, -1, 1.0F));
      }
      a(localView, a(localMenuItem));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.menu.BottomDashboardMenuPart
 * JD-Core Version:    0.7.0.1
 */