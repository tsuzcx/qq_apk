package com.tencent.mobileqq.onlinestatus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.onlinestatus.tempapi.IEmojiPanelApi;
import com.tencent.mobileqq.onlinestatus.view.SoftInputDetectView;
import com.tencent.mobileqq.onlinestatus.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.util.InputMethodUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AutoReplyEditActivity
  extends QIphoneTitleBarFragment
  implements SoftInputDetectView.OnImStateChangedListener
{
  private boolean A;
  private ViewGroup a;
  private EditText b;
  private View c;
  private AutoReplyText d;
  private ImageView e;
  private ImageView f;
  private View.OnTouchListener g = new AutoReplyEditActivity.1(this);
  private Handler w;
  private AppRuntime x;
  private boolean y;
  private boolean z;
  
  public static void a(Activity paramActivity, int paramInt, AutoReplyText paramAutoReplyText)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("AutoReplyEditActivity:text", paramAutoReplyText);
    QPublicFragmentActivity.startForResult(paramActivity, localIntent, AutoReplyEditActivity.class, paramInt);
  }
  
  private boolean a(String paramString)
  {
    if (paramString != null)
    {
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        int k = paramString.charAt(i);
        if ((k != 32) && (k != 10) && (k != 13) && (k != 9)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void b()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getQBaseActivity(), 230).setMessage(getString(2131887161));
    localQQCustomDialog.setPositiveButton(2131892267, new AutoReplyEditActivity.10(this));
    localQQCustomDialog.setNegativeButton(2131887648, new AutoReplyEditActivity.11(this));
    localQQCustomDialog.show();
  }
  
  private void c()
  {
    if ((!this.z) && (!this.y))
    {
      this.f.setImageResource(2130837600);
      this.f.setContentDescription(getQBaseActivity().getString(2131887162));
      return;
    }
    this.f.setImageResource(2130837599);
    this.f.setContentDescription(getQBaseActivity().getString(2131887159));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void c(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    a(getString(2131887150));
    a(2131887648, new AutoReplyEditActivity.2(this));
    c(2131889474, new AutoReplyEditActivity.3(this));
    ((SoftInputDetectView)this.t.findViewById(2131435828)).setOnImStateChangedListener(this);
    this.d = ((AutoReplyText)localBundle.getParcelable("AutoReplyEditActivity:text"));
    this.a = ((ViewGroup)this.t.findViewById(2131432441));
    this.b = ((EditText)this.t.findViewById(2131428942));
    this.b.setEditableFactory(new AutoReplyEditActivity.4(this));
    paramBundle = this.d;
    if (paramBundle != null)
    {
      if (paramBundle.getTextId() == 2147483647) {
        this.A = false;
      } else {
        this.b.setText(this.d.getRawText());
      }
    }
    else {
      this.A = true;
    }
    this.b.setFocusable(true);
    this.b.setFocusableInTouchMode(true);
    this.b.requestFocus();
    this.c = ((IEmojiPanelApi)QRoute.api(IEmojiPanelApi.class)).findAndInitEmojiPanel(this.x, getQBaseActivity(), this.t, 2131432442, this.b);
    this.c.setVisibility(8);
    if (TextUtils.isEmpty(this.b.getText())) {
      this.k.setEnabled(false);
    }
    this.b.addTextChangedListener(new AutoReplyEditActivity.5(this));
    this.e = ((ImageView)this.t.findViewById(2131432469));
    this.e.setOnTouchListener(this.g);
    this.f = ((ImageView)this.t.findViewById(2131432473));
    this.f.setOnTouchListener(this.g);
    this.f.setOnClickListener(new AutoReplyEditActivity.6(this));
    if (!QQTheme.isDefaultTheme())
    {
      this.t.findViewById(2131447724).setVisibility(8);
      this.t.findViewById(2131429660).setVisibility(8);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d(false);
      this.w.postDelayed(new AutoReplyEditActivity.7(this), 0L);
      return;
    }
    InputMethodUtil.b(this.b);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(false);
      localObject = this.w;
      AutoReplyEditActivity.8 local8 = new AutoReplyEditActivity.8(this);
      long l;
      if (this.y) {
        l = 500L;
      } else {
        l = 10L;
      }
      ((Handler)localObject).postDelayed(local8, l);
      return;
    }
    this.z = false;
    Object localObject = this.a.getLayoutParams();
    this.e.setImageResource(2130852006);
    this.e.setContentDescription(getQBaseActivity().getString(2131887157));
    this.e.setOnClickListener(new AutoReplyEditActivity.9(this));
    this.c.setVisibility(8);
    ((ViewGroup.LayoutParams)localObject).height = -2;
    this.a.setMinimumHeight(0);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    c();
  }
  
  protected int a()
  {
    return 2131623986;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.x = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.w = new Handler();
    this.y = false;
    this.A = false;
    this.z = false;
    c(getArguments());
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      d(false);
    }
    this.y = paramBoolean;
    c();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(16);
    paramActivity.getWindow().getDecorView().setBackgroundResource(2130838958);
  }
  
  public boolean onBackEvent()
  {
    if ((!getQBaseActivity().isFinishing()) && (this.c.getVisibility() == 0))
    {
      d(false);
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity
 * JD-Core Version:    0.7.0.1
 */