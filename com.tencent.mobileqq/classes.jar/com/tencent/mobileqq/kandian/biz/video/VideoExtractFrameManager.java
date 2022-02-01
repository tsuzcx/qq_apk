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
  private static JSONObject a;
  private static JSONObject b;
  private static ArrayList<VideoExtractFrameManager.VideoInfo> c;
  private static VideoExtractFrameTask d;
  private static AtomicBoolean e = new AtomicBoolean(false);
  private static AtomicBoolean f = new AtomicBoolean(false);
  private static long g;
  private static long h;
  private static long i;
  
  public static void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterBackground() mHasRun = ");
      localStringBuilder.append(e.get());
      localStringBuilder.append(", mHasDestory = ");
      localStringBuilder.append(f.get());
      QLog.d("VideoExtractFrame", 2, localStringBuilder.toString());
    }
    if (Looper.getMainLooper() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "Looper == null, 直接返回");
      }
      return;
    }
    if (!e.compareAndSet(false, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "当前进程已执行过一次，直接返回");
      }
      return;
    }
    if (!h())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "条件不满足，不进行检测逻辑");
      }
      return;
    }
    if (!j())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "当前设备OPENGL版本号低于2.0，直接返回");
      }
      return;
    }
    g();
  }
  
  public static void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEnterForeground() mHasRun = ");
      ((StringBuilder)localObject).append(e.get());
      ((StringBuilder)localObject).append(", mHasDestory = ");
      ((StringBuilder)localObject).append(f.get());
      QLog.d("VideoExtractFrame", 2, ((StringBuilder)localObject).toString());
    }
    if ((e.get()) && (!f.compareAndSet(false, true)))
    {
      localObject = d;
      if (localObject != null)
      {
        ((VideoExtractFrameTask)localObject).b();
        d = null;
      }
    }
  }
  
  private static void b(Context paramContext, VideoExtractFrameManager.VideoInfo paramVideoInfo, int paramInt, String paramString, HashMap<Integer, VideoExtractFrameTask.FrameInfo> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.8.175770");
      localJSONObject.put("subversion", "8.8.17");
      if (a == null) {
        break label621;
      }
      localObject = a.optString("version");
    }
    catch (Exception paramVideoInfo)
    {
      for (;;)
      {
        int j;
        int m;
        int n;
        continue;
        Object localObject = "";
        continue;
        boolean bool1 = false;
        continue;
        int k = 0;
        paramInt = 0;
      }
    }
    localJSONObject.put("server_version", localObject);
    localJSONObject.put("video_tag", paramVideoInfo.f);
    localJSONObject.put("video_vid", paramVideoInfo.a);
    localJSONObject.put("video_bitrate", paramVideoInfo.b);
    localJSONObject.put("video_width", paramVideoInfo.g);
    localJSONObject.put("video_height", paramVideoInfo.h);
    localJSONObject.put("task_cost_time", h);
    localJSONObject.put("extract_frame_cost_time", i);
    localJSONObject.put("return_code", paramInt);
    localJSONObject.put("return_code_detail", paramString);
    bool1 = true;
    j = 0;
    if (paramInt == 1)
    {
      m = 2147483647;
      if (!bool1) {
        break label635;
      }
      paramString = paramHashMap.values().iterator();
      k = 0;
      j = 2147483647;
      paramInt = 0;
      while (paramString.hasNext())
      {
        localObject = (VideoExtractFrameTask.FrameInfo)paramString.next();
        boolean bool2 = bool1;
        if (((VideoExtractFrameTask.FrameInfo)localObject).d > paramVideoInfo.e) {
          bool2 = false;
        }
        n = k + ((VideoExtractFrameTask.FrameInfo)localObject).d;
        m = j;
        if (j > ((VideoExtractFrameTask.FrameInfo)localObject).d) {
          m = ((VideoExtractFrameTask.FrameInfo)localObject).d;
        }
        j = m;
        k = n;
        bool1 = bool2;
        if (paramInt < ((VideoExtractFrameTask.FrameInfo)localObject).d)
        {
          paramInt = ((VideoExtractFrameTask.FrameInfo)localObject).d;
          j = m;
          k = n;
          bool1 = bool2;
        }
      }
      n = k / paramHashMap.size();
      m = j;
      j = n;
      localJSONObject.put("is_success", String.valueOf(bool1));
      localJSONObject.put("avg_hash_diff", j);
      localJSONObject.put("min_hash_diff", m);
      localJSONObject.put("max_hash_diff", paramInt);
      localJSONObject.put("total_hash_diff", k);
      paramVideoInfo = new JSONArray();
      paramString = paramHashMap.values().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (VideoExtractFrameTask.FrameInfo)paramString.next();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("frame_index", paramHashMap.a);
        ((JSONObject)localObject).put("hash_diff", paramHashMap.d);
        ((JSONObject)localObject).put("server_hash", paramHashMap.b);
        ((JSONObject)localObject).put("local_hash", paramHashMap.c);
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
      localStringBuilder.append(paramVideoInfo.f);
      QLog.d("VideoExtractFrame", 2, localStringBuilder.toString());
    }
    g = System.currentTimeMillis();
    d = new VideoExtractFrameTask(BaseApplication.getContext(), paramString, paramHashMap, paramLong);
    d.a(new VideoExtractFrameManager.2(paramVideoInfo));
    d.a();
  }
  
  private static void g()
  {
    try
    {
      int j = b.optInt("KEY_LOCAL_RESULT_TRY_COUNT", 0);
      b.put("KEY_LOCAL_RESULT_TRY_COUNT", j + 1);
      RIJSPUtils.a("kandian_video_extract_frame_local_result", b.toString());
      float f1 = VideoDeviceInfoHelper.b();
      Object localObject = c.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((VideoExtractFrameManager.VideoInfo)((Iterator)localObject).next()).d > f1) {
          ((Iterator)localObject).remove();
        }
      }
      if (c.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "当前设备无支持播放的视频，直接返回");
        }
        return;
      }
      j = c.size();
      j = new Random().nextInt(j);
      localObject = (VideoExtractFrameManager.VideoInfo)c.get(j);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((VideoExtractFrameManager.VideoInfo)localObject).i.iterator();
      while (localIterator.hasNext())
      {
        VideoExtractFrameTask.FrameInfo localFrameInfo = (VideoExtractFrameTask.FrameInfo)localIterator.next();
        localHashMap.put(Integer.valueOf(localFrameInfo.a), localFrameInfo);
      }
      ThirdVideoManager.a().a(((VideoExtractFrameManager.VideoInfo)localObject).a, new VideoExtractFrameManager.1((VideoExtractFrameManager.VideoInfo)localObject, localHashMap));
      return;
    }
    catch (Exception localException) {}
  }
  
  private static boolean h()
  {
    String str = (String)RIJSPUtils.b("kandian_video_extract_frame", "");
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
      a = new JSONObject(str);
      str = a.getString("version");
      int j = a.getInt("tryCount");
      int k = a.getInt("succCount");
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
      localObject = (String)RIJSPUtils.b("kandian_video_extract_frame_local_result", "");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("localResult = ");
        localStringBuilder.append((String)localObject);
        QLog.d("VideoExtractFrame", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      int m;
      int n;
      label420:
      return false;
    }
    catch (Exception localException1)
    {
      try
      {
        b = new JSONObject((String)localObject);
        localObject = b.optString("KEY_LOCAL_RESULT_VERSION", "");
        m = b.optInt("KEY_LOCAL_RESULT_TRY_COUNT", 0);
        n = b.optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
        if ((str.equals(localObject)) && ((m >= j) || (n >= k)))
        {
          if (!QLog.isColorLevel()) {
            break label446;
          }
          QLog.d("VideoExtractFrame", 2, "已到达运行上限");
          return false;
        }
        if (!str.equals(localObject))
        {
          b.put("KEY_LOCAL_RESULT_VERSION", str);
          b.put("KEY_LOCAL_RESULT_TRY_COUNT", 0);
          b.put("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
          RIJSPUtils.a("kandian_video_extract_frame_local_result", b.toString());
          break label420;
          b = new JSONObject();
          b.put("KEY_LOCAL_RESULT_VERSION", str);
          b.put("KEY_LOCAL_RESULT_TRY_COUNT", 0);
          b.put("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
          RIJSPUtils.a("kandian_video_extract_frame_local_result", b.toString());
        }
        c = i();
        if (c != null) {
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
  
  private static ArrayList<VideoExtractFrameManager.VideoInfo> i()
  {
    if (a == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = a.getJSONArray("videoList");
      int j = 0;
      while (j < localJSONArray.length())
      {
        VideoExtractFrameManager.VideoInfo localVideoInfo = new VideoExtractFrameManager.VideoInfo();
        Object localObject = (JSONObject)localJSONArray.get(j);
        localVideoInfo.a = ((JSONObject)localObject).getString("vid");
        localVideoInfo.b = ((JSONObject)localObject).getLong("bitrate");
        localVideoInfo.c = ((JSONObject)localObject).getLong("timeout_ms");
        localVideoInfo.d = Float.valueOf(((JSONObject)localObject).getString("hevc_level")).floatValue();
        localVideoInfo.e = ((JSONObject)localObject).getInt("max_hashdiff");
        localVideoInfo.f = ((JSONObject)localObject).optString("tag");
        localObject = ((JSONObject)localObject).getJSONArray("frameInfo");
        int k = 0;
        while (k < ((JSONArray)localObject).length())
        {
          VideoExtractFrameTask.FrameInfo localFrameInfo = new VideoExtractFrameTask.FrameInfo();
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(k);
          localFrameInfo.a = localJSONObject.getInt("index");
          localFrameInfo.b = localJSONObject.getLong("serverHash");
          localVideoInfo.i.add(localFrameInfo);
          k += 1;
        }
        localArrayList.add(localVideoInfo);
        j += 1;
      }
      return localArrayList;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private static boolean j()
  {
    try
    {
      Object localObject = (ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity");
      if (localObject != null)
      {
        localObject = ((ActivityManager)localObject).getDeviceConfigurationInfo();
        if (localObject != null)
        {
          int j = ((ConfigurationInfo)localObject).reqGlEsVersion;
          if (j >= 131072) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameManager
 * JD-Core Version:    0.7.0.1
 */