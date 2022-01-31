import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.qphone.base.util.QLog;

public class rby
  implements rgv
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private rcc jdField_a_of_type_Rcc;
  private rmn jdField_a_of_type_Rmn;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public rby(FragmentActivity paramFragmentActivity, FragmentManager paramFragmentManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, rmn paramrmn, VideoFeedsPlayManager paramVideoFeedsPlayManager, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = paramFragmentManager;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    if (paramVideoFeedsRecyclerView != null) {
      paramVideoFeedsRecyclerView.a(this);
    }
    this.jdField_a_of_type_Rmn = paramrmn;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130772066));
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new LinearInterpolator());
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130772001));
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new rbz(this));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new LinearInterpolator());
    }
  }
  
  private void i()
  {
    try
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new rcb(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.d("adjustSystemUiVisibility", 1, localException.toString());
      localException.printStackTrace();
    }
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.jdField_a_of_type_Boolean) {
        this.b = true;
      }
    }
    while (!this.b) {
      return;
    }
    this.b = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void a(AnchorData paramAnchorData)
  {
    ArticleInfo localArticleInfo;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
    {
      c();
      if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      }
      rdm.a(this.jdField_a_of_type_AndroidViewViewGroup, 0, 100);
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
      {
        Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentById(2131364588);
        if ((localFragment instanceof ReadInJoyCommentListFragment)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = ((ReadInJoyCommentListFragment)localFragment);
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (localArticleInfo != null)) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = false;; bool = true)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(localArticleInfo, paramAnchorData, bool, 2);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (bdin.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(true);
      }
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Rcc != null) {
        this.jdField_a_of_type_Rcc.a(true);
      }
      return;
    }
  }
  
  public void a(rcc paramrcc)
  {
    this.jdField_a_of_type_Rcc = paramrcc;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = (rdm.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity) - this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    d();
    i();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = (rdm.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity) - this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(rha.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a((Bundle)localObject, new rca(this), this.jdField_a_of_type_AndroidViewViewGroup);
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
      ((FragmentTransaction)localObject).add(2131364588, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public void e()
  {
    a(null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0) && (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)) {
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(false);
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Rcc != null) {
        this.jdField_a_of_type_Rcc.a(false);
      }
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
    {
      e();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.d();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.c())) {
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rby
 * JD-Core Version:    0.7.0.1
 */