package com.tencent.timi.game.room.impl.operation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.yolo.esports.room.api.IRoomOperation;
import com.yolo.esports.room.api.IRoomOperationService;
import com.yolo.esports.room.api.IRoomOperationService.OnYoloRoomSystemMsgListener;
import com.yolo.esports.room.api.OperationData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltrpc.yes.common.YoloRoomOuterClass.YoloRoomRotateMessage;>;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRotateMessage;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/room/impl/operation/RoomOperationService;", "Lcom/yolo/esports/room/api/IRoomOperationService;", "()V", "onYoloRoomSystemMsgListenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/yolo/esports/room/api/IRoomOperationService$OnYoloRoomSystemMsgListener;", "operationBundleList", "", "Lcom/tencent/timi/game/room/impl/operation/OperationBundle;", "tmpYoloRoomRotateMsgList", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomRotateMessage;", "clearYoloRoomRotateMsg", "", "roomId", "", "createView", "Landroid/view/View;", "viewName", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "delegateRoomOperation", "owner", "Landroidx/lifecycle/LifecycleOwner;", "roomOperation", "Lcom/yolo/esports/room/api/IRoomOperation;", "getYoloRoomRotateMsgList", "", "init", "interceptYoloRoomRotateMsg", "msg", "interceptYoloRoomRotateMsgList", "msgList", "isNotSupportMsg", "", "provideViews", "registerOnYoloRoomSystemMsgListener", "onYoloRoomSystemMsgListener", "serviceDestroy", "unregisterOnYoloRoomSystemMsgListener", "getOrCreate", "removeByRoomId", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class RoomOperationService
  implements IRoomOperationService
{
  public static final RoomOperationService.Companion a = new RoomOperationService.Companion(null);
  private final List<OperationBundle> b = (List)new ArrayList();
  private final List<YoloRoomOuterClass.YoloRoomRotateMessage> c = (List)new ArrayList();
  private final CopyOnWriteArrayList<IRoomOperationService.OnYoloRoomSystemMsgListener> d = new CopyOnWriteArrayList();
  
  private final OperationBundle a(@NotNull List<OperationBundle> paramList, long paramLong)
  {
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      int i;
      if (((OperationBundle)localObject).a() == paramLong) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label63;
      }
    }
    Object localObject = null;
    label63:
    localObject = (OperationBundle)localObject;
    if (localObject != null) {
      return localObject;
    }
    localObject = new OperationBundle(paramLong, null, (List)new ArrayList());
    paramList.add(localObject);
    return localObject;
  }
  
  private final boolean a(YoloRoomOuterClass.YoloRoomRotateMessage paramYoloRoomRotateMessage)
  {
    return (paramYoloRoomRotateMessage.message_type.get() != 5) && (paramYoloRoomRotateMessage.message_type.get() != 1);
  }
  
  private final void b(@NotNull List<OperationBundle> paramList, long paramLong)
  {
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      int i;
      if (((OperationBundle)localObject).a() == paramLong) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label63;
      }
    }
    Object localObject = null;
    label63:
    localObject = (OperationBundle)localObject;
    if (localObject != null) {
      paramList.remove(localObject);
    }
  }
  
  @Nullable
  public View a(@Nullable String paramString, @NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return null;
  }
  
  @NotNull
  public List<String> a()
  {
    return CollectionsKt.mutableListOf(new String[] { "com.yolo.esports.room.api.RoomOperationView" });
  }
  
  public void a(long paramLong)
  {
    b(this.b, paramLong);
    this.c.clear();
  }
  
  public void a(long paramLong, @NotNull List<YoloRoomOuterClass.YoloRoomRotateMessage> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "msgList");
    paramList = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if ((a((YoloRoomOuterClass.YoloRoomRotateMessage)localObject3) ^ true)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (List)localObject1;
    this.c.addAll((Collection)new ArrayList((Collection)localObject1));
    localObject2 = ((Iterable)this.d).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((IRoomOperationService.OnYoloRoomSystemMsgListener)((Iterator)localObject2).next()).a((List)localObject1);
    }
    localObject1 = a(this.b, paramLong);
    Object localObject4;
    if (((OperationBundle)localObject1).b() == null)
    {
      localObject2 = ((OperationBundle)localObject1).c();
      localObject3 = (Collection)new ArrayList();
      localObject4 = paramList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (YoloRoomOuterClass.YoloRoomRotateMessage)((Iterator)localObject4).next();
        paramList = (List<YoloRoomOuterClass.YoloRoomRotateMessage>)localObject1;
        if (a((YoloRoomOuterClass.YoloRoomRotateMessage)localObject1)) {
          paramList = null;
        }
        if (paramList != null) {
          ((Collection)localObject3).add(paramList);
        }
      }
      ((List)localObject2).addAll((Collection)localObject3);
      return;
    }
    localObject1 = ((OperationBundle)localObject1).b();
    if (localObject1 != null)
    {
      localObject2 = (Collection)new ArrayList();
      localObject3 = paramList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        paramList = (YoloRoomOuterClass.YoloRoomRotateMessage)((Iterator)localObject3).next();
        if (a(paramList))
        {
          paramList = null;
        }
        else
        {
          int i = paramList.message_type.get();
          localObject4 = paramList.message_tpl.get();
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "it.message_tpl.get()");
          List localList = paramList.label.get();
          Intrinsics.checkExpressionValueIsNotNull(localList, "it.label.get()");
          paramList = new OperationData(i, (String)localObject4, localList, paramList.message_time.get(), false, 16, null);
        }
        if (paramList != null) {
          ((Collection)localObject2).add(paramList);
        }
      }
      ((IRoomOperation)localObject1).a((List)localObject2);
    }
  }
  
  public void a(@Nullable Context paramContext) {}
  
  @NotNull
  public List<YoloRoomOuterClass.YoloRoomRotateMessage> b()
  {
    return this.c;
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.operation.RoomOperationService
 * JD-Core Version:    0.7.0.1
 */