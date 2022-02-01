package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;

class EditVideoButton$2
  implements ModuleDownloadListener
{
  EditVideoButton$2(EditVideoButton paramEditVideoButton) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QLog.i("Q.qqstory.record.EditVideoButton", 2, "onDownloadCanceled " + paramString);
  }
  
  public void onDownloadFailed(String paramString)
  {
    QLog.i("Q.qqstory.record.EditVideoButton", 2, "onDownloadFailed " + paramString);
    if ((this.a.a != null) && (this.a.a.getActivity() != null)) {
      this.a.a.getActivity().runOnUiThread(new EditVideoButton.2.2(this));
    }
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("cyber_clink_version_2.jar")) {}
    while ((this.a.a == null) || (this.a.a.getActivity() == null)) {
      return;
    }
    this.a.a.getActivity().runOnUiThread(new EditVideoButton.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoButton.2
 * JD-Core Version:    0.7.0.1
 */