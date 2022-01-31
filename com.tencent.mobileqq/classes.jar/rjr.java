import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.RecommendAndAdCallback.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import java.lang.ref.WeakReference;
import java.util.List;

public class rjr
  implements rmy
{
  private WeakReference<FastWebActivity> a;
  
  public rjr(FastWebActivity paramFastWebActivity)
  {
    this.a = new WeakReference(paramFastWebActivity);
  }
  
  public void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    FastWebActivity localFastWebActivity = (FastWebActivity)this.a.get();
    if (localFastWebActivity == null) {
      return;
    }
    localFastWebActivity.runOnUiThread(new FastWebActivity.RecommendAndAdCallback.1(this, localFastWebActivity, paramBoolean, paramString, paramList1, paramList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjr
 * JD-Core Version:    0.7.0.1
 */