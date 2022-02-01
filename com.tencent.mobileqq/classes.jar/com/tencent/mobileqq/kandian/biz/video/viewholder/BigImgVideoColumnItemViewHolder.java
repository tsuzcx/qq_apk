package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.qphone.base.util.QLog;

public class BigImgVideoColumnItemViewHolder
  extends ViewHolder
  implements View.OnClickListener, PlayableItem
{
  View a;
  public TextView b;
  public KandianUrlImageView c;
  public TextView d;
  public TextView e;
  public VideoViewGroup f;
  public ImageView g;
  public TextView h;
  public View i;
  public View j;
  public TextView k;
  public View l;
  public TextView m;
  public KandianUrlImageView n;
  public TextView o;
  public ImageView p;
  public VideoPlayParam q;
  
  public BigImgVideoColumnItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  private void d(View paramView)
  {
    if (paramView != null)
    {
      if (this.R == null) {
        return;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramView);
      if (localAbsBaseArticleInfo == null) {
        return;
      }
      if ((VideoFeedsHelper.n() == 1) && (this.R.g().R() != null))
      {
        VideoPlayManager localVideoPlayManager = this.R.g().R();
        if ((localVideoPlayManager != null) && (localVideoPlayManager.k() != null))
        {
          localVideoPlayManager.k().c(paramView);
          return;
        }
      }
      if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.o != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.o.a != 3))
      {
        VideoFeedsHelper.a(this.R.i(), localAbsBaseArticleInfo.mSimpleVideoColumnInfo.o);
      }
      else
      {
        paramView = c(paramView);
        if (paramView != null) {
          this.R.g().a(paramView.a(), localAbsBaseArticleInfo, false, false);
        }
      }
      if (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.o == null) {
        paramView = null;
      } else {
        paramView = localAbsBaseArticleInfo.mSimpleVideoColumnInfo.o.f;
      }
      a(this.R, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mSimpleVideoColumnInfo, 1, paramView);
    }
  }
  
  private void e(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramView);
    if ((localAbsBaseArticleInfo != null) && (this.R != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo != null))
    {
      if ((localAbsBaseArticleInfo.mSimpleVideoColumnInfo.n != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.n.a != 3))
      {
        VideoFeedsHelper.a(this.R.i(), localAbsBaseArticleInfo.mSimpleVideoColumnInfo.n);
      }
      else
      {
        paramView = c(paramView);
        if (paramView != null) {
          this.R.g().a(paramView.a(), localAbsBaseArticleInfo, false, false);
        }
      }
      if (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.n == null) {
        paramView = null;
      } else {
        paramView = localAbsBaseArticleInfo.mSimpleVideoColumnInfo.n.f;
      }
      a(this.R, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mSimpleVideoColumnInfo, 2, paramView);
    }
  }
  
  private void f(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramView);
    if ((localAbsBaseArticleInfo != null) && (this.R != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.q != null))
    {
      VideoFeedsHelper.a(this.R.i(), localAbsBaseArticleInfo.mSimpleVideoColumnInfo.q);
      if (localAbsBaseArticleInfo.mSimpleVideoColumnInfo.q == null) {
        paramView = null;
      } else {
        paramView = localAbsBaseArticleInfo.mSimpleVideoColumnInfo.q.f;
      }
      a(this.R, localAbsBaseArticleInfo, localAbsBaseArticleInfo.mSimpleVideoColumnInfo, 3, paramView);
    }
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.N).inflate(2131626430, paramViewGroup, false);
    this.a = paramViewGroup.findViewById(2131445137);
    this.b = ((TextView)paramViewGroup.findViewById(2131447463));
    this.d = ((TextView)paramViewGroup.findViewById(2131440378));
    this.e = ((TextView)paramViewGroup.findViewById(2131432267));
    this.c = ((KandianUrlImageView)paramViewGroup.findViewById(2131435357));
    this.f = ((VideoViewGroup)paramViewGroup.findViewById(2131449619));
    this.g = ((ImageView)paramViewGroup.findViewById(2131439638));
    this.h = ((TextView)paramViewGroup.findViewById(2131439639));
    this.k = ((TextView)paramViewGroup.findViewById(2131436799));
    this.i = paramViewGroup.findViewById(2131447534);
    this.j = paramViewGroup.findViewById(2131447566);
    this.l = paramViewGroup.findViewById(2131429637);
    this.m = ((TextView)paramViewGroup.findViewById(2131433076));
    this.n = ((KandianUrlImageView)paramViewGroup.findViewById(2131433077));
    this.o = ((TextView)paramViewGroup.findViewById(2131433078));
    this.p = ((ImageView)paramViewGroup.findViewById(2131449096));
    this.c.setTag(this);
    this.c.setOnClickListener(this);
    this.f.setTag(this);
    this.f.setOnClickListener(this);
    this.l.setTag(this);
    this.l.setOnClickListener(this);
    this.n.setTag(this);
    this.n.setOnClickListener(this);
    this.o.setTag(this);
    this.o.setOnClickListener(this);
    this.a.setTag(this);
    this.a.setOnClickListener(this);
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
  
  public VideoPlayParam a()
  {
    return this.q;
  }
  
  public boolean a(View paramView)
  {
    boolean bool1 = VideoFeedsHelper.c(b(paramView));
    boolean bool3 = false;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int i1 = VideoFeedsHelper.m();
    if (i1 == 0) {
      return false;
    }
    float f1 = ReadInJoyDisplayUtils.a(paramView);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("BigImgVideoItemViewHolder() canAutoPlay percent:");
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
      return;
    case 2131435357: 
    case 2131449619: 
      d(paramView);
      return;
    case 2131433077: 
    case 2131433078: 
      f(paramView);
      return;
    }
    e(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoColumnItemViewHolder
 * JD-Core Version:    0.7.0.1
 */