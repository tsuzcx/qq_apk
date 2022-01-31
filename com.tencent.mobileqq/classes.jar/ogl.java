import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.EditVideoPoiSearch;

public class ogl
  implements TextWatcher
{
  public ogl(EditVideoPoiSearch paramEditVideoPoiSearch) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    EditVideoPartManager localEditVideoPartManager = this.a.a;
    if (this.a.a.a()) {}
    for (paramEditable = "2";; paramEditable = "1")
    {
      localEditVideoPartManager.a("search_poi", 0, 0, new String[] { paramEditable });
      VideoEditReport.a("0X80076D1");
      VideoEditReport.b("0X80075E6");
      EditVideoPoiSearch.a(this.a);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogl
 * JD-Core Version:    0.7.0.1
 */