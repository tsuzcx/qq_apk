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
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (MovieSegmentModel)paramObject;
    } while (((this.videoResourceModels == paramObject.videoResourceModels) || ((this.videoResourceModels != null) && (this.videoResourceModels.equals(paramObject.videoResourceModels)))) && (this.timeRange != null) && (this.timeRange.equals(paramObject.timeRange)) && (this.minDuration != null) && (this.minDuration.equalsTo(paramObject.minDuration)));
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
    return "MovieSegmentModel{videoResourceModels=" + this.videoResourceModels + ", timeRange=" + this.timeRange + ", minDuration=" + this.minDuration + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.movie.MovieSegmentModel
 * JD-Core Version:    0.7.0.1
 */