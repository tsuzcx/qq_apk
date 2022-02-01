package com.tencent.mobileqq.fts.data.msg;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.MsgExts;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;

public class FTSMessage
  extends FTSEntity
{
  public static final int FTS_TYPE_MSG_2 = 1;
  private static final String TAG = "Q.fts.FTSMessage";
  public int friendIndex = -1;
  public int friendNum = -1;
  public int istroop;
  public CharSequence matchSecondTitle;
  public CharSequence matchTitle;
  public long msgCounter = 0L;
  public MsgExts msgExts;
  public int msgtype;
  public int searchStrategy = -1;
  public int senderNum = -1;
  public String senderuin;
  public long uin;
  
  public FTSMessage() {}
  
  public FTSMessage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, byte[] paramArrayOfByte)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramLong, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramArrayOfByte);
  }
  
  public FTSMessage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramLong, paramString2, paramString3, paramString4, paramArrayOfByte);
  }
  
  public FTSMessage(int paramInt, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    super(paramInt, paramString1, paramLong, paramString2, paramString3, paramString4, paramArrayOfByte);
  }
  
  public static String getExt1(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong));
    localStringBuilder.append("ZzZ");
    localStringBuilder.append(String.valueOf(paramInt));
    return localStringBuilder.toString();
  }
  
  public String createDeleteSQL()
  {
    try
    {
      Object localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append("DELETE FROM IndexContent WHERE IndexContent MATCH 'type:");
      ((StringBuilder)localObject).append(this.mType);
      if (this.mOId != -9223372036854775808L)
      {
        ((StringBuilder)localObject).append(" oid:");
        ((StringBuilder)localObject).append(this.mOId);
      }
      ((StringBuilder)localObject).append(" ext1:");
      ((StringBuilder)localObject).append(getExt1(this.uin, this.istroop));
      ((StringBuilder)localObject).append("';");
      if (QLog.isColorLevel())
      {
        long l = this.mOId;
        StringBuilder localStringBuilder;
        if (l != -9223372036854775808L)
        {
          boolean bool = TextUtils.isEmpty(this.mContent);
          if (!bool)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("FTS delete：FTSMessage Info [oId = ");
            localStringBuilder.append(this.mOId);
            localStringBuilder.append(", selfUin&istroop = ");
            localStringBuilder.append(this.mExt1);
            localStringBuilder.append(", msgType = ");
            localStringBuilder.append(this.mExt3);
            localStringBuilder.append(", senderUin = ");
            localStringBuilder.append(this.mExt2);
            localStringBuilder.append(", msg|size = ");
            localStringBuilder.append(this.mContent.charAt(0));
            localStringBuilder.append("|");
            localStringBuilder.append(this.mContent.length());
            localStringBuilder.append("]");
            QLog.i("Q.fts.FTSMessage", 2, localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("FTS delete：FTSMessage Info [oId = ");
            localStringBuilder.append(this.mOId);
            localStringBuilder.append(", selfUin&istroop = ");
            localStringBuilder.append(this.mExt1);
            localStringBuilder.append(", msgType = ");
            localStringBuilder.append(this.mExt3);
            localStringBuilder.append(", senderUin = ");
            localStringBuilder.append(this.mExt2);
            localStringBuilder.append("]");
            QLog.i("Q.fts.FTSMessage", 2, localStringBuilder.toString());
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("FTS delete：FTSTable Info [oId = ");
          localStringBuilder.append(this.mOId);
          localStringBuilder.append(", selfUin&istroop = ");
          localStringBuilder.append(this.mExt1);
          localStringBuilder.append("]");
          QLog.i("Q.fts.FTSMessage", 2, localStringBuilder.toString());
        }
      }
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSMessage", 2, "createDeleteSQL failure: ", localThrowable);
      }
    }
    return null;
  }
  
  public String createInsertSQL()
  {
    return String.format("FTSMessage Info [oId = %d, selfUin&istroop = %s, msgType = %s, senderUin = %s, msg|size = %s]", new Object[] { Long.valueOf(this.mOId), this.mExt1, this.mExt3, this.mExt2, MessageRecordUtil.a(this.mContent) });
  }
  
  public String createUpdateSQL()
  {
    return createDeleteSQL();
  }
  
  protected void doDeserialize()
  {
    int i = this.mExt1.indexOf("ZzZ");
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSMessage", 2, "doDeserialize: failure, ext1 not valid");
      }
      return;
    }
    try
    {
      this.uin = Long.parseLong(this.mExt1.substring(0, i));
      this.istroop = Integer.parseInt(this.mExt1.substring(i + 3));
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSMessage", 2, "doDeserialize: failure", localException1);
      }
    }
    try
    {
      this.senderuin = this.mExt2;
      this.msgtype = Integer.parseInt(this.mExt3);
      if ((this.mExts != null) && (this.mExts.length > 0)) {
        this.msgExts = ((MsgExts)MsgExts.unserialize(this.mExts, 1));
      } else {
        this.msgExts = null;
      }
      if (!TextUtils.isEmpty(this.mExt4))
      {
        this.msgCounter = Long.parseLong(this.mExt4);
        return;
      }
    }
    catch (Exception localException2)
    {
      QLog.e("Q.fts.FTSMessage", 1, new Object[] { "FTSMessage doDeserialize e:", localException2.toString() });
    }
  }
  
  protected void doSerialize()
  {
    this.mExt1 = getExt1(this.uin, this.istroop);
    this.mExt2 = this.senderuin;
    this.mExt3 = String.valueOf(this.msgtype);
    MsgExts localMsgExts = this.msgExts;
    if (localMsgExts != null) {
      this.mExts = MsgExts.serialize(localMsgExts, 1);
    } else {
      this.msgExts = null;
    }
    this.mExt4 = String.valueOf(this.msgCounter);
  }
  
  public String getTableName()
  {
    return "IndexContent";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FTSMessage{uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", istroop=");
    localStringBuilder.append(this.istroop);
    localStringBuilder.append(", senderuin='");
    localStringBuilder.append(this.senderuin);
    localStringBuilder.append(", msgtype=");
    localStringBuilder.append(this.msgtype);
    localStringBuilder.append(", proximity=");
    localStringBuilder.append(this.mProximity);
    localStringBuilder.append(", msgExts=");
    localStringBuilder.append(this.msgExts);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public int type()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.data.msg.FTSMessage
 * JD-Core Version:    0.7.0.1
 */