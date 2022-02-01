package oicq.wlogin_sdk.request;

import java.util.Comparator;
import java.util.Map.Entry;

final class Ticket$1
  implements Comparator<Map.Entry<String, Long>>
{
  public int compare(Map.Entry<String, Long> paramEntry1, Map.Entry<String, Long> paramEntry2)
  {
    return ((Long)paramEntry1.getValue()).longValue() < ((Long)paramEntry2.getValue()).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.Ticket.1
 * JD-Core Version:    0.7.0.1
 */