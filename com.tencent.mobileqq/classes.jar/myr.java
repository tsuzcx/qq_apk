import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import java.util.HashMap;
import java.util.Map;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;

public class myr
{
  private static Map<Integer, Integer> a = new HashMap(16);
  
  static
  {
    a.put(Integer.valueOf(1), Integer.valueOf(1));
    a.put(Integer.valueOf(2), Integer.valueOf(1));
    a.put(Integer.valueOf(3), Integer.valueOf(1));
    a.put(Integer.valueOf(4), Integer.valueOf(1));
    a.put(Integer.valueOf(101), Integer.valueOf(1));
    a.put(Integer.valueOf(102), Integer.valueOf(2));
    a.put(Integer.valueOf(103), Integer.valueOf(2));
    a.put(Integer.valueOf(104), Integer.valueOf(2));
    a.put(Integer.valueOf(105), Integer.valueOf(2));
    a.put(Integer.valueOf(106), Integer.valueOf(2));
    a.put(Integer.valueOf(107), Integer.valueOf(2));
    a.put(Integer.valueOf(108), Integer.valueOf(2));
    a.put(Integer.valueOf(110), Integer.valueOf(2));
    a.put(Integer.valueOf(201), Integer.valueOf(2));
  }
  
  private static anud a(AVGameAppInterface paramAVGameAppInterface, int paramInt)
  {
    if (paramAVGameAppInterface == null) {
      return null;
    }
    paramInt = ((Integer)a.get(Integer.valueOf(paramInt))).intValue();
    if (paramInt == 1) {
      paramAVGameAppInterface = paramAVGameAppInterface.a(1);
    }
    for (;;)
    {
      return paramAVGameAppInterface;
      if (paramInt == 2) {
        paramAVGameAppInterface = paramAVGameAppInterface.a(3);
      } else {
        paramAVGameAppInterface = null;
      }
    }
  }
  
  public static void a(AVGameAppInterface paramAVGameAppInterface, AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    paramAVGameAppInterface = a(paramAVGameAppInterface, paramNotifyMsg.type.get());
    if (paramAVGameAppInterface != null)
    {
      if (!(paramAVGameAppInterface instanceof nad)) {
        break label32;
      }
      ((nad)paramAVGameAppInterface).a(paramNotifyMsg);
    }
    label32:
    while (!(paramAVGameAppInterface instanceof nac)) {
      return;
    }
    ((nac)paramAVGameAppInterface).a(paramNotifyMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myr
 * JD-Core Version:    0.7.0.1
 */