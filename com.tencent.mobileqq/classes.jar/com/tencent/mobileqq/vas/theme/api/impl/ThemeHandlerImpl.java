package com.tencent.mobileqq.vas.theme.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.vas.theme.api.IThemeHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeHandlerImpl;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeHandler;", "()V", "isNeedAuth", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sendThemeAuth", "", "sendThemeVersionCheck", "themeId", "", "version", "isBackAuth", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ThemeHandlerImpl
  implements IThemeHandler
{
  @Nullable
  public AtomicBoolean isNeedAuth()
  {
    Object localObject = ThemeUtil.getCreateAppRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER);
      if (localObject != null)
      {
        localObject = (ThemeHandler)localObject;
        if (localObject != null) {
          return ((ThemeHandler)localObject).b;
        }
        return null;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.ThemeHandler");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void sendThemeAuth()
  {
    Object localObject = ThemeUtil.getCreateAppRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER);
      if (localObject != null)
      {
        ((ThemeHandler)localObject).a();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.ThemeHandler");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void sendThemeVersionCheck(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "themeId");
    Intrinsics.checkParameterIsNotNull(paramString2, "version");
    Object localObject = ThemeUtil.getCreateAppRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER);
      if (localObject != null)
      {
        ((ThemeHandler)localObject).a(paramString1, paramString2, paramBoolean);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.ThemeHandler");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.impl.ThemeHandlerImpl
 * JD-Core Version:    0.7.0.1
 */