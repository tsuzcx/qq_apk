import android.os.Bundle;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.RspStoryMessageList;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.storyHome.messagenotify.MessageData;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class nwj
  extends ProtoUtils.StoryProtocolObserver
{
  public nwj(StoryMessageListActivity paramStoryMessageListActivity)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "fetch message list result, code=" + paramInt);
    }
    paramBundle = new qqstory_struct.ErrorInfo();
    qqstory_710_message.RspStoryMessageList localRspStoryMessageList;
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        localRspStoryMessageList = new qqstory_710_message.RspStoryMessageList();
        localRspStoryMessageList.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_710_message.ErrorInfo)localRspStoryMessageList.errinfo.get();
        paramBundle.error_code.set(paramArrayOfByte.error_code.get());
        paramBundle.error_desc.set(paramArrayOfByte.error_desc.get());
        if ((localRspStoryMessageList.errinfo.error_code.has()) && (localRspStoryMessageList.errinfo.error_code.get() == 0))
        {
          paramArrayOfByte = new ArrayList(localRspStoryMessageList.message_num.get());
          Iterator localIterator = localRspStoryMessageList.message_list.get().iterator();
          while (localIterator.hasNext()) {
            paramArrayOfByte.add(new MessageData((qqstory_710_message.StoryMessage)localIterator.next()));
          }
        }
        ThreadManager.getUIHandler().post(new nwl(this));
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "parse RspStoryMessageList error", paramArrayOfByte);
        }
      }
    } else {
      return paramBundle;
    }
    ThreadManager.getUIHandler().post(new nwk(this, paramArrayOfByte, localRspStoryMessageList));
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwj
 * JD-Core Version:    0.7.0.1
 */