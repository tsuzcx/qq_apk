package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FilterBusinessOperation
{
  private QQFilterRenderManager mCommonOperation;
  private QQDanceEventHandler mDanceEventHandler;
  private List<FilterDesc> mFilterDescMap = new CopyOnWriteArrayList();
  private MusicItemInfo mMusicItemInfo;
  private long mOrgSamplerStamp = 0L;
  private long mPresentTimeStamp = 0L;
  private long mVideoStartTimeMs = 0L;
  private MovieMaterial movieMaterial;
  private WeakReference<QQSpecialAVFilter.MusicWaveformSupporter> musicWaveformSupporterWeakReference;
  
  FilterBusinessOperation(QQFilterRenderManager paramQQFilterRenderManager)
  {
    this.mCommonOperation = paramQQFilterRenderManager;
  }
  
  private void changeColorFilter(VideoFilterBase paramVideoFilterBase)
  {
    Object localObject = this.mCommonOperation.getQQFilters(184);
    if ((localObject != null) && (((List)localObject).size() == 1))
    {
      localObject = (QQPtColorFilter)((List)localObject).get(0);
      if (localObject != null) {
        ((QQPtColorFilter)localObject).setEffectFilter(paramVideoFilterBase);
      }
    }
  }
  
  private FilterDesc getSelectedTypeFilter(int paramInt)
  {
    Iterator localIterator = this.mFilterDescMap.iterator();
    while (localIterator.hasNext())
    {
      FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
      if (paramInt == QQAVImageFilterConstants.getFilterType(localFilterDesc.id)) {
        return localFilterDesc;
      }
    }
    return null;
  }
  
  private void removeSelectedFilterDesc(FilterDesc paramFilterDesc)
  {
    Iterator localIterator = this.mFilterDescMap.iterator();
    while (localIterator.hasNext())
    {
      FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
      if (paramFilterDesc.name.equals(localFilterDesc.name)) {
        this.mFilterDescMap.remove(localFilterDesc);
      }
    }
  }
  
  private void setAvSingleFilter(FilterDesc paramFilterDesc)
  {
    Object localObject = this.mCommonOperation.getQQFilters(70);
    if ((localObject != null) && (((List)localObject).size() == 1))
    {
      localObject = (QQAVFilter)((List)localObject).get(0);
      if (localObject != null) {
        ((QQAVFilter)localObject).setCurrentId(paramFilterDesc, true);
      }
    }
  }
  
  private void setAvSingleFilterForTimeSlamp(List<FilterDesc> paramList, List<Long> paramList1)
  {
    Object localObject = this.mCommonOperation.getQQFilters(70);
    if ((localObject != null) && (((List)localObject).size() == 1))
    {
      localObject = (QQAVFilter)((List)localObject).get(0);
      if (localObject != null) {
        ((QQAVFilter)localObject).setAVListAndTimeSlamp(paramList, paramList1);
      }
    }
  }
  
  private void setPtColorFilter(FilterDesc paramFilterDesc)
  {
    Object localObject = this.mCommonOperation.getQQFilters(184);
    if ((localObject != null) && (((List)localObject).size() == 1))
    {
      localObject = (QQPtColorFilter)((List)localObject).get(0);
      if (localObject != null) {
        ((QQPtColorFilter)localObject).setLutResPath(paramFilterDesc);
      }
    }
  }
  
  private void setQmcfArtFilter(FilterDesc paramFilterDesc)
  {
    List localList = this.mCommonOperation.getQQFilters(90);
    if ((localList != null) && (localList.size() == 1))
    {
      if (paramFilterDesc != null) {
        break label46;
      }
      if (QmcfManager.getInstance().getCurrQmcfMode() == 1) {
        QmcfManager.getInstance().setCurrQmcfMode(0);
      }
    }
    return;
    label46:
    int i = QmcfManager.getInstance().getMatchQmcfMode(paramFilterDesc.type);
    QmcfManager.getInstance().switchQmcfModel(i, paramFilterDesc.getResFold(SdkContext.getInstance().getResources().getArtFilterResource().getFilterResPath()));
  }
  
  private void setSelectedFilterDesc(List<FilterDesc> paramList)
  {
    this.mFilterDescMap.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        this.mFilterDescMap.add(localFilterDesc);
      }
    }
  }
  
  private void setSingleMTVFilter(FilterDesc paramFilterDesc)
  {
    Object localObject = this.mCommonOperation.getQQFilters(180);
    if ((localObject != null) && (((List)localObject).size() == 1))
    {
      localObject = (QQMTVFilter)((List)localObject).get(0);
      if (localObject != null) {
        ((QQMTVFilter)localObject).setCurrentId(paramFilterDesc);
      }
    }
  }
  
  private void setSpecialSingleFilter(FilterDesc paramFilterDesc)
  {
    Object localObject = this.mCommonOperation.getQQFilters(80);
    if ((localObject != null) && (((List)localObject).size() == 1))
    {
      localObject = (QQSpecialAVFilter)((List)localObject).get(0);
      if (localObject != null) {
        ((QQSpecialAVFilter)localObject).setCurrentId(paramFilterDesc);
      }
    }
  }
  
  public void SetTimeStamp(long paramLong1, long paramLong2)
  {
    this.mPresentTimeStamp = paramLong1;
    this.mOrgSamplerStamp = paramLong2;
  }
  
  public void addSelectedFilterDesc(FilterDesc paramFilterDesc)
  {
    FilterDesc localFilterDesc = getSelectedTypeFilter(QQAVImageFilterConstants.getFilterType(paramFilterDesc.id));
    if (localFilterDesc != null) {
      this.mFilterDescMap.remove(localFilterDesc);
    }
    this.mFilterDescMap.add(paramFilterDesc);
  }
  
  public int getAVFilterFilterType()
  {
    Object localObject = this.mCommonOperation.getQQFilters(70);
    if ((localObject != null) && (((List)localObject).size() >= 1))
    {
      localObject = (QQAVFilter)((List)localObject).get(0);
      if (localObject != null) {
        return ((QQAVFilter)localObject).getAVFilterType();
      }
    }
    return 0;
  }
  
  public FilterDesc getCurrentAVFilterIdByType(int paramInt)
  {
    Iterator localIterator = this.mFilterDescMap.iterator();
    while (localIterator.hasNext())
    {
      FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
      if ((localFilterDesc != null) && (QQAVImageFilterConstants.getFilterType(localFilterDesc.id) == paramInt)) {
        return localFilterDesc;
      }
    }
    return null;
  }
  
  public List<FilterDesc> getCurrentAVFilterIdList()
  {
    return this.mFilterDescMap;
  }
  
  public float getCurrentMusicGain()
  {
    QQSpecialAVFilter.MusicWaveformSupporter localMusicWaveformSupporter = null;
    if (this.musicWaveformSupporterWeakReference != null) {
      localMusicWaveformSupporter = (QQSpecialAVFilter.MusicWaveformSupporter)this.musicWaveformSupporterWeakReference.get();
    }
    if (localMusicWaveformSupporter != null) {
      return localMusicWaveformSupporter.getCurrentMusicGain();
    }
    return -1.0F;
  }
  
  public QQDanceEventHandler getDanceEventHandler()
  {
    return this.mDanceEventHandler;
  }
  
  public MovieMaterial getMovieMaterial()
  {
    return this.movieMaterial;
  }
  
  public MusicItemInfo getMusicItemInfo()
  {
    FilterDesc localFilterDesc = getCurrentAVFilterIdByType(2);
    if ((localFilterDesc != null) && (QQAVImageFilterConstants.isMusicSpecialFilter(localFilterDesc.id))) {
      return this.mMusicItemInfo;
    }
    return null;
  }
  
  public long getOrgTimeStamp()
  {
    return this.mOrgSamplerStamp;
  }
  
  public long getPresentTimeStamp()
  {
    return this.mPresentTimeStamp;
  }
  
  public long getVideoStartTime()
  {
    return this.mVideoStartTimeMs;
  }
  
  public boolean hasAvOrSpecialEffect()
  {
    return (getCurrentAVFilterIdList() != null) && (getCurrentAVFilterIdList().size() > 0);
  }
  
  public boolean isRunningMovieFilter()
  {
    boolean bool2 = false;
    List localList = this.mCommonOperation.getQQFilters(100);
    boolean bool1 = bool2;
    if (localList != null)
    {
      bool1 = bool2;
      if (localList.size() > 0) {
        bool1 = ((QQMovieFilter)localList.get(0)).isFilterWork();
      }
    }
    return bool1;
  }
  
  public void playMovie(String paramString1, String paramString2, boolean paramBoolean, HWDecodeListener paramHWDecodeListener, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F) || (paramFloat3 != 0.0F) || (paramFloat4 != 0.0F))
    {
      f1 = (paramFloat3 / 2.0F - paramFloat1) / (paramFloat3 / 2.0F) * 0.5F;
      f2 = (paramFloat2 - paramFloat4 / 2.0F) / (paramFloat4 / 2.0F) * 0.5F;
    }
    Object localObject = this.mCommonOperation.getQQFilters(100);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQMovieFilter)((Iterator)localObject).next()).startPlay(paramString1, paramString2, paramBoolean, f1, f2, paramHWDecodeListener);
      }
    }
  }
  
  public void setDanceEventHandler(QQDanceEventHandler paramQQDanceEventHandler)
  {
    this.mDanceEventHandler = paramQQDanceEventHandler;
  }
  
  public void setDynamicStickerParam(List<DynamicStickerData> paramList)
  {
    List localList = this.mCommonOperation.getQQFilters(120);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQDynamicStickersFilter)localList.get(0)).InitDynamicStickers(paramList);
    }
  }
  
  public void setFilterEffect(FilterDesc paramFilterDesc)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFilterDesc);
    setSelectedFilterDesc(localArrayList);
    if (paramFilterDesc == null)
    {
      setAvSingleFilter(null);
      setSpecialSingleFilter(null);
      setQmcfArtFilter(null);
      setPtColorFilter(null);
      SLog.i("FilterRender", "set currentFilter null");
      return;
    }
    SLog.i("FilterRender", "set currentFilter " + paramFilterDesc.name);
    if (paramFilterDesc.type == 0)
    {
      setAvSingleFilter(paramFilterDesc);
      setSpecialSingleFilter(null);
      setQmcfArtFilter(null);
      setPtColorFilter(null);
      return;
    }
    if (paramFilterDesc.type == 2)
    {
      setAvSingleFilter(null);
      setSpecialSingleFilter(paramFilterDesc);
      setQmcfArtFilter(null);
      setPtColorFilter(null);
      return;
    }
    if ((paramFilterDesc.type == 1) || (paramFilterDesc.type == 3))
    {
      setAvSingleFilter(null);
      setSpecialSingleFilter(null);
      setQmcfArtFilter(paramFilterDesc);
      setPtColorFilter(null);
      return;
    }
    if (paramFilterDesc.type == 5)
    {
      setQmcfArtFilter(null);
      setSpecialSingleFilter(null);
      setAvSingleFilter(null);
      setPtColorFilter(paramFilterDesc);
      return;
    }
    SLog.e("FilterRender", "set currentFilter unKnown");
  }
  
  public void setFilterEffectList(List<FilterDesc> paramList)
  {
    setSelectedFilterDesc(paramList);
    setAvSingleFilter(null);
    setSpecialSingleFilter(null);
    setSingleMTVFilter(null);
    if ((paramList == null) || (paramList.size() == 0))
    {
      setQmcfArtFilter(null);
      setPtColorFilter(null);
    }
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        if (localFilterDesc != null)
        {
          int i = QQAVImageFilterConstants.getFilterType(localFilterDesc.id);
          if (i == 0)
          {
            setQmcfArtFilter(null);
            setPtColorFilter(null);
            setAvSingleFilter(localFilterDesc);
          }
          else if (i == 2)
          {
            setQmcfArtFilter(null);
            setPtColorFilter(null);
            setSpecialSingleFilter(localFilterDesc);
          }
          else if (i == 1)
          {
            setPtColorFilter(null);
            setQmcfArtFilter(localFilterDesc);
          }
          else if (i == 4)
          {
            setPtColorFilter(null);
            setSingleMTVFilter(localFilterDesc);
          }
          else if (i == 5)
          {
            setPtColorFilter(localFilterDesc);
            setQmcfArtFilter(null);
          }
        }
      }
    }
  }
  
  public void setFilterEffectList(List<FilterDesc> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    label16:
    FilterDesc localFilterDesc1;
    int i;
    FilterDesc localFilterDesc2;
    if (paramBoolean)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localFilterDesc1 = (FilterDesc)paramList.next();
        if (localFilterDesc1 != null)
        {
          i = QQAVImageFilterConstants.getFilterType(localFilterDesc1.id);
          if (!QQAVImageFilterConstants.isNormalFilterSpecialCases(localFilterDesc1.id, localFilterDesc1.name)) {
            break label127;
          }
          setQmcfArtFilter(null);
          localFilterDesc2 = getSelectedTypeFilter(1);
          if (localFilterDesc2 != null) {
            removeSelectedFilterDesc(localFilterDesc2);
          }
          setSpecialSingleFilter(null);
          localFilterDesc2 = getSelectedTypeFilter(2);
          if (localFilterDesc2 != null) {
            removeSelectedFilterDesc(localFilterDesc2);
          }
          setAvSingleFilter(localFilterDesc1);
        }
      }
      for (;;)
      {
        addSelectedFilterDesc(localFilterDesc1);
        break label16;
        break;
        label127:
        if (i == 0) {
          setAvSingleFilter(localFilterDesc1);
        } else if (i == 2) {
          setSpecialSingleFilter(localFilterDesc1);
        } else if (i == 1) {
          setQmcfArtFilter(localFilterDesc1);
        } else if (i == 4) {
          setSingleMTVFilter(localFilterDesc1);
        } else if (i != 5) {}
      }
    }
    paramList = paramList.iterator();
    for (;;)
    {
      label197:
      if (paramList.hasNext())
      {
        localFilterDesc1 = (FilterDesc)paramList.next();
        if (localFilterDesc1 != null)
        {
          i = QQAVImageFilterConstants.getFilterType(localFilterDesc1.id);
          if (i != 0) {
            break label277;
          }
          localFilterDesc2 = getSelectedTypeFilter(i);
          if ((localFilterDesc2 != null) && (localFilterDesc2.name.equals(localFilterDesc1.name))) {
            setAvSingleFilter(null);
          }
        }
      }
    }
    for (;;)
    {
      removeSelectedFilterDesc(localFilterDesc1);
      break label197;
      break;
      label277:
      if (i == 2) {
        setSpecialSingleFilter(null);
      } else if (i == 1) {
        setQmcfArtFilter(null);
      } else if (i == 4) {
        setSingleMTVFilter(null);
      } else if (i != 5) {}
    }
  }
  
  public void setImgHazeRmoveFilterEnable(boolean paramBoolean)
  {
    List localList = this.mCommonOperation.getQQFilters(13);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQImgHazeRmoveFilter)localList.get(0)).setEnable(paramBoolean);
    }
  }
  
  public void setMovieEffectPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((this.movieMaterial == null) || (!FileUtil.fileExistsAndNotEmpty(this.movieMaterial.doodleVideoPath))) {}
    for (;;)
    {
      return;
      paramFloat1 = (paramFloat3 / 2.0F - paramFloat1) / (paramFloat3 / 2.0F);
      paramFloat2 = (paramFloat2 - paramFloat4 / 2.0F) / (paramFloat4 / 2.0F);
      Object localObject = this.mCommonOperation.getQQFilters(100);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((QQMovieFilter)((Iterator)localObject).next()).startPlay(this.movieMaterial.doodleVideoPath, this.movieMaterial.doodleAudioPath, this.movieMaterial.loopDoodle, paramFloat1 * 0.5F, paramFloat2 * 0.5F, null);
        }
      }
    }
  }
  
  public void setMusicWaveformSupporter(QQSpecialAVFilter.MusicWaveformSupporter paramMusicWaveformSupporter)
  {
    this.musicWaveformSupporterWeakReference = new WeakReference(paramMusicWaveformSupporter);
    if (paramMusicWaveformSupporter != null)
    {
      this.mMusicItemInfo = paramMusicWaveformSupporter.getMusicItemInfo();
      return;
    }
    this.mMusicItemInfo = null;
  }
  
  public void setTrackerStickerParam(ArrayList<TrackerStickerParam> paramArrayList)
  {
    List localList = this.mCommonOperation.getQQFilters(110);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQTrackerStickersFilter)localList.get(0)).InitTrackerStickers(paramArrayList);
    }
  }
  
  public void setVideoStartTime(long paramLong)
  {
    this.mVideoStartTimeMs = paramLong;
  }
  
  public void updateBeautyFilter(float paramFloat)
  {
    Object localObject = this.mCommonOperation.getQQFilters(20);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQBeautyFilter)((Iterator)localObject).next()).updateBeautyFilter(paramFloat);
      }
    }
  }
  
  public void updateBeautyFilter3Param(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Object localObject = this.mCommonOperation.getQQFilters(20);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQBeautyFilter)((Iterator)localObject).next()).updateBeautyFilterParam(paramFloat1, paramFloat2, paramFloat3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation
 * JD-Core Version:    0.7.0.1
 */