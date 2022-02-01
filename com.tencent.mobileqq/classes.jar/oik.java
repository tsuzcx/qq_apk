import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class oik
{
  public static ActionEntity a(ufw paramufw)
  {
    if (paramufw.a() != null) {
      return paramufw.a();
    }
    int i = paramufw.b();
    if (i == 32) {
      return ActionEntity.PKMiddlePage;
    }
    if ((paramufw.a() != null) && (uks.j(paramufw.a())))
    {
      if (i == 37) {
        return ActionEntity.OutSuperMask;
      }
      return ActionEntity.InnerSuperMask;
    }
    return ActionEntity.Default;
  }
  
  public static ReportAction a(ufw paramufw)
  {
    if (paramufw.a() != null) {
      return paramufw.a();
    }
    switch (paramufw.a())
    {
    default: 
      if ((paramufw.a() != null) && (paramufw.a().adClickPos != null) && (paramufw.a().adClickPos == AdClickPos.SoftAdClose)) {
        return ReportAction.CLOSE;
      }
      break;
    case 1: 
    case 19: 
      if (paramufw.d() == 39) {
        return ReportAction.CLOSE;
      }
      return ReportAction.CLICK;
    case 17: 
    case 23: 
      return ReportAction.SLIDE;
    case 5: 
    case 42: 
    case 116: 
      return ReportAction.CLICK;
    case 6: 
      return ReportAction.VIDEO_SEE_TIME;
    case 3: 
      return ReportAction.NFB;
    case 80: 
      return ReportAction.RECEIVE;
    case 4: 
    case 20: 
    case 26: 
      return ReportAction.CLOSE;
    case 2: 
      return ReportAction.EXPOSE;
    }
    if (paramufw.a() != null) {
      return ReportAction.CLICK;
    }
    return ReportAction.EXPOSE;
  }
  
  public static Integer a(ufw paramufw)
  {
    if (paramufw == null) {
      return Integer.valueOf(JumpMode.UNKNOWN.getValue());
    }
    if ((paramufw.a() == null) || (paramufw.a() == JumpMode.FAIL)) {
      return Integer.valueOf(JumpMode.UNKNOWN.getValue());
    }
    return Integer.valueOf(paramufw.a().getValue());
  }
  
  public static String a(ufw paramufw)
  {
    if (paramufw == null) {}
    while (paramufw.a() == null) {
      return null;
    }
    return paramufw.a().getLiujinReportUrl();
  }
  
  public static Map<String, ohv> a(ufw paramufw)
  {
    int i = 0;
    Object localObject;
    if (paramufw == null)
    {
      localObject = null;
      return localObject;
    }
    Class[] arrayOfClass = new Class[9];
    arrayOfClass[0] = oic.class;
    arrayOfClass[1] = oia.class;
    arrayOfClass[2] = oid.class;
    arrayOfClass[3] = oie.class;
    arrayOfClass[4] = oif.class;
    arrayOfClass[5] = oig.class;
    arrayOfClass[6] = oih.class;
    arrayOfClass[7] = oii.class;
    arrayOfClass[8] = oij.class;
    HashMap localHashMap = new HashMap();
    int j = arrayOfClass.length;
    for (;;)
    {
      localObject = localHashMap;
      if (i >= j) {
        break;
      }
      localObject = a(paramufw, arrayOfClass[i]);
      if ((localObject != null) && (((ohv)localObject).a())) {
        localHashMap.put(((ohv)localObject).a(), localObject);
      }
      i += 1;
    }
  }
  
  private static <T extends ohv> T a(ufw paramufw, Class<T> paramClass)
  {
    int j = 1;
    int i;
    if (paramufw == null)
    {
      i = 1;
      if (paramClass != null) {
        break label25;
      }
    }
    for (;;)
    {
      if ((j | i) == 0) {
        break label30;
      }
      return null;
      i = 0;
      break;
      label25:
      j = 0;
    }
    try
    {
      label30:
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      paramClass.setAccessible(true);
      paramClass = (ohv)paramClass.newInstance(new Object[0]);
      paramClass.a(paramufw);
      return paramClass;
    }
    catch (Throwable paramufw) {}
    return null;
  }
  
  public static ohw a(Map<String, ohv> paramMap)
  {
    ohw localohw = new ohw();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      ohv localohv = (ohv)paramMap.next();
      if ((localohv != null) && (localohv.a())) {
        localohw.a(localohv);
      }
    }
    return localohw;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 1024);
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static String b(ufw paramufw)
  {
    if (paramufw == null) {}
    while (paramufw.a() == null) {
      return null;
    }
    return paramufw.a().getTicket();
  }
  
  public static String c(ufw paramufw)
  {
    if (paramufw == null) {}
    while (paramufw.a() == null) {
      return null;
    }
    return paramufw.a().getAmsNfbUrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oik
 * JD-Core Version:    0.7.0.1
 */