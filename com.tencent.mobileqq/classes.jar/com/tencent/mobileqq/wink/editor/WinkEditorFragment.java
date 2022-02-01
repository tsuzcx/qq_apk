package com.tencent.mobileqq.wink.editor;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.QQWinkEnvironment;
import com.tencent.mobileqq.wink.WinkResManager;
import com.tencent.mobileqq.wink.edit.log.TavCutQLog;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingMenuPart;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.export.WinkExportViewModel;
import com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterMenuPart;
import com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterViewModel;
import com.tencent.mobileqq.wink.editor.menu.BottomDashboardMenuPart;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPart;
import com.tencent.mobileqq.wink.editor.music.ui.MarqueeTextView;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.recommend.WinkRecommendViewModel;
import com.tencent.mobileqq.wink.editor.sticker.WinkEditorStickerMenuPart;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel;
import com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart;
import com.tencent.mobileqq.wink.editor.text.WinkEditorTextMenuPart;
import com.tencent.mobileqq.wink.editor.text.WinkEditorTextViewModel;
import com.tencent.mobileqq.wink.editor.transition.TransitionResourceManager;
import com.tencent.mobileqq.wink.editor.view.BorderView;
import com.tencent.mobileqq.wink.editor.view.BorderView.Direction;
import com.tencent.mobileqq.wink.editor.view.BorderView.StickerOperationCallBack;
import com.tencent.mobileqq.wink.editor.view.ProgressView;
import com.tencent.mobileqq.wink.event.ImagePageTouchEvent;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.utils.QQWinkEditorUtils;
import com.tencent.mobileqq.wink.utils.StickerBorder;
import com.tencent.mobileqq.wink.view.WinkStickerFrameLayout;
import com.tencent.mobileqq.wink.view.WinkStickerFrameLayout.BorderIconMode;
import com.tencent.mobileqq.wink.view.WinkStickerFrameLayout.MenuClickListener;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.open.base.MD5;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.config.DynamicSoConfig;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.render.player.IPlayer.PlayerListener;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.Size;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$StickerOperationCallBack;", "()V", "backBtn", "Landroid/widget/ImageView;", "clientTraceId", "", "dashboardMenuPart", "Lcom/tencent/mobileqq/wink/editor/menu/BottomDashboardMenuPart;", "editorDataServiceHandler", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "imageBgmPlayer", "Landroid/media/MediaPlayer;", "mCurTavCut", "Lcom/tencent/mobileqq/wink/editor/WinkTavCutDelegate;", "mFakeFeedLayout", "Landroid/widget/RelativeLayout;", "mHandler", "Landroid/os/Handler;", "mImageTavCut", "mLoadingDialog", "Landroid/app/Dialog;", "mLoadingView", "Lcom/tencent/mobileqq/wink/editor/view/ProgressView;", "mStickerBorderView", "Lcom/tencent/mobileqq/wink/editor/view/BorderView;", "mVideoTavCut", "mWinkExportViewModel", "Lcom/tencent/mobileqq/wink/editor/export/WinkExportViewModel;", "mWinkStickerFrameLayout", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout;", "menuBar", "Landroid/widget/LinearLayout;", "musicMenuItem", "Lcom/tencent/mobileqq/wink/editor/music/ui/MarqueeTextView;", "musicMenuPart", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicMenuPart;", "musicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicVolumeViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "nextButton", "Landroid/widget/TextView;", "parts", "", "Lcom/tencent/biz/richframework/part/Part;", "playerContainerWrapper", "Landroid/widget/FrameLayout;", "playerListener", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerListener;", "stickerMenuPart", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkEditorStickerMenuPart;", "textMenuPart", "Lcom/tencent/mobileqq/wink/editor/text/WinkEditorTextMenuPart;", "tongKuanMusicMid", "winkEditorFilterViewModel", "Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorFilterViewModel;", "winkEditorTemplateViewModel", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateViewModel;", "winkEditorTextViewModel", "Lcom/tencent/mobileqq/wink/editor/text/WinkEditorTextViewModel;", "winkEditorViewModel", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "winkRecommendViewModel", "Lcom/tencent/mobileqq/wink/editor/recommend/WinkRecommendViewModel;", "assembleParts", "changeUIStatus", "", "view", "Landroid/view/View;", "visibility", "", "dismissLoadingDialog", "dtCustomReport", "elementId", "eventId", "otherParams", "", "", "enableRootViewSetFitsSystemWindows", "", "getAvatarBitmap", "Landroid/graphics/Bitmap;", "uin", "getAvatarPath", "getContentLayoutId", "getCurrentStickerModel", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "eventX", "", "eventY", "getCurrentStickerWithTwoFinger", "fingerOne", "Landroid/graphics/PointF;", "fingerTwo", "getDeleteIconLocation", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getLayoutCenter", "layout", "getLogTag", "getMusicSourceViewModel", "getRealSticker", "stickerList", "", "getRealStickerForTwoFinger", "getRenderHeight", "getRenderWidth", "getStatusBarColor", "getTavCut", "getWrapperContainerHeight", "handleTongKuanMusic", "imageModeStickerBind", "stickerModel", "initEditorViewModel", "initExportViewModel", "initFakeFeedData", "initFilterViewModel", "initMusicSourceViewModel", "initMusicVolumeViewModel", "initNextBtn", "initRecommendViewModel", "initStickerView", "initTavCut", "params", "Lcom/tencent/mobileqq/wink/editor/WinkTavCutDelegate$WinkTavCutParams;", "initTemplateViewModel", "initViewModel", "interceptGoBackEvent", "isAllImage", "mediaClips", "Lcom/tencent/videocut/model/MediaClip;", "loadLightAssets", "onAttach", "context", "Landroid/content/Context;", "onBackEvent", "onClick", "onDestroy", "onDestroyView", "onDoubleClick", "onHiddenChanged", "hidden", "onPause", "onReceiveEvent", "simpleBaseEvent", "onResume", "onStickerChange", "onStickerDelete", "onStickerMoveUIChange", "isMove", "onSwipe", "direction", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$Direction;", "onUpdate", "type", "isSuccess", "data", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "pauseImageBgm", "pauseVideoBgm", "refreshTransitionParams", "resumeImageBgm", "resumeVideoBgm", "showLoadingDialog", "msg", "", "cancelable", "delay", "", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "updateDuration", "durationUs", "videoModeStickerBind", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditorFragment
  extends BasePartFragment
  implements SimpleEventReceiver<SimpleBaseEvent>, BusinessObserver, BorderView.StickerOperationCallBack
{
  public static final WinkEditorFragment.Companion a = new WinkEditorFragment.Companion(null);
  private MusicVolumeControlViewModel A;
  private MusicSourceViewModel B;
  private WinkEditorTextViewModel F;
  private WinkExportViewModel G;
  private String H;
  private String I;
  private MediaPlayer J;
  private final IPlayer.PlayerListener K;
  private HashMap L;
  private final List<Part> b = (List)new ArrayList();
  private FrameLayout c;
  private ViewTreeObserver.OnGlobalLayoutListener d;
  private ImageView e;
  private TextView f;
  private LinearLayout g;
  private MarqueeTextView h;
  private BorderView i;
  private RelativeLayout j;
  private WinkStickerFrameLayout k;
  private BottomDashboardMenuPart l;
  private WinkEditorTextMenuPart m;
  private WinkEditorStickerMenuPart n;
  private WinkEditorMusicMenuPart o;
  private WinkTavCutDelegate p;
  private WinkTavCutDelegate q;
  private WinkTavCutDelegate r;
  private Handler s = new Handler(Looper.getMainLooper());
  private Dialog t;
  private ProgressView u;
  private final WinkDataServiceHandler v;
  private WinkEditorViewModel w;
  private WinkRecommendViewModel x;
  private WinkEditorTemplateViewModel y;
  private WinkEditorFilterViewModel z;
  
  public WinkEditorFragment()
  {
    BusinessHandler localBusinessHandler = QQWinkEnvironment.c().getBusinessHandler(WinkDataServiceHandler.class.getName());
    if (localBusinessHandler != null)
    {
      this.v = ((WinkDataServiceHandler)localBusinessHandler);
      this.H = "";
      this.I = "";
      this.J = new MediaPlayer();
      this.K = ((IPlayer.PlayerListener)new WinkEditorFragment.playerListener.1(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler");
  }
  
  private final void A()
  {
    WinkEditorViewModel localWinkEditorViewModel = this.w;
    if (localWinkEditorViewModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    localWinkEditorViewModel.b().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initEditorViewModel.1(this));
    localWinkEditorViewModel = this.w;
    if (localWinkEditorViewModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    localWinkEditorViewModel.c().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initEditorViewModel.2(this));
    localWinkEditorViewModel = this.w;
    if (localWinkEditorViewModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    localWinkEditorViewModel.d().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initEditorViewModel.3(this));
  }
  
  private final void B()
  {
    WinkRecommendViewModel localWinkRecommendViewModel = this.x;
    if (localWinkRecommendViewModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkRecommendViewModel");
    }
    localWinkRecommendViewModel.b().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initRecommendViewModel.1(this));
  }
  
  private final void C()
  {
    Object localObject = a(WinkEditorTemplateViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "getViewModel(WinkEditorT…ateViewModel::class.java)");
    this.y = ((WinkEditorTemplateViewModel)localObject);
    localObject = this.y;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateViewModel");
    }
    ((WinkEditorTemplateViewModel)localObject).c().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initTemplateViewModel.1(this));
    localObject = this.y;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateViewModel");
    }
    ((WinkEditorTemplateViewModel)localObject).b().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initTemplateViewModel.2(this));
  }
  
  private final void D()
  {
    Object localObject = a(WinkEditorFilterViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "getViewModel(WinkEditorF…terViewModel::class.java)");
    this.z = ((WinkEditorFilterViewModel)localObject);
    localObject = this.z;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorFilterViewModel");
    }
    WinkTavCutDelegate localWinkTavCutDelegate = this.p;
    long l1;
    if (localWinkTavCutDelegate != null) {
      l1 = localWinkTavCutDelegate.e();
    } else {
      l1 = 0L;
    }
    ((WinkEditorFilterViewModel)localObject).a(l1);
  }
  
  private final void E()
  {
    Object localObject = new ViewModelProvider((ViewModelStoreOwner)requireActivity()).get(MusicSourceViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewModelProvider(requir…rceViewModel::class.java)");
    this.B = ((MusicSourceViewModel)localObject);
    y();
    localObject = this.B;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
    }
    ((MusicSourceViewModel)localObject).p().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initMusicSourceViewModel.1(this));
    localObject = this.B;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
    }
    ((MusicSourceViewModel)localObject).a().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initMusicSourceViewModel.2(this));
    localObject = this.B;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
    }
    ((MusicSourceViewModel)localObject).d().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initMusicSourceViewModel.3(this));
    localObject = this.B;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
    }
    ((MusicSourceViewModel)localObject).j().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initMusicSourceViewModel.4(this));
    localObject = this.w;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    if (((WinkEditorViewModel)localObject).m())
    {
      localObject = this.w;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
      }
      if (!((WinkEditorViewModel)localObject).r())
      {
        localObject = this.w;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
        }
        if (!((WinkEditorViewModel)localObject).s())
        {
          localObject = this.A;
          if (localObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
          }
          ((MusicVolumeControlViewModel)localObject).d(false);
          localObject = this.B;
          if (localObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
          }
          ((MusicSourceViewModel)localObject).a(true);
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)this.I))
    {
      localObject = this.B;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
      }
      ((MusicSourceViewModel)localObject).a(true);
    }
    localObject = this.B;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
    }
    ((MusicSourceViewModel)localObject).f().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initMusicSourceViewModel.5(this));
  }
  
  private final void F()
  {
    Object localObject = new ViewModelProvider((ViewModelStoreOwner)requireActivity()).get(MusicVolumeControlViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewModelProvider(requir…rolViewModel::class.java)");
    this.A = ((MusicVolumeControlViewModel)localObject);
    localObject = this.A;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
    }
    ((MusicVolumeControlViewModel)localObject).b().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initMusicVolumeViewModel.1(this));
    localObject = this.A;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
    }
    ((MusicVolumeControlViewModel)localObject).d().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initMusicVolumeViewModel.2(this));
  }
  
  private final void G()
  {
    Object localObject = QRoute.api(IAEResUtil.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IAEResUtil::class.java)");
    WinkResManager.a(((IAEResUtil)localObject).getFinalUnzipFilePath());
    localObject = QRoute.api(IAEResUtil.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IAEResUtil::class.java)");
    localObject = ((IAEResUtil)localObject).getLightAssetsDir();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IAEResUtil::class.java).lightAssetsDir");
    TavCut.a((String)localObject);
    localObject = QRoute.api(IAEResUtil.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IAEResUtil::class.java)");
    localObject = ((IAEResUtil)localObject).getFinalUnzipFilePath();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IAEResUtil::c….java).finalUnzipFilePath");
    TavCut.a((List)new ArrayList((Collection)SetsKt.setOf(new DynamicSoConfig((String)localObject, "liblight-sdk.so", false))));
  }
  
  private final Bitmap a(String paramString)
  {
    paramString = b(paramString);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    int i1 = 0;
    do
    {
      BitmapManager.a(paramString, localOptions, localBitmapDecodeResult);
      i1 += 1;
    } while ((i1 < 2) && (localBitmapDecodeResult.b == 1));
    return localBitmapDecodeResult.a;
  }
  
  private final WinkStickerModel a(List<? extends WinkStickerModel> paramList, PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = 2147483647;
    WinkStickerModel localWinkStickerModel = (WinkStickerModel)null;
    Iterator localIterator = paramList.iterator();
    paramList = localWinkStickerModel;
    while (localIterator.hasNext())
    {
      localWinkStickerModel = (WinkStickerModel)localIterator.next();
      float f2 = paramPointF1.x;
      float f4 = paramPointF2.x;
      float f3 = 2;
      f2 = (f2 + f4) / f3;
      f3 = (paramPointF2.y + paramPointF2.y) / f3;
      f4 = localWinkStickerModel.centerX;
      float f5 = 1;
      float f6 = k();
      float f7 = localWinkStickerModel.centerY;
      float f8 = l();
      f2 = QQWinkEditorUtils.a(new PointF(f2, f3), new PointF((f4 + f5) * f6, (f5 - f7) * f8));
      if (f2 < f1)
      {
        paramList = localWinkStickerModel;
        f1 = f2;
      }
    }
    return paramList;
  }
  
  private final void a(long paramLong)
  {
    Object localObject = this.z;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorFilterViewModel");
    }
    ((WinkEditorFilterViewModel)localObject).a(paramLong);
    localObject = this.o;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicMenuPart");
    }
    ((WinkEditorMusicMenuPart)localObject).a(paramLong);
  }
  
  private final void a(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
  }
  
  private final void a(View paramView, String paramString1, String paramString2, Map<String, ? extends Object> paramMap)
  {
    VideoReport.setElementId(paramView, paramString1);
    paramString1 = WinkDTParamBuilder.buildElementParams();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "map");
    paramString1.put("xsj_camera_clck_ref_pgid", WinkDatongCurrentParams.params.get("xsj_camera_clck_ref_pgid"));
    paramString1.putAll(paramMap);
    VideoReport.reportEvent(paramString2, paramView, paramString1);
  }
  
  private final void a(WinkTavCutDelegate.WinkTavCutParams paramWinkTavCutParams)
  {
    if (paramWinkTavCutParams == null) {
      return;
    }
    if (paramWinkTavCutParams.b() == WinkEditorViewModel.EditMode.Image)
    {
      if (this.r == null)
      {
        this.r = ((WinkTavCutDelegate)new WinkImageTavCut());
        localObject1 = this.r;
        if (localObject1 != null) {
          ((WinkTavCutDelegate)localObject1).a((BasePartFragment)this, paramWinkTavCutParams);
        }
      }
      localObject1 = this.q;
      if (localObject1 != null) {
        ((WinkTavCutDelegate)localObject1).a(true);
      }
      this.p = this.r;
      localObject1 = this.i;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mStickerBorderView");
      }
      ((BorderView)localObject1).setBorderViewEventConsumable(false);
    }
    else
    {
      if (this.q == null)
      {
        this.q = ((WinkTavCutDelegate)new WinkVideoTavCut());
        localObject1 = this.q;
        if (localObject1 != null) {
          ((WinkTavCutDelegate)localObject1).a((BasePartFragment)this, paramWinkTavCutParams);
        }
        localObject1 = this.q;
        if (localObject1 != null)
        {
          localObject1 = ((WinkTavCutDelegate)localObject1).a();
          if (localObject1 != null) {
            ((IPlayer)localObject1).a(this.K);
          }
        }
        localObject1 = this.q;
        if (localObject1 != null) {
          ((WinkTavCutDelegate)localObject1).b(0.5F);
        }
      }
      localObject1 = this.q;
      if (localObject1 == null) {
        break label534;
      }
      ((WinkVideoTavCut)localObject1).m();
      localObject1 = this.r;
      if (localObject1 != null) {
        ((WinkTavCutDelegate)localObject1).a(true);
      }
      this.p = this.q;
      localObject1 = this.i;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mStickerBorderView");
      }
      ((BorderView)localObject1).setBorderViewEventConsumable(true);
    }
    a(((WinkEditData)paramWinkTavCutParams.c().get(0)).getDurationUs());
    Object localObject1 = this.p;
    if (localObject1 != null) {
      ((WinkTavCutDelegate)localObject1).a(false);
    }
    localObject1 = ((Iterable)this.b).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Part)((Iterator)localObject1).next();
      if ((localObject2 instanceof WinkEditorMenuPart)) {
        ((WinkEditorMenuPart)localObject2).a(paramWinkTavCutParams.b());
      }
    }
    if (paramWinkTavCutParams.a())
    {
      localObject1 = this.x;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("winkRecommendViewModel");
      }
      localObject2 = (Iterable)paramWinkTavCutParams.c();
      paramWinkTavCutParams = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramWinkTavCutParams.add(((WinkEditData)((Iterator)localObject2).next()).getMediaModel());
      }
      paramWinkTavCutParams = (List)paramWinkTavCutParams;
      localObject2 = this.w;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
      }
      boolean bool = ((WinkEditorViewModel)localObject2).m();
      localObject2 = this.p;
      long l1;
      if (localObject2 != null) {
        l1 = ((WinkTavCutDelegate)localObject2).e();
      } else {
        l1 = 0L;
      }
      ((WinkRecommendViewModel)localObject1).a(paramWinkTavCutParams, bool, l1);
    }
    return;
    label534:
    paramWinkTavCutParams = new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
    for (;;)
    {
      throw paramWinkTavCutParams;
    }
  }
  
  private final void a(List<MediaClip> paramList)
  {
    if ((this.p instanceof WinkImageTavCut)) {
      return;
    }
    if (!QzoneConfig.getWinkTransitionSwitch()) {
      return;
    }
    if (c(paramList))
    {
      paramList = this.p;
      if (paramList != null)
      {
        ((WinkVideoTavCut)paramList).m();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
    }
    paramList = this.p;
    if (paramList != null)
    {
      ((WinkVideoTavCut)paramList).n();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
  }
  
  private final WinkStickerModel b(List<? extends WinkStickerModel> paramList)
  {
    WinkStickerModel localWinkStickerModel = (WinkStickerModel)null;
    Iterator localIterator = paramList.iterator();
    int i1 = -2147483648;
    paramList = localWinkStickerModel;
    while (localIterator.hasNext())
    {
      localWinkStickerModel = (WinkStickerModel)localIterator.next();
      if (localWinkStickerModel.layerIndex > i1)
      {
        i1 = localWinkStickerModel.layerIndex;
        paramList = localWinkStickerModel;
      }
    }
    return paramList;
  }
  
  private final String b(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(256);
    if (SystemUtil.a()) {
      localStringBuilder1.append(AppConstants.PATH_HEAD_HD);
    } else {
      localStringBuilder1.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
    }
    if (paramString != null)
    {
      String str = MD5.b(paramString);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(str);
      localStringBuilder2.append(paramString);
      str = MD5.b(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(str);
      localStringBuilder2.append(paramString);
      localStringBuilder1.append(MD5.b(localStringBuilder2.toString()));
    }
    localStringBuilder1.append(".jpg_");
    paramString = localStringBuilder1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "sb.toString()");
    return paramString;
  }
  
  private final void b(View paramView)
  {
    paramView = paramView.findViewById(2131439283);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.nextBtn)");
    this.f = ((TextView)paramView);
    paramView = this.f;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("nextButton");
    }
    paramView.setOnClickListener((View.OnClickListener)new WinkEditorFragment.initNextBtn.1(this));
  }
  
  private final void c(View paramView)
  {
    Object localObject = paramView.findViewById(2131446386);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.stickerControlView)");
    this.i = ((BorderView)localObject);
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mStickerBorderView");
    }
    ((BorderView)localObject).setOperationCallback((BorderView.StickerOperationCallBack)this);
    paramView = paramView.findViewById(2131450173);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.winkStickerFrameLayout)");
    this.k = ((WinkStickerFrameLayout)paramView);
    paramView = this.k;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mWinkStickerFrameLayout");
    }
    paramView.setMenuClickListener((WinkStickerFrameLayout.MenuClickListener)new WinkEditorFragment.initStickerView.1(this));
  }
  
  private final boolean c(List<MediaClip> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 1) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MediaClip localMediaClip = (MediaClip)paramList.next();
        if ((localMediaClip.resource != null) && (localMediaClip.resource.type != MediaType.IMAGE)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private final void d(View paramView)
  {
    paramView = paramView.findViewById(2131432781);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.fakeFeedView)");
    this.j = ((RelativeLayout)paramView);
    paramView = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "MobileQQ.sMobileQQ.waitAppRuntime(null)");
    paramView = paramView.getAccount();
    Object localObject1 = QQWinkEnvironment.c().getRuntimeService(IFriendNameService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQWinkEnvironment.getApp…va, ProcessConstant.MAIN)");
    Object localObject3 = (IFriendNameService)localObject1;
    localObject1 = this.j;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFakeFeedLayout");
    }
    localObject1 = (ImageView)((RelativeLayout)localObject1).findViewById(2131433354);
    Object localObject2 = this.j;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFakeFeedLayout");
    }
    localObject2 = (TextView)((RelativeLayout)localObject2).findViewById(2131433358);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        return;
      }
      localObject3 = ((IFriendNameService)localObject3).getFriendNick(paramView);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "curUin");
      paramView = a(paramView);
      if (paramView != null) {
        ((ImageView)localObject1).setImageBitmap(paramView);
      } else {
        ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(2130853680));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        paramView = new StringBuilder();
        paramView.append('@');
        paramView.append((String)localObject3);
        ((TextView)localObject2).setText((CharSequence)paramView.toString());
      }
    }
  }
  
  private final void e(WinkStickerModel paramWinkStickerModel)
  {
    Object localObject = this.F;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorTextViewModel");
    }
    if (((WinkEditorTextViewModel)localObject).b(paramWinkStickerModel))
    {
      localObject = this.k;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mWinkStickerFrameLayout");
      }
      ((WinkStickerFrameLayout)localObject).a(paramWinkStickerModel, WinkStickerFrameLayout.BorderIconMode.ShowEdit);
    }
  }
  
  private final void f(WinkStickerModel paramWinkStickerModel)
  {
    Object localObject = this.F;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorTextViewModel");
    }
    if (((WinkEditorTextViewModel)localObject).b(paramWinkStickerModel)) {
      localObject = WinkStickerFrameLayout.BorderIconMode.ShowBoth;
    } else {
      localObject = WinkStickerFrameLayout.BorderIconMode.ShowDelete;
    }
    WinkStickerFrameLayout localWinkStickerFrameLayout = this.k;
    if (localWinkStickerFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mWinkStickerFrameLayout");
    }
    localWinkStickerFrameLayout.a(paramWinkStickerModel, (WinkStickerFrameLayout.BorderIconMode)localObject);
  }
  
  private final void x()
  {
    BaseViewModel localBaseViewModel = a(WinkEditorFilterViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localBaseViewModel, "getViewModel(WinkEditorF…terViewModel::class.java)");
    this.z = ((WinkEditorFilterViewModel)localBaseViewModel);
    localBaseViewModel = a(WinkEditorTextViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localBaseViewModel, "getViewModel(WinkEditorTextViewModel::class.java)");
    this.F = ((WinkEditorTextViewModel)localBaseViewModel);
    A();
    B();
    D();
    C();
    F();
    E();
    z();
  }
  
  private final void y()
  {
    Object localObject = this.w;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    int i1 = ((WinkEditorViewModel)localObject).k();
    int i2 = 0;
    if (i1 != 2)
    {
      localObject = this.w;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
      }
      if (((WinkEditorViewModel)localObject).k() != 3)
      {
        i1 = 0;
        break label60;
      }
    }
    i1 = 1;
    label60:
    localObject = this.w;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    if (((WinkEditorViewModel)localObject).k() == 1) {
      i2 = 1;
    }
    if (i1 != 0)
    {
      localObject = this.w;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
      }
      if (!TextUtils.isEmpty((CharSequence)((WinkEditorViewModel)localObject).o()))
      {
        localObject = this.w;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
        }
        this.I = ((WinkEditorViewModel)localObject).o();
        return;
      }
    }
    if ((i1 == 0) && (i2 == 1))
    {
      this.I = "";
      return;
    }
    localObject = getActivity();
    if (localObject != null)
    {
      localObject = ((FragmentActivity)localObject).getIntent();
      if (localObject != null)
      {
        localObject = ((Intent)localObject).getStringExtra("PUBLISH_SCHEMA_MUSIC_ID");
        break label189;
      }
    }
    localObject = null;
    label189:
    this.I = ((String)localObject);
  }
  
  private final void z()
  {
    Object localObject = a(WinkExportViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "getViewModel(WinkExportViewModel::class.java)");
    this.G = ((WinkExportViewModel)localObject);
    localObject = this.G;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mWinkExportViewModel");
    }
    ((WinkExportViewModel)localObject).b().observe(getViewLifecycleOwner(), (Observer)new WinkEditorFragment.initExportViewModel.1(this));
  }
  
  @Nullable
  public PointF a(@Nullable View paramView)
  {
    if (paramView == null) {
      return null;
    }
    int i1 = paramView.getTop();
    int i2 = paramView.getLeft();
    int i3 = paramView.getRight();
    int i4 = (paramView.getBottom() - i1) / 2;
    return new PointF(i2 + (i3 - i2) / 2, i1 + i4);
  }
  
  @Nullable
  public WinkStickerModel a(float paramFloat1, float paramFloat2)
  {
    Object localObject2 = this.p;
    Object localObject1 = null;
    if (localObject2 != null)
    {
      if (localObject2 != null) {
        localObject1 = ((WinkTavCutDelegate)localObject2).f();
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        return null;
      }
      localObject2 = (List)new ArrayList();
      localObject1 = this.p;
      if (localObject1 != null) {
        localObject1 = ((WinkTavCutDelegate)localObject1).f();
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        WinkStickerModel localWinkStickerModel = (WinkStickerModel)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localWinkStickerModel.isClickInside(paramFloat1, paramFloat2)) {
          ((List)localObject2).add(localWinkStickerModel);
        }
      }
      if (((List)localObject2).size() == 0) {
        return null;
      }
      localObject1 = b((List)localObject2);
    }
    return localObject1;
  }
  
  @Nullable
  public WinkStickerModel a(@NotNull PointF paramPointF1, @NotNull PointF paramPointF2)
  {
    Intrinsics.checkParameterIsNotNull(paramPointF1, "fingerOne");
    Intrinsics.checkParameterIsNotNull(paramPointF2, "fingerTwo");
    Object localObject = this.p;
    if (localObject != null)
    {
      if (localObject != null) {
        localObject = ((WinkTavCutDelegate)localObject).f();
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        List localList = (List)new ArrayList();
        localObject = this.p;
        if (localObject != null) {
          localObject = ((WinkTavCutDelegate)localObject).f();
        } else {
          localObject = null;
        }
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        Iterator localIterator = ((Map)localObject).entrySet().iterator();
        for (;;)
        {
          PointF localPointF2 = paramPointF2;
          PointF localPointF1 = paramPointF1;
          if (!localIterator.hasNext()) {
            break;
          }
          WinkStickerModel localWinkStickerModel = (WinkStickerModel)((Map.Entry)localIterator.next()).getValue();
          if (((Map)localObject).size() == 1) {
            return localWinkStickerModel;
          }
          StickerBorder localStickerBorder = QQWinkEditorUtils.a(localWinkStickerModel, k(), l());
          if (QQWinkEditorUtils.a(localPointF1.x, localPointF1.y, localPointF2.x, localPointF2.y, localStickerBorder.a, localStickerBorder.c, localStickerBorder.b, localStickerBorder.d)) {
            localList.add(localWinkStickerModel);
          }
        }
        if (localList.size() == 0) {
          return null;
        }
        return a(localList, paramPointF1, paramPointF2);
      }
    }
    return null;
  }
  
  public final void a()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((WinkTavCutDelegate)localObject).a();
      if (localObject != null) {
        ((IPlayer)localObject).b();
      }
    }
  }
  
  public void a(@NotNull WinkStickerModel paramWinkStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkStickerModel, "stickerModel");
    WinkTavCutDelegate localWinkTavCutDelegate = this.p;
    if (localWinkTavCutDelegate != null) {
      localWinkTavCutDelegate.a(paramWinkStickerModel);
    }
    paramWinkStickerModel = this.k;
    if (paramWinkStickerModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mWinkStickerFrameLayout");
    }
    paramWinkStickerModel.b();
  }
  
  public void a(@NotNull BorderView.Direction paramDirection)
  {
    Intrinsics.checkParameterIsNotNull(paramDirection, "direction");
    WinkEditorFilterViewModel localWinkEditorFilterViewModel = this.z;
    if (localWinkEditorFilterViewModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorFilterViewModel");
    }
    localWinkEditorFilterViewModel.a(paramDirection);
  }
  
  public final void a(@Nullable CharSequence paramCharSequence, boolean paramBoolean, long paramLong, @Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (getActivity() == null) {
      return;
    }
    FragmentActivity localFragmentActivity = getActivity();
    this.s.removeCallbacksAndMessages(null);
    this.s.postDelayed((Runnable)new WinkEditorFragment.showLoadingDialog.1(this, localFragmentActivity, paramOnDismissListener, paramBoolean, paramCharSequence), paramLong);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    }
    a((View)localObject, i1);
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicMenuItem");
    }
    a((View)localObject, i1);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("menuBar");
    }
    a((View)localObject, i1);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("nextButton");
    }
    a((View)localObject, i1);
  }
  
  @NotNull
  public String b()
  {
    return "WinkEditorFragment";
  }
  
  public void b(@NotNull WinkStickerModel paramWinkStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkStickerModel, "stickerModel");
    WinkTavCutDelegate localWinkTavCutDelegate = this.p;
    if (localWinkTavCutDelegate != null) {
      localWinkTavCutDelegate.b(paramWinkStickerModel);
    }
  }
  
  protected int c()
  {
    return 2131628247;
  }
  
  public void c(@Nullable WinkStickerModel paramWinkStickerModel)
  {
    if (paramWinkStickerModel == null)
    {
      paramWinkStickerModel = this.k;
      if (paramWinkStickerModel == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mWinkStickerFrameLayout");
      }
      paramWinkStickerModel.b();
      paramWinkStickerModel = this.w;
      if (paramWinkStickerModel == null) {
        Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
      }
      paramWinkStickerModel.p();
      return;
    }
    WinkEditorViewModel localWinkEditorViewModel = this.w;
    if (localWinkEditorViewModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    if (localWinkEditorViewModel.q() == 1)
    {
      f(paramWinkStickerModel);
      return;
    }
    e(paramWinkStickerModel);
  }
  
  @NotNull
  protected List<Part> d()
  {
    this.l = new BottomDashboardMenuPart();
    List localList = this.b;
    Object localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("dashboardMenuPart");
    }
    localList.add(localObject);
    this.b.add(new WinkEditorFilterMenuPart());
    this.m = new WinkEditorTextMenuPart();
    localList = this.b;
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("textMenuPart");
    }
    localList.add(localObject);
    this.n = new WinkEditorStickerMenuPart();
    localList = this.b;
    localObject = this.n;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("stickerMenuPart");
    }
    localList.add(localObject);
    this.o = new WinkEditorMusicMenuPart();
    localList = this.b;
    localObject = this.o;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicMenuPart");
    }
    localList.add(localObject);
    this.b.add(new WinkEditorVideoTemplateMenuPart());
    this.b.add(new WinkEditorClippingMenuPart());
    return this.b;
  }
  
  public void d(@Nullable WinkStickerModel paramWinkStickerModel)
  {
    if (paramWinkStickerModel != null)
    {
      WinkEditorTextViewModel localWinkEditorTextViewModel = this.F;
      if (localWinkEditorTextViewModel == null) {
        Intrinsics.throwUninitializedPropertyAccessException("winkEditorTextViewModel");
      }
      if (localWinkEditorTextViewModel.a(paramWinkStickerModel))
      {
        b(paramWinkStickerModel);
        paramWinkStickerModel = this.k;
        if (paramWinkStickerModel == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mWinkStickerFrameLayout");
        }
        paramWinkStickerModel.b();
      }
    }
  }
  
  public final void e()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((WinkTavCutDelegate)localObject).a();
      if (localObject != null) {
        ((IPlayer)localObject).a();
      }
    }
  }
  
  public final void f()
  {
    MediaPlayer localMediaPlayer = this.J;
    if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying() == true))
    {
      localMediaPlayer = this.J;
      if (localMediaPlayer != null) {
        localMediaPlayer.pause();
      }
    }
  }
  
  public final void g()
  {
    MediaPlayer localMediaPlayer = this.J;
    if ((localMediaPlayer != null) && (!localMediaPlayer.isPlaying()))
    {
      localMediaPlayer = this.J;
      if (localMediaPlayer != null) {
        localMediaPlayer.start();
      }
    }
  }
  
  @NotNull
  public ArrayList<Class<SimpleBaseEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WinkFinishActivityEvent.class);
    localArrayList.add(ImagePageTouchEvent.class);
    return localArrayList;
  }
  
  @Nullable
  public final WinkTavCutDelegate h()
  {
    return this.p;
  }
  
  @Nullable
  public PointF i()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.D.findViewById(2131436592);
    if (localLinearLayout != null) {
      return a((View)localLinearLayout);
    }
    return null;
  }
  
  protected int j()
  {
    return 0;
  }
  
  public int k()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((WinkTavCutDelegate)localObject).h();
      if (localObject != null)
      {
        localObject = ((Size)localObject).width;
        if (localObject != null) {
          return ((Integer)localObject).intValue();
        }
      }
    }
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
    }
    return ((FrameLayout)localObject).getWidth();
  }
  
  public int l()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((WinkTavCutDelegate)localObject).h();
      if (localObject != null)
      {
        localObject = ((Size)localObject).height;
        if (localObject != null) {
          return ((Integer)localObject).intValue();
        }
      }
    }
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
    }
    return ((FrameLayout)localObject).getHeight();
  }
  
  public int m()
  {
    FrameLayout localFrameLayout = this.c;
    if (localFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
    }
    if (localFrameLayout == null) {
      return 0;
    }
    localFrameLayout = this.c;
    if (localFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
    }
    return localFrameLayout.getHeight();
  }
  
  @NotNull
  public final MusicSourceViewModel n()
  {
    MusicSourceViewModel localMusicSourceViewModel = this.B;
    if (localMusicSourceViewModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
    }
    return localMusicSourceViewModel;
  }
  
  public final void o()
  {
    this.s.removeCallbacksAndMessages(null);
    this.s.post((Runnable)new WinkEditorFragment.dismissLoadingDialog.1(this));
  }
  
  public void onAttach(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    super.onAttach(paramContext);
    G();
    WinkEditorResourceManager.c().j();
    WinkEditorResourceManager.c().k();
    WinkEditorResourceManager.c().l();
    WinkEditorResourceManager.c().m();
    WinkEditorResourceManager.c().o();
    WinkEditorResourceManager.c().p();
    WinkEditorResourceManager.c().n();
    TransitionResourceManager.a().b(paramContext);
    QQWinkEnvironment.c().addObserver((BusinessObserver)this);
    this.v.a("MqKuaishanEdit");
    paramContext = getActivity();
    if (paramContext != null)
    {
      paramContext = paramContext.getIntent();
      if (paramContext != null)
      {
        paramContext = paramContext.getStringExtra("qcircle_client_traceid");
        break label116;
      }
    }
    paramContext = null;
    label116:
    this.H = paramContext;
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.w;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    if (((WinkEditorViewModel)localObject).u()) {
      return true;
    }
    localObject = this.p;
    if ((localObject != null) && (((WinkTavCutDelegate)localObject).k() == true))
    {
      u();
      return true;
    }
    localObject = this.w;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    ((WinkEditorViewModel)localObject).a(getContext());
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MediaPlayer localMediaPlayer = this.J;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
    a();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver)this);
    WinkTavCutDelegate localWinkTavCutDelegate = this.q;
    if (localWinkTavCutDelegate != null) {
      localWinkTavCutDelegate.c();
    }
    localWinkTavCutDelegate = this.r;
    if (localWinkTavCutDelegate != null) {
      localWinkTavCutDelegate.c();
    }
    w();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    Object localObject1;
    if (!paramBoolean)
    {
      localObject1 = getArguments();
      if ((localObject1 != null) && (((Bundle)localObject1).containsKey("IS_FROM_CLIP") == true) && ((this.p instanceof WinkVideoTavCut)))
      {
        localObject1 = getArguments();
        if ((localObject1 != null) && (((Bundle)localObject1).getBoolean("IS_FROM_CLIP")))
        {
          Object localObject2 = this.w;
          if (localObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
          }
          ((WinkEditorViewModel)localObject2).p();
          localObject2 = ((Bundle)localObject1).getParcelableArrayList("CLIP_RESOURCE_MODEL");
          if (localObject2 != null)
          {
            localObject3 = this.y;
            if (localObject3 == null) {
              Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateViewModel");
            }
            if (((WinkEditorTemplateViewModel)localObject3).f())
            {
              localObject3 = this.y;
              if (localObject3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkEditorTemplateViewModel");
              }
              WinkTavCutDelegate localWinkTavCutDelegate = this.p;
              if (localWinkTavCutDelegate != null) {
                ((WinkEditorTemplateViewModel)localObject3).a(((WinkVideoTavCut)localWinkTavCutDelegate).l(), (List)localObject2);
              } else {
                throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
              }
            }
            else
            {
              localObject3 = this.p;
              if (localObject3 != null) {
                ((WinkVideoTavCut)localObject3).a((List)localObject2);
              } else {
                throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
              }
            }
          }
          Object localObject3 = (List)localObject2;
          a((List)localObject3);
          long l2 = ((Bundle)localObject1).getLong("MEDIA_DURATION");
          long l1 = l2;
          if (localObject2 != null)
          {
            l1 = l2;
            if (c((List)localObject3))
            {
              l1 = l2;
              if (QzoneConfig.getWinkTransitionSwitch())
              {
                long l3 = l2 - (((ArrayList)localObject2).size() - 1) * 1000000L;
                l1 = l2;
                if (l3 > ((ArrayList)localObject2).size() * 1000000L) {
                  l1 = l3;
                }
              }
            }
          }
          if (l1 != 0L)
          {
            localObject2 = this.p;
            if (localObject2 != null) {
              ((WinkTavCutDelegate)localObject2).a(l1);
            }
            a(l1);
          }
          ((Bundle)localObject1).putBoolean("IS_FROM_CLIP", false);
        }
      }
      localObject1 = this.p;
      if (localObject1 != null)
      {
        localObject1 = ((WinkTavCutDelegate)localObject1).a();
        if (localObject1 != null) {
          ((IPlayer)localObject1).a();
        }
      }
    }
    else
    {
      localObject1 = this.p;
      if (localObject1 != null)
      {
        localObject1 = ((WinkTavCutDelegate)localObject1).a();
        if (localObject1 != null) {
          ((IPlayer)localObject1).b();
        }
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = this.w;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    if (localObject != null) {
      localObject = ((WinkEditorViewModel)localObject).n();
    } else {
      localObject = null;
    }
    if (localObject == WinkEditorViewModel.EditMode.Image)
    {
      f();
      return;
    }
    a();
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof WinkFinishActivityEvent))
    {
      paramSimpleBaseEvent = getActivity();
      if (paramSimpleBaseEvent != null) {
        paramSimpleBaseEvent.finish();
      }
    }
    else if ((paramSimpleBaseEvent instanceof ImagePageTouchEvent))
    {
      paramSimpleBaseEvent = this.k;
      if (paramSimpleBaseEvent == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mWinkStickerFrameLayout");
      }
      if (paramSimpleBaseEvent != null)
      {
        paramSimpleBaseEvent = this.k;
        if (paramSimpleBaseEvent == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mWinkStickerFrameLayout");
        }
        paramSimpleBaseEvent.b();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.w;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    if (localObject != null) {
      localObject = ((WinkEditorViewModel)localObject).n();
    } else {
      localObject = null;
    }
    if (localObject == WinkEditorViewModel.EditMode.Image)
    {
      g();
      return;
    }
    e();
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, @Nullable Object paramObject)
  {
    if (1 == paramInt) {
      WinkEditorResourceManager.c().b();
    }
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this);
    c(paramView);
    paramBundle = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.context");
    TavCut.a(paramBundle);
    TavCutQLog.a(2, 6);
    paramBundle = a(WinkEditorViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getViewModel(WinkEditorViewModel::class.java)");
    this.w = ((WinkEditorViewModel)paramBundle);
    paramBundle = a(WinkRecommendViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getViewModel(WinkRecommendViewModel::class.java)");
    this.x = ((WinkRecommendViewModel)paramBundle);
    paramBundle = paramView.findViewById(2131440396);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.playerContainerWrapper)");
    this.c = ((FrameLayout)paramBundle);
    Object localObject = this.w;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
    }
    paramBundle = getActivity();
    if (paramBundle != null) {
      paramBundle = paramBundle.getIntent();
    } else {
      paramBundle = null;
    }
    ((WinkEditorViewModel)localObject).a(paramBundle);
    this.d = ((ViewTreeObserver.OnGlobalLayoutListener)new WinkEditorFragment.onViewCreated.1(this));
    paramBundle = this.c;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
    }
    paramBundle = paramBundle.getViewTreeObserver();
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalLayoutListener");
    }
    paramBundle.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject);
    paramBundle = paramView.findViewById(2131429211);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.backBtn)");
    this.e = ((ImageView)paramBundle);
    paramBundle = this.e;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new WinkEditorFragment.onViewCreated.2(this));
    paramBundle = paramView.findViewById(2131429627);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.bottomDashboardMenu)");
    this.g = ((LinearLayout)paramBundle);
    paramBundle = paramView.findViewById(2131439026);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "view.findViewById(R.id.musicMenuItem)");
    this.h = ((MarqueeTextView)paramBundle);
    b(paramView);
    d(paramView);
    x();
  }
  
  protected boolean s()
  {
    return false;
  }
  
  public final boolean u()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a((Context)getActivity(), 230).setTitle(getResources().getString(2131913995)).setPositiveButton(getResources().getString(2131913994), (DialogInterface.OnClickListener)new WinkEditorFragment.interceptGoBackEvent.qqCustomDialog.1(this)).setNegativeButton(getResources().getString(2131913993), (DialogInterface.OnClickListener)WinkEditorFragment.interceptGoBackEvent.qqCustomDialog.2.a);
    if (localQQCustomDialog != null) {
      try
      {
        if (!localQQCustomDialog.isShowing()) {
          localQQCustomDialog.show();
        }
      }
      catch (Throwable localThrowable)
      {
        AEQLog.a("WinkEditorFragment", localThrowable);
      }
    }
    return true;
  }
  
  public void w()
  {
    HashMap localHashMap = this.L;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment
 * JD-Core Version:    0.7.0.1
 */