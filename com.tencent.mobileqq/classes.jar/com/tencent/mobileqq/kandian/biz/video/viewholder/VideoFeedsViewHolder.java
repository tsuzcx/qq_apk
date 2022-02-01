package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig;

public class VideoFeedsViewHolder
  extends ViewHolder
  implements PlayableItem
{
  public View A;
  public View B;
  public LinearLayout C;
  public TextView D;
  public LinearLayout E;
  public TextView F;
  public ImageView G;
  public KandianUrlImageView H;
  public RoundAngleFrameLayout a;
  public TextView b;
  public KandianUrlImageView c;
  public RelativeLayout d;
  public ReadInJoyNickNameTextView e;
  public ReadInJoyHeadImageView f;
  public ViewGroup g;
  public TextView h;
  public VideoViewGroup i;
  public TextView j;
  public ImageView k;
  public ImageView l;
  public ImageView m;
  public boolean n = false;
  public Handler o = new Handler(Looper.getMainLooper());
  public TextView p;
  public TextView q;
  public View r;
  public ReadInJoyVideoInfoViewGroup s;
  public VideoPlayParam t;
  public ViewGroup u;
  public View v;
  public View w;
  public ImageView x;
  public TextView y;
  public TextView z;
  
  public VideoFeedsViewHolder(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.N).inflate(2131626421, paramViewGroup, false);
    this.u = ((ViewGroup)paramViewGroup.findViewById(2131433072));
    this.a = ((RoundAngleFrameLayout)paramViewGroup.findViewById(2131449704));
    this.b = ((TextView)paramViewGroup.findViewById(2131447463));
    this.c = ((KandianUrlImageView)paramViewGroup.findViewById(2131435357));
    this.d = ((RelativeLayout)paramViewGroup.findViewById(2131449611));
    this.g = ((ViewGroup)paramViewGroup.findViewById(2131427438));
    this.f = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131435219));
    this.e = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131444254));
    this.h = ((TextView)paramViewGroup.findViewById(2131432267));
    this.j = ((TextView)paramViewGroup.findViewById(2131440832));
    this.k = ((ImageView)paramViewGroup.findViewById(2131435496));
    this.l = ((ImageView)paramViewGroup.findViewById(2131435495));
    this.m = ((ImageView)paramViewGroup.findViewById(2131449535));
    if (RIJSocialBottomViewAladdinConfig.b())
    {
      this.l.setVisibility(0);
      this.m.setVisibility(8);
    }
    else
    {
      this.l.setVisibility(8);
      this.m.setVisibility(0);
    }
    this.p = ((TextView)paramViewGroup.findViewById(2131449623));
    this.q = ((TextView)paramViewGroup.findViewById(2131440378));
    this.i = ((VideoViewGroup)paramViewGroup.findViewById(2131449619));
    this.v = paramViewGroup.findViewById(2131444659);
    this.w = paramViewGroup.findViewById(2131449611);
    this.r = paramViewGroup.findViewById(2131444214);
    this.s = ((ReadInJoyVideoInfoViewGroup)paramViewGroup.findViewById(2131436837));
    this.x = ((ImageView)paramViewGroup.findViewById(2131439638));
    this.y = ((TextView)paramViewGroup.findViewById(2131439639));
    this.z = ((TextView)paramViewGroup.findViewById(2131436799));
    this.A = paramViewGroup.findViewById(2131447534);
    this.B = paramViewGroup.findViewById(2131447566);
    this.C = ((LinearLayout)paramViewGroup.findViewById(2131437026));
    this.D = ((TextView)paramViewGroup.findViewById(2131427745));
    this.E = ((LinearLayout)paramViewGroup.findViewById(2131436871));
    this.F = ((TextView)paramViewGroup.findViewById(2131427664));
    this.G = ((ImageView)paramViewGroup.findViewById(2131427660));
    this.H = ((KandianUrlImageView)paramViewGroup.findViewById(2131433090));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
  
  public VideoPlayParam a()
  {
    return this.t;
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public boolean a(View paramView)
  {
    boolean bool2 = VideoFeedsHelper.c(b(paramView));
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (ReadInJoyDisplayUtils.a(paramView) >= 80.0F) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int b()
  {
    return this.P;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder
 * JD-Core Version:    0.7.0.1
 */