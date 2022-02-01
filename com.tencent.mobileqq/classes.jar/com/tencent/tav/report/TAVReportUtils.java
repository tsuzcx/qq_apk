package com.tencent.tav.report;

import android.media.MediaCodec.BufferInfo;

public class TAVReportUtils
{
  public static String a(MediaCodec.BufferInfo paramBufferInfo)
  {
    if (paramBufferInfo == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BufferInfo{offset=");
    localStringBuilder.append(paramBufferInfo.offset);
    localStringBuilder.append(", size=");
    localStringBuilder.append(paramBufferInfo.size);
    localStringBuilder.append(", presentationTimeUs=");
    localStringBuilder.append(paramBufferInfo.presentationTimeUs);
    localStringBuilder.append(", flags=");
    localStringBuilder.append(paramBufferInfo.flags);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.report.TAVReportUtils
 * JD-Core Version:    0.7.0.1
 */