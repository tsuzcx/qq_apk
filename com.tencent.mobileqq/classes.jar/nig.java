import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.network.QQStoryGuideRequest;
import com.tencent.biz.qqstory.msgTabNode.network.QQStoryGuideRequest.QQStoryGuideResponse;
import com.tencent.qphone.base.util.QLog;

public class nig
  implements CmdTaskManger.CommandCallback
{
  public nig(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  public void a(@NonNull QQStoryGuideRequest paramQQStoryGuideRequest, @Nullable QQStoryGuideRequest.QQStoryGuideResponse paramQQStoryGuideResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestQQStoryGuide onCmdRespond = " + paramQQStoryGuideResponse + " ,errorMsg = " + paramErrorMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nig
 * JD-Core Version:    0.7.0.1
 */