package com.tencent.mobileqq.kandian.biz.pts.listeners;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoDataManager;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoReportUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.RIJWeChatVideoSeeLaterModule;
import com.tencent.mobileqq.kandian.repo.video.RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class OnWeChatVideoWatchLaterClickListener
  implements ViewBase.OnClickListener
{
  AbsBaseArticleInfo a;
  
  public OnWeChatVideoWatchLaterClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.a = paramAbsBaseArticleInfo;
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mPartnerAccountInfo != null)
      {
        paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_watch_see_later.set(1);
        paramAbsBaseArticleInfo.invalidateProteusTemplateBean();
        return;
      }
      paramAbsBaseArticleInfo.isWatchLater = true;
      paramAbsBaseArticleInfo.invalidateProteusTemplateBean();
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    if (b(paramAbsBaseArticleInfo))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestWechatVideoSeelaterProgress: ");
      localStringBuilder.append(paramAbsBaseArticleInfo.innerUniqueID);
      localStringBuilder.append(" currentPlayTime: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" duration: ");
      localStringBuilder.append(paramInt2);
      QLog.d("OnWeChatVideoSeeLaterClickListener", 1, localStringBuilder.toString());
      ReadInJoyLogicEngine.a().t().a(b(paramAbsBaseArticleInfo, paramInt1, paramInt2));
      return;
    }
    QLog.d("OnWeChatVideoSeeLaterClickListener", 1, "requestWechatVideoSeelaterProgress: null");
  }
  
  public static List<RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem> b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem localWeChatVideoArticleItem = new RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem();
    localWeChatVideoArticleItem.b = paramAbsBaseArticleInfo.mFeedId;
    localWeChatVideoArticleItem.a = paramAbsBaseArticleInfo.innerUniqueID;
    localWeChatVideoArticleItem.c = paramInt1;
    localWeChatVideoArticleItem.d = paramInt2;
    localArrayList.add(localWeChatVideoArticleItem);
    return localArrayList;
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (((paramAbsBaseArticleInfo.mPartnerAccountInfo != null) && (paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_watch_see_later.get() == 1)) || (paramAbsBaseArticleInfo.isWatchLater)) {
      bool = true;
    }
    return bool;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a;
    if (paramViewBase == null)
    {
      QLog.d("OnWeChatVideoSeeLaterClickListener", 1, "articleInfo is null");
      return;
    }
    if (b(paramViewBase))
    {
      QLog.d("OnWeChatVideoSeeLaterClickListener", 1, "Watch see later already clicked!");
      return;
    }
    a(this.a);
    ReadInJoyLogicEngine.a().d(this.a);
    ReadInJoyLogicEngineEventDispatcher.a().c();
    long l1 = VideoDataManager.a.a(this.a.innerUniqueID);
    long l2 = VideoDataManager.a.b(this.a.innerUniqueID);
    a(this.a, (int)(l1 / 1000L), (int)(l2 / 1000L));
    QQToast.makeText(BaseApplicationImpl.getApplication(), 0, HardCodeUtil.a(2131915826), 0).show();
    VideoReportUtil.a.a(this.a, l1, null);
    RIJFeedsDynamicInsertController.INSTANCE.requestDynamicInsertInTL(this.a, new RIJFeedsInsertAction(ActionType.ACTION_SEE_LATER, 0, 0, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnWeChatVideoWatchLaterClickListener
 * JD-Core Version:    0.7.0.1
 */