import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.AVRedBag.3.1;
import com.tencent.qphone.base.util.QLog;

public class mro
  extends meu
{
  mro(mrl parammrl) {}
  
  protected void a(String paramString, Boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null)
    {
      msc localmsc = paramString.jdField_a_of_type_Msc;
      if (localmsc != null) {
        localmsc.a(-4, 10000L);
      }
      paramString.c(paramBoolean.booleanValue());
    }
  }
  
  public void a(mey parammey)
  {
    mrt localmrt = this.a.a();
    if (localmrt == null) {}
    while ((!localmrt.a()) || (localmrt.d())) {
      return;
    }
    mso.c();
    mdd.a(this.a.a, 1045, 2131696275);
    parammey.jdField_b_of_type_Boolean = true;
    parammey.jdField_b_of_type_JavaLangString = "AVRedBag";
  }
  
  protected void b(String paramString, Boolean paramBoolean)
  {
    mrt localmrt = this.a.a();
    if (localmrt != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.i, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localmrt.a() + "], isGameStarter[" + localmrt.d() + "]");
      }
      if (localmrt.a()) {
        ((AVRedPacketManager)this.a.a.a(6)).b(false);
      }
      localmrt.c();
      if ((!paramBoolean.booleanValue()) && (localmrt.a()) && (!localmrt.d())) {
        mso.e();
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    mrt localmrt = this.a.a();
    if (localmrt == null) {}
    do
    {
      do
      {
        return;
      } while ((!localmrt.a()) || (localmrt.jdField_a_of_type_Msb == null) || (localmrt.jdField_a_of_type_Msb.a == null));
      QLog.w(this.a.i, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localmrt.jdField_a_of_type_Msb.a.jdField_b_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mro
 * JD-Core Version:    0.7.0.1
 */