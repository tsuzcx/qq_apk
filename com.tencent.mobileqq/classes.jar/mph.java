import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class mph
  implements lmu
{
  private final WeakReference<mpe> a;
  
  mph(mpe parammpe)
  {
    this.a = new WeakReference(parammpe);
  }
  
  public void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    int i;
    mpe localmpe;
    if ((paramInt & 0x4) == 4)
    {
      i = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + paramInt + "], room[" + paramChatRoomInfo + "]");
      }
      localmpe = (mpe)this.a.get();
      if (localmpe != null) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (localmpe.a())
      {
        mpe.a(localmpe, paramChatRoomInfo);
        return;
      }
    } while (i == 0);
    mpe.a(localmpe, 0);
  }
  
  public void a(lmt paramlmt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + paramlmt + "]");
    }
    mpe localmpe = (mpe)this.a.get();
    if ((paramlmt == null) || (localmpe == null)) {}
    while (!localmpe.a()) {
      return;
    }
    mpe.a(localmpe, paramlmt.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mph
 * JD-Core Version:    0.7.0.1
 */