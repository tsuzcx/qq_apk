import android.view.View;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverSearchDialog;
import com.tencent.biz.qqstory.pgc.adapter.PgcSearchResultAdapter.ListItemData;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class nhz
  implements AdapterView.OnItemClickListener
{
  public nhz(QQStoryDiscoverSearchDialog paramQQStoryDiscoverSearchDialog) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramAdapterView.getItemAtPosition(paramInt);
    if (paramAdapterView != null)
    {
      paramAdapterView = ((PgcSearchResultAdapter.ListItemData)paramAdapterView).a;
      if ((paramAdapterView != null) && (paramAdapterView.type != 0)) {
        break label43;
      }
    }
    for (;;)
    {
      StoryReportor.a("search", "clk_detail", 0, 0, new String[0]);
      return;
      label43:
      if (paramAdapterView.type == 1) {
        StoryApi.a(this.a.a, 19, paramAdapterView.uid);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhz
 * JD-Core Version:    0.7.0.1
 */