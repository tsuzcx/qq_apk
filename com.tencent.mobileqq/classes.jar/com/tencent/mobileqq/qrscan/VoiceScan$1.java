package com.tencent.mobileqq.qrscan;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

class VoiceScan$1
  implements Runnable
{
  VoiceScan$1(VoiceScan paramVoiceScan) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(VoiceScan.a(this.this$0).getString(2131698522));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(VoiceScan.a(this.this$0).getResources().getColor(2131165601), VoiceScan.a(this.this$0).getResources().getColor(2131165606)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    VoiceScan localVoiceScan = this.this$0;
    VoiceScan.a(localVoiceScan, DialogUtil.a(VoiceScan.a(localVoiceScan), VoiceScan.a(this.this$0).getString(2131698521), localSpannableString, 0, 2131690709, null, null, new VoiceScan.1.1(this)));
    VoiceScan.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */