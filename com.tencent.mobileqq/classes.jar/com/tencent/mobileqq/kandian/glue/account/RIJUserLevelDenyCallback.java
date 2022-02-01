package com.tencent.mobileqq.kandian.glue.account;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog.DialogClick;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog.DialogSettingInfo;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule.UserLevelDenyCallback;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/account/RIJUserLevelDenyCallback;", "Lcom/tencent/mobileqq/kandian/repo/account/RIJUserLevelModule$UserLevelDenyCallback;", "()V", "onUserLevelDeny", "", "context", "Landroid/content/Context;", "userLevelInfo", "Lcom/tencent/mobileqq/kandian/repo/account/UserLevelInfo;", "showErrorDialog", "updateDialogText", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUserLevelDenyCallback
  implements RIJUserLevelModule.UserLevelDenyCallback
{
  private final void b(Context paramContext, UserLevelInfo paramUserLevelInfo)
  {
    c(paramContext, paramUserLevelInfo);
    RIJUserLevelDialog.DialogSettingInfo localDialogSettingInfo = new RIJUserLevelDialog.DialogSettingInfo();
    localDialogSettingInfo.a = paramUserLevelInfo.errorDialogTitle;
    localDialogSettingInfo.c = paramUserLevelInfo.errorDialogContent;
    localDialogSettingInfo.j = ((RIJUserLevelDialog.DialogClick)new RIJUserLevelDenyCallback.showErrorDialog.1(paramContext, paramUserLevelInfo));
    ReadInJoyUtils.a(paramContext, localDialogSettingInfo);
  }
  
  private final void c(Context paramContext, UserLevelInfo paramUserLevelInfo)
  {
    String str2 = paramContext.getString(2131897919);
    int i = paramUserLevelInfo.currentOpType;
    String str1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          str1 = paramContext.getString(2131897948);
          Intrinsics.checkExpressionValueIsNotNull(str1, "context.getString(R.stri…joy_window_allow_publish)");
        }
        else
        {
          str2 = paramContext.getString(2131897918);
          str1 = paramContext.getString(2131897947);
          Intrinsics.checkExpressionValueIsNotNull(str1, "context.getString(R.stri…dinjoy_window_allow_like)");
        }
      }
      else
      {
        str1 = paramContext.getString(2131897945);
        Intrinsics.checkExpressionValueIsNotNull(str1, "context.getString(R.stri…adinjoy_window_allow_biu)");
      }
    }
    else
    {
      str1 = paramContext.getString(2131897946);
      Intrinsics.checkExpressionValueIsNotNull(str1, "context.getString(R.stri…joy_window_allow_comment)");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getString(2131897903));
    localStringBuilder.append(paramUserLevelInfo.level);
    localStringBuilder.append(str1);
    paramUserLevelInfo.errorDialogContent = localStringBuilder.toString();
    paramUserLevelInfo.errorDialogTitle = str2;
  }
  
  public void a(@NotNull Context paramContext, @NotNull UserLevelInfo paramUserLevelInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramUserLevelInfo, "userLevelInfo");
    b(paramContext, paramUserLevelInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.account.RIJUserLevelDenyCallback
 * JD-Core Version:    0.7.0.1
 */