import android.content.Context;
import android.util.Pair;
import com.rookery.translate.type.Language;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class law
  extends lat
{
  private static law a;
  
  public static law a()
  {
    try
    {
      if (a == null) {
        a = new law();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext, List<String> paramList, Language paramLanguage, String paramString, Long paramLong, lbm paramlbm)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.CHINESE_SIMPLIFIED.toString();
    }
    Object localObject;
    for (;;)
    {
      localObject = new ArrayList();
      ((List)localObject).add(new Pair("key", paramString));
      ((List)localObject).add(new Pair("target", paramLanguage));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((List)localObject).add(new Pair("q", (String)paramList.next()));
      }
      localObject = paramLanguage.toString();
      if (localObject != null)
      {
        paramLanguage = (Language)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        paramLanguage = Language.CHINESE_SIMPLIFIED.toString();
      }
    }
    lav.a(paramContext, null, (List)localObject, new lax(this, paramlbm, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     law
 * JD-Core Version:    0.7.0.1
 */