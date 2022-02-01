package com.tencent.mobileqq.onlinestatus.constellation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/constellation/ConstellationLauncher;", "", "()V", "DEFAULT_CONSTELLATION", "", "REQUEST_CODE_BIRTHDAY", "launchMiniProgram", "", "activity", "Landroid/app/Activity;", "url", "", "launchScene", "launchSelectAge", "launchFrom", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ConstellationLauncher
{
  @JvmField
  public static final int a = 1040;
  public static final ConstellationLauncher a;
  @JvmField
  public static final int b = 0;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationConstellationLauncher = new ConstellationLauncher();
    jdField_a_of_type_Int = 1040;
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "launchFrom");
    Intent localIntent = new Intent((Context)paramActivity, AgeSelectionActivity.class);
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      int i = (int)ProfileCardUtil.a((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin()).lBirthday;
      if (QLog.isColorLevel()) {
        QLog.d("ConstellationLauncher", 2, new Object[] { "launchSelectAge: called. ", "{card.lBirthday}: " + i });
      }
      localIntent.putExtra("param_birthday", i);
      localIntent.putExtra("param_launch_from", paramString);
      paramActivity.startActivityForResult(localIntent, jdField_a_of_type_Int);
    }
  }
  
  public final void a(@NotNull Activity paramActivity, @Nullable String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (QLog.isColorLevel()) {
      QLog.d("ConstellationLauncher", 2, new Object[] { "launchMiniProgram: called. ", "url: " + paramString + "  launchScene: " + paramInt });
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)paramActivity, paramString, paramInt, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher
 * JD-Core Version:    0.7.0.1
 */