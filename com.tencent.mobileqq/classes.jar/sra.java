import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

class sra
  implements srh
{
  sra(sqr paramsqr) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if ((paramProteusItemData instanceof AuthorData))
    {
      ((AuthorData)paramProteusItemData).b();
      if (sqq.a(this.a.a) != null) {
        sqq.a(this.a.a).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sra
 * JD-Core Version:    0.7.0.1
 */