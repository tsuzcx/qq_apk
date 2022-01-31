import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class mth
{
  private static final Map<String, Long> a = new HashMap(5);
  private static final Map<String, Long> b = new HashMap(5);
  
  public static void a(String paramString1, String paramString2, int paramInt, Object... paramVarArgs)
  {
    int j = 0;
    if (QLog.isColorLevel())
    {
      long l2 = SystemClock.elapsedRealtime();
      Object localObject1 = (Long)b.get(paramString1);
      long l1;
      if ((paramInt == 1) || (localObject1 == null))
      {
        a.put(paramString1, Long.valueOf(l2));
        b.put(paramString1, Long.valueOf(l2));
        l1 = 0L;
      }
      for (;;)
      {
        Object localObject2 = "[]";
        localObject1 = localObject2;
        if (paramVarArgs == null) {
          break label210;
        }
        localObject1 = localObject2;
        if (paramVarArgs.length <= 0) {
          break label210;
        }
        localObject1 = new StringBuilder(100);
        ((StringBuilder)localObject1).append("[");
        int k = paramVarArgs.length;
        int i = 0;
        while (i < k)
        {
          localObject2 = paramVarArgs[i];
          if (j > 0) {
            ((StringBuilder)localObject1).append(",");
          }
          ((StringBuilder)localObject1).append(localObject2);
          j += 1;
          i += 1;
        }
        l1 = l2 - ((Long)localObject1).longValue();
        b.put(paramString1, Long.valueOf(l2));
      }
      ((StringBuilder)localObject1).append("]");
      localObject1 = ((StringBuilder)localObject1).toString();
      label210:
      QLog.i("AVTraceUtil", 2, paramString1 + "--" + paramString2 + "--" + (String)localObject1 + "--" + l1);
      if (paramInt == 2)
      {
        paramVarArgs = (Long)a.get(paramString1);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = Long.valueOf(l2);
        }
        l1 = paramString2.longValue();
        QLog.i("AVTraceUtil", 2, paramString1 + ": " + (l2 - l1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mth
 * JD-Core Version:    0.7.0.1
 */