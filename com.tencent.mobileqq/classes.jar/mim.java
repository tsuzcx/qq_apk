import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgTips;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class mim
  implements View.OnClickListener
{
  public mim(ReadinjoySocialMsgTips paramReadinjoySocialMsgTips) {}
  
  public void onClick(View paramView)
  {
    if (ReadinjoySocialMsgTips.a(this.a) != null) {
      ReadinjoySocialMsgTips.a(this.a).onClick(paramView);
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.a().getManager(161);
    int i = localKandianMergeManager.e() - localKandianMergeManager.b();
    if (localKandianMergeManager.b() > 0) {}
    for (paramView = ReadInJoyConstants.g + i;; paramView = ReadInJoyConstants.c + i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySocialMsgTips", 2, "person message box url: " + paramView);
      }
      localKandianMergeManager.b();
      localKandianMergeManager.k();
      ReadInJoyUtils.a(ReadinjoySocialMsgTips.a(this.a), paramView);
      PublicAccountReportUtils.a(null, "", "0X800824B", "0X800824B", 0, 0, "", "", "", ReadInJoyUtils.d(), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mim
 * JD-Core Version:    0.7.0.1
 */