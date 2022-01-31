import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class sah
  extends TroopObserver
{
  public sah(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    int i = 1;
    this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      HashMap localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
      for (;;)
      {
        localHashMap.put("result", i + "");
        localHashMap.put("netType", NetworkUtil.a(BaseApplication.getContext()) + "");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
        return;
        if (paramBoolean) {
          i = 0;
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    MultiMsgManager.a().b.clear();
    if ((paramBoolean) && (paramObject != null))
    {
      MultiMsgManager.a().b.putAll((Map)paramObject);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg", 4, "onBatchTroopCardDefaultNick = " + paramObject);
      }
    }
    while (MultiMsgManager.a().b.size() == 0)
    {
      QQToast.a(this.a, 2131433424, 0).b(this.a.getTitleBarHeight());
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg", 4, "onBatchTroopCardDefaultNick failed");
      }
    }
    this.a.a((Map)paramObject, MultiMsgManager.a().a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sah
 * JD-Core Version:    0.7.0.1
 */