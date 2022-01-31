import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.tag.TagAdapter;
import com.tencent.biz.qqstory.storyHome.tag.TagAdapter.OnItemClickListener;

public class oak
  implements View.OnClickListener
{
  public oak(TagAdapter paramTagAdapter) {}
  
  public void onClick(View paramView)
  {
    TagAdapter.a(this.a, false);
    this.a.notifyDataSetChanged();
    if (TagAdapter.a(this.a) != null) {
      TagAdapter.a(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oak
 * JD-Core Version:    0.7.0.1
 */