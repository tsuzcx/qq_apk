import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.AVRedBag.3.1;
import com.tencent.qphone.base.util.QLog;

public class mdy
  extends lru
{
  mdy(mdv parammdv) {}
  
  protected void a(String paramString, Boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null)
    {
      mem localmem = paramString.jdField_a_of_type_Mem;
      if (localmem != null) {
        localmem.a(-4, 10000L);
      }
      paramString.c(paramBoolean.booleanValue());
    }
  }
  
  public void a(lry paramlry)
  {
    med localmed = this.a.a();
    if (localmed == null) {}
    while ((!localmed.a()) || (localmed.d())) {
      return;
    }
    mey.c();
    lqb.a(this.a.a, 1045, 2131630412);
    paramlry.jdField_b_of_type_Boolean = true;
    paramlry.jdField_b_of_type_JavaLangString = "AVRedBag";
  }
  
  protected void b(String paramString, Boolean paramBoolean)
  {
    med localmed = this.a.a();
    if (localmed != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.i, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localmed.a() + "], isGameStarter[" + localmed.d() + "]");
      }
      if (localmed.a()) {
        ((AVRedPacketManager)this.a.a.a(6)).b(false);
      }
      localmed.c();
      if ((!paramBoolean.booleanValue()) && (localmed.a()) && (!localmed.d())) {
        mey.e();
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    med localmed = this.a.a();
    if (localmed == null) {}
    do
    {
      do
      {
        return;
      } while ((!localmed.a()) || (localmed.jdField_a_of_type_Mel == null) || (localmed.jdField_a_of_type_Mel.a == null));
      QLog.w(this.a.i, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localmed.jdField_a_of_type_Mel.a.jdField_b_of_type_Boolean);
    ((AVRedPacketManager)this.a.a.a(6)).a(paramString1, paramString2);
  }
  
  protected void d(String paramString)
  {
    paramString = this.a.a();
    if ((paramString != null) && (paramString.a())) {
      ((AVRedPacketManager)this.a.a.a(6)).b(true);
    }
  }
  
  protected void e(String paramString)
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.a().post(new AVRedBag.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdy
 * JD-Core Version:    0.7.0.1
 */