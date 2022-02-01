import android.content.Context;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class szc
{
  private static szc jdField_a_of_type_Szc = new szc();
  private final Map<String, szd> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public szc()
  {
    c();
  }
  
  public static String a(String paramString)
  {
    return (String)bkwm.a(b(paramString), "");
  }
  
  public static szc a()
  {
    return jdField_a_of_type_Szc;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bkwm.a(b(paramString1), paramString2);
  }
  
  private static String b(String paramString)
  {
    return "kandian_" + paramString;
  }
  
  private static szd b(String paramString)
  {
    szd localszd = new szd(paramString);
    localszd.a("default_feeds");
    localszd.c = ("proteus/" + paramString + "");
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith("")) {
        localszd.c = paramString;
      }
    }
    else {
      return localszd;
    }
    localszd.b = paramString;
    return localszd;
  }
  
  public static void b(String paramString)
  {
    szd localszd = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", localszd.b, ", config.localPath = ", localszd.c });
    new szf(localszd.b, localszd.c).a();
  }
  
  private void c()
  {
    szd localszd = new szd("default_feeds");
    localszd.b = bkwm.a("default_feeds_proteus_offline_bid");
    localszd.c = ("proteus/" + localszd.a + "");
    a(localszd);
    localszd = new szd("comment_feeds");
    localszd.b = bkwm.a("comment_proteus_offline_bid");
    localszd.c = ("proteus/" + localszd.a);
    a(localszd);
    localszd = new szd("native_article");
    localszd.a("default_feeds");
    localszd.c = ("proteus/" + localszd.a + "");
    localszd.b = bkwm.a("native_proteus_offline_bid");
    a(localszd);
    d();
    localszd = new szd("daily_dynamic_header");
    localszd.b = bkwm.a("daily_header_proteus_bid");
    localszd.c = ("proteus/" + localszd.a + "");
    QLog.i("StyleConfigHelper", 1, "[init]: dailyDynamicHeader.bid=" + localszd.b);
    a(localszd);
    QLog.d("TemplateFactory", 2, "init: " + this);
  }
  
  private void d() {}
  
  public Map<String, szd> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public szd a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (szd)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    szd localszd = b(paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localszd);
    return localszd;
  }
  
  public sze a(Context paramContext, String paramString)
  {
    szd localszd = a(paramString);
    szf localszf = new szf(localszd.b, localszd.c);
    szf.a(paramString);
    paramString = localszf.a(paramContext);
    if (paramString == null)
    {
      paramContext = localszf.b(paramContext);
      return new sze(localszd.c, paramContext, true);
    }
    return new sze(localszd.b, paramString, false);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      szd localszd = (szd)((Map.Entry)localIterator.next()).getValue();
      new szf(localszd.b, localszd.c).a();
    }
  }
  
  public void a(String paramString)
  {
    paramString = (szd)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      new szf(paramString.b, paramString.c).a();
    }
  }
  
  public void a(szd paramszd)
  {
    if (paramszd.a == null) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramszd.a, paramszd);
  }
  
  public void b()
  {
    if ((!pay.x()) && (Aladdin.getConfig(335).getIntegerFromString("pts_style_immediate_effect", 0) == 1) && (((Boolean)bkwm.a("kandian_pts_style_update", Boolean.valueOf(false))).booleanValue()))
    {
      QLog.d("StyleConfigHelper", 1, "invalidAllArticles");
      syz.c("default_feeds");
      bkwm.a("kandian_pts_style_update", Boolean.valueOf(false));
      ozm.a.a();
      List localList = ozm.a.a();
      ozm.a.a(localList);
      QLog.d("StyleConfigHelper", 1, "preload pts card, rules : " + localList);
      pkp.a().o();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((szd)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szc
 * JD-Core Version:    0.7.0.1
 */