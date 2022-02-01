package com.tencent.mobileqq.kandian.biz.video;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.video.VideoDeviceInfoHelper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class VideoExtractFrameManager
{
  private static long jdField_a_of_type_Long;
  private static VideoExtractFrameTask jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameTask;
  private static ArrayList<VideoExtractFrameManager.VideoInfo> jdField_a_of_type_JavaUtilArrayList;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private static long jdField_b_of_type_Long;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private static long c;
  
  private static ArrayList<VideoExtractFrameManager.VideoInfo> a()
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
        VideoExtractFrameManager.VideoInfo localVideoInfo = new VideoExtractFrameManager.VideoInfo();
        Object localObject = (JSONObject)localJSONArray.get(i);
        localVideoInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("vid");
        localVideoInfo.jdField_a_of_type_Long = ((JSONObject)localObject).getLong("bitrate");
        localVideoInfo.jdField_b_of_type_Long = ((JSONObject)localObject).getLong("timeout_ms");
        localVideoInfo.jdField_a_of_type_Float = Float.valueOf(((JSONObject)localObject).getString("hevc_level")).floatValue();
        localVideoInfo.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("max_hashdiff");
        localVideoInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("tag");
        localObject = ((JSONObject)localObject).getJSONArray("frameInfo");
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          VideoExtractFrameTask.FrameInfo localFrameInfo = new VideoExtractFrameTask.FrameInfo();
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(j);
          localFrameInfo.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localFrameInfo.jdField_a_of_type_Long = localJSONObject.getLong("serverHash");
          localVideoInfo.jdField_a_of_type_JavaUtilArrayList.add(localFrameInfo);
          j += 1;
        }
        localArrayList.add(localVideoInfo);
        i += 1;
      }
      return localArrayList;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterBackground() mHasRun = ");
      localStringBuilder.append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localStringBuilder.append(", mHasDestory = ");
      localStringBuilder.append(jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      QLog.d("VideoExtractFrame", 2, localStringBuilder.toString());
    }
    if (Looper.getMainLooper() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "Looper == null, 直接返回");
      }
      return;
    }
    if (!TVK_SDKMgr.isInstalled(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "视频SDK未初始化，直接返回");
      }
      return;
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "当前进程已执行过一次，直接返回");
      }
      return;
    }
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "条件不满足，不进行检测逻辑");
      }
      return;
    }
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "当前设备OPENGL版本号低于2.0，直接返回");
      }
      return;
    }
    c();
  }
  
  private static boolean a()
  {
    String str = (String)RIJSPUtils.a("kandian_video_extract_frame", "");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("serverConfig = ");
      ((StringBuilder)localObject).append(str);
      QLog.d("VideoExtractFrame", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    try
    {
      jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str);
      str = jdField_a_of_type_OrgJsonJSONObject.getString("version");
      int i = jdField_a_of_type_OrgJsonJSONObject.getInt("tryCount");
      int j = jdField_a_of_type_OrgJsonJSONObject.getInt("succCount");
      bool2 = TextUtils.isEmpty(str);
      if (bool2) {
        return false;
      }
      if (NetworkUtil.getSystemNetwork(null) != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "当前网络环境非WIFI，不进行检测逻辑");
        }
        return false;
      }
      localObject = (String)RIJSPUtils.a("kandian_video_extract_frame_local_result", "");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("localResult = ");
        localStringBuilder.append((String)localObject);
        QLog.d("VideoExtractFrame", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      int k;
      int m;
      label412:
      return false;
    }
    catch (Exception localException1)
    {
      try
      {
        jdField_b_of_type_OrgJsonJSONObject = new JSONObject((String)localObject);
        localObject = jdField_b_of_type_OrgJsonJSONObject.optString("KEY_LOCAL_RESULT_VERSION", "");
        k = jdField_b_of_type_OrgJsonJSONObject.optInt("KEY_LOCAL_RESULT_TRY_COUNT", 0);
        m = jdField_b_of_type_OrgJsonJSONObject.optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
        if ((str.equals(localObject)) && ((k >= i) || (m >= j)))
        {
          if (!QLog.isColorLevel()) {
            break label438;
          }
          QLog.d("VideoExtractFrame", 2, "已到达运行上限");
          return false;
        }
        if (!str.equals(localObject))
        {
          jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_VERSION", str);
          jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_TRY_COUNT", 0);
          jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
          RIJSPUtils.a("kandian_video_extract_frame_local_result", jdField_b_of_type_OrgJsonJSONObject.toString());
          break label412;
          jdField_b_of_type_OrgJsonJSONObject = new JSONObject();
          jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_VERSION", str);
          jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_TRY_COUNT", 0);
          jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
          RIJSPUtils.a("kandian_video_extract_frame_local_result", jdField_b_of_type_OrgJsonJSONObject.toString());
        }
        jdField_a_of_type_JavaUtilArrayList = a();
        if (jdField_a_of_type_JavaUtilArrayList != null) {
          bool1 = true;
        }
        return bool1;
      }
      catch (Exception localException2)
      {
        return false;
      }
      localException1 = localException1;
      return false;
    }
  }
  
  public static void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEnterForeground() mHasRun = ");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      ((StringBuilder)localObject).append(", mHasDestory = ");
      ((StringBuilder)localObject).append(jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      QLog.d("VideoExtractFrame", 2, ((StringBuilder)localObject).toString());
    }
    if ((jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)))
    {
      localObject = jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameTask;
      if (localObject != null)
      {
        ((VideoExtractFrameTask)localObject).b();
        jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameTask = null;
      }
    }
  }
  
  private static void b(Context paramContext, VideoExtractFrameManager.VideoInfo paramVideoInfo, int paramInt, String paramString, HashMap<Integer, VideoExtractFrameTask.FrameInfo> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.7.05295");
      localJSONObject.put("subversion", "8.7.0");
      if (jdField_a_of_type_OrgJsonJSONObject == null) {
        break label648;
      }
      localObject = jdField_a_of_type_OrgJsonJSONObject.optString("version");
    }
    catch (Exception paramVideoInfo)
    {
      for (;;)
      {
        int i;
        int k;
        int m;
        continue;
        Object localObject = "";
        continue;
        boolean bool1 = false;
        continue;
        int j = 0;
        paramInt = 0;
      }
    }
    localJSONObject.put("server_version", localObject);
    localJSONObject.put("video_tag", paramVideoInfo.jdField_b_of_type_JavaLangString);
    localJSONObject.put("video_vid", paramVideoInfo.jdField_a_of_type_JavaLangString);
    localJSONObject.put("video_bitrate", paramVideoInfo.jdField_a_of_type_Long);
    localJSONObject.put("video_width", paramVideoInfo.jdField_b_of_type_Int);
    localJSONObject.put("video_height", paramVideoInfo.c);
    localJSONObject.put("task_cost_time", jdField_b_of_type_Long);
    localJSONObject.put("extract_frame_cost_time", c);
    localJSONObject.put("return_code", paramInt);
    localJSONObject.put("return_code_detail", paramString);
    bool1 = true;
    i = 0;
    if (paramInt == 1)
    {
      k = 2147483647;
      if (!bool1) {
        break label661;
      }
      paramString = paramHashMap.values().iterator();
      j = 0;
      i = 2147483647;
      paramInt = 0;
      while (paramString.hasNext())
      {
        localObject = (VideoExtractFrameTask.FrameInfo)paramString.next();
        boolean bool2 = bool1;
        if (((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int > paramVideoInfo.jdField_a_of_type_Int) {
          bool2 = false;
        }
        m = j + ((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int;
        k = i;
        if (i > ((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int) {
          k = ((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int;
        }
        i = k;
        j = m;
        bool1 = bool2;
        if (paramInt < ((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int)
        {
          paramInt = ((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int;
          i = k;
          j = m;
          bool1 = bool2;
        }
      }
      m = j / paramHashMap.size();
      k = i;
      i = m;
      localJSONObject.put("is_success", String.valueOf(bool1));
      localJSONObject.put("avg_hash_diff", i);
      localJSONObject.put("min_hash_diff", k);
      localJSONObject.put("max_hash_diff", paramInt);
      localJSONObject.put("total_hash_diff", j);
      paramVideoInfo = new JSONArray();
      paramString = paramHashMap.values().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (VideoExtractFrameTask.FrameInfo)paramString.next();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("frame_index", paramHashMap.jdField_a_of_type_Int);
        ((JSONObject)localObject).put("hash_diff", paramHashMap.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("server_hash", paramHashMap.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("local_hash", paramHashMap.jdField_b_of_type_Long);
        paramVideoInfo.put(localObject);
      }
      localJSONObject.put("detail_list", paramVideoInfo);
      localHashMap.put("param_content", localJSONObject.toString());
      localHashMap.put("param_device", VideoDeviceInfoHelper.a());
      if (QLog.isColorLevel())
      {
        paramVideoInfo = new StringBuilder();
        paramVideoInfo.append("灯塔数据上报 reportMap = ");
        paramVideoInfo.append(localHashMap.toString());
        QLog.d("VideoExtractFrame", 2, paramVideoInfo.toString());
      }
      paramVideoInfo = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramVideoInfo != null) {
        StatisticCollector.getInstance(paramContext).collectPerformance(paramVideoInfo.getCurrentUin(), "actKandianVideoExtractFrame", true, -1L, 0L, localHashMap, null);
      }
    }
  }
  
  private static void b(VideoExtractFrameManager.VideoInfo paramVideoInfo, String paramString, HashMap<Integer, VideoExtractFrameTask.FrameInfo> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("innerDoExtractFrame start() videoInfo.tag = ");
      localStringBuilder.append(paramVideoInfo.jdField_b_of_type_JavaLangString);
      QLog.d("VideoExtractFrame", 2, localStringBuilder.toString());
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameTask = new VideoExtractFrameTask(BaseApplication.getContext(), paramString, paramHashMap, paramLong);
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameTask.a(new VideoExtractFrameManager.2(paramVideoInfo));
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameTask.a();
  }
  
  private static boolean b()
  {
    try
    {
      Object localObject = (ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity");
      if (localObject != null)
      {
        localObject = ((ActivityManager)localObject).getDeviceConfigurationInfo();
        if (localObject != null)
        {
          int i = ((ConfigurationInfo)localObject).reqGlEsVersion;
          if (i >= 131072) {
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private static void c()
  {
    try
    {
      int i = jdField_b_of_type_OrgJsonJSONObject.optInt("KEY_LOCAL_RESULT_TRY_COUNT", 0);
      jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_TRY_COUNT", i + 1);
      RIJSPUtils.a("kandian_video_extract_frame_local_result", jdField_b_of_type_OrgJsonJSONObject.toString());
      float f = VideoDeviceInfoHelper.a();
      Object localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((VideoExtractFrameManager.VideoInfo)((Iterator)localObject).next()).jdField_a_of_type_Float > f) {
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
      localObject = (VideoExtractFrameManager.VideoInfo)jdField_a_of_type_JavaUtilArrayList.get(i);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((VideoExtractFrameManager.VideoInfo)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        VideoExtractFrameTask.FrameInfo localFrameInfo = (VideoExtractFrameTask.FrameInfo)localIterator.next();
        localHashMap.put(Integer.valueOf(localFrameInfo.jdField_a_of_type_Int), localFrameInfo);
      }
      ThirdVideoManager.a().a(((VideoExtractFrameManager.VideoInfo)localObject).jdField_a_of_type_JavaLangString, new VideoExtractFrameManager.1((VideoExtractFrameManager.VideoInfo)localObject, localHashMap));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameManager
 * JD-Core Version:    0.7.0.1
 */