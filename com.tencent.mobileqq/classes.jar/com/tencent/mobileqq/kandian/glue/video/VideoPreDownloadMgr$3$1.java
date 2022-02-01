package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;

class VideoPreDownloadMgr$3$1
  implements Runnable
{
  VideoPreDownloadMgr$3$1(VideoPreDownloadMgr.3 param3, VideoUrlInfo paramVideoUrlInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.b.equals(VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr$3.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr$3.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.a, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.b))
      {
        if (QLog.isColorLevel())
        {
          String str = VideoPreDownloadMgr.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("innerDoPreDownload() 缓冲已存在，跳过, vid=");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.b);
          QLog.i(str, 2, localStringBuilder.toString());
        }
        VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr$3.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr, null);
        VideoPreDownloadMgr.b(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr$3.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr);
        return;
      }
      VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr$3.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.a, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.b, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.d, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr$3.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.3.1
 * JD-Core Version:    0.7.0.1
 */