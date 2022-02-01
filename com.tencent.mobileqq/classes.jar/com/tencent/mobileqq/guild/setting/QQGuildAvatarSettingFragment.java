package com.tencent.mobileqq.guild.setting;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.TroopAvatarController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController.OnDataChangeListener;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.File;
import mqq.app.MobileQQ;

public class QQGuildAvatarSettingFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, TroopPhotoController.OnDataChangeListener
{
  private IGProGuildInfo a;
  private Button b;
  private TroopAvatarController c;
  private URLImageView d;
  private RelativeLayout e;
  private TextView f;
  private AppInterface g;
  private String h;
  private GPServiceObserver i = new QQGuildAvatarSettingFragment.1(this);
  
  public static Intent a(IGProGuildInfo paramIGProGuildInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void a(Intent paramIntent)
  {
    if (this.c == null) {
      return;
    }
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQGuildAvatarSettingFragment", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.c.b(str, paramIntent);
    }
  }
  
  private void b(IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramIGProGuildInfo != null)
    {
      paramIGProGuildInfo = paramIGProGuildInfo.getAvatarUrl(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
      int j = (int)DeviceInfoUtil.D();
      localURLDrawableOptions.mRequestWidth = j;
      localURLDrawableOptions.mRequestHeight = j;
      try
      {
        paramIGProGuildInfo = URLDrawable.getDrawable(paramIGProGuildInfo, localURLDrawableOptions);
        this.d.setImageDrawable(paramIGProGuildInfo);
        paramIGProGuildInfo.setTag(new int[] { j, j });
        paramIGProGuildInfo.setDecodeHandler(QQGuildUtil.b);
        return;
      }
      catch (Exception paramIGProGuildInfo)
      {
        QLog.e("QQGuildAvatarSettingFragment", 1, paramIGProGuildInfo, new Object[0]);
      }
    }
  }
  
  private void c()
  {
    this.b = ((Button)this.e.findViewById(2131429821));
    this.b.setOnClickListener(this);
    this.d = ((URLImageView)this.e.findViewById(2131434544));
    this.f = ((TextView)this.e.findViewById(2131436180));
    this.f.setOnClickListener(this);
    ((RelativeLayout.LayoutParams)this.d.getLayoutParams()).height = ((int)DeviceInfoUtil.D());
  }
  
  private void c(AvatarInfo paramAvatarInfo)
  {
    if (paramAvatarInfo != null)
    {
      if (paramAvatarInfo.i != null)
      {
        this.d.setImageDrawable(new BitmapDrawable(paramAvatarInfo.i));
        return;
      }
      int j;
      if ((!TextUtils.isEmpty(paramAvatarInfo.c)) && (new File(paramAvatarInfo.c).exists()))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
        paramAvatarInfo = URLDrawable.getDrawable(new File(paramAvatarInfo.c), localURLDrawableOptions);
        this.d.setImageDrawable(paramAvatarInfo);
        j = (int)DeviceInfoUtil.D();
        paramAvatarInfo.setTag(new int[] { j, j });
        paramAvatarInfo.setDecodeHandler(QQGuildUtil.b);
        return;
      }
      if (this.a != null)
      {
        paramAvatarInfo = URLDrawable.URLDrawableOptions.obtain();
        paramAvatarInfo.mLoadingDrawable = URLDrawableHelperConstants.a;
        paramAvatarInfo = URLDrawable.getDrawable(this.a.getAvatarUrl(0), paramAvatarInfo);
        j = (int)DeviceInfoUtil.D();
        paramAvatarInfo.setTag(new int[] { j, j });
        paramAvatarInfo.setDecodeHandler(QQGuildUtil.b);
        this.d.setImageDrawable(paramAvatarInfo);
      }
    }
    else
    {
      QLog.e("QQGuildAvatarSettingFragment", 1, "onDataSetChanged avatarInfo is null");
    }
  }
  
  private void d()
  {
    this.a = ((IGProGuildInfo)getActivity().getIntent().getExtras().getSerializable("extra_guild_guild_info"));
    if (this.a == null)
    {
      QQToast.makeText(MobileQQ.getContext(), 1, 2131890625, 1).show();
      getActivity().finish();
    }
    this.h = this.a.getGuildID();
    if (TextUtils.isEmpty(this.h))
    {
      QQToast.makeText(MobileQQ.getContext(), 1, 2131890625, 1).show();
      getActivity().finish();
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", this.a.getShowNumber());
    localBundle.putInt("type", 2);
    localBundle.putString("groupID", this.a.getGuildID());
    if (this.g != null)
    {
      this.c = new QQGuildAvatarSettingFragment.2(this, getContext(), getActivity(), this.g, localBundle);
      this.c.a(GuildUrlAction.a(0));
      this.c.a(true);
      this.c.a(this);
    }
    b(this.a);
    if (a() != null) {
      ((IGPSService)a().getRuntimeService(IGPSService.class, "")).addObserver(this.i);
    }
  }
  
  public AppInterface a()
  {
    if ((getQBaseActivity().getAppRuntime() instanceof AppInterface)) {
      return (AppInterface)getQBaseActivity().getAppRuntime();
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(AvatarInfo paramAvatarInfo) {}
  
  public void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildAvatarSettingFragment", 2, new Object[] { "onUpdateItem info:", paramAvatarInfo });
    }
  }
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((TroopAvatarController)localObject).h();
      AppInterface localAppInterface = this.g;
      if ((localAppInterface != null) && (this.a != null)) {
        ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).refleshGuildInfo(this.a.getGuildID());
      }
      c((AvatarInfo)localObject);
      QQToast.makeText(MobileQQ.getContext(), 2, 2131890626, 1).show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildAvatarSettingFragment", 2, "onDataSetChanged");
    }
  }
  
  public void b(AvatarInfo paramAvatarInfo) {}
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 257) {
        return;
      }
      paramIntent = this.c;
      if (paramIntent != null) {
        paramIntent.i();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b)
    {
      TroopAvatarController localTroopAvatarController = this.c;
      if (localTroopAvatarController != null) {
        localTroopAvatarController.b();
      }
    }
    else if (paramView == this.f)
    {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.e = ((RelativeLayout)paramLayoutInflater.inflate(2131624997, null));
    this.g = a();
    c();
    d();
    paramLayoutInflater = this.e;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    TroopAvatarController localTroopAvatarController = this.c;
    if (localTroopAvatarController != null)
    {
      localTroopAvatarController.b(this);
      this.c.e();
    }
    if (a() != null) {
      ((IGPSService)a().getRuntimeService(IGPSService.class, "")).deleteObserver(this.i);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildAvatarSettingFragment
 * JD-Core Version:    0.7.0.1
 */