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
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchInfoInterface;
import com.tencent.mobileqq.search.business.group.model.SearchResultGroupModelImpl;
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
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705465);
    boolean bool = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel = paramISearchResultGroupModel;
    this.jdField_a_of_type_JavaLangString = paramISearchResultGroupModel.a();
    if (paramISearchResultGroupModel.a() != null)
    {
      if (paramISearchResultGroupModel.a().size() <= paramISearchResultGroupModel.a()) {
        bool = false;
      }
      this.jdField_c_of_type_Boolean = bool;
    }
  }
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705465);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel = paramISearchResultGroupModel;
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaLangString = paramISearchResultGroupModel.a();
    } else {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public GroupSearchModeTitle(ISearchResultGroupModel paramISearchResultGroupModel, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705465);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel = paramISearchResultGroupModel;
    this.jdField_a_of_type_JavaLangString = paramISearchResultGroupModel.a();
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public GroupSearchModeTitle(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705465);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705470);
    }
    this.jdField_c_of_type_Boolean = (TextUtils.isEmpty(paramString3) ^ true);
  }
  
  private void a(SearchInfoInterface paramSearchInfoInterface)
  {
    if (paramSearchInfoInterface != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel;
      if (localObject != null)
      {
        if (!(localObject instanceof GroupBaseNetSearchModel)) {
          return;
        }
        localObject = (GroupBaseNetSearchModel)localObject;
        if (SearchUtils.a(((GroupBaseNetSearchModel)localObject).jdField_a_of_type_Long))
        {
          int i;
          if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && ((this.jdField_c_of_type_JavaLangString.startsWith("http://")) || (this.jdField_c_of_type_JavaLangString.startsWith("https://")))) {
            i = 0;
          } else {
            i = 1;
          }
          String str1 = paramSearchInfoInterface.a();
          paramSearchInfoInterface = new StringBuilder();
          paramSearchInfoInterface.append("");
          paramSearchInfoInterface.append(a());
          String str2 = paramSearchInfoInterface.toString();
          if (i != 0) {
            paramSearchInfoInterface = "1";
          } else {
            paramSearchInfoInterface = "0";
          }
          SearchUtils.a("all_result", "more_object", new String[] { str1, str2, paramSearchInfoInterface });
        }
        if ((!TextUtils.isEmpty(((GroupBaseNetSearchModel)localObject).d())) && (((GroupBaseNetSearchModel)localObject).d().contains("opencirclesearch")))
        {
          paramSearchInfoInterface = new HashMap();
          paramSearchInfoInterface.put("ext6", b());
          if ((((GroupBaseNetSearchModel)localObject).jdField_a_of_type_JavaUtilList != null) && (((GroupBaseNetSearchModel)localObject).jdField_a_of_type_JavaUtilList.size() > 0) && ((((GroupBaseNetSearchModel)localObject).jdField_a_of_type_JavaUtilList.get(0) instanceof NetSearchTemplateHorizontalOneItem)))
          {
            localObject = (NetSearchTemplateHorizontalOneItem)((GroupBaseNetSearchModel)localObject).jdField_a_of_type_JavaUtilList.get(0);
            if (((NetSearchTemplateHorizontalOneItem)localObject).d == 6) {
              paramSearchInfoInterface.put("ext8", "1");
            } else if (((NetSearchTemplateHorizontalOneItem)localObject).d == 5) {
              paramSearchInfoInterface.put("ext8", "2");
            }
          }
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 73, 2, 2, paramSearchInfoInterface, null, null);
          UniteSearchReportController.a(null, 0, UniteSearchActivity.d, "0X800BA25", 0, 0, null, null);
        }
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public long a()
  {
    ISearchResultGroupModel localISearchResultGroupModel = this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel;
    if (localISearchResultGroupModel != null)
    {
      int i = SearchUtil.a(localISearchResultGroupModel);
      if (i > 0) {
        return i;
      }
    }
    localISearchResultGroupModel = this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel;
    if ((localISearchResultGroupModel != null) && ((localISearchResultGroupModel instanceof GroupBaseNetSearchModel))) {
      return ((GroupBaseNetSearchModel)localISearchResultGroupModel).jdField_a_of_type_Long;
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
    if ((localContext instanceof SearchInfoInterface))
    {
      localObject1 = (SearchInfoInterface)localContext;
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int i = ((SearchInfoInterface)localObject1).a();
      Object localObject4;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            break label473;
          }
          localObject2 = ((SearchInfoInterface)localObject1).a();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(((SearchInfoInterface)localObject1).a());
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("");
          ((StringBuilder)localObject4).append(a(1));
          SearchUtils.a("sub_result", "more_result", new String[] { localObject2, localObject3, ((StringBuilder)localObject4).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject1).a()) });
          break label473;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel instanceof GroupBaseNetSearchModel)) {
          a((SearchInfoInterface)localObject1);
        }
        if (!SearchUtil.jdField_a_of_type_Boolean)
        {
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
            ((JSONObject)localObject2).put("event_src", "client");
            ((JSONObject)localObject2).put("get_src", "web");
          }
          catch (JSONException localJSONException)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("e = ");
            ((StringBuilder)localObject4).append(localJSONException);
            QLog.e("Q.uniteSearch.SearchResultGroupModelImpl", 2, ((StringBuilder)localObject4).toString());
          }
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject4 = new ReportModelDC02528().module("all_result").action("clk_more");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(a());
          localStringBuilder.append("");
          localObject2 = ((ReportModelDC02528)localObject4).obj1(localStringBuilder.toString()).ver1(((SearchInfoInterface)localObject1).a()).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject2).toString());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(localQQAppInterface.getCurrentAccountUin());
          ((StringBuilder)localObject4).append(SearchUtils.d);
          UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject2).session_id(((StringBuilder)localObject4).toString()));
        }
      }
      SearchUtils.a("all_result", "clk_tab_more", new String[] { b(), SearchUtils.a(((SearchInfoInterface)localObject1).a()), "", SearchUtils.a("dynamic_unite_search.1", ((SearchInfoInterface)localObject1).a()) });
    }
    label473:
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel;
    if (localObject1 != null)
    {
      ((ISearchResultGroupModel)localObject1).a(paramView);
      return;
    }
    if (this.jdField_c_of_type_Boolean) {
      localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse(this.jdField_c_of_type_JavaLangString)));
    }
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
    ISearchResultGroupModel localISearchResultGroupModel = this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel;
    if ((localISearchResultGroupModel instanceof GroupBaseNetSearchModel))
    {
      if (SearchUtils.a(((GroupBaseNetSearchModel)localISearchResultGroupModel).jdField_a_of_type_Long)) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public String b()
  {
    ISearchResultGroupModel localISearchResultGroupModel = this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel;
    if (localISearchResultGroupModel != null) {
      return localISearchResultGroupModel.b();
    }
    return null;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public String c()
  {
    String str2 = this.jdField_b_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModeTitle
 * JD-Core Version:    0.7.0.1
 */