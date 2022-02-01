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
    if (FastWebActivity.a(this.a).c == 0) {
      str = "";
    } else {
      str = FastWebActivity.a(this.a).p;
    }
    int i = this.a.getIntent().getIntExtra("floating_window_scene", 0);
    FastWebRequestUtil.a(FastWebActivity.a(this.a).o, FastWebActivity.a(this.a).j, String.valueOf(FastWebActivity.a(this.a).e), FastWebActivity.a(this.a).l, FastWebActivity.a(this.a).a(), str, FastWebActivity.a(this.a).m, FastWebActivity.a(this.a).n, FastWebActivity.a(this.a), FastWebActivity.b(this.a), i, this.a.a.mChannelID, FastWebActivity.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.16
 * JD-Core Version:    0.7.0.1
 */