import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;

public class nxo
  extends sdu
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  protected oxe a;
  private rve jdField_a_of_type_Rve;
  
  protected void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(Map<Integer, qkk> paramMap)
  {
    if (this.jdField_a_of_type_Rve != null) {
      this.jdField_a_of_type_Rve.a(paramMap);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    oxb.a().b(this.jdField_a_of_type_Oxe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nxo
 * JD-Core Version:    0.7.0.1
 */