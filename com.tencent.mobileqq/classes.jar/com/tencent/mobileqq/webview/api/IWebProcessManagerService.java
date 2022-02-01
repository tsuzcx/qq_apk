package com.tencent.mobileqq.webview.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.webview.data.SonicPreloadData;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IWebProcessManagerService
  extends IRuntimeService
{
  public abstract boolean enablePreloadInBusiness(int paramInt);
  
  public abstract boolean isNeedPreloadWebProcess();
  
  public abstract boolean preloadSonicSession(@Nullable ArrayList<SonicPreloadData> paramArrayList);
  
  public abstract void startWebProcess(int paramInt, @Nullable WebProcessStartListener paramWebProcessStartListener);
  
  public abstract void updatePreloadWebProcessFlag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.IWebProcessManagerService
 * JD-Core Version:    0.7.0.1
 */