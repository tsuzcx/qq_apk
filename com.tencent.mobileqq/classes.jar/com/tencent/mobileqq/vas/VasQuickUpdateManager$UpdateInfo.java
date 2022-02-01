package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import bqfh;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.scupdate.SCUpdatePB.ItemExtend;
import com.tencent.pb.scupdate.SCUpdatePB.UpdateInfo;
import java.io.File;

public class VasQuickUpdateManager$UpdateInfo
{
  public String appVersion;
  public long bid;
  public int code;
  public int compressMode;
  public int deltaMode;
  public String dstVersion;
  public String filecontent;
  public long filesize;
  public String scid;
  public String srcVersion;
  public int storageMode;
  public String url;
  
  private String checkTempPath(int paramInt, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo, String paramString)
  {
    String str = paramString;
    if (paramTagItemInfo != null)
    {
      str = paramString;
      if (!TextUtils.isEmpty(paramTagItemInfo.strSavePath)) {
        if (!paramTagItemInfo.bSaveInDir) {
          break label106;
        }
      }
    }
    label106:
    int i;
    for (paramTagItemInfo = paramTagItemInfo.strSavePath;; paramTagItemInfo = paramTagItemInfo.strSavePath.substring(0, i))
    {
      str = paramString;
      if (!TextUtils.isEmpty(paramTagItemInfo))
      {
        paramString = new File(paramTagItemInfo);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        bqfh.a(paramTagItemInfo);
        str = paramTagItemInfo + "/tempFile_" + System.currentTimeMillis() + "_" + paramInt;
      }
      return str;
      i = paramTagItemInfo.strSavePath.lastIndexOf("/");
    }
  }
  
