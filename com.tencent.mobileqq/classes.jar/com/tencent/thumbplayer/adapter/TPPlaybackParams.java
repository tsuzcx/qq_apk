package com.tencent.thumbplayer.adapter;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TPPlaybackParams
{
  private static final String TAG = "TPPlaybackParams";
  private float mAudioGainRatio;
  private String mAudioNormalizeVolumeParams;
  private Map<String, TPPlaybackParams.AudioTrackAttribute> mAudioTrackSources = new HashMap(0);
  private TPPlayerDataSource mDataSource = new TPPlayerDataSource();
  private TPPlaybackParams.LoopbackAttribute mLoopback;
  private Map<Integer, TPOptionalParam> mOptionalParams = new HashMap(0);
  private boolean mOutputMute;
  private ArrayList<TPPlaybackParams.SelectTrackAttribute> mSelectTrackAttributes = new ArrayList();
  private float mSpeedRatio;
  private Map<String, TPPlaybackParams.SubtitleAttribute> mSubtitleSources = new HashMap(0);
  private Object mSurfaceObj;
  private TPProgramInfo mTpProgramInfo;
  private Map<Integer, TPTrackInfo> mTpSelectedTypeTrackInfoMap = new HashMap(0);
  private ArrayList<TPTrackInfo> mTpTrackInfoList = new ArrayList();
  private int trackId = -1;
  
  private void generateTrackInfoBySubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.trackId += 1;
    paramString1 = new TPTrackInfo();
    paramString1.trackType = 3;
    paramString1.name = paramString3;
    paramString1.isSelected = false;
    paramString1.isExclusive = true;
    paramString1.isInternal = false;
    this.mTpTrackInfoList.add(paramString1);
  }
  
  private void generateTrackInfoByTrackSource(String paramString1, String paramString2)
  {
    this.trackId += 1;
    paramString1 = new TPTrackInfo();
    paramString1.trackType = 2;
    paramString1.name = paramString2;
    paramString1.isSelected = false;
    paramString1.isExclusive = true;
    paramString1.isInternal = false;
    this.mTpTrackInfoList.add(paramString1);
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    while (TextUtils.isEmpty(paramString2)) {
      return;
    }
    TPPlaybackParams.AudioTrackAttribute localAudioTrackAttribute = new TPPlaybackParams.AudioTrackAttribute();
    localAudioTrackAttribute.url = paramString1;
    localAudioTrackAttribute.name = paramString2;
    localAudioTrackAttribute.audioTrackParams = paramList;
    this.mAudioTrackSources.put(paramString1, localAudioTrackAttribute);
    generateTrackInfoByTrackSource(paramString1, paramString2);
  }
  
  public void addOptionalParams(TPOptionalParam paramTPOptionalParam)
  {
    if (paramTPOptionalParam != null) {
      this.mOptionalParams.put(Integer.valueOf(paramTPOptionalParam.getKey()), paramTPOptionalParam);
    }
  }
  
  public void addSelectedTrackInfo(int paramInt, long paramLong, TPTrackInfo paramTPTrackInfo)
  {
    this.mTpSelectedTypeTrackInfoMap.put(Integer.valueOf(paramTPTrackInfo.getTrackType()), paramTPTrackInfo);
    if ((paramInt < 0) || (paramInt >= this.mTpTrackInfoList.size()))
    {
      TPLogUtil.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.mTpTrackInfoList.size());
      return;
    }
    TPPlaybackParams.SelectTrackAttribute localSelectTrackAttribute = new TPPlaybackParams.SelectTrackAttribute();
    localSelectTrackAttribute.trackIndex = paramInt;
    localSelectTrackAttribute.opaque = paramLong;
    Iterator localIterator = this.mTpTrackInfoList.iterator();
    while (localIterator.hasNext())
    {
      TPTrackInfo localTPTrackInfo = (TPTrackInfo)localIterator.next();
      if (localTPTrackInfo.trackType == paramTPTrackInfo.trackType) {
        if (((TextUtils.isEmpty(localTPTrackInfo.name)) && (TextUtils.isEmpty(paramTPTrackInfo.name))) || (localTPTrackInfo.name.equals(paramTPTrackInfo.name)))
        {
          localTPTrackInfo.isSelected = true;
          localSelectTrackAttribute.trackInfo = localTPTrackInfo;
        }
        else
        {
          localTPTrackInfo.isSelected = false;
        }
      }
    }
    this.mSelectTrackAttributes.add(localSelectTrackAttribute);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    while (TextUtils.isEmpty(paramString3)) {
      return;
    }
    TPPlaybackParams.SubtitleAttribute localSubtitleAttribute = new TPPlaybackParams.SubtitleAttribute();
    localSubtitleAttribute.url = paramString1;
    localSubtitleAttribute.mimeType = paramString2;
    localSubtitleAttribute.name = paramString3;
    this.mSubtitleSources.put(paramString1, localSubtitleAttribute);
    generateTrackInfoBySubtitleSource(paramString1, paramString2, paramString3);
  }
  
  public float audioGainRatio()
  {
    return this.mAudioGainRatio;
  }
  
  public String audioNormalizeVolumeParams()
  {
    return this.mAudioNormalizeVolumeParams;
  }
  
  public List<TPPlaybackParams.AudioTrackAttribute> audioTrackSources()
  {
    ArrayList localArrayList = new ArrayList(this.mAudioTrackSources.size());
    Iterator localIterator = this.mAudioTrackSources.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  public TPPlayerDataSource dataSource()
  {
    return this.mDataSource;
  }
  
  public TPOptionalParam getOptionalParam(int paramInt)
  {
    return (TPOptionalParam)this.mOptionalParams.get(Integer.valueOf(paramInt));
  }
  
  public TPProgramInfo getSelectProgramInfo()
  {
    return this.mTpProgramInfo;
  }
  
  public ArrayList<TPPlaybackParams.SelectTrackAttribute> getSelectTrackAttributes()
  {
    return this.mSelectTrackAttributes;
  }
  
  public TPTrackInfo getTrackInfoByType(int paramInt)
  {
    return (TPTrackInfo)this.mTpSelectedTypeTrackInfoMap.get(Integer.valueOf(paramInt));
  }
  
  public ArrayList<TPTrackInfo> getTrackInfos()
  {
    return this.mTpTrackInfoList;
  }
  
  public TPPlaybackParams.LoopbackAttribute loopback()
  {
    return this.mLoopback;
  }
  
  public List<TPOptionalParam> optionalParams()
  {
    ArrayList localArrayList = new ArrayList(this.mOptionalParams.size());
    Iterator localIterator = this.mOptionalParams.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  public boolean outputMute()
  {
    return this.mOutputMute;
  }
  
  public void reset()
  {
    this.mSubtitleSources.clear();
    this.mAudioTrackSources.clear();
    this.mOutputMute = false;
    this.mAudioGainRatio = 1.0F;
    this.mAudioNormalizeVolumeParams = "";
    this.mSpeedRatio = 1.0F;
    this.mTpSelectedTypeTrackInfoMap.clear();
    this.mSurfaceObj = null;
    this.mOptionalParams.clear();
    this.mDataSource = new TPPlayerDataSource();
    this.mLoopback = null;
    this.mTpProgramInfo = null;
    this.trackId = -1;
    this.mTpTrackInfoList.clear();
    this.mSelectTrackAttributes.clear();
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    this.mAudioGainRatio = paramFloat;
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    this.mAudioNormalizeVolumeParams = paramString;
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mDataSource.setFileDescriptor(paramParcelFileDescriptor);
  }
  
  public void setDataSource(TPUrlDataSource paramTPUrlDataSource, Map<String, String> paramMap)
  {
    this.mDataSource.setTpUrlDataSource(paramTPUrlDataSource);
    this.mDataSource.setHttpHeaders(paramMap);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    this.mDataSource.setMediaClipInfo(paramITPMediaAsset);
  }
  
  public void setDataSource(String paramString)
  {
    this.mDataSource.setUrl(paramString);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    this.mDataSource.setUrl(paramString);
    this.mDataSource.setHttpHeaders(paramMap);
  }
  
  public void setDeselectTrackInfo(int paramInt, long paramLong, TPTrackInfo paramTPTrackInfo)
  {
    this.mTpSelectedTypeTrackInfoMap.remove(Integer.valueOf(paramTPTrackInfo.getTrackType()));
    if ((paramInt < 0) || (paramInt >= this.mTpTrackInfoList.size())) {
      TPLogUtil.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.mTpTrackInfoList.size());
    }
    Object localObject;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        localIterator = this.mTpTrackInfoList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (TPTrackInfo)localIterator.next();
          if ((((TPTrackInfo)localObject).trackType == paramTPTrackInfo.trackType) && (((TextUtils.isEmpty(((TPTrackInfo)localObject).name)) && (TextUtils.isEmpty(paramTPTrackInfo.name))) || (((TPTrackInfo)localObject).name.equals(paramTPTrackInfo.name)))) {
            ((TPTrackInfo)localObject).isSelected = false;
          }
        }
        localIterator = this.mSelectTrackAttributes.iterator();
      }
      localObject = (TPPlaybackParams.SelectTrackAttribute)localIterator.next();
    } while ((((TPPlaybackParams.SelectTrackAttribute)localObject).trackInfo == null) || (!((TPPlaybackParams.SelectTrackAttribute)localObject).trackInfo.equals(paramTPTrackInfo)));
    this.mSelectTrackAttributes.remove(localObject);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    if (this.mLoopback == null) {
      this.mLoopback = new TPPlaybackParams.LoopbackAttribute();
    }
    this.mLoopback.isLoopback = paramBoolean;
    this.mLoopback.startPositionMs = 0L;
    this.mLoopback.endPositionMs = -1L;
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (this.mLoopback == null) {
      this.mLoopback = new TPPlaybackParams.LoopbackAttribute();
    }
    this.mLoopback.isLoopback = paramBoolean;
    this.mLoopback.startPositionMs = paramLong1;
    this.mLoopback.endPositionMs = paramLong2;
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    this.mOutputMute = paramBoolean;
  }
  
  public void setSelectProgramInfo(TPProgramInfo paramTPProgramInfo)
  {
    this.mTpProgramInfo = paramTPProgramInfo;
  }
  
  public void setSpeedRatio(float paramFloat)
  {
    this.mSpeedRatio = paramFloat;
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mSurfaceObj = paramSurface;
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    this.mSurfaceObj = paramSurfaceHolder;
  }
  
  public float speedRatio()
  {
    return this.mSpeedRatio;
  }
  
  public List<TPPlaybackParams.SubtitleAttribute> subtitleSources()
  {
    ArrayList localArrayList = new ArrayList(this.mSubtitleSources.size());
    Iterator localIterator = this.mSubtitleSources.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  public boolean supportClip()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (dataSource() != null)
    {
      bool1 = bool2;
      if (dataSource().getType() == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Object surface()
  {
    return this.mSurfaceObj;
  }
  
  public boolean validDataSource()
  {
    return (this.mDataSource != null) && (this.mDataSource.isValid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlaybackParams
 * JD-Core Version:    0.7.0.1
 */