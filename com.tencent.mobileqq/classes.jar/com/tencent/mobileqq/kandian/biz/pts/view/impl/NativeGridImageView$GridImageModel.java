package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView.PicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class NativeGridImageView$GridImageModel
{
  private List<SquareCornerTextImageView.PicInfo> b = new ArrayList();
  private List<URL> c = new ArrayList();
  
  public NativeGridImageView$GridImageModel(NativeGridImageView paramNativeGridImageView, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.size() > 0))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.t.a;
      i = 0;
      if (i >= paramAbsBaseArticleInfo.size()) {}
    }
    for (;;)
    {
      try
      {
        if (this.b.size() >= 9) {
          break label382;
        }
        if ((((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).d != null) || (((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).e != null))
        {
          if (((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).d != null) {
            paramNativeGridImageView = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).d;
          } else {
            paramNativeGridImageView = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).e;
          }
          Object localObject = new URL(paramNativeGridImageView);
          if (((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).e != null) {
            paramNativeGridImageView = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).e;
          } else {
            paramNativeGridImageView = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).d;
          }
          paramNativeGridImageView = new URL(paramNativeGridImageView);
          this.c.add(localObject);
          localObject = this.b;
          int j = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).a;
          int k = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).b;
          if (((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).f != 1) {
            break label413;
          }
          bool = true;
          ((List)localObject).add(new SquareCornerTextImageView.PicInfo(j, k, paramNativeGridImageView, bool));
        }
      }
      catch (Exception paramNativeGridImageView)
      {
        paramNativeGridImageView.printStackTrace();
        QLog.d("Proteus.NativeGridImageView", 1, "GridImageModel exception.");
      }
      i += 1;
      break;
      label382:
      if (this.b.size() == 1) {
        ((SquareCornerTextImageView.PicInfo)this.b.get(0)).a(true);
      }
      return;
      label413:
      boolean bool = false;
    }
  }
  
  public List<SquareCornerTextImageView.PicInfo> a()
  {
    return this.b;
  }
  
  public List<URL> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeGridImageView.GridImageModel
 * JD-Core Version:    0.7.0.1
 */