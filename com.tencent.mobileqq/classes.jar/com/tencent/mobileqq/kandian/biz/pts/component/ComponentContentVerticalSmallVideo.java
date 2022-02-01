package com.tencent.mobileqq.kandian.biz.pts.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper.VideoPackSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ComponentContentVerticalSmallVideo
  extends ComponentContentBig
{
  FrameLayout f;
  KandianUrlImageView g;
  View h;
  KandianUrlImageView i;
  TextView j;
  TextView k;
  TextView l;
  TextView m;
  ImageView n;
  Pair<Integer, Integer> o;
  public boolean p = false;
  
  public ComponentContentVerticalSmallVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static ShapeDrawable a(int paramInt, Context paramContext)
  {
    float f1 = DisplayUtil.a(paramContext, 2.0F);
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
    paramContext.getPaint();
    paramContext.getPaint().setColor(paramInt);
    return paramContext;
  }
  
  @SuppressLint({"Range"})
  private void c()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mVideoArticleSubsText))
    {
      String str;
      if (TextUtils.isEmpty(localAbsBaseArticleInfo.mVideoArticleSubsColor)) {
        str = "#FE6c6c";
      } else {
        str = localAbsBaseArticleInfo.mVideoArticleSubsColor;
      }
      try
      {
        this.m.setTextColor(Color.parseColor("#ffffff"));
        ApiCompatibilityUtils.a(this.m, a(Color.parseColor(str), getContext()));
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 2, "configDefaultItem: ", localException);
        }
        this.m.setTextColor(Color.parseColor("#ffffff"));
        ApiCompatibilityUtils.a(this.m, a(Color.parseColor("#FE6c6c"), getContext()));
      }
      this.m.setText(localAbsBaseArticleInfo.mVideoArticleSubsText);
      this.m.setVisibility(0);
      return;
    }
    this.m.setVisibility(8);
  }
  
  public URL a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, String paramString)
  {
    if (paramAbsBaseArticleInfo.mPolymericSmallVideoCoverUrl == null) {
      if (!TextUtils.isEmpty(paramString)) {
        paramAbsBaseArticleInfo.mPolymericSmallVideoCoverUrl = RIJConvertString2URL.b(RIJSmartCropUtils.a(paramString, paramInt1, paramInt2));
      } else {
        return null;
      }
    }
    return paramAbsBaseArticleInfo.mPolymericSmallVideoCoverUrl;
  }
  
  public void a(View paramView)
  {
    this.g = ((KandianUrlImageView)paramView.findViewById(2131435436));
    this.i = ((KandianUrlImageView)paramView.findViewById(2131435435));
    this.j = ((TextView)paramView.findViewById(2131430372));
    this.l = ((TextView)paramView.findViewById(2131431069));
    this.k = ((TextView)paramView.findViewById(2131449653));
    this.m = ((TextView)paramView.findViewById(2131446615));
    this.h = paramView.findViewById(2131435437);
    this.f = ((FrameLayout)paramView.findViewById(2131445159));
    this.n = ((ImageView)paramView.findViewById(2131440385));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)paramObject;
      this.a.a(localIReadInJoyModel);
      boolean bool;
      if (localIReadInJoyModel.q() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.p = bool;
      paramObject = localIReadInJoyModel.k();
      if (paramObject == null) {
        return;
      }
      if (RIJFeedsType.l(paramObject))
      {
        this.o = new Pair(Integer.valueOf(AIOUtils.b(165.0F, getResources())), Integer.valueOf(AIOUtils.b(293.0F, getResources())));
        findViewById(2131431747).setVisibility(8);
      }
      else if (this.p)
      {
        this.o = RIJComponentConfigImage.a(3, this.a.a.m());
      }
      else
      {
        this.o = RIJComponentConfigImage.a(this.a.a.q(), this.a.a.m());
      }
      b();
      if (this.a.a.m() == 56) {
        this.f.setForeground(getResources().getDrawable(2130844259));
      } else {
        this.f.setForeground(null);
      }
      Object localObject2;
      if (this.p)
      {
        localObject2 = RIJComponentConfigImage.a(1, this.a.a.m());
        localObject2 = URLDrawable.getDrawable(b(localIReadInJoyModel), ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue(), new ColorDrawable(-1447447), new ColorDrawable(-1447447));
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.t);
        this.g.setImageDrawable((Drawable)localObject2);
        this.g.setVisibility(0);
        this.h.setVisibility(0);
      }
      else
      {
        this.g.setVisibility(8);
        this.h.setVisibility(8);
      }
      this.i.setImagePlaceHolder(new ColorDrawable(-1447447));
      try
      {
        this.i.setImage(b(localIReadInJoyModel));
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("bindData setVideoCover failed. Exception e = ");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, ((StringBuilder)localObject2).toString());
      }
      if (RIJFeedsType.l(paramObject))
      {
        this.l.setVisibility(8);
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        this.n.setVisibility(0);
      }
      else
      {
        Object localObject1 = ReadInJoyHelper.aa(BaseApplicationImpl.getApplication().getRuntime());
        if ((localObject1 != null) && (((ReadInJoyHelper.VideoPackSetting)localObject1).a))
        {
          this.n.setVisibility(0);
          this.k.setCompoundDrawablePadding(AIOUtils.b(3.0F, getResources()));
          this.k.setCompoundDrawablesWithIntrinsicBounds(2130851342, 0, 0, 0);
        }
        else
        {
          this.n.setVisibility(8);
        }
        if ((localObject1 != null) && (!((ReadInJoyHelper.VideoPackSetting)localObject1).f))
        {
          this.j.setVisibility(8);
        }
        else
        {
          if ((localObject1 != null) && (((ReadInJoyHelper.VideoPackSetting)localObject1).b > 0)) {
            this.j.setMaxLines(((ReadInJoyHelper.VideoPackSetting)localObject1).b);
          }
          if (RIJItemViewTypeUtils.x(paramObject)) {
            this.j.setText(paramObject.mTitle);
          } else {
            this.j.setText(((UGCVideoInfo)paramObject.mSocialFeedInfo.s.c.get(0)).e);
          }
        }
        if ((localObject1 != null) && (!((ReadInJoyHelper.VideoPackSetting)localObject1).g))
        {
          this.l.setVisibility(8);
          this.k.setVisibility(8);
        }
        else
        {
          localObject1 = this.l;
          localObject2 = getResources();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramObject.getCommentCount());
          localStringBuilder.append("");
          ((TextView)localObject1).setText(((Resources)localObject2).getString(2131915273, new Object[] { localStringBuilder.toString() }));
          if (paramObject.mVideoPlayCount <= 0) {
            this.k.setText("0");
          } else {
            this.k.setText(VideoFeedsHelper.c(paramObject.mVideoPlayCount));
          }
        }
      }
      c();
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626185, this, true);
  }
  
  public URL b(IReadInJoyModel paramIReadInJoyModel)
  {
    Object localObject2 = paramIReadInJoyModel.k();
    boolean bool = ComponentPolymericView.a(paramIReadInJoyModel);
    paramIReadInJoyModel = null;
    Object localObject1 = null;
    StringBuilder localStringBuilder;
    if (bool)
    {
      paramIReadInJoyModel = ((NewPolymericInfo.PackArticleInfo)((AbsBaseArticleInfo)localObject2).mNewPolymericInfo.p.get(0)).d;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUrl new polymeric video cover rawUrl = ");
        localStringBuilder.append(paramIReadInJoyModel);
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, localStringBuilder.toString());
      }
      localObject2 = a((AbsBaseArticleInfo)localObject2, ((Integer)this.o.first).intValue(), ((Integer)this.o.second).intValue(), paramIReadInJoyModel);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUrl new polymeric video cover after smartcut url = ");
        paramIReadInJoyModel = (IReadInJoyModel)localObject1;
        if (localObject2 != null) {
          paramIReadInJoyModel = ((URL)localObject2).getFile();
        }
        localStringBuilder.append(paramIReadInJoyModel);
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, localStringBuilder.toString());
      }
      return localObject2;
    }
    localObject1 = ((AbsBaseArticleInfo)localObject2).getVideoCoverURL();
    if (localObject1 != null)
    {
      localObject1 = ((URL)localObject1).getFile();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUrl old polymeric video cover rawUrl = ");
        localStringBuilder.append((String)localObject1);
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, localStringBuilder.toString());
      }
      localObject1 = a((AbsBaseArticleInfo)localObject2, ((Integer)this.o.first).intValue(), ((Integer)this.o.second).intValue(), (String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getUrl old polymeric video cover after smartcut url = ");
        if (localObject1 != null) {
          paramIReadInJoyModel = ((URL)localObject1).getFile();
        }
        ((StringBuilder)localObject2).append(paramIReadInJoyModel);
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    return ((AbsBaseArticleInfo)localObject2).getVideoCoverURL();
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.i.getLayoutParams();
    localLayoutParams.width = ((Integer)this.o.first).intValue();
    localLayoutParams.height = ((Integer)this.o.second).intValue();
    this.i.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentVerticalSmallVideo
 * JD-Core Version:    0.7.0.1
 */