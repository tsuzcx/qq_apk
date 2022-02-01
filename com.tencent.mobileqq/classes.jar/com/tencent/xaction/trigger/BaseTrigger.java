package com.tencent.xaction.trigger;

import android.util.Log;
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
import com.tencent.xaction.api.data.LinkView;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.ReflectUtil;
import com.tencent.xaction.api.util.ReflectUtil.Companion;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.impl.AnimStateListener;
import com.tencent.xaction.impl.Expression;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.openapi.api.IStatusNotify;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.trigger.helper.CurrentState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/BaseTrigger;", "Lcom/tencent/xaction/api/ITrigger;", "Lcom/tencent/xaction/api/IStatus;", "()V", "anim", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/base/BaseAnim;", "Lkotlin/collections/ArrayList;", "getAnim", "()Ljava/util/ArrayList;", "setAnim", "(Ljava/util/ArrayList;)V", "animStateListenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/xaction/impl/AnimStateListener;", "Lkotlin/collections/HashMap;", "getAnimStateListenerMap", "()Ljava/util/HashMap;", "data", "Lcom/tencent/xaction/api/data/ViewData;", "getData", "()Lcom/tencent/xaction/api/data/ViewData;", "setData", "(Lcom/tencent/xaction/api/data/ViewData;)V", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "getEngine", "()Lcom/tencent/xaction/impl/XAEngine;", "setEngine", "(Lcom/tencent/xaction/impl/XAEngine;)V", "iView", "Lcom/tencent/xaction/api/IView;", "getIView", "()Lcom/tencent/xaction/api/IView;", "setIView", "(Lcom/tencent/xaction/api/IView;)V", "linkViews", "Lcom/tencent/xaction/api/data/LinkView;", "getLinkViews", "setLinkViews", "monitor", "", "", "getMonitor", "()[Ljava/lang/String;", "setMonitor", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "notify", "getNotify", "()Ljava/lang/String;", "state", "Lcom/tencent/xaction/trigger/helper/CurrentState;", "getState", "()Lcom/tencent/xaction/trigger/helper/CurrentState;", "status", "getStatus", "setStatus", "(Ljava/lang/String;)V", "timeline", "Lcom/tencent/xaction/impl/XATimeline;", "getTimeline", "()Lcom/tencent/xaction/impl/XATimeline;", "setTimeline", "(Lcom/tencent/xaction/impl/XATimeline;)V", "tp", "Lcom/tencent/xaction/api/data/TimeProp;", "getTp", "()Lcom/tencent/xaction/api/data/TimeProp;", "setTp", "(Lcom/tencent/xaction/api/data/TimeProp;)V", "type", "getType", "setType", "action", "", "view", "Landroid/view/View;", "addAnim", "baseAnim", "animCancel", "computeExps", "forWardActive", "", "link", "", "getStatusAnims", "isSameStatus", "s", "linkAnimStateListener", "linkIndepenentAnim", "listViews", "linkIndepenentProgressAnim", "linkSingleTagView", "it", "linkView", "linkViewAnim", "anims", "iview", "notifyState", "key", "value", "", "notifyStatus", "runViewAnim", "updateProgress", "change", "updateStatus", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public abstract class BaseTrigger
  implements IStatus, ITrigger
{
  @NotNull
  private ArrayList<BaseAnim> anim = new ArrayList();
  @NotNull
  private final transient HashMap<Integer, AnimStateListener> animStateListenerMap = new HashMap();
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
  private final transient CurrentState state = new CurrentState();
  @NotNull
  private String status = "";
  @Nullable
  private transient XATimeline timeline;
  @NotNull
  private TimeProp tp = new TimeProp();
  @NotNull
  private String type = "";
  
  private final void animCancel()
  {
    XATimeline localXATimeline = this.timeline;
    if (localXATimeline != null)
    {
      if (localXATimeline == null) {
        Intrinsics.throwNpe();
      }
      localXATimeline.e();
    }
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
  
  private final void linkAnimStateListener(LinkView paramLinkView, View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i = paramView.hashCode();
    if (this.animStateListenerMap.containsKey(Integer.valueOf(i))) {
      return;
    }
    paramLinkView = new BaseTrigger.linkAnimStateListener.listener.1(this, paramLinkView, paramView, i);
    ((Map)this.animStateListenerMap).put(Integer.valueOf(i), paramLinkView);
    paramView = this.timeline;
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    paramView.a((AnimStateListener)paramLinkView);
  }
  
  private final void linkIndepenentAnim(List<LinkView> paramList)
  {
    paramList = ((Iterable)paramList).iterator();
    break label143;
    label10:
    LinkView localLinkView;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localLinkView = (LinkView)paramList.next();
    } while ((localLinkView.getViews().size() == 0) || (localLinkView.getAnim() == null) || (!isSameStatus(localLinkView.getStatus())));
    Object localObject1;
    if (Intrinsics.areEqual(localLinkView.getFloat(), "window"))
    {
      localIterator1 = ((Iterable)localLinkView.getViews()).iterator();
      while (localIterator1.hasNext())
      {
        localObject1 = ((IView)localIterator1.next()).getDecor().getProxy();
        if (localObject1 != null) {
          linkAnimStateListener(localLinkView, (View)localObject1);
        }
      }
    }
    Iterator localIterator1 = ((Iterable)localLinkView.getAnim()).iterator();
    for (;;)
    {
      label143:
      if (!localIterator1.hasNext()) {
        break label10;
      }
      localObject1 = (BaseAnim)localIterator1.next();
      if ((localObject1 == null) || (!isSameStatus(((BaseAnim)localObject1).getStatus()))) {
        break;
      }
      Iterator localIterator2 = ((Iterable)localLinkView.getViews()).iterator();
      while (localIterator2.hasNext())
      {
        Object localObject2 = (IView)localIterator2.next();
        BaseAnim localBaseAnim = ((BaseAnim)localObject1).clone();
        localObject2 = ((IView)localObject2).getDecor().getProxy();
        Object localObject3 = this.timeline;
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        ((XATimeline)localObject3).a((ITimeline)localBaseAnim);
        computeExps(localBaseAnim);
        if (localObject2 != null)
        {
          localObject3 = this.engine;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          localBaseAnim.init((View)localObject2, (IXAEngine)localObject3);
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
    localObject2 = ((Iterable)paramList).iterator();
    break label206;
    label55:
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject3 = (LinkView)((Iterator)localObject2).next();
    } while ((((LinkView)localObject3).getViews().size() == 0) || (((LinkView)localObject3).getAnim() == null) || (!isSameStatus(((LinkView)localObject3).getStatus())) || (!forWardActive((LinkView)localObject3)));
    if (Intrinsics.areEqual(((LinkView)localObject3).getFloat(), "window"))
    {
      paramList = ((Iterable)((LinkView)localObject3).getViews()).iterator();
      while (paramList.hasNext())
      {
        localObject4 = ((IView)paramList.next()).getDecor().getProxy();
        if (localObject4 != null) {
          linkAnimStateListener((LinkView)localObject3, (View)localObject4);
        }
      }
    }
    Object localObject4 = ((Iterable)((LinkView)localObject3).getAnim()).iterator();
    for (;;)
    {
      label206:
      if (!((Iterator)localObject4).hasNext()) {
        break label55;
      }
      BaseAnim localBaseAnim = (BaseAnim)((Iterator)localObject4).next();
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("isForWardActive:");
      ((StringBuilder)localObject5).append(((LinkView)localObject3).isForWardActive());
      ((StringBuilder)localObject5).append(" forward:");
      if (localBaseAnim != null) {
        paramList = Boolean.valueOf(localBaseAnim.getForward());
      } else {
        paramList = null;
      }
      ((StringBuilder)localObject5).append(paramList);
      Log.v("BaseTrigger", ((StringBuilder)localObject5).toString());
      if ((localBaseAnim == null) || (localBaseAnim.getForward() != ((LinkView)localObject3).isForWardActive()) || (!isSameStatus(localBaseAnim.getStatus()))) {
        break;
      }
      paramList = ((Iterable)((LinkView)localObject3).getViews()).iterator();
      while (paramList.hasNext())
      {
        Object localObject6 = (IView)paramList.next();
        localObject5 = localBaseAnim.clone();
        localObject6 = ((IView)localObject6).getDecor().getProxy();
        ((XATimeline)localObject1).a((ITimeline)localObject5);
        computeExps((BaseAnim)localObject5);
        if (localObject6 != null)
        {
          XAEngine localXAEngine = this.engine;
          if (localXAEngine == null) {
            Intrinsics.throwNpe();
          }
          ((BaseAnim)localObject5).init((View)localObject6, (IXAEngine)localXAEngine);
        }
      }
    }
    return localObject1;
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
      paramLinkView = (View)paramString;
      if ((paramLinkView.getParent() instanceof ViewGroup))
      {
        localObject1 = paramLinkView.getParent();
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView(paramLinkView);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
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
      paramLinkView.init((IXAEngine)localObject1, (ViewGroup)localObject2);
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
        View localView = ((IView)localIterator2.next()).getDecor().getProxy();
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
        localObject2 = ((IView)localObject2).getDecor().getProxy();
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
  
  private final void runViewAnim(List<LinkView> paramList)
  {
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (LinkView)paramList.next();
      if ((((LinkView)localObject1).getViews().size() != 0) && (((LinkView)localObject1).getRunViewAnim()) && (!(Intrinsics.areEqual(((LinkView)localObject1).getStatus(), this.status) ^ true)))
      {
        Object localObject2;
        Object localObject3;
        if (Intrinsics.areEqual(((LinkView)localObject1).getFloat(), "window"))
        {
          localObject2 = ((Iterable)((LinkView)localObject1).getViews()).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((IView)((Iterator)localObject2).next()).getDecor().getProxy();
            if (localObject3 != null) {
              linkAnimStateListener((LinkView)localObject1, (View)localObject3);
            }
          }
        }
        localObject1 = ((Iterable)((LinkView)localObject1).getViews()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((IView)((Iterator)localObject1).next()).getDecor().getStyle();
          if (localObject2 != null)
          {
            localObject3 = ((ViewData)localObject2).getTl();
            if (localObject3 != null) {
              ((XATimeline)localObject3).c();
            }
            localObject2 = ((ViewData)localObject2).getTl();
            if (localObject2 != null) {
              ((XATimeline)localObject2).a();
            }
          }
        }
      }
    }
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
      localObject1 = ((XATimeline)localObject1).a();
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
      paramView.a();
    }
  }
  
  public void addAnim(@NotNull BaseAnim paramBaseAnim)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "baseAnim");
    this.anim.add(paramBaseAnim);
  }
  
  public final void computeExps(@NotNull BaseAnim paramBaseAnim)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "anim");
    Iterator localIterator = ((Map)paramBaseAnim.getExpressionList()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((Expression)localEntry.getValue()).a(this.state);
      ReflectUtil.a.a(paramBaseAnim, (String)localEntry.getKey(), ((Expression)localEntry.getValue()).a());
    }
  }
  
  public final boolean forWardActive(@NotNull LinkView paramLinkView)
  {
    Intrinsics.checkParameterIsNotNull(paramLinkView, "link");
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
        break label157;
      }
      bool1 = bool2;
      if (paramLinkView.getFy() < this.state.getMovedY()) {
        break label157;
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
        break label157;
      }
      bool1 = bool2;
      if (paramLinkView.getFy() > this.state.getMovedY()) {
        break label157;
      }
    }
    boolean bool1 = false;
    label157:
    if (bool1)
    {
      paramLinkView.setForWardActive(true ^ paramLinkView.isForWardActive());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isForWardActive:");
      localStringBuilder.append(paramLinkView.isForWardActive());
      localStringBuilder.append(" state.movedX:");
      localStringBuilder.append(this.state.getMovedX());
      localStringBuilder.append(" state.movedY:");
      localStringBuilder.append(this.state.getMovedY());
      Log.v("BaseTrigger", localStringBuilder.toString());
    }
    return bool1;
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
    if (this.linkViews != null)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.linkViews;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        LinkView localLinkView = (LinkView)localIterator.next();
        if (isSameStatus(localLinkView.getStatus()))
        {
          if (localLinkView.getViews().size() == 0)
          {
            Integer[] arrayOfInteger = localLinkView.getLId();
            int j = 0;
            int k;
            int i;
            if (arrayOfInteger != null)
            {
              k = arrayOfInteger.length;
              i = 0;
              while (i < k)
              {
                int m = ((Number)arrayOfInteger[i]).intValue();
                localObject = this.engine;
                if (localObject != null) {
                  localObject = ((XAEngine)localObject).findById(m);
                } else {
                  localObject = null;
                }
                if (localObject != null) {
                  localLinkView.getViews().add(localObject);
                }
                i += 1;
              }
            }
            localObject = localLinkView.getLTag();
            if (localObject != null)
            {
              k = localObject.length;
              i = j;
              while (i < k)
              {
                arrayOfInteger = localObject[i];
                Intrinsics.checkExpressionValueIsNotNull(localLinkView, "linkView");
                linkSingleTagView(arrayOfInteger, localLinkView);
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
    return null;
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
    return (Intrinsics.areEqual(paramString, "")) || (Intrinsics.areEqual(this.status, paramString));
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
    return false;
  }
  
  public final void setAnim(@NotNull ArrayList<BaseAnim> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.anim = paramArrayList;
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
      linkIndepenentProgressAnim(paramView).a();
    }
  }
  
  public void updateStatus(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "change");
    if ((Intrinsics.areEqual(this.status, paramString) ^ true))
    {
      this.status = paramString;
      notifyStatus(paramView, this.status);
      animCancel();
      paramString = getLinkViews();
      ArrayList localArrayList = getStatusAnims(this.status);
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if (paramString != null) {
          linkViewAnim(localArrayList, paramString);
        }
        i += 1;
      }
      if (paramString != null) {
        linkIndepenentAnim(paramString);
      }
      if (paramString != null) {
        runViewAnim(paramString);
      }
      action(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.BaseTrigger
 * JD-Core Version:    0.7.0.1
 */