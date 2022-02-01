package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$5
  implements OnColorNoteAnimFinishListener
{
  FastWebActivity$5(FastWebActivity paramFastWebActivity) {}
  
  public void onColorNoteAnimFinish()
  {
    FastWebActivity.b(this.a, true);
    FastWebActivity.f(this.a);
    if (FastWebActivity.g(this.a))
    {
      this.a.overridePendingTransition(0, 0);
      FastWebActivity.h(this.a);
    }
    QLog.d("FastWebActivity", 2, "mColorNoteController ：onColorNoteAnimFinish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.5
 * JD-Core Version:    0.7.0.1
 */