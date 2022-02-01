package com.tencent.qcircle.tavcut.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import java.util.Iterator;
import java.util.List;

public class MediaModelUtils
{
  public static long getTotalSelectDuration(@Nullable MediaResourceModel paramMediaResourceModel)
  {
    if (paramMediaResourceModel == null) {
      return 0L;
    }
    return getTotalSelectDuration(paramMediaResourceModel.getVideos());
  }
  
  public static long getTotalSelectDuration(@NonNull List<MediaClipModel> paramList)
  {
    paramList = paramList.iterator();
    long l = 0L;
    while (paramList.hasNext())
    {
      MediaClipModel localMediaClipModel = (MediaClipModel)paramList.next();
      if (localMediaClipModel != null) {
        l += localMediaClipModel.getResource().getScaleDuration();
      }
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.util.MediaModelUtils
 * JD-Core Version:    0.7.0.1
 */