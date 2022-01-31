import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyMsgManagerActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lhx
  implements ActionSheet.OnButtonClickListener
{
  public lhx(ReadinjoyMsgManagerActivity paramReadinjoyMsgManagerActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      ReadinjoyMsgManagerActivity.a(this.a).dismiss();
      return;
      ReadinjoyMsgManagerActivity.a(this.a).a("正在设置");
      ReadinjoyMsgManagerActivity.a(this.a).show();
      ReadinjoyMsgManagerActivity.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhx
 * JD-Core Version:    0.7.0.1
 */