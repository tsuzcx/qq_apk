package com.tencent.mobileqq.flashshow.widgets.common;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.data.FSUserStateData;
import com.tencent.mobileqq.flashshow.data.call.FSRequestCall;
import com.tencent.mobileqq.flashshow.data.interceptor.FSFollowRspInterceptor;
import com.tencent.mobileqq.flashshow.request.follow.FSDoFollowRequest;
import com.tencent.mobileqq.flashshow.sender.FSRequestSender;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.DataObserverWrapper;
import com.tencent.richframework.sender.aspect.ThrottlingDelay;
import com.tencent.richframework.sender.call.BaseCall;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;

public class FSFollowView
  extends TextView
  implements View.OnClickListener, Observer<FSUserStateData>
{
  protected FeedCloudMeta.StUser a;
  private FeedCloudMeta.StFeed b;
  private boolean c;
  private int d;
  private int e;
  private int f;
  private int g;
  private FSFollowView.FSFollowReportListener h;
  private DataObserverWrapper i;
  
  public FSFollowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public FSFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 38	android/widget/TextView:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 40	feedcloud/FeedCloudMeta$StUser
    //   11: dup
    //   12: invokespecial 43	feedcloud/FeedCloudMeta$StUser:<init>	()V
    //   15: putfield 45	com/tencent/mobileqq/flashshow/widgets/common/FSFollowView:a	Lfeedcloud/FeedCloudMeta$StUser;
    //   18: aload_0
    //   19: new 47	feedcloud/FeedCloudMeta$StFeed
    //   22: dup
    //   23: invokespecial 48	feedcloud/FeedCloudMeta$StFeed:<init>	()V
    //   26: putfield 50	com/tencent/mobileqq/flashshow/widgets/common/FSFollowView:b	Lfeedcloud/FeedCloudMeta$StFeed;
    //   29: aconst_null
    //   30: astore 4
    //   32: aconst_null
    //   33: astore 5
    //   35: aload_1
    //   36: aload_2
    //   37: getstatic 56	com/tencent/biz/flashshow/impl/R$styleable:aX	[I
    //   40: invokevirtual 62	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   43: astore_1
    //   44: aload_1
    //   45: astore 5
    //   47: aload_1
    //   48: astore 4
    //   50: aload_0
    //   51: aload_1
    //   52: getstatic 65	com/tencent/biz/flashshow/impl/R$styleable:aY	I
    //   55: ldc 66
    //   57: invokevirtual 72	android/content/res/TypedArray:getResourceId	(II)I
    //   60: putfield 74	com/tencent/mobileqq/flashshow/widgets/common/FSFollowView:e	I
    //   63: aload_1
    //   64: astore 5
    //   66: aload_1
    //   67: astore 4
    //   69: aload_0
    //   70: aload_1
    //   71: getstatic 77	com/tencent/biz/flashshow/impl/R$styleable:ba	I
    //   74: ldc 78
    //   76: invokevirtual 72	android/content/res/TypedArray:getResourceId	(II)I
    //   79: putfield 80	com/tencent/mobileqq/flashshow/widgets/common/FSFollowView:d	I
    //   82: aload_1
    //   83: astore 5
    //   85: aload_1
    //   86: astore 4
    //   88: aload_0
    //   89: aload_1
    //   90: getstatic 83	com/tencent/biz/flashshow/impl/R$styleable:aZ	I
    //   93: ldc 84
    //   95: invokevirtual 72	android/content/res/TypedArray:getResourceId	(II)I
    //   98: putfield 86	com/tencent/mobileqq/flashshow/widgets/common/FSFollowView:f	I
    //   101: aload_1
    //   102: astore 5
    //   104: aload_1
    //   105: astore 4
    //   107: aload_0
    //   108: aload_1
    //   109: getstatic 89	com/tencent/biz/flashshow/impl/R$styleable:bb	I
    //   112: ldc 84
    //   114: invokevirtual 72	android/content/res/TypedArray:getResourceId	(II)I
    //   117: putfield 91	com/tencent/mobileqq/flashshow/widgets/common/FSFollowView:g	I
    //   120: aload_1
    //   121: ifnull +31 -> 152
    //   124: goto +24 -> 148
    //   127: astore_1
    //   128: goto +42 -> 170
    //   131: astore_1
    //   132: aload 4
    //   134: astore 5
    //   136: aload_1
    //   137: invokevirtual 94	java/lang/Exception:printStackTrace	()V
    //   140: aload 4
    //   142: ifnull +10 -> 152
    //   145: aload 4
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 97	android/content/res/TypedArray:recycle	()V
    //   152: aload_0
    //   153: aload_0
    //   154: invokevirtual 101	com/tencent/mobileqq/flashshow/widgets/common/FSFollowView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   157: aload_0
    //   158: new 103	com/tencent/richframework/data/base/DataObserverWrapper
    //   161: dup
    //   162: aload_0
    //   163: invokespecial 106	com/tencent/richframework/data/base/DataObserverWrapper:<init>	(Landroidx/lifecycle/Observer;)V
    //   166: putfield 108	com/tencent/mobileqq/flashshow/widgets/common/FSFollowView:i	Lcom/tencent/richframework/data/base/DataObserverWrapper;
    //   169: return
    //   170: aload 5
    //   172: ifnull +8 -> 180
    //   175: aload 5
    //   177: invokevirtual 97	android/content/res/TypedArray:recycle	()V
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	FSFollowView
    //   0	182	1	paramContext	Context
    //   0	182	2	paramAttributeSet	AttributeSet
    //   0	182	3	paramInt	int
    //   30	116	4	localContext1	Context
    //   33	143	5	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   35	44	127	finally
    //   50	63	127	finally
    //   69	82	127	finally
    //   88	101	127	finally
    //   107	120	127	finally
    //   136	140	127	finally
    //   35	44	131	java/lang/Exception
    //   50	63	131	java/lang/Exception
    //   69	82	131	java/lang/Exception
    //   88	101	131	java/lang/Exception
    //   107	120	131	java/lang/Exception
  }
  
  private void e()
  {
    if (this.a == null)
    {
      QLog.i("FSFollowView", 1, "stUser is null");
      return;
    }
    FSDataCenter.a().a(this.a.id.get(), FSUserStateData.a(this.a));
    FSDataCenter.a().a(this.a.id.get(), this.i);
  }
  
  protected void a()
  {
    setVisibility(0);
    setBackgroundDrawable(getResources().getDrawable(this.d));
    setTextColor(getResources().getColor(this.g));
    FeedCloudMeta.StUser localStUser = this.a;
    if ((localStUser != null) && (localStUser.followState.get() == 2))
    {
      setText(2131889741);
      return;
    }
    setText(2131889714);
  }
  
  public void a(int paramInt)
  {
    if (FSCommonUtil.a(this.a)) {
      return;
    }
    FeedCloudMeta.StUser localStUser = this.a;
    if (localStUser != null) {
      localStUser.followState.set(paramInt);
    }
    if (FSCommonUtil.a(paramInt))
    {
      b();
      return;
    }
    a();
  }
  
  public void a(FSUserStateData paramFSUserStateData)
  {
    if (this.a.id.get().equals(paramFSUserStateData.a()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChanged: state");
      localStringBuilder.append(paramFSUserStateData.c());
      QLog.d("FSFollowView", 1, localStringBuilder.toString());
      a(paramFSUserStateData.c());
    }
  }
  
  protected void b()
  {
    setBackgroundDrawable(getResources().getDrawable(this.e));
    setTextColor(getResources().getColor(this.f));
    FeedCloudMeta.StUser localStUser = this.a;
    if ((localStUser != null) && (localStUser.followState.get() == 3)) {
      setText(2131889718);
    } else {
      setText(2131889717);
    }
    if (this.c)
    {
      if (getVisibility() == 0)
      {
        c();
        return;
      }
      setVisibility(8);
      return;
    }
    setVisibility(0);
  }
  
  protected void c()
  {
    postDelayed(new FSFollowView.1(this), 2000L);
  }
  
  protected void d()
  {
    Object localObject1 = this.a;
    if (localObject1 == null)
    {
      QLog.e("FSFollowView", 2, "follow user failed! user is null");
      return;
    }
    int j = ((FeedCloudMeta.StUser)localObject1).followState.get() ^ 0x1;
    localObject1 = null;
    if (!TextUtils.isEmpty(this.b.id.get()))
    {
      localObject1 = new FeedCloudCommon.StCommonExt();
      localObject2 = new FeedCloudCommon.Entry();
      ((FeedCloudCommon.Entry)localObject2).key.set("feedid");
      ((FeedCloudCommon.Entry)localObject2).value.set(this.b.id.get());
      ((FeedCloudCommon.StCommonExt)localObject1).mapInfo.get().add(localObject2);
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt(FSFollowRspInterceptor.a, j);
    localObject1 = new FSDoFollowRequest(this.a, j, (FeedCloudCommon.StCommonExt)localObject1);
    ((FSDoFollowRequest)localObject1).setEnableCache(false);
    FSRequestSender.a().b().a(new FSFollowRspInterceptor()).a((Bundle)localObject2).a(localObject1).a();
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    return this.b;
  }
  
  public FeedCloudMeta.StUser getUserData()
  {
    return this.a;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((!TextUtils.isEmpty(this.a.id.get())) && (!FSCommonUtil.a(this.a)))
    {
      FSUserStateData localFSUserStateData = (FSUserStateData)FSDataCenter.a().a(this.a.id.get(), FSUserStateData.a(this.a)).getValue();
      if (localFSUserStateData == null) {
        return;
      }
      this.a.followState.set(localFSUserStateData.c());
      if ((this.c) && (FSCommonUtil.a(localFSUserStateData.c())))
      {
        setVisibility(8);
        return;
      }
      a(localFSUserStateData.c());
      FSFollowView.FSFollowReportListener localFSFollowReportListener = this.h;
      if (localFSFollowReportListener != null) {
        localFSFollowReportListener.a(localFSUserStateData.c());
      }
      return;
    }
    setVisibility(8);
  }
  
  @ThrottlingDelay(a="FSFollowView", b=2000L)
  public void onClick(View paramView)
  {
    FSFollowView.FSFollowReportListener localFSFollowReportListener = this.h;
    if (localFSFollowReportListener != null) {
      localFSFollowReportListener.b(this.a.followState.get());
    }
    d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setFollowedDismiss(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setReportListener(FSFollowView.FSFollowReportListener paramFSFollowReportListener)
  {
    this.h = paramFSFollowReportListener;
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser)
  {
    setUserData(paramStUser, new FeedCloudMeta.StFeed());
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser, FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStUser != null)
    {
      if (TextUtils.isEmpty(paramStUser.id.get()))
      {
        QLog.e("FSFollowView", 1, "userId is empty");
        return;
      }
      this.a = paramStUser;
      if ((TextUtils.isEmpty(paramStUser.id.get())) || (FSCommonUtil.a(paramStUser))) {
        setVisibility(8);
      }
      e();
    }
    if (paramStFeed != null) {
      this.b = paramStFeed;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSFollowView
 * JD-Core Version:    0.7.0.1
 */