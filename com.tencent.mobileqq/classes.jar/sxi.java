import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import java.util.List;

class sxi
  implements Runnable
{
  sxi(sxh paramsxh, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Sxh.a) != null)
    {
      Leba.a(this.jdField_a_of_type_Sxh.a).clear();
      Leba.a(this.jdField_a_of_type_Sxh.a).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Sxh.a.a != null) {
        this.jdField_a_of_type_Sxh.a.a.notifyDataSetChanged();
      }
      Leba.c(this.jdField_a_of_type_Sxh.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxi
 * JD-Core Version:    0.7.0.1
 */