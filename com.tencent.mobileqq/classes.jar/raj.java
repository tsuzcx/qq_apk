import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class raj
{
  private static long jdField_a_of_type_Long;
  private static ArrayList<ram> jdField_a_of_type_JavaUtilArrayList;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private static ran jdField_a_of_type_Ran;
  private static long jdField_b_of_type_Long;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private static long c;
  
  private static ArrayList<ram> a()
  {
    if (jdField_a_of_type_OrgJsonJSONObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = jdField_a_of_type_OrgJsonJSONObject.getJSONArray("videoList");
      int i = 0;
      while (i < localJSONArray.length())
      {
        ram localram = new ram();
        Object localObject = (JSONObject)localJSONArray.get(i);
        localram.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("vid");
        localram.jdField_a_of_type_Long = ((JSONObject)localObject).getLong("bitrate");
        localram.jdField_b_of_type_Long = ((JSONObject)localObject).getLong("timeout_ms");
        localram.jdField_a_of_type_Float = Float.valueOf(((JSONObject)localObject).getString("hevc_level")).floatValue();
        localram.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("max_hashdiff");
        localram.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("tag");
        localObject = ((JSONObject)localObject).getJSONArray("frameInfo");
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          rau localrau = new rau();
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(j);
          localrau.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localrau.jdField_a_of_type_Long = localJSONObject.getLong("serverHash");
          localram.jdField_a_of_type_JavaUtilArrayList.add(localrau);
          j += 1;
        }
        localArrayList.add(localram);
        i += 1;
      }
      return localThrowable;
    }
    catch (Throwable localThrowable)
    {
      return null;
    }
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "onEnterBackground() mHasRun = " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", mHasDestory = " + jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    if (Looper.getMainLooper() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "Looper == null, 直接返回");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (TVK_SDKMgr.isInstalled(BaseApplication.getContext())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("VideoExtractFrame", 2, "视频SDK未初始化，直接返回");
          return;
          if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VideoExtractFrame", 2, "当前进程已执行过一次，直接返回");
        return;
        if (a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoExtractFrame", 2, "条件不满足，不进行检测逻辑");
      return;
      if (b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoExtractFrame", 2, "当前设备OPENGL版本号低于2.0，直接返回");
    return;
    c();
  }
  
  private static boolean a()
  {
    String str1 = (String)bjxj.a("kandian_video_extract_frame", "");
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "serverConfig = " + str1);
    }
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    int i;
    int j;
    try
    {
      jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str1);
      str1 = jdField_a_of_type_OrgJsonJSONObject.getString("version");
      i = jdField_a_of_type_OrgJsonJSONObject.getInt("tryCount");
      j = jdField_a_of_type_OrgJsonJSONObject.getInt("succCount");
      boolean bool = TextUtils.isEmpty(str1);
      if (bool) {
        return false;
      }
    }
    catch (Exception localException1)
    {
      return false;
    }
    if (bdee.a(null) != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "当前网络环境非WIFI，不进行检测逻辑");
      }
      return false;
    }
    String str2 = (String)bjxj.a("kandian_video_extract_frame_local_result", "");
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "localResult = " + str2);
    }
    if (!TextUtils.isEmpty(str2)) {}
    for (;;)
    {
      try
      {
        jdField_b_of_type_OrgJsonJSONObject = new JSONObject(str2);
        str2 = jdField_b_of_type_OrgJsonJSONObject.optString("KEY_LOCAL_RESULT_VERSION", "");
        int k = jdField_b_of_type_OrgJsonJSONObject.optInt("KEY_LOCAL_RESULT_TRY_COUNT", 0);
        int m = jdField_b_of_type_OrgJsonJSONObject.optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
        if ((localException1.equals(str2)) && ((k >= i) || (m >= j)))
        {
          if (!QLog.isColorLevel()) {
            break label411;
          }
          QLog.d("VideoExtractFrame", 2, "已到达运行上限");
          break label411;
        }
        if (!localException1.equals(str2))
        {
          jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_VERSION", localException1);
          jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_TRY_COUNT", 0);
          jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
          bjxj.a("kandian_video_extract_frame_local_result", jdField_b_of_type_OrgJsonJSONObject.toString());
        }
        jdField_a_of_type_JavaUtilArrayList = a();
        if (jdField_a_of_type_JavaUtilArrayList != null) {
          break;
        }
        return false;
      }
      catch (Exception localException2)
      {
        return false;
      }
      try
      {
        jdField_b_of_type_OrgJsonJSONObject = new JSONObject();
        jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_VERSION", localException2);
        jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_TRY_COUNT", 0);
        jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
        bjxj.a("kandian_video_extract_frame_local_result", jdField_b_of_type_OrgJsonJSONObject.toString());
      }
      catch (Exception localException3)
      {
        return false;
      }
    }
    return true;
    label411:
    return false;
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "onEnterForeground() mHasRun = " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", mHasDestory = " + jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    if ((jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (jdField_a_of_type_Ran != null))
    {
      jdField_a_of_type_Ran.b();
      jdField_a_of_type_Ran = null;
    }
  }
  
  private static void b(Context paramContext, ram paramram, int paramInt, String paramString, HashMap<Integer, rau> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    Object localObject;
    boolean bool1;
    label185:
    int k;
    int j;
    try
    {
      localJSONObject.put("version", "8.3.3.4515");
      localJSONObject.put("subversion", "8.3.3");
      if (jdField_a_of_type_OrgJsonJSONObject == null) {
        break label632;
      }
      localObject = jdField_a_of_type_OrgJsonJSONObject.optString("version");
      localJSONObject.put("server_version", localObject);
      localJSONObject.put("video_tag", paramram.jdField_b_of_type_JavaLangString);
      localJSONObject.put("video_vid", paramram.jdField_a_of_type_JavaLangString);
      localJSONObject.put("video_bitrate", paramram.jdField_a_of_type_Long);
      localJSONObject.put("video_width", paramram.jdField_b_of_type_Int);
      localJSONObject.put("video_height", paramram.c);
      localJSONObject.put("task_cost_time", jdField_b_of_type_Long);
      localJSONObject.put("extract_frame_cost_time", c);
      localJSONObject.put("return_code", paramInt);
      localJSONObject.put("return_code_detail", paramString);
      if (paramInt != 1) {
        break label639;
      }
      bool1 = true;
      k = 0;
      j = 2147483647;
      int i = 0;
      int m = 0;
      paramInt = 0;
      boolean bool2 = bool1;
      if (bool1)
      {
        paramString = paramHashMap.values().iterator();
        j = 2147483647;
        i = 0;
        paramInt = m;
        label232:
        if (paramString.hasNext())
        {
          localObject = (rau)paramString.next();
          if (((rau)localObject).jdField_b_of_type_Int > paramram.jdField_a_of_type_Int) {
            bool1 = false;
          }
          i += ((rau)localObject).jdField_b_of_type_Int;
          k = j;
          if (j > ((rau)localObject).jdField_b_of_type_Int) {
            k = ((rau)localObject).jdField_b_of_type_Int;
          }
          if (paramInt >= ((rau)localObject).jdField_b_of_type_Int) {
            break label645;
          }
          paramInt = ((rau)localObject).jdField_b_of_type_Int;
          break label625;
        }
        k = i / paramHashMap.size();
        m = i;
        bool2 = bool1;
        i = paramInt;
        paramInt = m;
      }
      localJSONObject.put("is_success", String.valueOf(bool2));
      localJSONObject.put("avg_hash_diff", k);
      localJSONObject.put("min_hash_diff", j);
      localJSONObject.put("max_hash_diff", i);
      localJSONObject.put("total_hash_diff", paramInt);
      paramram = new JSONArray();
      paramString = paramHashMap.values().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (rau)paramString.next();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("frame_index", paramHashMap.jdField_a_of_type_Int);
        ((JSONObject)localObject).put("hash_diff", paramHashMap.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("server_hash", paramHashMap.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("local_hash", paramHashMap.jdField_b_of_type_Long);
        paramram.put(localObject);
        continue;
        localHashMap.put("param_content", localJSONObject.toString());
      }
    }
    catch (Exception paramram) {}
    for (;;)
    {
      localHashMap.put("param_device", rae.a(false));
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "灯塔数据上报 reportMap = " + localHashMap.toString());
      }
      paramram = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramram != null) {
        azmz.a(paramContext).a(paramram.c(), "actKandianVideoExtractFrame", true, -1L, 0L, localHashMap, null);
      }
      return;
      localJSONObject.put("detail_list", paramram);
    }
    label645:
    for (;;)
    {
      label625:
      j = k;
      break label232;
      label632:
      localObject = "";
      break;
      label639:
      bool1 = false;
      break label185;
    }
  }
  
  private static void b(ram paramram, String paramString, HashMap<Integer, rau> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "innerDoExtractFrame start() videoInfo.tag = " + paramram.jdField_b_of_type_JavaLangString);
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Ran = new ran(BaseApplication.getContext(), paramString, paramHashMap, paramLong);
    jdField_a_of_type_Ran.a(new ral(paramram));
    jdField_a_of_type_Ran.a();
  }
  
  private static boolean b()
  {
    boolean bool2 = false;
    try
    {
      Object localObject = (ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity");
      boolean bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((ActivityManager)localObject).getDeviceConfigurationInfo();
        bool1 = bool2;
        if (localObject != null)
        {
          int i = ((ConfigurationInfo)localObject).reqGlEsVersion;
          if (i < 131072) {
            break label48;
          }
        }
      }
      label48:
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void c()
  {
    try
    {
      int i = jdField_b_of_type_OrgJsonJSONObject.optInt("KEY_LOCAL_RESULT_TRY_COUNT", 0);
      jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_TRY_COUNT", i + 1);
      bjxj.a("kandian_video_extract_frame_local_result", jdField_b_of_type_OrgJsonJSONObject.toString());
      float f = rae.a();
      Object localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ram)((Iterator)localObject).next()).jdField_a_of_type_Float > f) {
          ((Iterator)localObject).remove();
        }
      }
      if (jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "当前设备无支持播放的视频，直接返回");
        }
        return;
      }
      i = jdField_a_of_type_JavaUtilArrayList.size();
      i = new Random().nextInt(i);
      localObject = (ram)jdField_a_of_type_JavaUtilArrayList.get(i);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((ram)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        rau localrau = (rau)localIterator.next();
        localHashMap.put(Integer.valueOf(localrau.jdField_a_of_type_Int), localrau);
      }
      osf.a().a(((ram)localObject).jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new rak((ram)localObject, localHashMap));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     raj
 * JD-Core Version:    0.7.0.1
 */