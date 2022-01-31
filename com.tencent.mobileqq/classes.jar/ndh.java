import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider.DataProviderListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ndh
  implements MsgTabVideoPreloaderDataProvider.DataProviderListener
{
  public ndh(MsgTabStoryVideoPreloader paramMsgTabStoryVideoPreloader) {}
  
  public void a(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo, Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MsgTabStoryVideoPreloader", 2, "MsgTabVideoPreloaderDataProvider load video info error", paramError);
    }
    this.a.b();
  }
  
  public void a(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo, @NonNull List paramList)
  {
    if (!paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "start download video list, list = " + paramList.size() + "\n" + paramList);
      }
      MsgTabStoryVideoPreloader.a(this.a, paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MsgTabStoryVideoPreloader", 2, "can not find first unread video");
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndh
 * JD-Core Version:    0.7.0.1
 */