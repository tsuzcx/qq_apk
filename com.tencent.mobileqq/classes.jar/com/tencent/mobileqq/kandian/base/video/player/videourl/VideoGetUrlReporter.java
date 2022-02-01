package com.tencent.mobileqq.kandian.base.video.player.videourl;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJNetworkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/videourl/VideoGetUrlReporter;", "", "()V", "innerReportKandianVideoGetUrl", "", "context", "Landroid/content/Context;", "uin", "", "success", "", "data", "Ljava/util/HashMap;", "reportKandianVideoGetUrl", "reportVideoH265GetURL", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoGetUrlReporter
{
  public static final VideoGetUrlReporter a = new VideoGetUrlReporter();
  
  @JvmStatic
  public static final void a(@Nullable Context paramContext, @Nullable String paramString, @Nullable HashMap<String, String> paramHashMap)
  {
    ThreadManager.post((Runnable)new VideoGetUrlReporter.reportVideoH265GetURL.1(paramContext, paramString, paramHashMap), 5, null, true);
  }
  
  @JvmStatic
  public static final void a(@Nullable Context paramContext, @Nullable String paramString, boolean paramBoolean, @Nullable HashMap<String, String> paramHashMap)
  {
    if (ViolaUtils.isBindDataOpmOpen())
    {
      ThreadManager.excute((Runnable)new VideoGetUrlReporter.reportKandianVideoGetUrl.1(paramContext, paramString, paramBoolean, paramHashMap), 16, null, true);
      return;
    }
    a.b(paramContext, paramString, paramBoolean, paramHashMap);
  }
  
  private final void b(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramContext != null)) {
      ((Map)paramHashMap).put("param_networkDetail", Integer.toString(RIJNetworkUtils.d(paramContext)));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramHashMap != null)
      {
        localObject1 = ((Map)paramHashMap).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          localStringBuilder.append(str);
          localStringBuilder.append(":");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(" ");
        }
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("actKandianVideoGetUrl, success =");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(",  data=");
      ((StringBuilder)localObject1).append(localStringBuilder);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject1).toString());
    }
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actKandianVideoGetUrl", paramBoolean, -1L, 0L, paramHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.VideoGetUrlReporter
 * JD-Core Version:    0.7.0.1
 */