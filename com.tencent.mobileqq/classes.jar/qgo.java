import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;

public class qgo
{
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private sel jdField_a_of_type_Sel;
  private HashMap<String, ArticleInfo> b;
  
  private View a(int paramInt)
  {
    if ((this.jdField_a_of_type_Sel == null) || (this.jdField_a_of_type_Sel.a() == null)) {
      return null;
    }
    ListView localListView = this.jdField_a_of_type_Sel.a();
    return localListView.getChildAt(paramInt - localListView.getFirstVisiblePosition());
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString, HashMap<String, String> paramHashMap)
  {
    ozs.a(this.jdField_a_of_type_Sel.a(), paramArticleInfo, paramString);
    ubk.a(paramArticleInfo, this.jdField_a_of_type_Sel.a());
    paramString = ubg.b(this.jdField_a_of_type_Sel.a());
    if (!TextUtils.isEmpty(paramString)) {
      ocd.a(null, ozs.d(paramArticleInfo), paramString, paramString, 0, 0, sel.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), qia.a(paramArticleInfo, paramHashMap), false);
    }
    qge.b(paramArticleInfo);
    this.jdField_a_of_type_Sel.notifyDataSetChanged();
  }
  
  private void a(PTSComposer paramPTSComposer, HashMap<String, String> paramHashMap)
  {
    String str2 = (String)paramHashMap.get("businessType");
    String str1 = (String)paramHashMap.get("requestParams");
    paramHashMap = (String)paramHashMap.get("extendInfo");
    try
    {
      i = Integer.valueOf(str2).intValue();
      qhm.a.a(paramPTSComposer, i, str1, paramHashMap);
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
    if (paramString != null) {}
    int j;
    for (int i = paramString.intValue();; i = -1)
    {
      localObject = (ArticleInfo)this.jdField_a_of_type_Sel.getItem(i + 1);
      j = qgg.a(paramArticleInfo);
      paramString = a(i);
      if ((i != -1) && (paramArticleInfo != null) && (paramString != null)) {
        break;
      }
      QLog.e("PTSLiteTapEventDispatcher", 1, "[doDislikeClick] error, position = " + i + " ,or articleInfo is null or cellContainer is null");
      return;
    }
    paramArticleInfo = new pqk(this.jdField_a_of_type_Sel.a(), paramArticleInfo, j, this.jdField_a_of_type_Sel.a(), this.jdField_a_of_type_Sel.b(), i, this.jdField_a_of_type_Sel.c, this.jdField_a_of_type_Sel.getCount(), (ArticleInfo)localObject, this.jdField_a_of_type_Sel);
    Object localObject = new qlu(this.jdField_a_of_type_Sel.a(), this.jdField_a_of_type_Sel.a(), this.jdField_a_of_type_Sel);
    ((qlu)localObject).a(paramArticleInfo);
    ((qlu)localObject).a(paramString);
    ((qlu)localObject).a(paramView);
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
    label57:
    String str;
    if (i < j)
    {
      str = paramString1[i];
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleEventType], eventType = " + str);
      if (!TextUtils.equals(str, "allInOneJump")) {
        break label148;
      }
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], allInOneJump, jumpUrl = " + paramString2);
      a(paramArticleInfo, paramString2, paramHashMap);
    }
    for (;;)
    {
      i += 1;
      break label57;
      break;
      label148:
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
    if ((TextUtils.isEmpty(paramString)) || (paramHashMap == null) || (paramView == null) || (this.jdField_a_of_type_Sel == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.b == null)) {
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, something is null.");
    }
    ArticleInfo localArticleInfo;
    String str3;
    do
    {
      return;
      localArticleInfo = (ArticleInfo)this.b.get(paramString);
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
    ocd.a(null, ozs.d(localArticleInfo), str3, str3, 0, 0, sel.a(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), String.valueOf(localArticleInfo.mStrategyId), qia.a(localArticleInfo, paramHashMap), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgo
 * JD-Core Version:    0.7.0.1
 */