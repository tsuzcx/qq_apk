package com.tencent.mobileqq.troop.filemanager.upload;

import ajml;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import java.util.Timer;

public class TroopFileScanTask
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private TroopFileScanTask.ITroopFileScanTaskListener jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$ITroopFileScanTaskListener;
  private TroopFileScaner.ITroopFileScanPrg jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg;
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int c;
  private int d = 0;
  
  protected TroopFileScanTask(long paramLong, String paramString, TroopFileScanTask.ITroopFileScanTaskListener paramITroopFileScanTaskListener, TroopFileScaner.ITroopFileScanPrg paramITroopFileScanPrg)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg = paramITroopFileScanPrg;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$ITroopFileScanTaskListener = paramITroopFileScanTaskListener;
  }
  
  public static TroopFileScanTask a(long paramLong, String paramString, TroopFileScanTask.ITroopFileScanTaskListener paramITroopFileScanTaskListener, TroopFileScaner.ITroopFileScanPrg paramITroopFileScanPrg)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TroopFileTransferUtil.Log.a("TroopFileScanTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + paramLong + "] getTask filepath=null");
      return null;
    }
    return new TroopFileScanTask(paramLong, paramString, paramITroopFileScanTaskListener, paramITroopFileScanPrg);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      TroopFileTransferUtil.Log.b("TroopFileScanTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] scan fail had stop. errCode:" + paramInt);
    }
    do
    {
      return;
      TroopFileTransferUtil.Log.c("TroopFileScanTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] scan fail. errCode:" + paramInt + " passiveErr:" + paramBoolean);
      c();
      this.jdField_a_of_type_Boolean = true;
      this.d = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long, null, null, null, this.d);
      }
    } while ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$ITroopFileScanTaskListener == null));
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$ITroopFileScanTaskListener.a(this.jdField_a_of_type_Long, false, this.d, this);
  }
  
  private void a(long paramLong)
  {
    try
    {
      c();
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new ajml(this), paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      TroopFileTransferUtil.Log.b("TroopFileScanTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] scan suc. but had stop. passiveHit:" + paramBoolean);
    }
    do
    {
      return;
      c();
      String str1 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      String str2 = HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte);
      TroopFileTransferUtil.Log.c("TroopFileScanTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] scan suc. passiveHit:" + paramBoolean + " md5:" + str1 + " sha1:" + str2 + " mWith:" + this.jdField_a_of_type_Int + " mHeight:" + this.jdField_b_of_type_Int + " mDuration:" + this.c);
      this.d = 0;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, a(), this.d);
      }
    } while ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$ITroopFileScanTaskListener == null));
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask$ITroopFileScanTaskListener.a(this.jdField_a_of_type_Long, true, this.d, this);
  }
  
  private void c()
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
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_with_", this.jdField_a_of_type_Int);
    localBundle.putInt("_height_", this.jdField_b_of_type_Int);
    localBundle.putInt("_duration_", this.c);
    return localBundle;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    TroopFileTransferUtil.Log.c("TroopFileScanTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] stop");
    c();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      TroopFileTransferUtil.Log.b("TroopFileScanTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] passiveEnd. but had stop");
    }
    while (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      a(paramInt, true);
      return;
    }
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("_with_", 0);
      this.jdField_b_of_type_Int = paramBundle.getInt("_height_", 0);
      this.c = paramBundle.getInt("_duration_", 0);
    }
    a(true);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    a(90000L);
    TroopFileTransferUtil.Log.c("TroopFileScanTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] sart");
    ThreadManager.post(this, 5, null, true);
    return true;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileScanTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] passiveStart.");
    this.jdField_a_of_type_Boolean = false;
    a(90000L);
  }
  
  public byte[] b()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Boolean	Z
    //   6: ifeq +39 -> 45
    //   9: ldc 45
    //   11: getstatic 49	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:jdField_a_of_type_Int	I
    //   14: new 51	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   21: ldc 54
    //   23: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 29	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Long	J
    //   30: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc 215
    //   35: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 80	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:b	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: return
    //   45: ldc 45
    //   47: getstatic 49	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:jdField_a_of_type_Int	I
    //   50: new 51	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   57: ldc 54
    //   59: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 29	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Long	J
    //   66: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: ldc 217
    //   71: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 89	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: new 219	java/io/File
    //   83: dup
    //   84: aload_0
    //   85: getfield 31	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore 7
    //   93: aload 7
    //   95: invokevirtual 225	java/io/File:exists	()Z
    //   98: ifeq +21 -> 119
    //   101: aload 7
    //   103: invokevirtual 228	java/io/File:isFile	()Z
    //   106: ifne +41 -> 147
    //   109: aload 7
    //   111: invokevirtual 231	java/io/File:length	()J
    //   114: lconst_0
    //   115: lcmp
    //   116: ifge +31 -> 147
    //   119: aload_0
    //   120: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg	Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileScaner$ITroopFileScanPrg;
    //   123: ifnull +17 -> 140
    //   126: aload_0
    //   127: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg	Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileScaner$ITroopFileScanPrg;
    //   130: aload_0
    //   131: getfield 29	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Long	J
    //   134: lconst_0
    //   135: invokeinterface 234 5 0
    //   140: aload_0
    //   141: iconst_m1
    //   142: iconst_0
    //   143: invokespecial 121	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(IZ)V
    //   146: return
    //   147: aload_0
    //   148: aload 7
    //   150: invokevirtual 231	java/io/File:length	()J
    //   153: putfield 93	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Long	J
    //   156: aload_0
    //   157: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg	Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileScaner$ITroopFileScanPrg;
    //   160: ifnull +20 -> 180
    //   163: aload_0
    //   164: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg	Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileScaner$ITroopFileScanPrg;
    //   167: aload_0
    //   168: getfield 29	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Long	J
    //   171: aload_0
    //   172: getfield 93	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Long	J
    //   175: invokeinterface 234 5 0
    //   180: aload_0
    //   181: getfield 93	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Long	J
    //   184: ldc2_w 235
    //   187: lcmp
    //   188: iflt +11 -> 199
    //   191: aload_0
    //   192: bipush 252
    //   194: iconst_0
    //   195: invokespecial 121	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(IZ)V
    //   198: return
    //   199: ldc 238
    //   201: invokestatic 244	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   204: astore 5
    //   206: ldc 246
    //   208: invokestatic 244	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   211: astore 6
    //   213: new 248	java/io/FileInputStream
    //   216: dup
    //   217: aload 7
    //   219: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   222: astore 7
    //   224: ldc 252
    //   226: newarray byte
    //   228: astore 8
    //   230: aload 7
    //   232: aload 8
    //   234: invokevirtual 256	java/io/FileInputStream:read	([B)I
    //   237: istore_1
    //   238: iload_1
    //   239: ifge +106 -> 345
    //   242: aload 7
    //   244: invokevirtual 259	java/io/FileInputStream:close	()V
    //   247: aload_0
    //   248: aload 5
    //   250: invokevirtual 262	java/security/MessageDigest:digest	()[B
    //   253: putfield 126	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_ArrayOfByte	[B
    //   256: aload_0
    //   257: aload 6
    //   259: invokevirtual 262	java/security/MessageDigest:digest	()[B
    //   262: putfield 134	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_ArrayOfByte	[B
    //   265: aload_0
    //   266: getfield 31	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   269: invokestatic 267	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   272: istore_1
    //   273: iload_1
    //   274: ifne +197 -> 471
    //   277: new 269	android/graphics/BitmapFactory$Options
    //   280: dup
    //   281: invokespecial 270	android/graphics/BitmapFactory$Options:<init>	()V
    //   284: astore 5
    //   286: aload 5
    //   288: iconst_1
    //   289: putfield 273	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   292: aload_0
    //   293: getfield 31	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   296: aload 5
    //   298: invokestatic 278	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   301: pop
    //   302: aload_0
    //   303: aload 5
    //   305: getfield 281	android/graphics/BitmapFactory$Options:outWidth	I
    //   308: putfield 143	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Int	I
    //   311: aload_0
    //   312: aload 5
    //   314: getfield 284	android/graphics/BitmapFactory$Options:outHeight	I
    //   317: putfield 147	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Int	I
    //   320: aload_0
    //   321: iconst_0
    //   322: invokespecial 188	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(Z)V
    //   325: return
    //   326: astore 5
    //   328: aload_0
    //   329: bipush 254
    //   331: iconst_0
    //   332: invokespecial 121	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(IZ)V
    //   335: return
    //   336: astore 5
    //   338: aload_0
    //   339: iconst_m1
    //   340: iconst_0
    //   341: invokespecial 121	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(IZ)V
    //   344: return
    //   345: aload 5
    //   347: aload 8
    //   349: iconst_0
    //   350: iload_1
    //   351: invokevirtual 288	java/security/MessageDigest:update	([BII)V
    //   354: aload 6
    //   356: aload 8
    //   358: iconst_0
    //   359: iload_1
    //   360: invokevirtual 288	java/security/MessageDigest:update	([BII)V
    //   363: lload_2
    //   364: iload_1
    //   365: i2l
    //   366: ladd
    //   367: lstore_2
    //   368: aload_0
    //   369: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg	Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileScaner$ITroopFileScanPrg;
    //   372: ifnull +21 -> 393
    //   375: aload_0
    //   376: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner$ITroopFileScanPrg	Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileScaner$ITroopFileScanPrg;
    //   379: aload_0
    //   380: getfield 29	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Long	J
    //   383: lload_2
    //   384: aload_0
    //   385: getfield 93	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Long	J
    //   388: invokeinterface 291 7 0
    //   393: aload_0
    //   394: getfield 25	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Boolean	Z
    //   397: istore 4
    //   399: iload 4
    //   401: ifeq -171 -> 230
    //   404: aload 7
    //   406: invokevirtual 259	java/io/FileInputStream:close	()V
    //   409: return
    //   410: astore 5
    //   412: aload 5
    //   414: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   417: return
    //   418: astore 7
    //   420: aload 7
    //   422: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   425: goto -178 -> 247
    //   428: astore 5
    //   430: aload_0
    //   431: bipush 253
    //   433: iconst_0
    //   434: invokespecial 121	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(IZ)V
    //   437: aload 7
    //   439: invokevirtual 259	java/io/FileInputStream:close	()V
    //   442: return
    //   443: astore 5
    //   445: aload 5
    //   447: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   450: return
    //   451: astore 5
    //   453: aload 7
    //   455: invokevirtual 259	java/io/FileInputStream:close	()V
    //   458: aload 5
    //   460: athrow
    //   461: astore 6
    //   463: aload 6
    //   465: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   468: goto -10 -> 458
    //   471: iload_1
    //   472: iconst_2
    //   473: if_icmpne -153 -> 320
    //   476: aload_0
    //   477: getfield 31	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   480: invokestatic 299	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)[I
    //   483: astore 5
    //   485: aload_0
    //   486: aload 5
    //   488: iconst_0
    //   489: iaload
    //   490: putfield 143	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Int	I
    //   493: aload_0
    //   494: aload 5
    //   496: iconst_1
    //   497: iaload
    //   498: putfield 147	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Int	I
    //   501: aload_0
    //   502: aload 5
    //   504: iconst_2
    //   505: iaload
    //   506: putfield 151	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:c	I
    //   509: goto -189 -> 320
    //   512: astore 5
    //   514: goto -194 -> 320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	TroopFileScanTask
    //   237	237	1	i	int
    //   1	383	2	l	long
    //   397	3	4	bool	boolean
    //   204	109	5	localObject1	Object
    //   326	1	5	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   336	10	5	localFileNotFoundException	java.io.FileNotFoundException
    //   410	3	5	localIOException1	java.io.IOException
    //   428	1	5	localIOException2	java.io.IOException
    //   443	3	5	localIOException3	java.io.IOException
    //   451	8	5	localObject2	Object
    //   483	20	5	arrayOfInt	int[]
    //   512	1	5	localException	java.lang.Exception
    //   211	144	6	localMessageDigest	java.security.MessageDigest
    //   461	3	6	localIOException4	java.io.IOException
    //   91	314	7	localObject3	Object
    //   418	36	7	localIOException5	java.io.IOException
    //   228	129	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   199	213	326	java/security/NoSuchAlgorithmException
    //   213	224	336	java/io/FileNotFoundException
    //   404	409	410	java/io/IOException
    //   242	247	418	java/io/IOException
    //   224	230	428	java/io/IOException
    //   230	238	428	java/io/IOException
    //   345	363	428	java/io/IOException
    //   368	393	428	java/io/IOException
    //   393	399	428	java/io/IOException
    //   437	442	443	java/io/IOException
    //   224	230	451	finally
    //   230	238	451	finally
    //   345	363	451	finally
    //   368	393	451	finally
    //   393	399	451	finally
    //   430	437	451	finally
    //   453	458	461	java/io/IOException
    //   277	320	512	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileScanTask
 * JD-Core Version:    0.7.0.1
 */