package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.content.Context;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/VBarrage;", "Lcom/tencent/viola/ui/baseComponent/VComponentContainer;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/VBarrageView;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/IBarrageControl;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageCallback;", "instance", "Lcom/tencent/viola/core/ViolaInstance;", "node", "Lcom/tencent/viola/ui/dom/DomObject;", "parent", "(Lcom/tencent/viola/core/ViolaInstance;Lcom/tencent/viola/ui/dom/DomObject;Lcom/tencent/viola/ui/baseComponent/VComponentContainer;)V", "barrageConfig", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageConfig;", "barrageController", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageController;", "destroy", "", "doWhenCompDestroy", "fetchBarrageList", "articleId", "", "rowKey", "", "puin", "fetchBarrageListFromServer", "initComponentHostView", "context", "Landroid/content/Context;", "onActivityDestroy", "onEventBarrageDidAppear", "onEventBarrageOnClick", "commentId", "parseBarrageConfig", "pause", "play", "removedByDiff", "removedByJs", "stop", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VBarrage
  extends VComponentContainer<VBarrageView>
  implements BarrageCallback, IBarrageControl
{
  public static final VBarrage.Companion Companion = new VBarrage.Companion(null);
  @NotNull
  public static final String EVENT_BARRAGE_DIDAPPEAR = "barrageDidAppear";
  @NotNull
  public static final String EVENT_BARRAGE_ONCLICK = "barrageOnClick";
  private final BarrageConfig barrageConfig = parseBarrageConfig();
  private BarrageController barrageController;
  
  public VBarrage(@NotNull ViolaInstance paramViolaInstance, @NotNull DomObject paramDomObject, @NotNull VComponentContainer<?> paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
    int i = this.barrageConfig.a();
    int j = DisplayUtil.a((Context)BaseApplicationImpl.getContext(), 24 + this.barrageConfig.b());
    paramViolaInstance = getDomObject();
    if ((paramViolaInstance instanceof BarrageDomObject)) {
      ((BarrageDomObject)paramViolaInstance).a(i * j);
    }
  }
  
  private final void doWhenCompDestroy()
  {
    BarrageController localBarrageController = this.barrageController;
    if (localBarrageController != null) {
      localBarrageController.e();
    }
    localBarrageController = this.barrageController;
    if (localBarrageController != null) {
      localBarrageController.f();
    }
  }
  
  private final void fetchBarrageListFromServer()
  {
    Object localObject2 = "";
    long l1 = 0L;
    long l3;
    Object localObject7;
    Object localObject6;
    try
    {
      localObject1 = getDomObject();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "domObject");
      if (((DomObject)localObject1).getAttributes() != null)
      {
        localObject1 = getDomObject();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "domObject");
        Iterator localIterator = ((DomObject)localObject1).getAttributes().entrySet().iterator();
        localObject1 = "";
        for (;;)
        {
          localObject3 = localObject2;
          long l2 = l1;
          Object localObject4 = localObject2;
          l3 = l1;
          localObject7 = localObject1;
          try
          {
            if (!localIterator.hasNext()) {
              break label634;
            }
            localObject3 = localObject2;
            l2 = l1;
            localObject4 = localIterator.next();
            if (localObject4 != null)
            {
              localObject3 = localObject2;
              l2 = l1;
              localObject7 = (Map.Entry)localObject4;
              localObject3 = localObject2;
              l2 = l1;
              if (Intrinsics.areEqual("src", (String)((Map.Entry)localObject7).getKey()))
              {
                localObject3 = localObject2;
                l2 = l1;
                Object localObject8 = ((Map.Entry)localObject7).getValue();
                if (localObject8 != null)
                {
                  localObject4 = localObject2;
                  localObject3 = localObject2;
                  l2 = l1;
                  if (((JSONObject)localObject8).has("rowkey"))
                  {
                    localObject3 = localObject2;
                    l2 = l1;
                    localObject4 = ((Map.Entry)localObject7).getValue();
                    if (localObject4 != null)
                    {
                      localObject3 = localObject2;
                      l2 = l1;
                      localObject4 = ((JSONObject)localObject4).getString("rowkey");
                      localObject3 = localObject2;
                      l2 = l1;
                      Intrinsics.checkExpressionValueIsNotNull(localObject4, "(entry.value as JSONObject).getString(\"rowkey\")");
                    }
                    else
                    {
                      localObject3 = localObject2;
                      l2 = l1;
                      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                  }
                  localObject3 = localObject4;
                  l2 = l1;
                  localObject2 = ((Map.Entry)localObject7).getValue();
                  if (localObject2 != null)
                  {
                    l3 = l1;
                    localObject3 = localObject4;
                    l2 = l1;
                    if (((JSONObject)localObject2).has("article_id"))
                    {
                      localObject3 = localObject4;
                      l2 = l1;
                      localObject2 = ((Map.Entry)localObject7).getValue();
                      if (localObject2 != null)
                      {
                        localObject3 = localObject4;
                        l2 = l1;
                        l3 = ((JSONObject)localObject2).getLong("article_id");
                      }
                      else
                      {
                        localObject3 = localObject4;
                        l2 = l1;
                        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                      }
                    }
                    localObject3 = localObject4;
                    l2 = l3;
                    localObject8 = ((Map.Entry)localObject7).getValue();
                    if (localObject8 != null)
                    {
                      localObject2 = localObject4;
                      l1 = l3;
                      localObject3 = localObject4;
                      l2 = l3;
                      if (((JSONObject)localObject8).has("puin"))
                      {
                        localObject3 = localObject4;
                        l2 = l3;
                        localObject2 = ((Map.Entry)localObject7).getValue();
                        if (localObject2 != null)
                        {
                          localObject3 = localObject4;
                          l2 = l3;
                          localObject2 = ((JSONObject)localObject2).getString("puin");
                          localObject3 = localObject4;
                          l2 = l3;
                          Intrinsics.checkExpressionValueIsNotNull(localObject2, "(entry.value as JSONObject).getString(\"puin\")");
                          localObject1 = localObject2;
                          localObject2 = localObject4;
                          l1 = l3;
                        }
                        else
                        {
                          localObject3 = localObject4;
                          l2 = l3;
                          throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                      }
                    }
                    else
                    {
                      localObject3 = localObject4;
                      l2 = l3;
                      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                  }
                  else
                  {
                    localObject3 = localObject4;
                    l2 = l1;
                    throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                  }
                }
                else
                {
                  localObject3 = localObject2;
                  l2 = l1;
                  throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                }
              }
            }
            else
            {
              localObject3 = localObject2;
              l2 = l1;
              throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map.Entry<kotlin.String, kotlin.Any>");
            }
          }
          catch (Exception localException1)
          {
            localObject2 = localObject3;
            l1 = l2;
          }
        }
      }
      localObject7 = "";
      Object localObject5 = localObject2;
      l3 = l1;
    }
    catch (Exception localException2)
    {
      Object localObject1 = "";
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("fetchBarrageListFromServer exception:");
      ((StringBuilder)localObject3).append(localException2.getLocalizedMessage());
      QLog.e("VComponent", 1, ((StringBuilder)localObject3).toString());
      localObject7 = localObject1;
      l3 = l1;
      localObject6 = localObject2;
    }
    label634:
    fetchBarrageList(l3, localObject6, (String)localObject7);
  }
  
  private final BarrageConfig parseBarrageConfig()
  {
    BarrageConfig localBarrageConfig = new BarrageConfig();
    for (;;)
    {
      try
      {
        Object localObject1 = getDomObject();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "domObject");
        if (((DomObject)localObject1).getAttributes() != null)
        {
          localObject1 = getDomObject();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "domObject");
          localObject1 = ((DomObject)localObject1).getAttributes().entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject2 = (Map.Entry)localObject2;
              if (!Intrinsics.areEqual("barrageConfig", (String)((Map.Entry)localObject2).getKey())) {
                continue;
              }
              Object localObject3 = ((Map.Entry)localObject2).getValue();
              if (localObject3 != null)
              {
                if (((JSONObject)localObject3).has("lineCount"))
                {
                  localObject3 = ((Map.Entry)localObject2).getValue();
                  if (localObject3 != null) {
                    localBarrageConfig.a(((JSONObject)localObject3).getInt("lineCount"));
                  } else {
                    throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                  }
                }
                localObject3 = ((Map.Entry)localObject2).getValue();
                if (localObject3 != null)
                {
                  if (((JSONObject)localObject3).has("barrageSpace"))
                  {
                    localObject3 = ((Map.Entry)localObject2).getValue();
                    if (localObject3 != null) {
                      localBarrageConfig.b(((JSONObject)localObject3).getInt("barrageSpace"));
                    } else {
                      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                  }
                  localObject3 = ((Map.Entry)localObject2).getValue();
                  if (localObject3 != null)
                  {
                    if (((JSONObject)localObject3).has("orderOfAscending"))
                    {
                      localObject3 = ((Map.Entry)localObject2).getValue();
                      if (localObject3 != null)
                      {
                        int i = ((JSONObject)localObject3).getInt("orderOfAscending");
                        localBarrageConfig.a(BarrageConfig.AscendingOrder.values()[i]);
                      }
                      else
                      {
                        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                      }
                    }
                    localObject3 = ((Map.Entry)localObject2).getValue();
                    if (localObject3 != null)
                    {
                      if (((JSONObject)localObject3).has("slideDuration"))
                      {
                        localObject3 = ((Map.Entry)localObject2).getValue();
                        if (localObject3 != null) {
                          localBarrageConfig.a((float)((JSONObject)localObject3).getDouble("slideDuration"));
                        } else {
                          throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                      }
                      localObject3 = ((Map.Entry)localObject2).getValue();
                      if (localObject3 != null)
                      {
                        if (((JSONObject)localObject3).has("loop"))
                        {
                          localObject3 = ((Map.Entry)localObject2).getValue();
                          if (localObject3 != null)
                          {
                            if (((JSONObject)localObject3).getInt("loop") != 1) {
                              break label656;
                            }
                            bool = true;
                            localBarrageConfig.a(bool);
                          }
                          else
                          {
                            throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                          }
                        }
                        localObject3 = ((Map.Entry)localObject2).getValue();
                        if (localObject3 != null)
                        {
                          if (!((JSONObject)localObject3).has("transparent")) {
                            continue;
                          }
                          localObject2 = ((Map.Entry)localObject2).getValue();
                          if (localObject2 != null)
                          {
                            localBarrageConfig.b((float)((JSONObject)localObject2).getDouble("transparent"));
                            continue;
                          }
                          throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                      }
                      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                  }
                  throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                }
                throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
              }
              throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map.Entry<kotlin.String, kotlin.Any>");
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseBarrageConfig exception:");
        ((StringBuilder)localObject2).append(localException.getLocalizedMessage());
        QLog.e("VComponent", 1, ((StringBuilder)localObject2).toString());
      }
      return localBarrageConfig;
      label656:
      boolean bool = false;
    }
  }
  
  public void destroy()
  {
    super.destroy();
    doWhenCompDestroy();
  }
  
  public void fetchBarrageList(long paramLong, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "puin");
    BarrageController localBarrageController = this.barrageController;
    if (localBarrageController != null) {
      localBarrageController.a(paramLong, paramString1, paramString2);
    }
  }
  
  @NotNull
  protected VBarrageView initComponentHostView(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = new VBarrageView(paramContext, null, 0, 6, null);
    this.barrageController = new BarrageController((BarrageView)paramContext, this.barrageConfig, null, 4, null);
    BarrageController localBarrageController = this.barrageController;
    if (localBarrageController != null) {
      localBarrageController.a((BarrageCallback)this);
    }
    fetchBarrageListFromServer();
    return paramContext;
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    doWhenCompDestroy();
  }
  
  public void onEventBarrageDidAppear()
  {
    fireEvent("barrageDidAppear", null);
  }
  
  public void onEventBarrageOnClick(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "commentId");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("commentId", paramString);
    fireEvent("barrageOnClick", localJSONObject);
  }
  
  @JSMethod
  public void pause()
  {
    BarrageController localBarrageController = this.barrageController;
    if (localBarrageController != null) {
      localBarrageController.d();
    }
  }
  
  @JSMethod
  public void play()
  {
    BarrageController localBarrageController = this.barrageController;
    if (localBarrageController != null) {
      localBarrageController.c();
    }
  }
  
  public void removedByDiff()
  {
    super.removedByDiff();
    doWhenCompDestroy();
  }
  
  public void removedByJs()
  {
    super.removedByJs();
    doWhenCompDestroy();
  }
  
  @JSMethod
  public void stop()
  {
    BarrageController localBarrageController = this.barrageController;
    if (localBarrageController != null) {
      localBarrageController.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.VBarrage
 * JD-Core Version:    0.7.0.1
 */