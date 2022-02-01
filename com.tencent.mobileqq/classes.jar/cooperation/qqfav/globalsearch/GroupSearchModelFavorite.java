package cooperation.qqfav.globalsearch;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchModelFavorite
  implements ISearchResultGroupModel
{
  public static final String a;
  public static final String b = HardCodeUtil.a(2131705399);
  private List<ISearchResultModel> a;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = GroupSearchModelFavorite.class.getSimpleName();
  }
  
  public GroupSearchModelFavorite(List<ISearchResultModel> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.c = paramString;
  }
  
  public int a()
  {
    return 0;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131705405);
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    Object localObject;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtil.b.containsKey(this)))
    {
      localObject = (SearchUtil.ObjectItemInfo)SearchUtil.b.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", UniteSearchReportController.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject).jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((SearchUtil.ObjectItemInfo)localObject).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject).b).ver1(((SearchUtil.ObjectItemInfo)localObject).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      localObject = (BaseActivity)paramView.getContext();
      FavoriteSearchActivity.a((Context)localObject, this.c);
      QfavHelper.a((Activity)localObject, ((BaseActivity)localObject).getAppRuntime().getAccount(), 0L);
      SearchUtils.a(this.c, 60, 0, paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
      }
    }
  }
  
  public String b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.GroupSearchModelFavorite
 * JD-Core Version:    0.7.0.1
 */