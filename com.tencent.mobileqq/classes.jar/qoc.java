import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;

public class qoc
{
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private snh jdField_a_of_type_Snh;
  private HashMap<String, ArticleInfo> b;
  
  private View a(int paramInt)
  {
    if ((this.jdField_a_of_type_Snh == null) || (this.jdField_a_of_type_Snh.a() == null)) {
      return null;
    }
    ListView localListView = this.jdField_a_of_type_Snh.a();
    return localListView.getChildAt(paramInt - localListView.getFirstVisiblePosition());
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString, HashMap<String, String> paramHashMap)
  {
    pha.a(this.jdField_a_of_type_Snh.a(), paramArticleInfo, paramString);
    ubi.a(paramArticleInfo, this.jdField_a_of_type_Snh.a());
    paramString = ube.b(this.jdField_a_of_type_Snh.a());
    if (!TextUtils.isEmpty(paramString)) {
      oat.a(null, pha.d(paramArticleInfo), paramString, paramString, 0, 0, snh.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), qpm.a(paramArticleInfo, paramHashMap), false);
    }
    qnt.b(paramArticleInfo);
    this.jdField_a_of_type_Snh.notifyDataSetChanged();
  }
  
  private void a(String paramString, View paramView, ArticleInfo paramArticleInfo)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {}
    int j;
    for (int i = paramString.intValue();; i = -1)
    {
      localObject = (ArticleInfo)this.jdField_a_of_type_Snh.getItem(i + 1);
      j = qnu.a(paramArticleInfo);
      paramString = a(i);
      if ((i != -1) && (paramArticleInfo != null) && (paramString != null)) {
        break;
      }
      QLog.e("PTSLiteTapEventDispatcher", 1, "[doDislikeClick] error, position = " + i + " ,or articleInfo is null or cellContainer is null");
      return;
    }
    paramArticleInfo = new pya(this.jdField_a_of_type_Snh.a(), paramArticleInfo, j, this.jdField_a_of_type_Snh.a(), this.jdField_a_of_type_Snh.b(), i, this.jdField_a_of_type_Snh.c, this.jdField_a_of_type_Snh.getCount(), (ArticleInfo)localObject, this.jdField_a_of_type_Snh);
    Object localObject = new qtg(this.jdField_a_of_type_Snh.a(), this.jdField_a_of_type_Snh.a(), this.jdField_a_of_type_Snh);
    ((qtg)localObject).a(paramArticleInfo);
    ((qtg)localObject).a(paramString);
    ((qtg)localObject).a(paramView);
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramHashMap == null) || (paramView == null) || (this.jdField_a_of_type_Snh == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.b == null)) {
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
      String str3 = (String)paramHashMap.get("clickReportName");
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, eventType is null or empty.");
        return;
      }
      if (TextUtils.equals(str1, "allInOneJump"))
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], allInOneJump, jumpUrl = " + str2);
        a(localArticleInfo, str2, paramHashMap);
      }
      while (!TextUtils.isEmpty(str3))
      {
        oat.a(null, pha.d(localArticleInfo), str3, str3, 0, 0, snh.a(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), String.valueOf(localArticleInfo.mStrategyId), qpm.a(localArticleInfo, paramHashMap), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qoc
 * JD-Core Version:    0.7.0.1
 */