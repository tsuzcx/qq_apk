package com.tencent.tav.asset;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.extractor.AssetExtractor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composition<CTrack extends CompositionTrack>
  extends Asset
{
  protected List<CTrack> tracks = new ArrayList();
  
  protected Composition() {}
  
  protected Composition(@NonNull String paramString)
  {
    super(paramString);
  }
  
  protected Composition(@NonNull URL paramURL)
  {
    super(paramURL);
  }
  
  @TargetApi(16)
  protected void createTracks()
  {
    int j = this.extractor.getTrackCount();
    if (this.tracks == null) {
      this.tracks = new ArrayList();
    }
    int i = 0;
    while (i < j)
    {
      localObject = this.extractor.getTrackFormat(i).getString("mime");
      int k;
      if (((String)localObject).startsWith("video/"))
      {
        k = this.trackIndex;
        this.trackIndex = (k + 1);
        localObject = new CompositionTrack(this, k, 1, new CMTimeRange(CMTime.CMTimeZero, getVideoDuration()));
        this.tracks.add(localObject);
      }
      else if (((String)localObject).startsWith("audio/"))
      {
        k = this.trackIndex;
        this.trackIndex = (k + 1);
        localObject = new CompositionTrack(this, k, 2, new CMTimeRange(CMTime.CMTimeZero, getAudioDuration()));
        this.tracks.add(localObject);
      }
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" Composition createTracks finish, has track count: ");
    ((StringBuilder)localObject).append(this.tracks);
    Log.e("Asset", ((StringBuilder)localObject).toString());
  }
  
  protected CMTime getAudioDuration()
  {
    Object localObject1 = CMTime.CMTimeZero;
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (CompositionTrack)localIterator.next();
      if (((CompositionTrack)localObject2).getMediaType() == 2)
      {
        localObject2 = ((CompositionTrack)localObject2).getDuration();
        if (((CMTime)localObject2).bigThan((CMTime)localObject1)) {
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
  }
  
  public List<CTrack> getTracks()
  {
    return this.tracks;
  }
  
  protected CMTime getVideoDuration()
  {
    Object localObject1 = CMTime.CMTimeZero;
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (CompositionTrack)localIterator.next();
      if (((CompositionTrack)localObject2).getMediaType() == 1)
      {
        localObject2 = ((CompositionTrack)localObject2).getDuration();
        if (((CMTime)localObject2).bigThan((CMTime)localObject1)) {
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
  }
  
  public void loadValuesAsynchronouslyForKeys(List<String> paramList, AsynchronousKeyValueLoading.loadCallback paramloadCallback) {}
  
  public int statusOfValueForKey(String paramString)
  {
    return 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Composition{\ntracks=");
    localStringBuilder.append(this.tracks);
    localStringBuilder.append("\ntrackCount=");
    localStringBuilder.append(this.trackCount);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.asset.Composition
 * JD-Core Version:    0.7.0.1
 */