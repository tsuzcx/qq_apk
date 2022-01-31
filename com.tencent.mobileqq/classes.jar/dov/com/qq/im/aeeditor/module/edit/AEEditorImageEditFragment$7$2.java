package dov.com.qq.im.aeeditor.module.edit;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import blin;
import com.tencent.mobileqq.widget.QQToast;

public class AEEditorImageEditFragment$7$2
  implements Runnable
{
  public AEEditorImageEditFragment$7$2(blin paramblin) {}
  
  public void run()
  {
    this.a.a.b();
    QQToast.a(this.a.a.getActivity(), "导出成功", 0).a();
    Intent localIntent = new Intent();
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", AEEditorImageEditFragment.a(this.a.a, AEEditorImageEditFragment.b(this.a.a)));
    localIntent.putExtra("PhotoConst.PHOTO_PATHS", AEEditorImageEditFragment.b(this.a.a));
    this.a.a.getActivity().setResult(-1, localIntent);
    this.a.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7.2
 * JD-Core Version:    0.7.0.1
 */