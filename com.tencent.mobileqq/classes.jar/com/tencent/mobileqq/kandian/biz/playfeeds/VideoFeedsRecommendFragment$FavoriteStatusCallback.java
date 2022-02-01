package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashSet;

class VideoFeedsRecommendFragment$FavoriteStatusCallback
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  private VideoFeedsRecommendFragment$FavoriteStatusCallback(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleDoFavoriteResult isSuccess = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", operationType = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", cid = ");
    localStringBuilder.append(paramString2);
    VideoFeedsPlayActivity.a(localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = VideoFeedsRecommendFragment.a(this.a).a(paramString1);
    if (paramString1 == null) {
      return;
    }
    if ((paramBoolean) && (paramInt == 1))
    {
      paramString1.a.add(paramString2);
      if (!paramString1.c) {
        new ArrayList(paramString1.a);
      }
    }
    if (paramString1.d)
    {
      paramString2 = new QQToast(this.a.getBaseActivity().getApplicationContext());
      paramString2.d(2000);
      if (paramBoolean)
      {
        paramString2.a(QQToast.a(2));
        paramString2.c(2131692185);
        paramString2.b(this.a.getBaseActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(this.a.getBaseActivity().getApplicationContext(), 5.0F));
      }
      else
      {
        paramString2.a(QQToast.a(1));
        paramString2.c(2131692186);
        paramString2.b(this.a.getBaseActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(this.a.getBaseActivity().getApplicationContext(), 5.0F));
        paramString1.c = false;
      }
      paramString1.d = false;
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleFavoriteStatus isSuccess = ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", rowkey = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", isFavorite = ");
    localStringBuilder.append(paramBoolean2);
    VideoFeedsPlayActivity.a(localStringBuilder.toString());
    if (paramBoolean1)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = VideoFeedsRecommendFragment.a(this.a).a(paramString);
      if (paramString != null)
      {
        paramString.c = paramBoolean2;
        paramString.a.addAll(paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.FavoriteStatusCallback
 * JD-Core Version:    0.7.0.1
 */