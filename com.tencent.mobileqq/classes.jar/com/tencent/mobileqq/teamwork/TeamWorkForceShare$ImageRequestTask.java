package com.tencent.mobileqq.teamwork;

import android.graphics.Bitmap;
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
    //   7: astore 4
    //   9: new 31	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask$1
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 34	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask$1:<init>	(Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask;)V
    //   17: astore 5
    //   19: aconst_null
    //   20: astore_3
    //   21: aconst_null
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: new 36	com/tencent/image/DownloadParams
    //   28: dup
    //   29: invokespecial 37	com/tencent/image/DownloadParams:<init>	()V
    //   32: astore 6
    //   34: aload_2
    //   35: astore_1
    //   36: aload 6
    //   38: new 39	java/net/URL
    //   41: dup
    //   42: aload_0
    //   43: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   46: invokespecial 42	java/net/URL:<init>	(Ljava/lang/String;)V
    //   49: putfield 46	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   52: aload_2
    //   53: astore_1
    //   54: aload 6
    //   56: aload_0
    //   57: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   60: putfield 49	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   63: aload_2
    //   64: astore_1
    //   65: new 51	java/io/FileOutputStream
    //   68: dup
    //   69: aload_0
    //   70: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: invokestatic 57	com/tencent/mobileqq/transfile/AbsDownloader:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokespecial 58	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   79: astore_2
    //   80: aload 4
    //   82: aload_2
    //   83: aload 6
    //   85: aload 5
    //   87: invokevirtual 62	com/tencent/mobileqq/transfile/HttpDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   90: pop
    //   91: aload_2
    //   92: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   95: return
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   101: return
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: aload_3
    //   106: astore_2
    //   107: goto +104 -> 211
    //   110: astore_3
    //   111: goto +12 -> 123
    //   114: astore_2
    //   115: goto +96 -> 211
    //   118: astore_1
    //   119: aload_3
    //   120: astore_2
    //   121: aload_1
    //   122: astore_3
    //   123: aload_2
    //   124: astore_1
    //   125: aload_3
    //   126: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   129: aload_2
    //   130: astore_1
    //   131: invokestatic 73	com/tencent/mobileqq/teamwork/TeamWorkForceShare:a	()Ljava/lang/String;
    //   134: astore 4
    //   136: aload_2
    //   137: astore_1
    //   138: new 75	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   145: astore 5
    //   147: aload_2
    //   148: astore_1
    //   149: aload 5
    //   151: ldc 78
    //   153: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_2
    //   158: astore_1
    //   159: aload 5
    //   161: aload_3
    //   162: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_2
    //   170: astore_1
    //   171: aload 4
    //   173: iconst_1
    //   174: aload 5
    //   176: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload_2
    //   183: astore_1
    //   184: aload_0
    //   185: getfield 15	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:this$0	Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare;
    //   188: invokestatic 97	com/tencent/mobileqq/teamwork/TeamWorkForceShare:a	(Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare;)Landroid/app/Activity;
    //   191: new 99	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask$2
    //   194: dup
    //   195: aload_0
    //   196: invokespecial 100	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask$2:<init>	(Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask;)V
    //   199: invokevirtual 106	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   202: aload_2
    //   203: ifnull +7 -> 210
    //   206: aload_2
    //   207: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   210: return
    //   211: aload_1
    //   212: ifnull +15 -> 227
    //   215: aload_1
    //   216: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   219: goto +8 -> 227
    //   222: astore_1
    //   223: aload_1
    //   224: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   227: aload_2
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	ImageRequestTask
    //   24	41	1	localObject1	Object
    //   96	2	1	localException1	java.lang.Exception
    //   104	1	1	localObject2	Object
    //   118	4	1	localException2	java.lang.Exception
    //   124	92	1	localException3	java.lang.Exception
    //   222	2	1	localException4	java.lang.Exception
    //   22	85	2	localObject3	Object
    //   114	1	2	localObject4	Object
    //   120	108	2	localException5	java.lang.Exception
    //   20	1	3	localObject5	Object
    //   102	4	3	localObject6	Object
    //   110	10	3	localException6	java.lang.Exception
    //   122	40	3	localObject7	Object
    //   7	165	4	localObject8	Object
    //   17	158	5	localObject9	Object
    //   32	52	6	localDownloadParams	com.tencent.image.DownloadParams
    // Exception table:
    //   from	to	target	type
    //   91	95	96	java/lang/Exception
    //   206	210	96	java/lang/Exception
    //   80	91	102	finally
    //   80	91	110	java/lang/Exception
    //   25	34	114	finally
    //   36	52	114	finally
    //   54	63	114	finally
    //   65	80	114	finally
    //   125	129	114	finally
    //   131	136	114	finally
    //   138	147	114	finally
    //   149	157	114	finally
    //   159	169	114	finally
    //   171	182	114	finally
    //   184	202	114	finally
    //   25	34	118	java/lang/Exception
    //   36	52	118	java/lang/Exception
    //   54	63	118	java/lang/Exception
    //   65	80	118	java/lang/Exception
    //   215	219	222	java/lang/Exception
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return false;
    }
    Object localObject2 = HttpDownloader.getFile(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = null;
    Object localObject3;
    if (localObject2 != null)
    {
      QLog.d(TeamWorkForceShare.a(), 1, "file exist");
      Object localObject4 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject4).inJustDecodeBounds = true;
      try
      {
        ImageUtil.a(((File)localObject2).getAbsolutePath(), (BitmapFactory.Options)localObject4);
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        localOutOfMemoryError2.printStackTrace();
      }
      if (((BitmapFactory.Options)localObject4).outWidth > DeviceInfoUtil.i()) {
        ((BitmapFactory.Options)localObject4).inSampleSize = ((int)(DeviceInfoUtil.i() / ((BitmapFactory.Options)localObject4).outWidth));
      }
      ((BitmapFactory.Options)localObject4).inJustDecodeBounds = false;
      try
      {
        localObject2 = ImageUtil.a(((File)localObject2).getAbsolutePath(), (BitmapFactory.Options)localObject4);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localOutOfMemoryError1.printStackTrace();
        localObject3 = TeamWorkForceShare.a();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("oom, url = ");
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_JavaLangString);
        QLog.d((String)localObject3, 1, ((StringBuilder)localObject4).toString());
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqTeamworkBitmapDecodedListener;
      if (localObject3 != null) {
        ((BitmapDecodedListener)localObject3).a((Bitmap)localObject1);
      }
      return true;
    }
    if (paramBoolean)
    {
      localObject1 = TeamWorkForceShare.a();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("file not exist, url = ");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkBitmapDecodedListener;
      if (localObject1 != null) {
        ((BitmapDecodedListener)localObject1).a(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.ImageRequestTask
 * JD-Core Version:    0.7.0.1
 */