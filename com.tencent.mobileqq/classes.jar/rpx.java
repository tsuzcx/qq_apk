import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class rpx
{
  private final Map<String, rpy> a = new HashMap();
  
  public rpx()
  {
    b();
  }
  
  public static String a(String paramString)
  {
    return (String)bhvh.a(b(paramString), "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bhvh.a(b(paramString1), paramString2);
  }
  
  private static String b(String paramString)
  {
    return "kandian_" + paramString;
  }
  
  private static rpy b(String paramString)
  {
    rpy localrpy = new rpy(paramString);
    localrpy.a("default_feeds");
    localrpy.c = ("proteus/" + paramString + "");
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith("")) {
        localrpy.c = paramString;
      }
    }
    else {
      return localrpy;
    }
    localrpy.b = paramString;
    return localrpy;
  }
  
  private void b()
  {
    rpy localrpy = new rpy("default_feeds");
    localrpy.b = bhvh.a("default_feeds_proteus_offline_bid");
    localrpy.c = ("proteus/" + localrpy.a + "");
    a(localrpy);
    localrpy = new rpy("comment_feeds");
    localrpy.b = bhvh.a("comment_proteus_offline_bid");
    localrpy.c = ("proteus/" + localrpy.a);
    a(localrpy);
    localrpy = new rpy("native_article");
    localrpy.a("default_feeds");
    localrpy.c = ("proteus/" + localrpy.a + "");
    localrpy.b = bhvh.a("native_proteus_offline_bid");
    a(localrpy);
    c();
    localrpy = new rpy("daily_dynamic_header");
    localrpy.b = bhvh.a("daily_header_proteus_bid");
    localrpy.c = ("proteus/" + localrpy.a + "");
    QLog.i("StyleConfigHelper", 1, "[init]: dailyDynamicHeader.bid=" + localrpy.b);
    a(localrpy);
    QLog.d("TemplateFactory", 2, "init: " + this);
  }
  
  public static void b(String paramString)
  {
    rpy localrpy = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", localrpy.b, ", config.localPath = ", localrpy.c });
    new rqa(localrpy.b, localrpy.c).a();
  }
  
  private void c() {}
  
  public Map<String, rpy> a()
  {
    return this.a;
  }
  
  public rpy a(String paramString)
  {
    if (this.a.containsKey(paramString)) {
      return (rpy)this.a.get(paramString);
    }
    rpy localrpy = b(paramString);
    this.a.put(paramString, localrpy);
    return localrpy;
  }
  
  public rpz a(Context paramContext, String paramString)
  {
    rpy localrpy = a(paramString);
    rqa localrqa = new rqa(localrpy.b, localrpy.c);
    rqa.a(paramString);
    paramString = localrqa.a(paramContext);
    if (paramString == null)
    {
      paramContext = localrqa.b(paramContext);
      return new rpz(localrpy.c, paramContext, true);
    }
    return new rpz(localrpy.b, paramString, false);
  }
  
  public void a()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      rpy localrpy = (rpy)((Map.Entry)localIterator.next()).getValue();
      new rqa(localrpy.b, localrpy.c).a();
    }
  }
  
  public void a(String paramString)
  {
    paramString = (rpy)this.a.get(paramString);
    if (paramString != null) {
      new rqa(paramString.b, paramString.c).a();
    }
  }
  
  public void a(rpy paramrpy)
  {
    if (paramrpy.a == null) {
      throw new IllegalArgumentException();
    }
    this.a.put(paramrpy.a, paramrpy);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((rpy)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpx
 * JD-Core Version:    0.7.0.1
 */