package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchModeTitle
  extends SearchResultGroupModelImpl
{
  private ISearchResultGroupModel a;
  public String a;
  public boolean a;
  private String jdField_b_of_type_JavaLangString = "更多";
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel = paramISearchResultGroupModel;
    this.jdField_a_of_type_JavaLangString = paramISearchResultGroupModel.a();
    if (paramISearchResultGroupModel.a() != null) {
      if (paramISearchResultGroupModel.a().size() <= paramISearchResultGroupModel.a()) {
        break label67;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
      label67:
      bool = false;
    }
  }
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel = paramISearchResultGroupModel;
    if (TextUtils.isEmpty(paramString)) {}
    for (this.jdField_a_of_type_JavaLangString = paramISearchResultGroupModel.a();; this.jdField_a_of_type_JavaLangString = paramString)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel = paramISearchResultGroupModel;
    this.jdField_a_of_type_JavaLangString = paramISearchResultGroupModel.a();
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  public GroupSearchModeTitle(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.jdField_b_of_type_JavaLangString = "更多";
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
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
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List a()
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
    label144:
    label412:
    while (!this.jdField_b_of_type_Boolean)
    {
      for (;;)
      {
        return;
        int i;
        Object localObject2;
        if (((this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel instanceof GroupBaseNetSearchModel)) && (SearchUtils.a(((GroupBaseNetSearchModel)this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel).jdField_a_of_type_Long)))
        {
          if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || ((!this.jdField_c_of_type_JavaLangString.startsWith("http://")) && (!this.jdField_c_of_type_JavaLangString.startsWith("https://"))))
          {
            i = 1;
            localObject2 = localSearchInfoInterface.a();
            String str = "" + a();
            if (i == 0) {
              break label412;
            }
            localObject1 = "1";
            SearchUtils.a("all_result", "more_object", new String[] { localObject2, str, localObject1 });
          }
        }
        else if (!SearchUtil.jdField_a_of_type_Boolean) {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("get_src", "web");
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          UniteSearchReportController.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("clk_more").obj1(a() + "").ver1(localSearchInfoInterface.a()).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
          SearchUtils.a("all_result", "clk_tab_more", new String[] { b(), SearchUtils.a(localSearchInfoInterface.a()), "", SearchUtils.a("dynamic_unite_search.1", localSearchInfoInterface.a()) });
          break;
          i = 0;
          break label144;
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
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
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
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public String c()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {
      return "";
    }
    return this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModeTitle
 * JD-Core Version:    0.7.0.1
 */