import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class qyu
{
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private szd jdField_a_of_type_Szd;
  private HashMap<String, ArticleInfo> b;
  private HashMap<String, ArticleInfo> c = new HashMap();
  
  private View a(int paramInt)
  {
    if ((this.jdField_a_of_type_Szd == null) || (this.jdField_a_of_type_Szd.a() == null)) {
      return null;
    }
    ListView localListView = this.jdField_a_of_type_Szd.a();
    return localListView.getChildAt(paramInt - localListView.getFirstVisiblePosition() + localListView.getHeaderViewsCount());
  }
  
  private ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramArticleInfo.innerUniqueID))) {
      return null;
    }
    return (ArticleInfo)this.c.get(paramArticleInfo.innerUniqueID);
  }
  
  private ArticleInfo a(String paramString)
  {
    Object localObject;
    if (this.b == null) {
      localObject = null;
    }
    ArticleInfo localArticleInfo1;
    do
    {
      return localObject;
      localArticleInfo1 = (ArticleInfo)this.b.get(paramString);
      localObject = localArticleInfo1;
    } while (localArticleInfo1 != null);
    ArticleInfo localArticleInfo2;
    do
    {
      localObject = this.b.values().iterator();
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localArticleInfo1 = (ArticleInfo)((Iterator)localObject).next();
        } while (localArticleInfo1.mSubArtilceList == null);
        localIterator = localArticleInfo1.mSubArtilceList.iterator();
      }
      localArticleInfo2 = (ArticleInfo)localIterator.next();
    } while (!TextUtils.equals(paramString, localArticleInfo2.innerUniqueID));
    this.c.put(localArticleInfo2.innerUniqueID, localArticleInfo1);
    return localArticleInfo2;
    return null;
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString, HashMap<String, String> paramHashMap)
  {
    pqx.a(this.jdField_a_of_type_Szd.a(), paramArticleInfo, paramString);
    uvw.a(paramArticleInfo, this.jdField_a_of_type_Szd.a());
    paramString = uvs.b(this.jdField_a_of_type_Szd.a());
    if (!TextUtils.isEmpty(paramString)) {
      olh.a(null, pqw.b(paramArticleInfo), paramString, paramString, 0, 0, prg.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), rai.a(paramArticleInfo, paramHashMap), false);
    }
    qyk.c(paramArticleInfo);
    qyk.b(a(paramArticleInfo));
  }
  
  private void a(PTSComposer paramPTSComposer, HashMap<String, String> paramHashMap)
  {
    String str2 = (String)paramHashMap.get("businessType");
    String str1 = (String)paramHashMap.get("requestParams");
    paramHashMap = (String)paramHashMap.get("extendInfo");
    try
    {
      i = Integer.valueOf(str2).intValue();
      qzs.a.a(paramPTSComposer, i, str1, paramHashMap);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("PTSLiteTapEventDispatcher", 1, "[doRequest0xebf] e = " + localNumberFormatException);
        int i = 0;
      }
    }
  }
  
  private void a(String paramString, View paramView, ArticleInfo paramArticleInfo)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    int i;
    int j;
    View localView;
    if (paramString != null)
    {
      i = paramString.intValue();
      paramString = (ArticleInfo)this.jdField_a_of_type_Szd.getItem(i + 1);
      j = qym.a(paramArticleInfo);
      localView = a(i);
      if ((i != -1) && (paramArticleInfo != null) && (localView != null)) {
        break label104;
      }
      QLog.e("PTSLiteTapEventDispatcher", 1, "[doDislikeClick] error, position = " + i + " ,or articleInfo is null or cellContainer is null");
    }
    label104:
    rec localrec;
    do
    {
      return;
      i = -1;
      break;
      qhk localqhk = new qhk(this.jdField_a_of_type_Szd.a(), paramArticleInfo, j, this.jdField_a_of_type_Szd.a(), this.jdField_a_of_type_Szd.b(), i, this.jdField_a_of_type_Szd.b(), this.jdField_a_of_type_Szd.getCount(), paramString, this.jdField_a_of_type_Szd);
      localrec = new rec(this.jdField_a_of_type_Szd.a(), this.jdField_a_of_type_Szd.a(), this.jdField_a_of_type_Szd);
      localrec.a(localqhk);
      localrec.a(localView);
      localrec.a(paramView);
      paramView = a(paramArticleInfo);
    } while (paramView == null);
    localrec.a(new qhk(this.jdField_a_of_type_Szd.a(), paramView, j, this.jdField_a_of_type_Szd.a(), this.jdField_a_of_type_Szd.b(), i, this.jdField_a_of_type_Szd.b(), this.jdField_a_of_type_Szd.getCount(), paramString, this.jdField_a_of_type_Szd));
  }
  
  private void a(String paramString1, ArticleInfo paramArticleInfo, String paramString2, String paramString3, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    QLog.i("PTSLiteTapEventDispatcher", 1, "[handleEventType], eventTypeString = " + paramString1 + ", identifier = " + paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = paramString1.split("\\|");
    int j = paramString1.length;
    int i = 0;
    label60:
    String str;
    if (i < j)
    {
      str = paramString1[i];
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleEventType], eventType = " + str);
      if (!TextUtils.equals(str, "allInOneJump")) {
        break label154;
      }
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], allInOneJump, jumpUrl = " + paramString2);
      a(paramArticleInfo, paramString2, paramHashMap);
    }
    for (;;)
    {
      i += 1;
      break label60;
      break;
      label154:
      if (TextUtils.equals(str, "dislikeClick"))
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], dislikeClick.");
        a(paramString3, paramView, paramArticleInfo);
      }
      else if (TextUtils.equals(str, "0xebfRequest"))
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], request0xebf.");
        a(paramPTSComposer, paramHashMap);
      }
    }
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramHashMap == null) || (paramView == null) || (this.jdField_a_of_type_Szd == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.b == null)) {
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, something is null.");
    }
    ArticleInfo localArticleInfo;
    String str3;
    do
    {
      return;
      localArticleInfo = a(paramString);
      if (localArticleInfo == null)
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, articleInfo is null.");
        return;
      }
      String str1 = (String)paramHashMap.get("eventType");
      String str2 = (String)paramHashMap.get("jumpUrl");
      str3 = (String)paramHashMap.get("clickReportName");
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, eventType is null or empty.");
        return;
      }
      a(str1, localArticleInfo, str2, paramString, paramHashMap, paramView, paramPTSComposer);
    } while (TextUtils.isEmpty(str3));
    olh.a(null, pqw.b(localArticleInfo), str3, str3, 0, 0, prg.a(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), String.valueOf(localArticleInfo.mStrategyId), rai.a(localArticleInfo, paramHashMap), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyu
 * JD-Core Version:    0.7.0.1
 */