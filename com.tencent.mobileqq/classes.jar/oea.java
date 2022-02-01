import java.util.Comparator;
import java.util.Map.Entry;

class oea
  implements Comparator<Map.Entry<Long, Long>>
{
  oea(odz paramodz) {}
  
  public int a(Map.Entry<Long, Long> paramEntry1, Map.Entry<Long, Long> paramEntry2)
  {
    return ((Long)paramEntry1.getValue()).compareTo((Long)paramEntry2.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oea
 * JD-Core Version:    0.7.0.1
 */