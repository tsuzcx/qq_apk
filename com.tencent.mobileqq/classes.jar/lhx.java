import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport.1;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class lhx
{
  private static int jdField_a_of_type_Int;
  private static ArrayList<PendantItem> jdField_a_of_type_JavaUtilArrayList;
  private static int b;
  
  private static Class<?> a()
  {
    return PendantItem.class;
  }
  
  private static String a()
  {
    return "content";
  }
  
  private static String a(PendantItem paramPendantItem)
  {
    String str = null;
    if (paramPendantItem != null) {
      str = lbh.c() + paramPendantItem.getName();
    }
    return str;
  }
  
  private static ArrayList<PendantItem> a(String paramString)
  {
    localArrayList = new ArrayList();
    b = 0;
    jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        int j = mvk.a();
        Object localObject = a();
        if (paramString.has((String)localObject))
        {
          paramString = paramString.getJSONArray((String)localObject);
          localObject = a();
          int i = 0;
          while (i < paramString.length())
          {
            PendantItem localPendantItem = (PendantItem)bgzr.a((JSONObject)paramString.get(i), (Class)localObject);
            if ((localPendantItem != null) && (!TextUtils.isEmpty(localPendantItem.getId())) && (localPendantItem.isShow()))
            {
              int k = localPendantItem.getPlatform();
              if ((k == 0) || (j >= k))
              {
                boolean bool = b(localPendantItem);
                localPendantItem.setUsable(bool);
                localArrayList.add(localPendantItem);
                b += 1;
                if (bool) {
                  jdField_a_of_type_Int += 1;
                }
              }
            }
            i += 1;
          }
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void a()
  {
    bhhr.b(jdField_a_of_type_Int, b);
    lbd.f("AVEffectPendantReport", "setAVPendantDownloadInfo()  mTotalCount = " + b + "  mDownloadCount = " + jdField_a_of_type_Int);
  }
  
  private static String b()
  {
    return lbt.b(e()).a;
  }
  
  public static void b()
  {
    bhhr.c();
    lbd.f("AVEffectPendantReport", "setAVPendantUseInfo()  time = " + System.currentTimeMillis());
  }
  
  private static boolean b(PendantItem paramPendantItem)
  {
    if ((e() <= 0) || (paramPendantItem == null) || (TextUtils.isEmpty(paramPendantItem.getId()))) {
      lbd.h("AVEffectPendantReport", "isTemplateUsable:" + e() + "|");
    }
    do
    {
      return false;
      if (TextUtils.isEmpty(paramPendantItem.getResurl())) {
        return true;
      }
    } while (!new File(a(paramPendantItem)).exists());
    System.currentTimeMillis();
    String str = SecUtil.getFileMd5(a(paramPendantItem));
    System.currentTimeMillis();
    return paramPendantItem.getMd5().equalsIgnoreCase(str);
  }
  
  public static void c()
  {
    ThreadManager.getFileThreadHandler().post(new AVEffectPendantReport.1());
  }
  
  public static void d()
  {
    String str = b();
    jdField_a_of_type_JavaUtilArrayList = null;
    jdField_a_of_type_JavaUtilArrayList = a(str);
  }
  
  private static int e()
  {
    return 106;
  }
  
  public static void e()
  {
    long l1 = -1L;
    try
    {
      localHashMap = new HashMap();
      bool = bhhr.b();
      arrayOfInt = bhhr.b();
      l2 = bhhr.b();
      if ((!bool) && (arrayOfInt[1] <= 0))
      {
        bbgg.a().b(false);
        bhhr.d();
      }
      if (l2 <= 0L) {
        break label380;
      }
      l1 = (System.currentTimeMillis() - l2) / 1000L;
    }
    catch (Throwable localThrowable)
    {
      int[] arrayOfInt;
      do
      {
        HashMap localHashMap;
        boolean bool;
        long l2;
        BigDecimal localBigDecimal;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AVEffectPendantReport", 2, "reportAVPendantDownloadInfo", localThrowable);
        return;
        if ((arrayOfInt[0] <= 0) && (arrayOfInt[1] <= 0)) {
          break;
        }
      } while (arrayOfInt[0] <= arrayOfInt[1]);
    }
    localBigDecimal = new BigDecimal(arrayOfInt[0] * 1.0F / arrayOfInt[1]);
    localHashMap.put("filter_download", String.valueOf(arrayOfInt[0]));
    localHashMap.put("filter_total", String.valueOf(arrayOfInt[1]));
    localHashMap.put("filter_ratio", String.valueOf(localBigDecimal.setScale(2, 4).floatValue()));
    localHashMap.put("filter_spacing", String.valueOf(l1));
    if (QLog.isColorLevel()) {
      QLog.d("DailyReport", 2, "reportAVPendantDownloadInfo filter_download = " + arrayOfInt[0] + ",filter_total = " + arrayOfInt[1] + ",filter_spacing" + l1);
    }
    bool = UserAction.onUserAction("AVFunChatExpression", true, -1L, -1L, localHashMap, true);
    UserAction.flushObjectsToDB(true);
    lbd.f("AVEffectPendantReport", "reportAVPendantDownloadInfo, filter_download[" + (String)localHashMap.get("filter_download") + "], filter_total[" + (String)localHashMap.get("filter_total") + "],filter_total[" + (String)localHashMap.get("filter_ratio") + "],filter_ratio[" + (String)localHashMap.get("filter_spacing") + "], lastUserTime = " + l2 + "    ret[" + bool + "]");
    return;
    label380:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhx
 * JD-Core Version:    0.7.0.1
 */