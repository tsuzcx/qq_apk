import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lxt
  implements ActionSheet.OnButtonClickListener
{
  public lxt(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (ReadInJoyDeliverUGCActivity.a(this.a)) {
      return;
    }
    ReadInJoyDeliverUGCActivity.a(this.a, true);
    ReadInJoyDeliverUGCActivity.b(this.a, ReadInJoyDeliverUGCActivity.b(this.a));
    switch (paramInt)
    {
    }
    for (;;)
    {
      ReadInJoyDeliverUGCActivity.a(this.a).dismiss();
      return;
      ReadInJoyDeliverUGCActivity.a(this.a);
      PublicAccountReportUtils.a(null, "", "0X8008239", "0X8008239", 0, 0, "", "", "", ReadInJoyUtils.e(), false);
      continue;
      ReadInJoyDeliverUGCActivity.b(this.a);
      PublicAccountReportUtils.a(null, "", "0X800823A", "0X800823A", 0, 0, "", "", "", ReadInJoyUtils.e(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lxt
 * JD-Core Version:    0.7.0.1
 */