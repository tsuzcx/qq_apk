import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

public class sxm
  extends sxk
{
  private List<String> jdField_a_of_type_JavaUtilList;
  private sxn jdField_a_of_type_Sxn;
  private List<String> b;
  protected boolean b;
  
  public sxm(Activity paramActivity, sxn paramsxn, List<String> paramList1, List<String> paramList2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Sxn = paramsxn;
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_b_of_type_JavaUtilList = paramList2;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = (LinearLayout)paramLayoutInflater.inflate(2131560144, null);
    RecyclerView localRecyclerView = (RecyclerView)paramLayoutInflater.findViewById(2131364953);
    oyv localoyv = new oyv(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_Sxn);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity));
    localRecyclerView.setAdapter(localoyv);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxm
 * JD-Core Version:    0.7.0.1
 */