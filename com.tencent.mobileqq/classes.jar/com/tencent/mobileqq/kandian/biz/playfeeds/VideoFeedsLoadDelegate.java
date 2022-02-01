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
  protected static ArrayList<VideoInfo> y;
  protected VideoFeedsRecommendFragment i;
  protected ViolaFragment j;
  protected ViewGroup k;
  protected VideoFeedsLoadDelegate.Adapter l;
  protected IVideoFeedsLoadDelegate.LifeCycleCallBack m;
  protected int n = 2131431280;
  protected String[] o = { HardCodeUtil.a(2131913346), HardCodeUtil.a(2131913380) };
  protected Bundle p;
  protected QQAppInterface q;
  protected BaseActivity r;
  protected String s;
  protected String t;
  protected String u;
  protected boolean v;
  protected boolean w;
  protected int x;
  
  public VideoFeedsLoadDelegate(IVideoFeedsLoadDelegate.LifeCycleCallBack paramLifeCycleCallBack, Bundle paramBundle, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    this.m = paramLifeCycleCallBack;
    this.p = paramBundle;
    this.q = paramQQAppInterface;
    this.r = paramBaseActivity;
    this.s = paramString1;
    this.u = paramString2;
    this.t = paramString3;
    this.v = paramBoolean;
    this.x = paramInt;
    this.w = VideoFeedsHelper.q();
  }
  
  public static void a(PendingIntent paramPendingIntent)
  {
    y = null;
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getString("enable_video_feeds_default_anim", "0").equals("1"))
    {
      this.r.overridePendingTransition(0, 0);
      return;
    }
    this.r.overridePendingTransition(2130772345, 0);
  }
  
  private VideoInfo c()
  {
    VideoInfo localVideoInfo = new VideoInfo();
    if (this.p.getParcelable("VIDEO_OBJ") != null)
    {
      localVideoInfo = (VideoInfo)this.p.getParcelable("VIDEO_OBJ");
      VideoFeedsHelper.a(localVideoInfo);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("generateRequestVideoInfo: 外部传进来的VideoInfo=");
        ((StringBuilder)localObject).append(localVideoInfo.q());
        QLog.d("VideoFeedsLoadDelegate", 2, ((StringBuilder)localObject).toString());
      }
      this.p.putString("VIDEO_ARTICLE_ID", localVideoInfo.l);
      return localVideoInfo;
    }
    Object localObject = (MessageForShortVideo)this.p.getParcelable("key_message_for_shortvideo");
    if (localObject != null)
    {
      localVideoInfo.a = 0;
      localVideoInfo.aQ = ((MessageForShortVideo)localObject);
      return localVideoInfo;
    }
    localVideoInfo = VideoFeedsHelper.a(this.p);
    VideoFeedsHelper.a(localVideoInfo);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generateRequestVideoInfo: 外部传进来的VideoInfo=");
      ((StringBuilder)localObject).append(localVideoInfo.q());
      QLog.d("VideoFeedsLoadDelegate", 2, ((StringBuilder)localObject).toString());
    }
    return localVideoInfo;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.i = a();
    if (this.w)
    {
      this.j = b();
      this.k = a(this.n, this.i, this.j);
    }
    else
    {
      this.k = a(this.n, this.i);
    }
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    paramViewGroup.addView(this.k, 0, paramLayoutInflater);
    return this.k;
  }
  
  protected ViewGroup a(int paramInt, BaseFragment paramBaseFragment)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.r);
    localFrameLayout.setId(paramInt);
    this.r.getSupportFragmentManager().beginTransaction().replace(paramInt, paramBaseFragment).commitAllowingStateLoss();
    return localFrameLayout;
  }
  
  protected ViewGroup a(int paramInt, QBaseFragment paramQBaseFragment1, QBaseFragment paramQBaseFragment2)
  {
    ViewPagerCompat localViewPagerCompat = new ViewPagerCompat(this.r);
    localViewPagerCompat.setId(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (paramQBaseFragment1 != null) {
      localArrayList.add(0, paramQBaseFragment1);
    }
    if (paramQBaseFragment2 != null) {
      localArrayList.add(1, paramQBaseFragment2);
    }
    this.l = new VideoFeedsLoadDelegate.Adapter(this.r.getSupportFragmentManager(), localArrayList, this.o);
    localViewPagerCompat.setAdapter(this.l);
    if (localArrayList.indexOf(paramQBaseFragment1) >= 0) {
      localViewPagerCompat.setCurrentItem(localArrayList.indexOf(paramQBaseFragment1));
    }
    return localViewPagerCompat;
  }
  
  protected VideoFeedsRecommendFragment a()
  {
    Object localObject1;
    if (this.p.getBoolean("VIDEO_IS_CACHE_CACHE_INFO_LIST", false))
    {
      localObject1 = y;
      y = null;
    }
    else
    {
      localObject1 = null;
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      int i1 = this.p.getInt("VIDEO_FIRST_INFO_POSITION", 0);
      localObject2 = (VideoInfo)((ArrayList)localObject1).remove(0);
      this.p.putParcelableArrayList("VIDEO_RECOMMEND_LIST", (ArrayList)localObject1);
      localObject1 = VideoFeedsRecommendFragment.a(this.p, (VideoInfo)localObject2, this.s, this.u, this.t, true, i1);
    }
    else
    {
      localObject1 = VideoFeedsRecommendFragment.a(this.p, c(), this.s, this.u, this.t);
    }
    Object localObject2 = this.m;
    if (localObject2 != null) {
      ((IVideoFeedsLoadDelegate.LifeCycleCallBack)localObject2).a((VideoFeedsRecommendFragment)localObject1);
    }
    return localObject1;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    int i3 = this.p.getInt("item_x", 0);
    int i4 = this.p.getInt("item_y", 0);
    int i1 = this.p.getInt("item_width", 0);
    int i5 = this.p.getInt("item_height", 0);
    int i2 = VideoFeedsHelper.c(this.r)[0];
    if (((i3 == 0) && (i4 == 0) && (i1 == 0)) || (i1 >= i5))
    {
      a(this.p);
      return;
    }
    int[] arrayOfInt = VideoFeedsHelper.a(this.r, i3, i4);
    i3 = arrayOfInt[0];
    i4 = arrayOfInt[1];
    this.r.overridePendingTransition(0, 0);
    paramDragFrameLayout.setSizeAndPosition(i1 * 1.0F / i2, i3, i4);
    paramDragFrameLayout.post(new VideoFeedsLoadDelegate.1(this, paramDragFrameLayout));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    Bundle localBundle = this.p;
    if (localBundle == null) {
      return;
    }
    if (localBundle.getInt("KEY_OLD_LOAD_DELEGATE_TYPE", -1) == 2) {
      new WeishiVideoFeedsLazyLoadDelegate(null, this.p, this.q, this.r, this.s, this.u, this.t, this.v, this.x).b(paramVideoInfo);
    }
  }
  
  protected ViolaFragment b()
  {
    ViolaFragment localViolaFragment = new ViolaFragment();
    localViolaFragment.setArguments(new Bundle());
    IVideoFeedsLoadDelegate.LifeCycleCallBack localLifeCycleCallBack = this.m;
    if (localLifeCycleCallBack != null) {
      localLifeCycleCallBack.a(localViolaFragment);
    }
    return localViolaFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLoadDelegate
 * JD-Core Version:    0.7.0.1
 */