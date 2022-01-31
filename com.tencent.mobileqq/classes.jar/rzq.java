import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.RecommendAndAdCallback.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import java.lang.ref.WeakReference;
import java.util.List;

public class rzq
  implements scu
{
  private WeakReference<FastWebActivity> a;
  
  public rzq(FastWebActivity paramFastWebActivity)
  {
    this.a = new WeakReference(paramFastWebActivity);
  }
  
  public void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    FastWebActivity localFastWebActivity = (FastWebActivity)this.a.get();
    if (localFastWebActivity == null) {
      return;
    }
    localFastWebActivity.runOnUiThread(new FastWebActivity.RecommendAndAdCallback.1(this, paramList1, paramList2, localFastWebActivity, paramBoolean, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rzq
 * JD-Core Version:    0.7.0.1
 */