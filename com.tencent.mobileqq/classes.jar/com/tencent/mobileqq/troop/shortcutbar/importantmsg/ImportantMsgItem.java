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
    int k = 0;
    Collections.sort(this.msgInfoList, Collections.reverseOrder());
    if (this.msgInfoList.size() > 20)
    {
      Iterator localIterator = this.msgInfoList.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        k += 1;
        ImportantMsgItem.MsgInfo localMsgInfo = (ImportantMsgItem.MsgInfo)localIterator.next();
        int j = i;
        if (localMsgInfo.msgNeedShow) {
          j = i + 1;
        }
        if (k > 20)
        {
          if (localMsgInfo.msgNeedShow) {
            break label136;
          }
          if (QLog.isColorLevel()) {
            QLog.e("ImportantMsgItem", 2, "sortAndlimitMsgInfoList remove seq:" + localMsgInfo.msgSeq);
          }
          localIterator.remove();
        }
        for (;;)
        {
          i = j;
          break;
          label136:
          if (j > 20)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ImportantMsgItem", 2, "sortAndlimitMsgInfoList remove seq:" + localMsgInfo.msgSeq);
            }
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public boolean addMsgInfo(ImportantMsgItem.MsgInfo paramMsgInfo)
  {
    if (paramMsgInfo == null) {}
    while (this.msgInfoList.contains(paramMsgInfo)) {
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
  public void postRead()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 139	com/tencent/mobileqq/persistence/Entity:postRead	()V
    //   4: aload_0
    //   5: getfield 141	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoData	[B
    //   8: ifnull +11 -> 19
    //   11: aload_0
    //   12: getfield 141	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoData	[B
    //   15: arraylength
    //   16: ifne +4 -> 20
    //   19: return
    //   20: new 143	java/io/ObjectInputStream
    //   23: dup
    //   24: new 145	java/io/ByteArrayInputStream
    //   27: dup
    //   28: aload_0
    //   29: getfield 141	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoData	[B
    //   32: invokespecial 148	java/io/ByteArrayInputStream:<init>	([B)V
    //   35: invokespecial 151	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 154	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   45: astore_3
    //   46: aload_2
    //   47: astore_1
    //   48: aload_3
    //   49: instanceof 31
    //   52: ifeq +13 -> 65
    //   55: aload_2
    //   56: astore_1
    //   57: aload_0
    //   58: aload_3
    //   59: checkcast 31	java/util/ArrayList
    //   62: putfield 34	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoList	Ljava/util/ArrayList;
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 157	java/io/ObjectInputStream:close	()V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 141	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoData	[B
    //   78: return
    //   79: astore_1
    //   80: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq -10 -> 73
    //   86: ldc 17
    //   88: iconst_2
    //   89: new 81	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   96: ldc 159
    //   98: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_1
    //   102: invokevirtual 160	java/io/IOException:toString	()Ljava/lang/String;
    //   105: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: goto -41 -> 73
    //   117: astore_3
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_2
    //   121: astore_1
    //   122: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +33 -> 158
    //   128: aload_2
    //   129: astore_1
    //   130: ldc 17
    //   132: iconst_2
    //   133: new 81	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   140: ldc 159
    //   142: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_3
    //   146: invokevirtual 161	java/lang/Exception:toString	()Ljava/lang/String;
    //   149: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 157	java/io/ObjectInputStream:close	()V
    //   166: aload_0
    //   167: aconst_null
    //   168: putfield 141	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoData	[B
    //   171: return
    //   172: astore_1
    //   173: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq -10 -> 166
    //   179: ldc 17
    //   181: iconst_2
    //   182: new 81	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   189: ldc 159
    //   191: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_1
    //   195: invokevirtual 160	java/io/IOException:toString	()Ljava/lang/String;
    //   198: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -41 -> 166
    //   210: astore_2
    //   211: aconst_null
    //   212: astore_1
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 157	java/io/ObjectInputStream:close	()V
    //   221: aload_0
    //   222: aconst_null
    //   223: putfield 141	com/tencent/mobileqq/troop/shortcutbar/importantmsg/ImportantMsgItem:msgInfoData	[B
    //   226: aload_2
    //   227: athrow
    //   228: astore_1
    //   229: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq -11 -> 221
    //   235: ldc 17
    //   237: iconst_2
    //   238: new 81	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   245: ldc 159
    //   247: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_1
    //   251: invokevirtual 160	java/io/IOException:toString	()Ljava/lang/String;
    //   254: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto -42 -> 221
    //   266: astore_2
    //   267: goto -54 -> 213
    //   270: astore_3
    //   271: goto -151 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	ImportantMsgItem
    //   40	17	1	localObjectInputStream1	java.io.ObjectInputStream
    //   79	23	1	localIOException1	java.io.IOException
    //   121	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   172	23	1	localIOException2	java.io.IOException
    //   212	6	1	localObject1	java.lang.Object
    //   228	23	1	localIOException3	java.io.IOException
    //   38	125	2	localObjectInputStream3	java.io.ObjectInputStream
    //   210	17	2	localObject2	java.lang.Object
    //   266	1	2	localObject3	java.lang.Object
    //   45	14	3	localObject4	java.lang.Object
    //   117	29	3	localException1	java.lang.Exception
    //   270	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   69	73	79	java/io/IOException
    //   20	39	117	java/lang/Exception
    //   162	166	172	java/io/IOException
    //   20	39	210	finally
    //   217	221	228	java/io/IOException
    //   41	46	266	finally
    //   48	55	266	finally
    //   57	65	266	finally
    //   122	128	266	finally
    //   130	158	266	finally
    //   41	46	270	java/lang/Exception
    //   48	55	270	java/lang/Exception
    //   57	65	270	java/lang/Exception
  }
  
  public void postwrite()
  {
    if (this.msgInfoData != null) {
      this.msgInfoData = null;
    }
  }
  
  /* Error */
  public void prewrite()
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
    //   48: ifnull +7 -> 55
    //   51: aload_2
    //   52: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   55: return
    //   56: astore_1
    //   57: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq -5 -> 55
    //   63: ldc 17
    //   65: iconst_2
    //   66: new 81	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   73: ldc 187
    //   75: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 160	java/io/IOException:toString	()Ljava/lang/String;
    //   82: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: return
    //   92: astore_3
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_2
    //   96: astore_1
    //   97: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +33 -> 133
    //   103: aload_2
    //   104: astore_1
    //   105: ldc 17
    //   107: iconst_2
    //   108: new 81	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   115: ldc 187
    //   117: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_3
    //   121: invokevirtual 160	java/io/IOException:toString	()Ljava/lang/String;
    //   124: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_2
    //   134: ifnull -79 -> 55
    //   137: aload_2
    //   138: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   141: return
    //   142: astore_1
    //   143: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq -91 -> 55
    //   149: ldc 17
    //   151: iconst_2
    //   152: new 81	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   159: ldc 187
    //   161: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 160	java/io/IOException:toString	()Ljava/lang/String;
    //   168: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: return
    //   178: astore_2
    //   179: aconst_null
    //   180: astore_1
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   189: aload_2
    //   190: athrow
    //   191: astore_1
    //   192: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -6 -> 189
    //   198: ldc 17
    //   200: iconst_2
    //   201: new 81	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   208: ldc 187
    //   210: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_1
    //   214: invokevirtual 160	java/io/IOException:toString	()Ljava/lang/String;
    //   217: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: goto -37 -> 189
    //   229: astore_2
    //   230: goto -49 -> 181
    //   233: astore_3
    //   234: goto -139 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	ImportantMsgItem
    //   22	17	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   56	23	1	localIOException1	java.io.IOException
    //   96	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   142	23	1	localIOException2	java.io.IOException
    //   180	6	1	localObject1	java.lang.Object
    //   191	23	1	localIOException3	java.io.IOException
    //   20	118	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   178	12	2	localObject2	java.lang.Object
    //   229	1	2	localObject3	java.lang.Object
    //   11	30	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   92	29	3	localIOException4	java.io.IOException
    //   233	1	3	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   51	55	56	java/io/IOException
    //   4	21	92	java/io/IOException
    //   137	141	142	java/io/IOException
    //   4	21	178	finally
    //   185	189	191	java/io/IOException
    //   23	31	229	finally
    //   33	37	229	finally
    //   39	47	229	finally
    //   97	103	229	finally
    //   105	133	229	finally
    //   23	31	233	java/io/IOException
    //   33	37	233	java/io/IOException
    //   39	47	233	java/io/IOException
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
    localStringBuilder.append("troopUin").append("=").append(this.troopUin);
    localStringBuilder.append(", msgInfo").append("=").append(this.msgInfoList.toString());
    localStringBuilder.append(", maxImportantMsgSeq").append("=").append(this.maxImportantMsgSeq);
    return localStringBuilder.toString();
  }
  
  public void updateMaxMsgSeq()
  {
    if (this.msgInfoList.size() > 0) {
      this.maxImportantMsgSeq = ((ImportantMsgItem.MsgInfo)this.msgInfoList.get(0)).msgSeq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem
 * JD-Core Version:    0.7.0.1
 */