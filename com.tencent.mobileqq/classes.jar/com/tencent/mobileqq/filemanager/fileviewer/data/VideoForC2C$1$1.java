package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.CheckResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class VideoForC2C$1$1
  implements QQFileManagerUtil.CheckResult
{
  VideoForC2C$1$1(VideoForC2C.1 param1, long paramLong, boolean paramBoolean1, String paramString1, Bundle paramBundle, short paramShort, boolean paramBoolean2, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("shouq_bus_type", "bus_type_video_file");
      localObject2 = new TVK_PlayerVideoInfo();
      ((TVK_PlayerVideoInfo)localObject2).setReportInfoMap((Map)localObject1);
      ((TVK_PlayerVideoInfo)localObject2).setPlayType(4);
      ((TVK_PlayerVideoInfo)localObject2).setConfigMap("RawVideoPlay", "true");
      ((TVK_PlayerVideoInfo)localObject2).setConfigMap("keep_last_frame", "true");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForC2C$1.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoDownloadManager$FileVideoManagerCallback.a();
      return;
    }
    long l = this.jdField_a_of_type_Long;
    if (l != -100001L)
    {
      if ((l == -25081L) || (l == -6101L) || (l == -7003L)) {
        break label393;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForC2C$1.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoDownloadManager$FileVideoManagerCallback.a((int)9045L, BaseApplication.getContext().getResources().getString(2131690964));
        return;
      }
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    if ((localObject1 != null) && (((String)localObject1).length() != 0))
    {
      Object localObject3 = this.jdField_a_of_type_JavaLangString;
      localObject1 = null;
      Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
      localObject2 = "";
      if (localBundle != null)
      {
        localObject2 = localBundle.getString("IPv6Dns", "");
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("ipv6list");
      }
      localObject2 = VideoForC2C.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForC2C$1.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForC2C, (String)localObject2, this.jdField_a_of_type_Short, (List)localObject1, this.jdField_b_of_type_Boolean);
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localObject2;
      }
      localObject2 = this.jdField_b_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("http://");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append(String.valueOf(this.jdField_a_of_type_Short));
      ((StringBuilder)localObject3).append(this.c);
      localObject1 = ((StringBuilder)localObject3).toString();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForC2C$1.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoDownloadManager$FileVideoManagerCallback.a((String)localObject1, (String)localObject2);
      return;
    }
    l = 9360L;
    if (this.jdField_a_of_type_Long == 0L) {
      l = 9048L;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForC2C$1.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoDownloadManager$FileVideoManagerCallback.a((int)l, BaseApplication.getContext().getResources().getString(2131690964));
    return;
    label393:
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForC2C$1.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForC2C.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataVideoForC2C$1.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoDownloadManager$FileVideoManagerCallback.a((int)this.jdField_a_of_type_Long, BaseApplication.getContext().getResources().getString(2131692751));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C.1.1
 * JD-Core Version:    0.7.0.1
 */