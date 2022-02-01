package com.tencent.mobileqq.profilecard.bussiness.guide.action;

import android.app.Activity;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils.Companion;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/action/ProfileGuideAction;", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "activity", "Landroid/app/Activity;", "cardInfo", "Lcom/tencent/mobileqq/profile/ProfileCardInfo;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Lcom/tencent/mobileqq/profile/ProfileCardInfo;Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;)V", "jumpLabelEdit", "", "jumpPhotoEdit", "jumpProfileEdit", "jumpSignEdit", "onAction", "guideId", "", "guideType", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileGuideAction
{
  public static final ProfileGuideAction.Companion Companion = new ProfileGuideAction.Companion(null);
  @NotNull
  public static final String TAG = "ProfileGuideAction";
  private Activity activity;
  private QQAppInterface app;
  private ProfileCardInfo cardInfo;
  private IComponentCenter componentCenter;
  
  public ProfileGuideAction(@NotNull QQAppInterface paramQQAppInterface, @NotNull Activity paramActivity, @NotNull ProfileCardInfo paramProfileCardInfo, @NotNull IComponentCenter paramIComponentCenter)
  {
    this.app = paramQQAppInterface;
    this.activity = paramActivity;
    this.cardInfo = paramProfileCardInfo;
    this.componentCenter = paramIComponentCenter;
  }
  
  public final void jumpLabelEdit()
  {
    Object localObject = this.componentCenter.getComponent(1010);
    if ((localObject instanceof ProfilePersonalityLabelComponent))
    {
      localObject = (View)((ProfilePersonalityLabelComponent)localObject).getContainerView();
      if ((localObject instanceof ProfileCardFavorShowView))
      {
        localObject = ((ProfileCardFavorShowView)localObject).a(0);
        if ((localObject instanceof PersonalityLabelBoard)) {
          ((PersonalityLabelBoard)localObject).a(false);
        }
      }
    }
  }
  
  public final void jumpPhotoEdit()
  {
    PhotoWallView.a(this.activity, this.app.getCurrentUin(), true);
  }
  
  public final void jumpProfileEdit()
  {
    ProfileCardUtils.openProfileEdit(this.app, this.activity, this.cardInfo);
  }
  
  public final void jumpSignEdit()
  {
    Object localObject2 = this.cardInfo.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = RichStatusUtils.Companion;
      localObject2 = this.cardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "cardInfo.card");
      localObject1 = ((RichStatusUtils.Companion)localObject1).getRichStatus((Card)localObject2);
    }
    SignTextEditFragment.a(this.activity, (RichStatus)localObject1, null, null, -1);
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
      QLog.d("ProfileGuideAction", 0, (String)localObject);
    }
    if (ArraysKt.contains(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }, Integer.valueOf(paramInt1))) {
      jumpProfileEdit();
    }
    do
    {
      return;
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
    } while (paramInt1 != 9);
    jumpLabelEdit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.action.ProfileGuideAction
 * JD-Core Version:    0.7.0.1
 */