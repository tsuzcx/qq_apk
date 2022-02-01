package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/IColdPalaceUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getColdPalaceHelper", "", "app", "Lcom/tencent/common/app/AppInterface;", "getFaceHeadDrawable", "Lcom/tencent/mobileqq/app/face/FaceDrawable;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "uin", "", "getSvrShowGrayTipEntry", "", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IColdPalaceUtils
  extends QRouteApi
{
  @NotNull
  public abstract Object getColdPalaceHelper(@NotNull AppInterface paramAppInterface);
  
  @NotNull
  public abstract FaceDrawable getFaceHeadDrawable(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @NotNull String paramString);
  
  public abstract boolean getSvrShowGrayTipEntry(@NotNull AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils
 * JD-Core Version:    0.7.0.1
 */