package com.tencent.tkd.topicsdk.mediaselector;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.PermissionUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.widget.AlbumPermissionView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IView;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IPresenter;", "panelType", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IPresenter;Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;)V", "albumEmptyView", "Landroid/view/View;", "getAlbumEmptyView", "()Landroid/view/View;", "setAlbumEmptyView", "(Landroid/view/View;)V", "albumPermissionView", "Lcom/tencent/tkd/topicsdk/widget/AlbumPermissionView;", "getAlbumPermissionView", "()Lcom/tencent/tkd/topicsdk/widget/AlbumPermissionView;", "setAlbumPermissionView", "(Lcom/tencent/tkd/topicsdk/widget/AlbumPermissionView;)V", "allMediaList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lkotlin/collections/ArrayList;", "getAllMediaList", "()Ljava/util/ArrayList;", "setAllMediaList", "(Ljava/util/ArrayList;)V", "dirPath", "", "getDirPath", "()Ljava/lang/String;", "setDirPath", "(Ljava/lang/String;)V", "gridView", "Landroid/widget/GridView;", "isScrollToBottom", "", "()Z", "setScrollToBottom", "(Z)V", "isScrollToTop", "setScrollToTop", "maxMediaSize", "", "getMaxMediaSize", "()J", "setMaxMediaSize", "(J)V", "maxSelectCount", "", "getMaxSelectCount", "()I", "setMaxSelectCount", "(I)V", "mediaList", "getMediaList", "setMediaList", "mediaMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getMediaMap", "()Ljava/util/HashMap;", "setMediaMap", "(Ljava/util/HashMap;)V", "onItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onMediaLoadedListener", "getOnMediaLoadedListener", "setOnMediaLoadedListener", "onOverSelectListener", "Lkotlin/Function0;", "getOnOverSelectListener", "()Lkotlin/jvm/functions/Function0;", "setOnOverSelectListener", "(Lkotlin/jvm/functions/Function0;)V", "onSelectChangeListener", "", "selectedMedias", "getOnSelectChangeListener", "setOnSelectChangeListener", "onSelectedOverSizeListener", "media", "getOnSelectedOverSizeListener", "setOnSelectedOverSizeListener", "photoAdapter", "com/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel$photoAdapter$1", "Lcom/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel$photoAdapter$1;", "getSelectedMedias", "setSelectedMedias", "clearSelectedMediaList", "loadMedias", "onAttachedToWindow", "onDetachedFromWindow", "removeSelectedMedia", "path", "showDataList", "updateDataListByRecentList", "updateEmptyView", "isVisible", "updateSelectMediaList", "selectMediaList", "Companion", "ListPhotoViewHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class MediaSelectorPanel
  extends RelativeLayout
  implements IMediaContract.IView
{
  public static final MediaSelectorPanel.Companion a = new MediaSelectorPanel.Companion(null);
  private GridView b;
  @NotNull
  private View c;
  @NotNull
  private AlbumPermissionView d;
  @NotNull
  private ArrayList<Media> e;
  @NotNull
  private ArrayList<Media> f;
  @NotNull
  private HashMap<String, ArrayList<Media>> g;
  @NotNull
  private ArrayList<Media> h;
  @Nullable
  private Function1<? super List<Media>, Unit> i;
  @Nullable
  private Function1<? super Integer, Unit> j;
  @Nullable
  private Function0<Unit> k;
  @Nullable
  private Function1<? super Media, Unit> l;
  private int m;
  private long n;
  private boolean o;
  private boolean p;
  @NotNull
  private String q;
  @Nullable
  private Function1<? super PanelType, Unit> r;
  private final MediaSelectorPanel.photoAdapter.1 s;
  private final IMediaContract.IPresenter t;
  private final PanelType u;
  
  public final void a(@NotNull String paramString, @NotNull ArrayList<Media> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "dirPath");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "mediaList");
    this.q = paramString;
    this.e = paramArrayList;
    this.s.a((List)paramArrayList);
  }
  
  public final void a(@NotNull ArrayList<String> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "selectMediaList");
    this.h.clear();
    ThreadManagerKt.b((Function0)new MediaSelectorPanel.updateSelectMediaList.1(this, paramArrayList));
    this.s.notifyDataSetChanged();
  }
  
  public void a(@NotNull ArrayList<Media> paramArrayList, @NotNull HashMap<String, ArrayList<Media>> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "mediaList");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "mediaMap");
    this.q = "";
    this.f = paramArrayList;
    this.e = paramArrayList;
    this.g = paramHashMap;
    this.s.a((List)paramArrayList);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.c;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
  }
  
  public final boolean a()
  {
    return this.o;
  }
  
  public final boolean b()
  {
    return this.p;
  }
  
  public final void c()
  {
    if ((((Collection)this.h).isEmpty() ^ true))
    {
      this.h.clear();
      Object localObject = this.i;
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(this.h);
      }
      this.s.notifyDataSetChanged();
    }
  }
  
  public final void d()
  {
    this.t.a(this.u, this.r);
  }
  
  @NotNull
  public final View getAlbumEmptyView()
  {
    return this.c;
  }
  
  @NotNull
  public final AlbumPermissionView getAlbumPermissionView()
  {
    return this.d;
  }
  
  @NotNull
  public final ArrayList<Media> getAllMediaList()
  {
    return this.f;
  }
  
  @NotNull
  public final String getDirPath()
  {
    return this.q;
  }
  
  public final long getMaxMediaSize()
  {
    return this.n;
  }
  
  public final int getMaxSelectCount()
  {
    return this.m;
  }
  
  @NotNull
  public final ArrayList<Media> getMediaList()
  {
    return this.e;
  }
  
  @NotNull
  public final HashMap<String, ArrayList<Media>> getMediaMap()
  {
    return this.g;
  }
  
  @Nullable
  public final Function1<Integer, Unit> getOnItemClickListener()
  {
    return this.j;
  }
  
  @Nullable
  public final Function1<PanelType, Unit> getOnMediaLoadedListener()
  {
    return this.r;
  }
  
  @Nullable
  public final Function0<Unit> getOnOverSelectListener()
  {
    return this.k;
  }
  
  @Nullable
  public final Function1<List<Media>, Unit> getOnSelectChangeListener()
  {
    return this.i;
  }
  
  @Nullable
  public final Function1<Media, Unit> getOnSelectedOverSizeListener()
  {
    return this.l;
  }
  
  @NotNull
  public final ArrayList<Media> getSelectedMedias()
  {
    return this.h;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b.setAdapter((ListAdapter)this.s);
    this.t.a(this);
    Object localObject;
    if ((getContext() instanceof Activity))
    {
      localObject = getContext();
      if (localObject != null) {
        localObject = (Activity)localObject;
      } else {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
    }
    else if ((getContext() instanceof ContextWrapper))
    {
      localObject = getContext();
      if (localObject != null)
      {
        localObject = ((ContextWrapper)localObject).getBaseContext();
        if (localObject != null) {
          localObject = (Activity)localObject;
        } else {
          throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.content.ContextWrapper");
      }
    }
    else
    {
      localObject = null;
    }
    if (localObject != null)
    {
      if (PermissionUtils.a.a((Activity)localObject))
      {
        this.d.setVisibility(8);
        d();
        return;
      }
      this.d.setVisibility(0);
      return;
    }
    TLog.a("MediaSelectorView", "onAttachedToWindow, activity=null");
    a(true);
  }
  
  protected void onDetachedFromWindow()
  {
    this.t.a();
    super.onDetachedFromWindow();
  }
  
  public final void setAlbumEmptyView(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "<set-?>");
    this.c = paramView;
  }
  
  public final void setAlbumPermissionView(@NotNull AlbumPermissionView paramAlbumPermissionView)
  {
    Intrinsics.checkParameterIsNotNull(paramAlbumPermissionView, "<set-?>");
    this.d = paramAlbumPermissionView;
  }
  
  public final void setAllMediaList(@NotNull ArrayList<Media> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.f = paramArrayList;
  }
  
  public final void setDirPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.q = paramString;
  }
  
  public final void setMaxMediaSize(long paramLong)
  {
    this.n = paramLong;
  }
  
  public final void setMaxSelectCount(int paramInt)
  {
    this.m = paramInt;
  }
  
  public final void setMediaList(@NotNull ArrayList<Media> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.e = paramArrayList;
  }
  
  public final void setMediaMap(@NotNull HashMap<String, ArrayList<Media>> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "<set-?>");
    this.g = paramHashMap;
  }
  
  public final void setOnItemClickListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.j = paramFunction1;
  }
  
  public final void setOnMediaLoadedListener(@Nullable Function1<? super PanelType, Unit> paramFunction1)
  {
    this.r = paramFunction1;
  }
  
  public final void setOnOverSelectListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.k = paramFunction0;
  }
  
  public final void setOnSelectChangeListener(@Nullable Function1<? super List<Media>, Unit> paramFunction1)
  {
    this.i = paramFunction1;
  }
  
  public final void setOnSelectedOverSizeListener(@Nullable Function1<? super Media, Unit> paramFunction1)
  {
    this.l = paramFunction1;
  }
  
  public final void setScrollToBottom(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public final void setScrollToTop(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public final void setSelectedMedias(@NotNull ArrayList<Media> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.h = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel
 * JD-Core Version:    0.7.0.1
 */