package com.tencent.mobileqq.vas.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/TroopGiftPAGAnimationController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "mComboView", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftComboView;", "mContext", "mGiftView", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "mLayout", "Landroid/widget/FrameLayout;", "mStopBtn", "Landroid/widget/ImageView;", "senderAvatarCallback", "com/tencent/mobileqq/vas/troopgift/TroopGiftPAGAnimationController$senderAvatarCallback$1", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftPAGAnimationController$senderAvatarCallback$1;", "times", "", "getPAGLayout", "loadAvatars", "", "giftData", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;", "playAnimation", "closeAnimation", "Lkotlin/Function0;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopGiftPAGAnimationController
{
  private int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final TroopGiftComboView jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView;
  private final TroopGiftPAGAnimationController.senderAvatarCallback.1 jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController$senderAvatarCallback$1;
  private final VasPagView jdField_a_of_type_ComTencentMobileqqVasUiVasPagView;
  private final String jdField_a_of_type_JavaLangString = "TroopGiftPAGAnimationController";
  
  public TroopGiftPAGAnimationController(@NotNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131560853, null, false);
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramContext);
    paramContext = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365009);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mLayout.findViewById(R.id.combo_pag)");
    this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView = ((TroopGiftComboView)paramContext);
    paramContext = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367951);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mLayout.findViewById(R.id.gift_pag)");
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView = ((VasPagView)paramContext);
    paramContext = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380031);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mLayout.findViewById(R.i…end_gift_animation_close)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView.b();
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.b();
    this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController$senderAvatarCallback$1 = new TroopGiftPAGAnimationController.senderAvatarCallback.1(this);
  }
  
  @NotNull
  public final FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public final void a(@NotNull TroopGiftData paramTroopGiftData)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "loadAvatars");
    }
    Object localObject1 = ImageUtil.c();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "defAvatar");
    ((TroopGiftComboView)localObject2).setAvatars((Bitmap)localObject1, (Bitmap)localObject1);
    localObject2 = FaceDrawable.getDefaultDrawable(1, 3);
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return;
    }
    if (Intrinsics.areEqual(paramTroopGiftData.giftData.dataForClient.sendUin, "80000000"))
    {
      localObject1 = paramTroopGiftData.giftData.dataForClient.anonymousPortraitIdx;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "giftData.giftData.dataFo…ient.anonymousPortraitIdx");
      localObject1 = AnonymousChatHelper.a(Integer.parseInt((String)localObject1));
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843891);
      Intrinsics.checkExpressionValueIsNotNull(localDrawable, "mContext.getResources().…mous_default_header_icon)");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localObject1 = (Drawable)URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
      this.jdField_a_of_type_Int = 0;
      if ((localObject1 instanceof FaceDrawable)) {
        break label308;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "senderDrawable");
      ((Drawable)localObject1).setCallback((Drawable.Callback)this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController$senderAvatarCallback$1);
    }
    for (;;)
    {
      localObject2 = FaceDrawable.getFaceDrawable((AppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, 1, paramTroopGiftData.giftData.dataForClient.recvUin, 3, (Drawable)localObject2, (Drawable)localObject2, (FaceDrawable.OnLoadingStateChangeListener)new TroopGiftPAGAnimationController.loadAvatars.receiverDrawable.1(this, paramTroopGiftData, (Drawable)localObject2));
      paramTroopGiftData = this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView;
      localObject1 = TroopUtils.a((Drawable)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "TroopUtils.headDrawableToBitamp(senderDrawable)");
      localObject2 = TroopUtils.a((Drawable)localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "TroopUtils.headDrawableToBitamp(receiverDrawable)");
      paramTroopGiftData.setAvatars((Bitmap)localObject1, (Bitmap)localObject2);
      return;
      localObject1 = (Drawable)FaceDrawable.getFaceDrawable((AppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, 1, paramTroopGiftData.giftData.dataForClient.sendUin, 3, (Drawable)localObject2, (Drawable)localObject2, (FaceDrawable.OnLoadingStateChangeListener)new TroopGiftPAGAnimationController.loadAvatars.senderDrawable.1(this, paramTroopGiftData, (Drawable)localObject2));
      break;
      label308:
      ((FaceDrawable)localObject1).setCallback((Drawable.Callback)null);
    }
  }
  
  public final void a(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "closeAnimation");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "playAnimation");
    }
    Object localObject = paramTroopGiftData.giftData.dataForClient.sendCount;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "giftData.giftData.dataForClient.sendCount");
    int i = Integer.parseInt((String)localObject);
    localObject = new String[2];
    localObject[0] = paramTroopGiftData.giftData.dataForClient.continueAnimationAnd;
    localObject[1] = paramTroopGiftData.giftData.dataForClient.giftResourceAnd;
    File[] arrayOfFile = TroopGiftResManager.a.a((String[])localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)new TroopGiftPAGAnimationController.playAnimation.1(paramFunction0));
    if (arrayOfFile[0].exists())
    {
      String str = arrayOfFile[0].getPath();
      this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView.setPAGResource(str + "/combo/combo.pag", str + "/combo/combo.ttf");
      this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView.a(i);
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, StringsKt.trimIndent("\n                        giftID: " + paramTroopGiftData.giftData.dataForClient.giftId + " \n                        file url: " + localObject[0] + "  \n                        file path: " + str + " \n                        file MD5: " + MD5Utils.encodeFileHexStr(new StringBuilder().append(str).append("/combo/combo.pag").toString()) + " \n                        "));
      }
    }
    if (arrayOfFile[1].exists()) {
      this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.a((Function1)new TroopGiftPAGAnimationController.playAnimation.2(arrayOfFile));
    }
    a(paramTroopGiftData);
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.a((Function1)new TroopGiftPAGAnimationController.playAnimation.3(this, paramFunction0));
    if ((!arrayOfFile[0].exists()) && (!arrayOfFile[1].exists())) {
      paramFunction0.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController
 * JD-Core Version:    0.7.0.1
 */