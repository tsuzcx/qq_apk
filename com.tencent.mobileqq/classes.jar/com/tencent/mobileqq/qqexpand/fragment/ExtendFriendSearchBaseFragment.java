package com.tencent.mobileqq.qqexpand.fragment;

import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.TagUtils;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;

public abstract class ExtendFriendSearchBaseFragment
  extends PublicBaseFragment
  implements Handler.Callback, TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, SoftKeyboardStateHelper.SoftKeyboardStateListener, BounceScrollView.OnScrollChangedListener
{
  protected BaseActivity a;
  protected QQAppInterface b;
  private SystemBarCompact c;
  private QuickPinyinEditText d;
  private ImageView e;
  private TextView f;
  private FrameLayout g;
  private BounceScrollView h;
  private ViewGroup i;
  private ExtendFriendMultiLinesTagsView j;
  private TextView k;
  private ViewGroup l;
  private ExtendFriendMultiLinesTagsView m;
  private View n;
  private int o = -1;
  private boolean p = true;
  private WeakReferenceHandler q;
  private SoftKeyboardStateHelper r;
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, String.format("switchToMode oldMode=%s newMode=%s", new Object[] { Integer.valueOf(this.o), Integer.valueOf(paramInt) }));
    }
    if (this.o != paramInt)
    {
      this.o = paramInt;
      if (this.o == 1)
      {
        this.h.setVisibility(8);
        this.g.setVisibility(0);
        a(false, 50L);
        return;
      }
      this.d.requestFocus();
      this.d.setText("");
      this.h.setVisibility(0);
      this.g.setVisibility(8);
      a(true, 50L);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.d.setFocusable(paramBoolean);
    this.d.setFocusableInTouchMode(paramBoolean);
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, String.format("toggleInputMethod open=%s delay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) }));
    }
    this.q.removeMessages(12);
    this.q.removeMessages(11);
    if (paramBoolean)
    {
      if (!this.q.hasMessages(11)) {
        this.q.sendEmptyMessageDelayed(11, paramLong);
      }
    }
    else if (!this.q.hasMessages(12)) {
      this.q.sendEmptyMessageDelayed(12, paramLong);
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, "showInputMethod");
    }
    this.d.clearFocus();
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(this.d, 0);
  }
  
  private void b(int paramInt)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.c == null))
    {
      this.c = new SystemBarCompact(getBaseActivity(), false, getResources().getColor(paramInt));
      this.c.init();
      if (Build.VERSION.SDK_INT >= 19) {
        this.a.getWindow().addFlags(67108864);
      }
      d();
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, "hideInputMethod");
    }
    this.d.clearFocus();
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
  }
  
  private void c(String paramString)
  {
    a(1);
    a(paramString);
  }
  
  private void d()
  {
    try
    {
      if ((this.c != null) && (ThemeUtil.isInNightMode(this.a.app)))
      {
        int i1 = getResources().getColor(2131167812);
        this.c.setStatusBarMask(new PorterDuffColorFilter(i1, PorterDuff.Mode.SRC_ATOP));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendSearchBaseFragment", 1, "showStatusBarMask fail.", localException);
    }
  }
  
  abstract void a();
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(false, 50L);
  }
  
  abstract void a(ViewGroup paramViewGroup);
  
  abstract void a(String paramString);
  
  public void a(ArrayList<String> paramArrayList)
  {
    int i2 = 0;
    int i1;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    this.j.setSearchTags(paramArrayList);
    paramArrayList = this.i;
    if (i1 != 0) {
      i2 = 8;
    }
    paramArrayList.setVisibility(i2);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.d.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.e.setVisibility(8);
    } else {
      this.e.setVisibility(0);
    }
    if ((this.o == 1) && (TextUtils.isEmpty(paramEditable))) {
      a(0);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      float f3 = ((QuickPinyinEditText)localObject).getWidth() - this.d.getPaddingLeft() - this.d.getPaddingRight();
      float f4 = this.d.getTextSize();
      float f2 = 18.0F;
      float f1 = f2;
      if (f4 > 1.0F)
      {
        f1 = f2;
        if (f3 > 1.0F) {
          f1 = f3 / f4;
        }
      }
      f1 = Math.max(f1, 12.0F);
      localObject = paramString;
      if (TagUtils.b(paramString) > f1)
      {
        int i1 = Math.max(0, (int)(f1 - 4.0F));
        int i2 = i1;
        while (i1 < paramString.length())
        {
          if (!TextUtils.equals(String.valueOf(paramString.charAt(i1 - 1)), "、"))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString.substring(0, i1));
            ((StringBuilder)localObject).append("…");
            if (TagUtils.b(((StringBuilder)localObject).toString()) > f1) {
              break;
            }
            i2 = i1;
          }
          i1 += 1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, i2));
        ((StringBuilder)localObject).append("…");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.d.setHint((CharSequence)localObject);
    }
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    int i2 = 0;
    int i1;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    this.m.setSearchTags(paramArrayList);
    paramArrayList = this.l;
    if (i1 != 0) {
      i2 = 8;
    }
    paramArrayList.setVisibility(i2);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 11)
    {
      if (i1 == 12) {
        c();
      }
    }
    else {
      b();
    }
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.o == 1)
    {
      a(0);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 1912930423: 
      if (this.o == 1) {
        a(0);
      }
      this.d.setText("");
      return;
    case 1912930422: 
      if (this.o == 1)
      {
        a(0);
        return;
      }
      paramView = this.a;
      if (paramView != null)
      {
        paramView.finish();
        return;
      }
      break;
    case 1912930360: 
      a();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getBaseActivity();
    this.b = this.a.app;
    paramBundle = this.a.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
    }
    this.q = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(1912995849, null);
    paramViewGroup = paramLayoutInflater.findViewById(1912930436);
    if (paramViewGroup != null)
    {
      paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
      paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(this.a);
      paramViewGroup.setLayoutParams(paramBundle);
      b(2131168092);
    }
    this.d = ((QuickPinyinEditText)paramLayoutInflater.findViewById(1912930426));
    this.d.setImeOptions(3);
    this.d.setOnEditorActionListener(this);
    this.d.addTextChangedListener(this);
    this.d.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
    this.d.setInputType(524289);
    this.e = ((ImageView)paramLayoutInflater.findViewById(1912930423));
    this.e.setOnTouchListener(UITools.a);
    this.e.setOnClickListener(this);
    this.f = ((TextView)paramLayoutInflater.findViewById(1912930422));
    this.f.setOnTouchListener(UITools.a);
    this.f.setOnClickListener(this);
    this.g = ((FrameLayout)paramLayoutInflater.findViewById(1912930424));
    a(this.g);
    this.h = ((BounceScrollView)paramLayoutInflater.findViewById(1912930428));
    this.h.setOnScrollChangedListener(this);
    this.i = ((ViewGroup)paramLayoutInflater.findViewById(1912930361));
    this.j = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(1912930362));
    this.j.setViewMargin(AIOUtils.b(10.0F, getResources()), AIOUtils.b(10.0F, getResources()));
    this.j.setOnItemClickListener(new ExtendFriendSearchBaseFragment.1(this));
    this.k = ((TextView)paramLayoutInflater.findViewById(1912930360));
    this.k.setOnClickListener(this);
    this.l = ((ViewGroup)paramLayoutInflater.findViewById(1912930408));
    this.m = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(1912930409));
    this.m.setViewMargin(AIOUtils.b(10.0F, getResources()), AIOUtils.b(10.0F, getResources()));
    this.m.setOnItemClickListener(new ExtendFriendSearchBaseFragment.2(this));
    this.n = paramLayoutInflater.findViewById(1912930389);
    if (this.n != null)
    {
      boolean bool = ThemeUtil.isInNightMode(this.a.app);
      paramViewGroup = this.n;
      int i1;
      if (bool) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      paramViewGroup.setVisibility(i1);
    }
    this.r = new SoftKeyboardStateHelper(paramLayoutInflater);
    this.r.a(this);
    a(0);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.q.removeCallbacksAndMessages(null);
    this.d.removeTextChangedListener(this);
    this.d.setOnEditorActionListener(null);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      return false;
    }
    paramTextView = this.d.getText().toString().trim();
    if (!TextUtils.isEmpty(paramTextView)) {
      c(paramTextView);
    }
    a(false, 50L);
    return true;
  }
  
  public void onFinish()
  {
    super.onFinish();
    BaseActivity localBaseActivity = this.a;
    if (localBaseActivity != null) {
      localBaseActivity.overridePendingTransition(0, 2130772473);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((!this.p) && (this.o == 1))
    {
      a(false);
      this.q.postDelayed(new ExtendFriendSearchBaseFragment.3(this), 50L);
    }
    this.p = false;
  }
  
  public void onSoftKeyboardClosed()
  {
    this.d.setCursorVisible(false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.d.setCursorVisible(true);
  }
  
  public void onStop()
  {
    super.onStop();
    c();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    QuickPinyinEditText localQuickPinyinEditText = this.d;
    if (localQuickPinyinEditText != null) {
      localQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onViewStateRestored(paramBundle);
    paramBundle = this.d;
    if (paramBundle != null) {
      paramBundle.addTextChangedListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchBaseFragment
 * JD-Core Version:    0.7.0.1
 */