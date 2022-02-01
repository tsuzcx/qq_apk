package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="troopUin")
public class ImportantMsgItem
  extends Entity
{
  public static final int MAX_MSGINFO_LIST_COUNT = 20;
  public static final String TAG = "ImportantMsgItem";
  public long maxImportantMsgSeq = 0L;
  public byte[] msgInfoData;
  @notColumn
  private ArrayList<ImportantMsgItem.MsgInfo> msgInfoList = new ArrayList();
  public long troopUin = 0L;
  
  private void sortAndlimitMsgInfoList()
  {
    Collections.sort(this.msgInfoList, Collections.reverseOrder());
    if (this.msgInfoList.size() > 20)
    {
      Iterator localIterator = this.msgInfoList.iterator();
      int j = 0;
      int i = 0;
      while (localIterator.hasNext())
      {
        int m = j + 1;
        ImportantMsgItem.MsgInfo localMsgInfo = (ImportantMsgItem.MsgInfo)localIterator.next();
        int k = i;
        if (localMsgInfo.msgNeedShow) {
          k = i + 1;
        }
        j = m;
        i = k;
        if (m > 20)
        {
          StringBuilder localStringBuilder;
          if (!localMsgInfo.msgNeedShow)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("sortAndlimitMsgInfoList remove seq:");
              localStringBuilder.append(localMsgInfo.msgSeq);
              QLog.e("ImportantMsgItem", 2, localStringBuilder.toString());
            }
            localIterator.remove();
            j = m;
            i = k;
          }
          else
          {
            j = m;
            i = k;
            if (k > 20)
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("sortAndlimitMsgInfoList remove seq:");
                localStringBuilder.append(localMsgInfo.msgSeq);
                QLog.e("ImportantMsgItem", 2, localStringBuilder.toString());
              }
              localIterator.remove();
              j = m;
              i = k;
            }
          }
        }
      }
    }
  }
  
  public boolean addMsgInfo(ImportantMsgItem.MsgInfo paramMsgInfo)
  {
    if (paramMsgInfo == null) {
      return false;
    }
    if (this.msgInfoList.contains(paramMsgInfo)) {
      return false;
    }
    this.msgInfoList.add(paramMsgInfo);
    sortAndlimitMsgInfoList();
    return true;
  }
  
  public boolean addMsgInfos(ArrayList<ImportantMsgItem.MsgInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ImportantMsgItem.MsgInfo localMsgInfo = (ImportantMsgItem.MsgInfo)paramArrayList.next();
      if (!this.msgInfoList.contains(localMsgInfo)) {
        this.msgInfoList.add(localMsgInfo);
      }
    }
    sortAndlimitMsgInfoList();
    return true;
  }
  
  public ImportantMsgItem clone()
  {
    ImportantMsgItem localImportantMsgItem = new ImportantMsgItem();
    localImportantMsgItem.troopUin = this.troopUin;
    localImportantMsgItem.msgInfoList.addAll(this.msgInfoList);
    localImportantMsgItem.maxImportantMsgSeq = this.maxImportantMsgSeq;
    return localImportantMsgItem;
  }
  
  public ArrayList<ImportantMsgItem.MsgInfo> getMsgInfoList()
  {
    return this.msgInfoList;
  }
  
  /* Error */
  protected void postRead()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 139	com/tencent/mobileqq/persistence/Entity:postRead	()V
    //   4: aload_0
    //   5: getfield 141	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoData	[B
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +261 -> 271
    //   13: aload_1
    //   14: arraylength
    //   15: ifne +4 -> 19
    //   18: return
    //   19: new 143	java/io/ObjectInputStream
    //   22: dup
    //   23: new 145	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 148	java/io/ByteArrayInputStream:<init>	([B)V
    //   31: invokespecial 151	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_2
    //   38: invokevirtual 154	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   41: astore_3
    //   42: aload_2
    //   43: astore_1
    //   44: aload_3
    //   45: instanceof 31
    //   48: ifeq +13 -> 61
    //   51: aload_2
    //   52: astore_1
    //   53: aload_0
    //   54: aload_3
    //   55: checkcast 31	java/util/ArrayList
    //   58: putfield 34	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoList	Ljava/util/ArrayList;
    //   61: aload_2
    //   62: invokevirtual 157	java/io/ObjectInputStream:close	()V
    //   65: goto +140 -> 205
    //   68: astore_1
    //   69: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +133 -> 205
    //   75: new 81	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   82: astore_2
    //   83: goto +96 -> 179
    //   86: astore_3
    //   87: goto +12 -> 99
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: goto +119 -> 212
    //   96: astore_3
    //   97: aconst_null
    //   98: astore_2
    //   99: aload_2
    //   100: astore_1
    //   101: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +49 -> 153
    //   107: aload_2
    //   108: astore_1
    //   109: new 81	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   116: astore 4
    //   118: aload_2
    //   119: astore_1
    //   120: aload 4
    //   122: ldc 159
    //   124: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_2
    //   129: astore_1
    //   130: aload 4
    //   132: aload_3
    //   133: invokevirtual 160	java/lang/Exception:toString	()Ljava/lang/String;
    //   136: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_2
    //   141: astore_1
    //   142: ldc 17
    //   144: iconst_2
    //   145: aload 4
    //   147: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_2
    //   154: ifnull +51 -> 205
    //   157: aload_2
    //   158: invokevirtual 157	java/io/ObjectInputStream:close	()V
    //   161: goto +44 -> 205
    //   164: astore_1
    //   165: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +37 -> 205
    //   171: new 81	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   178: astore_2
    //   179: aload_2
    //   180: ldc 159
    //   182: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_2
    //   187: aload_1
    //   188: invokevirtual 161	java/io/IOException:toString	()Ljava/lang/String;
    //   191: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 17
    //   197: iconst_2
    //   198: aload_2
    //   199: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_0
    //   206: aconst_null
    //   207: putfield 141	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoData	[B
    //   210: return
    //   211: astore_2
    //   212: aload_1
    //   213: ifnull +51 -> 264
    //   216: aload_1
    //   217: invokevirtual 157	java/io/ObjectInputStream:close	()V
    //   220: goto +44 -> 264
    //   223: astore_1
    //   224: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +37 -> 264
    //   230: new 81	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   237: astore_3
    //   238: aload_3
    //   239: ldc 159
    //   241: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_3
    //   246: aload_1
    //   247: invokevirtual 161	java/io/IOException:toString	()Ljava/lang/String;
    //   250: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: ldc 17
    //   256: iconst_2
    //   257: aload_3
    //   258: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aload_0
    //   265: aconst_null
    //   266: putfield 141	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoData	[B
    //   269: aload_2
    //   270: athrow
    //   271: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	ImportantMsgItem
    //   8	45	1	localObject1	java.lang.Object
    //   68	1	1	localIOException1	java.io.IOException
    //   92	50	1	localObject2	java.lang.Object
    //   164	53	1	localIOException2	java.io.IOException
    //   223	24	1	localIOException3	java.io.IOException
    //   34	49	2	localObject3	java.lang.Object
    //   90	1	2	localObject4	java.lang.Object
    //   98	101	2	localStringBuilder1	StringBuilder
    //   211	59	2	localObject5	java.lang.Object
    //   41	14	3	localObject6	java.lang.Object
    //   86	1	3	localException1	java.lang.Exception
    //   96	37	3	localException2	java.lang.Exception
    //   237	21	3	localStringBuilder2	StringBuilder
    //   116	30	4	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   61	65	68	java/io/IOException
    //   37	42	86	java/lang/Exception
    //   44	51	86	java/lang/Exception
    //   53	61	86	java/lang/Exception
    //   19	35	90	finally
    //   19	35	96	java/lang/Exception
    //   157	161	164	java/io/IOException
    //   37	42	211	finally
    //   44	51	211	finally
    //   53	61	211	finally
    //   101	107	211	finally
    //   109	118	211	finally
    //   120	128	211	finally
    //   130	140	211	finally
    //   142	153	211	finally
    //   216	220	223	java/io/IOException
  }
  
  protected void postwrite()
  {
    if (this.msgInfoData != null) {
      this.msgInfoData = null;
    }
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 165	com/tencent/mobileqq/persistence/Entity:prewrite	()V
    //   4: new 167	java/io/ByteArrayOutputStream
    //   7: dup
    //   8: invokespecial 168	java/io/ByteArrayOutputStream:<init>	()V
    //   11: astore_3
    //   12: new 170	java/io/ObjectOutputStream
    //   15: dup
    //   16: aload_3
    //   17: invokespecial 173	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: aload_0
    //   25: getfield 34	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoList	Ljava/util/ArrayList;
    //   28: invokevirtual 177	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 180	java/io/ObjectOutputStream:flush	()V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: aload_3
    //   41: invokevirtual 184	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   44: putfield 141	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoData	[B
    //   47: aload_2
    //   48: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   51: return
    //   52: astore_1
    //   53: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +132 -> 188
    //   59: new 81	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   66: astore_2
    //   67: aload_2
    //   68: ldc 187
    //   70: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_2
    //   75: aload_1
    //   76: invokevirtual 161	java/io/IOException:toString	()Ljava/lang/String;
    //   79: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: ldc 17
    //   85: iconst_2
    //   86: aload_2
    //   87: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: return
    //   94: astore_3
    //   95: goto +12 -> 107
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_2
    //   101: goto +93 -> 194
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: astore_1
    //   109: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +49 -> 161
    //   115: aload_2
    //   116: astore_1
    //   117: new 81	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   124: astore 4
    //   126: aload_2
    //   127: astore_1
    //   128: aload 4
    //   130: ldc 187
    //   132: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: astore_1
    //   138: aload 4
    //   140: aload_3
    //   141: invokevirtual 161	java/io/IOException:toString	()Ljava/lang/String;
    //   144: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_2
    //   149: astore_1
    //   150: ldc 17
    //   152: iconst_2
    //   153: aload 4
    //   155: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload_2
    //   162: ifnull +26 -> 188
    //   165: aload_2
    //   166: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   169: return
    //   170: astore_1
    //   171: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +14 -> 188
    //   177: new 81	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   184: astore_2
    //   185: goto -118 -> 67
    //   188: return
    //   189: astore_3
    //   190: aload_1
    //   191: astore_2
    //   192: aload_3
    //   193: astore_1
    //   194: aload_2
    //   195: ifnull +51 -> 246
    //   198: aload_2
    //   199: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   202: goto +44 -> 246
    //   205: astore_2
    //   206: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +37 -> 246
    //   212: new 81	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   219: astore_3
    //   220: aload_3
    //   221: ldc 187
    //   223: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_3
    //   228: aload_2
    //   229: invokevirtual 161	java/io/IOException:toString	()Ljava/lang/String;
    //   232: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: ldc 17
    //   238: iconst_2
    //   239: aload_3
    //   240: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: goto +5 -> 251
    //   249: aload_1
    //   250: athrow
    //   251: goto -2 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	ImportantMsgItem
    //   22	17	1	localObject1	java.lang.Object
    //   52	24	1	localIOException1	java.io.IOException
    //   98	1	1	localObject2	java.lang.Object
    //   108	42	1	localObject3	java.lang.Object
    //   170	21	1	localIOException2	java.io.IOException
    //   193	57	1	localObject4	java.lang.Object
    //   20	179	2	localObject5	java.lang.Object
    //   205	24	2	localIOException3	java.io.IOException
    //   11	30	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   94	1	3	localIOException4	java.io.IOException
    //   104	37	3	localIOException5	java.io.IOException
    //   189	4	3	localObject6	java.lang.Object
    //   219	21	3	localStringBuilder1	StringBuilder
    //   124	30	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   47	51	52	java/io/IOException
    //   23	31	94	java/io/IOException
    //   33	37	94	java/io/IOException
    //   39	47	94	java/io/IOException
    //   4	21	98	finally
    //   4	21	104	java/io/IOException
    //   165	169	170	java/io/IOException
    //   23	31	189	finally
    //   33	37	189	finally
    //   39	47	189	finally
    //   109	115	189	finally
    //   117	126	189	finally
    //   128	136	189	finally
    //   138	148	189	finally
    //   150	161	189	finally
    //   198	202	205	java/io/IOException
  }
  
  public boolean setMsgInfos(ArrayList<ImportantMsgItem.MsgInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    this.msgInfoList.clear();
    this.msgInfoList.addAll(paramArrayList);
    sortAndlimitMsgInfoList();
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopUin");
    localStringBuilder.append("=");
    localStringBuilder.append(this.troopUin);
    localStringBuilder.append(", msgInfo");
    localStringBuilder.append("=");
    localStringBuilder.append(this.msgInfoList.toString());
    localStringBuilder.append(", maxImportantMsgSeq");
    localStringBuilder.append("=");
    localStringBuilder.append(this.maxImportantMsgSeq);
    return localStringBuilder.toString();
  }
  
  public void updateMaxMsgSeq()
  {
    if (this.msgInfoList.size() > 0) {
      this.maxImportantMsgSeq = ((ImportantMsgItem.MsgInfo)this.msgInfoList.get(0)).msgSeq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem
 * JD-Core Version:    0.7.0.1
 */