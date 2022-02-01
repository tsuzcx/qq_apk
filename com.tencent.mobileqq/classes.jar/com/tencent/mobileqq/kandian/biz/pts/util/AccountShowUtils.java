package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.view.AvatarView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class AccountShowUtils
{
  public static void a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel)
  {
    a(paramContainer, paramIReadInJoyModel, "id_nickname");
  }
  
  public static void a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel, String paramString)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
    paramContainer = paramContainer.getVirtualView();
    AvatarView localAvatarView = (AvatarView)paramContainer.findViewBaseByName("id_partner_info_avator");
    if (localAvatarView != null) {
      localAvatarView.a(paramIReadInJoyModel);
    }
    paramContainer = (ReadInjoyTextView)paramContainer.findViewBaseByName(paramString);
    if (paramContainer != null)
    {
      long l = 0L;
      if (localAbsBaseArticleInfo.mPartnerAccountInfo != null) {
        l = localAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
      }
      paramContainer.a(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.AccountShowUtils
 * JD-Core Version:    0.7.0.1
 */