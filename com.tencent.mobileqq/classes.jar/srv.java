import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.30.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.XListView.DrawFinishedListener;
import java.util.ArrayList;
import java.util.List;

public class srv
  implements XListView.DrawFinishedListener
{
  public srv(FastWebActivity paramFastWebActivity) {}
  
  public void drawFinished()
  {
    if (FastWebActivity.f(this.a))
    {
      FastWebActivity.a(this.a).a(FastWebActivity.a(this.a).getWidth());
      FastWebActivity.d(this.a, false);
      FastWebActivity.h(this.a);
      FastWebActivity.a(this.a, new ssz(FastWebActivity.a(this.a), FastWebActivity.a(this.a).getFirstVisiblePosition(), FastWebActivity.a(this.a).getLastVisiblePosition()));
      long l = sxd.a("FastWebActivity.show");
      sxd.b("fast_web_show_light_house_draw_finish");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(FastWebActivity.a(this.a));
      ThreadManager.post(new FastWebActivity.30.1(this, l, localArrayList), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srv
 * JD-Core Version:    0.7.0.1
 */