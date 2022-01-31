package com.tencent.mobileqq.flashchat;

import adjs;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipFile;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.json.JSONObject;

public class FlashChatManager
  implements Manager
{
  public static final Handler a;
  public static SparseArray a;
  public static SparseArray b;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageForArkFlashChat jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = null;
  public FlashChatManager.GlobalConfig a;
  String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  public ConcurrentHashMap a;
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 3, 4, 2, 1, 0 };
  public ArrayList[] a;
  public ArrayList b;
  public ConcurrentHashMap b;
  boolean b;
  public ConcurrentHashMap c;
  boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new adjs());
  }
  
  public FlashChatManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig = new FlashChatManager.GlobalConfig();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ArrayOfJavaUtilArrayList = new ArrayList[2];
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface).getInt("k_flashchat_config_v" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static final int a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkFlashChat)) {
      return 1;
    }
    if ((paramMessageRecord instanceof MessageForHiBoom)) {
      return 2;
    }
    if ((paramMessageRecord instanceof MessageForScribble)) {
      return 0;
    }
    if ((paramMessageRecord instanceof MessageForPic)) {
      return 3;
    }
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      return 4;
    }
    return -1;
  }
  
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("sp_flashchat_" + paramQQAppInterface.c(), 0);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, FlashChatItem paramFlashChatItem)
  {
    int i = 0;
    int j = ((SVIPHandler)paramQQAppInterface.a(13)).j();
    switch (paramFlashChatItem.jdField_b_of_type_Int)
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      paramQQAppInterface = null;
      if (i == 0)
      {
        paramQQAppInterface = "LTMCLUB";
        if (paramFlashChatItem.jdField_b_of_type_Int == 5) {
          paramQQAppInterface = "CJCLUBT";
        }
      }
      return paramQQAppInterface;
      if (j == 3) {}
      for (i = 1;; i = 0) {
        break;
      }
      if ((j == 1) || (j == 3)) {
        i = 1;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface).edit().putInt("k_flashchat_config_v" + paramQQAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
  
  /* Error */
  private void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 6
    //   12: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +37 -> 52
    //   18: ldc 172
    //   20: iconst_2
    //   21: new 81	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   28: ldc 174
    //   30: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 176
    //   39: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: new 181	java/io/File
    //   55: dup
    //   56: new 81	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   63: aload_2
    //   64: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 184	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 7
    //   81: aload 7
    //   83: invokevirtual 190	java/io/File:exists	()Z
    //   86: ifne +9 -> 95
    //   89: aload 7
    //   91: invokevirtual 193	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: aload 11
    //   97: astore 8
    //   99: aload 10
    //   101: astore 7
    //   103: new 195	com/tencent/commonsdk/zip/QZipFile
    //   106: dup
    //   107: aload_1
    //   108: invokespecial 196	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   111: astore 12
    //   113: aload 11
    //   115: astore 8
    //   117: aload 10
    //   119: astore 7
    //   121: aload 12
    //   123: invokevirtual 202	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   126: astore 13
    //   128: aload 11
    //   130: astore 8
    //   132: aload 10
    //   134: astore 7
    //   136: sipush 8192
    //   139: newarray byte
    //   141: astore 10
    //   143: aload 9
    //   145: astore_1
    //   146: aload 6
    //   148: astore 8
    //   150: aload_1
    //   151: astore 7
    //   153: aload 13
    //   155: invokeinterface 207 1 0
    //   160: ifeq +518 -> 678
    //   163: aload 6
    //   165: astore 8
    //   167: aload_1
    //   168: astore 7
    //   170: aload 13
    //   172: invokeinterface 211 1 0
    //   177: checkcast 213	java/util/zip/ZipEntry
    //   180: astore 14
    //   182: aload 6
    //   184: astore 8
    //   186: aload_1
    //   187: astore 7
    //   189: aload 14
    //   191: invokevirtual 216	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   194: astore 9
    //   196: aload 9
    //   198: ifnull -52 -> 146
    //   201: aload 6
    //   203: astore 8
    //   205: aload_1
    //   206: astore 7
    //   208: aload 9
    //   210: ldc 218
    //   212: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   215: ifne -69 -> 146
    //   218: aload 6
    //   220: astore 8
    //   222: aload_1
    //   223: astore 7
    //   225: new 81	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   232: aload_2
    //   233: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: getstatic 184	java/io/File:separator	Ljava/lang/String;
    //   239: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 9
    //   244: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: astore 11
    //   252: aload 6
    //   254: astore 8
    //   256: aload_1
    //   257: astore 7
    //   259: aload 14
    //   261: invokevirtual 227	java/util/zip/ZipEntry:isDirectory	()Z
    //   264: ifeq +52 -> 316
    //   267: aload 6
    //   269: astore 8
    //   271: aload_1
    //   272: astore 7
    //   274: new 181	java/io/File
    //   277: dup
    //   278: aload 11
    //   280: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   283: astore 9
    //   285: aload 6
    //   287: astore 8
    //   289: aload_1
    //   290: astore 7
    //   292: aload 9
    //   294: invokevirtual 190	java/io/File:exists	()Z
    //   297: ifne +434 -> 731
    //   300: aload 6
    //   302: astore 8
    //   304: aload_1
    //   305: astore 7
    //   307: aload 9
    //   309: invokevirtual 230	java/io/File:mkdir	()Z
    //   312: pop
    //   313: goto +418 -> 731
    //   316: aload 6
    //   318: astore 8
    //   320: aload_1
    //   321: astore 7
    //   323: aload 11
    //   325: getstatic 184	java/io/File:separator	Ljava/lang/String;
    //   328: invokevirtual 234	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   331: istore_3
    //   332: aload 6
    //   334: astore 8
    //   336: aload_1
    //   337: astore 7
    //   339: aload 11
    //   341: iconst_0
    //   342: iload_3
    //   343: invokevirtual 238	java/lang/String:substring	(II)Ljava/lang/String;
    //   346: astore 9
    //   348: aload 6
    //   350: astore 8
    //   352: aload_1
    //   353: astore 7
    //   355: aload 11
    //   357: iload_3
    //   358: iconst_1
    //   359: iadd
    //   360: invokevirtual 241	java/lang/String:substring	(I)Ljava/lang/String;
    //   363: ldc 243
    //   365: invokevirtual 247	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   368: ifne -222 -> 146
    //   371: aload 6
    //   373: astore 8
    //   375: aload_1
    //   376: astore 7
    //   378: new 181	java/io/File
    //   381: dup
    //   382: aload 9
    //   384: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   387: astore 9
    //   389: aload 6
    //   391: astore 8
    //   393: aload_1
    //   394: astore 7
    //   396: aload 9
    //   398: invokevirtual 190	java/io/File:exists	()Z
    //   401: ifne +16 -> 417
    //   404: aload 6
    //   406: astore 8
    //   408: aload_1
    //   409: astore 7
    //   411: aload 9
    //   413: invokevirtual 230	java/io/File:mkdir	()Z
    //   416: pop
    //   417: aload 6
    //   419: astore 8
    //   421: aload_1
    //   422: astore 7
    //   424: new 181	java/io/File
    //   427: dup
    //   428: new 81	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   435: aload 11
    //   437: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc 249
    //   442: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   451: astore 9
    //   453: aload 6
    //   455: astore 8
    //   457: aload_1
    //   458: astore 7
    //   460: new 181	java/io/File
    //   463: dup
    //   464: aload 11
    //   466: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   469: astore 11
    //   471: aload 6
    //   473: astore 8
    //   475: aload_1
    //   476: astore 7
    //   478: aload 9
    //   480: invokevirtual 190	java/io/File:exists	()Z
    //   483: ifeq +16 -> 499
    //   486: aload 6
    //   488: astore 8
    //   490: aload_1
    //   491: astore 7
    //   493: aload 9
    //   495: invokevirtual 252	java/io/File:delete	()Z
    //   498: pop
    //   499: aload 6
    //   501: astore 8
    //   503: aload_1
    //   504: astore 7
    //   506: new 254	java/io/FileOutputStream
    //   509: dup
    //   510: aload 9
    //   512: invokespecial 257	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   515: astore 6
    //   517: aload 12
    //   519: aload 14
    //   521: invokevirtual 261	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   524: astore 7
    //   526: lconst_0
    //   527: lstore 4
    //   529: aload 7
    //   531: astore_1
    //   532: aload 7
    //   534: aload 10
    //   536: iconst_0
    //   537: aload 10
    //   539: arraylength
    //   540: invokevirtual 267	java/io/InputStream:read	([BII)I
    //   543: istore_3
    //   544: iload_3
    //   545: iconst_m1
    //   546: if_icmpeq +57 -> 603
    //   549: lload 4
    //   551: iload_3
    //   552: i2l
    //   553: ladd
    //   554: lstore 4
    //   556: aload 7
    //   558: astore_1
    //   559: aload 6
    //   561: aload 10
    //   563: iconst_0
    //   564: iload_3
    //   565: invokevirtual 271	java/io/FileOutputStream:write	([BII)V
    //   568: goto -39 -> 529
    //   571: astore_2
    //   572: aload 6
    //   574: astore 8
    //   576: aload_1
    //   577: astore 7
    //   579: aload_2
    //   580: astore_1
    //   581: aload 8
    //   583: ifnull +8 -> 591
    //   586: aload 8
    //   588: invokevirtual 274	java/io/FileOutputStream:close	()V
    //   591: aload 7
    //   593: ifnull +8 -> 601
    //   596: aload 7
    //   598: invokevirtual 275	java/io/InputStream:close	()V
    //   601: aload_1
    //   602: athrow
    //   603: aload 7
    //   605: astore_1
    //   606: aload 6
    //   608: invokevirtual 278	java/io/FileOutputStream:flush	()V
    //   611: aload 7
    //   613: astore_1
    //   614: aload 6
    //   616: invokevirtual 274	java/io/FileOutputStream:close	()V
    //   619: aload 7
    //   621: astore_1
    //   622: aload 7
    //   624: invokevirtual 275	java/io/InputStream:close	()V
    //   627: aconst_null
    //   628: astore 7
    //   630: aconst_null
    //   631: astore 8
    //   633: aload 7
    //   635: astore_1
    //   636: aload 8
    //   638: astore 6
    //   640: aload 9
    //   642: aload 11
    //   644: invokestatic 283	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;Ljava/io/File;)Z
    //   647: ifne +94 -> 741
    //   650: aload 9
    //   652: aload 11
    //   654: invokestatic 285	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   657: pop
    //   658: aload 7
    //   660: astore_1
    //   661: aload 8
    //   663: astore 6
    //   665: goto +76 -> 741
    //   668: astore_1
    //   669: aconst_null
    //   670: astore 7
    //   672: aconst_null
    //   673: astore 8
    //   675: goto -94 -> 581
    //   678: aload 6
    //   680: ifnull +8 -> 688
    //   683: aload 6
    //   685: invokevirtual 274	java/io/FileOutputStream:close	()V
    //   688: aload_1
    //   689: ifnull +7 -> 696
    //   692: aload_1
    //   693: invokevirtual 275	java/io/InputStream:close	()V
    //   696: return
    //   697: astore_2
    //   698: aload_2
    //   699: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   702: goto -14 -> 688
    //   705: astore_1
    //   706: aload_1
    //   707: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   710: return
    //   711: astore_2
    //   712: aload_2
    //   713: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   716: goto -125 -> 591
    //   719: astore_2
    //   720: aload_2
    //   721: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   724: goto -123 -> 601
    //   727: astore_1
    //   728: goto -147 -> 581
    //   731: aload 6
    //   733: astore 7
    //   735: aload_1
    //   736: astore 6
    //   738: aload 7
    //   740: astore_1
    //   741: aload 6
    //   743: astore 7
    //   745: aload_1
    //   746: astore 6
    //   748: aload 7
    //   750: astore_1
    //   751: goto -605 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	754	0	this	FlashChatManager
    //   0	754	1	paramString1	String
    //   0	754	2	paramString2	String
    //   331	234	3	i	int
    //   527	28	4	l	long
    //   10	737	6	localObject1	Object
    //   79	670	7	localObject2	Object
    //   97	577	8	localObject3	Object
    //   4	647	9	localObject4	Object
    //   1	561	10	arrayOfByte	byte[]
    //   7	646	11	localObject5	Object
    //   111	407	12	localQZipFile	QZipFile
    //   126	45	13	localEnumeration	java.util.Enumeration
    //   180	340	14	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   517	526	571	finally
    //   532	544	571	finally
    //   559	568	571	finally
    //   606	611	571	finally
    //   614	619	571	finally
    //   622	627	571	finally
    //   640	658	668	finally
    //   683	688	697	java/io/IOException
    //   692	696	705	java/io/IOException
    //   586	591	711	java/io/IOException
    //   596	601	719	java/io/IOException
    //   103	113	727	finally
    //   121	128	727	finally
    //   136	143	727	finally
    //   153	163	727	finally
    //   170	182	727	finally
    //   189	196	727	finally
    //   208	218	727	finally
    //   225	252	727	finally
    //   259	267	727	finally
    //   274	285	727	finally
    //   292	300	727	finally
    //   307	313	727	finally
    //   323	332	727	finally
    //   339	348	727	finally
    //   355	371	727	finally
    //   378	389	727	finally
    //   396	404	727	finally
    //   411	417	727	finally
    //   424	453	727	finally
    //   460	471	727	finally
    //   478	486	727	finally
    //   493	499	727	finally
    //   506	517	727	finally
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "SourceClickHandler clickWebMsg  url = " + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || ((!paramString1.startsWith("http://")) && (!paramString1.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("url", paramString1);
    paramContext.startActivity(localIntent);
    if (paramMessageRecord != null)
    {
      PublicAccountUtil.a(paramMessageRecord, localIntent, paramString1);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
    }
    return true;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +49 -> 52
    //   6: ldc 172
    //   8: iconst_2
    //   9: new 81	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 355
    //   19: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 357
    //   29: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 359
    //   39: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_3
    //   43: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_2
    //   53: aload_3
    //   54: invokestatic 362	com/tencent/mobileqq/flashchat/FlashChatManager:a	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore_1
    //   58: aload_0
    //   59: invokevirtual 366	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   62: astore_2
    //   63: aload_2
    //   64: aload_1
    //   65: iconst_0
    //   66: aaload
    //   67: iconst_1
    //   68: invokevirtual 372	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   71: ifnull +171 -> 242
    //   74: aload_2
    //   75: aload_1
    //   76: iconst_0
    //   77: aaload
    //   78: invokevirtual 376	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   81: astore_2
    //   82: aload_2
    //   83: ifnonnull +5 -> 88
    //   86: iconst_0
    //   87: ireturn
    //   88: aload_2
    //   89: ldc_w 377
    //   92: invokevirtual 381	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   95: pop
    //   96: aload_1
    //   97: iconst_1
    //   98: aaload
    //   99: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +14 -> 116
    //   105: aload_2
    //   106: aload_1
    //   107: iconst_1
    //   108: aaload
    //   109: invokestatic 387	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   112: invokevirtual 391	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   115: pop
    //   116: aload 4
    //   118: bipush 23
    //   120: invokevirtual 132	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   123: checkcast 393	com/tencent/mobileqq/app/StartAppCheckHandler
    //   126: astore_3
    //   127: aload_2
    //   128: ldc_w 395
    //   131: ldc_w 397
    //   134: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   137: pop
    //   138: aload_2
    //   139: ldc_w 399
    //   142: ldc_w 337
    //   145: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   148: pop
    //   149: aload_2
    //   150: ldc_w 401
    //   153: ldc_w 403
    //   156: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   159: pop
    //   160: aload_2
    //   161: ldc_w 405
    //   164: ldc_w 407
    //   167: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   170: pop
    //   171: aload_2
    //   172: ldc_w 409
    //   175: aload_0
    //   176: invokevirtual 413	java/lang/Object:getClass	()Ljava/lang/Class;
    //   179: invokevirtual 416	java/lang/Class:getName	()Ljava/lang/String;
    //   182: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   185: pop
    //   186: aload_3
    //   187: aload_1
    //   188: iconst_0
    //   189: aaload
    //   190: invokevirtual 419	java/lang/String:trim	()Ljava/lang/String;
    //   193: aload_0
    //   194: aload_2
    //   195: invokevirtual 422	com/tencent/mobileqq/app/StartAppCheckHandler:b	(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V
    //   198: iconst_1
    //   199: ireturn
    //   200: astore_1
    //   201: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +13 -> 217
    //   207: ldc_w 424
    //   210: iconst_2
    //   211: ldc_w 426
    //   214: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: aload_2
    //   219: invokevirtual 326	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   222: goto -24 -> 198
    //   225: astore_0
    //   226: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +13 -> 242
    //   232: ldc 172
    //   234: iconst_2
    //   235: aload_0
    //   236: invokevirtual 429	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   239: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: iconst_0
    //   243: ireturn
    //   244: astore_0
    //   245: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -6 -> 242
    //   251: ldc 172
    //   253: iconst_2
    //   254: aload_0
    //   255: invokevirtual 430	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   258: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: goto -19 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	Context
    //   0	264	1	paramString1	String
    //   0	264	2	paramString2	String
    //   0	264	3	paramString3	String
    //   0	264	4	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   116	198	200	java/lang/Exception
    //   63	82	225	android/content/pm/PackageManager$NameNotFoundException
    //   88	116	225	android/content/pm/PackageManager$NameNotFoundException
    //   116	198	225	android/content/pm/PackageManager$NameNotFoundException
    //   201	217	225	android/content/pm/PackageManager$NameNotFoundException
    //   217	222	225	android/content/pm/PackageManager$NameNotFoundException
    //   63	82	244	java/lang/RuntimeException
    //   88	116	244	java/lang/RuntimeException
    //   116	198	244	java/lang/RuntimeException
    //   201	217	244	java/lang/RuntimeException
    //   217	222	244	java/lang/RuntimeException
  }
  
  protected static final String[] a(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label49;
      }
    }
    label49:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label60;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label60:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public static String b(String paramString)
  {
    return paramString.substring(0, paramString.lastIndexOf("."));
  }
  
  public ArkFlashChatMessage a(String paramString)
  {
    int i = -1;
    ArkFlashChatMessage localArkFlashChatMessage = null;
    Object localObject3;
    if (!a()) {
      localObject3 = localArkFlashChatMessage;
    }
    do
    {
      do
      {
        return localObject3;
        localObject3 = localArkFlashChatMessage;
      } while (paramString == null);
      localObject3 = localArkFlashChatMessage;
    } while (TextUtils.isEmpty(paramString.trim()));
    Object localObject1 = b();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).split(":");
        if (localObject1.length != 2) {
          break label293;
        }
        i = Integer.valueOf(localObject1[0]).intValue();
        j = Integer.valueOf(localObject1[1]).intValue();
        localObject1 = this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i];
        if (localObject1 == null) {
          continue;
        }
        localObject3 = ((ArrayList)localObject1).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          continue;
        }
        localObject1 = (FlashChatItem)((Iterator)localObject3).next();
        if ((localObject1 == null) || (((FlashChatItem)localObject1).jdField_a_of_type_Int != j)) {
          continue;
        }
        localObject3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FlashChatItem)localObject1);
        if (localObject3 != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject2 = null;
        continue;
      }
      localObject3 = localArkFlashChatMessage;
      if (localObject1 == null) {
        break;
      }
      localArkFlashChatMessage = new ArkFlashChatMessage();
      localArkFlashChatMessage.appMinVersion = ((FlashChatItem)localObject1).jdField_e_of_type_JavaLangString;
      localArkFlashChatMessage.appName = ((FlashChatItem)localObject1).jdField_a_of_type_JavaLangString;
      localArkFlashChatMessage.appView = ((FlashChatItem)localObject1).jdField_d_of_type_JavaLangString;
      localArkFlashChatMessage.appDesc = ((FlashChatItem)localObject1).jdField_b_of_type_JavaLangString;
      localArkFlashChatMessage.appResId = ((FlashChatItem)localObject1).jdField_a_of_type_Int;
      localArkFlashChatMessage.promptText = paramString;
      localArkFlashChatMessage.config = "config";
      localObject3 = localArkFlashChatMessage;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("FlashChat", 1, "sendMessage");
      return localArkFlashChatMessage;
      a("");
      localObject1 = null;
      continue;
      label293:
      int j = -1;
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      localObject = BaseApplicationImpl.getContext();
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      localStringBuilder = new StringBuilder();
      if (!bool) {
        break label87;
      }
    }
    label87:
    for (Object localObject = AppConstants.aJ;; localObject = ((Context)localObject).getCacheDir().getAbsolutePath())
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject + File.separator + "flashchat" + File.separator);
      new File(this.jdField_a_of_type_JavaLangString).mkdirs();
      return this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    FlashChatManager.FlashPackCfg localFlashPackCfg = FlashChatManager.FlashPackCfg.a(FileUtils.a(new File(a("flashchat." + paramInt + ".cfg"))));
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "getAppPathByNameFromLocal " + localFlashPackCfg);
    }
    if (localFlashPackCfg == null) {
      localObject1 = localObject3;
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject3;
      } while (!new File(a(localFlashPackCfg.jdField_b_of_type_JavaLangString)).exists());
      paramString1 = new File(a() + b(localFlashPackCfg.jdField_b_of_type_JavaLangString) + File.separator + paramString1);
      localObject1 = localObject3;
    } while (!paramString1.exists());
    Object localObject1 = paramString1.listFiles();
    int i = localObject1.length;
    paramInt = 0;
    label192:
    if (paramInt < i)
    {
      paramString1 = localObject1[paramInt];
      if ((!paramString1.getName().endsWith(".app")) || (!paramString1.getName().contains(paramString2))) {}
    }
    for (;;)
    {
      localObject1 = localObject3;
      if (paramString1 == null) {
        break;
      }
      try
      {
        new QZipFile(paramString1).close();
        paramString2 = paramString1.getAbsolutePath();
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString1.delete();
          paramString2.printStackTrace();
          paramString1 = localObject2;
        }
      }
      localObject1 = paramString1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FlashChat", 2, "getAppPathByNameFromLocal path " + paramString1);
      return paramString1;
      paramInt += 1;
      break label192;
      paramString1 = null;
    }
  }
  
  public String a(String paramString)
  {
    return a() + paramString;
  }
  
  public ArrayList a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "getItemList");
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(FlashChatItem.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem);
      return localArrayList;
    }
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfJavaUtilArrayList[0] = a();
    this.jdField_a_of_type_ArrayOfJavaUtilArrayList[1] = a();
  }
  
  public void a(int paramInt)
  {
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183);
    String str = "flashchat." + paramInt + ".cfg";
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, String.valueOf(paramInt));
    localVasQuickUpdateManager.a(1002L, str, "initChatResource");
  }
  
  public void a(Context paramContext, MessageRecord paramMessageRecord)
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    String str1 = localGlobalConfig.jdField_c_of_type_JavaLangString;
    String str2 = localGlobalConfig.jdField_f_of_type_JavaLangString;
    String str3 = localGlobalConfig.jdField_g_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "clickQIMSource clickAppMsg url = " + str1 + ", actionData = " + str2 + ", actionDataA = " + str3 + paramMessageRecord);
    }
    if (a(paramContext, str1, str2, str3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    while (!a(paramContext, str1, localGlobalConfig.jdField_b_of_type_JavaLangString, paramMessageRecord)) {
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = a(paramQQAppInterface);
    int j = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.i("FlashChat", 2, "handleFlashChatConfig l :" + i + " s : " + j);
    }
    if (i != j)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label253;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig == null) {
        break label253;
      }
      if (paramConfig.compress.get() != 1) {
        break label239;
      }
      paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label277;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {
          break label253;
        }
        QLog.i("FlashChat", 1, "handleFlashChatConfig content" + paramConfig);
        String str = c();
        if (!FileUtils.a(str, paramConfig))
        {
          FileUtils.d(str);
          FileUtils.a(str, paramConfig);
        }
        a(paramQQAppInterface, j);
        c(paramConfig);
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.e("FlashChat", 1, "handleFlashChatConfig|uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      label239:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label253:
      QLog.i("FlashChat", 1, "handleFlashChatConfig content empty");
      FileUtils.d(c());
      a(paramQQAppInterface, j);
      return;
      label277:
      paramConfig = null;
    }
  }
  
  public void a(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "setNeedAnim i");
    }
    if ((paramMessageForArkFlashChat != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat.uniseq != paramMessageForArkFlashChat.uniseq))) {
      if (paramMessageForArkFlashChat == null) {
        break label64;
      }
    }
    label64:
    for (Long localLong = Long.valueOf(paramMessageForArkFlashChat.uniseq);; localLong = null)
    {
      a(localLong);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = paramMessageForArkFlashChat;
      return;
    }
  }
  
  public void a(Long paramLong)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramLong = new FlashChatManager.StopTask(localArrayList, paramLong);
    ArkDispatchTask.getInstance().send(paramLong);
  }
  
  public void a(String paramString)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).edit().putString("flashchat_sel_0", paramString).commit();
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "onGetFlashItems begin");
    }
    if (paramArrayList != null)
    {
      paramArrayList.add(0, FlashChatItem.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem);
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      this.jdField_a_of_type_ArrayOfJavaUtilArrayList[0] = this.jdField_b_of_type_JavaUtilArrayList;
      this.jdField_a_of_type_ArrayOfJavaUtilArrayList[1] = this.jdField_b_of_type_JavaUtilArrayList;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        FlashChatItem localFlashChatItem = (FlashChatItem)paramArrayList.next();
        if (QLog.isColorLevel()) {
          QLog.d("FlashChat", 2, "onGetFlashItems item = " + localFlashChatItem);
        }
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).edit().putBoolean("flashchat_switch", paramBoolean).commit();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 969, true, null);
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "isSwitchCombine g " + this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_a_of_type_JavaLangString + " u " + this.jdField_a_of_type_Boolean);
    }
    return (c()) && (this.jdField_a_of_type_Boolean);
  }
  
  public boolean a(int paramInt, MessageRecord paramMessageRecord)
  {
    SparseArray localSparseArray2 = jdField_a_of_type_AndroidUtilSparseArray;
    SparseArray localSparseArray1 = jdField_b_of_type_AndroidUtilSparseArray;
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    long l1;
    if ((localSparseArray2 == null) || (localSparseArray1 == null))
    {
      localSparseArray2 = new SparseArray();
      localSparseArray1 = new SparseArray();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_flashchat_source", 0);
      localObject2 = this.jdField_a_of_type_ArrayOfInt;
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        int k = localObject2[i];
        int m = ((SharedPreferences)localObject1).getInt("use_count_" + k, 0);
        l1 = ((SharedPreferences)localObject1).getLong("use_lasttime_" + k, 0L);
        localSparseArray2.put(k, Integer.valueOf(m));
        localSparseArray1.put(k, Long.valueOf(l1));
        i += 1;
      }
    }
    for (;;)
    {
      long l2;
      switch (paramInt)
      {
      default: 
        i = 0;
        l1 = 0L;
        j = 0;
        l2 = 0L;
        localObject1 = (Integer)localSparseArray2.get(paramInt);
        localObject2 = (Long)localSparseArray1.get(paramInt);
        if (localObject1 != null) {
          j = ((Integer)localObject1).intValue();
        }
        if (localObject2 != null) {
          l2 = ((Long)localObject2).longValue();
        }
        if ((j >= i) || (Math.abs(System.currentTimeMillis() - l2) <= l1)) {
          break;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FlashChat", 2, "hasLeftCount type " + paramInt + " ," + bool + ", " + j + ", " + i + ", " + l2 + ", " + l1);
        }
        if (bool)
        {
          l1 = System.currentTimeMillis();
          localSparseArray2.put(paramInt, Integer.valueOf(j + 1));
          localSparseArray1.put(paramInt, Long.valueOf(l1));
          paramMessageRecord.saveExtInfoToExtStr("qim_source", "1");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008278", "0X8008278", paramInt, 0, "", "", "", "");
        }
        jdField_a_of_type_AndroidUtilSparseArray = localSparseArray2;
        jdField_b_of_type_AndroidUtilSparseArray = localSparseArray1;
        return bool;
        i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_b_of_type_Int;
        l1 = 0L;
        break;
        i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_c_of_type_Int;
        l1 = 0L;
        break;
        i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_a_of_type_Int;
        l1 = 0L;
        break;
        i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_d_of_type_Int;
        l1 = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_f_of_type_Int;
        l1 *= 1000L;
        break;
        i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_e_of_type_Int;
        l1 = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_g_of_type_Int;
        l1 *= 1000L;
        break;
      }
    }
  }
  
  public boolean a(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat.uniseq == paramMessageForArkFlashChat.uniseq);
  }
  
  public String b()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getString("flashchat_sel_0", "");
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getBoolean("flashchat_switch", true);
    c();
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "initAndGetSwitch " + this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_a_of_type_JavaLangString + " u " + this.jdField_a_of_type_Boolean);
    }
    if ((jdField_a_of_type_AndroidUtilSparseArray == null) || (jdField_b_of_type_AndroidUtilSparseArray == null))
    {
      SparseArray localSparseArray1 = new SparseArray();
      SparseArray localSparseArray2 = new SparseArray();
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_flashchat_source", 0);
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        int m = localSharedPreferences.getInt("use_count_" + k, 0);
        long l = localSharedPreferences.getLong("use_lasttime_" + k, 0L);
        localSparseArray1.put(k, Integer.valueOf(m));
        localSparseArray2.put(k, Long.valueOf(l));
        i += 1;
      }
      jdField_a_of_type_AndroidUtilSparseArray = localSparseArray1;
      jdField_b_of_type_AndroidUtilSparseArray = localSparseArray2;
    }
    a();
    ((FlashChatHanlder)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(109)).b();
  }
  
  public void b(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    if ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForArkFlashChat.uniseq)) == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForArkFlashChat.uniseq), Long.valueOf(System.currentTimeMillis()));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramMessageForArkFlashChat);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "parseJson isMainThread scid " + paramString);
    }
    if (paramString != null)
    {
      if (!paramString.endsWith(".cfg")) {
        break label132;
      }
      ??? = (String)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      paramString = FlashChatManager.FlashPackCfg.a(FileUtils.a(new File(a(paramString))));
      if ((paramString != null) && (paramString.jdField_b_of_type_JavaLangString != null) && (??? != null))
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.jdField_b_of_type_JavaLangString, ???);
        ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183)).a(1002L, paramString.jdField_b_of_type_JavaLangString, "FlashChatManager");
      }
    }
    label132:
    while (!paramString.endsWith(".zip")) {
      return;
    }
    String str3 = a(paramString);
    ??? = b(paramString);
    String str2 = a() + ??? + File.separator;
    new StringBuilder().append(a()).append(???).append("tmp").append(File.separator).toString();
    File localFile;
    synchronized (str2.intern())
    {
      localFile = new File(str2);
    }
    try
    {
      a(str3, str2);
      int i = Integer.valueOf((String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue();
      paramString = new Bundle();
      paramString.putInt("resourceId", i);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 968, true, paramString);
      return;
      paramString = finally;
      throw paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = paramString;
        paramString.printStackTrace();
        if (0 != 0) {
          throw new NullPointerException();
        }
        if (localFile != null) {
          localFile.delete();
        }
      }
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "setTurnOn isChecked " + paramBoolean);
    }
    ((FlashChatHanlder)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(109)).a(paramBoolean);
  }
  
  public boolean b()
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "isSwitchUser g " + this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_a_of_type_JavaLangString + " u " + this.jdField_a_of_type_Boolean);
    }
    if (MobileQQ.processName.startsWith("com.tencent.mobileqq")) {
      return TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_a_of_type_JavaLangString, "1");
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    paramMessageForArkFlashChat = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForArkFlashChat.uniseq));
    return (paramMessageForArkFlashChat != null) && (System.currentTimeMillis() - paramMessageForArkFlashChat.longValue() < 600L);
  }
  
  public String c()
  {
    String str = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "flashchat" + File.separator;
    new File(str).mkdirs();
    return str + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "config.xml";
  }
  
  public void c()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    c(FileUtils.a(new File(c())));
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlashChat", 2, "loadConfig l :" + paramString);
    }
    FlashChatManager.GlobalConfig localGlobalConfig = new FlashChatManager.GlobalConfig();
    try
    {
      paramString = new JSONObject(paramString);
      localGlobalConfig.jdField_a_of_type_JavaLangString = paramString.optString("entry", "1");
      localGlobalConfig.jdField_b_of_type_JavaLangString = paramString.optString("name", null);
      localGlobalConfig.jdField_d_of_type_JavaLangString = paramString.optString("icon", null);
      localGlobalConfig.jdField_f_of_type_JavaLangString = paramString.optString("actionI", null);
      localGlobalConfig.jdField_g_of_type_JavaLangString = paramString.optString("actionA", null);
      localGlobalConfig.jdField_c_of_type_JavaLangString = paramString.optString("url", null);
      localGlobalConfig.jdField_a_of_type_Int = paramString.optInt("scC", 2);
      localGlobalConfig.jdField_b_of_type_Int = paramString.optInt("hiC", 2);
      localGlobalConfig.jdField_c_of_type_Int = paramString.optInt("flC", 2);
      localGlobalConfig.jdField_d_of_type_Int = paramString.optInt("piC", 3);
      localGlobalConfig.jdField_e_of_type_Int = paramString.optInt("tvC", 3);
      localGlobalConfig.h = paramString.optString("recordRule", "1");
      localGlobalConfig.jdField_f_of_type_Int = paramString.optInt("pIn", 60);
      localGlobalConfig.jdField_g_of_type_Int = paramString.optInt("tvI", 60);
      localGlobalConfig.jdField_a_of_type_Boolean = "1".equals(paramString.optString("qimNotifyEnable", "0"));
      localGlobalConfig.jdField_b_of_type_Boolean = "1".equals(paramString.optString("qimPopUpEnable", "0"));
      localGlobalConfig.i = paramString.optString("qimNotifySource", "");
      localGlobalConfig.jdField_e_of_type_JavaLangString = paramString.optString("qimNotifyLogo", "");
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig = localGlobalConfig;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 969, true, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 970, true, null);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        QLog.e("FlashChat", 1, "handleFlashChatConfig failed" + paramString);
      }
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public String d()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    if (localGlobalConfig != null) {
      return localGlobalConfig.i;
    }
    return "";
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "requestAIOFlashItems");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), FlashChatServlet.class);
    localNewIntent.putExtra("req_type", 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    boolean bool1 = bool2;
    if (localGlobalConfig != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localGlobalConfig.jdField_g_of_type_JavaLangString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean e()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    if (localGlobalConfig != null) {
      return localGlobalConfig.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean f()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    if (localGlobalConfig != null) {
      return localGlobalConfig.jdField_b_of_type_Boolean;
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.d = false;
    this.jdField_b_of_type_Boolean = false;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_flashchat_source", 0).edit();
    SparseArray localSparseArray1 = jdField_a_of_type_AndroidUtilSparseArray;
    SparseArray localSparseArray2 = jdField_b_of_type_AndroidUtilSparseArray;
    if (localSparseArray1 != null)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        Integer localInteger = (Integer)localSparseArray1.get(k);
        Long localLong = (Long)localSparseArray2.get(k);
        if (localInteger != null)
        {
          int m = localInteger.intValue();
          localEditor.putInt("use_count_" + k, m);
        }
        if (localLong != null) {
          localEditor.putLong("use_lasttime_" + k, localLong.longValue());
        }
        i += 1;
      }
    }
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager
 * JD-Core Version:    0.7.0.1
 */