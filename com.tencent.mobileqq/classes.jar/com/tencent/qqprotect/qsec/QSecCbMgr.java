package com.tencent.qqprotect.qsec;

import android.os.Handler;
import android.util.Pair;
import com.tencent.qqprotect.common.QPDirUtils;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class QSecCbMgr
{
  private ConcurrentHashMap<Integer, Byte> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<QSecCbMgr.IControlBitChangeListener> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public QSecCbMgr()
  {
    SecSvcHandlerHelper.a("MobileQQprotect.QSecCb", new QSecCbMgr.1(this));
    a();
  }
  
  private Pair<Integer, Byte> a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramString = new Pair(Integer.valueOf(Integer.parseInt(paramString)), Byte.valueOf((byte)paramJSONObject.getInt(paramString)));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QPDirUtils.a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("QSecCb.dat");
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    byte[] arrayOfByte = new QSecStoreUtil().a(a(), null, 1);
    if (arrayOfByte != null) {
      a(arrayOfByte);
    }
  }
  
  private void a(long paramLong)
  {
    QSecCbMgr.2 local2 = new QSecCbMgr.2(this);
    QSecFramework.a().postDelayed(local2, paramLong);
  }
  
  private void a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.getInt("ver") != 1) {
        return;
      }
      JSONObject localJSONObject = paramString.getJSONObject("cbs");
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        if (localIterator != null) {
          while (localIterator.hasNext())
          {
            Object localObject = a((String)localIterator.next(), localJSONObject);
            if (localObject != null)
            {
              paramString = (String)localObject;
              if (((Integer)((Pair)localObject).first).intValue() == 3) {
                paramString = new Pair(Integer.valueOf(3), Byte.valueOf((byte)0));
              }
              localObject = (Byte)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString.first);
              if (localObject == null) {
                localLinkedList.add(paramString);
              } else if (((Byte)localObject).byteValue() != ((Byte)paramString.second).byteValue()) {
                localLinkedList.add(paramString);
              }
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.first, paramString.second);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      b();
      if (!localLinkedList.isEmpty())
      {
        paramString = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (paramString.hasNext()) {
          ((QSecCbMgr.IControlBitChangeListener)paramString.next()).a(localLinkedList);
        }
      }
    }
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 201	java/io/DataInputStream
    //   9: dup
    //   10: new 203	java/io/ByteArrayInputStream
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 205	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: invokespecial 208	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 211	java/io/DataInputStream:readInt	()I
    //   26: istore_3
    //   27: aload_1
    //   28: invokevirtual 214	java/io/DataInputStream:readByte	()B
    //   31: istore_2
    //   32: aload_0
    //   33: getfield 18	com/tencent/qqprotect/qsec/QSecCbMgr:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: iload_3
    //   37: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: iload_2
    //   41: invokestatic 63	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   44: invokevirtual 183	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: goto -26 -> 22
    //   51: astore 4
    //   53: goto +48 -> 101
    //   56: astore 5
    //   58: goto +20 -> 78
    //   61: astore 5
    //   63: aload 4
    //   65: astore_1
    //   66: aload 5
    //   68: astore 4
    //   70: goto +31 -> 101
    //   73: astore 5
    //   75: aload 6
    //   77: astore_1
    //   78: aload_1
    //   79: astore 4
    //   81: aload 5
    //   83: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   86: aload_1
    //   87: ifnull +13 -> 100
    //   90: aload_1
    //   91: invokevirtual 218	java/io/DataInputStream:close	()V
    //   94: return
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   100: return
    //   101: aload_1
    //   102: ifnull +15 -> 117
    //   105: aload_1
    //   106: invokevirtual 218	java/io/DataInputStream:close	()V
    //   109: goto +8 -> 117
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   117: goto +6 -> 123
    //   120: aload 4
    //   122: athrow
    //   123: goto -3 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	QSecCbMgr
    //   0	126	1	paramArrayOfByte	byte[]
    //   31	10	2	b	byte
    //   26	11	3	i	int
    //   4	1	4	localObject1	Object
    //   51	13	4	localObject2	Object
    //   68	53	4	localObject3	Object
    //   56	1	5	localIOException1	java.io.IOException
    //   61	6	5	localObject4	Object
    //   73	9	5	localIOException2	java.io.IOException
    //   1	75	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   22	48	51	finally
    //   22	48	56	java/io/IOException
    //   6	22	61	finally
    //   81	86	61	finally
    //   6	22	73	java/io/IOException
    //   90	94	95	java/io/IOException
    //   105	109	112	java/io/IOException
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: new 221	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 222	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 224	java/io/DataOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 227	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore 5
    //   18: aload_1
    //   19: astore_2
    //   20: aload 5
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 18	com/tencent/qqprotect/qsec/QSecCbMgr:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   27: invokevirtual 231	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   30: invokeinterface 234 1 0
    //   35: astore 4
    //   37: aload_1
    //   38: astore_2
    //   39: aload 5
    //   41: astore_3
    //   42: aload 4
    //   44: invokeinterface 146 1 0
    //   49: ifeq +69 -> 118
    //   52: aload_1
    //   53: astore_2
    //   54: aload 5
    //   56: astore_3
    //   57: aload 4
    //   59: invokeinterface 150 1 0
    //   64: checkcast 236	java/util/Map$Entry
    //   67: astore 6
    //   69: aload_1
    //   70: astore_2
    //   71: aload 5
    //   73: astore_3
    //   74: aload 5
    //   76: aload 6
    //   78: invokeinterface 239 1 0
    //   83: checkcast 45	java/lang/Integer
    //   86: invokevirtual 162	java/lang/Integer:intValue	()I
    //   89: invokevirtual 243	java/io/DataOutputStream:writeInt	(I)V
    //   92: aload_1
    //   93: astore_2
    //   94: aload 5
    //   96: astore_3
    //   97: aload 5
    //   99: aload 6
    //   101: invokeinterface 246 1 0
    //   106: checkcast 60	java/lang/Byte
    //   109: invokevirtual 176	java/lang/Byte:byteValue	()B
    //   112: invokevirtual 249	java/io/DataOutputStream:writeByte	(I)V
    //   115: goto -78 -> 37
    //   118: aload_1
    //   119: astore_2
    //   120: aload 5
    //   122: astore_3
    //   123: aload_1
    //   124: invokevirtual 252	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   127: astore 4
    //   129: aload_1
    //   130: invokevirtual 253	java/io/ByteArrayOutputStream:close	()V
    //   133: goto +8 -> 141
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   141: aload 5
    //   143: invokevirtual 254	java/io/DataOutputStream:close	()V
    //   146: aload 4
    //   148: areturn
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   154: aload 4
    //   156: areturn
    //   157: astore_2
    //   158: aload_1
    //   159: astore 4
    //   161: aload 5
    //   163: astore_1
    //   164: aload_2
    //   165: astore 5
    //   167: goto +37 -> 204
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_3
    //   173: goto +83 -> 256
    //   176: astore 5
    //   178: aconst_null
    //   179: astore_2
    //   180: aload_1
    //   181: astore 4
    //   183: aload_2
    //   184: astore_1
    //   185: goto +19 -> 204
    //   188: astore_2
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_3
    //   192: astore_1
    //   193: goto +63 -> 256
    //   196: astore 5
    //   198: aconst_null
    //   199: astore 4
    //   201: aload 4
    //   203: astore_1
    //   204: aload 4
    //   206: astore_2
    //   207: aload_1
    //   208: astore_3
    //   209: aload 5
    //   211: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   214: aload 4
    //   216: ifnull +16 -> 232
    //   219: aload 4
    //   221: invokevirtual 253	java/io/ByteArrayOutputStream:close	()V
    //   224: goto +8 -> 232
    //   227: astore_2
    //   228: aload_2
    //   229: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   232: aload_1
    //   233: ifnull +14 -> 247
    //   236: aload_1
    //   237: invokevirtual 254	java/io/DataOutputStream:close	()V
    //   240: aconst_null
    //   241: areturn
    //   242: astore_1
    //   243: aload_1
    //   244: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   247: aconst_null
    //   248: areturn
    //   249: astore 4
    //   251: aload_2
    //   252: astore_1
    //   253: aload 4
    //   255: astore_2
    //   256: aload_1
    //   257: ifnull +15 -> 272
    //   260: aload_1
    //   261: invokevirtual 253	java/io/ByteArrayOutputStream:close	()V
    //   264: goto +8 -> 272
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   272: aload_3
    //   273: ifnull +15 -> 288
    //   276: aload_3
    //   277: invokevirtual 254	java/io/DataOutputStream:close	()V
    //   280: goto +8 -> 288
    //   283: astore_1
    //   284: aload_1
    //   285: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   288: goto +5 -> 293
    //   291: aload_2
    //   292: athrow
    //   293: goto -2 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	QSecCbMgr
    //   7	123	1	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   136	2	1	localIOException1	java.io.IOException
    //   149	10	1	localIOException2	java.io.IOException
    //   163	74	1	localObject1	Object
    //   242	2	1	localIOException3	java.io.IOException
    //   252	9	1	localObject2	Object
    //   267	2	1	localIOException4	java.io.IOException
    //   283	2	1	localIOException5	java.io.IOException
    //   19	101	2	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   157	8	2	localIOException6	java.io.IOException
    //   170	1	2	localObject3	Object
    //   179	5	2	localObject4	Object
    //   188	1	2	localObject5	Object
    //   206	1	2	localObject6	Object
    //   227	25	2	localIOException7	java.io.IOException
    //   255	37	2	localObject7	Object
    //   22	255	3	localObject8	Object
    //   35	185	4	localObject9	Object
    //   249	5	4	localObject10	Object
    //   16	150	5	localObject11	Object
    //   176	1	5	localIOException8	java.io.IOException
    //   196	14	5	localIOException9	java.io.IOException
    //   67	33	6	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   129	133	136	java/io/IOException
    //   141	146	149	java/io/IOException
    //   23	37	157	java/io/IOException
    //   42	52	157	java/io/IOException
    //   57	69	157	java/io/IOException
    //   74	92	157	java/io/IOException
    //   97	115	157	java/io/IOException
    //   123	129	157	java/io/IOException
    //   8	18	170	finally
    //   8	18	176	java/io/IOException
    //   0	8	188	finally
    //   0	8	196	java/io/IOException
    //   219	224	227	java/io/IOException
    //   236	240	242	java/io/IOException
    //   23	37	249	finally
    //   42	52	249	finally
    //   57	69	249	finally
    //   74	92	249	finally
    //   97	115	249	finally
    //   123	129	249	finally
    //   209	214	249	finally
    //   260	264	267	java/io/IOException
    //   276	280	283	java/io/IOException
  }
  
  private void b()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte != null) {
      new QSecStoreUtil().a(a(), arrayOfByte, null, 1);
    }
  }
  
  public byte a(int paramInt)
  {
    if (paramInt == 3) {
      return 0;
    }
    Byte localByte = (Byte)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localByte != null) {
      return localByte.byteValue();
    }
    return -1;
  }
  
  public void a(QSecCbMgr.IControlBitChangeListener paramIControlBitChangeListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramIControlBitChangeListener);
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 270	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 272
    //   9: iconst_2
    //   10: ldc_w 274
    //   13: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: getstatic 284	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   19: aconst_null
    //   20: invokevirtual 288	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   23: checkcast 290	com/tencent/mobileqq/app/QQAppInterface
    //   26: astore 6
    //   28: aload 6
    //   30: ifnonnull +11 -> 41
    //   33: aload_0
    //   34: ldc2_w 291
    //   37: invokespecial 294	com/tencent/qqprotect/qsec/QSecCbMgr:a	(J)V
    //   40: return
    //   41: aload 6
    //   43: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   46: ldc_w 300
    //   49: iconst_0
    //   50: invokevirtual 306	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   53: astore 6
    //   55: iload_1
    //   56: ifne +50 -> 106
    //   59: aload 6
    //   61: ldc_w 308
    //   64: lconst_0
    //   65: invokeinterface 314 4 0
    //   70: lstore_2
    //   71: new 316	java/util/Date
    //   74: dup
    //   75: invokespecial 317	java/util/Date:<init>	()V
    //   78: invokevirtual 321	java/util/Date:getTime	()J
    //   81: lstore 4
    //   83: lload 4
    //   85: lload_2
    //   86: lsub
    //   87: lstore_2
    //   88: lload_2
    //   89: ldc2_w 291
    //   92: lcmp
    //   93: ifge +13 -> 106
    //   96: aload_0
    //   97: ldc2_w 291
    //   100: lload_2
    //   101: lsub
    //   102: invokespecial 294	com/tencent/qqprotect/qsec/QSecCbMgr:a	(J)V
    //   105: return
    //   106: aload 6
    //   108: invokeinterface 325 1 0
    //   113: astore 6
    //   115: aload 6
    //   117: ldc_w 308
    //   120: new 316	java/util/Date
    //   123: dup
    //   124: invokespecial 317	java/util/Date:<init>	()V
    //   127: invokevirtual 321	java/util/Date:getTime	()J
    //   130: invokeinterface 331 4 0
    //   135: pop
    //   136: aload 6
    //   138: invokeinterface 334 1 0
    //   143: pop
    //   144: iconst_0
    //   145: invokestatic 339	com/tencent/qqprotect/common/QPMiscUtils:a	(I)Lcom/tencent/ims/QQProtectCommon$QQProtectQueryHead;
    //   148: astore 6
    //   150: aload 6
    //   152: ifnonnull +11 -> 163
    //   155: aload_0
    //   156: ldc2_w 291
    //   159: invokespecial 294	com/tencent/qqprotect/qsec/QSecCbMgr:a	(J)V
    //   162: return
    //   163: new 341	com/tencent/ims/QSecControlBitsQuery$QSecCbQueryBody
    //   166: dup
    //   167: invokespecial 342	com/tencent/ims/QSecControlBitsQuery$QSecCbQueryBody:<init>	()V
    //   170: astore 7
    //   172: new 344	com/tencent/ims/QSecControlBitsQuery$QSecCbQuery
    //   175: dup
    //   176: invokespecial 345	com/tencent/ims/QSecControlBitsQuery$QSecCbQuery:<init>	()V
    //   179: astore 8
    //   181: aload 7
    //   183: getfield 349	com/tencent/ims/QSecControlBitsQuery$QSecCbQueryBody:u32_cfg_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   186: iconst_1
    //   187: invokevirtual 354	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   190: aload 7
    //   192: getfield 357	com/tencent/ims/QSecControlBitsQuery$QSecCbQueryBody:u32_qsec_ver	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   195: ldc_w 358
    //   198: invokevirtual 354	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   201: aload 8
    //   203: getfield 362	com/tencent/ims/QSecControlBitsQuery$QSecCbQuery:cb_query_head	Lcom/tencent/ims/QQProtectCommon$QQProtectQueryHead;
    //   206: aload 6
    //   208: invokevirtual 367	com/tencent/ims/QQProtectCommon$QQProtectQueryHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   211: aload 8
    //   213: getfield 371	com/tencent/ims/QSecControlBitsQuery$QSecCbQuery:cb_query_body	Lcom/tencent/ims/QSecControlBitsQuery$QSecCbQueryBody;
    //   216: aload 7
    //   218: invokevirtual 372	com/tencent/ims/QSecControlBitsQuery$QSecCbQueryBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   221: ldc 25
    //   223: aload 8
    //   225: invokevirtual 373	com/tencent/ims/QSecControlBitsQuery$QSecCbQuery:toByteArray	()[B
    //   228: invokestatic 376	com/tencent/qqprotect/qsec/SecSvcHandlerHelper:a	(Ljava/lang/String;[B)Z
    //   231: pop
    //   232: goto +15 -> 247
    //   235: astore 6
    //   237: goto +18 -> 255
    //   240: astore 6
    //   242: aload 6
    //   244: invokevirtual 377	java/lang/Throwable:printStackTrace	()V
    //   247: aload_0
    //   248: ldc2_w 291
    //   251: invokespecial 294	com/tencent/qqprotect/qsec/QSecCbMgr:a	(J)V
    //   254: return
    //   255: aload_0
    //   256: ldc2_w 291
    //   259: invokespecial 294	com/tencent/qqprotect/qsec/QSecCbMgr:a	(J)V
    //   262: aload 6
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	QSecCbMgr
    //   0	265	1	paramBoolean	boolean
    //   70	31	2	l1	long
    //   81	3	4	l2	long
    //   26	181	6	localObject1	Object
    //   235	1	6	localObject2	Object
    //   240	23	6	localThrowable	java.lang.Throwable
    //   170	47	7	localQSecCbQueryBody	com.tencent.ims.QSecControlBitsQuery.QSecCbQueryBody
    //   179	45	8	localQSecCbQuery	com.tencent.ims.QSecControlBitsQuery.QSecCbQuery
    // Exception table:
    //   from	to	target	type
    //   0	16	235	finally
    //   16	28	235	finally
    //   41	55	235	finally
    //   59	83	235	finally
    //   106	150	235	finally
    //   163	232	235	finally
    //   242	247	235	finally
    //   0	16	240	java/lang/Throwable
    //   16	28	240	java/lang/Throwable
    //   41	55	240	java/lang/Throwable
    //   59	83	240	java/lang/Throwable
    //   106	150	240	java/lang/Throwable
    //   163	232	240	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecCbMgr
 * JD-Core Version:    0.7.0.1
 */