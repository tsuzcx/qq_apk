package com.tencent.mobileqq.teamwork;

import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class TeamWorkForceShare$ImageRequestTask
  implements Runnable
{
  private BitmapDecodedListener jdField_a_of_type_ComTencentMobileqqTeamworkBitmapDecodedListener;
  private String jdField_a_of_type_JavaLangString = null;
  
  public TeamWorkForceShare$ImageRequestTask(TeamWorkForceShare paramTeamWorkForceShare, String paramString, BitmapDecodedListener paramBitmapDecodedListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkBitmapDecodedListener = paramBitmapDecodedListener;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: new 28	com/tencent/mobileqq/transfile/HttpDownloader
    //   3: dup
    //   4: invokespecial 29	com/tencent/mobileqq/transfile/HttpDownloader:<init>	()V
    //   7: astore_3
    //   8: new 31	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask$1
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 34	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask$1:<init>	(Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask;)V
    //   16: astore 4
    //   18: new 36	com/tencent/image/DownloadParams
    //   21: dup
    //   22: invokespecial 37	com/tencent/image/DownloadParams:<init>	()V
    //   25: astore 5
    //   27: aload 5
    //   29: new 39	java/net/URL
    //   32: dup
    //   33: aload_0
    //   34: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokespecial 42	java/net/URL:<init>	(Ljava/lang/String;)V
    //   40: putfield 46	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   43: aload 5
    //   45: aload_0
    //   46: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: putfield 49	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   52: new 51	java/io/FileOutputStream
    //   55: dup
    //   56: aload_0
    //   57: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   60: invokestatic 57	com/tencent/mobileqq/transfile/AbsDownloader:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokespecial 58	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: aload_2
    //   71: aload 5
    //   73: aload 4
    //   75: invokevirtual 62	com/tencent/mobileqq/transfile/HttpDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   78: pop
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_2
    //   84: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   87: return
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   93: return
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_1
    //   99: aload_3
    //   100: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   103: aload_2
    //   104: astore_1
    //   105: invokestatic 73	com/tencent/mobileqq/teamwork/TeamWorkForceShare:a	()Ljava/lang/String;
    //   108: iconst_1
    //   109: new 75	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   116: ldc 78
    //   118: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   125: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_2
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 15	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:this$0	Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare;
    //   140: invokestatic 97	com/tencent/mobileqq/teamwork/TeamWorkForceShare:a	(Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare;)Landroid/app/Activity;
    //   143: new 99	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask$2
    //   146: dup
    //   147: aload_0
    //   148: invokespecial 100	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask$2:<init>	(Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask;)V
    //   151: invokevirtual 106	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   154: aload_2
    //   155: ifnull -68 -> 87
    //   158: aload_2
    //   159: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   162: return
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   168: return
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_1
    //   172: aload_1
    //   173: ifnull +7 -> 180
    //   176: aload_1
    //   177: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   180: aload_2
    //   181: athrow
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   187: goto -7 -> 180
    //   190: astore_2
    //   191: goto -19 -> 172
    //   194: astore_3
    //   195: goto -98 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	ImageRequestTask
    //   68	1	1	localFileOutputStream1	java.io.FileOutputStream
    //   88	2	1	localException1	java.lang.Exception
    //   98	38	1	localFileOutputStream2	java.io.FileOutputStream
    //   163	2	1	localException2	java.lang.Exception
    //   171	6	1	localObject1	Object
    //   182	2	1	localException3	java.lang.Exception
    //   66	93	2	localFileOutputStream3	java.io.FileOutputStream
    //   169	12	2	localObject2	Object
    //   190	1	2	localObject3	Object
    //   7	63	3	localHttpDownloader	HttpDownloader
    //   94	28	3	localException4	java.lang.Exception
    //   194	1	3	localException5	java.lang.Exception
    //   16	58	4	local1	TeamWorkForceShare.ImageRequestTask.1
    //   25	47	5	localDownloadParams	com.tencent.image.DownloadParams
    // Exception table:
    //   from	to	target	type
    //   83	87	88	java/lang/Exception
    //   18	67	94	java/lang/Exception
    //   158	162	163	java/lang/Exception
    //   18	67	169	finally
    //   176	180	182	java/lang/Exception
    //   69	79	190	finally
    //   99	103	190	finally
    //   105	134	190	finally
    //   136	154	190	finally
    //   69	79	194	java/lang/Exception
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject1 = null;
    if (!paramBoolean) {
      return false;
    }
    Object localObject2 = HttpDownloader.getFile(this.jdField_a_of_type_JavaLangString);
    if (localObject2 != null)
    {
      QLog.d(TeamWorkForceShare.a(), 1, "file exist");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        ImageUtil.a(((File)localObject2).getAbsolutePath(), localOptions);
        if (localOptions.outWidth > DeviceInfoUtil.i()) {
          localOptions.inSampleSize = ((int)(DeviceInfoUtil.i() / localOptions.outWidth));
        }
        localOptions.inJustDecodeBounds = false;
        try
        {
          localObject2 = ImageUtil.a(((File)localObject2).getAbsolutePath(), localOptions);
          localObject1 = localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          for (;;)
          {
            localOutOfMemoryError1.printStackTrace();
            QLog.d(TeamWorkForceShare.a(), 1, "oom, url = " + this.jdField_a_of_type_JavaLangString);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBitmapDecodedListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTeamworkBitmapDecodedListener.a(localObject1);
        }
        return true;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        for (;;)
        {
          localOutOfMemoryError2.printStackTrace();
        }
      }
    }
    if (paramBoolean)
    {
      QLog.d(TeamWorkForceShare.a(), 1, "file not exist, url = " + this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBitmapDecodedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBitmapDecodedListener.a(null);
      }
    }
    return false;
  }
  
  public void run()
  {
    if (!a(false)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.ImageRequestTask
 * JD-Core Version:    0.7.0.1
 */