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
  public static int j = 960;
  CompressInfo a;
  protected String a;
  protected int k;
  
  PicType(CompressInfo paramCompressInfo)
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    if ((paramCompressInfo != null) && (!TextUtils.isEmpty(paramCompressInfo.c)))
    {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
      int i = a(paramCompressInfo);
      this.k = i;
      if (i != -1) {
        return;
      }
      throw new IllegalArgumentException("create PicQuality is Fail");
    }
    throw new IllegalArgumentException("info == null || TextUtils.isEmpty(info.srcPath)");
  }
  
  protected int a()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g == 2)
    {
      i = 100;
    }
    else
    {
      i = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.h;
      if (i != 1)
      {
        if (i != 4) {
          i = b;
        } else {
          i = c;
        }
      }
      else {
        i = jdField_a_of_type_Int;
      }
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("compressQuality = ");
    localStringBuilder.append(i);
    Logger.a(str, "getCompressQuality", localStringBuilder.toString());
    return i;
  }
  
  protected abstract int a(CompressInfo paramCompressInfo);
  
  public int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int m = 0;
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
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
    localObject1 = this.jdField_a_of_type_JavaLangString;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
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
        paramBoolean = Utils.a(paramString2, paramString1, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
        if (paramString1 != null) {
          paramString1.recycle();
        }
        if (paramBoolean) {
          m = i;
        }
        return m;
      }
      catch (OutOfMemoryError paramString1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
        paramString1.printStackTrace();
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder();
        paramString2.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        paramString2.append(" sampleCompress()");
        paramString2 = paramString2.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" oomKeepCompress decodeFile OutOfMemoryError, sampleCnt:");
        ((StringBuilder)localObject1).append(2);
        Logger.b(paramString1, paramString2, ((StringBuilder)localObject1).toString());
      }
    }
    return 0;
    localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
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
    boolean bool2 = FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
    boolean bool1 = false;
    Object localObject;
    StringBuilder localStringBuilder;
    if (!bool2)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" startThumbnail()");
      Logger.b(localObject, localStringBuilder.toString(), " src file does not exist");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
      ((CompressInfo)localObject).jdField_e_of_type_JavaLangString = Utils.a(((CompressInfo)localObject).c);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" startThumbnail()");
        Logger.b(localObject, localStringBuilder.toString(), " destPath is empty");
        return false;
      }
    }
    if ((FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" startThumbnail()");
      Logger.b(localObject, localStringBuilder.toString(), " destPath exist. return true");
      return true;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int == 2)
      {
        bool2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_ComTencentMobileqqDataThumbWidthHeightDP);
        bool1 = bool2;
      }
      else
      {
        bool2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_ComTencentMobileqqDataThumbWidthHeightDP);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Logger.b(this.jdField_a_of_type_JavaLangString, "startThumbnail()", localException.getMessage());
    }
    if (!bool1)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
      String str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" startThumbnail()");
      Logger.b(str, localStringBuilder.toString(), " compressAIOThumbnail is failed");
    }
    return bool1;
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
    if (this.k == 2) {
      return c();
    }
    return d();
  }
  
  final boolean c()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g == 2)
    {
      if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c) <= ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
        ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString = ((CompressInfo)localObject1).c;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708169));
        ((CompressInfo)localObject1).jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" commonCompress()");
        Logger.a(localObject1, ((StringBuilder)localObject2).toString(), HardCodeUtil.a(2131708168));
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean = true;
          return true;
        }
      }
      else
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" commonCompress()");
        Logger.b(localObject1, ((StringBuilder)localObject2).toString(), HardCodeUtil.a(2131708173));
        return true;
      }
    }
    else
    {
      int i = b();
      long l1 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
      long l2 = i;
      if (l1 > l2)
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" commonCompress()");
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" src file size > max, file size:");
        ((StringBuilder)localObject3).append(Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c));
        ((StringBuilder)localObject3).append(" max:");
        ((StringBuilder)localObject3).append(i);
        Logger.a(localObject1, (String)localObject2, ((StringBuilder)localObject3).toString());
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
        ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString = Utils.a(((CompressInfo)localObject1).c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(" commonCompress()");
          Logger.b(localObject1, ((StringBuilder)localObject2).toString(), " destPath is empty");
          return false;
        }
        if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(" commonCompress()");
          Logger.b(localObject1, ((StringBuilder)localObject2).toString(), " destPath exist. return true");
          return true;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
        ((CompressInfo)localObject1).i = 0;
        int m = a(((CompressInfo)localObject1).c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, true);
        if (m != 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
          ((CompressInfo)localObject1).i += m;
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) > l2)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.i >= 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject2).append(" commonCompress() 面积是原来的1/16，不能再小了fileSize:");
              ((StringBuilder)localObject2).append(Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString));
              ((StringBuilder)localObject2).append(" max:");
              ((StringBuilder)localObject2).append(i);
              ((CompressInfo)localObject1).jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
              localObject1 = this.jdField_a_of_type_JavaLangString;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject2).append(" commonCompress()");
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(" 面积是原来的1/16，不能再小了fileSize:");
              ((StringBuilder)localObject3).append(Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString));
              ((StringBuilder)localObject3).append(" max:");
              ((StringBuilder)localObject3).append(i);
              Logger.b(localObject1, (String)localObject2, ((StringBuilder)localObject3).toString());
              FileUtils.deleteFile(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
              return false;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("_second");
            localObject1 = ((StringBuilder)localObject1).toString();
            this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
            m = a((String)localObject2, (String)localObject1, false);
            FileUtils.deleteFile((String)localObject2);
            if (m != 0)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
              ((CompressInfo)localObject2).i += m;
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = ((String)localObject1);
              if (Utils.a((String)localObject1) > l2)
              {
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
                ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
                ((StringBuilder)localObject3).append(" commonCompress()");
                ((StringBuilder)localObject3).append(HardCodeUtil.a(2131708174));
                ((StringBuilder)localObject3).append(Utils.a((String)localObject1));
                ((StringBuilder)localObject3).append(" max:");
                ((StringBuilder)localObject3).append(i);
                ((CompressInfo)localObject2).jdField_f_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
                localObject2 = this.jdField_a_of_type_JavaLangString;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
                ((StringBuilder)localObject3).append(" commonCompress()");
                localObject3 = ((StringBuilder)localObject3).toString();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(HardCodeUtil.a(2131708175));
                localStringBuilder.append(Utils.a((String)localObject1));
                localStringBuilder.append(" max:");
                localStringBuilder.append(i);
                Logger.b(localObject2, (String)localObject3, localStringBuilder.toString());
                FileUtils.deleteFile(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
                return false;
              }
            }
            else
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
              ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString = "";
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject2).append(" commonCompress()");
              ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708172));
              ((CompressInfo)localObject1).jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
              localObject1 = this.jdField_a_of_type_JavaLangString;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject2).append(" commonCompress()");
              Logger.b(localObject1, ((StringBuilder)localObject2).toString(), HardCodeUtil.a(2131708170));
              return false;
            }
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
          ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString = "";
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(" commonCompress() sampleCompress failed");
          ((CompressInfo)localObject1).jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(" commonCompress()");
          Logger.b(localObject1, ((StringBuilder)localObject2).toString(), " sampleCompress failed");
          return false;
        }
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
        ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString = ((CompressInfo)localObject1).c;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708176));
        ((CompressInfo)localObject1).jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" commonCompress()");
        Logger.a(localObject1, ((StringBuilder)localObject2).toString(), HardCodeUtil.a(2131708171));
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean = true;
        }
      }
    }
    return true;
  }
  
  protected abstract boolean d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicType
 * JD-Core Version:    0.7.0.1
 */