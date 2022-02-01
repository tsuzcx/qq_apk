package com.tencent.mobileqq.qqexpand.plugin.preload;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/plugin/preload/IExpandPluginPreload;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "preloadProcessIfPlugin", "", "app", "Lcom/tencent/common/app/AppInterface;", "delay", "", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandPluginPreload
  extends QRouteApi
{
  public abstract void preloadProcessIfPlugin(@Nullable AppInterface paramAppInterface, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.preload.IExpandPluginPreload
 * JD-Core Version:    0.7.0.1
 */