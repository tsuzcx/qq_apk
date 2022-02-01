package com.tencent.tkd.topicsdk.covergallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.interfaces.IPermission.ISimpleCallback;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import com.tencent.tkd.topicsdk.mediaselector.IMediaContract.IModel;
import com.tencent.tkd.topicsdk.mediaselector.IMediaContract.IPresenter.DefaultImpls;
import com.tencent.tkd.topicsdk.mediaselector.IMediaContract.IView;
import com.tencent.tkd.topicsdk.mediaselector.MediaPresenter;
import com.tencent.tkd.topicsdk.mediaselector.PanelType;
import com.tencent.tkd.topicsdk.mediaselector.SelectMediaModel;
import com.tencent.tkd.topicsdk.ucrop.callback.BitmapCropCallback;
import com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler;
import com.tencent.tkd.topicsdk.ucrop.view.IGestureCropView;
import com.tencent.tkd.topicsdk.ucrop.view.UCropView;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.OutputPicListener;
import com.tencent.tkd.topicsdk.widget.AlbumPermissionView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IView;", "context", "Landroid/content/Context;", "videoWidth", "", "videoHeight", "coverPath", "", "coverRatio", "", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;IILjava/lang/String;FLandroid/util/AttributeSet;)V", "adapter", "Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView$GalleryGridAdapter;", "albumPermissionView", "Lcom/tencent/tkd/topicsdk/widget/AlbumPermissionView;", "candidateCover", "Lcom/tencent/tkd/topicsdk/ucrop/view/UCropView;", "dataContentView", "Landroid/view/View;", "emptyView", "gridView", "Landroid/widget/GridView;", "mediaList", "", "Lcom/tencent/tkd/topicsdk/bean/Media;", "mediaPresenter", "Lcom/tencent/tkd/topicsdk/mediaselector/MediaPresenter;", "checkAndLoadImageList", "", "confirmClick", "outputPicListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "detachViewFromParent", "child", "initView", "loadCandidateImage", "selectMediaInfo", "path", "loadImageList", "loadPlaceHolderImage", "reportGalleryCoverAdjusted", "resetCropImageView", "setBitmapOnUiThread", "bitmap", "Landroid/graphics/Bitmap;", "showDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "updateEmptyView", "isVisible", "", "updatePlaceHolderBitmap", "Companion", "GalleryGridAdapter", "GalleryGridHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class CoverGalleryView
  extends LinearLayout
  implements IMediaContract.IView
{
  public static final CoverGalleryView.Companion a = new CoverGalleryView.Companion(null);
  private UCropView b;
  private View c;
  private GridView d;
  private AlbumPermissionView e;
  private View f;
  private final MediaPresenter g;
  private List<Media> h;
  private CoverGalleryView.GalleryGridAdapter i;
  private int j;
  private int k;
  private String l;
  private float m;
  
  public CoverGalleryView(@NotNull Context paramContext, int paramInt1, int paramInt2, @NotNull String paramString, float paramFloat, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramString;
    this.m = paramFloat;
    this.g = new MediaPresenter((IMediaContract.IModel)new SelectMediaModel(paramContext));
    this.h = ((List)new ArrayList());
    this.i = new CoverGalleryView.GalleryGridAdapter(this);
    LayoutInflater.from(paramContext).inflate(R.layout.d, (ViewGroup)this, true);
    a();
  }
  
  private final void a()
  {
    this.g.a((IMediaContract.IView)this);
    Object localObject = findViewById(R.id.u);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.gv_gallery)");
    this.d = ((GridView)localObject);
    localObject = findViewById(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.album_empty_layout)");
    this.c = ((View)localObject);
    localObject = findViewById(R.id.G);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.iv_gallery_cover)");
    this.b = ((UCropView)localObject);
    localObject = findViewById(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.album_permission_view)");
    this.e = ((AlbumPermissionView)localObject);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("albumPermissionView");
    }
    ((AlbumPermissionView)localObject).setOnPermissionCallback((IPermission.ISimpleCallback)new CoverGalleryView.initView.1(this));
    localObject = findViewById(R.id.J);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.ll_content_view)");
    this.f = ((View)localObject);
    this.i.a((Function1)new CoverGalleryView.initView.2(this));
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gridView");
    }
    ((GridView)localObject).setAdapter((ListAdapter)this.i);
    b();
    d();
    e();
  }
  
  private final void a(Media paramMedia)
  {
    a(paramMedia.getFilePath());
  }
  
  private final void a(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return;
    }
    try
    {
      ThreadManagerKt.c((Function0)new CoverGalleryView.loadCandidateImage.1(this, paramString));
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private final void b()
  {
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("candidateCover");
    }
    ((UCropView)localObject).a();
    if ((this.j != 0) && (this.k != 0))
    {
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("candidateCover");
      }
      localObject = ((UCropView)localObject).getGestureCropView();
      if (localObject != null)
      {
        View localView = ((IGestureCropView)localObject).getView();
        if (localView != null) {
          localView.setOnTouchListener((View.OnTouchListener)new CoverGalleryView.resetCropImageView.1(this));
        }
      }
      if (localObject != null)
      {
        localObject = ((IGestureCropView)localObject).getGestureCropHandler();
        if (localObject != null)
        {
          ((GestureCropHandler)localObject).b(false);
          ((GestureCropHandler)localObject).a(this.m);
        }
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAspectRatio error mVideoWidth:");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append(", mVideoHeight");
      ((StringBuilder)localObject).append(this.k);
      TLog.d("CoverGalleryView", ((StringBuilder)localObject).toString());
    }
  }
  
  private final void c()
  {
    DispatchManager localDispatchManager = DispatchManager.a;
    ReportEventKey localReportEventKey = ReportEventKey.EVENT_DRAG;
    ReportEventElement localReportEventElement = ReportEventElement.WIDGET_UCROP;
    localDispatchManager.a((IEvent)new UserActionEvent(null, localReportEventKey, ReportEventPage.PAGE_SELECT_VIDEO_COVER, localReportEventElement, null, null, null, 113, null));
  }
  
  private final void d()
  {
    a(this.l);
  }
  
  private final void e()
  {
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("albumPermissionView");
    }
    if (((AlbumPermissionView)localObject).getNeedShowContentView())
    {
      f();
      return;
    }
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("dataContentView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("albumPermissionView");
    }
    ((AlbumPermissionView)localObject).setVisibility(0);
  }
  
  private final void f()
  {
    IMediaContract.IPresenter.DefaultImpls.a(this.g, PanelType.PHOTO, null, 2, null);
  }
  
  private final void setBitmapOnUiThread(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    ThreadManagerKt.a((Function0)new CoverGalleryView.setBitmapOnUiThread.1(this, paramBitmap));
  }
  
  public final void a(@Nullable Bitmap paramBitmap)
  {
    int n;
    if (this.i.a() >= 0) {
      n = 1;
    } else {
      n = 0;
    }
    if ((TextUtils.isEmpty((CharSequence)this.l)) && (n == 0)) {
      setBitmapOnUiThread(paramBitmap);
    }
  }
  
  public final void a(@NotNull OutputPicListener paramOutputPicListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputPicListener, "outputPicListener");
    String str = TopicSDK.a.a().b().q().b();
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("candidateCover");
    }
    localObject = ((UCropView)localObject).getGestureCropView();
    if (localObject != null)
    {
      localObject = ((IGestureCropView)localObject).getGestureCropHandler();
      if (localObject != null) {
        ((GestureCropHandler)localObject).a(Bitmap.CompressFormat.JPEG, 90, str, (BitmapCropCallback)new CoverGalleryView.confirmClick.1(this, paramOutputPicListener));
      }
    }
  }
  
  public void a(@NotNull ArrayList<Media> paramArrayList, @NotNull HashMap<String, ArrayList<Media>> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "mediaList");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "mediaMap");
    paramHashMap = (Iterable)paramArrayList;
    paramArrayList = (Collection)new ArrayList();
    paramHashMap = paramHashMap.iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = paramHashMap.next();
      if ((StringsKt.endsWith$default(((Media)localObject).getFilePath(), ".gif", false, 2, null) ^ true)) {
        paramArrayList.add(localObject);
      }
    }
    this.h = ((List)paramArrayList);
    this.i.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.c;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("emptyView");
    }
    int n;
    if (paramBoolean) {
      n = 0;
    } else {
      n = 8;
    }
    localView.setVisibility(n);
  }
  
  protected void detachViewFromParent(@Nullable View paramView)
  {
    this.g.a();
    super.detachViewFromParent(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView
 * JD-Core Version:    0.7.0.1
 */