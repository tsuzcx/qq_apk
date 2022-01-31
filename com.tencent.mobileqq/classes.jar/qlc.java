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

public class qlc
{
  private static long jdField_a_of_type_Long;
  private static ArrayList<qlf> jdField_a_of_type_JavaUtilArrayList;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private static qlg jdField_a_of_type_Qlg;
  private static long jdField_b_of_type_Long;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private static long c;
  
  private static ArrayList<qlf> a()
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
        qlf localqlf = new qlf();
        Object localObject = (JSONObject)localJSONArray.get(i);
        localqlf.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("vid");
        localqlf.jdField_a_of_type_Long = ((JSONObject)localObject).getLong("bitrate");
        localqlf.jdField_b_of_type_Long = ((JSONObject)localObject).getLong("timeout_ms");
        localqlf.jdField_a_of_type_Float = Float.valueOf(((JSONObject)localObject).getString("hevc_level")).floatValue();
        localqlf.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("max_hashdiff");
        localqlf.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("tag");
        localObject = ((JSONObject)localObject).getJSONArray("frameInfo");
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          qln localqln = new qln();
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(j);
          localqln.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localqln.jdField_a_of_type_Long = localJSONObject.getLong("serverHash");
          localqlf.jdField_a_of_type_JavaUtilArrayList.add(localqln);
          j += 1;
        }
        localArrayList.add(localqlf);
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
    String str1 = (String)bhvy.a("kandian_video_extract_frame", "");
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
    if (bbfj.a(null) != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "当前网络环境非WIFI，不进行检测逻辑");
      }
      return false;
    }
    String str2 = (String)bhvy.a("kandian_video_extract_frame_local_result", "");
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
          bhvy.a("kandian_video_extract_frame_local_result", jdField_b_of_type_OrgJsonJSONObject.toString());
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
        bhvy.a("kandian_video_extract_frame_local_result", jdField_b_of_type_OrgJsonJSONObject.toString());
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
    if ((jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (jdField_a_of_type_Qlg != null))
    {
      jdField_a_of_type_Qlg.b();
      jdField_a_of_type_Qlg = null;
    }
  }
  
  private static void b(Context paramContext, qlf paramqlf, int paramInt, String paramString, HashMap<Integer, qln> paramHashMap)
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
      localJSONObject.put("version", "8.3.0.4480");
      localJSONObject.put("subversion", "8.3.0");
      if (jdField_a_of_type_OrgJsonJSONObject == null) {
        break label632;
      }
      localObject = jdField_a_of_type_OrgJsonJSONObject.optString("version");
      localJSONObject.put("server_version", localObject);
      localJSONObject.put("video_tag", paramqlf.jdField_b_of_type_JavaLangString);
      localJSONObject.put("video_vid", paramqlf.jdField_a_of_type_JavaLangString);
      localJSONObject.put("video_bitrate", paramqlf.jdField_a_of_type_Long);
      localJSONObject.put("video_width", paramqlf.jdField_b_of_type_Int);
      localJSONObject.put("video_height", paramqlf.c);
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
          localObject = (qln)paramString.next();
          if (((qln)localObject).jdField_b_of_type_Int > paramqlf.jdField_a_of_type_Int) {
            bool1 = false;
          }
          i += ((qln)localObject).jdField_b_of_type_Int;
          k = j;
          if (j > ((qln)localObject).jdField_b_of_type_Int) {
            k = ((qln)localObject).jdField_b_of_type_Int;
          }
          if (paramInt >= ((qln)localObject).jdField_b_of_type_Int) {
            break label645;
          }
          paramInt = ((qln)localObject).jdField_b_of_type_Int;
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
      paramqlf = new JSONArray();
      paramString = paramHashMap.values().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (qln)paramString.next();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("frame_index", paramHashMap.jdField_a_of_type_Int);
        ((JSONObject)localObject).put("hash_diff", paramHashMap.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("server_hash", paramHashMap.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("local_hash", paramHashMap.jdField_b_of_type_Long);
        paramqlf.put(localObject);
        continue;
        localHashMap.put("param_content", localJSONObject.toString());
      }
    }
    catch (Exception paramqlf) {}
    for (;;)
    {
      localHashMap.put("param_device", qkx.a(false));
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "灯塔数据上报 reportMap = " + localHashMap.toString());
      }
      paramqlf = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramqlf != null) {
        axrn.a(paramContext).a(paramqlf.c(), "actKandianVideoExtractFrame", true, -1L, 0L, localHashMap, null);
      }
      return;
      localJSONObject.put("detail_list", paramqlf);
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
  
  private static void b(qlf paramqlf, String paramString, HashMap<Integer, qln> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "innerDoExtractFrame start() videoInfo.tag = " + paramqlf.jdField_b_of_type_JavaLangString);
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Qlg = new qlg(BaseApplication.getContext(), paramString, paramHashMap, paramLong);
    jdField_a_of_type_Qlg.a(new qle(paramqlf));
    jdField_a_of_type_Qlg.a();
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
      bhvy.a("kandian_video_extract_frame_local_result", jdField_b_of_type_OrgJsonJSONObject.toString());
      float f = qkx.a();
      Object localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((qlf)((Iterator)localObject).next()).jdField_a_of_type_Float > f) {
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
      localObject = (qlf)jdField_a_of_type_JavaUtilArrayList.get(i);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((qlf)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        qln localqln = (qln)localIterator.next();
        localHashMap.put(Integer.valueOf(localqln.jdField_a_of_type_Int), localqln);
      }
      onu.a().a(((qlf)localObject).jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new qld((qlf)localObject, localHashMap));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlc
 * JD-Core Version:    0.7.0.1
 */