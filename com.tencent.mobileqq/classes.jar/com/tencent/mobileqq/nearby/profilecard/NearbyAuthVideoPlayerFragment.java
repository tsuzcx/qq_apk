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
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public VideoDrawable a;
  private DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback = new NearbyAuthVideoPlayerFragment.2(this);
  private DynamicAvatarDownloadManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
  private DynamicAvatarManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager;
  public NearbyCardObserver a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  public NearbyAuthVideoPlayerFragment()
  {
    this.jdField_a_of_type_ComTencentImageVideoDrawable = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new NearbyAuthVideoPlayerFragment.3(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = getBaseActivity().getIntent().getStringExtra("file_send_path");
    this.jdField_b_of_type_JavaLangString = getBaseActivity().getIntent().getStringExtra("video_url");
    this.c = getBaseActivity().getIntent().getStringExtra("video_thumb_url");
    this.d = getBaseActivity().getIntent().getStringExtra("uin");
    this.jdField_a_of_type_Int = getBaseActivity().getIntent().getIntExtra("mode", 0);
    this.jdField_a_of_type_Boolean = getBaseActivity().getIntent().getBooleanExtra("is_authentic", false);
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = getResources().getDrawable(2130851081);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mUseMemoryCache = false;
    if ((paramBoolean1) && (!TextUtils.isEmpty(this.c)))
    {
      paramString = URLDrawable.getDrawable(this.c);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
      if (paramBoolean2)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
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
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
      }
      else
      {
        paramString = URLDrawable.getDrawable(DynamicAvatarDownloadManager.a(paramString), localURLDrawableOptions);
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      int i = 2;
      paramString = new StringBuilder();
      paramString.append("");
      if (this.jdField_a_of_type_Int != 3) {
        i = 1;
      }
      paramString.append(i);
      NearbyVideoUtilsReal.a("play_video", new String[] { paramString.toString(), this.d });
    }
  }
  
  private void b()
  {
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364711)).setOnClickListener(this);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371480);
    localImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 3) {
      localImageView.setVisibility(8);
    } else {
      localImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372825));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373027));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380563));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380505));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370381));
    this.jdField_b_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
    if ((this.jdField_a_of_type_Int == 3) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == 2)) {
      a(this.jdField_a_of_type_JavaLangString, false, false);
    } else if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.c))) {
      if (DynamicAvatarDownloadManager.b(this.jdField_b_of_type_JavaLangString))
      {
        a(this.jdField_b_of_type_JavaLangString, false, false);
      }
      else if (NetworkUtil.isWifiConnected(getBaseActivity()))
      {
        a(this.c, true, true);
        a(this.jdField_b_of_type_JavaLangString);
      }
      else
      {
        a(this.c, true, false);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    localActionSheet.addButton(HardCodeUtil.a(2131707142), 1);
    localActionSheet.addButton(2131691479, 1);
    localActionSheet.addCancelButton(2131690728);
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
        QQToast.a(getBaseActivity(), getString(2131694422), 0).b(getBaseActivity().getTitleBarHeight());
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
      if (this.jdField_a_of_type_Int == 3) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      getBaseActivity().setResult(-1, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131373027: 
      if (!((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).showTakeAuthVideoGuideDialog(getActivity(), getBaseActivity().app))
      {
        ((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).showPtvPanel(getActivity(), getBaseActivity().app, 3);
        return;
      }
      break;
    case 2131372825: 
      if (DynamicAvatarDownloadManager.b(this.jdField_b_of_type_JavaLangString))
      {
        paramView = ((URLDrawable)this.jdField_b_of_type_ComTencentImageURLImageView.getDrawable()).getCurrDrawable();
        if ((paramView != null) && ((paramView instanceof VideoDrawable)))
        {
          ((VideoDrawable)paramView).resetAndPlayAudioCircle();
          return;
        }
        a(this.jdField_b_of_type_JavaLangString, false, false);
        return;
      }
      a(this.jdField_b_of_type_JavaLangString);
      return;
    case 2131371480: 
      c();
      return;
    case 2131364711: 
      getBaseActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getBaseActivity().getWindow().addFlags(128);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559477, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager = ((DynamicAvatarManager)getBaseActivity().app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a();
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback);
    }
    ShortVideoUtils.loadShortVideoSo(getBaseActivity().app);
    getBaseActivity().app.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    a();
    b();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getBaseActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    QQToast.a(getBaseActivity(), 1, HardCodeUtil.a(2131707145), 0).b(getBaseActivity().getTitleBarHeight());
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    QQToast.a(getBaseActivity(), 1, HardCodeUtil.a(2131707141), 0).b(getBaseActivity().getTitleBarHeight());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    QQToast.a(getBaseActivity(), 1, HardCodeUtil.a(2131707144), 0).b(getBaseActivity().getTitleBarHeight());
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("URLDrawable load success, url=");
      paramView.append(this.jdField_b_of_type_JavaLangString);
      QLog.i("NearbyAuthVideoPlayerFragment", 2, paramView.toString());
    }
    paramView = paramURLDrawable.getCurrDrawable();
    if (VideoDrawable.class.isInstance(paramView))
    {
      this.jdField_a_of_type_ComTencentImageVideoDrawable = ((VideoDrawable)paramView);
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayRepeatListener(this);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    NativeVideoImage.pauseAll();
    VideoDrawable localVideoDrawable = this.jdField_a_of_type_ComTencentImageVideoDrawable;
    if (localVideoDrawable != null) {
      localVideoDrawable.stopAudio();
    }
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt > this.jdField_b_of_type_Int)
    {
      int i = 2;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      if (this.jdField_a_of_type_Int != 3) {
        i = 1;
      }
      localStringBuilder.append(i);
      NearbyVideoUtilsReal.a("play_video", new String[] { localStringBuilder.toString(), this.d });
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NativeVideoImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment
 * JD-Core Version:    0.7.0.1
 */