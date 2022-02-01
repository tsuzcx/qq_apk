import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.AVRedBag.3.1;
import com.tencent.qphone.base.util.QLog;

public class mot
  extends mbx
{
  mot(moq parammoq) {}
  
  protected void a(String paramString, Boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null)
    {
      mph localmph = paramString.jdField_a_of_type_Mph;
      if (localmph != null) {
        localmph.a(-4, 10000L);
      }
      paramString.c(paramBoolean.booleanValue());
    }
  }
  
  public void a(mcb parammcb)
  {
    moy localmoy = this.a.a();
    if (localmoy == null) {}
    while ((!localmoy.a()) || (localmoy.d())) {
      return;
    }
    mpt.c();
    maf.a(this.a.a, 1045, 2131695157);
    parammcb.jdField_b_of_type_Boolean = true;
    parammcb.jdField_b_of_type_JavaLangString = "AVRedBag";
  }
  
  protected void b(String paramString, Boolean paramBoolean)
  {
    moy localmoy = this.a.a();
    if (localmoy != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.i, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localmoy.a() + "], isGameStarter[" + localmoy.d() + "]");
      }
      if (localmoy.a()) {
        ((AVRedPacketManager)this.a.a.a(6)).b(false);
      }
      localmoy.c();
      if ((!paramBoolean.booleanValue()) && (localmoy.a()) && (!localmoy.d())) {
        mpt.e();
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    moy localmoy = this.a.a();
    if (localmoy == null) {}
    do
    {
      do
      {
        return;
      } while ((!localmoy.a()) || (localmoy.jdField_a_of_type_Mpg == null) || (localmoy.jdField_a_of_type_Mpg.a == null));
      QLog.w(this.a.i, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localmoy.jdField_a_of_type_Mpg.a.jdField_b_of_type_Boolean);
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
 * Qualified Name:     mot
 * JD-Core Version:    0.7.0.1
 */