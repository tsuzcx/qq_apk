import android.database.DataSetObserver;
import com.tencent.biz.qqstory.view.segment.SegmentManager;

public class oow
  extends DataSetObserver
{
  public oow(SegmentManager paramSegmentManager) {}
  
  public void onChanged()
  {
    SegmentManager.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oow
 * JD-Core Version:    0.7.0.1
 */