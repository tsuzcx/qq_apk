package com.tencent.mobileqq.soload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import java.util.List;

@QAPI(process={"all"})
public abstract interface ISoloadService
  extends QRouteApi
{
  public abstract void download(String paramString, OnLoadListener paramOnLoadListener);
  
  public abstract void download(String[] paramArrayOfString, OnLoadListener paramOnLoadListener);
  
  public abstract List<String> getCurInitSoList();
  
  public abstract String getInitVer(String paramString);
  
  public abstract void getSoLoadInfoTaskAsync(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem, OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener);
  
  public abstract SoLoadInfo getSoLoadInfoTaskSync(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem);
  
  public abstract String getSoVer(String paramString);
  
  public abstract void load(String paramString, OnLoadListener paramOnLoadListener);
  
  public abstract void loadSequentially(String[] paramArrayOfString, OnLoadListener paramOnLoadListener, LoadOptions[] paramArrayOfLoadOptions);
  
  public abstract LoadExtResult loadSequentiallySync(String[] paramArrayOfString, LoadOptions[] paramArrayOfLoadOptions);
  
  public abstract LoadExtResult loadSync(String paramString, LoadOptions paramLoadOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.ISoloadService
 * JD-Core Version:    0.7.0.1
 */