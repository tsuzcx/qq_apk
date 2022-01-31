package com.tencent.weiyun.callback;

import android.util.Pair;
import com.tencent.weiyun.data.CBundleReader;
import java.util.ArrayList;
import java.util.List;

public abstract class FetchPicVideoInfoCallback
  extends WeiyunCallback
{
  public abstract void onError(int paramInt, String paramString, boolean paramBoolean);
  
  protected void onNativeCallback(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 0)
    {
      if (paramLong == 0L)
      {
        onSuccess(new ArrayList(0), paramBoolean);
        return;
      }
      paramString = CBundleReader.getLongArray(paramLong, "info_list");
      CBundleReader.deleteBundle(paramLong);
      if (paramString == null) {}
      ArrayList localArrayList;
      for (paramInt1 = 0;; paramInt1 = paramString.length)
      {
        localArrayList = new ArrayList(paramInt1);
        if (paramString == null) {
          break;
        }
        paramInt2 = paramString.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          paramLong = paramString[paramInt1];
          if (paramLong != 0L)
          {
            long l1 = CBundleReader.getLong(paramLong, "take_time", 0L);
            long l2 = CBundleReader.getLong(paramLong, "org_file_size", 0L);
            CBundleReader.deleteBundle(paramLong);
            localArrayList.add(new Pair(Long.valueOf(l1), Long.valueOf(l2)));
          }
          paramInt1 += 1;
        }
      }
      onSuccess(localArrayList, paramBoolean);
      return;
    }
    onError(paramInt2, paramString, paramBoolean);
  }
  
  public abstract void onSuccess(List<Pair<Long, Long>> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.callback.FetchPicVideoInfoCallback
 * JD-Core Version:    0.7.0.1
 */