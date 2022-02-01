package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.comment.HippyCommentPageListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListFragment;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$MyHippyCommentPageListener
  implements HippyCommentPageListener
{
  private final int b;
  
  FastWebActivity$MyHippyCommentPageListener(FastWebActivity paramFastWebActivity, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    if (FastWebActivity.ai(this.a) == null) {
      return;
    }
    if (paramBoolean)
    {
      QLog.d("FastWebActivity", 1, "hippy init success");
      FastWebActivity.ai(this.a).setTuWenHippyCallback(new FastWebActivity.TKDTuWenHippyCallback(this.a, null));
      FastWebActivity.p(this.a).setOnOpenCommentEditListener(new FastWebActivity.MyOpenCommentEditListener(this.a, null));
      FastWebActivity.aj(this.a);
      FastWebActivity.ak(this.a).a(null);
      FastWebActivity.ak(this.a).getTKDHippyEventDispatcher().register(FastWebActivity.ai(this.a).getSubHippyEventReceiver());
      FastWebActivity.ak(this.a).getTKDHippyEventDispatcher().register(new FastWebActivity.MySubCommentHippyEventListener(this.a, null));
      return;
    }
    QLog.d("FastWebActivity", 1, "hippy init fail");
    FastWebActivity.l(this.a).b(FastWebActivity.ai(this.a));
    FastWebActivity.ai(this.a).destroy();
    FastWebActivity.a(this.a, null);
    FastWebActivity.g(this.a, this.b);
    FastWebActivity.n(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.MyHippyCommentPageListener
 * JD-Core Version:    0.7.0.1
 */