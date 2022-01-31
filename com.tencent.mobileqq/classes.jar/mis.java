import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import cooperation.readinjoy.ReadInJoyHelper;

public class mis
  implements Runnable
{
  public mis(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    int k = 2;
    boolean bool;
    String str;
    label90:
    int i;
    int j;
    if (!ReadInJoyListViewGroup.a(this.a)) {
      if ((this.a.a() instanceof BaseActivity))
      {
        bool = SharedPreUtils.v(this.a.getContext(), ((BaseActivity)this.a.a()).getCurrentAccountUin());
        if ((this.a.getContext() instanceof BaseActivity))
        {
          str = ((ReadInJoySkinManager)((BaseActivity)this.a.getContext()).app.getManager(260)).a();
          if ((TextUtils.isEmpty(str)) || (str.equals("0")))
          {
            i = 0;
            str = "0";
            j = 0;
            if (!(this.a.getContext() instanceof BaseActivity)) {
              break label380;
            }
            ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)((BaseActivity)this.a.getContext()).app.getManager(269);
            if ((localReadInJoyRefreshManager.a() != 1) || (!localReadInJoyRefreshManager.a())) {
              break label380;
            }
            str = localReadInJoyRefreshManager.a();
            j = 0;
            i = k;
          }
        }
      }
    }
    for (;;)
    {
      if (this.a.a == 40677)
      {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009294", "0X8009294", 0, 0, ReadInJoyHelper.a(), "", "", ReadInJoyUtils.a(this.a.a, str, j, i), false);
        PublicAccountReportUtils.a("0X8009294", "", "", "", "", ReadInJoyUtils.a(this.a.a));
      }
      for (;;)
      {
        if (this.a.a == 56) {
          PublicAccountReportUtils.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", VideoReporter.a(this.a.a, null), false);
        }
        return;
        if (bool)
        {
          i = 1;
          j = 1;
          break;
        }
        i = 1;
        j = 2;
        break;
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F8", "0X80066F8", 0, 0, ReadInJoyHelper.a(), "", "", ReadInJoyUtils.a(this.a.a, str, j, i), false);
        PublicAccountReportUtils.a("0X80066F8", "", "", "", "", ReadInJoyUtils.a(this.a.a));
      }
      label380:
      continue;
      str = "0";
      break label90;
      bool = false;
      break;
      i = 0;
      str = "0";
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mis
 * JD-Core Version:    0.7.0.1
 */