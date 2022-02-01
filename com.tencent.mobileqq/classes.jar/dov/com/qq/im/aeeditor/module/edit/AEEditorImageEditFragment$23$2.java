package dov.com.qq.im.aeeditor.module.edit;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.ae.util.AEQLog;

class AEEditorImageEditFragment$23$2
  implements Runnable
{
  AEEditorImageEditFragment$23$2(AEEditorImageEditFragment.23 param23) {}
  
  public void run()
  {
    if (this.a.a.getActivity() == null)
    {
      AEQLog.d("AEEditorImageEditFragment", "[onExportComplete], activity == null");
      return;
    }
    this.a.a.b();
    QQToast.a(this.a.a.getActivity(), "导出成功", 0).a();
    Intent localIntent = new Intent();
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", AEEditorImageEditFragment.a(this.a.a, AEEditorImageEditFragment.b(this.a.a)));
    localIntent.putExtra("PhotoConst.PHOTO_PATHS", AEEditorImageEditFragment.b(this.a.a));
    this.a.a.getActivity().setResult(-1, localIntent);
    this.a.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.23.2
 * JD-Core Version:    0.7.0.1
 */