import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class sgx
  implements Runnable
{
  sgx(sgt paramsgt, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Sgt.a.a != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_Sgt.a.a.a(str, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgx
 * JD-Core Version:    0.7.0.1
 */