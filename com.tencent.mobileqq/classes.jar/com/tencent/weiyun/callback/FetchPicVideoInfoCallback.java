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
      paramInt2 = 0;
      if (paramLong == 0L)
      {
        onSuccess(new ArrayList(0), paramBoolean);
        return;
      }
      paramString = CBundleReader.getLongArray(paramLong, "info_list");
      CBundleReader.deleteBundle(paramLong);
      if (paramString == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = paramString.length;
      }
      ArrayList localArrayList = new ArrayList(paramInt1);
      if (paramString != null)
      {
        int i = paramString.length;
        paramInt1 = paramInt2;
        while (paramInt1 < i)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.callback.FetchPicVideoInfoCallback
 * JD-Core Version:    0.7.0.1
 */