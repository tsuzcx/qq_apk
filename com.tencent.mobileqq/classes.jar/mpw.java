import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.AVRedBag.3.1;
import com.tencent.qphone.base.util.QLog;

public class mpw
  extends mcx
{
  mpw(mpt parammpt) {}
  
  protected void a(String paramString, Boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null)
    {
      mqk localmqk = paramString.jdField_a_of_type_Mqk;
      if (localmqk != null) {
        localmqk.a(-4, 10000L);
      }
      paramString.c(paramBoolean.booleanValue());
    }
  }
  
  public void a(mdb parammdb)
  {
    mqb localmqb = this.a.a();
    if (localmqb == null) {}
    while ((!localmqb.a()) || (localmqb.d())) {
      return;
    }
    mqw.c();
    mbf.a(this.a.a, 1045, 2131695556);
    parammdb.jdField_b_of_type_Boolean = true;
    parammdb.jdField_b_of_type_JavaLangString = "AVRedBag";
  }
  
  protected void b(String paramString, Boolean paramBoolean)
  {
    mqb localmqb = this.a.a();
    if (localmqb != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.i, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localmqb.a() + "], isGameStarter[" + localmqb.d() + "]");
      }
      if (localmqb.a()) {
        ((AVRedPacketManager)this.a.a.a(6)).b(false);
      }
      localmqb.c();
      if ((!paramBoolean.booleanValue()) && (localmqb.a()) && (!localmqb.d())) {
        mqw.e();
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    mqb localmqb = this.a.a();
    if (localmqb == null) {}
    do
    {
      do
      {
        return;
      } while ((!localmqb.a()) || (localmqb.jdField_a_of_type_Mqj == null) || (localmqb.jdField_a_of_type_Mqj.a == null));
      QLog.w(this.a.i, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localmqb.jdField_a_of_type_Mqj.a.jdField_b_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mpw
 * JD-Core Version:    0.7.0.1
 */