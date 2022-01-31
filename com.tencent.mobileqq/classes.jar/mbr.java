import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class mbr
  implements lag
{
  private final WeakReference<mbo> a;
  
  mbr(mbo parammbo)
  {
    this.a = new WeakReference(parammbo);
  }
  
  public void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    int i;
    mbo localmbo;
    if ((paramInt & 0x4) == 4)
    {
      i = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + paramInt + "], room[" + paramChatRoomInfo + "]");
      }
      localmbo = (mbo)this.a.get();
      if (localmbo != null) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (localmbo.a())
      {
        mbo.a(localmbo, paramChatRoomInfo);
        return;
      }
    } while (i == 0);
    mbo.a(localmbo, 0);
  }
  
  public void a(laf paramlaf)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + paramlaf + "]");
    }
    mbo localmbo = (mbo)this.a.get();
    if ((paramlaf == null) || (localmbo == null)) {}
    while (!localmbo.a()) {
      return;
    }
    mbo.a(localmbo, paramlaf.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbr
 * JD-Core Version:    0.7.0.1
 */