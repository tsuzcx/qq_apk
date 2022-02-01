package com.tencent.mobileqq.guild.channel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.audio.AudioRoom;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.event.QQGuildEventManager;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.privatechannel.ext.GuildPrivateDeleteMemberFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton.OnCheckedChangeListener;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QQGuildChannelInfoSettingFragment
  extends QQGuildTitleBarFragment
  implements View.OnClickListener, GuildSwitchButton.OnCheckedChangeListener
{
  private View A;
  private RelativeLayout B;
  private RelativeLayout C;
  private RelativeLayout D;
  private RelativeLayout E;
  private QQProgressDialog F;
  private ActionSheet G;
  private ActionSheet H;
  private boolean I = false;
  private int J = 3;
  private RelativeLayout K;
  private TextView L;
  private GPServiceObserver M = new QQGuildChannelInfoSettingFragment.1(this);
  private QQGuildObserver N = new QQGuildChannelInfoSettingFragment.5(this);
  public IGProChannelInfo o;
  private String p;
  private String q;
  private int r;
  private TextView s;
  private TextView t;
  private Button u;
  private GuildSwitchButton v;
  private TextView w;
  private View x;
  private View y;
  private View z;
  
  private boolean A()
  {
    return this.o.getSpecialType().contains(Integer.valueOf(1));
  }
  
  private void B()
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_channel_set");
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_pg_source", Integer.valueOf(this.r));
    localHashMap.put("sgrp_sub_channel_id", this.o.getChannelUin());
    int j = this.o.getType();
    int i = 2;
    if (j != 2) {
      i = 1;
    }
    localHashMap.put("sgrp_sub_channel_type", Integer.valueOf(i));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.k, this.o, localHashMap);
  }
  
  private void C()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.B, "em_sgrp_channel_set_name", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.u, "em_sgrp_channel_set_delete", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.y, "em_sgrp_channel_set_access_member", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.K, "em_sgrp_channel_set_type", null);
  }
  
  private void a(int paramInt, @NonNull List<String> paramList)
  {
    if ((this.o.getVisibleType() == paramInt) && (paramInt != 2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setChannelVisible: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramList);
    localStringBuilder.append("");
    QLog.e("QQGuildChannelInfoSettingFragment", 4, localStringBuilder.toString());
    ((QQGuildHandler)l().getBusinessHandler(QQGuildHandler.class.getName())).a(this.o.getGuildId(), this.o.getChannelUin(), paramInt, paramList, new QQGuildChannelInfoSettingFragment.9(this));
  }
  
  public static void a(Context paramContext, IGProChannelInfo paramIGProChannelInfo, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localBundle.putSerializable("extra_guild_channel_info", paramIGProChannelInfo);
    localBundle.putString("extra_channel_category", paramString);
    localBundle.putInt("extra_entrance_from", paramInt);
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildChannelInfoSettingFragment.class);
  }
  
  private void a(View paramView, String paramString, Map<String, Object> paramMap)
  {
    VideoReport.setElementId(paramView, paramString);
    VideoReport.setLogicParent(paramView, this.k);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
    VideoReport.reportEvent("clck", paramView, paramMap);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    paramAppInterface = ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString2);
    if (paramAppInterface == null)
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("openChannelInfoSetting guildId=");
      paramAppInterface.append(paramString1);
      paramAppInterface.append(" channelId=");
      paramAppInterface.append(paramString2);
      QLog.e("QQGuildChannelInfoSettingFragment", 1, paramAppInterface.toString());
      return;
    }
    a(paramContext, paramAppInterface, paramAppInterface.getCategoryName(), 2);
  }
  
  private void a(IGProChannelInfo paramIGProChannelInfo, int paramInt, boolean paramBoolean)
  {
    if (l() == null)
    {
      QLog.e("QQGuildChannelInfoSettingFragment", 1, "updateNotifyLevel appInterface null");
      return;
    }
    ((QQGuildHandler)l().getBusinessHandler(QQGuildHandler.class.getName())).b(paramIGProChannelInfo, paramInt, new QQGuildChannelInfoSettingFragment.3(this));
  }
  
  private void a(String paramString)
  {
    this.q = paramString;
    if (TextUtils.isEmpty(this.q))
    {
      this.L.setText(BaseApplication.getContext().getString(2131890325));
      return;
    }
    this.L.setText(this.q);
  }
  
  private void b(int paramInt)
  {
    String str;
    if (paramInt == 2) {
      str = getResources().getString(2131890340);
    } else {
      str = getResources().getString(2131890338);
    }
    this.t.setText(str);
  }
  
  private void b(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChannelDeleteResult errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.i("QQGuildChannelInfoSettingFragment", 1, localStringBuilder.toString());
    paramString = this.F;
    if ((paramString != null) && (paramString.isShowing())) {
      this.F.dismiss();
    }
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      QQGuildEventManager.a.b(this.p, this.o.getChannelUin(), 1);
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    else
    {
      QQGuildUtil.a(getContext(), paramInt, getResources().getString(2131890335), paramIGProSecurityResult);
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == this.o.getTalkPermission())
    {
      QLog.i("QQGuildChannelInfoSettingFragment", 1, "onUpdateChannel permission same");
      return;
    }
    ((QQGuildHandler)l().getBusinessHandler(QQGuildHandler.class.getName())).a(this.o.getChannelUin(), paramInt, new QQGuildChannelInfoSettingFragment.7(this));
  }
  
  private void c(boolean paramBoolean)
  {
    IGProChannelInfo localIGProChannelInfo = this.o;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    a(localIGProChannelInfo, i, paramBoolean);
  }
  
  private void d(int paramInt)
  {
    a(paramInt, Collections.emptyList());
  }
  
  private void n()
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGuildChannelInfoSettingFragment.2(this));
  }
  
  private void o()
  {
    Object localObject = this.l.findViewById(2131434577);
    IGProChannelInfo localIGProChannelInfo = this.o;
    if ((localIGProChannelInfo != null) && (localIGProChannelInfo.getType() == 2)) {
      ((View)localObject).setVisibility(8);
    }
    this.v.setOnCheckedChangeListener(null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateMsgNotifyItem. channelId: ");
      ((StringBuilder)localObject).append(this.o.getChannelUin());
      ((StringBuilder)localObject).append(", getMsgNotify: ");
      ((StringBuilder)localObject).append(this.o.getMsgNotify());
      QLog.d("QQGuildChannelInfoSettingFragment", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.v;
    int i = this.o.getMsgNotify();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    ((GuildSwitchButton)localObject).setChecked(bool);
    this.v.setOnCheckedChangeListener(this);
  }
  
  private void p()
  {
    a(getString(2131890319, new Object[] { this.o.getChannelName() }));
    this.s.setText(this.o.getChannelName());
    b(this.o.getTalkPermission());
    a(this.q);
    o();
    int i = this.o.getChannelMemberMax();
    this.w.setText(String.valueOf(i));
    q();
    if (this.o.getVisibleType() == 2) {
      m();
    }
  }
  
  private void q()
  {
    int i = this.o.getVisibleType();
    Object localObject = (TextView)this.l.findViewById(2131434769);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("invalid visibleType=");
          ((StringBuilder)localObject).append(i);
          QLog.e("QQGuildChannelInfoSettingFragment", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          ((TextView)localObject).setText(2131890615);
        }
      }
      else {
        ((TextView)localObject).setText(2131890221);
      }
    }
    else {
      ((TextView)localObject).setText(2131890227);
    }
    if (i != 2)
    {
      this.y.setVisibility(8);
      return;
    }
    this.y.setVisibility(0);
  }
  
  private boolean r()
  {
    if ((this.o.getType() == 2) && (AudioRoom.b().a(this.o.getChannelUin())))
    {
      if (getContext() != null) {
        QQToast.makeText(getContext(), 1, 2131890530, 1).show();
      }
      return true;
    }
    return false;
  }
  
  private boolean s()
  {
    if ((this.o.getType() == 5) && (this.o.getLiveRoomId() > 0L))
    {
      if (getContext() != null) {
        QQToast.makeText(getContext(), 1, 2131890531, 1).show();
      }
      return true;
    }
    return false;
  }
  
  private void t()
  {
    if (A())
    {
      y();
      return;
    }
    if (this.G == null)
    {
      this.G = ((ActionSheet)ActionSheetHelper.b(getActivity(), null));
      this.G.setMainTitle(2131890339);
      localObject1 = this.G;
      localObject2 = getResources().getString(2131890338);
      boolean bool;
      if (this.o.getTalkPermission() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((ActionSheet)localObject1).addRadioButton((CharSequence)localObject2, 1, bool);
      localObject1 = this.G;
      localObject2 = getResources().getString(2131890340);
      if (this.o.getTalkPermission() == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((ActionSheet)localObject1).addRadioButton((CharSequence)localObject2, 1, bool);
      this.G.addCancelButton(2131887648);
      this.G.setOnButtonClickListener(new QQGuildChannelInfoSettingFragment.6(this));
    }
    this.G.show();
    Object localObject1 = (ImageView)this.G.mContentContainer.findViewById(0).findViewById(2131427550);
    Object localObject2 = (ImageView)this.G.mContentContainer.findViewById(1).findViewById(2131427550);
    int j = ViewUtils.dip2px(16.0F);
    ImageView[] arrayOfImageView = new ImageView[2];
    arrayOfImageView[0] = localObject1;
    arrayOfImageView[1] = localObject2;
    int k = arrayOfImageView.length;
    int i = 0;
    while (i < k)
    {
      ViewGroup.LayoutParams localLayoutParams = arrayOfImageView[i].getLayoutParams();
      localLayoutParams.width = j;
      localLayoutParams.height = j;
      i += 1;
    }
    if (this.o.getTalkPermission() == 1)
    {
      ((ImageView)localObject1).setImageResource(2130840638);
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject2).setVisibility(8);
      return;
    }
    if (this.o.getTalkPermission() == 2)
    {
      ((ImageView)localObject2).setImageResource(2130840638);
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject2).setVisibility(0);
    }
  }
  
  private void u()
  {
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChannelNameSetting(getContext(), this.o);
  }
  
  private void v()
  {
    if (A())
    {
      y();
      return;
    }
    int j = this.o.getVisibleType();
    Object localObject = this.H;
    int i = 0;
    boolean bool2 = true;
    if (localObject != null)
    {
      ((ActionSheet)localObject).clearAllRadioBtnCheckStatus();
      if (j == 0) {
        this.H.setRadioButtonChecked(0);
      } else if (j == 1) {
        this.H.setRadioButtonChecked(1);
      } else {
        this.H.setRadioButtonChecked(2);
      }
      this.H.show();
      return;
    }
    this.H = ((ActionSheet)ActionSheetHelper.b(getActivity(), null));
    this.H.setMainTitle(2131890640);
    localObject = this.H;
    String str = getString(2131890227);
    boolean bool1;
    if (j == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((ActionSheet)localObject).addRadioButton(str, bool1);
    localObject = this.H;
    str = getString(2131890221);
    if (j == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((ActionSheet)localObject).addRadioButton(str, bool1);
    localObject = this.H;
    str = getString(2131890615);
    if (j == 2) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((ActionSheet)localObject).addRadioButton(str, bool1);
    this.H.addCancelButton(2131887648);
    this.H.setOnButtonClickListener(new QQGuildChannelInfoSettingFragment.8(this));
    this.H.show();
    while (i < 3)
    {
      localObject = (ImageView)this.H.mContentContainer.findViewById(i).findViewById(2131427550);
      ((ImageView)localObject).setImageResource(2130840638);
      j = ViewUtils.dip2px(16.0F);
      localObject = ((ImageView)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = j;
      ((ViewGroup.LayoutParams)localObject).height = j;
      i += 1;
    }
  }
  
  private void w()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getActivity(), null);
    localActionSheet.setMainTitle(2131890289);
    localActionSheet.addButton(getResources().getString(2131888434), 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new QQGuildChannelInfoSettingFragment.10(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void x()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230, null, getResources().getString(2131890622), getResources().getString(2131890621), getResources().getString(2131890620), getResources().getColor(2131165410), new QQGuildChannelInfoSettingFragment.11(this), new QQGuildChannelInfoSettingFragment.12(this));
    localQQCustomDialog.getMessageTextView().setGravity(17);
    localQQCustomDialog.getBtnLeft().setTypeface(localQQCustomDialog.getBtnLeft().getTypeface(), 1);
    localQQCustomDialog.show();
  }
  
  private void y()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230, null, getResources().getString(2131890624), getResources().getString(2131890623), null, null, new QQGuildChannelInfoSettingFragment.13(this));
    localQQCustomDialog.getMessageTextView().setGravity(17);
    localQQCustomDialog.getBtnLeft().setTypeface(localQQCustomDialog.getBtnLeft().getTypeface(), 1);
    localQQCustomDialog.show();
  }
  
  private void z()
  {
    QLog.i("QQGuildChannelInfoSettingFragment", 1, "deleteChannel");
    if (this.F == null) {
      this.F = new QQProgressDialog(getContext());
    }
    if (!this.F.isShowing()) {
      this.F.show();
    }
    ((QQGuildHandler)l().getBusinessHandler(QQGuildHandler.class.getName())).a(this.o, new QQGuildChannelInfoSettingFragment.16(this));
  }
  
  protected void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (getActivity() == null) {
      return;
    }
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      q();
      if (this.o.getVisibleType() == 2) {
        m();
      }
      return;
    }
    QQGuildUtil.a(getActivity(), paramInt, paramString, paramIGProSecurityResult);
    if ((paramInt == 10006) && (getActivity() != null)) {
      getActivity().finish();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    k();
    if (this.o == null)
    {
      QLog.e("QQGuildChannelInfoSettingFragment", 1, "error channel info");
      QQToast.makeText(getContext(), 1, getResources().getString(2131889041), 1).show();
      return;
    }
    this.s = ((TextView)this.l.findViewById(2131434583));
    this.t = ((TextView)this.l.findViewById(2131434555));
    this.v = ((GuildSwitchButton)this.l.findViewById(2131439103));
    this.v.setTag(Integer.valueOf(1));
    this.u = ((Button)this.l.findViewById(2131434554));
    this.u.setOnClickListener(this);
    this.B = ((RelativeLayout)this.l.findViewById(2131434580));
    this.C = ((RelativeLayout)this.l.findViewById(2131434582));
    this.B.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.K = ((RelativeLayout)this.l.findViewById(2131434545));
    this.K.setOnClickListener(this);
    this.L = ((TextView)this.l.findViewById(2131434549));
    this.x = this.l.findViewById(2131434770);
    this.y = this.l.findViewById(2131434724);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z = this.l.findViewById(2131437208);
    this.A = this.l.findViewById(2131437209);
    this.D = ((RelativeLayout)this.l.findViewById(2131434574));
    this.w = ((TextView)this.l.findViewById(2131434575));
    this.E = ((RelativeLayout)this.l.findViewById(2131434577));
    if (this.o.getType() == 2)
    {
      this.D.setOnClickListener(this);
      this.A.setVisibility(8);
      this.C.setVisibility(8);
    }
    else if (this.o.getType() == 5)
    {
      this.D.setVisibility(8);
    }
    else if (this.o.getType() == 6)
    {
      this.D.setVisibility(8);
      this.z.setVisibility(8);
      this.C.setVisibility(8);
      this.E.setVisibility(8);
    }
    else
    {
      this.D.setVisibility(8);
      this.C.setVisibility(0);
      this.z.setVisibility(8);
    }
    p();
    B();
    C();
  }
  
  protected int b()
  {
    return 2131625006;
  }
  
  protected void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.C;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localRelativeLayout.setVisibility(i);
  }
  
  protected String i()
  {
    return this.p;
  }
  
  protected IGProChannelInfo j()
  {
    return this.o;
  }
  
  protected void k()
  {
    Object localObject = getActivity().getIntent().getExtras();
    if (localObject != null)
    {
      this.o = ((IGProChannelInfo)((Bundle)localObject).getSerializable("extra_guild_channel_info"));
      this.p = ((Bundle)localObject).getString("extra_guild_id", "");
      this.q = ((Bundle)localObject).getString("extra_channel_category");
      this.r = ((Bundle)localObject).getInt("extra_entrance_from");
      int i = this.r;
      if ((i != 1) && (i != 2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unknown mPageSource value detected: ");
        ((StringBuilder)localObject).append(this.r);
        QLog.i("QQGuildChannelInfoSettingFragment", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void m()
  {
    TextView localTextView = (TextView)this.y.findViewById(2131434576);
    localTextView.setText("");
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getVisibleMemberCount(this.o.getGuildId(), this.o.getChannelUin(), new QQGuildChannelInfoSettingFragment.4(this, localTextView));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null) {
          return;
        }
        paramIntent = paramIntent.getStringArrayExtra("select_member_list");
        if (paramIntent != null) {
          paramIntent = Arrays.asList(paramIntent);
        } else {
          paramIntent = Collections.emptyList();
        }
        if (paramIntent.size() <= 0) {
          return;
        }
        a(2, paramIntent);
      }
    }
    else
    {
      if (paramInt1 == 2)
      {
        m();
        return;
      }
      if ((paramInt2 == 10006) && (getActivity() != null)) {
        getActivity().finish();
      }
    }
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    l().addObserver(this.N);
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).addObserver(this.M);
  }
  
  public void onCheckedChanged(GuildSwitchButton paramGuildSwitchButton, boolean paramBoolean)
  {
    if (((Integer)paramGuildSwitchButton.getTag()).intValue() != 1) {
      return;
    }
    c(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131434554) {
      w();
    } else if (i == 2131434582) {
      t();
    } else if (i == 2131434580) {
      u();
    } else if (paramView == this.K) {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChannelChooseCategory(getContext(), this.o.getGuildId(), this.o.getChannelUin(), this.q);
    } else if (i == 2131434574) {
      QQGuildVoiceChannelMemberLimitFragment.a(getQBaseActivity(), this.o);
    } else if (i == 2131434770)
    {
      if ((!r()) && (!s())) {
        v();
      }
    }
    else if (i == 2131434724) {
      if (A()) {
        y();
      } else if ((!r()) && (!s())) {
        GuildPrivateDeleteMemberFragment.a(getActivity(), l(), this.o.getGuildId(), this.o.getChannelUin(), String.format(getResources().getString(2131890533), new Object[] { this.o.getChannelName().toString() }), 2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.F;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.F.dismiss();
    }
    localObject = this.G;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
      this.G.dismiss();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    l().removeObserver(this.N);
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).deleteObserver(this.M);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.o != null)
    {
      this.o = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getChannelInfo(this.o.getChannelUin());
      IGProChannelInfo localIGProChannelInfo = this.o;
      if (localIGProChannelInfo != null)
      {
        int i = localIGProChannelInfo.getChannelMemberMax();
        this.w.setText(String.valueOf(i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment
 * JD-Core Version:    0.7.0.1
 */