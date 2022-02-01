import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.av.chatroom.ChatRoomMng.2;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.NewIntent;
import tencent.av.chatroom.chatroom_sso.Msg;
import tencent.av.chatroom.chatroom_sso.PushMsg;
import tencent.av.chatroom.chatroom_sso.ReqGetMsg;
import tencent.av.chatroom.chatroom_sso.ReqSendMsg;
import tencent.av.chatroom.chatroom_sso.RoomKey;
import tencent.av.chatroom.chatroom_sso.RspGetMsg;
import tencent.av.chatroom.chatroom_sso.RspSendMsg;

public class lkf
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = 0;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Comparator<lkh> jdField_a_of_type_JavaUtilComparator = new lkg(this);
  private final ConcurrentHashMap<ChatRoomInfo, ConcurrentLinkedQueue<lkh>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final ConcurrentLinkedQueue<ChatRoomInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private final ConcurrentLinkedQueue<lki> b = new ConcurrentLinkedQueue();
  
  public lkf(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private ChatRoomInfo a(chatroom_sso.RoomKey paramRoomKey)
  {
    Object localObject1 = lbz.a().a();
    int i = ((lfe)localObject1).e();
    long l5 = ((lfe)localObject1).a();
    long l3 = ((lfe)localObject1).b();
    long l4 = ((lfe)localObject1).g();
    long l2 = l4;
    long l1 = l3;
    Object localObject2;
    if (i == paramRoomKey.type.get())
    {
      l2 = l4;
      l1 = l3;
      if (l5 == paramRoomKey.id.get())
      {
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (localObject2 != null) {
          ((VideoController)localObject2).a("pushMsg", (lfe)localObject1);
        }
        l1 = ((lfe)localObject1).b();
        l2 = ((lfe)localObject1).g();
      }
    }
    if ((i == paramRoomKey.type.get()) && (l5 == paramRoomKey.id.get()) && (l1 == paramRoomKey.room_id.get()) && (l2 == paramRoomKey.create_ts.get())) {}
    for (localObject1 = a((lfe)localObject1);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (ChatRoomInfo)localIterator.next();
        } while ((localObject2 == null) || (((ChatRoomInfo)localObject2).jdField_a_of_type_Int != paramRoomKey.type.get()) || (((ChatRoomInfo)localObject2).jdField_b_of_type_Long != paramRoomKey.id.get()) || (((ChatRoomInfo)localObject2).jdField_c_of_type_Long != paramRoomKey.create_ts.get()) || (((ChatRoomInfo)localObject2).jdField_a_of_type_Long == paramRoomKey.room_id.get()));
      }
      for (paramRoomKey = (chatroom_sso.RoomKey)localObject2;; paramRoomKey = null)
      {
        if (paramRoomKey != localObject1) {
          a(paramRoomKey);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomMng", 2, "checkFromPushMsg, curRoomInfo[" + localObject1 + "]");
        }
        return localObject1;
      }
    }
  }
  
  private ConcurrentLinkedQueue<lkh> a(ChatRoomInfo paramChatRoomInfo)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramChatRoomInfo);
    ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
    if (localConcurrentLinkedQueue2 == null)
    {
      localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramChatRoomInfo, localConcurrentLinkedQueue1);
    }
    return localConcurrentLinkedQueue1;
  }
  
  private void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    this.jdField_a_of_type_Int |= paramInt;
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1, paramChatRoomInfo))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramChatRoomInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  private void a(ChatRoomInfo paramChatRoomInfo, long paramLong)
  {
    if (paramChatRoomInfo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomMng", 2, "doRetryGetMsgList, room[" + paramChatRoomInfo + "], retryDelay[" + paramLong + "], canRetry[" + paramChatRoomInfo.a() + "]");
      }
      paramLong = Math.max(paramLong, 1000L);
    } while (!paramChatRoomInfo.a());
    Message localMessage = Message.obtain();
    localMessage.obj = paramChatRoomInfo;
    localMessage.what = 3;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(lkh paramlkh)
  {
    if ((paramlkh == null) || (paramlkh.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo == null)) {}
    ChatRoomInfo localChatRoomInfo;
    do
    {
      return;
      localChatRoomInfo = paramlkh.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo;
      long l1 = 0L;
      try
      {
        l2 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        l1 = l2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          long l2;
          Object localObject;
          chatroom_sso.Msg localMsg;
          chatroom_sso.ReqSendMsg localReqSendMsg;
          QLog.i("ChatRoomMng", 1, "sendMsg get self uin fail.", localThrowable);
        }
      }
      l2 = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomMng", 2, "sendMsg, seq[" + l2 + "], room[" + localChatRoomInfo + "], msg[" + paramlkh + "]");
      }
      paramlkh.a();
      localObject = new chatroom_sso.RoomKey();
      ((chatroom_sso.RoomKey)localObject).type.set(localChatRoomInfo.jdField_a_of_type_Int);
      ((chatroom_sso.RoomKey)localObject).room_id.set(localChatRoomInfo.jdField_a_of_type_Long);
      ((chatroom_sso.RoomKey)localObject).id.set(localChatRoomInfo.jdField_b_of_type_Long);
      ((chatroom_sso.RoomKey)localObject).create_ts.set((int)localChatRoomInfo.jdField_c_of_type_Long);
      localMsg = new chatroom_sso.Msg();
      localMsg.msg.set(paramlkh.jdField_a_of_type_JavaLangString);
      localMsg.uin.set(l1);
      localReqSendMsg = new chatroom_sso.ReqSendMsg();
      localReqSendMsg.room_key.set((MessageMicro)localObject);
      localReqSendMsg.msg.set(localMsg);
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
      ((NewIntent)localObject).putExtra("reqType", 21);
      ((NewIntent)localObject).putExtra("ssoCmd", "QQRTCSvc.chatroom_send_msg");
      ((NewIntent)localObject).putExtra("vMsg", localReqSendMsg.toByteArray());
      ((NewIntent)localObject).putExtra("room_key", localChatRoomInfo);
      ((NewIntent)localObject).putExtra("localSeq", paramlkh.jdField_b_of_type_Long);
      mur.a((Intent)localObject, l2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet((NewIntent)localObject);
    } while (paramlkh.e != lkh.jdField_a_of_type_Int);
    a(1, localChatRoomInfo);
  }
  
  private void b(lkh paramlkh)
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2, paramlkh))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.obj = paramlkh;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public ChatRoomInfo a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      ChatRoomInfo localChatRoomInfo = (ChatRoomInfo)localIterator.next();
      if ((localChatRoomInfo != null) && (localChatRoomInfo.a(paramInt, paramLong1, paramLong2, paramLong3))) {
        return localChatRoomInfo;
      }
    }
    return null;
  }
  
  public ChatRoomInfo a(lfe paramlfe)
  {
    ChatRoomInfo localChatRoomInfo = a(paramlfe, true);
    Object localObject;
    if (localChatRoomInfo != null)
    {
      localObject = (ConcurrentLinkedQueue)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localChatRoomInfo);
      if (localObject != null) {
        break label189;
      }
      localObject = new ConcurrentLinkedQueue();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localChatRoomInfo, localObject);
    }
    for (;;)
    {
      localObject = Message.obtain();
      ((Message)localObject).obj = localChatRoomInfo;
      ((Message)localObject).what = 3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      if ((QLog.isDevelopLevel()) && (paramlfe != null)) {
        QLog.i("ChatRoomMng", 4, "enterChatRoom, SessionType[" + paramlfe.jdField_d_of_type_Int + "], relationType[" + paramlfe.F + "], relationId[" + paramlfe.g + "], peerUin[" + paramlfe.jdField_d_of_type_JavaLangString + "], extraUin[" + paramlfe.f + "], isDoubleVideoMeeting[" + paramlfe.J + "], room[" + localChatRoomInfo + "]");
      }
      return localChatRoomInfo;
      label189:
      ((ConcurrentLinkedQueue)localObject).clear();
    }
  }
  
  public ChatRoomInfo a(lfe paramlfe, boolean paramBoolean)
  {
    Object localObject = null;
    int i;
    long l5;
    long l2;
    long l1;
    if (paramlfe != null)
    {
      i = paramlfe.e();
      l5 = paramlfe.a();
      long l3 = paramlfe.b();
      long l4 = paramlfe.g();
      l2 = l3;
      l1 = l4;
      if (paramBoolean) {
        if (l3 != 0L)
        {
          l2 = l3;
          l1 = l4;
          if (i == 1)
          {
            l2 = l3;
            l1 = l4;
            if (l4 != 0L) {}
          }
        }
        else
        {
          if (i != 2) {
            break label359;
          }
          VideoController.a().c();
        }
      }
    }
    for (;;)
    {
      l2 = paramlfe.b();
      l1 = paramlfe.g();
      ChatRoomInfo localChatRoomInfo2 = a(i, l2, l5, l1);
      localObject = localChatRoomInfo2;
      if (localChatRoomInfo2 == null)
      {
        localObject = localChatRoomInfo2;
        if (paramBoolean)
        {
          ChatRoomInfo localChatRoomInfo1 = localChatRoomInfo2;
          if (l2 != 0L)
          {
            localChatRoomInfo1 = localChatRoomInfo2;
            if (l5 != 0L)
            {
              localChatRoomInfo1 = localChatRoomInfo2;
              if (i != 0)
              {
                localChatRoomInfo1 = new ChatRoomInfo(i, l2, l5, l1);
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localChatRoomInfo1);
              }
            }
          }
          localObject = localChatRoomInfo1;
          if (QLog.isDevelopLevel())
          {
            QLog.i("ChatRoomMng", 4, "getRoomInfo, SessionType[" + paramlfe.jdField_d_of_type_Int + "], relationType[" + paramlfe.F + "], relationId[" + paramlfe.g + "], peerUin[" + paramlfe.jdField_d_of_type_JavaLangString + "], extraUin[" + paramlfe.f + "], isDoubleVideoMeeting[" + paramlfe.J + "], type[" + i + "], roomID[" + l2 + "], id[" + l5 + "], createTime[" + l1 + "], room[" + localChatRoomInfo1 + "]");
            localObject = localChatRoomInfo1;
          }
        }
      }
      return localObject;
      label359:
      if (i == 1) {
        VideoController.a().d();
      }
    }
  }
  
  public lkh a(ChatRoomInfo paramChatRoomInfo, long paramLong)
  {
    if (paramChatRoomInfo == null) {
      return null;
    }
    paramChatRoomInfo = a(paramChatRoomInfo);
    if ((paramChatRoomInfo != null) && (paramChatRoomInfo.size() > 0))
    {
      Iterator localIterator = paramChatRoomInfo.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramChatRoomInfo = (lkh)localIterator.next();
      } while ((paramChatRoomInfo == null) || (paramChatRoomInfo.jdField_b_of_type_Long != paramLong));
    }
    for (;;)
    {
      return paramChatRoomInfo;
      paramChatRoomInfo = null;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "clearObserver");
    }
    this.b.clear();
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt != 2) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatRoomMng", 4, "onReceivePushMsg params error.");
      }
      return;
    }
    localObject1 = null;
    Object localObject2 = new chatroom_sso.PushMsg();
    for (;;)
    {
      try
      {
        ((chatroom_sso.PushMsg)localObject2).mergeFrom(paramArrayOfByte);
        if (((chatroom_sso.PushMsg)localObject2).room_key.has())
        {
          paramArrayOfByte = (chatroom_sso.RoomKey)((chatroom_sso.PushMsg)localObject2).room_key.get();
          paramInt = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        ChatRoomInfo localChatRoomInfo;
        paramArrayOfByte = (byte[])localObject1;
        localObject1 = localInvalidProtocolBufferMicroException2;
        paramInt = 1;
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomMng", 2, "processAVChatRoomMsgPush parse fail.", (Throwable)localObject1);
        }
        Object localObject3 = null;
        localObject1 = paramArrayOfByte;
        paramArrayOfByte = localObject3;
        continue;
        int i = 4;
        paramInt = i;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("ChatRoomMng", 4, String.format("onReceivePushMsg, [type: %s, room_id: %s, id: %s, create_ts: %s", new Object[] { Integer.valueOf(((chatroom_sso.RoomKey)localObject1).type.get()), Long.valueOf(((chatroom_sso.RoomKey)localObject1).room_id.get()), Long.valueOf(((chatroom_sso.RoomKey)localObject1).id.get()), Integer.valueOf(((chatroom_sso.RoomKey)localObject1).create_ts.get()) }));
        paramInt = i;
        continue;
      }
      try
      {
        if (!((chatroom_sso.PushMsg)localObject2).msg.has()) {
          continue;
        }
        localObject1 = (chatroom_sso.Msg)((chatroom_sso.PushMsg)localObject2).msg.get();
        localObject2 = localObject1;
        localObject1 = paramArrayOfByte;
        paramArrayOfByte = (byte[])localObject2;
        if ((localObject1 == null) || (paramArrayOfByte == null)) {
          break label371;
        }
        localChatRoomInfo = a(((chatroom_sso.RoomKey)localObject1).type.get(), ((chatroom_sso.RoomKey)localObject1).room_id.get(), ((chatroom_sso.RoomKey)localObject1).id.get(), ((chatroom_sso.RoomKey)localObject1).create_ts.get());
        localObject2 = localChatRoomInfo;
        if (localChatRoomInfo == null) {
          localObject2 = a((chatroom_sso.RoomKey)localObject1);
        }
        if (localObject2 == null) {
          continue;
        }
        a((ChatRoomInfo)localObject2, paramArrayOfByte, true);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        continue;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatRoomMng", 2, "onReceivePushMsg, ret[" + paramInt + "]");
      return;
      paramArrayOfByte = null;
      paramInt = 2;
      continue;
      paramInt = 3;
      localObject1 = null;
    }
  }
  
  public void a(VideoController paramVideoController, lfe paramlfe)
  {
    ChatRoomInfo localChatRoomInfo2 = a(paramlfe, false);
    boolean bool = paramVideoController.a("onSwitchTerminalSuccess", paramlfe);
    ChatRoomInfo localChatRoomInfo1 = a(paramlfe, false);
    paramVideoController = localChatRoomInfo1;
    if (localChatRoomInfo1 == null) {
      paramVideoController = a(paramlfe);
    }
    if (paramVideoController != null)
    {
      if (localChatRoomInfo2 != paramVideoController) {
        a(localChatRoomInfo2);
      }
      paramVideoController.jdField_c_of_type_Boolean = true;
      if ((localChatRoomInfo2 != paramVideoController) && (localChatRoomInfo2 != null)) {
        paramVideoController.jdField_d_of_type_Long = localChatRoomInfo2.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3, paramVideoController);
      paramlfe = Message.obtain();
      paramlfe.obj = paramVideoController;
      paramlfe.what = 3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramlfe);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, String.format("onSwitchTerminalSuccess, ret[%s], pre[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), localChatRoomInfo2, paramVideoController }));
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramChatRoomInfo);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramChatRoomInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "removeChatRoom, room[" + paramChatRoomInfo + "]");
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, String paramString, long paramLong)
  {
    if ((paramChatRoomInfo == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("ChatRoomMng", 1, "sendMsg get self uin fail.", localThrowable);
      }
    }
    paramString = new lkh(paramChatRoomInfo, l1, paramString, paramLong, -9223372036854775808L, lkh.jdField_a_of_type_Int);
    a(paramChatRoomInfo).add(paramString);
    a(paramString);
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, List<lkh> paramList)
  {
    if ((paramChatRoomInfo == null) || (paramList == null)) {}
    do
    {
      return;
      paramChatRoomInfo = (ConcurrentLinkedQueue)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramChatRoomInfo);
      if ((paramChatRoomInfo != null) && (paramChatRoomInfo.size() > 0)) {
        paramList.addAll(paramChatRoomInfo);
      }
      try
      {
        Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
        return;
      }
      catch (Throwable paramChatRoomInfo) {}
    } while (!QLog.isDevelopLevel());
    QLog.i("ChatRoomMng", 4, "getChatRoomMsg", paramChatRoomInfo);
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, List<chatroom_sso.Msg> paramList, boolean paramBoolean)
  {
    if ((paramChatRoomInfo == null) || (paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatRoomMng", 4, "onRecvMsg, room[" + paramChatRoomInfo + "], size[" + paramList.size() + "]");
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        chatroom_sso.Msg localMsg = (chatroom_sso.Msg)paramList.next();
        if (localMsg != null) {
          a(paramChatRoomInfo, localMsg, paramBoolean);
        }
      }
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, chatroom_sso.Msg paramMsg, boolean paramBoolean)
  {
    if ((paramChatRoomInfo == null) || (paramMsg == null)) {
      return;
    }
    long l = paramMsg.uin.get();
    ConcurrentLinkedQueue localConcurrentLinkedQueue = a(paramChatRoomInfo);
    Object localObject = null;
    Iterator localIterator = localConcurrentLinkedQueue.iterator();
    label35:
    lkh locallkh;
    boolean bool;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        locallkh = (lkh)localIterator.next();
        if (locallkh != null) {
          if (locallkh.a(paramMsg))
          {
            bool = true;
            locallkh.jdField_c_of_type_Long = paramMsg.msg_time.get();
            locallkh.a(lkh.jdField_d_of_type_Int);
          }
        }
      }
    }
    for (;;)
    {
      if ((!bool) && (localObject != null))
      {
        bool = true;
        ((lkh)localObject).jdField_d_of_type_Long = paramMsg.msg_id.get();
        ((lkh)localObject).jdField_c_of_type_Long = paramMsg.msg_time.get();
        ((lkh)localObject).a(lkh.jdField_d_of_type_Int);
        label140:
        if (!bool)
        {
          localObject = new lkh(paramChatRoomInfo, paramMsg.uin.get(), paramMsg.msg.get(), paramMsg.msg_time.get(), paramMsg.msg_id.get(), lkh.jdField_d_of_type_Int);
          localConcurrentLinkedQueue.add(localObject);
          if (paramBoolean) {
            a(4, paramChatRoomInfo);
          }
        }
        else
        {
          label205:
          if (!QLog.isDevelopLevel()) {
            break label320;
          }
          QLog.i("ChatRoomMng", 4, "onRecvMsg, isDuplicatedMsg[" + bool + "], msg[" + localObject + "], isFromPush[" + paramBoolean + "]");
          return;
          if ((locallkh.jdField_d_of_type_Long != -9223372036854775808L) || (locallkh.jdField_a_of_type_Long != l) || (!TextUtils.equals(locallkh.jdField_a_of_type_JavaLangString, paramMsg.msg.get()))) {
            break label329;
          }
          localObject = locallkh;
        }
      }
      label320:
      label329:
      for (;;)
      {
        break label35;
        a(2, paramChatRoomInfo);
        break label205;
        break;
        localObject = locallkh;
        break label140;
      }
      locallkh = null;
      bool = false;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, byte[] paramArrayOfByte)
  {
    long l1 = mur.a(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "onChatRoomRsp, cmd[" + paramString + "], isSuc[" + paramBoolean + "], resultCode[" + paramInt + "], seq[" + l1 + "]");
    }
    long l2;
    if ("QQRTCSvc.chatroom_send_msg".equals(paramString))
    {
      paramString = (ChatRoomInfo)paramIntent.getParcelableExtra("room_key");
      l2 = paramIntent.getLongExtra("localSeq", 0L);
      if (paramString == null) {
        break label1013;
      }
    }
    label405:
    label862:
    label879:
    label1013:
    for (paramIntent = a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_Long, paramString.jdField_b_of_type_Long, paramString.jdField_c_of_type_Long);; paramIntent = null)
    {
      if (paramIntent != null) {}
      int i;
      for (Object localObject1 = a(paramIntent, l2);; localObject1 = null)
      {
        if ((paramIntent == null) || (localObject1 == null)) {
          QLog.i("ChatRoomMng", 1, "onChatRoomRsp find msg fail, localSeq[" + l2 + "], room[" + paramString + "]");
        }
        do
        {
          Object localObject2;
          do
          {
            do
            {
              do
              {
                return;
                if ((!paramBoolean) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
                  break;
                }
                paramInt = -1;
                l1 = 0L;
                localObject2 = new chatroom_sso.RspSendMsg();
                i = paramInt;
                for (;;)
                {
                  try
                  {
                    ((chatroom_sso.RspSendMsg)localObject2).mergeFrom(paramArrayOfByte);
                    i = paramInt;
                    paramInt = ((chatroom_sso.RspSendMsg)localObject2).result.get();
                    i = paramInt;
                    paramString = ((chatroom_sso.RspSendMsg)localObject2).err_msg.get();
                  }
                  catch (InvalidProtocolBufferMicroException paramArrayOfByte)
                  {
                    try
                    {
                      i = ((chatroom_sso.RspSendMsg)localObject2).msg_id.get();
                      l1 = i;
                      if (QLog.isColorLevel()) {
                        QLog.i("ChatRoomMng", 2, String.format("onChatRoomRsp, result[%s], msgSeq[%s], errorMsg[%s], localSeq[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), paramString, Long.valueOf(l2) }));
                      }
                      if (paramInt == 0) {
                        break label405;
                      }
                      ((lkh)localObject1).a(lkh.jdField_b_of_type_Int);
                      b((lkh)localObject1);
                      if (!((lkh)localObject1).b()) {
                        break;
                      }
                      paramString = Message.obtain();
                      paramString.what = 4;
                      paramString.obj = localObject1;
                      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 200L);
                      return;
                    }
                    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
                    {
                      for (;;)
                      {
                        continue;
                        localObject1 = null;
                      }
                    }
                    paramArrayOfByte = paramArrayOfByte;
                    paramString = null;
                    paramInt = i;
                  }
                  QLog.i("ChatRoomMng", 1, "onChatRoomRsp, parse RspSendMsg fail.", paramArrayOfByte);
                }
                ((lkh)localObject1).jdField_d_of_type_Long = l1;
                ((lkh)localObject1).a(lkh.jdField_c_of_type_Int);
                b((lkh)localObject1);
                if (!paramIntent.jdField_a_of_type_Boolean)
                {
                  lkj.a("0X800A8D4");
                  paramIntent.jdField_a_of_type_Boolean = true;
                }
              } while ((paramIntent.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(((lkh)localObject1).jdField_a_of_type_JavaLangString)) || (((lkh)localObject1).jdField_a_of_type_JavaLangString.indexOf('\024') < 0));
              lkj.a("0X800A8D5");
              paramIntent.jdField_b_of_type_Boolean = true;
              return;
              ((lkh)localObject1).a(lkh.jdField_b_of_type_Int);
              b((lkh)localObject1);
            } while (!QLog.isColorLevel());
            QLog.i("ChatRoomMng", 2, "onChatRoomRsp send msg fail, localSeq[" + l2 + "]");
            return;
          } while (!"QQRTCSvc.chatroom_get_msg".equals(paramString));
          paramString = (ChatRoomInfo)paramIntent.getParcelableExtra("room_key");
          if (paramString == null) {
            break label1001;
          }
          localObject1 = a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_Long, paramString.jdField_b_of_type_Long, paramString.jdField_c_of_type_Long);
          if (localObject1 == null)
          {
            QLog.i("ChatRoomMng", 1, "onChatRoomRsp find room info fail. room[" + paramString + "]");
            return;
          }
          if ((paramBoolean) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
          {
            i = -1;
            paramIntent = null;
            l1 = 1000L;
            localObject2 = new chatroom_sso.RspGetMsg();
            paramString = paramIntent;
            paramInt = i;
            for (;;)
            {
              try
              {
                ((chatroom_sso.RspGetMsg)localObject2).mergeFrom(paramArrayOfByte);
                paramString = paramIntent;
                paramInt = i;
                i = ((chatroom_sso.RspGetMsg)localObject2).result.get();
                paramString = paramIntent;
                paramInt = i;
                paramIntent = ((chatroom_sso.RspGetMsg)localObject2).err_msg.get();
                paramString = paramIntent;
                paramInt = i;
                paramArrayOfByte = ((chatroom_sso.RspGetMsg)localObject2).msg_list.get();
                paramString = paramArrayOfByte;
                QLog.i("ChatRoomMng", 1, "onChatRoomRsp, parse RspGetMsg fail.", paramIntent);
              }
              catch (InvalidProtocolBufferMicroException paramIntent)
              {
                try
                {
                  paramBoolean = ((chatroom_sso.RspGetMsg)localObject2).retry.get();
                }
                catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
                {
                  for (;;)
                  {
                    paramBoolean = false;
                    paramArrayOfByte = paramString;
                    paramString = paramIntent;
                    paramInt = i;
                    paramIntent = localInvalidProtocolBufferMicroException1;
                  }
                }
                try
                {
                  l2 = ((chatroom_sso.RspGetMsg)localObject2).retry_delay.get();
                  l1 = l2;
                  paramInt = i;
                  paramArrayOfByte = paramString;
                  if (QLog.isColorLevel())
                  {
                    if (paramArrayOfByte != null) {
                      break label879;
                    }
                    i = 0;
                    QLog.i("ChatRoomMng", 2, String.format("onChatRoomRsp, get msg from server, result[%s], errorMsg[%s], msgSize[%s], retry[%s], retryDelay[%s]", new Object[] { Integer.valueOf(paramInt), paramIntent, Integer.valueOf(i), Boolean.valueOf(paramBoolean), Long.valueOf(l1) }));
                  }
                  if (paramInt != 0) {
                    break label901;
                  }
                  if ((!paramBoolean) || ((paramArrayOfByte != null) && (paramArrayOfByte.size() != 0))) {
                    break;
                  }
                  a((ChatRoomInfo)localObject1, l1);
                  return;
                }
                catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
                {
                  paramArrayOfByte = paramString;
                  paramString = paramIntent;
                  paramInt = i;
                  paramIntent = localInvalidProtocolBufferMicroException2;
                  break label862;
                }
                paramIntent = paramIntent;
                paramArrayOfByte = null;
                paramBoolean = false;
              }
              paramIntent = paramString;
              continue;
              i = paramArrayOfByte.size();
            }
            a((ChatRoomInfo)localObject1, paramArrayOfByte, false);
            return;
            a((ChatRoomInfo)localObject1, l1);
            return;
          }
          a((ChatRoomInfo)localObject1, 1000L);
        } while (!QLog.isColorLevel());
        QLog.i("ChatRoomMng", 2, "onChatRoomRsp get msg fail seq[" + l1 + "]");
        return;
      }
    }
  }
  
  public void a(lfe paramlfe)
  {
    ChatRoomInfo localChatRoomInfo = a(paramlfe, false);
    a(localChatRoomInfo);
    if ((QLog.isDevelopLevel()) && (paramlfe != null)) {
      QLog.i("ChatRoomMng", 4, "quitChatRoom, SessionType[" + paramlfe.jdField_d_of_type_Int + "], relationType[" + paramlfe.F + "], relationId[" + paramlfe.g + "], peerUin[" + paramlfe.jdField_d_of_type_JavaLangString + "], extraUin[" + paramlfe.f + "], isDoubleVideoMeeting[" + paramlfe.J + "], room[" + localChatRoomInfo + "]");
    }
  }
  
  public void a(lki paramlki)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "addObserver, observer[" + paramlki + "]");
    }
    if ((paramlki != null) && (!this.b.contains(paramlki))) {
      this.b.add(paramlki);
    }
  }
  
  public void b(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo == null)
    {
      QLog.i("ChatRoomMng", 1, "reqGetMsgFromServer, no room info.");
      return;
    }
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "reqGetMsgFromServer, seq[" + l + "], curRoomInfo[" + paramChatRoomInfo + "]");
    }
    int i = (int)paramChatRoomInfo.jdField_c_of_type_Long;
    Object localObject = new chatroom_sso.RoomKey();
    ((chatroom_sso.RoomKey)localObject).type.set(paramChatRoomInfo.jdField_a_of_type_Int);
    ((chatroom_sso.RoomKey)localObject).room_id.set(paramChatRoomInfo.jdField_a_of_type_Long);
    ((chatroom_sso.RoomKey)localObject).id.set(paramChatRoomInfo.jdField_b_of_type_Long);
    ((chatroom_sso.RoomKey)localObject).create_ts.set(i);
    chatroom_sso.ReqGetMsg localReqGetMsg = new chatroom_sso.ReqGetMsg();
    localReqGetMsg.room_key.set((MessageMicro)localObject);
    if (paramChatRoomInfo.jdField_c_of_type_Boolean)
    {
      localReqGetMsg.is_terminal_switch.set(true);
      if (paramChatRoomInfo.jdField_d_of_type_Long != 0L) {
        localReqGetMsg.room_id.set(paramChatRoomInfo.jdField_d_of_type_Long);
      }
    }
    paramChatRoomInfo.a();
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
    ((NewIntent)localObject).putExtra("reqType", 21);
    ((NewIntent)localObject).putExtra("ssoCmd", "QQRTCSvc.chatroom_get_msg");
    ((NewIntent)localObject).putExtra("vMsg", localReqGetMsg.toByteArray());
    ((NewIntent)localObject).putExtra("room_key", paramChatRoomInfo);
    mur.a((Intent)localObject, l);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void b(lki paramlki)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "removeObserver, observer[" + paramlki + "]");
    }
    if (paramlki != null) {
      this.b.remove(paramlki);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Iterator localIterator;
    lki locallki;
    if (paramMessage.what == 1)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = 0;
      paramMessage = (ChatRoomInfo)paramMessage.obj;
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        locallki = (lki)localIterator.next();
        if (locallki != null) {
          locallki.a(i, paramMessage);
        }
      }
    }
    if (paramMessage.what == 2)
    {
      paramMessage = (lkh)paramMessage.obj;
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        locallki = (lki)localIterator.next();
        if (locallki != null) {
          locallki.a(paramMessage);
        }
      }
    }
    if (paramMessage.what == 3) {
      ThreadManagerV2.excute(new ChatRoomMng.2(this, (ChatRoomInfo)paramMessage.obj), 16, null, true);
    }
    do
    {
      do
      {
        return true;
      } while (paramMessage.what != 4);
      paramMessage = (lkh)paramMessage.obj;
    } while ((paramMessage == null) || (!paramMessage.b()));
    a(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lkf
 * JD-Core Version:    0.7.0.1
 */