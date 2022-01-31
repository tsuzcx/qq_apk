import android.content.Context;
import android.util.Pair;
import com.rookery.translate.type.Language;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lda
  extends lcx
{
  private static lda a;
  
  public static lda a()
  {
    try
    {
      if (a == null) {
        a = new lda();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext, List<String> paramList, Language paramLanguage, String paramString, Long paramLong, ldq paramldq)
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
    lcz.a(paramContext, null, (List)localObject, new ldb(this, paramldq, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lda
 * JD-Core Version:    0.7.0.1
 */