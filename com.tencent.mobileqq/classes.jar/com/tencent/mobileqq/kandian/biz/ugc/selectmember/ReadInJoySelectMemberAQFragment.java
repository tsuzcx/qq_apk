package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadInJoySelectMemberAQFragment
  extends ReadInJoySelectMemberFragment
{
  private int jdField_a_of_type_Int;
  ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoySelectMemberAQFragment.2(this);
  protected QQProgressDialog a;
  private String jdField_a_of_type_JavaLangString = "";
  protected boolean a;
  private int jdField_b_of_type_Int = 10000;
  private boolean jdField_b_of_type_Boolean;
  private int c = -1;
  
  public ReadInJoySelectMemberAQFragment()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private String a(ResultRecord paramResultRecord, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ask_rowkey", paramString);
      localJSONObject.put("uin", String.valueOf(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin()));
      localJSONObject.put("invite_uin", paramResultRecord.a());
      localJSONObject.put("invite_type", paramResultRecord.a());
    }
    catch (Exception paramResultRecord)
    {
      paramResultRecord.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.executeOnSubThread(new ReadInJoySelectMemberAQFragment.3(this, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.b()));
    }
  }
  
  protected void a()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.c(paramInt1);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.rightViewText.postDelayed(new ReadInJoySelectMemberAQFragment.1(this, paramInt2), paramInt3);
      }
    }
  }
  
  protected void b()
  {
    if (getBaseActivity() == null) {
      return;
    }
    e();
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "network error!");
      }
      QQToast.a(getBaseActivity(), 1, getString(2131717855), 0).b(this.jdField_a_of_type_Int);
      return;
    }
    a(2131718029, 2131718026, this.jdField_b_of_type_Int);
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList, ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.b());
  }
  
  protected void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_callback", this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a());
    localIntent.putExtra("result_msg", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("result_code", this.c);
    getBaseActivity().setResult(-1, localIntent);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Int = getBaseActivity().getResources().getDimensionPixelSize(2131299168);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getBaseActivity(), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public boolean onBackEvent()
  {
    this.c = 1;
    if (this.jdField_b_of_type_Boolean) {
      this.c = 2;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberAQFragment
 * JD-Core Version:    0.7.0.1
 */