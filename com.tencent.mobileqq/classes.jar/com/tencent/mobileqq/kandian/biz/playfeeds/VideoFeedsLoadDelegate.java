package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.PendingIntent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.kandian.biz.video.IVideoFeedsLoadDelegate;
import com.tencent.mobileqq.kandian.biz.video.IVideoFeedsLoadDelegate.LifeCycleCallBack;
import com.tencent.mobileqq.kandian.biz.video.WeishiVideoFeedsLazyLoadDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class VideoFeedsLoadDelegate
  implements IVideoFeedsLoadDelegate
{
  protected static ArrayList<VideoInfo> a;
  protected int a;
  protected Bundle a;
  protected ViewGroup a;
  protected BaseActivity a;
  protected QQAppInterface a;
  protected VideoFeedsLoadDelegate.Adapter a;
  protected VideoFeedsRecommendFragment a;
  protected IVideoFeedsLoadDelegate.LifeCycleCallBack a;
  protected ViolaFragment a;
  protected String a;
  protected String[] a;
  protected int b;
  protected String b;
  protected boolean b;
  protected String c;
  protected boolean c;
  
  public VideoFeedsLoadDelegate(IVideoFeedsLoadDelegate.LifeCycleCallBack paramLifeCycleCallBack, Bundle paramBundle, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Int = 2131365132;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131715890), HardCodeUtil.a(2131715925) };
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate$LifeCycleCallBack = paramLifeCycleCallBack;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_Boolean = VideoFeedsHelper.g();
  }
  
  private VideoInfo a()
  {
    VideoInfo localVideoInfo = new VideoInfo();
    if (this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_OBJ") != null)
    {
      localVideoInfo = (VideoInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_OBJ");
      VideoFeedsHelper.a(localVideoInfo);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("generateRequestVideoInfo: 外部传进来的VideoInfo=");
        ((StringBuilder)localObject).append(localVideoInfo.e());
        QLog.d("VideoFeedsLoadDelegate", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", localVideoInfo.g);
      return localVideoInfo;
    }
    Object localObject = (MessageForShortVideo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("key_message_for_shortvideo");
    if (localObject != null)
    {
      localVideoInfo.jdField_a_of_type_Int = 0;
      localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)localObject);
      return localVideoInfo;
    }
    localVideoInfo = VideoFeedsHelper.a(this.jdField_a_of_type_AndroidOsBundle);
    VideoFeedsHelper.a(localVideoInfo);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generateRequestVideoInfo: 外部传进来的VideoInfo=");
      ((StringBuilder)localObject).append(localVideoInfo.e());
      QLog.d("VideoFeedsLoadDelegate", 2, ((StringBuilder)localObject).toString());
    }
    return localVideoInfo;
  }
  
  public static void a(PendingIntent paramPendingIntent)
  {
    jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getString("enable_video_feeds_default_anim", "0").equals("1"))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130772266, 0);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment = a();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment = a();
      this.jdField_a_of_type_AndroidViewViewGroup = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewViewGroup = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment);
    }
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup, 0, paramLayoutInflater);
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  protected ViewGroup a(int paramInt, BaseFragment paramBaseFragment)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localFrameLayout.setId(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager().beginTransaction().replace(paramInt, paramBaseFragment).commitAllowingStateLoss();
    return localFrameLayout;
  }
  
  protected ViewGroup a(int paramInt, QBaseFragment paramQBaseFragment1, QBaseFragment paramQBaseFragment2)
  {
    ViewPagerCompat localViewPagerCompat = new ViewPagerCompat(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localViewPagerCompat.setId(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (paramQBaseFragment1 != null) {
      localArrayList.add(0, paramQBaseFragment1);
    }
    if (paramQBaseFragment2 != null) {
      localArrayList.add(1, paramQBaseFragment2);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLoadDelegate$Adapter = new VideoFeedsLoadDelegate.Adapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager(), localArrayList, this.jdField_a_of_type_ArrayOfJavaLangString);
    localViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLoadDelegate$Adapter);
    if (localArrayList.indexOf(paramQBaseFragment1) >= 0) {
      localViewPagerCompat.setCurrentItem(localArrayList.indexOf(paramQBaseFragment1));
    }
    return localViewPagerCompat;
  }
  
  protected VideoFeedsRecommendFragment a()
  {
    Object localObject1;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_IS_CACHE_CACHE_INFO_LIST", false))
    {
      localObject1 = jdField_a_of_type_JavaUtilArrayList;
      jdField_a_of_type_JavaUtilArrayList = null;
    }
    else
    {
      localObject1 = null;
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FIRST_INFO_POSITION", 0);
      localObject2 = (VideoInfo)((ArrayList)localObject1).remove(0);
      this.jdField_a_of_type_AndroidOsBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", (ArrayList)localObject1);
      localObject1 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_AndroidOsBundle, (VideoInfo)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, i);
    }
    else
    {
      localObject1 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_AndroidOsBundle, a(), this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate$LifeCycleCallBack;
    if (localObject2 != null) {
      ((IVideoFeedsLoadDelegate.LifeCycleCallBack)localObject2).a((VideoFeedsRecommendFragment)localObject1);
    }
    return localObject1;
  }
  
  protected ViolaFragment a()
  {
    ViolaFragment localViolaFragment = new ViolaFragment();
    localViolaFragment.setArguments(new Bundle());
    IVideoFeedsLoadDelegate.LifeCycleCallBack localLifeCycleCallBack = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate$LifeCycleCallBack;
    if (localLifeCycleCallBack != null) {
      localLifeCycleCallBack.a(localViolaFragment);
    }
    return localViolaFragment;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("item_x", 0);
    int m = this.jdField_a_of_type_AndroidOsBundle.getInt("item_y", 0);
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("item_width", 0);
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("item_height", 0);
    int j = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)[0];
    if (((k == 0) && (m == 0) && (i == 0)) || (i >= n))
    {
      a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    int[] arrayOfInt = VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, k, m);
    k = arrayOfInt[0];
    m = arrayOfInt[1];
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
    paramDragFrameLayout.setSizeAndPosition(i * 1.0F / j, k, m);
    paramDragFrameLayout.post(new VideoFeedsLoadDelegate.1(this, paramDragFrameLayout));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle == null) {
      return;
    }
    if (localBundle.getInt("KEY_OLD_LOAD_DELEGATE_TYPE", -1) == 2) {
      new WeishiVideoFeedsLazyLoadDelegate(null, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_Int).b(paramVideoInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLoadDelegate
 * JD-Core Version:    0.7.0.1
 */