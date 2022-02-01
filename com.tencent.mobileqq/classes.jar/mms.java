import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class mms
  implements ljw
{
  private final WeakReference<mmp> a;
  
  mms(mmp parammmp)
  {
    this.a = new WeakReference(parammmp);
  }
  
  public void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    int i;
    mmp localmmp;
    if ((paramInt & 0x4) == 4)
    {
      i = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + paramInt + "], room[" + paramChatRoomInfo + "]");
      }
      localmmp = (mmp)this.a.get();
      if (localmmp != null) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (localmmp.a())
      {
        mmp.a(localmmp, paramChatRoomInfo);
        return;
      }
    } while (i == 0);
    mmp.a(localmmp, 0);
  }
  
  public void a(ljv paramljv)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + paramljv + "]");
    }
    mmp localmmp = (mmp)this.a.get();
    if ((paramljv == null) || (localmmp == null)) {}
    while (!localmmp.a()) {
      return;
    }
    mmp.a(localmmp, paramljv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mms
 * JD-Core Version:    0.7.0.1
 */