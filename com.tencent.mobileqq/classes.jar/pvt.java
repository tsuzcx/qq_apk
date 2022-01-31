import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;

public class pvt
{
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private rqj jdField_a_of_type_Rqj;
  private HashMap<String, ArticleInfo> b;
  
  private View a(int paramInt)
  {
    if ((this.jdField_a_of_type_Rqj == null) || (this.jdField_a_of_type_Rqj.a() == null)) {
      return null;
    }
    ListView localListView = this.jdField_a_of_type_Rqj.a();
    return localListView.getChildAt(paramInt - localListView.getFirstVisiblePosition());
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString)
  {
    ors.a(this.jdField_a_of_type_Rqj.a(), paramArticleInfo, paramString);
    szt.a(paramArticleInfo, this.jdField_a_of_type_Rqj.a());
    paramString = szp.b(this.jdField_a_of_type_Rqj.a());
    if (!TextUtils.isEmpty(paramString)) {
      nrt.a(null, ors.d(paramArticleInfo), paramString, paramString, 0, 0, rqj.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), pwz.a(paramArticleInfo), false);
    }
    pvp.b(paramArticleInfo);
    this.jdField_a_of_type_Rqj.notifyDataSetChanged();
  }
  
  private void a(String paramString, View paramView, ArticleInfo paramArticleInfo)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {}
    int j;
    for (int i = paramString.intValue();; i = -1)
    {
      localObject = (ArticleInfo)this.jdField_a_of_type_Rqj.getItem(i + 1);
      j = pvq.a(paramArticleInfo);
      paramString = a(i);
      if ((i != -1) && (paramArticleInfo != null) && (paramString != null)) {
        break;
      }
      QLog.e("PTSLiteTapEventDispatcher", 1, "[doDislikeClick] error, position = " + i + " ,or articleInfo is null or cellContainer is null");
      return;
    }
    paramArticleInfo = new pgq(this.jdField_a_of_type_Rqj.a(), paramArticleInfo, j, this.jdField_a_of_type_Rqj.a(), this.jdField_a_of_type_Rqj.b(), i, this.jdField_a_of_type_Rqj.c, this.jdField_a_of_type_Rqj.getCount(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqj);
    Object localObject = new pzy(this.jdField_a_of_type_Rqj.a(), this.jdField_a_of_type_Rqj.a(), this.jdField_a_of_type_Rqj);
    ((pzy)localObject).a(paramArticleInfo);
    ((pzy)localObject).a(paramString);
    ((pzy)localObject).a(paramView);
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramHashMap == null) || (paramView == null) || (this.jdField_a_of_type_Rqj == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.b == null)) {
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, something is null.");
    }
    for (;;)
    {
      return;
      ArticleInfo localArticleInfo = (ArticleInfo)this.b.get(paramString);
      if (localArticleInfo == null)
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, articleInfo is null.");
        return;
      }
      String str1 = (String)paramHashMap.get("eventType");
      String str2 = (String)paramHashMap.get("jumpUrl");
      paramHashMap = (String)paramHashMap.get("clickReportName");
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, eventType is null or empty.");
        return;
      }
      if (TextUtils.equals(str1, "allInOneJump"))
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], allInOneJump, jumpUrl = " + str2);
        a(localArticleInfo, str2);
      }
      while (!TextUtils.isEmpty(paramHashMap))
      {
        nrt.a(null, ors.d(localArticleInfo), paramHashMap, paramHashMap, 0, 0, rqj.a(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), String.valueOf(localArticleInfo.mStrategyId), pwz.a(localArticleInfo), false);
        return;
        if (TextUtils.equals(str1, "dislikeClick"))
        {
          QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], dislikeClick.");
          a(paramString, paramView, localArticleInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pvt
 * JD-Core Version:    0.7.0.1
 */