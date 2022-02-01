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

public class svc
{
  private static svc jdField_a_of_type_Svc = new svc();
  private final Map<String, svd> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public svc()
  {
    c();
  }
  
  public static String a(String paramString)
  {
    return (String)bnrf.a(b(paramString), "");
  }
  
  public static svc a()
  {
    return jdField_a_of_type_Svc;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bnrf.a(b(paramString1), paramString2);
  }
  
  private static String b(String paramString)
  {
    return "kandian_" + paramString;
  }
  
  private static svd b(String paramString)
  {
    svd localsvd = new svd(paramString);
    localsvd.a("default_feeds");
    localsvd.c = ("proteus/" + paramString + "");
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith("")) {
        localsvd.c = paramString;
      }
    }
    else {
      return localsvd;
    }
    localsvd.b = paramString;
    return localsvd;
  }
  
  public static void b(String paramString)
  {
    svd localsvd = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", localsvd.b, ", config.localPath = ", localsvd.c });
    new svf(localsvd.b, localsvd.c).a();
  }
  
  private void c()
  {
    svd localsvd = new svd("default_feeds");
    localsvd.b = bnrf.a("default_feeds_proteus_offline_bid");
    localsvd.c = ("proteus/" + localsvd.a + "");
    a(localsvd);
    localsvd = new svd("comment_feeds");
    localsvd.b = bnrf.a("comment_proteus_offline_bid");
    localsvd.c = ("proteus/" + localsvd.a);
    a(localsvd);
    localsvd = new svd("native_article");
    localsvd.a("default_feeds");
    localsvd.c = ("proteus/" + localsvd.a + "");
    localsvd.b = bnrf.a("native_proteus_offline_bid");
    a(localsvd);
    d();
    localsvd = new svd("daily_dynamic_header");
    localsvd.b = bnrf.a("daily_header_proteus_bid");
    localsvd.c = ("proteus/" + localsvd.a + "");
    QLog.i("StyleConfigHelper", 1, "[init]: dailyDynamicHeader.bid=" + localsvd.b);
    a(localsvd);
    QLog.d("TemplateFactory", 2, "init: " + this);
  }
  
  private void d() {}
  
  public Map<String, svd> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public svd a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (svd)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    svd localsvd = b(paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localsvd);
    return localsvd;
  }
  
  public sve a(Context paramContext, String paramString)
  {
    svd localsvd = a(paramString);
    svf localsvf = new svf(localsvd.b, localsvd.c);
    svf.a(paramString);
    paramString = localsvf.a(paramContext);
    if (paramString == null)
    {
      paramContext = localsvf.b(paramContext);
      return new sve(localsvd.c, paramContext, true);
    }
    return new sve(localsvd.b, paramString, false);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      svd localsvd = (svd)((Map.Entry)localIterator.next()).getValue();
      new svf(localsvd.b, localsvd.c).a();
    }
  }
  
  public void a(String paramString)
  {
    paramString = (svd)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      new svf(paramString.b, paramString.c).a();
    }
  }
  
  public void a(svd paramsvd)
  {
    if (paramsvd.a == null) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramsvd.a, paramsvd);
  }
  
  public void b()
  {
    if ((!ozs.x()) && (Aladdin.getConfig(335).getIntegerFromString("pts_style_immediate_effect", 0) == 1) && (((Boolean)bnrf.a("kandian_pts_style_update", Boolean.valueOf(false))).booleanValue()))
    {
      QLog.d("StyleConfigHelper", 1, "invalidAllArticles");
      suz.c("default_feeds");
      bnrf.a("kandian_pts_style_update", Boolean.valueOf(false));
      oyh.a.a();
      List localList = oyh.a.a();
      oyh.a.a(localList);
      QLog.d("StyleConfigHelper", 1, "preload pts card, rules : " + localList);
      pfd.a().o();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((svd)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svc
 * JD-Core Version:    0.7.0.1
 */