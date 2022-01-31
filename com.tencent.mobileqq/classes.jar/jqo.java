import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.BeautySettingUi;

public class jqo
  implements Runnable
{
  public jqo(BeautySettingUi paramBeautySettingUi) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.c = AVNotifyCenter.b(this.a.a.getCurrentAccountUin());
      this.a.d(this.a.c);
      if (this.a.c > 0)
      {
        SessionInfo localSessionInfo = SessionMgr.a().a();
        if (localSessionInfo != null) {
          localSessionInfo.s = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqo
 * JD-Core Version:    0.7.0.1
 */