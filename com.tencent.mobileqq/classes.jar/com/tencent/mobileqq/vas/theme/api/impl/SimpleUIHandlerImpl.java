package com.tencent.mobileqq.vas.theme.api.impl;

import android.os.Parcel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.theme.api.ISimpleUIHandler;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/impl/SimpleUIHandlerImpl;", "Lcom/tencent/mobileqq/vas/theme/api/ISimpleUIHandler;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "onPostThemeChanged", "", "sendSwitchAndSetSimpleUI", "", "bSwitch", "", "prefId", "", "bSwitchElsePref", "setReqTs", "ts", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SimpleUIHandlerImpl
  implements ISimpleUIHandler
{
  public SimpleUIHandlerImpl() {}
  
  public SimpleUIHandlerImpl(@NotNull Parcel paramParcel)
  {
    this();
  }
  
  public void onPostThemeChanged()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
      if (localObject != null)
      {
        ((SimpleUIHandler)localObject).c();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public long sendSwitchAndSetSimpleUI(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    boolean bool = StudyModeManager.a();
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
      if (localObject != null) {
        return ((SimpleUIHandler)localObject).a(paramBoolean1, paramInt, paramBoolean2, bool);
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void setReqTs(long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
      if (localObject != null)
      {
        ((SimpleUIHandler)localObject).a(paramLong);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.impl.SimpleUIHandlerImpl
 * JD-Core Version:    0.7.0.1
 */