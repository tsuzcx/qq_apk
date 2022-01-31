import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.AVRedBag.3.1;
import com.tencent.qphone.base.util.QLog;

public class mox
  extends mck
{
  mox(mou parammou) {}
  
  protected void a(String paramString, Boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null)
    {
      mpl localmpl = paramString.jdField_a_of_type_Mpl;
      if (localmpl != null) {
        localmpl.a(-4, 10000L);
      }
      paramString.c(paramBoolean.booleanValue());
    }
  }
  
  public void a(mco parammco)
  {
    mpc localmpc = this.a.a();
    if (localmpc == null) {}
    while ((!localmpc.a()) || (localmpc.d())) {
      return;
    }
    mpx.c();
    mat.a(this.a.a, 1045, 2131696112);
    parammco.jdField_b_of_type_Boolean = true;
    parammco.jdField_b_of_type_JavaLangString = "AVRedBag";
  }
  
  protected void b(String paramString, Boolean paramBoolean)
  {
    mpc localmpc = this.a.a();
    if (localmpc != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.i, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localmpc.a() + "], isGameStarter[" + localmpc.d() + "]");
      }
      if (localmpc.a()) {
        ((AVRedPacketManager)this.a.a.a(6)).b(false);
      }
      localmpc.c();
      if ((!paramBoolean.booleanValue()) && (localmpc.a()) && (!localmpc.d())) {
        mpx.e();
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    mpc localmpc = this.a.a();
    if (localmpc == null) {}
    do
    {
      do
      {
        return;
      } while ((!localmpc.a()) || (localmpc.jdField_a_of_type_Mpk == null) || (localmpc.jdField_a_of_type_Mpk.a == null));
      QLog.w(this.a.i, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localmpc.jdField_a_of_type_Mpk.a.jdField_b_of_type_Boolean);
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
 * Qualified Name:     mox
 * JD-Core Version:    0.7.0.1
 */