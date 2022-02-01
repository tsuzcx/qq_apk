package com.tencent.xaction.trigger;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IStatus;
import com.tencent.xaction.api.ITimeline;
import com.tencent.xaction.api.ITrigger;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.data.LinkView;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.AnimStateListener;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XATimeline;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/BaseTrigger;", "Lcom/tencent/xaction/api/ITrigger;", "Lcom/tencent/xaction/api/IStatus;", "()V", "anim", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/base/BaseAnim;", "Lkotlin/collections/ArrayList;", "getAnim", "()Ljava/util/ArrayList;", "setAnim", "(Ljava/util/ArrayList;)V", "animStateListenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/xaction/impl/AnimStateListener;", "Lkotlin/collections/HashMap;", "getAnimStateListenerMap", "()Ljava/util/HashMap;", "data", "Lcom/tencent/xaction/api/data/ViewData;", "getData", "()Lcom/tencent/xaction/api/data/ViewData;", "setData", "(Lcom/tencent/xaction/api/data/ViewData;)V", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "getEngine", "()Lcom/tencent/xaction/impl/XAEngine;", "setEngine", "(Lcom/tencent/xaction/impl/XAEngine;)V", "iView", "Lcom/tencent/xaction/api/IView;", "getIView", "()Lcom/tencent/xaction/api/IView;", "setIView", "(Lcom/tencent/xaction/api/IView;)V", "linkViews", "Lcom/tencent/xaction/api/data/LinkView;", "getLinkViews", "setLinkViews", "monitor", "", "", "getMonitor", "()[Ljava/lang/String;", "setMonitor", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "status", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "timeline", "Lcom/tencent/xaction/impl/XATimeline;", "getTimeline", "()Lcom/tencent/xaction/impl/XATimeline;", "setTimeline", "(Lcom/tencent/xaction/impl/XATimeline;)V", "tp", "Lcom/tencent/xaction/api/data/TimeProp;", "getTp", "()Lcom/tencent/xaction/api/data/TimeProp;", "setTp", "(Lcom/tencent/xaction/api/data/TimeProp;)V", "type", "getType", "setType", "action", "", "view", "Landroid/view/View;", "addAnim", "baseAnim", "animCancel", "", "getStatusAnims", "linkAnimStateListener", "link", "linkIndepenentAnim", "listViews", "linkViewAnim", "anims", "iview", "notifyState", "", "key", "value", "", "updateStatus", "change", "XActionEngine_release"}, k=1, mv={1, 1, 16})
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
  private String status = "";
  @Nullable
  private transient XATimeline timeline;
  @NotNull
  private TimeProp tp = new TimeProp();
  @NotNull
  private String type = "";
  
  private final void animCancel()
  {
    if (this.timeline != null)
    {
      XATimeline localXATimeline = this.timeline;
      if (localXATimeline == null) {
        Intrinsics.throwNpe();
      }
      localXATimeline.e();
    }
  }
  
  private final void linkAnimStateListener(LinkView paramLinkView, View paramView)
  {
    if (paramView == null) {}
    int i;
    do
    {
      return;
      i = paramView.hashCode();
    } while (this.animStateListenerMap.containsKey(Integer.valueOf(i)));
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
    while (paramList.hasNext())
    {
      LinkView localLinkView = (LinkView)paramList.next();
      if ((localLinkView.getViews().size() != 0) && (localLinkView.getAnim() != null))
      {
        Object localObject1;
        if (Intrinsics.areEqual(localLinkView.getFloat(), "window"))
        {
          localIterator1 = ((Iterable)localLinkView.getViews()).iterator();
          while (localIterator1.hasNext())
          {
            localObject1 = ((IView)localIterator1.next()).a().a();
            if (localObject1 != null) {
              linkAnimStateListener(localLinkView, (View)localObject1);
            }
          }
        }
        Iterator localIterator1 = ((Iterable)localLinkView.getAnim()).iterator();
        while (localIterator1.hasNext())
        {
          localObject1 = (BaseAnim)localIterator1.next();
          if (localObject1 != null) {
            if ((Intrinsics.areEqual(((BaseAnim)localObject1).getStatus(), "")) || (Intrinsics.areEqual(((BaseAnim)localObject1).getStatus(), this.status)))
            {
              Iterator localIterator2 = ((Iterable)localLinkView.getViews()).iterator();
              while (localIterator2.hasNext())
              {
                Object localObject2 = (IView)localIterator2.next();
                BaseAnim localBaseAnim = ((BaseAnim)localObject1).clone();
                localObject2 = ((IView)localObject2).a().a();
                Object localObject3 = this.timeline;
                if (localObject3 == null) {
                  Intrinsics.throwNpe();
                }
                ((XATimeline)localObject3).a((ITimeline)localBaseAnim);
                if (localObject2 != null)
                {
                  localObject3 = this.engine;
                  if (localObject3 == null) {
                    Intrinsics.throwNpe();
                  }
                  localBaseAnim.init((View)localObject2, (XAEngine)localObject3);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private final void linkViewAnim(ArrayList<BaseAnim> paramArrayList, List<LinkView> paramList)
  {
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      BaseAnim localBaseAnim1 = (BaseAnim)paramArrayList.next();
      Iterator localIterator1 = ((Iterable)paramList).iterator();
      label208:
      while (localIterator1.hasNext())
      {
        LinkView localLinkView = (LinkView)localIterator1.next();
        if ((localLinkView.getViews().size() != 0) && (localLinkView.getAnim() == null))
        {
          Iterator localIterator2 = ((Iterable)localLinkView.getViews()).iterator();
          for (;;)
          {
            if (!localIterator2.hasNext()) {
              break label208;
            }
            View localView = ((IView)localIterator2.next()).a().a();
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
            localObject = this.engine;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            localBaseAnim2.init(localView, (XAEngine)localObject);
          }
        }
      }
    }
  }
  
  public void action(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if (this.timeline != null)
    {
      localObject1 = this.timeline;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((XATimeline)localObject1).a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (!((Boolean)localObject1).booleanValue()) {}
    }
    else
    {
      return;
    }
    Object localObject1 = this.timeline;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    ((XATimeline)localObject1).a().set(this.tp);
    localObject1 = this.anim.iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseAnim)((Iterator)localObject1).next();
      if (!Intrinsics.areEqual(((BaseAnim)localObject2).getFloat(), "window")) {
        break label253;
      }
      i = 1;
    }
    label253:
    for (;;)
    {
      if ((Intrinsics.areEqual(((BaseAnim)localObject2).getStatus(), "")) || (Intrinsics.areEqual(((BaseAnim)localObject2).getStatus(), this.status)))
      {
        Object localObject3 = this.timeline;
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "an");
        ((XATimeline)localObject3).a((ITimeline)localObject2);
        localObject3 = this.engine;
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        ((BaseAnim)localObject2).init(paramView, (XAEngine)localObject3);
      }
      break;
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
      return;
    }
  }
  
  public void addAnim(@NotNull BaseAnim paramBaseAnim)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "baseAnim");
    this.anim.add(paramBaseAnim);
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
        if ((Intrinsics.areEqual(localLinkView.getStatus(), "")) || (Intrinsics.areEqual(this.status, localLinkView.getStatus())))
        {
          if (localLinkView.getViews().size() == 0)
          {
            Integer[] arrayOfInteger = localLinkView.getLId();
            if (arrayOfInteger != null)
            {
              int j = arrayOfInteger.length;
              int i = 0;
              if (i < j)
              {
                int k = ((Number)arrayOfInteger[i]).intValue();
                localObject = this.engine;
                if (localObject != null) {}
                for (localObject = ((XAEngine)localObject).findById(k);; localObject = null)
                {
                  if (localObject != null) {
                    localLinkView.getViews().add(localObject);
                  }
                  i += 1;
                  break;
                }
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
  public final String getStatus()
  {
    return this.status;
  }
  
  @NotNull
  public final ArrayList<BaseAnim> getStatusAnims(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "status");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.anim.iterator();
    while (localIterator.hasNext())
    {
      BaseAnim localBaseAnim = (BaseAnim)localIterator.next();
      if ((Intrinsics.areEqual(localBaseAnim.getStatus(), "")) || (Intrinsics.areEqual(localBaseAnim.getStatus(), paramString))) {
        localArrayList.add(localBaseAnim);
      }
    }
    return localArrayList;
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
  
  public void updateStatus(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "change");
    if ((Intrinsics.areEqual(this.status, paramString) ^ true))
    {
      this.status = paramString;
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
      action(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.trigger.BaseTrigger
 * JD-Core Version:    0.7.0.1
 */