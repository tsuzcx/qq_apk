package com.tencent.mobileqq.troop.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class TroopRemarkEditFragment
  extends IphoneTitleBarFragment
{
  public static String a = "param_troopuin";
  public static String b = "param_troopcode";
  public static String c = "param_troopname";
  public static String d = "param_old_troopremark";
  public static int e = 60;
  private ClearableEditText f;
  private IFaceDecoder g;
  private Button h;
  private Button i;
  private QQAppInterface j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private final View.OnClickListener p = new TroopRemarkEditFragment.1(this);
  private final View.OnClickListener q = new TroopRemarkEditFragment.2(this);
  private final TroopSettingObserver r = new TroopRemarkEditFragment.3(this);
  
  private void a(Intent paramIntent)
  {
    this.j = getBaseActivity().app;
    this.k = paramIntent.getStringExtra(a);
    this.l = paramIntent.getStringExtra(c);
    this.n = paramIntent.getStringExtra(d);
    this.m = paramIntent.getStringExtra(b);
    this.g = ((IQQAvatarService)this.j.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.j);
    this.f = ((ClearableEditText)a(2131448087));
    this.h = ((Button)a(2131442529));
    this.i = ((Button)a(2131442530));
  }
  
  private void b()
  {
    Button localButton = this.h;
    if (localButton != null) {
      localButton.setOnClickListener(this.p);
    }
    localButton = this.i;
    if (localButton != null) {
      localButton.setOnClickListener(this.q);
    }
  }
  
  private void b(EditText paramEditText)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    if (localInputMethodManager.isActive())
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopRemarkEditFragment", 2, "hideInputMethod()");
      }
      localInputMethodManager.hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
    }
  }
  
  private void c()
  {
    this.f.setInputType(131072);
    this.f.setCanMultiLine(true);
    this.f.setClearButtonStyle(1);
    this.f.setSingleLine(false);
    TroopRemarkEditFragment.5 local5 = new TroopRemarkEditFragment.5(this);
    this.f.setFilters(new InputFilter[] { local5 });
    if (!TextUtils.isEmpty(this.n))
    {
      this.f.setText(this.n);
      this.f.setSelection(this.n.length());
    }
    this.f.addTextChangedListener(new TroopRemarkEditFragment.6(this));
  }
  
  private void d()
  {
    hideTitleBar();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      i1 = 2131167990;
    } else {
      i1 = 2131167993;
    }
    int i1 = getResources().getColor(i1);
    Drawable localDrawable = getResources().getDrawable(2130853297);
    localDrawable.setColorFilter(i1, PorterDuff.Mode.SRC_ATOP);
    TextView localTextView = (TextView)a(2131436180);
    localTextView.setTextColor(i1);
    localTextView.setBackgroundDrawable(localDrawable);
    localTextView.setContentDescription(getString(2131895481));
    localTextView.setOnClickListener(new TroopRemarkEditFragment.7(this));
  }
  
  private void e()
  {
    if ((ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null) ^ true)) {
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }
  }
  
  private Drawable f()
  {
    Bitmap localBitmap2 = this.g.getBitmapFromCache(4, this.k);
    if ((localBitmap2 == null) && (!this.g.isPausing())) {
      this.g.requestDecodeFace(this.k, 4, true);
    }
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = ImageUtil.k();
    }
    return new BitmapDrawable(localBitmap1);
  }
  
  protected final <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  protected void a()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.titleRoot.setFitsSystemWindows(false);
      this.titleRoot.setPadding(0, 0, 0, 0);
    }
    d();
    c();
    Object localObject = (ImageView)a(2131448088);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(f());
    }
    localObject = (TextView)a(2131442528);
    if (localObject != null) {
      ((TextView)localObject).setText(String.format("%s %s ", new Object[] { getString(2131897546), this.l }));
    }
  }
  
  void a(EditText paramEditText)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    try
    {
      localInputMethodManager.showSoftInput(paramEditText, 0);
      return;
    }
    catch (Exception paramEditText)
    {
      label21:
      break label21;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopRemarkEditFragment", 2, "showInputMethod error");
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getActivity() != null)
    {
      if (getBaseActivity().app == null) {
        return;
      }
      a(getActivity().getIntent());
      a();
      b();
      paramLayoutInflater = this.r;
      if (paramLayoutInflater != null) {
        this.j.addObserver(paramLayoutInflater);
      }
      ReportController.b(this.j, "dc00899", "Grp_set_new", "", "groupnameRemarks", "exp", 0, 0, this.k, "", "", "");
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131629605;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(this.f);
    this.j.removeObserver(this.r);
    IFaceDecoder localIFaceDecoder = this.g;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    e();
    ClearableEditText localClearableEditText = this.f;
    if (localClearableEditText != null) {
      localClearableEditText.postDelayed(new TroopRemarkEditFragment.4(this), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment
 * JD-Core Version:    0.7.0.1
 */