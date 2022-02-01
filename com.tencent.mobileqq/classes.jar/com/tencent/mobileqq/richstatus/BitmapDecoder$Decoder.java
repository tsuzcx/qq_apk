package com.tencent.mobileqq.richstatus;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;

class BitmapDecoder$Decoder
  extends AsyncTask<Void, Bitmap, Bitmap>
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public BitmapDecoder$Decoder(BitmapDecoder paramBitmapDecoder, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  private Bitmap a(File paramFile)
  {
    boolean bool = paramFile.exists();
    Bitmap localBitmap1 = null;
    Bitmap localBitmap2 = null;
    if (bool) {
      localBitmap2 = localBitmap1;
    }
    try
    {
      localBitmap1 = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath());
      localBitmap2 = localBitmap1;
      if (localBitmap1 == null)
      {
        localBitmap2 = localBitmap1;
        paramFile.delete();
        localBitmap2 = localBitmap1;
      }
      return localBitmap2;
    }
    catch (OutOfMemoryError paramFile) {}
    return localBitmap2;
  }
  
  protected Bitmap a(Void... paramVarArgs)
  {
    Object localObject2 = BitmapDecoder.a();
    Object localObject1 = null;
    paramVarArgs = null;
    if (localObject2 != null)
    {
      localObject1 = new File((File)localObject2, this.jdField_a_of_type_JavaLangString);
      boolean bool3 = ((File)localObject1).exists();
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (!bool3)
      {
        if (!TextUtils.isEmpty(this.b))
        {
          localObject2 = a(new File((File)localObject2, this.b));
          if (localObject2 != null) {
            publishProgress(new Bitmap[] { localObject2 });
          }
        }
        bool1 = bool2;
        if (this.c != null)
        {
          if ((BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder) > 3L) && (Math.abs(SystemClock.uptimeMillis() - BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder)) > 60000L)) {
            BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder, 0L);
          }
          bool1 = bool2;
          if (BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder) < 3L) {
            bool1 = BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder, this.c, (File)localObject1);
          }
        }
      }
      if (bool1) {
        paramVarArgs = a((File)localObject1);
      }
      if ((bool1) && (paramVarArgs != null))
      {
        BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder, 0L);
        localObject1 = paramVarArgs;
      }
      else
      {
        localObject1 = paramVarArgs;
        if (!TextUtils.isEmpty(this.c))
        {
          localObject1 = paramVarArgs;
          if (BitmapDecoder.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder) == 3L)
          {
            BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder, SystemClock.uptimeMillis());
            localObject1 = paramVarArgs;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("decodeBitmap finish with ");
      paramVarArgs.append(localObject1);
      paramVarArgs.append(", ");
      paramVarArgs.append(BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder));
      QLog.d("Q.richstatus.img", 2, paramVarArgs.toString());
    }
    return localObject1;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      MQLruCache localMQLruCache = GlobalImageCache.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder));
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localMQLruCache.put(localStringBuilder.toString(), paramBitmap, (byte)0);
    }
    BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder).remove(this.jdField_a_of_type_JavaLangString);
    if (BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder) != null) {
      BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder).a(this.jdField_a_of_type_JavaLangString, this.c, paramBitmap, 1);
    }
  }
  
  protected void a(Bitmap... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    MQLruCache localMQLruCache = GlobalImageCache.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder));
    localStringBuilder.append(this.b);
    localMQLruCache.put(localStringBuilder.toString(), paramVarArgs, (byte)0);
    if (BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder) != null) {
      BitmapDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder).a(this.jdField_a_of_type_JavaLangString, this.c, paramVarArgs, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.BitmapDecoder.Decoder
 * JD-Core Version:    0.7.0.1
 */