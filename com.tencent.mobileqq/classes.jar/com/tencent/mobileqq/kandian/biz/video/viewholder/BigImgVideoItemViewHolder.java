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
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.repo.comment.FamilyCommentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class BigImgVideoItemViewHolder
  extends ViewHolder
  implements View.OnClickListener, PlayableItem
{
  View a;
  public TextView b;
  public TextView c;
  public KandianUrlImageView d;
  public TextView e;
  public VideoViewGroup f;
  public ImageView g;
  public TextView h;
  public View i;
  public View j;
  public TextView k;
  public View l;
  public TextView m;
  public TextView n;
  public TextView o;
  public ImageView p;
  public KandianUrlImageView q;
  public TextView r;
  public KandianUrlImageView s;
  public VideoPlayParam t;
  
  public BigImgVideoItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.N).inflate(2131626429, paramViewGroup, false);
    this.a = paramViewGroup.findViewById(2131445137);
    this.b = ((TextView)paramViewGroup.findViewById(2131447463));
    this.c = ((TextView)paramViewGroup.findViewById(2131440378));
    this.e = ((TextView)paramViewGroup.findViewById(2131432267));
    this.d = ((KandianUrlImageView)paramViewGroup.findViewById(2131435357));
    this.f = ((VideoViewGroup)paramViewGroup.findViewById(2131449619));
    this.g = ((ImageView)paramViewGroup.findViewById(2131439638));
    this.h = ((TextView)paramViewGroup.findViewById(2131439639));
    this.k = ((TextView)paramViewGroup.findViewById(2131436799));
    this.i = paramViewGroup.findViewById(2131447534);
    this.j = paramViewGroup.findViewById(2131447566);
    this.l = paramViewGroup.findViewById(2131429637);
    this.m = ((TextView)paramViewGroup.findViewById(2131433089));
    this.n = ((TextView)paramViewGroup.findViewById(2131433074));
    this.o = ((TextView)paramViewGroup.findViewById(2131431069));
    this.p = ((ImageView)paramViewGroup.findViewById(2131449096));
    this.r = ((TextView)paramViewGroup.findViewById(2131433087));
    this.s = ((KandianUrlImageView)paramViewGroup.findViewById(2131433090));
    this.q = ((KandianUrlImageView)paramViewGroup.findViewById(2131436370));
    this.q.setOnClickListener(this);
    this.d.setTag(this);
    this.d.setOnClickListener(this);
    this.f.setTag(this);
    this.f.setOnClickListener(this);
    this.l.setTag(this);
    this.l.setOnClickListener(this);
    this.a.setTag(this);
    this.a.setOnClickListener(this);
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
  
  public VideoPlayParam a()
  {
    return this.t;
  }
  
  public boolean a(View paramView)
  {
    boolean bool1 = VideoFeedsHelper.c(b(paramView));
    boolean bool3 = false;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int i1 = VideoFeedsHelper.k();
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
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
    case 2131436370: 
      paramView = this.R.g().a(this.P);
      if ((paramView != null) && (paramView.familyCommentInfo != null))
      {
        RIJJumpUtils.a(this.N, paramView, paramView.familyCommentInfo.b);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("familyJumpUrl ");
        ((StringBuilder)localObject1).append(paramView.familyCommentInfo.b);
        QLog.d("ReadInJoyBaseAdapter", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      break;
    case 2131435357: 
    case 2131449619: 
      localObject1 = b(paramView);
      if (localObject1 == null) {
        return;
      }
      if ((VideoFeedsHelper.l() == 1) && (this.R.g().R() != null))
      {
        localObject2 = this.R.g().R();
        if ((localObject2 != null) && (((VideoPlayManager)localObject2).k() != null))
        {
          ((VideoPlayManager)localObject2).k().c(paramView);
          return;
        }
      }
      localObject2 = c(paramView);
      if (localObject2 == null) {
        return;
      }
      if (RIJTransMergeKanDianReport.a(paramView.getContext(), (AbsBaseArticleInfo)localObject1))
      {
        this.R.a(((PlayableItem)localObject2).a(), (AbsBaseArticleInfo)localObject1);
        RIJJumpUtils.a(paramView.getContext(), (AbsBaseArticleInfo)localObject1, RIJJumpUtils.f(((AbsBaseArticleInfo)localObject1).getInnerUniqueID()));
        return;
      }
      if (VideoFeedsHelper.b(this.R.i(), (AbsBaseArticleInfo)localObject1).intValue() != -1)
      {
        this.R.a(((PlayableItem)localObject2).a(), (AbsBaseArticleInfo)localObject1);
        return;
      }
      if (localObject2 != null)
      {
        this.R.g().a(((PlayableItem)localObject2).a(), (AbsBaseArticleInfo)localObject1, false, true);
        return;
      }
      break;
    case 2131429637: 
      localObject1 = c(paramView);
      if (localObject1 == null) {
        return;
      }
      localObject2 = this.R.g().a(this.P);
      if (RIJTransMergeKanDianReport.a(paramView.getContext(), (AbsBaseArticleInfo)localObject2))
      {
        this.R.a(((PlayableItem)localObject1).a(), (AbsBaseArticleInfo)localObject2);
        RIJJumpUtils.a(paramView.getContext(), (AbsBaseArticleInfo)localObject2, RIJJumpUtils.f(((AbsBaseArticleInfo)localObject2).getInnerUniqueID()));
        return;
      }
      if (VideoFeedsHelper.b(this.R.i(), (AbsBaseArticleInfo)localObject2).intValue() != -1)
      {
        this.R.a(((PlayableItem)localObject1).a(), (AbsBaseArticleInfo)localObject2);
        return;
      }
      if (localObject1 != null) {
        this.R.g().a(((PlayableItem)localObject1).a(), (AbsBaseArticleInfo)localObject2, false, true);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */