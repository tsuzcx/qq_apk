package com.tencent.mobileqq.notification.modularize;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.biz.qqstory.notification.StoryMsgNotificationUtils;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.utils.ProcessUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime.Status;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "cachedNotifyIdMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "cancelAllPush", "", "isAppBackground", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "joinProcessesAsString", "processes", "", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "needShieldPush", "runAsync", "run", "Lkotlin/Function0;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class OnlineModulePushReceiverKt
{
  private static final ConcurrentHashMap<Integer, Integer> a = new ConcurrentHashMap();
  
  @NotNull
  public static final String a(@NotNull List<? extends ActivityManager.RunningAppProcessInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "processes");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("name: ");
      localStringBuilder.append(localRunningAppProcessInfo.processName);
      localStringBuilder.append(" imp: ");
      localStringBuilder.append(localRunningAppProcessInfo.importance);
      localStringBuilder.append(" pid: ");
      localStringBuilder.append(localRunningAppProcessInfo.pid);
      paramList.add(localStringBuilder.toString());
    }
    return CollectionsKt.joinToString$default((Iterable)paramList, null, null, null, 0, null, null, 63, null);
  }
  
  public static final void a()
  {
    Object localObject = a.keySet();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "cachedNotifyIdMap.keys");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localInteger, "it");
      localQQNotificationManager.cancel("OnlineModulePushReceiver", localInteger.intValue());
    }
    a.clear();
  }
  
  public static final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "run");
    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))
    {
      ThreadManagerV2.executeOnSubThread((Runnable)new OnlineModulePushReceiverKt.sam.java_lang_Runnable.0(paramFunction0));
      return;
    }
    paramFunction0.invoke();
  }
  
  public static final boolean a(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    if (Build.VERSION.SDK_INT > 19)
    {
      paramQQAppInterface = BaseApplication.context;
      Object localObject1 = paramQQAppInterface.getSystemService("activity");
      if (localObject1 != null)
      {
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "procList");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localObject3;
          if (ProcessUtil.a((Context)paramQQAppInterface, localRunningAppProcessInfo.processName)) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        paramQQAppInterface = (List)localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("foreProcesses: ");
          ((StringBuilder)localObject1).append(a(paramQQAppInterface));
          QLog.d("OnlineModulePushReceiver", 2, new Object[] { "isAppBackground: called. ", ((StringBuilder)localObject1).toString() });
        }
        return paramQQAppInterface.isEmpty();
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }
    boolean bool = StoryMsgNotificationUtils.a(paramQQAppInterface);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("foreground: ");
      paramQQAppInterface.append(bool);
      QLog.d("OnlineModulePushReceiver", 2, new Object[] { "isAppBackground: kitkat called. ", paramQQAppInterface.toString() });
    }
    return bool ^ true;
  }
  
  public static final boolean b(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    boolean bool3 = FriendsStatusUtil.a((Context)paramQQAppInterface.getApp());
    paramQQAppInterface = paramQQAppInterface.getRuntimeService(IOnlineStatusService.class);
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "app.getRuntimeService(IO…tatusService::class.java)");
    paramQQAppInterface = ((IOnlineStatusService)paramQQAppInterface).getOnlineStatus();
    AppRuntime.Status localStatus = AppRuntime.Status.dnd;
    boolean bool2 = true;
    boolean bool1;
    if (paramQQAppInterface == localStatus) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("canNotDisturb: ");
      paramQQAppInterface.append(bool3);
      paramQQAppInterface.append("  dndStatus: ");
      paramQQAppInterface.append(bool1);
      QLog.d("OnlineModulePushReceiver", 2, new Object[] { "needShieldPush: called. ", paramQQAppInterface.toString() });
    }
    if (!bool3)
    {
      if (bool1) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiverKt
 * JD-Core Version:    0.7.0.1
 */