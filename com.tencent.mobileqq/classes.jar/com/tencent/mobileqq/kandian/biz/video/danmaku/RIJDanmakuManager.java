package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.danmaku.core.DanmakuManager.IDanmakuListener;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext.Builder;
import com.tencent.mobileqq.danmaku.inject.IDanmakuCreator;
import com.tencent.mobileqq.danmaku.inject.IDanmakuExposureCallback;
import com.tencent.mobileqq.danmaku.inject.IDanmakuPlayTimeSupplier;
import com.tencent.mobileqq.danmaku.inject.IDanmakuUIConfig;
import com.tencent.mobileqq.danmaku.inject.IDanmakuUIConfigCreator;
import com.tencent.mobileqq.danmaku.inject.IDanmakuWindowCreator;
import com.tencent.mobileqq.danmaku.inject.VideoDanmakuConfig;
import com.tencent.mobileqq.danmaku.inject.WindowConfig;
import com.tencent.mobileqq.danmaku.render.BaseDanmakuRender;
import com.tencent.mobileqq.danmaku.tool.ClickResult;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawTimer;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.video.danmaku.ext.DanmakuManagerExt;
import com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuModel;
import com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuModel.Callback;
import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJBaseDanmaku;
import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuCreator;
import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuRender;
import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuUIConfigCreator;
import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuWindowCreator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuManager;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/IDanmakuManager;", "Lcom/tencent/mobileqq/danmaku/core/DanmakuManager$IDanmakuListener;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel$Callback;", "context", "Landroid/content/Context;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "useTextureView", "", "config", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;", "callback", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuEventCallback;", "(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;ZLcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuEventCallback;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "getCallback", "()Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuEventCallback;", "setCallback", "(Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuEventCallback;)V", "cancelClickRunnable", "Ljava/lang/Runnable;", "clickEnable", "clickingDanmaku", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJBaseDanmaku;", "getClickingDanmaku", "()Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJBaseDanmaku;", "setClickingDanmaku", "(Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJBaseDanmaku;)V", "getContext", "()Landroid/content/Context;", "value", "", "currentAuthorUin", "getCurrentAuthorUin", "()Ljava/lang/String;", "setCurrentAuthorUin", "(Ljava/lang/String;)V", "danmaViewMarginTop", "", "danmakuContext", "Lcom/tencent/mobileqq/danmaku/inject/DanmakuContext;", "danmakuManager", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ext/DanmakuManagerExt;", "danmakuUIConfigCreator", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuUIConfigCreator;", "danmakuView", "Landroid/view/View;", "handler", "Landroid/os/Handler;", "lastGetPositionTime", "", "lastPlayPositon", "model", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel;", "seeked", "touchRect", "Landroid/graphics/Rect;", "touchView", "videoHeight", "videoPlayer", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/IPlayer;", "addDanmakuNow", "", "data", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "addDanmakus", "list", "", "attachContainer", "container", "Landroid/view/ViewGroup;", "calculateTouchRect", "calculateViewHeight", "cancelClick", "changeConfig", "newConfig", "changeLayoutOrientaion", "isVertical", "clear", "clickDanmaku", "danmaku", "createDanmakuView", "destroy", "getDanmakuType", "info", "hide", "innerSeek", "position", "isInDanmakuRange", "event", "Landroid/view/MotionEvent;", "location", "", "isSeeked", "curPosition", "loadData", "rowkey", "startPosition", "onClickEvent", "Lcom/tencent/mobileqq/danmaku/data/BaseDanmaku;", "touchPoint", "Lcom/tencent/mobileqq/danmaku/tool/TouchPoint;", "clickResult", "Lcom/tencent/mobileqq/danmaku/tool/ClickResult;", "onDanmakuClicked", "onDanmaku", "onDanmakuDrawFinish", "danmakuList", "", "", "Lcom/tencent/mobileqq/danmaku/inject/IDanmakuUIConfig;", "onDanmakuExposure", "onDanmakuMesureFinish", "onGetData", "reportInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ReportInfo;", "sendDanmakuForbid", "clearData", "onGetPlayPosition", "onReportBtnClick", "onTouch", "v", "pause", "reloadConfig", "restart", "seekTo", "setDanmakuTouchArea", "marginTop", "setDanmakuViewMarginTop", "topMargin", "setPlayer", "player", "setSpeedRatio", "speed", "", "show", "start", "stop", "unclickDanmauku", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuManager
  implements View.OnTouchListener, DanmakuManager.IDanmakuListener, IDanmakuManager, RIJDanmakuModel.Callback
{
  public static final RIJDanmakuManager.Companion a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @NotNull
  private final Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final View jdField_a_of_type_AndroidViewView;
  @NotNull
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final DanmakuContext jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext;
  @Nullable
  private DanmakuEventCallback jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuEventCallback;
  private IPlayer jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuIPlayer;
  private RIJDanmakuConfig jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig;
  private final DanmakuManagerExt jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt;
  private final RIJDanmakuModel jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel;
  @Nullable
  private RIJBaseDanmaku jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku;
  private final RIJDanmakuUIConfigCreator jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJDanmakuUIConfigCreator;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private final View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private final boolean c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuManager$Companion = new RIJDanmakuManager.Companion(null);
  }
  
  public RIJDanmakuManager(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface, boolean paramBoolean, @NotNull RIJDanmakuConfig paramRIJDanmakuConfig, @Nullable DanmakuEventCallback paramDanmakuEventCallback)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.c = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig = paramRIJDanmakuConfig;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuEventCallback = paramDanmakuEventCallback;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new RIJDanmakuManager.cancelClickRunnable.1(this));
    this.jdField_a_of_type_JavaLangString = "";
    VideoDanmakuConfig.a(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJDanmakuUIConfigCreator = new RIJDanmakuUIConfigCreator(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig);
    b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig);
    this.jdField_a_of_type_AndroidViewView = a();
    paramContext = DanmakuContext.a().a((IDanmakuPlayTimeSupplier)new RIJDanmakuManager.1(this)).a(-4).a((IDanmakuUIConfigCreator)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJDanmakuUIConfigCreator).a((BaseDanmakuRender)new RIJDanmakuRender(this.jdField_a_of_type_AndroidContentContext)).a((IDanmakuCreator)new RIJDanmakuCreator(this.jdField_a_of_type_AndroidViewView)).a((IDanmakuExposureCallback)new RIJDanmakuManager.2(this)).a((IDanmakuWindowCreator)new RIJDanmakuWindowCreator()).a();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "DanmakuContext.newBuilde…\n                .build()");
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt = new DanmakuManagerExt(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a((DanmakuManager.IDanmakuListener)this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a(false);
    paramContext = this.jdField_a_of_type_AndroidViewView;
    if ((paramContext instanceof SurfaceView)) {
      ((SurfaceView)paramContext).setZOrderOnTop(true);
    }
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel = new RIJDanmakuModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RIJDanmakuModel.Callback)this);
    this.jdField_b_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)this);
    RIJDanmakuManager.Companion.a(jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuManager$Companion);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("config: ");
      paramContext.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig);
      paramContext.append(", useTextureView=");
      paramContext.append(this.c);
      paramContext.append(", miniHeight=");
      paramContext.append(a());
      QLog.d("RIJDanmakuManager", 2, paramContext.toString());
    }
  }
  
  private final int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig.a() * this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a();
  }
  
  private final int a(DanmakuDetail paramDanmakuDetail)
  {
    if ((Intrinsics.areEqual(paramDanmakuDetail.a().a(), this.jdField_a_of_type_JavaLangString)) && (Intrinsics.areEqual(paramDanmakuDetail.a().a(), RIJQQAppInterfaceUtil.a()))) {
      return 20;
    }
    if (Intrinsics.areEqual(paramDanmakuDetail.a().a(), this.jdField_a_of_type_JavaLangString)) {
      return 19;
    }
    if (Intrinsics.areEqual(paramDanmakuDetail.a().a(), RIJQQAppInterfaceUtil.a())) {
      return 18;
    }
    return 17;
  }
  
  private final long a()
  {
    long l3 = System.currentTimeMillis();
    if (l3 - this.jdField_b_of_type_Long > 'È')
    {
      IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuIPlayer;
      long l1;
      if (localIPlayer != null) {
        l1 = localIPlayer.getCurrentPosition();
      } else {
        l1 = 0L;
      }
      localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuIPlayer;
      long l2;
      if (localIPlayer != null) {
        l2 = localIPlayer.getDuration();
      } else {
        l2 = 0L;
      }
      localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuIPlayer;
      if (localIPlayer != null)
      {
        long l4 = 2000;
        if ((l1 < l4) && (l2 > 0L) && (this.jdField_a_of_type_Long > localIPlayer.getDuration() - l4))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.o();
          b(0);
        }
      }
      if ((this.jdField_a_of_type_Boolean) && (a(l1)))
      {
        this.jdField_a_of_type_Boolean = false;
        b((int)(l1 / 1000));
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel.a((int)(l1 / 1000));
      this.jdField_b_of_type_Long = l3;
      this.jdField_a_of_type_Long = l1;
    }
    return this.jdField_a_of_type_Long;
  }
  
  private final View a()
  {
    if (this.c) {
      return (View)new TextureView(this.jdField_a_of_type_AndroidContentContext);
    }
    return (View)new SurfaceView(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private final void a(BaseDanmaku<Object, IDanmakuUIConfig> paramBaseDanmaku)
  {
    Object localObject;
    if (!(paramBaseDanmaku instanceof RIJBaseDanmaku)) {
      localObject = null;
    } else {
      localObject = paramBaseDanmaku;
    }
    if ((RIJBaseDanmaku)localObject != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuEventCallback;
      if (localObject != null)
      {
        paramBaseDanmaku = (DanmakuDetail)((RIJBaseDanmaku)paramBaseDanmaku).a();
        Intrinsics.checkExpressionValueIsNotNull(paramBaseDanmaku, "danmaku.data");
        ((DanmakuEventCallback)localObject).onDanmakuExposure(paramBaseDanmaku);
      }
    }
  }
  
  private final void a(RIJBaseDanmaku paramRIJBaseDanmaku)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReportBtnClick: danmaku=");
      ((StringBuilder)localObject).append(paramRIJBaseDanmaku);
      QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuEventCallback;
    if (localObject != null)
    {
      paramRIJBaseDanmaku = (DanmakuDetail)paramRIJBaseDanmaku.a();
      Intrinsics.checkExpressionValueIsNotNull(paramRIJBaseDanmaku, "danmaku.data");
      ((DanmakuEventCallback)localObject).onClickReport(paramRIJBaseDanmaku);
    }
  }
  
  private final boolean a(long paramLong)
  {
    return Math.abs(paramLong - this.jdField_a_of_type_Long) > 3;
  }
  
  private final boolean a(MotionEvent paramMotionEvent, int[] paramArrayOfInt)
  {
    float f = paramMotionEvent.getRawX();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (f > paramArrayOfInt[0])
    {
      bool1 = bool2;
      if (paramMotionEvent.getRawX() < paramArrayOfInt[0] + this.jdField_a_of_type_AndroidViewView.getWidth())
      {
        bool1 = bool2;
        if (paramMotionEvent.getRawY() > paramArrayOfInt[1])
        {
          bool1 = bool2;
          if (paramMotionEvent.getRawY() < paramArrayOfInt[1] + this.jdField_a_of_type_AndroidViewView.getHeight()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private final void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("innerSeek: position=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.b(paramInt * 1000);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel;
    ((RIJDanmakuModel)localObject).a(((RIJDanmakuModel)localObject).a(), paramInt);
  }
  
  private final void b(RIJDanmakuConfig paramRIJDanmakuConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig = paramRIJDanmakuConfig;
    WindowConfig localWindowConfig = DanmakuContext.a();
    Intrinsics.checkExpressionValueIsNotNull(localWindowConfig, "windowConfig");
    localWindowConfig.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig.a());
    localWindowConfig.c((int)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig.a());
    float f = 2;
    localWindowConfig.c(f);
    localWindowConfig.b(f);
    localWindowConfig.b(10);
    localWindowConfig.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig.a() / f);
    localWindowConfig.d((int)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig.b() / 2);
    localWindowConfig.b(true);
    localWindowConfig.d(true);
    localWindowConfig.g(0.0F);
    localWindowConfig.f(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJDanmakuUIConfigCreator.a(paramRIJDanmakuConfig);
  }
  
  private final void b(RIJBaseDanmaku paramRIJBaseDanmaku)
  {
    paramRIJBaseDanmaku.d();
    paramRIJBaseDanmaku.f(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a((BaseDanmaku)paramRIJBaseDanmaku);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.e()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.q();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private final void c(RIJBaseDanmaku paramRIJBaseDanmaku)
  {
    paramRIJBaseDanmaku.c();
    paramRIJBaseDanmaku.f(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a((BaseDanmaku)paramRIJBaseDanmaku);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.e()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.q();
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig.d() * 1000L);
    DanmakuEventCallback localDanmakuEventCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuEventCallback;
    if (localDanmakuEventCallback != null)
    {
      paramRIJBaseDanmaku = (DanmakuDetail)paramRIJBaseDanmaku.a();
      Intrinsics.checkExpressionValueIsNotNull(paramRIJBaseDanmaku, "danmaku.data");
      localDanmakuEventCallback.onDanmakuClicked(paramRIJBaseDanmaku);
    }
  }
  
  private final void j()
  {
    Object localObject = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen((int[])localObject);
    int i = localObject[0];
    int j = localObject[1] - this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i, j, this.jdField_a_of_type_AndroidViewView.getWidth() + i, this.jdField_b_of_type_Int + j);
    this.jdField_b_of_type_AndroidViewView.bringToFront();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("calculateTouchRect: touchRect=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsRect);
      QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @Nullable
  public final RIJBaseDanmaku a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJDanmakuManager", 2, "hide: ", localThrowable);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSpeedRatio: ");
      localStringBuilder.append(paramFloat);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    if (paramFloat > 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seekTo: ");
      localStringBuilder.append(paramInt);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDanamkuTouchArea: marginTop=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", videoHeight=");
      localStringBuilder.append(paramInt2);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("attachContainer: ");
      ((StringBuilder)localObject).append(paramViewGroup);
      QLog.d("RIJDanmakuManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((Intrinsics.areEqual(paramViewGroup, this.jdField_a_of_type_AndroidViewView.getParent()) ^ true))
    {
      ViewParent localViewParent = this.jdField_a_of_type_AndroidViewView.getParent();
      localObject = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject = null;
      }
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
    }
    paramViewGroup.post((Runnable)new RIJDanmakuManager.attachContainer.1(this, paramViewGroup));
  }
  
  public void a(@Nullable BaseDanmaku<?, ?> paramBaseDanmaku, @NotNull TouchPoint paramTouchPoint, @Nullable ClickResult paramClickResult)
  {
    Intrinsics.checkParameterIsNotNull(paramTouchPoint, "touchPoint");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClickEvent: danmaku=");
      localStringBuilder.append(paramBaseDanmaku);
      localStringBuilder.append(", TouchPoint=");
      localStringBuilder.append(paramTouchPoint);
      localStringBuilder.append(", clickResult=");
      localStringBuilder.append(paramClickResult);
      localStringBuilder.append(", clickEnable=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    j();
    if (!(paramBaseDanmaku instanceof RIJBaseDanmaku)) {
      paramClickResult = null;
    } else {
      paramClickResult = paramBaseDanmaku;
    }
    if ((RIJBaseDanmaku)paramClickResult != null) {
      if (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku, paramBaseDanmaku))
      {
        paramClickResult = (RIJBaseDanmaku)paramBaseDanmaku;
        if (paramClickResult.a(paramTouchPoint))
        {
          a(paramClickResult);
          paramClickResult.f(false);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a(paramBaseDanmaku);
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.e()) {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.q();
          }
        }
      }
      else
      {
        paramTouchPoint = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku;
        if (paramTouchPoint != null) {
          b(paramTouchPoint);
        }
        paramBaseDanmaku = (RIJBaseDanmaku)paramBaseDanmaku;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku = paramBaseDanmaku;
        c(paramBaseDanmaku);
      }
    }
  }
  
  public void a(@NotNull DanmakuDetail paramDanmakuDetail)
  {
    Intrinsics.checkParameterIsNotNull(paramDanmakuDetail, "data");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addDanmakuNow: ");
      localStringBuilder.append(paramDanmakuDetail);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    int i = a(paramDanmakuDetail);
    paramDanmakuDetail = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a(i, paramDanmakuDetail);
    Intrinsics.checkExpressionValueIsNotNull(paramDanmakuDetail, "baseDanmaku");
    paramDanmakuDetail.e(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.b(paramDanmakuDetail);
  }
  
  public void a(@Nullable IPlayer paramIPlayer)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuIPlayer = paramIPlayer;
  }
  
  public void a(@NotNull RIJDanmakuConfig paramRIJDanmakuConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDanmakuConfig, "newConfig");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeConfig: config=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig);
      localStringBuilder.append(", newConfig=");
      localStringBuilder.append(paramRIJDanmakuConfig);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    if ((Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig, paramRIJDanmakuConfig) ^ true))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRIJDanmakuConfig = paramRIJDanmakuConfig;
      b(paramRIJDanmakuConfig);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.h();
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("setCurrentAuthorUin: ");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("RIJDanmakuManager", 2, paramString.toString());
    }
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start: rowkey=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", position=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(' ');
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a(paramInt * 1000);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel.a(paramString, paramInt);
  }
  
  public void a(@NotNull List<DanmakuDetail> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DanmakuDetail localDanmakuDetail = (DanmakuDetail)paramList.next();
      int i = a(localDanmakuDetail);
      BaseDanmaku localBaseDanmaku = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a(i, localDanmakuDetail);
      Intrinsics.checkExpressionValueIsNotNull(localBaseDanmaku, "baseDanmaku");
      localBaseDanmaku.b(localDanmakuDetail.a().a() * 1000);
      localArrayList.add(localBaseDanmaku);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a((List)localArrayList);
  }
  
  public void a(@NotNull List<DanmakuDetail> paramList, @NotNull ArrayList<ReportInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "reportInfoList");
    if (paramBoolean2) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.o();
    }
    a(paramList);
    paramList = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuEventCallback;
    if (paramList != null) {
      paramList.onGetDanmakuData(paramBoolean1, paramArrayList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDanmakuClicked: onDanmaku=");
      localStringBuilder.append(paramBoolean);
      QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJDanmakuManager", 2, "show: ", localThrowable);
      }
    }
  }
  
  public void b(@Nullable List<BaseDanmaku<Object, IDanmakuUIConfig>> paramList) {}
  
  public void b(boolean paramBoolean)
  {
    WindowConfig localWindowConfig = DanmakuContext.a();
    Intrinsics.checkExpressionValueIsNotNull(localWindowConfig, "DanmakuContext.getWindowConfig()");
    localWindowConfig.d(paramBoolean);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJDanmakuManager", 2, "pause: ");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.c();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJDanmakuManager", 2, "restart: ");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.b();
  }
  
  public void e()
  {
    h();
  }
  
  public void f() {}
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJDanmakuManager", 2, "destroy: ");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.g();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel.a();
    ViewParent localViewParent = this.jdField_a_of_type_AndroidViewView.getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
    }
    localViewParent = this.jdField_b_of_type_AndroidViewView.getParent();
    localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.d();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.e();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJDanmakuManager", 2, "cancelClick: ");
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  public boolean onTouch(@Nullable View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    if ((this.jdField_b_of_type_Boolean) && (paramMotionEvent.getAction() == 0))
    {
      paramView = this.jdField_a_of_type_AndroidGraphicsRect;
      if ((paramView == null) || (paramView.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
      {
        paramView = new int[2];
        this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramView);
        boolean bool3 = a(paramMotionEvent, paramView);
        boolean bool2 = true;
        boolean bool1 = true;
        if (bool3)
        {
          float f1 = paramMotionEvent.getRawX();
          float f2 = paramView[0];
          float f3 = paramMotionEvent.getRawY();
          float f4 = paramView[1];
          paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a();
          Intrinsics.checkExpressionValueIsNotNull(paramView, "danmakuManager.drawTimer");
          paramView = new TouchPoint(paramView.a(), new Point((int)(f1 - f2), (int)(f3 - f4)), 0);
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuExtDanmakuManagerExt.a(paramView);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onTouch: clickDanmakuView, candidateDanmaku=");
            localStringBuilder.append(paramMotionEvent);
            localStringBuilder.append(", clickedDanamku=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku);
            QLog.d("RIJDanmakuManager", 2, localStringBuilder.toString());
          }
          if (paramMotionEvent != null)
          {
            a(paramMotionEvent, paramView, null);
            return true;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku == null) {
            bool1 = false;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku;
          bool2 = bool1;
          if (paramView != null)
          {
            b(paramView);
            this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku = ((RIJBaseDanmaku)null);
            return bool1;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("onTouch: clickVideoArea, clickedDanmaku=");
            paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku);
            QLog.d("RIJDanmakuManager", 2, paramView.toString());
          }
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku != null) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku;
          bool2 = bool1;
          if (paramView != null)
          {
            b(paramView);
            this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku = ((RIJBaseDanmaku)null);
            bool2 = bool1;
          }
        }
        return bool2;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuManager
 * JD-Core Version:    0.7.0.1
 */