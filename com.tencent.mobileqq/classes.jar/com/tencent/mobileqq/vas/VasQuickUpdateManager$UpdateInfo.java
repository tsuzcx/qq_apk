package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
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
  
  private String checkTempPath(int paramInt, TagItemInfo paramTagItemInfo, String paramString)
  {
    String str = paramString;
    if (paramTagItemInfo != null)
    {
      str = paramString;
      if (!TextUtils.isEmpty(paramTagItemInfo.c))
      {
        if (paramTagItemInfo.b)
        {
          paramTagItemInfo = paramTagItemInfo.c;
        }
        else
        {
          int i = paramTagItemInfo.c.lastIndexOf("/");
          paramTagItemInfo = paramTagItemInfo.c.substring(0, i);
        }
        str = paramString;
        if (!TextUtils.isEmpty(paramTagItemInfo))
        {
          paramString = new File(paramTagItemInfo);
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          QQAlbumUtils.a(paramTagItemInfo);
          paramString = new StringBuilder();
          paramString.append(paramTagItemInfo);
          paramString.append("/tempFile_");
          paramString.append(System.currentTimeMillis());
          paramString.append("_");
          paramString.append(paramInt);
          str = paramString.toString();
        }
      }
    }
    return str;
  }
  
  /* Error */
  private void initTempPath(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 6
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 103	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:bid	J
    //   16: aload_0
    //   17: getfield 105	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:scid	Ljava/lang/String;
    //   20: invokestatic 110	com/tencent/mobileqq/vas/updatesystem/VasUpdateUtil:a	(JLjava/lang/String;)Lcom/tencent/mobileqq/vas/updatesystem/callback/TagItemInfo;
    //   23: astore 7
    //   25: aload 6
    //   27: astore_3
    //   28: new 72	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   35: astore 8
    //   37: aload 6
    //   39: astore_3
    //   40: aload 8
    //   42: invokestatic 116	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   45: invokevirtual 120	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 123	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 6
    //   57: astore_3
    //   58: aload 8
    //   60: ldc 79
    //   62: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 6
    //   68: astore_3
    //   69: aload 8
    //   71: invokestatic 85	java/lang/System:currentTimeMillis	()J
    //   74: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 6
    //   80: astore_3
    //   81: aload 8
    //   83: ldc 90
    //   85: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 6
    //   91: astore_3
    //   92: aload 8
    //   94: iload_1
    //   95: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 6
    //   101: astore_3
    //   102: aload_0
    //   103: iload_1
    //   104: aload 7
    //   106: aload 8
    //   108: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 125	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:checkTempPath	(ILcom/tencent/mobileqq/vas/updatesystem/callback/TagItemInfo;Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 7
    //   116: aload 6
    //   118: astore_3
    //   119: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +51 -> 173
    //   125: aload 6
    //   127: astore_3
    //   128: new 72	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   135: astore 8
    //   137: aload 6
    //   139: astore_3
    //   140: aload 8
    //   142: ldc 132
    //   144: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 6
    //   150: astore_3
    //   151: aload 8
    //   153: aload 7
    //   155: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 6
    //   161: astore_3
    //   162: ldc 134
    //   164: iconst_2
    //   165: aload 8
    //   167: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload 6
    //   175: astore_3
    //   176: aload 7
    //   178: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +78 -> 259
    //   184: aload 6
    //   186: astore_3
    //   187: new 140	java/io/DataOutputStream
    //   190: dup
    //   191: new 142	java/io/BufferedOutputStream
    //   194: dup
    //   195: new 144	java/io/FileOutputStream
    //   198: dup
    //   199: new 55	java/io/File
    //   202: dup
    //   203: aload 7
    //   205: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   208: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   211: invokespecial 150	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   214: invokespecial 151	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   217: astore 4
    //   219: aload 4
    //   221: aload_2
    //   222: iconst_0
    //   223: aload_2
    //   224: arraylength
    //   225: invokevirtual 155	java/io/DataOutputStream:write	([BII)V
    //   228: aload 4
    //   230: invokevirtual 158	java/io/DataOutputStream:flush	()V
    //   233: aload_0
    //   234: aload 7
    //   236: putfield 160	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
    //   239: goto +49 -> 288
    //   242: astore_2
    //   243: aload 4
    //   245: astore_3
    //   246: goto +102 -> 348
    //   249: astore_3
    //   250: aload 4
    //   252: astore_2
    //   253: aload_3
    //   254: astore 4
    //   256: goto +52 -> 308
    //   259: aload 6
    //   261: astore_3
    //   262: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +14 -> 279
    //   268: aload 6
    //   270: astore_3
    //   271: ldc 134
    //   273: iconst_2
    //   274: ldc 162
    //   276: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload 6
    //   281: astore_3
    //   282: aload_0
    //   283: ldc 164
    //   285: putfield 160	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
    //   288: aload 4
    //   290: ifnull +57 -> 347
    //   293: aload 4
    //   295: invokevirtual 167	java/io/DataOutputStream:close	()V
    //   298: return
    //   299: astore_2
    //   300: goto +48 -> 348
    //   303: astore 4
    //   305: aload 5
    //   307: astore_2
    //   308: aload_2
    //   309: astore_3
    //   310: ldc 134
    //   312: iconst_1
    //   313: ldc 169
    //   315: aload 4
    //   317: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: aload_2
    //   321: astore_3
    //   322: aload_0
    //   323: ldc 164
    //   325: putfield 160	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
    //   328: aload_2
    //   329: ifnull +18 -> 347
    //   332: aload_2
    //   333: invokevirtual 167	java/io/DataOutputStream:close	()V
    //   336: return
    //   337: astore_2
    //   338: ldc 134
    //   340: iconst_1
    //   341: ldc 175
    //   343: aload_2
    //   344: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   347: return
    //   348: aload_3
    //   349: ifnull +20 -> 369
    //   352: aload_3
    //   353: invokevirtual 167	java/io/DataOutputStream:close	()V
    //   356: goto +13 -> 369
    //   359: astore_3
    //   360: ldc 134
    //   362: iconst_1
    //   363: ldc 175
    //   365: aload_3
    //   366: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   369: aload_2
    //   370: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	UpdateInfo
    //   0	371	1	paramInt	int
    //   0	371	2	paramArrayOfByte	byte[]
    //   11	235	3	localObject1	Object
    //   249	5	3	localException1	java.lang.Exception
    //   261	92	3	localObject2	Object
    //   359	7	3	localException2	java.lang.Exception
    //   7	287	4	localObject3	Object
    //   303	13	4	localException3	java.lang.Exception
    //   4	302	5	localObject4	Object
    //   1	279	6	localObject5	Object
    //   23	212	7	localObject6	Object
    //   35	131	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   219	239	242	finally
    //   219	239	249	java/lang/Exception
    //   12	25	299	finally
    //   28	37	299	finally
    //   40	55	299	finally
    //   58	66	299	finally
    //   69	78	299	finally
    //   81	89	299	finally
    //   92	99	299	finally
    //   102	116	299	finally
    //   119	125	299	finally
    //   128	137	299	finally
    //   140	148	299	finally
    //   151	159	299	finally
    //   162	173	299	finally
    //   176	184	299	finally
    //   187	219	299	finally
    //   262	268	299	finally
    //   271	279	299	finally
    //   282	288	299	finally
    //   310	320	299	finally
    //   322	328	299	finally
    //   12	25	303	java/lang/Exception
    //   28	37	303	java/lang/Exception
    //   40	55	303	java/lang/Exception
    //   58	66	303	java/lang/Exception
    //   69	78	303	java/lang/Exception
    //   81	89	303	java/lang/Exception
    //   92	99	303	java/lang/Exception
    //   102	116	303	java/lang/Exception
    //   119	125	303	java/lang/Exception
    //   128	137	303	java/lang/Exception
    //   140	148	303	java/lang/Exception
    //   151	159	303	java/lang/Exception
    //   162	173	303	java/lang/Exception
    //   176	184	303	java/lang/Exception
    //   187	219	303	java/lang/Exception
    //   262	268	303	java/lang/Exception
    //   271	279	303	java/lang/Exception
    //   282	288	303	java/lang/Exception
    //   293	298	337	java/lang/Exception
    //   332	336	337	java/lang/Exception
    //   352	356	359	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.UpdateInfo
 * JD-Core Version:    0.7.0.1
 */