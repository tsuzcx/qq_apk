package com.tencent.mobileqq.data.fts;

import android.text.TextUtils;
import bbbr;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.MsgExts;
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
  public long msgCounter;
  public FTSMessageCodec.MsgExts msgExts;
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
    return String.valueOf(paramLong) + "ZzZ" + String.valueOf(paramInt);
  }
  
  public String createDeleteSQL()
  {
    label306:
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("DELETE FROM IndexContent WHERE IndexContent MATCH 'type:");
        localStringBuilder.append(this.mType);
        if (this.mOId != -9223372036854775808L)
        {
          localStringBuilder.append(" oid:");
          localStringBuilder.append(this.mOId);
        }
        localStringBuilder.append(" ext1:");
        localStringBuilder.append(getExt1(this.uin, this.istroop));
        localStringBuilder.append("';");
        if (QLog.isColorLevel())
        {
          if (this.mOId == -9223372036854775808L) {
            break label306;
          }
          if (!TextUtils.isEmpty(this.mContent)) {
            QLog.i("Q.fts.FTSMessage", 2, "FTS delete：FTSMessage Info [oId = " + this.mOId + ", selfUin&istroop = " + this.mExt1 + ", msgType = " + this.mExt3 + ", senderUin = " + this.mExt2 + ", msg|size = " + this.mContent.charAt(0) + "|" + this.mContent.length() + "]");
          }
        }
        else
        {
          return localStringBuilder.toString();
        }
        QLog.i("Q.fts.FTSMessage", 2, "FTS delete：FTSMessage Info [oId = " + this.mOId + ", selfUin&istroop = " + this.mExt1 + ", msgType = " + this.mExt3 + ", senderUin = " + this.mExt2 + "]");
        continue;
        QLog.i("Q.fts.FTSMessage", 2, "FTS delete：FTSTable Info [oId = " + this.mOId + ", selfUin&istroop = " + this.mExt1 + "]");
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.FTSMessage", 2, "createDeleteSQL failure: ", localThrowable);
        }
        return null;
      }
    }
  }
  
  public String createInsertSQL()
  {
    return String.format("FTSMessage Info [oId = %d, selfUin&istroop = %s, msgType = %s, senderUin = %s, msg|size = %s]", new Object[] { Long.valueOf(this.mOId), this.mExt1, this.mExt3, this.mExt2, bbbr.a(this.mContent) });
  }
  
  public String createUpdateSQL()
  {
    return createDeleteSQL();
  }
  
  public void doDeserialize()
  {
    int i = this.mExt1.indexOf("ZzZ");
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSMessage", 2, "doDeserialize: failure, ext1 not valid");
      }
    }
    for (;;)
    {
      return;
      try
      {
        this.uin = Long.parseLong(this.mExt1.substring(0, i));
        this.istroop = Integer.parseInt(this.mExt1.substring(i + 3));
        try
        {
          this.senderuin = this.mExt2;
          this.msgtype = Integer.parseInt(this.mExt3);
          if ((this.mExts != null) && (this.mExts.length > 0))
          {
            this.msgExts = ((FTSMessageCodec.MsgExts)FTSMessageCodec.a(this.mExts, 1));
            if (TextUtils.isEmpty(this.mExt4)) {
              continue;
            }
            this.msgCounter = Long.parseLong(this.mExt4);
            return;
          }
        }
        catch (Exception localException1)
        {
          QLog.e("Q.fts.FTSMessage", 1, new Object[] { "FTSMessage doDeserialize e:", localException1.toString() });
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          if (QLog.isColorLevel())
          {
            QLog.e("Q.fts.FTSMessage", 2, "doDeserialize: failure", localException2);
            continue;
            this.msgExts = null;
          }
        }
      }
    }
  }
  
  public void doSerialize()
  {
    this.mExt1 = getExt1(this.uin, this.istroop);
    this.mExt2 = this.senderuin;
    this.mExt3 = String.valueOf(this.msgtype);
    if (this.msgExts != null) {
      this.mExts = FTSMessageCodec.a(this.msgExts, 1);
    }
    for (;;)
    {
      this.mExt4 = String.valueOf(this.msgCounter);
      return;
      this.msgExts = null;
    }
  }
  
  public String getTableName()
  {
    return "IndexContent";
  }
  
  public String toString()
  {
    return "FTSMessage{uin=" + this.uin + ", istroop=" + this.istroop + ", senderuin='" + this.senderuin + ", msgtype=" + this.msgtype + ", proximity=" + this.mProximity + ", msgExts=" + this.msgExts + '}';
  }
  
  public int type()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.fts.FTSMessage
 * JD-Core Version:    0.7.0.1
 */