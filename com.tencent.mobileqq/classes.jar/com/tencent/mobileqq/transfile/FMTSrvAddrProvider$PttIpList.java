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
    if ((this.groupPttDownloadWifiIPLIst != null) && (this.groupPttDownloadWifiIPLIst.size() > 0)) {
      this.wifiError = new int[this.groupPttDownloadWifiIPLIst.size()];
    }
    if ((this.groupPttDownloadXGIPLIst != null) && (this.groupPttDownloadXGIPLIst.size() > 0)) {
      this.xGError = new int[this.groupPttDownloadXGIPLIst.size()];
    }
  }
  
  public void onFailed(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        int i;
        if (paramString1.equals(this.wifiIdentifier))
        {
          localArrayList = this.groupPttDownloadWifiIPLIst;
          paramString1 = this.wifiError;
          if ((localArrayList == null) || (localArrayList.size() <= 0) || (paramString1 == null) || (paramString1.length <= 0)) {
            break;
          }
          paramString2 = new URL(paramString2).getHost();
          if ((paramString2 == null) || (paramString2.length() <= 0)) {
            break;
          }
          i = 0;
          if (i >= localArrayList.size()) {
            break;
          }
          String str = ((FileStorageServerListInfo)localArrayList.get(i)).sIP;
          if ((str != null) && (str.equalsIgnoreCase(paramString2)))
          {
            if (paramString1.length <= i) {
              break;
            }
            paramString1[i] += 1;
          }
        }
        else
        {
          if ((paramString1 == null) || (!paramString1.equals(this.xGIdentifier))) {
            break label163;
          }
          localArrayList = this.groupPttDownloadXGIPLIst;
          paramString1 = this.xGError;
          continue;
        }
        i += 1;
        continue;
        paramString1 = null;
      }
      catch (MalformedURLException paramString1)
      {
        return;
      }
      label163:
      ArrayList localArrayList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FMTSrvAddrProvider.PttIpList
 * JD-Core Version:    0.7.0.1
 */