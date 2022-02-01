package com.tencent.mobileqq.intervideo.od;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IODProxyUtil
  extends QRouteApi
{
  public abstract Bundle getODIntentBundle(IVPluginInfo paramIVPluginInfo, ILoginKeyHelper paramILoginKeyHelper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.IODProxyUtil
 * JD-Core Version:    0.7.0.1
 */