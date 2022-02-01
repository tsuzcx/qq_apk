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
  protected CheckBox a = null;
  protected EditText b = null;
  protected TextView c = null;
  Handler d = new Handler(Looper.getMainLooper());
  private structmsg.StructMsg e = null;
  private String f = "";
  
  protected String a()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("share_troop_request_refuse", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(MD5.b(this.mRuntime.getCurrentAccountUin()), "");
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
        ((SharedPreferences.Editor)localObject).putString(MD5.b(this.mRuntime.getCurrentAccountUin()), paramString);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      int i = ((structmsg.StructMsg)localObject).msg_type.get();
      long l1 = this.e.msg_seq.get();
      long l2 = this.e.req_uin.get();
      int j = this.e.msg.sub_type.get();
      int k = this.e.msg.src_id.get();
      int m = this.e.msg.sub_src_id.get();
      int n = this.e.msg.group_msg_type.get();
      localObject = this.e.msg.actions.get();
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
      this.d.post(new TroopRequestRefuseActivity.1(this, paramEditable));
      return;
    }
    this.c.setText(String.valueOf(25));
    this.c.setTextColor(Color.rgb(119, 119, 119));
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
    super.setContentView(2131629606);
    setTitle(2131895563);
    setLeftButton(2131887648, this);
    setRightHighlightButton(2131916261, this);
    enableRightHighlight(true);
    this.b = ((EditText)findViewById(2131432630));
    this.b.setBackgroundColor(-1);
    this.b.addTextChangedListener(this);
    this.c = ((TextView)findViewById(2131448880));
    this.c.setText(String.valueOf(25));
    this.a = ((CheckBox)findViewById(2131430665));
    paramBundle = a();
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.b.setText(paramBundle);
      paramBundle = this.b;
      paramBundle.setSelection(paramBundle.length());
    }
    paramBundle = GroupSystemMsgController.a().f();
    this.e = GroupSystemMsgController.a().b(paramBundle);
    paramBundle = this.e;
    if (paramBundle != null) {
      this.f = String.valueOf(paramBundle.msg.group_code.get());
    }
    ReportController.b(this.mRuntime, "P_CliOper", "Grp_sysmsg", "", "Grp_ask", "exp_reject", 0, 0, this.f, "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.b;
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
        QQToast.makeText(this, getString(2131917585), 0).show(getTitleBarHeight());
      }
      else
      {
        String str1 = this.b.getText().toString();
        boolean bool = this.a.isChecked();
        a(str1, bool);
        setResult(-1);
        finish();
        AppRuntime localAppRuntime = this.mRuntime;
        String str3 = this.f;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestRefuseActivity
 * JD-Core Version:    0.7.0.1
 */