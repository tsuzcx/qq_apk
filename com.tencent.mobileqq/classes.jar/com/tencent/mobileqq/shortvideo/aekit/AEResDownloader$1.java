package com.tencent.mobileqq.shortvideo.aekit;

import awfg;
import awgh;
import bhcs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.List;

public class AEResDownloader$1
  implements Runnable
{
  public AEResDownloader$1(awgh paramawgh, QQAppInterface paramQQAppInterface, List paramList, awfg paramawfg) {}
  
  public void run()
  {
    bhcs.a(awgh.a(), 1, "【AEResDownloader】preDownloadTask 【start】");
    ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Awfg, "new_qq_android_native_short_filter_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.aekit.AEResDownloader.1
 * JD-Core Version:    0.7.0.1
 */