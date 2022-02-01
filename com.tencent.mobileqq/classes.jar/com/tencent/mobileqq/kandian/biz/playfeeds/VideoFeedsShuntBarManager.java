package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VideoFeedsShuntBarManager
  implements View.OnClickListener
{
  private static final String a;
  private Activity b;
  private VideoInfo.ECommerceEntranceInfo c;
  private boolean d;
  private boolean e;
  private int f;
  private int g;
  private int h;
  private VideoFeedsAdapter i;
  private Set<String> j = new HashSet();
  private ArrayList<Integer> k;
  private VideoFeedsShuntBarConfigure l;
  private VideoInfo.ECommerceEntranceInfo m;
  private VideofeedsUserGuideController n;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video");
    localStringBuilder.append(VideoFeedsShuntBarManager.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public VideoFeedsShuntBarManager(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsAdapter paramVideoFeedsAdapter, VideofeedsUserGuideController paramVideofeedsUserGuideController)
  {
    this.l = new VideoFeedsShuntBarConfigure(paramQQAppInterface);
    this.f = VideoFeedsHelper.b();
    this.g = VideoFeedsHelper.c();
    this.h = VideoFeedsHelper.d();
    this.i = paramVideoFeedsAdapter;
    this.b = paramActivity;
    this.n = paramVideofeedsUserGuideController;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    int i1 = 1;
    this.e = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.m = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.o == 0)
    {
      if ((paramVideoItemHolder.ba == null) && ((paramVideoItemHolder instanceof ShortVideoItemHolder)))
      {
        paramVideoItemHolder.ba = ((ViewGroup)((ViewStub)paramVideoItemHolder.aZ.findViewById(2131449595)).inflate());
        paramVideoItemHolder.bb = ((URLImageView)paramVideoItemHolder.ba.findViewById(2131445924));
        paramVideoItemHolder.bc = ((TextView)paramVideoItemHolder.ba.findViewById(2131445925));
        paramVideoItemHolder.bd = paramVideoItemHolder.ba.findViewById(2131445923);
      }
      if (paramVideoItemHolder.ba == null) {
        break label769;
      }
      paramVideoItemHolder.ba.setVisibility(0);
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.c)) {}
    }
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ViewUtils.dip2px(this.h);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ViewUtils.dip2px(this.h);
      localObject = URLDrawable.getDrawable(paramECommerceEntranceInfo.c, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(new int[] { 0, 0, this.f, this.g });
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.k);
      paramVideoItemHolder.bb.setImageDrawable((Drawable)localObject);
    }
    catch (Exception localException)
    {
      Object localObject;
      label223:
      StringBuilder localStringBuilder;
      int i2;
      int i3;
      float f1;
      break label223;
    }
    if (QLog.isColorLevel())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("后台下发的url格式有问题：");
      localStringBuilder.append(paramECommerceEntranceInfo.c);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    paramVideoItemHolder.bc.setText(paramECommerceEntranceInfo.a);
    VideoFeedsHelper.c(paramVideoItemHolder.ba, 200);
    paramVideoItemHolder.ba.setTag(paramVideoItemHolder);
    paramVideoItemHolder.ba.setOnClickListener(this);
    if (paramVideoItemHolder.bd != null)
    {
      paramVideoItemHolder.bd.setTag(paramVideoItemHolder);
      paramVideoItemHolder.bd.setOnClickListener(this);
      break label769;
      if (paramECommerceEntranceInfo.o == 1)
      {
        if ((paramVideoItemHolder.bn == null) && (paramVideoItemHolder.bm != null))
        {
          paramVideoItemHolder.bm.inflate();
          paramVideoItemHolder.bn = ((ViewGroup)paramVideoItemHolder.bY.findViewById(2131441415));
          paramVideoItemHolder.bo = ((URLImageView)paramVideoItemHolder.bY.findViewById(2131446437));
          paramVideoItemHolder.bp = ((TextView)paramVideoItemHolder.bY.findViewById(2131446436));
          paramVideoItemHolder.bq = paramVideoItemHolder.bY.findViewById(2131446434);
          paramVideoItemHolder.br = ((TextView)paramVideoItemHolder.bY.findViewById(2131446438));
          paramVideoItemHolder.bs = ((TextView)paramVideoItemHolder.bY.findViewById(2131446435));
          paramVideoItemHolder.bq.setTag(paramVideoItemHolder);
          paramVideoItemHolder.bq.setOnClickListener(this);
          paramVideoItemHolder.bp.setTag(paramVideoItemHolder);
          paramVideoItemHolder.bp.setOnClickListener(this);
        }
        VideoFeedsHelper.a(paramVideoItemHolder.bn, 0);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
        i2 = ViewUtils.dip2px(60.0F);
        i3 = ViewUtils.dip2px(10.0F);
        f1 = i2;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ViewUtils.dip2px(f1);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ViewUtils.dip2px(f1);
        localObject = URLDrawable.getDrawable(paramECommerceEntranceInfo.c, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.k);
        ((URLDrawable)localObject).setTag(new int[] { 0, 0, i3, 0 });
        paramVideoItemHolder.bo.setImageDrawable((Drawable)localObject);
        if ((paramECommerceEntranceInfo.p == null) || (!PackageUtil.a(this.b, paramECommerceEntranceInfo.p.c))) {
          i1 = 0;
        }
        if (i1 != 0) {
          paramVideoItemHolder.bp.setText(paramECommerceEntranceInfo.r);
        } else {
          paramVideoItemHolder.bp.setText(paramECommerceEntranceInfo.q);
        }
        paramVideoItemHolder.br.setText(paramECommerceEntranceInfo.a);
        paramVideoItemHolder.bs.setText(paramECommerceEntranceInfo.b);
        paramVideoItemHolder.aG.setVisibility(8);
        paramVideoItemHolder.aA.f(false);
        paramVideoItemHolder.aA.i(false);
        paramVideoItemHolder.aA.j(false);
        this.i.g(false);
      }
      else if (paramECommerceEntranceInfo.o == 2)
      {
        b(paramECommerceEntranceInfo, paramVideoItemHolder, paramVideoInfo);
      }
    }
    label769:
    PublicAccountReportUtils.a(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new VideoR5.Builder(null, null, null, paramVideoInfo.l).R(paramECommerceEntranceInfo.o).b(paramECommerceEntranceInfo.j).e(paramVideoInfo.ah).k(paramVideoInfo.l).f(paramECommerceEntranceInfo.i).b().a(), false);
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, int paramInt1, int paramInt2)
  {
    if ((paramECommerceEntranceInfo.h >= 0) && (paramInt1 >= paramECommerceEntranceInfo.h)) {
      return true;
    }
    return (paramECommerceEntranceInfo.i >= 0) && (paramInt1 / paramInt2 * 100.0F >= paramECommerceEntranceInfo.i);
  }
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    this.n.a(paramVideoInfo, paramECommerceEntranceInfo, this);
  }
  
  private boolean b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    int i1 = paramECommerceEntranceInfo.o;
    boolean bool = true;
    if (i1 == 2) {
      return TextUtils.isEmpty(paramECommerceEntranceInfo.a) ^ true;
    }
    if (this.l.a(paramECommerceEntranceInfo))
    {
      if (!TextUtils.isEmpty(paramECommerceEntranceInfo.a)) {
        return bool;
      }
      if (!TextUtils.isEmpty(paramECommerceEntranceInfo.b)) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public void a()
  {
    this.l.a();
    this.b = null;
  }
  
  public void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if ((this.c == null) && (paramECommerceEntranceInfo != null))
    {
      this.c = paramECommerceEntranceInfo;
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("play by positions, position to play is: ");
        localStringBuilder.append(Arrays.toString(paramECommerceEntranceInfo.g));
        localStringBuilder.append(", play time is:");
        localStringBuilder.append(paramECommerceEntranceInfo.h);
        localStringBuilder.append(", play percent :");
        localStringBuilder.append(paramECommerceEntranceInfo.i);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.k = new ArrayList(Arrays.asList(VideoFeedsHelper.a(this.c.g)));
    }
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, int paramInt1, int paramInt2)
  {
    if (paramVideoItemHolder.X != 2) {
      return;
    }
    if (paramVideoItemHolder.af.getVisibility() == 0) {
      return;
    }
    if ((paramVideoInfo != null) && (paramVideoInfo.aG != null))
    {
      if ((a(paramVideoInfo.aG, paramInt1, paramInt2)) && (!this.d) && (!this.e) && (b(paramVideoInfo.aG)))
      {
        a(paramVideoInfo.aG, paramVideoItemHolder, paramVideoInfo);
        this.j.add(paramVideoInfo.b);
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "show shunt bar!!!");
        }
      }
    }
    else if ((paramVideoItemHolder.ba != null) && (paramVideoItemHolder.ba.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "默认不显示引流条");
      }
      paramVideoItemHolder.ba.setVisibility(8);
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    this.e = false;
    this.d = false;
    b(paramVideoItemHolder);
  }
  
  public void a(List<VideoInfo> paramList)
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      Iterator localIterator = new ArrayList((Collection)localObject).iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        int i1 = localInteger.intValue() - 1;
        if ((i1 > 0) && (i1 < paramList.size()))
        {
          VideoInfo localVideoInfo = (VideoInfo)paramList.get(i1);
          localObject = localVideoInfo;
          if (localVideoInfo.aq)
          {
            i1 += 1;
            if (i1 < paramList.size()) {
              localObject = (VideoInfo)paramList.get(i1);
            }
          }
          else
          {
            if (((VideoInfo)localObject).aG == null) {
              ((VideoInfo)localObject).aG = this.c;
            }
            this.k.remove(localInteger);
          }
        }
      }
    }
  }
  
  public void b(VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder != null)
    {
      if (this.m == null) {
        return;
      }
      if (paramVideoItemHolder.X != 2) {
        return;
      }
      if (this.m.o == 0)
      {
        if (paramVideoItemHolder.ba != null) {
          paramVideoItemHolder.ba.setVisibility(8);
        }
      }
      else
      {
        if (this.m.o == 1)
        {
          if (paramVideoItemHolder.bn != null) {
            paramVideoItemHolder.bn.setVisibility(8);
          }
          paramVideoItemHolder.aG.setVisibility(0);
          paramVideoItemHolder.aA.f(true);
          paramVideoItemHolder.aA.i(true);
          paramVideoItemHolder.aA.j(true);
          this.i.g(true);
          return;
        }
        if (this.m.o == 2) {
          this.n.a();
        }
      }
    }
  }
  
  public void c(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject1 = this.m;
    if (localObject1 == null) {
      return;
    }
    this.d = true;
    this.e = false;
    int i1 = ((VideoInfo.ECommerceEntranceInfo)localObject1).o;
    Object localObject2 = null;
    if (i1 == 0)
    {
      if (!TextUtils.isEmpty(this.m.f)) {
        RIJJumpUtils.a(this.b, this.m.f, null);
      } else if (this.m.p != null) {
        VideoFeedsHelper.a(this.b, this.m.p);
      }
    }
    else if (this.m.o == 1) {
      VideoFeedsHelper.a(this.b, this.m.p);
    }
    b(paramVideoItemHolder);
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.az != null)) {
      paramVideoItemHolder = paramVideoItemHolder.az.c;
    } else {
      paramVideoItemHolder = null;
    }
    if (paramVideoItemHolder != null) {
      localObject1 = paramVideoItemHolder.l;
    } else {
      localObject1 = null;
    }
    VideoR5.Builder localBuilder = new VideoR5.Builder(null, null, null, (String)localObject1).R(this.m.o).f(this.m.i).b(this.m.j);
    if (paramVideoItemHolder != null) {
      localObject1 = paramVideoItemHolder.l;
    } else {
      localObject1 = null;
    }
    localBuilder = localBuilder.k((String)localObject1);
    localObject1 = localObject2;
    if (paramVideoItemHolder != null) {
      localObject1 = Long.valueOf(paramVideoItemHolder.ah);
    }
    PublicAccountReportUtils.a(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", localBuilder.e(((Long)localObject1).longValue()).b().a(), false);
  }
  
  public void onClick(View paramView)
  {
    BaseItemHolder localBaseItemHolder = (BaseItemHolder)paramView.getTag();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131445923: 
    case 2131446434: 
      b((VideoItemHolder)localBaseItemHolder);
      return;
    }
    c((VideoItemHolder)localBaseItemHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShuntBarManager
 * JD-Core Version:    0.7.0.1
 */