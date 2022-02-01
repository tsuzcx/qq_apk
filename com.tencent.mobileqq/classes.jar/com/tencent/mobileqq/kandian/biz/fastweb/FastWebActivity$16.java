package com.tencent.mobileqq.kandian.biz.fastweb;

import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;

class FastWebActivity$16
  implements MessageQueue.IdleHandler
{
  FastWebActivity$16(FastWebActivity paramFastWebActivity) {}
  
  public boolean queueIdle()
  {
    String str;
    if (FastWebActivity.d(this.a).B == 0) {
      str = "";
    } else {
      str = FastWebActivity.d(this.a).C;
    }
    int i = this.a.getIntent().getIntExtra("floating_window_scene", 0);
    FastWebRequestUtil.a(FastWebActivity.d(this.a).x, FastWebActivity.d(this.a).q, String.valueOf(FastWebActivity.d(this.a).y), FastWebActivity.d(this.a).t, FastWebActivity.d(this.a).a(), str, FastWebActivity.d(this.a).u, FastWebActivity.d(this.a).v, FastWebActivity.q(this.a), FastWebActivity.r(this.a), i, this.a.g.mChannelID, FastWebActivity.k(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.16
 * JD-Core Version:    0.7.0.1
 */