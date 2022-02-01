package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class TroopFileThumbnailGenTask
  implements Runnable
{
  protected int a;
  protected long a;
  protected TroopFileThumbnailGenTask.ITroopFileThumbGenTaskListener a;
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
  
  protected TroopFileThumbnailGenTask(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString, TroopFileThumbnailGenTask.ITroopFileThumbGenTaskListener paramITroopFileThumbGenTaskListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask$ITroopFileThumbGenTaskListener = paramITroopFileThumbGenTaskListener;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = TroopFileThumbnailGenMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id, paramInt);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile)) {}
    for (paramItem = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);; paramItem = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName))
    {
      if (FileManagerUtil.a(paramItem) == 2) {
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
  
  public static TroopFileThumbnailGenTask a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString, TroopFileThumbnailGenTask.ITroopFileThumbGenTaskListener paramITroopFileThumbGenTaskListener)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTask. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTask. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTask. item.id=null");
      return null;
    }
    if (paramInt == 0)
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTask. nThumbSize=0");
      return null;
    }
    if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(paramItem.LocalFile)))
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTask. localfilepath=null");
      return null;
    }
    return new TroopFileThumbnailGenTask(paramLong, paramItem, paramInt, paramString, paramITroopFileThumbGenTaskListener);
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
    //   5: invokestatic 127	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +80 -> 90
    //   13: aload_0
    //   14: getfield 129	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:d	Ljava/lang/String;
    //   17: invokestatic 134	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   20: pop
    //   21: new 136	com/tencent/mm/vfs/VFSFile
    //   24: dup
    //   25: aload_0
    //   26: getfield 129	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:d	Ljava/lang/String;
    //   29: invokespecial 139	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 143	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   37: pop
    //   38: new 145	java/io/BufferedOutputStream
    //   41: dup
    //   42: new 147	java/io/FileOutputStream
    //   45: dup
    //   46: aload_0
    //   47: getfield 129	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:d	Ljava/lang/String;
    //   50: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   53: invokespecial 151	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: getstatic 157	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   63: bipush 100
    //   65: aload_2
    //   66: invokevirtual 163	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   69: pop
    //   70: aload_2
    //   71: astore_1
    //   72: aload_3
    //   73: invokevirtual 166	android/graphics/Bitmap:recycle	()V
    //   76: aload_2
    //   77: astore_1
    //   78: aload_2
    //   79: invokevirtual 169	java/io/BufferedOutputStream:flush	()V
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 172	java/io/BufferedOutputStream:close	()V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore_1
    //   93: bipush 254
    //   95: ireturn
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 175	java/lang/Exception:printStackTrace	()V
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
    //   113: invokevirtual 176	java/io/FileNotFoundException:printStackTrace	()V
    //   116: aload_2
    //   117: ifnull +45 -> 162
    //   120: aload_2
    //   121: invokevirtual 172	java/io/BufferedOutputStream:close	()V
    //   124: iconst_m1
    //   125: ireturn
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   131: iconst_m1
    //   132: ireturn
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 172	java/io/BufferedOutputStream:close	()V
    //   144: aload_2
    //   145: athrow
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 175	java/lang/Exception:printStackTrace	()V
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
    while (TroopFileUtils.a(this.f, this.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int)) {
      try
      {
        boolean bool = Utils.a(this.f, this.d, true, "", i);
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
      TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped");
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop.");
    e();
    this.jdField_a_of_type_Boolean = true;
    TroopFileThumbnailMgr.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.d)) {
      FileUtils.e(this.d);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onGenErr but had stop. errCode:" + paramInt);
    }
    do
    {
      return;
      e();
      this.jdField_a_of_type_Boolean = true;
      if (!TextUtils.isEmpty(this.d)) {
        FileUtils.e(this.d);
      }
      TroopFileThumbnailMgr.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onGenErr  errCode:" + paramInt + " passvieErr:" + paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    } while ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask$ITroopFileThumbGenTaskListener == null));
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask$ITroopFileThumbGenTaskListener.a(a(), false, paramInt, this);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ThreadManager.post(new TroopFileThumbnailGenTask.1(this, paramBoolean, paramInt, paramString), 5, null, true);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] doSuc but had stop.");
      return;
    }
    e();
    this.jdField_a_of_type_Boolean = true;
    if ((!paramBoolean1) && (!FileManagerUtil.a(new VFSFile(this.d), new VFSFile(this.e))))
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.e);
      if (FileUtils.b(this.e))
      {
        a(TroopTechReportUtils.TroopFileReportResultCode.o, false);
        return;
      }
    }
    d();
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onGenSuc  mFilePath:" + this.e + " bHit:" + paramBoolean1 + " bPassiveEnd:" + paramBoolean2);
    if (!paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    }
    Object localObject1;
    if (ZhuoXusManager.a().i()) {
      if (this.f.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile)) {
        localObject1 = new File(this.e);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = JumpShareUtils.a(BaseApplicationImpl.getContext(), (File)localObject1);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.strQRUrl = ((StringBuilder)((Pair)localObject1).first).toString();
          if (QLog.isDevelopLevel()) {
            QLog.i("IMG_FILE_QR", 1, "TroopFIleThumbGenTask success:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.strQRUrl);
          }
          TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
          TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
          if ((paramBoolean2) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask$ITroopFileThumbGenTaskListener == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask$ITroopFileThumbGenTaskListener.a(a(), true, 0, this);
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
        if (JumpShareUtils.jdField_a_of_type_Boolean)
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
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start.");
    ThreadManager.post(this, 5, null, true);
    return true;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] passiveStart.");
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
    this.jdField_b_of_type_JavaLangString = TroopFileThumbnailMgr.a();
    this.c = this.jdField_b_of_type_JavaLangString;
  }
  
  protected void d()
  {
    TroopFileThumbnailMgr.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    TroopFileThumbnailMgr.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, this.e);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] run genThumb. but had stop");
      return;
    }
    c();
    this.e = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    this.d = (this.e + ".ttmp");
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] run genThumb. mTmpFilePath:" + this.d + " thumbPath:" + this.e);
    if (FileUtils.b(this.e))
    {
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] thumb had exsited");
      a(true, false);
      return;
    }
    if (!FileUtils.b(this.f))
    {
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] origfile is no exsit");
      a(-111, false);
      return;
    }
    FileUtils.e(this.d);
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