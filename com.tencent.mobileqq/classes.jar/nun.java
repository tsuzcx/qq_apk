import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;

public class nun
  extends rny
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  protected osp a;
  private rfl jdField_a_of_type_Rfl;
  
  protected void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(Map<Integer, qar> paramMap)
  {
    if (this.jdField_a_of_type_Rfl != null) {
      this.jdField_a_of_type_Rfl.a(paramMap);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    osm.a().b(this.jdField_a_of_type_Osp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nun
 * JD-Core Version:    0.7.0.1
 */