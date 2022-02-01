package com.tencent.mobileqq.nearby.interestTag;

import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.utils.NetworkUtil;

class ChooseInterestTagActivity$13
  implements TextWatcher
{
  ChooseInterestTagActivity$13(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ChooseInterestTagActivity.access$400(this.a).removeMessages(4097);
    ChooseInterestTagActivity.access$802(this.a, 0);
    if (ChooseInterestTagActivity.access$2700(this.a).getText() == null) {
      paramEditable = "";
    } else {
      paramEditable = ChooseInterestTagActivity.access$2700(this.a).getText().toString();
    }
    String str = NearbyUtils.a(paramEditable);
    if (ChooseInterestTagActivity.access$2700(this.a).getText() == null) {
      paramEditable = "";
    } else {
      paramEditable = ChooseInterestTagActivity.access$2700(this.a).getText().toString();
    }
    boolean bool2 = TextUtils.isEmpty(paramEditable);
    boolean bool1 = true;
    if (bool2)
    {
      if (ChooseInterestTagActivity.access$1900(this.a).getVisibility() != 8) {
        ChooseInterestTagActivity.access$1900(this.a).setVisibility(8);
      }
      ChooseInterestTagActivity.access$1100(this.a).a(ChooseInterestTagActivity.access$1000(this.a), true);
      paramEditable = this.a;
      if (ChooseInterestTagActivity.access$200(paramEditable) == -1) {
        bool1 = false;
      }
      ChooseInterestTagActivity.access$1400(paramEditable, false, bool1);
      ChooseInterestTagActivity.access$702(this.a, "");
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      if (ChooseInterestTagActivity.access$1900(this.a).getVisibility() != 0) {
        ChooseInterestTagActivity.access$1900(this.a).setVisibility(0);
      }
      ChooseInterestTagActivity.access$2000(this.a).setText(HardCodeUtil.a(2131900040));
      ChooseInterestTagActivity.access$2100(this.a).setVisibility(8);
      ChooseInterestTagActivity.access$702(this.a, "");
      return;
    }
    if (ChooseInterestTagActivity.access$1900(this.a).getVisibility() != 0) {
      ChooseInterestTagActivity.access$1900(this.a).setVisibility(0);
    }
    if (NetworkUtil.isNetSupport(this.a))
    {
      ChooseInterestTagActivity.access$2000(this.a).setText(HardCodeUtil.a(2131900045));
      ChooseInterestTagActivity.access$2100(this.a).setVisibility(8);
      ChooseInterestTagActivity.access$702(this.a, str);
      ChooseInterestTagActivity.access$400(this.a).sendEmptyMessageDelayed(4097, 400L);
      return;
    }
    if (!ChooseInterestTagActivity.access$1500(this.a))
    {
      ChooseInterestTagActivity.access$1600(this.a, HardCodeUtil.a(2131900020));
      ChooseInterestTagActivity.access$1502(this.a, true);
      ChooseInterestTagActivity.access$400(this.a).sendEmptyMessageDelayed(4100, 3000L);
    }
    ChooseInterestTagActivity.access$2000(this.a).setText("");
    ChooseInterestTagActivity.access$2000(this.a).setOnClickListener(null);
    ChooseInterestTagActivity.access$2100(this.a).setVisibility(8);
    ChooseInterestTagActivity.access$702(this.a, "");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    ChooseInterestTagActivity.access$2900(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.13
 * JD-Core Version:    0.7.0.1
 */