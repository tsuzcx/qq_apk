package com.tencent.tavmovie;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavmovie.base.TAVDecodeAndEncodeBase;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieSegment;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.filter.TAVBigStickerOverlayEffect;
import com.tencent.tavmovie.filter.TAVMovieFilterChainContext;
import com.tencent.tavmovie.filter.TAVStickerOverlayEffect;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavmovie.utils.CloneUtil;
import com.tencent.tavmovie.utils.TAVMovieTimeEffectUtil;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVMovie
  implements TAVDecodeAndEncodeBase, Cloneable
{
  private static final String TAG = "TAVMovie";
  protected int backgroundColor = -1;
  protected TAVMovieClip backgroundMusic;
  protected List<TAVMovieClip> backgroundMusics;
  protected TAVStickerRenderContext bigStickerRenderContext;
  protected List<TAVMovieClip> clips = new ArrayList();
  protected List<TAVVideoEffect> filters;
  protected TAVTemplate movieTemplate;
  protected List<TAVClip> overlays;
  protected boolean realTimeReleaseEachSticker;
  protected boolean realTimeReleaseStickerContext;
  protected CGSize renderSize;
  protected TAVStickerRenderContext stickerRenderContext;
  protected List<TAVMovieSticker> stickers;
  protected List<TAVClip> tavClips = new ArrayList();
  protected TAVMovieSticker templateSticker;
  protected List<TAVMovieTimeEffect> timeEffects = new ArrayList();
  
  public void addBackgroundMusic(TAVMovieClip paramTAVMovieClip)
  {
    if (this.backgroundMusics == null) {
      this.backgroundMusics = new ArrayList();
    }
    this.backgroundMusics.add(paramTAVMovieClip);
  }
  
  public void addClipsObject(TAVMovieClip paramTAVMovieClip)
  {
    if (paramTAVMovieClip == null) {
      return;
    }
    if (this.clips == null) {
      this.clips = new ArrayList();
    }
    this.clips.add(paramTAVMovieClip);
  }
  
  public void addFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    if (paramTAVVideoEffect == null) {}
    do
    {
      return;
      if (this.filters == null) {
        this.filters = new ArrayList();
      }
    } while (this.filters.contains(paramTAVVideoEffect));
    this.filters.add(paramTAVVideoEffect);
  }
  
  public void addOverlay(TAVClip paramTAVClip)
  {
    if (paramTAVClip == null) {
      return;
    }
    if (this.overlays == null) {
      this.overlays = new ArrayList();
    }
    this.overlays.add(paramTAVClip);
  }
  
  public void addStickersObject(TAVMovieSticker paramTAVMovieSticker)
  {
    if (paramTAVMovieSticker == null) {
      return;
    }
    if (this.stickers == null) {
      this.stickers = new ArrayList();
    }
    this.stickers.add(paramTAVMovieSticker);
  }
  
  public void addTavClip(TAVClip paramTAVClip)
  {
    this.tavClips.add(paramTAVClip);
  }
  
  public TAVMovie clone()
  {
    TAVMovie localTAVMovie = new TAVMovie();
    localTAVMovie.renderSize = this.renderSize.clone();
    localTAVMovie.backgroundColor = this.backgroundColor;
    localTAVMovie.backgroundMusic = this.backgroundMusic.clone();
    localTAVMovie.clips = CloneUtil.cloneMovieClips(this.clips);
    localTAVMovie.movieTemplate = this.movieTemplate;
    localTAVMovie.stickers = CloneUtil.cloneTemplateStickers(this.stickers);
    return localTAVMovie;
  }
  
  public TAVComposition convertToComposition()
  {
    TAVComposition localTAVComposition = new TAVComposition();
    localTAVComposition.setRenderSize(this.renderSize);
    localTAVComposition.setBackgroundColor(this.backgroundColor);
    Object localObject1 = new CMTime(0.0F);
    if (this.movieTemplate != null)
    {
      localObject2 = this.movieTemplate.convertClips(this.clips);
      fillCompositionBySegment(localTAVComposition, (List)localObject2);
      localObject3 = ((List)localObject2).iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = ((CMTime)localObject1).add(((TAVMovieSegment)((Iterator)localObject3).next()).getPlayDuration());
      }
    }
    Object localObject3 = convertToTAVClips(this.clips);
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new ArrayList();
    }
    ((List)localObject2).addAll(this.tavClips);
    localObject2 = TAVMovieTimeEffectUtil.applyTimeEffectsNew((List)localObject2, TAVMovieTimeEffectUtil.pretreatTimeEffects(this.timeEffects));
    localTAVComposition.addVideoChannel((List)localObject2);
    localTAVComposition.addAudioChannel((List)localObject2);
    localObject3 = ((List)localObject2).iterator();
    for (;;)
    {
      localObject2 = localObject1;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      ((CMTime)localObject1).add(((TAVClip)((Iterator)localObject3).next()).getDuration());
    }
    localTAVComposition.setOverlays(this.overlays);
    if (this.backgroundMusics == null) {
      this.backgroundMusics = new ArrayList();
    }
    if (this.backgroundMusic != null) {
      this.backgroundMusics.add(0, this.backgroundMusic);
    }
    if (!this.backgroundMusics.isEmpty())
    {
      localObject1 = new ArrayList();
      localObject3 = this.backgroundMusics.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        TAVMovieClip localTAVMovieClip = (TAVMovieClip)((Iterator)localObject3).next();
        CMTimeRange localCMTimeRange = localTAVMovieClip.getResource().getTimeRange();
        localTAVMovieClip.getResource().setTimeRange(new CMTimeRange(localCMTimeRange.getStart(), (CMTime)localObject2));
        ((List)localObject1).add(localTAVMovieClip.convertToClip());
      }
      localTAVComposition.setAudios((List)localObject1);
    }
    localObject1 = new TAVMovieFilterChainContext();
    if ((this.filters != null) && (this.filters.size() > 0))
    {
      localObject2 = this.filters.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TAVVideoEffect)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((TAVMovieFilterChainContext)localObject1).addFilter((TAVVideoEffect)localObject3);
        }
      }
    }
    if ((this.templateSticker != null) && (this.bigStickerRenderContext != null))
    {
      this.bigStickerRenderContext.setRenderSize(this.renderSize);
      localObject2 = new ArrayList();
      ((List)localObject2).add(this.templateSticker.getSticker());
      this.bigStickerRenderContext.reloadStickers((List)localObject2);
      localTAVComposition.setVideoMixEffect(new TAVBigStickerOverlayEffect(this.bigStickerRenderContext));
    }
    initStickers((TAVMovieFilterChainContext)localObject1);
    localTAVComposition.setGlobalVideoEffect((TAVVideoEffect)localObject1);
    return localTAVComposition;
  }
  
  protected List<TAVClip> convertToTAVClips(List<TAVMovieClip> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVMovieClip localTAVMovieClip = (TAVMovieClip)paramList.next();
      if (localTAVMovieClip != null) {
        localArrayList.add(localTAVMovieClip.convertToClip());
      }
    }
    return localArrayList;
  }
  
  public TAVDecodeAndEncodeBase decodeFromJsonString(String paramString)
  {
    return (TAVDecodeAndEncodeBase)new GsonBuilder().create().fromJson(paramString, getClass());
  }
  
  public String encodeToJsonString()
  {
    return new GsonBuilder().create().toJson(this);
  }
  
  public TAVMovieSticker fetchStickerModelWithUniqueId(String paramString)
  {
    if ((this.stickers == null) || (this.stickers.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.stickers.iterator();
    while (localIterator.hasNext())
    {
      TAVMovieSticker localTAVMovieSticker = (TAVMovieSticker)localIterator.next();
      if ((localTAVMovieSticker != null) && (localTAVMovieSticker.getSticker().getUniqueId().equals(paramString))) {
        return localTAVMovieSticker;
      }
    }
    return null;
  }
  
  protected void fillCompositionBySegment(TAVComposition paramTAVComposition, List<TAVMovieSegment> paramList)
  {
    if ((paramTAVComposition == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    label34:
    label509:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (paramList.hasNext())
      {
        localObject2 = (TAVMovieSegment)paramList.next();
        if (((List)localObject1).isEmpty())
        {
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject2);
          ((List)localObject1).add(localObject3);
        }
        else
        {
          localObject3 = ((List)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (List)((Iterator)localObject3).next();
            if (!((TAVMovieSegment)((List)localObject4).get(((List)localObject4).size() - 1)).getTimeRange().containsTime(((TAVMovieSegment)localObject2).getTimeRange().getStart())) {
              ((List)localObject4).add(localObject2);
            }
          }
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label509;
          }
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject2);
          ((List)localObject1).add(localObject3);
          break label34;
          paramList = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (List)((Iterator)localObject1).next();
            localObject3 = new ArrayList();
            i = 0;
            if (i < ((List)localObject2).size())
            {
              localObject4 = (TAVMovieSegment)((List)localObject2).get(i);
              if (i == 0)
              {
                if (((TAVMovieSegment)localObject4).getTimeRange().getStart().bigThan(CMTime.CMTimeZero)) {
                  ((List)localObject3).add(new TAVClip(new TAVEmptyResource(((TAVMovieSegment)((List)localObject2).get(0)).getTimeRange().getStart())));
                }
                ((List)localObject3).addAll(((TAVMovieSegment)localObject4).getFullTavClips());
              }
              for (;;)
              {
                i += 1;
                break;
                Object localObject5 = (TAVMovieSegment)((List)localObject2).get(i - 1);
                localObject5 = ((TAVMovieSegment)localObject4).getTimeRange().getStart().sub(((TAVMovieSegment)localObject5).getTimeRange().getEnd());
                if (((CMTime)localObject5).bigThan(CMTime.CMTimeZero)) {
                  ((List)localObject3).add(new TAVClip(new TAVEmptyResource((CMTime)localObject5)));
                }
                ((List)localObject3).addAll(((TAVMovieSegment)localObject4).getFullTavClips());
              }
            }
            paramList.add(localObject3);
          }
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject1 = (List)paramList.next();
            paramTAVComposition.addVideoChannel((List)localObject1);
            paramTAVComposition.addAudioChannel((List)localObject1);
          }
          break;
        }
      }
    }
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public TAVMovieClip getBackgroundMusic()
  {
    return this.backgroundMusic;
  }
  
  public List<TAVMovieClip> getBackgroundMusics()
  {
    return this.backgroundMusics;
  }
  
  public TAVStickerRenderContext getBigStickerRenderContext()
  {
    return this.bigStickerRenderContext;
  }
  
  public List<TAVMovieClip> getClips()
  {
    return this.clips;
  }
  
  public List<TAVVideoEffect> getFilters()
  {
    return this.filters;
  }
  
  public TAVTemplate getMovieTemplate()
  {
    return this.movieTemplate;
  }
  
  public List<TAVClip> getOverlays()
  {
    return this.overlays;
  }
  
  public CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public TAVStickerRenderContext getStickerRenderContext()
  {
    return this.stickerRenderContext;
  }
  
  public List<TAVMovieSticker> getStickers()
  {
    return this.stickers;
  }
  
  public List<TAVClip> getTavClips()
  {
    return this.tavClips;
  }
  
  public TAVMovieSticker getTemplateSticker()
  {
    return this.templateSticker;
  }
  
  public List<TAVMovieTimeEffect> getTimeEffects()
  {
    return this.timeEffects;
  }
  
  protected void initStickers(TAVMovieFilterChainContext paramTAVMovieFilterChainContext)
  {
    if ((this.stickers == null) || (this.stickers.size() <= 0) || (this.stickerRenderContext == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.stickers.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((TAVMovieSticker)((Iterator)localObject).next()).getSticker());
    }
    this.stickerRenderContext.setRenderSize(this.renderSize);
    localObject = new TAVStickerOverlayEffect(this.stickerRenderContext);
    paramTAVMovieFilterChainContext.addFilter((TAVVideoEffect)localObject);
    if (this.realTimeReleaseStickerContext)
    {
      ((TAVStickerOverlayEffect)localObject).setStickers(localArrayList, this.realTimeReleaseStickerContext, this.realTimeReleaseEachSticker);
      return;
    }
    this.stickerRenderContext.reloadStickers(localArrayList);
  }
  
  public boolean isHardMode()
  {
    return this.realTimeReleaseStickerContext;
  }
  
  public void release()
  {
    if (this.clips != null)
    {
      Iterator localIterator = this.clips.iterator();
      while (localIterator.hasNext())
      {
        TAVMovieClip localTAVMovieClip = (TAVMovieClip)localIterator.next();
        if (localTAVMovieClip != null) {
          localTAVMovieClip.release();
        }
      }
    }
  }
  
  public void removeClipsObject(TAVMovieClip paramTAVMovieClip)
  {
    if ((paramTAVMovieClip == null) || (this.clips == null) || (this.clips.size() == 0)) {
      return;
    }
    this.clips.remove(paramTAVMovieClip);
  }
  
  public void removeFilter(TAVVideoEffect.Filter paramFilter)
  {
    if (paramFilter == null) {}
    while (this.filters == null) {
      return;
    }
    this.filters.remove(paramFilter);
  }
  
  public void removeObjectFromClipsAtIndex(int paramInt)
  {
    if ((this.clips == null) || (this.clips.size() == 0)) {}
    while ((paramInt < 0) || (paramInt >= this.clips.size())) {
      return;
    }
    this.clips.remove(paramInt);
  }
  
  public void removeStickerWithUniqueId(String paramString)
  {
    if ((this.stickers == null) || (this.stickers.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.stickers.iterator();
      TAVMovieSticker localTAVMovieSticker;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localTAVMovieSticker = (TAVMovieSticker)localIterator.next();
      } while ((localTAVMovieSticker == null) || (!localTAVMovieSticker.getSticker().getUniqueId().equals(paramString)));
      for (paramString = localTAVMovieSticker; paramString != null; paramString = null)
      {
        this.stickers.remove(paramString);
        return;
      }
    }
  }
  
  public void removeStickersObject(TAVMovieSticker paramTAVMovieSticker)
  {
    if ((paramTAVMovieSticker == null) || (this.stickers == null) || (this.stickers.size() == 0)) {
      return;
    }
    this.stickers.remove(paramTAVMovieSticker);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setBackgroundMusic(TAVMovieClip paramTAVMovieClip)
  {
    this.backgroundMusic = paramTAVMovieClip;
  }
  
  public void setBackgroundMusics(List<TAVMovieClip> paramList)
  {
    this.backgroundMusics = paramList;
  }
  
  public void setBigStickerRenderContext(TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    this.bigStickerRenderContext = paramTAVStickerRenderContext;
  }
  
  public void setClips(List<TAVMovieClip> paramList)
  {
    this.clips = paramList;
  }
  
  public void setHardMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.realTimeReleaseStickerContext = paramBoolean1;
    this.realTimeReleaseEachSticker = paramBoolean2;
  }
  
  public void setMovieTemplate(TAVTemplate paramTAVTemplate)
  {
    this.movieTemplate = paramTAVTemplate;
  }
  
  public void setOverlays(List<TAVClip> paramList)
  {
    this.overlays = paramList;
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    this.renderSize = paramCGSize;
  }
  
  public void setStickerRenderContext(TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    this.stickerRenderContext = paramTAVStickerRenderContext;
  }
  
  public void setStickers(List<TAVMovieSticker> paramList)
  {
    this.stickers = paramList;
  }
  
  public void setTavClips(List<TAVClip> paramList)
  {
    this.tavClips = paramList;
  }
  
  public void setTemplateSticker(TAVMovieSticker paramTAVMovieSticker)
  {
    this.templateSticker = paramTAVMovieSticker;
  }
  
  public void setTimeEffects(List<TAVMovieTimeEffect> paramList)
  {
    this.timeEffects = paramList;
  }
  
  public TAVComposition updateComposition()
  {
    if (this.movieTemplate != null) {
      this.clips = this.movieTemplate.getMovieClips();
    }
    return convertToComposition();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavmovie.TAVMovie
 * JD-Core Version:    0.7.0.1
 */