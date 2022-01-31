import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller.OnFinishCallBack;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class nhc
  implements IVidToVideoInfoPuller.OnFinishCallBack
{
  nhc(nhb paramnhb) {}
  
  public void a(List paramList, boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new nhd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhc
 * JD-Core Version:    0.7.0.1
 */