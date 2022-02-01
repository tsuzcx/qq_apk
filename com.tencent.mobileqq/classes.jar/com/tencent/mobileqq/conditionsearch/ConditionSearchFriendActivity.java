package com.tencent.mobileqq.conditionsearch;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ConditionSearchFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String X = HardCodeUtil.a(2131900546);
  boolean A = false;
  boolean B = true;
  boolean C = true;
  String D;
  BaseAddress E;
  Object[] F;
  int G;
  BaseAddress[] H;
  int[] I;
  String[] J;
  IphonePickerView.PickerViewAdapter K = new ConditionSearchFriendActivity.3(this);
  IphonePickerView.IphonePickListener L = new ConditionSearchFriendActivity.4(this);
  DialogInterface.OnDismissListener M = new ConditionSearchFriendActivity.5(this);
  ActionSheet N;
  IphonePickerView O;
  int P;
  Handler Q = new ConditionSearchFriendActivity.7(this);
  QQProgressDialog R;
  int S = 0;
  ConditionSearchManager.ISearchListener T = new ConditionSearchFriendActivity.8(this);
  ConditionSearchManager.IConfigListener U = new ConditionSearchFriendActivity.9(this);
  LBSObserver V = new ConditionSearchFriendActivity.10(this);
  private final int W = 20;
  private int Y = 0;
  ConditionSearchManager a;
  String b;
  volatile int c;
  volatile int d;
  volatile int e;
  volatile int f;
  volatile int g;
  volatile int h;
  volatile int i;
  EditText j;
  boolean k = false;
  FormSimpleItem l;
  FormSimpleItem m;
  FormSimpleItem n;
  FormSimpleItem o;
  FormSimpleItem p;
  Button q;
  TextView r;
  TextView s;
  TextView t;
  TextView u;
  View v;
  View w;
  View x;
  View y;
  View z;
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
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
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i1 = this.G;
    if ((i1 > 0) && (i1 <= 3))
    {
      if (paramInt == 1)
      {
        if ("不限".equals(this.m.getRightTextView().getText())) {
          this.m.setRightText(this.a.d(i()));
        }
        e(1);
        return;
      }
      if (paramInt == 2)
      {
        if ("不限".equals(this.n.getRightTextView().getText())) {
          this.n.setRightText(this.a.d(i()));
        }
        e(2);
      }
    }
    else if (!"0".equals(this.D))
    {
      Intent localIntent = new Intent(this, CountrySelectActivity.class);
      localIntent.putExtra("key_country_code", this.D);
      localIntent.putExtra("key_no_limit_allow", true);
      if (paramInt == 1)
      {
        startActivityForResult(localIntent, 1003);
        return;
      }
      if (paramInt == 2) {
        startActivityForResult(localIntent, 1004);
      }
    }
    else
    {
      if (!paramBoolean)
      {
        b(paramInt);
        g();
      }
      if (paramInt == 1)
      {
        this.m.setRightText(this.a.d(i()));
        e(1);
        return;
      }
      if (paramInt == 2)
      {
        this.n.setRightText(this.a.d(i()));
        e(2);
      }
    }
  }
  
  private void b(int paramInt)
  {
    int i1 = 1;
    Object localObject;
    String[] arrayOfString;
    if (paramInt == 1)
    {
      localObject = this.a.k();
      this.D = localObject[0];
      if (this.D.equals("0"))
      {
        arrayOfString = this.a.j();
        this.D = arrayOfString[0];
        localObject = arrayOfString;
        if (this.D.equals("0"))
        {
          this.D = "1";
          localObject = arrayOfString;
        }
      }
    }
    else if (paramInt == 2)
    {
      arrayOfString = this.a.l();
      this.D = arrayOfString[0];
      localObject = arrayOfString;
      if (this.D.equals("0"))
      {
        this.D = "1";
        localObject = arrayOfString;
      }
    }
    else
    {
      localObject = null;
    }
    this.J = new String[] { "0", "0", "0" };
    if (localObject != null)
    {
      int i2 = localObject.length;
      while (i1 < i2)
      {
        this.J[(i1 - 1)] = localObject[i1];
        i1 += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initLocationCode|type : ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", mLocationCountyCode : ");
      ((StringBuilder)localObject).append(this.D);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private int c(int paramInt)
  {
    if (paramInt == 0) {
      return paramInt;
    }
    if (paramInt > 0) {
      return paramInt + 17;
    }
    return 0;
  }
  
  private int d(int paramInt)
  {
    int i1 = 0;
    if ((paramInt >= 0) && (paramInt <= 17)) {
      return 0;
    }
    if (paramInt > 17) {
      i1 = paramInt - 17;
    }
    return i1;
  }
  
  private void d()
  {
    this.A = getIntent().getBooleanExtra("key_first_req_location", false);
    this.a = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    ThreadManager.getSubThreadHandler().post(new ConditionSearchFriendActivity.1(this));
    this.f = this.a.g();
    this.g = this.a.f();
    if ((this.g == ConditionSearchManager.p[0]) || (this.g == ConditionSearchManager.p[1]))
    {
      this.g = 0;
      this.a.b(this.g);
    }
    this.j = ((EditText)findViewById(2131432626));
    this.j.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
    Object localObject1 = getResources().getDrawable(2130852492);
    ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    this.j.setCompoundDrawables((Drawable)localObject1, null, null, null);
    this.j.addTextChangedListener(new ConditionSearchFriendActivity.2(this));
    this.l = ((FormSimpleItem)findViewById(2131431193));
    this.m = ((FormSimpleItem)findViewById(2131431196));
    this.n = ((FormSimpleItem)findViewById(2131431194));
    this.o = ((FormSimpleItem)findViewById(2131431195));
    this.p = ((FormSimpleItem)findViewById(2131431197));
    this.q = ((Button)findViewById(2131431375));
    this.v = findViewById(2131434147);
    this.w = findViewById(2131434149);
    this.x = findViewById(2131434145);
    this.r = ((TextView)findViewById(2131433096));
    this.s = ((TextView)findViewById(2131437929));
    this.t = ((TextView)findViewById(2131429615));
    e();
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.l.setLeftIcon(null);
    this.l.setLeftText(getResources().getString(2131887996));
    localObject1 = this.a.b(this.d, this.e);
    this.l.setRightText((CharSequence)localObject1);
    Object localObject3;
    if (AppSetting.e)
    {
      localObject2 = this.l;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131900552));
      ((StringBuilder)localObject3).append((String)localObject1);
      ((FormSimpleItem)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
    }
    this.l.setOnClickListener(this);
    this.o.setVisibility(0);
    this.o.setLeftIcon(null);
    this.o.setLeftText(getResources().getString(2131887999));
    this.o.setRightText(ConditionSearchManager.l[this.g]);
    if (AppSetting.e)
    {
      localObject1 = this.o;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131900543));
      ((StringBuilder)localObject2).append(ConditionSearchManager.l[this.g]);
      ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    }
    this.o.setOnClickListener(this);
    this.m.setLeftIcon(null);
    this.m.setLeftText(getResources().getString(2131888000));
    localObject1 = this.a.e(0);
    this.m.setRightText(this.a.d((String)localObject1));
    if (AppSetting.e)
    {
      localObject2 = this.m;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131900535));
      ((StringBuilder)localObject3).append((String)localObject1);
      ((FormSimpleItem)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
    }
    this.m.setOnClickListener(this);
    this.n.setLeftIcon(null);
    this.n.setLeftText(getResources().getString(2131887998));
    Object localObject2 = this.a.e(1);
    this.n.setRightText(this.a.d((String)localObject2));
    if (AppSetting.e)
    {
      localObject3 = this.n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131900549));
      localStringBuilder.append((String)localObject2);
      ((FormSimpleItem)localObject3).setContentDescription(localStringBuilder.toString());
    }
    this.n.setOnClickListener(this);
    this.p.setLeftIcon(null);
    this.p.setLeftText(getResources().getString(2131888002));
    this.p.setRightText(ConditionSearchManager.k[this.f]);
    if (AppSetting.e)
    {
      localObject2 = this.p;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131900538));
      ((StringBuilder)localObject3).append(ConditionSearchManager.k[this.f]);
      ((FormSimpleItem)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
    }
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    if (AppSetting.e) {
      this.q.setContentDescription(getString(2131888075));
    }
    SimpleModeHelper.a(this.q);
    h();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("init|mIsFirstReqLocation : ");
      ((StringBuilder)localObject2).append(this.A);
      ((StringBuilder)localObject2).append(", locDesc : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if ((this.A) || ("不限".equals(localObject1))) {
      addObserver(this.V);
    }
  }
  
  private void e()
  {
    boolean bool = ThemeImageWrapper.isNightMode();
    int i1;
    if (bool) {
      i1 = 2130839622;
    } else {
      i1 = 2130851704;
    }
    this.v.setBackgroundResource(i1);
    this.w.setBackgroundResource(i1);
    this.x.setBackgroundResource(i1);
    if (bool) {
      i1 = 2131168119;
    } else {
      i1 = 2131167999;
    }
    this.r.setTextColor(getResources().getColor(i1));
    this.s.setTextColor(getResources().getColor(i1));
    this.t.setTextColor(getResources().getColor(i1));
  }
  
  private void e(int paramInt)
  {
    this.P = paramInt;
    this.N = ActionSheet.createMenuSheet(this);
    Object localObject = (DispatchActionMoveScrollView)this.N.findViewById(2131427560);
    ((DispatchActionMoveScrollView)localObject).getChildAt(0).setOnClickListener(null);
    ((DispatchActionMoveScrollView)localObject).a = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.O = ((IphonePickerView)getLayoutInflater().inflate(2131627482, null));
    this.O.a(this.K);
    this.O.setBackgroundColor(-1118221);
    int i2 = -1;
    int i1;
    if (paramInt == 0)
    {
      paramInt = d(this.d);
      i1 = d(this.e);
      this.O.setSelection(0, paramInt);
      this.O.setSelection(1, i1);
      this.l.setRightTextColor(1);
      paramInt = a(this.l);
      i1 = this.l.getHeight();
    }
    else if (paramInt == 3)
    {
      this.O.setSelection(0, this.f);
      this.p.setRightTextColor(1);
      paramInt = a(this.p);
      i1 = this.p.getHeight();
    }
    else
    {
      i1 = 0;
      while (i1 < this.G)
      {
        this.O.setSelection(i1, this.I[i1]);
        i1 += 1;
      }
      this.u = ((TextView)this.O.findViewById(2131445520));
      this.u.setVisibility(0);
      localObject = this.E;
      if (localObject != null) {
        localObject = ((BaseAddress)localObject).name;
      } else {
        localObject = "中国";
      }
      this.u.setText((CharSequence)localObject);
      this.u.setOnClickListener(this);
      if (AppSetting.e)
      {
        TextView localTextView = this.u;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131900548));
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(HardCodeUtil.a(2131900545));
        localTextView.setContentDescription(localStringBuilder.toString());
      }
      if (paramInt == 1)
      {
        this.m.setRightTextColor(1);
        paramInt = a(this.m);
        i1 = this.m.getHeight();
      }
      else if (paramInt == 2)
      {
        this.n.setRightTextColor(1);
        paramInt = a(this.n);
        i1 = this.n.getHeight();
      }
      else
      {
        i1 = -1;
        paramInt = i2;
      }
    }
    this.O.setPickListener(this.L);
    if (Build.VERSION.SDK_INT >= 11) {
      this.N.getWindow().setFlags(16777216, 16777216);
    }
    this.N.setActionContentView(this.O, null);
    this.N.setOnDismissListener(this.M);
    try
    {
      this.N.show();
      this.O.post(new ConditionSearchFriendActivity.6(this, paramInt, i1));
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, localThrowable.getMessage());
      }
    }
  }
  
  private void f()
  {
    this.I = null;
    this.H = null;
    this.F = null;
    this.G = 0;
    this.J = new String[] { "0", "0", "0" };
  }
  
  private void g()
  {
    this.E = this.a.a(this.D);
    Object localObject1 = this.E;
    Object localObject2;
    if (localObject1 != null)
    {
      this.G = ((BaseAddress)localObject1).getColumnNember();
      int i1 = this.G;
      this.F = new Object[i1];
      this.H = new BaseAddress[i1];
      this.I = new int[i1];
      if (i1 == 0) {
        return;
      }
      localObject1 = this.E;
      int i3 = this.J.length;
      i1 = 0;
      int i2 = 0;
      while (i1 < i3)
      {
        if (!"0".equals(this.J[i1]))
        {
          localObject2 = this.F;
          if (i2 >= localObject2.length) {
            break;
          }
          localObject2[i2] = ((BaseAddress)localObject1).getDataList();
          BaseAddress[] arrayOfBaseAddress = this.H;
          localObject2 = (BaseAddress)((BaseAddress)localObject1).dataMap.get(this.J[i1]);
          arrayOfBaseAddress[i2] = localObject2;
          this.I[i2] = a((ArrayList)this.F[i2], this.J[i1]);
          i2 += 1;
          localObject1 = localObject2;
          if (localObject2 == null) {
            return;
          }
        }
        i1 += 1;
      }
      if (i2 < this.G)
      {
        this.F[i2] = ((BaseAddress)localObject1).getDataList();
        this.H[i2] = ((BaseAddress)((BaseAddress)localObject1).dataMap.get(Integer.valueOf(0)));
        this.I[i2] = 0;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initLocationData|mLocationColumCount : ");
      ((StringBuilder)localObject2).append(this.G);
      ((StringBuilder)localObject2).append(", mLocationCountry.name : ");
      localObject1 = this.E;
      if (localObject1 == null) {
        localObject1 = "null";
      } else {
        localObject1 = ((BaseAddress)localObject1).name;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void h()
  {
    if (this.c == 0)
    {
      this.x.setSelected(true);
      this.v.setSelected(false);
      this.w.setSelected(false);
    }
    else if (this.c == 1)
    {
      this.x.setSelected(false);
      this.v.setSelected(false);
      this.w.setSelected(true);
    }
    else if (this.c == 2)
    {
      this.x.setSelected(false);
      this.v.setSelected(true);
      this.w.setSelected(false);
    }
    if (AppSetting.e)
    {
      this.x.setContentDescription(HardCodeUtil.a(2131900550));
      this.w.setContentDescription(HardCodeUtil.a(2131900542));
      this.v.setContentDescription(HardCodeUtil.a(2131900547));
    }
  }
  
  private String i()
  {
    Object localObject1 = new StringBuilder();
    if (!"0".equals(this.D))
    {
      Object localObject2 = this.E;
      if (localObject2 != null)
      {
        ((StringBuilder)localObject1).append(((BaseAddress)localObject2).name);
        ((StringBuilder)localObject1).append("-");
        int i1 = 0;
        while (i1 < this.G)
        {
          localObject2 = this.H;
          if ((localObject2 != null) && (localObject2[i1] != null) && (!"0".equals(localObject2[i1].code)))
          {
            ((StringBuilder)localObject1).append(this.H[i1].name);
            ((StringBuilder)localObject1).append("-");
          }
          i1 += 1;
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return "不限";
    }
    return ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
  }
  
  void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dismissWaittingDialog | type = ");
      ((StringBuilder)localObject).append(this.R);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.R;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing()))
    {
      this.S = 0;
      this.R.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog dismiss");
      }
    }
  }
  
  void a(int paramInt)
  {
    int i1 = this.a.d();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSelectAddress|checkUpdate result = ");
      localStringBuilder.append(i1);
      QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 != 0)
    {
      i1 = this.a.a(i1, true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startSelectAddress|update updateResult = ");
        localStringBuilder.append(i1);
        QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
      }
      if (i1 == 2)
      {
        QQToast.makeText(this, 2131892104, 0).show(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131888006));
        this.a.c(this.U);
        return;
      }
      a(paramInt, getString(2131888006));
      this.Q.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSelectAddress|type : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", mNeedInitLocation");
      localStringBuilder.append(this.C);
      localStringBuilder.append(", mNeedInitHome : ");
      localStringBuilder.append(this.B);
      localStringBuilder.append(", mLocationColumCount : ");
      localStringBuilder.append(this.G);
      localStringBuilder.append(", mLocationCountyCode : ");
      localStringBuilder.append(this.D);
      QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
    }
    if (paramInt == 1)
    {
      if (this.C)
      {
        b(1);
        g();
        this.C = false;
        this.B = true;
        bool1 = true;
      }
      a(paramInt, bool1);
      return;
    }
    if (paramInt == 2)
    {
      bool1 = bool2;
      if (this.B)
      {
        b(2);
        g();
        this.B = false;
        this.C = true;
        bool1 = true;
      }
      a(paramInt, bool1);
    }
  }
  
  void a(int paramInt, String paramString)
  {
    this.S = paramInt;
    if (this.R == null) {
      this.R = new QQProgressDialog(this, getTitleBarHeight());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showWaitingDialog | type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", str = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", dlg=");
      localStringBuilder.append(this.R);
      QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
    }
    this.R.a(paramString);
    this.R.show();
  }
  
  void b()
  {
    if (this.k)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004241", "0X8004241", 0, 0, "", "", "", "");
      this.k = false;
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnActivityResult | requestCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramIntent == null) {
      return;
    }
    if (paramInt2 == -1) {
      if (paramInt1 == 1002)
      {
        this.g = paramIntent.getIntExtra("param_id", 0);
        this.o.setRightText(ConditionSearchManager.l[this.g]);
        this.a.b(this.g);
        if (AppSetting.e)
        {
          paramIntent = this.o;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131900537));
          ((StringBuilder)localObject).append(ConditionSearchManager.l[this.g]);
          paramIntent.setContentDescription(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        paramIntent = paramIntent.getStringExtra("key_country_code");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doOnActivityResult | codes = ");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
        }
        if ((!TextUtils.isEmpty(paramIntent)) && (!paramIntent.equals(this.D)))
        {
          this.D = paramIntent;
          this.E = this.a.a(this.D);
          paramIntent = this.E;
          if (paramIntent != null)
          {
            paramInt2 = paramIntent.getColumnNember();
            if ((paramInt2 > 0) && (paramInt2 <= 3))
            {
              f();
              g();
              paramIntent = this.N;
              if ((paramIntent != null) && (paramIntent.isShowing()))
              {
                if (this.O == null) {
                  this.O = ((IphonePickerView)getLayoutInflater().inflate(2131627482, null));
                }
                this.O.a(this.K);
                paramInt2 = 0;
              }
              while (paramInt2 < this.G)
              {
                this.O.a(paramInt2);
                this.O.setSelection(paramInt2, 0);
                paramInt2 += 1;
                continue;
                if (paramInt1 == 1003) {
                  e(1);
                } else if (paramInt1 == 1004) {
                  e(2);
                }
              }
              paramIntent = this.u;
              if (paramIntent != null)
              {
                paramIntent.setText(this.E.name);
                if (AppSetting.e)
                {
                  paramIntent = this.u;
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(HardCodeUtil.a(2131900536));
                  ((StringBuilder)localObject).append(this.E.name);
                  ((StringBuilder)localObject).append(HardCodeUtil.a(2131900539));
                  paramIntent.setContentDescription(((StringBuilder)localObject).toString());
                }
              }
            }
            else
            {
              f();
              g();
              paramIntent = this.N;
              if ((paramIntent != null) && (paramIntent.isShowing()))
              {
                this.N.dismiss();
              }
              else
              {
                paramIntent = new String[4];
                paramIntent[0] = this.D;
                localObject = this.J;
                paramIntent[1] = localObject[0];
                paramIntent[2] = localObject[1];
                paramIntent[3] = localObject[2];
                localObject = i();
                if (paramInt1 == 1003)
                {
                  this.a.a(0, (String)localObject);
                  this.a.b(paramIntent);
                }
                else if (paramInt1 == 1004)
                {
                  this.a.a(1, (String)localObject);
                  this.a.c(paramIntent);
                }
              }
            }
            if (paramInt1 == 1003)
            {
              this.m.setRightText(this.E.name);
              if (AppSetting.e)
              {
                paramIntent = this.m;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131900532));
                ((StringBuilder)localObject).append(this.E.name);
                paramIntent.setContentDescription(((StringBuilder)localObject).toString());
              }
            }
            else if (paramInt1 == 1004)
            {
              this.n.setRightText(this.E.name);
              if (AppSetting.e)
              {
                paramIntent = this.n;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131900551));
                ((StringBuilder)localObject).append(this.E.name);
                paramIntent.setContentDescription(((StringBuilder)localObject).toString());
              }
            }
          }
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131627354);
    this.y = findViewById(2131445137);
    this.z = findViewById(2131435763);
    setContentBackgroundResource(2130838958);
    this.a = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    setTitle(2131887989);
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    b();
    super.doOnDestroy();
    this.Q.removeCallbacksAndMessages(null);
    this.a.b(this);
    this.a.d(this.U);
    this.a.d(this.T);
    removeObserver(this.V);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ConditionSearchManager localConditionSearchManager = this.a;
    if (localConditionSearchManager != null) {
      localConditionSearchManager.a(this);
    }
  }
  
  public void onClick(View paramView)
  {
    b();
    int i1 = paramView.getId();
    Object localObject1;
    switch (i1)
    {
    default: 
      Object localObject2;
      switch (i1)
      {
      default: 
        break;
      case 2131445520: 
        localObject1 = new Intent(this, CountrySelectActivity.class);
        ((Intent)localObject1).putExtra("key_country_code", this.D);
        ((Intent)localObject1).putExtra("key_no_limit_allow", true);
        i1 = this.P;
        if (i1 == 1) {
          startActivityForResult((Intent)localObject1, 1003);
        } else if (i1 == 2) {
          startActivityForResult((Intent)localObject1, 1004);
        }
        break;
      case 2131434149: 
        this.c = 1;
        h();
        this.a.d(this.c);
        localObject1 = this.app;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
        break;
      case 2131434147: 
        this.c = 2;
        h();
        this.a.d(this.c);
        localObject1 = this.app;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
        break;
      case 2131434145: 
        this.c = 0;
        h();
        this.a.d(this.c);
        localObject1 = this.app;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
        break;
      case 2131431375: 
        ReportController.b(this.app, "CliOper", "", "", "0X800424B", "0X800424B", 0, 0, "", "", "", "");
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.makeText(this, 2131892104, 0).show(getTitleBarHeight());
        }
        else
        {
          this.b = this.j.getText().toString();
          localObject1 = this.a.k();
          localObject2 = this.a.l();
          this.a.c(this.T);
          this.a.a(true, this.b, this.c, this.d, this.e, (String[])localObject1, (String[])localObject2, this.g, this.f, 1);
          a(3, getString(2131888007));
        }
        break;
      }
      break;
    case 2131431197: 
      e(3);
      break;
    case 2131431196: 
      this.A = false;
      this.a.a();
      ReportController.b(this.app, "CliOper", "", "", "0X8004244", "0X8004244", 0, 0, "", "", "", "");
      a(1);
      break;
    case 2131431195: 
      localObject1 = new Intent(this, JobSelectionActivity.class);
      ((Intent)localObject1).putExtra("param_id", this.g);
      ((Intent)localObject1).putExtra("param_from_consearch", true);
      ((Intent)localObject1).putExtra("param_need_no_limit", true);
      startActivityForResult((Intent)localObject1, 1002);
      break;
    case 2131431194: 
      ReportController.b(this.app, "CliOper", "", "", "0X8004245", "0X8004245", 0, 0, "", "", "", "");
      a(2);
      break;
    case 2131431193: 
      e(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity
 * JD-Core Version:    0.7.0.1
 */