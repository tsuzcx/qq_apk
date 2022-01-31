import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class mmn
  implements lkr
{
  private final WeakReference<mmk> a;
  
  mmn(mmk parammmk)
  {
    this.a = new WeakReference(parammmk);
  }
  
  public void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    int i;
    mmk localmmk;
    if ((paramInt & 0x4) == 4)
    {
      i = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + paramInt + "], room[" + paramChatRoomInfo + "]");
      }
      localmmk = (mmk)this.a.get();
      if (localmmk != null) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (localmmk.a())
      {
        mmk.a(localmmk, paramChatRoomInfo);
        return;
      }
    } while (i == 0);
    mmk.a(localmmk, 0);
  }
  
  public void a(lkq paramlkq)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + paramlkq + "]");
    }
    mmk localmmk = (mmk)this.a.get();
    if ((paramlkq == null) || (localmmk == null)) {}
    while (!localmmk.a()) {
      return;
    }
    mmk.a(localmmk, paramlkq.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmn
 * JD-Core Version:    0.7.0.1
 */