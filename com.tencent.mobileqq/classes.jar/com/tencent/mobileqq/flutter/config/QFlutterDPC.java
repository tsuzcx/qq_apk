package com.tencent.mobileqq.flutter.config;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

public class QFlutterDPC
{
  private static final String a = DPCNames.qflutterCfg.name();
  private static Random b = new Random();
  private static QFlutterDPC f;
  private boolean c;
  private boolean d;
  private int e;
  
  private QFlutterDPC()
  {
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(new QFlutterDPC.1(this));
    b();
  }
  
  public static QFlutterDPC a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new QFlutterDPC();
        }
      }
      finally {}
    }
    return f;
  }
  
  public void b()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(a);
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split("\\|");
      if (arrayOfString.length >= 3) {
        try
        {
          if (Integer.valueOf(arrayOfString[0]).intValue() == 1) {
            this.c = true;
          } else {
            this.c = false;
          }
          if (b.nextFloat() < Float.valueOf(arrayOfString[1]).floatValue()) {
            this.d = true;
          } else {
            this.d = false;
          }
          this.e = Integer.valueOf(arrayOfString[2]).intValue();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadConfig exception :");
          localStringBuilder.append(localException.getMessage());
          QLog.d("QFlutterDPC", 1, localStringBuilder.toString());
          this.d = true;
          this.c = true;
          this.e = 0;
        }
      }
    }
    else
    {
      this.d = true;
      this.c = true;
      this.e = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterDPC", 2, String.format("loadConfig, dpcValue: %s, mIsSupport: %s, mNeedReport: %s, mVoteRankingFlutterThreashold=%s", new Object[] { str, Boolean.valueOf(this.c), Boolean.valueOf(this.d), Integer.valueOf(this.e) }));
    }
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    try
    {
      l = Long.valueOf(str).longValue();
    }
    catch (Throwable localThrowable)
    {
      long l;
      label23:
      int i;
      boolean bool;
      break label23;
    }
    l = 0L;
    i = (int)(l % 10L);
    bool = false;
    QLog.d("QFlutterDPC", 1, String.format("isVoteRankingFlutterOpen lastNum=%d threashold=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.e) }));
    if (this.c)
    {
      if (i >= this.e) {
        return false;
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.config.QFlutterDPC
 * JD-Core Version:    0.7.0.1
 */