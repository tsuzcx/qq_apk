package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.editipc.PeakIpcController.IUploadArkVideoCallback;
import mqq.os.MqqHandler;

class EditVideoPartManager$11
  implements PeakIpcController.IUploadArkVideoCallback
{
  EditVideoPartManager$11(EditVideoPartManager paramEditVideoPartManager) {}
  
  public void a()
  {
    AEQLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---onFail:");
    ThreadManager.getUIHandler().post(new EditVideoPartManager.11.2(this));
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new EditVideoPartManager.11.4(this, paramInt));
  }
  
  public void a(String paramString)
  {
    AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---onSuccess: videoDownLoadUrl=" + paramString);
    ThreadManager.getUIHandler().post(new EditVideoPartManager.11.1(this));
  }
  
  public void b()
  {
    AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---onCancel:");
    ThreadManager.getUIHandler().post(new EditVideoPartManager.11.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.11
 * JD-Core Version:    0.7.0.1
 */