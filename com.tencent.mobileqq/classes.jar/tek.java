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

public class tek
{
  private static tek jdField_a_of_type_Tek = new tek();
  private final Map<String, tel> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public tek()
  {
    c();
  }
  
  public static String a(String paramString)
  {
    return (String)bmqa.a(b(paramString), "");
  }
  
  public static tek a()
  {
    return jdField_a_of_type_Tek;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bmqa.a(b(paramString1), paramString2);
  }
  
  private static String b(String paramString)
  {
    return "kandian_" + paramString;
  }
  
  private static tel b(String paramString)
  {
    tel localtel = new tel(paramString);
    localtel.a("default_feeds");
    localtel.c = ("proteus/" + paramString + "");
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith("")) {
        localtel.c = paramString;
      }
    }
    else {
      return localtel;
    }
    localtel.b = paramString;
    return localtel;
  }
  
  public static void b(String paramString)
  {
    tel localtel = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", localtel.b, ", config.localPath = ", localtel.c });
    new ten(localtel.b, localtel.c).a();
  }
  
  private void c()
  {
    tel localtel = new tel("default_feeds");
    localtel.b = bmqa.a("default_feeds_proteus_offline_bid");
    localtel.c = ("proteus/" + localtel.a + "");
    a(localtel);
    localtel = new tel("comment_feeds");
    localtel.b = bmqa.a("comment_proteus_offline_bid");
    localtel.c = ("proteus/" + localtel.a);
    a(localtel);
    localtel = new tel("native_article");
    localtel.a("default_feeds");
    localtel.c = ("proteus/" + localtel.a + "");
    localtel.b = bmqa.a("native_proteus_offline_bid");
    a(localtel);
    d();
    localtel = new tel("daily_dynamic_header");
    localtel.b = bmqa.a("daily_header_proteus_bid");
    localtel.c = ("proteus/" + localtel.a + "");
    QLog.i("StyleConfigHelper", 1, "[init]: dailyDynamicHeader.bid=" + localtel.b);
    a(localtel);
    QLog.d("TemplateFactory", 2, "init: " + this);
  }
  
  private void d() {}
  
  public Map<String, tel> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public tel a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (tel)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    tel localtel = b(paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localtel);
    return localtel;
  }
  
  public tem a(Context paramContext, String paramString)
  {
    tel localtel = a(paramString);
    ten localten = new ten(localtel.b, localtel.c);
    ten.a(paramString);
    paramString = localten.a(paramContext);
    if (paramString == null)
    {
      paramContext = localten.b(paramContext);
      return new tem(localtel.c, paramContext, true);
    }
    return new tem(localtel.b, paramString, false);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      tel localtel = (tel)((Map.Entry)localIterator.next()).getValue();
      new ten(localtel.b, localtel.c).a();
    }
  }
  
  public void a(String paramString)
  {
    paramString = (tel)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      new ten(paramString.b, paramString.c).a();
    }
  }
  
  public void a(tel paramtel)
  {
    if (paramtel.a == null) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramtel.a, paramtel);
  }
  
  public void b()
  {
    if ((!pha.x()) && (Aladdin.getConfig(335).getIntegerFromString("pts_style_immediate_effect", 0) == 1) && (((Boolean)bmqa.a("kandian_pts_style_update", Boolean.valueOf(false))).booleanValue()))
    {
      QLog.d("StyleConfigHelper", 1, "invalidAllArticles");
      teh.c("default_feeds");
      bmqa.a("kandian_pts_style_update", Boolean.valueOf(false));
      pfp.a.a();
      List localList = pfp.a.a();
      pfp.a.a(localList);
      QLog.d("StyleConfigHelper", 1, "preload pts card, rules : " + localList);
      pmk.a().o();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((tel)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tek
 * JD-Core Version:    0.7.0.1
 */