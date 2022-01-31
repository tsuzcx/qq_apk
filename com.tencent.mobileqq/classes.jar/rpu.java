import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class rpu
{
  private final Map<String, rpv> a = new HashMap();
  
  public rpu()
  {
    b();
  }
  
  public static String a(String paramString)
  {
    return (String)bhvy.a(b(paramString), "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bhvy.a(b(paramString1), paramString2);
  }
  
  private static String b(String paramString)
  {
    return "kandian_" + paramString;
  }
  
  private static rpv b(String paramString)
  {
    rpv localrpv = new rpv(paramString);
    localrpv.a("default_feeds");
    localrpv.c = ("proteus/" + paramString + "");
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith("")) {
        localrpv.c = paramString;
      }
    }
    else {
      return localrpv;
    }
    localrpv.b = paramString;
    return localrpv;
  }
  
  private void b()
  {
    rpv localrpv = new rpv("default_feeds");
    localrpv.b = bhvy.a("default_feeds_proteus_offline_bid");
    localrpv.c = ("proteus/" + localrpv.a + "");
    a(localrpv);
    localrpv = new rpv("comment_feeds");
    localrpv.b = bhvy.a("comment_proteus_offline_bid");
    localrpv.c = ("proteus/" + localrpv.a);
    a(localrpv);
    localrpv = new rpv("native_article");
    localrpv.a("default_feeds");
    localrpv.c = ("proteus/" + localrpv.a + "");
    localrpv.b = bhvy.a("native_proteus_offline_bid");
    a(localrpv);
    c();
    localrpv = new rpv("daily_dynamic_header");
    localrpv.b = bhvy.a("daily_header_proteus_bid");
    localrpv.c = ("proteus/" + localrpv.a + "");
    QLog.i("StyleConfigHelper", 1, "[init]: dailyDynamicHeader.bid=" + localrpv.b);
    a(localrpv);
    QLog.d("TemplateFactory", 2, "init: " + this);
  }
  
  public static void b(String paramString)
  {
    rpv localrpv = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", localrpv.b, ", config.localPath = ", localrpv.c });
    new rpx(localrpv.b, localrpv.c).a();
  }
  
  private void c() {}
  
  public Map<String, rpv> a()
  {
    return this.a;
  }
  
  public rpv a(String paramString)
  {
    if (this.a.containsKey(paramString)) {
      return (rpv)this.a.get(paramString);
    }
    rpv localrpv = b(paramString);
    this.a.put(paramString, localrpv);
    return localrpv;
  }
  
  public rpw a(Context paramContext, String paramString)
  {
    rpv localrpv = a(paramString);
    rpx localrpx = new rpx(localrpv.b, localrpv.c);
    rpx.a(paramString);
    paramString = localrpx.a(paramContext);
    if (paramString == null)
    {
      paramContext = localrpx.b(paramContext);
      return new rpw(localrpv.c, paramContext, true);
    }
    return new rpw(localrpv.b, paramString, false);
  }
  
  public void a()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      rpv localrpv = (rpv)((Map.Entry)localIterator.next()).getValue();
      new rpx(localrpv.b, localrpv.c).a();
    }
  }
  
  public void a(String paramString)
  {
    paramString = (rpv)this.a.get(paramString);
    if (paramString != null) {
      new rpx(paramString.b, paramString.c).a();
    }
  }
  
  public void a(rpv paramrpv)
  {
    if (paramrpv.a == null) {
      throw new IllegalArgumentException();
    }
    this.a.put(paramrpv.a, paramrpv);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((rpv)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpu
 * JD-Core Version:    0.7.0.1
 */