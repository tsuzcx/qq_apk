package com.tencent.weiyun.callback;

import com.tencent.weiyun.data.CBundleReader;
import com.tencent.weiyun.data.FileItem;
import java.util.ArrayList;
import java.util.List;

public abstract class FetchFileListCallback
  extends WeiyunCallback
{
  public abstract void onError(int paramInt1, String paramString, int paramInt2, boolean paramBoolean);
  
  protected void onNativeCallback(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 0)
    {
      int i = 0;
      if (paramLong == 0L)
      {
        onSuccess(new ArrayList(0), new ArrayList(0), paramInt1, paramBoolean);
        return;
      }
      long l1 = CBundleReader.getLong(paramLong, "add_list", 0L);
      long l2 = CBundleReader.getLong(paramLong, "delete_list", 0L);
      CBundleReader.deleteBundle(paramLong);
      long[] arrayOfLong = null;
      if (l1 == 0L) {
        paramString = null;
      } else {
        paramString = CBundleReader.getLongArray(l1, "file_list");
      }
      if (l2 != 0L) {
        arrayOfLong = CBundleReader.getLongArray(l2, "file_list");
      }
      if (l1 != 0L) {
        CBundleReader.deleteBundle(l1);
      }
      if (l2 != 0L) {
        CBundleReader.deleteBundle(l2);
      }
      if (paramString == null) {
        paramInt2 = 0;
      } else {
        paramInt2 = paramString.length;
      }
      ArrayList localArrayList1 = new ArrayList(paramInt2);
      if (arrayOfLong == null) {
        paramInt2 = 0;
      } else {
        paramInt2 = arrayOfLong.length;
      }
      ArrayList localArrayList2 = new ArrayList(paramInt2);
      int j;
      if (paramString != null)
      {
        j = paramString.length;
        paramInt2 = 0;
        while (paramInt2 < j)
        {
          paramLong = paramString[paramInt2];
          if (paramLong != 0L)
          {
            FileItem localFileItem = FileItem.newInstance(paramLong);
            if (localFileItem != null) {
              localArrayList1.add(localFileItem);
            }
          }
          paramInt2 += 1;
        }
      }
      if (arrayOfLong != null)
      {
        j = arrayOfLong.length;
        paramInt2 = i;
        while (paramInt2 < j)
        {
          paramLong = arrayOfLong[paramInt2];
          if (paramLong != 0L)
          {
            paramString = FileItem.newInstance(paramLong);
            if (paramString != null) {
              localArrayList2.add(paramString);
            }
          }
          paramInt2 += 1;
        }
      }
      onSuccess(localArrayList1, localArrayList2, paramInt1, paramBoolean);
      return;
    }
    onError(paramInt2, paramString, paramInt1, paramBoolean);
  }
  
  public abstract void onSuccess(List<FileItem> paramList1, List<FileItem> paramList2, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.callback.FetchFileListCallback
 * JD-Core Version:    0.7.0.1
 */