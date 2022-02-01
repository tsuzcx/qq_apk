package com.tencent.mobileqq.wink.pubcover;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.wink.editor.MediaModelExKt;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataHelper;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.picker.MediaData;
import com.tencent.videocut.render.ComposeRenderLayer;
import com.tencent.videocut.render.ComposeRenderLayer.RenderScene;
import com.tencent.videocut.render.repository.DataBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WinkCoverSelectViewModel
  extends BaseViewModel
{
  public MutableLiveData<Long> a = new MutableLiveData();
  private ICutSession b;
  private IPlayer c;
  private ComposeRenderLayer d;
  private MediaModel e;
  private final Map<String, WinkStickerModel> f = new HashMap();
  private ArrayList<LocalMediaInfo> g;
  private long h;
  private WinkEditDataWrapper i;
  private MutableLiveData<Long> j = new MutableLiveData();
  
  private MediaData a(LocalMediaInfo paramLocalMediaInfo, long paramLong)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    if (QAlbumUtil.getMediaType(paramLocalMediaInfo) == 1) {
      return new MediaData(0, paramLocalMediaInfo.mMimeType, 720, 1280, 0L, 0L, 1000L * paramLocalMediaInfo.mDuration, paramLocalMediaInfo.path, paramLocalMediaInfo.path, paramLocalMediaInfo.mAlbumName);
    }
    return new MediaData(1, paramLocalMediaInfo.mMimeType, 720, 1280, 0L, 0L, paramLong, paramLocalMediaInfo.path, paramLocalMediaInfo.path, paramLocalMediaInfo.mAlbumName);
  }
  
  public String a()
  {
    return "WinkEditorViewModel";
  }
  
  public void a(long paramLong)
  {
    this.h = paramLong;
    this.a.postValue(Long.valueOf(this.h));
  }
  
  public void a(ICutSession paramICutSession, IPlayer paramIPlayer)
  {
    this.b = paramICutSession;
    this.c = paramIPlayer;
  }
  
  public void a(String paramString)
  {
    this.d = new ComposeRenderLayer(this.b, new MediaModel(), ComposeRenderLayer.RenderScene.VIDEO);
    this.i = WinkEditDataHelper.a(paramString);
    paramString = this.i;
    if (paramString != null)
    {
      paramString = paramString.getEditDatas();
      if ((paramString != null) && (paramString.size() == 1) && (paramString.get(0) != null))
      {
        this.e = ((WinkEditData)paramString.get(0)).getMediaModel();
        paramString = this.e;
        if (paramString != null)
        {
          this.e = MediaModelExKt.a(paramString, Collections.emptyMap());
          this.d.a(this.e);
        }
      }
    }
    else
    {
      paramString = new ArrayList();
      Object localObject = this.g;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.g.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MediaData localMediaData = a((LocalMediaInfo)((Iterator)localObject).next(), 2500000L);
          if (localMediaData != null) {
            paramString.add(localMediaData);
          }
        }
      }
      this.e = DataBuilder.a.a(paramString);
      this.d.a(this.e);
    }
  }
  
  public void a(ArrayList<LocalMediaInfo> paramArrayList)
  {
    this.g = new ArrayList();
    this.g.addAll(paramArrayList);
  }
  
  public ICutSession b()
  {
    return this.b;
  }
  
  public void b(long paramLong)
  {
    this.j.postValue(Long.valueOf(paramLong));
  }
  
  public IPlayer c()
  {
    return this.c;
  }
  
  public ComposeRenderLayer d()
  {
    return this.d;
  }
  
  public MediaModel e()
  {
    return this.e;
  }
  
  public WinkEditDataWrapper f()
  {
    return this.i;
  }
  
  public MutableLiveData<Long> g()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pubcover.WinkCoverSelectViewModel
 * JD-Core Version:    0.7.0.1
 */