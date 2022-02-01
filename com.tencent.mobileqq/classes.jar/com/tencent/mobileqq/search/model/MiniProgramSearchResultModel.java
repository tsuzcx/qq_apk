package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramSearchResultModel
  extends IContactSearchModel
{
  public MiniAppLocalSearchEntity a;
  protected String a;
  public int[] a;
  
  public MiniProgramSearchResultModel(QQAppInterface paramQQAppInterface, int paramInt, MiniAppLocalSearchEntity paramMiniAppLocalSearchEntity, String paramString)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity = paramMiniAppLocalSearchEntity;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 0;
  }
  
  protected long a(String paramString)
  {
    return 0L;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.desc;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId;
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.MINI_APP_LOCAL_SEARCH) != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.showMask == 0) {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById((Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId, null, null, null, null, 1005, null);
      } else {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById((Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId, null, null, null, null, 1027, null);
      }
    }
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (SearchUtils.b.containsKey(this))
      {
        paramView = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
        Object localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("obj_lct", paramView.jdField_a_of_type_Int);
          ((JSONObject)localObject1).put("get_src", "native");
        }
        catch (JSONException localJSONException)
        {
          localObject2 = h;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("e = ");
          localStringBuilder.append(localJSONException);
          QLog.e((String)localObject2, 2, localStringBuilder.toString());
        }
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item");
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramView.jdField_a_of_type_Long);
        ((StringBuilder)localObject2).append("");
        localReportModelDC02528 = localReportModelDC02528.obj1(((StringBuilder)localObject2).toString()).obj2(this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId).ver1(paramView.jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.d));
        if (c()) {
          paramView = "1";
        } else {
          paramView = "0";
        }
        paramView = localReportModelDC02528.ver3(paramView).ver7(((JSONObject)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject1).append(SearchUtils.d);
        UniteSearchReportController.a(null, paramView.session_id(((StringBuilder)localObject1).toString()));
      }
      SearchUtils.b(localQQAppInterface, this.jdField_a_of_type_JavaLangString, this.i, e(), e());
      if ((this.i != null) && (!TextUtils.isEmpty(this.i)))
      {
        UniteSearchReportController.a(null, 0, this.b, "0X8009D31", 3, 0, null, null);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appName != null) && (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appName.equals(this.jdField_a_of_type_JavaLangString)))
      {
        UniteSearchReportController.a(null, 0, this.b, "0X8009D33", 0, 0, this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId, null);
        return;
      }
      UniteSearchReportController.a(null, 0, this.b, "0X8009D45", 0, 0, this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId, null);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appName, this.jdField_a_of_type_JavaLangString, 10, true);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appName;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.showMask & 0x1) != 0;
  }
  
  public int d()
  {
    return 0;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
  
  public int e()
  {
    return 6;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId;
  }
  
  public String f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.iconUrl;
  }
  
  public String g()
  {
    return "https://qzonestyle.gtimg.cn/aoi/sola/20190108152813_orkMRcBegl.png";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.MiniProgramSearchResultModel
 * JD-Core Version:    0.7.0.1
 */