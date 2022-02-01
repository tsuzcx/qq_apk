package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.WeishiRedDotInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class VideoPlayRecommendHandler$2
  implements Runnable
{
  VideoPlayRecommendHandler$2(VideoPlayRecommendHandler paramVideoPlayRecommendHandler, ArrayList paramArrayList1, VideoPlayRecommendObserver paramVideoPlayRecommendObserver, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList paramArrayList2, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, int paramInt4, int paramInt5, int paramInt6, ArrayList paramArrayList3, int paramInt7) {}
  
  public void run()
  {
    ArrayList localArrayList = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).convertAdTagInfos(this.jdField_a_of_type_JavaUtilArrayList);
    VideoPlayRecommendHandler.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructWeishiRedDotInfo, this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, localArrayList, this.jdField_d_of_type_Int, this.e, this.f, 0, this.jdField_c_of_type_JavaUtilArrayList, null, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler.2
 * JD-Core Version:    0.7.0.1
 */