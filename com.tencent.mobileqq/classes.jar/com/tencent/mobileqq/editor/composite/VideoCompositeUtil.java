package com.tencent.mobileqq.editor.composite;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.editor.composite.step.HwVideoMerge;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class VideoCompositeUtil
{
  public static int a(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".temp.mp4");
    localObject = ((StringBuilder)localObject).toString();
    SLog.b("VideoCompositeUtil", "reEncodeVideoWithFFmpeg start!");
    int i = 0;
    int j = HwVideoMerge.ffmpegReCodec(paramString, (String)localObject, 0);
    if (j != 0)
    {
      paramString = new StringBuilder();
      paramString.append("[NewVersion]HwVideoMerge->merge: errcode=");
      paramString.append(j);
      QLog.e("VideoCompositeUtil", 2, paramString.toString());
      i = j;
    }
    else
    {
      FileUtils.deleteFile(paramString);
      FileUtils.rename((String)localObject, paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("reEncodeVideoWithFFmpeg cost=");
      paramString.append(System.currentTimeMillis() - l);
      QLog.i("VideoCompositeUtil", 2, paramString.toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeUtil
 * JD-Core Version:    0.7.0.1
 */