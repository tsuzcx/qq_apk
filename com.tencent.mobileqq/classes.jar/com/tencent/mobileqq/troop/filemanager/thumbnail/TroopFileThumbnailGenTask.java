package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import android.util.Pair;
import atvo;
import atwl;
import auxv;
import auyg;
import ayzh;
import bevg;
import bevx;
import bexo;
import bexp;
import bexq;
import bfsj;
import bfuj;
import bgmg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class TroopFileThumbnailGenTask
  implements Runnable
{
  protected int a;
  protected long a;
  protected bexp a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  protected Timer a;
  protected boolean a;
  protected String b;
  protected boolean b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  
  protected TroopFileThumbnailGenTask(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString, bexp parambexp)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Bexp = parambexp;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = bexo.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id, paramInt);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile)) {}
    for (paramItem = atwl.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);; paramItem = atwl.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName))
    {
      if (atvo.a(paramItem) == 2) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      this.f = paramString;
      return;
    }
    this.f = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile;
  }
  
  public static TroopFileThumbnailGenTask a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString, bexp parambexp)
  {
    if (paramLong == 0L)
    {
      bevx.a("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "getTask. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bevx.a("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "getTask. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bevx.a("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "getTask. item.id=null");
      return null;
    }
    if (paramInt == 0)
    {
      bevx.a("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "getTask. nThumbSize=0");
      return null;
    }
    if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(paramItem.LocalFile)))
    {
      bevx.a("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "getTask. localfilepath=null");
      return null;
    }
    return new TroopFileThumbnailGenTask(paramLong, paramItem, paramInt, paramString, parambexp);
  }
  
  private void a(long paramLong)
  {
    try
    {
      e();
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new TroopFileThumbnailGenTask.2(this), paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private int b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: aload_0
    //   2: getfield 70	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:f	Ljava/lang/String;
    //   5: invokestatic 126	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +80 -> 90
    //   13: aload_0
    //   14: getfield 128	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:d	Ljava/lang/String;
    //   17: invokestatic 133	bgmg:d	(Ljava/lang/String;)Z
    //   20: pop
    //   21: new 135	com/tencent/mm/vfs/VFSFile
    //   24: dup
    //   25: aload_0
    //   26: getfield 128	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:d	Ljava/lang/String;
    //   29: invokespecial 138	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 142	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   37: pop
    //   38: new 144	java/io/BufferedOutputStream
    //   41: dup
    //   42: new 146	java/io/FileOutputStream
    //   45: dup
    //   46: aload_0
    //   47: getfield 128	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:d	Ljava/lang/String;
    //   50: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   53: invokespecial 150	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: getstatic 156	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   63: bipush 100
    //   65: aload_2
    //   66: invokevirtual 162	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   69: pop
    //   70: aload_2
    //   71: astore_1
    //   72: aload_3
    //   73: invokevirtual 165	android/graphics/Bitmap:recycle	()V
    //   76: aload_2
    //   77: astore_1
    //   78: aload_2
    //   79: invokevirtual 168	java/io/BufferedOutputStream:flush	()V
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 171	java/io/BufferedOutputStream:close	()V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore_1
    //   93: bipush 254
    //   95: ireturn
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_1
    //   104: bipush 253
    //   106: ireturn
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: aload_3
    //   113: invokevirtual 175	java/io/FileNotFoundException:printStackTrace	()V
    //   116: aload_2
    //   117: ifnull +45 -> 162
    //   120: aload_2
    //   121: invokevirtual 171	java/io/BufferedOutputStream:close	()V
    //   124: iconst_m1
    //   125: ireturn
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   131: iconst_m1
    //   132: ireturn
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 171	java/io/BufferedOutputStream:close	()V
    //   144: aload_2
    //   145: athrow
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_2
    //   155: goto -19 -> 136
    //   158: astore_3
    //   159: goto -49 -> 110
    //   162: iconst_m1
    //   163: ireturn
    //   164: astore_1
    //   165: bipush 252
    //   167: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	TroopFileThumbnailGenTask
    //   32	46	1	localObject1	Object
    //   92	1	1	localIOException	IOException
    //   96	2	1	localException1	Exception
    //   103	1	1	localException2	Exception
    //   111	1	1	localObject2	Object
    //   126	2	1	localException3	Exception
    //   135	6	1	localObject3	Object
    //   146	2	1	localException4	Exception
    //   164	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   56	65	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   133	12	2	localObject4	Object
    //   154	1	2	localObject5	Object
    //   8	65	3	localBitmap	android.graphics.Bitmap
    //   107	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   158	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   33	38	92	java/io/IOException
    //   86	90	96	java/lang/Exception
    //   0	9	103	java/lang/Exception
    //   13	33	103	java/lang/Exception
    //   33	38	103	java/lang/Exception
    //   97	101	103	java/lang/Exception
    //   127	131	103	java/lang/Exception
    //   144	146	103	java/lang/Exception
    //   147	151	103	java/lang/Exception
    //   38	57	107	java/io/FileNotFoundException
    //   120	124	126	java/lang/Exception
    //   38	57	133	finally
    //   140	144	146	java/lang/Exception
    //   59	70	154	finally
    //   72	76	154	finally
    //   78	82	154	finally
    //   112	116	154	finally
    //   59	70	158	java/io/FileNotFoundException
    //   72	76	158	java/io/FileNotFoundException
    //   78	82	158	java/io/FileNotFoundException
    //   0	9	164	java/lang/OutOfMemoryError
    //   13	33	164	java/lang/OutOfMemoryError
    //   33	38	164	java/lang/OutOfMemoryError
    //   86	90	164	java/lang/OutOfMemoryError
    //   97	101	164	java/lang/OutOfMemoryError
    //   120	124	164	java/lang/OutOfMemoryError
    //   127	131	164	java/lang/OutOfMemoryError
    //   140	144	164	java/lang/OutOfMemoryError
    //   144	146	164	java/lang/OutOfMemoryError
    //   147	151	164	java/lang/OutOfMemoryError
  }
  
  private int c()
  {
    int i = 1;
    if ((this.jdField_a_of_type_Int == 383) || (this.jdField_a_of_type_Int == 640)) {
      if (this.jdField_a_of_type_Int == 640) {
        i = 2;
      }
    }
    while (bfsj.a(this.f, this.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int)) {
      try
      {
        boolean bool = ayzh.a(this.f, this.d, true, "", i);
        if (!bool) {
          break;
        }
        return 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return -2;
      }
    }
    return -1;
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bevx.c("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped");
      return;
    }
    bevx.c("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop.");
    e();
    this.jdField_a_of_type_Boolean = true;
    bexq.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.d)) {
      bgmg.d(this.d);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    bevg.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      bevx.b("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onGenErr but had stop. errCode:" + paramInt);
    }
    do
    {
      return;
      e();
      this.jdField_a_of_type_Boolean = true;
      if (!TextUtils.isEmpty(this.d)) {
        bgmg.d(this.d);
      }
      bexq.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
      bevx.a("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onGenErr  errCode:" + paramInt + " passvieErr:" + paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      bevg.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    } while ((paramBoolean) || (this.jdField_a_of_type_Bexp == null));
    this.jdField_a_of_type_Bexp.a(a(), false, paramInt, this);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ThreadManager.post(new TroopFileThumbnailGenTask.1(this, paramBoolean, paramInt, paramString), 5, null, true);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bevx.b("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] doSuc but had stop.");
      return;
    }
    e();
    this.jdField_a_of_type_Boolean = true;
    if ((!paramBoolean1) && (!atvo.a(new VFSFile(this.d), new VFSFile(this.e))))
    {
      bevx.a("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.e);
      if (bgmg.b(this.e))
      {
        a(bfuj.o, false);
        return;
      }
    }
    d();
    bevx.c("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onGenSuc  mFilePath:" + this.e + " bHit:" + paramBoolean1 + " bPassiveEnd:" + paramBoolean2);
    if (!paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    }
    Object localObject1;
    if (auyg.a().i()) {
      if (this.f.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile)) {
        localObject1 = new File(this.e);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = auxv.a(BaseApplicationImpl.getContext(), (File)localObject1);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.strQRUrl = ((StringBuilder)((Pair)localObject1).first).toString();
          if (QLog.isDevelopLevel()) {
            QLog.i("IMG_FILE_QR", 1, "TroopFIleThumbGenTask success:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.strQRUrl);
          }
          bevg.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
          bevg.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
          if ((paramBoolean2) || (this.jdField_a_of_type_Bexp == null)) {
            break;
          }
          this.jdField_a_of_type_Bexp.a(a(), true, 0, this);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.i("IMG_FILE_QR", 2, "JumpShareUtils.getQRCodeResult crash");
        }
        Object localObject2 = null;
        continue;
        if (auxv.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.strQRUrl = null;
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.strQRUrl = "";
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("IMG_FILE", 1, "choushane false!");
      }
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    a(90000L);
    bevx.c("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start.");
    ThreadManager.post(this, 5, null, true);
    return true;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void b()
  {
    bevx.c("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] passiveStart.");
    this.jdField_a_of_type_Boolean = false;
    a(90000L);
  }
  
  public String c()
  {
    return this.e;
  }
  
  protected void c()
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.c))) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = bexq.a();
    this.c = this.jdField_b_of_type_JavaLangString;
  }
  
  protected void d()
  {
    bexq.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    bexq.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, this.e);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bevx.b("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] run genThumb. but had stop");
      return;
    }
    c();
    this.e = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    this.d = (this.e + ".ttmp");
    bevx.c("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] run genThumb. mTmpFilePath:" + this.d + " thumbPath:" + this.e);
    if (bgmg.b(this.e))
    {
      bevx.b("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] thumb had exsited");
      a(true, false);
      return;
    }
    if (!bgmg.b(this.f))
    {
      bevx.b("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] origfile is no exsit");
      a(-111, false);
      return;
    }
    bgmg.d(this.d);
    VFSFile localVFSFile = new VFSFile(this.d);
    for (;;)
    {
      try
      {
        localVFSFile.createNewFile();
        if (this.jdField_b_of_type_Boolean)
        {
          i = b();
          if (i == 0) {
            break;
          }
          a(i, false);
          return;
        }
      }
      catch (IOException localIOException)
      {
        a(-1, false);
        return;
      }
      int i = c();
    }
    a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask
 * JD-Core Version:    0.7.0.1
 */