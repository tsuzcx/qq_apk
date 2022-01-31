import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import java.util.ArrayList;

public class qsu
  implements AdapterView.OnItemClickListener
{
  public qsu(EditVideoFragment paramEditVideoFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    EditVideoFragment.a(this.a, (ColumnInfo)EditVideoFragment.a(this.a).get(paramInt));
    if (EditVideoFragment.a(this.a) != null) {
      EditVideoFragment.a(this.a).columnId = EditVideoFragment.a(this.a).columnID;
    }
    EditVideoFragment.a(this.a).notifyDataSetChanged();
    EditVideoFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qsu
 * JD-Core Version:    0.7.0.1
 */