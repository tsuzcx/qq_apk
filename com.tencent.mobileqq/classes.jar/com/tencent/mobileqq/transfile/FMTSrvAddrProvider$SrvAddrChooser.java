package com.tencent.mobileqq.transfile;

import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import azbx;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

class FMTSrvAddrProvider$SrvAddrChooser
{
  private static final int MAX_FAILED_TIMES = 5;
  private static final int MAX_FAILED_XG_TIMES = 2;
  private int[][] mUrlFailedTimes;
  private Random rand = new Random(System.currentTimeMillis());
  
  FMTSrvAddrProvider$SrvAddrChooser(FMTSrvAddrProvider paramFMTSrvAddrProvider) {}
  
  private int findBestServer(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int j = 5;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        int k;
        if (paramArrayOfInt[i] < j)
        {
          k = paramArrayOfInt[i];
          localArrayList.clear();
          localArrayList.add(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j;
          if (paramArrayOfInt[i] == j)
          {
            localArrayList.add(Integer.valueOf(i));
            k = j;
          }
        }
      }
      if (localArrayList.size() > 0) {
        return ((Integer)localArrayList.get(Math.abs(this.rand.nextInt()) % localArrayList.size())).intValue();
      }
    }
    return -1;
  }
  
  private int findBestServerForPttDown(int[] paramArrayOfInt)
  {
    if (!FMTSrvAddrProvider.access$600(this.this$0).a()) {}
    for (int i = 2;; i = 5)
    {
      if (paramArrayOfInt != null)
      {
        int j = 0;
        while (j < paramArrayOfInt.length)
        {
          if (paramArrayOfInt[j] < i) {
            return j;
          }
          j += 1;
        }
      }
      return -1;
    }
  }
  
  void clear() {}
  
  FileStorageServerListInfo getAddr(int paramInt)
  {
    Object localObject2 = null;
    ArrayList localArrayList = FMTSrvAddrProvider.access$500(this.this$0, paramInt);
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        paramInt = findBestServer(getFailedTimesArray(paramInt));
        localObject1 = localObject2;
        if (paramInt > -1)
        {
          localObject1 = localObject2;
          if (paramInt < localArrayList.size()) {
            localObject1 = (FileStorageServerListInfo)localArrayList.get(paramInt);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
    }
    return localObject1;
  }
  
  FileStorageServerListInfo getAddrForPttDownload()
  {
    Object localObject2 = null;
    ArrayList localArrayList = FMTSrvAddrProvider.access$500(this.this$0, 16);
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        int i = findBestServerForPttDown(FMTSrvAddrProvider.access$400(this.this$0).getPttFailTimesArea(FMTSrvAddrProvider.access$600(this.this$0).b()));
        localObject1 = localObject2;
        if (i > -1)
        {
          localObject1 = localObject2;
          if (i < localArrayList.size()) {
            localObject1 = (FileStorageServerListInfo)localArrayList.get(i);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
    }
    return localObject1;
  }
  
  int[] getFailedTimesArray(int paramInt)
  {
    if (this.mUrlFailedTimes == null) {
      return null;
    }
    return this.mUrlFailedTimes[paramInt];
  }
  
  ArrayList<FileStorageServerListInfo> getOrderAddrList(int paramInt)
  {
    int i3 = 2147483647;
    int i2 = 0;
    ArrayList localArrayList1 = FMTSrvAddrProvider.access$500(this.this$0, paramInt);
    int i;
    int k;
    ArrayList localArrayList2;
    int[] arrayOfInt;
    int j;
    int m;
    int n;
    int i1;
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      i = localArrayList1.size();
      k = i;
      if (i >= 3) {
        k = 3;
      }
      localArrayList2 = new ArrayList(k);
      arrayOfInt = getFailedTimesArray(paramInt);
      if ((arrayOfInt != null) && (arrayOfInt.length == localArrayList1.size()))
      {
        paramInt = 0;
        i = 2147483647;
        j = 0;
        while (paramInt < arrayOfInt.length)
        {
          m = i;
          if (arrayOfInt[paramInt] < i)
          {
            m = arrayOfInt[paramInt];
            j = paramInt;
          }
          paramInt += 1;
          i = m;
        }
        localArrayList2.add(0, localArrayList1.get(j));
        if (k < 2) {
          break label342;
        }
        paramInt = 0;
        n = 2147483647;
        for (i = 0; paramInt < arrayOfInt.length; i = m)
        {
          i1 = n;
          m = i;
          if (paramInt != j)
          {
            i1 = n;
            m = i;
            if (arrayOfInt[paramInt] < n)
            {
              i1 = arrayOfInt[paramInt];
              m = paramInt;
            }
          }
          paramInt += 1;
          n = i1;
        }
        localArrayList2.add(1, localArrayList1.get(i));
      }
    }
    for (;;)
    {
      if (k >= 3)
      {
        n = 0;
        k = i3;
        paramInt = i2;
        while (paramInt < arrayOfInt.length)
        {
          i1 = n;
          m = k;
          if (paramInt != j)
          {
            i1 = n;
            m = k;
            if (paramInt != i)
            {
              i1 = n;
              m = k;
              if (arrayOfInt[paramInt] < k)
              {
                m = arrayOfInt[paramInt];
                i1 = paramInt;
              }
            }
          }
          paramInt += 1;
          n = i1;
          k = m;
        }
        localArrayList2.add(2, localArrayList1.get(n));
      }
      return localArrayList2;
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
      }
      return null;
      label342:
      i = 0;
    }
  }
  
  void init(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    int k = 0;
    if (paramFileStoragePushFSSvcList != null)
    {
      this.mUrlFailedTimes = new int[18][];
      if ((paramFileStoragePushFSSvcList.vUrlEncodeServiceList != null) && (paramFileStoragePushFSSvcList.vUrlEncodeServiceList.size() > 0)) {
        this.mUrlFailedTimes[4] = new int[paramFileStoragePushFSSvcList.vUrlEncodeServiceList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vGPicDownLoadList != null) && (paramFileStoragePushFSSvcList.vGPicDownLoadList.size() > 0)) {
        this.mUrlFailedTimes[2] = new int[paramFileStoragePushFSSvcList.vGPicDownLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vPicDownLoadList != null) && (paramFileStoragePushFSSvcList.vPicDownLoadList.size() > 0)) {
        this.mUrlFailedTimes[1] = new int[paramFileStoragePushFSSvcList.vPicDownLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vQzoneProxyServiceList != null) && (paramFileStoragePushFSSvcList.vQzoneProxyServiceList.size() > 0)) {
        this.mUrlFailedTimes[3] = new int[paramFileStoragePushFSSvcList.vQzoneProxyServiceList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vUpLoadList != null) && (paramFileStoragePushFSSvcList.vUpLoadList.size() > 0)) {
        this.mUrlFailedTimes[0] = new int[paramFileStoragePushFSSvcList.vUpLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vVipEmotionList != null) && (paramFileStoragePushFSSvcList.vVipEmotionList.size() > 0)) {
        this.mUrlFailedTimes[5] = new int[paramFileStoragePushFSSvcList.vVipEmotionList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vC2CPicDownList != null) && (paramFileStoragePushFSSvcList.vC2CPicDownList.size() > 0)) {
        this.mUrlFailedTimes[11] = new int[paramFileStoragePushFSSvcList.vC2CPicDownList.size()];
      }
      int i = 6;
      int j;
      if (i <= 10)
      {
        paramFileStoragePushFSSvcList = FMTSrvAddrProvider.access$100(this.this$0, FMTSrvAddrProvider.access$000(this.this$0, i));
        if (paramFileStoragePushFSSvcList != null) {}
        for (j = paramFileStoragePushFSSvcList.size();; j = 0)
        {
          this.mUrlFailedTimes[i] = new int[j];
          i += 1;
          break;
        }
      }
      i = 12;
      if (i <= 15)
      {
        paramFileStoragePushFSSvcList = FMTSrvAddrProvider.access$300(this.this$0, FMTSrvAddrProvider.access$200(this.this$0, i));
        if (paramFileStoragePushFSSvcList != null) {}
        for (j = paramFileStoragePushFSSvcList.size();; j = 0)
        {
          this.mUrlFailedTimes[i] = new int[j];
          i += 1;
          break;
        }
      }
      paramFileStoragePushFSSvcList = FMTSrvAddrProvider.access$300(this.this$0, FMTSrvAddrProvider.access$200(this.this$0, 17));
      i = k;
      if (paramFileStoragePushFSSvcList != null) {
        i = paramFileStoragePushFSSvcList.size();
      }
      this.mUrlFailedTimes[17] = new int[i];
    }
    FMTSrvAddrProvider.access$400(this.this$0).initError();
  }
  
  void onFailed(int paramInt, String paramString)
  {
    try
    {
      ArrayList localArrayList = FMTSrvAddrProvider.access$500(this.this$0, paramInt);
      int[] arrayOfInt = getFailedTimesArray(paramInt);
      if ((localArrayList != null) && (localArrayList.size() > 0) && (arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        paramString = new URL(paramString).getHost();
        if ((paramString != null) && (paramString.length() > 0)) {
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt < localArrayList.size())
        {
          String str = ((FileStorageServerListInfo)localArrayList.get(paramInt)).sIP;
          if ((str == null) || (!str.equalsIgnoreCase(paramString))) {
            break label116;
          }
          if (arrayOfInt.length > paramInt) {
            arrayOfInt[paramInt] += 1;
          }
        }
        return;
        label116:
        paramInt += 1;
      }
      return;
    }
    catch (MalformedURLException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FMTSrvAddrProvider.SrvAddrChooser
 * JD-Core Version:    0.7.0.1
 */