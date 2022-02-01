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
  private static final String A = HardCodeUtil.a(2131913385);
  private static final String B = HardCodeUtil.a(2131913405);
  private static final String z = HardCodeUtil.a(2131913362);
  protected VideoInfo a;
  protected FrameLayout b;
  protected ImageView c;
  protected TextView d;
  protected boolean e = false;
  protected VideoPlayRecommendHandler f;
  protected VideoPlayRecommendObserver g;
  protected VideoFeedsLazyLoadDelegate.LoadingFragment h;
  
  public VideoFeedsLazyLoadDelegate(IVideoFeedsLoadDelegate.LifeCycleCallBack paramLifeCycleCallBack, Bundle paramBundle, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramLifeCycleCallBack, paramBundle, paramQQAppInterface, paramBaseActivity, paramString1, paramString2, paramString3, paramBoolean, paramInt);
  }
  
  private boolean b(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.l));
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626368, paramViewGroup, false);
    this.b = ((FrameLayout)paramLayoutInflater.findViewById(2131449551));
    this.c = ((ImageView)paramLayoutInflater.findViewById(2131449566));
    this.d = ((TextView)paramLayoutInflater.findViewById(2131449588));
    paramLayoutInflater.findViewById(2131449549).setOnClickListener(this);
    d();
    a(0);
    return paramLayoutInflater;
  }
  
  protected ViewGroup a(int paramInt, BaseFragment paramBaseFragment)
  {
    if (paramBaseFragment == null) {
      paramBaseFragment = this.h;
    }
    return super.a(paramInt, paramBaseFragment);
  }
  
  protected ViewGroup a(int paramInt, QBaseFragment paramQBaseFragment1, QBaseFragment paramQBaseFragment2)
  {
    if (paramQBaseFragment1 == null) {
      paramQBaseFragment1 = this.h;
    }
    return super.a(paramInt, paramQBaseFragment1, paramQBaseFragment2);
  }
  
  protected VideoFeedsRecommendFragment a()
  {
    this.h = VideoFeedsLazyLoadDelegate.LoadingFragment.a(this);
    this.f = ((VideoPlayRecommendHandler)this.q.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
    this.g = new VideoFeedsLazyLoadDelegate.1(this);
    this.r.addObserver(this.g);
    f();
    return null;
  }
  
  protected void a(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        str = B;
        paramInt = 2130844241;
      }
      else
      {
        str = A;
        paramInt = 2130844194;
      }
    }
    else
    {
      str = z;
      paramInt = 2130844150;
    }
    this.d.setText(str);
    this.c.setImageResource(paramInt);
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    int j = this.p.getInt("item_x", 0);
    int n = this.p.getInt("item_y", 0);
    int i1 = this.p.getInt("item_width", 0);
    int k = this.p.getInt("item_height", 0);
    int[] arrayOfInt = VideoFeedsHelper.c(this.r);
    int i = arrayOfInt[0];
    int m = arrayOfInt[1];
    if ((i1 != 0) && (k != 0))
    {
      arrayOfInt = VideoFeedsHelper.a(this.r, j, n);
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
    this.r.overridePendingTransition(0, 0);
    paramDragFrameLayout.setSizeAndPosition(f1, j, i);
    paramDragFrameLayout.post(new VideoFeedsLazyLoadDelegate.2(this, paramDragFrameLayout));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    c();
    super.a(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, Bundle paramBundle)
  {
    VideoFeedsHelper.c(this.r);
    this.p.putString("VIDEO_ARTICLE_ID", paramVideoInfo.l);
    this.p.putAll(paramBundle);
    this.i = VideoFeedsRecommendFragment.a(this.p, paramVideoInfo, this.s, this.u, this.t, true);
    this.i.b(1);
    if (this.m != null) {
      this.m.a(this.i);
    }
    if ((this.w) && ((this.k instanceof ViewPagerCompat)))
    {
      this.j = super.b();
      this.l.a().remove(this.h);
      this.l.a().add(0, this.i);
      this.l.a().add(1, this.j);
      this.l.notifyDataSetChanged();
    }
    else
    {
      this.r.getSupportFragmentManager().beginTransaction().replace(this.n, this.i).commitAllowingStateLoss();
    }
    c();
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("懒加载数据get isSuccess");
    localStringBuilder.append(paramBoolean);
    VideoFeedsPlayActivity.a(localStringBuilder.toString());
    if (!paramBoolean)
    {
      this.e = true;
      a(1);
      return;
    }
    if (!a(paramBundle))
    {
      a(2);
      return;
    }
    a(this.a, paramBundle);
  }
  
  protected boolean a(Bundle paramBundle)
  {
    VideoInfo localVideoInfo2 = (VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
    VideoInfo localVideoInfo1 = localVideoInfo2;
    if (!b(localVideoInfo2))
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
    if (!b(localVideoInfo1)) {
      return false;
    }
    this.a = localVideoInfo1;
    paramBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", localArrayList);
    paramBundle.remove("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    VideoFeedsHelper.a(this.a);
    return true;
  }
  
  protected ViolaFragment b()
  {
    return null;
  }
  
  protected void c()
  {
    this.r.removeObserver(this.g);
    this.g = null;
    this.f = null;
    this.b = null;
    this.c = null;
    this.d = null;
  }
  
  protected void d()
  {
    this.b.setBackgroundColor(-16777216);
  }
  
  protected void e()
  {
    if (this.e)
    {
      f();
      this.e = false;
      this.c.setImageResource(2130844150);
      this.d.setText(z);
    }
  }
  
  protected void f()
  {
    int i = this.p.getInt("VIDEO_FROM_TYPE", -1);
    String str1 = this.p.getString("VIDEO_SECOND_INDEX_INNER_ID");
    long l2 = this.p.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    String str2 = this.p.getString("VIDEO_COMMON_DATA");
    String str3 = this.p.getString("VALUE_COOKIE");
    long l1 = this.p.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    if (l1 == 0L) {
      l1 = Long.parseLong(this.q.getCurrentAccountUin());
    }
    this.f.a(this.g, l1, g(), i, null, str1, l2, true, 0, str2, str3, null, 0, null, null, 0, null, 0);
  }
  
  protected VideoInfo g()
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.l = this.p.getString("VIDEO_ARTICLE_ID", null);
    return localVideoInfo;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131449549) {
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLazyLoadDelegate
 * JD-Core Version:    0.7.0.1
 */