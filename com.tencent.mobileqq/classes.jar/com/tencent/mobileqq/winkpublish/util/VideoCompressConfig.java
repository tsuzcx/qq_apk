package com.tencent.mobileqq.winkpublish.util;

import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;

public class VideoCompressConfig
{
  public static boolean a()
  {
    String str = QCircleHostQzoneHelper.KEY_UPLOAD_KEEP_VIDEO_CACHE();
    boolean bool = false;
    if (QCircleHostQzoneHelper.getInt(str, 0) == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.VideoCompressConfig
 * JD-Core Version:    0.7.0.1
 */