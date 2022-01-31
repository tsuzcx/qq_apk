package com.tencent.mobileqq.nearby.profilecard;

import ajya;
import alyp;
import alyr;
import alyy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import atbt;
import atcd;
import atom;
import aton;
import atoo;
import bbfj;
import bcql;
import bfpc;
import bfpp;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class NearbyAuthVideoPlayerFragment
  extends PublicBaseFragment
  implements View.OnClickListener, URLDrawableDownListener, VideoDrawable.OnPlayRepeatListener
{
  private int jdField_a_of_type_Int;
  private alyp jdField_a_of_type_Alyp;
  private alyr jdField_a_of_type_Alyr = new atom(this);
  private alyy jdField_a_of_type_Alyy;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public atcd a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public VideoDrawable a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  public NearbyAuthVideoPlayerFragment()
  {
    this.jdField_a_of_type_Atcd = new aton(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("file_send_path");
    this.jdField_b_of_type_JavaLangString = getActivity().getIntent().getStringExtra("video_url");
    this.c = getActivity().getIntent().getStringExtra("video_thumb_url");
    this.d = getActivity().getIntent().getStringExtra("uin");
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("mode", 0);
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("is_authentic", false);
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    Object localObject = getResources().getDrawable(2130849561);
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
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
    while (!ShortVideoUtils.a()) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramString = new StringBuilder().append("");
      if (this.jdField_a_of_type_Int != 3) {
        break label309;
      }
    }
    for (;;)
    {
      atbt.a("play_video", new String[] { i, this.d });
      return;
      paramString = URLDrawable.getDrawable(alyp.a(paramString), localURLDrawableOptions);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
      break;
      label309:
      i = 1;
    }
  }
  
  private void b()
  {
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364268)).setOnClickListener(this);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370404);
    localImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 3)
    {
      localImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371738));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371902));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378948));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378909));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369500));
      this.jdField_b_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if ((this.jdField_a_of_type_Int != 3) || (this.jdField_a_of_type_Boolean)) {
        break label212;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label159:
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Int != 2)) {
        break label224;
      }
      a(this.jdField_a_of_type_JavaLangString, false, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
      localImageView.setVisibility(0);
      break;
      label212:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label159;
      label224:
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.c))) {
        if (alyp.b(this.jdField_b_of_type_JavaLangString))
        {
          a(this.jdField_b_of_type_JavaLangString, false, false);
        }
        else if (bbfj.h(getActivity()))
        {
          a(this.c, true, true);
          a(this.jdField_b_of_type_JavaLangString);
        }
        else
        {
          a(this.c, true, false);
        }
      }
    }
  }
  
  private void c()
  {
    bfpc localbfpc = (bfpc)bfpp.b(getActivity(), null);
    localbfpc.a(ajya.a(2131707114), 1);
    localbfpc.a(2131691507, 1);
    localbfpc.c(2131690596);
    localbfpc.a(new atoo(this, localbfpc));
    if (!localbfpc.isShowing()) {
      localbfpc.show();
    }
  }
  
  protected void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (getActivity().app != null))
    {
      if (bbfj.d(getActivity())) {
        break label54;
      }
      bcql.a(getActivity(), getString(2131694608), 0).b(getActivity().getTitleBarHeight());
    }
    label54:
    while ((isDetached()) || (getActivity() == null)) {
      return;
    }
    ThreadManager.post(new NearbyAuthVideoPlayerFragment.1(this, paramString), 5, null, true);
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
      if (this.jdField_a_of_type_Int != 3) {
        break label39;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      getActivity().setResult(-1, paramIntent);
      return;
      label39:
      String str = paramIntent.getStringExtra("video_path");
      if (!TextUtils.isEmpty(str)) {
        a(str, false, false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      getActivity().finish();
      return;
      c();
      return;
      if (alyp.b(this.jdField_b_of_type_JavaLangString))
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
    } while (atbt.a(getActivity(), getActivity().app));
    atbt.a(getActivity(), getActivity().app, 3);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getActivity().getWindow().addFlags(128);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559322, paramViewGroup, false);
    this.jdField_a_of_type_Alyy = ((alyy)getActivity().app.getManager(180));
    this.jdField_a_of_type_Alyp = this.jdField_a_of_type_Alyy.a();
    if (this.jdField_a_of_type_Alyp != null) {
      this.jdField_a_of_type_Alyp.a(this.jdField_a_of_type_Alyr);
    }
    ShortVideoUtils.a(getActivity().app);
    getActivity().app.addObserver(this.jdField_a_of_type_Atcd);
    a();
    b();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().app.removeObserver(this.jdField_a_of_type_Atcd);
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    bcql.a(getActivity(), 1, ajya.a(2131707117), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    bcql.a(getActivity(), 1, ajya.a(2131707113), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    bcql.a(getActivity(), 1, ajya.a(2131707116), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAuthVideoPlayerFragment", 2, "URLDrawable load success, url=" + this.jdField_b_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null) {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.stopAudio();
    }
  }
  
  public void onPlayRepeat(int paramInt)
  {
    int i = 2;
    StringBuilder localStringBuilder;
    if (paramInt > this.jdField_b_of_type_Int)
    {
      localStringBuilder = new StringBuilder().append("");
      if (this.jdField_a_of_type_Int != 3) {
        break label64;
      }
    }
    for (;;)
    {
      atbt.a("play_video", new String[] { i, this.d });
      this.jdField_b_of_type_Int = paramInt;
      return;
      label64:
      i = 1;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NativeVideoImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment
 * JD-Core Version:    0.7.0.1
 */