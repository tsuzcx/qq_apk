package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Bundle;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.av.utils.GVideoGrayConfig.GVideoPreDownloadListener;
import com.tencent.qphone.base.util.QLog;

class GroupVideoManager$1
  implements GVideoGrayConfig.GVideoPreDownloadListener
{
  GroupVideoManager$1(GroupVideoManager paramGroupVideoManager, String paramString) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "start slientDownloadPlugin onResult:" + paramInt);
    }
    GVideoGrayConfig.a().a();
    if (paramInt == 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("roomCodeType", 1);
      localBundle.putLong("roomid", Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue());
      GroupVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGroupVideoManager, localBundle, 1001L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.1
 * JD-Core Version:    0.7.0.1
 */