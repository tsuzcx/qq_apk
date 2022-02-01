package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.upload.IQQLiveModuleFileUpload;
import com.tencent.mobileqq.qqlive.callback.upload.IQQLiveUploadBitmapCallback;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.avatar.iPicCtrl;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/ChooseCoverController;", "Ljava/util/Observer;", "Lcom/tencent/mobileqq/troop/avatar/iPicCtrl;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "mCurShowItemIndex", "", "mMenuItems", "", "", "[Ljava/lang/String;", "mRoomID", "", "mType", "", "upLoadUrl", "getUpLoadUrl", "()Ljava/lang/String;", "setUpLoadUrl", "(Ljava/lang/String;)V", "uploadPhotoUri", "Landroid/net/Uri;", "getUploadPhotoUri", "()Landroid/net/Uri;", "setUploadPhotoUri", "(Landroid/net/Uri;)V", "enterSnapshot", "", "getAvatar", "Lcom/tencent/mobileqq/troop/avatar/AvatarInfo;", "getCoverList", "", "onDeleteItem", "pos", "onGetTroopAuthSubmitTime", "submitTime", "onItemSelect", "onPicPicked", "", "path", "clipInfo", "onPickPic", "onSnapShotBack", "onUpdateTroopAvatarWallList", "bFromServer", "openCamera", "putExtraBundle", "setRoomID", "roomID", "setUrlAction", "urlAction", "Lcom/tencent/mobileqq/troop/avatar/BaseUrlAction;", "update", "o", "Ljava/util/Observable;", "arg", "", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class ChooseCoverController
  implements iPicCtrl, Observer
{
  public static final ChooseCoverController.Companion a = new ChooseCoverController.Companion(null);
  private final Context b;
  private int[] c;
  private String[] d;
  private final int e;
  private long f;
  @NotNull
  private String g;
  @Nullable
  private Uri h;
  
  public ChooseCoverController(@NotNull Context paramContext)
  {
    this.b = paramContext;
    this.e = 104;
    this.g = "";
  }
  
  private final void d()
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isUsingCameraOnVideo((AppRuntime)localObject)) {
      QQToast.makeText(this.b, 0, 2131893827, 0).show();
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.b.checkSelfPermission("android.permission.CAMERA") != 0)
      {
        localObject = this.b;
        if (localObject != null)
        {
          ((AppActivity)localObject).requestPermissions(new ChooseCoverController.openCamera.1(this), 1, new String[] { "android.permission.CAMERA" });
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type mqq.app.AppActivity");
      }
      e();
      return;
    }
    e();
  }
  
  private final void e()
  {
    this.h = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot((Activity)this.b, 257);
  }
  
  @NotNull
  public final String a()
  {
    return this.g;
  }
  
  public final void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.g = paramString;
  }
  
  public boolean a(@Nullable String paramString1, @Nullable String paramString2)
  {
    paramString2 = (CharSequence)paramString1;
    int i;
    if ((paramString2 != null) && (paramString2.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    QLog.d("ChooseCoverController", 4, new Object[] { "onPicPicked {}", paramString1 });
    paramString2 = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1054");
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "QRoute.api(IQQLiveSDKMan…(GuildConfigConst.APP_ID)");
    paramString2 = paramString2.getFileUploadModule();
    paramString1 = BitmapFactory.decodeFile(paramString1);
    QQLiveUploadBitmapParams localQQLiveUploadBitmapParams = new QQLiveUploadBitmapParams();
    localQQLiveUploadBitmapParams.flag = "1054";
    localQQLiveUploadBitmapParams.format = "raw";
    localQQLiveUploadBitmapParams.roomId = String.valueOf(this.f);
    paramString2.uploadBitmap(paramString1, localQQLiveUploadBitmapParams, (IQQLiveUploadBitmapCallback)new ChooseCoverController.onPicPicked.1(this));
    return true;
  }
  
  public void b()
  {
    this.c = new int[3];
    Object localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
    }
    localObject1[0] = 13;
    localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
    }
    localObject1[1] = 14;
    localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
    }
    localObject1[2] = 16;
    localObject1 = this.b.getResources().getStringArray(2130968636);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext.resources.getSt…_profile_card_menu_items)");
    this.d = ((String[])localObject1);
    localObject1 = ActionSheetHelper.b(this.b, null);
    if (localObject1 != null)
    {
      localObject1 = (ActionSheet)localObject1;
      Object localObject2 = this.c;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
      }
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = this.c;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
        }
        int[] arrayOfInt;
        if (localObject2[i] == 16)
        {
          localObject2 = this.d;
          if (localObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMenuItems");
          }
          arrayOfInt = this.c;
          if (arrayOfInt == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
          }
          ((ActionSheet)localObject1).addCancelButton((CharSequence)localObject2[arrayOfInt[i]]);
        }
        else
        {
          localObject2 = this.d;
          if (localObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMenuItems");
          }
          arrayOfInt = this.c;
          if (arrayOfInt == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
          }
          ((ActionSheet)localObject1).addButton((CharSequence)localObject2[arrayOfInt[i]], 0);
        }
        i += 1;
      }
      ((ActionSheet)localObject1).setOnButtonClickListener((ActionSheet.OnButtonClickListener)new ChooseCoverController.onPickPic.1(this, (ActionSheet)localObject1));
      ((ActionSheet)localObject1).show();
      return;
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type com.tencent.widget.ActionSheet");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public void c()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = BaseImageUtil.b(this.b, (Uri)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEdit((Activity)this.b, (String)localObject, ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getBusiByType(this.e));
      }
    }
  }
  
  public void update(@Nullable Observable paramObservable, @Nullable Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.ChooseCoverController
 * JD-Core Version:    0.7.0.1
 */