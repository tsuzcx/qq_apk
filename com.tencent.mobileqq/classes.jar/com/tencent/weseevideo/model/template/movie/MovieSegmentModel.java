package com.tencent.weseevideo.model.template.movie;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.ArrayList;
import java.util.Iterator;

public class MovieSegmentModel
{
  private CMTime minDuration = CMTime.CMTimeZero;
  private CMTimeRange timeRange = CMTimeRange.CMTimeRangeInvalid;
  private ArrayList<VideoResourceModel> videoResourceModels = new ArrayList();
  
  public MovieSegmentModel clone()
  {
    MovieSegmentModel localMovieSegmentModel = new MovieSegmentModel();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.videoResourceModels.iterator();
    while (localIterator.hasNext())
    {
      VideoResourceModel localVideoResourceModel = (VideoResourceModel)localIterator.next();
      if (localVideoResourceModel != null) {
        localArrayList.add(localVideoResourceModel.clone());
      }
    }
    localMovieSegmentModel.setVideoResourceModels(localArrayList);
    localMovieSegmentModel.setTimeRange(this.timeRange.clone());
    localMovieSegmentModel.setMinDuration(this.minDuration.clone());
    return localMovieSegmentModel;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (MovieSegmentModel)paramObject;
      Object localObject = this.videoResourceModels;
      ArrayList localArrayList = paramObject.videoResourceModels;
      if ((localObject == localArrayList) || ((localObject != null) && (((ArrayList)localObject).equals(localArrayList))))
      {
        localObject = this.timeRange;
        if ((localObject != null) && (((CMTimeRange)localObject).equals(paramObject.timeRange)))
        {
          localObject = this.minDuration;
          if ((localObject != null) && (((CMTime)localObject).equalsTo(paramObject.minDuration))) {
            return true;
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public CMTime getMinDuration()
  {
    return this.minDuration;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  @NonNull
  public ArrayList<VideoResourceModel> getVideoResourceModels()
  {
    return this.videoResourceModels;
  }
  
  public void setMinDuration(CMTime paramCMTime)
  {
    this.minDuration = paramCMTime;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public void setVideoResourceModels(@NonNull ArrayList<VideoResourceModel> paramArrayList)
  {
    this.videoResourceModels = paramArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MovieSegmentModel{videoResourceModels=");
    localStringBuilder.append(this.videoResourceModels);
    localStringBuilder.append(", timeRange=");
    localStringBuilder.append(this.timeRange);
    localStringBuilder.append(", minDuration=");
    localStringBuilder.append(this.minDuration);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.movie.MovieSegmentModel
 * JD-Core Version:    0.7.0.1
 */