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
  private static volatile WeakReference<StatusManager> d;
  private static Object[] p = new Object[2];
  private volatile SparseArray<ActionInfo> a = new SparseArray();
  private ArrayList<StateTag> b = new ArrayList();
  private QQAppInterface c;
  private BitmapDecoder e;
  private volatile AsyncTask<Void, Integer, Integer> f;
  private RichStatus g;
  private long h;
  private long i;
  private ConfigObserver j;
  private StatusObserver k;
  private SignatureObserver l;
  private long m;
  private long n;
  private HashSet<String> o;
  private LinkedList<IIconListener> q;
  private LinkedList<IActionListener> r;
  private LinkedList<IImageListener> s;
  private LinkedList<IStatusListener> t;
  private LinkedList<ISameStatusListener> u;
  private ArrayList<UserProfile> v;
  private ArrayList<UserProfile> w;
  private AsyncTask<Void, Void, ArrayList<UserProfile>> x;
  private byte[] y;
  private HashMap<Long, UserProfile> z;
  
  private StatusManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.o = new HashSet();
    this.m = e().getLong("k_update_time", 0L);
  }
  
  public static StatusManager a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != paramQQAppInterface) {
      return (StatusManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.STATUS_MANAGER);
    }
    if (d != null) {
      localObject1 = (StatusManager)d.get();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      paramQQAppInterface = new StatusManager(paramQQAppInterface);
      d = new WeakReference(paramQQAppInterface);
      return paramQQAppInterface;
    }
    ((StatusManager)localObject1).o.clear();
    ((StatusManager)localObject1).i = 0L;
    ((StatusManager)localObject1).h = 0L;
    ((StatusManager)localObject1).g = null;
    Object localObject2 = ((StatusManager)localObject1).j;
    if (localObject2 != null)
    {
      ((StatusManager)localObject1).c.removeObserver((com.tencent.mobileqq.app.BusinessObserver)localObject2);
      ((StatusManager)localObject1).j = null;
    }
    localObject2 = ((StatusManager)localObject1).k;
    if (localObject2 != null)
    {
      ((StatusManager)localObject1).c.unRegistObserver((mqq.observer.BusinessObserver)localObject2);
      ((StatusManager)localObject1).k = null;
    }
    localObject2 = ((StatusManager)localObject1).e;
    if (localObject2 != null) {
      ((BitmapDecoder)localObject2).b();
    }
    localObject2 = ((StatusManager)localObject1).l;
    if (localObject2 != null)
    {
      ((StatusManager)localObject1).c.removeObserver((com.tencent.mobileqq.app.BusinessObserver)localObject2);
      ((StatusManager)localObject1).l = null;
    }
    ((StatusManager)localObject1).c = paramQQAppInterface;
    return localObject1;
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
    int i2 = 0;
    int i1 = 0;
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
      i2 = paramSparseArray1.length;
      while (i1 < i2)
      {
        paramSparseArray2 = paramSparseArray1[i1];
        if ((paramSparseArray2 != null) && (paramSparseArray2.exists()) && (!paramSparseArray2.delete()) && (!paramSparseArray2.delete())) {
          paramSparseArray2.delete();
        }
        i1 += 1;
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
    int i3 = paramSparseArray2.size();
    i1 = i2;
    while (i1 < i3)
    {
      Object localObject2 = (ActionInfo)paramSparseArray2.valueAt(i1);
      ActionInfo localActionInfo = (ActionInfo)paramSparseArray1.get(((ActionInfo)localObject2).b);
      if ((localActionInfo != null) && (localActionInfo.c != null) && (!localActionInfo.c.equalsIgnoreCase(((ActionInfo)localObject2).c)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localActionInfo.b);
        localStringBuilder.append("_s_");
        localStringBuilder.append(201);
        localArrayList.add(localStringBuilder.toString());
      }
      if ((localActionInfo != null) && (localActionInfo.d != null) && (!localActionInfo.d.equalsIgnoreCase(((ActionInfo)localObject2).d)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localActionInfo.b);
        ((StringBuilder)localObject2).append("_s_");
        ((StringBuilder)localObject2).append(200);
        localArrayList.add(((StringBuilder)localObject2).toString());
      }
      i1 += 1;
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
    //   0: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +47 -> 50
    //   6: new 190	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc_w 311
    //   20: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: ldc 204
    //   35: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 206
    //   41: iconst_2
    //   42: aload 4
    //   44: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: iconst_2
    //   51: anewarray 4	java/lang/Object
    //   54: astore 4
    //   56: aload_1
    //   57: ifnonnull +6 -> 63
    //   60: aload 4
    //   62: areturn
    //   63: new 313	com/tencent/mobileqq/richstatus/StatusXmlHandler
    //   66: dup
    //   67: invokespecial 314	com/tencent/mobileqq/richstatus/StatusXmlHandler:<init>	()V
    //   70: astore 6
    //   72: invokestatic 320	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   75: invokevirtual 324	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   78: aload_1
    //   79: aload 6
    //   81: invokevirtual 330	javax/xml/parsers/SAXParser:parse	(Ljava/io/InputStream;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   84: aload 6
    //   86: invokevirtual 333	com/tencent/mobileqq/richstatus/StatusXmlHandler:a	()Landroid/util/SparseArray;
    //   89: astore 5
    //   91: aload 6
    //   93: invokevirtual 336	com/tencent/mobileqq/richstatus/StatusXmlHandler:b	()Ljava/util/ArrayList;
    //   96: astore 6
    //   98: aload 5
    //   100: invokevirtual 246	android/util/SparseArray:size	()I
    //   103: iconst_1
    //   104: if_icmple +9 -> 113
    //   107: aload 4
    //   109: iconst_0
    //   110: aload 5
    //   112: aastore
    //   113: aload 6
    //   115: invokevirtual 337	java/util/ArrayList:size	()I
    //   118: ifle +9 -> 127
    //   121: aload 4
    //   123: iconst_1
    //   124: aload 6
    //   126: aastore
    //   127: aload_1
    //   128: invokevirtual 342	java/io/InputStream:close	()V
    //   131: goto +55 -> 186
    //   134: astore 4
    //   136: goto +154 -> 290
    //   139: astore 5
    //   141: aload 5
    //   143: invokevirtual 345	java/io/IOException:printStackTrace	()V
    //   146: aload_1
    //   147: invokevirtual 342	java/io/InputStream:close	()V
    //   150: goto +36 -> 186
    //   153: astore 5
    //   155: aload 5
    //   157: invokevirtual 346	org/xml/sax/SAXException:printStackTrace	()V
    //   160: aload_1
    //   161: invokevirtual 342	java/io/InputStream:close	()V
    //   164: goto +22 -> 186
    //   167: astore 5
    //   169: aload 5
    //   171: invokevirtual 347	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   174: aload_1
    //   175: invokevirtual 342	java/io/InputStream:close	()V
    //   178: goto +8 -> 186
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 345	java/io/IOException:printStackTrace	()V
    //   186: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +98 -> 287
    //   192: new 190	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   199: astore_1
    //   200: aload_1
    //   201: ldc_w 349
    //   204: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   225: checkcast 74	android/util/SparseArray
    //   228: invokevirtual 246	android/util/SparseArray:size	()I
    //   231: istore_2
    //   232: goto +5 -> 237
    //   235: iconst_m1
    //   236: istore_2
    //   237: aload_1
    //   238: iload_2
    //   239: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_1
    //   244: ldc_w 351
    //   247: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   264: checkcast 79	java/util/ArrayList
    //   267: invokevirtual 337	java/util/ArrayList:size	()I
    //   270: istore_2
    //   271: aload_1
    //   272: iload_2
    //   273: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: ldc 206
    //   279: iconst_2
    //   280: aload_1
    //   281: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 4
    //   289: areturn
    //   290: aload_1
    //   291: invokevirtual 342	java/io/InputStream:close	()V
    //   294: goto +8 -> 302
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 345	java/io/IOException:printStackTrace	()V
    //   302: aload 4
    //   304: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	StatusManager
    //   0	305	1	paramInputStream	java.io.InputStream
    //   231	42	2	i1	int
    //   215	37	3	i2	int
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
  
  private int d(boolean paramBoolean)
  {
    if (this.a.size() == 0) {
      return 102;
    }
    long l1 = System.currentTimeMillis();
    if (Math.abs(this.m - l1) > 43200000L)
    {
      if (!paramBoolean) {
        return 101;
      }
      if (Math.abs(this.n - l1) > 300000L)
      {
        this.n = l1;
        return 101;
      }
    }
    return 100;
  }
  
  private SharedPreferences e()
  {
    return this.c.getApp().getSharedPreferences("rich_status", 0);
  }
  
  private void e(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    f().edit().putBoolean("k_sync_ss", paramBoolean).putLong("k_ss_time", l1).commit();
  }
  
  private SharedPreferences f()
  {
    BaseApplication localBaseApplication = this.c.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rich_status");
    localStringBuilder.append(this.c.getCurrentAccountUin());
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  private int g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Local");
    }
    if (this.f != null) {
      return 100;
    }
    this.f = new StatusManager.1(this).execute(new Void[0]);
    return 100;
  }
  
  private int h()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateActions_Remote:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append("rich_status_android");
      QLog.d("Q.richstatus.xml", 2, ((StringBuilder)localObject).toString());
    }
    if (Math.abs(l1 - this.i) > 240000L)
    {
      localObject = (ConfigHandler)this.c.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
      if (this.j == null) {
        i();
      }
      ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).j() });
      this.i = l1;
    }
    return 100;
  }
  
  private void i()
  {
    this.j = new StatusManager.2(this);
    this.c.addObserver(this.j);
  }
  
  private boolean j()
  {
    int i1 = d(true);
    if (i1 != 100)
    {
      b(i1);
      return true;
    }
    return false;
  }
  
  private void k()
  {
    this.k = new StatusManager.3(this);
    this.c.registObserver(this.k);
  }
  
  private void l()
  {
    this.l = new StatusManager.4(this);
    this.c.addObserver(this.l);
  }
  
  public int a(RichStatus paramRichStatus, int paramInt)
  {
    if (paramRichStatus == null) {
      return 100;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.richstatus.set", 2, String.format("changeStatus %d,%d [%s]", new Object[] { Integer.valueOf(paramRichStatus.actionId), Integer.valueOf(paramInt), paramRichStatus.toSpannableString(null) }));
    }
    this.g = paramRichStatus;
    if (paramRichStatus.isEmpty())
    {
      paramRichStatus = this.c;
      if (paramRichStatus != null)
      {
        paramRichStatus = new NewIntent(paramRichStatus.getApp(), StatusServlet.class);
        paramRichStatus.putExtra("k_cmd", 8);
        this.c.startServlet(paramRichStatus);
      }
    }
    else
    {
      byte[] arrayOfByte = paramRichStatus.encode();
      NewIntent localNewIntent = new NewIntent(this.c.getApp(), StatusServlet.class);
      localNewIntent.putExtra("k_cmd", 9);
      localNewIntent.putExtra("k_tpl_id", paramRichStatus.tplId);
      localNewIntent.putExtra("k_font_id", paramRichStatus.fontId);
      localNewIntent.putExtra("k_sign_len", arrayOfByte.length);
      localNewIntent.putExtra("k_sign_data", arrayOfByte);
      localNewIntent.putExtra("k_source", paramInt);
      this.c.startServlet(localNewIntent);
    }
    if (this.k == null) {
      k();
    }
    return 100;
  }
  
  public int a(ArrayList<StateTag> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList.clear();
      if (this.b.size() > 0) {
        paramArrayList.addAll(this.b);
      }
      return d(false);
    }
    throw new InvalidParameterException("array list is null");
  }
  
  public long a()
  {
    return e().getLong("k_version", 0L);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    if (this.e == null) {
      this.e = new BitmapDecoder("StatusIcon_", this);
    }
    Object localObject2 = (ActionInfo)this.a.get(paramInt1);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("_s_");
    ((StringBuilder)localObject1).append(paramInt2);
    Object localObject3 = ((StringBuilder)localObject1).toString();
    Object localObject5 = this.e;
    Object localObject4 = null;
    if (localObject2 != null)
    {
      if (paramInt2 == 201) {
        localObject1 = ((ActionInfo)localObject2).c;
      } else {
        localObject1 = ((ActionInfo)localObject2).d;
      }
    }
    else {
      localObject1 = null;
    }
    localObject5 = ((BitmapDecoder)localObject5).a((String)localObject3, null, (String)localObject1);
    if ((localObject2 == null) && (j()) && (localObject5 == null)) {
      this.o.add(localObject3);
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
      localObject3 = BitmapManager.a(this.c.getApp().getResources(), 2130851608);
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
    localObject1 = BitmapManager.a(this.c.getApp().getResources(), 2130851608);
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
          localObject1 = BitmapManager.a(this.c.getApp().getResources(), 2130851609);
          GlobalImageCache.a.put("StatusIcon_RichStatusDefaultSmall", localObject1, (byte)0);
        }
        localObject3 = null;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      else
      {
        localObject2 = BitmapManager.a(this.c.getApp().getResources(), 2130851609);
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
    ActionInfo localActionInfo = (ActionInfo)this.a.get(paramInt);
    if (localActionInfo == null) {
      j();
    }
    return localActionInfo;
  }
  
  public RichStatus a(String paramString, boolean paramBoolean)
  {
    Object localObject = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null)
    {
      paramString = ((FriendsManager)localObject).d(paramString, paramBoolean);
      if (paramString != null)
      {
        paramString = ExtensionRichStatus.c(paramString);
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
  
  public String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return paramString1.replace("$I", Integer.toString(paramInt1)).replace("$U", Integer.toString(paramInt2)).replace("$A", this.c.getCurrentAccountUin()).replace("$N", paramString2);
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
      localObject1 = Long.valueOf(Long.parseLong(this.c.getCurrentAccountUin()));
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
    this.z = localHashMap;
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
    ((SignatureHandler)this.c.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER)).a(paramLong);
    if (this.l == null) {
      l();
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
        if (this.q == null)
        {
          this.q = new LinkedList();
          this.q.add((IIconListener)paramObject);
        }
        else if (!this.q.contains(paramObject))
        {
          this.q.add((IIconListener)paramObject);
        }
      }
      if ((paramObject instanceof IActionListener)) {
        if (this.r == null)
        {
          this.r = new LinkedList();
          this.r.add((IActionListener)paramObject);
        }
        else if (!this.r.contains(paramObject))
        {
          this.r.add((IActionListener)paramObject);
        }
      }
      if ((paramObject instanceof IImageListener)) {
        if (this.s == null)
        {
          this.s = new LinkedList();
          this.s.add((IImageListener)paramObject);
        }
        else if (!this.s.contains(paramObject))
        {
          this.s.add((IImageListener)paramObject);
        }
      }
      if ((paramObject instanceof IStatusListener)) {
        if (this.t == null)
        {
          this.t = new LinkedList();
          this.t.add((IStatusListener)paramObject);
        }
        else if (!this.t.contains(paramObject))
        {
          this.t.add((IStatusListener)paramObject);
        }
      }
      if ((paramObject instanceof ISameStatusListener)) {
        if (this.u == null)
        {
          this.u = new LinkedList();
          this.u.add((ISameStatusListener)paramObject);
        }
        else if (!this.u.contains(paramObject))
        {
          this.u.add((ISameStatusListener)paramObject);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.c.getPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.getCurrentAccountUin());
    localStringBuilder.append("sp_hot_status");
    localEditor.putString(localStringBuilder.toString(), paramString).commit();
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    if ((paramString2 == null) && (paramBitmap != null)) {
      this.o.remove(paramString1);
    }
    paramString1 = paramString1.split("_");
    int i1;
    if (paramString1.length == 3)
    {
      if (this.q != null)
      {
        paramInt = Integer.parseInt(paramString1[0]);
        i1 = Integer.parseInt(paramString1[2]);
        paramString1 = this.q.iterator();
        while (paramString1.hasNext()) {
          ((IIconListener)paramString1.next()).onGetIcon(paramInt, i1, paramBitmap);
        }
      }
    }
    else if ((paramString1.length == 2) && (this.s != null))
    {
      i1 = Integer.parseInt(paramString1[0]);
      int i2 = Integer.parseInt(paramString1[1]);
      paramString1 = this.s.iterator();
      while (paramString1.hasNext()) {
        ((IImageListener)paramString1.next()).a(i1, i2, paramBitmap, paramInt);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject1 = this.q;
    if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
    {
      localObject1 = this.s;
      if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0)) {}
    }
    else
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject1 = str.split("_");
        Object localObject2 = (ActionInfo)this.a.get(Integer.parseInt(localObject1[0]));
        if (localObject2 != null)
        {
          if (localObject1.length == 3)
          {
            if (Integer.parseInt(localObject1[2]) == 201) {
              localObject1 = ((ActionInfo)localObject2).c;
            } else {
              localObject1 = ((ActionInfo)localObject2).d;
            }
          }
          else if ((localObject1.length == 2) && (!TextUtils.isEmpty(((ActionInfo)localObject2).j))) {
            localObject1 = ((ActionInfo)localObject2).j.replace("$U", localObject1[1]);
          } else {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            localObject2 = this.e.a(str, null, (String)localObject1);
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
        this.o.clear();
      }
      return;
    }
    this.o.clear();
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
              localObject1 = this.a;
              synchronized (this.a)
              {
                AsyncTask localAsyncTask = this.f;
                if (localAsyncTask != null) {
                  localAsyncTask.cancel(true);
                }
                this.a = ((SparseArray)???);
                if ((localArrayList != null) && (localArrayList.size() > 0)) {
                  synchronized (this.b)
                  {
                    this.b.clear();
                    this.b.addAll(localArrayList);
                  }
                }
                this.m = System.currentTimeMillis();
                ??? = new File(this.c.getApp().getFilesDir(), "rich_status.xml");
                if ((!paramFile.renameTo((File)???)) && (!paramFile.renameTo((File)???)) && (!paramFile.renameTo((File)???)))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.richstatus.xml", 2, "saveActions rename failed!");
                  }
                }
                else
                {
                  paramFile = e().edit();
                  paramFile.putLong("k_version", paramLong).putLong("k_update_time", this.m).commit();
                  if (a((SparseArray)localObject1, this.a)) {
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
  
  public int b(int paramInt)
  {
    if (paramInt == 102) {
      return g();
    }
    if (paramInt == 101) {
      return h();
    }
    return -1;
  }
  
  public RichStatus b(boolean paramBoolean)
  {
    Object localObject1 = this.g;
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 != null)
    {
      localObject1 = ((FriendsManager)localObject1).d(this.c.getCurrentAccountUin(), paramBoolean);
      if (localObject1 != null)
      {
        localObject1 = ExtensionRichStatus.c((ExtensionInfo)localObject1);
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
  
  protected ArrayList<UserProfile> b(ArrayList<UserProfile> paramArrayList)
  {
    HashMap localHashMap = this.z;
    int i3 = paramArrayList.size();
    int i2 = -1;
    int i1;
    Object localObject;
    if ((localHashMap != null) && (localHashMap.size() > 0) && (i3 > 0))
    {
      i1 = i3 - 1;
      while (i1 > -1)
      {
        localObject = (UserProfile)paramArrayList.get(i1);
        UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject).lEctID));
        if (localUserProfile != null)
        {
          localUserProfile.bAge = ((UserProfile)localObject).bAge;
          localUserProfile.bSex = ((UserProfile)localObject).bSex;
          localUserProfile.strDesc = ((UserProfile)localObject).strDesc;
          paramArrayList.remove(i1);
        }
        i1 -= 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("filterFriends ");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append(" - ");
      i1 = i2;
      if (localHashMap != null) {
        i1 = localHashMap.size();
      }
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append(paramArrayList.size());
      QLog.d("Q.richstatus.mate", 2, ((StringBuilder)localObject).toString());
    }
    return paramArrayList;
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    LinkedList localLinkedList;
    if ((paramObject instanceof IIconListener))
    {
      localLinkedList = this.q;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
    if ((paramObject instanceof IActionListener))
    {
      localLinkedList = this.r;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
    if ((paramObject instanceof IImageListener))
    {
      localLinkedList = this.s;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
    if ((paramObject instanceof IStatusListener))
    {
      localLinkedList = this.t;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
    if ((paramObject instanceof ISameStatusListener))
    {
      localLinkedList = this.u;
      if (localLinkedList != null) {
        localLinkedList.remove(paramObject);
      }
    }
  }
  
  public boolean b()
  {
    return this.g != null;
  }
  
  public boolean b(long paramLong)
  {
    long l2 = e().getLong("k_version", 104L);
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
  
  public int c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSyncShuoShuo ");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.richstatus.shuo", 2, localStringBuilder.toString());
    }
    if (this.k == null) {
      k();
    }
    StatusServlet.a(this.c, paramBoolean);
    return 100;
  }
  
  public RichStatus c()
  {
    return b(true);
  }
  
  public boolean d()
  {
    Object localObject = f();
    boolean bool = ((SharedPreferences)localObject).getBoolean("k_sync_ss", false);
    long l1 = System.currentTimeMillis();
    if ((Math.abs(l1 - this.h) > 180000L) && (Math.abs(l1 - ((SharedPreferences)localObject).getLong("k_ss_time", 0L)) > 60000L))
    {
      if (this.k == null) {
        k();
      }
      this.h = l1;
      StatusServlet.a(this.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager
 * JD-Core Version:    0.7.0.1
 */