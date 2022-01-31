import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest.MsgTabNodeListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class nia
  implements CmdTaskManger.CommandCallback
{
  public nia(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  public void a(@NonNull MsgTabNodeListRequest arg1, @Nullable MsgTabNodeListRequest.MsgTabNodeListResponse paramMsgTabNodeListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramMsgTabNodeListResponse == null))
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() get latest failed: %s", paramErrorMessage.getErrorMessage());
      this.a.a(false);
      if (this.a.a()) {
        this.a.a(new ArrayList(this.a.jdField_a_of_type_JavaUtilArrayList), true, this.a.jdField_a_of_type_Boolean, true);
      }
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    this.a.a(true);
    this.a.g = paramMsgTabNodeListResponse.jdField_a_of_type_Boolean;
    if (TextUtils.equals(this.a.b, paramMsgTabNodeListResponse.jdField_a_of_type_JavaLangString))
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() seq(%s) equals, sort only, mData size=%d", this.a.b, Integer.valueOf(this.a.jdField_a_of_type_JavaUtilArrayList.size()));
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        Collections.sort(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_JavaUtilComparator);
        this.a.a();
        MsgTabNodeListLoader.a(this.a, this.a.jdField_a_of_type_JavaUtilArrayList);
        MsgTabNodeListLoader.a(this.a, this.a.jdField_a_of_type_JavaUtilArrayList);
        this.a.a(this.a.jdField_a_of_type_JavaUtilArrayList, true, this.a.jdField_a_of_type_Boolean, false);
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.a.d();
        return;
      }
    }
    new ArrayList();
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin syncLocalReadStatus() of nodeList, size = %d", Integer.valueOf(paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size()));
      int i = 0;
      while (i < paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size())
      {
        MsgTabNodeListLoader.a(this.a, (MsgTabNodeInfo)paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end syncLocalReadStatus() of nodeList");
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin replace mData with response, and sort data");
      this.a.b = paramMsgTabNodeListResponse.jdField_a_of_type_JavaLangString;
      this.a.jdField_a_of_type_JavaLangString = paramMsgTabNodeListResponse.c;
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
      this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList);
      MsgTabNodeListLoader.a(this.a, this.a.jdField_a_of_type_JavaUtilArrayList);
      Collections.sort(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_JavaUtilComparator);
      this.a.jdField_a_of_type_Boolean = paramMsgTabNodeListResponse.b;
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end replace mData with response");
      this.a.a();
      MsgTabNodeListLoader.a(this.a);
      this.a.a(false, false);
      paramMsgTabNodeListResponse = new ArrayList(this.a.jdField_a_of_type_JavaUtilArrayList);
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin save changedData(mData) to DB");
      this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(paramMsgTabNodeListResponse, true);
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end save changedData(mData) to DB");
      MsgTabNodeListLoader.a(this.a, paramMsgTabNodeListResponse);
      this.a.a(paramMsgTabNodeListResponse, true, this.a.jdField_a_of_type_Boolean, false);
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.a.d();
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() return, mData.size() = %d", Integer.valueOf(paramMsgTabNodeListResponse.size()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nia
 * JD-Core Version:    0.7.0.1
 */