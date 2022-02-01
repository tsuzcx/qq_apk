package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.event.FastWebAdapterShowHelper;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.widget.XListView.DrawFinishedListener;
import java.util.ArrayList;
import java.util.List;

class FastWebActivity$29
  implements XListView.DrawFinishedListener
{
  FastWebActivity$29(FastWebActivity paramFastWebActivity) {}
  
  public void drawFinished()
  {
    if (FastWebActivity.L(this.a))
    {
      FastWebActivity.z(this.a).a(FastWebActivity.w(this.a).getWidth());
      FastWebActivity.f(this.a, false);
      FastWebActivity.M(this.a);
      Object localObject = this.a;
      FastWebActivity.a((FastWebActivity)localObject, new FastWebAdapterShowHelper(FastWebActivity.w((FastWebActivity)localObject), FastWebActivity.w(this.a).getFirstVisiblePosition(), FastWebActivity.w(this.a).getLastVisiblePosition()));
      long l = TimeUtil.a("FastWebActivity.show");
      TimeUtil.b("fast_web_show_light_house_draw_finish");
      localObject = new ArrayList();
      ((List)localObject).addAll(FastWebActivity.m(this.a));
      ThreadManager.post(new FastWebActivity.29.1(this, l, (List)localObject), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.29
 * JD-Core Version:    0.7.0.1
 */