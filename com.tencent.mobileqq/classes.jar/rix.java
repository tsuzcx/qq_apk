import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.28.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;

public class rix
  implements bfxm
{
  public rix(FastWebActivity paramFastWebActivity) {}
  
  public void a()
  {
    if (FastWebActivity.f(this.a))
    {
      FastWebActivity.a(this.a).a(FastWebActivity.a(this.a).getWidth());
      FastWebActivity.e(this.a, false);
      FastWebActivity.i(this.a);
      FastWebActivity.a(this.a, new rkb(FastWebActivity.a(this.a), FastWebActivity.a(this.a).getFirstVisiblePosition(), FastWebActivity.a(this.a).getLastVisiblePosition()));
      long l = rnu.a("FastWebActivity.show");
      rnu.b("fast_web_show_light_house_draw_finish");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(FastWebActivity.a(this.a));
      ThreadManager.post(new FastWebActivity.28.1(this, l, localArrayList), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rix
 * JD-Core Version:    0.7.0.1
 */