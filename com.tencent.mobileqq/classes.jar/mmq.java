import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class mmq
  implements lkw
{
  private final WeakReference<mmn> a;
  
  mmq(mmn parammmn)
  {
    this.a = new WeakReference(parammmn);
  }
  
  public void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    int i;
    mmn localmmn;
    if ((paramInt & 0x4) == 4)
    {
      i = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + paramInt + "], room[" + paramChatRoomInfo + "]");
      }
      localmmn = (mmn)this.a.get();
      if (localmmn != null) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (localmmn.a())
      {
        mmn.a(localmmn, paramChatRoomInfo);
        return;
      }
    } while (i == 0);
    mmn.a(localmmn, 0);
  }
  
  public void a(lkv paramlkv)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + paramlkv + "]");
    }
    mmn localmmn = (mmn)this.a.get();
    if ((paramlkv == null) || (localmmn == null)) {}
    while (!localmmn.a()) {
      return;
    }
    mmn.a(localmmn, paramlkv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmq
 * JD-Core Version:    0.7.0.1
 */