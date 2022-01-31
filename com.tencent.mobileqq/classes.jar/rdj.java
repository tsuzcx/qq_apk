import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class rdj
{
  private final Map<String, rdk> a = new HashMap();
  
  public rdj()
  {
    b();
  }
  
  public static String a(String paramString)
  {
    return (String)bgmq.a(b(paramString), "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bgmq.a(b(paramString1), paramString2);
  }
  
  private static String b(String paramString)
  {
    return "kandian_" + paramString;
  }
  
  private static rdk b(String paramString)
  {
    rdk localrdk = new rdk(paramString);
    localrdk.a("default_feeds");
    localrdk.c = ("proteus/" + paramString + "");
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith("")) {
        localrdk.c = paramString;
      }
    }
    else {
      return localrdk;
    }
    localrdk.b = paramString;
    return localrdk;
  }
  
  private void b()
  {
    rdk localrdk = new rdk("default_feeds");
    localrdk.b = bgmq.a("default_feeds_proteus_offline_bid");
    localrdk.c = ("proteus/" + localrdk.a + "");
    a(localrdk);
    localrdk = new rdk("comment_feeds");
    localrdk.b = bgmq.a("comment_proteus_offline_bid");
    localrdk.c = ("proteus/" + localrdk.a);
    a(localrdk);
    localrdk = new rdk("native_article");
    localrdk.a("default_feeds");
    localrdk.c = ("proteus/" + localrdk.a + "");
    localrdk.b = bgmq.a("native_proteus_offline_bid");
    a(localrdk);
    c();
    localrdk = new rdk("daily_dynamic_header");
    localrdk.b = bgmq.a("daily_header_proteus_bid");
    localrdk.c = ("proteus/" + localrdk.a + "");
    QLog.i("StyleConfigHelper", 1, "[init]: dailyDynamicHeader.bid=" + localrdk.b);
    a(localrdk);
    QLog.d("TemplateFactory", 2, "init: " + this);
  }
  
  public static void b(String paramString)
  {
    rdk localrdk = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", localrdk.b, ", config.localPath = ", localrdk.c });
    new rdm(localrdk.b, localrdk.c).a();
  }
  
  private void c() {}
  
  public Map<String, rdk> a()
  {
    return this.a;
  }
  
  public rdk a(String paramString)
  {
    if (this.a.containsKey(paramString)) {
      return (rdk)this.a.get(paramString);
    }
    rdk localrdk = b(paramString);
    this.a.put(paramString, localrdk);
    return localrdk;
  }
  
  public rdl a(Context paramContext, String paramString)
  {
    rdk localrdk = a(paramString);
    rdm localrdm = new rdm(localrdk.b, localrdk.c);
    rdm.a(paramString);
    paramString = localrdm.a(paramContext);
    if (paramString == null)
    {
      paramContext = localrdm.b(paramContext);
      return new rdl(localrdk.c, paramContext, true);
    }
    return new rdl(localrdk.b, paramString, false);
  }
  
  public void a()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      rdk localrdk = (rdk)((Map.Entry)localIterator.next()).getValue();
      new rdm(localrdk.b, localrdk.c).a();
    }
  }
  
  public void a(String paramString)
  {
    paramString = (rdk)this.a.get(paramString);
    if (paramString != null) {
      new rdm(paramString.b, paramString.c).a();
    }
  }
  
  public void a(rdk paramrdk)
  {
    if (paramrdk.a == null) {
      throw new IllegalArgumentException();
    }
    this.a.put(paramrdk.a, paramrdk);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((rdk)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rdj
 * JD-Core Version:    0.7.0.1
 */