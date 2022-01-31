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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class ncr
  implements CmdTaskManger.CommandCallback
{
  public ncr(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  public void a(@NonNull MsgTabNodeListRequest arg1, @Nullable MsgTabNodeListRequest.MsgTabNodeListResponse paramMsgTabNodeListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramMsgTabNodeListResponse == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.nodeList", 2, "get latest failed:" + paramErrorMessage.getErrorMessage());
      }
      this.a.a(false);
      if (this.a.a()) {
        this.a.a(new ArrayList(this.a.jdField_a_of_type_JavaUtilArrayList), true, this.a.jdField_a_of_type_Boolean, true);
      }
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    for (;;)
    {
      return;
      this.a.a(true);
      if (TextUtils.equals(this.a.b, paramMsgTabNodeListResponse.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.msgTab.nodeList", 2, "not change, sort only");
        }
        synchronized (this.a.jdField_a_of_type_JavaLangObject)
        {
          Collections.sort(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_JavaUtilComparator);
          this.a.a();
          this.a.a(new ArrayList(this.a.jdField_a_of_type_JavaUtilArrayList), true, this.a.jdField_a_of_type_Boolean, false);
          this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          return;
        }
      }
      ??? = this.a.jdField_a_of_type_JavaLangObject;
      int i = 0;
      try
      {
        while (i < paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size())
        {
          MsgTabNodeListLoader.a(this.a, (MsgTabNodeInfo)paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
        }
        this.a.b = paramMsgTabNodeListResponse.jdField_a_of_type_JavaLangString;
        this.a.jdField_a_of_type_JavaLangString = paramMsgTabNodeListResponse.c;
        this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList);
        Collections.sort(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_JavaUtilComparator);
        this.a.jdField_a_of_type_Boolean = paramMsgTabNodeListResponse.jdField_a_of_type_Boolean;
        this.a.a();
        MsgTabNodeListLoader.a(this.a);
        this.a.a(false, false);
        ??? = new ArrayList(this.a.jdField_a_of_type_JavaUtilArrayList);
        this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(???, true);
        this.a.a(???, true, this.a.jdField_a_of_type_Boolean, false);
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.qqstory.msgTab.nodeList", 2, "get latest data size=" + this.a.jdField_a_of_type_JavaUtilArrayList.size());
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncr
 * JD-Core Version:    0.7.0.1
 */