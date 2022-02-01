package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import bize;
import bizj;
import bizo;
import bmxe;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class AppJsPlugin$AppDownloadManager$1
  implements bmxe
{
  AppJsPlugin$AppDownloadManager$1(AppJsPlugin.AppDownloadManager paramAppDownloadManager) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    Object localObject1;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      localObject1 = AppJsPlugin.AppDownloadManager.access$500(this.this$1).entrySet().iterator();
      label78:
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayList = (Map.Entry)((Iterator)localObject1).next();
        if (paramArrayList != null) {}
        for (paramArrayList = (AppJsPlugin.IWaldlCallback)paramArrayList.getValue();; paramArrayList = null)
        {
          if (paramArrayList == null) {
            break label78;
          }
          paramArrayList.onResult(false, null);
          break;
        }
      }
      AppJsPlugin.AppDownloadManager.access$500(this.this$1).clear();
    }
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (WadlResult)paramArrayList.next();
        Object localObject2 = ((WadlResult)localObject1).jdField_a_of_type_CooperationWadlIpcWadlParams;
        String str = ((WadlParams)localObject2).a;
        if ((str != null) && (localObject2 != null)) {
          AppJsPlugin.AppDownloadManager.access$600(this.this$1).put(str, localObject2);
        }
        if ((str != null) && (AppJsPlugin.AppDownloadManager.access$500(this.this$1).containsKey(str)))
        {
          localObject2 = (AppJsPlugin.IWaldlCallback)AppJsPlugin.AppDownloadManager.access$500(this.this$1).remove(str);
          if (localObject2 != null) {
            ((AppJsPlugin.IWaldlCallback)localObject2).onResult(true, localObject1);
          }
        }
      }
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onReceiveYYBInstall(String paramString1, String paramString2) {}
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {
      bize.a("AppJsPlugin_AppDownloadManager", "onWadlTaskStatusChanged error wadlResult is null");
    }
    String str;
    int i;
    int j;
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            return;
            localObject = paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams;
            str = ((WadlParams)localObject).a;
            i = bizo.a(paramWadlResult.jdField_b_of_type_Int);
            bizj.b(((WadlParams)localObject).a);
            QLog.i("AppJsPlugin_AppDownloadManager", 1, "onWadlTaskStatusChanged:" + paramWadlResult + ",localStatus:" + i);
            switch (i)
            {
            case 3: 
            case 9: 
            case 10: 
            case 20: 
            default: 
              QLog.e("AppJsPlugin_AppDownloadManager", 1, "download status not response!");
              return;
            case 4: 
              AppJsPlugin.AppDownloadManager.access$200(this.this$1).remove(str);
              if ((AppJsPlugin.AppDownloadManager.access$300(this.this$1) != null) && (AppJsPlugin.AppDownloadManager.access$300(this.this$1).containsKey(str)) && (AppJsPlugin.AppDownloadManager.access$300(this.this$1).get(str) != null)) {
                ((AppJsPlugin.IDownloadListener)AppJsPlugin.AppDownloadManager.access$300(this.this$1).get(str)).onDownloadComplete();
              }
              AppJsPlugin.AppDownloadManager.access$300(this.this$1).remove(str);
              return;
            }
          } while (!AppJsPlugin.AppDownloadManager.access$400(this.this$1).containsKey(str));
          localObject = (AppJsPlugin.IWaldlCallback)AppJsPlugin.AppDownloadManager.access$400(this.this$1).remove(str);
        } while (localObject == null);
        ((AppJsPlugin.IWaldlCallback)localObject).onResult(true, paramWadlResult);
        return;
        i = bizo.b(paramWadlResult.c);
        bizo.a(i);
        AppJsPlugin.AppDownloadManager.access$200(this.this$1).remove(str);
        if ((AppJsPlugin.AppDownloadManager.access$300(this.this$1) != null) && (AppJsPlugin.AppDownloadManager.access$300(this.this$1).containsKey(str)) && (AppJsPlugin.AppDownloadManager.access$300(this.this$1).get(str) != null)) {
          ((AppJsPlugin.IDownloadListener)AppJsPlugin.AppDownloadManager.access$300(this.this$1).get(str)).onDownloadFailed(i, i, "failed");
        }
        AppJsPlugin.AppDownloadManager.access$300(this.this$1).remove(str);
        return;
      } while ((AppJsPlugin.AppDownloadManager.access$300(this.this$1) == null) || (!AppJsPlugin.AppDownloadManager.access$300(this.this$1).containsKey(str)) || (AppJsPlugin.AppDownloadManager.access$300(this.this$1).get(str) == null));
      i = 0;
      if (AppJsPlugin.AppDownloadManager.access$200(this.this$1).containsKey(str)) {
        i = ((Integer)AppJsPlugin.AppDownloadManager.access$200(this.this$1).get(str)).intValue();
      }
      j = (int)(paramWadlResult.jdField_b_of_type_Long * 100L / paramWadlResult.jdField_a_of_type_Long);
    } while (j - i < 1);
    ((AppJsPlugin.IDownloadListener)AppJsPlugin.AppDownloadManager.access$300(this.this$1).get(str)).onDownloadProgress(paramWadlResult.jdField_b_of_type_Long, paramWadlResult.jdField_a_of_type_Long, j);
    AppJsPlugin.AppDownloadManager.access$200(this.this$1).put(str, Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin.AppDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */