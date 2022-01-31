package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.utils.FileUtils;

public abstract class PicType
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g = 960;
  public static int h = 960;
  public static int i = 960;
  public static int j = 960;
  CompressInfo a;
  protected String a;
  protected int k;
  
  static
  {
    jdField_a_of_type_Int = 80;
    b = 70;
    c = 70;
    d = 960;
    e = 1920;
    jdField_f_of_type_Int = 960;
  }
  
  PicType(CompressInfo paramCompressInfo)
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    if ((paramCompressInfo == null) || (TextUtils.isEmpty(paramCompressInfo.c))) {
      throw new IllegalArgumentException("info == null || TextUtils.isEmpty(info.srcPath)");
    }
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    int m = a(paramCompressInfo);
    this.k = m;
    if (m == -1) {
      throw new IllegalArgumentException("create PicQuality is Fail");
    }
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int m = 1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.b(paramString1))) {
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
    }
    BitmapFactory.Options localOptions;
    do
    {
      return 0;
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      try
      {
        Bitmap localBitmap3 = SafeBitmapFactory.decodeFile(paramString1, localOptions);
        Bitmap localBitmap1 = localBitmap3;
        if (localBitmap3 != null) {
          break;
        }
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " bm == null, maybe is broken");
        return 0;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " decodeFile OutOfMemoryError, sampleCnt:" + 1 + " oomKeepCompress:" + paramBoolean);
      }
    } while (!paramBoolean);
    localOptions.inSampleSize = 4;
    for (;;)
    {
      try
      {
        Bitmap localBitmap2 = SafeBitmapFactory.decodeFile(paramString1, localOptions);
        m = 2;
        paramBoolean = Utils.a(paramString2, localBitmap2, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
        if (localBitmap2 != null) {
          localBitmap2.recycle();
        }
        if (paramBoolean) {
          return m;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
        paramString1.printStackTrace();
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " oomKeepCompress decodeFile OutOfMemoryError, sampleCnt:" + 2);
        return 0;
      }
      m = 0;
    }
  }
  
  protected int a()
  {
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g == 2) {
      m = 100;
    }
    for (;;)
    {
      Logger.a(this.jdField_a_of_type_JavaLangString, "getCompressQuality", "compressQuality = " + m);
      return m;
      switch (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.h)
      {
      case 2: 
      case 3: 
      default: 
        m = b;
        break;
      case 1: 
        m = jdField_a_of_type_Int;
        break;
      case 4: 
        m = c;
      }
    }
  }
  
  protected abstract int a(CompressInfo paramCompressInfo);
  
  final boolean a()
  {
    if (this.k == 2) {
      return c();
    }
    return d();
  }
  
  final int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.h == 1) {
      return 20971520;
    }
    return 4194304;
  }
  
  final boolean b()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c))
    {
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " src file does not exist");
      return bool2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " destPath is empty");
        return false;
      }
    }
    if ((FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Boolean))
    {
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " destPath exist. return true");
      return true;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2) {
          continue;
        }
        bool2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, 3);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Logger.b(this.jdField_a_of_type_JavaLangString, "startThumbnail()", localException.getMessage());
        continue;
      }
      bool2 = bool1;
      if (bool1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " compressAIOThumbnail is failed");
      return bool1;
      bool2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, 0);
      bool1 = bool2;
    }
  }
  
  final boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g == 2) {
      if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c) <= 20971520L)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 直接传原图，UI上选择了原图");
        Logger.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", "直接传原图，UI上选择了原图");
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean = true;
        }
      }
    }
    for (;;)
    {
      return true;
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", "直接传原图，UI上选择了原图，该图片 > 最大文件限制");
      continue;
      int m = b();
      if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c) > m)
      {
        Logger.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " src file size > max, file size:" + Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c) + " max:" + m);
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " destPath is empty");
          return false;
        }
        if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " destPath exist. return true");
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.i = 0;
        int n = a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, true);
        if (n != 0)
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
          ((CompressInfo)localObject1).i = (n + ((CompressInfo)localObject1).i);
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) > m)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.i >= 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 面积是原来的1/16，不能再小了fileSize:" + Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) + " max:" + m);
              Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " 面积是原来的1/16，不能再小了fileSize:" + Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) + " max:" + m);
              FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
              return false;
            }
            Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString;
            localObject1 = (String)localObject2 + "_second";
            this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
            n = a((String)localObject2, (String)localObject1, false);
            FileUtils.d((String)localObject2);
            if (n != 0)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
              ((CompressInfo)localObject2).i = (n + ((CompressInfo)localObject2).i);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = ((String)localObject1);
              if (Utils.a((String)localObject1) > m)
              {
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 已经2次sample压缩，长、宽各是原来的1/4；面积是原来的1/16。fileSize:" + Utils.a((String)localObject1) + " max:" + m);
                Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " 已经2次sample压缩，长、宽各是原来的1/4；面积是原来的1/16。fileSize:" + Utils.a((String)localObject1) + " max:" + m);
                FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
                return false;
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 第二次压缩失败");
              Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " 第二次压缩失败");
              return false;
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() sampleCompress failed");
          Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " sampleCompress failed");
          return false;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 直接传原图");
        Logger.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", "直接传原图");
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean = true;
        }
      }
    }
  }
  
  protected abstract boolean d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicType
 * JD-Core Version:    0.7.0.1
 */