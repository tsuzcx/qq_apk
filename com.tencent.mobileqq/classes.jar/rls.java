import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class rls
  implements AdapterView.OnItemClickListener
{
  public rls(EditVideoFragment paramEditVideoFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if ((paramView.getTag(2131365915) instanceof Boolean)) {
        bool1 = ((Boolean)paramView.getTag(2131365915)).booleanValue();
      }
    }
    if (!bool1)
    {
      EditVideoFragment.a(this.a, (ColumnInfo)EditVideoFragment.a(this.a).get(paramInt));
      if (EditVideoFragment.a(this.a) == null) {}
    }
    for (EditVideoFragment.a(this.a).columnId = EditVideoFragment.a(this.a).columnID;; EditVideoFragment.a(this.a).columnId = 0L)
    {
      EditVideoFragment.a(this.a).notifyDataSetChanged();
      EditVideoFragment.a(this.a);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      EditVideoFragment.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rls
 * JD-Core Version:    0.7.0.1
 */