package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowTimeItem;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="channelId")
@KeepClassConstructor
public class GuildMsgSeqTimeItem
  extends Entity
{
  private static final String TAG = "GuildMsgSeqTimeItem";
  public String channelId;
  public byte[] decreaseMsgSeqBytes = null;
  @notColumn
  public HashSet<DecreaseMsgSeqInfo> decreaseMsgSeqList = new HashSet();
  @notColumn
  public GuildEventFlowTimeItem eventFlowTimeItem = new GuildEventFlowTimeItem();
  public byte[] eventFlowTimeItemBytes = null;
  public long expiredMsgSeq = 0L;
  public String guildId;
  public long lastLocalCntSeq = -1L;
  public byte[] lastLocalMsgMeta = null;
  public long lastLocalMsgSeq = -1L;
  public long lastLocalMsgTime = 0L;
  public long lastLocalVisibleCntSeq = -1L;
  public byte[] lastLocalVisibleMsgMeta = null;
  public long lastLocalVisibleMsgSeq = -1L;
  public long lastLocalVisibleMsgTime = 0L;
  public long lastSvrCntSeq = -1L;
  public byte[] lastSvrMsgMeta = null;
  public long lastSvrMsgSeq = -1L;
  public long lastSvrMsgTime = 0L;
  public long readedCntSeq = -1L;
  public byte[] readedMsgMeta = null;
  public long readedMsgSeq = -1L;
  public long readedMsgTime = 0L;
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        paramCloseable.printStackTrace();
      }
    }
  }
  
  public static void closeQuietly(ObjectOutputStream paramObjectOutputStream)
  {
    if (paramObjectOutputStream != null) {
      try
      {
        paramObjectOutputStream.close();
        return;
      }
      catch (IOException paramObjectOutputStream)
      {
        paramObjectOutputStream.printStackTrace();
      }
    }
  }
  
  /* Error */
  @androidx.annotation.Nullable
  public static Object deserialize(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 121	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 124	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore 4
    //   16: new 126	java/io/ObjectInputStream
    //   19: dup
    //   20: aload 4
    //   22: invokespecial 129	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_1
    //   29: invokevirtual 133	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_1
    //   34: invokestatic 135	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/Closeable;)V
    //   37: aload 4
    //   39: invokestatic 135	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/Closeable;)V
    //   42: aload_2
    //   43: areturn
    //   44: astore_3
    //   45: goto +16 -> 61
    //   48: astore_3
    //   49: goto +38 -> 87
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_0
    //   55: goto +67 -> 122
    //   58: astore_3
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: astore_2
    //   63: aload_1
    //   64: astore_0
    //   65: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +42 -> 110
    //   71: aload_1
    //   72: astore_0
    //   73: ldc 15
    //   75: iconst_2
    //   76: ldc 143
    //   78: aload_3
    //   79: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_1
    //   83: astore_2
    //   84: goto +26 -> 110
    //   87: aload_1
    //   88: astore_2
    //   89: aload_1
    //   90: astore_0
    //   91: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +16 -> 110
    //   97: aload_1
    //   98: astore_0
    //   99: ldc 15
    //   101: iconst_2
    //   102: ldc 143
    //   104: aload_3
    //   105: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_1
    //   109: astore_2
    //   110: aload_2
    //   111: invokestatic 135	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/Closeable;)V
    //   114: aload 4
    //   116: invokestatic 135	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/Closeable;)V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_1
    //   122: aload_0
    //   123: invokestatic 135	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/Closeable;)V
    //   126: aload 4
    //   128: invokestatic 135	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/Closeable;)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_1
    //   136: goto -49 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramArrayOfByte	byte[]
    //   25	9	1	localObjectInputStream	java.io.ObjectInputStream
    //   52	1	1	localObject1	Object
    //   60	49	1	localObject2	Object
    //   121	11	1	localObject3	Object
    //   135	1	1	localObject4	Object
    //   32	79	2	localObject5	Object
    //   44	1	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   48	1	3	localIOException1	IOException
    //   58	47	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   133	1	3	localIOException2	IOException
    //   14	113	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   28	33	44	java/lang/ClassNotFoundException
    //   28	33	48	java/io/IOException
    //   16	26	52	finally
    //   16	26	58	java/lang/ClassNotFoundException
    //   28	33	121	finally
    //   65	71	121	finally
    //   73	82	121	finally
    //   91	97	121	finally
    //   99	108	121	finally
    //   16	26	133	java/io/IOException
  }
  
  private void onPostReadDecreaseMsgSeqList()
  {
    Object localObject = this.decreaseMsgSeqBytes;
    if (localObject != null)
    {
      localObject = deserialize((byte[])localObject);
      if ((localObject instanceof HashSet)) {
        this.decreaseMsgSeqList = ((HashSet)localObject);
      }
    }
  }
  
  private void onPostReadEventFlowTimeItem()
  {
    Object localObject = this.eventFlowTimeItemBytes;
    if (localObject != null)
    {
      localObject = deserialize((byte[])localObject);
      if ((localObject instanceof GuildEventFlowTimeItem)) {
        this.eventFlowTimeItem = ((GuildEventFlowTimeItem)localObject);
      }
    }
  }
  
  private void onPrewriteDecreaseMsgSeqList()
  {
    HashSet localHashSet = this.decreaseMsgSeqList;
    if ((localHashSet != null) && (localHashSet.size() != 0))
    {
      this.decreaseMsgSeqBytes = serialize(this.decreaseMsgSeqList);
      return;
    }
    this.decreaseMsgSeqBytes = null;
  }
  
  private void onPrewriteEventFlowTimeItem()
  {
    this.eventFlowTimeItemBytes = serialize(this.eventFlowTimeItem);
  }
  
  /* Error */
  @androidx.annotation.Nullable
  public static byte[] serialize(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 164	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 1024
    //   13: invokespecial 167	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore_3
    //   17: new 113	java/io/ObjectOutputStream
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 170	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: aload_0
    //   30: invokevirtual 174	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 177	java/io/ObjectOutputStream:flush	()V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_3
    //   42: invokevirtual 181	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   45: astore_0
    //   46: aload_2
    //   47: invokestatic 183	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/ObjectOutputStream;)V
    //   50: aload_3
    //   51: invokestatic 135	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/Closeable;)V
    //   54: aload_0
    //   55: areturn
    //   56: astore_1
    //   57: aload_2
    //   58: astore_0
    //   59: aload_1
    //   60: astore_2
    //   61: goto +12 -> 73
    //   64: astore_0
    //   65: aconst_null
    //   66: astore_1
    //   67: goto +36 -> 103
    //   70: astore_2
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: astore_1
    //   75: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +14 -> 92
    //   81: aload_0
    //   82: astore_1
    //   83: ldc 15
    //   85: iconst_2
    //   86: ldc 185
    //   88: aload_2
    //   89: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: invokestatic 183	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/ObjectOutputStream;)V
    //   96: aload_3
    //   97: invokestatic 135	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/Closeable;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aload_1
    //   104: invokestatic 183	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/ObjectOutputStream;)V
    //   107: aload_3
    //   108: invokestatic 135	com/tencent/mobileqq/guild/message/GuildMsgSeqTimeItem:closeQuietly	(Ljava/io/Closeable;)V
    //   111: aload_0
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramObject	Object
    //   27	14	1	localObject1	Object
    //   56	4	1	localIOException1	IOException
    //   66	38	1	localObject2	Object
    //   25	36	2	localObject3	Object
    //   70	19	2	localIOException2	IOException
    //   16	92	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   28	33	56	java/io/IOException
    //   35	39	56	java/io/IOException
    //   41	46	56	java/io/IOException
    //   17	26	64	finally
    //   17	26	70	java/io/IOException
    //   28	33	102	finally
    //   35	39	102	finally
    //   41	46	102	finally
    //   75	81	102	finally
    //   83	92	102	finally
  }
  
  protected void postRead()
  {
    onPostReadDecreaseMsgSeqList();
    onPostReadEventFlowTimeItem();
  }
  
  protected void prewrite()
  {
    onPrewriteDecreaseMsgSeqList();
    onPrewriteEventFlowTimeItem();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId:");
    localStringBuilder.append(this.guildId);
    localStringBuilder.append(" ");
    localStringBuilder.append("channelId:");
    localStringBuilder.append(this.channelId);
    localStringBuilder.append(" ");
    localStringBuilder.append("lastLocalMsgSeq:");
    localStringBuilder.append(this.lastLocalMsgSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("lastLocalCntSeq:");
    localStringBuilder.append(this.lastLocalCntSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("lastLocalMsgTime:");
    localStringBuilder.append(this.lastLocalMsgTime);
    localStringBuilder.append(" ");
    localStringBuilder.append("lastSvrMsgSeq:");
    localStringBuilder.append(this.lastSvrMsgSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("lastSvrCntSeq:");
    localStringBuilder.append(this.lastSvrCntSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("lastSvrMsgTime:");
    localStringBuilder.append(this.lastSvrMsgTime);
    localStringBuilder.append(" ");
    localStringBuilder.append("readedMsgSeq:");
    localStringBuilder.append(this.readedMsgSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("readedCntSeq:");
    localStringBuilder.append(this.readedCntSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("readedMsgTime:");
    localStringBuilder.append(this.readedMsgTime);
    localStringBuilder.append(" ");
    localStringBuilder.append("lastLocalVisibleMsgSeq:");
    localStringBuilder.append(this.lastLocalVisibleMsgSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("lastLocalVisibleCntSeq:");
    localStringBuilder.append(this.lastLocalVisibleCntSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("lastLocalVisibleMsgTime:");
    localStringBuilder.append(this.lastLocalVisibleMsgTime);
    localStringBuilder.append(" ");
    localStringBuilder.append("expiredMsgSeq:");
    localStringBuilder.append(this.expiredMsgSeq);
    localStringBuilder.append(" ");
    localStringBuilder.append("decreaseMsgSeqList:");
    localStringBuilder.append(this.decreaseMsgSeqList.toString());
    localStringBuilder.append(" ");
    localStringBuilder.append("eventFlowTimeItem:");
    localStringBuilder.append(this.eventFlowTimeItem.toString());
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildMsgSeqTimeItem
 * JD-Core Version:    0.7.0.1
 */