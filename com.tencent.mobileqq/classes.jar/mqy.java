import android.text.TextUtils;
import com.tencent.util.Pair;

public class mqy
{
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    int j = 1;
    switch (paramInt2)
    {
    default: 
      return null;
    }
    for (int i = 1;; i = 2)
    {
      paramInt2 = j;
      switch (paramInt1)
      {
      default: 
        return null;
      }
    }
    paramInt2 = 2;
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt2), Integer.valueOf(i));
      paramInt2 = 3;
      continue;
      paramInt2 = 4;
      continue;
      paramInt2 = 5;
      continue;
      paramInt2 = 7;
    }
  }
  
  public static void a()
  {
    mqw.b("0X800A2B9");
  }
  
  public static void a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 4: 
      str = "0X800A2BF";
    }
    for (;;)
    {
      mqw.b(str);
      return;
      str = "0X800A2C1";
      continue;
      str = "0X800A2BE";
      continue;
      str = "0X800A2C3";
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Pair localPair = a(paramInt1, paramInt2);
    if (localPair == null) {
      return;
    }
    bcst.b(null, "dc00898", "", "", "0X800A2BB", "0X800A2BB", ((Integer)localPair.first).intValue(), 0, String.valueOf(((Integer)localPair.second).intValue()), "", "", "");
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    String str;
    switch (paramInt3)
    {
    default: 
      return;
    case 1: 
      str = "0X800A3E3";
    }
    for (;;)
    {
      Object localObject = a(paramInt1, paramInt2);
      if (localObject == null) {
        break;
      }
      paramInt1 = ((Integer)((Pair)localObject).first).intValue();
      localObject = String.valueOf(((Pair)localObject).second);
      if (!TextUtils.isEmpty(paramString)) {
        localObject = paramString;
      }
      bcst.b(null, "dc00898", "", "", str, str, paramInt1, 0, (String)localObject, "", "", "");
      return;
      str = "0X800A3E1";
      continue;
      str = "0X800A2BC";
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      bcst.b(null, "dc00898", "", "", "0X800A3E2", "0X800A3E2", 0, 0, "", paramString, "", "");
    }
  }
  
  public static void b()
  {
    mqw.b("0X800A2BA");
  }
  
  public static void c()
  {
    mqw.b("0X800A2BD");
  }
  
  public static void d()
  {
    mqw.b("0X800A2C0");
  }
  
  public static void e()
  {
    mqw.b("0X800A2C2");
  }
  
  public static void f()
  {
    mqw.b("0X800A3DB");
  }
  
  public static void g()
  {
    mqw.b("0X800A3DC");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqy
 * JD-Core Version:    0.7.0.1
 */