package com.tencent.mobileqq.kandian.biz.atlas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJDisplayStyleManager;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.math.BigInteger;

public class ReadInJoyAtlasCommentFragment
  extends PublicBaseFragment
{
  private static String jdField_a_of_type_JavaLangString = "ReadInJoyAtlasCommentFragment";
  private int jdField_a_of_type_Int = -1;
  protected TranslateAnimation a;
  protected ReadInJoyCommentListFragment a;
  private CommonCommentData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData;
  private final ITKDHippyEventReceiver jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesReceiverITKDHippyEventReceiver = new ReadInJoyAtlasCommentFragment.6(this);
  protected AbsBaseArticleInfo a;
  protected boolean a;
  private int jdField_b_of_type_Int = 3;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public static AbsBaseArticleInfo a(Bundle paramBundle)
  {
    BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
    if (paramBundle != null)
    {
      paramBundle = (AbsBaseArticleInfo)paramBundle.getParcelable("articleInfo");
      if (paramBundle != null) {
        return paramBundle;
      }
    }
    return localBaseArticleInfo;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, AnchorData paramAnchorData, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    if (((paramContext instanceof Activity)) && (!TextUtils.isEmpty(paramString1)))
    {
      CommonCommentData localCommonCommentData = null;
      long l = 0L;
      int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("source", 3);
        l = paramBundle.getLong("recommendSeq", 0L);
        localObject = paramBundle.getSerializable("commonCommentData");
        if ((localObject instanceof CommonCommentData)) {
          localCommonCommentData = (CommonCommentData)localObject;
        }
      }
      else
      {
        localCommonCommentData = null;
        i = 3;
      }
      Object localObject = a(paramBundle);
      int j;
      if (i == 3) {
        j = 1;
      } else {
        j = 0;
      }
      ((AbsBaseArticleInfo)localObject).mIsGallery = j;
      ((AbsBaseArticleInfo)localObject).innerUniqueID = paramString1;
      ((AbsBaseArticleInfo)localObject).mTitle = paramString2;
      ((AbsBaseArticleInfo)localObject).mSummary = paramString3;
      ((AbsBaseArticleInfo)localObject).mFirstPagePicUrl = paramString4;
      ((AbsBaseArticleInfo)localObject).mRecommendSeq = l;
      boolean bool;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("canBiu", true);
      } else {
        bool = true;
      }
      if (!bool)
      {
        ((AbsBaseArticleInfo)localObject).mSocialFeedInfo = new SocializeFeedsInfo();
        ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.a = new PGCFeedsInfo();
        ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.a.jdField_a_of_type_Boolean = true;
      }
      if (localCommonCommentData != null)
      {
        if (a(localCommonCommentData, localCommonCommentData.getArticleId())) {
          try
          {
            ((AbsBaseArticleInfo)localObject).mArticleID = Long.parseLong(localCommonCommentData.getArticleId());
          }
          catch (NumberFormatException paramString1)
          {
            paramString1.printStackTrace();
          }
        }
        if (a(localCommonCommentData, localCommonCommentData.getFeedsId())) {
          ((AbsBaseArticleInfo)localObject).mFeedId = new BigInteger(localCommonCommentData.getFeedsId()).longValue();
        }
        if (a(localCommonCommentData, localCommonCommentData.getFeedsType())) {
          ((AbsBaseArticleInfo)localObject).mFeedType = localCommonCommentData.getFeedsType();
        }
      }
      paramString1 = new Intent();
      paramString1.putExtra("public_fragment_window_feature", 1);
      paramString1.putExtra("arg_article_info", (Parcelable)localObject);
      if (i == 3) {
        paramString1.putExtra("readinjoy_open_comment_from_atlas", true);
      }
      paramString1.putExtra("readinjoy_open_comment_with_edit_panel", paramBoolean1);
      paramString1.putExtra("source", i);
      paramString1.putExtra("mNeedImmersive", paramBoolean2);
      paramString1.putExtra("anchorData", paramAnchorData);
      paramString1.putExtra("commonCommentData", localCommonCommentData);
      if (paramBundle != null)
      {
        paramString1.putExtra("bundle", paramBundle);
        paramString1.putExtra("comment_layout_height", paramBundle.getInt("comment_layout_height", -1));
        paramString1.putExtra("bigT_report_entry", paramBundle.getInt("bigT_report_entry", -1));
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "readToStartComment");
      PublicFragmentActivity.Launcher.a((Activity)paramContext, paramString1, PublicTransFragmentActivity.class, ReadInJoyAtlasCommentFragment.class, 6003);
    }
  }
  
  private static boolean a(CommonCommentData paramCommonCommentData, int paramInt)
  {
    return (paramCommonCommentData != null) && (paramCommonCommentData.getFeedsType() != -1);
  }
  
  private static boolean a(CommonCommentData paramCommonCommentData, String paramString)
  {
    return (paramCommonCommentData != null) && (!TextUtils.isEmpty(paramString));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("mNeedImmersive", true);
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("comment_layout_height", -1);
    this.jdField_b_of_type_Int = getActivity().getIntent().getIntExtra("source", 3);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData = ((CommonCommentData)getActivity().getIntent().getSerializableExtra("commonCommentData"));
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)getBaseActivity().getIntent().getParcelableExtra("arg_article_info"));
    Object localObject = getActivity();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null)
      {
        localObject = ((Intent)localObject).getBundleExtra("bundle");
        if (localObject != null) {
          this.c = ((Bundle)localObject).getInt("seq");
        }
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_with_edit_panel", getBaseActivity().getIntent().getBooleanExtra("readinjoy_open_comment_with_edit_panel", false));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a((Bundle)localObject, new ReadInJoyAtlasCommentFragment.5(this), (ViewGroup)getView().findViewById(2131376067));
      localObject = getBaseActivity().getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131376067, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  private void d()
  {
    View localView = getView();
    if (localView != null) {
      localView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  public void a()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a().register(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesReceiverITKDHippyEventReceiver);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment != null)
    {
      AnchorData localAnchorData = (AnchorData)getBaseActivity().getIntent().getParcelableExtra("anchorData");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.c(2131376067);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(paramAbsBaseArticleInfo, localAnchorData, this.jdField_b_of_type_Int);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (localReadInJoyCommentListFragment != null)
    {
      int j = localReadInJoyCommentListFragment.b();
      int i;
      if (this.jdField_b_of_type_Boolean) {
        i = 0;
      } else {
        i = 5;
      }
      RIJTransMergeKanDianReport.a(0, j, i);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.onBackEvent();
      boolean bool1 = bool2;
      if (!bool2)
      {
        getView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        bool1 = true;
      }
      return bool1;
    }
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    b();
    paramLayoutInflater = jdField_a_of_type_JavaLangString;
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("oncreatView  mNeedImmersive = ");
    paramViewGroup.append(this.jdField_a_of_type_Boolean);
    QLog.d(paramLayoutInflater, 1, paramViewGroup.toString());
    if (getBaseActivity().mSystemBarComp == null)
    {
      getBaseActivity().setImmersiveStatus(0);
    }
    else
    {
      getBaseActivity().mSystemBarComp.setStatusBarDrawable(null);
      getBaseActivity().mSystemBarComp.setStatusBarColor(0);
      getBaseActivity().mSystemBarComp.setStatusColor(0);
    }
    paramLayoutInflater = new FrameLayout(getBaseActivity());
    paramViewGroup = new View(getBaseActivity());
    paramLayoutInflater.addView(paramViewGroup, new LinearLayout.LayoutParams(-1, -1));
    paramViewGroup.setOnClickListener(new ReadInJoyAtlasCommentFragment.1(this));
    paramLayoutInflater.post(new ReadInJoyAtlasCommentFragment.2(this));
    paramViewGroup = new FrameLayout(getBaseActivity());
    paramViewGroup.setId(2131376067);
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      paramBundle = ((IRIJDisplayStyleManager)QRoute.api(IRIJDisplayStyleManager.class)).getPhysicalDisplaySize(getBaseActivity());
      i = (int)(paramBundle[1] - paramBundle[0] / 16.0F * 9.0F);
      paramBundle = new FrameLayout.LayoutParams(UIUtils.a(getBaseActivity()), i);
      paramBundle.gravity = 80;
      paramLayoutInflater.addView(paramViewGroup, paramBundle);
    }
    else
    {
      i = UIUtils.c(getActivity()) - UIUtils.e(getActivity());
      int j = this.jdField_a_of_type_Int;
      if (j > 0) {
        i = j / 3;
      }
      paramBundle = new FrameLayout.LayoutParams(UIUtils.a(getActivity()), i);
      paramBundle.gravity = 80;
      paramLayoutInflater.addView(paramViewGroup, paramBundle);
    }
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(getBaseActivity(), 2130772046));
    paramViewGroup.setAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    TimeSliceHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
    getBaseActivity().getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
    ReadInJoyLogicEngineEventDispatcher.a().h();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(getBaseActivity(), 2130772015));
    paramView = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    if (paramView != null)
    {
      paramView.setAnimationListener(new ReadInJoyAtlasCommentFragment.3(this));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new LinearInterpolator());
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ReadInJoyAtlasCommentFragment.4(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasCommentFragment
 * JD-Core Version:    0.7.0.1
 */