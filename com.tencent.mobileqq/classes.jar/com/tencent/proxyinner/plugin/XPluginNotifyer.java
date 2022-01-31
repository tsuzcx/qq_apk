package com.tencent.proxyinner.plugin;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.txproxy.HostEventListener;
import com.tencent.txproxy.XEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XPluginNotifyer
{
  private static final String TAG = "XProxy|XProxy";
  private List<XEventListener> mList = new ArrayList();
  
  public void addListener(XEventListener paramXEventListener)
  {
    if ((paramXEventListener != null) && (!this.mList.contains(paramXEventListener))) {
      this.mList.add(paramXEventListener);
    }
  }
  
  void onDataReport(String paramString, Bundle paramBundle)
  {
    Object localObject = new ArrayList();
    if ((this.mList != null) && (this.mList.size() > 0)) {
      ((List)localObject).addAll(this.mList);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
      try
      {
        localXEventListener.onDataReport(paramString, paramBundle);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onDownloadFile(int paramInt, String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
      try
      {
        localXEventListener.onDownload(paramInt, paramString1, paramString2, paramHostEventListener);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onError(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
      try
      {
        localXEventListener.onError(paramString1, paramInt, paramString2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onGetPluginActivity(Activity paramActivity)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
      try
      {
        localXEventListener.onGetPluginActivity(paramActivity);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onLog(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new ArrayList();
    if ((this.mList != null) && (this.mList.size() > 0)) {
      ((List)localObject).addAll(this.mList);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
      try
      {
        localXEventListener.onLog(paramString1, paramString2, paramInt);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onPluginInstalled(String paramString)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
      try
      {
        localXEventListener.onPluginInstalled(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onPluginLoaded(String paramString)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
      try
      {
        localXEventListener.onPluginLoaded(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onPluginRun(String paramString)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
      try
      {
        localXEventListener.onPluginRun(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onProgress(String paramString, int paramInt)
  {
    Object localObject = new ArrayList();
    if ((this.mList != null) && (this.mList.size() > 0)) {
      ((List)localObject).addAll(this.mList);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
      try
      {
        localXEventListener.onProgress(paramString, paramInt);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onRecvMessage(String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject = new ArrayList();
    if (this.mList.size() > 0) {
      ((List)localObject).addAll(this.mList);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
      try
      {
        localXEventListener.onReceivePluginMsg(paramString1, paramString2, paramBundle);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onStatusChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      XEventListener localXEventListener = (XEventListener)((Iterator)localObject).next();
    }
  }
  
  void onUnZipSo(String paramString1, String paramString2)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((XEventListener)((Iterator)localObject).next()).onUnZipSo(paramString1, paramString2) > 0) {
        throw new MoveSoException("Host Move So Failed");
      }
    }
  }
  
  public void removeListener(XEventListener paramXEventListener)
  {
    if ((paramXEventListener != null) && (this.mList.contains(paramXEventListener))) {
      this.mList.remove(paramXEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.XPluginNotifyer
 * JD-Core Version:    0.7.0.1
 */