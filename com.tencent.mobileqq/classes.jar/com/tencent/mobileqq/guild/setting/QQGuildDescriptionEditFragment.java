package com.tencent.mobileqq.guild.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.Builder;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.api.IGuildSoftKeyboardObserver;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QQGuildDescriptionEditFragment
  extends QQGuildTitleBarFragment
{
  private ViewTreeObserver.OnGlobalLayoutListener A = new QQGuildDescriptionEditFragment.7(this);
  protected TextView o;
  protected CharacterCountEditText p;
  protected RelativeLayout q;
  protected LinearLayout r;
  protected ImageButton s;
  private IGuildSoftKeyboardObserver t;
  private LinearLayout u;
  private boolean v = true;
  private String w;
  private String x = "";
  private int y = 0;
  private int z = 0;
  
  private static SystemAndEmojiUniversalPanel a(EditText paramEditText)
  {
    return new SystemAndEmojiUniversalPanel.Builder(paramEditText.getContext()).setFilterSysFaceBeyond255Enable(true).setEmoticonCallback(new QQGuildDescriptionEditFragment.8(paramEditText)).setShowDeleteButton(paramEditText).create(((IEmoticonMainPanelAppService)QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.peekAppRuntime()));
  }
  
  private void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      paramString = new Intent();
      paramString.putExtra("guild_introduction", this.x);
      localFragmentActivity.setResult(-1, paramString);
      onBackEvent();
      QQToast.makeText(MobileQQ.getContext(), 2, " 设置成功", 0).show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildDescriptionEditFragment", 2, String.format("set guildIntroduction failed: %s", new Object[] { paramString }));
    }
    QQGuildUtil.a(getContext(), paramInt, "提交失败，请稍后重试 ", paramIGProSecurityResult);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("guild_id", paramString1);
    localBundle.putString("guild_introduction", paramString2);
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildDescriptionEditFragment.class);
  }
  
  private static void a(@NonNull View paramView, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.height != paramInt)
    {
      localLayoutParams.height = paramInt;
      paramView.requestLayout();
    }
  }
  
  private void b(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      this.x = ((IGuildEmotionCodecApi)QRoute.api(IGuildEmotionCodecApi.class)).fromQQTextBuilder((QQTextBuilder)paramCharSequence);
    } else {
      this.x = paramCharSequence.toString();
    }
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).setGuildProfile(this.w, this.x, new QQGuildDescriptionEditFragment.9(this));
  }
  
  @RequiresApi(api=21)
  private void m()
  {
    Object localObject = getActivity();
    if (localObject == null)
    {
      QLog.w("QQGuildDescriptionEditFragment", 2, "getActivity() is null");
      return;
    }
    ((Activity)localObject).getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.A);
    ((Activity)localObject).getWindow().setSoftInputMode(16);
    this.q = ((RelativeLayout)this.l.findViewById(2131434607));
    this.q.setOnClickListener(new QQGuildDescriptionEditFragment.1(this));
    this.s = ((ImageButton)this.l.findViewById(2131430482));
    this.s.setOnClickListener(new QQGuildDescriptionEditFragment.2(this));
    this.o = ((TextView)this.l.findViewById(2131434726));
    this.r = ((LinearLayout)this.l.findViewById(2131432470));
    this.p = ((CharacterCountEditText)this.l.findViewById(2131434608));
    this.p.setLimitCount(25);
    this.p.setCountChangeListener(new QQGuildDescriptionEditFragment.3(this));
    localObject = ((IGuildEmotionCodecApi)QRoute.api(IGuildEmotionCodecApi.class)).toQQText(this.x, 20);
    this.p.setText((CharSequence)localObject);
    localObject = this.p;
    ((CharacterCountEditText)localObject).setSelection(Math.min(25, ((CharacterCountEditText)localObject).getEditableText().length()));
    this.p.setOnFocusChangeListener(new QQGuildDescriptionEditFragment.4(this));
    n();
    k();
    b(true);
  }
  
  private void n()
  {
    b(2131888784, new QQGuildDescriptionEditFragment.5(this));
    a(getResources().getString(2131916350));
    a(2131887648, new QQGuildDescriptionEditFragment.6(this));
  }
  
  private void o()
  {
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle == null)
    {
      QLog.e("QQGuildDescriptionEditFragment", 1, "initIntentData failed: bundle is null");
      getActivity().finish();
      return;
    }
    this.w = localBundle.getString("guild_id");
    this.x = localBundle.getString("guild_introduction");
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildDescriptionEditFragment", 2, String.format("initIntentData guildId: %s, remark: %s", new Object[] { this.w, this.x }));
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  @RequiresApi(api=21)
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    o();
    m();
  }
  
  protected int b()
  {
    return 2131625044;
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildDescriptionEditFragment", 2, new Object[] { "toggleKeyboard: ", Boolean.valueOf(paramBoolean) });
    }
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    localObject = (InputMethodManager)((FragmentActivity)localObject).getSystemService("input_method");
    if (paramBoolean)
    {
      ((InputMethodManager)localObject).showSoftInput(this.p, 2);
      return;
    }
    View localView = getActivity().getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null))
    {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      return;
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(this.p.getWindowToken(), 0);
  }
  
  @RequiresApi(api=16)
  public void i()
  {
    Object localObject = this.u;
    if ((localObject != null) && (this.v))
    {
      ((LinearLayout)localObject).setVisibility(8);
      this.s.setBackground(getResources().getDrawable(2130849798));
      localObject = getActivity();
      if (localObject != null) {
        ((Activity)localObject).getWindow().setSoftInputMode(16);
      }
      b(true);
    }
  }
  
  @RequiresApi(api=16)
  public void j()
  {
    if ((this.u != null) && (!this.v))
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null) {
        localFragmentActivity.getWindow().setSoftInputMode(32);
      }
      b(false);
      this.r.setVisibility(0);
      this.u.setVisibility(0);
      this.s.setBackground(getResources().getDrawable(2130838075));
      a(this.u, this.z);
    }
  }
  
  public void k()
  {
    this.u = ((LinearLayout)this.l.findViewById(2131432437));
    if (this.v) {
      this.u.setVisibility(8);
    }
    SystemAndEmojiUniversalPanel localSystemAndEmojiUniversalPanel = a(this.p);
    localSystemAndEmojiUniversalPanel.setVisibility(0);
    this.u.addView(localSystemAndEmojiUniversalPanel);
  }
  
  public boolean onBackEvent()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      if (Build.VERSION.SDK_INT >= 16) {
        localFragmentActivity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.A);
      } else {
        localFragmentActivity.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.A);
      }
    }
    return super.onBackEvent();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.v)
    {
      this.v = false;
      b(false);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildDescriptionEditFragment
 * JD-Core Version:    0.7.0.1
 */