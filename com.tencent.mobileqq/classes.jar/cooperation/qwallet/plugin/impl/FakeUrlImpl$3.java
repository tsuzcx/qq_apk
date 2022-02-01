package cooperation.qwallet.plugin.impl;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IFakeUrl.FakeListener;

class FakeUrlImpl$3
  extends ClickableSpan
{
  FakeUrlImpl$3(FakeUrlImpl paramFakeUrlImpl, String paramString) {}
  
  public void onClick(View paramView)
  {
    QLog.i("FakeUrl", 2, "span click url = " + this.val$url);
    if ((FakeUrlImpl.access$000(this.this$0)) && (FakeUrlImpl.access$100(this.this$0) != null) && (FakeUrlImpl.access$100(this.this$0).isShowing())) {
      FakeUrlImpl.access$100(this.this$0).dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.FakeUrlImpl.3
 * JD-Core Version:    0.7.0.1
 */