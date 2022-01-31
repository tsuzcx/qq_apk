import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.AVRedBag.3.1;
import com.tencent.qphone.base.util.QLog;

public class mou
  extends mcf
{
  mou(mor parammor) {}
  
  protected void a(String paramString, Boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null)
    {
      mpi localmpi = paramString.jdField_a_of_type_Mpi;
      if (localmpi != null) {
        localmpi.a(-4, 10000L);
      }
      paramString.c(paramBoolean.booleanValue());
    }
  }
  
  public void a(mcj parammcj)
  {
    moz localmoz = this.a.a();
    if (localmoz == null) {}
    while ((!localmoz.a()) || (localmoz.d())) {
      return;
    }
    mpu.c();
    mao.a(this.a.a, 1045, 2131696113);
    parammcj.jdField_b_of_type_Boolean = true;
    parammcj.jdField_b_of_type_JavaLangString = "AVRedBag";
  }
  
  protected void b(String paramString, Boolean paramBoolean)
  {
    moz localmoz = this.a.a();
    if (localmoz != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.i, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localmoz.a() + "], isGameStarter[" + localmoz.d() + "]");
      }
      if (localmoz.a()) {
        ((AVRedPacketManager)this.a.a.a(6)).b(false);
      }
      localmoz.c();
      if ((!paramBoolean.booleanValue()) && (localmoz.a()) && (!localmoz.d())) {
        mpu.e();
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    moz localmoz = this.a.a();
    if (localmoz == null) {}
    do
    {
      do
      {
        return;
      } while ((!localmoz.a()) || (localmoz.jdField_a_of_type_Mph == null) || (localmoz.jdField_a_of_type_Mph.a == null));
      QLog.w(this.a.i, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localmoz.jdField_a_of_type_Mph.a.jdField_b_of_type_Boolean);
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
 * Qualified Name:     mou
 * JD-Core Version:    0.7.0.1
 */