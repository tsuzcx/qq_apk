package com.tencent.mobileqq.search.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.activity.MessageSearchDetailActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageSearchResultModel
  extends ISearchResultPositionModel
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FullMessageSearchResult.SearchResultItem jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private String jdField_b_of_type_JavaLangString;
  
  public MessageSearchResultModel(QQAppInterface paramQQAppInterface, String paramString, FullMessageSearchResult.SearchResultItem paramSearchResultItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem = paramSearchResultItem;
    if (paramSearchResultItem.user.getType() == 3000)
    {
      int i = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramSearchResultItem.user.uin);
      if (i <= 0)
      {
        this.jdField_b_of_type_JavaLangString = "";
        return;
      }
      this.jdField_b_of_type_JavaLangString = String.valueOf(i);
    }
  }
  
  public int a()
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType();
    int j = 1;
    int i = j;
    if (k != 0) {
      if (k != 1)
      {
        if (k != 3000)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Face type is illegal. type = ");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType());
            QLog.d("MessageSearchResultModel", 2, localStringBuilder.toString());
            return 1;
          }
        }
        else
        {
          return 101;
        }
      }
      else {
        i = 4;
      }
    }
    return i;
  }
  
  public CharSequence a()
  {
    if (this.jdField_b_of_type_JavaLangCharSequence == null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageMessageUniseq.size();
      if (i == 1)
      {
        this.jdField_b_of_type_JavaLangCharSequence = SearchUtils.a(((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageList.get(0)).msg, this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131706698));
        ((StringBuilder)localObject).append("\"");
        localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
        String str = this.jdField_a_of_type_JavaLangString;
        ((SpannableStringBuilder)localObject).append(SearchUtils.a(str, str));
        ((SpannableStringBuilder)localObject).append("\"").append("相关记录");
        this.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject);
      }
    }
    return this.jdField_b_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.uin;
  }
  
  public void a(View paramView)
  {
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtils.b.containsKey(this)))
    {
      Object localObject1 = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject2).put("event_src", "client");
        ((JSONObject)localObject2).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject1).jdField_a_of_type_Int);
        ((JSONObject)localObject2).put("get_src", "native");
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("MessageSearchResultModel", 2, localStringBuilder.toString());
      }
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((SearchUtils.ObjectItemInfo)localObject1).jdField_a_of_type_Long);
      localStringBuilder.append("");
      localObject1 = localReportModelDC02528.obj1(localStringBuilder.toString()).obj2(((SearchUtils.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString).ver1(((SearchUtils.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append(SearchUtils.d);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject2).toString()));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageMessageUniseq.size() == 1)
    {
      RecentUtil.jdField_a_of_type_Boolean = true;
      RecentUtil.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageList.get(0);
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.uin, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType(), ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.uin, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType()), false);
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, paramView, false);
    }
    else
    {
      MessageSearchDetailActivity.a(paramView.getContext(), b(), this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem);
    }
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.uin, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType());
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType() == 3000) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      return SearchUtils.a(this.jdField_b_of_type_JavaLangString);
    }
    return "";
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.MessageSearchResultModel
 * JD-Core Version:    0.7.0.1
 */