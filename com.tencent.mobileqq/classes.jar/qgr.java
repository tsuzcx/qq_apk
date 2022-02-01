import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class qgr
{
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "null";
    }
    return " title = " + paramBaseArticleInfo.mTitle + ", rowKey = " + paramBaseArticleInfo.innerUniqueID + ", pageName = " + paramBaseArticleInfo.ptsLitePageName;
  }
  
  public static <T extends BaseArticleInfo> void a(T paramT)
  {
    if ((paramT == null) || (paramT.ptsComposer == null)) {
      return;
    }
    paramT.ptsComposer.destroy();
    paramT.ptsComposer = null;
    QLog.i("PTSPreLayoutHandler", 1, "[destroy] succeed, " + a(paramT));
  }
  
  private static void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    if ((paramBaseArticleInfo == null) || (TextUtils.isEmpty(paramString))) {
      QLog.i("PTSPreLayoutHandler", 1, "[parsePtsCardType] articleInfo is null or frameTreeJson is empty.");
    }
    do
    {
      return;
      if (paramString.contains("pts:round-corner-card"))
      {
        QLog.i("PTSPreLayoutHandler", 1, "[parsePtsCardType] ptsRoundCornerCard = true, articleInfo = " + a(paramBaseArticleInfo));
        paramBaseArticleInfo.ptsRoundCornerCard = true;
      }
    } while (!paramString.contains("pts:special-card"));
    QLog.i("PTSPreLayoutHandler", 1, "[parsePtsCardType] ptsSpecialCard = true, articleInfo = " + a(paramBaseArticleInfo));
    paramBaseArticleInfo.ptsSpecialCard = true;
  }
  
  public static void a(List<? extends BaseArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo] articleInfoList is empty.");
    }
    for (;;)
    {
      return;
      if (!qhv.a().a())
      {
        QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo] pts lite master switch disabled.");
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
        if (!qgg.a(localBaseArticleInfo))
        {
          QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo], articleInfo is not valid.");
        }
        else
        {
          String str1 = localBaseArticleInfo.ptsLitePageName;
          String str2 = qib.a().a("default_feeds", str1);
          if (TextUtils.isEmpty(str2))
          {
            QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo], frameTreeJson is empty.");
          }
          else
          {
            localBaseArticleInfo.ptsComposer = PTSComposer.buildComposer(str1, str2, localBaseArticleInfo.ptsItemData.getJSONData(), null, localBaseArticleInfo.ptsUpdateDataListener);
            a(localBaseArticleInfo, str2);
            QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo] succeed, " + a(localBaseArticleInfo));
          }
        }
      }
    }
  }
  
  public static void b(List<? extends BaseArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      QLog.i("PTSPreLayoutHandler", 1, "[destroy] articleInfoList is null.");
    }
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
        if (!qgg.a(localBaseArticleInfo)) {
          QLog.i("PTSPreLayoutHandler", 1, "[destroy], articleInfo is not valid.");
        } else {
          a(localBaseArticleInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgr
 * JD-Core Version:    0.7.0.1
 */