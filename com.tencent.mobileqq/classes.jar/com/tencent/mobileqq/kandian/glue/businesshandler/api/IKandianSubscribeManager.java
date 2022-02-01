package com.tencent.mobileqq.kandian.glue.businesshandler.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Service(needUin=false, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/IKandianSubscribeManager;", "Lmqq/app/api/IRuntimeService;", "getAggregateAvate", "Landroid/graphics/drawable/Drawable;", "oriIcon", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "getMessageObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "lanuchKandianSubscribeActivity", "", "context", "Landroid/content/Context;", "enterType", "", "launchFrom", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKandianSubscribeManager
  extends IRuntimeService
{
  @Nullable
  public abstract Drawable getAggregateAvate(@Nullable Drawable paramDrawable, @NotNull BaseQQAppInterface paramBaseQQAppInterface);
  
  @NotNull
  public abstract BusinessObserver getMessageObserver();
  
  public abstract void lanuchKandianSubscribeActivity(@NotNull Context paramContext, int paramInt);
  
  public abstract void lanuchKandianSubscribeActivity(@NotNull Context paramContext, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager
 * JD-Core Version:    0.7.0.1
 */