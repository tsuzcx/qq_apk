package com.tencent.xaction.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.IMemoryLruCache;
import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.api.ITimeline;
import com.tencent.xaction.api.ITrigger;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.BaseRule;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.api.base.DecorDrawable.Companion;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.AnimData;
import com.tencent.xaction.api.data.Component;
import com.tencent.xaction.api.data.Component.Companion;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.style.Style;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.api.util.GsonAdapter;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.log.QLog;
import com.tencent.xaction.manager.RuleManager;
import com.tencent.xaction.manager.ViewManager;
import com.tencent.xaction.manager.ViewManager.Companion;
import com.tencent.xaction.openapi.api.IDownload;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.rule.ScreenRule;
import com.tencent.xaction.trigger.BaseTrigger;
import com.tencent.xaction.view.XAEmptyView;
import com.tencent.xaction.view.XATextView;
import com.tencent.xaction.view.XAView;
import com.tencent.xaction.view.XAViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/XAEngine;", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "VERSION_CODE", "", "getVERSION_CODE", "()I", "animData", "Lcom/tencent/xaction/api/data/AnimData;", "animTimeline", "Lcom/tencent/xaction/impl/XATimeline;", "componentList", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/data/Component;", "Lkotlin/collections/ArrayList;", "drawableList", "Lcom/tencent/xaction/api/IDrawable;", "isAddRelativeLayout", "", "notifyMap", "Ljava/util/HashMap;", "", "Lcom/tencent/xaction/api/ITrigger;", "Lkotlin/collections/HashMap;", "ruleManager", "Lcom/tencent/xaction/api/IRuleManager;", "tag", "timelineCount", "getTimelineCount", "setTimelineCount", "(I)V", "timelineList", "viewDataList", "Lcom/tencent/xaction/api/data/ViewData;", "viewLayout", "Landroid/view/ViewGroup;", "viewList", "Lcom/tencent/xaction/api/IView;", "clearGlobalView", "", "compareVersion", "createComponent", "style", "createTimeLine", "createView", "viewData", "destroy", "doDestroy", "doStart", "finalize", "findById", "id", "findByTag", "singleTag", "findComponentById", "Lcom/tencent/xaction/api/IDecorView;", "findDrawableById", "getAbsPath", "path", "root", "getContext", "getLayout", "getRuleManager", "init", "data", "eles", "initAsync", "callback", "Lkotlin/Function0;", "initFromFile", "filePath", "initFromFileAsync", "initFromUrlAsync", "url", "initRoot", "rootPath", "initRootAsync", "initZipAsync", "zipFilePath", "isPagInit", "linkDrawable", "logd", "level", "msg", "loge", "tr", "", "logi", "notifyMonitor", "rule", "value", "", "parseJson", "postMainThread", "runnable", "Ljava/lang/Runnable;", "preInit", "removeSelfView", "view", "Landroid/view/View;", "removeViewWhenDestroy", "setCache", "cache", "Lcom/tencent/xaction/api/IMemoryLruCache;", "setContentLayout", "framelayout", "setProxy", "isStyle", "setProxyMore", "setTag", "setViewDrawable", "it", "start", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class XAEngine
  implements IXAEngine
{
  public static final XAEngine.Companion Companion = new XAEngine.Companion(null);
  private static final String TAG = "XAEngine";
  private static long availClassSize;
  private static IMemoryLruCache cache;
  @NotNull
  private static final ExecutorService threadPoolExecutor;
  @NotNull
  private static Handler uiHandler = new Handler(Looper.getMainLooper());
  @NotNull
  private static ViewManager viewManager = new ViewManager();
  private final int VERSION_CODE = 2;
  private AnimData animData;
  private final XATimeline animTimeline;
  private final ArrayList<Component> componentList;
  private Context context;
  private final ArrayList<IDrawable> drawableList;
  private boolean isAddRelativeLayout;
  private HashMap<String, ArrayList<ITrigger>> notifyMap;
  private IRuleManager ruleManager;
  private String tag;
  private int timelineCount;
  private final ArrayList<XATimeline> timelineList;
  private ArrayList<ViewData> viewDataList;
  private ViewGroup viewLayout;
  private final ArrayList<IView> viewList;
  
  static
  {
    ExecutorService localExecutorService = Executors.newFixedThreadPool(3);
    Intrinsics.checkExpressionValueIsNotNull(localExecutorService, "Executors.newFixedThreadPool(3)");
    threadPoolExecutor = localExecutorService;
  }
  
  public XAEngine(@NotNull Context paramContext)
  {
    this.context = paramContext;
    this.viewDataList = new ArrayList();
    this.viewList = new ArrayList();
    this.drawableList = new ArrayList();
    this.componentList = new ArrayList();
    this.notifyMap = new HashMap();
    this.ruleManager = ((IRuleManager)new RuleManager());
    this.timelineList = new ArrayList();
    this.animTimeline = createTimeLine();
    Object localObject = this.context;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((Context)localObject).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this.context!!.resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = this.context;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((Context)localObject).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this.context!!.resources");
      int j = ((Resources)localObject).getDisplayMetrics().heightPixels;
      ScreenUnit.a.a(i * 1.0F, j * 1.0F);
      this.ruleManager.registerRuleLine("$SCREEN_WIDTH", Float.valueOf(750.0F));
      this.ruleManager.registerRuleLine("$SCREEN_HEIGHT", Float.valueOf(ScreenUnit.a.a()));
      this.ruleManager.registerRuleLine("$SCREEN_WIDTH_HALF", Float.valueOf(375.0F));
      this.ruleManager.registerRuleLine("$SCREEN_HEIGHT_HALF", Float.valueOf(ScreenUnit.a.a() / 2));
    }
    localObject = viewManager;
    String str = XAView.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "XAView::class.java.name");
    ((ViewManager)localObject).a("view", str);
    localObject = viewManager;
    str = XAViewGroup.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "XAViewGroup::class.java.name");
    ((ViewManager)localObject).a("group", str);
    localObject = viewManager;
    str = XATextView.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "XATextView::class.java.name");
    ((ViewManager)localObject).a("text", str);
    localObject = viewManager;
    str = XAEmptyView.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "XAEmptyView::class.java.name");
    ((ViewManager)localObject).a("empty", str);
    viewManager.a("lottieview", "com.tencent.xaction.XALottieView");
    viewManager.a("pagview", "com.tencent.xaction.XAPagView");
    this.ruleManager.registerRule((BaseRule)new ScreenRule());
    if (availClassSize == 0L) {
      availClassSize = MemoryLruCacheImpl.a.a(paramContext);
    }
  }
  
  private final void clearGlobalView()
  {
    Iterator localIterator = ((Map)ViewManager.a.a()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      IView localIView = (IView)((Map.Entry)localIterator.next()).getValue();
      if ((localIView instanceof View)) {
        removeSelfView((View)localIView);
      }
      localIView.getDecor().destroy();
    }
  }
  
  private final boolean compareVersion()
  {
    AnimData localAnimData = this.animData;
    if (localAnimData == null) {
      Intrinsics.throwNpe();
    }
    if (localAnimData.getVersionMin() < this.VERSION_CODE)
    {
      localAnimData = this.animData;
      if (localAnimData == null) {
        Intrinsics.throwNpe();
      }
      if (localAnimData.getVersionMax() >= this.VERSION_CODE) {
        return true;
      }
    }
    return false;
  }
  
  private final void createComponent(ViewData paramViewData)
  {
    Object localObject = paramViewData.getType();
    if (((String)localObject).hashCode() != -1399907075) {
      return;
    }
    if (((String)localObject).equals("component"))
    {
      localObject = this.context;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      paramViewData = new Component((Context)localObject, this, paramViewData);
      this.componentList.add(paramViewData);
    }
  }
  
  private final void createView(ViewData paramViewData)
  {
    if (!isPagInit(paramViewData)) {
      return;
    }
    Object localObject1 = viewManager;
    Object localObject2 = this.context;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((ViewManager)localObject1).a((Context)localObject2, paramViewData, this.viewLayout, this);
    if (localObject1 != null)
    {
      ((IView)localObject1).getDecor().setStyle(paramViewData);
      if (TextUtils.isEmpty((CharSequence)paramViewData.getSingleTag())) {
        this.viewList.add(localObject1);
      }
      return;
    }
    localObject1 = paramViewData.getType();
    int i = ((String)localObject1).hashCode();
    if (i != -826507106)
    {
      if (i != 0)
      {
        if (i != 94843717) {
          return;
        }
        if (((String)localObject1).equals("compt"))
        {
          localObject1 = this.viewLayout;
          if (localObject1 != null) {
            paramViewData = Component.Companion.a(this, paramViewData, (ViewGroup)localObject1);
          } else {
            paramViewData = null;
          }
          if (paramViewData != null)
          {
            localObject1 = this.viewList;
            if (paramViewData != null)
            {
              ((ArrayList)localObject1).add((IView)paramViewData);
              return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.IView");
          }
        }
      }
      else if (((String)localObject1).equals(""))
      {
        localObject1 = this.context;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = new XAEmptyView((Context)localObject1);
        ((XAEmptyView)localObject1).a().init((IXAEngine)this, this.viewLayout);
        ((XAEmptyView)localObject1).a().setStyle(paramViewData);
        this.viewList.add((IView)localObject1);
      }
    }
    else if ((((String)localObject1).equals("drawable")) && (paramViewData.getDrawable() != null))
    {
      localObject1 = paramViewData.getDrawable();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((DecorDrawableState)localObject1).buildDrawable();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("drawable:");
      ((StringBuilder)localObject2).append(localObject1.toString());
      ((StringBuilder)localObject2).append(" decor:");
      ((StringBuilder)localObject2).append(((IDrawable)localObject1).getDecor());
      logi("XAEngine", 1, ((StringBuilder)localObject2).toString());
      localObject2 = ((IDrawable)localObject1).getDecor();
      if (localObject2 != null)
      {
        localObject2 = (DecorDrawable)localObject2;
        ((DecorDrawable)localObject2).setStyle(paramViewData);
        ((DecorDrawable)localObject2).setId(paramViewData.getId());
        this.drawableList.add(localObject1);
        localObject1 = this.viewLayout;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((DecorDrawable)localObject2).init((View)localObject1, (IXAEngine)this);
        paramViewData = paramViewData.getTl();
        if (paramViewData != null) {
          paramViewData.a((ITimeline)localObject2);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
      }
    }
  }
  
  private final void doDestroy()
  {
    Object localObject = ((Iterable)this.timelineList).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((XATimeline)((Iterator)localObject).next()).d();
    }
    this.timelineList.clear();
    removeViewWhenDestroy();
    localObject = ((Iterable)this.viewDataList).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ViewData)((Iterator)localObject).next()).setDrawable((DecorDrawableState)null);
    }
    this.viewDataList.clear();
    this.drawableList.clear();
    this.viewList.clear();
    this.notifyMap.clear();
    this.context = ((Context)null);
    clearGlobalView();
    if (this.isAddRelativeLayout)
    {
      localObject = this.viewLayout;
      if (localObject != null)
      {
        this.isAddRelativeLayout = false;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        removeSelfView((View)localObject);
      }
    }
  }
  
  private final void doStart()
  {
    if (this.tag == null) {
      QLog.b("AnimEngine", 1, "AnimEngine Must set tag source", new Throwable(" Must set tag source, you can invoke engine.setTag()"));
    }
    Object localObject2 = ((Iterable)this.viewList).iterator();
    Object localObject1;
    for (;;)
    {
      boolean bool = ((Iterator)localObject2).hasNext();
      localIterator = null;
      if (!bool) {
        break;
      }
      IView localIView = (IView)((Iterator)localObject2).next();
      if (localIView.getDecor().getProxy() != null)
      {
        localObject1 = localIView.getDecor().getStyle();
        if (localObject1 != null)
        {
          localObject1 = ((ViewData)localObject1).getTp();
          if (localObject1 != null)
          {
            localObject1 = Boolean.valueOf(((TimeProp)localObject1).getAutoPlay());
            break label121;
          }
        }
        localObject1 = null;
        label121:
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        if (((Boolean)localObject1).booleanValue())
        {
          Object localObject3 = localIView.getDecor().getStyle();
          localObject1 = localIterator;
          if (localObject3 != null)
          {
            localObject3 = ((ViewData)localObject3).getAnim();
            localObject1 = localIterator;
            if (localObject3 != null) {
              localObject1 = Integer.valueOf(((ArrayList)localObject3).size());
            }
          }
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          if (((Integer)localObject1).intValue() > 0)
          {
            localObject1 = localIView.getDecor().getStyle();
            if (localObject1 != null)
            {
              localObject1 = ((ViewData)localObject1).getTl();
              if (localObject1 != null) {
                ((XATimeline)localObject1).a();
              }
            }
          }
        }
      }
    }
    Iterator localIterator = ((Iterable)this.drawableList).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = ((IDrawable)localIterator.next()).getDecor();
      if (localObject1 != null)
      {
        localObject2 = (DecorDrawable)localObject1;
        localObject1 = ((DecorDrawable)localObject2).getTl();
        if (localObject1 != null)
        {
          localObject1 = ((XATimeline)localObject1).a();
          if (localObject1 != null)
          {
            localObject1 = Boolean.valueOf(((TimeProp)localObject1).getAutoPlay());
            break label305;
          }
        }
        localObject1 = null;
        label305:
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        if ((((Boolean)localObject1).booleanValue()) && ((((DecorDrawable)localObject2).getDrawable() instanceof Drawable)))
        {
          localObject1 = ((DecorDrawable)localObject2).getDrawable();
          if (localObject1 != null)
          {
            if (((Drawable)localObject1).getCallback() != null)
            {
              localObject1 = ((DecorDrawable)localObject2).getTl();
              if (localObject1 != null) {
                ((XATimeline)localObject1).a();
              }
            }
          }
          else {
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Drawable");
          }
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
      }
    }
  }
  
  private final boolean isPagInit(ViewData paramViewData)
  {
    if (Intrinsics.areEqual(paramViewData.getType(), "pagview"))
    {
      paramViewData = this.ruleManager.getRuleValue("$IS_PAG_INIT");
      if ((paramViewData instanceof Boolean)) {
        return ((Boolean)paramViewData).booleanValue();
      }
    }
    return true;
  }
  
  private final void linkDrawable()
  {
    Iterator localIterator = ((Iterable)this.viewList).iterator();
    while (localIterator.hasNext()) {
      setViewDrawable((IView)localIterator.next());
    }
  }
  
  private final AnimData parseJson(String paramString)
  {
    logi("XAEngine", 2, "parseJson");
    try
    {
      paramString = (AnimData)GsonAdapter.a().fromJson(paramString, AnimData.class);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      loge("XAEngine", "parseJson OutOfMemoryError:", (Throwable)paramString);
    }
    catch (Exception paramString)
    {
      loge("XAEngine", "parseJson error:", (Throwable)paramString);
    }
    logi("XAEngine", 1, "parseJson error, return default AnimData");
    return new AnimData();
  }
  
  @JvmStatic
  public static final void pauseAll()
  {
    Companion.a();
  }
  
  private final void postMainThread(Runnable paramRunnable)
  {
    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))
    {
      paramRunnable.run();
      return;
    }
    uiHandler.post(paramRunnable);
  }
  
  private final void preInit(ViewData paramViewData)
  {
    Object localObject1 = paramViewData.getRules();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        this.ruleManager.refreshRuleValue(paramViewData, (String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
      }
    }
    localObject1 = ((Iterable)paramViewData.getTr()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseTrigger)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((BaseTrigger)localObject2).getMonitor() != null))
      {
        String[] arrayOfString = ((BaseTrigger)localObject2).getMonitor();
        if (arrayOfString == null) {
          Intrinsics.throwNpe();
        }
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = arrayOfString[i];
          if (this.notifyMap.get(localObject3) == null) {
            ((Map)this.notifyMap).put(localObject3, new ArrayList());
          }
          localObject3 = this.notifyMap.get(localObject3);
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          ((ArrayList)localObject3).add(localObject2);
          i += 1;
        }
      }
    }
    createComponent(paramViewData);
  }
  
  @JvmStatic
  public static final boolean registerAnim(@NotNull String paramString, @NotNull Class<BaseAnim> paramClass)
  {
    return Companion.a(paramString, paramClass);
  }
  
  @JvmStatic
  public static final boolean registerDrawable(@NotNull String paramString1, @NotNull String paramString2)
  {
    return Companion.a(paramString1, paramString2);
  }
  
  @JvmStatic
  public static final boolean registerTrigger(@NotNull String paramString, @NotNull Class<BaseTrigger> paramClass)
  {
    return Companion.b(paramString, paramClass);
  }
  
  private final boolean removeSelfView(View paramView)
  {
    if ((paramView.getParent() instanceof ViewGroup))
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null)
      {
        ((ViewGroup)localViewParent).removeView(paramView);
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    return false;
  }
  
  private final void removeViewWhenDestroy()
  {
    try
    {
      Iterator localIterator = ((Iterable)this.viewList).iterator();
      while (localIterator.hasNext())
      {
        IView localIView = (IView)localIterator.next();
        if (localIView != null)
        {
          Object localObject = localIView.getDecor();
          if (localObject != null)
          {
            localObject = ((IDecorView)localObject).getStyle();
            if ((localObject != null) && (((ViewData)localObject).getRwd() == true) && ((localIView instanceof View))) {
              removeSelfView((View)localIView);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      loge("XAEngine", "removeViewWhenDestroy error", (Throwable)localException);
    }
  }
  
  @JvmStatic
  public static final void resumeAll()
  {
    Companion.b();
  }
  
  private final void setViewDrawable(IView paramIView)
  {
    ViewData localViewData = paramIView.getDecor().getStyle();
    if (localViewData == null) {
      Intrinsics.throwNpe();
    }
    int i = localViewData.getSt().getDrawableId();
    if (i != 0)
    {
      if (paramIView.getDecor().getProxy() == null) {
        return;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramIView = DecorDrawable.Companion.a(this, i, paramIView, true);
        if (paramIView != null) {
          this.drawableList.add(paramIView);
        }
      }
    }
  }
  
  @NotNull
  public final XATimeline createTimeLine()
  {
    this.timelineCount += 1;
    XATimeline localXATimeline = new XATimeline(this.timelineCount);
    this.timelineList.add(localXATimeline);
    return localXATimeline;
  }
  
  public void destroy()
  {
    postMainThread((Runnable)new XAEngine.destroy.1(this));
  }
  
  public final void finalize()
  {
    destroy();
    logd("XAEngine", 1, "finalize");
  }
  
  @Nullable
  public IView findById(int paramInt)
  {
    Iterator localIterator = this.viewList.iterator();
    while (localIterator.hasNext())
    {
      IView localIView = (IView)localIterator.next();
      ViewData localViewData = localIView.getDecor().getStyle();
      int i;
      if (localViewData != null) {
        i = localViewData.getId();
      } else {
        i = ScreenUnit.a.a();
      }
      if (i == paramInt) {
        return localIView;
      }
    }
    return null;
  }
  
  @Nullable
  public final IView findByTag(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "singleTag");
    return (IView)ViewManager.a.a().get(paramString);
  }
  
  @Nullable
  public final IDecorView findComponentById(int paramInt)
  {
    Iterator localIterator = this.componentList.iterator();
    while (localIterator.hasNext())
    {
      Component localComponent = (Component)localIterator.next();
      if (localComponent.getComptId() == paramInt) {
        return (IDecorView)localComponent;
      }
    }
    return null;
  }
  
  @Nullable
  public IDrawable findDrawableById(int paramInt)
  {
    Iterator localIterator = this.drawableList.iterator();
    while (localIterator.hasNext())
    {
      IDrawable localIDrawable = (IDrawable)localIterator.next();
      IPublicDecorDrawable localIPublicDecorDrawable = localIDrawable.getDecor();
      if (localIPublicDecorDrawable != null)
      {
        if (((DecorDrawable)localIPublicDecorDrawable).getId() == paramInt) {
          return localIDrawable;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
      }
    }
    return null;
  }
  
  @Nullable
  public String getAbsPath(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    FileUtil.Companion localCompanion = FileUtil.a;
    Context localContext = this.context;
    if (localContext == null) {
      Intrinsics.throwNpe();
    }
    return localCompanion.a(localContext, paramString1, paramString2, (IXAEngine)this);
  }
  
  @Nullable
  public final Context getContext()
  {
    return this.context;
  }
  
  @Nullable
  public ViewGroup getLayout()
  {
    return this.viewLayout;
  }
  
  @NotNull
  public IRuleManager getRuleManager()
  {
    return this.ruleManager;
  }
  
  public final int getTimelineCount()
  {
    return this.timelineCount;
  }
  
  public final int getVERSION_CODE()
  {
    return this.VERSION_CODE;
  }
  
  @NotNull
  public XAEngine init(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    logd("XAEngine", 2, "init");
    this.animData = parseJson(paramString);
    if (!compareVersion())
    {
      paramString = new StringBuilder();
      paramString.append("init faild versionMin:");
      AnimData localAnimData = this.animData;
      if (localAnimData == null) {
        Intrinsics.throwNpe();
      }
      paramString.append(localAnimData.getVersionMin());
      paramString.append(" VERSION_CODE:");
      paramString.append(this.VERSION_CODE);
      logi("XAEngine", 1, paramString.toString());
      return this;
    }
    paramString = this.animData;
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    paramString = paramString.getEles();
    if (paramString != null) {
      init(paramString);
    }
    return this;
  }
  
  @NotNull
  public final XAEngine init(@NotNull ArrayList<ViewData> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "eles");
    this.viewDataList = paramArrayList;
    this.animTimeline.a(this.timelineCount);
    paramArrayList = ((Iterable)this.viewDataList).iterator();
    while (paramArrayList.hasNext()) {
      preInit((ViewData)paramArrayList.next());
    }
    paramArrayList = ((Iterable)this.componentList).iterator();
    while (paramArrayList.hasNext()) {
      ((Component)paramArrayList.next()).init();
    }
    paramArrayList = this.viewDataList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      ViewData localViewData = (ViewData)paramArrayList.next();
      i = Math.max(localViewData.getTp().getDuration(), i);
      if (!Intrinsics.areEqual(localViewData.getType(), "component"))
      {
        if ((localViewData.getTp().getRc() == 0) && (!localViewData.getTp().getSingle()))
        {
          localViewData.setTl(this.animTimeline);
        }
        else
        {
          XATimeline localXATimeline = createTimeLine();
          this.timelineCount += 1;
          localXATimeline.a(this.timelineCount);
          localXATimeline.a().set(localViewData.getTp());
          localViewData.setTl(localXATimeline);
        }
        Intrinsics.checkExpressionValueIsNotNull(localViewData, "style");
        createView(localViewData);
      }
    }
    linkDrawable();
    this.animTimeline.a().setDuration(i);
    return this;
  }
  
  @NotNull
  public XAEngine initAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    threadPoolExecutor.execute((Runnable)new XAEngine.initAsync.1(this, paramString, paramFunction0));
    return this;
  }
  
  @NotNull
  public XAEngine initFromFile(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    paramString = FileUtil.a.b(paramString);
    if (paramString != null) {
      init(paramString);
    }
    return this;
  }
  
  @NotNull
  public XAEngine initFromFileAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    logi("XAEngine", 1, "initFromFileAsync");
    threadPoolExecutor.execute((Runnable)new XAEngine.initFromFileAsync.1(this, paramString, paramFunction0));
    return this;
  }
  
  @NotNull
  public IXAEngine initFromUrlAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    Object localObject = this.ruleManager.getRuleValue("$DOWNLOAD");
    if (!(localObject instanceof IDownload))
    {
      logi("XAEngine", 1, "initFromUrlAsync  iDownload is null, init failed");
      return (IXAEngine)this;
    }
    ((IDownload)localObject).requestFile(paramString, (Function2)new XAEngine.initFromUrlAsync.1(this, paramFunction0));
    return (IXAEngine)this;
  }
  
  @NotNull
  public XAEngine initRoot(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rootPath");
    this.ruleManager.registerRuleLine("$PARENT_ROOT", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("/xa.json");
    initFromFile(localStringBuilder.toString());
    return this;
  }
  
  @NotNull
  public XAEngine initRootAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rootPath");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    this.ruleManager.registerRuleLine("$PARENT_ROOT", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("/xa.json");
    initFromFileAsync(localStringBuilder.toString(), paramFunction0);
    return this;
  }
  
  @NotNull
  public IXAEngine initZipAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "zipFilePath");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    threadPoolExecutor.execute((Runnable)new XAEngine.initZipAsync.1(this, paramString, paramFunction0));
    return (IXAEngine)this;
  }
  
  public final void logd(@NotNull String paramString1, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(this.tag);
    QLog.a(localStringBuilder.toString(), paramInt, paramString2);
  }
  
  public final void loge(@NotNull String paramString1, @NotNull String paramString2, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "tr");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(this.tag);
    QLog.a(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
  
  public final void logi(@NotNull String paramString1, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(this.tag);
    QLog.c(localStringBuilder.toString(), paramInt, paramString2, null);
  }
  
  public boolean notifyMonitor(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rule");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    if (this.notifyMap.containsKey(paramString))
    {
      Object localObject = this.notifyMap.get(paramString);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject, "notifyMap[rule]!!");
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        return ((ITrigger)((Iterator)localObject).next()).notifyState(paramString, paramObject);
      }
    }
    return false;
  }
  
  @NotNull
  public final XAEngine setCache(@NotNull IMemoryLruCache paramIMemoryLruCache)
  {
    Intrinsics.checkParameterIsNotNull(paramIMemoryLruCache, "cache");
    cache = paramIMemoryLruCache;
    return this;
  }
  
  @NotNull
  public XAEngine setContentLayout(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "framelayout");
    if (!(paramViewGroup instanceof RelativeLayout))
    {
      this.isAddRelativeLayout = true;
      this.viewLayout = ((ViewGroup)new RelativeLayout(paramViewGroup.getContext()));
      paramViewGroup.addView((View)this.viewLayout, new ViewGroup.LayoutParams(-1, -1));
      return this;
    }
    this.viewLayout = paramViewGroup;
    return this;
  }
  
  @NotNull
  public final XAEngine setProxy(int paramInt, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    return setProxy(paramInt, paramView, false);
  }
  
  @NotNull
  public XAEngine setProxy(int paramInt, @NotNull View paramView, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    IView localIView = findById(paramInt);
    if (localIView != null)
    {
      localIView.getDecor().setProxy(paramView, paramBoolean);
      setViewDrawable(localIView);
    }
    return this;
  }
  
  @NotNull
  public IXAEngine setProxyMore(int paramInt, @NotNull View paramView, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    IView localIView = findById(paramInt);
    if (localIView != null)
    {
      localIView.getDecor().setProxy(paramView, paramBoolean);
      setViewDrawable(localIView);
    }
    return (IXAEngine)this;
  }
  
  @NotNull
  public XAEngine setTag(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    this.tag = paramString;
    return this;
  }
  
  public final void setTimelineCount(int paramInt)
  {
    this.timelineCount = paramInt;
  }
  
  public void start()
  {
    postMainThread((Runnable)new XAEngine.start.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine
 * JD-Core Version:    0.7.0.1
 */