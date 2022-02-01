package com.tencent.mobileqq.guild.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.tencent.mobileqq.guild.setting.controller.QQGuildPhotoController;
import com.tencent.mobileqq.guild.util.GuildCoverUtils;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
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

public class QQGuildCoverSettingFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, TroopPhotoController.OnDataChangeListener
{
  private IGProGuildInfo a;
  private Button b;
  private LinearLayout c;
  private QQGuildPhotoController d;
  private URLImageView e;
  private RelativeLayout f;
  private TextView g;
  private TextView h;
  private ImageView i;
  private AppInterface j;
  private String k;
  private GPServiceObserver l = new QQGuildCoverSettingFragment.1(this);
  
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
    if (this.d == null) {
      return;
    }
    this.b.setVisibility(8);
    this.c.setVisibility(0);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQGuildCoverSettingFragment", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.d.b(str, paramIntent);
    }
  }
  
  private void b(IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramIGProGuildInfo != null)
    {
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      Object localObject = GuildCoverUtils.b(getActivity(), 102);
      this.e.getLayoutParams().height = ((Point)localObject).y;
      if ((paramIGProGuildInfo.getCoverUrl(0, 0) != null) && (paramIGProGuildInfo.getCoverUrl(0, 0).length() != 0))
      {
        this.e.setBackgroundColor(getResources().getColor(2131165564));
        this.h.setVisibility(4);
        paramIGProGuildInfo = paramIGProGuildInfo.getCoverUrl(0, 0);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
        int m = (int)DeviceInfoUtil.D();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = m;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = m;
        try
        {
          paramIGProGuildInfo = URLDrawable.getDrawable(paramIGProGuildInfo, (URLDrawable.URLDrawableOptions)localObject);
          this.e.setImageDrawable(paramIGProGuildInfo);
          paramIGProGuildInfo.setTag(new int[] { m, m });
          paramIGProGuildInfo.setDecodeHandler(QQGuildUtil.d);
          return;
        }
        catch (Exception paramIGProGuildInfo)
        {
          QLog.e("QQGuildCoverSettingFragment", 1, paramIGProGuildInfo, new Object[0]);
          return;
        }
      }
      this.e.setBackgroundColor(getResources().getColor(2131166207));
      this.h.setVisibility(0);
    }
  }
  
  private void c()
  {
    this.b = ((Button)this.f.findViewById(2131429822));
    this.b.setOnClickListener(this);
    this.b.setVisibility(0);
    this.c = ((LinearLayout)this.f.findViewById(2131429826));
    this.c.setVisibility(8);
    this.e = ((URLImageView)this.f.findViewById(2131434591));
    this.g = ((TextView)this.f.findViewById(2131434595));
    this.i = ((ImageView)this.f.findViewById(2131431465));
    this.h = ((TextView)this.f.findViewById(2131434592));
    this.i.setOnClickListener(this);
    ((RelativeLayout.LayoutParams)this.e.getLayoutParams()).height = ((int)DeviceInfoUtil.D());
  }
  
  private void c(AvatarInfo paramAvatarInfo)
  {
    if (paramAvatarInfo != null)
    {
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      if (paramAvatarInfo.i != null)
      {
        this.e.setImageDrawable(new BitmapDrawable(paramAvatarInfo.i));
        return;
      }
      int m;
      if ((!TextUtils.isEmpty(paramAvatarInfo.c)) && (new File(paramAvatarInfo.c).exists()))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
        paramAvatarInfo = URLDrawable.getDrawable(new File(paramAvatarInfo.c), localURLDrawableOptions);
        this.e.setImageDrawable(paramAvatarInfo);
        m = (int)DeviceInfoUtil.D();
        paramAvatarInfo.setTag(new int[] { m, m });
        paramAvatarInfo.setDecodeHandler(QQGuildUtil.d);
        return;
      }
      if (this.a != null)
      {
        paramAvatarInfo = URLDrawable.URLDrawableOptions.obtain();
        paramAvatarInfo.mLoadingDrawable = URLDrawableHelperConstants.a;
        paramAvatarInfo = URLDrawable.getDrawable(this.a.getCoverUrl(0, 0), paramAvatarInfo);
        m = (int)DeviceInfoUtil.D();
        paramAvatarInfo.setTag(new int[] { m, m });
        paramAvatarInfo.setDecodeHandler(QQGuildUtil.d);
        this.e.setImageDrawable(paramAvatarInfo);
      }
    }
    else
    {
      QLog.e("QQGuildCoverSettingFragment", 1, "onDataSetChanged avatarInfo is null");
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
    this.k = this.a.getGuildID();
    if (TextUtils.isEmpty(this.k))
    {
      QQToast.makeText(MobileQQ.getContext(), 1, 2131890625, 1).show();
      getActivity().finish();
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", this.a.getShowNumber());
    localBundle.putInt("type", 2);
    localBundle.putString("groupID", this.a.getGuildID());
    if (this.j != null)
    {
      this.d = new QQGuildPhotoController(getContext(), getActivity(), this.j, localBundle);
      this.d.a(GuildUrlAction.a(1));
      this.d.a(true);
      this.d.a(this);
    }
    b(this.a);
    if (a() != null) {
      ((IGPSService)a().getRuntimeService(IGPSService.class, "")).addObserver(this.l);
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
      QLog.d("QQGuildCoverSettingFragment", 2, new Object[] { "onUpdateItem info:", paramAvatarInfo });
    }
  }
  
  public void b()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((QQGuildPhotoController)localObject).h();
      AppInterface localAppInterface = this.j;
      if ((localAppInterface != null) && (this.a != null)) {
        ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).refleshGuildInfo(this.a.getGuildID());
      }
      c((AvatarInfo)localObject);
      QQToast.makeText(MobileQQ.getContext(), 2, 2131890626, 1).show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildCoverSettingFragment", 2, "onDataSetChanged");
    }
  }
  
  public void b(AvatarInfo paramAvatarInfo)
  {
    this.b.setVisibility(0);
    this.c.setVisibility(8);
  }
  
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
      paramIntent = this.d;
      if (paramIntent != null) {
        paramIntent.i();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b)
    {
      QQGuildPhotoController localQQGuildPhotoController = this.d;
      if (localQQGuildPhotoController != null) {
        localQQGuildPhotoController.b();
      }
    }
    else if (paramView == this.i)
    {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.f = ((RelativeLayout)paramLayoutInflater.inflate(2131625043, null));
    this.j = a();
    c();
    d();
    paramLayoutInflater = this.f;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQGuildPhotoController localQQGuildPhotoController = this.d;
    if (localQQGuildPhotoController != null)
    {
      localQQGuildPhotoController.b(this);
      this.d.e();
    }
    if (a() != null) {
      ((IGPSService)a().getRuntimeService(IGPSService.class, "")).deleteObserver(this.l);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildCoverSettingFragment
 * JD-Core Version:    0.7.0.1
 */