package com.tencent.mobileqq.flashchat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.QStorageSafeDeleteException;
import com.tencent.mobileqq.config.business.FlashChatConfBean;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class FlashChatManager
  implements Manager
{
  public static SparseArray<Integer> b;
  public static SparseArray<Long> c;
  public SparseArray<String> a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QStorage jdField_a_of_type_ComTencentMobileqqConfigQStorage = QStorage.a("flashchat");
  MessageForArkFlashChat jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = null;
  public FlashChatManager.GlobalConfig a;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<FlashChatItem> a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public ConcurrentHashMap<Long, Long> a;
  public CopyOnWriteArrayList<MessageForArkFlashChat> a;
  public AtomicBoolean a;
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 3, 4, 2, 1, 0 };
  public ConcurrentHashMap<String, String> b;
  boolean b;
  public ConcurrentHashMap<String, String> c;
  boolean c;
  private boolean d;
  
  static
  {
    jdField_b_of_type_AndroidUtilSparseArray = null;
    jdField_c_of_type_AndroidUtilSparseArray = null;
  }
  
  public FlashChatManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig = new FlashChatManager.GlobalConfig();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ThreadManager.post(new FlashChatManager.1(this), 8, null, true);
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
  
  public static String a(QQAppInterface paramQQAppInterface, FlashChatItem paramFlashChatItem)
  {
    int i = 0;
    int j = ((SVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
    switch (paramFlashChatItem.feedType)
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
        if (paramFlashChatItem.feedType == 5) {
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
    //   12: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +37 -> 52
    //   18: ldc 158
    //   20: iconst_2
    //   21: new 160	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   28: ldc 163
    //   30: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 169
    //   39: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: new 178	java/io/File
    //   55: dup
    //   56: new 160	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   63: aload_2
    //   64: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 181	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 7
    //   81: aload 7
    //   83: invokevirtual 187	java/io/File:exists	()Z
    //   86: ifne +9 -> 95
    //   89: aload 7
    //   91: invokevirtual 190	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: aload 11
    //   97: astore 8
    //   99: aload 10
    //   101: astore 7
    //   103: new 192	com/tencent/commonsdk/zip/QZipFile
    //   106: dup
    //   107: aload_1
    //   108: invokespecial 193	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   111: astore 12
    //   113: aload 11
    //   115: astore 8
    //   117: aload 10
    //   119: astore 7
    //   121: aload 12
    //   123: invokevirtual 199	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
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
    //   155: invokeinterface 204 1 0
    //   160: ifeq +518 -> 678
    //   163: aload 6
    //   165: astore 8
    //   167: aload_1
    //   168: astore 7
    //   170: aload 13
    //   172: invokeinterface 208 1 0
    //   177: checkcast 210	java/util/zip/ZipEntry
    //   180: astore 14
    //   182: aload 6
    //   184: astore 8
    //   186: aload_1
    //   187: astore 7
    //   189: aload 14
    //   191: invokevirtual 213	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   194: astore 9
    //   196: aload 9
    //   198: ifnull -52 -> 146
    //   201: aload 6
    //   203: astore 8
    //   205: aload_1
    //   206: astore 7
    //   208: aload 9
    //   210: ldc 215
    //   212: invokevirtual 221	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   215: ifne -69 -> 146
    //   218: aload 6
    //   220: astore 8
    //   222: aload_1
    //   223: astore 7
    //   225: new 160	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   232: aload_2
    //   233: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: getstatic 181	java/io/File:separator	Ljava/lang/String;
    //   239: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 9
    //   244: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: astore 11
    //   252: aload 6
    //   254: astore 8
    //   256: aload_1
    //   257: astore 7
    //   259: aload 14
    //   261: invokevirtual 224	java/util/zip/ZipEntry:isDirectory	()Z
    //   264: ifeq +52 -> 316
    //   267: aload 6
    //   269: astore 8
    //   271: aload_1
    //   272: astore 7
    //   274: new 178	java/io/File
    //   277: dup
    //   278: aload 11
    //   280: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   283: astore 9
    //   285: aload 6
    //   287: astore 8
    //   289: aload_1
    //   290: astore 7
    //   292: aload 9
    //   294: invokevirtual 187	java/io/File:exists	()Z
    //   297: ifne +434 -> 731
    //   300: aload 6
    //   302: astore 8
    //   304: aload_1
    //   305: astore 7
    //   307: aload 9
    //   309: invokevirtual 227	java/io/File:mkdir	()Z
    //   312: pop
    //   313: goto +418 -> 731
    //   316: aload 6
    //   318: astore 8
    //   320: aload_1
    //   321: astore 7
    //   323: aload 11
    //   325: getstatic 181	java/io/File:separator	Ljava/lang/String;
    //   328: invokevirtual 231	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   331: istore_3
    //   332: aload 6
    //   334: astore 8
    //   336: aload_1
    //   337: astore 7
    //   339: aload 11
    //   341: iconst_0
    //   342: iload_3
    //   343: invokevirtual 235	java/lang/String:substring	(II)Ljava/lang/String;
    //   346: astore 9
    //   348: aload 6
    //   350: astore 8
    //   352: aload_1
    //   353: astore 7
    //   355: aload 11
    //   357: iload_3
    //   358: iconst_1
    //   359: iadd
    //   360: invokevirtual 238	java/lang/String:substring	(I)Ljava/lang/String;
    //   363: ldc 240
    //   365: invokevirtual 244	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   368: ifne -222 -> 146
    //   371: aload 6
    //   373: astore 8
    //   375: aload_1
    //   376: astore 7
    //   378: new 178	java/io/File
    //   381: dup
    //   382: aload 9
    //   384: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   387: astore 9
    //   389: aload 6
    //   391: astore 8
    //   393: aload_1
    //   394: astore 7
    //   396: aload 9
    //   398: invokevirtual 187	java/io/File:exists	()Z
    //   401: ifne +16 -> 417
    //   404: aload 6
    //   406: astore 8
    //   408: aload_1
    //   409: astore 7
    //   411: aload 9
    //   413: invokevirtual 227	java/io/File:mkdir	()Z
    //   416: pop
    //   417: aload 6
    //   419: astore 8
    //   421: aload_1
    //   422: astore 7
    //   424: new 178	java/io/File
    //   427: dup
    //   428: new 160	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   435: aload 11
    //   437: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc 246
    //   442: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   451: astore 9
    //   453: aload 6
    //   455: astore 8
    //   457: aload_1
    //   458: astore 7
    //   460: new 178	java/io/File
    //   463: dup
    //   464: aload 11
    //   466: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   469: astore 11
    //   471: aload 6
    //   473: astore 8
    //   475: aload_1
    //   476: astore 7
    //   478: aload 9
    //   480: invokevirtual 187	java/io/File:exists	()Z
    //   483: ifeq +16 -> 499
    //   486: aload 6
    //   488: astore 8
    //   490: aload_1
    //   491: astore 7
    //   493: aload 9
    //   495: invokevirtual 249	java/io/File:delete	()Z
    //   498: pop
    //   499: aload 6
    //   501: astore 8
    //   503: aload_1
    //   504: astore 7
    //   506: new 251	java/io/FileOutputStream
    //   509: dup
    //   510: aload 9
    //   512: invokespecial 254	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   515: astore 6
    //   517: aload 12
    //   519: aload 14
    //   521: invokevirtual 258	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
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
    //   540: invokevirtual 264	java/io/InputStream:read	([BII)I
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
    //   565: invokevirtual 268	java/io/FileOutputStream:write	([BII)V
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
    //   588: invokevirtual 271	java/io/FileOutputStream:close	()V
    //   591: aload 7
    //   593: ifnull +8 -> 601
    //   596: aload 7
    //   598: invokevirtual 272	java/io/InputStream:close	()V
    //   601: aload_1
    //   602: athrow
    //   603: aload 7
    //   605: astore_1
    //   606: aload 6
    //   608: invokevirtual 275	java/io/FileOutputStream:flush	()V
    //   611: aload 7
    //   613: astore_1
    //   614: aload 6
    //   616: invokevirtual 271	java/io/FileOutputStream:close	()V
    //   619: aload 7
    //   621: astore_1
    //   622: aload 7
    //   624: invokevirtual 272	java/io/InputStream:close	()V
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
    //   644: invokestatic 280	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;Ljava/io/File;)Z
    //   647: ifne +94 -> 741
    //   650: aload 9
    //   652: aload 11
    //   654: invokestatic 282	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
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
    //   685: invokevirtual 271	java/io/FileOutputStream:close	()V
    //   688: aload_1
    //   689: ifnull +7 -> 696
    //   692: aload_1
    //   693: invokevirtual 272	java/io/InputStream:close	()V
    //   696: return
    //   697: astore_2
    //   698: aload_2
    //   699: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   702: goto -14 -> 688
    //   705: astore_1
    //   706: aload_1
    //   707: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   710: return
    //   711: astore_2
    //   712: aload_2
    //   713: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   716: goto -125 -> 591
    //   719: astore_2
    //   720: aload_2
    //   721: invokevirtual 285	java/io/IOException:printStackTrace	()V
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
    //   111	407	12	localQZipFile	com.tencent.commonsdk.zip.QZipFile
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
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramMessageRecord, localIntent, paramString1);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
    }
    return true;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +49 -> 52
    //   6: ldc 158
    //   8: iconst_2
    //   9: new 160	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 359
    //   19: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 361
    //   29: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 363
    //   39: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_3
    //   43: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_2
    //   53: aload_3
    //   54: invokestatic 366	com/tencent/mobileqq/flashchat/FlashChatManager:a	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore_1
    //   58: aload_0
    //   59: invokevirtual 370	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   62: astore_2
    //   63: aload_2
    //   64: aload_1
    //   65: iconst_0
    //   66: aaload
    //   67: iconst_1
    //   68: invokevirtual 376	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   71: ifnull +172 -> 243
    //   74: aload_2
    //   75: aload_1
    //   76: iconst_0
    //   77: aaload
    //   78: invokevirtual 380	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   81: astore_2
    //   82: aload_2
    //   83: ifnonnull +5 -> 88
    //   86: iconst_0
    //   87: ireturn
    //   88: aload_2
    //   89: ldc_w 381
    //   92: invokevirtual 385	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   95: pop
    //   96: aload_1
    //   97: iconst_1
    //   98: aaload
    //   99: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +14 -> 116
    //   105: aload_2
    //   106: aload_1
    //   107: iconst_1
    //   108: aaload
    //   109: invokestatic 391	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   112: invokevirtual 395	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   115: pop
    //   116: aload 4
    //   118: getstatic 398	com/tencent/mobileqq/app/BusinessHandlerFactory:STARTAPPCHECK_HANDLER	Ljava/lang/String;
    //   121: invokevirtual 131	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   124: checkcast 400	com/tencent/mobileqq/app/StartAppCheckHandler
    //   127: astore_3
    //   128: aload_2
    //   129: ldc_w 402
    //   132: ldc_w 404
    //   135: invokevirtual 315	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   138: pop
    //   139: aload_2
    //   140: ldc_w 406
    //   143: ldc_w 341
    //   146: invokevirtual 315	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   149: pop
    //   150: aload_2
    //   151: ldc_w 408
    //   154: ldc_w 410
    //   157: invokevirtual 315	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   160: pop
    //   161: aload_2
    //   162: ldc_w 412
    //   165: ldc_w 414
    //   168: invokevirtual 315	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   171: pop
    //   172: aload_2
    //   173: ldc_w 416
    //   176: aload_0
    //   177: invokevirtual 420	java/lang/Object:getClass	()Ljava/lang/Class;
    //   180: invokevirtual 423	java/lang/Class:getName	()Ljava/lang/String;
    //   183: invokevirtual 315	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   186: pop
    //   187: aload_3
    //   188: aload_1
    //   189: iconst_0
    //   190: aaload
    //   191: invokevirtual 426	java/lang/String:trim	()Ljava/lang/String;
    //   194: aload_0
    //   195: aload_2
    //   196: invokevirtual 429	com/tencent/mobileqq/app/StartAppCheckHandler:b	(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V
    //   199: iconst_1
    //   200: ireturn
    //   201: astore_1
    //   202: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +13 -> 218
    //   208: ldc_w 431
    //   211: iconst_2
    //   212: ldc_w 433
    //   215: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_0
    //   219: aload_2
    //   220: invokevirtual 323	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   223: goto -24 -> 199
    //   226: astore_0
    //   227: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +13 -> 243
    //   233: ldc 158
    //   235: iconst_2
    //   236: aload_0
    //   237: invokevirtual 436	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   240: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: iconst_0
    //   244: ireturn
    //   245: astore_0
    //   246: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq -6 -> 243
    //   252: ldc 158
    //   254: iconst_2
    //   255: aload_0
    //   256: invokevirtual 437	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   259: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto -19 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramContext	Context
    //   0	265	1	paramString1	String
    //   0	265	2	paramString2	String
    //   0	265	3	paramString3	String
    //   0	265	4	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   116	199	201	java/lang/Exception
    //   63	82	226	android/content/pm/PackageManager$NameNotFoundException
    //   88	116	226	android/content/pm/PackageManager$NameNotFoundException
    //   116	199	226	android/content/pm/PackageManager$NameNotFoundException
    //   202	218	226	android/content/pm/PackageManager$NameNotFoundException
    //   218	223	226	android/content/pm/PackageManager$NameNotFoundException
    //   63	82	245	java/lang/RuntimeException
    //   88	116	245	java/lang/RuntimeException
    //   116	199	245	java/lang/RuntimeException
    //   202	218	245	java/lang/RuntimeException
    //   218	223	245	java/lang/RuntimeException
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
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      return str;
    }
    int k = paramString.length() - 1;
    int i = 0;
    while ((i <= k) && (paramString.charAt(i) == ' ')) {
      i += 1;
    }
    for (;;)
    {
      int j;
      if ((j >= i) && (paramString.charAt(j) == ' '))
      {
        j -= 1;
      }
      else
      {
        if (i == 0)
        {
          str = paramString;
          if (j == k) {
            break;
          }
        }
        if (i <= j) {
          return paramString.substring(i, j + 1);
        }
        return "";
        j = k;
      }
    }
  }
  
  public static String c(String paramString)
  {
    return paramString.substring(0, paramString.lastIndexOf("."));
  }
  
  public ArkFlashChatMessage a(String paramString, int paramInt1, int paramInt2)
  {
    ArkFlashChatMessage localArkFlashChatMessage = null;
    Object localObject3;
    if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
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
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 == null) {
          continue;
        }
        localObject3 = ((ArrayList)localObject1).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          continue;
        }
        localObject1 = (FlashChatItem)((Iterator)localObject3).next();
        if ((localObject1 == null) || (((FlashChatItem)localObject1).id != paramInt2)) {
          continue;
        }
        localObject3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FlashChatItem)localObject1);
        if (localObject3 != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        localException.printStackTrace();
        Object localObject2 = null;
        continue;
      }
      localObject3 = localArkFlashChatMessage;
      if (localObject1 == null) {
        break;
      }
      localArkFlashChatMessage = new ArkFlashChatMessage();
      localArkFlashChatMessage.appMinVersion = ((FlashChatItem)localObject1).ver;
      localArkFlashChatMessage.appName = ((FlashChatItem)localObject1).appName;
      localArkFlashChatMessage.appView = ((FlashChatItem)localObject1).mainView;
      localArkFlashChatMessage.appDesc = ((FlashChatItem)localObject1).name;
      localArkFlashChatMessage.appResId = ((FlashChatItem)localObject1).id;
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
    }
  }
  
  public String a()
  {
    int i;
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      localObject = BaseApplicationImpl.getContext();
      i = 0;
    }
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        localException.printStackTrace();
        continue;
        localObject = ((Context)localObject).getFilesDir().getAbsolutePath();
      }
    }
    localStringBuilder = new StringBuilder();
    if (i != 0)
    {
      localObject = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
      this.jdField_a_of_type_JavaLangString = ((String)localObject + File.separator + "flashchat" + File.separator);
      new File(this.jdField_a_of_type_JavaLangString).mkdirs();
      return this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject1 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject1 != null) {
      return localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "getAppPathByNameFromLocal " + paramInt + " path " + (String)localObject1 + " version" + paramString2 + " name" + paramString1);
    }
    localObject1 = FlashChatManager.FlashPackCfg.a(FileUtils.a(new File(a("flashchat." + paramInt + ".cfg"))));
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "getAppPathByNameFromLocal cfg not exist ...");
      }
      return null;
    }
    Object localObject2 = a() + c(((FlashChatManager.FlashPackCfg)localObject1).jdField_b_of_type_JavaLangString) + File.separator + paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "getAppPathByNameFromLocal installPath: " + (String)localObject2 + "cfg info : " + localObject1);
    }
    localObject1 = new File((String)localObject2);
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "getAppPathByNameFromLocal appDir not exist ...");
      }
      return null;
    }
    localObject2 = ((File)localObject1).listFiles();
    int i;
    if (localObject2 != null)
    {
      int j = localObject2.length;
      i = 0;
      label291:
      if (i < j)
      {
        localObject1 = localObject2[i];
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).getName().endsWith(".app")) || (!((File)localObject1).getName().contains(paramString2))) {}
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FlashChat", 2, "getAppPathByNameFromLocal appFile not exist ...");
        }
        return null;
        i += 1;
        break label291;
      }
      localObject2 = ((File)localObject1).getAbsolutePath();
      if (localObject2 != null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      }
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FlashChat", 2, "getAppPathByNameFromLocal " + paramInt + " path " + (String)localObject2 + " version" + paramString2 + " name" + paramString1);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public String a(String paramString)
  {
    return a() + paramString;
  }
  
  public ArrayList<FlashChatItem> a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "getItemList");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(FlashChatItem.sDefaultItem);
      return localArrayList;
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "initAndGetSwitch " + this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_a_of_type_JavaLangString + " u " + this.jdField_a_of_type_Boolean);
    }
    if ((jdField_b_of_type_AndroidUtilSparseArray == null) || (jdField_c_of_type_AndroidUtilSparseArray == null))
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
      jdField_b_of_type_AndroidUtilSparseArray = localSparseArray1;
      jdField_c_of_type_AndroidUtilSparseArray = localSparseArray2;
    }
    ((FlashChatHanlder)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FLASH_CHAT_HANDLER)).a();
  }
  
  public void a(int paramInt)
  {
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    String str = "flashchat." + paramInt + ".cfg";
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, String.valueOf(paramInt));
    localIVasQuickUpdateService.downloadItem(1002L, str, "initChatResource");
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
  
  public void a(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForArkFlashChat)) && (!paramChatMessage.isread)) {
      a((MessageForArkFlashChat)paramChatMessage);
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
    Object localObject = (CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clone();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)((Iterator)localObject).next();
        if ((paramLong == null) || (paramLong.longValue() != localMessageForArkFlashChat.uniseq))
        {
          String str = localMessageForArkFlashChat.ark_app_message.appName;
          ArkAppCenter.a().post(str, new FlashChatManager.2(this, localMessageForArkFlashChat));
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
  }
  
  public void a(String arg1, int paramInt)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "parseJson isMainThread scid " + ??? + " errCode " + paramInt);
    }
    if (??? != null)
    {
      if (!???.endsWith(".cfg")) {
        break label232;
      }
      str1 = (String)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(???);
      if (paramInt == 0) {}
    }
    else
    {
      try
      {
        i = Integer.valueOf(str1).intValue();
        paramInt = i;
      }
      catch (Exception ???)
      {
        for (;;)
        {
          QLog.e("FlashChat", 2, "onCompleteDownload" + paramInt, ???);
          paramInt = -1;
        }
      }
      ??? = new Bundle();
      ???.putInt("resourceId", paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 968, false, ???);
    }
    label232:
    while (!???.endsWith(".zip"))
    {
      do
      {
        return;
        ??? = FlashChatManager.FlashPackCfg.a(FileUtils.a(new File(a(???))));
      } while ((??? == null) || (???.jdField_b_of_type_JavaLangString == null) || (str1 == null));
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(???.jdField_b_of_type_JavaLangString, str1);
      ((IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1002L, ???.jdField_b_of_type_JavaLangString, "FlashChatManager");
      return;
    }
    Object localObject3 = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(???);
    if (paramInt != 0)
    {
      try
      {
        int j = Integer.valueOf((String)localObject3).intValue();
        paramInt = j;
      }
      catch (Exception ???)
      {
        for (;;)
        {
          QLog.e("FlashChat", 2, "onCompleteDownload" + paramInt, ???);
          paramInt = i;
        }
      }
      ??? = new Bundle();
      ???.putInt("resourceId", paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 968, false, ???);
      return;
    }
    String str1 = a(???);
    ??? = c(???);
    String str2 = a() + ??? + File.separator;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    synchronized (str2.intern())
    {
      localFile = new File(str2);
      try
      {
        a(str1, str2);
        paramInt = Integer.valueOf((String)localObject3).intValue();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("resourceId", paramInt);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 968, true, (Bundle)localObject3);
        new File(str1).delete();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          if (0 != 0) {
            throw new NullPointerException();
          }
          if (localFile != null) {
            localFile.delete();
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      return;
    }
  }
  
  public void a(ArrayList<FlashChatItem> paramArrayList, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlashChat", 2, "onGetFlashItems begin " + paramBoolean);
    }
    if (paramArrayList != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqConfigQStorage.a("FlashItems", paramArrayList);
      }
      paramArrayList.add(0, FlashChatItem.sDefaultItem);
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramArrayOfByte = (FlashChatItem)paramArrayList.next();
        if (QLog.isColorLevel()) {
          QLog.i("FlashChat", 2, "onGetFlashItems item = " + paramArrayOfByte);
        }
        if ((paramArrayOfByte.id != -100001) && (paramArrayOfByte.id != -100000)) {
          a(paramArrayOfByte.id, paramArrayOfByte.appName, paramArrayOfByte.ver);
        }
      }
    }
  }
  
  public boolean a()
  {
    b();
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "isSwitchUser g " + this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_a_of_type_JavaLangString + " u " + this.jdField_a_of_type_Boolean);
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt, MessageRecord paramMessageRecord)
  {
    SparseArray localSparseArray2 = jdField_b_of_type_AndroidUtilSparseArray;
    SparseArray localSparseArray1 = jdField_c_of_type_AndroidUtilSparseArray;
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
        jdField_b_of_type_AndroidUtilSparseArray = localSparseArray2;
        jdField_c_of_type_AndroidUtilSparseArray = localSparseArray1;
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
        i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.d;
        l1 = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_f_of_type_Int;
        l1 *= 1000L;
        break;
        i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.e;
        l1 = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_g_of_type_Int;
        l1 *= 1000L;
        break;
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (!RichTextChatManager.a(paramQQAppInterface).b(paramQQAppInterface)) {}
    do
    {
      return false;
      paramQQAppInterface = RichTextChatManager.a(paramQQAppInterface).a(paramQQAppInterface);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0));
    paramQQAppInterface = paramQQAppInterface.iterator();
    boolean bool = false;
    if (paramQQAppInterface.hasNext())
    {
      if (((Integer)paramQQAppInterface.next()).intValue() != 1) {
        break label72;
      }
      bool = true;
    }
    label72:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public boolean a(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat.uniseq == paramMessageForArkFlashChat.uniseq);
  }
  
  public String b()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public void b()
  {
    if (this.d) {}
    for (;;)
    {
      return;
      this.d = true;
      Object localObject1 = (FlashChatConfBean)QConfigManager.a().a(168);
      if (localObject1 == null)
      {
        localObject1 = "";
        b((String)localObject1);
      }
      try
      {
        localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqConfigQStorage.a("FlashItems", ArrayList.class, 0);
        a((ArrayList)localObject1, false, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("loadFromCacheOnce ");
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
          QLog.i("FlashChat", 2, localObject1);
          return;
          localObject1 = ((FlashChatConfBean)localObject1).jdField_a_of_type_JavaLangString;
        }
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        for (;;)
        {
          QLog.i("FlashChat", 1, "loadFromCacheOnce", localQStorageInstantiateException);
          Object localObject2 = null;
        }
      }
      catch (QStorageSafeDeleteException localQStorageSafeDeleteException)
      {
        for (;;)
        {
          QLog.i("FlashChat", 1, "loadFromCacheOnce", localQStorageSafeDeleteException);
          String str = null;
          continue;
          str = "null";
        }
      }
    }
  }
  
  public void b(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    if ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForArkFlashChat.uniseq)) == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForArkFlashChat.uniseq), Long.valueOf(System.currentTimeMillis()));
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramMessageForArkFlashChat);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlashChat", 2, "loadConfig l :" + paramString);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig = ((FlashChatManager.GlobalConfig)QStorage.a(paramString, FlashChatManager.GlobalConfig.class));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 969, true, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 970, true, null);
      return;
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("FlashChat", 1, "loadConfig l :" + paramString, localQStorageInstantiateException);
      }
    }
  }
  
  public boolean b()
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
  
  public boolean b(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    paramMessageForArkFlashChat = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForArkFlashChat.uniseq));
    return (paramMessageForArkFlashChat != null) && (System.currentTimeMillis() - paramMessageForArkFlashChat.longValue() < 600L);
  }
  
  public String c()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    if (localGlobalConfig != null) {
      return localGlobalConfig.i;
    }
    return "";
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "requestAIOFlashItems");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), FlashChatServlet.class);
    localNewIntent.putExtra("req_type", 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean c()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    if (localGlobalConfig != null) {
      return localGlobalConfig.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean c(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((MessageForArkFlashChat)localIterator.next()).uniseq == paramMessageForArkFlashChat.uniseq) {
        return true;
      }
    }
    return false;
  }
  
  public boolean d()
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
    SparseArray localSparseArray1 = jdField_b_of_type_AndroidUtilSparseArray;
    SparseArray localSparseArray2 = jdField_c_of_type_AndroidUtilSparseArray;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager
 * JD-Core Version:    0.7.0.1
 */