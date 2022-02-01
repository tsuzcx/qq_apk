import android.content.Context;
import android.util.Pair;
import com.rookery.translate.type.Language;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class kzy
  extends kzv
{
  private static kzy a;
  
  public static kzy a()
  {
    try
    {
      if (a == null) {
        a = new kzy();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext, List<String> paramList, Language paramLanguage, String paramString, Long paramLong, lao paramlao)
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
    kzx.a(paramContext, null, (List)localObject, new kzz(this, paramlao, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kzy
 * JD-Core Version:    0.7.0.1
 */