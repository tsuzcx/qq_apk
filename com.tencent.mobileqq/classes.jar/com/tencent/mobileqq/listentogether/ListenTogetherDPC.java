package com.tencent.mobileqq.listentogether;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherDPC
{
  public static final String a = DPCNames.ltcfg.name();
  public int b = 50;
  public int c = 0;
  public long d = 3000L;
  public DPCObserver e = new ListenTogetherDPC.1(this);
  
  private ListenTogetherDPC()
  {
    b();
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.e);
  }
  
  public static ListenTogetherDPC a()
  {
    return ListenTogetherDPC.SingletonHolder.a();
  }
  
  private void b()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(a);
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        if (arrayOfString.length >= 4)
        {
          this.b = Integer.valueOf(arrayOfString[0]).intValue();
          this.c = Integer.valueOf(arrayOfString[1]).intValue();
          this.d = Long.valueOf(arrayOfString[2]).longValue();
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("ListenTogether.dpc", 1, "loadDpc", localException);
      this.b = 50;
      this.c = 0;
      this.d = 3000L;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.dpc", 2, String.format("loadDpc, dpcValue: %s, [%s]", new Object[] { str, this }));
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ListenTogetherDPC{maxCacheCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", preDownloadNetType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", playingAdjustInterval=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherDPC
 * JD-Core Version:    0.7.0.1
 */