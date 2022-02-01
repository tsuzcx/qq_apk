package com.tencent.tkd.topicsdk.mediaselector;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.PermissionUtils;
import com.tencent.tkd.topicsdk.common.ViewExtensionsKt;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.interfaces.IPermission.ISimpleCallback;
import com.tencent.tkd.topicsdk.widget.AlbumPermissionView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IView;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IPresenter;", "panelType", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IPresenter;Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;)V", "albumEmptyView", "Landroid/view/View;", "getAlbumEmptyView", "()Landroid/view/View;", "setAlbumEmptyView", "(Landroid/view/View;)V", "albumPermissionView", "Lcom/tencent/tkd/topicsdk/widget/AlbumPermissionView;", "getAlbumPermissionView", "()Lcom/tencent/tkd/topicsdk/widget/AlbumPermissionView;", "setAlbumPermissionView", "(Lcom/tencent/tkd/topicsdk/widget/AlbumPermissionView;)V", "allMediaList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lkotlin/collections/ArrayList;", "getAllMediaList", "()Ljava/util/ArrayList;", "setAllMediaList", "(Ljava/util/ArrayList;)V", "dirPath", "", "getDirPath", "()Ljava/lang/String;", "setDirPath", "(Ljava/lang/String;)V", "gridView", "Landroid/widget/GridView;", "isScrollToBottom", "", "()Z", "setScrollToBottom", "(Z)V", "isScrollToTop", "setScrollToTop", "maxMediaSize", "", "getMaxMediaSize", "()J", "setMaxMediaSize", "(J)V", "maxSelectCount", "", "getMaxSelectCount", "()I", "setMaxSelectCount", "(I)V", "mediaList", "getMediaList", "setMediaList", "mediaMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getMediaMap", "()Ljava/util/HashMap;", "setMediaMap", "(Ljava/util/HashMap;)V", "onItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onMediaLoadedListener", "getOnMediaLoadedListener", "setOnMediaLoadedListener", "onOverSelectListener", "Lkotlin/Function0;", "getOnOverSelectListener", "()Lkotlin/jvm/functions/Function0;", "setOnOverSelectListener", "(Lkotlin/jvm/functions/Function0;)V", "onSelectChangeListener", "", "selectedMedias", "getOnSelectChangeListener", "setOnSelectChangeListener", "onSelectedOverSizeListener", "media", "getOnSelectedOverSizeListener", "setOnSelectedOverSizeListener", "photoAdapter", "com/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel$photoAdapter$1", "Lcom/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel$photoAdapter$1;", "getSelectedMedias", "setSelectedMedias", "clearSelectedMediaList", "loadMedias", "onAttachedToWindow", "onDetachedFromWindow", "removeSelectedMedia", "path", "showDataList", "updateDataListByRecentList", "updateEmptyView", "isVisible", "updateSelectMediaList", "selectMediaList", "Companion", "ListPhotoViewHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class MediaSelectorPanel
  extends RelativeLayout
  implements IMediaContract.IView
{
  public static final MediaSelectorPanel.Companion a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @NotNull
  private View jdField_a_of_type_AndroidViewView;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private final IMediaContract.IPresenter jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IPresenter;
  private final MediaSelectorPanel.photoAdapter.1 jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel$photoAdapter$1;
  private final PanelType jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelType;
  @NotNull
  private AlbumPermissionView jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private ArrayList<Media> jdField_a_of_type_JavaUtilArrayList;
  @NotNull
  private HashMap<String, ArrayList<Media>> jdField_a_of_type_JavaUtilHashMap;
  @Nullable
  private Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  @Nullable
  private Function1<? super List<Media>, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean;
  @NotNull
  private ArrayList<Media> jdField_b_of_type_JavaUtilArrayList;
  @Nullable
  private Function1<? super Integer, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_b_of_type_Boolean;
  @NotNull
  private ArrayList<Media> jdField_c_of_type_JavaUtilArrayList;
  @Nullable
  private Function1<? super Media, Unit> jdField_c_of_type_KotlinJvmFunctionsFunction1;
  @Nullable
  private Function1<? super PanelType, Unit> d;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel$Companion = new MediaSelectorPanel.Companion(null);
  }
  
  public MediaSelectorPanel(@NotNull Context paramContext, @NotNull IMediaContract.IPresenter paramIPresenter, @NotNull PanelType paramPanelType)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IPresenter = paramIPresenter;
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelType = paramPanelType;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 9;
    this.jdField_a_of_type_Long = 31457280L;
    this.jdField_a_of_type_JavaLangString = "";
    LayoutInflater.from(paramContext).inflate(R.layout.jdField_a_of_type_Int, (ViewGroup)this, true);
    paramIPresenter = findViewById(R.id.al);
    Intrinsics.checkExpressionValueIsNotNull(paramIPresenter, "findViewById(R.id.photo_grid)");
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramIPresenter);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnScrollListener((AbsListView.OnScrollListener)new MediaSelectorPanel.1(this));
    ViewExtensionsKt.a((AbsListView)this.jdField_a_of_type_AndroidWidgetGridView, (Function4)new MediaSelectorPanel.2(this));
    paramIPresenter = findViewById(R.id.jdField_a_of_type_Int);
    Intrinsics.checkExpressionValueIsNotNull(paramIPresenter, "findViewById(R.id.album_empty_layout)");
    this.jdField_a_of_type_AndroidViewView = paramIPresenter;
    paramIPresenter = findViewById(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(paramIPresenter, "findViewById(R.id.album_permission_view)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView = ((AlbumPermissionView)paramIPresenter);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView.setOnPermissionCallback((IPermission.ISimpleCallback)new MediaSelectorPanel.3(this));
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel$photoAdapter$1 = new MediaSelectorPanel.photoAdapter.1(this, paramContext, paramContext);
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  public final AlbumPermissionView a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final ArrayList<Media> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  @NotNull
  public final HashMap<String, ArrayList<Media>> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  @Nullable
  public final Function0<Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction0;
  }
  
  @Nullable
  public final Function1<List<Media>, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a()
  {
    if ((((Collection)this.jdField_c_of_type_JavaUtilArrayList).isEmpty() ^ true))
    {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      Object localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(this.jdField_c_of_type_JavaUtilArrayList);
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel$photoAdapter$1.notifyDataSetChanged();
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Object localObject1 = (Iterable)this.jdField_c_of_type_JavaUtilArrayList;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (Intrinsics.areEqual(((Media)localObject2).getFilePath(), paramString)) {
        localCollection.add(localObject2);
      }
    }
    paramString = (List)localCollection;
    if ((((Collection)paramString).isEmpty() ^ true))
    {
      paramString = (Media)paramString.get(0);
      this.jdField_c_of_type_JavaUtilArrayList.remove(paramString);
      paramString = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (paramString != null) {
        paramString = (Unit)paramString.invoke(this.jdField_c_of_type_JavaUtilArrayList);
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel$photoAdapter$1.notifyDataSetChanged();
    }
  }
  
  public final void a(@NotNull String paramString, @NotNull ArrayList<Media> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "dirPath");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "mediaList");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel$photoAdapter$1.a((List)paramArrayList);
  }
  
  public final void a(@NotNull ArrayList<String> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "selectMediaList");
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    ThreadManagerKt.b((Function0)new MediaSelectorPanel.updateSelectMediaList.1(this, paramArrayList));
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel$photoAdapter$1.notifyDataSetChanged();
  }
  
  public void a(@NotNull ArrayList<Media> paramArrayList, @NotNull HashMap<String, ArrayList<Media>> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "mediaList");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "mediaMap");
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel$photoAdapter$1.a((List)paramArrayList);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public final ArrayList<Media> b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  @Nullable
  public final Function1<Integer, Unit> b()
  {
    return this.jdField_b_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IPresenter.a(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelType, this.d);
  }
  
  public final boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  @NotNull
  public final ArrayList<Media> c()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  @Nullable
  public final Function1<Media, Unit> c()
  {
    return this.jdField_c_of_type_KotlinJvmFunctionsFunction1;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter((ListAdapter)this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaSelectorPanel$photoAdapter$1);
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IPresenter.a(this);
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
        this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView.setVisibility(8);
        b();
        return;
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView.setVisibility(0);
      return;
    }
    TLog.a("MediaSelectorView", "onAttachedToWindow, activity=null");
    a(true);
  }
  
  protected void onDetachedFromWindow()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorIMediaContract$IPresenter.a();
    super.onDetachedFromWindow();
  }
  
  public final void setAlbumEmptyView(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "<set-?>");
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public final void setAlbumPermissionView(@NotNull AlbumPermissionView paramAlbumPermissionView)
  {
    Intrinsics.checkParameterIsNotNull(paramAlbumPermissionView, "<set-?>");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView = paramAlbumPermissionView;
  }
  
  public final void setAllMediaList(@NotNull ArrayList<Media> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public final void setDirPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void setMaxMediaSize(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void setMaxSelectCount(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void setMediaList(@NotNull ArrayList<Media> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public final void setMediaMap(@NotNull HashMap<String, ArrayList<Media>> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "<set-?>");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public final void setOnItemClickListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_b_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setOnMediaLoadedListener(@Nullable Function1<? super PanelType, Unit> paramFunction1)
  {
    this.d = paramFunction1;
  }
  
  public final void setOnOverSelectListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  public final void setOnSelectChangeListener(@Nullable Function1<? super List<Media>, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setOnSelectedOverSizeListener(@Nullable Function1<? super Media, Unit> paramFunction1)
  {
    this.jdField_c_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setScrollToBottom(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void setScrollToTop(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final void setSelectedMedias(@NotNull ArrayList<Media> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.jdField_c_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel
 * JD-Core Version:    0.7.0.1
 */