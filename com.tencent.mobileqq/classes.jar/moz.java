import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.AVRedBag.3.1;
import com.tencent.qphone.base.util.QLog;

public class moz
  extends mcc
{
  moz(mow parammow) {}
  
  protected void a(String paramString, Boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null)
    {
      mpn localmpn = paramString.jdField_a_of_type_Mpn;
      if (localmpn != null) {
        localmpn.a(-4, 10000L);
      }
      paramString.c(paramBoolean.booleanValue());
    }
  }
  
  public void a(mcg parammcg)
  {
    mpe localmpe = this.a.a();
    if (localmpe == null) {}
    while ((!localmpe.a()) || (localmpe.d())) {
      return;
    }
    mpz.c();
    mak.a(this.a.a, 1045, 2131695339);
    parammcg.jdField_b_of_type_Boolean = true;
    parammcg.jdField_b_of_type_JavaLangString = "AVRedBag";
  }
  
  protected void b(String paramString, Boolean paramBoolean)
  {
    mpe localmpe = this.a.a();
    if (localmpe != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.i, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localmpe.a() + "], isGameStarter[" + localmpe.d() + "]");
      }
      if (localmpe.a()) {
        ((AVRedPacketManager)this.a.a.a(6)).b(false);
      }
      localmpe.c();
      if ((!paramBoolean.booleanValue()) && (localmpe.a()) && (!localmpe.d())) {
        mpz.e();
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    mpe localmpe = this.a.a();
    if (localmpe == null) {}
    do
    {
      do
      {
        return;
      } while ((!localmpe.a()) || (localmpe.jdField_a_of_type_Mpm == null) || (localmpe.jdField_a_of_type_Mpm.a == null));
      QLog.w(this.a.i, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localmpe.jdField_a_of_type_Mpm.a.jdField_b_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     moz
 * JD-Core Version:    0.7.0.1
 */