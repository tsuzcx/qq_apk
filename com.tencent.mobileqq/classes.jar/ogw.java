import android.database.DataSetObserver;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;

public class ogw
  extends DataSetObserver
{
  public ogw(TagFlowLayout paramTagFlowLayout) {}
  
  public void onChanged()
  {
    super.onChanged();
    TagFlowLayout.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogw
 * JD-Core Version:    0.7.0.1
 */