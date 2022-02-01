package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchModeTitle
  extends SearchResultGroupModelImpl
{
  private ISearchResultGroupModel a;
  public String a;
  public boolean a;
  private String b;
  public boolean b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel)
  {
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705392);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel = paramISearchResultGroupModel;
    this.jdField_a_of_type_JavaLangString = paramISearchResultGroupModel.a();
    if (paramISearchResultGroupModel.a() != null) {
      if (paramISearchResultGroupModel.a().size() <= paramISearchResultGroupModel.a()) {
        break label75;
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      label75:
      bool = false;
    }
  }
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705392);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel = paramISearchResultGroupModel;
    if (TextUtils.isEmpty(paramString)) {}
    for (this.jdField_a_of_type_JavaLangString = paramISearchResultGroupModel.a();; this.jdField_a_of_type_JavaLangString = paramString)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705392);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel = paramISearchResultGroupModel;
    this.jdField_a_of_type_JavaLangString = paramISearchResultGroupModel.a();
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public GroupSearchModeTitle(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705392);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705397);
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel != null)
    {
      int i = SearchUtil.a(this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel);
      if (i > 0) {
        return i;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel != null) && ((this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel instanceof GroupBaseNetSearchModel))) {
      return ((GroupBaseNetSearchModel)this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel).jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public ISearchResultGroupModel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<ISearchResultModel> a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    SearchInfoInterface localSearchInfoInterface;
    Object localObject1;
    if ((localContext instanceof SearchInfoInterface))
    {
      localSearchInfoInterface = (SearchInfoInterface)localContext;
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    switch (localSearchInfoInterface.a())
    {
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel.a(paramView);
      }
      break;
    }
    label148:
    label499:
    label504:
    while (!this.jdField_c_of_type_Boolean)
    {
      for (;;)
      {
        return;
        Object localObject2;
        int i;
        if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel instanceof GroupBaseNetSearchModel))
        {
          localObject2 = (GroupBaseNetSearchModel)this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel;
          if (SearchUtils.a(((GroupBaseNetSearchModel)localObject2).jdField_a_of_type_Long))
          {
            if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && ((this.jdField_c_of_type_JavaLangString.startsWith("http://")) || (this.jdField_c_of_type_JavaLangString.startsWith("https://")))) {
              break label499;
            }
            i = 1;
            String str1 = localSearchInfoInterface.a();
            String str2 = "" + a();
            if (i == 0) {
              break label504;
            }
            localObject1 = "1";
            SearchUtils.a("all_result", "more_object", new String[] { str1, str2, localObject1 });
          }
          if ((!TextUtils.isEmpty(((GroupBaseNetSearchModel)localObject2).d())) && (((GroupBaseNetSearchModel)localObject2).d().contains("opencirclesearch")))
          {
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("ext6", b());
            ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 73, 2, 2, (HashMap)localObject1, null, null);
            UniteSearchReportController.a(null, 0, UniteSearchActivity.d, "0X800BA25", 0, 0, null, null);
          }
        }
        if (!SearchUtil.jdField_a_of_type_Boolean) {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("get_src", "web");
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          UniteSearchReportController.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("clk_more").obj1(a() + "").ver1(localSearchInfoInterface.a()).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
          SearchUtils.a("all_result", "clk_tab_more", new String[] { b(), SearchUtils.a(localSearchInfoInterface.a()), "", SearchUtils.a("dynamic_unite_search.1", localSearchInfoInterface.a()) });
          break;
          i = 0;
          break label148;
          localObject1 = "0";
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.SearchResultGroupModelImpl", 2, "e = " + localJSONException);
          }
          SearchUtils.a("sub_result", "more_result", new String[] { localSearchInfoInterface.a(), "" + localSearchInfoInterface.a(), "" + a(1), SearchUtils.a("dynamic_tab_search.1", localSearchInfoInterface.a()) });
        }
      }
      break;
    }
    localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse(this.jdField_c_of_type_JavaLangString)));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel instanceof GroupBaseNetSearchModel))
    {
      if (SearchUtils.a(((GroupBaseNetSearchModel)this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel).jdField_a_of_type_Long)) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel.b();
    }
    return null;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public String c()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {
      return "";
    }
    return this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModeTitle
 * JD-Core Version:    0.7.0.1
 */