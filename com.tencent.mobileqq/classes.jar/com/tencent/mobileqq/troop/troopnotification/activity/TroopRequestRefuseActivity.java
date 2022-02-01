package com.tencent.mobileqq.troop.troopnotification.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopRequestRefuseActivity
  extends QIphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  protected CheckBox a;
  protected EditText a;
  protected TextView a;
  private String jdField_a_of_type_JavaLangString = "";
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
  
  public TroopRequestRefuseActivity()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  protected String a()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("share_troop_request_refuse", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(MD5.a(this.mRuntime.getCurrentAccountUin()), "");
    }
    return "";
  }
  
  protected void a(String paramString)
  {
    Object localObject = getSharedPreferences("share_troop_request_refuse", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString(MD5.a(this.mRuntime.getCurrentAccountUin()), paramString);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      int i = ((structmsg.StructMsg)localObject).msg_type.get();
      long l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int k = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((List)localObject).size() > 0)
        {
          localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
          if (!TextUtils.isEmpty(paramString)) {
            ((structmsg.SystemMsgActionInfo)localObject).msg.set(paramString);
          }
          ((structmsg.SystemMsgActionInfo)localObject).blacklist.set(paramBoolean);
          paramString = (IMessageHandler)this.mRuntime.getRuntimeService(IMessageHandler.class, "");
          if (paramString != null) {
            paramString.sendGroupSystemMsgAction(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 0);
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.length() != 0))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new TroopRequestRefuseActivity.1(this, paramEditable));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(25));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.rgb(119, 119, 119));
    enableRightHighlight(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562998);
    setTitle(2131697790);
    setLeftButton(2131690728, this);
    setRightHighlightButton(2131718755, this);
    enableRightHighlight(true);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366328));
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379980));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(25));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364596));
    paramBundle = a();
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramBundle);
      paramBundle = this.jdField_a_of_type_AndroidWidgetEditText;
      paramBundle.setSelection(paramBundle.length());
    }
    paramBundle = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(paramBundle);
    paramBundle = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if (paramBundle != null) {
      this.jdField_a_of_type_JavaLangString = String.valueOf(paramBundle.msg.group_code.get());
    }
    ReportController.b(this.mRuntime, "P_CliOper", "Grp_sysmsg", "", "Grp_ask", "exp_reject", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a((String)localObject);
      }
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightHighLView)
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.a(this, getString(2131719980), 0).b(getTitleBarHeight());
      }
      else
      {
        String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        boolean bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
        a(str1, bool);
        setResult(-1);
        finish();
        AppRuntime localAppRuntime = this.mRuntime;
        String str3 = this.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(str1)) {
          str1 = "0";
        } else {
          str1 = "1";
        }
        String str2;
        if (bool) {
          str2 = "0";
        } else {
          str2 = "1";
        }
        ReportController.b(localAppRuntime, "P_CliOper", "Grp_sysmsg", "", "Grp_ask", "Clk_send_reject", 0, 0, str3, str1, str2, "");
      }
    }
    else if (paramView == this.leftViewNotBack) {
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestRefuseActivity
 * JD-Core Version:    0.7.0.1
 */