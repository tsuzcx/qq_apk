import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class mnj
  implements lkc
{
  private final WeakReference<mng> a;
  
  mnj(mng parammng)
  {
    this.a = new WeakReference(parammng);
  }
  
  public void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    int i;
    mng localmng;
    if ((paramInt & 0x4) == 4)
    {
      i = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + paramInt + "], room[" + paramChatRoomInfo + "]");
      }
      localmng = (mng)this.a.get();
      if (localmng != null) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (localmng.a())
      {
        mng.a(localmng, paramChatRoomInfo);
        return;
      }
    } while (i == 0);
    mng.a(localmng, 0);
  }
  
  public void a(lkb paramlkb)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + paramlkb + "]");
    }
    mng localmng = (mng)this.a.get();
    if ((paramlkb == null) || (localmng == null)) {}
    while (!localmng.a()) {
      return;
    }
    mng.a(localmng, paramlkb.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mnj
 * JD-Core Version:    0.7.0.1
 */