import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.ControlUIObserver.CPreEventInfo;
import com.tencent.av.ui.redbag.AVRedBag;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.GameSink;
import com.tencent.av.ui.redbag.GetRedBag;
import com.tencent.av.ui.redbag.RedBagReport;
import com.tencent.av.ui.redbag.ResultData;
import com.tencent.qphone.base.util.QLog;

public class kds
  extends ControlUIObserver
{
  public kds(AVRedBag paramAVRedBag) {}
  
  public void a(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    Object localObject = this.a.a();
    if (localObject == null) {}
    while ((!((AVRedBagMgr)localObject).a()) || (((AVRedBagMgr)localObject).d())) {
      return;
    }
    RedBagReport.c();
    localObject = this.a.a();
    if (localObject != null) {
      ((AVActivity)localObject).a("正在表情游戏中，不能切换成小窗。", 3000, null);
    }
    paramCPreEventInfo.b = true;
    paramCPreEventInfo.a = "AVRedBag";
  }
  
  protected void a(String paramString, Boolean paramBoolean)
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.i, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localAVRedBagMgr.a() + "], isGameStarter[" + localAVRedBagMgr.d() + "]");
      }
      if (localAVRedBagMgr.a()) {
        ((AVRedPacketManager)this.a.a.a(6)).b(false);
      }
      localAVRedBagMgr.c();
      if ((!paramBoolean.booleanValue()) && (localAVRedBagMgr.a()) && (!localAVRedBagMgr.d())) {
        RedBagReport.e();
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr == null) {}
    do
    {
      do
      {
        return;
      } while ((!localAVRedBagMgr.a()) || (localAVRedBagMgr.jdField_a_of_type_ComTencentAvUiRedbagGameSink == null) || (localAVRedBagMgr.jdField_a_of_type_ComTencentAvUiRedbagGameSink.a == null));
      QLog.w(this.a.i, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localAVRedBagMgr.jdField_a_of_type_ComTencentAvUiRedbagGameSink.a.b);
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
    paramString = this.a.a();
    if (paramString != null)
    {
      paramString = paramString.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag;
      if (paramString != null) {
        paramString.a(-4, 10000L);
      }
    }
  }
  
  protected void f(String paramString)
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.a().post(new kdt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kds
 * JD-Core Version:    0.7.0.1
 */