import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import cooperation.readinjoy.ReadInJoyHelper;

public class lcr
  implements PopupMenuDialog.OnClickActionListener
{
  public lcr(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity, KandianMergeManager paramKandianMergeManager) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    switch (paramMenuItem.a)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      do
      {
        return;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c()) {}
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(bool1);
          if (!bool1) {
            break;
          }
          QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getResources().getString(2131428461), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
          return;
          bool1 = false;
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800705C", "0X800705C", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
        return;
        ThreadManager.postImmediately(new lcs(this), null, true);
        paramMenuItem = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity, ReadInJoySettingActivity.class);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.startActivity(paramMenuItem);
        ReportController.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", ReadInJoyUtils.c());
        return;
        paramMenuItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getAppRuntime();
        if (!ReadInJoyHelper.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getAppRuntime())) {}
        for (bool1 = bool2;; bool1 = false)
        {
          ReadInJoyHelper.b(paramMenuItem, bool1);
          ReadInJoyLogicEngineEventDispatcher.a().b();
          return;
        }
        if (paramMenuItem.a == 3) {
          ReadInJoyUtils.c = -2;
        }
        for (;;)
        {
          QLog.d("ReadInJoyBaseActivity", 1, "readinjoy setting feeds type:" + ReadInJoyUtils.c);
          return;
          if (paramMenuItem.a == 4) {
            ReadInJoyUtils.c = -1;
          } else if (paramMenuItem.a == 5) {
            ReadInJoyUtils.c = 1;
          } else if (paramMenuItem.a == 6) {
            ReadInJoyUtils.c = 0;
          }
        }
        paramMenuItem = ReadInJoyUtils.a();
        if (TextUtils.isEmpty(paramMenuItem)) {
          QLog.e("ReadInJoyBaseActivity", 2, "click personal page , but uin is empty !");
        }
        for (;;)
        {
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007384", "0X8007384", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
          return;
          paramMenuItem = ReadInJoyConstants.f + Base64Util.encodeToString(paramMenuItem.getBytes(), 2);
          ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity, paramMenuItem);
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007383", "0X8007383", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
        ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity, ReadInJoyConstants.c);
      } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.e());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
      return;
    case 9: 
      paramMenuItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getAppRuntime();
      if (!ReadInJoyHelper.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getAppRuntime())) {}
      for (bool1 = bool3;; bool1 = false)
      {
        ReadInJoyHelper.e(paramMenuItem, bool1);
        return;
      }
    }
    paramMenuItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getAppRuntime();
    if (!ReadInJoyHelper.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getAppRuntime())) {}
    for (bool1 = bool4;; bool1 = false)
    {
      ReadInJoyHelper.f(paramMenuItem, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcr
 * JD-Core Version:    0.7.0.1
 */