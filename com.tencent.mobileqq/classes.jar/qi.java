import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;

public class qi
  extends VasQuickUpdateManager.CallBacker
{
  public qi(VasFontIPCModule paramVasFontIPCModule) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 1004L) && ("libVipFont_765".equals(paramString1))) {
      if (paramInt1 != 0) {
        break label110;
      }
    }
    label110:
    for (paramString1 = EIPCResult.createResult(0, null);; paramString1 = EIPCResult.createResult(-102, null))
    {
      this.a.callbackResult(VasFontIPCModule.a(this.a), paramString1);
      VasFontIPCModule.a(this.a, 0);
      VasFontIPCModule.a(this.a).set(false);
      if ((BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))) {
        ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(183)).b(this.a.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qi
 * JD-Core Version:    0.7.0.1
 */