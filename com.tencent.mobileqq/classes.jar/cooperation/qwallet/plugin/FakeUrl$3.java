package cooperation.qwallet.plugin;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class FakeUrl$3
  extends ClickableSpan
{
  FakeUrl$3(FakeUrl paramFakeUrl, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("span click url = ");
    paramView.append(this.val$url);
    QLog.i("FakeUrl", 2, paramView.toString());
    if ((FakeUrl.access$000(this.this$0)) && (FakeUrl.access$100(this.this$0) != null) && (FakeUrl.access$100(this.this$0).isShowing())) {
      FakeUrl.access$100(this.this$0).dismiss();
    }
    if ((this.this$0.fl != null) && (this.this$0.fl.onClickUrl(this.val$url))) {
      return;
    }
    this.this$0.parseFakeUrl(this.val$url);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.FakeUrl.3
 * JD-Core Version:    0.7.0.1
 */