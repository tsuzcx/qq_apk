package com.tencent.mobileqq.guild.channel.create.fragment;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateAppSubSelectMemberDialogFragment;
import com.tencent.mobileqq.guild.util.QQGuildTextUtils.CharacterCountInfo;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText.ITextEditEventListener;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ChannelCreateInfo.Builder;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGuildSubChannelCreateFragment
  extends BaseCreateSubChannelFragment
  implements Handler.Callback, View.OnClickListener, CharacterCountEditText.ITextEditEventListener
{
  private TextView d;
  private TextView e;
  private LinearLayout f;
  private RoundRectImageView g;
  private ImageView h;
  private CharacterCountEditText i;
  private ImageView j;
  private long k;
  private String l;
  private String m;
  private final WeakReferenceHandler n = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean o = false;
  private View p;
  private int q;
  private RelativeLayout r;
  private TextView s;
  private List<String> t = new ArrayList();
  private View u;
  private View v;
  private List<View> w = new ArrayList();
  private String[] x;
  private GuildPrivateMemberListAdapter.UserInfoUIData[] y;
  
  public static QQGuildSubChannelCreateFragment a(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    QQGuildSubChannelCreateFragment localQQGuildSubChannelCreateFragment = new QQGuildSubChannelCreateFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra_key_subchannel_info", paramCreateSubChannelInfo);
    localQQGuildSubChannelCreateFragment.setArguments(localBundle);
    return localQQGuildSubChannelCreateFragment;
  }
  
  private String a(String paramString)
  {
    int i1 = paramString.length();
    while ((i1 > 0) && (paramString.charAt(i1 - 1) <= ' ')) {
      i1 -= 1;
    }
    String str = paramString;
    if (i1 < paramString.length()) {
      str = paramString.substring(0, i1);
    }
    return str;
  }
  
  private void a(int paramInt)
  {
    int i1 = 0;
    while (i1 < 3)
    {
      if (i1 == paramInt)
      {
        ((View)this.w.get(i1)).setVisibility(0);
        if (i1 == 2) {
          this.s.setVisibility(0);
        }
      }
      else
      {
        this.s.setVisibility(8);
        ((View)this.w.get(i1)).setVisibility(4);
      }
      i1 += 1;
    }
  }
  
  private void a(int paramInt, @NonNull List<String> paramList)
  {
    this.q = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("invalid visibleType=");
          localStringBuilder.append(paramInt);
          QLog.e("QQGuildSubChannelCreateFragment", 1, localStringBuilder.toString());
        }
        else
        {
          a(2);
        }
      }
      else {
        a(1);
      }
    }
    else {
      a(0);
    }
    if (paramInt != 2) {
      return;
    }
    this.t = paramList;
    this.s.setText(getString(2131890348, new Object[] { Integer.valueOf(this.t.size()) }));
  }
  
  private void a(EditText paramEditText)
  {
    paramEditText.setFocusableInTouchMode(false);
    paramEditText.clearFocus();
    paramEditText.setFocusableInTouchMode(true);
  }
  
  private void a(QQGuildSubChannelCreateFragment.SelectedAnchor paramSelectedAnchor)
  {
    paramSelectedAnchor = GuildLiveSubSelectMemberDialogFragment.g.a(this.b, a(), null, null, new QQGuildSubChannelCreateFragment.6(this, paramSelectedAnchor));
    paramSelectedAnchor.a(this.q, (String[])this.t.toArray(new String[0]));
    paramSelectedAnchor.a(this.c);
    this.c.b(paramSelectedAnchor);
    this.c.a();
    this.c.b = Boolean.valueOf(false);
    paramSelectedAnchor.show(QBaseActivity.sTopActivity.getSupportFragmentManager(), "GuildLiveSubSelectMemberDialogFragment");
    this.o = false;
  }
  
  private void a(ChannelCreateInfo.Builder paramBuilder, String[] paramArrayOfString)
  {
    paramBuilder = paramBuilder.a();
    ((QQGuildHandler)a().getBusinessHandler(QQGuildHandler.class.getName())).a(this.b.a, paramBuilder, null, this.b.b, this.b.c, new QQGuildSubChannelCreateFragment.8(this, paramArrayOfString));
  }
  
  private void a(IGProChannelInfo paramIGProChannelInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_sub_channel_type", Integer.valueOf(b(paramIGProChannelInfo.getType())));
    localHashMap.put("sgrp_sub_channel_name", paramIGProChannelInfo.getChannelName());
    localHashMap.put("sgrp_op_create_result", Integer.valueOf(c(this.q)));
    if (this.b.d == 6) {
      localHashMap.put("sgrp_sub_appchannel_id", Long.valueOf(this.k));
    }
    VideoReport.reportEvent("clck", this.e, localHashMap);
  }
  
  private void a(String paramString1, IGProChannelInfo paramIGProChannelInfo, int paramInt, String paramString2, IGProSecurityResult paramIGProSecurityResult, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChannelCreateResult errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString2);
    QLog.i("QQGuildSubChannelCreateFragment", 1, localStringBuilder.toString());
    this.o = false;
    if (getContext() == null)
    {
      QLog.e("QQGuildSubChannelCreateFragment", 1, "onChannelCreateResult context is null");
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890335));
      return;
    }
    if (a() == null)
    {
      QLog.e("QQGuildSubChannelCreateFragment", 1, "onChannelCreateResult app is null");
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890335));
      return;
    }
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      a(paramIGProChannelInfo);
      InputMethodUtil.b(this.i);
      a(this.i);
      if ("main_setting".equals(paramString1))
      {
        paramString1 = (IGPSService)a().getRuntimeService(IGPSService.class, "");
        paramInt = this.b.d;
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 5)
            {
              if (paramInt == 6)
              {
                paramString1.tryRrefreshAllAppChnnPreInfo(this.b.a, true);
                QQGuildUtil.c(getString(2131890285));
              }
            }
            else
            {
              a(paramArrayOfString, paramIGProChannelInfo);
              QQGuildUtil.c(getString(2131890285));
            }
          }
          else {
            QQGuildUtil.c(getString(2131890285));
          }
        }
        else {
          QQGuildUtil.a(a(), getContext(), paramString1.getGuildInfo(this.b.a), paramIGProChannelInfo);
        }
      }
      else
      {
        QQGuildUtil.c(getString(2131890285));
      }
      if (this.c != null) {
        this.c.d();
      }
      return;
    }
    QQGuildUtil.a(getActivity(), paramInt, paramString2, paramIGProSecurityResult);
  }
  
  private void a(String[] paramArrayOfString, IGProChannelInfo paramIGProChannelInfo)
  {
    ((IGPSService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).setLiveChannelAnchorList(paramIGProChannelInfo.getGuildId(), paramIGProChannelInfo.getChannelUin(), Arrays.asList(paramArrayOfString), Collections.emptyList(), new QQGuildSubChannelCreateFragment.7(this));
  }
  
  private int b(int paramInt)
  {
    int i1 = 1;
    if (paramInt != 1)
    {
      i1 = 2;
      if (paramInt != 2)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return 0;
          }
          return 4;
        }
        return 3;
      }
    }
    return i1;
  }
  
  private int c(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("invalid reportVisibleType=");
          localStringBuilder.append(paramInt);
          QLog.e("QQGuildSubChannelCreateFragment", 1, localStringBuilder.toString());
          return 0;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  @RequiresApi(api=21)
  private void d()
  {
    this.e = ((TextView)this.a.findViewById(2131446561));
    this.i = ((CharacterCountEditText)this.a.findViewById(2131446524));
    this.d = ((TextView)this.a.findViewById(2131429230));
    this.j = ((ImageView)this.a.findViewById(2131430752));
    this.f = ((LinearLayout)this.a.findViewById(2131447539));
    this.h = ((ImageView)this.a.findViewById(2131430516));
    this.g = ((RoundRectImageView)this.a.findViewById(2131428605));
    this.p = this.a.findViewById(2131430483);
    this.s = ((TextView)this.a.findViewById(2131445521));
    this.u = this.a.findViewById(2131428271);
    this.v = this.a.findViewById(2131450130);
    this.r = ((RelativeLayout)this.a.findViewById(2131431550));
    this.w.add(this.a.findViewById(2131428277));
    this.w.add(this.a.findViewById(2131427844));
    this.w.add(this.a.findViewById(2131431551));
    this.a.findViewById(2131428276).setOnClickListener(this);
    this.a.findViewById(2131427843).setOnClickListener(this);
    this.a.findViewById(2131431550).setOnClickListener(this);
    this.u.setVisibility(8);
    this.v.setVisibility(0);
    this.i.setLimitCount(20);
    this.i.setCountChangeListener(this);
    this.e.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.u.setOnClickListener(this);
    if (this.b.d == 6)
    {
      this.h.setVisibility(0);
      this.f.setVisibility(0);
      this.i.setText(this.l);
      this.i.setSelection(this.l.length());
      if (!StringUtil.isEmpty(this.m))
      {
        this.g.setCornerRadiusAndMode(ViewUtils.dpToPx(4.0F), 1);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ViewUtils.dip2px(18.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ViewUtils.dip2px(18.0F);
        localObject = URLDrawable.getDrawable(this.m, (URLDrawable.URLDrawableOptions)localObject);
        this.g.setImageDrawable((Drawable)localObject);
      }
    }
    else
    {
      this.h.setVisibility(4);
      this.f.setVisibility(8);
      this.d.setVisibility(8);
      if (this.b.d == 5) {
        this.e.setText(2131890429);
      }
    }
    h();
    a(0, new ArrayList());
    if (this.c != null)
    {
      this.c.a(new -..Lambda.QQGuildSubChannelCreateFragment.1ds83Ytuam9pKQThZZnUqoCSWMc(this));
      ((BottomSheetDialog)this.c.getDialog()).a().b(new QQGuildSubChannelCreateFragment.1(this));
    }
  }
  
  private void e()
  {
    this.u.setOnClickListener(null);
    Animation localAnimation = f();
    localAnimation.setAnimationListener(new QQGuildSubChannelCreateFragment.2(this));
    this.u.startAnimation(localAnimation);
    this.v.setVisibility(0);
    this.v.startAnimation(g());
    InputMethodUtil.b(this.i);
    a(this.i);
  }
  
  private Animation f()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(410L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, ViewUtils.dpToPx(50.0F));
    localTranslateAnimation.setDuration(410L);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    return localAnimationSet;
  }
  
  private Animation g()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(410L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, ViewUtils.dpToPx(50.0F), 0.0F);
    localTranslateAnimation.setDuration(410L);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    return localAnimationSet;
  }
  
  private void h()
  {
    this.i.setFocusable(true);
    this.i.setFocusableInTouchMode(true);
    this.i.requestFocus();
    this.i.postDelayed(new QQGuildSubChannelCreateFragment.3(this), 800L);
  }
  
  private void i()
  {
    if (this.o)
    {
      QLog.e("QQGuildSubChannelCreateFragment", 1, "submit duplicate while creating！");
      return;
    }
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890335));
      return;
    }
    if (a() == null)
    {
      QLog.e("QQGuildSubChannelCreateFragment", 1, "createChannel app is null");
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890335));
      return;
    }
    String str = this.i.getText().toString();
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isEmpty(str.trim())))
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890282));
      return;
    }
    this.o = true;
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      if (this.b.d == 1)
      {
        localObject = "文字频道";
      }
      else if (this.b.d == 2)
      {
        localObject = "语音频道";
      }
      else if (this.b.d == 5)
      {
        localObject = "直播频道";
      }
      else
      {
        localObject = str;
        if (this.b.d == 6) {
          localObject = this.l;
        }
      }
    }
    localObject = a((String)localObject);
    localObject = new ChannelCreateInfo.Builder().a(this.b.d).a((String)localObject).e(this.q).a(this.t).b(1).d(1);
    if (this.b.d == 6) {
      ((ChannelCreateInfo.Builder)localObject).a(this.k);
    }
    if (this.b.d == 5)
    {
      a(new QQGuildSubChannelCreateFragment.4(this, (ChannelCreateInfo.Builder)localObject));
      return;
    }
    a((ChannelCreateInfo.Builder)localObject, null);
  }
  
  private void j()
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.a, "pg_create_sub_channel");
    VideoReport.setPageContentId(this.a, "QQGuildSubChannelCreateFragment");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.a, this.b.a, null);
  }
  
  private void k()
  {
    VideoReport.setElementId(this.e, "em_sgrp_create_channel_done");
    VideoReport.setElementClickPolicy(this.e, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.e, ExposurePolicy.REPORT_NONE);
  }
  
  public void a(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo)
  {
    if (TextUtils.isEmpty(this.i.getText().toString()))
    {
      this.i.setTypeface(Typeface.defaultFromStyle(0));
      this.j.setVisibility(8);
      return;
    }
    this.i.setTypeface(Typeface.defaultFromStyle(1));
    this.j.setVisibility(0);
  }
  
  protected int b()
  {
    return 2131625129;
  }
  
  public void b(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo) {}
  
  @RequiresApi(api=21)
  protected void c()
  {
    if (this.b.e != null)
    {
      this.k = this.b.e.getLong("appId");
      this.l = this.b.e.getString("appName");
      this.m = this.b.e.getString("iconUrl");
      QLog.i("QQGuildSubChannelCreateFragment", 1, String.format("appId=%d, iconurl=%s", new Object[] { Long.valueOf(this.k), this.m }));
    }
    d();
    j();
    k();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.c != null)) {
      this.c.c();
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (!QQGuildUIUtil.a())
    {
      int i1 = paramView.getId();
      if (i1 == 2131446561)
      {
        i();
      }
      else if (i1 == 2131429230)
      {
        InputMethodUtil.b(this.i);
        a(this.i);
        this.n.sendEmptyMessageDelayed(1, 200L);
      }
      else if (i1 == 2131430752)
      {
        if ((this.i.getText() != null) && (this.i.getText().length() > 0)) {
          this.i.setText("");
        }
      }
      else if (i1 == 2131430483)
      {
        e();
      }
      else if (i1 == 2131428271)
      {
        e();
      }
      else if (i1 == 2131428276)
      {
        a(0, new ArrayList());
      }
      else if (i1 == 2131427843)
      {
        a(1, new ArrayList());
      }
      else if (i1 == 2131431550)
      {
        GuildPrivateAppSubSelectMemberDialogFragment localGuildPrivateAppSubSelectMemberDialogFragment = GuildPrivateAppSubSelectMemberDialogFragment.a(this.b, a(), this.x, this.y, new QQGuildSubChannelCreateFragment.5(this));
        localGuildPrivateAppSubSelectMemberDialogFragment.a(this.c);
        this.c.a();
        this.c.b = Boolean.valueOf(false);
        localGuildPrivateAppSubSelectMemberDialogFragment.show(QBaseActivity.sTopActivity.getSupportFragmentManager(), "GuildPrivateAppSubSelectMemberDialogFragment");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    InputMethodUtil.b(this.i);
    onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateFragment
 * JD-Core Version:    0.7.0.1
 */