import android.widget.EditText;
import com.tencent.biz.qqstory.takevideo.EditVideoPoiSearch;
import com.tencent.util.InputMethodUtil;

public class oep
  implements Runnable
{
  public oep(EditVideoPoiSearch paramEditVideoPoiSearch) {}
  
  public void run()
  {
    this.a.a.setFocusableInTouchMode(true);
    this.a.a.requestFocus();
    InputMethodUtil.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oep
 * JD-Core Version:    0.7.0.1
 */