package com.tencent.xaction.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.IMemoryLruCache;
import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.api.ITimeline;
import com.tencent.xaction.api.ITrigger;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.IViewManager;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/XAEngine;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "VERSION_CODE", "", "getVERSION_CODE", "()I", "animData", "Lcom/tencent/xaction/api/data/AnimData;", "animTimeline", "Lcom/tencent/xaction/impl/XATimeline;", "componentList", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/data/Component;", "Lkotlin/collections/ArrayList;", "drawableList", "Lcom/tencent/xaction/api/IDrawable;", "notifyMap", "Ljava/util/HashMap;", "", "Lcom/tencent/xaction/api/ITrigger;", "Lkotlin/collections/HashMap;", "ruleManager", "Lcom/tencent/xaction/api/IRuleManager;", "tag", "timelineCount", "getTimelineCount", "setTimelineCount", "(I)V", "timelineList", "uiHandler", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "setUiHandler", "(Landroid/os/Handler;)V", "viewDataList", "Lcom/tencent/xaction/api/data/ViewData;", "viewLayout", "Landroid/view/ViewGroup;", "viewList", "Lcom/tencent/xaction/api/IView;", "compareVersion", "", "createComponent", "", "style", "createTimeLine", "createView", "viewData", "destroy", "finalize", "findById", "id", "findComponentById", "Lcom/tencent/xaction/api/IDecorView;", "findDrawableById", "getContext", "getLayout", "getRuleManager", "init", "data", "eles", "initAsync", "callback", "Lkotlin/Function0;", "initFromFile", "filePath", "initFromFileAsync", "initRoot", "rootPath", "initRootAsync", "linkDrawable", "logd", "level", "msg", "logi", "notifyMonitor", "rule", "value", "preInit", "setCache", "cache", "Lcom/tencent/xaction/api/IMemoryLruCache;", "setContentLayout", "framelayout", "setProxy", "view", "Landroid/view/View;", "isStyle", "setTag", "setViewDrawable", "it", "start", "Companion", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class XAEngine
{
  public static final XAEngine.Companion Companion = new XAEngine.Companion(null);
  private static final String TAG = "XAEngine";
  private static long availClassSize;
  private static IMemoryLruCache cache;
  @NotNull
  private static final ExecutorService threadPoolExecutor;
  @NotNull
  private static IViewManager viewManager = (IViewManager)new ViewManager();
  private final int VERSION_CODE = 2;
  private AnimData animData;
  private final XATimeline animTimeline;
  private final ArrayList<Component> componentList;
  private Context context;
  private final ArrayList<IDrawable> drawableList;
  private HashMap<String, ArrayList<ITrigger>> notifyMap;
  private IRuleManager ruleManager;
  private String tag;
  private int timelineCount;
  private final ArrayList<XATimeline> timelineList;
  @Nullable
  private Handler uiHandler = new Handler(Looper.getMainLooper());
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
    if (this.context != null)
    {
      ScreenUnit.Companion localCompanion = ScreenUnit.a;
      Object localObject = this.context;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((Context)localObject).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this.context!!.resources");
      float f = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = this.context;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((Context)localObject).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this.context!!.resources");
      localCompanion.a(f * 1.0F, ((Resources)localObject).getDisplayMetrics().heightPixels * 1.0F);
    }
    viewManager.a("view", XAView.class);
    viewManager.a("group", XAViewGroup.class);
    viewManager.a("text", XATextView.class);
    this.ruleManager.a((BaseRule)new ScreenRule());
    if (availClassSize == 0L) {
      availClassSize = MemoryLruCacheImpl.a.a(paramContext);
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
    switch (((String)localObject).hashCode())
    {
    }
    do
    {
      return;
    } while (!((String)localObject).equals("component"));
    localObject = this.context;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramViewData = new Component((Context)localObject, this, paramViewData);
    this.componentList.add(paramViewData);
  }
  
  private final void createView(ViewData paramViewData)
  {
    Object localObject1 = viewManager;
    Object localObject2 = this.context;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((IViewManager)localObject1).a((Context)localObject2, paramViewData, this.viewLayout, this);
    if (localObject1 != null)
    {
      ((IView)localObject1).a().setStyle(paramViewData);
      this.viewList.add(localObject1);
    }
    for (;;)
    {
      return;
      localObject1 = paramViewData.getType();
      switch (((String)localObject1).hashCode())
      {
      default: 
        return;
      case -826507106: 
        if ((((String)localObject1).equals("drawable")) && (paramViewData.getDrawable() != null))
        {
          localObject1 = paramViewData.getDrawable();
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = ((DecorDrawableState)localObject1).buildDrawable();
          localObject2 = ((IDrawable)localObject1).a();
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          ((DecorDrawable)localObject2).setStyle(paramViewData);
          localObject2 = ((IDrawable)localObject1).a();
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          ((DecorDrawable)localObject2).setId(paramViewData.getId());
          this.drawableList.add(localObject1);
          localObject2 = this.viewLayout;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          DecorDrawable localDecorDrawable = ((IDrawable)localObject1).a();
          if (localDecorDrawable == null) {
            Intrinsics.throwNpe();
          }
          localDecorDrawable.init((View)localObject2, this);
          paramViewData = paramViewData.getTl();
          if (paramViewData != null)
          {
            localObject1 = ((IDrawable)localObject1).a();
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            paramViewData.a((ITimeline)localObject1);
            return;
          }
        }
        break;
      case 0: 
        if (((String)localObject1).equals(""))
        {
          localObject1 = new XAEmptyView();
          ((XAEmptyView)localObject1).a().a(this, this.viewLayout);
          ((XAEmptyView)localObject1).a().setStyle(paramViewData);
          this.viewList.add((IView)localObject1);
          return;
        }
        break;
      case 94843717: 
        if (((String)localObject1).equals("compt"))
        {
          localObject1 = this.viewLayout;
          if (localObject1 != null) {}
          for (paramViewData = Component.a.a(this, paramViewData, (ViewGroup)localObject1); paramViewData != null; paramViewData = null)
          {
            localObject1 = this.viewList;
            if (paramViewData != null) {
              break label364;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.IView");
          }
        }
        break;
      }
    }
    label364:
    ((ArrayList)localObject1).add((IView)paramViewData);
  }
  
  private final void linkDrawable()
  {
    Iterator localIterator = ((Iterable)this.viewList).iterator();
    while (localIterator.hasNext()) {
      setViewDrawable((IView)localIterator.next());
    }
  }
  
  @JvmStatic
  public static final void pauseAll()
  {
    Companion.a();
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
        this.ruleManager.a(paramViewData, (String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
      }
    }
    localObject1 = ((Iterable)paramViewData.getTr()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseTrigger)((Iterator)localObject1).next();
      if (localObject2 != null) {
        if (((BaseTrigger)localObject2).getMonitor() != null)
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
    }
    createComponent(paramViewData);
  }
  
  @JvmStatic
  public static final boolean registerAnim(@NotNull String paramString, @NotNull Class<BaseAnim> paramClass)
  {
    return Companion.b(paramString, paramClass);
  }
  
  @JvmStatic
  public static final boolean registerDrawable(@NotNull String paramString, @NotNull Class<? extends DecorDrawableState> paramClass)
  {
    return Companion.d(paramString, paramClass);
  }
  
  @JvmStatic
  public static final boolean registerTrigger(@NotNull String paramString, @NotNull Class<BaseTrigger> paramClass)
  {
    return Companion.c(paramString, paramClass);
  }
  
  @JvmStatic
  public static final boolean registerView(@NotNull String paramString, @NotNull Class<? extends IView> paramClass)
  {
    return Companion.a(paramString, paramClass);
  }
  
  @JvmStatic
  public static final void resumeAll()
  {
    Companion.b();
  }
  
  private final void setViewDrawable(IView paramIView)
  {
    Object localObject = paramIView.a().getStyle();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int i = ((ViewData)localObject).getSt().getDrawableId();
    if ((i == 0) || (paramIView.a().a() == null)) {}
    do
    {
      do
      {
        return;
      } while (Build.VERSION.SDK_INT < 16);
      localObject = DecorDrawable.Companion;
      ViewData localViewData = paramIView.a().getStyle();
      if (localViewData == null) {
        Intrinsics.throwNpe();
      }
      paramIView = ((DecorDrawable.Companion)localObject).a(this, i, localViewData.getSt().getHierarchy(), paramIView, true);
    } while (paramIView == null);
    this.drawableList.add(paramIView);
  }
  
  @NotNull
  public final XATimeline createTimeLine()
  {
    this.timelineCount += 1;
    XATimeline localXATimeline = new XATimeline(this.timelineCount);
    this.timelineList.add(localXATimeline);
    return localXATimeline;
  }
  
  public final void destroy()
  {
    Iterator localIterator = ((Iterable)this.timelineList).iterator();
    while (localIterator.hasNext()) {
      ((XATimeline)localIterator.next()).d();
    }
    this.timelineList.clear();
    localIterator = ((Iterable)this.viewDataList).iterator();
    while (localIterator.hasNext()) {
      ((ViewData)localIterator.next()).setDrawable((DecorDrawableState)null);
    }
    this.viewDataList.clear();
    localIterator = ((Iterable)this.drawableList).iterator();
    while (localIterator.hasNext()) {
      ((IDrawable)localIterator.next()).a((DecorDrawable)null);
    }
    this.drawableList.clear();
    this.notifyMap.clear();
    this.uiHandler = ((Handler)null);
    this.context = ((Context)null);
  }
  
  public final void finalize()
  {
    destroy();
    logd("XAEngine", 1, "finalize");
  }
  
  @Nullable
  public final IView findById(int paramInt)
  {
    Iterator localIterator = this.viewList.iterator();
    while (localIterator.hasNext())
    {
      IView localIView = (IView)localIterator.next();
      ViewData localViewData = localIView.a().getStyle();
      if (localViewData != null) {}
      for (int i = localViewData.getId(); i == paramInt; i = -1) {
        return localIView;
      }
    }
    return null;
  }
  
  @Nullable
  public final IDecorView findComponentById(int paramInt)
  {
    Iterator localIterator = this.componentList.iterator();
    while (localIterator.hasNext())
    {
      Component localComponent = (Component)localIterator.next();
      if (localComponent.a() == paramInt) {
        return (IDecorView)localComponent;
      }
    }
    return null;
  }
  
  @Nullable
  public final IDrawable findDrawableById(int paramInt)
  {
    Iterator localIterator = this.drawableList.iterator();
    while (localIterator.hasNext())
    {
      IDrawable localIDrawable = (IDrawable)localIterator.next();
      DecorDrawable localDecorDrawable = localIDrawable.a();
      if (localDecorDrawable == null) {
        Intrinsics.throwNpe();
      }
      if (localDecorDrawable.getId() == paramInt) {
        return localIDrawable;
      }
    }
    return null;
  }
  
  @Nullable
  public final Context getContext()
  {
    return this.context;
  }
  
  @Nullable
  public final ViewGroup getLayout()
  {
    return this.viewLayout;
  }
  
  @NotNull
  public final IRuleManager getRuleManager()
  {
    return this.ruleManager;
  }
  
  public final int getTimelineCount()
  {
    return this.timelineCount;
  }
  
  @Nullable
  public final Handler getUiHandler()
  {
    return this.uiHandler;
  }
  
  public final int getVERSION_CODE()
  {
    return this.VERSION_CODE;
  }
  
  @NotNull
  public final XAEngine init(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    this.animData = ((AnimData)GsonAdapter.a().fromJson(paramString, AnimData.class));
    if (!compareVersion())
    {
      paramString = new StringBuilder().append("init faild versionMin:");
      AnimData localAnimData = this.animData;
      if (localAnimData == null) {
        Intrinsics.throwNpe();
      }
      logi("XAEngine", 1, localAnimData.getVersionMin() + " VERSION_CODE:" + this.VERSION_CODE);
    }
    do
    {
      return this;
      paramString = this.animData;
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      paramString = paramString.getEles();
    } while (paramString == null);
    init(paramString);
    return this;
  }
  
  @NotNull
  public final XAEngine init(@NotNull ArrayList<ViewData> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "eles");
    this.viewDataList = paramArrayList;
    this.animTimeline.a(this.timelineCount);
    int i = 0;
    paramArrayList = ((Iterable)this.viewDataList).iterator();
    while (paramArrayList.hasNext()) {
      preInit((ViewData)paramArrayList.next());
    }
    paramArrayList = ((Iterable)this.componentList).iterator();
    while (paramArrayList.hasNext()) {
      ((Component)paramArrayList.next()).a();
    }
    paramArrayList = this.viewDataList.iterator();
    while (paramArrayList.hasNext())
    {
      ViewData localViewData = (ViewData)paramArrayList.next();
      int j = Math.max(localViewData.getTp().getDuration(), i);
      i = j;
      if (!Intrinsics.areEqual(localViewData.getType(), "component"))
      {
        if ((localViewData.getTp().getRc() == 0) && (!localViewData.getTp().getSingle())) {
          localViewData.setTl(this.animTimeline);
        }
        for (;;)
        {
          Intrinsics.checkExpressionValueIsNotNull(localViewData, "style");
          createView(localViewData);
          i = j;
          break;
          XATimeline localXATimeline = createTimeLine();
          this.timelineCount += 1;
          localXATimeline.a(this.timelineCount);
          localXATimeline.a().set(localViewData.getTp());
          localViewData.setTl(localXATimeline);
        }
      }
    }
    linkDrawable();
    this.animTimeline.a().setDuration(i);
    return this;
  }
  
  @NotNull
  public final XAEngine initAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    threadPoolExecutor.execute((Runnable)new XAEngine.initAsync.1(this, paramString, paramFunction0));
    return this;
  }
  
  @NotNull
  public final XAEngine initFromFile(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    paramString = FileUtil.a.a(paramString);
    if (paramString != null) {
      init(paramString);
    }
    return this;
  }
  
  @NotNull
  public final XAEngine initFromFileAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    threadPoolExecutor.execute((Runnable)new XAEngine.initFromFileAsync.1(this, paramString, paramFunction0));
    return this;
  }
  
  @NotNull
  public final XAEngine initRoot(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rootPath");
    this.ruleManager.a("$PARENT_ROOT", paramString);
    initFromFile(paramString + "/xa.json");
    return this;
  }
  
  @NotNull
  public final XAEngine initRootAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rootPath");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    this.ruleManager.a("$PARENT_ROOT", paramString);
    initFromFileAsync(paramString + "/xa.json", paramFunction0);
    return this;
  }
  
  public final void logd(@NotNull String paramString1, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    QLog.a(paramString1 + "_" + this.tag, paramInt, paramString2);
  }
  
  public final void logi(@NotNull String paramString1, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    QLog.c(paramString1 + "_" + this.tag, paramInt, paramString2, null);
  }
  
  public final boolean notifyMonitor(@NotNull String paramString, @NotNull Object paramObject)
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
  public final XAEngine setContentLayout(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "framelayout");
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
  public final XAEngine setProxy(int paramInt, @NotNull View paramView, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    IView localIView = findById(paramInt);
    if (localIView != null)
    {
      localIView.a().a(paramView, paramBoolean);
      setViewDrawable(localIView);
    }
    return this;
  }
  
  @NotNull
  public final XAEngine setTag(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    this.tag = paramString;
    return this;
  }
  
  public final void setTimelineCount(int paramInt)
  {
    this.timelineCount = paramInt;
  }
  
  public final void setUiHandler(@Nullable Handler paramHandler)
  {
    this.uiHandler = paramHandler;
  }
  
  public final void start()
  {
    if (this.tag == null) {
      QLog.b("AnimEngine", 1, "AnimEngine Must set tag source", new Throwable(" Must set tag source, you can invoke engine.setTag()"));
    }
    Iterator localIterator = ((Iterable)this.viewList).iterator();
    Object localObject2;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localObject2 = (IView)localIterator.next();
      if (((IView)localObject2).a().a() != null)
      {
        localObject1 = ((IView)localObject2).a().getStyle();
        if (localObject1 == null) {
          break label199;
        }
        localObject1 = ((ViewData)localObject1).getTp();
        if (localObject1 == null) {
          break label199;
        }
        localObject1 = Boolean.valueOf(((TimeProp)localObject1).getAutoPlay());
        label106:
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        if (((Boolean)localObject1).booleanValue())
        {
          localObject1 = ((IView)localObject2).a().getStyle();
          if (localObject1 == null) {
            break label204;
          }
          localObject1 = ((ViewData)localObject1).getAnim();
          if (localObject1 == null) {
            break label204;
          }
        }
      }
      label199:
      label204:
      for (localObject1 = Integer.valueOf(((ArrayList)localObject1).size());; localObject1 = null)
      {
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        if (((Integer)localObject1).intValue() > 0)
        {
          localObject1 = ((IView)localObject2).a().getStyle();
          if (localObject1 != null)
          {
            localObject1 = ((ViewData)localObject1).getTl();
            if (localObject1 != null) {
              ((XATimeline)localObject1).a();
            }
          }
        }
        break;
        localObject1 = null;
        break label106;
      }
    }
    localIterator = ((Iterable)this.drawableList).iterator();
    label416:
    while (localIterator.hasNext())
    {
      localObject2 = (IDrawable)localIterator.next();
      localObject1 = ((IDrawable)localObject2).a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((DecorDrawable)localObject1).getTl();
      if (localObject1 != null)
      {
        localObject1 = ((XATimeline)localObject1).a();
        if (localObject1 == null) {}
      }
      for (localObject1 = Boolean.valueOf(((TimeProp)localObject1).getAutoPlay());; localObject1 = null)
      {
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        if (!((Boolean)localObject1).booleanValue()) {
          break label416;
        }
        localObject1 = ((IDrawable)localObject2).a();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        if (((DecorDrawable)localObject1).getDrawable() == null) {
          break label416;
        }
        localObject1 = ((IDrawable)localObject2).a();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        if (!(((DecorDrawable)localObject1).getDrawable() instanceof Drawable)) {
          break label416;
        }
        localObject1 = ((IDrawable)localObject2).a();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((DecorDrawable)localObject1).getDrawable();
        if (localObject1 != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Drawable");
      }
      if (((Drawable)localObject1).getCallback() != null)
      {
        localObject1 = ((IDrawable)localObject2).a();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((DecorDrawable)localObject1).getTl();
        if (localObject1 != null) {
          ((XATimeline)localObject1).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine
 * JD-Core Version:    0.7.0.1
 */