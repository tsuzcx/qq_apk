import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;

public class oir
  extends stf
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  protected pfh a;
  private ske jdField_a_of_type_Ske;
  
  protected void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(Map<Integer, qvp> paramMap)
  {
    if (this.jdField_a_of_type_Ske != null) {
      this.jdField_a_of_type_Ske.a(paramMap);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    pfd.a().b(this.jdField_a_of_type_Pfh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oir
 * JD-Core Version:    0.7.0.1
 */