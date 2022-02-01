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
    if ((FastWebActivity.O(this.this$0) != null) && (FastWebActivity.o(this.this$0) != null))
    {
      if (FastWebActivity.O(this.this$0).d)
      {
        FastWebActivity.o(this.this$0).j();
        return;
      }
      FastWebActivity.o(this.this$0).i();
      return;
    }
    QLog.d("FastWebActivity", 1, "error! scrollToHotNewComment");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.31
 * JD-Core Version:    0.7.0.1
 */