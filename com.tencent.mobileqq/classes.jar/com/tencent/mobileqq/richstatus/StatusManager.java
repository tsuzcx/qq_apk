package com.tencent.mobileqq.richstatus;

import PersonalState.UserProfile;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import protocol.KQQConfig.GetResourceReqInfo;

public class StatusManager
  implements BitmapDecoder.IBitmapListener, Manager
{
  private static volatile WeakReference<StatusManager> jdField_a_of_type_JavaLangRefWeakReference;
  private static Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[2];
  private long jdField_a_of_type_Long;
  private volatile AsyncTask<Void, Integer, Integer> jdField_a_of_type_AndroidOsAsyncTask;
  private volatile SparseArray<ActionInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SignatureObserver jdField_a_of_type_ComTencentMobileqqAppSignatureObserver;
  private BitmapDecoder jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private StatusObserver jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver;
  private ArrayList<StateTag> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, UserProfile> jdField_a_of_type_JavaUtilHashMap;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private LinkedList<IIconListener> jdField_a_of_type_JavaUtilLinkedList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long jdField_b_of_type_Long;
  private AsyncTask<Void, Void, ArrayList<UserProfile>> jdField_b_of_type_AndroidOsAsyncTask;
  private ArrayList<UserProfile> jdField_b_of_type_JavaUtilArrayList;
  private LinkedList<IActionListener> jdField_b_of_type_JavaUtilLinkedList;
  private long jdField_c_of_type_Long;
  private ArrayList<UserProfile> jdField_c_of_type_JavaUtilArrayList;
  private LinkedList<IImageListener> jdField_c_of_type_JavaUtilLinkedList;
  private long jdField_d_of_type_Long;
  private LinkedList<IStatusListener> jdField_d_of_type_JavaUtilLinkedList;
  private LinkedList<ISameStatusListener> e;
  
  private StatusManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_c_of_type_Long = a().getLong("k_update_time", 0L);
  }
  
  private int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Local");
    }
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      return 100;
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new StatusManager.1(this).execute(new Void[0]);
    return 100;
  }
  
  private SharedPreferences a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("rich_status", 0);
  }
  
  public static StatusManager a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != paramQQAppInterface) {
      return (StatusManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.STATUS_MANAGER);
    }
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {
      localObject1 = (StatusManager)jdField_a_of_type_JavaLangRefWeakReference.get();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      paramQQAppInterface = new StatusManager(paramQQAppInterface);
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
      return paramQQAppInterface;
    }
    ((StatusManager)localObject1).jdField_a_of_type_JavaUtilHashSet.clear();
    ((StatusManager)localObject1).jdField_b_of_type_Long = 0L;
    ((StatusManager)localObject1).jdField_a_of_type_Long = 0L;
    ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    Object localObject2 = ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqAppConfigObserver;
    if (localObject2 != null)
    {
      ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((com.tencent.mobileqq.app.BusinessObserver)localObject2);
      ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqAppConfigObserver = null;
    }
    localObject2 = ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver;
    if (localObject2 != null)
    {
      ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver((mqq.observer.BusinessObserver)localObject2);
      ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = null;
    }
    localObject2 = ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder;
    if (localObject2 != null) {
      ((BitmapDecoder)localObject2).a();
    }
    localObject2 = ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqAppSignatureObserver;
    if (localObject2 != null)
    {
      ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((com.tencent.mobileqq.app.BusinessObserver)localObject2);
      ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = null;
    }
    ((StatusManager)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    return localObject1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new StatusManager.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  private boolean a(SparseArray<ActionInfo> paramSparseArray1, SparseArray<ActionInfo> paramSparseArray2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("removeOldIcons(");
      ((StringBuilder)localObject1).append(paramSparseArray1);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramSparseArray2);
      ((StringBuilder)localObject1).append(")");
      QLog.d("Q.richstatus.xml", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = BitmapDecoder.a();
    int j = 0;
    int i = 0;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir is null");
      }
      return false;
    }
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir does not exist!");
      }
      return true;
    }
    if (!((File)localObject1).canWrite())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir can not write!");
      }
      return false;
    }
    if (paramSparseArray1 == null)
    {
      paramSparseArray1 = ((File)localObject1).listFiles();
      j = paramSparseArray1.length;
      while (i < j)
      {
        paramSparseArray2 = paramSparseArray1[i];
        if ((paramSparseArray2 != null) && (paramSparseArray2.exists()) && (!paramSparseArray2.delete()) && (!paramSparseArray2.delete())) {
          paramSparseArray2.delete();
        }
        i += 1;
      }
      bool = ((File)localObject1).canWrite();
      if (QLog.isColorLevel())
      {
        paramSparseArray1 = new StringBuilder();
        paramSparseArray1.append("removeOldIcons return with ");
        paramSparseArray1.append(bool);
        QLog.d("Q.richstatus.xml", 2, paramSparseArray1.toString());
      }
      return bool;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramSparseArray2.size();
    i = j;
    while (i < k)
    {
      Object localObject2 = (ActionInfo)paramSparseArray2.valueAt(i);
      ActionInfo localActionInfo = (ActionInfo)paramSparseArray1.get(((ActionInfo)localObject2).jdField_a_of_type_Int);
      if ((localActionInfo != null) && (localActionInfo.jdField_a_of_type_JavaLangString != null) && (!localActionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(((ActionInfo)localObject2).jdField_a_of_type_JavaLangString)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localActionInfo.jdField_a_of_type_Int);
        localStringBuilder.append("_s_");
        localStringBuilder.append(201);
        localArrayList.add(localStringBuilder.toString());
      }
      if ((localActionInfo != null) && (localActionInfo.b != null) && (!localActionInfo.b.equalsIgnoreCase(((ActionInfo)localObject2).b)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localActionInfo.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append("_s_");
        ((StringBuilder)localObject2).append(200);
        localArrayList.add(((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
    paramSparseArray1 = localArrayList.iterator();
    while (paramSparseArray1.hasNext())
    {
      paramSparseArray2 = new File((File)localObject1, (String)paramSparseArray1.next());
      if ((paramSparseArray2.exists()) && (!paramSparseArray2.delete()) && (!paramSparseArray2.delete())) {
        paramSparseArray2.delete();
      }
    }
    boolean bool = ((File)localObject1).canWrite();
    if (QLog.isColorLevel())
    {
      paramSparseArray1 = new StringBuilder();
      paramSparseArray1.append("removeOldIcons return with ");
      paramSparseArray1.append(bool);
      QLog.d("Q.richstatus.xml", 2, paramSparseArray1.toString());
    }
    return bool;
  }
  
  /* Error */
  private Object[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +47 -> 50
    //   6: new 224	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc_w 340
    //   20: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: ldc 238
    //   35: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 90
    //   41: iconst_2
    //   42: aload 4
    //   44: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: iconst_2
    //   51: anewarray 4	java/lang/Object
    //   54: astore 4
    //   56: aload_1
    //   57: ifnonnull +6 -> 63
    //   60: aload 4
    //   62: areturn
    //   63: new 342	com/tencent/mobileqq/richstatus/StatusXmlHandler
    //   66: dup
    //   67: invokespecial 343	com/tencent/mobileqq/richstatus/StatusXmlHandler:<init>	()V
    //   70: astore 6
    //   72: invokestatic 349	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   75: invokevirtual 353	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   78: aload_1
    //   79: aload 6
    //   81: invokevirtual 359	javax/xml/parsers/SAXParser:parse	(Ljava/io/InputStream;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   84: aload 6
    //   86: invokevirtual 362	com/tencent/mobileqq/richstatus/StatusXmlHandler:a	()Landroid/util/SparseArray;
    //   89: astore 5
    //   91: aload 6
    //   93: invokevirtual 365	com/tencent/mobileqq/richstatus/StatusXmlHandler:a	()Ljava/util/ArrayList;
    //   96: astore 6
    //   98: aload 5
    //   100: invokevirtual 274	android/util/SparseArray:size	()I
    //   103: iconst_1
    //   104: if_icmple +9 -> 113
    //   107: aload 4
    //   109: iconst_0
    //   110: aload 5
    //   112: aastore
    //   113: aload 6
    //   115: invokevirtual 366	java/util/ArrayList:size	()I
    //   118: ifle +9 -> 127
    //   121: aload 4
    //   123: iconst_1
    //   124: aload 6
    //   126: aastore
    //   127: aload_1
    //   128: invokevirtual 371	java/io/InputStream:close	()V
    //   131: goto +55 -> 186
    //   134: astore 4
    //   136: goto +154 -> 290
    //   139: astore 5
    //   141: aload 5
    //   143: invokevirtual 374	java/io/IOException:printStackTrace	()V
    //   146: aload_1
    //   147: invokevirtual 371	java/io/InputStream:close	()V
    //   150: goto +36 -> 186
    //   153: astore 5
    //   155: aload 5
    //   157: invokevirtual 375	org/xml/sax/SAXException:printStackTrace	()V
    //   160: aload_1
    //   161: invokevirtual 371	java/io/InputStream:close	()V
    //   164: goto +22 -> 186
    //   167: astore 5
    //   169: aload 5
    //   171: invokevirtual 376	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   174: aload_1
    //   175: invokevirtual 371	java/io/InputStream:close	()V
    //   178: goto +8 -> 186
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 374	java/io/IOException:printStackTrace	()V
    //   186: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +98 -> 287
    //   192: new 224	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   199: astore_1
    //   200: aload_1
    //   201: ldc_w 378
    //   204: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 4
    //   210: iconst_0
    //   211: aaload
    //   212: astore 5
    //   214: iconst_m1
    //   215: istore_3
    //   216: aload 5
    //   218: ifnull +17 -> 235
    //   221: aload 4
    //   223: iconst_0
    //   224: aaload
    //   225: checkcast 53	android/util/SparseArray
    //   228: invokevirtual 274	android/util/SparseArray:size	()I
    //   231: istore_2
    //   232: goto +5 -> 237
    //   235: iconst_m1
    //   236: istore_2
    //   237: aload_1
    //   238: iload_2
    //   239: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_1
    //   244: ldc_w 380
    //   247: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: iload_3
    //   252: istore_2
    //   253: aload 4
    //   255: iconst_1
    //   256: aaload
    //   257: ifnull +14 -> 271
    //   260: aload 4
    //   262: iconst_1
    //   263: aaload
    //   264: checkcast 58	java/util/ArrayList
    //   267: invokevirtual 366	java/util/ArrayList:size	()I
    //   270: istore_2
    //   271: aload_1
    //   272: iload_2
    //   273: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: ldc 90
    //   279: iconst_2
    //   280: aload_1
    //   281: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 4
    //   289: areturn
    //   290: aload_1
    //   291: invokevirtual 371	java/io/InputStream:close	()V
    //   294: goto +8 -> 302
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 374	java/io/IOException:printStackTrace	()V
    //   302: aload 4
    //   304: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	StatusManager
    //   0	305	1	paramInputStream	java.io.InputStream
    //   231	42	2	i	int
    //   215	37	3	j	int
    //   13	109	4	localObject1	Object
    //   134	169	4	arrayOfObject	Object[]
    //   89	22	5	localSparseArray	SparseArray
    //   139	3	5	localIOException	java.io.IOException
    //   153	3	5	localSAXException	org.xml.sax.SAXException
    //   167	3	5	localParserConfigurationException	javax.xml.parsers.ParserConfigurationException
    //   212	5	5	localObject2	Object
    //   70	55	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   72	107	134	finally
    //   113	121	134	finally
    //   141	146	134	finally
    //   155	160	134	finally
    //   169	174	134	finally
    //   72	107	139	java/io/IOException
    //   113	121	139	java/io/IOException
    //   72	107	153	org/xml/sax/SAXException
    //   113	121	153	org/xml/sax/SAXException
    //   72	107	167	javax/xml/parsers/ParserConfigurationException
    //   113	121	167	javax/xml/parsers/ParserConfigurationException
    //   127	131	181	java/io/IOException
    //   146	150	181	java/io/IOException
    //   160	164	181	java/io/IOException
    //   174	178	181	java/io/IOException
    //   290	294	297	java/io/IOException
  }
  
  private int b()
  {
    long l = System.currentTimeMillis();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateActions_Remote:");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append("rich_status_android");
      QLog.d("Q.richstatus.xml", 2, ((StringBuilder)localObject).toString());
    }
    if (Math.abs(l - this.jdField_b_of_type_Long) > 240000L)
    {
      localObject = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
      if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver == null) {
        a();
      }
      ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).d() });
      this.jdField_b_of_type_Long = l;
    }
    return 100;
  }
  
  private int b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0) {
      return 102;
    }
    long l = System.currentTimeMillis();
    if (Math.abs(this.jdField_c_of_type_Long - l) > 43200000L)
    {
      if (!paramBoolean) {
        return 101;
      }
      if (Math.abs(this.jdField_d_of_type_Long - l) > 300000L)
      {
        this.jdField_d_of_type_Long = l;
        return 101;
      }
    }
    return 100;
  }
  
  private SharedPreferences b()
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rich_status");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = new StatusManager.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
  }
  
  private void b(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    b().edit().putBoolean("k_sync_ss", paramBoolean).putLong("k_ss_time", l).commit();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = new StatusManager.4(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
  }
  
  private boolean c()
  {
    int i = b(true);
    if (i != 100)
    {
      a(i);
      return true;
    }
    return false;
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 102) {
      return a();
    }
    if (paramInt == 101) {
      return b();
    }
    return -1;
  }
  
  public int a(RichStatus paramRichStatus, int paramInt)
  {
    if (paramRichStatus == null) {
      return 100;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.richstatus.set", 2, String.format("changeStatus %d,%d [%s]", new Object[] { Integer.valueOf(paramRichStatus.actionId), Integer.valueOf(paramInt), paramRichStatus.toSpannableString(null) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    if (paramRichStatus.isEmpty())
    {
      paramRichStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramRichStatus != null)
      {
        paramRichStatus = new NewIntent(paramRichStatus.getApp(), StatusServlet.class);
        paramRichStatus.putExtra("k_cmd", 8);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramRichStatus);
      }
    }
    else
    {
      byte[] arrayOfByte = paramRichStatus.encode();
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), StatusServlet.class);
      localNewIntent.putExtra("k_cmd", 9);
      localNewIntent.putExtra("k_tpl_id", paramRichStatus.tplId);
      localNewIntent.putExtra("k_font_id", paramRichStatus.fontId);
      localNewIntent.putExtra("k_sign_len", arrayOfByte.length);
      localNewIntent.putExtra("k_sign_data", arrayOfByte);
      localNewIntent.putExtra("k_source", paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null) {
      b();
    }
    return 100;
  }
  
  public int a(ArrayList<StateTag> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList.clear();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        paramArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      }
      return b(false);
    }
    throw new InvalidParameterException("array list is null");
  }
  
  public int a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSyncShuoShuo ");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.richstatus.shuo", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null) {
      b();
    }
    StatusServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    return 100;
  }
  
  public long a()
  {
    return a().getLong("k_version", 0L);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder = new BitmapDecoder("StatusIcon_", this);
    }
    Object localObject2 = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("_s_");
    ((StringBuilder)localObject1).append(paramInt2);
    Object localObject3 = ((StringBuilder)localObject1).toString();
    Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder;
    Object localObject4 = null;
    if (localObject2 != null)
    {
      if (paramInt2 == 201) {
        localObject1 = ((ActionInfo)localObject2).jdField_a_of_type_JavaLangString;
      } else {
        localObject1 = ((ActionInfo)localObject2).b;
      }
    }
    else {
      localObject1 = null;
    }
    localObject5 = ((BitmapDecoder)localObject5).a((String)localObject3, null, (String)localObject1);
    if ((localObject2 == null) && (c()) && (localObject5 == null)) {
      this.jdField_a_of_type_JavaUtilHashSet.add(localObject3);
    }
    if (paramInt2 == 201) {}
    try
    {
      if (GlobalImageCache.a != null)
      {
        localObject3 = (Bitmap)GlobalImageCache.a.get("StatusIcon_RichStatusDefaultBig");
        localObject2 = localObject4;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label370;
        }
        localObject1 = localObject3;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label234:
      break label364;
    }
    try
    {
      localObject3 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130849880);
      localObject1 = localObject3;
      GlobalImageCache.a.put("StatusIcon_RichStatusDefaultSmall", localObject3, (byte)0);
      localObject2 = localObject4;
      localObject1 = localObject3;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label234;
    }
    localObject2 = localObject4;
    break label370;
    localObject1 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130849880);
    localObject2 = localObject4;
    break label370;
    if (paramInt2 == 200)
    {
      if (GlobalImageCache.a != null)
      {
        localObject2 = (Bitmap)GlobalImageCache.a.get("StatusIcon_RichStatusDefaultSmall");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130849881);
          GlobalImageCache.a.put("StatusIcon_RichStatusDefaultSmall", localObject1, (byte)0);
        }
        localObject3 = null;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      else
      {
        localObject2 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130849881);
        localObject1 = null;
      }
    }
    else
    {
      label364:
      localObject1 = null;
      localObject2 = localObject4;
    }
    label370:
    if (localObject5 != null) {
      return localObject5;
    }
    if (paramInt2 == 201) {
      return localObject1;
    }
    return localObject2;
  }
  
  public ActionInfo a(int paramInt)
  {
    ActionInfo localActionInfo = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localActionInfo == null) {
      c();
    }
    return localActionInfo;
  }
  
  public RichStatus a()
  {
    return a(true);
  }
  
  public RichStatus a(String paramString, boolean paramBoolean)
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null)
    {
      paramString = ((FriendsManager)localObject).a(paramString, paramBoolean);
      if (paramString != null)
      {
        paramString = ExtensionRichStatus.a(paramString);
        break label39;
      }
    }
    paramString = null;
    label39:
    localObject = paramString;
    if (paramString == null) {
      localObject = new RichStatus(null);
    }
    return localObject;
  }
  
  public RichStatus a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 != null)
    {
      localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean);
      if (localObject1 != null)
      {
        localObject1 = ExtensionRichStatus.a((ExtensionInfo)localObject1);
        break label56;
      }
    }
    localObject1 = null;
    label56:
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new RichStatus(null);
    }
    return localObject2;
  }
  
  public String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return paramString1.replace("$I", Integer.toString(paramInt1)).replace("$U", Integer.toString(paramInt2)).replace("$A", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$N", paramString2);
  }
  
  protected ArrayList<UserProfile> a(ArrayList<UserProfile> paramArrayList)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    int k = paramArrayList.size();
    int j = -1;
    int i;
    Object localObject;
    if ((localHashMap != null) && (localHashMap.size() > 0) && (k > 0))
    {
      i = k - 1;
      while (i > -1)
      {
        localObject = (UserProfile)paramArrayList.get(i);
        UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject).lEctID));
        if (localUserProfile != null)
        {
          localUserProfile.bAge = ((UserProfile)localObject).bAge;
          localUserProfile.bSex = ((UserProfile)localObject).bSex;
          localUserProfile.strDesc = ((UserProfile)localObject).strDesc;
          paramArrayList.remove(i);
        }
        i -= 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("filterFriends ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(" - ");
      i = j;
      if (localHashMap != null) {
        i = localHashMap.size();
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append(paramArrayList.size());
      QLog.d("Q.richstatus.mate", 2, ((StringBuilder)localObject).toString());
    }
    return paramArrayList;
  }
  
  protected ArrayList<UserProfile> a(ArrayList<UserProfile> paramArrayList1, ArrayList<UserProfile> paramArrayList2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (paramInt == -1)
    {
      localArrayList.addAll(paramArrayList1);
      localObject1 = paramArrayList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UserProfile)((Iterator)localObject1).next();
        localHashMap.put(Long.valueOf(((UserProfile)localObject2).lEctID), localObject2);
      }
    }
    Object localObject1 = paramArrayList1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (UserProfile)((Iterator)localObject1).next();
      if (((UserProfile)localObject2).bSex == paramInt)
      {
        localArrayList.add(localObject2);
        localHashMap.put(Long.valueOf(((UserProfile)localObject2).lEctID), localObject2);
      }
    }
    Object localObject2 = Long.valueOf(0L);
    try
    {
      localObject1 = Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.richstatus.xml", 2, localException.toString());
        localObject1 = localObject2;
      }
    }
    localHashMap.put(localObject1, new UserProfile());
    localObject1 = paramArrayList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (UserProfile)((Iterator)localObject1).next();
      UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject2).lEctID));
      if (localUserProfile == null)
      {
        localArrayList.add(localObject2);
      }
      else
      {
        localUserProfile.bAge = ((UserProfile)localObject2).bAge;
        localUserProfile.bSex = ((UserProfile)localObject2).bSex;
        localUserProfile.strDesc = ((UserProfile)localObject2).strDesc;
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mergeFriendsStrangers ");
      ((StringBuilder)localObject1).append(paramArrayList1.size());
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramArrayList2.size());
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("=");
      ((StringBuilder)localObject1).append(localArrayList.size());
      QLog.d("Q.richstatus.mate", 2, ((StringBuilder)localObject1).toString());
    }
    return localArrayList;
  }
  
  public void a(long paramLong)
  {
    ((SignatureHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER)).a(paramLong);
    if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver == null) {
      c();
    }
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    try
    {
      if ((paramObject instanceof IIconListener)) {
        if (this.jdField_a_of_type_JavaUtilLinkedList == null)
        {
          this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
          this.jdField_a_of_type_JavaUtilLinkedList.add((IIconListener)paramObject);
        }
        else if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject))
        {
          this.jdField_a_of_type_JavaUtilLinkedList.add((IIconListener)paramObject);
        }
      }
      if ((paramObject instanceof IActionListener)) {
        if (this.jdField_b_of_type_JavaUtilLinkedList == null)
        {
          this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
          this.jdField_b_of_type_JavaUtilLinkedList.add((IActionListener)paramObject);
        }
        else if (!this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject))
        {
          this.jdField_b_of_type_JavaUtilLinkedList.add((IActionListener)paramObject);
        }
      }
      if ((paramObject instanceof IImageListener)) {
        if (this.jdField_c_of_type_JavaUtilLinkedList == null)
        {
          this.jdField_c_of_type_JavaUtilLinkedList = new LinkedList();
          this.jdField_c_of_type_JavaUtilLinkedList.add((IImageListener)paramObject);
        }
        else if (!this.jdField_c_of_type_JavaUtilLinkedList.contains(paramObject))
        {
          this.jdField_c_of_type_JavaUtilLinkedList.add((IImageListener)paramObject);
        }
      }
      if ((paramObject instanceof IStatusListener)) {
        if (this.jdField_d_of_type_JavaUtilLinkedList == null)
        {
          this.jdField_d_of_type_JavaUtilLinkedList = new LinkedList();
          this.jdField_d_of_type_JavaUtilLinkedList.add((IStatusListener)paramObject);
        }
        else if (!this.jdField_d_of_type_JavaUtilLinkedList.contains(paramObject))
        {
          this.jdField_d_of_type_JavaUtilLinkedList.add((IStatusListener)paramObject);
        }
      }
      if ((paramObject instanceof ISameStatusListener)) {
        if (this.e == null)
        {
          this.e = new LinkedList();
          this.e.add((ISameStatusListener)paramObject);
        }
        else if (!this.e.contains(paramObject))
        {
          this.e.add((ISameStatusListener)paramObject);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("sp_hot_status");
    localEditor.putString(localStringBuilder.toString(), paramString).commit();
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    if ((paramString2 == null) && (paramBitmap != null)) {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramString1);
    }
    paramString1 = paramString1.split("_");
    int i;
    if (paramString1.length == 3)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        paramInt = Integer.parseInt(paramString1[0]);
        i = Integer.parseInt(paramString1[2]);
        paramString1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (paramString1.hasNext()) {
          ((IIconListener)paramString1.next()).onGetIcon(paramInt, i, paramBitmap);
        }
      }
    }
    else if ((paramString1.length == 2) && (this.jdField_c_of_type_JavaUtilLinkedList != null))
    {
      i = Integer.parseInt(paramString1[0]);
      int j = Integer.parseInt(paramString1[1]);
      paramString1 = this.jdField_c_of_type_JavaUtilLinkedList.iterator();
      while (paramString1.hasNext()) {
        ((IImageListener)paramString1.next()).a(i, j, paramBitmap, paramInt);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedList;
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      localObject1 = this.jdField_c_of_type_JavaUtilLinkedList;
      if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0)) {}
    }
    else
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject1 = str.split("_");
        Object localObject2 = (ActionInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(localObject1[0]));
        if (localObject2 != null)
        {
          if (localObject1.length == 3)
          {
            if (Integer.parseInt(localObject1[2]) == 201) {
              localObject1 = ((ActionInfo)localObject2).jdField_a_of_type_JavaLangString;
            } else {
              localObject1 = ((ActionInfo)localObject2).b;
            }
          }
          else if ((localObject1.length == 2) && (!TextUtils.isEmpty(((ActionInfo)localObject2).g))) {
            localObject1 = ((ActionInfo)localObject2).g.replace("$U", localObject1[1]);
          } else {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder.a(str, null, (String)localObject1);
            if (localObject2 != null) {
              a(str, (String)localObject1, (Bitmap)localObject2, 1);
            }
          }
          else
          {
            localIterator.remove();
          }
        }
      }
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilHashSet.clear();
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null;
  }
  
  public boolean a(long paramLong)
  {
    long l2 = a().getLong("k_version", 104L);
    long l1 = l2;
    if (l2 < 104L) {
      l1 = 104L;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StatusManager.isNewVersion(): localVersion ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" serverVersion ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", builtInVersion ");
      localStringBuilder.append(104L);
      QLog.d("Q.richstatus.xml", 2, localStringBuilder.toString());
    }
    return paramLong > l1;
  }
  
  public boolean a(File paramFile, long paramLong)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("saveActions(");
      ((StringBuilder)localObject1).append(paramFile);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(")");
      QLog.d("Q.richstatus.xml", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool2 = false;
    try
    {
      localObject1 = a(new FileInputStream(paramFile));
      ??? = (SparseArray)localObject1[0];
      ArrayList localArrayList = (ArrayList)localObject1[1];
      boolean bool1 = bool2;
      if (??? != null)
      {
        bool1 = bool2;
        if (((SparseArray)???).size() > 0)
        {
          bool1 = bool2;
          if (localArrayList != null)
          {
            bool1 = bool2;
            if (localArrayList.size() > 0)
            {
              localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray;
              synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
              {
                AsyncTask localAsyncTask = this.jdField_a_of_type_AndroidOsAsyncTask;
                if (localAsyncTask != null) {
                  localAsyncTask.cancel(true);
                }
                this.jdField_a_of_type_AndroidUtilSparseArray = ((SparseArray)???);
                if ((localArrayList != null) && (localArrayList.size() > 0)) {
                  synchronized (this.jdField_a_of_type_JavaUtilArrayList)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.clear();
                    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
                  }
                }
                this.jdField_c_of_type_Long = System.currentTimeMillis();
                ??? = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir(), "rich_status.xml");
                if ((!paramFile.renameTo((File)???)) && (!paramFile.renameTo((File)???)) && (!paramFile.renameTo((File)???)))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.richstatus.xml", 2, "saveActions rename failed!");
                  }
                }
                else
                {
                  paramFile = a().edit();
                  paramFile.putLong("k_version", paramLong).putLong("k_update_time", this.jdField_c_of_type_Long).commit();
                  if (a((SparseArray)localObject1, this.jdField_a_of_type_AndroidUtilSparseArray)) {
                    paramFile.putLong("k_icon", paramLong).commit();
                  }
                }
                bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("saveActions return with ");
        paramFile.append(bool1);
        QLog.d("Q.richstatus.xml", 2, paramFile.toString());
      }
    }
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    LinkedList localLinkedList;
    if ((paramObject instanceof IIconListener))
    {
      localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
    if ((paramObject instanceof IActionListener))
    {
      localLinkedList = this.jdField_b_of_type_JavaUtilLinkedList;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
    if ((paramObject instanceof IImageListener))
    {
      localLinkedList = this.jdField_c_of_type_JavaUtilLinkedList;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
    if ((paramObject instanceof IStatusListener))
    {
      localLinkedList = this.jdField_d_of_type_JavaUtilLinkedList;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
    if ((paramObject instanceof ISameStatusListener))
    {
      localLinkedList = this.e;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
  }
  
  public boolean b()
  {
    Object localObject = b();
    boolean bool = ((SharedPreferences)localObject).getBoolean("k_sync_ss", false);
    long l = System.currentTimeMillis();
    if ((Math.abs(l - this.jdField_a_of_type_Long) > 180000L) && (Math.abs(l - ((SharedPreferences)localObject).getLong("k_ss_time", 0L)) > 60000L))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver == null) {
        b();
      }
      this.jdField_a_of_type_Long = l;
      StatusServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSyncShuoShuo ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.richstatus.shuo", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager
 * JD-Core Version:    0.7.0.1
 */