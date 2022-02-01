package com.tencent.mobileqq.kandian.biz.pts.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/IOfflineUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkOfflineDirExist", "", "init", "preCache", "isBackground", "", "readInputStreamAsString", "", "inputStream", "Ljava/io/InputStream;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IOfflineUtils
  extends QRouteApi
{
  public abstract void checkOfflineDirExist();
  
  public abstract void init();
  
  public abstract void preCache(boolean paramBoolean);
  
  @Nullable
  public abstract String readInputStreamAsString(@Nullable InputStream paramInputStream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.IOfflineUtils
 * JD-Core Version:    0.7.0.1
 */