package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebDataInsertUtils;
import java.util.List;

class FastWebActivity$25$2
  implements Runnable
{
  FastWebActivity$25$2(FastWebActivity.25 param25, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (this.a != null) {
      FastWebDataInsertUtils.a(this.c.a.g, FastWebActivity.d(this.c.a), FastWebActivity.m(this.c.a), this.a, this.c.a.n);
    }
    if (this.b != null) {
      FastWebDataInsertUtils.a(FastWebActivity.K(this.c.a), this.c.a.g, FastWebActivity.d(this.c.a), FastWebActivity.m(this.c.a), this.b, this.c.a.n);
    }
    FastWebActivity.n(this.c.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.25.2
 * JD-Core Version:    0.7.0.1
 */