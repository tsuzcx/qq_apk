import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest.MsgTabNodeListResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class nib
  implements CmdTaskManger.CommandCallback
{
  public nib(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  public void a(@NonNull MsgTabNodeListRequest arg1, @Nullable MsgTabNodeListRequest.MsgTabNodeListResponse paramMsgTabNodeListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramMsgTabNodeListResponse == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "get next failed:" + paramErrorMessage.getErrorMessage());
      }
      this.a.b(false);
      if (this.a.a()) {
        this.a.a(new ArrayList(this.a.jdField_a_of_type_JavaUtilArrayList), true, this.a.jdField_a_of_type_Boolean, true);
      }
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    this.a.b(true);
    paramErrorMessage = new ArrayList();
    for (;;)
    {
      MsgTabNodeInfo localMsgTabNodeInfo1;
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_JavaLangString = paramMsgTabNodeListResponse.c;
        int i = 0;
        if (i < paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size())
        {
          MsgTabNodeListLoader.a(this.a, (MsgTabNodeInfo)paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
        }
        Iterator localIterator = paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localMsgTabNodeInfo1 = (MsgTabNodeInfo)localIterator.next();
        if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(localMsgTabNodeInfo1))
        {
          if (localMsgTabNodeInfo1.a != 5) {
            continue;
          }
          i = this.a.jdField_a_of_type_JavaUtilArrayList.indexOf(localMsgTabNodeInfo1);
          MsgTabNodeInfo localMsgTabNodeInfo2 = (MsgTabNodeInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(i);
          this.a.jdField_a_of_type_JavaUtilArrayList.remove(i);
          if (localMsgTabNodeInfo2.c > 0) {
            localMsgTabNodeInfo1.a(localMsgTabNodeInfo2);
          }
          this.a.jdField_a_of_type_JavaUtilArrayList.add(i, localMsgTabNodeInfo1);
          this.a.a(localMsgTabNodeInfo1, false, 2, false);
        }
      }
      this.a.jdField_a_of_type_JavaUtilArrayList.add(localMsgTabNodeInfo1);
      paramErrorMessage.add(localMsgTabNodeInfo1);
    }
    this.a.jdField_a_of_type_Boolean = paramMsgTabNodeListResponse.b;
    this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(paramErrorMessage, false);
    if (this.a.a()) {
      this.a.a(new ArrayList(this.a.jdField_a_of_type_JavaUtilArrayList), true, this.a.jdField_a_of_type_Boolean, true);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "get next data size=" + this.a.jdField_a_of_type_JavaUtilArrayList.size() + ", rsp size=" + paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      if (paramErrorMessage.size() > 0) {
        this.a.a(paramErrorMessage, false, this.a.jdField_a_of_type_Boolean, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nib
 * JD-Core Version:    0.7.0.1
 */