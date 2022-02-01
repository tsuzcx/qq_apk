package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;

public abstract class PicType
  extends AbstractPicType
{
  public static int k = 960;
  protected String j = getClass().getSimpleName();
  CompressInfo l;
  protected int m;
  
  PicType(CompressInfo paramCompressInfo)
  {
    if ((paramCompressInfo != null) && (!TextUtils.isEmpty(paramCompressInfo.h)))
    {
      this.l = paramCompressInfo;
      int i = a(paramCompressInfo);
      this.m = i;
      if (i != -1) {
        return;
      }
      throw new IllegalArgumentException("create PicQuality is Fail");
    }
    throw new IllegalArgumentException("info == null || TextUtils.isEmpty(info.srcPath)");
  }
  
  protected abstract int a(CompressInfo paramCompressInfo);
  
  public int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int n = 0;
    int i;
    if ((!bool) && (!TextUtils.isEmpty(paramString2)) && (FileUtils.fileExistsAndNotEmpty(paramString1)))
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
      i = 2;
      ((BitmapFactory.Options)localObject2).inSampleSize = 2;
      ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
    }
    try
    {
      localObject1 = SafeBitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject2);
      if (localObject1 == null)
      {
        localObject1 = this.j;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.l.a);
        ((StringBuilder)localObject3).append(" sampleCompress()");
        Logger.b(localObject1, ((StringBuilder)localObject3).toString(), " bm == null, maybe is broken");
        return 0;
      }
      i = 1;
      paramString1 = (String)localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject1;
      Object localObject3;
      label135:
      StringBuilder localStringBuilder;
      break label135;
    }
    this.l.a(true);
    localObject1 = this.j;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.l.a);
    ((StringBuilder)localObject3).append(" sampleCompress()");
    localObject3 = ((StringBuilder)localObject3).toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" decodeFile OutOfMemoryError, sampleCnt:");
    localStringBuilder.append(1);
    localStringBuilder.append(" oomKeepCompress:");
    localStringBuilder.append(paramBoolean);
    Logger.b(localObject1, (String)localObject3, localStringBuilder.toString());
    if (paramBoolean)
    {
      ((BitmapFactory.Options)localObject2).inSampleSize = 4;
      try
      {
        paramString1 = SafeBitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject2);
        paramBoolean = Utils.a(paramString2, paramString1, c(), this.l.a, this.l);
        if (paramString1 != null) {
          paramString1.recycle();
        }
        if (paramBoolean) {
          n = i;
        }
        return n;
      }
      catch (OutOfMemoryError paramString1)
      {
        this.l.a(false);
        paramString1.printStackTrace();
        paramString1 = this.j;
        paramString2 = new StringBuilder();
        paramString2.append(this.l.a);
        paramString2.append(" sampleCompress()");
        paramString2 = paramString2.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" oomKeepCompress decodeFile OutOfMemoryError, sampleCnt:");
        ((StringBuilder)localObject1).append(2);
        Logger.b(paramString1, paramString2, ((StringBuilder)localObject1).toString());
      }
    }
    return 0;
    localObject1 = this.j;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.l.a);
    ((StringBuilder)localObject2).append(" sampleCompress()");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(" infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:");
    ((StringBuilder)localObject3).append(paramString1);
    ((StringBuilder)localObject3).append(" outfilePath:");
    ((StringBuilder)localObject3).append(paramString2);
    Logger.b(localObject1, (String)localObject2, ((StringBuilder)localObject3).toString());
    return 0;
  }
  
  final boolean a()
  {
    boolean bool2 = FileUtils.fileExistsAndNotEmpty(this.l.h);
    boolean bool1 = false;
    Object localObject;
    StringBuilder localStringBuilder;
    if (!bool2)
    {
      localObject = this.j;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.l.a);
      localStringBuilder.append(" startThumbnail()");
      Logger.b(localObject, localStringBuilder.toString(), " src file does not exist");
      return false;
    }
    if (this.l.l == null)
    {
      localObject = this.l;
      ((CompressInfo)localObject).l = Utils.b(((CompressInfo)localObject).h);
      if (TextUtils.isEmpty(this.l.l))
      {
        localObject = this.j;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.l.a);
        localStringBuilder.append(" startThumbnail()");
        Logger.b(localObject, localStringBuilder.toString(), " destPath is empty");
        return false;
      }
    }
    if ((FileUtils.fileExistsAndNotEmpty(this.l.l)) && (!this.l.u))
    {
      localObject = this.j;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.l.a);
      localStringBuilder.append(" startThumbnail()");
      Logger.b(localObject, localStringBuilder.toString(), " destPath exist. return true");
      return true;
    }
    try
    {
      if (this.l.o == 2)
      {
        bool2 = Utils.a(this.l.h, this.l.l, this.l.g, this.l.a, 3, this.l.x);
        bool1 = bool2;
      }
      else
      {
        bool2 = Utils.a(this.l.h, this.l.l, this.l.g, this.l.a, 0, this.l.x);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Logger.b(this.j, "startThumbnail()", localException.getMessage());
    }
    if (!bool1)
    {
      this.l.l = "";
      String str = this.j;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.l.a);
      localStringBuilder.append(" startThumbnail()");
      Logger.b(str, localStringBuilder.toString(), " compressAIOThumbnail is failed");
    }
    return bool1;
  }
  
  final boolean b()
  {
    if (this.m == 2) {
      return e();
    }
    return f();
  }
  
  protected int c()
  {
    int i;
    if (this.l.p == 2)
    {
      i = 100;
    }
    else
    {
      i = this.l.q;
      if (i != 1)
      {
        if (i != 4) {
          i = b;
        } else {
          i = c;
        }
      }
      else {
        i = a;
      }
    }
    String str = this.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("compressQuality = ");
    localStringBuilder.append(i);
    Logger.a(str, "getCompressQuality", localStringBuilder.toString());
    return i;
  }
  
  final int d()
  {
    if (this.l.q == 1) {
      return 20971520;
    }
    return 4194304;
  }
  
  final boolean e()
  {
    Object localObject1;
    Object localObject2;
    if (this.l.p == 2)
    {
      if (Utils.a(this.l.h) <= ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit())
      {
        localObject1 = this.l;
        ((CompressInfo)localObject1).l = ((CompressInfo)localObject1).h;
        localObject1 = this.l;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.j);
        ((StringBuilder)localObject2).append(this.l.a);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131905964));
        ((CompressInfo)localObject1).s = ((StringBuilder)localObject2).toString();
        localObject1 = this.j;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.l.a);
        ((StringBuilder)localObject2).append(" commonCompress()");
        Logger.a(localObject1, ((StringBuilder)localObject2).toString(), HardCodeUtil.a(2131905963));
        if (this.l.o != 2)
        {
          this.l.t = true;
          return true;
        }
      }
      else
      {
        localObject1 = this.j;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.l.a);
        ((StringBuilder)localObject2).append(" commonCompress()");
        Logger.b(localObject1, ((StringBuilder)localObject2).toString(), HardCodeUtil.a(2131905968));
        return true;
      }
    }
    else
    {
      int i = d();
      long l1 = Utils.a(this.l.h);
      long l2 = i;
      if (l1 > l2)
      {
        localObject1 = this.j;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.l.a);
        ((StringBuilder)localObject2).append(" commonCompress()");
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" src file size > max, file size:");
        ((StringBuilder)localObject3).append(Utils.a(this.l.h));
        ((StringBuilder)localObject3).append(" max:");
        ((StringBuilder)localObject3).append(i);
        Logger.a(localObject1, (String)localObject2, ((StringBuilder)localObject3).toString());
        localObject1 = this.l;
        ((CompressInfo)localObject1).l = Utils.a(((CompressInfo)localObject1).h, this.l.p);
        if (TextUtils.isEmpty(this.l.l))
        {
          localObject1 = this.j;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.l.a);
          ((StringBuilder)localObject2).append(" commonCompress()");
          Logger.b(localObject1, ((StringBuilder)localObject2).toString(), " destPath is empty");
          return false;
        }
        if (FileUtils.fileExistsAndNotEmpty(this.l.l))
        {
          localObject1 = this.j;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.l.a);
          ((StringBuilder)localObject2).append(" commonCompress()");
          Logger.b(localObject1, ((StringBuilder)localObject2).toString(), " destPath exist. return true");
          return true;
        }
        localObject1 = this.l;
        ((CompressInfo)localObject1).r = 0;
        int n = a(((CompressInfo)localObject1).h, this.l.l, true);
        if (n != 0)
        {
          localObject1 = this.l;
          ((CompressInfo)localObject1).r += n;
          if (Utils.a(this.l.l) > l2)
          {
            if (this.l.r >= 2)
            {
              this.l.a(false);
              localObject1 = this.l;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.j);
              ((StringBuilder)localObject2).append(this.l.a);
              ((StringBuilder)localObject2).append(" commonCompress() 面积是原来的1/16，不能再小了fileSize:");
              ((StringBuilder)localObject2).append(Utils.a(this.l.l));
              ((StringBuilder)localObject2).append(" max:");
              ((StringBuilder)localObject2).append(i);
              ((CompressInfo)localObject1).s = ((StringBuilder)localObject2).toString();
              localObject1 = this.j;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.l.a);
              ((StringBuilder)localObject2).append(" commonCompress()");
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(" 面积是原来的1/16，不能再小了fileSize:");
              ((StringBuilder)localObject3).append(Utils.a(this.l.l));
              ((StringBuilder)localObject3).append(" max:");
              ((StringBuilder)localObject3).append(i);
              Logger.b(localObject1, (String)localObject2, ((StringBuilder)localObject3).toString());
              FileUtils.deleteFile(this.l.l);
              this.l.l = "";
              return false;
            }
            localObject2 = this.l.l;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("_second");
            localObject1 = ((StringBuilder)localObject1).toString();
            this.l.l = "";
            n = a((String)localObject2, (String)localObject1, false);
            FileUtils.deleteFile((String)localObject2);
            if (n != 0)
            {
              localObject2 = this.l;
              ((CompressInfo)localObject2).r += n;
              this.l.l = ((String)localObject1);
              if (Utils.a((String)localObject1) > l2)
              {
                this.l.a(false);
                localObject2 = this.l;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(this.j);
                ((StringBuilder)localObject3).append(this.l.a);
                ((StringBuilder)localObject3).append(" commonCompress()");
                ((StringBuilder)localObject3).append(HardCodeUtil.a(2131905969));
                ((StringBuilder)localObject3).append(Utils.a((String)localObject1));
                ((StringBuilder)localObject3).append(" max:");
                ((StringBuilder)localObject3).append(i);
                ((CompressInfo)localObject2).s = ((StringBuilder)localObject3).toString();
                localObject2 = this.j;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(this.l.a);
                ((StringBuilder)localObject3).append(" commonCompress()");
                localObject3 = ((StringBuilder)localObject3).toString();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(HardCodeUtil.a(2131905970));
                localStringBuilder.append(Utils.a((String)localObject1));
                localStringBuilder.append(" max:");
                localStringBuilder.append(i);
                Logger.b(localObject2, (String)localObject3, localStringBuilder.toString());
                FileUtils.deleteFile(this.l.l);
                this.l.l = "";
                return false;
              }
            }
            else
            {
              localObject1 = this.l;
              ((CompressInfo)localObject1).l = "";
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.j);
              ((StringBuilder)localObject2).append(this.l.a);
              ((StringBuilder)localObject2).append(" commonCompress()");
              ((StringBuilder)localObject2).append(HardCodeUtil.a(2131905967));
              ((CompressInfo)localObject1).s = ((StringBuilder)localObject2).toString();
              localObject1 = this.j;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.l.a);
              ((StringBuilder)localObject2).append(" commonCompress()");
              Logger.b(localObject1, ((StringBuilder)localObject2).toString(), HardCodeUtil.a(2131905965));
              return false;
            }
          }
        }
        else
        {
          localObject1 = this.l;
          ((CompressInfo)localObject1).l = "";
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.j);
          ((StringBuilder)localObject2).append(this.l.a);
          ((StringBuilder)localObject2).append(" commonCompress() sampleCompress failed");
          ((CompressInfo)localObject1).s = ((StringBuilder)localObject2).toString();
          localObject1 = this.j;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.l.a);
          ((StringBuilder)localObject2).append(" commonCompress()");
          Logger.b(localObject1, ((StringBuilder)localObject2).toString(), " sampleCompress failed");
          return false;
        }
      }
      else
      {
        localObject1 = this.l;
        ((CompressInfo)localObject1).l = ((CompressInfo)localObject1).h;
        localObject1 = this.l;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.j);
        ((StringBuilder)localObject2).append(this.l.a);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131905971));
        ((CompressInfo)localObject1).s = ((StringBuilder)localObject2).toString();
        localObject1 = this.j;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.l.a);
        ((StringBuilder)localObject2).append(" commonCompress()");
        Logger.a(localObject1, ((StringBuilder)localObject2).toString(), HardCodeUtil.a(2131905966));
        if (this.l.o != 2) {
          this.l.t = true;
        }
      }
    }
    return true;
  }
  
  protected abstract boolean f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicType
 * JD-Core Version:    0.7.0.1
 */