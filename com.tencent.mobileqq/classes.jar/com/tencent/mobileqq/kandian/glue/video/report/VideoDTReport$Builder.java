package com.tencent.mobileqq.kandian.glue.video.report;

import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.RIJDtConstant;
import java.util.HashMap;

public class VideoDTReport$Builder
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private int g = -1;
  
  public static Builder a(VideoPlayParam paramVideoPlayParam)
  {
    Builder localBuilder = new Builder();
    if (paramVideoPlayParam == null) {
      return localBuilder;
    }
    localBuilder.jdField_d_of_type_JavaLangString = paramVideoPlayParam.k;
    localBuilder.jdField_b_of_type_JavaLangString = paramVideoPlayParam.jdField_c_of_type_JavaLangString;
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      localBuilder.jdField_a_of_type_Long = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID;
      localBuilder.jdField_c_of_type_Int = VideoDTReport.a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.videoReportInfo);
      localBuilder.jdField_f_of_type_JavaLangString = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.videoReportInfo;
    }
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null)
    {
      localBuilder.jdField_c_of_type_JavaLangString = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_JavaLangString;
      localBuilder.jdField_b_of_type_Int = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.m;
      localBuilder.jdField_a_of_type_Int = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.l;
    }
    return localBuilder;
  }
  
  public static Builder a(VideoInfo paramVideoInfo)
  {
    Builder localBuilder = new Builder();
    if (paramVideoInfo == null) {
      return localBuilder;
    }
    localBuilder.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localBuilder.jdField_d_of_type_JavaLangString = paramVideoInfo.j;
    localBuilder.jdField_a_of_type_Long = 409409L;
    localBuilder.jdField_c_of_type_Int = VideoDTReport.a(paramVideoInfo.w);
    localBuilder.jdField_c_of_type_JavaLangString = paramVideoInfo.g;
    localBuilder.jdField_b_of_type_Int = paramVideoInfo.b();
    localBuilder.jdField_a_of_type_Int = paramVideoInfo.a();
    localBuilder.jdField_f_of_type_JavaLangString = paramVideoInfo.w;
    return localBuilder;
  }
  
  private boolean a()
  {
    return (this.jdField_f_of_type_JavaLangString != null) || (this.g > 0);
  }
  
  public Builder a(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    this.jdField_d_of_type_Int = i;
    return this;
  }
  
  public HashMap<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", RIJDtConstant.jdField_a_of_type_JavaLangString);
    localHashMap.put("dt_pgid", VideoDTReport.a(this.jdField_a_of_type_JavaLangString));
    localHashMap.put("channel_id", Long.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("vid", VideoDTReport.a(this.jdField_b_of_type_JavaLangString));
    localHashMap.put("rowkey", VideoDTReport.a(this.jdField_c_of_type_JavaLangString));
    localHashMap.put("cid", "");
    localHashMap.put("cmsid", "");
    localHashMap.put("puin", VideoDTReport.a(this.jdField_d_of_type_JavaLangString));
    localHashMap.put("video_height", Integer.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("video_width", Integer.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("is_short", Integer.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("play_sessionid", VideoDTReport.a(this.jdField_e_of_type_JavaLangString));
    localHashMap.put("play_type", Integer.valueOf(this.jdField_d_of_type_Int));
    localHashMap.put("play_loop_type", Integer.valueOf(this.jdField_e_of_type_Int));
    localHashMap.put("backend_info", VideoDTReport.a(this.jdField_f_of_type_JavaLangString));
    return localHashMap;
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder f(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.report.VideoDTReport.Builder
 * JD-Core Version:    0.7.0.1
 */