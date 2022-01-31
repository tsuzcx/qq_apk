import android.text.TextUtils;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qphone.base.util.QLog;

public class jwf
  extends VideoObserver
{
  public jwf(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void a(int paramInt, String paramString)
  {
    QLog.w(this.a.b, 1, "VideoObserver_onClose, reason[" + paramInt + "], peerUin[" + paramString + "], mPeerUin[" + this.a.c + "]");
    if (TextUtils.equals(this.a.c, paramString))
    {
      this.a.b("VideoObserver_onClose");
      this.a.b(paramInt);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    QLog.w(this.a.b, 1, "VideoObserver_onDestroyUI, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], mPeerUin[" + this.a.c + "]");
    if (TextUtils.equals(this.a.c, paramString)) {
      this.a.b("VideoObserver_onDestroyUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jwf
 * JD-Core Version:    0.7.0.1
 */