package com.tencent.mobileqq.filemanager.openbrowser;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.core.IFileVideoDownloadInfoListener;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserProviderCallBack;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;

class MediaFileBrowseProcessorBase$1
  implements IFileVideoDownloadInfoListener
{
  MediaFileBrowseProcessorBase$1(MediaFileBrowseProcessorBase paramMediaFileBrowseProcessorBase, BaseVideoBiz paramBaseVideoBiz, long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerOpenbrowserMediaFileBrowseProcessorBase.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerOpenbrowserMediaFileBrowseProcessorBase.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, "I:E", new String[] { String.valueOf(paramInt), paramString }, null, null, -1, null);
    }
  }
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerOpenbrowserMediaFileBrowseProcessorBase.a != null)
    {
      ArrayList localArrayList = paramSuperPlayerVideoInfo.getCookie();
      Bundle localBundle = new Bundle();
      localBundle.putString("savepath", paramSuperPlayerVideoInfo.getLocalSavePath());
      localBundle.putStringArrayList("cookies", localArrayList);
      localBundle.putString("contextid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.a());
      localBundle.putString("fileid", paramSuperPlayerVideoInfo.getFileId());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerOpenbrowserMediaFileBrowseProcessorBase.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz.b(), paramSuperPlayerVideoInfo.getPlayUrls(), null, null, -1, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.MediaFileBrowseProcessorBase.1
 * JD-Core Version:    0.7.0.1
 */