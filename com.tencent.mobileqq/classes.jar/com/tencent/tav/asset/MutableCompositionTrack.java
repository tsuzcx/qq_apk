package com.tencent.tav.asset;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.ImageDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutableCompositionTrack
  extends CompositionTrack
{
  private String extendedLanguageTag;
  private String languageCode;
  
  MutableCompositionTrack(int paramInt1, int paramInt2)
  {
    this.mediaType = paramInt1;
    this.trackID = paramInt2;
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    Iterator localIterator = this.segments.iterator();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (!localIterator.hasNext()) {
        break;
      }
      CompositionTrackSegment localCompositionTrackSegment = (CompositionTrackSegment)localIterator.next();
      if (localCompositionTrackSegment.timeRange.containsTime(paramCMTime))
      {
        j = 1;
        break;
      }
      localCMTime = localCompositionTrackSegment.timeRange.getEnd();
      i += 1;
    }
    int m = i;
    k = j;
    if (j == 0)
    {
      m = i;
      k = j;
      if (paramCMTime.equalsTo(localCMTime))
      {
        m = i;
        k = j;
        if (i > 0)
        {
          m = i;
          k = j;
          if (paramBoolean)
          {
            m = i - 1;
            k = 1;
          }
        }
      }
    }
    if (k != 0) {
      return m;
    }
    return -1;
  }
  
  private CMTime getSegmentStartCMTime(int paramInt)
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while ((i < paramInt) && (i < this.segments.size()))
    {
      localCMTime = localCMTime.add(((CompositionTrackSegment)this.segments.get(i)).getScaleDuration());
      i += 1;
    }
    return localCMTime;
  }
  
  private long getSegmentStartTime(int paramInt)
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while ((i < paramInt) && (i < this.segments.size()))
    {
      localCMTime = localCMTime.add(((CompositionTrackSegment)this.segments.get(i)).getScaleDuration());
      i += 1;
    }
    return localCMTime.getTimeUs();
  }
  
  private void insertSegment(CompositionTrackSegment paramCompositionTrackSegment, int paramInt)
  {
    if (paramInt >= 0) {
      this.segments.add(paramInt, paramCompositionTrackSegment);
    } else {
      this.segments.add(paramCompositionTrackSegment);
    }
    updateTimeRange();
  }
  
  private void insertTimeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2, AssetTrack paramAssetTrack, int paramInt)
  {
    if ((paramAssetTrack instanceof CompositionTrack))
    {
      insertTimeRange(paramCMTimeRange1, paramCMTimeRange2, (CompositionTrack)paramAssetTrack, paramInt);
      return;
    }
    if (paramAssetTrack != null)
    {
      paramCMTimeRange1 = new CompositionTrackSegment(paramAssetTrack.getSourcePath(), paramAssetTrack.getTrackID(), paramCMTimeRange1, paramCMTimeRange2, paramAssetTrack.getMediaType());
      paramCMTimeRange1.setExtraInfo(paramAssetTrack.getExtraInfo());
    }
    else
    {
      paramCMTimeRange1 = new CompositionTrackSegment(paramCMTimeRange2);
    }
    if (paramInt >= 0) {
      this.segments.add(paramInt, paramCMTimeRange1);
    } else {
      this.segments.add(paramCMTimeRange1);
    }
    updateTimeRange();
  }
  
  private void insertTimeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2, CompositionTrack paramCompositionTrack, int paramInt)
  {
    CMTime localCMTime3 = paramCMTimeRange1.getStart();
    CMTime localCMTime2 = paramCMTimeRange1.getEnd();
    CMTime localCMTime1 = paramCMTimeRange2.getStart();
    float f = (float)paramCMTimeRange2.getDurationUs() * 1.0F / (float)paramCMTimeRange1.getDurationUs();
    Iterator localIterator = paramCompositionTrack.getSegments().iterator();
    while (localIterator.hasNext())
    {
      CompositionTrackSegment localCompositionTrackSegment = (CompositionTrackSegment)localIterator.next();
      paramCMTimeRange2 = localCompositionTrackSegment.getTimeMapping().getTarget();
      Object localObject = paramCMTimeRange2.getStart();
      CMTime localCMTime4 = paramCMTimeRange2.getEnd();
      paramCMTimeRange2 = ((CMTime)localObject).clone();
      paramCompositionTrack = localCMTime4.clone();
      if (((CMTime)localObject).smallThan(localCMTime3)) {
        paramCMTimeRange2 = paramCMTimeRange1.getStart();
      } else if (((CMTime)localObject).bigThan(localCMTime2)) {
        paramCMTimeRange2 = CMTime.CMTimeInvalid;
      }
      if (localCMTime4.smallThan(localCMTime3)) {
        paramCompositionTrack = CMTime.CMTimeInvalid;
      } else if (localCMTime4.bigThan(localCMTime2)) {
        paramCompositionTrack = localCMTime2;
      }
      if ((!paramCMTimeRange2.equalsTo(paramCompositionTrack)) && (paramCMTimeRange2 != CMTime.CMTimeInvalid) && (paramCompositionTrack != CMTime.CMTimeInvalid))
      {
        localObject = paramCMTimeRange2.sub((CMTime)localObject);
        paramCompositionTrack = paramCompositionTrack.sub(paramCMTimeRange2);
        paramCMTimeRange2 = paramCompositionTrack.multi(f);
        paramCompositionTrack = new CMTimeRange(localCompositionTrackSegment.timeMapping.getSource().getStart().add(((CMTime)localObject).divide((float)localCompositionTrackSegment.timeMapping.getTarget().getDurationUs() * 1.0F / (float)localCompositionTrackSegment.timeMapping.getSource().getDurationUs())), paramCompositionTrack);
        localObject = new CMTimeRange(localCMTime1, paramCMTimeRange2);
        localCMTime1 = localCMTime1.add(paramCMTimeRange2);
        paramCMTimeRange2 = new CompositionTrackSegment(localCompositionTrackSegment.getSourcePath(), this.trackID, paramCompositionTrack, (CMTimeRange)localObject, localCompositionTrackSegment.getSourceType());
        paramCMTimeRange2.setExtraInfo(localCompositionTrackSegment.getExtraInfo());
        if (paramInt >= 0)
        {
          this.segments.add(paramInt, paramCMTimeRange2);
          paramInt += 1;
        }
        else
        {
          this.segments.add(paramCMTimeRange2);
        }
      }
    }
    updateTimeRange();
  }
  
  private CompositionTrackSegment[] split(CompositionTrackSegment paramCompositionTrackSegment, CMTime paramCMTime)
  {
    if ((paramCompositionTrackSegment != null) && (!paramCompositionTrackSegment.timeRange.getDuration().smallThan(paramCMTime)))
    {
      float f = (float)paramCMTime.getTimeUs() * 1.0F / (float)paramCompositionTrackSegment.timeRange.getDurationUs();
      Object localObject = paramCompositionTrackSegment.getTimeMapping().getTarget().split(f);
      CMTimeRange[] arrayOfCMTimeRange = paramCompositionTrackSegment.getTimeMapping().getSource().split(f);
      if ((localObject != null) && (arrayOfCMTimeRange != null))
      {
        CompositionTrackSegment localCompositionTrackSegment = new CompositionTrackSegment(paramCompositionTrackSegment.getSourcePath(), paramCompositionTrackSegment.getSourceTrackID(), arrayOfCMTimeRange[0], localObject[0], paramCompositionTrackSegment.getSourceType());
        localCompositionTrackSegment.setExtraInfo(paramCompositionTrackSegment.getExtraInfo());
        localObject = new CompositionTrackSegment(paramCompositionTrackSegment.getSourcePath(), paramCompositionTrackSegment.getSourceTrackID(), arrayOfCMTimeRange[1], localObject[1], paramCompositionTrackSegment.getSourceType());
        ((CompositionTrackSegment)localObject).setExtraInfo(paramCompositionTrackSegment.getExtraInfo());
        localCompositionTrackSegment.scaleDuration = paramCMTime;
        ((CompositionTrackSegment)localObject).scaleDuration = paramCompositionTrackSegment.scaleDuration.sub(paramCMTime);
        return new CompositionTrackSegment[] { localCompositionTrackSegment, localObject };
      }
    }
    return null;
  }
  
  private void updateSegmentStartTimeAfterInserted(CMTime paramCMTime, CMTimeRange paramCMTimeRange)
  {
    int i = findSegmentIndexAt(paramCMTime, false);
    if ((i >= 0) && (i < this.segments.size())) {
      for (;;)
      {
        i += 1;
        if (i >= this.segments.size()) {
          break;
        }
        paramCMTime = (CompositionTrackSegment)this.segments.get(i);
        CMTimeRange localCMTimeRange = paramCMTime.getTimeMapping().getTarget();
        paramCMTime.updateTargetTimeRange(new CMTimeRange(localCMTimeRange.getStart().add(paramCMTimeRange.getDuration()), localCMTimeRange.getDuration().clone()));
      }
    }
  }
  
  private void updateSegmentsStartTimeAfterRemoved(CMTimeRange paramCMTimeRange)
  {
    int i = findSegmentIndexAt(paramCMTimeRange.getStart(), false);
    if ((i >= 0) && (i < this.segments.size())) {
      while (i < this.segments.size())
      {
        CompositionTrackSegment localCompositionTrackSegment = (CompositionTrackSegment)this.segments.get(i);
        CMTimeRange localCMTimeRange = localCompositionTrackSegment.getTimeMapping().getTarget();
        localCompositionTrackSegment.updateTargetTimeRange(new CMTimeRange(localCMTimeRange.getStart().sub(paramCMTimeRange.getDuration().add(CMTime.CMTimeOne).add(CMTime.CMTimeOne)), localCMTimeRange.getDuration().clone()));
        i += 1;
      }
    }
  }
  
  private void updateTimeRange()
  {
    if ((this.segments != null) && (this.segments.size() > 0))
    {
      this.timeRange = new CMTimeRange(((CompositionTrackSegment)this.segments.get(0)).timeRange.getStart(), getDuration());
      return;
    }
    this.timeRange = new CMTimeRange(CMTime.CMTimeZero, CMTime.CMTimeZero);
  }
  
  public void clipRangeAndRemoveOutRange(CMTimeRange paramCMTimeRange)
  {
    if ((paramCMTimeRange != null) && (paramCMTimeRange.getDuration().getTimeUs() > 0L) && (this.segments != null))
    {
      if (this.segments.size() == 0) {
        return;
      }
      Object localObject1 = paramCMTimeRange.getStart();
      Object localObject2 = paramCMTimeRange.getEnd();
      int k = findSegmentIndexAt((CMTime)localObject1, false);
      if (k == -1) {
        return;
      }
      int j = findSegmentIndexAt((CMTime)localObject2, false);
      int i;
      if (j == -1)
      {
        i = this.segments.size() - 1;
      }
      else
      {
        i = j;
        if (getSegmentStartTime(j) == ((CMTime)localObject2).getTimeUs()) {
          i = j - 1;
        }
      }
      long l1 = getSegmentStartTime(k);
      long l2 = getSegmentStartTime(i);
      localObject1 = (CompositionTrackSegment)this.segments.get(k);
      localObject2 = (CompositionTrackSegment)this.segments.get(i);
      l2 = paramCMTimeRange.getEnd().getTimeUs() - l2;
      float f = (float)(((CompositionTrackSegment)localObject2).scaleDuration.getTimeUs() / ((CompositionTrackSegment)localObject2).timeRange.getDuration().getTimeUs());
      ((CompositionTrackSegment)localObject2).timeRange = new CMTimeRange(((CompositionTrackSegment)localObject2).timeRange.getStart(), TimeUtil.us2CMTime(((float)l2 * f)));
      ((CompositionTrackSegment)localObject2).scaleDuration = TimeUtil.us2CMTime(l2);
      f = (float)(((CompositionTrackSegment)localObject1).scaleDuration.getTimeUs() / ((CompositionTrackSegment)localObject1).timeRange.getDuration().getTimeUs());
      l1 = paramCMTimeRange.getStart().getTimeUs() - l1;
      l2 = ((float)l1 * f);
      ((CompositionTrackSegment)localObject1).timeRange = new CMTimeRange(TimeUtil.us2CMTime(((CompositionTrackSegment)localObject1).timeRange.getStart().getTimeUs() + l2), TimeUtil.us2CMTime(((CompositionTrackSegment)localObject1).timeRange.getDuration().getTimeUs() - l2));
      ((CompositionTrackSegment)localObject1).scaleDuration = TimeUtil.us2CMTime(((CompositionTrackSegment)localObject1).scaleDuration.getTimeUs() - l1);
      j = this.segments.size() - 1;
      while (j >= 0)
      {
        if ((j > i) || (j < k)) {
          this.segments.remove(j);
        }
        j -= 1;
      }
    }
  }
  
  public CMTime getDuration()
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while (i < this.segments.size())
    {
      localCMTime = localCMTime.add(((CompositionTrackSegment)this.segments.get(i)).getScaleDuration());
      i += 1;
    }
    return localCMTime;
  }
  
  public String getExtendedLanguageTag()
  {
    return this.extendedLanguageTag;
  }
  
  public String getLanguageCode()
  {
    return this.languageCode;
  }
  
  public void insertCompositionTrackSegment(@NonNull CompositionTrackSegment paramCompositionTrackSegment)
  {
    if (((this.naturalSize == null) || (this.naturalSize.equals(CGSize.CGSizeZero))) && (paramCompositionTrackSegment.getSourceType() == 3) && (!TextUtils.isEmpty(paramCompositionTrackSegment.getSourcePath()))) {
      this.naturalSize = ImageDecoder.getDefaultOutputImageSize(paramCompositionTrackSegment.getSourcePath());
    }
    Object localObject2 = paramCompositionTrackSegment.timeMapping.getTarget();
    Object localObject1 = ((CMTimeRange)localObject2).getStart();
    if (this.segments.size() == 0)
    {
      if (((CMTimeRange)localObject2).getStart().value > 0L) {
        this.segments.add(new CompositionTrackSegment(new CMTimeRange(CMTime.CMTimeZero, ((CMTimeRange)localObject2).getStart())));
      }
      insertSegment(paramCompositionTrackSegment, -1);
      return;
    }
    int i = findSegmentIndexAt((CMTime)localObject1, false);
    if (i != -1)
    {
      localObject2 = getSegmentStartCMTime(i);
      if (((CMTime)localObject1).equalsTo((CMTime)localObject2))
      {
        insertSegment(paramCompositionTrackSegment, i);
      }
      else
      {
        localObject1 = split((CompositionTrackSegment)this.segments.remove(i), ((CMTime)localObject1).sub((CMTime)localObject2));
        if (localObject1[1].scaleDuration.getTimeUs() > 0L) {
          this.segments.add(i, localObject1[1]);
        }
        insertSegment(paramCompositionTrackSegment, i);
        if (localObject1[0].scaleDuration.getTimeUs() > 0L) {
          this.segments.add(i, localObject1[0]);
        }
      }
    }
    else
    {
      localObject2 = getSegmentStartCMTime(this.segments.size());
      if (((CMTime)localObject1).bigThan((CMTime)localObject2)) {
        this.segments.add(new CompositionTrackSegment(new CMTimeRange((CMTime)localObject2, ((CMTime)localObject1).sub((CMTime)localObject2))));
      }
      insertSegment(paramCompositionTrackSegment, -1);
    }
    paramCompositionTrackSegment = CMTime.CMTimeZero;
    localObject1 = this.segments.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CompositionTrackSegment)((Iterator)localObject1).next();
      ((CompositionTrackSegment)localObject2).updateTargetTimeRange(new CMTimeRange(paramCompositionTrackSegment, ((CompositionTrackSegment)localObject2).scaleDuration));
      paramCompositionTrackSegment = paramCompositionTrackSegment.add(((CompositionTrackSegment)localObject2).scaleDuration);
    }
    updateTimeRange();
  }
  
  public void insertEmptyTimeRange(CMTimeRange paramCMTimeRange)
  {
    insertTimeRange(paramCMTimeRange, null, paramCMTimeRange.getStart());
  }
  
  public boolean insertTimeRange(CMTimeRange paramCMTimeRange, AssetTrack paramAssetTrack, CMTime paramCMTime)
  {
    if (this.timeRange == null) {
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, CMTime.CMTimeZero);
    }
    if (((this.naturalSize == null) || (this.naturalSize.equals(CGSize.CGSizeZero))) && (paramAssetTrack != null)) {
      this.naturalSize = paramAssetTrack.naturalSize;
    }
    if ((this.preferredRotation == 0) && (paramAssetTrack != null)) {
      this.preferredRotation = paramAssetTrack.preferredRotation;
    }
    if ((paramCMTime != CMTime.CMTimeInvalid) && (paramCMTime.getValue() >= 0L))
    {
      if (paramCMTimeRange.getDuration().value <= 0L) {
        return false;
      }
      CMTimeRange localCMTimeRange = new CMTimeRange(paramCMTime, paramCMTimeRange.getDuration());
      if (this.segments.size() == 0)
      {
        if (paramCMTime.value > 0L) {
          this.segments.add(new CompositionTrackSegment(new CMTimeRange(CMTime.CMTimeZero, paramCMTime)));
        }
        insertTimeRange(paramCMTimeRange, localCMTimeRange, paramAssetTrack, -1);
        return true;
      }
      int i = findSegmentIndexAt(paramCMTime, false);
      CMTime localCMTime;
      if (i != -1)
      {
        localCMTime = getSegmentStartCMTime(i);
        if (paramCMTime.equalsTo(localCMTime))
        {
          insertTimeRange(paramCMTimeRange, localCMTimeRange, paramAssetTrack, i);
        }
        else
        {
          paramCMTime = split((CompositionTrackSegment)this.segments.remove(i), paramCMTime.sub(localCMTime));
          if (paramCMTime[1].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(i, paramCMTime[1]);
          }
          insertTimeRange(paramCMTimeRange, paramCMTimeRange, paramAssetTrack, i);
          if (paramCMTime[0].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(i, paramCMTime[0]);
          }
        }
      }
      else
      {
        localCMTime = getSegmentStartCMTime(this.segments.size());
        if (paramCMTime.bigThan(localCMTime)) {
          this.segments.add(new CompositionTrackSegment(new CMTimeRange(localCMTime, paramCMTime.sub(localCMTime))));
        }
        insertTimeRange(paramCMTimeRange, localCMTimeRange, paramAssetTrack, -1);
      }
      updateTimeRange();
      return true;
    }
    insertTimeRange(paramCMTimeRange, new CMTimeRange(this.timeRange.getDuration(), paramCMTimeRange.getDuration()), paramAssetTrack, -1);
    return true;
  }
  
  public void removeTimeRange(CMTimeRange paramCMTimeRange)
  {
    if (paramCMTimeRange != null)
    {
      if (!paramCMTimeRange.isLegal()) {
        return;
      }
      insertEmptyTimeRange(new CMTimeRange(paramCMTimeRange.getStart(), CMTime.CMTimeOne));
      insertEmptyTimeRange(new CMTimeRange(paramCMTimeRange.getEnd().add(CMTime.CMTimeOne), CMTime.CMTimeOne));
      Object localObject = paramCMTimeRange.getStart();
      int i = 0;
      int j = findSegmentIndexAt((CMTime)localObject, false);
      int k = findSegmentIndexAt(paramCMTimeRange.getEnd().add(CMTime.CMTimeOne), false);
      localObject = new ArrayList();
      while (i < this.segments.size())
      {
        if ((i < j) || (i > k)) {
          ((List)localObject).add(this.segments.get(i));
        }
        i += 1;
      }
      this.segments = ((List)localObject);
      updateTimeRange();
      updateSegmentsStartTimeAfterRemoved(paramCMTimeRange);
    }
  }
  
  public void scaleTimeRange(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    Object localObject3 = paramCMTimeRange.getStart();
    Object localObject2 = paramCMTimeRange.getEnd();
    if ((paramCMTimeRange.getDuration().getTimeUs() > 0L) && (this.segments != null))
    {
      if (this.segments.size() == 0) {
        return;
      }
      int k = findSegmentIndexAt(paramCMTimeRange.getStart(), false);
      if (k == -1) {
        return;
      }
      int j = findSegmentIndexAt(paramCMTimeRange.getEnd(), false);
      int i;
      if (j == -1)
      {
        i = this.segments.size() - 1;
      }
      else
      {
        i = j;
        if (getSegmentStartCMTime(j).equalsTo(paramCMTimeRange.getEnd())) {
          i = j - 1;
        }
      }
      CMTime localCMTime;
      Object localObject1;
      if (k == i)
      {
        localCMTime = getSegmentStartCMTime(k);
        localObject1 = (CompositionTrackSegment)this.segments.remove(k);
        paramCMTimeRange = (CMTimeRange)localObject1;
        if (((CMTime)localObject2).smallThan(localCMTime.add(((CompositionTrackSegment)localObject1).scaleDuration)))
        {
          localObject2 = split((CompositionTrackSegment)localObject1, ((CMTime)localObject3).sub(localCMTime));
          localObject1 = localObject2[0];
          paramCMTimeRange = (CMTimeRange)localObject1;
          if (localObject2[1].scaleDuration.getTimeUs() > 0L)
          {
            this.segments.add(k, localObject2[1]);
            paramCMTimeRange = (CMTimeRange)localObject1;
          }
        }
        if (((CMTime)localObject3).bigThan(localCMTime))
        {
          paramCMTimeRange = split(paramCMTimeRange, ((CMTime)localObject3).sub(localCMTime));
          paramCMTimeRange[1].scaleDuration = paramCMTime;
          if (paramCMTimeRange[1].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(k, paramCMTimeRange[1]);
          }
          if (paramCMTimeRange[0].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(k, paramCMTimeRange[0]);
          }
        }
        else
        {
          paramCMTimeRange.scaleDuration = paramCMTime;
          this.segments.add(k, paramCMTimeRange);
        }
      }
      else
      {
        localObject1 = getSegmentStartCMTime(k);
        localCMTime = getSegmentStartCMTime(i);
        if (((CMTime)localObject3).bigThan((CMTime)localObject1))
        {
          localObject3 = split((CompositionTrackSegment)this.segments.remove(k), ((CMTime)localObject3).sub((CMTime)localObject1));
          localObject3[1].scaleDuration = paramCMTime.multi(localObject3[1].scaleDuration).divide(paramCMTimeRange.getDuration());
          localObject1 = paramCMTime.sub(localObject3[1].scaleDuration);
          if (localObject3[1].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(k, localObject3[1]);
          }
          paramCMTime = (CMTime)localObject1;
          if (localObject3[0].scaleDuration.getTimeUs() > 0L)
          {
            this.segments.add(k, localObject3[0]);
            paramCMTime = (CMTime)localObject1;
          }
        }
        else
        {
          localObject1 = (CompositionTrackSegment)this.segments.get(k);
          ((CompositionTrackSegment)localObject1).scaleDuration = paramCMTime.multi(((CompositionTrackSegment)localObject1).scaleDuration).divide(paramCMTimeRange.getDuration());
          paramCMTime = paramCMTime.sub(((CompositionTrackSegment)localObject1).scaleDuration);
        }
        j = k + 1;
        while (j < i)
        {
          localObject1 = (CompositionTrackSegment)this.segments.get(j);
          ((CompositionTrackSegment)localObject1).scaleDuration = paramCMTime.multi(((CompositionTrackSegment)localObject1).scaleDuration).divide(paramCMTimeRange.getDuration());
          paramCMTime = paramCMTime.sub(((CompositionTrackSegment)localObject1).scaleDuration);
          j += 1;
        }
        paramCMTimeRange = (CompositionTrackSegment)this.segments.get(i);
        if (((CMTime)localObject2).smallThan(localCMTime.add(paramCMTimeRange.scaleDuration)))
        {
          paramCMTimeRange = split((CompositionTrackSegment)this.segments.remove(i), ((CMTime)localObject2).sub(localCMTime));
          paramCMTimeRange[0].scaleDuration = paramCMTime;
          if (paramCMTimeRange[1].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(i, paramCMTimeRange[1]);
          }
          if (paramCMTimeRange[0].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(i, paramCMTimeRange[0]);
          }
        }
        else
        {
          paramCMTimeRange.scaleDuration = paramCMTime;
        }
      }
      paramCMTimeRange = CMTime.CMTimeZero;
      paramCMTime = this.segments.iterator();
      while (paramCMTime.hasNext())
      {
        localObject1 = (CompositionTrackSegment)paramCMTime.next();
        ((CompositionTrackSegment)localObject1).updateTargetTimeRange(new CMTimeRange(paramCMTimeRange, ((CompositionTrackSegment)localObject1).scaleDuration));
        paramCMTimeRange = paramCMTimeRange.add(((CompositionTrackSegment)localObject1).scaleDuration);
      }
      updateTimeRange();
    }
  }
  
  public void setExtendedLanguageTag(String paramString)
  {
    this.extendedLanguageTag = paramString;
  }
  
  public void setLanguageCode(String paramString)
  {
    this.languageCode = paramString;
  }
  
  void setNaturalSize(CGSize paramCGSize)
  {
    this.naturalSize = paramCGSize;
  }
  
  public void setNaturalTimeScale(int paramInt)
  {
    this.naturalTimeScale = paramInt;
  }
  
  public void setPreferredTransform(Matrix paramMatrix)
  {
    this.preferredTransform = paramMatrix;
  }
  
  public void setPreferredVolume(float paramFloat)
  {
    this.preferredVolume = paramFloat;
  }
  
  public void setSegments(List<CompositionTrackSegment> paramList)
  {
    this.segments = paramList;
  }
  
  public boolean validateTrackSegments(List<CompositionTrackSegment> paramList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.asset.MutableCompositionTrack
 * JD-Core Version:    0.7.0.1
 */