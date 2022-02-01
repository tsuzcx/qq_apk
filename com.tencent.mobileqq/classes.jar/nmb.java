import android.os.Handler;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.1;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.2;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.3;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.4;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.5;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.6;
import com.tencent.qav.QavDef.MultiUserInfo;
import java.util.List;

public class nmb
  extends ndt
{
  public nmb(AVGameControlUIImpl paramAVGameControlUIImpl) {}
  
  public void a()
  {
    nom.a().b().post(new AVGameControlUIImpl.2.1(this));
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != -1)
    {
      if (paramInt1 != 2) {
        break label38;
      }
      AVGameControlUIImpl.b(this.a, 1);
    }
    for (;;)
    {
      AVGameControlUIImpl.a(this.a).post(new AVGameControlUIImpl.2.5(this));
      return;
      label38:
      if (paramInt1 == 1) {
        AVGameControlUIImpl.b(this.a, 4);
      } else if (paramInt1 == 0) {
        if (paramInt2 == 0) {
          AVGameControlUIImpl.b(this.a, 5);
        } else {
          AVGameControlUIImpl.b(this.a, 6);
        }
      }
    }
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo) {}
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean) {}
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean, int paramInt)
  {
    nom.a().b().post(new AVGameControlUIImpl.2.2(this, paramMultiUserInfo, paramBoolean));
  }
  
  public void a(List<QavDef.MultiUserInfo> paramList) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    nom.a().b().post(new AVGameControlUIImpl.2.4(this, paramLong, paramBoolean, paramInt));
  }
  
  public void b(int paramInt)
  {
    nof localnof = nnm.b().a();
    if ((localnof == null) || (localnof.e)) {
      return;
    }
    nom.a().b().post(new AVGameControlUIImpl.2.3(this, paramInt));
  }
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo) {}
  
  public void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    nom.a().b().post(new AVGameControlUIImpl.2.6(this, paramLong, paramBoolean, paramInt));
  }
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmb
 * JD-Core Version:    0.7.0.1
 */