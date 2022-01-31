import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

public class rfb
  extends rez
{
  private List<String> jdField_a_of_type_JavaUtilList;
  private rfc jdField_a_of_type_Rfc;
  private List<String> b;
  protected boolean b;
  
  public rfb(Activity paramActivity, rfc paramrfc, List<String> paramList1, List<String> paramList2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Rfc = paramrfc;
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_b_of_type_JavaUtilList = paramList2;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = (LinearLayout)paramLayoutInflater.inflate(2131494319, null);
    RecyclerView localRecyclerView = (RecyclerView)paramLayoutInflater.findViewById(2131299049);
    obc localobc = new obc(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_Rfc);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity));
    localRecyclerView.setAdapter(localobc);
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
 * Qualified Name:     rfb
 * JD-Core Version:    0.7.0.1
 */