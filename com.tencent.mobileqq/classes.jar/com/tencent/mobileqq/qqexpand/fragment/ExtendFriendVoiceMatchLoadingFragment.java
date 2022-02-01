package com.tencent.mobileqq.qqexpand.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.match.TagInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager.LimitChatMatchListener;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.MatchingView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.util.HashMap;
import java.util.Map;

public class ExtendFriendVoiceMatchLoadingFragment
  extends PublicBaseFragment
  implements View.OnClickListener, ExtendFriendLimitChatManager.LimitChatMatchListener
{
  protected QQCustomDialog a;
  private AnimatorSet b;
  private MatchingView c;
  private BaseActivity d;
  private ViewGroup e;
  private ExtendFriendLimitChatManager f;
  private ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler g;
  private final int h = 2;
  private TagInfo i;
  private int j = 0;
  private long k;
  private QQAppInterface l;
  
  private void a()
  {
    a(this.i);
    ReportController.b(this.l, "dc00898", "", "", "0X800A68F", "0X800A68F", 3, this.j, "", "", "", "");
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(3));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_tab#match_btn", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void a(TagInfo paramTagInfo)
  {
    if (this.f.f() == 2)
    {
      QLog.i("ExtendFriendVoiceMatchLoadingFragment", 2, "startMatching IN STATE_MATCHING return");
      return;
    }
    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext()))
    {
      a(this.d.getString(2131896805), false);
      return;
    }
    this.f.a(2);
    int m = this.f.f();
    if (m == 0)
    {
      this.k = System.currentTimeMillis();
      this.f.a(paramTagInfo);
      paramTagInfo = this.g;
      if (paramTagInfo != null) {
        paramTagInfo.sendEmptyMessageDelayed(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.a, 35000L);
      }
      c();
      return;
    }
    paramTagInfo = new StringBuilder();
    paramTagInfo.append("startMatching IN STATE_MATCHING return : ");
    paramTagInfo.append(m);
    QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, paramTagInfo.toString());
  }
  
  private void a(String paramString)
  {
    Object localObject;
    if (this.a == null)
    {
      localObject = this.d;
      if ((localObject != null) && (this.l != null)) {
        this.a = DialogUtil.a((Context)localObject, 230).setMessage(paramString).setPositiveButton(this.d.getString(2131896803), new ExtendFriendVoiceMatchLoadingFragment.3(this)).setNegativeButton(this.d.getString(2131896802), new ExtendFriendVoiceMatchLoadingFragment.2(this));
      }
    }
    try
    {
      if ((this.a != null) && (!this.a.isShowing()))
      {
        this.a.show();
        return;
      }
    }
    catch (Throwable paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("match fail dialog error:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.d;
    if ((localObject != null) && (!((BaseActivity)localObject).isFinishing()))
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.d, 230);
      if (localQQCustomDialog != null)
      {
        localObject = this.d.getString(2131896798);
        if (paramBoolean)
        {
          localObject = localQQCustomDialog.getMessageTextView();
          if (localObject != null) {
            ((TextView)localObject).setGravity(17);
          }
          localQQCustomDialog.setTitle(2131896861);
          localObject = this.d.getString(2131896797);
        }
        localQQCustomDialog.setMessage(paramString);
        localQQCustomDialog.setPositiveButton((String)localObject, new ExtendFriendVoiceMatchLoadingFragment.4(this));
        try
        {
          localQQCustomDialog.show();
        }
        catch (Throwable paramString)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("match handleFailAndQuitDialog error:");
          ((StringBuilder)localObject).append(paramString);
          QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, ((StringBuilder)localObject).toString());
        }
      }
      paramString = this.b;
      if (paramString != null)
      {
        paramString.cancel();
        this.b.end();
      }
      f();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler localLimitChatHandler = this.g;
    if (localLimitChatHandler != null) {
      localLimitChatHandler.removeMessages(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.a);
    }
    int m = this.f.f();
    d();
    if (m == 2)
    {
      this.f.e();
      if (paramBoolean) {
        a(this.d.getString(2131896804));
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceMatchLoadingFragment", 2, "handleOutOfMatchCountResult");
    }
    d();
    Object localObject1 = this.d;
    if ((localObject1 != null) && (!((BaseActivity)localObject1).isFinishing()))
    {
      localObject1 = DialogUtil.a(this.d, 230);
      if (localObject1 != null)
      {
        Object localObject2 = this.d.getString(2131896797);
        ((QQCustomDialog)localObject1).setMessage(this.d.getString(2131896840));
        ((QQCustomDialog)localObject1).setPositiveButton((String)localObject2, new ExtendFriendVoiceMatchLoadingFragment.1(this));
        try
        {
          ((QQCustomDialog)localObject1).show();
        }
        catch (Throwable localThrowable)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("match handleOutOfMatchCountResult error:");
          ((StringBuilder)localObject2).append(localThrowable);
          QLog.e("ExtendFriendVoiceMatchLoadingFragment", 1, ((StringBuilder)localObject2).toString());
        }
      }
      AnimatorSet localAnimatorSet = this.b;
      if (localAnimatorSet != null)
      {
        localAnimatorSet.cancel();
        this.b.end();
      }
      f();
      return;
    }
    QLog.d("ExtendFriendVoiceMatchLoadingFragment", 1, "handleOutOfMatchCountResult return");
  }
  
  private void c()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((MatchingView)localObject).a("# 语音连麦");
    }
    localObject = (ImageView)this.e.findViewById(1912930379);
    a(this.c, (View)localObject);
  }
  
  private void d()
  {
    this.c.b();
  }
  
  private void e()
  {
    this.c.a();
  }
  
  private void f() {}
  
  public void a(int paramInt, MatchInfo paramMatchInfo, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onMatchResult result");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, ((StringBuilder)localObject).toString());
    localObject = this.g;
    if (localObject != null) {
      ((ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler)localObject).removeMessages(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.a);
    }
    if ((paramInt == 0) && (paramMatchInfo != null))
    {
      LimitChatUtil.a(this.d, paramMatchInfo, paramString1, this.j, 10000, 2);
      d();
      if (paramMatchInfo == null) {
        paramString1 = "";
      } else {
        paramString1 = paramMatchInfo.c;
      }
      ReportController.b(null, "dc00898", "", paramString1, "0X80096A6", "0X80096A6", 2, 0, "", "", "", "");
      paramString1 = new HashMap();
      paramString1.put("duration", String.valueOf((System.currentTimeMillis() - this.k) / 1000L));
      paramString1.put("to_uid", paramMatchInfo.c);
      paramString1.put("match_type", "1");
      paramString1.put("source_id", String.valueOf(paramMatchInfo.i));
      paramString1.put("choose_condition", String.valueOf(this.j + 1));
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("success#match_page#match_inline", true, -1L, -1L, paramString1, true, true);
      QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "before finish on success");
      this.d.finish();
      QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "after finish on success");
      return;
    }
    paramMatchInfo = new HashMap();
    paramMatchInfo.put("failed_reason", paramString2);
    paramMatchInfo.put("match_type", "1");
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("failed#match_page#match_inline", true, -1L, -1L, paramMatchInfo, true, true);
    if (paramInt == 7)
    {
      d();
      paramMatchInfo = (IExpandManager)this.l.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramMatchInfo.D();
        paramMatchInfo = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramMatchInfo = this.d.getString(2131896816);
        }
      }
      else
      {
        paramMatchInfo = paramString2;
      }
      a(paramMatchInfo, false);
      return;
    }
    if (paramInt == 2)
    {
      d();
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = this.d.getString(2131896804);
      }
      a(paramString2);
      return;
    }
    if (paramInt == 8)
    {
      d();
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = this.d.getString(2131896860);
      }
      a(paramString2, true);
      return;
    }
    if (paramInt == 9)
    {
      b();
      return;
    }
    if (paramInt == 13)
    {
      d();
      paramMatchInfo = this.b;
      if (paramMatchInfo != null)
      {
        paramMatchInfo.cancel();
        this.b.end();
      }
      f();
      return;
    }
    d();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = this.d.getString(2131896806);
    }
    a(paramString2, false);
  }
  
  public void a(MatchingView paramMatchingView, View paramView)
  {
    if (paramMatchingView != null)
    {
      if (paramView == null) {
        return;
      }
      if (this.b == null)
      {
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramMatchingView, "alpha", new float[] { 0.0F, 1.0F });
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F });
        paramView = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F });
        this.b = new AnimatorSet();
        this.b.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramView });
        this.b.addListener(new ExtendFriendVoiceMatchLoadingFragment.5(this, paramMatchingView));
      }
      this.b.start();
    }
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    LiuHaiUtils.f(paramActivity);
  }
  
  public boolean onBackEvent()
  {
    this.d.finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 1912930371) {
      return;
    }
    onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = getBaseActivity();
    this.l = ((QQAppInterface)this.d.getAppInterface());
    if (this.l == null)
    {
      QLog.w("ExtendFriendVoiceMatchLoadingFragment", 1, "can't find app!!");
      this.l = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
    this.f = ((ExtendFriendLimitChatManager)this.l.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER));
    this.f.a(this);
    this.g = new ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler(this);
    paramBundle = this.d.getIntent();
    if (paramBundle != null) {
      this.j = paramBundle.getIntExtra("intent_sex_key", 0);
    }
    ExtendFriendLimitChatManager.a(this.l, this.j);
    this.i = new TagInfo();
    this.i.a = 10000;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.e = ((ViewGroup)paramLayoutInflater.inflate(1912995851, null));
    this.c = ((MatchingView)this.e.findViewById(1912930383));
    ((ImageView)this.e.findViewById(1912930371)).setOnClickListener(this);
    paramLayoutInflater = this.e.findViewById(1912930389);
    if (paramLayoutInflater != null) {
      if (ThemeUtil.isInNightMode(this.l)) {
        paramLayoutInflater.setVisibility(0);
      } else {
        paramLayoutInflater.setVisibility(8);
      }
    }
    if (LiuHaiUtils.b())
    {
      paramLayoutInflater = (RelativeLayout)this.e.findViewById(1912930435);
      paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      paramViewGroup.topMargin = LiuHaiUtils.d;
      paramLayoutInflater.setLayoutParams(paramViewGroup);
    }
    paramLayoutInflater = this.g;
    paramLayoutInflater.sendMessage(paramLayoutInflater.obtainMessage(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.d));
    return this.e;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler localLimitChatHandler = this.g;
    if (localLimitChatHandler != null)
    {
      localLimitChatHandler.removeMessages(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.a);
      this.g.removeMessages(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.b);
    }
    ReportController.b(this.l, "dc00898", "", "", "qq_kuolie", "0X800AA93", 0, 0, "", "", "语音连麦", "");
  }
  
  public void onPause()
  {
    super.onPause();
    a(false);
  }
  
  public void onResume()
  {
    super.onResume();
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#match_page#view", true, -1L, -1L, null, true, true);
    f();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendVoiceMatchLoadingFragment
 * JD-Core Version:    0.7.0.1
 */