import android.database.DataSetObserver;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;

public class och
  extends DataSetObserver
{
  public och(TagFlowLayout paramTagFlowLayout) {}
  
  public void onChanged()
  {
    super.onChanged();
    TagFlowLayout.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     och
 * JD-Core Version:    0.7.0.1
 */