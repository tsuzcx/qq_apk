import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListAdapter;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListAdapter.ItemHolder;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView.OnCheckBoxClickListener;

public class ntb
  implements View.OnClickListener
{
  public ntb(StoryPickerHorizontalListAdapter.ItemHolder paramItemHolder) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (this.a.a.a != null) {
      this.a.a.a.a(paramView, this.a.a.a(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntb
 * JD-Core Version:    0.7.0.1
 */