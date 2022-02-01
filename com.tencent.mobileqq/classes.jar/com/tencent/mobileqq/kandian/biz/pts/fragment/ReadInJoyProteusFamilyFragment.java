package com.tencent.mobileqq.kandian.biz.pts.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyProteusFamilyViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil;
import com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil.OnProteusFamilyDataLoaded;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ReadInJoyProteusFamilyFragment
  extends IphoneTitleBarFragment
  implements ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener, ReadInJoyProteusFamilyUtil.OnProteusFamilyDataLoaded
{
  private ReadInJoyProteusFamilyViewController a;
  private Context b;
  private TextView c;
  
  private void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      this.a = new ReadInJoyProteusFamilyViewController((Activity)localObject);
      localObject = (ViewGroup)this.mContentView.findViewById(2131440778);
      this.a.a((ViewGroup)localObject);
      b();
    }
  }
  
  private void a(int paramInt)
  {
    if (this.leftView != null)
    {
      this.leftView.setTextColor(paramInt);
      this.leftView.setBackgroundResource(2130851519);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(paramInt);
    }
  }
  
  private void b()
  {
    setTitle(this.b.getString(2131915470));
    RIJAppSetting.a(getTitleBarView());
    a(-16777216);
    Object localObject = this.rightViewImg;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageResource(2130843914);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(0);
      ((ImageView)localObject).setOnClickListener(new ReadInJoyProteusFamilyFragment.2(this, (ImageView)localObject));
    }
    localObject = getTitleBarView();
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new ReadInJoyProteusFamilyFragment.3(this));
    }
  }
  
  public void a(BaseActivity paramBaseActivity, View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[3];
    int[] tmp16_14 = arrayOfInt;
    tmp16_14[0] = 0;
    int[] tmp20_16 = tmp16_14;
    tmp20_16[1] = 1;
    int[] tmp24_20 = tmp20_16;
    tmp24_20[2] = 2;
    tmp24_20;
    String str1 = BaseApplicationImpl.getApplication().getString(2131915470);
    String str2 = BaseApplicationImpl.getApplication().getString(2131915470);
    String str3 = BaseApplicationImpl.getApplication().getString(2131915470);
    int i = 0;
    while (i < arrayOfInt.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = arrayOfInt[i];
      localMenuItem.title = new String[] { str1, str2, str3 }[i];
      localMenuItem.iconId = new int[] { 2130843907, 2130843908, 2130843907 }[i];
      localArrayList.add(localMenuItem);
      i += 1;
    }
    i = ViewUtils.dip2px(125.0F);
    PopupMenuDialog.build(paramBaseActivity, localArrayList, new ReadInJoyProteusFamilyFragment.4(this), new ReadInJoyProteusFamilyFragment.5(this), i, false, -1, 2131951651).showAsDropDown(paramView, -(i - paramView.getWidth()), 0);
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.c;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
    this.c.setVisibility(0);
  }
  
  public void a(boolean paramBoolean, List<AbsBaseArticleInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      ThreadManager.getUIHandler().post(new ReadInJoyProteusFamilyFragment.1(this, paramList));
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    this.a.cT_();
    this.c = ((TextView)this.mContentView.findViewById(2131433080));
    ReadInJoyDropFrameHelper.d().a(8888, this);
  }
  
  protected int getContentLayoutId()
  {
    return 2131626307;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.a;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getBaseActivity();
    ReadInJoyProteusFamilyUtil.c().a(this);
    ReadInJoyProteusFamilyUtil.c().d();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyProteusFamilyUtil.c().f();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.a;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.e();
    }
    ReadInJoyDropFrameHelper.d().b(8888, this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.a;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.a;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.h();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.a;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.i();
    }
    RIJAppSetting.a(getBaseActivity(), true, RIJAppSetting.a(getBaseActivity()));
  }
  
  public void onStart()
  {
    super.onStart();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.a;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.f();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ReadInJoyProteusFamilyViewController localReadInJoyProteusFamilyViewController = this.a;
    if (localReadInJoyProteusFamilyViewController != null) {
      localReadInJoyProteusFamilyViewController.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.fragment.ReadInJoyProteusFamilyFragment
 * JD-Core Version:    0.7.0.1
 */