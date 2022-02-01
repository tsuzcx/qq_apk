package com.tencent.mobileqq.kandian.glue.viola.components;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.danmaku.QQDanmakuManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuEventCallback;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuInfo;
import com.tencent.mobileqq.kandian.biz.video.danmaku.IPlayer;
import com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuConfig;
import com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuManager;
import com.tencent.mobileqq.kandian.biz.video.danmaku.ReportInfo;
import com.tencent.mobileqq.kandian.biz.video.danmaku.UserInfo;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaChannelVisibilityChangedEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VDiv;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.VFrameLayout;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/components/VideoDanmakuComponent;", "Lcom/tencent/viola/ui/component/VDiv;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuEventCallback;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/IPlayer;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/kandian/glue/viola/event/ViolaChannelVisibilityChangedEvent;", "instance", "Lcom/tencent/viola/core/ViolaInstance;", "dom", "Lcom/tencent/viola/ui/dom/DomObject;", "parent", "Lcom/tencent/viola/ui/baseComponent/VComponentContainer;", "(Lcom/tencent/viola/core/ViolaInstance;Lcom/tencent/viola/ui/dom/DomObject;Lcom/tencent/viola/ui/baseComponent/VComponentContainer;)V", "barrageLayoutHorizontal", "", "barrageMarginTop", "", "barrageVideoHeight", "currentTime", "", "danmakuManager", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuManager;", "duration", "hasDanmakuDestroy", "rate", "reportList", "", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ReportInfo;", "addDanmaku", "", "param", "Lorg/json/JSONObject;", "changeParent", "ref", "", "destroy", "destroyDanmakuIfNeed", "doReport", "action", "data", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "getCurrentPosition", "", "getDuration", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getReportInfos", "Lorg/json/JSONArray;", "getSrcAttr", "key", "hide", "initComponentHostView", "Lcom/tencent/viola/ui/view/VFrameLayout;", "context", "Landroid/content/Context;", "isReuse", "onActivityDestroy", "onClickReport", "danmakuDetail", "onDanmakuClicked", "onDanmakuExposure", "onGetDanmakuData", "sendDanmakuForbid", "reportInfoList", "onReceiveEvent", "event", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "parseDanmakuConfig", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;", "pause", "recoveryArea", "removedByDiff", "removedByJs", "resume", "seekTo", "position", "setDisableSync", "forceVsync", "(Ljava/lang/Boolean;)V", "setProperty", "", "setUseUiTime", "useUiTime", "setVideoBarrageConfig", "json", "show", "start", "stop", "updateAttrs", "attrs", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoDanmakuComponent
  extends VDiv
  implements SimpleEventReceiver<ViolaChannelVisibilityChangedEvent>, DanmakuEventCallback, IPlayer
{
  public static final VideoDanmakuComponent.Companion Companion = new VideoDanmakuComponent.Companion(null);
  @NotNull
  public static final String EVENT_INFORM = "onInform";
  @NotNull
  public static final String EVENT_SEND_DANMAKU_FORBID = "sendDanmakuForbid";
  @NotNull
  public static final String KEY_DANMAKU_INFO = "danmakuInfo";
  @NotNull
  public static final String KEY_DANMAKU_INFO_CONTENT = "content";
  @NotNull
  public static final String KEY_DANMAKU_INFO_ID = "id";
  @NotNull
  public static final String KEY_DANMAKU_INFO_ROWKEY = "rowkey";
  @NotNull
  public static final String KEY_DANMAKU_INFO_TIME = "time";
  @NotNull
  public static final String KEY_DANMAKU_INFO_TYPE = "type";
  @NotNull
  public static final String KEY_INFO_SOURCE = "source";
  @NotNull
  public static final String KEY_REPORT_INFO = "reportInfos";
  @NotNull
  public static final String KEY_USER_INFO = "userInfo";
  @NotNull
  public static final String KEY_USER_INFO_AVATAR = "avatar";
  @NotNull
  public static final String KEY_USER_INFO_NICK_NAME = "nickName";
  @NotNull
  public static final String KEY_USER_INFO_UIN = "uin";
  @NotNull
  public static final String VIDEO_DANMAKU_CURRENT_TIME = "currentTime";
  @NotNull
  public static final String VIDEO_DANMAKU_DURATION = "duration";
  @NotNull
  public static final String VIDEO_LAYOUT_HORIZONTAL = "layoutHorizontal";
  private boolean barrageLayoutHorizontal;
  private float barrageMarginTop;
  private float barrageVideoHeight;
  private int currentTime;
  private RIJDanmakuManager danmakuManager;
  private int duration;
  private boolean hasDanmakuDestroy;
  private float rate = 1.0F;
  private List<ReportInfo> reportList;
  
  public VideoDanmakuComponent(@NotNull ViolaInstance paramViolaInstance, @NotNull DomObject paramDomObject, @NotNull VComponentContainer<?> paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private final void destroyDanmakuIfNeed()
  {
    if (!this.hasDanmakuDestroy)
    {
      this.hasDanmakuDestroy = true;
      RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
      if (localRIJDanmakuManager != null) {
        localRIJDanmakuManager.j();
      }
      this.danmakuManager = ((RIJDanmakuManager)null);
      SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver)this);
    }
  }
  
  private final void doReport(String paramString, DanmakuDetail paramDanmakuDetail)
  {
    long l = System.currentTimeMillis();
    String str = paramDanmakuDetail.a().f();
    if (str != null)
    {
      int i;
      if (((CharSequence)str).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 1)
      {
        str = paramDanmakuDetail.a().f();
        break label64;
      }
    }
    str = getSrcAttr("rowkey");
    label64:
    ThreadManager.excute((Runnable)new VideoDanmakuComponent.doReport.1(this, str, l, paramDanmakuDetail, paramString), 16, null, true);
  }
  
  private final JSONArray getReportInfos()
  {
    JSONArray localJSONArray = new JSONArray();
    Object localObject = this.reportList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ReportInfo localReportInfo = (ReportInfo)((Iterator)localObject).next();
        localJSONArray.put(new JSONObject().put("type", localReportInfo.a()).put("text", localReportInfo.b()));
      }
    }
    return localJSONArray;
  }
  
  private final String getSrcAttr(String paramString)
  {
    Object localObject1 = getDomObject();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "domObject");
    Object localObject2 = ((DomObject)localObject1).getAttributes().get("src");
    localObject1 = localObject2;
    if (!(localObject2 instanceof JSONObject)) {
      localObject1 = null;
    }
    localObject1 = (JSONObject)localObject1;
    if (localObject1 != null)
    {
      paramString = ViolaUtils.getString(((JSONObject)localObject1).get(paramString), "");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "ViolaUtils.getString(it[key], \"\")");
      return paramString;
    }
    return "";
  }
  
  private final RIJDanmakuConfig parseDanmakuConfig()
  {
    Object localObject1 = this.mDomObj;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mDomObj");
    Object localObject2 = ((DomObject)localObject1).getAttributes().get("videoBarrageConfig");
    localObject1 = localObject2;
    if (!(localObject2 instanceof JSONObject)) {
      localObject1 = null;
    }
    localObject1 = (JSONObject)localObject1;
    if (localObject1 != null)
    {
      if (((JSONObject)localObject1).length() == 0) {
        return new RIJDanmakuConfig(0, 0.0F, 0.0F, 0L, 0, 0, 0, 0.0F, 0, 0, 0L, 0L, 4095, null);
      }
      int i = ViolaUtils.getInt(((JSONObject)localObject1).opt("lineCount"));
      float f1 = ViolaUtils.getFloat(((JSONObject)localObject1).opt("lineSpace"));
      float f2 = ViolaUtils.getFloat(((JSONObject)localObject1).opt("columnSpace"));
      long l = ViolaUtils.getLong(((JSONObject)localObject1).opt("slideDuration"));
      return new RIJDanmakuConfig(i, f1, f2, 1000 * l, ViolaUtils.getInt(((JSONObject)localObject1).opt("maxWordCount")), ViolaUtils.getColor(ViolaUtils.getString(((JSONObject)localObject1).opt("textColor"), "")), ViolaUtils.getColor(ViolaUtils.getString(((JSONObject)localObject1).opt("textStrokeColor"), "")), ViolaUtils.getFloat(((JSONObject)localObject1).opt("textFontSize")), ViolaUtils.getInt(((JSONObject)localObject1).opt("clickDuration"), 6), ViolaUtils.getInt(((JSONObject)localObject1).opt("numShowLike"), -1), (ViolaUtils.getFloat(((JSONObject)localObject1).opt("guideDuration"), Float.valueOf(1.0F)) * (float)1000L), (ViolaUtils.getFloat(((JSONObject)localObject1).opt("danmakuDelayTime"), Float.valueOf(0.5F)) * 1000));
    }
    return new RIJDanmakuConfig(0, 0.0F, 0.0F, 0L, 0, 0, 0, 0.0F, 0, 0, 0L, 0L, 4095, null);
  }
  
  @JSMethod
  public final void addDanmaku(@Nullable JSONObject paramJSONObject)
  {
    Object localObject2 = (DanmakuInfo)null;
    Object localObject1 = localObject2;
    int i;
    if (paramJSONObject != null)
    {
      localObject3 = paramJSONObject.optJSONObject("danmakuInfo");
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = ViolaUtils.getString(((JSONObject)localObject3).opt("id"), "");
        i = ViolaUtils.getInt(((JSONObject)localObject3).opt("type"));
        int j = ViolaUtils.getInt(((JSONObject)localObject3).opt("source"));
        localObject2 = ViolaUtils.getString(((JSONObject)localObject3).opt("content"), "");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "ViolaUtils.getString(it.…ANMAKU_INFO_CONTENT), \"\")");
        int k = ViolaUtils.getInt(((JSONObject)localObject3).opt("time"));
        localObject3 = ViolaUtils.getString(((JSONObject)localObject3).opt("rowkey"), "");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "id");
        localObject1 = new DanmakuInfo((String)localObject1, i, j, (String)localObject2, k, (String)localObject3);
      }
    }
    Object localObject3 = (UserInfo)null;
    localObject2 = localObject3;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("userInfo");
      localObject2 = localObject3;
      if (paramJSONObject != null)
      {
        localObject2 = ViolaUtils.getString(paramJSONObject.opt("uin"), "");
        i = ViolaUtils.getInt(paramJSONObject.opt("source"));
        localObject3 = ViolaUtils.getString(paramJSONObject.opt("nickName"), "");
        paramJSONObject = ViolaUtils.getString(paramJSONObject.opt("avatar"), "");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "uin");
        localObject2 = new UserInfo((String)localObject2, i, (String)localObject3, paramJSONObject);
      }
    }
    if ((localObject1 != null) && (localObject2 != null))
    {
      paramJSONObject = this.danmakuManager;
      if (paramJSONObject != null)
      {
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        paramJSONObject.a(new DanmakuDetail((DanmakuInfo)localObject1, (UserInfo)localObject2));
      }
    }
  }
  
  @JSMethod
  public final void changeParent(@Nullable String paramString)
  {
    if (paramString != null)
    {
      int i;
      if (((CharSequence)paramString).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 1)
      {
        Object localObject = getInstance();
        if (localObject != null)
        {
          ViolaSDKManager localViolaSDKManager = ViolaSDKManager.getInstance();
          Intrinsics.checkExpressionValueIsNotNull(localViolaSDKManager, "ViolaSDKManager.getInstance()");
          paramString = localViolaSDKManager.getDomManager().getDomContext(((ViolaInstance)localObject).getInstanceId()).getComponent(paramString);
          if (paramString != null) {
            paramString = paramString.getHostView();
          } else {
            paramString = null;
          }
          localObject = paramString;
          if (!(paramString instanceof ViewGroup)) {
            localObject = null;
          }
          paramString = (ViewGroup)localObject;
          if (paramString != null)
          {
            localObject = this.danmakuManager;
            if (localObject != null) {
              ((RIJDanmakuManager)localObject).a(paramString);
            }
          }
        }
      }
    }
  }
  
  public void destroy()
  {
    super.destroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroy: ");
      localStringBuilder.append(hashCode());
      QLog.d("VDiv", 2, localStringBuilder.toString());
    }
    destroyDanmakuIfNeed();
  }
  
  public long getCurrentPosition()
  {
    return this.currentTime * 1000;
  }
  
  public long getDuration()
  {
    return this.duration * 1000;
  }
  
  @NotNull
  public ArrayList<Class<ViolaChannelVisibilityChangedEvent>> getEventClass()
  {
    return CollectionsKt.arrayListOf(new Class[] { ViolaChannelVisibilityChangedEvent.class });
  }
  
  @JSMethod
  public final void hide()
  {
    RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
    if (localRIJDanmakuManager != null) {
      localRIJDanmakuManager.d();
    }
  }
  
  @NotNull
  protected VFrameLayout initComponentHostView(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    QQDanmakuManager.a();
    Object localObject = getDomObject();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "domObject");
    boolean bool = ViolaUtils.getBoolean(((DomObject)localObject).getAttributes().get("useTextureView"));
    localObject = ReadInJoyUtils.b();
    if (localObject != null)
    {
      this.danmakuManager = new RIJDanmakuManager(paramContext, (QQAppInterface)localObject, bool, parseDanmakuConfig(), (DanmakuEventCallback)this);
      localObject = this.danmakuManager;
      if (localObject != null) {
        ((RIJDanmakuManager)localObject).a((IPlayer)this);
      }
      localObject = this.danmakuManager;
      if (localObject != null) {
        ((RIJDanmakuManager)localObject).a(getSrcAttr("puin"));
      }
      paramContext = new ViolaDanmakuView(paramContext);
      paramContext.bindComponent((VDiv)this);
      localObject = this.danmakuManager;
      if (localObject != null) {
        ((RIJDanmakuManager)localObject).a((ViewGroup)paramContext);
      }
      SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this);
      return (VFrameLayout)paramContext;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public boolean isReuse()
  {
    return false;
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    destroyDanmakuIfNeed();
  }
  
  public void onClickReport(@NotNull DanmakuDetail paramDanmakuDetail)
  {
    Intrinsics.checkParameterIsNotNull(paramDanmakuDetail, "danmakuDetail");
    JSONObject localJSONObject = new JSONObject().put("id", paramDanmakuDetail.a().a()).put("type", paramDanmakuDetail.a().b()).put("source", paramDanmakuDetail.a().c()).put("content", paramDanmakuDetail.a().d()).put("time", paramDanmakuDetail.a().e()).put("rowkey", paramDanmakuDetail.a().f());
    paramDanmakuDetail = new JSONObject().put("uin", paramDanmakuDetail.b().a()).put("source", paramDanmakuDetail.b().b()).put("nickName", paramDanmakuDetail.b().c()).put("avatar", paramDanmakuDetail.b().d());
    fireEvent("onInform", new JSONObject().put("danmakuInfo", localJSONObject).put("userInfo", paramDanmakuDetail).put("reportInfos", getReportInfos()));
  }
  
  public void onDanmakuClicked(@NotNull DanmakuDetail paramDanmakuDetail)
  {
    Intrinsics.checkParameterIsNotNull(paramDanmakuDetail, "data");
    doReport("0X800BBCC", paramDanmakuDetail);
  }
  
  public void onDanmakuExposure(@NotNull DanmakuDetail paramDanmakuDetail)
  {
    Intrinsics.checkParameterIsNotNull(paramDanmakuDetail, "data");
    RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
    if ((localRIJDanmakuManager != null) && (localRIJDanmakuManager.f() == true))
    {
      if (Intrinsics.areEqual(paramDanmakuDetail.a().a(), "danmukaipin"))
      {
        doReport("0X800BE1C", paramDanmakuDetail);
        return;
      }
      doReport("0X800BABE", paramDanmakuDetail);
    }
  }
  
  public void onGetDanmakuData(boolean paramBoolean, @NotNull ArrayList<ReportInfo> paramArrayList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ViolaChannelVisibilityChangedEvent))
    {
      paramSimpleBaseEvent = (ViolaChannelVisibilityChangedEvent)paramSimpleBaseEvent;
      String str = paramSimpleBaseEvent.getViolaInstanceId();
      ViolaInstance localViolaInstance = getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localViolaInstance, "instance");
      if (Intrinsics.areEqual(str, localViolaInstance.getInstanceId())) {
        if (paramSimpleBaseEvent.getVisiable())
        {
          paramSimpleBaseEvent = this.danmakuManager;
          if (paramSimpleBaseEvent != null) {
            paramSimpleBaseEvent.e();
          }
        }
        else
        {
          paramSimpleBaseEvent = this.danmakuManager;
          if (paramSimpleBaseEvent != null) {
            paramSimpleBaseEvent.d();
          }
        }
      }
    }
  }
  
  @JSMethod
  public final void pause()
  {
    RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
    if (localRIJDanmakuManager != null) {
      localRIJDanmakuManager.g();
    }
  }
  
  @JSMethod
  public final void recoveryArea()
  {
    RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
    if (localRIJDanmakuManager != null) {
      localRIJDanmakuManager.l();
    }
  }
  
  public void removedByDiff()
  {
    super.removedByDiff();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removedByDiff: ");
      localStringBuilder.append(hashCode());
      QLog.d("VDiv", 2, localStringBuilder.toString());
    }
    destroyDanmakuIfNeed();
  }
  
  public void removedByJs()
  {
    super.removedByJs();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removedByJs: ");
      localStringBuilder.append(hashCode());
      QLog.d("VDiv", 2, localStringBuilder.toString());
    }
    destroyDanmakuIfNeed();
  }
  
  @JSMethod
  public final void resume()
  {
    RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
    if (localRIJDanmakuManager != null) {
      localRIJDanmakuManager.h();
    }
  }
  
  @JSMethod
  public final void seekTo(int paramInt)
  {
    RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
    if (localRIJDanmakuManager != null) {
      localRIJDanmakuManager.a(paramInt);
    }
  }
  
  @VComponentProp(name="disableSync")
  public final void setDisableSync(@Nullable Boolean paramBoolean)
  {
    RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
    if (localRIJDanmakuManager != null) {
      localRIJDanmakuManager.b(paramBoolean);
    }
  }
  
  public boolean setProperty(@Nullable String paramString, @Nullable Object paramObject)
  {
    if (paramString != null) {
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 665450222: 
        if (paramString.equals("layoutHorizontal"))
        {
          boolean bool = ViolaUtils.getBoolean(paramObject);
          if (bool != this.barrageLayoutHorizontal)
          {
            this.barrageLayoutHorizontal = bool;
            paramString = this.danmakuManager;
            if (paramString != null) {
              paramString.b(this.barrageLayoutHorizontal ^ true);
            }
          }
          return true;
        }
        break;
      case 601235430: 
        if (paramString.equals("currentTime"))
        {
          this.currentTime = ViolaUtils.getInt(paramObject);
          return true;
        }
        break;
      case 3493088: 
        if (paramString.equals("rate"))
        {
          float f = ViolaUtils.getFloat(paramObject);
          if (f == this.rate) {
            return true;
          }
          this.rate = f;
          paramString = this.danmakuManager;
          if (paramString != null) {
            paramString.a(this.rate);
          }
          return true;
        }
        break;
      case -1992012396: 
        if (paramString.equals("duration"))
        {
          this.duration = ViolaUtils.getInt(paramObject);
          return true;
        }
        break;
      }
    }
    return super.setProperty(paramString, paramObject);
  }
  
  @VComponentProp(name="useUiTime")
  public final void setUseUiTime(@Nullable Boolean paramBoolean)
  {
    RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
    if (localRIJDanmakuManager != null) {
      localRIJDanmakuManager.a(paramBoolean);
    }
  }
  
  @VComponentProp(name="videoBarrageConfig")
  public final void setVideoBarrageConfig(@Nullable JSONObject paramJSONObject)
  {
    Object localObject = this.danmakuManager;
    if (localObject != null) {
      ((RIJDanmakuManager)localObject).a(parseDanmakuConfig());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setVideoBarrageConfig: json=");
      ((StringBuilder)localObject).append(String.valueOf(paramJSONObject));
      QLog.d("VDiv", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @JSMethod
  public final void show()
  {
    RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
    if (localRIJDanmakuManager != null) {
      localRIJDanmakuManager.e();
    }
  }
  
  @JSMethod
  public final void start(@Nullable JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.currentTime = ViolaUtils.getInt(paramJSONObject.opt("currentTime"));
      this.duration = ViolaUtils.getInt(paramJSONObject.opt("duration"));
    }
    paramJSONObject = this.danmakuManager;
    if (paramJSONObject != null) {
      paramJSONObject.a(getSrcAttr("rowkey"), this.currentTime);
    }
  }
  
  @JSMethod
  public final void stop()
  {
    RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
    if (localRIJDanmakuManager != null) {
      localRIJDanmakuManager.i();
    }
  }
  
  public void updateAttrs(@Nullable Map<String, Object> paramMap)
  {
    if ((paramMap != null) && ((paramMap.get("barrageMarginTop") != null) || (paramMap.get("barrageVideoHeight") != null)))
    {
      float f1 = FlexConvertUtils.getFloatByViewport(paramMap.get("barrageMarginTop"), 750);
      float f2 = FlexConvertUtils.getFloatByViewport(paramMap.get("barrageVideoHeight"), 750);
      if ((this.barrageMarginTop != f1) || (this.barrageVideoHeight != f2))
      {
        this.barrageMarginTop = f1;
        this.barrageVideoHeight = f2;
        RIJDanmakuManager localRIJDanmakuManager = this.danmakuManager;
        if (localRIJDanmakuManager != null) {
          localRIJDanmakuManager.a((int)f1, (int)f2);
        }
      }
    }
    super.updateAttrs(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.components.VideoDanmakuComponent
 * JD-Core Version:    0.7.0.1
 */