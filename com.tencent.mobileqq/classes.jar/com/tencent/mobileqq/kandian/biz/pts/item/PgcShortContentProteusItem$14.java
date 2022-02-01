package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyVideoView;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeVideoView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class PgcShortContentProteusItem$14
  implements ViewBase.OnClickListener
{
  PgcShortContentProteusItem$14(PgcShortContentProteusItem paramPgcShortContentProteusItem, ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ReadInJoyVideoView localReadInJoyVideoView = (ReadInJoyVideoView)this.a.getParent().findViewBaseByName("id_pgc_short_content_video_view");
    paramViewBase = this.b.k();
    if (paramViewBase.mProteusTemplateBean == null)
    {
      QLog.e("PgcShortContentProteusItem", 1, "articleInfo.mProteusTemplateBean is null");
      return;
    }
    ViewBean localViewBean = paramViewBase.mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    ViewBase localViewBase = this.a.getParent().findViewBaseByName("id_pgc_short_content_video_audio_icon");
    if ((localViewBase != null) && (localReadInJoyVideoView != null))
    {
      if (localViewBean == null) {
        return;
      }
      Object localObject = localViewBean.valueBean.dynamicValue.get("loadImageWithPath:");
      paramViewBase = "video_audio_mute";
      boolean bool = true ^ "video_audio_mute".equals(localObject);
      localReadInJoyVideoView.a().setMute(bool);
      if (!bool) {
        paramViewBase = "video_audio_speak";
      }
      localViewBean.putMapValue("pgc_video_content_audio_icon", paramViewBase);
      localViewBase.bindDynamicValue(localViewBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.14
 * JD-Core Version:    0.7.0.1
 */