package com.tencent.mobileqq.wink.editor.template;

import android.os.Handler;
import android.os.Looper;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.ResDownLoadListener;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.WinkMapReport;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import mqq.os.MqqHandler;

class WinkEditorVideoTemplateMenuPart$1$1
  implements WinkEditorResourceDownloader.ResDownLoadListener
{
  WinkEditorVideoTemplateMenuPart$1$1(WinkEditorVideoTemplateMenuPart.1 param1, MetaMaterial paramMetaMaterial) {}
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 100)) {
      ThreadManager.getUIHandler().post(new -..Lambda.WinkEditorVideoTemplateMenuPart.1.1.Uhdy1w-TRiVIgSno5LvHZPSo71c(this, paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (WinkEditorVideoTemplateMenuPart.d(this.b.a))
    {
      WinkEditorVideoTemplateMenuPart.a(this.b.a, false);
      return;
    }
    if (paramBoolean)
    {
      MetaMaterialKt.d(this.a, WinkEditorResourceManager.c().a(this.a));
      WinkEditorVideoTemplateMenuPart.a(this.b.a, this.a);
      WinkMapReport.a().a(this.a.id, "video", "0");
    }
    else
    {
      new Handler(Looper.getMainLooper()).post(new -..Lambda.WinkEditorVideoTemplateMenuPart.1.1.bYUF_EFhzFbTbs1pUFbW7ZsskYs(this));
    }
    ThreadManager.getUIHandler().post(new -..Lambda.WinkEditorVideoTemplateMenuPart.1.1.Kh8IiCN7zduajxi6t9IGrLob1ac(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart.1.1
 * JD-Core Version:    0.7.0.1
 */