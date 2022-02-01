package com.tencent.mobileqq.kandian.repo.webarticle;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/RIJWebArticlePreloadUtil;", "", "()V", "TAG", "", "preloadList", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/kandian/repo/webarticle/RIJWebArticlePreloadUtil$PreloadData;", "isInPreloadList", "", "url", "preload", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "preloadImpInWebProcess", "warmUpTemplateInWebProcess", "PreloadData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticlePreloadUtil
{
  public static final RIJWebArticlePreloadUtil a = new RIJWebArticlePreloadUtil();
  private static final LinkedList<RIJWebArticlePreloadUtil.PreloadData> b = new LinkedList();
  
  private final boolean b(String paramString)
  {
    paramString = (CharSequence)paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (b.size() <= 0) {
        return false;
      }
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        if (TextUtils.equals(paramString, (CharSequence)((RIJWebArticlePreloadUtil.PreloadData)localIterator.next()).a())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final void a()
  {
    if (!RIJWebArticleUtil.a.g())
    {
      QLog.i("RIJWebArticlePreloadUtil", 1, "[warmUpTemplateInWebProcess] warm up template switch is off.");
      return;
    }
    Runnable localRunnable = (Runnable)RIJWebArticlePreloadUtil.warmUpTemplateInWebProcess.runnable.1.a;
    ThreadManager.getSubThreadHandler().post(localRunnable);
  }
  
  public final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    if (!RIJWebArticleUtil.a.f())
    {
      QLog.i("RIJWebArticlePreloadUtil", 2, "[preload] web article preload switch is off.");
      return;
    }
    if ((!RIJFeedsType.a(paramAbsBaseArticleInfo)) && (!TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.mArticleContentUrl)))
    {
      Object localObject = RIJQQAppInterfaceUtil.e();
      if (localObject != null)
      {
        localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        if (localObject != null)
        {
          localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
          if ((localObject != null) && (((ReadInJoyLogicEngine)localObject).a(paramAbsBaseArticleInfo.mArticleID) == true))
          {
            QLog.i("RIJWebArticlePreloadUtil", 1, "[preload] article has been read, do not preload.");
            return;
          }
        }
        paramAbsBaseArticleInfo = (Runnable)new RIJWebArticlePreloadUtil.preload.runnable.1(RIJWebArticleOptimizeUtil.a.a(paramAbsBaseArticleInfo.mArticleContentUrl));
        ThreadManager.getSubThreadHandler().post(paramAbsBaseArticleInfo);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    QLog.i("RIJWebArticlePreloadUtil", 2, "[preload] article is video or url is empty.");
  }
  
  public final void a(@Nullable String paramString)
  {
    paramString = (Runnable)new RIJWebArticlePreloadUtil.preloadImpInWebProcess.runnable.1(paramString);
    ThreadManager.getSubThreadHandler().post(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticlePreloadUtil
 * JD-Core Version:    0.7.0.1
 */