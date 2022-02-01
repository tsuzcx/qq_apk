package dov.com.qq.im.aeeditor.module.edit.multi;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import java.util.List;

class AEEditorMultiCutEditFragment$14
  implements View.OnClickListener
{
  AEEditorMultiCutEditFragment$14(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  @RequiresApi(api=16)
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AEBaseDataReporter.a().A();
      AEReportUtils.n();
      if (this.a.a != null)
      {
        CutModelKt localCutModelKt = this.a.a.a();
        if (localCutModelKt != null) {
          if (AEEditorMultiCutEditFragment.a(this.a).size() == 1)
          {
            QQToast.a(this.a.getActivity(), 2131689720, 0).a();
          }
          else
          {
            FragmentActivity localFragmentActivity = this.a.getActivity();
            QQCustomDialog localQQCustomDialog = DialogUtil.a(localFragmentActivity, 230);
            localQQCustomDialog.setTitle(localFragmentActivity.getString(2131689719));
            localQQCustomDialog.setMessage(localFragmentActivity.getString(2131689718));
            localQQCustomDialog.setPositiveButton(localFragmentActivity.getString(2131689748), new AEEditorMultiCutEditFragment.14.1(this, localCutModelKt));
            localQQCustomDialog.setNegativeButton(localFragmentActivity.getString(2131689713), new AEEditorMultiCutEditFragment.14.2(this));
            if (localQQCustomDialog != null) {
              try
              {
                if (!localQQCustomDialog.isShowing()) {
                  localQQCustomDialog.show();
                }
              }
              catch (Throwable localThrowable) {}
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.14
 * JD-Core Version:    0.7.0.1
 */