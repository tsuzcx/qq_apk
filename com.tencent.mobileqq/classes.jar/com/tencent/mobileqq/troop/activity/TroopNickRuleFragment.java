package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.widget.PresetWordFlowLayout;
import com.tencent.mobileqq.util.ColorUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopNickRuleFragment
  extends IphoneTitleBarFragment
{
  public static String a = "PARAM_UIN";
  public static String b = "PARAM_INTRO";
  public static String c = "PARAM_PRESET_WORDS";
  public static String d = "";
  public static String e = "close";
  public static String f = "add";
  public static String g = "none";
  public static int h = 15;
  public static int i = 10;
  public static int j = 600;
  protected PresetWordFlowLayout k;
  protected PresetWordsListAdapter l;
  protected ArrayList<String> m = new ArrayList();
  protected QQAppInterface n;
  protected BaseActivity o;
  protected EditText p;
  protected TextView q;
  private String r = "";
  private String s = "";
  private View t = null;
  private EditText u = null;
  private boolean v = false;
  private View.OnTouchListener w = new TroopNickRuleFragment.1(this);
  private TroopManagerBizObserver x = new TroopNickRuleFragment.2(this);
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.p;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ViewCompat.setImportantForAccessibility((View)localObject, i1);
    int i1 = 0;
    while (i1 < this.k.getChildCount())
    {
      localObject = (PresetWordsListAdapter.ViewHolder)this.k.getChildAt(i1).getTag();
      if (localObject != null)
      {
        int i2;
        if (((PresetWordsListAdapter.ViewHolder)localObject).c != null)
        {
          TextView localTextView = ((PresetWordsListAdapter.ViewHolder)localObject).c;
          if (paramBoolean) {
            i2 = 1;
          } else {
            i2 = 2;
          }
          ViewCompat.setImportantForAccessibility(localTextView, i2);
        }
        if (((PresetWordsListAdapter.ViewHolder)localObject).b != null)
        {
          localObject = ((PresetWordsListAdapter.ViewHolder)localObject).b;
          if (paramBoolean) {
            i2 = 1;
          } else {
            i2 = 2;
          }
          ViewCompat.setImportantForAccessibility((View)localObject, i2);
        }
      }
      i1 += 1;
    }
  }
  
  private void b(EditText paramEditText)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getBaseActivity().getSystemService("input_method");
    if (localInputMethodManager.isActive())
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopNickRuleFragment", 2, String.format("hideInputMethod()", new Object[0]));
      }
      localInputMethodManager.hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
    }
  }
  
  private void d()
  {
    setTitle(getString(2131917621));
    this.k = ((PresetWordFlowLayout)getBaseActivity().findViewById(2131448059));
    this.k.c = ViewUtils.dpToPx(12.0F);
    this.k.e = ViewUtils.dpToPx(12.0F);
    this.l = new PresetWordsListAdapter();
    boolean bool = ThemeUtil.isInNightMode(this.n);
    if (bool) {
      this.l.c();
    }
    this.l.c = new TroopNickRuleFragment.3(this);
    this.k.setAdapter(this.l);
    this.q = ((TextView)this.o.findViewById(2131448056));
    this.p = ((EditText)this.o.findViewById(2131448055));
    this.p.setOnTouchListener(new TroopNickRuleFragment.4(this));
    this.p.addTextChangedListener(new TroopNickRuleFragment.5(this));
    if (bool)
    {
      this.p.setBackgroundColor(ColorUtils.a("#282828"));
      this.p.setTextColor(-1);
    }
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(getString(2131917619));
    this.rightViewText.setOnClickListener(new TroopNickRuleFragment.6(this));
    ViewCompat.setImportantForAccessibility(this.mContentView, 2);
  }
  
  private void e()
  {
    this.n.addObserver(this.x);
    Intent localIntent = this.o.getIntent();
    if (localIntent != null)
    {
      Object localObject = localIntent.getStringExtra(a);
      String str = "";
      if (localObject != null) {
        localObject = localIntent.getStringExtra(a);
      } else {
        localObject = "";
      }
      this.r = ((String)localObject);
      if (localIntent.getStringExtra(b) != null) {
        localObject = localIntent.getStringExtra(b);
      } else {
        localObject = "";
      }
      this.s = ((String)localObject);
      if (!TextUtils.isEmpty(this.s)) {
        this.p.setText(this.s);
      }
      localObject = this.p;
      ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
      this.p.requestFocus();
      if (localIntent.getStringArrayListExtra(c) != null) {
        this.m = localIntent.getStringArrayListExtra(c);
      }
      localObject = str;
      if (localIntent.getStringExtra(d) != null) {
        localObject = localIntent.getStringExtra(d);
      }
      ReportController.b(this.n, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_exp", 0, 0, String.valueOf(this.r), (String)localObject, "", "");
    }
    f();
  }
  
  private void f()
  {
    this.l.a();
    int i2 = this.m.size();
    int i3 = h;
    int i1 = 0;
    if (i2 < i3)
    {
      this.l.a(getString(2131917614));
      this.l.b = true;
    }
    else
    {
      this.l.b = false;
    }
    Object localObject = this.m.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.l.a(str);
    }
    localObject = this.k;
    if (this.l.getCount() == 0) {
      i1 = 8;
    }
    ((PresetWordFlowLayout)localObject).setVisibility(i1);
    this.l.notifyDataSetChanged();
  }
  
  private void g()
  {
    if (!NetworkUtil.isNetSupport(this.o))
    {
      ReportController.b(this.n, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_failure", 0, 0, String.valueOf(this.r), "1", "", "");
      QQToast.makeText(this.o, 1, 2131892104, 0).show();
      return;
    }
    ITroopManagerBizHandler localITroopManagerBizHandler = (ITroopManagerBizHandler)this.n.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
    if (localITroopManagerBizHandler != null)
    {
      this.s = this.p.getText().toString();
      localITroopManagerBizHandler.a(this.r, this.s, this.m);
    }
  }
  
  void a()
  {
    View localView = this.t;
    if (localView != null)
    {
      localView = localView.findViewById(2131447845);
      this.u = ((EditText)this.t.findViewById(2131440600));
      InputFilter.LengthFilter localLengthFilter = new InputFilter.LengthFilter(i);
      TroopNickRuleFragment.7 local7 = new TroopNickRuleFragment.7(this);
      this.u.setFilters(new InputFilter[] { localLengthFilter, local7 });
      this.u.addTextChangedListener(new TroopNickRuleFragment.8(this));
      if (ThemeUtil.isInNightMode(this.n))
      {
        this.u.setTextColor(-1);
        localView.setBackgroundDrawable(getResources().getDrawable(2130847891));
      }
      this.u.setOnEditorActionListener(new TroopNickRuleFragment.9(this));
    }
  }
  
  void a(float paramFloat1, float paramFloat2)
  {
    this.v = false;
    Object localObject = this.u;
    if (localObject != null)
    {
      if (b((View)localObject).contains(paramFloat1, paramFloat2)) {
        return;
      }
      b(this.u);
      localObject = this.u.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.m.add(0, localObject);
        f();
      }
      this.u.setText("");
    }
    b();
    a(true);
  }
  
  void a(int paramInt)
  {
    int i1 = paramInt;
    if (this.l.b()) {
      i1 = paramInt - 1;
    }
    if ((i1 >= 0) && (this.m.size() > i1))
    {
      this.m.remove(i1);
      f();
    }
  }
  
  void a(View paramView)
  {
    if (this.t != null)
    {
      paramView = b(paramView);
      View localView = this.t.findViewById(2131447845);
      if (localView != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(localView.getLayoutParams());
        localLayoutParams.topMargin = ((int)paramView.top);
        localLayoutParams.leftMargin = ((int)paramView.left);
        localView.setLayoutParams(localLayoutParams);
        this.t.invalidate();
      }
    }
  }
  
  void a(EditText paramEditText)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.o.getSystemService("input_method");
    if (QLog.isColorLevel()) {
      QLog.i("TroopNickRuleFragment", 2, String.format("showInputMethod()", new Object[0]));
    }
    localInputMethodManager.showSoftInput(paramEditText, 2);
  }
  
  void a(PresetWordsListAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return;
    }
    if (paramViewHolder.b == null) {
      return;
    }
    if (paramViewHolder.b.getParent() != null)
    {
      if (this.t == null)
      {
        this.t = LayoutInflater.from(this.o).inflate(2131625963, null, false);
        a();
      }
      View localView = this.o.getWindow().getDecorView();
      if ((localView instanceof ViewGroup))
      {
        if (this.t.getParent() != null) {
          ((ViewGroup)this.t.getParent()).removeView(this.t);
        }
        ((ViewGroup)localView).addView(this.t);
        this.t.setOnTouchListener(this.w);
      }
      a((View)paramViewHolder.b.getParent());
      paramViewHolder = this.u;
      if (paramViewHolder != null)
      {
        paramViewHolder.setHint(2131917614);
        this.u.requestFocus();
        a(this.u);
      }
      this.v = true;
      a(false);
    }
  }
  
  RectF b(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i1 = ImmersiveUtils.getStatusBarHeight(this.o);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i1 = 0;
    }
    if (i1 > 0) {
      arrayOfInt[1] -= i1;
    }
    RectF localRectF = new RectF();
    localRectF.left = arrayOfInt[0];
    localRectF.top = arrayOfInt[1];
    localRectF.right = (localRectF.left + paramView.getMeasuredWidth());
    localRectF.bottom = (localRectF.top + paramView.getMeasuredHeight());
    return localRectF;
  }
  
  void b()
  {
    View localView = this.t;
    if (localView != null)
    {
      if ((localView.getParent() != null) && ((this.t.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.t.getParent()).removeView(this.t);
      }
      this.t.setOnTouchListener(null);
    }
  }
  
  void c()
  {
    boolean bool = TextUtils.isEmpty(this.s);
    Object localObject = this.m;
    int i1;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (bool)
    {
      if (i1 != 0) {
        localObject = "4";
      } else {
        localObject = "2";
      }
    }
    else if (i1 != 0) {
      localObject = "1";
    } else {
      localObject = "3";
    }
    ReportController.b(this.n, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_success", 0, 0, String.valueOf(this.r), (String)localObject, "", "");
    localObject = (TroopManager)this.n.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      TroopInfo localTroopInfo = ((TroopManager)localObject).f(this.r);
      if (localTroopInfo != null)
      {
        localTroopInfo.setGroupCardPrefix(this.m);
        localTroopInfo.groupCardPrefixIntro = this.s;
        ((TroopManager)localObject).b(localTroopInfo);
      }
    }
    localObject = new Intent();
    ((Intent)localObject).putStringArrayListExtra(c, this.m);
    ((Intent)localObject).putExtra(b, this.s);
    ((Intent)localObject).putExtra(a, this.r);
    this.o.setResult(-1, (Intent)localObject);
    this.o.finish();
  }
  
  protected int getContentLayoutId()
  {
    return 2131625962;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
    this.n.removeObserver(this.x);
    b(this.p);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.o = getBaseActivity();
    this.n = this.o.app;
    d();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment
 * JD-Core Version:    0.7.0.1
 */