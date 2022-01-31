import android.content.Context;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.OfflineExpire.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mzi
{
  public static int a;
  public static String a;
  public static boolean a;
  private static int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OfflineExpire";
    jdField_a_of_type_Int = 3;
  }
  
  protected static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire:" + paramString);
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        int j = paramString.length();
        if (i >= j) {
          break;
        }
        localObject = paramString.optJSONObject(i);
        if (localObject != null) {
          break label121;
        }
        i += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire: " + QLog.getStackTraceString(paramString));
      return;
      label121:
      int k = ((JSONObject)localObject).optInt("bid");
      if (k > 0)
      {
        localObject = mzh.a(k + "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (String)localObject + k;
          if (new File((String)localObject).exists()) {
            nau.a((String)localObject);
          }
        }
      }
    }
  }
  
  protected static void a(String paramString, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parsePreDown:" + paramString);
    }
    if (paramInt == 1) {}
    for (paramInt = 300000;; paramInt = 0)
    {
      ArrayList localArrayList;
      for (;;)
      {
        Object localObject;
        try
        {
          paramString = new JSONObject(paramString).optJSONArray("data");
          b = 0;
          paramContext = new WeakReference(paramQQAppInterface);
          localArrayList = new ArrayList();
          int j = paramString.length();
          int i = 0;
          if (i >= j) {
            break label399;
          }
          localObject = paramString.optJSONObject(i);
          if (localObject != null) {
            break label163;
          }
          i += 1;
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "parsePreDown: " + QLog.getStackTraceString(paramString));
        return;
        label163:
        int k = ((JSONObject)localObject).optInt("code");
        if ((k > 0) && (k < 10))
        {
          String str1 = ((JSONObject)localObject).optInt("bid") + "";
          String str2 = ((JSONObject)localObject).optString("url");
          int m = ((JSONObject)localObject).optInt("filesize", 0);
          BidDownloader localBidDownloader = new BidDownloader(str1, paramQQAppInterface, new mzj(paramContext, str2, m, str1), true, k);
          localBidDownloader.d = ((JSONObject)localObject).optInt("id");
          JSONObject localJSONObject = mzb.a(str1);
          if ((localJSONObject == null) || (localJSONObject.optInt("version", 0) < localBidDownloader.d))
          {
            if (((JSONObject)localObject).optInt("network", 0) == 1) {}
            for (boolean bool = true;; bool = false)
            {
              localBidDownloader.f = bool;
              b += 1;
              localBidDownloader.jdField_c_of_type_JavaLangString = str2;
              localBidDownloader.jdField_c_of_type_Int = m;
              localBidDownloader.a = true;
              localObject = new mzl(paramQQAppInterface, str1, localBidDownloader);
              if (!localBidDownloader.f) {
                break label388;
              }
              localArrayList.add(localObject);
              break;
            }
            label388:
            localArrayList.add(0, localObject);
          }
        }
      }
      label399:
      ThreadManager.getSubThreadHandler().postDelayed(new OfflineExpire.2(paramContext, localArrayList), paramInt);
      return;
    }
  }
  
  private static String b(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.tmdownloader.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     mzi
 * JD-Core Version:    0.7.0.1
 */