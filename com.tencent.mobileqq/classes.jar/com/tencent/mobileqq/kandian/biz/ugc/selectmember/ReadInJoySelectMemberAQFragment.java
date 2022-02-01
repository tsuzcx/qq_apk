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
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadInJoySelectMemberAQFragment
  extends ReadInJoySelectMemberFragment
{
  protected QQProgressDialog a;
  protected boolean b = false;
  ReadInJoyObserver c = new ReadInJoySelectMemberAQFragment.2(this);
  private int f;
  private int g = 10000;
  private int h = -1;
  private String i = "";
  private boolean j;
  
  private String a(ResultRecord paramResultRecord, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ask_rowkey", paramString);
      localJSONObject.put("uin", String.valueOf(RIJQQAppInterfaceUtil.c()));
      localJSONObject.put("invite_uin", paramResultRecord.a());
      localJSONObject.put("invite_type", paramResultRecord.c());
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
      ThreadManager.executeOnSubThread(new ReadInJoySelectMemberAQFragment.3(this, this.d, this.e.f()));
    }
  }
  
  protected void a()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.a.dismiss();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.c(paramInt1);
      if (!this.a.isShowing())
      {
        this.a.show();
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
      QQToast.makeText(getBaseActivity(), 1, getString(2131915328), 0).show(this.f);
      return;
    }
    a(2131915510, 2131915507, this.g);
    ReadInJoyLogicEngine.a().a(this.d, RIJQQAppInterfaceUtil.c(), this.e.f());
  }
  
  protected void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_callback", this.e.e());
    localIntent.putExtra("result_msg", this.i);
    localIntent.putExtra("result_code", this.h);
    getBaseActivity().setResult(-1, localIntent);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.f = getBaseActivity().getResources().getDimensionPixelSize(2131299920);
    if (this.a == null)
    {
      this.a = new QQProgressDialog(getBaseActivity(), this.f);
      this.a.setCanceledOnTouchOutside(true);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.c);
  }
  
  public boolean onBackEvent()
  {
    this.h = 1;
    if (this.j) {
      this.h = 2;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.dismiss();
      this.a = null;
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.c);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberAQFragment
 * JD-Core Version:    0.7.0.1
 */