  /* Error */
  private void initTempPath(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 4
    //   8: astore_3
    //   9: aload_0
    //   10: iload_1
    //   11: aload_0
    //   12: getfield 103	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:bid	J
    //   15: aload_0
    //   16: getfield 105	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:scid	Ljava/lang/String;
    //   19: invokestatic 111	com/tencent/mobileqq/vas/VasQuickUpdateEngine:getItemInfo	(JLjava/lang/String;)Lcom/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo;
    //   22: new 60	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   29: invokestatic 117	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   32: invokevirtual 121	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   35: invokevirtual 124	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 67
    //   43: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   49: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: ldc 78
    //   54: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload_1
    //   58: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 126	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:checkTempPath	(ILcom/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo;Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 6
    //   69: aload 4
    //   71: astore_3
    //   72: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +32 -> 107
    //   78: aload 4
    //   80: astore_3
    //   81: ldc 133
    //   83: iconst_2
    //   84: new 60	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   91: ldc 135
    //   93: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 6
    //   98: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload 4
    //   109: astore_3
    //   110: aload 6
    //   112: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +69 -> 184
    //   118: aload 4
    //   120: astore_3
    //   121: new 141	java/io/DataOutputStream
    //   124: dup
    //   125: new 143	java/io/BufferedOutputStream
    //   128: dup
    //   129: new 145	java/io/FileOutputStream
    //   132: dup
    //   133: new 43	java/io/File
    //   136: dup
    //   137: aload 6
    //   139: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   145: invokespecial 151	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   148: invokespecial 152	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   151: astore 4
    //   153: aload 4
    //   155: aload_2
    //   156: iconst_0
    //   157: aload_2
    //   158: arraylength
    //   159: invokevirtual 156	java/io/DataOutputStream:write	([BII)V
    //   162: aload 4
    //   164: invokevirtual 159	java/io/DataOutputStream:flush	()V
    //   167: aload_0
    //   168: aload 6
    //   170: putfield 161	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
    //   173: aload 4
    //   175: ifnull +8 -> 183
    //   178: aload 4
    //   180: invokevirtual 164	java/io/DataOutputStream:close	()V
    //   183: return
    //   184: aload 4
    //   186: astore_3
    //   187: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +14 -> 204
    //   193: aload 4
    //   195: astore_3
    //   196: ldc 133
    //   198: iconst_2
    //   199: ldc 166
    //   201: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload 4
    //   206: astore_3
    //   207: aload_0
    //   208: ldc 168
    //   210: putfield 161	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
    //   213: aconst_null
    //   214: astore 4
    //   216: goto -43 -> 173
    //   219: astore_2
    //   220: ldc 133
    //   222: iconst_1
    //   223: ldc 170
    //   225: aload_2
    //   226: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   229: return
    //   230: astore 4
    //   232: aload 5
    //   234: astore_2
    //   235: aload_2
    //   236: astore_3
    //   237: ldc 133
    //   239: iconst_1
    //   240: ldc 176
    //   242: aload 4
    //   244: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload_2
    //   248: astore_3
    //   249: aload_0
    //   250: ldc 168
    //   252: putfield 161	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
    //   255: aload_2
    //   256: ifnull -73 -> 183
    //   259: aload_2
    //   260: invokevirtual 164	java/io/DataOutputStream:close	()V
    //   263: return
    //   264: astore_2
    //   265: ldc 133
    //   267: iconst_1
    //   268: ldc 170
    //   270: aload_2
    //   271: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   274: return
    //   275: astore_2
    //   276: aload_3
    //   277: ifnull +7 -> 284
    //   280: aload_3
    //   281: invokevirtual 164	java/io/DataOutputStream:close	()V
    //   284: aload_2
    //   285: athrow
    //   286: astore_3
    //   287: ldc 133
    //   289: iconst_1
    //   290: ldc 170
    //   292: aload_3
    //   293: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   296: goto -12 -> 284
    //   299: astore_2
    //   300: aload 4
    //   302: astore_3
    //   303: goto -27 -> 276
    //   306: astore_3
    //   307: aload 4
    //   309: astore_2
    //   310: aload_3
    //   311: astore 4
    //   313: goto -78 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	UpdateInfo
    //   0	316	1	paramInt	int
    //   0	316	2	paramArrayOfByte	byte[]
    //   8	273	3	localObject1	Object
    //   286	7	3	localException1	java.lang.Exception
    //   302	1	3	localException2	java.lang.Exception
    //   306	5	3	localException3	java.lang.Exception
    //   1	214	4	localDataOutputStream	java.io.DataOutputStream
    //   230	78	4	localException4	java.lang.Exception
    //   311	1	4	localObject2	Object
    //   4	229	5	localObject3	Object
    //   67	102	6	str	String
    // Exception table:
    //   from	to	target	type
    //   178	183	219	java/lang/Exception
    //   9	69	230	java/lang/Exception
    //   72	78	230	java/lang/Exception
    //   81	107	230	java/lang/Exception
    //   110	118	230	java/lang/Exception
    //   121	153	230	java/lang/Exception
    //   187	193	230	java/lang/Exception
    //   196	204	230	java/lang/Exception
    //   207	213	230	java/lang/Exception
    //   259	263	264	java/lang/Exception
    //   9	69	275	finally
    //   72	78	275	finally
    //   81	107	275	finally
    //   110	118	275	finally
    //   121	153	275	finally
    //   187	193	275	finally
    //   196	204	275	finally
    //   207	213	275	finally
    //   237	247	275	finally
    //   249	255	275	finally
    //   280	284	286	java/lang/Exception
    //   153	173	299	finally
    //   153	173	306	java/lang/Exception
  }
  
  public void set(SCUpdatePB.UpdateInfo paramUpdateInfo, int paramInt)
  {
    this.bid = paramUpdateInfo.bid.get();
    this.scid = paramUpdateInfo.scid.get();
    this.dstVersion = paramUpdateInfo.dst_version.get();
    this.srcVersion = paramUpdateInfo.src_version.get();
    this.deltaMode = paramUpdateInfo.delta_mode.get();
    this.storageMode = paramUpdateInfo.storage_mode.get();
    this.compressMode = paramUpdateInfo.compress_mode.get();
    this.url = paramUpdateInfo.url.get();
    this.filesize = paramUpdateInfo.filesize.get();
    byte[] arrayOfByte = paramUpdateInfo.filecontent.get().toByteArray();
    if (arrayOfByte.length > 0) {
      initTempPath(paramInt, arrayOfByte);
    }
    this.code = paramUpdateInfo.code.get();
    this.appVersion = paramUpdateInfo.extendinfo.app_version.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.UpdateInfo
 * JD-Core Version:    0.7.0.1
 */