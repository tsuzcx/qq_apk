package com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.kandian.biz.comment.TKDCommentFragmentHelper;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Random;
import org.json.JSONObject;

public class ViolaCommentManager
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment = null;
  private final ITKDHippyEventReceiver jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesReceiverITKDHippyEventReceiver;
  @Nullable
  private VVideoView jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView;
  private ViolaCommentManager.CommentEventListener jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager$CommentEventListener = null;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  @Nullable
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_b_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean = false;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int[] jdField_c_of_type_ArrayOfInt;
  private int d = 0;
  private int e;
  
  public ViolaCommentManager(QBaseActivity paramQBaseActivity, FragmentManager paramFragmentManager, int paramInt, ViewGroup paramViewGroup, TopGestureLayout paramTopGestureLayout, JSONObject paramJSONObject)
  {
    int i;
    if (LiuHaiUtils.b()) {
      i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    } else {
      i = 0;
    }
    this.e = i;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesReceiverITKDHippyEventReceiver = new ViolaCommentManager.11(this);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = paramFragmentManager;
    paramFragmentManager = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    boolean bool = true;
    this.jdField_c_of_type_Int = (paramFragmentManager[1] / 3);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramQBaseActivity);
    this.jdField_a_of_type_AndroidViewView = new View(paramQBaseActivity);
    this.jdField_a_of_type_AndroidViewView.setId(2131363349);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, -1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramQBaseActivity);
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_AndroidViewViewGroup.setId(View.generateViewId());
    } else {
      this.jdField_a_of_type_AndroidViewViewGroup.setId(new Random().nextInt());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, -1, -2);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).gravity = 80;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    if (paramTopGestureLayout != null) {
      paramTopGestureLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -1, -1);
    } else {
      paramTopGestureLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    }
    if (paramViewGroup != null) {
      paramViewGroup.addView(paramTopGestureLayout, -1, -1);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow().addContentView(paramTopGestureLayout, new WindowManager.LayoutParams(-1, -1));
    }
    if (paramJSONObject.optInt("directComment") != 1) {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    a();
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = new int[2];
      }
      paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    }
  }
  
  private void a(VVideoView paramVVideoView, View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    b(paramVVideoView, paramView);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    paramVVideoView = this.jdField_b_of_type_AndroidViewViewGroup;
    if (paramVVideoView != null) {
      paramVVideoView.addView(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams = null;
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_b_of_type_ArrayOfInt = null;
  }
  
  private void a(VVideoView paramVVideoView, View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView = paramVVideoView;
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(paramInt));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewView, 0, 300);
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, 0, 300);
    int[] arrayOfInt1 = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    int i;
    int j;
    if (paramView != null)
    {
      this.jdField_b_of_type_AndroidViewView = paramView;
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.getParent());
      this.jdField_a_of_type_Int = this.jdField_b_of_type_AndroidViewViewGroup.indexOfChild(paramView);
      this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams = paramView.getLayoutParams();
      a(paramView);
      int[] arrayOfInt2;
      if (this.d == 0)
      {
        arrayOfInt2 = this.jdField_a_of_type_ArrayOfInt;
        arrayOfInt2[1] -= this.jdField_b_of_type_Int;
      }
      this.jdField_b_of_type_ArrayOfInt = new int[] { paramView.getWidth(), paramView.getHeight() };
      b(paramVVideoView, paramView);
      int k;
      if (this.d == 1)
      {
        f();
        paramInt = this.jdField_c_of_type_Int;
        i = (int)(paramView.getWidth() / paramView.getHeight() * paramInt);
        j = (arrayOfInt1[0] - i) / 2;
        k = this.e;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, 1, new FrameLayout.LayoutParams(paramView.getWidth(), paramView.getHeight()));
        paramView.addOnLayoutChangeListener(new ViolaCommentManager.2(this, paramVVideoView, paramView, new int[] { j, k }, i, paramInt));
      }
      else
      {
        paramInt = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)[0];
        i = (int)(paramView.getHeight() / paramView.getWidth() * paramInt);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, 1, new FrameLayout.LayoutParams(-1, i));
        VideoFeedsHelper.a(paramView, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, new int[] { 0, this.e }, new int[] { paramInt, i }, 300L, true);
        paramVVideoView = this.jdField_a_of_type_AndroidViewViewGroup;
        paramInt = this.jdField_a_of_type_ArrayOfInt[1];
        i = this.jdField_b_of_type_ArrayOfInt[1];
        arrayOfInt1 = this.jdField_c_of_type_ArrayOfInt;
        j = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)[1];
        arrayOfInt2 = this.jdField_c_of_type_ArrayOfInt;
        k = arrayOfInt2[1];
        VideoFeedsHelper.a(paramVVideoView, new int[] { 0, paramInt + i }, arrayOfInt1, new int[] { 0, j - k }, arrayOfInt2, 300L, true);
        paramView.addOnLayoutChangeListener(new ViolaCommentManager.3(this));
      }
    }
    else
    {
      paramVVideoView = this.jdField_a_of_type_AndroidViewViewGroup;
      paramInt = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)[1];
      paramView = this.jdField_c_of_type_ArrayOfInt;
      i = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)[1];
      arrayOfInt1 = this.jdField_c_of_type_ArrayOfInt;
      j = arrayOfInt1[1];
      VideoFeedsHelper.a(paramVVideoView, new int[] { 0, paramInt }, paramView, new int[] { 0, i - j }, arrayOfInt1, 300L, true);
    }
    paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (paramVVideoView != null) {
      paramVVideoView.g();
    }
  }
  
  private void a(VVideoView paramVVideoView, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_b_of_type_Boolean) {
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewView, 8, 0);
    } else {
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewView, 8, 300);
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, 8, 300);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.jdField_a_of_type_AndroidViewViewGroup.getWidth();
    arrayOfInt[1] = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    Object localObject;
    if ((!paramBoolean) && (paramView != null))
    {
      localObject = new int[2];
      localObject[0] = 0;
      localObject[1] = (this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_b_of_type_ArrayOfInt[1]);
    }
    else
    {
      localObject = new int[2];
      localObject[0] = 0;
      localObject[1] = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)[1];
    }
    if (!paramBoolean) {
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, new int[] { 0, VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)[1] - this.jdField_a_of_type_AndroidViewViewGroup.getHeight() }, arrayOfInt, (int[])localObject, arrayOfInt, 300L, true);
    }
    if (paramView != null)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        b(paramVVideoView, paramView);
        localObject = this.jdField_b_of_type_AndroidViewViewGroup;
        if (localObject != null) {
          ((ViewGroup)localObject).addView(paramView, this.jdField_a_of_type_Int, paramView.getLayoutParams());
        }
      }
      int i;
      int j;
      int k;
      if (this.d == 1)
      {
        localObject = new int[2];
        paramView.getLocationInWindow((int[])localObject);
        i = localObject[0];
        j = localObject[1];
        k = (int)(paramView.getWidth() * paramView.getScaleX());
        int m = (int)(paramView.getHeight() * paramView.getScaleY());
        localObject = this.jdField_a_of_type_ArrayOfInt;
        arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
        localObject = VideoFeedsHelper.a(paramView, new int[] { i, j }, new int[] { k, m }, (int[])localObject, arrayOfInt, 300L, false);
        ((Animator)localObject).addListener(new ViolaCommentManager.4(this, paramVVideoView, paramView));
        ((Animator)localObject).start();
      }
      else
      {
        i = this.e;
        j = paramView.getWidth();
        k = paramView.getHeight();
        localObject = this.jdField_a_of_type_ArrayOfInt;
        arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
        localObject = VideoFeedsHelper.a(paramView, new int[] { 0, i }, new int[] { j, k }, (int[])localObject, arrayOfInt, 300L, false);
        ((Animator)localObject).addListener(new ViolaCommentManager.5(this, paramVVideoView, paramView));
        ((Animator)localObject).start();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView = null;
    }
    paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (paramVVideoView != null) {
      paramVVideoView.h();
    }
  }
  
  private void b(VVideoView paramVVideoView, View paramView)
  {
    if (paramVVideoView != null) {
      paramVVideoView.b();
    }
    if ((paramView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    if (paramVVideoView != null) {
      paramVVideoView.c();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.e();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hideFirstCommentList: isSlideDown=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("ViolaCommentManager", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView == null)
      {
        localObject = this.jdField_b_of_type_AndroidViewView;
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewWithTag("VVideoView");
          if ((localObject instanceof VVideoView)) {
            this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView = ((VVideoView)localObject);
          }
        }
      }
      a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView, this.jdField_b_of_type_AndroidViewView, paramBoolean);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager$CommentEventListener;
      if (localObject != null) {
        ((ViolaCommentManager.CommentEventListener)localObject).a(false);
      }
    }
  }
  
  private boolean d()
  {
    boolean bool = ScreenUtil.checkNavigationBarShow(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getApplicationContext());
    if (bool) {
      for (ViewParent localViewParent = this.jdField_a_of_type_AndroidViewViewGroup.getParent(); (localViewParent instanceof View); localViewParent = localViewParent.getParent()) {
        if ((((View)localViewParent).getSystemUiVisibility() & 0x2) > 0) {
          return false;
        }
      }
    }
    return bool;
  }
  
  private void e()
  {
    try
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      int i;
      if ((ScreenUtil.checkDeviceHasNavigationBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getApplicationContext())) && (d()))
      {
        i = ScreenUtil.getNavigationBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getApplicationContext());
        this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, i);
      }
      if (CommonSuspensionGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
      {
        if (this.jdField_b_of_type_Int != 0)
        {
          i = ScreenUtil.getNavigationBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getApplicationContext());
          this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, i + this.jdField_b_of_type_Int);
        }
      }
      else
      {
        if (this.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.post(new ViolaCommentManager.1(this));
          return;
        }
        if ((!CommonSuspensionGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)) && (this.jdField_b_of_type_Int != 0))
        {
          this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, this.jdField_b_of_type_Int);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("ViolaCommentManager", 1, "setCommentPadding");
      localException.printStackTrace();
    }
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment != null) && (TKDCommentFragmentHelper.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a());
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ViolaCommentManager.6(this));
  }
  
  private void g()
  {
    VideoFeedsHelper.a(new ViolaCommentManager.8(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment == null)
    {
      Fragment localFragment = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.findFragmentById(this.jdField_a_of_type_AndroidViewViewGroup.getId());
      if ((localFragment instanceof ReadInJoyCommentListFragment)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment = ((ReadInJoyCommentListFragment)localFragment);
      }
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment != null) && (!e())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.d();
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
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = VideoFeedsHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    b();
    this.jdField_c_of_type_ArrayOfInt = new int[] { VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)[0], this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height };
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams != null)
    {
      int i = 0;
      if (paramView != null) {
        i = (int)(paramView.getHeight() / paramView.getWidth() * VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)[0]);
      }
      if (this.d == 1) {
        this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = (VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)[1] - this.jdField_c_of_type_Int - this.e);
      } else {
        this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ((int)(VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)[1] - i - paramFloat - this.e));
      }
      this.jdField_c_of_type_ArrayOfInt[1] = this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    }
  }
  
  public void a(VVideoView paramVVideoView, View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    h();
    if (e())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(paramAbsBaseArticleInfo);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(paramAnchorData);
      if (c()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.b(true);
      }
    }
    e();
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getWidth() > 0) && (this.jdField_a_of_type_AndroidViewViewGroup.getHeight() == this.jdField_c_of_type_ArrayOfInt[1]))
    {
      if ((!this.jdField_a_of_type_Boolean) && (paramAbsBaseArticleInfo != null))
      {
        QLog.d("ViolaCommentManager", 1, "showCommentList: ");
        h();
        ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
        if (localReadInJoyCommentListFragment != null) {
          localReadInJoyCommentListFragment.a(paramAbsBaseArticleInfo, paramAnchorData, true, 2);
        }
        this.jdField_a_of_type_Boolean = true;
        a(paramVVideoView, paramView, paramInt);
        paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager$CommentEventListener;
        if (paramVVideoView != null) {
          paramVVideoView.a(true);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(new ViolaCommentManager.9(this, paramVVideoView, paramView, paramAbsBaseArticleInfo, paramAnchorData, paramInt));
    }
  }
  
  public void a(ViolaCommentManager.CommentEventListener paramCommentEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager$CommentEventListener = paramCommentEventListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment;
    if ((localReadInJoyCommentListFragment != null) && (!localReadInJoyCommentListFragment.d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaCommentManager", 2, "onBackPress: ");
      }
      b(false);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_is_fragment_container", true);
      ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
      ((Bundle)localObject).putBoolean("is_from_viola", true);
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_with_edit_panel", c());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
      JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if ((localJSONObject != null) && (localJSONObject.has("rowkey"))) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(ViolaBizUtils.a(this.jdField_a_of_type_OrgJsonJSONObject));
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(2);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a().register(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesReceiverITKDHippyEventReceiver);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a((Bundle)localObject, new ViolaCommentManager.7(this), this.jdField_a_of_type_AndroidViewViewGroup);
      localObject = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
      ((FragmentTransaction)localObject).add(this.jdField_a_of_type_AndroidViewViewGroup.getId(), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(VVideoView paramVVideoView, View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaCommentManager", 2, "openWriteCommentComponent: ");
      }
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment == null)
      {
        a(paramVVideoView, paramView, paramAbsBaseArticleInfo, paramAnchorData, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.a(new ViolaCommentManager.10(this));
        return;
      }
      a(paramVVideoView, paramView, paramAbsBaseArticleInfo, paramAnchorData, paramInt);
      i();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaCommentManager", 2, "hideCommentList: ");
      }
      c(4);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment.d();
      b(false);
    }
  }
  
  public void c(int paramInt)
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
  
  public boolean c()
  {
    boolean bool = this.jdField_c_of_type_Boolean;
    this.jdField_c_of_type_Boolean = false;
    return bool;
  }
  
  public void d()
  {
    QLog.d("ViolaCommentManager", 1, "destory");
    try
    {
      FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
      localFragmentTransaction.remove(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup))
      {
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaCommentManager", 2, "destroy: ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager
 * JD-Core Version:    0.7.0.1
 */