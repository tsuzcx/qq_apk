package com.tencent.mobileqq.kandian.biz.pts.item;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

class KandianTenProteusItem$1
  implements ViewBase.OnClickListener
{
  KandianTenProteusItem$1(KandianTenProteusItem paramKandianTenProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    for (;;)
    {
      try
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.k();
        ProteusSupportUtil.a(localAbsBaseArticleInfo, localAbsBaseArticleInfo.mProteusTemplateBean, paramViewBase);
        RIJDtReportHelper.a.a(localAbsBaseArticleInfo);
        int j = 0;
        if (PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.reading"))
        {
          i = j;
          if (this.a.k().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() == 2)
          {
            paramViewBase = KandianTenProteusItem.a(this.c, this.a.k().weishiUGInfo.msg_url_jump_info.bytes_jump_schema);
            i = j;
            if (!TextUtils.isEmpty(paramViewBase))
            {
              KandianTenProteusItem.a(this.c, this.b.getContext(), paramViewBase);
              break label329;
            }
          }
        }
        else
        {
          i = j;
          if (this.a.k().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() == 1)
          {
            paramViewBase = KandianTenProteusItem.a(this.c, this.a.k().weishiUGInfo.msg_url_jump_info.bytes_jump_url);
            i = j;
            if (!TextUtils.isEmpty(paramViewBase))
            {
              SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.b.getContext(), paramViewBase);
              break label329;
            }
          }
        }
        if (i == 0)
        {
          paramViewBase = new JSONObject(localAbsBaseArticleInfo.proteusItemsData).getString("kandian_jump_url");
          if (!TextUtils.isEmpty(paramViewBase)) {
            SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.b.getContext(), paramViewBase);
          }
        }
        paramViewBase = new StringBuilder();
        paramViewBase.append(KandianTenProteusItem.a(this.c, this.a.k().weishiUGInfo.bytes_report_base_url));
        paramViewBase.append(KandianTenProteusItem.a(this.c, this.a.k().weishiUGInfo.bytes_click_report_tail));
        KandianUGStatisticUtils.a(paramViewBase.toString());
        return;
      }
      catch (Exception paramViewBase)
      {
        return;
      }
      label329:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.KandianTenProteusItem.1
 * JD-Core Version:    0.7.0.1
 */