package com.tencent.mobileqq.troop.homework.arithmetic.stream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.arithmetic.ArithmeticUtils;
import com.tencent.mobileqq.troop.homework.arithmetic.data.ArithResult;
import com.tencent.mobileqq.troop.homework.arithmetic.data.ArithResult.Item;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import mqq.app.AppRuntime;

public class UploadImageSegment
  extends JobSegment<Bitmap, String>
  implements TroopHomeworkHelper.UploadCallback
{
  private int jdField_a_of_type_Int;
  private ArithResult jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public UploadImageSegment(String paramString, ArithResult paramArithResult, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult = paramArithResult;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Canvas paramCanvas, int paramInt5, Bitmap paramBitmap, Paint paramPaint)
  {
    paramCanvas.drawRoundRect(new RectF(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), paramInt5, paramInt5, paramPaint);
    paramCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(paramInt1 + paramInt3 + this.b * 2, paramInt4 / 4 + paramInt2, paramInt1 + paramInt3 + this.b * 3 + paramInt4 / 2, paramInt4 * 3 / 4 + paramInt2), null);
  }
  
  /* Error */
  private boolean a(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 6
    //   11: astore_3
    //   12: new 63	java/io/File
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload 6
    //   23: astore_3
    //   24: aload_2
    //   25: invokevirtual 70	java/io/File:exists	()Z
    //   28: ifne +147 -> 175
    //   31: aload 6
    //   33: astore_3
    //   34: aload_2
    //   35: invokevirtual 74	java/io/File:getParentFile	()Ljava/io/File;
    //   38: invokevirtual 70	java/io/File:exists	()Z
    //   41: ifne +71 -> 112
    //   44: aload 6
    //   46: astore_3
    //   47: aload_2
    //   48: invokevirtual 74	java/io/File:getParentFile	()Ljava/io/File;
    //   51: invokevirtual 77	java/io/File:mkdirs	()Z
    //   54: ifne +58 -> 112
    //   57: aload 6
    //   59: astore_3
    //   60: ldc 79
    //   62: ldc 81
    //   64: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: iconst_0
    //   68: ifeq +11 -> 79
    //   71: new 89	java/lang/NullPointerException
    //   74: dup
    //   75: invokespecial 90	java/lang/NullPointerException:<init>	()V
    //   78: athrow
    //   79: iconst_0
    //   80: ireturn
    //   81: astore_1
    //   82: ldc 79
    //   84: new 92	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   91: ldc 95
    //   93: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_1
    //   107: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   110: iconst_0
    //   111: ireturn
    //   112: aload 6
    //   114: astore_3
    //   115: aload_2
    //   116: invokevirtual 112	java/io/File:createNewFile	()Z
    //   119: ifne +56 -> 175
    //   122: aload 6
    //   124: astore_3
    //   125: ldc 79
    //   127: ldc 114
    //   129: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: iconst_0
    //   133: ifeq -54 -> 79
    //   136: new 89	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 90	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: astore_1
    //   145: ldc 79
    //   147: new 92	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   154: ldc 95
    //   156: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_1
    //   170: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   173: iconst_0
    //   174: ireturn
    //   175: aload 6
    //   177: astore_3
    //   178: new 116	java/io/BufferedOutputStream
    //   181: dup
    //   182: new 118	java/io/FileOutputStream
    //   185: dup
    //   186: aload_2
    //   187: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   190: invokespecial 124	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   193: astore_2
    //   194: aload_1
    //   195: getstatic 130	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   198: bipush 100
    //   200: aload_2
    //   201: invokevirtual 134	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   204: pop
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 137	java/io/BufferedOutputStream:close	()V
    //   213: iconst_1
    //   214: ireturn
    //   215: astore_1
    //   216: ldc 79
    //   218: new 92	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   225: ldc 95
    //   227: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_1
    //   231: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload_1
    //   241: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   244: goto -31 -> 213
    //   247: astore_2
    //   248: aload 4
    //   250: astore_1
    //   251: aload_1
    //   252: astore_3
    //   253: aload_2
    //   254: invokevirtual 138	java/io/FileNotFoundException:printStackTrace	()V
    //   257: aload_1
    //   258: astore_3
    //   259: ldc 79
    //   261: new 92	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   268: ldc 140
    //   270: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_2
    //   274: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_1
    //   284: ifnull -205 -> 79
    //   287: aload_1
    //   288: invokevirtual 137	java/io/BufferedOutputStream:close	()V
    //   291: iconst_0
    //   292: ireturn
    //   293: astore_1
    //   294: ldc 79
    //   296: new 92	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   303: ldc 95
    //   305: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_1
    //   309: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload_1
    //   319: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   322: iconst_0
    //   323: ireturn
    //   324: astore_2
    //   325: aload 5
    //   327: astore_1
    //   328: aload_1
    //   329: astore_3
    //   330: aload_2
    //   331: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   334: aload_1
    //   335: astore_3
    //   336: ldc 79
    //   338: new 92	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   345: ldc 140
    //   347: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_2
    //   351: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_1
    //   361: ifnull -148 -> 213
    //   364: aload_1
    //   365: invokevirtual 137	java/io/BufferedOutputStream:close	()V
    //   368: goto -155 -> 213
    //   371: astore_1
    //   372: ldc 79
    //   374: new 92	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   381: ldc 95
    //   383: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_1
    //   387: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload_1
    //   397: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   400: goto -187 -> 213
    //   403: astore_1
    //   404: aload_3
    //   405: ifnull +7 -> 412
    //   408: aload_3
    //   409: invokevirtual 137	java/io/BufferedOutputStream:close	()V
    //   412: aload_1
    //   413: athrow
    //   414: astore_2
    //   415: ldc 79
    //   417: new 92	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   424: ldc 95
    //   426: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_2
    //   430: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload_2
    //   440: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   443: goto -31 -> 412
    //   446: astore_1
    //   447: aload_2
    //   448: astore_3
    //   449: goto -45 -> 404
    //   452: astore_3
    //   453: aload_2
    //   454: astore_1
    //   455: aload_3
    //   456: astore_2
    //   457: goto -129 -> 328
    //   460: astore_3
    //   461: aload_2
    //   462: astore_1
    //   463: aload_3
    //   464: astore_2
    //   465: goto -214 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	UploadImageSegment
    //   0	468	1	paramBitmap	Bitmap
    //   0	468	2	paramString	String
    //   11	438	3	localObject1	java.lang.Object
    //   452	4	3	localIOException	java.io.IOException
    //   460	4	3	localFileNotFoundException	java.io.FileNotFoundException
    //   7	242	4	localObject2	java.lang.Object
    //   1	325	5	localObject3	java.lang.Object
    //   4	172	6	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   71	79	81	java/io/IOException
    //   136	144	144	java/io/IOException
    //   209	213	215	java/io/IOException
    //   12	21	247	java/io/FileNotFoundException
    //   24	31	247	java/io/FileNotFoundException
    //   34	44	247	java/io/FileNotFoundException
    //   47	57	247	java/io/FileNotFoundException
    //   60	67	247	java/io/FileNotFoundException
    //   115	122	247	java/io/FileNotFoundException
    //   125	132	247	java/io/FileNotFoundException
    //   178	194	247	java/io/FileNotFoundException
    //   287	291	293	java/io/IOException
    //   12	21	324	java/io/IOException
    //   24	31	324	java/io/IOException
    //   34	44	324	java/io/IOException
    //   47	57	324	java/io/IOException
    //   60	67	324	java/io/IOException
    //   115	122	324	java/io/IOException
    //   125	132	324	java/io/IOException
    //   178	194	324	java/io/IOException
    //   364	368	371	java/io/IOException
    //   12	21	403	finally
    //   24	31	403	finally
    //   34	44	403	finally
    //   47	57	403	finally
    //   60	67	403	finally
    //   115	122	403	finally
    //   125	132	403	finally
    //   178	194	403	finally
    //   253	257	403	finally
    //   259	283	403	finally
    //   330	334	403	finally
    //   336	360	403	finally
    //   408	412	414	java/io/IOException
    //   194	205	446	finally
    //   194	205	452	java/io/IOException
    //   194	205	460	java/io/FileNotFoundException
  }
  
  public void a(int paramInt)
  {
    SLog.b("QQ.Troop.homework.UploadImageSegment", "onProgress");
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    SLog.d("QQ.Troop.homework.UploadImageSegment", "runSegment source w=" + paramBitmap.getWidth() + ",h=" + paramBitmap.getHeight());
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    this.b = UIUtils.a(BaseApplicationImpl.getApplication().getBaseContext(), 1.0F);
    try
    {
      paramJobContext = paramBitmap.copy(paramBitmap.getConfig(), true);
      if (paramJobContext == null)
      {
        SLog.e("QQ.Troop.homework.UploadImageSegment", "bitmap is null");
        return;
      }
    }
    catch (OutOfMemoryError paramJobContext)
    {
      for (;;)
      {
        SLog.e("QQ.Troop.homework.UploadImageSegment", "draw bitmap out of memory");
        notifyError(new ErrorMessage(-97, "QQ.Troop.homework.UploadImageSegment draw bitmap out of memory"));
        paramJobContext = null;
      }
      paramBitmap = new Canvas(paramJobContext);
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setColor(-65536);
      localPaint.setAntiAlias(true);
      localPaint.setStrokeWidth(this.b);
      for (;;)
      {
        Bitmap localBitmap;
        ArithResult.Item localItem;
        try
        {
          localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130846510);
          int i = 0;
          if (i >= this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult.a()) {
            break;
          }
          localItem = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult.a(i);
          if (localItem.a)
          {
            i += 1;
            continue;
          }
          j = localItem.b;
        }
        catch (OutOfMemoryError paramJobContext)
        {
          SLog.e("QQ.Troop.homework.UploadImageSegment", "draw maskBmp out of memory");
          notifyError(new ErrorMessage(-97, "QQ.Troop.homework.UploadImageSegment draw maskBmp out of memory"));
          return;
        }
        int j;
        int k = this.b;
        int m = localItem.c;
        int n = this.b;
        int i1 = localItem.d;
        int i2 = this.b;
        int i3 = localItem.e;
        a(j - k, m - n, i1 + i2 * 2, this.b * 2 + i3, paramBitmap, this.jdField_a_of_type_Int, localBitmap, localPaint);
      }
      paramBitmap = ArithmeticUtils.b + "temp.png";
      if (!a(paramJobContext, paramBitmap))
      {
        notifyError(new ErrorMessage(-1, "save file to sdCard error!"));
        return;
      }
      paramJobContext = new TroopHomeworkHelper.UploadFileTask(localAppRuntime, paramBitmap, this.jdField_a_of_type_JavaLangString);
      paramJobContext.a(this);
      paramJobContext.a();
    }
  }
  
  public void a(String paramString)
  {
    SLog.d("QQ.Troop.homework.UploadImageSegment", "upload file completed");
    notifyResult(paramString);
  }
  
  public void b(int paramInt)
  {
    SLog.e("QQ.Troop.homework.UploadImageSegment", "upload file failed,code=" + paramInt);
    notifyError(new ErrorMessage(-2, "upload error !!return error code=" + paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.stream.UploadImageSegment
 * JD-Core Version:    0.7.0.1
 */