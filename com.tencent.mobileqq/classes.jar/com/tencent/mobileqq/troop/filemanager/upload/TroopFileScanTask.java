package com.tencent.mobileqq.troop.filemanager.upload;

import android.os.Bundle;
import android.text.TextUtils;
import azsr;
import azuo;
import azuq;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Timer;

public class TroopFileScanTask
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private azuo jdField_a_of_type_Azuo;
  private azuq jdField_a_of_type_Azuq;
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int d = 0;
  
  protected TroopFileScanTask(long paramLong, String paramString, azuo paramazuo, azuq paramazuq)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Azuq = paramazuq;
    this.jdField_a_of_type_Azuo = paramazuo;
  }
  
  public static TroopFileScanTask a(long paramLong, String paramString, azuo paramazuo, azuq paramazuq)
  {
    if (TextUtils.isEmpty(paramString))
    {
      azsr.a("TroopFileScanTask", azsr.jdField_a_of_type_Int, "[" + paramLong + "] getTask filepath=null");
      return null;
    }
    return new TroopFileScanTask(paramLong, paramString, paramazuo, paramazuq);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      azsr.b("TroopFileScanTask", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] scan fail had stop. errCode:" + paramInt);
    }
    do
    {
      return;
      azsr.c("TroopFileScanTask", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] scan fail. errCode:" + paramInt + " passiveErr:" + paramBoolean);
      c();
      this.jdField_a_of_type_Boolean = true;
      this.d = paramInt;
      if (this.jdField_a_of_type_Azuq != null) {
        this.jdField_a_of_type_Azuq.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long, null, null, null, null, this.d);
      }
    } while ((paramBoolean) || (this.jdField_a_of_type_Azuo == null));
    this.jdField_a_of_type_Azuo.a(this.jdField_a_of_type_Long, false, this.d, this);
  }
  
  private void a(long paramLong)
  {
    try
    {
      c();
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new TroopFileScanTask.1(this), paramLong);
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
      azsr.b("TroopFileScanTask", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] scan suc. but had stop. passiveHit:" + paramBoolean);
    }
    do
    {
      return;
      c();
      String str1 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      String str2 = HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte);
      String str3 = HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte);
      azsr.c("TroopFileScanTask", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] scan suc. passiveHit:" + paramBoolean + " md5:" + str1 + " sha1:" + str2 + " sha3:" + str3 + " mWith:" + this.jdField_a_of_type_Int + " mHeight:" + this.jdField_b_of_type_Int + " mDuration:" + this.jdField_c_of_type_Int);
      this.d = 0;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Azuq != null) {
        this.jdField_a_of_type_Azuq.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte, a(), this.d);
      }
    } while ((paramBoolean) || (this.jdField_a_of_type_Azuo == null));
    this.jdField_a_of_type_Azuo.a(this.jdField_a_of_type_Long, true, this.d, this);
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
    localBundle.putInt("_duration_", this.jdField_c_of_type_Int);
    return localBundle;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    azsr.c("TroopFileScanTask", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] stop");
    c();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      azsr.b("TroopFileScanTask", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] passiveEnd. but had stop");
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
    this.jdField_c_of_type_ArrayOfByte = paramArrayOfByte3;
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("_with_", 0);
      this.jdField_b_of_type_Int = paramBundle.getInt("_height_", 0);
      this.jdField_c_of_type_Int = paramBundle.getInt("_duration_", 0);
    }
    a(true);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    a(90000L);
    azsr.c("TroopFileScanTask", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] sart");
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
    azsr.c("TroopFileScanTask", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] passiveStart.");
    this.jdField_a_of_type_Boolean = false;
    a(90000L);
  }
  
  public byte[] b()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public byte[] c()
  {
    return this.jdField_c_of_type_ArrayOfByte;
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
    //   11: getstatic 49	azsr:jdField_a_of_type_Int	I
    //   14: new 51	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   21: ldc 54
    //   23: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 29	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Long	J
    //   30: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc 219
    //   35: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 80	azsr:b	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: return
    //   45: ldc 45
    //   47: getstatic 49	azsr:jdField_a_of_type_Int	I
    //   50: new 51	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   57: ldc 54
    //   59: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 29	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Long	J
    //   66: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: ldc 221
    //   71: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 89	azsr:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: new 223	com/tencent/mm/vfs/VFSFile
    //   83: dup
    //   84: aload_0
    //   85: getfield 31	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: invokespecial 226	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   91: astore 7
    //   93: aload 7
    //   95: invokevirtual 229	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   98: ifeq +21 -> 119
    //   101: aload 7
    //   103: invokevirtual 232	com/tencent/mm/vfs/VFSFile:isFile	()Z
    //   106: ifne +41 -> 147
    //   109: aload 7
    //   111: invokevirtual 235	com/tencent/mm/vfs/VFSFile:length	()J
    //   114: lconst_0
    //   115: lcmp
    //   116: ifge +31 -> 147
    //   119: aload_0
    //   120: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Azuq	Lazuq;
    //   123: ifnull +17 -> 140
    //   126: aload_0
    //   127: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Azuq	Lazuq;
    //   130: aload_0
    //   131: getfield 29	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Long	J
    //   134: lconst_0
    //   135: invokeinterface 238 5 0
    //   140: aload_0
    //   141: iconst_m1
    //   142: iconst_0
    //   143: invokespecial 121	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(IZ)V
    //   146: return
    //   147: aload_0
    //   148: aload 7
    //   150: invokevirtual 235	com/tencent/mm/vfs/VFSFile:length	()J
    //   153: putfield 93	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Long	J
    //   156: aload_0
    //   157: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Azuq	Lazuq;
    //   160: ifnull +20 -> 180
    //   163: aload_0
    //   164: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Azuq	Lazuq;
    //   167: aload_0
    //   168: getfield 29	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Long	J
    //   171: aload_0
    //   172: getfield 93	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Long	J
    //   175: invokeinterface 238 5 0
    //   180: aload_0
    //   181: getfield 93	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Long	J
    //   184: ldc2_w 239
    //   187: lcmp
    //   188: iflt +11 -> 199
    //   191: aload_0
    //   192: bipush 252
    //   194: iconst_0
    //   195: invokespecial 121	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(IZ)V
    //   198: return
    //   199: ldc 242
    //   201: invokestatic 248	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   204: astore 5
    //   206: ldc 250
    //   208: invokestatic 248	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   211: astore 6
    //   213: new 252	com/tencent/mm/vfs/VFSFileInputStream
    //   216: dup
    //   217: aload 7
    //   219: invokespecial 255	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   222: astore 7
    //   224: ldc_w 256
    //   227: newarray byte
    //   229: astore 8
    //   231: aload 7
    //   233: aload 8
    //   235: invokevirtual 260	com/tencent/mm/vfs/VFSFileInputStream:read	([B)I
    //   238: istore_1
    //   239: iload_1
    //   240: ifge +117 -> 357
    //   243: aload 7
    //   245: invokevirtual 263	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   248: aload_0
    //   249: aload 5
    //   251: invokevirtual 266	java/security/MessageDigest:digest	()[B
    //   254: putfield 126	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_ArrayOfByte	[B
    //   257: aload_0
    //   258: aload 6
    //   260: invokevirtual 266	java/security/MessageDigest:digest	()[B
    //   263: putfield 134	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_ArrayOfByte	[B
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 31	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   271: invokestatic 271	apue:b	(Ljava/lang/String;)[B
    //   274: putfield 136	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_c_of_type_ArrayOfByte	[B
    //   277: aload_0
    //   278: getfield 31	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   281: invokestatic 274	apue:a	(Ljava/lang/String;)I
    //   284: istore_1
    //   285: iload_1
    //   286: ifne +197 -> 483
    //   289: new 276	android/graphics/BitmapFactory$Options
    //   292: dup
    //   293: invokespecial 277	android/graphics/BitmapFactory$Options:<init>	()V
    //   296: astore 5
    //   298: aload 5
    //   300: iconst_1
    //   301: putfield 280	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   304: aload_0
    //   305: getfield 31	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   308: aload 5
    //   310: invokestatic 285	bbdr:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   313: pop
    //   314: aload_0
    //   315: aload 5
    //   317: getfield 288	android/graphics/BitmapFactory$Options:outWidth	I
    //   320: putfield 147	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Int	I
    //   323: aload_0
    //   324: aload 5
    //   326: getfield 291	android/graphics/BitmapFactory$Options:outHeight	I
    //   329: putfield 151	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Int	I
    //   332: aload_0
    //   333: iconst_0
    //   334: invokespecial 192	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(Z)V
    //   337: return
    //   338: astore 5
    //   340: aload_0
    //   341: bipush 254
    //   343: iconst_0
    //   344: invokespecial 121	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(IZ)V
    //   347: return
    //   348: astore 5
    //   350: aload_0
    //   351: iconst_m1
    //   352: iconst_0
    //   353: invokespecial 121	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(IZ)V
    //   356: return
    //   357: aload 5
    //   359: aload 8
    //   361: iconst_0
    //   362: iload_1
    //   363: invokevirtual 295	java/security/MessageDigest:update	([BII)V
    //   366: aload 6
    //   368: aload 8
    //   370: iconst_0
    //   371: iload_1
    //   372: invokevirtual 295	java/security/MessageDigest:update	([BII)V
    //   375: lload_2
    //   376: iload_1
    //   377: i2l
    //   378: ladd
    //   379: lstore_2
    //   380: aload_0
    //   381: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Azuq	Lazuq;
    //   384: ifnull +21 -> 405
    //   387: aload_0
    //   388: getfield 33	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Azuq	Lazuq;
    //   391: aload_0
    //   392: getfield 29	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Long	J
    //   395: lload_2
    //   396: aload_0
    //   397: getfield 93	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Long	J
    //   400: invokeinterface 298 7 0
    //   405: aload_0
    //   406: getfield 25	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Boolean	Z
    //   409: istore 4
    //   411: iload 4
    //   413: ifeq -182 -> 231
    //   416: aload 7
    //   418: invokevirtual 263	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   421: return
    //   422: astore 5
    //   424: aload 5
    //   426: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   429: return
    //   430: astore 7
    //   432: aload 7
    //   434: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   437: goto -189 -> 248
    //   440: astore 5
    //   442: aload_0
    //   443: bipush 253
    //   445: iconst_0
    //   446: invokespecial 121	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:a	(IZ)V
    //   449: aload 7
    //   451: invokevirtual 263	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   454: return
    //   455: astore 5
    //   457: aload 5
    //   459: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   462: return
    //   463: astore 5
    //   465: aload 7
    //   467: invokevirtual 263	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   470: aload 5
    //   472: athrow
    //   473: astore 6
    //   475: aload 6
    //   477: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   480: goto -10 -> 470
    //   483: iload_1
    //   484: iconst_2
    //   485: if_icmpne -153 -> 332
    //   488: aload_0
    //   489: getfield 31	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   492: invokestatic 306	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)[I
    //   495: astore 5
    //   497: aload_0
    //   498: aload 5
    //   500: iconst_0
    //   501: iaload
    //   502: putfield 147	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_a_of_type_Int	I
    //   505: aload_0
    //   506: aload 5
    //   508: iconst_1
    //   509: iaload
    //   510: putfield 151	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_b_of_type_Int	I
    //   513: aload_0
    //   514: aload 5
    //   516: iconst_2
    //   517: iaload
    //   518: putfield 155	com/tencent/mobileqq/troop/filemanager/upload/TroopFileScanTask:jdField_c_of_type_Int	I
    //   521: goto -189 -> 332
    //   524: astore 5
    //   526: goto -194 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	this	TroopFileScanTask
    //   238	248	1	i	int
    //   1	395	2	l	long
    //   409	3	4	bool	boolean
    //   204	121	5	localObject1	Object
    //   338	1	5	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   348	10	5	localFileNotFoundException	java.io.FileNotFoundException
    //   422	3	5	localIOException1	java.io.IOException
    //   440	1	5	localIOException2	java.io.IOException
    //   455	3	5	localIOException3	java.io.IOException
    //   463	8	5	localObject2	Object
    //   495	20	5	arrayOfInt	int[]
    //   524	1	5	localException	java.lang.Exception
    //   211	156	6	localMessageDigest	java.security.MessageDigest
    //   473	3	6	localIOException4	java.io.IOException
    //   91	326	7	localObject3	Object
    //   430	36	7	localIOException5	java.io.IOException
    //   229	140	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   199	213	338	java/security/NoSuchAlgorithmException
    //   213	224	348	java/io/FileNotFoundException
    //   416	421	422	java/io/IOException
    //   243	248	430	java/io/IOException
    //   224	231	440	java/io/IOException
    //   231	239	440	java/io/IOException
    //   357	375	440	java/io/IOException
    //   380	405	440	java/io/IOException
    //   405	411	440	java/io/IOException
    //   449	454	455	java/io/IOException
    //   224	231	463	finally
    //   231	239	463	finally
    //   357	375	463	finally
    //   380	405	463	finally
    //   405	411	463	finally
    //   442	449	463	finally
    //   465	470	473	java/io/IOException
    //   289	332	524	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileScanTask
 * JD-Core Version:    0.7.0.1
 */