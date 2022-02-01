package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.nearby.NearbyVideoUtilsReal;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;

public class NearbyAuthVideoPlayerFragment
  extends PublicBaseFragment
  implements View.OnClickListener, URLDrawableDownListener, VideoDrawable.OnPlayRepeatListener
{
  public VideoDrawable a = null;
  public NearbyCardObserver b = new NearbyAuthVideoPlayerFragment.3(this);
  private String c;
  private String d;
  private String e;
  private int f;
  private String g;
  private boolean h;
  private int i = 0;
  private ImageView j;
  private TextView k;
  private URLImageView l;
  private URLImageView m;
  private LinearLayout n;
  private View o;
  private DynamicAvatarDownloadManager p;
  private DynamicAvatarManager q;
  private DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback r = new NearbyAuthVideoPlayerFragment.2(this);
  
  private void a()
  {
    this.c = getBaseActivity().getIntent().getStringExtra("file_send_path");
    this.d = getBaseActivity().getIntent().getStringExtra("video_url");
    this.e = getBaseActivity().getIntent().getStringExtra("video_thumb_url");
    this.g = getBaseActivity().getIntent().getStringExtra("uin");
    this.f = getBaseActivity().getIntent().getIntExtra("mode", 0);
    this.h = getBaseActivity().getIntent().getBooleanExtra("is_authentic", false);
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = getResources().getDrawable(2130853313);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mUseMemoryCache = false;
    if ((paramBoolean1) && (!TextUtils.isEmpty(this.e)))
    {
      paramString = URLDrawable.getDrawable(this.e);
      this.l.setImageDrawable(paramString);
      if (paramBoolean2)
      {
        this.n.setVisibility(0);
        this.j.setVisibility(8);
      }
      else
      {
        this.n.setVisibility(8);
        this.j.setVisibility(0);
      }
      this.l.setVisibility(0);
      this.m.setVisibility(8);
      return;
    }
    if (ShortVideoUtils.isVideoSoLibLoaded())
    {
      localObject = new VideoDrawable.VideoDrawableParams();
      ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject).mPlayAudioFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = 18;
      localURLDrawableOptions.mExtraInfo = localObject;
      localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        paramString = URLDrawable.getDrawable((File)localObject, localURLDrawableOptions);
        this.m.setImageDrawable(paramString);
      }
      else
      {
        paramString = URLDrawable.getDrawable(DynamicAvatarDownloadManager.d(paramString), localURLDrawableOptions);
        this.m.setImageDrawable(paramString);
      }
      this.n.setVisibility(8);
      this.j.setVisibility(8);
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      int i1 = 2;
      paramString = new StringBuilder();
      paramString.append("");
      if (this.f != 3) {
        i1 = 1;
      }
      paramString.append(i1);
      NearbyVideoUtilsReal.a("play_video", new String[] { paramString.toString(), this.g });
    }
  }
  
  private void b()
  {
    ((ImageView)this.o.findViewById(2131430817)).setOnClickListener(this);
    ImageView localImageView = (ImageView)this.o.findViewById(2131438855);
    localImageView.setOnClickListener(this);
    if (this.f == 3) {
      localImageView.setVisibility(8);
    } else {
      localImageView.setVisibility(0);
    }
    this.j = ((ImageView)this.o.findViewById(2131440374));
    this.k = ((TextView)this.o.findViewById(2131440606));
    this.l = ((URLImageView)this.o.findViewById(2131449520));
    this.m = ((URLImageView)this.o.findViewById(2131449462));
    this.n = ((LinearLayout)this.o.findViewById(2131437648));
    this.m.setURLDrawableDownListener(this);
    if ((this.f == 3) && (!this.h)) {
      this.k.setVisibility(0);
    } else {
      this.k.setVisibility(8);
    }
    if ((!TextUtils.isEmpty(this.c)) && (this.f == 2)) {
      a(this.c, false, false);
    } else if ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e))) {
      if (DynamicAvatarDownloadManager.e(this.d))
      {
        a(this.d, false, false);
      }
      else if (NetworkUtil.isWifiConnected(getBaseActivity()))
      {
        a(this.e, true, true);
        a(this.d);
      }
      else
      {
        a(this.e, true, false);
      }
    }
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  private void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.c(getBaseActivity(), null);
    localActionSheet.addButton(HardCodeUtil.a(2131904977), 1);
    localActionSheet.addButton(2131888438, 1);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new NearbyAuthVideoPlayerFragment.4(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  protected void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (getBaseActivity().app != null))
    {
      if (!NetworkUtil.isNetSupport(getBaseActivity()))
      {
        QQToast.makeText(getBaseActivity(), getString(2131892102), 0).show(getBaseActivity().getTitleBarHeight());
        return;
      }
      if (!isDetached())
      {
        if (getBaseActivity() == null) {
          return;
        }
        ThreadManager.post(new NearbyAuthVideoPlayerFragment.1(this, paramString), 5, null, true);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 11000) && (paramInt2 == -1))
    {
      if (this.f == 3) {
        this.k.setVisibility(8);
      }
      getBaseActivity().setResult(-1, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131440606: 
      if (!((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).showTakeAuthVideoGuideDialog(getActivity(), getBaseActivity().app))
      {
        ((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).showPtvPanel(getActivity(), getBaseActivity().app, 3);
        return;
      }
      break;
    case 2131440374: 
      if (DynamicAvatarDownloadManager.e(this.d))
      {
        paramView = ((URLDrawable)this.m.getDrawable()).getCurrDrawable();
        if ((paramView != null) && ((paramView instanceof VideoDrawable)))
        {
          ((VideoDrawable)paramView).resetAndPlayAudioCircle();
          return;
        }
        a(this.d, false, false);
        return;
      }
      a(this.d);
      return;
    case 2131438855: 
      c();
      return;
    case 2131430817: 
      getBaseActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getBaseActivity().getWindow().addFlags(128);
    this.o = paramLayoutInflater.inflate(2131625497, paramViewGroup, false);
    this.q = ((DynamicAvatarManager)getBaseActivity().app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER));
    this.p = this.q.e();
    paramLayoutInflater = this.p;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.a(this.r);
    }
    ShortVideoUtils.loadShortVideoSo(getBaseActivity().app);
    getBaseActivity().app.addObserver(this.b);
    a();
    b();
    return this.o;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getBaseActivity().app.removeObserver(this.b);
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    this.j.setVisibility(0);
    QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.a(2131904980), 0).show(getBaseActivity().getTitleBarHeight());
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.j.setVisibility(0);
    QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.a(2131904976), 0).show(getBaseActivity().getTitleBarHeight());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    this.j.setVisibility(0);
    QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.a(2131904979), 0).show(getBaseActivity().getTitleBarHeight());
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("URLDrawable load success, url=");
      paramView.append(this.d);
      QLog.i("NearbyAuthVideoPlayerFragment", 2, paramView.toString());
    }
    paramView = paramURLDrawable.getCurrDrawable();
    if (VideoDrawable.class.isInstance(paramView))
    {
      this.a = ((VideoDrawable)paramView);
      this.a.setOnPlayRepeatListener(this);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    NativeVideoImage.pauseAll();
    VideoDrawable localVideoDrawable = this.a;
    if (localVideoDrawable != null) {
      localVideoDrawable.stopAudio();
    }
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt > this.i)
    {
      int i1 = 2;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      if (this.f != 3) {
        i1 = 1;
      }
      localStringBuilder.append(i1);
      NearbyVideoUtilsReal.a("play_video", new String[] { localStringBuilder.toString(), this.g });
      this.i = paramInt;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NativeVideoImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment
 * JD-Core Version:    0.7.0.1
 */