import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class mnp
  implements lki
{
  private final WeakReference<mnm> a;
  
  mnp(mnm parammnm)
  {
    this.a = new WeakReference(parammnm);
  }
  
  public void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    int i;
    mnm localmnm;
    if ((paramInt & 0x4) == 4)
    {
      i = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + paramInt + "], room[" + paramChatRoomInfo + "]");
      }
      localmnm = (mnm)this.a.get();
      if (localmnm != null) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (localmnm.a())
      {
        mnm.a(localmnm, paramChatRoomInfo);
        return;
      }
    } while (i == 0);
    mnm.a(localmnm, 0);
  }
  
  public void a(lkh paramlkh)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + paramlkh + "]");
    }
    mnm localmnm = (mnm)this.a.get();
    if ((paramlkh == null) || (localmnm == null)) {}
    while (!localmnm.a()) {
      return;
    }
    mnm.a(localmnm, paramlkh.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mnp
 * JD-Core Version:    0.7.0.1
 */