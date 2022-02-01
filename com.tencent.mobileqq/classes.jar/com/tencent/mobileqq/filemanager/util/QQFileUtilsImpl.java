package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileProcessor;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQFileUtilsImpl
{
  public static int a()
  {
    int i = 1;
    int j = NetConnInfoCenter.getActiveNetIpFamily(true);
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          return 0;
        }
        return 2;
      }
      i = 3;
    }
    return i;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 * 1.0F / paramInt2 >= 1.777778F) {
      return 2;
    }
    return 1;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = b(new URL(paramString).getHost());
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  private static SpannableString a(String paramString1, String paramString2, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    int k = paramString1.indexOf(paramString2);
    if (k < 0) {
      return new SpannableString(paramString1);
    }
    int m = paramString2.length();
    int j = Color.parseColor("#4799DF");
    int i;
    if (paramTipsClickedInterface != null) {
      i = Color.parseColor("#A3CCEF");
    } else {
      i = j;
    }
    paramString2 = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { i, j });
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSpannableString(paramString1, paramTipsClickedInterface, paramString2, k, k + m);
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, TextView paramTextView1, TextView paramTextView2, String paramString1, String paramString2)
  {
    paramTextView1 = paramTextView1.getPaint();
    paramTextView2 = paramTextView2.getPaint();
    int i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(7, paramContext.getResources());
    int j = (int)paramTextView2.measureText(paramString2);
    int k = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(15, paramContext.getResources());
    paramContext = paramString1;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return paramString1;
      }
      paramContext = (String)TextUtils.ellipsize(paramString1, paramTextView1, paramInt2 - i * 2 - j - k, TextUtils.TruncateAt.END);
    }
    return paramContext;
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131692346));
      }
      localStringBuilder.append("来自");
      localStringBuilder.append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131692346));
      }
      localStringBuilder.append(paramString3);
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131692346));
      }
      localStringBuilder.append(paramString4);
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString3);
    if (i < 0) {
      return paramString2;
    }
    int j = paramString1.indexOf("\n");
    if (j > i)
    {
      paramString1 = paramString1.substring(i + paramString3.length(), j);
      if (paramString1.contains(paramString2)) {
        return paramString2;
      }
      if (paramString1.length() < paramString2.length())
      {
        paramString2 = new StringBuilder(paramString2);
        paramString2.insert(paramString1.length(), "\n");
        return paramString2.toString();
      }
    }
    return paramString2;
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    String str = a(paramContext, paramString1, paramString2, paramString3, paramString4);
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramTextView.getWidth() == 0)
      {
        paramTextView.post(new QQFileUtilsImpl.2(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramTipsClickedInterface));
        return;
      }
      c(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramTipsClickedInterface);
      return;
    }
    if (!TextUtils.isEmpty(str.replace(" ", "")))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString5);
      paramContext.append(str);
      paramTextView.setText(paramContext.toString());
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity, MessageRecord paramMessageRecord)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    String str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    int i = Integer.parseInt(str);
    paramBaseQQAppInterface = paramBaseQQAppInterface.getCurrentAccountUin();
    str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSenderUin");
    if (i == 1)
    {
      paramFileManagerEntity.peerType = 0;
      if ((!TextUtils.isEmpty(paramBaseQQAppInterface)) && (!TextUtils.isEmpty(str)) && (paramBaseQQAppInterface.equals(str))) {
        paramFileManagerEntity.peerUin = paramMessageRecord;
      }
    }
    else if (i == 2)
    {
      paramFileManagerEntity.peerType = 3000;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (QQFileManagerUtilImpl.a(paramString) <= 10485760L) {
      return true;
    }
    FMDialogUtil.a(paramContext, "", 2131698225, new QQFileUtilsImpl.1(paramContext, paramString));
    return false;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 243	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: iconst_0
    //   13: istore 5
    //   15: iload 7
    //   17: ifne +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_2
    //   23: ifnonnull +5 -> 28
    //   26: iconst_0
    //   27: ireturn
    //   28: iconst_1
    //   29: istore 7
    //   31: aconst_null
    //   32: astore 9
    //   34: aconst_null
    //   35: astore 8
    //   37: aconst_null
    //   38: astore 11
    //   40: aload_0
    //   41: invokevirtual 247	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   44: aload_2
    //   45: ldc 249
    //   47: invokevirtual 255	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnonnull +20 -> 72
    //   55: aload_0
    //   56: ifnull +14 -> 70
    //   59: aload_0
    //   60: invokevirtual 260	android/os/ParcelFileDescriptor:close	()V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: new 265	java/io/FileOutputStream
    //   75: dup
    //   76: aload_0
    //   77: invokevirtual 269	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   80: invokespecial 272	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   83: astore_2
    //   84: aload 9
    //   86: astore 8
    //   88: aload_0
    //   89: astore 10
    //   91: aload_2
    //   92: astore 12
    //   94: new 274	java/io/FileInputStream
    //   97: dup
    //   98: aload_1
    //   99: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   102: astore_1
    //   103: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   106: sipush 4096
    //   109: invokevirtual 285	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   112: astore 8
    //   114: aload_1
    //   115: aload 8
    //   117: invokevirtual 289	java/io/FileInputStream:read	([B)I
    //   120: istore_3
    //   121: iload_3
    //   122: iconst_m1
    //   123: if_icmpeq +14 -> 137
    //   126: aload_2
    //   127: aload 8
    //   129: iconst_0
    //   130: iload_3
    //   131: invokevirtual 293	java/io/FileOutputStream:write	([BII)V
    //   134: goto -20 -> 114
    //   137: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   140: aload 8
    //   142: invokevirtual 297	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   145: aload_2
    //   146: invokevirtual 300	java/io/FileOutputStream:flush	()V
    //   149: aload_1
    //   150: invokevirtual 301	java/io/FileInputStream:close	()V
    //   153: iload 7
    //   155: istore 4
    //   157: goto +11 -> 168
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   165: iconst_0
    //   166: istore 4
    //   168: aload_2
    //   169: invokevirtual 302	java/io/FileOutputStream:close	()V
    //   172: goto +12 -> 184
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   180: iload 5
    //   182: istore 4
    //   184: iload 4
    //   186: istore 5
    //   188: aload_0
    //   189: ifnull +175 -> 364
    //   192: iload 4
    //   194: istore 5
    //   196: aload_0
    //   197: invokevirtual 260	android/os/ParcelFileDescriptor:close	()V
    //   200: iload 4
    //   202: ireturn
    //   203: astore_0
    //   204: aload_0
    //   205: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   208: iload 5
    //   210: ireturn
    //   211: astore 9
    //   213: aload_1
    //   214: astore 8
    //   216: aload_0
    //   217: astore 10
    //   219: aload 9
    //   221: astore_0
    //   222: aload_2
    //   223: astore_1
    //   224: goto +147 -> 371
    //   227: astore 8
    //   229: aload_1
    //   230: astore 11
    //   232: aload_0
    //   233: astore 9
    //   235: aload 8
    //   237: astore_0
    //   238: aload_2
    //   239: astore_1
    //   240: goto +53 -> 293
    //   243: astore_1
    //   244: aload_0
    //   245: astore 9
    //   247: aload_1
    //   248: astore_0
    //   249: aload_2
    //   250: astore_1
    //   251: goto +42 -> 293
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_0
    //   258: astore 10
    //   260: aload_2
    //   261: astore_0
    //   262: goto +109 -> 371
    //   265: astore_2
    //   266: aconst_null
    //   267: astore_1
    //   268: aload_0
    //   269: astore 9
    //   271: aload_2
    //   272: astore_0
    //   273: goto +20 -> 293
    //   276: astore_0
    //   277: aconst_null
    //   278: astore 10
    //   280: aload 10
    //   282: astore_1
    //   283: goto +88 -> 371
    //   286: astore_0
    //   287: aconst_null
    //   288: astore 9
    //   290: aload 9
    //   292: astore_1
    //   293: aload 11
    //   295: astore 8
    //   297: aload 9
    //   299: astore 10
    //   301: aload_1
    //   302: astore 12
    //   304: aload_0
    //   305: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   308: aload 11
    //   310: ifnull +16 -> 326
    //   313: aload 11
    //   315: invokevirtual 301	java/io/FileInputStream:close	()V
    //   318: goto +8 -> 326
    //   321: astore_0
    //   322: aload_0
    //   323: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   326: aload_1
    //   327: ifnull +15 -> 342
    //   330: aload_1
    //   331: invokevirtual 302	java/io/FileOutputStream:close	()V
    //   334: goto +8 -> 342
    //   337: astore_0
    //   338: aload_0
    //   339: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   342: iload 4
    //   344: istore 5
    //   346: aload 9
    //   348: ifnull +16 -> 364
    //   351: iload 6
    //   353: istore 5
    //   355: aload 9
    //   357: invokevirtual 260	android/os/ParcelFileDescriptor:close	()V
    //   360: iload 4
    //   362: istore 5
    //   364: iload 5
    //   366: ireturn
    //   367: astore_0
    //   368: aload 12
    //   370: astore_1
    //   371: aload 8
    //   373: ifnull +16 -> 389
    //   376: aload 8
    //   378: invokevirtual 301	java/io/FileInputStream:close	()V
    //   381: goto +8 -> 389
    //   384: astore_2
    //   385: aload_2
    //   386: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   389: aload_1
    //   390: ifnull +15 -> 405
    //   393: aload_1
    //   394: invokevirtual 302	java/io/FileOutputStream:close	()V
    //   397: goto +8 -> 405
    //   400: astore_1
    //   401: aload_1
    //   402: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   405: aload 10
    //   407: ifnull +16 -> 423
    //   410: aload 10
    //   412: invokevirtual 260	android/os/ParcelFileDescriptor:close	()V
    //   415: goto +8 -> 423
    //   418: astore_1
    //   419: aload_1
    //   420: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   423: goto +5 -> 428
    //   426: aload_0
    //   427: athrow
    //   428: goto -2 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	paramContext	Context
    //   0	431	1	paramString	String
    //   0	431	2	paramUri	android.net.Uri
    //   120	11	3	i	int
    //   10	351	4	bool1	boolean
    //   13	352	5	bool2	boolean
    //   7	345	6	bool3	boolean
    //   4	150	7	bool4	boolean
    //   35	180	8	localObject1	Object
    //   227	9	8	localException	Exception
    //   295	82	8	localObject2	Object
    //   32	53	9	localObject3	Object
    //   211	9	9	localObject4	Object
    //   233	123	9	localContext1	Context
    //   89	322	10	localContext2	Context
    //   38	276	11	str	String
    //   92	277	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   59	63	65	java/io/IOException
    //   149	153	160	java/io/IOException
    //   168	172	175	java/io/IOException
    //   196	200	203	java/io/IOException
    //   355	360	203	java/io/IOException
    //   103	114	211	finally
    //   114	121	211	finally
    //   126	134	211	finally
    //   137	149	211	finally
    //   103	114	227	java/lang/Exception
    //   114	121	227	java/lang/Exception
    //   126	134	227	java/lang/Exception
    //   137	149	227	java/lang/Exception
    //   94	103	243	java/lang/Exception
    //   72	84	254	finally
    //   72	84	265	java/lang/Exception
    //   40	51	276	finally
    //   40	51	286	java/lang/Exception
    //   313	318	321	java/io/IOException
    //   330	334	337	java/io/IOException
    //   94	103	367	finally
    //   304	308	367	finally
    //   376	381	384	java/io/IOException
    //   393	397	400	java/io/IOException
    //   410	415	418	java/io/IOException
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    if ((!paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isReplySource)) {
      return false;
    }
    return !TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType"));
  }
  
  public static int b()
  {
    int i = a();
    if (1 == i) {
      return 1;
    }
    if (3 == i) {
      return 2;
    }
    if (2 == i) {
      return 3;
    }
    return 0;
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$").matcher(paramString).matches()) {
      return 1;
    }
    paramString = paramString.replaceAll("[\\[\\]]", "");
    if ((!TextUtils.isEmpty(paramString)) && (IPAddressUtil.isIPv6LiteralAddress(paramString))) {
      return 2;
    }
    return 0;
  }
  
  public static int c()
  {
    int i = MsfServiceSdk.get().getConnectedIPFamily();
    if (2 == i) {
      return 2;
    }
    if (1 == i) {
      return 1;
    }
    return 0;
  }
  
  private static void c(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    String str = a(paramContext, paramString1, paramString2, paramString3, paramString4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString5);
    localStringBuilder.append(str);
    paramString2 = QQFileManagerUtilImpl.a(paramTextView, 2, localStringBuilder.toString(), paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramContext = a(paramContext, paramString1, paramString2, paramString3, paramString4);
      paramString1 = new StringBuilder();
      paramString1.append(paramString5);
      paramString1.append(paramContext);
      paramContext = QQFileManagerUtilImpl.a(paramTextView, paramString1.toString());
      paramString1 = a(paramContext, paramString2, HardCodeUtil.a(2131709686));
      if (paramBoolean) {
        paramContext = a(paramContext, paramString1, paramTipsClickedInterface);
      } else {
        paramContext = new SpannableString(paramContext);
      }
    }
    else
    {
      paramContext = null;
    }
    if (QVipTroopFileProcessor.c().a())
    {
      paramString1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getVipType();
      QVipTroopFileProcessor.c().a(paramContext, paramString4, paramString1);
    }
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(paramContext);
      paramTextView.setFocusable(false);
      paramTextView.setClickable(false);
      paramTextView.setLongClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileUtilsImpl
 * JD-Core Version:    0.7.0.1
 */