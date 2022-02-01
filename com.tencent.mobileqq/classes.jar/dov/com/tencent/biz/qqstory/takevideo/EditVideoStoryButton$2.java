package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.editipc.PeakIpcController.IUploadArkVideoCallback;
import mqq.os.MqqHandler;

class EditVideoStoryButton$2
  implements PeakIpcController.IUploadArkVideoCallback
{
  EditVideoStoryButton$2(EditVideoStoryButton paramEditVideoStoryButton) {}
  
  public void a()
  {
    AEQLog.d("EditVideoStoryButton", "uploadArkVideo---onFail:");
    ThreadManager.getUIHandler().post(new EditVideoStoryButton.2.2(this));
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new EditVideoStoryButton.2.4(this, paramInt));
  }
  
  public void a(String paramString)
  {
    AEQLog.b("EditVideoStoryButton", "uploadArkVideo---onSuccess: videoDownLoadUrl=" + paramString);
    ThreadManager.getUIHandler().post(new EditVideoStoryButton.2.1(this));
  }
  
  public void b()
  {
    AEQLog.b("EditVideoStoryButton", "uploadArkVideo---onCancel:");
    ThreadManager.getUIHandler().post(new EditVideoStoryButton.2.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.2
 * JD-Core Version:    0.7.0.1
 */