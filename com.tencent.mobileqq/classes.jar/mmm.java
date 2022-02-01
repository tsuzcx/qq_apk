import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class mmm
  implements ljr
{
  private final WeakReference<mmj> a;
  
  mmm(mmj parammmj)
  {
    this.a = new WeakReference(parammmj);
  }
  
  public void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    int i;
    mmj localmmj;
    if ((paramInt & 0x4) == 4)
    {
      i = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + paramInt + "], room[" + paramChatRoomInfo + "]");
      }
      localmmj = (mmj)this.a.get();
      if (localmmj != null) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (localmmj.a())
      {
        mmj.a(localmmj, paramChatRoomInfo);
        return;
      }
    } while (i == 0);
    mmj.a(localmmj, 0);
  }
  
  public void a(ljq paramljq)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + paramljq + "]");
    }
    mmj localmmj = (mmj)this.a.get();
    if ((paramljq == null) || (localmmj == null)) {}
    while (!localmmj.a()) {
      return;
    }
    mmj.a(localmmj, paramljq.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmm
 * JD-Core Version:    0.7.0.1
 */