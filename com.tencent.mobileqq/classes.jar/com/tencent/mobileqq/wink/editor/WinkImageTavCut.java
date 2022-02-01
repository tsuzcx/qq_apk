package com.tencent.mobileqq.wink.editor;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.event.FilterSelectedEvent;
import com.tencent.mobileqq.wink.event.ImageChangePageEvent;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.Size;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.ComposeRenderLayer;
import com.tencent.videocut.render.ComposeRenderLayer.RenderScene;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/WinkImageTavCut;", "Lcom/tencent/mobileqq/wink/editor/WinkTavCutDelegate;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "()V", "currentPosition", "", "datas", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "indicator", "Landroid/widget/TextView;", "oriMediaModels", "", "Lcom/tencent/videocut/model/MediaModel;", "pageChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "renderLayer", "Lcom/tencent/videocut/render/ComposeRenderLayer;", "session", "Lcom/tencent/tavcut/session/ICutSession;", "showAreaHeight", "showAreaWidth", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getContainerSize", "Lcom/tencent/videocut/model/Size;", "getDuration", "", "getEditDatas", "getMediaModels", "getPlayer", "Lcom/tencent/tavcut/render/player/IPlayer;", "getPlayerContainer", "Landroid/widget/FrameLayout;", "position", "getRenderLayer", "getRenderSize", "getSession", "getStickers", "", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "getTemplatePath", "init", "", "hostFragment", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "params", "Lcom/tencent/mobileqq/wink/editor/WinkTavCutDelegate$WinkTavCutParams;", "isMediaChanged", "notifyFilterMenu", "onHiddenChanged", "hidden", "onPageScrollStateChanged", "state", "onPageSelected", "onPageSelectedUpdate", "release", "removeSticker", "stickerModel", "resetTavCut", "setShowAreaSize", "width", "height", "updateAudio", "audioModel", "Lcom/tencent/videocut/model/AudioModel;", "updateAudioVolume", "volume", "", "updateDuration", "durationUs", "updateFilter", "filterModel", "Lcom/tencent/videocut/model/FilterModel;", "material", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "updateIndicator", "updateSticker", "updateVideoOriginalSoundVolume", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkImageTavCut
  extends ViewPager2.OnPageChangeCallback
  implements WinkTavCutDelegate
{
  public static final WinkImageTavCut.Companion a = new WinkImageTavCut.Companion(null);
  private TextView b;
  private ViewPager2 c;
  private RecyclerView d;
  private List<WinkEditData> e = (List)new ArrayList();
  private ComposeRenderLayer f;
  private ICutSession g;
  private int h;
  private boolean i;
  private int j;
  private int k;
  private List<MediaModel> l = (List)new ArrayList();
  
  private final FrameLayout a(int paramInt)
  {
    Object localObject = this.d;
    FrameLayout localFrameLayout = null;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getLayoutManager();
      if (localObject != null)
      {
        localObject = ((RecyclerView.LayoutManager)localObject).findViewByPosition(paramInt);
        break label31;
      }
    }
    localObject = null;
    label31:
    if (localObject != null) {
      localFrameLayout = (FrameLayout)((View)localObject).findViewById(2131440395);
    }
    return localFrameLayout;
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    ViewPager2 localViewPager2 = this.c;
    if (localViewPager2 == null) {
      Intrinsics.throwNpe();
    }
    localViewPager2.setOrientation(0);
    Object localObject = (Iterable)this.e;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((WinkEditData)((Iterator)localObject).next()).getMediaModel());
    }
    localViewPager2.setAdapter((RecyclerView.Adapter)new WinkImageAdapter((List)localCollection, paramInt1, paramInt2));
    localViewPager2.registerOnPageChangeCallback((ViewPager2.OnPageChangeCallback)this);
    localViewPager2.setVisibility(0);
    this.d = ((RecyclerView)localViewPager2.getChildAt(0));
    localViewPager2.setOffscreenPageLimit(3);
    localViewPager2.post((Runnable)new WinkImageTavCut.setShowAreaSize.2(this));
  }
  
  private final void b(int paramInt)
  {
    Object localObject1 = ((MediaClip)((WinkEditData)this.e.get(paramInt)).getMediaModel().videos.get(0)).resource;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((ResourceModel)localObject1).size;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    float f1 = ((SizeF)localObject1).width;
    localObject1 = ((MediaClip)((WinkEditData)this.e.get(paramInt)).getMediaModel().videos.get(0)).resource;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((ResourceModel)localObject1).size;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    float f2 = ((SizeF)localObject1).height;
    localObject1 = new Ref.IntRef();
    Object localObject2 = new Ref.IntRef();
    if (3 * f1 <= 2 * f2)
    {
      ((Ref.IntRef)localObject1).element = this.j;
      ((Ref.IntRef)localObject2).element = ((int)(((Ref.IntRef)localObject1).element * f2 / f1));
      int m = ((Ref.IntRef)localObject2).element;
      int n = this.k;
      if (m < n)
      {
        ((Ref.IntRef)localObject2).element = n;
        ((Ref.IntRef)localObject1).element = ((int)(n * f1 / f2));
      }
    }
    else
    {
      ((Ref.IntRef)localObject1).element = this.j;
      ((Ref.IntRef)localObject2).element = ((int)(((Ref.IntRef)localObject1).element * f2 / f1));
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[onPageSelectedUpdate] image size=");
    ((StringBuilder)localObject3).append(f1);
    ((StringBuilder)localObject3).append('x');
    ((StringBuilder)localObject3).append(f2);
    ((StringBuilder)localObject3).append(", ");
    ((StringBuilder)localObject3).append("area size=");
    ((StringBuilder)localObject3).append(this.j);
    ((StringBuilder)localObject3).append('x');
    ((StringBuilder)localObject3).append(this.k);
    ((StringBuilder)localObject3).append(", ");
    ((StringBuilder)localObject3).append("container size=");
    ((StringBuilder)localObject3).append(((Ref.IntRef)localObject1).element);
    ((StringBuilder)localObject3).append('x');
    ((StringBuilder)localObject3).append(((Ref.IntRef)localObject2).element);
    AEQLog.a("WinkImageTavCut", ((StringBuilder)localObject3).toString());
    localObject3 = a(paramInt);
    if (localObject3 != null)
    {
      ViewGroup.LayoutParams localLayoutParams = ((FrameLayout)localObject3).getLayoutParams();
      localLayoutParams.width = ((Ref.IntRef)localObject1).element;
      localLayoutParams.height = ((Ref.IntRef)localObject2).element;
      ((FrameLayout)localObject3).setLayoutParams(localLayoutParams);
      localObject1 = TavCut.a.a((FrameLayout)localObject3);
      localObject2 = this.g;
      if (localObject2 != null) {
        ((ICutSession)localObject2).a((IPlayer)localObject1);
      }
      localObject1 = this.f;
      if (localObject1 != null) {
        ((ComposeRenderLayer)localObject1).a(((WinkEditData)this.e.get(paramInt)).getMediaModel());
      }
    }
    m();
  }
  
  private final void l()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((ICutSession)localObject).g();
    }
    this.g = TavCut.a.b();
    localObject = TavCut.a.c(null);
    if (localObject != null)
    {
      ICutSession localICutSession = this.g;
      if (localICutSession != null) {
        localICutSession.a((RenderModel)localObject);
      }
    }
    localObject = this.g;
    if (localObject != null) {
      this.f = new ComposeRenderLayer((ICutSession)localObject, new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null), ComposeRenderLayer.RenderScene.PIC);
    }
  }
  
  private final void m()
  {
    TextView localTextView;
    if (this.e.size() > 1)
    {
      localTextView = this.b;
      if (localTextView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.h + 1);
        localStringBuilder.append('/');
        localStringBuilder.append(this.e.size());
        localTextView.setText((CharSequence)localStringBuilder.toString());
        localTextView.setVisibility(0);
      }
    }
    else
    {
      localTextView = this.b;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
    }
  }
  
  private final void n()
  {
    MetaMaterial localMetaMaterial = (MetaMaterial)null;
    Object localObject2 = ((WinkEditData)this.e.get(this.h)).getFilterMaterialMap();
    Object localObject1 = localMetaMaterial;
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).values();
      localObject1 = localMetaMaterial;
      if (localObject2 != null)
      {
        localObject2 = (MetaMaterial)CollectionsKt.elementAtOrNull((Iterable)localObject2, 0);
        localObject1 = localMetaMaterial;
        if (localObject2 != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[notifyFilterMenu] filterMaterialId=");
          ((StringBuilder)localObject1).append(((MetaMaterial)localObject2).id);
          ((StringBuilder)localObject1).append(", position=");
          ((StringBuilder)localObject1).append(this.h);
          AEQLog.a("WinkImageTavCut", ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
    }
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new FilterSelectedEvent((MetaMaterial)localObject1));
  }
  
  @Nullable
  public IPlayer a()
  {
    ICutSession localICutSession = this.g;
    if (localICutSession != null) {
      return localICutSession.f();
    }
    return null;
  }
  
  public void a(float paramFloat) {}
  
  public void a(long paramLong) {}
  
  public void a(@NotNull BasePartFragment paramBasePartFragment, @NotNull WinkTavCutDelegate.WinkTavCutParams paramWinkTavCutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramBasePartFragment, "hostFragment");
    Intrinsics.checkParameterIsNotNull(paramWinkTavCutParams, "params");
    l();
    this.e = paramWinkTavCutParams.c();
    this.l = d();
    this.c = ((ViewPager2)paramBasePartFragment.requireView().findViewById(2131435379));
    this.b = ((TextView)paramBasePartFragment.requireView().findViewById(2131435375));
    a(paramWinkTavCutParams.e(), paramWinkTavCutParams.f());
  }
  
  public void a(@NotNull WinkStickerModel paramWinkStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkStickerModel, "stickerModel");
    WinkEditData localWinkEditData = (WinkEditData)this.e.get(this.h);
    if (localWinkEditData.getStickerModelMap() == null) {
      localWinkEditData.setStickerModelMap((Map)new LinkedHashMap());
    }
    Map localMap = localWinkEditData.getStickerModelMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localMap.put(paramWinkStickerModel.id, paramWinkStickerModel);
    paramWinkStickerModel = localWinkEditData.getMediaModel();
    localMap = localWinkEditData.getStickerModelMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localWinkEditData.setMediaModel(MediaModel.copy$default(paramWinkStickerModel, null, null, null, null, null, null, null, null, localMap, null, null, null, null, null, null, null, null, null, 261887, null));
    paramWinkStickerModel = this.f;
    if (paramWinkStickerModel != null) {
      paramWinkStickerModel.a(localWinkEditData.getMediaModel());
    }
  }
  
  public void a(@Nullable AudioModel paramAudioModel) {}
  
  public void a(@Nullable FilterModel paramFilterModel, @Nullable MetaMaterial paramMetaMaterial)
  {
    WinkEditData localWinkEditData = (WinkEditData)this.e.get(this.h);
    if (localWinkEditData.getFilterModelMap() == null) {
      localWinkEditData.setFilterModelMap((Map)new LinkedHashMap());
    }
    if (localWinkEditData.getFilterMaterialMap() == null) {
      localWinkEditData.setFilterMaterialMap((Map)new LinkedHashMap());
    }
    Map localMap = localWinkEditData.getFilterMaterialMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localMap.clear();
    localMap = localWinkEditData.getFilterModelMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localMap.clear();
    if (paramMetaMaterial != null)
    {
      localMap = localWinkEditData.getFilterMaterialMap();
      if (localMap == null) {
        Intrinsics.throwNpe();
      }
      String str = paramMetaMaterial.id;
      Intrinsics.checkExpressionValueIsNotNull(str, "it.id");
      localMap.put(str, paramMetaMaterial);
    }
    if (paramFilterModel != null)
    {
      paramMetaMaterial = localWinkEditData.getFilterModelMap();
      if (paramMetaMaterial == null) {
        Intrinsics.throwNpe();
      }
      paramMetaMaterial.put(paramFilterModel.id, paramFilterModel);
    }
    paramFilterModel = localWinkEditData.getMediaModel();
    paramMetaMaterial = localWinkEditData.getFilterModelMap();
    if (paramMetaMaterial == null) {
      Intrinsics.throwNpe();
    }
    localWinkEditData.setMediaModel(MediaModel.copy$default(paramFilterModel, null, null, null, null, null, null, null, null, null, null, paramMetaMaterial, null, null, null, null, null, null, null, 261119, null));
    paramFilterModel = this.f;
    if (paramFilterModel != null) {
      paramFilterModel.a(localWinkEditData.getMediaModel());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.c;
      if (localObject != null) {
        ((ViewPager2)localObject).setVisibility(4);
      }
      localObject = this.b;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(4);
      }
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        ((ViewPager2)localObject).setVisibility(0);
      }
      if (this.e.size() > 1)
      {
        localObject = this.b;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      n();
    }
  }
  
  @Nullable
  public ICutSession b()
  {
    return this.g;
  }
  
  public void b(float paramFloat) {}
  
  public void b(@NotNull WinkStickerModel paramWinkStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkStickerModel, "stickerModel");
    WinkEditData localWinkEditData = (WinkEditData)this.e.get(this.h);
    Map localMap = localWinkEditData.getStickerModelMap();
    int m;
    if ((localMap != null) && (!localMap.isEmpty())) {
      m = 0;
    } else {
      m = 1;
    }
    if (m != 0) {
      return;
    }
    localMap = localWinkEditData.getStickerModelMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localMap.remove(paramWinkStickerModel.id);
    paramWinkStickerModel = localWinkEditData.getMediaModel();
    localMap = localWinkEditData.getStickerModelMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localWinkEditData.setMediaModel(MediaModel.copy$default(paramWinkStickerModel, null, null, null, null, null, null, null, null, localMap, null, null, null, null, null, null, null, null, null, 261887, null));
    paramWinkStickerModel = this.f;
    if (paramWinkStickerModel != null) {
      paramWinkStickerModel.a(localWinkEditData.getMediaModel());
    }
  }
  
  public void c()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((ICutSession)localObject).g();
    }
    localObject = this.c;
    if (localObject != null) {
      ((ViewPager2)localObject).setVisibility(8);
    }
    localObject = this.b;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  @NotNull
  public List<MediaModel> d()
  {
    Object localObject = (Iterable)this.e;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((WinkEditData)((Iterator)localObject).next()).getMediaModel());
    }
    return (List)localCollection;
  }
  
  public long e()
  {
    return 1000000L;
  }
  
  @Nullable
  public Map<String, WinkStickerModel> f()
  {
    return ((WinkEditData)this.e.get(this.h)).getStickerModelMap();
  }
  
  @NotNull
  public Size g()
  {
    return new Size(Integer.valueOf(this.j), Integer.valueOf(this.k), null, 4, null);
  }
  
  @NotNull
  public Size h()
  {
    FrameLayout localFrameLayout = a(this.h);
    if (localFrameLayout != null) {
      return new Size(Integer.valueOf(localFrameLayout.getWidth()), Integer.valueOf(localFrameLayout.getHeight()), null, 4, null);
    }
    return new Size(null, null, null, 7, null);
  }
  
  @Nullable
  public String i()
  {
    return null;
  }
  
  @NotNull
  public List<WinkEditData> j()
  {
    return this.e;
  }
  
  public boolean k()
  {
    return Intrinsics.areEqual(this.l, d()) ^ true;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onPageScrollStateChanged] state=");
    localStringBuilder.append(paramInt);
    AEQLog.a("WinkImageTavCut", localStringBuilder.toString());
    if ((this.i) && (paramInt == 0))
    {
      l();
      b(this.h);
      this.i = false;
      n();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onPageSelected] position=");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("WinkImageTavCut", ((StringBuilder)localObject).toString());
    int m = this.h;
    if (m != paramInt)
    {
      localObject = a(m);
      if (localObject != null) {
        ((FrameLayout)localObject).removeAllViews();
      }
      this.h = paramInt;
      this.i = true;
      SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new ImageChangePageEvent(paramInt));
      m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkImageTavCut
 * JD-Core Version:    0.7.0.1
 */