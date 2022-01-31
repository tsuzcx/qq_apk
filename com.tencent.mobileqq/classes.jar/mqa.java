import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.XListView.DrawFinishedListener;
import java.util.ArrayList;
import java.util.List;

public class mqa
  implements XListView.DrawFinishedListener
{
  public mqa(FastWebActivity paramFastWebActivity) {}
  
  public void a()
  {
    if (FastWebActivity.f(this.a))
    {
      FastWebActivity.c(this.a, false);
      FastWebActivity.e(this.a);
      long l = TimeUtil.a("FastWebActivity.show");
      TimeUtil.b("fast_web_show_light_house_draw_finish");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(FastWebActivity.a(this.a));
      ThreadManager.post(new mqb(this, l, localArrayList), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqa
 * JD-Core Version:    0.7.0.1
 */