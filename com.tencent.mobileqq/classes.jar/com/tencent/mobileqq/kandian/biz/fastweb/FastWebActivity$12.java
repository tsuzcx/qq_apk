package com.tencent.mobileqq.kandian.biz.fastweb;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.CommentAnchor;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class FastWebActivity$12
  implements ReadInJoyCommentDataManager.OnCommentListLoadListener
{
  FastWebActivity$12(FastWebActivity paramFastWebActivity, String paramString1, String paramString2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    QLog.d("FastWebActivity", 2, "onCommentListLoad");
    this.c.getIntent().removeExtra("intent_key_anchor_data");
    if (!paramBoolean1)
    {
      QRUtils.a(1, 2131915284);
      return;
    }
    paramList = FastWebActivity.o(this.c).f().i();
    if (paramList != null)
    {
      if (!TextUtils.isEmpty(paramList.c))
      {
        this.c.a(true, this.a, this.b, 2130772482, 0);
        FastWebActivity.b(this.c, 1000L);
      }
      else
      {
        FastWebActivity.b(this.c, 100L);
      }
      paramList = new FastWebActivity.12.1(this);
      FastWebActivity.l(this.c).registerDataSetObserver(paramList);
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.12.2(this, paramList), 2000L);
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (paramInt == 1001) {
      QRUtils.a(1, 2131915274);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.12
 * JD-Core Version:    0.7.0.1
 */