import android.os.Handler;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nhy
  implements GetUserInfoHandler.OnGetUserInfoCallback
{
  public nhy(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "Update UserItems %s", paramUpdateUserInfoEvent);
    this.a.a.post(new nhz(this, paramUpdateUserInfoEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhy
 * JD-Core Version:    0.7.0.1
 */