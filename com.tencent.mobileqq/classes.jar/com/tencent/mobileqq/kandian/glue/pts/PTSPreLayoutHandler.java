package com.tencent.mobileqq.kandian.glue.pts;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class PTSPreLayoutHandler
{
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" title = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
    localStringBuilder.append(", rowKey = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.innerUniqueID);
    localStringBuilder.append(", pageName = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.ptsLitePageName);
    return localStringBuilder.toString();
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.ptsComposer == null) {
        return;
      }
      paramAbsBaseArticleInfo.ptsComposer.destroy();
      paramAbsBaseArticleInfo.ptsComposer = null;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[destroy] succeed, ");
      localStringBuilder.append(a(paramAbsBaseArticleInfo));
      QLog.i("PTSPreLayoutHandler", 1, localStringBuilder.toString());
    }
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramString.contains("pts:round-corner-card"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[parsePtsCardType] ptsRoundCornerCard = true, articleInfo = ");
        localStringBuilder.append(a(paramAbsBaseArticleInfo));
        QLog.i("PTSPreLayoutHandler", 1, localStringBuilder.toString());
        paramAbsBaseArticleInfo.ptsRoundCornerCard = true;
      }
      if (paramString.contains("pts:special-card"))
      {
        paramString = new StringBuilder();
        paramString.append("[parsePtsCardType] ptsSpecialCard = true, articleInfo = ");
        paramString.append(a(paramAbsBaseArticleInfo));
        QLog.i("PTSPreLayoutHandler", 1, paramString.toString());
        paramAbsBaseArticleInfo.ptsSpecialCard = true;
      }
      return;
    }
    QLog.i("PTSPreLayoutHandler", 1, "[parsePtsCardType] articleInfo is null or frameTreeJson is empty.");
  }
  
  public static void a(List<? extends AbsBaseArticleInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (!PTSLiteSwitchManager.a().a())
      {
        QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo] pts lite master switch disabled.");
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
        if (!PTSLiteItemViewBuilder.b(localAbsBaseArticleInfo))
        {
          QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo], articleInfo is not valid.");
        }
        else
        {
          Object localObject = localAbsBaseArticleInfo.ptsLitePageName;
          String str = PTSStyleManager.a().a("default_feeds", (String)localObject);
          if (TextUtils.isEmpty(str))
          {
            QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo], frameTreeJson is empty.");
          }
          else
          {
            localAbsBaseArticleInfo.ptsComposer = PTSComposer.buildComposer((String)localObject, str, localAbsBaseArticleInfo.ptsItemData.getJSONData(), null, localAbsBaseArticleInfo.getPTSUpdateDataListener());
            a(localAbsBaseArticleInfo, str);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[preHandleArticleInfo] succeed, ");
            ((StringBuilder)localObject).append(a(localAbsBaseArticleInfo));
            QLog.i("PTSPreLayoutHandler", 1, ((StringBuilder)localObject).toString());
          }
        }
      }
      return;
    }
    QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo] articleInfoList is empty.");
  }
  
  public static void b(List<AbsBaseArticleInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
        if (!PTSLiteItemViewBuilder.b(localAbsBaseArticleInfo)) {
          QLog.i("PTSPreLayoutHandler", 1, "[destroy], articleInfo is not valid.");
        } else {
          a(localAbsBaseArticleInfo);
        }
      }
      return;
    }
    QLog.i("PTSPreLayoutHandler", 1, "[destroy] articleInfoList is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.PTSPreLayoutHandler
 * JD-Core Version:    0.7.0.1
 */