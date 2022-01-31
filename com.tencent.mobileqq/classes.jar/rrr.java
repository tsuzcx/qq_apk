import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

public class rrr
  extends rrp
{
  private List<String> jdField_a_of_type_JavaUtilList;
  private rrs jdField_a_of_type_Rrs;
  private List<String> b;
  protected boolean b;
  
  public rrr(Activity paramActivity, rrs paramrrs, List<String> paramList1, List<String> paramList2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Rrs = paramrrs;
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_b_of_type_JavaUtilList = paramList2;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = (LinearLayout)paramLayoutInflater.inflate(2131559890, null);
    RecyclerView localRecyclerView = (RecyclerView)paramLayoutInflater.findViewById(2131364609);
    omn localomn = new omn(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_Rrs);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity));
    localRecyclerView.setAdapter(localomn);
    return paramLayoutInflater;
  }
  
  public void b(View paramView)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      a();
      this.jdField_b_of_type_Boolean = true;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrr
 * JD-Core Version:    0.7.0.1
 */