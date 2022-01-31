import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class slp
  implements Runnable
{
  slp(sll paramsll, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Sll.a.a != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_Sll.a.a.a(str, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slp
 * JD-Core Version:    0.7.0.1
 */