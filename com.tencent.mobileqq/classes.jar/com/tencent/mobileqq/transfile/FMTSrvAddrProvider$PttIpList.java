package com.tencent.mobileqq.transfile;

import ConfigPush.FileStorageServerListInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FMTSrvAddrProvider$PttIpList
{
  public ArrayList<FileStorageServerListInfo> groupPttDownloadWifiIPLIst = new ArrayList();
  public ArrayList<FileStorageServerListInfo> groupPttDownloadXGIPLIst = new ArrayList();
  public int[] wifiError = new int[6];
  public String wifiIdentifier;
  public int[] xGError = new int[6];
  public String xGIdentifier;
  
  public ArrayList<FileStorageServerListInfo> getIpList(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.wifiIdentifier))) {
      return this.groupPttDownloadWifiIPLIst;
    }
    if ((paramString != null) && (paramString.equals(this.xGIdentifier))) {
      return this.groupPttDownloadXGIPLIst;
    }
    return null;
  }
  
  public int[] getPttFailTimesArea(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.wifiIdentifier))) {
      return this.wifiError;
    }
    if ((paramString != null) && (paramString.equals(this.xGIdentifier))) {
      return this.xGError;
    }
    return null;
  }
  
  public void initError()
  {
    ArrayList localArrayList = this.groupPttDownloadWifiIPLIst;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.wifiError = new int[this.groupPttDownloadWifiIPLIst.size()];
    }
    localArrayList = this.groupPttDownloadXGIPLIst;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.xGError = new int[this.groupPttDownloadXGIPLIst.size()];
    }
  }
  
  public void onFailed(String paramString1, String paramString2)
  {
    Object localObject = null;
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        if (paramString1.equals(this.wifiIdentifier))
        {
          paramString1 = this.groupPttDownloadWifiIPLIst;
          localObject = this.wifiError;
        }
        else
        {
          if ((paramString1 == null) || (!paramString1.equals(this.xGIdentifier))) {
            break label171;
          }
          paramString1 = this.groupPttDownloadXGIPLIst;
          localObject = this.xGError;
        }
        if ((paramString1 != null) && (paramString1.size() > 0) && (localObject != null) && (localObject.length > 0))
        {
          paramString2 = new URL(paramString2).getHost();
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            int i = 0;
            if (i < paramString1.size())
            {
              str = ((FileStorageServerListInfo)paramString1.get(i)).sIP;
              if ((str != null) && (str.equalsIgnoreCase(paramString2)))
              {
                if (localObject.length > i) {
                  localObject[i] += 1;
                }
              }
              else
              {
                i += 1;
                continue;
              }
            }
          }
        }
        return;
      }
      catch (MalformedURLException paramString1)
      {
        return;
      }
      label171:
      String str = null;
      paramString1 = (String)localObject;
      localObject = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FMTSrvAddrProvider.PttIpList
 * JD-Core Version:    0.7.0.1
 */