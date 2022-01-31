import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.28.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;

public class rja
  implements bfwv
{
  public rja(FastWebActivity paramFastWebActivity) {}
  
  public void a()
  {
    if (FastWebActivity.f(this.a))
    {
      FastWebActivity.a(this.a).a(FastWebActivity.a(this.a).getWidth());
      FastWebActivity.e(this.a, false);
      FastWebActivity.i(this.a);
      FastWebActivity.a(this.a, new rke(FastWebActivity.a(this.a), FastWebActivity.a(this.a).getFirstVisiblePosition(), FastWebActivity.a(this.a).getLastVisiblePosition()));
      long l = rnx.a("FastWebActivity.show");
      rnx.b("fast_web_show_light_house_draw_finish");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(FastWebActivity.a(this.a));
      ThreadManager.post(new FastWebActivity.28.1(this, l, localArrayList), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rja
 * JD-Core Version:    0.7.0.1
 */