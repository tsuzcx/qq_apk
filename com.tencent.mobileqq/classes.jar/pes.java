import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class pes
  implements Runnable
{
  public pes(BaseApplicationImpl paramBaseApplicationImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_retryIndex", Integer.toString(this.jdField_a_of_type_Int));
    localHashMap.put("param_uin", this.jdField_a_of_type_JavaLangString);
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_JavaLangString, "PcActiveSuccB", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     pes
 * JD-Core Version:    0.7.0.1
 */