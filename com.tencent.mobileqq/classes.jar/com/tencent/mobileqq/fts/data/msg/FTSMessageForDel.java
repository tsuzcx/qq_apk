package com.tencent.mobileqq.fts.data.msg;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FTSMessageForDel
  extends FTSMessage
{
  public static final int MODE_DEL_ALL = 3;
  public static final int MODE_DEL_ENTIRE_CONTENT = 4;
  public static final int MODE_DEL_ONE = 1;
  public static final int MODE_DEL_PATCH = 2;
  private static final String TAG = "FTSMessageForDel";
  public String mExt1Key;
  private ArrayList<String> mOIdList = new ArrayList(30);
  public int mode = 1;
  
  private String createDelForEntire()
  {
    try
    {
      String str = "DELETE FROM IndexContent;";
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FTSMessageForDel", 2, "createDeleteSQL failure: ", localThrowable);
      }
    }
    return null;
  }
  
  private String createDelForOne()
  {
    try
    {
      Object localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append("DELETE FROM IndexContent WHERE IndexContent MATCH 'ext1:");
      ((StringBuilder)localObject).append(this.mExt1Key);
      ((StringBuilder)localObject).append(" oid:");
      int i = 0;
      while (i < this.mOIdList.size())
      {
        if (i > 0) {
          ((StringBuilder)localObject).append(" OR ");
        }
        ((StringBuilder)localObject).append((String)this.mOIdList.get(i));
        i += 1;
      }
      ((StringBuilder)localObject).append("';");
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FTSMessageForDel", 2, "createDeleteSQL failure: ", localThrowable);
      }
    }
    return null;
  }
  
  private String createDelForPatch()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    String str = getExt1(this.uin, this.istroop);
    localStringBuilder.append("DELETE FROM IndexContent WHERE IndexContent MATCH 'ext4:");
    localStringBuilder.append(this.msgCounter);
    localStringBuilder.append(" ext1:");
    localStringBuilder.append(str);
    localStringBuilder.append("';");
    return localStringBuilder.toString();
  }
  
  public void appendOId(FTSMessageDelete paramFTSMessageDelete)
  {
    this.mOIdList.add(String.valueOf(paramFTSMessageDelete.mOId));
  }
  
  public String createDeleteSQL()
  {
    int i = this.mode;
    if (i == 2) {
      return createDelForPatch();
    }
    if (i == 4) {
      return createDelForEntire();
    }
    return createDelForOne();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.data.msg.FTSMessageForDel
 * JD-Core Version:    0.7.0.1
 */