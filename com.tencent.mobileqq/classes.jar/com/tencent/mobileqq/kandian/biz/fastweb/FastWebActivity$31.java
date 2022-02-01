package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$31
  implements Runnable
{
  FastWebActivity$31(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    if ((FastWebActivity.a(this.this$0) != null) && (FastWebActivity.a(this.this$0) != null))
    {
      if (FastWebActivity.a(this.this$0).b)
      {
        FastWebActivity.a(this.this$0).f();
        return;
      }
      FastWebActivity.a(this.this$0).e();
      return;
    }
    QLog.d("FastWebActivity", 1, "error! scrollToHotNewComment");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.31
 * JD-Core Version:    0.7.0.1
 */