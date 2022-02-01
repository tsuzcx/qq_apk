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
    SpannableString localSpannableString = new SpannableString(VoiceScan.a(this.this$0).getString(2131896468));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(VoiceScan.a(this.this$0).getResources().getColor(2131165990), VoiceScan.a(this.this$0).getResources().getColor(2131165998)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    VoiceScan localVoiceScan = this.this$0;
    VoiceScan.a(localVoiceScan, DialogUtil.a(VoiceScan.a(localVoiceScan), VoiceScan.a(this.this$0).getString(2131896467), localSpannableString, 0, 2131887629, null, null, new VoiceScan.1.1(this)));
    VoiceScan.b(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */