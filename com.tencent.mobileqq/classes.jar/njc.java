import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;

public class njc
  extends rbg
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  protected ohe a;
  private qsz jdField_a_of_type_Qsz;
  
  protected void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(Map<Integer, pov> paramMap)
  {
    if (this.jdField_a_of_type_Qsz != null) {
      this.jdField_a_of_type_Qsz.a(paramMap);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    ohb.a().b(this.jdField_a_of_type_Ohe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njc
 * JD-Core Version:    0.7.0.1
 */