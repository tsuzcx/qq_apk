package com.tencent.mobileqq.webview.api;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.data.SonicParserInfo;
import com.tencent.mobileqq.webview.data.SonicPreloadData;
import java.util.List;

@QAPI(process={"all"})
public abstract interface ISonicPreloaderService
  extends QRouteApi
{
  public abstract boolean enablePreloadSonic();
  
  @Nullable
  public abstract SparseArray<SonicPreloadData> getSonicPreloadDataList(@Nullable SonicParserInfo paramSonicParserInfo);
  
  public abstract boolean preload(@Nullable List<SonicPreloadData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.ISonicPreloaderService
 * JD-Core Version:    0.7.0.1
 */