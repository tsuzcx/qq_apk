package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.video.IVideoFeedsLoadDelegate.LifeCycleCallBack;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import java.util.ArrayList;
import java.util.List;

public class VideoFeedsLazyLoadDelegate
  extends VideoFeedsLoadDelegate
  implements View.OnClickListener
{
  private static final String d = HardCodeUtil.a(2131715906);
  private static final String e = HardCodeUtil.a(2131715930);
  private static final String f = HardCodeUtil.a(2131715950);
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  protected VideoFeedsLazyLoadDelegate.LoadingFragment a;
  protected VideoPlayRecommendHandler a;
  protected VideoPlayRecommendObserver a;
  protected VideoInfo a;
  protected boolean a;
  
  public VideoFeedsLazyLoadDelegate(IVideoFeedsLoadDelegate.LifeCycleCallBack paramLifeCycleCallBack, Bundle paramBundle, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramLifeCycleCallBack, paramBundle, paramQQAppInterface, paramBaseActivity, paramString1, paramString2, paramString3, paramBoolean, paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.g));
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560322, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(2131380593));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131380608));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380630));
    paramLayoutInflater.findViewById(2131380591).setOnClickListener(this);
    b();
    a(0);
    return paramLayoutInflater;
  }
  
  protected ViewGroup a(int paramInt, BaseFragment paramBaseFragment)
  {
    if (paramBaseFragment == null) {
      paramBaseFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLazyLoadDelegate$LoadingFragment;
    }
    return super.a(paramInt, paramBaseFragment);
  }
  
  protected ViewGroup a(int paramInt, QBaseFragment paramQBaseFragment1, QBaseFragment paramQBaseFragment2)
  {
    if (paramQBaseFragment1 == null) {
      paramQBaseFragment1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLazyLoadDelegate$LoadingFragment;
    }
    return super.a(paramInt, paramQBaseFragment1, paramQBaseFragment2);
  }
  
  protected VideoFeedsRecommendFragment a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLazyLoadDelegate$LoadingFragment = VideoFeedsLazyLoadDelegate.LoadingFragment.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler = ((VideoPlayRecommendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver = new VideoFeedsLazyLoadDelegate.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver);
    d();
    return null;
  }
  
  protected VideoInfo a()
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.g = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID", null);
    return localVideoInfo;
  }
  
  protected ViolaFragment a()
  {
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  protected void a(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        str = f;
        paramInt = 2130843287;
      }
      else
      {
        str = e;
        paramInt = 2130843240;
      }
    }
    else
    {
      str = d;
      paramInt = 2130843196;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("item_x", 0);
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("item_y", 0);
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("item_width", 0);
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("item_height", 0);
    int[] arrayOfInt = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    int i = arrayOfInt[0];
    int m = arrayOfInt[1];
    if ((i1 != 0) && (k != 0))
    {
      arrayOfInt = VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, j, n);
      j = arrayOfInt[0];
      i = arrayOfInt[1];
    }
    else
    {
      double d1 = m;
      Double.isNaN(d1);
      k = (int)(d1 * 0.4D);
      d1 = i;
      Double.isNaN(d1);
      j = (i - (int)(d1 * 0.4D)) / 2;
      i = (m - k) / 2;
    }
    float f1 = k * 1.0F / m;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
    paramDragFrameLayout.setSizeAndPosition(f1, j, i);
    paramDragFrameLayout.post(new VideoFeedsLazyLoadDelegate.2(this, paramDragFrameLayout));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    a();
    super.a(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, Bundle paramBundle)
  {
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", paramVideoInfo.g);
    this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_AndroidOsBundle, paramVideoInfo, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.b, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.b(1);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate$LifeCycleCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate$LifeCycleCallBack.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
    }
    if ((this.jdField_c_of_type_Boolean) && ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment = super.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLoadDelegate$Adapter.a().remove(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLazyLoadDelegate$LoadingFragment);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLoadDelegate$Adapter.a().add(0, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLoadDelegate$Adapter.a().add(1, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLoadDelegate$Adapter.notifyDataSetChanged();
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager().beginTransaction().replace(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment).commitAllowingStateLoss();
    }
    a();
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("懒加载数据get isSuccess");
    localStringBuilder.append(paramBoolean);
    VideoFeedsPlayActivity.a(localStringBuilder.toString());
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      a(1);
      return;
    }
    if (!a(paramBundle))
    {
      a(2);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, paramBundle);
  }
  
  protected boolean a(Bundle paramBundle)
  {
    VideoInfo localVideoInfo2 = (VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
    VideoInfo localVideoInfo1 = localVideoInfo2;
    if (!a(localVideoInfo2))
    {
      localVideoInfo1 = localVideoInfo2;
      if (localArrayList != null)
      {
        localVideoInfo1 = localVideoInfo2;
        if (localArrayList.size() > 0) {
          localVideoInfo1 = (VideoInfo)localArrayList.remove(0);
        }
      }
    }
    if (!a(localVideoInfo1)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = localVideoInfo1;
    paramBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", localArrayList);
    paramBundle.remove("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    return true;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843196);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(d);
    }
  }
  
  protected void d()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SECOND_INDEX_INNER_ID");
    long l2 = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COMMON_DATA");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("VALUE_COOKIE");
    long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    if (l1 == 0L) {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver, l1, a(), i, null, str1, l2, true, 0, str2, str3, null, 0, null, null, 0, null, 0);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131380591) {
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLazyLoadDelegate
 * JD-Core Version:    0.7.0.1
 */