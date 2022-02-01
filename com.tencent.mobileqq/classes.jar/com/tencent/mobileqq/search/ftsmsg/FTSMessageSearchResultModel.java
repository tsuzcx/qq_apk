package com.tencent.mobileqq.search.ftsmsg;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSMessageSearchResultModel
  extends FTSEntitySearchResultModel
{
  protected String c;
  private String d;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  
  public FTSMessageSearchResultModel(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<String> paramArrayList, List<FTSMessage> paramList, String paramString3, CharSequence paramCharSequence)
  {
    super(paramQQAppInterface, paramString1, paramString2, paramArrayList, paramList);
    paramString1 = (FTSMessage)paramList.get(0);
    this.jdField_d_of_type_JavaLangString = String.valueOf(paramString1.uin);
    this.jdField_e_of_type_JavaLangString = paramString1.senderuin;
    this.jdField_e_of_type_Int = paramString1.istroop;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    if (this.jdField_e_of_type_Int == 3000)
    {
      int i = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.jdField_d_of_type_JavaLangString);
      if (i <= 0)
      {
        this.f = "";
        return;
      }
      this.f = String.valueOf(i);
    }
  }
  
  public int a()
  {
    int k = this.jdField_e_of_type_Int;
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
            localStringBuilder.append(this.jdField_e_of_type_Int);
            QLog.d("FTSMessageSearchResultModel", 2, localStringBuilder.toString());
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
    if (this.jdField_d_of_type_JavaLangCharSequence == null)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (i == 1)
      {
        this.jdField_d_of_type_JavaLangCharSequence = SearchUtils.a(((FTSEntity)this.jdField_a_of_type_JavaUtilList.get(0)).mContent, ((FTSEntity)this.jdField_a_of_type_JavaUtilList.get(0)).mProximityStart, this.jdField_a_of_type_JavaUtilArrayList);
      }
      else
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131705055));
        ((StringBuilder)localObject).append("\"");
        localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
        if ((this.jdField_c_of_type_JavaLangString != null) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())))
        {
          String str = this.jdField_c_of_type_JavaLangString;
          ((SpannableStringBuilder)localObject).append(SearchUtils.a(str, str));
        }
        else
        {
          ((SpannableStringBuilder)localObject).append(SearchUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
        }
        ((SpannableStringBuilder)localObject).append("\"").append("相关记录");
        this.jdField_d_of_type_JavaLangCharSequence = ((CharSequence)localObject);
      }
    }
    return this.jdField_d_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    Object localObject3;
    Object localObject4;
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      if (SearchUtils.b.containsKey(this))
      {
        localObject2 = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Int);
          ((JSONObject)localObject3).put("get_src", "native");
        }
        catch (JSONException localJSONException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("e = ");
          localStringBuilder.append(localJSONException);
          QLog.e("FTSMessageSearchResultModel", 2, localStringBuilder.toString());
        }
        localObject4 = new ReportModelDC02528().module("all_result").action("clk_item");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Long);
        localStringBuilder.append("");
        localObject2 = ((ReportModelDC02528)localObject4).obj1(localStringBuilder.toString()).obj2(((SearchUtils.ObjectItemInfo)localObject2).jdField_b_of_type_JavaLangString).ver1(((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((QQAppInterface)localObject1).getCurrentAccountUin());
        ((StringBuilder)localObject3).append(SearchUtils.d);
        UniteSearchReportController.a(null, ((ReportModelDC02528)localObject2).session_id(((StringBuilder)localObject3).toString()));
      }
      localObject1 = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localObject1 != null) {
        ((InputMethodManager)localObject1).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      UniteSearchReportController.a(null, this.v, 0, "0X8009D4D", 0, 0, null, null);
    }
    if (this.jdField_a_of_type_JavaLangCharSequence != null) {
      this.jdField_a_of_type_JavaLangCharSequence = SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, this.jdField_e_of_type_JavaLangString);
    }
    Object localObject1 = (Integer)paramView.getTag(2131380885);
    Object localObject2 = (Integer)paramView.getTag(2131380883);
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (((Integer)localObject1).intValue() >= 0) && (((Integer)localObject2).intValue() >= 0))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(localObject2);
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(((Integer)localObject1).intValue() + 1);
      SearchUtils.a("all_result", "clk_talk", new String[] { localObject3, localObject2, ((StringBuilder)localObject4).toString() });
    }
    else if ((paramView.getContext() instanceof FTSEntitySearchDetailActivity))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(localObject2);
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(((Integer)localObject1).intValue() + 1);
      SearchUtils.a("talk", "clk_talk", new String[] { localObject3, localObject2, ((StringBuilder)localObject4).toString() });
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 1;
    } else {
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 2;
    }
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.g = this.jdField_e_of_type_Int;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.h = this.jdField_b_of_type_Int;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.i = this.jdField_c_of_type_Int;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.j = this.jdField_d_of_type_Int;
    SQLiteFTSUtils.a(paramView);
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      RecentUtil.jdField_a_of_type_Boolean = true;
      localObject1 = (FTSMessage)this.jdField_a_of_type_JavaUtilList.get(0);
      if (((FTSMessage)localObject1).msgExts != null) {
        if ((((FTSMessage)localObject1).istroop != 1) && (((FTSMessage)localObject1).istroop != 3000)) {
          RecentUtil.jdField_a_of_type_Long = ((TextMsgExts)((FTSMessage)localObject1).msgExts).time;
        } else {
          RecentUtil.jdField_a_of_type_Long = ((TextMsgExts)((FTSMessage)localObject1).msgExts).shmsgseq;
        }
      }
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, (String)this.jdField_a_of_type_JavaLangCharSequence, false);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, paramView, false);
    }
    else
    {
      FTSEntitySearchDetailActivity.a(paramView.getContext(), b(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_JavaUtilList, 1, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int);
    }
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
  }
  
  public CharSequence b()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public CharSequence c()
  {
    if ((this.jdField_e_of_type_Int == 3000) && (!TextUtils.isEmpty(this.f))) {
      return SearchUtils.a(this.f);
    }
    return "";
  }
  
  public CharSequence e()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_b_of_type_JavaLangCharSequence == null) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof FTSMessage)))
    {
      CharSequence localCharSequence = ((FTSMessage)this.jdField_a_of_type_JavaUtilList.get(0)).matchTitle;
      if (localCharSequence != null) {
        this.jdField_b_of_type_JavaLangCharSequence = localCharSequence;
      }
    }
    return this.jdField_b_of_type_JavaLangCharSequence;
  }
  
  public CharSequence f()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_c_of_type_JavaLangCharSequence == null) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof FTSMessage)))
    {
      CharSequence localCharSequence = ((FTSMessage)this.jdField_a_of_type_JavaUtilList.get(0)).matchSecondTitle;
      if (localCharSequence != null) {
        this.jdField_c_of_type_JavaLangCharSequence = localCharSequence;
      }
    }
    return this.jdField_c_of_type_JavaLangCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchResultModel
 * JD-Core Version:    0.7.0.1
 */