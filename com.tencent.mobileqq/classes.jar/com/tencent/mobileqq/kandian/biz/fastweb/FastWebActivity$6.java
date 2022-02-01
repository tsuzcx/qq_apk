package com.tencent.mobileqq.kandian.biz.fastweb;

import android.os.Bundle;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;

class FastWebActivity$6
  extends OnColorNoteCurdListener
{
  FastWebActivity$6(FastWebActivity paramFastWebActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    ReportUtil.a(this.a.a, FastWebActivity.a(this.a), this.a.getApplicationContext());
    if (paramBundle.getInt("color_note_curd_from_type") != 1) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.6
 * JD-Core Version:    0.7.0.1
 */