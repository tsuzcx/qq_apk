package com.tencent.mobileqq.kandian.biz.fastweb;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyFastWebBottomSocialViewNew$1$1
  implements ViewBase.OnClickListener
{
  ReadInJoyFastWebBottomSocialViewNew$1$1(ReadInJoyFastWebBottomSocialViewNew.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject = paramViewBase.getEventAttachedData();
        i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.aQ;
        FastWebArticleInfo localFastWebArticleInfo = this.a.a.aR;
        if (i != 1129) {}
        switch (i)
        {
        case 1004: 
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            RIJJumpUtils.c(this.a.b, (String)localObject);
            return;
            ReadInJoyFastWebBottomSocialViewNew.a(this.a.c, this.a.b, localAbsBaseArticleInfo, localFastWebArticleInfo, 1);
            return;
            ReadInJoyFastWebBottomSocialViewNew.d(this.a.c, this.a.b, localAbsBaseArticleInfo, localFastWebArticleInfo);
            return;
            ReadInJoyFastWebBottomSocialViewNew.e(this.a.c, this.a.b, localAbsBaseArticleInfo, localFastWebArticleInfo);
            return;
            ReadInJoyFastWebBottomSocialViewNew.a(this.a.c, this.a.b, localAbsBaseArticleInfo, localFastWebArticleInfo);
            return;
          }
          break;
        case 1003: 
          ReadInJoyFastWebBottomSocialViewNew.b(this.a.c, this.a.b, localAbsBaseArticleInfo, localFastWebArticleInfo);
          return;
        case 1002: 
          ReadInJoyFastWebBottomSocialViewNew.c(this.a.c, this.a.b, localAbsBaseArticleInfo, localFastWebArticleInfo);
          return;
          ReadInJoyFastWebBottomSocialViewNew.a(this.a.c, paramViewBase, localAbsBaseArticleInfo, localFastWebArticleInfo, 7);
          return;
        }
      }
      catch (Exception paramViewBase)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("findClickableViewListener error!  msg=");
        ((StringBuilder)localObject).append(paramViewBase);
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, ((StringBuilder)localObject).toString());
      }
      return;
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew.1.1
 * JD-Core Version:    0.7.0.1
 */