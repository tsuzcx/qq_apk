package com.tencent.mobileqq.profilecard.bussiness.guide.action;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileGuideApi;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/action/ProfileGuideAction;", "", "app", "Lcom/tencent/common/app/AppInterface;", "activity", "Landroid/app/Activity;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;)V", "jumpLabelEdit", "", "jumpPhotoEdit", "jumpProfileEdit", "jumpSignEdit", "onAction", "guideId", "", "guideType", "Companion", "profilecard-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileGuideAction
{
  public static final ProfileGuideAction.Companion Companion = new ProfileGuideAction.Companion(null);
  @NotNull
  public static final String TAG = "ProfileGuideAction";
  private Activity activity;
  private AppInterface app;
  private ProfileCardInfo cardInfo;
  private IComponentCenter componentCenter;
  
  public ProfileGuideAction(@NotNull AppInterface paramAppInterface, @NotNull Activity paramActivity, @NotNull ProfileCardInfo paramProfileCardInfo, @NotNull IComponentCenter paramIComponentCenter)
  {
    this.app = paramAppInterface;
    this.activity = paramActivity;
    this.cardInfo = paramProfileCardInfo;
    this.componentCenter = paramIComponentCenter;
  }
  
  public final void jumpLabelEdit()
  {
    QRouteApi localQRouteApi = QRoute.api(IProfileGuideApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IProfileGuideApi::class.java)");
    ((IProfileGuideApi)localQRouteApi).jumpLabelEdit(this.componentCenter);
  }
  
  public final void jumpPhotoEdit()
  {
    QRouteApi localQRouteApi = QRoute.api(IProfileGuideApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IProfileGuideApi::class.java)");
    ((IProfileGuideApi)localQRouteApi).jumpPhotoEdit(this.activity, this.app.getCurrentUin(), true);
  }
  
  public final void jumpProfileEdit()
  {
    QRouteApi localQRouteApi = QRoute.api(IProfileGuideApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IProfileGuideApi::class.java)");
    ((IProfileGuideApi)localQRouteApi).jumpProfileEdit(this.app, this.activity, this.cardInfo);
  }
  
  public final void jumpSignEdit()
  {
    QRouteApi localQRouteApi = QRoute.api(IProfileGuideApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IProfileGuideApi::class.java)");
    ((IProfileGuideApi)localQRouteApi).jumpSignEdit(this.activity, this.cardInfo);
  }
  
  public final void onAction(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = StringCompanionObject.INSTANCE;
      localObject = new Object[2];
      localObject[0] = Integer.valueOf(paramInt1);
      localObject[1] = Integer.valueOf(paramInt2);
      localObject = String.format("onAction guideId=%s guideType=%s", Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      QLog.d("ProfileGuideAction", 2, (String)localObject);
    }
    if (ArraysKt.contains(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }, Integer.valueOf(paramInt1)))
    {
      jumpProfileEdit();
      return;
    }
    if (paramInt1 == 7)
    {
      jumpSignEdit();
      return;
    }
    if (paramInt1 == 8)
    {
      jumpPhotoEdit();
      return;
    }
    if (paramInt1 == 9) {
      jumpLabelEdit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.action.ProfileGuideAction
 * JD-Core Version:    0.7.0.1
 */