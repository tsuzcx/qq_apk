import android.database.DataSetObserver;
import com.tencent.biz.qqstory.view.segment.SegmentManager;

public class oqq
  extends DataSetObserver
{
  public oqq(SegmentManager paramSegmentManager) {}
  
  public void onChanged()
  {
    SegmentManager.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqq
 * JD-Core Version:    0.7.0.1
 */