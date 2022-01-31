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

public class lad
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = 0;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Comparator<laf> jdField_a_of_type_JavaUtilComparator = new lae(this);
  private final ConcurrentHashMap<ChatRoomInfo, ConcurrentLinkedQueue<laf>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final ConcurrentLinkedQueue<ChatRoomInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private final ConcurrentLinkedQueue<lag> b = new ConcurrentLinkedQueue();
  
  public lad(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private ChatRoomInfo a(chatroom_sso.RoomKey paramRoomKey)
  {
    Object localObject1 = ksn.a().a();
    int i = ((kvq)localObject1).b();
    long l5 = ((kvq)localObject1).a();
    long l3 = ((kvq)localObject1).b();
    long l4 = ((kvq)localObject1).c();
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
          ((VideoController)localObject2).a("pushMsg", (kvq)localObject1);
        }
        l1 = ((kvq)localObject1).b();
        l2 = ((kvq)localObject1).c();
      }
    }
    if ((i == paramRoomKey.type.get()) && (l5 == paramRoomKey.id.get()) && (l1 == paramRoomKey.room_id.get()) && (l2 == paramRoomKey.create_ts.get())) {}
    for (localObject1 = a((kvq)localObject1);; localObject1 = null)
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
  
  private ConcurrentLinkedQueue<laf> a(ChatRoomInfo paramChatRoomInfo)
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
  
  private void a(laf paramlaf)
  {
    if ((paramlaf == null) || (paramlaf.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo == null)) {}
    ChatRoomInfo localChatRoomInfo;
    do
    {
      return;
      localChatRoomInfo = paramlaf.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo;
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
        QLog.i("ChatRoomMng", 2, "sendMsg, seq[" + l2 + "], room[" + localChatRoomInfo + "], msg[" + paramlaf + "]");
      }
      paramlaf.a();
      localObject = new chatroom_sso.RoomKey();
      ((chatroom_sso.RoomKey)localObject).type.set(localChatRoomInfo.jdField_a_of_type_Int);
      ((chatroom_sso.RoomKey)localObject).room_id.set(localChatRoomInfo.jdField_a_of_type_Long);
      ((chatroom_sso.RoomKey)localObject).id.set(localChatRoomInfo.jdField_b_of_type_Long);
      ((chatroom_sso.RoomKey)localObject).create_ts.set((int)localChatRoomInfo.jdField_c_of_type_Long);
      localMsg = new chatroom_sso.Msg();
      localMsg.msg.set(paramlaf.jdField_a_of_type_JavaLangString);
      localMsg.uin.set(l1);
      localReqSendMsg = new chatroom_sso.ReqSendMsg();
      localReqSendMsg.room_key.set((MessageMicro)localObject);
      localReqSendMsg.msg.set(localMsg);
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
      ((NewIntent)localObject).putExtra("reqType", 21);
      ((NewIntent)localObject).putExtra("vMsg", localReqSendMsg.toByteArray());
      ((NewIntent)localObject).putExtra("room_key", localChatRoomInfo);
      ((NewIntent)localObject).putExtra("localSeq", paramlaf.jdField_b_of_type_Long);
      min.a((Intent)localObject, l2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet((NewIntent)localObject);
    } while (paramlaf.e != laf.jdField_a_of_type_Int);
    a(1, localChatRoomInfo);
  }
  
  private void b(laf paramlaf)
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2, paramlaf))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.obj = paramlaf;
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
  
  public ChatRoomInfo a(kvq paramkvq)
  {
    ChatRoomInfo localChatRoomInfo = a(paramkvq, true);
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
      if ((QLog.isDevelopLevel()) && (paramkvq != null)) {
        QLog.i("ChatRoomMng", 4, "enterChatRoom, SessionType[" + paramkvq.jdField_d_of_type_Int + "], relationType[" + paramkvq.C + "], relationId[" + paramkvq.g + "], peerUin[" + paramkvq.jdField_d_of_type_JavaLangString + "], extraUin[" + paramkvq.f + "], isDoubleVideoMeeting[" + paramkvq.I + "], room[" + localChatRoomInfo + "]");
      }
      return localChatRoomInfo;
      label189:
      ((ConcurrentLinkedQueue)localObject).clear();
    }
  }
  
  public ChatRoomInfo a(kvq paramkvq, boolean paramBoolean)
  {
    Object localObject = null;
    int i;
    long l5;
    long l2;
    long l1;
    if (paramkvq != null)
    {
      i = paramkvq.b();
      l5 = paramkvq.a();
      long l3 = paramkvq.b();
      long l4 = paramkvq.c();
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
      l2 = paramkvq.b();
      l1 = paramkvq.c();
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
            QLog.i("ChatRoomMng", 4, "getRoomInfo, SessionType[" + paramkvq.jdField_d_of_type_Int + "], relationType[" + paramkvq.C + "], relationId[" + paramkvq.g + "], peerUin[" + paramkvq.jdField_d_of_type_JavaLangString + "], extraUin[" + paramkvq.f + "], isDoubleVideoMeeting[" + paramkvq.I + "], type[" + i + "], roomID[" + l2 + "], id[" + l5 + "], createTime[" + l1 + "], room[" + localChatRoomInfo1 + "]");
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
  
  public laf a(ChatRoomInfo paramChatRoomInfo, long paramLong)
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
        paramChatRoomInfo = (laf)localIterator.next();
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
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2, Intent paramIntent, byte[] paramArrayOfByte)
  {
    long l1 = min.a(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "onChatRoomRsp, req[" + paramInt1 + "], isSuc[" + paramBoolean + "], resultCode[" + paramInt2 + "], seq[" + l1 + "]");
    }
    Object localObject3;
    long l2;
    if (paramInt1 == 21)
    {
      localObject3 = (ChatRoomInfo)paramIntent.getParcelableExtra("room_key");
      l2 = paramIntent.getLongExtra("localSeq", 0L);
      if (localObject3 == null) {
        break label1019;
      }
    }
    label409:
    label866:
    label884:
    label1019:
    for (Object localObject1 = a(((ChatRoomInfo)localObject3).jdField_a_of_type_Int, ((ChatRoomInfo)localObject3).jdField_a_of_type_Long, ((ChatRoomInfo)localObject3).jdField_b_of_type_Long, ((ChatRoomInfo)localObject3).jdField_c_of_type_Long);; localObject1 = null)
    {
      if (localObject1 != null) {}
      for (Object localObject2 = a((ChatRoomInfo)localObject1, l2);; localObject2 = null)
      {
        if ((localObject1 == null) || (localObject2 == null)) {
          QLog.i("ChatRoomMng", 1, "onChatRoomRsp find msg fail, localSeq[" + l2 + "], room[" + localObject3 + "]");
        }
        do
        {
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
                paramInt1 = -1;
                l1 = 0L;
                localObject3 = new chatroom_sso.RspSendMsg();
                paramInt2 = paramInt1;
                for (;;)
                {
                  try
                  {
                    ((chatroom_sso.RspSendMsg)localObject3).mergeFrom(paramArrayOfByte);
                    paramInt2 = paramInt1;
                    paramInt1 = ((chatroom_sso.RspSendMsg)localObject3).result.get();
                    paramInt2 = paramInt1;
                    paramIntent = ((chatroom_sso.RspSendMsg)localObject3).err_msg.get();
                  }
                  catch (InvalidProtocolBufferMicroException paramArrayOfByte)
                  {
                    try
                    {
                      paramInt2 = ((chatroom_sso.RspSendMsg)localObject3).msg_id.get();
                      l1 = paramInt2;
                      if (QLog.isColorLevel()) {
                        QLog.i("ChatRoomMng", 2, String.format("onChatRoomRsp, result[%s], msgSeq[%s], errorMsg[%s], localSeq[%s]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l1), paramIntent, Long.valueOf(l2) }));
                      }
                      if (paramInt1 == 0) {
                        break label409;
                      }
                      ((laf)localObject2).a(laf.jdField_b_of_type_Int);
                      b((laf)localObject2);
                      if (!((laf)localObject2).b()) {
                        break;
                      }
                      paramIntent = Message.obtain();
                      paramIntent.what = 4;
                      paramIntent.obj = localObject2;
                      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramIntent, 200L);
                      return;
                    }
                    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
                    {
                      for (;;)
                      {
                        continue;
                        localObject2 = null;
                      }
                    }
                    paramArrayOfByte = paramArrayOfByte;
                    paramIntent = null;
                    paramInt1 = paramInt2;
                  }
                  QLog.i("ChatRoomMng", 1, "onChatRoomRsp, parse RspSendMsg fail.", paramArrayOfByte);
                }
                ((laf)localObject2).jdField_d_of_type_Long = l1;
                ((laf)localObject2).a(laf.jdField_c_of_type_Int);
                b((laf)localObject2);
                if (!((ChatRoomInfo)localObject1).jdField_a_of_type_Boolean)
                {
                  lah.a("0X800A8D4");
                  ((ChatRoomInfo)localObject1).jdField_a_of_type_Boolean = true;
                }
              } while ((((ChatRoomInfo)localObject1).jdField_b_of_type_Boolean) || (TextUtils.isEmpty(((laf)localObject2).jdField_a_of_type_JavaLangString)) || (((laf)localObject2).jdField_a_of_type_JavaLangString.indexOf('\024') < 0));
              lah.a("0X800A8D5");
              ((ChatRoomInfo)localObject1).jdField_b_of_type_Boolean = true;
              return;
              ((laf)localObject2).a(laf.jdField_b_of_type_Int);
              b((laf)localObject2);
            } while (!QLog.isColorLevel());
            QLog.i("ChatRoomMng", 2, "onChatRoomRsp send msg fail, localSeq[" + l2 + "]");
            return;
          } while (paramInt1 != 22);
          paramIntent = (ChatRoomInfo)paramIntent.getParcelableExtra("room_key");
          if (paramIntent == null) {
            break label1007;
          }
          localObject2 = a(paramIntent.jdField_a_of_type_Int, paramIntent.jdField_a_of_type_Long, paramIntent.jdField_b_of_type_Long, paramIntent.jdField_c_of_type_Long);
          if (localObject2 == null)
          {
            QLog.i("ChatRoomMng", 1, "onChatRoomRsp find room info fail. room[" + paramIntent + "]");
            return;
          }
          if ((paramBoolean) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
          {
            paramInt2 = -1;
            localObject1 = null;
            l1 = 1000L;
            localObject3 = new chatroom_sso.RspGetMsg();
            paramIntent = (Intent)localObject1;
            paramInt1 = paramInt2;
            for (;;)
            {
              try
              {
                ((chatroom_sso.RspGetMsg)localObject3).mergeFrom(paramArrayOfByte);
                paramIntent = (Intent)localObject1;
                paramInt1 = paramInt2;
                paramInt2 = ((chatroom_sso.RspGetMsg)localObject3).result.get();
                paramIntent = (Intent)localObject1;
                paramInt1 = paramInt2;
                paramArrayOfByte = ((chatroom_sso.RspGetMsg)localObject3).err_msg.get();
                paramIntent = paramArrayOfByte;
                paramInt1 = paramInt2;
                localObject1 = ((chatroom_sso.RspGetMsg)localObject3).msg_list.get();
                paramIntent = (Intent)localObject1;
                QLog.i("ChatRoomMng", 1, "onChatRoomRsp, parse RspGetMsg fail.", paramArrayOfByte);
              }
              catch (InvalidProtocolBufferMicroException paramArrayOfByte)
              {
                try
                {
                  paramBoolean = ((chatroom_sso.RspGetMsg)localObject3).retry.get();
                }
                catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
                {
                  for (;;)
                  {
                    paramBoolean = false;
                    localObject1 = paramIntent;
                    paramIntent = paramArrayOfByte;
                    paramInt1 = paramInt2;
                    paramArrayOfByte = localInvalidProtocolBufferMicroException1;
                  }
                }
                try
                {
                  l2 = ((chatroom_sso.RspGetMsg)localObject3).retry_delay.get();
                  l1 = l2;
                  paramInt1 = paramInt2;
                  localObject1 = paramIntent;
                  if (QLog.isColorLevel())
                  {
                    if (localObject1 != null) {
                      break label884;
                    }
                    paramInt2 = 0;
                    QLog.i("ChatRoomMng", 2, String.format("onChatRoomRsp, get msg from server, result[%s], errorMsg[%s], msgSize[%s], retry[%s], retryDelay[%s]", new Object[] { Integer.valueOf(paramInt1), paramArrayOfByte, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Long.valueOf(l1) }));
                  }
                  if (paramInt1 != 0) {
                    break label905;
                  }
                  if ((!paramBoolean) || ((localObject1 != null) && (((List)localObject1).size() != 0))) {
                    break;
                  }
                  a((ChatRoomInfo)localObject2, l1);
                  return;
                }
                catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
                {
                  localObject1 = paramIntent;
                  paramIntent = paramArrayOfByte;
                  paramInt1 = paramInt2;
                  paramArrayOfByte = localInvalidProtocolBufferMicroException2;
                  break label866;
                }
                paramArrayOfByte = paramArrayOfByte;
                localObject1 = null;
                paramBoolean = false;
              }
              paramArrayOfByte = paramIntent;
              continue;
              paramInt2 = ((List)localObject1).size();
            }
            a((ChatRoomInfo)localObject2, (List)localObject1, false);
            return;
            a((ChatRoomInfo)localObject2, l1);
            return;
          }
          a((ChatRoomInfo)localObject2, 1000L);
        } while (!QLog.isColorLevel());
        QLog.i("ChatRoomMng", 2, "onChatRoomRsp get msg fail seq[" + l1 + "]");
        return;
      }
    }
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
  
  public void a(VideoController paramVideoController, kvq paramkvq)
  {
    ChatRoomInfo localChatRoomInfo2 = a(paramkvq, false);
    boolean bool = paramVideoController.a("onSwitchTerminalSuccess", paramkvq);
    ChatRoomInfo localChatRoomInfo1 = a(paramkvq, false);
    paramVideoController = localChatRoomInfo1;
    if (localChatRoomInfo1 == null) {
      paramVideoController = a(paramkvq);
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
      paramkvq = Message.obtain();
      paramkvq.obj = paramVideoController;
      paramkvq.what = 3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramkvq);
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
    paramString = new laf(paramChatRoomInfo, l1, paramString, paramLong, -9223372036854775808L, laf.jdField_a_of_type_Int);
    a(paramChatRoomInfo).add(paramString);
    a(paramString);
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, List<laf> paramList)
  {
    if ((paramChatRoomInfo == null) || (paramList == null)) {
      return;
    }
    paramChatRoomInfo = (ConcurrentLinkedQueue)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramChatRoomInfo);
    if ((paramChatRoomInfo != null) && (paramChatRoomInfo.size() > 0)) {
      paramList.addAll(paramChatRoomInfo);
    }
    Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
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
    laf locallaf;
    boolean bool;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        locallaf = (laf)localIterator.next();
        if (locallaf != null) {
          if (locallaf.a(paramMsg))
          {
            bool = true;
            locallaf.jdField_c_of_type_Long = paramMsg.msg_time.get();
            locallaf.a(laf.jdField_d_of_type_Int);
          }
        }
      }
    }
    for (;;)
    {
      if ((!bool) && (localObject != null))
      {
        bool = true;
        ((laf)localObject).jdField_d_of_type_Long = paramMsg.msg_id.get();
        ((laf)localObject).jdField_c_of_type_Long = paramMsg.msg_time.get();
        ((laf)localObject).a(laf.jdField_d_of_type_Int);
        label140:
        if (!bool)
        {
          localObject = new laf(paramChatRoomInfo, paramMsg.uin.get(), paramMsg.msg.get(), paramMsg.msg_time.get(), paramMsg.msg_id.get(), laf.jdField_d_of_type_Int);
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
          if ((locallaf.jdField_d_of_type_Long != -9223372036854775808L) || (locallaf.jdField_a_of_type_Long != l) || (!TextUtils.equals(locallaf.jdField_a_of_type_JavaLangString, paramMsg.msg.get()))) {
            break label329;
          }
          localObject = locallaf;
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
        localObject = locallaf;
        break label140;
      }
      locallaf = null;
      bool = false;
    }
  }
  
  public void a(kvq paramkvq)
  {
    ChatRoomInfo localChatRoomInfo = a(paramkvq, false);
    a(localChatRoomInfo);
    if ((QLog.isDevelopLevel()) && (paramkvq != null)) {
      QLog.i("ChatRoomMng", 4, "quitChatRoom, SessionType[" + paramkvq.jdField_d_of_type_Int + "], relationType[" + paramkvq.C + "], relationId[" + paramkvq.g + "], peerUin[" + paramkvq.jdField_d_of_type_JavaLangString + "], extraUin[" + paramkvq.f + "], isDoubleVideoMeeting[" + paramkvq.I + "], room[" + localChatRoomInfo + "]");
    }
  }
  
  public void a(lag paramlag)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "addObserver, observer[" + paramlag + "]");
    }
    if ((paramlag != null) && (!this.b.contains(paramlag))) {
      this.b.add(paramlag);
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
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
    ((NewIntent)localObject).putExtra("reqType", 22);
    ((NewIntent)localObject).putExtra("vMsg", localReqGetMsg.toByteArray());
    ((NewIntent)localObject).putExtra("room_key", paramChatRoomInfo);
    min.a((Intent)localObject, l);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void b(lag paramlag)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "removeObserver, observer[" + paramlag + "]");
    }
    if (paramlag != null) {
      this.b.remove(paramlag);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Iterator localIterator;
    lag locallag;
    if (paramMessage.what == 1)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = 0;
      paramMessage = (ChatRoomInfo)paramMessage.obj;
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        locallag = (lag)localIterator.next();
        if (locallag != null) {
          locallag.a(i, paramMessage);
        }
      }
    }
    if (paramMessage.what == 2)
    {
      paramMessage = (laf)paramMessage.obj;
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        locallag = (lag)localIterator.next();
        if (locallag != null) {
          locallag.a(paramMessage);
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
      paramMessage = (laf)paramMessage.obj;
    } while ((paramMessage == null) || (!paramMessage.b()));
    a(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lad
 * JD-Core Version:    0.7.0.1
 */