import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class sft
{
  private final Map<String, sfu> a = new HashMap();
  
  public sft()
  {
    b();
  }
  
  public static String a(String paramString)
  {
    return (String)bkbq.a(b(paramString), "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bkbq.a(b(paramString1), paramString2);
  }
  
  private static String b(String paramString)
  {
    return "kandian_" + paramString;
  }
  
  private static sfu b(String paramString)
  {
    sfu localsfu = new sfu(paramString);
    localsfu.a("default_feeds");
    localsfu.c = ("proteus/" + paramString + "");
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith("")) {
        localsfu.c = paramString;
      }
    }
    else {
      return localsfu;
    }
    localsfu.b = paramString;
    return localsfu;
  }
  
  private void b()
  {
    sfu localsfu = new sfu("default_feeds");
    localsfu.b = bkbq.a("default_feeds_proteus_offline_bid");
    localsfu.c = ("proteus/" + localsfu.a + "");
    a(localsfu);
    localsfu = new sfu("comment_feeds");
    localsfu.b = bkbq.a("comment_proteus_offline_bid");
    localsfu.c = ("proteus/" + localsfu.a);
    a(localsfu);
    localsfu = new sfu("native_article");
    localsfu.a("default_feeds");
    localsfu.c = ("proteus/" + localsfu.a + "");
    localsfu.b = bkbq.a("native_proteus_offline_bid");
    a(localsfu);
    c();
    localsfu = new sfu("daily_dynamic_header");
    localsfu.b = bkbq.a("daily_header_proteus_bid");
    localsfu.c = ("proteus/" + localsfu.a + "");
    QLog.i("StyleConfigHelper", 1, "[init]: dailyDynamicHeader.bid=" + localsfu.b);
    a(localsfu);
    QLog.d("TemplateFactory", 2, "init: " + this);
  }
  
  public static void b(String paramString)
  {
    sfu localsfu = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", localsfu.b, ", config.localPath = ", localsfu.c });
    new sfw(localsfu.b, localsfu.c).a();
  }
  
  private void c() {}
  
  public Map<String, sfu> a()
  {
    return this.a;
  }
  
  public sfu a(String paramString)
  {
    if (this.a.containsKey(paramString)) {
      return (sfu)this.a.get(paramString);
    }
    sfu localsfu = b(paramString);
    this.a.put(paramString, localsfu);
    return localsfu;
  }
  
  public sfv a(Context paramContext, String paramString)
  {
    sfu localsfu = a(paramString);
    sfw localsfw = new sfw(localsfu.b, localsfu.c);
    sfw.a(paramString);
    paramString = localsfw.a(paramContext);
    if (paramString == null)
    {
      paramContext = localsfw.b(paramContext);
      return new sfv(localsfu.c, paramContext, true);
    }
    return new sfv(localsfu.b, paramString, false);
  }
  
  public void a()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      sfu localsfu = (sfu)((Map.Entry)localIterator.next()).getValue();
      new sfw(localsfu.b, localsfu.c).a();
    }
  }
  
  public void a(String paramString)
  {
    paramString = (sfu)this.a.get(paramString);
    if (paramString != null) {
      new sfw(paramString.b, paramString.c).a();
    }
  }
  
  public void a(sfu paramsfu)
  {
    if (paramsfu.a == null) {
      throw new IllegalArgumentException();
    }
    this.a.put(paramsfu.a, paramsfu);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((sfu)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sft
 * JD-Core Version:    0.7.0.1
 */