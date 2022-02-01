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
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
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
  protected long a;
  protected TroopFileTransferManager.Item b;
  protected String c;
  protected boolean d = true;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected int j;
  protected boolean k = false;
  protected TroopFileThumbnailGenTask.ITroopFileThumbGenTaskListener l;
  protected Timer m;
  
  protected TroopFileThumbnailGenTask(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString, TroopFileThumbnailGenTask.ITroopFileThumbGenTaskListener paramITroopFileThumbGenTaskListener)
  {
    this.a = paramLong;
    this.b = paramItem;
    this.l = paramITroopFileThumbGenTaskListener;
    this.j = paramInt;
    this.c = TroopFileThumbnailGenMgr.b(this.b.Id, paramInt);
    if (!TextUtils.isEmpty(this.b.LocalFile)) {
      paramItem = FileUtil.a(this.b.LocalFile);
    } else {
      paramItem = FileUtil.a(this.b.FileName);
    }
    if (FileManagerUtil.c(paramItem) == 2) {
      this.k = true;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.i = paramString;
      return;
    }
    this.i = this.b.LocalFile;
  }
  
  public static TroopFileThumbnailGenTask a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString, TroopFileThumbnailGenTask.ITroopFileThumbGenTaskListener paramITroopFileThumbGenTaskListener)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.b, "getTask. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.b, "getTask. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.b, "getTask. item.id=null");
      return null;
    }
    if (paramInt == 0)
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.b, "getTask. nThumbSize=0");
      return null;
    }
    if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(paramItem.LocalFile)))
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.b, "getTask. localfilepath=null");
      return null;
    }
    return new TroopFileThumbnailGenTask(paramLong, paramItem, paramInt, paramString, paramITroopFileThumbGenTaskListener);
  }
  
  private void a(long paramLong)
  {
    try
    {
      l();
      this.m = new Timer();
      this.m.schedule(new TroopFileThumbnailGenTask.2(this), paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private int j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:i	Ljava/lang/String;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: aload_3
    //   12: invokestatic 135	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   15: astore 5
    //   17: iconst_0
    //   18: istore_1
    //   19: aload 5
    //   21: ifnull +159 -> 180
    //   24: aload_0
    //   25: getfield 137	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:g	Ljava/lang/String;
    //   28: invokestatic 143	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   31: pop
    //   32: new 145	com/tencent/mm/vfs/VFSFile
    //   35: dup
    //   36: aload_0
    //   37: getfield 137	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:g	Ljava/lang/String;
    //   40: invokespecial 148	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   43: astore_3
    //   44: aload_3
    //   45: invokevirtual 152	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   48: pop
    //   49: new 154	java/io/BufferedOutputStream
    //   52: dup
    //   53: new 156	java/io/FileOutputStream
    //   56: dup
    //   57: aload_0
    //   58: getfield 137	com/tencent/mobileqq/troop/filemanager/thumbnail/TroopFileThumbnailGenTask:g	Ljava/lang/String;
    //   61: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   64: invokespecial 160	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore_3
    //   68: aload 5
    //   70: getstatic 166	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   73: bipush 100
    //   75: aload_3
    //   76: invokevirtual 172	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   79: pop
    //   80: aload 5
    //   82: invokevirtual 175	android/graphics/Bitmap:recycle	()V
    //   85: aload_3
    //   86: invokevirtual 178	java/io/BufferedOutputStream:flush	()V
    //   89: aload_3
    //   90: invokevirtual 181	java/io/BufferedOutputStream:close	()V
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_2
    //   96: aload_2
    //   97: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore 4
    //   104: aload_3
    //   105: astore_2
    //   106: aload 4
    //   108: astore_3
    //   109: goto +44 -> 153
    //   112: astore 4
    //   114: goto +14 -> 128
    //   117: astore_3
    //   118: goto +35 -> 153
    //   121: astore_2
    //   122: aload 4
    //   124: astore_3
    //   125: aload_2
    //   126: astore 4
    //   128: aload_3
    //   129: astore_2
    //   130: aload 4
    //   132: invokevirtual 185	java/io/FileNotFoundException:printStackTrace	()V
    //   135: aload_3
    //   136: ifnull +15 -> 151
    //   139: aload_3
    //   140: invokevirtual 181	java/io/BufferedOutputStream:close	()V
    //   143: goto +8 -> 151
    //   146: astore_2
    //   147: aload_2
    //   148: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   151: iconst_m1
    //   152: ireturn
    //   153: aload_2
    //   154: ifnull +15 -> 169
    //   157: aload_2
    //   158: invokevirtual 181	java/io/BufferedOutputStream:close	()V
    //   161: goto +8 -> 169
    //   164: astore_2
    //   165: aload_2
    //   166: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   169: aload_3
    //   170: athrow
    //   171: bipush 254
    //   173: ireturn
    //   174: bipush 252
    //   176: ireturn
    //   177: bipush 253
    //   179: istore_1
    //   180: iload_1
    //   181: ireturn
    //   182: astore_2
    //   183: goto -6 -> 177
    //   186: astore_2
    //   187: goto -13 -> 174
    //   190: astore_2
    //   191: goto -20 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	TroopFileThumbnailGenTask
    //   18	163	1	n	int
    //   9	1	2	localObject1	Object
    //   95	2	2	localException1	Exception
    //   105	1	2	localObject2	Object
    //   121	5	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   129	1	2	localObject3	Object
    //   146	12	2	localException2	Exception
    //   164	2	2	localException3	Exception
    //   182	1	2	localException4	Exception
    //   186	1	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   190	1	2	localIOException	IOException
    //   4	105	3	localObject4	Object
    //   117	1	3	localObject5	Object
    //   124	46	3	localObject6	Object
    //   6	1	4	localObject7	Object
    //   102	5	4	localObject8	Object
    //   112	11	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   126	5	4	localObject9	Object
    //   15	66	5	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   89	93	95	java/lang/Exception
    //   68	89	102	finally
    //   68	89	112	java/io/FileNotFoundException
    //   49	68	117	finally
    //   130	135	117	finally
    //   49	68	121	java/io/FileNotFoundException
    //   139	143	146	java/lang/Exception
    //   157	161	164	java/lang/Exception
    //   0	5	182	java/lang/Exception
    //   10	17	182	java/lang/Exception
    //   24	44	182	java/lang/Exception
    //   44	49	182	java/lang/Exception
    //   96	100	182	java/lang/Exception
    //   147	151	182	java/lang/Exception
    //   165	169	182	java/lang/Exception
    //   169	171	182	java/lang/Exception
    //   0	5	186	java/lang/OutOfMemoryError
    //   10	17	186	java/lang/OutOfMemoryError
    //   24	44	186	java/lang/OutOfMemoryError
    //   44	49	186	java/lang/OutOfMemoryError
    //   89	93	186	java/lang/OutOfMemoryError
    //   96	100	186	java/lang/OutOfMemoryError
    //   139	143	186	java/lang/OutOfMemoryError
    //   147	151	186	java/lang/OutOfMemoryError
    //   157	161	186	java/lang/OutOfMemoryError
    //   165	169	186	java/lang/OutOfMemoryError
    //   169	171	186	java/lang/OutOfMemoryError
    //   44	49	190	java/io/IOException
  }
  
  private int k()
  {
    int n = this.j;
    if ((n != 383) && (n != 640)) {
      if (TroopFileUtils.a(this.i, this.g, n, n)) {
        return 0;
      }
    }
    for (;;)
    {
      return -1;
      if (this.j == 640) {
        n = 2;
      } else {
        n = 1;
      }
      try
      {
        boolean bool = ((ICompressOperator)QRoute.api(ICompressOperator.class)).compressAIOThumbnail(this.i, this.g, true, "", n);
        if (bool) {
          return 0;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return -2;
  }
  
  private void l()
  {
    try
    {
      if (this.m != null)
      {
        this.m.cancel();
        this.m = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a()
  {
    return this.c;
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (this.d)
    {
      n = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] onGenErr but had stop. errCode:");
      ((StringBuilder)localObject).append(paramInt);
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
      return;
    }
    l();
    this.d = true;
    if (!TextUtils.isEmpty(this.g)) {
      FileUtils.deleteFile(this.g);
    }
    TroopFileThumbnailMgr.b(this.b, this.j);
    int n = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] onGenErr  errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" passvieErr:");
    ((StringBuilder)localObject).append(paramBoolean);
    TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
    localObject = this.b;
    ((TroopFileTransferManager.Item)localObject).StatusUpdateTimeMs = 0L;
    TroopFileDataCenter.b(this.a, (TroopFileTransferManager.Item)localObject);
    if (!paramBoolean)
    {
      localObject = this.l;
      if (localObject != null) {
        ((TroopFileThumbnailGenTask.ITroopFileThumbGenTaskListener)localObject).a(a(), false, paramInt, this);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ThreadManager.post(new TroopFileThumbnailGenTask.1(this, paramBoolean, paramInt, paramString), 5, null, true);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.d)
    {
      n = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] doSuc but had stop.");
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
      return;
    }
    l();
    this.d = true;
    if ((!paramBoolean1) && (!FileManagerUtil.a(new VFSFile(this.g), new VFSFile(this.h))))
    {
      n = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] renameFile fail  mFilePath:");
      ((StringBuilder)localObject).append(this.h);
      TroopFileTransferUtil.Log.a("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
      if (FileUtils.fileExistsAndNotEmpty(this.h))
      {
        a(TroopTechReportUtils.TroopFileReportResultCode.o, false);
        return;
      }
    }
    i();
    int n = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] onGenSuc  mFilePath:");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(" bHit:");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" bPassiveEnd:");
    ((StringBuilder)localObject).append(paramBoolean2);
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
    if (!paramBoolean1) {
      this.b.StatusUpdateTimeMs = 0L;
    }
    if (ZhuoXusManager.a().l())
    {
      if (!this.i.equalsIgnoreCase(this.b.LocalFile)) {
        break label480;
      }
      localObject = new File(this.h);
    }
    try
    {
      localObject = JumpShareUtils.a(BaseApplicationImpl.getContext(), (File)localObject);
    }
    catch (Throwable localThrowable)
    {
      label341:
      break label341;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IMG_FILE_QR", 2, "JumpShareUtils.getQRCodeResult crash");
    }
    localObject = null;
    if (localObject != null)
    {
      this.b.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TroopFIleThumbGenTask success:");
        ((StringBuilder)localObject).append(this.b.strQRUrl);
        QLog.i("IMG_FILE_QR", 1, ((StringBuilder)localObject).toString());
      }
    }
    else if (JumpShareUtils.a)
    {
      this.b.strQRUrl = null;
    }
    else
    {
      this.b.strQRUrl = "";
      break label480;
      if (QLog.isColorLevel()) {
        QLog.i("IMG_FILE", 1, "choushane false!");
      }
    }
    label480:
    TroopFileDataCenter.a(this.a, this.b);
    TroopFileDataCenter.b(this.a, this.b);
    if (!paramBoolean2)
    {
      localObject = this.l;
      if (localObject != null) {
        ((TroopFileThumbnailGenTask.ITroopFileThumbGenTaskListener)localObject).a(a(), true, 0, this);
      }
    }
  }
  
  public boolean b()
  {
    this.d = false;
    a(90000L);
    int n = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] start.");
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", n, localStringBuilder.toString());
    ThreadManager.post(this, 5, null, true);
    return true;
  }
  
  public void c()
  {
    if (this.d)
    {
      n = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] stop. but had stoped");
      TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
      return;
    }
    int n = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] stop.");
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
    l();
    this.d = true;
    TroopFileThumbnailMgr.b(this.b, this.j);
    if (!TextUtils.isEmpty(this.g)) {
      FileUtils.deleteFile(this.g);
    }
    localObject = this.b;
    ((TroopFileTransferManager.Item)localObject).StatusUpdateTimeMs = 0L;
    TroopFileDataCenter.b(this.a, (TroopFileTransferManager.Item)localObject);
  }
  
  public String d()
  {
    return this.i;
  }
  
  public String e()
  {
    return this.h;
  }
  
  public int f()
  {
    return this.j;
  }
  
  public void g()
  {
    int n = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] passiveStart.");
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", n, localStringBuilder.toString());
    this.d = false;
    a(90000L);
  }
  
  protected void h()
  {
    if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f))) {
      return;
    }
    this.e = TroopFileThumbnailMgr.d();
    this.f = this.e;
  }
  
  protected void i()
  {
    TroopFileThumbnailMgr.b(this.b, this.j);
    TroopFileThumbnailMgr.a(this.a, this.b, this.j, this.h);
  }
  
  public void run()
  {
    if (this.d)
    {
      n = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] run genThumb. but had stop");
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
      return;
    }
    h();
    this.h = this.b.getThumbnailFile(this.a, this.j);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(".ttmp");
    this.g = ((StringBuilder)localObject).toString();
    int n = TroopFileTransferUtil.Log.b;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] run genThumb. mTmpFilePath:");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(" thumbPath:");
    ((StringBuilder)localObject).append(this.h);
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
    if (FileUtils.fileExistsAndNotEmpty(this.h))
    {
      n = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] thumb had exsited");
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
      a(true, false);
      return;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.i))
    {
      n = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] origfile is no exsit");
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", n, ((StringBuilder)localObject).toString());
      a(-111, false);
      return;
    }
    FileUtils.deleteFile(this.g);
    localObject = new VFSFile(this.g);
    try
    {
      ((VFSFile)localObject).createNewFile();
      if (this.k) {
        n = j();
      } else {
        n = k();
      }
      if (n != 0)
      {
        a(n, false);
        return;
      }
      a(false, false);
      return;
    }
    catch (IOException localIOException)
    {
      label372:
      break label372;
    }
    a(-1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask
 * JD-Core Version:    0.7.0.1
 */