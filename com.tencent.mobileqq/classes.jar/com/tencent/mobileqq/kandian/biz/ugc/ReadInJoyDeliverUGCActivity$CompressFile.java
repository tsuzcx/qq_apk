package com.tencent.mobileqq.kandian.biz.ugc;

import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyDeliverUGCActivity$CompressFile
{
  private boolean b;
  private String c;
  private long d;
  private CompressInfo e;
  private boolean f;
  private BitmapFactory.Options g;
  
  public ReadInJoyDeliverUGCActivity$CompressFile(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, String paramString, long paramLong)
  {
    this.c = paramString;
    this.d = paramLong;
  }
  
  private boolean a(String paramString, CompressInfo paramCompressInfo, boolean paramBoolean, BitmapFactory.Options paramOptions)
  {
    if (paramBoolean)
    {
      if (ReadInJoyDeliverUGCActivity.z(this.a))
      {
        paramBoolean = ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramCompressInfo);
        if (QLog.isColorLevel())
        {
          paramOptions = new StringBuilder();
          paramOptions.append("compress result= ");
          paramOptions.append(paramBoolean);
          QLog.d("ReadInJoyDeliverUGCActivity", 2, paramOptions.toString());
        }
        if (!paramBoolean) {
          ReadInJoyDeliverUGCActivity.c(this.a, 1001);
        } else {
          ReadInJoyDeliverUGCActivity.l(this.a).add(paramCompressInfo.l);
        }
        paramOptions = new StringBuilder();
        paramOptions.append("startUploadPic compressPath=");
        paramOptions.append(paramCompressInfo.l);
        paramOptions.append(", path=");
        paramOptions.append(paramString);
        paramOptions.append(", width=");
        paramOptions.append(paramCompressInfo.m);
        paramOptions.append(", height=");
        paramOptions.append(paramCompressInfo.n);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, paramOptions.toString());
      }
      else
      {
        return true;
      }
    }
    else
    {
      paramCompressInfo.m = paramOptions.outWidth;
      paramCompressInfo.n = paramOptions.outHeight;
    }
    return false;
  }
  
  private boolean a(String paramString, boolean paramBoolean, BitmapFactory.Options paramOptions)
  {
    try
    {
      paramOptions.inJustDecodeBounds = true;
      ImageUtil.a(paramString, paramOptions);
      int i;
      if (paramOptions.outHeight > paramOptions.outWidth) {
        i = paramOptions.outHeight;
      } else {
        i = paramOptions.outWidth;
      }
      if (i <= 2560) {
        return false;
      }
    }
    catch (Exception paramString)
    {
      paramOptions = new StringBuilder();
      paramOptions.append("isNeedCompress error");
      paramOptions.append(paramString.toString());
      QLog.d("ReadInJoyDeliverUGCActivity", 2, paramOptions.toString());
    }
    return paramBoolean;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public CompressInfo b()
  {
    return this.e;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public BitmapFactory.Options d()
  {
    return this.g;
  }
  
  public CompressFile e()
  {
    this.e = new CompressInfo(this.c, 0);
    Object localObject = this.e;
    ((CompressInfo)localObject).o = 0;
    ((CompressInfo)localObject).b = 1036;
    this.f = true;
    this.g = new BitmapFactory.Options();
    this.f = a(this.c, this.f, this.g);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("beforeCompress picture: w:");
    ((StringBuilder)localObject).append(this.g.outWidth);
    ((StringBuilder)localObject).append("  h:");
    ((StringBuilder)localObject).append(this.g.outHeight);
    ((StringBuilder)localObject).append(" size:");
    ((StringBuilder)localObject).append(this.d / 1024L);
    ((StringBuilder)localObject).append("kb isNeedCompress:");
    ((StringBuilder)localObject).append(this.f);
    QLog.d("ReadInJoyDeliverUGCActivity", 2, ((StringBuilder)localObject).toString());
    if (a(this.c, this.e, this.f, this.g))
    {
      this.b = true;
      return this;
    }
    this.b = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.CompressFile
 * JD-Core Version:    0.7.0.1
 */