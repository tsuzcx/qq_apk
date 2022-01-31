import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class len
  implements ActionSheet.OnButtonClickListener
{
  public len(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReadInJoySettingActivity.c(this.a).d(paramInt);
    ((TextView)this.a.findViewById(2131367303)).setText(ReadInJoySettingActivity.a(this.a)[paramInt]);
    ReadInJoyUtils.a(Integer.toString(paramInt));
    PublicAccountReportUtils.a(null, "", "0X8007416", "0X8007416", 0, 0, Integer.toString(paramInt), "", "", "", false);
    ReadInJoySettingActivity.c(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     len
 * JD-Core Version:    0.7.0.1
 */