package com.tencent.mobileqq.kandian.biz.video.danmaku.model;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "callback", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel$Callback;", "(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel$Callback;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "currentRowkey", "", "getCurrentRowkey", "()Ljava/lang/String;", "setCurrentRowkey", "(Ljava/lang/String;)V", "danmakuHandler", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuHandler;", "lastPlayPosition", "", "lastRequestPosition", "lastRequestTime", "needClearData", "", "nextTask", "Ljava/lang/Runnable;", "requestInterval", "requesting", "getDebugUin", "needReloadData", "position", "onDestroy", "", "onGetPlayPosition", "onUpdate", "type", "isSuccess", "data", "", "reloadData", "rowkey", "startPosition", "requestData", "Callback", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuModel
  implements BusinessObserver
{
  public static final RIJDanmakuModel.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final RIJDanmakuHandler jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuHandler;
  private RIJDanmakuModel.Callback jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel$Callback;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel$Companion = new RIJDanmakuModel.Companion(null);
  }
  
  public RIJDanmakuModel(@NotNull QQAppInterface paramQQAppInterface, @Nullable RIJDanmakuModel.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel$Callback = paramCallback;
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(RIJDanmakuHandler.class.getName());
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuHandler = ((RIJDanmakuHandler)paramQQAppInterface);
      this.d = 30;
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)this);
      this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new RIJDanmakuModel.1(this));
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
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", currentRequestTime=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", requestInterval=");
      localStringBuilder.append(this.d);
      QLog.d("RIJDanmakuModel", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Boolean = true;
    ThreadManager.excute((Runnable)new RIJDanmakuModel.requestData.1(this, paramString), 128, null, true);
  }
  
  private final boolean a(int paramInt)
  {
    return Math.abs(this.jdField_a_of_type_Int - paramInt) > 3;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel$Callback = ((RIJDanmakuModel.Callback)null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this);
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder;
    if (a(paramInt))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetPlayPosition: loadData position=");
        localStringBuilder.append(paramInt);
        QLog.d("RIJDanmakuModel", 2, localStringBuilder.toString());
      }
      a(this.jdField_a_of_type_JavaLangString, paramInt);
      return;
    }
    if (paramInt >= this.c + this.d - 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetPlayPosition: nextTask position=");
        localStringBuilder.append(paramInt);
        QLog.d("RIJDanmakuModel", 2, localStringBuilder.toString());
      }
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangRunnable.run();
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
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", startPosition=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", lastRequestTime=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", requestInterval=");
      localStringBuilder.append(this.d);
      QLog.d("RIJDanmakuModel", 2, localStringBuilder.toString());
    }
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    if ((Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramString)) && (!a(paramInt))) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramInt;
    this.jdField_a_of_type_Boolean = true;
    a(paramString);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, @Nullable Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (Bundle)paramObject;
      Object localObject1 = paramObject.getString("VALUE_REQUEST_ROWKEY");
      paramInt = paramObject.getInt("VALUE_OBSERVER_TAG");
      int i = paramObject.getInt("VALUE_REQUEST_BEGIN_TIME");
      if ((paramInt == hashCode()) && (Intrinsics.areEqual(localObject1, this.jdField_a_of_type_JavaLangString)) && (i == this.c))
      {
        this.jdField_b_of_type_Boolean = false;
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onUpdate: requestRowkey=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", observer=");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(", hascode=");
          ((StringBuilder)localObject2).append(hashCode());
          ((StringBuilder)localObject2).append(", needClearData=");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
          QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject2).toString());
        }
        if (paramBoolean)
        {
          paramInt = paramObject.getInt("VALUE_PULL_INTERVAL");
          paramBoolean = paramObject.getBoolean("VALUE_IS_FORBID");
          localObject1 = paramObject.getParcelableArrayList("VALUE_DANMAKU_LIST");
          paramObject = paramObject.getParcelableArrayList("VALUE_REPORT_INFO_LIST");
          if (paramInt > 0) {
            this.d = paramInt;
          }
          if (localObject1 != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuModelRIJDanmakuModel$Callback;
            if (localObject2 != null)
            {
              localObject1 = (List)localObject1;
              Intrinsics.checkExpressionValueIsNotNull(paramObject, "reportInfoList");
              ((RIJDanmakuModel.Callback)localObject2).a((List)localObject1, paramObject, paramBoolean, this.jdField_a_of_type_Boolean);
            }
          }
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.os.Bundle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuModel
 * JD-Core Version:    0.7.0.1
 */