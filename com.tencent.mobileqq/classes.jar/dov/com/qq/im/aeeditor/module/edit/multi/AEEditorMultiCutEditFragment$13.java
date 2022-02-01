package dov.com.qq.im.aeeditor.module.edit.multi;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.entry.AECameraLauncher;
import dov.com.qq.im.ae.entry.AELaunchParamsBuilder;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import dov.com.qq.im.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import java.util.List;

class AEEditorMultiCutEditFragment$13
  implements View.OnClickListener
{
  AEEditorMultiCutEditFragment$13(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (AEFastClickThrottle.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AEBaseDataReporter.a().z();
      AEReportUtils.m();
      if (AEEditorMultiCutEditFragment.a(this.a).size() >= 30)
      {
        QQToast.a(this.a.getActivity(), this.a.getResources().getString(2131689723, new Object[] { Integer.valueOf(30) }), 0).a();
      }
      else
      {
        if (AEEditorMultiCutEditFragment.a(this.a).a()) {
          AEEditorMultiCutEditFragment.a(this.a).b();
        }
        Object localObject = new AELaunchParamsBuilder().a(AECameraEntry.E).b(false).a(true);
        if (AEEditorMultiCutEditFragment.a(this.a) != null) {
          i = AEEditorMultiCutEditFragment.a(this.a).size();
        }
        localObject = ((AELaunchParamsBuilder)localObject).a(i).a();
        AECameraLauncher.a(this.a.getActivity(), (Bundle)localObject, 1024);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.13
 * JD-Core Version:    0.7.0.1
 */