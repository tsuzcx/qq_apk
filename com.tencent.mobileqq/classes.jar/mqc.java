import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.RecommendAndAdCallback;
import java.util.List;

public class mqc
  implements FastWebRequestUtil.RecommendAndAdCallback
{
  public mqc(FastWebActivity paramFastWebActivity) {}
  
  public void a(boolean paramBoolean, String paramString, List paramList1, List paramList2)
  {
    this.a.runOnUiThread(new mqd(this, paramBoolean, paramString, paramList1, paramList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqc
 * JD-Core Version:    0.7.0.1
 */