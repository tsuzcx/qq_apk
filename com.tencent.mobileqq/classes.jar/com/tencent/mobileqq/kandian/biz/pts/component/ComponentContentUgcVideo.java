package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class ComponentContentUgcVideo
  extends ComponentContentBigImageVideo
{
  public ComponentContentUgcVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentUgcVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentUgcVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626184, this, true);
  }
  
  public URL b(IReadInJoyModel paramIReadInJoyModel)
  {
    Object localObject1 = paramIReadInJoyModel.k();
    if ((((AbsBaseArticleInfo)localObject1).mSocialFeedInfo != null) && (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.s != null) && (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.s.c.size() > 0))
    {
      Object localObject2 = ((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.s.c;
      int i = 0;
      localObject2 = (UGCVideoInfo)((ArrayList)localObject2).get(0);
      int j = ((UGCVideoInfo)localObject2).j;
      int k = ((UGCVideoInfo)localObject2).k;
      if ((this.b != null) && (this.b.getLayoutParams() != null))
      {
        localObject2 = this.b.getLayoutParams();
        int m = ((ViewGroup.LayoutParams)localObject2).width;
        int n = ((ViewGroup.LayoutParams)localObject2).height;
        if (m == n)
        {
          localObject2 = ((AbsBaseArticleInfo)localObject1).getVideoCoverWithSmartCut(m, n);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder;
            if (localObject2 != null)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("url: ");
              localStringBuilder.append(((URL)localObject2).toString());
              localStringBuilder.append(", ivWidth: ");
              localStringBuilder.append(m);
              localStringBuilder.append(", ivHeight: ");
              localStringBuilder.append(n);
              QLog.d("ComponentContentUgcVideo", 2, localStringBuilder.toString());
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("ivWidth: ");
              localStringBuilder.append(m);
              localStringBuilder.append(", ivHeight: ");
              localStringBuilder.append(n);
              QLog.d("ComponentContentUgcVideo", 2, localStringBuilder.toString());
            }
          }
          if (localObject2 != null) {
            return localObject2;
          }
        }
      }
      if (j * 4 > k * 3) {
        i = 1;
      }
      localObject1 = ((AbsBaseArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(i ^ 0x1);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          paramIReadInJoyModel = new StringBuilder();
          paramIReadInJoyModel.append("url: ");
          paramIReadInJoyModel.append(((URL)localObject1).toString());
          QLog.d("ComponentContentUgcVideo", 2, paramIReadInJoyModel.toString());
        }
        return localObject1;
      }
    }
    return super.b(paramIReadInJoyModel);
  }
  
  public void b()
  {
    if ((this.a.a != null) && (this.a.a.k() != null))
    {
      Object localObject3 = this.a.a.k();
      if ((((AbsBaseArticleInfo)localObject3).mSocialFeedInfo != null) && (((AbsBaseArticleInfo)localObject3).mSocialFeedInfo.s != null) && (((AbsBaseArticleInfo)localObject3).mSocialFeedInfo.s.c.size() > 0))
      {
        Object localObject1 = getLayoutParams();
        Object localObject2 = getResources().getDisplayMetrics();
        int i = Math.min(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
        int j = AIOUtils.b(12.0F, getResources());
        localObject2 = this.b.getLayoutParams();
        Object localObject4 = (UGCVideoInfo)((AbsBaseArticleInfo)localObject3).mSocialFeedInfo.s.c.get(0);
        boolean bool = RIJFeedsType.a(((UGCVideoInfo)localObject4).j, ((UGCVideoInfo)localObject4).k) ^ true;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("isHorizontalScreen ");
        ((StringBuilder)localObject4).append(bool);
        QLog.d("ComponentContentUgcVideo", 2, ((StringBuilder)localObject4).toString());
        if (bool)
        {
          j = i - j * 2;
          i = j * 9 / 16;
        }
        else if (((AbsBaseArticleInfo)localObject3).mChannelID == 0L)
        {
          j = ReadInJoyDisplayUtils.a(i, getResources());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("main feeds | ivWidth is ");
          ((StringBuilder)localObject3).append(j);
          ((StringBuilder)localObject3).append("; ivHeight is ");
          ((StringBuilder)localObject3).append(j);
          QLog.d("ComponentContentUgcVideo", 2, ((StringBuilder)localObject3).toString());
          i = j;
        }
        else
        {
          i -= j * 2;
          j = (i + 9) / 2;
          i /= 3;
          i *= 2;
        }
        ((ViewGroup.LayoutParams)localObject2).width = j;
        ((ViewGroup.LayoutParams)localObject2).height = i;
        ((ViewGroup.LayoutParams)localObject1).width = j;
        ((ViewGroup.LayoutParams)localObject1).height = i;
        this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("imageParams.width is ");
        ((StringBuilder)localObject1).append(((ViewGroup.LayoutParams)localObject2).width);
        ((StringBuilder)localObject1).append("; imageParams.height is ");
        ((StringBuilder)localObject1).append(((ViewGroup.LayoutParams)localObject2).height);
        QLog.d("ComponentContentUgcVideo", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcVideo
 * JD-Core Version:    0.7.0.1
 */