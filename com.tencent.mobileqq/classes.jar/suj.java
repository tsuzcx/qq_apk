import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import java.util.List;

class suj
  implements Runnable
{
  suj(sui paramsui, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Sui.a) != null)
    {
      Leba.a(this.jdField_a_of_type_Sui.a).clear();
      Leba.a(this.jdField_a_of_type_Sui.a).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Sui.a.a != null) {
        this.jdField_a_of_type_Sui.a.a.notifyDataSetChanged();
      }
      Leba.c(this.jdField_a_of_type_Sui.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     suj
 * JD-Core Version:    0.7.0.1
 */