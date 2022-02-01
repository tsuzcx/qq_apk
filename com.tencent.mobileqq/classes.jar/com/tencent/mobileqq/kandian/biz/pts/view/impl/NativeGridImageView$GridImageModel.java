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
  private List<SquareCornerTextImageView.PicInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<URL> b = new ArrayList();
  
  public NativeGridImageView$GridImageModel(NativeGridImageView paramNativeGridImageView, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.a.size() > 0))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.a.a;
      i = 0;
      if (i >= paramAbsBaseArticleInfo.size()) {}
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList.size() >= 9) {
          break label382;
        }
        if ((((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).jdField_b_of_type_JavaLangString != null) || (((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).jdField_c_of_type_JavaLangString != null))
        {
          if (((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).jdField_b_of_type_JavaLangString != null) {
            paramNativeGridImageView = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).jdField_b_of_type_JavaLangString;
          } else {
            paramNativeGridImageView = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).jdField_c_of_type_JavaLangString;
          }
          Object localObject = new URL(paramNativeGridImageView);
          if (((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).jdField_c_of_type_JavaLangString != null) {
            paramNativeGridImageView = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).jdField_c_of_type_JavaLangString;
          } else {
            paramNativeGridImageView = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).jdField_b_of_type_JavaLangString;
          }
          paramNativeGridImageView = new URL(paramNativeGridImageView);
          this.b.add(localObject);
          localObject = this.jdField_a_of_type_JavaUtilList;
          int j = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).a;
          int k = ((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).jdField_b_of_type_Int;
          if (((PGCPicInfo)paramAbsBaseArticleInfo.get(i)).jdField_c_of_type_Int != 1) {
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
      if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
        ((SquareCornerTextImageView.PicInfo)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      }
      return;
      label413:
      boolean bool = false;
    }
  }
  
  public List<SquareCornerTextImageView.PicInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<URL> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeGridImageView.GridImageModel
 * JD-Core Version:    0.7.0.1
 */