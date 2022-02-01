package com.tencent.mobileqq.transfile;

import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import com.tencent.mobileqq.richmedia.IRichMediaIpSaver;
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
      while (i < paramArrayOfInt.length)
      {
        int k;
        if (paramArrayOfInt[i] < j)
        {
          k = paramArrayOfInt[i];
          localArrayList.clear();
          localArrayList.add(Integer.valueOf(i));
        }
        else
        {
          k = j;
          if (paramArrayOfInt[i] == j)
          {
            localArrayList.add(Integer.valueOf(i));
            k = j;
          }
        }
        i += 1;
        j = k;
      }
      if (localArrayList.size() > 0) {
        return ((Integer)localArrayList.get(Math.abs(this.rand.nextInt()) % localArrayList.size())).intValue();
      }
    }
    return -1;
  }
  
  private int findBestServerForPttDown(int[] paramArrayOfInt)
  {
    int i;
    if (!FMTSrvAddrProvider.access$600(this.this$0).c()) {
      i = 2;
    } else {
      i = 5;
    }
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
  
  void clear() {}
  
  FileStorageServerListInfo getAddr(int paramInt)
  {
    Object localObject = FMTSrvAddrProvider.access$500(this.this$0, paramInt);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      paramInt = findBestServer(getFailedTimesArray(paramInt));
      if ((paramInt > -1) && (paramInt < ((ArrayList)localObject).size()))
      {
        localObject = (FileStorageServerListInfo)((ArrayList)localObject).get(paramInt);
        break label57;
      }
    }
    localObject = null;
    label57:
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
    }
    return localObject;
  }
  
  FileStorageServerListInfo getAddrForPttDownload()
  {
    Object localObject = FMTSrvAddrProvider.access$500(this.this$0, 16);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int i = findBestServerForPttDown(FMTSrvAddrProvider.access$400(this.this$0).getPttFailTimesArea(FMTSrvAddrProvider.access$600(this.this$0).a()));
      if ((i > -1) && (i < ((ArrayList)localObject).size()))
      {
        localObject = (FileStorageServerListInfo)((ArrayList)localObject).get(i);
        break label75;
      }
    }
    localObject = null;
    label75:
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
    }
    return localObject;
  }
  
  int[] getFailedTimesArray(int paramInt)
  {
    int[][] arrayOfInt = this.mUrlFailedTimes;
    if (arrayOfInt == null) {
      return null;
    }
    return arrayOfInt[paramInt];
  }
  
  ArrayList<FileStorageServerListInfo> getOrderAddrList(int paramInt)
  {
    ArrayList localArrayList1 = FMTSrvAddrProvider.access$500(this.this$0, paramInt);
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      int i = localArrayList1.size();
      int k = i;
      if (i >= 3) {
        k = 3;
      }
      ArrayList localArrayList2 = new ArrayList(k);
      int[] arrayOfInt = getFailedTimesArray(paramInt);
      if ((arrayOfInt != null) && (arrayOfInt.length == localArrayList1.size()))
      {
        int i2 = 2147483647;
        int i3 = 0;
        paramInt = 0;
        int j = 0;
        int m;
        for (i = 2147483647; paramInt < arrayOfInt.length; i = m)
        {
          m = i;
          if (arrayOfInt[paramInt] < i)
          {
            m = arrayOfInt[paramInt];
            j = paramInt;
          }
          paramInt += 1;
        }
        localArrayList2.add(0, localArrayList1.get(j));
        int i1;
        int n;
        if (k >= 2)
        {
          paramInt = 0;
          i = 0;
          for (m = 2147483647; paramInt < arrayOfInt.length; m = n)
          {
            i1 = i;
            n = m;
            if (paramInt != j)
            {
              i1 = i;
              n = m;
              if (arrayOfInt[paramInt] < m)
              {
                n = arrayOfInt[paramInt];
                i1 = paramInt;
              }
            }
            paramInt += 1;
            i = i1;
          }
          localArrayList2.add(1, localArrayList1.get(i));
        }
        else
        {
          i = 0;
        }
        if (k >= 3)
        {
          n = 0;
          paramInt = i3;
          for (k = i2; paramInt < arrayOfInt.length; k = m)
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
          }
          localArrayList2.add(2, localArrayList1.get(n));
        }
        return localArrayList2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
    }
    return null;
  }
  
  void init(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
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
      ArrayList localArrayList = paramFileStoragePushFSSvcList.vUpLoadList;
      int k = 0;
      if ((localArrayList != null) && (paramFileStoragePushFSSvcList.vUpLoadList.size() > 0)) {
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
      while (i <= 10)
      {
        paramFileStoragePushFSSvcList = this.this$0;
        paramFileStoragePushFSSvcList = FMTSrvAddrProvider.access$100(paramFileStoragePushFSSvcList, FMTSrvAddrProvider.access$000(paramFileStoragePushFSSvcList, i));
        if (paramFileStoragePushFSSvcList != null) {
          j = paramFileStoragePushFSSvcList.size();
        } else {
          j = 0;
        }
        this.mUrlFailedTimes[i] = new int[j];
        i += 1;
      }
      i = 12;
      while (i <= 15)
      {
        paramFileStoragePushFSSvcList = this.this$0;
        paramFileStoragePushFSSvcList = FMTSrvAddrProvider.access$300(paramFileStoragePushFSSvcList, FMTSrvAddrProvider.access$200(paramFileStoragePushFSSvcList, i));
        if (paramFileStoragePushFSSvcList != null) {
          j = paramFileStoragePushFSSvcList.size();
        } else {
          j = 0;
        }
        this.mUrlFailedTimes[i] = new int[j];
        i += 1;
      }
      paramFileStoragePushFSSvcList = this.this$0;
      paramFileStoragePushFSSvcList = FMTSrvAddrProvider.access$300(paramFileStoragePushFSSvcList, FMTSrvAddrProvider.access$200(paramFileStoragePushFSSvcList, 17));
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
        if ((paramString != null) && (paramString.length() > 0))
        {
          paramInt = 0;
          while (paramInt < localArrayList.size())
          {
            String str = ((FileStorageServerListInfo)localArrayList.get(paramInt)).sIP;
            if ((str != null) && (str.equalsIgnoreCase(paramString)))
            {
              if (arrayOfInt.length <= paramInt) {
                break;
              }
              arrayOfInt[paramInt] += 1;
              return;
            }
            paramInt += 1;
          }
        }
      }
      return;
    }
    catch (MalformedURLException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FMTSrvAddrProvider.SrvAddrChooser
 * JD-Core Version:    0.7.0.1
 */