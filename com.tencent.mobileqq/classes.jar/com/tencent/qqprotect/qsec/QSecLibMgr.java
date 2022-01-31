package com.tencent.qqprotect.qsec;

import alib;
import alic;
import alid;
import alif;
import alig;
import alih;
import alii;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.qqprotect.common.QSecRptController;
import com.tencent.qqprotect.common.QSecRptHelper;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class QSecLibMgr
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QSecCbMgr jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr;
  private QSecDatabaseMgr jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr;
  private List jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 1, 2, 3 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "libhobi.so" };
  private boolean jdField_b_of_type_Boolean;
  private final String[] jdField_b_of_type_ArrayOfJavaLangString = { "2.0.2" };
  
  public QSecLibMgr(QSecCbMgr paramQSecCbMgr)
  {
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr = paramQSecCbMgr;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr = new QSecDatabaseMgr();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new alig(this, QSecFramework.a().getLooper());
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(new alib(this));
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      if (paramInt == this.jdField_a_of_type_ArrayOfInt[(i + 1)]) {
        return i / 4;
      }
      i += 4;
    }
    return -1;
  }
  
  private alif a(QSecDatabaseMgr.LibEntry paramLibEntry)
  {
    alif localalif = new alif(null);
    localalif.jdField_a_of_type_Int = paramLibEntry.jdField_a_of_type_Int;
    localalif.jdField_b_of_type_Int = paramLibEntry.jdField_b_of_type_Int;
    localalif.c = paramLibEntry.c;
    localalif.jdField_b_of_type_JavaLangString = paramLibEntry.jdField_b_of_type_JavaLangString;
    localalif.jdField_a_of_type_JavaLangString = paramLibEntry.jdField_a_of_type_JavaLangString;
    localalif.e = 4;
    return localalif;
  }
  
  private String a()
  {
    return BaseApplication.getContext().getFilesDir().getParent().toString() + File.separator + "lib";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      QSecLibMgr.LibEventListener localLibEventListener = (QSecLibMgr.LibEventListener)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Notify listener [%d:%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      localLibEventListener.a(paramInt1, paramInt2);
    }
  }
  
  private void a(alif paramalif)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QSec", 2, String.format("Prepare to unload: %d,%d,%d,%d,%s,%s", new Object[] { Integer.valueOf(paramalif.jdField_a_of_type_Int), Integer.valueOf(paramalif.jdField_b_of_type_Int), Integer.valueOf(paramalif.c), Integer.valueOf(paramalif.e), paramalif.jdField_a_of_type_JavaLangString, paramalif.jdField_b_of_type_JavaLangString }));
    }
    if ((paramalif.c & 0x1) == 0) {}
    while (paramalif.e != 1) {
      return;
    }
    paramalif.e = 3;
    paramalif.jdField_a_of_type_ComTencentQqprotectQsecRundownProtection.b();
    int i = QSecFramework.a(3, paramalif.jdField_a_of_type_Int, 0, 0, null, null, null, null);
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QSec", 2, new Object[] { "Unload ret: %d", Integer.valueOf(i) });
    }
    if (i == 0)
    {
      paramalif.e = 4;
      a(2, paramalif.jdField_a_of_type_Int);
      return;
    }
    paramalif.e = 5;
    paramalif.d = i;
  }
  
  private void a(alif paramalif, String paramString1, String paramString2)
  {
    a(paramalif);
    if (paramalif.e == 4)
    {
      if ((paramalif.jdField_b_of_type_JavaLangString != null) && (!paramalif.jdField_b_of_type_JavaLangString.equals(paramString2)))
      {
        FileUtils.delete(paramalif.jdField_b_of_type_JavaLangString);
        paramalif.jdField_b_of_type_JavaLangString = paramString2;
      }
      if ((paramalif.jdField_a_of_type_JavaLangString != null) && (!paramalif.jdField_a_of_type_JavaLangString.equals(paramString1))) {
        paramalif.jdField_a_of_type_JavaLangString = paramString1;
      }
      paramalif.f = 0;
      c(paramalif);
      d(paramalif);
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (Pair)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("cb changed: id(%d), cb(%d)", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second }));
      }
      Object localObject2 = (alif)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Pair)localObject1).first);
      if (localObject2 == null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(((Integer)((Pair)localObject1).first).intValue());
        if (localObject2 != null) {
          if (((Byte)((Pair)localObject1).second).byteValue() == 1) {
            e(a((QSecDatabaseMgr.LibEntry)localObject2));
          } else if (((Byte)((Pair)localObject1).second).byteValue() == 2) {
            localLinkedList.add(localObject2);
          }
        }
      }
      else if (((Byte)((Pair)localObject1).second).byteValue() == 1)
      {
        if (((alif)localObject2).e == 4)
        {
          c((alif)localObject2);
          if (((alif)localObject2).d != 0) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(((alif)localObject2).jdField_a_of_type_Int));
          }
          d((alif)localObject2);
        }
      }
      else if ((((Byte)((Pair)localObject1).second).byteValue() == 2) && (((alif)localObject2).e == 4))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((Pair)localObject1).first);
        localObject1 = this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(((Integer)((Pair)localObject1).first).intValue());
        if (localObject1 != null) {
          localLinkedList.add(localObject1);
        }
      }
    }
    if (!localLinkedList.isEmpty()) {
      b(localLinkedList);
    }
    e();
  }
  
  private void b(alif paramalif)
  {
    QSecRptHelper localQSecRptHelper = new QSecRptHelper();
    localQSecRptHelper.a(paramalif.jdField_a_of_type_Int).a(paramalif.jdField_a_of_type_JavaLangString).a(paramalif.d);
    QSecRptController.b(localQSecRptHelper.toString(), 104);
  }
  
  private void b(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QSecDatabaseMgr.LibEntry localLibEntry = (QSecDatabaseMgr.LibEntry)paramList.next();
      this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(localLibEntry.jdField_a_of_type_Int, false);
      if (localLibEntry.jdField_b_of_type_JavaLangString != null)
      {
        int i = a(localLibEntry.jdField_a_of_type_Int);
        if (i != -1)
        {
          String str = a() + File.separator + this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]];
          if (localLibEntry.jdField_b_of_type_JavaLangString.equals(str)) {}
        }
        else
        {
          FileUtils.delete(localLibEntry.jdField_b_of_type_JavaLangString);
        }
      }
    }
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a();
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    new alih(new alid(this)).a(1);
  }
  
  private void c(alif paramalif)
  {
    paramalif.e = 2;
    Object localObject = new alic(this);
    ((alic)localObject).a = paramalif;
    new CrashProtector(String.format("Lib%d_%s", new Object[] { Integer.valueOf(paramalif.jdField_a_of_type_Int), paramalif.jdField_a_of_type_JavaLangString }), 43200000L).a((CrashProtector.IProtectedMethod)localObject);
    if (QLog.isColorLevel())
    {
      if (paramalif.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "null";
        QLog.d("QQProtect.QSec", 2, String.format("load: %s ver: %s error: %08X", new Object[] { localObject, QPMiscUtils.a(paramalif.f), Integer.valueOf(paramalif.d) }));
      }
    }
    else {
      if (paramalif.d != 0) {
        break label140;
      }
    }
    label140:
    for (int i = 1;; i = 4)
    {
      paramalif.e = i;
      return;
      localObject = paramalif.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  private void c(QSecLibMgr.LibEventListener paramLibEventListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((alif)localEntry.getValue()).e == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("Notify listener [%d:%d]", new Object[] { Integer.valueOf(1), localEntry.getKey() }));
        }
        paramLibEventListener.a(1, ((Integer)localEntry.getKey()).intValue());
      }
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: invokestatic 129	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: ldc_w 387
    //   6: iconst_0
    //   7: invokevirtual 391	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: astore 11
    //   12: aload 11
    //   14: invokeinterface 397 1 0
    //   19: astore 10
    //   21: ldc2_w 398
    //   24: lstore_3
    //   25: lload_3
    //   26: lstore 5
    //   28: getstatic 405	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   31: aconst_null
    //   32: invokevirtual 409	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   35: checkcast 411	com/tencent/mobileqq/app/QQAppInterface
    //   38: astore 9
    //   40: aload 9
    //   42: ifnull +496 -> 538
    //   45: lload_3
    //   46: lstore 5
    //   48: aload 9
    //   50: invokevirtual 414	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   53: astore 12
    //   55: aload 12
    //   57: ifnull +481 -> 538
    //   60: lload_3
    //   61: lstore 5
    //   63: aload 9
    //   65: invokevirtual 414	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   68: invokestatic 418	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   71: istore_1
    //   72: lload_3
    //   73: lstore 5
    //   75: aload_0
    //   76: getfield 44	com/tencent/qqprotect/qsec/QSecLibMgr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   79: invokeinterface 256 1 0
    //   84: astore 12
    //   86: lload_3
    //   87: lstore 5
    //   89: aload 12
    //   91: invokeinterface 163 1 0
    //   96: ifeq +436 -> 532
    //   99: lload_3
    //   100: lstore 5
    //   102: aload 12
    //   104: invokeinterface 167 1 0
    //   109: checkcast 87	alif
    //   112: astore 13
    //   114: lload_3
    //   115: lstore 5
    //   117: aload 13
    //   119: getfield 110	alif:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: astore 9
    //   124: lload_3
    //   125: lstore 5
    //   127: aload 13
    //   129: getfield 231	alif:f	I
    //   132: ifeq +16 -> 148
    //   135: lload_3
    //   136: lstore 5
    //   138: aload 13
    //   140: getfield 231	alif:f	I
    //   143: invokestatic 364	com/tencent/qqprotect/common/QPMiscUtils:a	(I)Ljava/lang/String;
    //   146: astore 9
    //   148: iload_1
    //   149: ldc_w 419
    //   152: ixor
    //   153: istore_2
    //   154: lload_3
    //   155: lstore 5
    //   157: ldc_w 421
    //   160: iconst_3
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload 13
    //   168: getfield 96	alif:jdField_a_of_type_Int	I
    //   171: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: iload_2
    //   178: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: aastore
    //   182: dup
    //   183: iconst_2
    //   184: aload 9
    //   186: aastore
    //   187: invokestatic 188	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   190: astore 14
    //   192: lload_3
    //   193: lstore 5
    //   195: ldc_w 423
    //   198: iconst_3
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload 13
    //   206: getfield 96	alif:jdField_a_of_type_Int	I
    //   209: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload_2
    //   216: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: aload 9
    //   224: aastore
    //   225: invokestatic 188	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   228: astore 15
    //   230: lload_3
    //   231: lstore 5
    //   233: aload 11
    //   235: aload 14
    //   237: iconst_m1
    //   238: invokeinterface 427 3 0
    //   243: istore_1
    //   244: lload_3
    //   245: lstore 5
    //   247: aload 11
    //   249: aload 15
    //   251: lconst_0
    //   252: invokeinterface 431 4 0
    //   257: lstore 7
    //   259: lload_3
    //   260: lstore 5
    //   262: new 433	java/util/Date
    //   265: dup
    //   266: invokespecial 434	java/util/Date:<init>	()V
    //   269: invokevirtual 438	java/util/Date:getTime	()J
    //   272: lload 7
    //   274: lsub
    //   275: lstore 7
    //   277: lload 7
    //   279: ldc2_w 398
    //   282: lcmp
    //   283: ifge +73 -> 356
    //   286: lload_3
    //   287: lstore 5
    //   289: aload 13
    //   291: getfield 215	alif:d	I
    //   294: iload_1
    //   295: if_icmpne +61 -> 356
    //   298: lload_3
    //   299: lstore 5
    //   301: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +239 -> 543
    //   307: lload_3
    //   308: lstore 5
    //   310: ldc 176
    //   312: iconst_2
    //   313: ldc_w 440
    //   316: iconst_3
    //   317: anewarray 4	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload 13
    //   324: getfield 96	alif:jdField_a_of_type_Int	I
    //   327: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: aastore
    //   331: dup
    //   332: iconst_1
    //   333: aload 13
    //   335: getfield 215	alif:d	I
    //   338: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: aastore
    //   342: dup
    //   343: iconst_2
    //   344: aload 9
    //   346: aastore
    //   347: invokestatic 188	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   350: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: goto +190 -> 543
    //   356: lload_3
    //   357: lstore 5
    //   359: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +49 -> 411
    //   365: lload_3
    //   366: lstore 5
    //   368: ldc 176
    //   370: iconst_2
    //   371: ldc_w 442
    //   374: iconst_3
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload 13
    //   382: getfield 96	alif:jdField_a_of_type_Int	I
    //   385: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: aload 13
    //   393: getfield 215	alif:d	I
    //   396: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   399: aastore
    //   400: dup
    //   401: iconst_2
    //   402: aload 9
    //   404: aastore
    //   405: invokestatic 188	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   408: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: lload_3
    //   412: lstore 5
    //   414: aload 10
    //   416: aload 14
    //   418: aload 13
    //   420: getfield 215	alif:d	I
    //   423: invokeinterface 448 3 0
    //   428: pop
    //   429: lload_3
    //   430: lstore 5
    //   432: aload 10
    //   434: aload 15
    //   436: new 433	java/util/Date
    //   439: dup
    //   440: invokespecial 434	java/util/Date:<init>	()V
    //   443: invokevirtual 438	java/util/Date:getTime	()J
    //   446: invokeinterface 452 4 0
    //   451: pop
    //   452: lload_3
    //   453: lstore 5
    //   455: aload_0
    //   456: aload 13
    //   458: invokespecial 454	com/tencent/qqprotect/qsec/QSecLibMgr:b	(Lalif;)V
    //   461: iload_2
    //   462: istore_1
    //   463: goto -377 -> 86
    //   466: astore 9
    //   468: aload 9
    //   470: invokevirtual 457	java/lang/Exception:printStackTrace	()V
    //   473: aload 10
    //   475: invokeinterface 460 1 0
    //   480: pop
    //   481: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +30 -> 514
    //   487: ldc 176
    //   489: iconst_2
    //   490: new 122	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 462
    //   500: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: lload 5
    //   505: invokevirtual 465	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   508: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: invokestatic 468	com/tencent/qqprotect/qsec/QSecFramework:a	()Landroid/os/Handler;
    //   517: new 470	alie
    //   520: dup
    //   521: aload_0
    //   522: invokespecial 471	alie:<init>	(Lcom/tencent/qqprotect/qsec/QSecLibMgr;)V
    //   525: lload 5
    //   527: invokevirtual 477	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   530: pop
    //   531: return
    //   532: lload_3
    //   533: lstore 5
    //   535: goto -62 -> 473
    //   538: iconst_0
    //   539: istore_1
    //   540: goto -468 -> 72
    //   543: iload_2
    //   544: istore_1
    //   545: lload_3
    //   546: ldc2_w 398
    //   549: lload 7
    //   551: lsub
    //   552: lcmp
    //   553: ifle -467 -> 86
    //   556: ldc2_w 398
    //   559: lload 7
    //   561: lsub
    //   562: lstore_3
    //   563: iload_2
    //   564: istore_1
    //   565: goto -479 -> 86
    //   568: astore 9
    //   570: iconst_0
    //   571: istore_1
    //   572: goto -500 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	QSecLibMgr
    //   71	501	1	i	int
    //   153	411	2	j	int
    //   24	539	3	l1	long
    //   26	508	5	l2	long
    //   257	303	7	l3	long
    //   38	365	9	localObject1	Object
    //   466	3	9	localException	java.lang.Exception
    //   568	1	9	localNumberFormatException	java.lang.NumberFormatException
    //   19	455	10	localEditor	android.content.SharedPreferences.Editor
    //   10	238	11	localSharedPreferences	android.content.SharedPreferences
    //   53	50	12	localObject2	Object
    //   112	345	13	localalif	alif
    //   190	227	14	str1	String
    //   228	207	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   28	40	466	java/lang/Exception
    //   48	55	466	java/lang/Exception
    //   63	72	466	java/lang/Exception
    //   75	86	466	java/lang/Exception
    //   89	99	466	java/lang/Exception
    //   102	114	466	java/lang/Exception
    //   117	124	466	java/lang/Exception
    //   127	135	466	java/lang/Exception
    //   138	148	466	java/lang/Exception
    //   157	192	466	java/lang/Exception
    //   195	230	466	java/lang/Exception
    //   233	244	466	java/lang/Exception
    //   247	259	466	java/lang/Exception
    //   262	277	466	java/lang/Exception
    //   289	298	466	java/lang/Exception
    //   301	307	466	java/lang/Exception
    //   310	353	466	java/lang/Exception
    //   359	365	466	java/lang/Exception
    //   368	411	466	java/lang/Exception
    //   414	429	466	java/lang/Exception
    //   432	452	466	java/lang/Exception
    //   455	461	466	java/lang/Exception
    //   63	72	568	java/lang/NumberFormatException
  }
  
  private void d(alif paramalif)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramalif);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4));
  }
  
  private void e(alif paramalif)
  {
    c(paramalif);
    if (paramalif.d == 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramalif.jdField_a_of_type_Int), paramalif);
      a(1, paramalif.jdField_a_of_type_Int);
    }
    d(paramalif);
  }
  
  private void f()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a();
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (QSecDatabaseMgr.LibEntry)localIterator.next();
      byte b1 = this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(((QSecDatabaseMgr.LibEntry)localObject2).jdField_a_of_type_Int);
      int i;
      int j;
      int k;
      String str;
      if (QLog.isColorLevel())
      {
        i = ((QSecDatabaseMgr.LibEntry)localObject2).jdField_a_of_type_Int;
        j = ((QSecDatabaseMgr.LibEntry)localObject2).jdField_b_of_type_Int;
        k = ((QSecDatabaseMgr.LibEntry)localObject2).c;
        str = ((QSecDatabaseMgr.LibEntry)localObject2).jdField_a_of_type_JavaLangString;
        if (((QSecDatabaseMgr.LibEntry)localObject2).jdField_b_of_type_JavaLangString != null) {
          break label201;
        }
      }
      label201:
      for (localObject1 = "null";; localObject1 = ((QSecDatabaseMgr.LibEntry)localObject2).jdField_b_of_type_JavaLangString)
      {
        QLog.d("QQProtect.QSec", 2, String.format("%d,%d,%d,%s,%s,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, localObject1, Byte.valueOf(b1) }));
        if (b1 == 0) {
          break;
        }
        if (2 != b1) {
          break label211;
        }
        localLinkedList.add(localObject2);
        break;
      }
      label211:
      if (1 == b1)
      {
        localObject1 = a((QSecDatabaseMgr.LibEntry)localObject2);
        e((alif)localObject1);
        if (((alif)localObject1).d != 0)
        {
          i = a(((alif)localObject1).jdField_a_of_type_Int);
          if (i != -1)
          {
            localObject2 = a() + File.separator + this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]];
            if ((((alif)localObject1).jdField_b_of_type_JavaLangString == null) || (!((String)localObject2).equals(((alif)localObject1).jdField_b_of_type_JavaLangString)))
            {
              ((alif)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject2);
              ((alif)localObject1).jdField_b_of_type_Int = this.jdField_a_of_type_ArrayOfInt[(i + 2)];
              ((alif)localObject1).c = this.jdField_a_of_type_ArrayOfInt[(i + 3)];
              ((alif)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]];
              ((alif)localObject1).f = 0;
              e((alif)localObject1);
            }
          }
        }
      }
      else if (-1 == b1)
      {
        i = a(((QSecDatabaseMgr.LibEntry)localObject2).jdField_a_of_type_Int);
        if (i != -1)
        {
          localObject1 = a((QSecDatabaseMgr.LibEntry)localObject2);
          ((alif)localObject1).jdField_b_of_type_JavaLangString = (a() + File.separator + this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]]);
          e((alif)localObject1);
        }
      }
    }
    if (!localLinkedList.isEmpty()) {
      b(localLinkedList);
    }
    e();
  }
  
  private void g()
  {
    new alih(new alii(this, null)).a(1);
  }
  
  private void h()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      int k = this.jdField_a_of_type_ArrayOfInt[(i + 1)];
      if (this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(k) == null)
      {
        QSecDatabaseMgr.LibEntry localLibEntry = new QSecDatabaseMgr.LibEntry();
        localLibEntry.jdField_a_of_type_Int = k;
        localLibEntry.jdField_b_of_type_Int = this.jdField_a_of_type_ArrayOfInt[(i + 2)];
        localLibEntry.c = this.jdField_a_of_type_ArrayOfInt[(i + 3)];
        localLibEntry.jdField_b_of_type_JavaLangString = (a() + File.separator + this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]]);
        localLibEntry.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ArrayOfInt[i]];
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("Add buildin: %d,%d,%d,%s", new Object[] { Integer.valueOf(localLibEntry.jdField_a_of_type_Int), Integer.valueOf(localLibEntry.jdField_b_of_type_Int), Integer.valueOf(localLibEntry.c), localLibEntry.jdField_b_of_type_JavaLangString }));
        }
        this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(localLibEntry, false);
        j = 1;
      }
      i += 4;
    }
    if (j != 0) {
      this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      h();
      g();
      f();
    } while (!this.jdField_b_of_type_Boolean);
    a();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    alif localalif = (alif)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
    if (localalif == null) {
      if (this.jdField_a_of_type_ComTencentQqprotectQsecQSecDatabaseMgr.a(paramInt1) == null) {
        paramInt2 = 4;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("dispatch to id: %d, cmd: %d, err: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) }));
      }
      return paramInt2;
      paramInt2 = 17;
      continue;
      if ((paramInt2 != 0) && (paramInt2 != localalif.f))
      {
        paramInt2 = 32;
      }
      else if (localalif.jdField_a_of_type_Int != paramInt1)
      {
        paramInt2 = 5;
      }
      else
      {
        int i = this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(paramInt1);
        if ((1 != i) && ((i != -1) || (a(paramInt1) == -1)))
        {
          paramInt2 = 6;
        }
        else if (localalif.e != 1)
        {
          paramInt2 = 7;
        }
        else if (!localalif.jdField_a_of_type_ComTencentQqprotectQsecRundownProtection.a())
        {
          paramInt2 = 7;
        }
        else
        {
          paramInt2 = QSecFramework.a(4, localalif.jdField_a_of_type_Int, paramInt2, paramInt3, null, null, paramArrayOfObject1, paramArrayOfObject2);
          localalif.jdField_a_of_type_ComTencentQqprotectQsecRundownProtection.a();
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1));
  }
  
  public void a(QSecLibMgr.LibEventListener paramLibEventListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramLibEventListener);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, paramLibEventListener));
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3));
    }
  }
  
  public void b(QSecLibMgr.LibEventListener paramLibEventListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramLibEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr
 * JD-Core Version:    0.7.0.1
 */