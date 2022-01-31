import java.util.HashMap;

public class now
{
  private static HashMap<Integer, Integer> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(1105), Integer.valueOf(4));
    a.put(Integer.valueOf(1106), Integer.valueOf(3));
    a.put(Integer.valueOf(1107), Integer.valueOf(4));
    a.put(Integer.valueOf(1103), Integer.valueOf(101));
    a.put(Integer.valueOf(1104), Integer.valueOf(102));
    a.put(Integer.valueOf(1108), Integer.valueOf(103));
    a.put(Integer.valueOf(1109), Integer.valueOf(104));
  }
  
  public static int a(int paramInt)
  {
    if (a.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)a.get(Integer.valueOf(paramInt))).intValue();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     now
 * JD-Core Version:    0.7.0.1
 */