import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.ArrayList;

class svc
  implements svf
{
  svc(sup paramsup) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if (((suo.a(this.a.a) instanceof ssq)) && ((paramContext instanceof FastWebActivity)))
    {
      if (sup.a(this.a) == null) {
        sup.a(this.a, new ArrayList());
      }
      svs.a(paramProteusItemData.b, paramProteusItemData.a, (FastWebActivity)paramContext, paramProteusItemData.c, ((ssq)suo.a(this.a.a)).a(), sup.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svc
 * JD-Core Version:    0.7.0.1
 */