package com.tencent.weseevideo.model.resource;

import android.support.annotation.NonNull;
import com.tencent.weseevideo.model.BaseMediaModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaResourceModel
  extends BaseMediaModel
{
  private List<MediaClipModel> backgroundMusic = new ArrayList();
  private List<MediaClipModel> recordAudios = new ArrayList();
  private List<MediaClipModel> videos = new ArrayList();
  
  public MediaResourceModel clone()
  {
    MediaResourceModel localMediaResourceModel = new MediaResourceModel();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = getVideos().iterator();
    while (localIterator.hasNext()) {
      localArrayList1.add(((MediaClipModel)localIterator.next()).clone());
    }
    localIterator = getRecordAudios().iterator();
    while (localIterator.hasNext()) {
      localArrayList2.add(((MediaClipModel)localIterator.next()).clone());
    }
    localIterator = getBackgroundMusic().iterator();
    while (localIterator.hasNext()) {
      localArrayList3.add(((MediaClipModel)localIterator.next()).clone());
    }
    localMediaResourceModel.setVideos(localArrayList1);
    localMediaResourceModel.setRecordAudios(localArrayList2);
    localMediaResourceModel.setBackgroundMusic(localArrayList3);
    return localMediaResourceModel;
  }
  
  @NonNull
  public List<MediaClipModel> getBackgroundMusic()
  {
    return this.backgroundMusic;
  }
  
  @NonNull
  public List<MediaClipModel> getRecordAudios()
  {
    return this.recordAudios;
  }
  
  @NonNull
  public List<MediaClipModel> getVideos()
  {
    return this.videos;
  }
  
  public void setBackgroundMusic(@NonNull List<MediaClipModel> paramList)
  {
    this.backgroundMusic = paramList;
  }
  
  public void setRecordAudios(@NonNull List<MediaClipModel> paramList)
  {
    this.recordAudios = paramList;
  }
  
  public void setVideos(@NonNull List<MediaClipModel> paramList)
  {
    this.videos = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.MediaResourceModel
 * JD-Core Version:    0.7.0.1
 */