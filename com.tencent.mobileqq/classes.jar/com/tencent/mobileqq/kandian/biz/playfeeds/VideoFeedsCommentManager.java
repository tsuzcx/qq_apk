package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.FirstCommentEvent;
import com.tencent.mobileqq.kandian.biz.comment.TKDCommentFragmentHelper;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class VideoFeedsCommentManager
  implements ListEventListener, ITKDHippyEventDispatcherOwner
{
  private int jdField_a_of_type_Int = 0;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment = null;
  private ITKDHippyEventDispatcher jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher = new TKDHippyEventDispatcher();
  private VideoFeedsCommentManager.CommentEventListener jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager$CommentEventListener = null;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager = null;
  private IAdapter jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIAdapter = null;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d;
  
  public VideoFeedsCommentManager(BaseActivity paramBaseActivity, FragmentManager paramFragmentManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, IAdapter paramIAdapter, VideoFeedsPlayManager paramVideoFeedsPlayManager, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = paramFragmentManager;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    if (paramVideoFeedsRecyclerView != null) {
      paramVideoFeedsRecyclerView.a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIAdapter = paramIAdapter;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130772111));
    paramBaseActivity = this.jdField_a_of_type_AndroidViewAnimationAnimationSet;
    if (paramBaseActivity != null)
    {
      paramBaseActivity.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new LinearInterpolator());
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130772015));
    paramBaseActivity = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    if (paramBaseActivity != null)
    {
      paramBaseActivity.setAnimationListener(new VideoFeedsCommentManager.1(this));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new LinearInterpolator());
    }
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment != null) && (TKDCommentFragmentHelper.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a());
  }
  
  private void j()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
    ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
    ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
    ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
    ((Bundle)localObject).putBoolean("is_from_viola", true);
    ((Bundle)localObject).putBoolean("readinjoy_open_comment_with_edit_panel", d());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(VideoFeedsResourceLoader.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a((Bundle)localObject, a(), this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a().merge(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher.clear();
    localObject = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
    ((FragmentTransaction)localObject).add(2131364984, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment);
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private void k()
  {
    if (!e()) {
      RIJUserLevelModule.getInstance().doActionsByUserLevel(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, new VideoFeedsCommentManager.4(this));
    }
  }
  
  private void l()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new VideoFeedsCommentManager.5(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.d("adjustSystemUiVisibility", 1, localException.toString());
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (localReadInJoyCommentListFragment != null) {
      return localReadInJoyCommentListFragment.a();
    }
    return -1;
  }
  
  @NotNull
  public ReadInJoyCommentUtils.FirstCommentEvent a()
  {
    return new VideoFeedsCommentManager.2(this);
  }
  
  public VideoInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = (VideoFeedsHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity) - this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    d();
    l();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment == null) {
      return;
    }
    int j = a();
    int i = 0;
    if (j == 2) {
      i = 1;
    }
    RIJTransMergeKanDianReport.a(i, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.b(), paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.jdField_a_of_type_Boolean) {
        this.c = true;
      }
    }
    else if (this.c)
    {
      this.c = false;
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void a(AnchorData paramAnchorData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment == null) {
      a();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
      {
        if (e())
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(paramAnchorData);
          if (d()) {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.b(true);
          }
        }
        c();
        localObject = this.jdField_a_of_type_AndroidViewAnimationAnimationSet;
        if (localObject != null) {
          this.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
        }
        localObject = this.jdField_a_of_type_AndroidViewViewGroup;
        boolean bool = false;
        VideoFeedsHelper.a((View)localObject, 0, 100);
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment == null)
        {
          BaseFragment localBaseFragment = (BaseFragment)this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.findFragmentById(2131364984);
          if ((localBaseFragment instanceof ReadInJoyCommentListFragment)) {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment = ((ReadInJoyCommentListFragment)localBaseFragment);
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment != null) && (localObject != null))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo == null) {
            bool = true;
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a((AbsBaseArticleInfo)localObject, paramAnchorData, bool, 2);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager != null) && (NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.g(true);
        }
        this.jdField_a_of_type_Boolean = true;
        paramAnchorData = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager$CommentEventListener;
        if (paramAnchorData != null) {
          paramAnchorData.a(true);
        }
        paramAnchorData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
        if (paramAnchorData != null) {
          paramAnchorData.g();
        }
      }
    }
  }
  
  public void a(VideoFeedsCommentManager.CommentEventListener paramCommentEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager$CommentEventListener = paramCommentEventListener;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
      if (localObject != null) {
        ((ReadInJoyCommentListFragment)localObject).e();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        }
        else
        {
          localObject = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
          if (localObject != null) {
            this.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
          }
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
      if (localObject != null) {
        ((VideoFeedsPlayManager)localObject).g(false);
      }
      this.jdField_a_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager$CommentEventListener;
      if (localObject != null) {
        ((VideoFeedsCommentManager.CommentEventListener)localObject).a(false);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
      if (localObject != null) {
        ((ReadInJoyCommentListFragment)localObject).h();
      }
    }
  }
  
  public boolean a()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    return (localReadInJoyCommentListFragment != null) && (!localReadInJoyCommentListFragment.d());
  }
  
  public void aC_() {}
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
    if (localLayoutParams != null)
    {
      localLayoutParams.height = (VideoFeedsHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity) - this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void d()
  {
    j();
  }
  
  public boolean d()
  {
    boolean bool = this.d;
    this.d = false;
    return bool;
  }
  
  public void e()
  {
    a(null);
  }
  
  public void f()
  {
    a(false);
  }
  
  public void g()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if ((localVideoInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
    {
      this.d = true;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment == null)
      {
        e();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(new VideoFeedsCommentManager.3(this));
        return;
      }
      e();
      k();
    }
  }
  
  @NonNull
  public ITKDHippyEventDispatcher getTKDHippyEventDispatcher()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (localReadInJoyCommentListFragment != null) {
      return localReadInJoyCommentListFragment.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher;
  }
  
  public void h()
  {
    if (a()) {
      f();
    }
  }
  
  public void i()
  {
    TranslateAnimation localTranslateAnimation = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    if (localTranslateAnimation != null)
    {
      localTranslateAnimation.setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    getTKDHippyEventDispatcher().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsCommentManager
 * JD-Core Version:    0.7.0.1
 */