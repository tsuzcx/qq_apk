package com.tencent.mobileqq.kandian.biz.video.danmaku.model;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.video.danmaku.ReportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "callback", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel$Callback;", "(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel$Callback;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "cookie", "", "currentRowkey", "getCurrentRowkey", "()Ljava/lang/String;", "setCurrentRowkey", "(Ljava/lang/String;)V", "danmakuCount", "", "danmakuHandler", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuHandler;", "lastPlayPosition", "", "lastRequestPosition", "lastRequestTime", "needClearData", "", "nextTask", "Ljava/lang/Runnable;", "openText", "reportInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ReportInfo;", "Lkotlin/collections/ArrayList;", "requestInterval", "requesting", "getDebugUin", "needReloadData", "position", "onDestroy", "", "onGetPlayPosition", "onUpdate", "type", "isSuccess", "data", "", "reloadData", "rowkey", "startPosition", "requestData", "Callback", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuModel
  implements BusinessObserver
{
  public static final RIJDanmakuModel.Companion a = new RIJDanmakuModel.Companion(null);
  private final RIJDanmakuHandler b;
  private final Runnable c;
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private boolean i;
  private String j;
  private ArrayList<ReportInfo> k;
  private String l;
  private long m;
  @NotNull
  private String n;
  @NotNull
  private final QQAppInterface o;
  private RIJDanmakuModel.Callback p;
  
  public RIJDanmakuModel(@NotNull QQAppInterface paramQQAppInterface, @Nullable RIJDanmakuModel.Callback paramCallback)
  {
    this.o = paramQQAppInterface;
    this.p = paramCallback;
    paramQQAppInterface = this.o.getBusinessHandler(RIJDanmakuHandler.class.getName());
    if (paramQQAppInterface != null)
    {
      this.b = ((RIJDanmakuHandler)paramQQAppInterface);
      this.g = 30;
      this.j = "";
      this.k = new ArrayList();
      this.l = "";
      this.n = "";
      this.o.addObserver((BusinessObserver)this);
      this.c = ((Runnable)new RIJDanmakuModel.1(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuHandler");
  }
  
  private final void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestData: currentRowkey=");
      localStringBuilder.append(this.n);
      localStringBuilder.append(", currentRequestTime=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", requestInterval=");
      localStringBuilder.append(this.g);
      QLog.d("RIJDanmakuModel", 2, localStringBuilder.toString());
    }
    this.i = true;
    ThreadManager.excute((Runnable)new RIJDanmakuModel.requestData.1(this, paramString), 128, null, true);
  }
  
  private final boolean b(int paramInt)
  {
    return Math.abs(this.d - paramInt) > 3;
  }
  
  @NotNull
  public final String a()
  {
    return this.n;
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
    if (this.i) {
      return;
    }
    StringBuilder localStringBuilder;
    if (b(paramInt))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetPlayPosition: loadData position=");
        localStringBuilder.append(paramInt);
        QLog.d("RIJDanmakuModel", 2, localStringBuilder.toString());
      }
      a(this.n, paramInt);
      return;
    }
    if (paramInt >= this.f + this.g - 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetPlayPosition: nextTask position=");
        localStringBuilder.append(paramInt);
        QLog.d("RIJDanmakuModel", 2, localStringBuilder.toString());
      }
      this.e = paramInt;
      this.c.run();
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadData: rowkey=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", currentRowkey=");
      localStringBuilder.append(this.n);
      localStringBuilder.append(", startPosition=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", lastRequestTime=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", requestInterval=");
      localStringBuilder.append(this.g);
      QLog.d("RIJDanmakuModel", 2, localStringBuilder.toString());
    }
    int i1;
    if (((CharSequence)paramString).length() == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return;
    }
    if ((Intrinsics.areEqual(this.n, paramString)) && (!b(paramInt))) {
      return;
    }
    this.n = paramString;
    this.d = paramInt;
    this.e = paramInt;
    this.f = paramInt;
    this.h = true;
    this.m = 0L;
    this.g = 30;
    this.l = "";
    a(paramString);
  }
  
  public final void b()
  {
    this.p = ((RIJDanmakuModel.Callback)null);
    this.o.removeObserver((BusinessObserver)this);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, @Nullable Object paramObject)
  {
    if (paramObject != null)
    {
      Object localObject1 = (Bundle)paramObject;
      paramObject = ((Bundle)localObject1).getString("VALUE_REQUEST_ROWKEY");
      int i1 = ((Bundle)localObject1).getInt("VALUE_OBSERVER_TAG");
      paramInt = ((Bundle)localObject1).getInt("VALUE_REQUEST_BEGIN_TIME");
      if ((i1 == hashCode()) && (Intrinsics.areEqual(paramObject, this.n)) && (paramInt == this.f))
      {
        paramInt = 0;
        this.i = false;
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onUpdate: requestRowkey=");
          ((StringBuilder)localObject2).append(paramObject);
          ((StringBuilder)localObject2).append(", observer=");
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append(", hascode=");
          ((StringBuilder)localObject2).append(hashCode());
          ((StringBuilder)localObject2).append(", needClearData=");
          ((StringBuilder)localObject2).append(this.h);
          QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject2).toString());
        }
        if (paramBoolean)
        {
          paramObject = ((Bundle)localObject1).getString("VALUE_COOKIE");
          if (paramObject == null) {
            paramObject = "";
          }
          this.j = paramObject;
          paramObject = ((Bundle)localObject1).getString("VALUE_OPEN_TEXT");
          if (paramObject == null) {
            paramObject = "";
          }
          long l1 = ((Bundle)localObject1).getLong("VALUE_DANMAKU_COUNT");
          i1 = ((Bundle)localObject1).getInt("VALUE_PULL_INTERVAL");
          paramBoolean = ((Bundle)localObject1).getBoolean("VALUE_IS_FORBID");
          localObject2 = ((Bundle)localObject1).getParcelableArrayList("VALUE_DANMAKU_LIST");
          localObject1 = ((Bundle)localObject1).getParcelableArrayList("VALUE_REPORT_INFO_LIST");
          if ((localObject1 != null) && ((((Collection)localObject1).isEmpty() ^ true) == true)) {
            this.k = ((ArrayList)localObject1);
          }
          if (((CharSequence)paramObject).length() > 0) {
            paramInt = 1;
          }
          if (paramInt != 0) {
            this.l = paramObject;
          }
          if (l1 > 0L) {
            this.m = l1;
          }
          if (i1 > 0) {
            this.g = i1;
          }
          if (localObject2 != null)
          {
            paramObject = this.p;
            if (paramObject != null) {
              paramObject.a((List)localObject2, this.k, paramBoolean, this.h, this.l, this.m);
            }
          }
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.os.Bundle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuModel
 * JD-Core Version:    0.7.0.1
 */