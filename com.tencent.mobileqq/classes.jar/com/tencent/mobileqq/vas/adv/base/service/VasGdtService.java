package com.tencent.mobileqq.vas.adv.base.service;

import android.content.Context;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtAdUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService;", "", "()V", "gdtCallback", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtCallback;", "getGdtCallback", "()Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtCallback;", "setGdtCallback", "(Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtCallback;)V", "listener", "Lcom/tencent/gdtad/aditem/GdtAdLoader$Listener;", "getListener", "()Lcom/tencent/gdtad/aditem/GdtAdLoader$Listener;", "listener$delegate", "Lkotlin/Lazy;", "createAdGetReq", "Ltencent/gdt/qq_ad_get$QQAdGet;", "createGdtAdLoadSession", "Lcom/tencent/gdtad/aditem/GdtAdLoader$Session;", "createParams", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtParams;", "loadAd", "", "loadGdtAd", "gdtSession", "loaderListenerRef", "Ljava/lang/ref/WeakReference;", "contextRef", "Landroid/content/Context;", "GdtCallback", "GdtParams", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public abstract class VasGdtService
{
  @Nullable
  private VasGdtService.GdtCallback a;
  private final Lazy b = LazyKt.lazy((Function0)new VasGdtService.listener.2(this));
  
  private final void a(GdtAdLoader.Session paramSession, WeakReference<GdtAdLoader.Listener> paramWeakReference, WeakReference<Context> paramWeakReference1)
  {
    new GdtAdLoader(paramSession, paramWeakReference).a(paramWeakReference1);
  }
  
  private final GdtAdLoader.Listener d()
  {
    return (GdtAdLoader.Listener)this.b.getValue();
  }
  
  private final GdtAdLoader.Session e()
  {
    GdtAdLoader.Session localSession = new GdtAdLoader.Session();
    localSession.a = f();
    return localSession;
  }
  
  private final qq_ad_get.QQAdGet f()
  {
    Object localObject1 = c();
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    Object localObject2 = (qq_ad_get.QQAdGet.ContextInfo)localQQAdGet.context_info.get();
    int i;
    if (localObject2 != null)
    {
      localObject3 = ((VasGdtService.GdtParams)localObject1).e();
      long l;
      if (localObject3 != null)
      {
        l = ((Number)localObject3).longValue();
        ((qq_ad_get.QQAdGet.ContextInfo)localObject2).public_id.set(l);
      }
      localObject3 = ((VasGdtService.GdtParams)localObject1).f();
      if (localObject3 != null)
      {
        l = ((Number)localObject3).longValue();
        ((qq_ad_get.QQAdGet.ContextInfo)localObject2).article_id.set(l);
      }
      localObject3 = ((VasGdtService.GdtParams)localObject1).g();
      if (localObject3 != null)
      {
        i = ((Number)localObject3).intValue();
        ((qq_ad_get.QQAdGet.ContextInfo)localObject2).tribe_tag.set(i);
      }
      localObject3 = ((VasGdtService.GdtParams)localObject1).g();
      if (localObject3 != null)
      {
        i = ((Number)localObject3).intValue();
        ((qq_ad_get.QQAdGet.ContextInfo)localObject2).tribe_id_tag.set(i);
      }
      localObject3 = ((VasGdtService.GdtParams)localObject1).h();
      if (localObject3 != null)
      {
        i = ((Number)localObject3).intValue();
        ((qq_ad_get.QQAdGet.ContextInfo)localObject2).source_from.set(i);
      }
    }
    localObject2 = (qq_ad_get.QQAdGet.UserInfo)localQQAdGet.user_info.get();
    if (localObject2 != null) {
      ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(((VasGdtService.GdtParams)localObject1).a());
    }
    localObject2 = ((VasGdtService.GdtParams)localObject1).j();
    if (localObject2 != null) {
      localQQAdGet.gdt_cookie.set((String)localObject2);
    }
    localObject2 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    Object localObject3 = ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).share_info;
    Object localObject4 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
    Object localObject5 = ((VasGdtService.GdtParams)localObject1).i();
    if (localObject5 != null)
    {
      i = ((Number)localObject5).intValue();
      ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject4).share_rate.set(i);
    }
    if ((((VasGdtService.GdtParams)localObject1).e() != null) && (((VasGdtService.GdtParams)localObject1).f() != null) && (((VasGdtService.GdtParams)localObject1).i() != null)) {
      ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject4).share_check.set(GdtAdUtil.a(((VasGdtService.GdtParams)localObject1).e().longValue(), ((VasGdtService.GdtParams)localObject1).f().longValue(), ((VasGdtService.GdtParams)localObject1).i().intValue()));
    }
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject3).set((MessageMicro)localObject4);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).deep_link_version.set(((VasGdtService.GdtParams)localObject1).d());
    localObject4 = (Iterable)((VasGdtService.GdtParams)localObject1).b();
    localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (String)((Iterator)localObject4).next();
      qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
      localPositionInfo.pos_id.set((String)localObject5);
      localPositionInfo.ad_count.set(((VasGdtService.GdtParams)localObject1).c());
      localPositionInfo.pos_ext.set((MessageMicro)localObject2);
      ((Collection)localObject3).add(localPositionInfo);
    }
    localObject1 = (List)localObject3;
    localQQAdGet.position_info.get().addAll((Collection)localObject1);
    return localQQAdGet;
  }
  
  @Nullable
  protected final VasGdtService.GdtCallback a()
  {
    return this.a;
  }
  
  protected final void a(@Nullable VasGdtService.GdtCallback paramGdtCallback)
  {
    this.a = paramGdtCallback;
  }
  
  public final void b()
  {
    a(e(), new WeakReference(d()), new WeakReference(VasAdvSupport.a.a().b()));
  }
  
  @NotNull
  protected abstract VasGdtService.GdtParams c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.service.VasGdtService
 * JD-Core Version:    0.7.0.1
 */