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
import com.tencent.tkd.topicsdk.ucrop.view.GestureCropImageView;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IView;", "context", "Landroid/content/Context;", "videoWidth", "", "videoHeight", "coverPath", "", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;IILjava/lang/String;Landroid/util/AttributeSet;)V", "adapter", "Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView$GalleryGridAdapter;", "albumPermissionView", "Lcom/tencent/tkd/topicsdk/widget/AlbumPermissionView;", "candidateCover", "Lcom/tencent/tkd/topicsdk/ucrop/view/UCropView;", "dataContentView", "Landroid/view/View;", "emptyView", "gridView", "Landroid/widget/GridView;", "mediaList", "", "Lcom/tencent/tkd/topicsdk/bean/Media;", "mediaPresenter", "Lcom/tencent/tkd/topicsdk/mediaselector/MediaPresenter;", "checkAndLoadImageList", "", "confirmClick", "outputPicListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "detachViewFromParent", "child", "initView", "loadCandidateImage", "selectMediaInfo", "path", "loadImageList", "loadPlaceHolderImage", "reportGalleryCoverAdjusted", "resetCropImageView", "setBitmapOnUiThread", "bitmap", "Landroid/graphics/Bitmap;", "showDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "updateEmptyView", "isVisible", "", "updatePlaceHolderBitmap", "Companion", "GalleryGridAdapter", "GalleryGridHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class CoverGalleryView
  extends LinearLayout
  implements IMediaContract.IView
{
  public static final CoverGalleryView.Companion a;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private CoverGalleryView.GalleryGridAdapter jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter;
  private final MediaPresenter jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaPresenter;
  private UCropView jdField_a_of_type_ComTencentTkdTopicsdkUcropViewUCropView;
  private AlbumPermissionView jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView;
  private String jdField_a_of_type_JavaLangString;
  private List<Media> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$Companion = new CoverGalleryView.Companion(null);
  }
  
  public CoverGalleryView(@NotNull Context paramContext, int paramInt1, int paramInt2, @NotNull String paramString, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaPresenter = new MediaPresenter((IMediaContract.IModel)new SelectMediaModel(paramContext));
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter = new CoverGalleryView.GalleryGridAdapter(this);
    LayoutInflater.from(paramContext).inflate(R.layout.h, (ViewGroup)this, true);
    a();
  }
  
  private final void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaPresenter.a((IMediaContract.IView)this);
    Object localObject = findViewById(R.id.N);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.gv_gallery)");
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localObject);
    localObject = findViewById(R.id.jdField_a_of_type_Int);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.album_empty_layout)");
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = findViewById(R.id.ab);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.iv_gallery_cover)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewUCropView = ((UCropView)localObject);
    localObject = findViewById(R.id.jdField_b_of_type_Int);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.album_permission_view)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView = ((AlbumPermissionView)localObject);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("albumPermissionView");
    }
    ((AlbumPermissionView)localObject).setOnPermissionCallback((IPermission.ISimpleCallback)new CoverGalleryView.initView.1(this));
    localObject = findViewById(R.id.af);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.ll_content_view)");
    this.jdField_b_of_type_AndroidViewView = ((View)localObject);
    this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter.a((Function1)new CoverGalleryView.initView.2(this));
    localObject = this.jdField_a_of_type_AndroidWidgetGridView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gridView");
    }
    ((GridView)localObject).setAdapter((ListAdapter)this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter);
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
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewUCropView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("candidateCover");
    }
    ((UCropView)localObject).a();
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0))
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewUCropView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("candidateCover");
      }
      localObject = ((UCropView)localObject).a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "candidateCover.cropImageView");
      ((GestureCropImageView)localObject).setOnTouchListener((View.OnTouchListener)new CoverGalleryView.resetCropImageView.1(this));
      ((GestureCropImageView)localObject).setRotateEnabled(false);
      ((GestureCropImageView)localObject).setMaxResultImageSizeX(this.jdField_a_of_type_Int);
      ((GestureCropImageView)localObject).setMaxResultImageSizeY(this.jdField_b_of_type_Int);
      ((GestureCropImageView)localObject).setTargetAspectRatio(this.jdField_a_of_type_Int / this.jdField_b_of_type_Int);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setAspectRatio error mVideoWidth:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", mVideoHeight");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    TLog.d("CoverGalleryView", ((StringBuilder)localObject).toString());
  }
  
  private final void b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    ThreadManagerKt.a((Function0)new CoverGalleryView.setBitmapOnUiThread.1(this, paramBitmap));
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
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  private final void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("albumPermissionView");
    }
    if (((AlbumPermissionView)localObject).a())
    {
      f();
      return;
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("dataContentView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("albumPermissionView");
    }
    ((AlbumPermissionView)localObject).setVisibility(0);
  }
  
  private final void f()
  {
    IMediaContract.IPresenter.DefaultImpls.a(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaPresenter, PanelType.PHOTO, null, 2, null);
  }
  
  public final void a(@Nullable Bitmap paramBitmap)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter.a() >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString)) && (i == 0)) {
      b(paramBitmap);
    }
  }
  
  public final void a(@NotNull OutputPicListener paramOutputPicListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputPicListener, "outputPicListener");
    String str = TopicSDK.a.a().a().a().c();
    UCropView localUCropView = this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewUCropView;
    if (localUCropView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("candidateCover");
    }
    localUCropView.a().a(Bitmap.CompressFormat.JPEG, 90, str, (BitmapCropCallback)new CoverGalleryView.confirmClick.1(this, paramOutputPicListener));
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
    this.jdField_a_of_type_JavaUtilList = ((List)paramArrayList);
    this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("emptyView");
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  protected void detachViewFromParent(@Nullable View paramView)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaPresenter.a();
    super.detachViewFromParent(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView
 * JD-Core Version:    0.7.0.1
 */