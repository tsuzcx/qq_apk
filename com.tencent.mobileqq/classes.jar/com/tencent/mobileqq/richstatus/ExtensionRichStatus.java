package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.friend.IExtensionBusinessData;

public class ExtensionRichStatus
  implements IExtensionBusinessData
{
  public RichStatus a;
  
  public static RichStatus a(ExtensionInfo paramExtensionInfo, boolean paramBoolean)
  {
    if (paramExtensionInfo == null) {
      return null;
    }
    if ((paramExtensionInfo.richTime > 0L) && (paramBoolean)) {
      return RichStatus.getEmptyStatus();
    }
    paramExtensionInfo = (ExtensionRichStatus)paramExtensionInfo.getBusinessData(ExtensionRichStatus.class, new Object[0]);
    if (paramExtensionInfo != null) {
      return paramExtensionInfo.a;
    }
    return null;
  }
  
  public static void a(ExtensionInfo paramExtensionInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramExtensionInfo == null) {
      return;
    }
    paramExtensionInfo.richBuffer = paramArrayOfByte;
    paramExtensionInfo.richTime = paramLong;
    paramExtensionInfo.isAdded2C2C = false;
    ((ExtensionRichStatus)paramExtensionInfo.getBusinessData(ExtensionRichStatus.class, new Object[0])).a = null;
  }
  
  public static RichStatus c(ExtensionInfo paramExtensionInfo)
  {
    return a(paramExtensionInfo, false);
  }
  
  public void a(ExtensionInfo paramExtensionInfo) {}
  
  public void a(ExtensionInfo paramExtensionInfo, Object... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVarArgs != null)
    {
      bool1 = bool2;
      if (paramVarArgs.length == 1)
      {
        bool1 = bool2;
        if ((paramVarArgs[0] instanceof Boolean)) {
          bool1 = ((Boolean)paramVarArgs[0]).booleanValue();
        }
      }
    }
    if (this.a == null)
    {
      if ((paramExtensionInfo.richTime > 0L) && (bool1)) {
        return;
      }
      if (paramExtensionInfo.richTime > 0L)
      {
        this.a = RichStatus.parseStatus(paramExtensionInfo.richBuffer);
        this.a.time = paramExtensionInfo.richTime;
        return;
      }
      this.a = new RichStatus(null);
    }
  }
  
  public void b(ExtensionInfo paramExtensionInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ExtensionRichStatus
 * JD-Core Version:    0.7.0.1
 */