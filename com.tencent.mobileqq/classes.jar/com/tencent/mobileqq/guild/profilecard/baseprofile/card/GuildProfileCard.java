package com.tencent.mobileqq.guild.profilecard.baseprofile.card;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.GuildProfileComponentController;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.ILoadUserProfileInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GuildProfileCard
  extends BottomSheetDialogFragment
{
  private static GuildProfileCard.CardShowListener f;
  private GuildProfileData a;
  private View b;
  private ViewGroup c;
  private BottomSheetDialog d;
  private GuildProfileCardViewModel e;
  private boolean g = true;
  private Observer h = new GuildProfileCard.1(this);
  private IGuildComponentController i;
  
  private static String a(GuildProfileData paramGuildProfileData, IGPSService paramIGPSService)
  {
    String str2 = paramGuildProfileData.getGuildBaseProfileData().a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = paramIGPSService.getGuildIdOf(paramGuildProfileData.getGuildBaseProfileData().b());
      paramGuildProfileData.getGuildBaseProfileData().a(str1);
    }
    return str1;
  }
  
  private void a()
  {
    this.d = ((BottomSheetDialog)getDialog());
    this.d.setOnDismissListener(new GuildProfileCard.3(this));
    this.i.a(new GuildProfileCard.4(this));
  }
  
  private static void a(Activity paramActivity, int paramInt, String paramString)
  {
    if (paramInt == 24000)
    {
      QQGuildUtil.a(paramActivity, paramInt, paramActivity.getString(2131890554));
      return;
    }
    if (paramInt == 23000)
    {
      QQGuildUtil.a(paramActivity, paramInt, paramActivity.getString(2131890553));
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QQGuildUtil.a(paramActivity, paramInt, paramString);
  }
  
  private static void a(Activity paramActivity, Fragment paramFragment, GuildProfileData paramGuildProfileData)
  {
    if (paramGuildProfileData.getGuildBaseProfileData().j())
    {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openRobotProfileCard(paramActivity, paramGuildProfileData.getGuildBaseProfileData().a(), paramGuildProfileData.getGuildBaseProfileData().c(), "");
      return;
    }
    paramActivity = ((QBaseActivity)paramActivity).getSupportFragmentManager();
    GuildProfileCard localGuildProfileCard = new GuildProfileCard();
    if (paramFragment != null) {
      localGuildProfileCard.setTargetFragment(paramFragment, 1);
    }
    localGuildProfileCard.a = paramGuildProfileData;
    paramActivity.beginTransaction().add(localGuildProfileCard, "GuildProfileCard").commit();
  }
  
  public static void a(Activity paramActivity, QBaseFragment paramQBaseFragment, GuildProfileData paramGuildProfileData)
  {
    if (QLog.isColorLevel()) {
      QLog.w("GuildProfileCard", 1, "openCard action!");
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAppRuntime == null)
    {
      QLog.w("GuildProfileCard", 2, "openCard app is null!");
      return;
    }
    if (QQGuildUIUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.w("GuildProfileCard", 1, "openCard dialog is showing");
      }
      return;
    }
    IGPSService localIGPSService = (IGPSService)localAppRuntime.getRuntimeService(IGPSService.class, "");
    String str1 = localIGPSService.getSelfTinyId();
    String str2 = paramGuildProfileData.getGuildBaseProfileData().c();
    a(paramGuildProfileData, localIGPSService);
    if (str1.equals(str2))
    {
      a(paramGuildProfileData, localIGPSService, str1);
      a(paramActivity, paramQBaseFragment, paramGuildProfileData);
      return;
    }
    a(paramGuildProfileData, localAppRuntime, new -..Lambda.GuildProfileCard.KOZTMNSPHycAdjg1kP-il54Qn-M(paramActivity, paramGuildProfileData, paramQBaseFragment));
  }
  
  public static void a(Activity paramActivity, GuildProfileData paramGuildProfileData, GuildProfileCard.CardShowListener paramCardShowListener)
  {
    f = paramCardShowListener;
    a(paramActivity, null, paramGuildProfileData);
  }
  
  private void a(Fragment paramFragment, AppInterface paramAppInterface)
  {
    if (this.i == null) {
      this.i = new GuildProfileComponentController();
    }
    this.i.init(paramFragment, this.a, new GuildProfileCard.5(this));
    this.i.setContentViewContainer(this.c);
    this.i.onCreate(paramFragment, paramAppInterface, null);
    this.i.onInitData(this.a);
  }
  
  private static void a(GuildProfileData paramGuildProfileData, IGPSService paramIGPSService, String paramString)
  {
    paramGuildProfileData.getGuildBaseProfileData().c(paramString);
    paramGuildProfileData.getGuildBaseProfileData().b(paramString);
  }
  
  private static void a(GuildProfileData paramGuildProfileData, AppRuntime paramAppRuntime, ILoadUserProfileInfoCallback paramILoadUserProfileInfoCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GuildProfileData: ");
      ((StringBuilder)localObject).append(paramGuildProfileData.toString());
      QLog.i("GuildProfileCard", 1, ((StringBuilder)localObject).toString());
    }
    paramAppRuntime = (IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "");
    Object localObject = paramGuildProfileData.getGuildBaseProfileData().a();
    IGProGuildInfo localIGProGuildInfo = paramAppRuntime.getGuildInfo((String)localObject);
    String str = paramAppRuntime.getSelfTinyId();
    paramGuildProfileData.getGuildBaseProfileData().c(str);
    if (localIGProGuildInfo != null) {
      paramGuildProfileData.getGuildBaseProfileData().a(localIGProGuildInfo.getUserType());
    }
    paramAppRuntime.loadGProUserProfileInfo((String)localObject, paramGuildProfileData.getGuildBaseProfileData().c(), paramILoadUserProfileInfoCallback);
  }
  
  private void b()
  {
    BottomSheetDialog localBottomSheetDialog = this.d;
    if (localBottomSheetDialog != null)
    {
      localBottomSheetDialog.dismiss();
      this.d = null;
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    if (this.a.getGuildBaseProfileData().e() == 1) {
      getDialog().getWindow().clearFlags(2);
    }
    AudioRoomLiveData.a.a().observe(getViewLifecycleOwner(), this.h);
    boolean bool = false;
    this.b = paramLayoutInflater.inflate(2131625104, paramViewGroup, false);
    this.c = ((ViewGroup)this.b.findViewById(2131434677));
    a(this, (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime());
    if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
      bool = true;
    }
    QLog.d("GuildProfileCard", 4, new Object[] { "peekAppRuntime isNull", Boolean.valueOf(bool) });
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDismiss(@NonNull DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    AudioRoomLiveData.a.a().removeObserver(this.h);
    paramDialogInterface = f;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.g);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.i.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ((ViewGroup)this.b.getParent()).setBackgroundDrawable(getResources().getDrawable(2130840689));
    a();
    this.i.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    this.e = ((GuildProfileCardViewModel)GuildProfileCardViewModel.a.create(GuildProfileCardViewModel.class));
    this.e.a(getContext());
    this.e.a().observe(this, new GuildProfileCard.2(this));
  }
  
  public void onStop()
  {
    super.onStop();
    GuildProfileCardViewModel localGuildProfileCardViewModel = this.e;
    if (localGuildProfileCardViewModel != null) {
      localGuildProfileCardViewModel.b(getContext());
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCard
 * JD-Core Version:    0.7.0.1
 */