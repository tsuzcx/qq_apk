import android.text.TextUtils;
import com.tencent.util.Pair;

public class mrf
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
    mrd.b("0X800A2B9");
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
      mrd.b(str);
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
    bcef.b(null, "dc00898", "", "", "0X800A2BB", "0X800A2BB", ((Integer)localPair.first).intValue(), 0, String.valueOf(((Integer)localPair.second).intValue()), "", "", "");
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
      bcef.b(null, "dc00898", "", "", str, str, paramInt1, 0, (String)localObject, "", "", "");
      return;
      str = "0X800A3E1";
      continue;
      str = "0X800A2BC";
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      bcef.b(null, "dc00898", "", "", "0X800A3E2", "0X800A3E2", 0, 0, "", paramString, "", "");
    }
  }
  
  public static void b()
  {
    mrd.b("0X800A2BA");
  }
  
  public static void c()
  {
    mrd.b("0X800A2BD");
  }
  
  public static void d()
  {
    mrd.b("0X800A2C0");
  }
  
  public static void e()
  {
    mrd.b("0X800A2C2");
  }
  
  public static void f()
  {
    mrd.b("0X800A3DB");
  }
  
  public static void g()
  {
    mrd.b("0X800A3DC");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mrf
 * JD-Core Version:    0.7.0.1
 */