import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.AVRedBag.3.1;
import com.tencent.qphone.base.util.QLog;

public class mpq
  extends mct
{
  mpq(mpn parammpn) {}
  
  protected void a(String paramString, Boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null)
    {
      mqe localmqe = paramString.jdField_a_of_type_Mqe;
      if (localmqe != null) {
        localmqe.a(-4, 10000L);
      }
      paramString.c(paramBoolean.booleanValue());
    }
  }
  
  public void a(mcx parammcx)
  {
    mpv localmpv = this.a.a();
    if (localmpv == null) {}
    while ((!localmpv.a()) || (localmpv.d())) {
      return;
    }
    mqq.c();
    mbb.a(this.a.a, 1045, 2131695200);
    parammcx.jdField_b_of_type_Boolean = true;
    parammcx.jdField_b_of_type_JavaLangString = "AVRedBag";
  }
  
  protected void b(String paramString, Boolean paramBoolean)
  {
    mpv localmpv = this.a.a();
    if (localmpv != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.i, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localmpv.a() + "], isGameStarter[" + localmpv.d() + "]");
      }
      if (localmpv.a()) {
        ((AVRedPacketManager)this.a.a.a(6)).b(false);
      }
      localmpv.c();
      if ((!paramBoolean.booleanValue()) && (localmpv.a()) && (!localmpv.d())) {
        mqq.e();
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    mpv localmpv = this.a.a();
    if (localmpv == null) {}
    do
    {
      do
      {
        return;
      } while ((!localmpv.a()) || (localmpv.jdField_a_of_type_Mqd == null) || (localmpv.jdField_a_of_type_Mqd.a == null));
      QLog.w(this.a.i, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localmpv.jdField_a_of_type_Mqd.a.jdField_b_of_type_Boolean);
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
 * Qualified Name:     mpq
 * JD-Core Version:    0.7.0.1
 */