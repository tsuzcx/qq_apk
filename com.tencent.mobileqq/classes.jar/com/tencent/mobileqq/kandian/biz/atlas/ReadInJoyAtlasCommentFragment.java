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
import com.tencent.mobileqq.kandian.base.utils.RIJDisplayStyleManager;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.math.BigInteger;

public class ReadInJoyAtlasCommentFragment
  extends PublicBaseFragment
{
  private static String e = "ReadInJoyAtlasCommentFragment";
  protected ReadInJoyCommentListFragment a;
  protected AbsBaseArticleInfo b;
  protected TranslateAnimation c;
  protected boolean d;
  private TranslateAnimation f;
  private CommonCommentData g;
  private int h = -1;
  private int i = 3;
  private int j;
  private boolean k = true;
  private boolean l;
  private final ITKDHippyEventReceiver m = new ReadInJoyAtlasCommentFragment.6(this);
  
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
      long l1 = 0L;
      int n;
      if (paramBundle != null)
      {
        n = paramBundle.getInt("source", 3);
        l1 = paramBundle.getLong("recommendSeq", 0L);
        localObject = paramBundle.getSerializable("commonCommentData");
        if ((localObject instanceof CommonCommentData)) {
          localCommonCommentData = (CommonCommentData)localObject;
        }
      }
      else
      {
        localCommonCommentData = null;
        n = 3;
      }
      Object localObject = a(paramBundle);
      int i1;
      if (n == 3) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      ((AbsBaseArticleInfo)localObject).mIsGallery = i1;
      ((AbsBaseArticleInfo)localObject).innerUniqueID = paramString1;
      ((AbsBaseArticleInfo)localObject).mTitle = paramString2;
      ((AbsBaseArticleInfo)localObject).mSummary = paramString3;
      ((AbsBaseArticleInfo)localObject).mFirstPagePicUrl = paramString4;
      ((AbsBaseArticleInfo)localObject).mRecommendSeq = l1;
      boolean bool;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("canBiu", true);
      } else {
        bool = true;
      }
      if (!bool)
      {
        ((AbsBaseArticleInfo)localObject).mSocialFeedInfo = new SocializeFeedsInfo();
        ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.t = new PGCFeedsInfo();
        ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.t.f = true;
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
      if (n == 3) {
        paramString1.putExtra("readinjoy_open_comment_from_atlas", true);
      }
      paramString1.putExtra("readinjoy_open_comment_with_edit_panel", paramBoolean1);
      paramString1.putExtra("source", n);
      paramString1.putExtra("mNeedImmersive", paramBoolean2);
      paramString1.putExtra("anchorData", paramAnchorData);
      paramString1.putExtra("commonCommentData", localCommonCommentData);
      if (paramBundle != null)
      {
        paramString1.putExtra("bundle", paramBundle);
        paramString1.putExtra("comment_layout_height", paramBundle.getInt("comment_layout_height", -1));
        paramString1.putExtra("bigT_report_entry", paramBundle.getInt("bigT_report_entry", -1));
      }
      QLog.d(e, 1, "readToStartComment");
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
  
  private void c()
  {
    this.d = getActivity().getIntent().getBooleanExtra("mNeedImmersive", true);
    this.h = getActivity().getIntent().getIntExtra("comment_layout_height", -1);
    this.i = getActivity().getIntent().getIntExtra("source", 3);
    this.g = ((CommonCommentData)getActivity().getIntent().getSerializableExtra("commonCommentData"));
    this.b = ((AbsBaseArticleInfo)getBaseActivity().getIntent().getParcelableExtra("arg_article_info"));
    Object localObject = getActivity();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null)
      {
        localObject = ((Intent)localObject).getBundleExtra("bundle");
        if (localObject != null)
        {
          this.j = ((Bundle)localObject).getInt("seq");
          this.k = ((Bundle)localObject).getBoolean("showShare", true);
        }
      }
    }
  }
  
  private void d()
  {
    if (this.a == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_with_edit_panel", getBaseActivity().getIntent().getBooleanExtra("readinjoy_open_comment_with_edit_panel", false));
      this.a = new ReadInJoyCommentListFragment();
      this.a.a(this.g);
      this.a.a(this.i);
      this.a.a((Bundle)localObject, new ReadInJoyAtlasCommentFragment.5(this), (ViewGroup)getView().findViewById(2131444267));
      localObject = getBaseActivity().getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131444267, this.a);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  private void e()
  {
    View localView = getView();
    if (localView != null) {
      localView.startAnimation(this.c);
    }
  }
  
  public void a()
  {
    d();
    this.a.b().register(this.m);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.a != null)
    {
      AnchorData localAnchorData = (AnchorData)getBaseActivity().getIntent().getParcelableExtra("anchorData");
      this.a.d(2131444267);
      this.a.a(paramAbsBaseArticleInfo, localAnchorData, this.i, this.k);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.a;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.a;
    if (localReadInJoyCommentListFragment != null)
    {
      int i1 = localReadInJoyCommentListFragment.n();
      int n;
      if (this.l) {
        n = 0;
      } else {
        n = 5;
      }
      RIJTransMergeKanDianReport.a(0, i1, n);
      boolean bool2 = this.a.onBackEvent();
      boolean bool1 = bool2;
      if (!bool2)
      {
        getView().startAnimation(this.c);
        bool1 = true;
      }
      return bool1;
    }
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    c();
    paramLayoutInflater = e;
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("oncreatView  mNeedImmersive = ");
    paramViewGroup.append(this.d);
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
    paramViewGroup.setId(2131444267);
    int n;
    if (this.d)
    {
      paramBundle = RIJDisplayStyleManager.INSTANCE.getPhysicalDisplaySize(getBaseActivity());
      n = (int)(paramBundle[1] - paramBundle[0] / 16.0F * 9.0F);
      paramBundle = new FrameLayout.LayoutParams(UIUtils.b(getBaseActivity()), n);
      paramBundle.gravity = 80;
      paramLayoutInflater.addView(paramViewGroup, paramBundle);
    }
    else
    {
      n = UIUtils.d(getActivity()) - UIUtils.f(getActivity());
      int i1 = this.h;
      if (i1 > 0) {
        n = i1 / 3;
      }
      paramBundle = new FrameLayout.LayoutParams(UIUtils.b(getActivity()), n);
      paramBundle.gravity = 80;
      paramLayoutInflater.addView(paramViewGroup, paramBundle);
    }
    this.f = ((TranslateAnimation)AnimationUtils.loadAnimation(getBaseActivity(), 2130772063));
    paramViewGroup.setAnimation(this.f);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    TimeSliceHelper.c(this.b.innerUniqueID);
    getBaseActivity().getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
    ReadInJoyLogicEngineEventDispatcher.a().h();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
    this.c = ((TranslateAnimation)AnimationUtils.loadAnimation(getBaseActivity(), 2130772018));
    paramView = this.c;
    if (paramView != null)
    {
      paramView.setAnimationListener(new ReadInJoyAtlasCommentFragment.3(this));
      this.c.setDuration(300L);
      this.c.setInterpolator(new LinearInterpolator());
    }
    if (this.f != null)
    {
      a(this.b);
      this.f.setAnimationListener(new ReadInJoyAtlasCommentFragment.4(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasCommentFragment
 * JD-Core Version:    0.7.0.1
 */