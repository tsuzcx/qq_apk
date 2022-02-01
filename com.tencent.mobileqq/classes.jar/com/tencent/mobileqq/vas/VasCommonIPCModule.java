package com.tencent.mobileqq.vas;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.config.business.qvip.QQFriendRelation2Config;
import com.tencent.mobileqq.config.business.qvip.QQFriendRelation2Processor;
import com.tencent.mobileqq.mutualmark.alienation.RelationVipHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class VasCommonIPCModule
  extends QIPCModule
{
  private static VasCommonIPCModule a;
  
  private VasCommonIPCModule(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public static VasCommonIPCModule a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	com/tencent/mobileqq/vas/VasCommonIPCModule:a	Lcom/tencent/mobileqq/vas/VasCommonIPCModule;
    //   6: ifnonnull +27 -> 33
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 14	com/tencent/mobileqq/vas/VasCommonIPCModule:a	Lcom/tencent/mobileqq/vas/VasCommonIPCModule;
    //   15: ifnonnull +15 -> 30
    //   18: new 2	com/tencent/mobileqq/vas/VasCommonIPCModule
    //   21: dup
    //   22: ldc 16
    //   24: invokespecial 17	com/tencent/mobileqq/vas/VasCommonIPCModule:<init>	(Ljava/lang/String;)V
    //   27: putstatic 14	com/tencent/mobileqq/vas/VasCommonIPCModule:a	Lcom/tencent/mobileqq/vas/VasCommonIPCModule;
    //   30: ldc 2
    //   32: monitorexit
    //   33: getstatic 14	com/tencent/mobileqq/vas/VasCommonIPCModule:a	Lcom/tencent/mobileqq/vas/VasCommonIPCModule;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	5	0	localVasCommonIPCModule	VasCommonIPCModule
    //   42	5	0	localObject1	java.lang.Object
    //   48	5	0	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   12	30	42	finally
    //   30	33	42	finally
    //   43	46	42	finally
    //   3	12	48	finally
    //   33	37	48	finally
    //   46	48	48	finally
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    int i;
    boolean bool;
    if ("is_white_name".equals(paramString))
    {
      i = paramBundle.getInt("managerId", -1);
      if (i == 490)
      {
        bool = RelationVipHelper.a().a();
        paramString = new Bundle();
        paramString.putBoolean("isWhiteName", bool);
        paramString = EIPCResult.createSuccessResult(paramString);
      }
    }
    for (;;)
    {
      callbackResult(paramInt, paramString);
      return null;
      if (i == 491)
      {
        bool = QQFriendRelation2Processor.c().mIsEnable;
        paramString = new Bundle();
        paramString.putBoolean("isWhiteName", bool);
        paramString = EIPCResult.createSuccessResult(paramString);
      }
      else
      {
        paramString = EIPCResult.createResult(-1, new Bundle());
        continue;
        if ("paySuccess".equals(paramString))
        {
          ((VipInfoHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).notifyUI(5, true, paramBundle);
          paramString = EIPCResult.createResult(0, null);
        }
        else
        {
          paramString = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasCommonIPCModule
 * JD-Core Version:    0.7.0.1
 */