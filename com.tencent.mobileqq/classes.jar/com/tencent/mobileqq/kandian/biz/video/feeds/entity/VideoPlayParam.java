package com.tencent.mobileqq.kandian.biz.video.feeds.entity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.video.api.IFeedsChannelDataHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;

public class VideoPlayParam
  extends BaseVideoPlayParam
{
  public Bundle a;
  public View a;
  public ViewGroup a;
  public IVideoView a;
  public AbsReadInJoyVideoReportData a;
  public AbsBaseArticleInfo a;
  public Map<String, Object> a;
  boolean a;
  public int b;
  public boolean b;
  public int c;
  public long c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public int e = -1;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public long g = -1L;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n = 1;
  public String n;
  public int o;
  public int p;
  public int q;
  public int r;
  
  public VideoPlayParam()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
  }
  
  public VideoInfo a()
  {
    return ((IFeedsChannelDataHelper)QRoute.api(IFeedsChannelDataHelper.class)).getVideoInfoReq(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
  }
  
  public String a()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localAbsBaseArticleInfo != null) {
      return localAbsBaseArticleInfo.getInnerUniqueID();
    }
    return "";
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof VideoPlayParam)) {
      return a().equals(((VideoPlayParam)paramObject).a());
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoPlayParam[");
    localStringBuilder.append(" articleID:");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", videoVid:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", busitype:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", videoDuration:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", position:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      localStringBuilder.append(", title:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTitle);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam
 * JD-Core Version:    0.7.0.1
 */