import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class oll
{
  public static long a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (opz.d(paramAdvertisementInfo)) {
      return 30102L;
    }
    if (opz.b(paramAdvertisementInfo)) {
      return 30103L;
    }
    return 0L;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0";
    case 0: 
      return "0";
    case 1: 
      return "1";
    case 2: 
      return "2";
    }
    return "3";
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return "0";
          if (paramBoolean1) {
            return "1";
          }
        } while (!paramBoolean2);
        return "0";
        return "8";
        return "9";
        if (paramBoolean1) {
          return "2";
        }
      } while (!paramBoolean2);
      return "1";
    } while (!paramBoolean2);
    return "2";
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    if (paramAdvertisementInfo == null) {
      return null;
    }
    int i = olu.a(paramAdvertisementInfo);
    HashMap localHashMap;
    if (i >= 0)
    {
      str = i + "";
      localHashMap = new HashMap();
      localHashMap.put("oper_module", Long.valueOf(a(paramAdvertisementInfo)));
      localHashMap.put("oper_id", Long.valueOf(paramLong1));
      localHashMap.put("oper_type", Long.valueOf(paramLong2));
      localHashMap.put("obj_id", "" + str);
      localHashMap.put("loc_id", "0");
      if (paramAdvertisementInfo.gameAdComData == null) {
        break label347;
      }
      str = paramAdvertisementInfo.gameAdComData.g;
      label141:
      localHashMap.put("app_id", str);
      if (paramAdvertisementInfo.gameAdComData == null) {
        break label354;
      }
    }
    label347:
    label354:
    for (String str = paramAdvertisementInfo.gameAdComData.d;; str = "")
    {
      localHashMap.put("game_pkg", str);
      localHashMap.put("ex1", paramString1);
      localHashMap.put("ex2", paramAdvertisementInfo.getExtraParam("game_adtag"));
      localHashMap.put("ex3", paramAdvertisementInfo.mRowKey);
      localHashMap.put("ex4", String.valueOf(paramAdvertisementInfo.mArticleID));
      localHashMap.put("ex5", paramString2);
      paramAdvertisementInfo = new JSONObject();
      paramString1 = localHashMap.keySet();
      try
      {
        paramString1 = paramString1.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          paramAdvertisementInfo.put(paramString2, localHashMap.get(paramString2));
        }
        str = "";
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = new JSONObject();
        try
        {
          paramString1.put("game_gift_report", paramAdvertisementInfo.toString());
          return paramString1;
        }
        catch (JSONException paramAdvertisementInfo)
        {
          paramAdvertisementInfo.printStackTrace();
          return paramString1;
        }
      }
      break;
      str = "";
      break label141;
    }
  }
  
  public static JSONObject a(AdData paramAdData, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    if (paramAdData == null) {
      return null;
    }
    return a(paramAdData.a, paramLong1, paramLong2, paramString1, paramString2);
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, int paramInt, String paramString)
  {
    long l = 3010205L;
    if (paramAdvertisementInfo == null) {
      oqh.a("GameComponentReport", "doGameDownloadStateReport:advertisementInfo is null");
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      bool1 = opz.d(paramAdvertisementInfo);
      bool2 = opz.b(paramAdvertisementInfo);
    } while ((!bool1) && (!bool2));
    String str = a(bool1, bool2, paramInt);
    if (bool1) {}
    for (;;)
    {
      a(paramAdvertisementInfo, nxw.a(paramAdvertisementInfo), a(paramAdvertisementInfo, l, 9L, str, paramString));
      return;
      if (bool2) {
        l = 3010307L;
      }
    }
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    oqj.b(paramAdvertisementInfo);
    QQAppInterface localQQAppInterface = (QQAppInterface)pha.a();
    nxw.a(new omp().a(localQQAppInterface).a(BaseApplication.getContext()).a(119).b(39).e(paramJSONObject2).a(paramAdvertisementInfo).d(paramJSONObject1).a());
  }
  
  public static void b(AdvertisementInfo paramAdvertisementInfo, int paramInt, String paramString)
  {
    if (paramAdvertisementInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameComponentReport", 2, "advertisementInfo is null");
      }
      return;
    }
    String str = a(paramInt);
    a(paramAdvertisementInfo, nxw.a(paramAdvertisementInfo), a(paramAdvertisementInfo, 3010305L, 10L, str, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oll
 * JD-Core Version:    0.7.0.1
 */