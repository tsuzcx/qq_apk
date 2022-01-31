import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.tag.TagAdapter;
import com.tencent.biz.qqstory.storyHome.tag.TagAdapter.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;

public class oan
{
  public TextView a;
  
  public oan(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131367202));
  }
  
  public void a(TagItem.TagInfoBase paramTagInfoBase, TagAdapter.OnItemClickListener paramOnItemClickListener)
  {
    if (TextUtils.isEmpty(paramTagInfoBase.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(TagAdapter.a(paramTagInfoBase));
    TagAdapter.a(this.a);
    this.a.setOnClickListener(new oao(this, paramOnItemClickListener, paramTagInfoBase));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oan
 * JD-Core Version:    0.7.0.1
 */