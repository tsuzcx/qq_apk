package com.tencent.mobileqq.qqexpand.utils.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/impl/ColdPalaceUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/utils/IColdPalaceUtils;", "()V", "getColdPalaceHelper", "", "app", "Lcom/tencent/common/app/AppInterface;", "getFaceHeadDrawable", "Lcom/tencent/mobileqq/app/face/FaceDrawable;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "uin", "", "getSvrShowGrayTipEntry", "", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ColdPalaceUtilsImpl
  implements IColdPalaceUtils
{
  @NotNull
  public Object getColdPalaceHelper(@NotNull AppInterface paramAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    paramAppInterface = paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramAppInterface != null)
    {
      paramAppInterface = ((ExpandManager)paramAppInterface).a();
      Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "extendFriendManager.coldPalaceHelper");
      return paramAppInterface;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.ExpandManager");
  }
  
  @NotNull
  public FaceDrawable getFaceHeadDrawable(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    paramBaseQQAppInterface = Util.a((AppInterface)paramBaseQQAppInterface, paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramBaseQQAppInterface, "Util.getFaceHeadDrawable(app, uin)");
    return paramBaseQQAppInterface;
  }
  
  public boolean getSvrShowGrayTipEntry(@NotNull AppInterface paramAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    paramAppInterface = getColdPalaceHelper(paramAppInterface);
    if (paramAppInterface != null) {
      return ((ColdPalaceHelper)paramAppInterface).a();
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.ColdPalaceUtilsImpl
 * JD-Core Version:    0.7.0.1
 */