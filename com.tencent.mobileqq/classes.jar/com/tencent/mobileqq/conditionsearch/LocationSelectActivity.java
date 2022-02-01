package com.tencent.mobileqq.conditionsearch;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.MultiImageTextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LocationSelectActivity
  extends LbsBaseActivity
  implements View.OnClickListener
{
  ConditionSearchManager a;
  Object[] b;
  BaseAddress[] c;
  int[] d;
  String[] e;
  int f = 0;
  String g = "1";
  IphonePickerView.PickerViewAdapter h = new LocationSelectActivity.3(this);
  ActionSheet i;
  IphonePickerView j;
  IphonePickerView.IphonePickListener k = new LocationSelectActivity.4(this);
  long l = 0L;
  final int m = 1000;
  Handler n = new LocationSelectActivity.5(this);
  DialogInterface.OnDismissListener o = new LocationSelectActivity.7(this);
  private boolean p;
  private FormSimpleItem q;
  private FormSimpleItem r;
  private FormSimpleItem s;
  private int t;
  private boolean u;
  private BaseAddress v;
  private String w;
  private LBSObserver x = new LocationSelectActivity.6(this);
  
  private int a(ArrayList<? extends BaseAddress> paramArrayList, String paramString)
  {
    int i2 = paramArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((BaseAddress)paramArrayList.get(i1)).code.equals(paramString)) {
        return i1;
      }
      i1 += 1;
    }
    return 0;
  }
  
  private void a()
  {
    this.e = new String[] { "0", "0", "0" };
    this.c = null;
  }
  
  private void a(FormSimpleItem paramFormSimpleItem, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.equals("不限")) {
        str = "";
      }
    }
    paramFormSimpleItem.setRightText(str);
  }
  
  private void a(FormSimpleItem paramFormSimpleItem, boolean paramBoolean)
  {
    if (paramFormSimpleItem != null)
    {
      this.s.setEnabled(paramBoolean);
      paramFormSimpleItem = this.s;
      int i1;
      if (!paramBoolean) {
        i1 = 2;
      } else {
        i1 = 0;
      }
      paramFormSimpleItem.setLeftTextColor(i1);
    }
    if ((!paramBoolean) && (AppSetting.e)) {
      this.s.setContentDescription(HardCodeUtil.a(2131904252));
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    Intent localIntent = new Intent("action_get_lbs_location");
    localIntent.putExtra("code", paramArrayOfString);
    ConditionSearchManager localConditionSearchManager = this.a;
    if (localConditionSearchManager != null)
    {
      paramArrayOfString = localConditionSearchManager.f(paramArrayOfString);
      if (paramArrayOfString != null) {
        localIntent.putExtra("location", paramArrayOfString);
      }
    }
    if ((getIntent() != null) && (getIntent().hasExtra("select_location_broadcast_callback"))) {
      localIntent.putExtra("select_location_broadcast_callback", getIntent().getIntExtra("select_location_broadcast_callback", 0));
    }
    sendBroadcast(localIntent);
  }
  
  private void b()
  {
    String[] arrayOfString = getIntent().getStringArrayExtra("param_location");
    if (arrayOfString != null)
    {
      a();
      if ((this.t == 0) && (this.a.m()) && ((arrayOfString == null) || (arrayOfString[0].equals("0")))) {
        return;
      }
      this.g = arrayOfString[0];
      int i2 = arrayOfString.length;
      int i1 = 1;
      while (i1 < i2)
      {
        this.e[(i1 - 1)] = arrayOfString[i1];
        i1 += 1;
      }
    }
  }
  
  private void c()
  {
    this.v = this.a.a(this.g);
    Object localObject = this.v;
    if (localObject == null) {
      return;
    }
    if (localObject != null)
    {
      this.f = ((BaseAddress)localObject).getColumnNember();
      localObject = this.s;
      if (localObject != null)
      {
        if (this.f == 0)
        {
          a((FormSimpleItem)localObject, false);
          return;
        }
        a((FormSimpleItem)localObject, true);
      }
      int i1 = this.f;
      this.b = new Object[i1];
      this.c = new BaseAddress[i1];
      this.d = new int[i1];
      if (i1 == 0) {
        return;
      }
      localObject = this.v;
      int i3 = this.e.length;
      i1 = 0;
      int i2 = 0;
      while (i1 < i3)
      {
        if (!"0".equals(this.e[i1]))
        {
          this.b[i2] = ((BaseAddress)localObject).getDataList();
          BaseAddress[] arrayOfBaseAddress = this.c;
          BaseAddress localBaseAddress = (BaseAddress)((BaseAddress)localObject).dataMap.get(this.e[i1]);
          arrayOfBaseAddress[i2] = localBaseAddress;
          this.d[i2] = a((ArrayList)this.b[i2], this.e[i1]);
          i2 += 1;
          localObject = localBaseAddress;
          if (localBaseAddress == null) {
            return;
          }
        }
        i1 += 1;
      }
      if (i2 == 0)
      {
        this.b[i2] = ((BaseAddress)localObject).getDataList();
        this.c[i2] = ((BaseAddress)((BaseAddress)localObject).dataMap.get(Integer.valueOf(0)));
        return;
      }
      try
      {
        if (i2 < this.f)
        {
          this.b[i2] = ((BaseAddress)localObject).getDataList();
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationSelectActivity", 2, "", localException);
        }
      }
    }
  }
  
  private void d()
  {
    this.u = getIntent().getBooleanExtra("param_is_popup", true);
    if (this.u)
    {
      setRightHighlightButton(2131889474, new LocationSelectActivity.1(this));
      enableRightHighlight(true);
      this.leftView.setVisibility(8);
    }
    else
    {
      setLeftViewName(2131887440);
    }
    this.q = ((FormSimpleItem)findViewById(2131431200));
    this.r = ((FormSimpleItem)findViewById(2131431199));
    this.s = ((FormSimpleItem)findViewById(2131431201));
    int i1 = this.t;
    if ((i1 != 0) && (i1 != 2))
    {
      setTitle(2131887998);
      this.q.setVisibility(8);
    }
    else
    {
      setTitle(2131888000);
      this.q.setLeftIcon(null);
      this.q.setLeftText(getResources().getString(2131888005));
      this.q.setLeftTextColor(1);
      this.q.a(false);
      this.q.setOnClickListener(this);
      if (AppSetting.e) {
        this.q.setContentDescription(HardCodeUtil.a(2131904248));
      }
    }
    Object localObject1 = getIntent().getStringExtra("param_title");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      setTitle((CharSequence)localObject1);
    }
    this.r.setLeftIcon(null);
    this.r.setLeftText(getResources().getString(2131887997));
    localObject1 = this.v;
    if (localObject1 != null)
    {
      if (localObject1 != null) {
        localObject1 = ((BaseAddress)localObject1).name;
      } else {
        localObject1 = HardCodeUtil.a(2131904250);
      }
    }
    else {
      localObject1 = null;
    }
    a(this.r, (String)localObject1);
    this.r.setOnClickListener(this);
    Object localObject2;
    if (AppSetting.e)
    {
      localObject2 = this.r;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131904246));
      localStringBuilder.append((String)localObject1);
      ((FormSimpleItem)localObject2).setContentDescription(localStringBuilder.toString());
    }
    this.s.setLeftIcon(null);
    this.s.setLeftText(getResources().getString(2131888001));
    this.s.setOnClickListener(this);
    if (this.f == 0)
    {
      a(this.s, false);
      return;
    }
    a(this.s, true);
    this.w = getIntent().getStringExtra("param_location_param");
    localObject1 = this.a.e(this.w);
    if (localObject1[0].equals(this.v.name)) {
      this.w = localObject1[1];
    }
    a(this.s, this.w);
    if (AppSetting.e)
    {
      localObject1 = this.s;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131904244));
      ((StringBuilder)localObject2).append(this.s.getRightTextView().getText());
      ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    }
  }
  
  private void e()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this, 2131892104, 0).show(getTitleBarHeight());
      return;
    }
    this.l = System.currentTimeMillis();
    addObserver(this.x);
    ((LBSHandler)this.app.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).b();
    this.q.setLeftTextColor(2);
    Drawable localDrawable = getResources().getDrawable(2130839590);
    this.q.setRightIcon(localDrawable);
    ((Animatable)localDrawable).start();
    this.q.setEnabled(false);
  }
  
  private void f()
  {
    this.i = ActionSheet.createMenuSheet(this);
    DispatchActionMoveScrollView localDispatchActionMoveScrollView = (DispatchActionMoveScrollView)this.i.findViewById(2131427560);
    localDispatchActionMoveScrollView.a = true;
    localDispatchActionMoveScrollView.setBackgroundResource(17170445);
    this.i.setOnDismissListener(this.o);
    this.i.setCloseAutoRead(true);
    this.j = ((IphonePickerView)getLayoutInflater().inflate(2131627482, null));
    this.j.a(this.h);
    int i1 = 0;
    while (i1 < this.f)
    {
      this.j.setSelection(i1, this.d[i1]);
      i1 += 1;
    }
    this.j.setPickListener(this.k);
    if (Build.VERSION.SDK_INT >= 11) {
      this.i.getWindow().setFlags(16777216, 16777216);
    }
    this.i.setActionContentView(this.j, null);
    try
    {
      this.p = false;
      this.i.show();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationSelectActivity", 2, localThrowable.getMessage());
      }
      this.p = true;
    }
    this.s.setRightTextColor(1);
  }
  
  private String g()
  {
    Object localObject = new StringBuilder();
    int i1 = 0;
    while (i1 < this.f)
    {
      BaseAddress[] arrayOfBaseAddress = this.c;
      if ((arrayOfBaseAddress != null) && (arrayOfBaseAddress[i1] != null) && (!"0".equals(arrayOfBaseAddress[i1].code)))
      {
        ((StringBuilder)localObject).append(this.c[i1].name);
        ((StringBuilder)localObject).append("-");
      }
      i1 += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "不限";
    }
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
  }
  
  private String h()
  {
    String str = g();
    if (!"不限".equals(str)) {
      return str;
    }
    return "";
  }
  
  private String[] i()
  {
    String[] arrayOfString = new String[3];
    int i1 = 0;
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    BaseAddress[] arrayOfBaseAddress = this.c;
    if (arrayOfBaseAddress != null)
    {
      int i2 = arrayOfBaseAddress.length;
      while (i1 < i2)
      {
        BaseAddress localBaseAddress = arrayOfBaseAddress[i1];
        if (localBaseAddress == null) {
          break;
        }
        arrayOfString[(localBaseAddress.addressType - 1)] = String.valueOf(ConditionSearchManager.f(localBaseAddress.code));
        i1 += 1;
      }
    }
    return arrayOfString;
  }
  
  void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    Object localObject1 = this.q;
    int i1 = 1;
    ((FormSimpleItem)localObject1).setLeftTextColor(1);
    Object localObject2 = this.q;
    localObject1 = null;
    ((FormSimpleItem)localObject2).setRightIcon(null);
    this.q.setEnabled(true);
    int i2 = 0;
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length == 4))
    {
      if (this.p)
      {
        if (!TextUtils.isEmpty(paramArrayOfString[0])) {
          localObject1 = this.a.a(paramArrayOfString[0]);
        }
        if (localObject1 != null)
        {
          this.g = paramArrayOfString[0];
          a();
          int i4 = paramArrayOfString.length;
          while (i1 < i4)
          {
            int i3 = i2;
            if (!TextUtils.isEmpty(paramArrayOfString[i1]))
            {
              this.e[i2] = paramArrayOfString[i1];
              i3 = i2 + 1;
            }
            i1 += 1;
            i2 = i3;
          }
          c();
          a(this.r, this.v.name);
          paramArrayOfString = this.r;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904247));
          ((StringBuilder)localObject1).append(this.v.name);
          paramArrayOfString.setContentDescription(((StringBuilder)localObject1).toString());
          if (this.f == 0) {
            paramArrayOfString = "";
          } else {
            paramArrayOfString = g();
          }
          a(this.s, paramArrayOfString);
          localObject1 = this.s;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131904249));
          ((StringBuilder)localObject2).append(paramArrayOfString);
          ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("invalid country code!! | cournty code is :");
          ((StringBuilder)localObject1).append(paramArrayOfString[0]);
          QLog.d("LocationSelectActivity", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    else {
      QQToast.makeText(this, 2131887994, 0).show(getTitleBarHeight());
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_country_code");
      if ((!TextUtils.isEmpty(paramIntent)) && (!paramIntent.equals(this.g)))
      {
        if (this.a.a(paramIntent) == null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("doOnActivityResult | should not be here, can not get country by code ! result code = ");
            localStringBuilder.append(paramIntent);
            QLog.d("LocationSelectActivity", 2, localStringBuilder.toString());
          }
          return;
        }
        this.g = paramIntent;
        a();
        c();
        a(this.r, this.v.name);
        if (this.f == 0) {
          paramIntent = "";
        } else {
          paramIntent = "不限";
        }
        a(this.s, paramIntent);
        if (AppSetting.e)
        {
          paramIntent = this.r;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131904251));
          localStringBuilder.append(this.v.name);
          paramIntent.setContentDescription(localStringBuilder.toString());
          paramIntent = this.s;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131904245));
          localStringBuilder.append(this.s.getRightTextView().getText());
          paramIntent.setContentDescription(localStringBuilder.toString());
        }
        if (this.t == 0)
        {
          paramIntent = this.app;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ConditionSearchManager.f(this.g));
          localStringBuilder.append("");
          ReportController.b(paramIntent, "CliOper", "", "", "0X8004247", "0X8004247", 0, 0, localStringBuilder.toString(), "", "", "");
          return;
        }
        paramIntent = this.app;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ConditionSearchManager.f(this.g));
        localStringBuilder.append("");
        ReportController.b(paramIntent, "CliOper", "", "", "0X8004249", "0X8004249", 0, 0, localStringBuilder.toString(), "", "", "");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.t = getIntent().getIntExtra("param_req_type", 0);
    setContentBackgroundResource(2130838958);
    setContentView(2131627507);
    this.a = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    b();
    c();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.x);
    super.doOnDestroy();
  }
  
  protected int getContentTipsForEnableLbs()
  {
    return 2131887991;
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    String[] arrayOfString = new String[4];
    arrayOfString[0] = this.g;
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    arrayOfString[3] = "0";
    Object localObject = this.c;
    int i1;
    if (localObject != null)
    {
      int i2 = localObject.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject = this.c;
        if (localObject[i1] == null) {
          break;
        }
        arrayOfString[localObject[i1].addressType] = this.c[i1].code;
        i1 += 1;
      }
    }
    localIntent.putExtra("param_location", arrayOfString);
    localObject = h();
    if (this.v != null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = this.v.name;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.v.name);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(g());
        localObject = ((StringBuilder)localObject).toString();
      }
      localIntent.putExtra("param_location_param", (String)localObject);
    }
    else
    {
      i1 = this.t;
      if ((i1 != 2) && (i1 != 3)) {
        localObject = "不限";
      } else {
        localObject = "";
      }
      localIntent.putExtra("param_location_param", (String)localObject);
    }
    a(arrayOfString);
    setResult(-1, localIntent);
    finish();
    if (this.u) {
      overridePendingTransition(0, 2130771995);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    boolean bool2 = true;
    switch (i1)
    {
    default: 
      break;
    case 2131431201: 
      f();
      break;
    case 2131431200: 
      ReportController.b(this.app, "CliOper", "", "", "0X8004246", "0X8004246", 0, 0, "", "", "", "");
      this.p = true;
      checkAndEnableLbs(new LocationSelectActivity.2(this));
      break;
    case 2131431199: 
      Intent localIntent = new Intent(this, CountrySelectActivity.class);
      localIntent.putExtra("key_country_code", this.g);
      i1 = this.t;
      boolean bool1 = bool2;
      if (i1 != 1) {
        if (i1 == 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      localIntent.putExtra("key_no_limit_allow", bool1);
      startActivityForResult(localIntent, 1000);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onLBSForbidden() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */