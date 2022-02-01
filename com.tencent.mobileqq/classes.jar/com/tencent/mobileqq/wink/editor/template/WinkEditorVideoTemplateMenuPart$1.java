package com.tencent.mobileqq.wink.editor.template;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.WinkMapReport;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.flow.ApplyMaterialOnlineTask;
import com.tencent.mobileqq.wink.view.WinkMaterialPanel;

class WinkEditorVideoTemplateMenuPart$1
  extends ApplyMaterialOnlineTask
{
  WinkEditorVideoTemplateMenuPart$1(WinkEditorVideoTemplateMenuPart paramWinkEditorVideoTemplateMenuPart) {}
  
  public void e(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if (WinkEditorVideoTemplateMenuPart.a(this.a)) {
      return;
    }
    WinkEditorVideoTemplateMenuPart.b(this.a).setClearButtonEnable(true);
    WinkEditorVideoTemplateMenuPart.c(this.a).a(paramInt);
    if (TextUtils.isEmpty(paramMetaMaterial.packageUrl))
    {
      WinkEditorVideoTemplateMenuPart.c(this.a).notifyDataSetChanged();
      return;
    }
    String str = WinkEditorResourceManager.c().a(paramMetaMaterial);
    if (!WinkEditorVideoTemplateMenuPart.a(this.a, str))
    {
      if (!NetworkUtil.isNetworkAvailable())
      {
        QQToast.makeText(this.a.g(), 1, this.a.g().getString(2131886354), 0).show();
        WinkEditorVideoTemplateMenuPart.c(this.a).a(-1);
        WinkEditorVideoTemplateMenuPart.c(this.a).notifyDataSetChanged();
        WinkEditorVideoTemplateMenuPart.a(this.a, null);
        return;
      }
      WinkEditorVideoTemplateMenuPart.b(this.a, paramMetaMaterial);
      WinkEditorResourceManager.c().a(paramMetaMaterial, new WinkEditorVideoTemplateMenuPart.1.1(this, paramMetaMaterial));
      return;
    }
    MetaMaterialKt.d(paramMetaMaterial, WinkEditorResourceManager.c().a(paramMetaMaterial));
    WinkEditorVideoTemplateMenuPart.a(this.a, paramMetaMaterial);
    WinkMapReport.a().a(paramMetaMaterial.id, "video", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.1
 * JD-Core Version:    0.7.0.1
 */