package com.tencent.mobileqq.kandian.biz.pts.lite;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeProteus;
import com.tencent.mobileqq.kandian.biz.pts.network.PTSGeneralRequestModule;
import com.tencent.mobileqq.kandian.biz.pts.network.PTSGeneralRequestModule.Companion;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSRijReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.CoreReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PTSLiteTapEventDispatcher
{
  private ReadInJoyBaseAdapter a;
  private HashMap<String, Integer> b;
  private HashMap<String, AbsBaseArticleInfo> c;
  private HashMap<String, AbsBaseArticleInfo> d = new HashMap();
  
  private View a(int paramInt)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ReadInJoyBaseAdapter)localObject).d() != null))
    {
      localObject = this.a.d();
      return ((ListView)localObject).getChildAt(paramInt - ((ListView)localObject).getFirstVisiblePosition() + ((ListView)localObject).getHeaderViewsCount());
    }
    return null;
  }
  
  private AbsBaseArticleInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID))) {
      return (AbsBaseArticleInfo)this.d.get(paramAbsBaseArticleInfo.innerUniqueID);
    }
    return null;
  }
  
  private AbsBaseArticleInfo a(String paramString)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return null;
    }
    localObject = (AbsBaseArticleInfo)((HashMap)localObject).get(paramString);
    if (localObject != null) {
      return localObject;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo1;
    AbsBaseArticleInfo localAbsBaseArticleInfo2;
    do
    {
      localObject = this.c.values().iterator();
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localAbsBaseArticleInfo1 = (AbsBaseArticleInfo)((Iterator)localObject).next();
        } while (localAbsBaseArticleInfo1.mSubArticleList == null);
        localIterator = localAbsBaseArticleInfo1.mSubArticleList.iterator();
      }
      localAbsBaseArticleInfo2 = (AbsBaseArticleInfo)localIterator.next();
    } while (!TextUtils.equals(paramString, localAbsBaseArticleInfo2.innerUniqueID));
    this.d.put(localAbsBaseArticleInfo2.innerUniqueID, localAbsBaseArticleInfo1);
    return localAbsBaseArticleInfo2;
    return null;
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, HashMap<String, String> paramHashMap)
  {
    RIJJumpUtils.a(this.a.a(), paramAbsBaseArticleInfo, paramString);
    ReadinjoyReportUtils.CoreReport.a(paramAbsBaseArticleInfo, this.a.c());
    paramString = ReadinjoyReportUtils.e(this.a.c());
    if (!TextUtils.isEmpty(paramString)) {
      PublicAccountReportUtils.a(null, RIJFeedsType.k(paramAbsBaseArticleInfo), paramString, paramString, 0, 0, RIJStringUtils.a(paramAbsBaseArticleInfo.mFeedId), String.valueOf(paramAbsBaseArticleInfo.mArticleID), String.valueOf(paramAbsBaseArticleInfo.mStrategyId), PTSRijReport.a(paramAbsBaseArticleInfo, paramHashMap), false);
    }
    PTSLiteDataParser.c(paramAbsBaseArticleInfo);
    PTSLiteDataParser.b(a(paramAbsBaseArticleInfo));
  }
  
  private void a(PTSComposer paramPTSComposer, HashMap<String, String> paramHashMap)
  {
    String str2 = (String)paramHashMap.get("businessType");
    String str1 = (String)paramHashMap.get("requestParams");
    paramHashMap = (String)paramHashMap.get("extendInfo");
    int i;
    try
    {
      i = Integer.valueOf(str2).intValue();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doRequest0xebf] e = ");
      localStringBuilder.append(localNumberFormatException);
      QLog.e("PTSLiteTapEventDispatcher", 1, localStringBuilder.toString());
      i = 0;
    }
    PTSGeneralRequestModule.a.a(paramPTSComposer, i, str1, paramHashMap);
  }
  
  private void a(String paramString, View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramString = (Integer)this.b.get(paramString);
    int i;
    if (paramString != null) {
      i = paramString.intValue();
    } else {
      i = -1;
    }
    paramString = (AbsBaseArticleInfo)this.a.getItem(i + 1);
    int j = PTSLiteItemViewBuilder.a(paramAbsBaseArticleInfo);
    View localView = a(i);
    if ((i != -1) && (paramAbsBaseArticleInfo != null) && (localView != null))
    {
      ReadInJoyModelImpl localReadInJoyModelImpl = new ReadInJoyModelImpl(this.a.a(), paramAbsBaseArticleInfo, j, this.a.c(), this.a.i(), i, this.a.j(), this.a.getCount(), paramString, this.a);
      FeedItemCellTypeProteus localFeedItemCellTypeProteus = new FeedItemCellTypeProteus(this.a.a(), this.a.l(), this.a);
      localFeedItemCellTypeProteus.a(localReadInJoyModelImpl);
      localFeedItemCellTypeProteus.a(localView);
      localFeedItemCellTypeProteus.b(paramView);
      paramView = a(paramAbsBaseArticleInfo);
      if (paramView != null) {
        localFeedItemCellTypeProteus.a(new ReadInJoyModelImpl(this.a.a(), paramView, j, this.a.c(), this.a.i(), i, this.a.j(), this.a.getCount(), paramString, this.a));
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("[doDislikeClick] error, position = ");
    paramString.append(i);
    paramString.append(" ,or articleInfo is null or cellContainer is null");
    QLog.e("PTSLiteTapEventDispatcher", 1, paramString.toString());
  }
  
  private void a(String paramString1, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString2, String paramString3, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[handleEventType], eventTypeString = ");
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(", identifier = ");
    localStringBuilder1.append(paramString3);
    QLog.i("PTSLiteTapEventDispatcher", 1, localStringBuilder1.toString());
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = paramString1.split("\\|");
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder1 = paramString1[i];
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[handleEventType], eventType = ");
      localStringBuilder2.append(localStringBuilder1);
      QLog.i("PTSLiteTapEventDispatcher", 1, localStringBuilder2.toString());
      if (TextUtils.equals(localStringBuilder1, "allInOneJump"))
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[handleTapEvent], allInOneJump, jumpUrl = ");
        localStringBuilder1.append(paramString2);
        QLog.i("PTSLiteTapEventDispatcher", 1, localStringBuilder1.toString());
        a(paramAbsBaseArticleInfo, paramString2, paramHashMap);
      }
      else if (TextUtils.equals(localStringBuilder1, "dislikeClick"))
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], dislikeClick.");
        a(paramString3, paramView, paramAbsBaseArticleInfo);
      }
      else if (TextUtils.equals(localStringBuilder1, "0xebfRequest"))
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], request0xebf.");
        a(paramPTSComposer, paramHashMap);
      }
      i += 1;
    }
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramHashMap != null) && (paramView != null) && (this.a != null) && (this.b != null) && (this.c != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramString);
      if (localAbsBaseArticleInfo == null)
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, articleInfo is null.");
        return;
      }
      String str1 = (String)paramHashMap.get("eventType");
      String str2 = (String)paramHashMap.get("jumpUrl");
      String str3 = (String)paramHashMap.get("clickReportName");
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, eventType is null or empty.");
        return;
      }
      a(str1, localAbsBaseArticleInfo, str2, paramString, paramHashMap, paramView, paramPTSComposer);
      if (!TextUtils.isEmpty(str3)) {
        PublicAccountReportUtils.a(null, RIJFeedsType.k(localAbsBaseArticleInfo), str3, str3, 0, 0, RIJStringUtils.a(localAbsBaseArticleInfo.mFeedId), String.valueOf(localAbsBaseArticleInfo.mArticleID), String.valueOf(localAbsBaseArticleInfo.mStrategyId), PTSRijReport.a(localAbsBaseArticleInfo, paramHashMap), false);
      }
      return;
    }
    QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, something is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteTapEventDispatcher
 * JD-Core Version:    0.7.0.1
 */