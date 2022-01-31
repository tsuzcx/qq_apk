import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class taw
  extends CardObserver
{
  public taw(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.a, this.a.a, null, "qqsetting_pcactive_key", paramBoolean2);
      QLog.i("CardObserver_onSetPCActiveState", 1, "Set the PC Active State " + paramBoolean1);
      return;
    }
    Message localMessage = NotifyPushSettingActivity.a(this.a).obtainMessage();
    localMessage.what = 10001;
    localMessage.obj = paramString2;
    NotifyPushSettingActivity.a(this.a).sendMessage(localMessage);
    QQToast.a(this.a, paramString1, 0).b(5);
    QLog.i("SetPCActiveState_Failure", 1, "Failed to set PC Active State " + paramString1);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.a, this.a.a, null, "qqsetting_hello_live_message", paramBoolean2);
      QLog.i("CardObserver_onSetHelloLiveMessage", 1, "Set the hell live mesaage result " + paramBoolean1);
      return;
    }
    Message localMessage = NotifyPushSettingActivity.a(this.a).obtainMessage();
    localMessage.what = 10002;
    localMessage.obj = paramString2;
    NotifyPushSettingActivity.a(this.a).sendMessage(localMessage);
    QQToast.a(this.a, paramString1, 0).b(5);
    QLog.i("SetHelloLiveMessage_Failure", 1, "Failed to HelloLiveMessage State " + paramString1);
  }
  
  protected void h(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      Message localMessage = NotifyPushSettingActivity.a(this.a).obtainMessage();
      localMessage.what = 10003;
      localMessage.obj = Boolean.valueOf(paramBoolean2);
      NotifyPushSettingActivity.a(this.a).sendMessage(localMessage);
      QLog.i("CardObserver_onGetHelloLiveMessageState", 1, "Succeeded to Get hello live message State with Msg");
      return;
    }
    QLog.i("CardObserver_onGetHelloLiveMessageState", 1, "Failed to Get  hello live message State with Msg");
  }
  
  protected void i(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      Message localMessage = NotifyPushSettingActivity.a(this.a).obtainMessage();
      localMessage.what = 10000;
      localMessage.obj = Boolean.valueOf(paramBoolean2);
      NotifyPushSettingActivity.a(this.a).sendMessage(localMessage);
      QLog.i("CardObserver_onGetPCActiveState", 1, "Succeeded to Get PC Active State with Msg");
      return;
    }
    QLog.i("CardObserver_onGetPCActiveState", 1, "Failed to Get PC Active State with Msg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     taw
 * JD-Core Version:    0.7.0.1
 */