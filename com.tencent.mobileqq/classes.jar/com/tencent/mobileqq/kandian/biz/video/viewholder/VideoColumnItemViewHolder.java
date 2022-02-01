package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.qphone.base.util.QLog;

public class VideoColumnItemViewHolder
  extends ViewHolder
  implements View.OnClickListener, PlayableItem
{
  public RelativeLayout a;
  public KandianUrlImageView b;
  public KandianUrlImageView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public ViewGroup g;
  public TextView h;
  public TextView i;
  public KandianUrlImageView j;
  public TextView k;
  public VideoViewGroup l;
  public ImageView m;
  public TextView n;
  public View o;
  public View p;
  public TextView q;
  public ViewGroup r;
  public KanDianUrlRoundCornerImageView s;
  public TextView t;
  public ImageView u;
  public VideoPlayParam v;
  
  public VideoColumnItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  private void d(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramView);
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    if ((this.R != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.n != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.n.a != 3))
    {
      VideoFeedsHelper.a(this.R.i(), localAbsBaseArticleInfo.mVideoColumnInfo.n);
    }
    else
    {
      paramView = c(paramView);
      if (paramView != null) {
        this.R.g().a(paramView.a(), localAbsBaseArticleInfo, false, false);
      }
    }
    if (localAbsBaseArticleInfo.mVideoColumnInfo.n == null) {
      paramView = null;
    } else {
      paramView = localAbsBaseArticleInfo.mVideoColumnInfo.n.f;
    }
    a(this.R, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mVideoColumnInfo, 1, paramView);
  }
  
  private void e(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramView);
    if ((localAbsBaseArticleInfo != null) && (this.R != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null))
    {
      VideoFeedsHelper.a(this.R.i(), localAbsBaseArticleInfo.mVideoColumnInfo.p);
      VideoFeedsHelper.a(RIJQQAppInterfaceUtil.a(), localAbsBaseArticleInfo.mVideoColumnInfo.b, true, localAbsBaseArticleInfo.mVideoColumnInfo.d);
      localAbsBaseArticleInfo.mVideoColumnInfo.h = true;
      VideoColumnInfo localVideoColumnInfo = localAbsBaseArticleInfo.mVideoColumnInfo;
      localVideoColumnInfo.g += 1;
      ReadInJoyLogicEngine.a().c(localAbsBaseArticleInfo);
      paramView.setVisibility(8);
      if (localAbsBaseArticleInfo.mVideoColumnInfo.p == null) {
        paramView = null;
      } else {
        paramView = localAbsBaseArticleInfo.mVideoColumnInfo.p.f;
      }
      a(this.R, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mVideoColumnInfo, 2, paramView);
    }
  }
  
  private void f(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramView);
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    if ((this.R != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.o != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.o.a != 3))
    {
      VideoFeedsHelper.a(this.R.i(), localAbsBaseArticleInfo.mVideoColumnInfo.o);
    }
    else
    {
      paramView = c(paramView);
      if (paramView != null) {
        this.R.g().a(paramView.a(), localAbsBaseArticleInfo, false, false);
      }
    }
    if (localAbsBaseArticleInfo.mVideoColumnInfo.o == null) {
      paramView = null;
    } else {
      paramView = localAbsBaseArticleInfo.mVideoColumnInfo.o.f;
    }
    a(this.R, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mVideoColumnInfo, 3, paramView);
  }
  
  private void g(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramView);
    if ((localAbsBaseArticleInfo != null) && (this.R != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null))
    {
      VideoFeedsHelper.a(this.R.i(), localAbsBaseArticleInfo.mVideoColumnInfo.q);
      if (localAbsBaseArticleInfo.mVideoColumnInfo.q == null) {
        paramView = null;
      } else {
        paramView = localAbsBaseArticleInfo.mVideoColumnInfo.q.f;
      }
      a(this.R, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mVideoColumnInfo, 4, paramView);
    }
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.N).inflate(2131626431, paramViewGroup, false);
    this.a = ((RelativeLayout)paramViewGroup.findViewById(2131434958));
    this.b = ((KandianUrlImageView)paramViewGroup.findViewById(2131434959));
    this.c = ((KandianUrlImageView)paramViewGroup.findViewById(2131431001));
    this.d = ((TextView)paramViewGroup.findViewById(2131431004));
    this.e = ((TextView)paramViewGroup.findViewById(2131431002));
    this.f = ((TextView)paramViewGroup.findViewById(2131446570));
    this.g = ((ViewGroup)paramViewGroup.findViewById(2131431339));
    this.h = ((TextView)paramViewGroup.findViewById(2131447463));
    this.i = ((TextView)paramViewGroup.findViewById(2131440378));
    this.k = ((TextView)paramViewGroup.findViewById(2131432267));
    this.j = ((KandianUrlImageView)paramViewGroup.findViewById(2131435357));
    this.l = ((VideoViewGroup)paramViewGroup.findViewById(2131449619));
    this.m = ((ImageView)paramViewGroup.findViewById(2131439638));
    this.n = ((TextView)paramViewGroup.findViewById(2131439639));
    this.q = ((TextView)paramViewGroup.findViewById(2131436799));
    this.o = paramViewGroup.findViewById(2131447534);
    this.p = paramViewGroup.findViewById(2131447566);
    this.r = ((ViewGroup)paramViewGroup.findViewById(2131428519));
    this.s = ((KanDianUrlRoundCornerImageView)paramViewGroup.findViewById(2131430997));
    this.t = ((TextView)paramViewGroup.findViewById(2131430998));
    this.u = ((ImageView)paramViewGroup.findViewById(2131449096));
    this.a.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
  
  public VideoPlayParam a()
  {
    return this.v;
  }
  
  public boolean a(View paramView)
  {
    boolean bool1 = VideoFeedsHelper.c(b(paramView));
    boolean bool3 = false;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int i1 = VideoFeedsHelper.i();
    if (i1 == 0) {
      return false;
    }
    float f1 = ReadInJoyDisplayUtils.a(paramView);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("VideoColumnItemViewHolder() canAutoPlay percent:");
      paramView.append(f1);
      QLog.d("Q.readinjoy.video", 2, paramView.toString());
    }
    if (i1 == 1)
    {
      bool1 = bool2;
      if (VideoAutoPlayController.getInstance().isWifi())
      {
        bool1 = bool2;
        if (f1 >= 70.0F) {
          bool1 = true;
        }
      }
      return bool1;
    }
    bool1 = bool3;
    if (i1 == 2)
    {
      bool1 = bool3;
      if (f1 >= 70.0F) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int b()
  {
    return this.P;
  }
  
  public void onClick(View paramView)
  {
    VideoHandler.b(paramView);
    switch (paramView.getId())
    {
    default: 
      d(paramView);
      return;
    case 2131446570: 
      e(paramView);
      return;
    case 2131435357: 
    case 2131449619: 
      f(paramView);
      return;
    case 2131434958: 
      d(paramView);
      return;
    }
    g(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.VideoColumnItemViewHolder
 * JD-Core Version:    0.7.0.1
 */