import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import java.util.List;

class tcc
  implements Runnable
{
  tcc(tcb paramtcb, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Tcb.a) != null)
    {
      Leba.a(this.jdField_a_of_type_Tcb.a).clear();
      Leba.a(this.jdField_a_of_type_Tcb.a).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Tcb.a.a != null) {
        this.jdField_a_of_type_Tcb.a.a.notifyDataSetChanged();
      }
      Leba.c(this.jdField_a_of_type_Tcb.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcc
 * JD-Core Version:    0.7.0.1
 */