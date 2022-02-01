package com.tencent.xaction.trigger;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.api.IStatus;
import com.tencent.xaction.api.ITimeline;
import com.tencent.xaction.api.ITrigger;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.data.FloatViewData;
import com.tencent.xaction.api.data.LinkView;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.data.ViewData.Companion;
import com.tencent.xaction.api.util.ReflectUtil;
import com.tencent.xaction.api.util.ReflectUtil.Companion;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.express.ExpressHelper;
import com.tencent.xaction.helper.ViewHelper;
import com.tencent.xaction.impl.AnimStateListener;
import com.tencent.xaction.impl.Expression;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.log.QLog;
import com.tencent.xaction.manager.RuleManager;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IStatusNotify;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.trigger.helper.CurrentState;
import com.tencent.xaction.view.Component;
import com.tencent.xaction.view.Component.Companion;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/BaseTrigger;", "Lcom/tencent/xaction/api/ITrigger;", "Lcom/tencent/xaction/api/IStatus;", "", "()V", "anim", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/base/BaseAnim;", "Lkotlin/collections/ArrayList;", "getAnim", "()Ljava/util/ArrayList;", "setAnim", "(Ljava/util/ArrayList;)V", "animStateListenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/xaction/impl/AnimStateListener;", "Lkotlin/collections/HashMap;", "getAnimStateListenerMap", "()Ljava/util/HashMap;", "setAnimStateListenerMap", "(Ljava/util/HashMap;)V", "data", "Lcom/tencent/xaction/api/data/ViewData;", "getData", "()Lcom/tencent/xaction/api/data/ViewData;", "setData", "(Lcom/tencent/xaction/api/data/ViewData;)V", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "getEngine", "()Lcom/tencent/xaction/impl/XAEngine;", "setEngine", "(Lcom/tencent/xaction/impl/XAEngine;)V", "iView", "Lcom/tencent/xaction/api/IView;", "getIView", "()Lcom/tencent/xaction/api/IView;", "setIView", "(Lcom/tencent/xaction/api/IView;)V", "linkViews", "Lcom/tencent/xaction/api/data/LinkView;", "getLinkViews", "setLinkViews", "monitor", "", "", "getMonitor", "()[Ljava/lang/String;", "setMonitor", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "notify", "getNotify", "()Ljava/lang/String;", "state", "Lcom/tencent/xaction/trigger/helper/CurrentState;", "getState", "()Lcom/tencent/xaction/trigger/helper/CurrentState;", "setState", "(Lcom/tencent/xaction/trigger/helper/CurrentState;)V", "status", "getStatus", "setStatus", "(Ljava/lang/String;)V", "timeline", "Lcom/tencent/xaction/impl/XATimeline;", "getTimeline", "()Lcom/tencent/xaction/impl/XATimeline;", "setTimeline", "(Lcom/tencent/xaction/impl/XATimeline;)V", "tp", "Lcom/tencent/xaction/api/data/TimeProp;", "getTp", "()Lcom/tencent/xaction/api/data/TimeProp;", "setTp", "(Lcom/tencent/xaction/api/data/TimeProp;)V", "type", "getType", "setType", "action", "", "view", "Landroid/view/View;", "addAnim", "baseAnim", "addParView", "linkView", "animCancel", "clone", "computeExps", "computeValue", "", "value", "order", "floatWindow", "forWardActive", "", "link", "getAnimWithStatus", "", "getStatusAnims", "isSameStatus", "s", "linkAnimStateListener", "floatData", "Lcom/tencent/xaction/api/data/FloatViewData;", "tl", "linkAnimValue", "i", "linkIndepenentAnim", "listViews", "linkIndepenentProgressAnim", "linkParticalView", "linkSingleTagView", "it", "linkViewAnim", "anims", "linkViewAnims", "decorView", "Lcom/tencent/xaction/api/IDecorView;", "iview", "notifyState", "key", "notifyStatus", "parseLinkViewRule", "ruleManager", "Lcom/tencent/xaction/manager/RuleManager;", "viewData", "fieldKey", "removeParView", "runViewAnim", "updateDynamicProxy", "updateProgress", "change", "updateStatus", "viewDataCopy", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public abstract class BaseTrigger
  implements IStatus, ITrigger, Cloneable
{
  public static final BaseTrigger.Companion Companion = new BaseTrigger.Companion(null);
  private static final String TAG = "BaseTrigger";
  @NotNull
  private ArrayList<BaseAnim> anim = new ArrayList();
  @NotNull
  private transient HashMap<Integer, AnimStateListener> animStateListenerMap = new HashMap();
  @Nullable
  private transient ViewData data;
  @Nullable
  private transient XAEngine engine;
  @Nullable
  private transient IView iView;
  @Nullable
  private ArrayList<LinkView> linkViews;
  @Nullable
  private String[] monitor;
  @NotNull
  private final String notify = "";
  @NotNull
  private transient CurrentState state = new CurrentState(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 4095, null);
  @NotNull
  private String status = "";
  @Nullable
  private transient XATimeline timeline;
  @NotNull
  private TimeProp tp = new TimeProp();
  @NotNull
  private String type = "";
  
  private final void addParView(IView paramIView, LinkView paramLinkView)
  {
    ViewData localViewData = paramIView.getDecor().getStyle();
    if (localViewData != null)
    {
      paramIView = this.engine;
      if (paramIView != null) {
        paramIView = paramIView.getRuleManager();
      } else {
        paramIView = null;
      }
      if (paramIView != null)
      {
        paramIView = (RuleManager)paramIView;
        Object localObject1 = paramLinkView.getRules().entrySet();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "linkView.rules.entries");
        localObject1 = ((Iterable)localObject1).iterator();
        Object localObject3;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = ((Map.Entry)localObject2).getKey();
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.key");
          localObject3 = (String)localObject3;
          localObject2 = ((Map.Entry)localObject2).getValue();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.value");
          paramIView.setRuleValueToObj(paramLinkView, (String)localObject3, (String)localObject2);
        }
        boolean bool = Intrinsics.areEqual(localViewData.getType(), "compt");
        int j = 0;
        int i = 0;
        if (bool)
        {
          j = paramLinkView.getParCount();
          while (i < j)
          {
            paramIView = Component.Companion;
            localObject1 = this.engine;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            localObject2 = viewDataCopy(i, localViewData, paramLinkView);
            localObject3 = this.engine;
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            localObject3 = ((XAEngine)localObject3).getLayout();
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            paramIView = paramIView.a((XAEngine)localObject1, (ViewData)localObject2, (ViewGroup)localObject3);
            if (paramIView != null) {
              paramLinkView.getParViews().add(paramIView);
            }
            i += 1;
          }
        }
        paramIView = new ArrayList();
        int k = paramLinkView.getParCount();
        i = j;
        while (i < k)
        {
          paramIView.add(viewDataCopy(i, localViewData, paramLinkView));
          i += 1;
        }
        localObject1 = this.engine;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        Object localObject2 = this.engine;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((XAEngine)localObject1).data2View(((XAEngine)localObject2).getLayout(), paramIView, paramLinkView.getParViews(), localViewData.getTp());
        paramLinkView.getViews().addAll((Collection)paramLinkView.getParViews());
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.manager.RuleManager");
    }
  }
  
  private final void animCancel()
  {
    XATimeline localXATimeline = this.timeline;
    if (localXATimeline != null)
    {
      if (localXATimeline == null) {
        Intrinsics.throwNpe();
      }
      localXATimeline.g();
    }
  }
  
  private final void computeExps(BaseAnim paramBaseAnim)
  {
    Iterator localIterator = ((Map)paramBaseAnim.getExpressionList()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((Expression)localEntry.getValue()).a(this.state);
      ReflectUtil.a.a(paramBaseAnim, (String)localEntry.getKey(), ((Expression)localEntry.getValue()).a());
    }
  }
  
  private final Object computeValue(String paramString, int paramInt)
  {
    int i = StringsKt.indexOf$default((CharSequence)paramString, ":", 0, false, 6, null);
    if (i == -1) {
      return paramString;
    }
    if (paramString != null)
    {
      String str = paramString.substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (paramString != null)
      {
        Object localObject = paramString.substring(i + 1);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).substring(startIndex)");
        localObject = StringsKt.split$default((CharSequence)localObject, new String[] { "," }, false, 0, 6, null);
        i = str.hashCode();
        if (i != -938285885)
        {
          if (i != 106006350) {
            return paramString;
          }
          if (str.equals("order"))
          {
            float f;
            if ((paramInt >= 0) && (paramInt < ((List)localObject).size())) {
              f = Float.parseFloat((String)((List)localObject).get(paramInt));
            } else {
              f = Float.parseFloat((String)((List)localObject).get(0));
            }
            return Float.valueOf(f);
          }
        }
        else if (str.equals("random"))
        {
          paramString = CollectionsKt.random((Collection)localObject, (Random)Random.Default);
        }
        return paramString;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final void floatWindow(LinkView paramLinkView)
  {
    if ((Intrinsics.areEqual(paramLinkView.getFloat(), "window") ^ true)) {
      return;
    }
    Iterator localIterator = ((Iterable)paramLinkView.getViews()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (IView)localIterator.next();
      View localView = ((IView)localObject).getDecor().b();
      if ((localView != null) && (((IView)localObject).getDecor().getStyle() != null))
      {
        localObject = ((IView)localObject).getDecor().getStyle();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((ViewData)localObject).getTl();
        if (localObject != null) {
          linkAnimStateListener(paramLinkView.getFloatData(), localView, (XATimeline)localObject);
        }
      }
    }
  }
  
  private final boolean forWardActive(LinkView paramLinkView)
  {
    boolean bool2;
    if (!paramLinkView.isForWardActive())
    {
      if ((paramLinkView.getFx() != ScreenUnit.a.a()) && (paramLinkView.getFx() >= this.state.getMovedX())) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      bool1 = bool2;
      if (paramLinkView.getFy() == ScreenUnit.a.a()) {
        break label150;
      }
      bool1 = bool2;
      if (paramLinkView.getFy() < this.state.getMovedY()) {
        break label150;
      }
    }
    else
    {
      if ((paramLinkView.getFx() != ScreenUnit.a.a()) && (paramLinkView.getFx() <= this.state.getMovedX())) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      bool1 = bool2;
      if (paramLinkView.getFy() == ScreenUnit.a.a()) {
        break label150;
      }
      bool1 = bool2;
      if (paramLinkView.getFy() > this.state.getMovedY()) {
        break label150;
      }
    }
    boolean bool1 = false;
    label150:
    if (bool1) {
      paramLinkView.setForWardActive(true ^ paramLinkView.isForWardActive());
    }
    return bool1;
  }
  
  private final ArrayList<BaseAnim> getAnimWithStatus()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.anim).iterator();
    while (localIterator.hasNext())
    {
      BaseAnim localBaseAnim = (BaseAnim)localIterator.next();
      if (isSameStatus(localBaseAnim.getStatus())) {
        localArrayList.add(localBaseAnim);
      }
    }
    return localArrayList;
  }
  
  private final ArrayList<BaseAnim> getStatusAnims(String paramString)
  {
    paramString = new ArrayList();
    Iterator localIterator = this.anim.iterator();
    while (localIterator.hasNext())
    {
      BaseAnim localBaseAnim = (BaseAnim)localIterator.next();
      if (isSameStatus(localBaseAnim.getStatus())) {
        paramString.add(localBaseAnim);
      }
    }
    return paramString;
  }
  
  private final void linkAnimStateListener(FloatViewData paramFloatViewData, View paramView, XATimeline paramXATimeline)
  {
    if (paramView == null) {
      return;
    }
    int i = paramView.hashCode();
    if (this.animStateListenerMap.containsKey(Integer.valueOf(i))) {
      return;
    }
    paramFloatViewData = new BaseTrigger.linkAnimStateListener.listener.1(this, paramFloatViewData, paramView, i);
    ((Map)this.animStateListenerMap).put(Integer.valueOf(i), paramFloatViewData);
    paramXATimeline.a((AnimStateListener)paramFloatViewData);
  }
  
  private final void linkAnimValue(ViewData paramViewData, int paramInt, LinkView paramLinkView)
  {
    Object localObject1 = this.engine;
    if (localObject1 != null) {
      localObject1 = ((XAEngine)localObject1).getRuleManager();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject1 = (RuleManager)localObject1;
      paramLinkView = paramLinkView.getParRules().entrySet();
      Intrinsics.checkExpressionValueIsNotNull(paramLinkView, "linkView.parRules.entries");
      paramLinkView = ((Iterable)paramLinkView).iterator();
      while (paramLinkView.hasNext())
      {
        Object localObject2 = (Map.Entry)paramLinkView.next();
        Object localObject3 = ((Map.Entry)localObject2).getValue();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "ruleIt.value");
        Object localObject4 = ((RuleManager)localObject1).getRuleValue((String)localObject3);
        localObject3 = ExpressHelper.a;
        Object localObject5 = ((Map.Entry)localObject2).getKey();
        Intrinsics.checkExpressionValueIsNotNull(localObject5, "ruleIt.key");
        localObject3 = ((ExpressHelper)localObject3).a(paramViewData, (String)localObject5);
        if (localObject3 == null)
        {
          paramViewData = new StringBuilder();
          paramViewData.append("unSupport field = ");
          paramViewData.append((String)((Map.Entry)localObject2).getKey());
          QLog.a("BaseTrigger", 1, paramViewData.toString());
          return;
        }
        localObject5 = ExpressHelper.a;
        Object localObject6 = ((Map.Entry)localObject2).getValue();
        Intrinsics.checkExpressionValueIsNotNull(localObject6, "ruleIt.value");
        if (((ExpressHelper)localObject5).a((String)localObject6))
        {
          localObject4 = ExpressHelper.a;
          localObject5 = ((Field)((Pair)localObject3).getSecond()).getType();
          Intrinsics.checkExpressionValueIsNotNull(localObject5, "fieldPair.second.type");
          localObject2 = ((Map.Entry)localObject2).getValue();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "ruleIt.value");
          localObject2 = ((ExpressHelper)localObject4).a((Class)localObject5, (String)localObject2, paramInt);
          ExpressHelper.a.a((Pair)localObject3, localObject2);
        }
        else if ((localObject4 instanceof List))
        {
          localObject2 = (List)localObject4;
          if (paramInt < ((List)localObject2).size())
          {
            localObject2 = ((List)localObject2).get(paramInt);
            if (localObject2 != null) {
              ExpressHelper.a.a((Pair)localObject3, localObject2);
            }
          }
        }
        else if (localObject4 != null)
        {
          ExpressHelper.a.a((Pair)localObject3, localObject4);
        }
      }
      paramViewData = ((Iterable)paramViewData.getAnim()).iterator();
      while (paramViewData.hasNext())
      {
        paramLinkView = (BaseAnim)paramViewData.next();
        if (paramLinkView.getLDelay() > 0) {
          paramLinkView.setDelay(paramLinkView.getLDelay() * paramInt + paramLinkView.getDelay());
        }
      }
      return;
    }
    paramViewData = new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.manager.RuleManager");
    for (;;)
    {
      throw paramViewData;
    }
  }
  
  private final void linkIndepenentAnim(List<LinkView> paramList)
  {
    paramList = ((Iterable)paramList).iterator();
    break label78;
    label10:
    LinkView localLinkView;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localLinkView = (LinkView)paramList.next();
    } while ((localLinkView.getViews().size() == 0) || (localLinkView.getAnim() == null) || (!isSameStatus(localLinkView.getStatus())));
    floatWindow(localLinkView);
    Iterator localIterator1 = ((Iterable)localLinkView.getAnim()).iterator();
    for (;;)
    {
      label78:
      if (!localIterator1.hasNext()) {
        break label10;
      }
      BaseAnim localBaseAnim1 = (BaseAnim)localIterator1.next();
      if ((localBaseAnim1 == null) || (!isSameStatus(localBaseAnim1.getStatus()))) {
        break;
      }
      Iterator localIterator2 = ((Iterable)localLinkView.getViews()).iterator();
      while (localIterator2.hasNext())
      {
        Object localObject1 = (IView)localIterator2.next();
        BaseAnim localBaseAnim2 = localBaseAnim1.clone();
        localObject1 = ((IView)localObject1).getDecor().b();
        Object localObject2 = this.timeline;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((XATimeline)localObject2).a((ITimeline)localBaseAnim2);
        computeExps(localBaseAnim2);
        if (localObject1 != null)
        {
          localObject2 = this.engine;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          localBaseAnim2.init((View)localObject1, (IXAEngine)localObject2);
        }
      }
    }
  }
  
  private final XATimeline linkIndepenentProgressAnim(List<LinkView> paramList)
  {
    Object localObject1 = this.engine;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((XAEngine)localObject1).createTimeLine();
    Object localObject2 = ((XATimeline)localObject1).a();
    Object localObject3 = this.timeline;
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    ((TimeProp)localObject2).set(((XATimeline)localObject3).a());
    paramList = ((Iterable)paramList).iterator();
    break label132;
    label55:
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localObject2 = (LinkView)paramList.next();
    } while ((((LinkView)localObject2).getViews().size() == 0) || (((LinkView)localObject2).getAnim() == null) || (!isSameStatus(((LinkView)localObject2).getStatus())) || (!forWardActive((LinkView)localObject2)));
    floatWindow((LinkView)localObject2);
    localObject3 = ((Iterable)((LinkView)localObject2).getAnim()).iterator();
    for (;;)
    {
      label132:
      if (!((Iterator)localObject3).hasNext()) {
        break label55;
      }
      BaseAnim localBaseAnim1 = (BaseAnim)((Iterator)localObject3).next();
      if ((localBaseAnim1 == null) || (localBaseAnim1.getForward() != ((LinkView)localObject2).isForWardActive()) || (!isSameStatus(localBaseAnim1.getStatus()))) {
        break;
      }
      Iterator localIterator = ((Iterable)((LinkView)localObject2).getViews()).iterator();
      while (localIterator.hasNext())
      {
        Object localObject4 = (IView)localIterator.next();
        BaseAnim localBaseAnim2 = localBaseAnim1.clone();
        localObject4 = ((IView)localObject4).getDecor().b();
        ((XATimeline)localObject1).a((ITimeline)localBaseAnim2);
        computeExps(localBaseAnim2);
        if (localObject4 != null)
        {
          XAEngine localXAEngine = this.engine;
          if (localXAEngine == null) {
            Intrinsics.throwNpe();
          }
          localBaseAnim2.init((View)localObject4, (IXAEngine)localXAEngine);
        }
      }
    }
    return localObject1;
  }
  
  private final void linkParticalView(LinkView paramLinkView)
  {
    int i = paramLinkView.hashCode();
    if (this.animStateListenerMap.containsKey(Integer.valueOf(i))) {
      return;
    }
    Integer[] arrayOfInteger = paramLinkView.getLId();
    if (arrayOfInteger != null)
    {
      int j = arrayOfInteger.length;
      i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = this.engine;
        if (localObject != null)
        {
          localObject = ((XAEngine)localObject).findById(k);
          if (localObject != null)
          {
            if (paramLinkView.getParCount() > 1)
            {
              XAEngine localXAEngine = this.engine;
              if (localXAEngine == null) {
                Intrinsics.throwNpe();
              }
              if (localXAEngine.getLayout() != null)
              {
                removeParView(paramLinkView);
                addParView((IView)localObject, paramLinkView);
                break label134;
              }
            }
            paramLinkView.getViews().add(localObject);
          }
        }
        label134:
        i += 1;
      }
    }
  }
  
  private final void linkSingleTagView(String paramString, LinkView paramLinkView)
  {
    Object localObject1 = this.engine;
    if (localObject1 != null) {
      paramString = ((XAEngine)localObject1).findByTag(paramString);
    } else {
      paramString = null;
    }
    if ((paramString instanceof View))
    {
      paramLinkView.getViews().add(paramString);
      ViewHelper.a.a((View)paramString);
      paramLinkView = paramString.getDecor();
      localObject1 = this.engine;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = (IXAEngine)localObject1;
      Object localObject2 = this.engine;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((XAEngine)localObject2).getLayout();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      paramLinkView.a((IXAEngine)localObject1, (ViewGroup)localObject2);
      paramLinkView = paramString.getDecor().getStyle();
      if (paramLinkView != null) {
        paramString.getDecor().setStyle(paramLinkView);
      }
    }
  }
  
  private final void linkViewAnim(ArrayList<BaseAnim> paramArrayList, List<LinkView> paramList)
  {
    paramArrayList = ((Iterable)paramArrayList).iterator();
    break label47;
    break label47;
    label10:
    BaseAnim localBaseAnim1;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localBaseAnim1 = (BaseAnim)paramArrayList.next();
    } while (!localBaseAnim1.isLink());
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    label47:
    label217:
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label10;
      }
      LinkView localLinkView = (LinkView)localIterator1.next();
      if (localLinkView.getViews().size() == 0) {
        break;
      }
      Iterator localIterator2 = ((Iterable)localLinkView.getViews()).iterator();
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label217;
        }
        View localView = ((IView)localIterator2.next()).getDecor().b();
        if (localView == null) {
          break;
        }
        BaseAnim localBaseAnim2 = localBaseAnim1.clone();
        localBaseAnim2.setDuration((int)(localBaseAnim2.getDuration() * localLinkView.getDamping()));
        Object localObject = this.timeline;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        ((XATimeline)localObject).a((ITimeline)localBaseAnim2);
        computeExps(localBaseAnim2);
        localObject = this.engine;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localBaseAnim2.init(localView, (IXAEngine)localObject);
      }
    }
  }
  
  private final void linkViewAnims(IDecorView paramIDecorView, ArrayList<BaseAnim> paramArrayList, XATimeline paramXATimeline)
  {
    Object localObject1 = paramIDecorView.getStyle();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((ViewData)localObject1).getExts();
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).get("animLink");
      if (localObject1 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "decorView.getStyle()!!.e…get(\"animLink\") ?: return");
        Object localObject2 = RuleManager.Companion;
        localObject2 = this.engine;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = (IXAEngine)localObject2;
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          localObject1 = ((IXAEngine)localObject2).getRuleManager().getRuleValue((String)localObject1);
          if (localObject1 != null) {
            try
            {
              if ((localObject1 instanceof ArrayList)) {
                break label166;
              }
              if (localObject1 != null)
              {
                localObject1 = ((Function0)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject1, 0)).invoke();
                break label166;
              }
              throw new TypeCastException("null cannot be cast to non-null type () -> T?");
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          } else {
            localArrayList = null;
          }
          label166:
          ArrayList localArrayList = (ArrayList)localArrayList;
          if ((localArrayList != null) && ((((Collection)localArrayList).isEmpty() ^ true))) {
            paramIDecorView.a(localArrayList, paramArrayList, paramXATimeline);
          }
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
    }
  }
  
  private final void notifyStatus(View paramView, String paramString)
  {
    try
    {
      Object localObject1 = this.engine;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((XAEngine)localObject1).getRuleManager().getRuleValue(this.notify);
      if ((localObject1 instanceof IStatusNotify))
      {
        Object localObject2 = this.iView;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((IView)localObject2).getDecor().b();
        if (localObject2 != null)
        {
          ((IStatusNotify)localObject1).notify(paramString, (View)localObject2, (Function1)new BaseTrigger.notifyStatus..inlined.let.lambda.1(this, localObject1, paramString, paramView));
          return;
        }
      }
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private final void parseLinkViewRule(RuleManager paramRuleManager, ViewData paramViewData, String paramString, Object paramObject)
  {
    Object localObject = (CharSequence)paramString;
    if (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)".", false, 2, null))
    {
      paramRuleManager.setValueToObj(paramViewData, paramString, paramObject);
      return;
    }
    int i = StringsKt.indexOf$default((CharSequence)localObject, ".", 0, false, 6, null);
    int j = StringsKt.indexOf$default((CharSequence)localObject, ".", 0, false, 6, null);
    if (paramString != null)
    {
      localObject = paramString.substring(0, j);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (paramString != null)
      {
        paramString = paramString.substring(i + 1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        i = ((String)localObject).hashCode();
        if (i != 3681)
        {
          if (i != 2998801) {
            return;
          }
          if (((String)localObject).equals("anim"))
          {
            paramViewData = ((Iterable)paramViewData.getAnim()).iterator();
            while (paramViewData.hasNext()) {
              paramRuleManager.setValueToObj((BaseAnim)paramViewData.next(), paramString, paramObject);
            }
          }
        }
        else if (((String)localObject).equals("st"))
        {
          paramRuleManager.setValueToObj(paramViewData.getSt(), paramString, paramObject);
        }
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    paramRuleManager = new TypeCastException("null cannot be cast to non-null type java.lang.String");
    for (;;)
    {
      throw paramRuleManager;
    }
  }
  
  private final void removeParView(LinkView paramLinkView)
  {
    Iterator localIterator = ((Iterable)paramLinkView.getParViews()).iterator();
    while (localIterator.hasNext())
    {
      IView localIView = (IView)localIterator.next();
      paramLinkView.getViews().remove(localIView);
      if ((localIView instanceof View)) {
        ViewHelper.a.a((View)localIView);
      }
    }
    paramLinkView.getParViews().clear();
  }
  
  private final void removeParView(LinkView paramLinkView, View paramView)
  {
    Iterator localIterator = ((Iterable)paramLinkView.getParViews()).iterator();
    while (localIterator.hasNext())
    {
      IView localIView = (IView)localIterator.next();
      if (!(Intrinsics.areEqual(paramView, localIView) ^ true))
      {
        paramLinkView.getViews().remove(localIView);
        paramLinkView.getParViews().remove(localIView);
        if ((localIView instanceof View)) {
          ViewHelper.a.a((View)localIView);
        }
      }
    }
  }
  
  private final void runViewAnim(List<LinkView> paramList)
  {
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      LinkView localLinkView = (LinkView)paramList.next();
      if ((localLinkView.getViews().size() != 0) && (localLinkView.getRunViewAnim()) && (isSameStatus(localLinkView.getStatus())))
      {
        floatWindow(localLinkView);
        Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
        localObjectRef.element = ((XATimeline)null);
        Iterator localIterator = ((Iterable)localLinkView.getViews()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (IView)localIterator.next();
          Object localObject2 = ((IView)localObject1).getDecor().getStyle();
          if ((localObject2 != null) && (((ViewData)localObject2).getTl() != null))
          {
            Object localObject3;
            if ((Intrinsics.areEqual((XATimeline)localObjectRef.element, ((ViewData)localObject2).getTl()) ^ true))
            {
              localObject3 = ((ViewData)localObject2).getTl();
              if (localObject3 == null) {
                Intrinsics.throwNpe();
              }
              ((XATimeline)localObject3).g();
            }
            localObjectRef.element = ((ViewData)localObject2).getTl();
            if ((XATimeline)localObjectRef.element != null)
            {
              localObject3 = ((IView)localObject1).getDecor();
              Object localObject4 = ((ViewData)localObject2).getAnim();
              XATimeline localXATimeline = ((ViewData)localObject2).getTl();
              if (localXATimeline == null) {
                Intrinsics.throwNpe();
              }
              linkViewAnims((IDecorView)localObject3, (ArrayList)localObject4, localXATimeline);
              localObject3 = ((Iterable)((ViewData)localObject2).getAnim()).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (BaseAnim)((Iterator)localObject3).next();
                localXATimeline = ((ViewData)localObject2).getTl();
                if (localXATimeline == null) {
                  Intrinsics.throwNpe();
                }
                localXATimeline.a((ITimeline)localObject4);
              }
              int i = ((IView)localObject1).getDecor().hashCode();
              if (!this.animStateListenerMap.containsKey(Integer.valueOf(i)))
              {
                localObject1 = new BaseTrigger.runViewAnim..inlined.forEach.lambda.1((IView)localObject1, i, localObjectRef, localLinkView, this);
                localObject2 = (XATimeline)localObjectRef.element;
                if (localObject2 != null) {
                  ((XATimeline)localObject2).a((AnimStateListener)localObject1);
                }
              }
              localObject1 = (XATimeline)localObjectRef.element;
              if (localObject1 != null) {
                ((XATimeline)localObject1).c();
              }
            }
          }
        }
      }
    }
  }
  
  private final void updateDynamicProxy()
  {
    Object localObject1 = this.iView;
    if (localObject1 == null) {
      return;
    }
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((IView)localObject1).getDecor().getStyle();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((ViewData)localObject1).getExts();
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).get("dynamic");
      if (localObject1 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "iView!!.decor.getStyle()….get(\"dynamic\") ?: return");
        Object localObject2 = RuleManager.Companion;
        localObject2 = this.engine;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = (IXAEngine)localObject2;
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          localObject1 = ((IXAEngine)localObject2).getRuleManager().getRuleValue((String)localObject1);
          if (localObject1 != null) {
            try
            {
              if ((localObject1 instanceof View)) {
                break label160;
              }
              if (localObject1 != null)
              {
                localObject1 = ((Function0)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject1, 0)).invoke();
                break label160;
              }
              throw new TypeCastException("null cannot be cast to non-null type () -> T?");
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          } else {
            localView = null;
          }
          label160:
          View localView = (View)localView;
          if (localView != null)
          {
            localObject2 = this.engine;
            if (localObject2 != null)
            {
              IView localIView = this.iView;
              if (localIView == null) {
                Intrinsics.throwNpe();
              }
              ((XAEngine)localObject2).setProxy(localIView, localView, true);
              return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
          }
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
    }
  }
  
  private final ViewData viewDataCopy(int paramInt, ViewData paramViewData, LinkView paramLinkView)
  {
    ViewData localViewData = paramViewData.deepCopy();
    localViewData.setTemplate(false);
    linkAnimValue(localViewData, paramInt, paramLinkView);
    localViewData.setId(paramViewData.getId() * 10000 + paramInt);
    return localViewData;
  }
  
  public void action(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Object localObject1 = this.timeline;
    if (localObject1 != null)
    {
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((XATimeline)localObject1).i();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((Boolean)localObject1).booleanValue()) {
        return;
      }
      localObject1 = this.timeline;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((XATimeline)localObject1).a().set(this.tp);
      localObject1 = this.anim.iterator();
      int i = 0;
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseAnim)((Iterator)localObject1).next();
        int j = i;
        if (Intrinsics.areEqual(((BaseAnim)localObject2).getFloat(), "window")) {
          j = 1;
        }
        i = j;
        if (isSameStatus(((BaseAnim)localObject2).getStatus()))
        {
          Object localObject3 = this.timeline;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "an");
          ((XATimeline)localObject3).a((ITimeline)localObject2);
          computeExps((BaseAnim)localObject2);
          localObject3 = this.engine;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          ((BaseAnim)localObject2).init(paramView, (IXAEngine)localObject3);
          i = j;
        }
      }
      if (i != 0)
      {
        localObject1 = (BaseAnim)this.anim.get(0);
        localObject2 = this.timeline;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((BaseAnim)localObject1).animStateListener((XATimeline)localObject2, paramView);
      }
      paramView = this.timeline;
      if (paramView == null) {
        Intrinsics.throwNpe();
      }
      paramView.c();
    }
  }
  
  public void addAnim(@NotNull BaseAnim paramBaseAnim)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "baseAnim");
    this.anim.add(paramBaseAnim);
  }
  
  @NotNull
  public BaseTrigger clone()
  {
    Object localObject = super.clone();
    if (localObject != null)
    {
      BaseTrigger localBaseTrigger = (BaseTrigger)localObject;
      localBaseTrigger.anim = ViewData.Companion.a(this.anim);
      localObject = this.monitor;
      if (localObject != null) {
        localObject = (String[])localObject.clone();
      } else {
        localObject = null;
      }
      localBaseTrigger.monitor = ((String[])localObject);
      localBaseTrigger.state = CurrentState.copy$default(this.state, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 4095, null);
      localBaseTrigger.animStateListenerMap = new HashMap();
      return localBaseTrigger;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.trigger.BaseTrigger");
  }
  
  @NotNull
  public final ArrayList<BaseAnim> getAnim()
  {
    return this.anim;
  }
  
  @NotNull
  public final HashMap<Integer, AnimStateListener> getAnimStateListenerMap()
  {
    return this.animStateListenerMap;
  }
  
  @Nullable
  protected final ViewData getData()
  {
    return this.data;
  }
  
  @Nullable
  public final XAEngine getEngine()
  {
    return this.engine;
  }
  
  @Nullable
  protected final IView getIView()
  {
    return this.iView;
  }
  
  @Nullable
  public final ArrayList<LinkView> getLinkViews()
  {
    return this.linkViews;
  }
  
  @Nullable
  public final List<LinkView> getLinkViews()
  {
    if (this.linkViews == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.linkViews;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LinkView localLinkView = (LinkView)((Iterator)localObject).next();
      if (isSameStatus(localLinkView.getStatus()))
      {
        if (localLinkView.getViews().size() == 0)
        {
          Intrinsics.checkExpressionValueIsNotNull(localLinkView, "linkView");
          linkParticalView(localLinkView);
          String[] arrayOfString = localLinkView.getLTag();
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              linkSingleTagView(arrayOfString[i], localLinkView);
              i += 1;
            }
          }
        }
        if (localLinkView.getViews().size() > 0) {
          localArrayList.add(localLinkView);
        }
      }
    }
    return (List)localArrayList;
  }
  
  @Nullable
  public final String[] getMonitor()
  {
    return this.monitor;
  }
  
  @NotNull
  public final String getNotify()
  {
    return this.notify;
  }
  
  @NotNull
  public final CurrentState getState()
  {
    return this.state;
  }
  
  @NotNull
  public final String getStatus()
  {
    return this.status;
  }
  
  @Nullable
  protected final XATimeline getTimeline()
  {
    return this.timeline;
  }
  
  @NotNull
  public final TimeProp getTp()
  {
    return this.tp;
  }
  
  @NotNull
  public final String getType()
  {
    return this.type;
  }
  
  public final boolean isSameStatus(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "s");
    if (Intrinsics.areEqual(paramString, "")) {
      return true;
    }
    paramString = (CharSequence)paramString;
    if (StringsKt.contains$default(paramString, (CharSequence)",", false, 2, null))
    {
      Iterator localIterator = ((Iterable)StringsKt.split$default(paramString, new String[] { "," }, false, 0, 6, null)).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (StringsKt.contains$default((CharSequence)this.status, (CharSequence)str, false, 2, null)) {
          return true;
        }
      }
    }
    return StringsKt.contains$default((CharSequence)this.status, paramString, false, 2, null);
  }
  
  @CallSuper
  public void monitor(@NotNull ViewData paramViewData, @NotNull IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    this.iView = paramIView;
    this.data = paramViewData;
    if (this.timeline == null)
    {
      paramViewData = this.engine;
      if (paramViewData == null) {
        Intrinsics.throwNpe();
      }
      this.timeline = paramViewData.createTimeLine();
    }
  }
  
  public boolean notifyState(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    updateDynamicProxy();
    return false;
  }
  
  public final void setAnim(@NotNull ArrayList<BaseAnim> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.anim = paramArrayList;
  }
  
  public final void setAnimStateListenerMap(@NotNull HashMap<Integer, AnimStateListener> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "<set-?>");
    this.animStateListenerMap = paramHashMap;
  }
  
  protected final void setData(@Nullable ViewData paramViewData)
  {
    this.data = paramViewData;
  }
  
  public final void setEngine(@Nullable XAEngine paramXAEngine)
  {
    this.engine = paramXAEngine;
  }
  
  protected final void setIView(@Nullable IView paramIView)
  {
    this.iView = paramIView;
  }
  
  public final void setLinkViews(@Nullable ArrayList<LinkView> paramArrayList)
  {
    this.linkViews = paramArrayList;
  }
  
  public final void setMonitor(@Nullable String[] paramArrayOfString)
  {
    this.monitor = paramArrayOfString;
  }
  
  public final void setState(@NotNull CurrentState paramCurrentState)
  {
    Intrinsics.checkParameterIsNotNull(paramCurrentState, "<set-?>");
    this.state = paramCurrentState;
  }
  
  public final void setStatus(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.status = paramString;
  }
  
  protected final void setTimeline(@Nullable XATimeline paramXATimeline)
  {
    this.timeline = paramXATimeline;
  }
  
  public final void setTp(@NotNull TimeProp paramTimeProp)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeProp, "<set-?>");
    this.tp = paramTimeProp;
  }
  
  public final void setType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.type = paramString;
  }
  
  public final void updateProgress(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "change");
    this.status = paramString;
    paramView = getLinkViews();
    if (paramView != null) {
      linkIndepenentProgressAnim(paramView).c();
    }
  }
  
  public void updateStatus(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "change");
    if (Intrinsics.areEqual(this.status, paramString)) {
      return;
    }
    this.status = paramString;
    notifyStatus(paramView, this.status);
    animCancel();
    paramString = getLinkViews();
    Object localObject = getStatusAnims(this.status);
    int j = ((ArrayList)localObject).size();
    int i = 0;
    while (i < j)
    {
      if (paramString != null) {
        linkViewAnim((ArrayList)localObject, paramString);
      }
      i += 1;
    }
    if (paramString != null) {
      linkIndepenentAnim(paramString);
    }
    if (paramString != null) {
      runViewAnim(paramString);
    }
    paramString = this.timeline;
    if (paramString != null)
    {
      localObject = this.iView;
      if (localObject != null)
      {
        localObject = ((IView)localObject).getDecor();
        if (localObject != null) {
          linkViewAnims((IDecorView)localObject, getAnimWithStatus(), paramString);
        }
      }
    }
    action(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.BaseTrigger
 * JD-Core Version:    0.7.0.1
 */