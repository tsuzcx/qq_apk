import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;

public class nuj
  extends rnv
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  protected osm a;
  private rfi jdField_a_of_type_Rfi;
  
  protected void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(Map<Integer, qao> paramMap)
  {
    if (this.jdField_a_of_type_Rfi != null) {
      this.jdField_a_of_type_Rfi.a(paramMap);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    osj.a().b(this.jdField_a_of_type_Osm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuj
 * JD-Core Version:    0.7.0.1
 */