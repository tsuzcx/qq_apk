package com.tencent.mobileqq.gamecenter.gameBuddy;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class GameBuddyModule
  extends QIPCModule
{
  public static GameBuddyModule a;
  
  public GameBuddyModule()
  {
    super("module_game_buddy");
  }
  
  /* Error */
  public static GameBuddyModule a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/tencent/mobileqq/gamecenter/gameBuddy/GameBuddyModule:a	Lcom/tencent/mobileqq/gamecenter/gameBuddy/GameBuddyModule;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 17	com/tencent/mobileqq/gamecenter/gameBuddy/GameBuddyModule:a	Lcom/tencent/mobileqq/gamecenter/gameBuddy/GameBuddyModule;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/mobileqq/gamecenter/gameBuddy/GameBuddyModule
    //   21: dup
    //   22: invokespecial 19	com/tencent/mobileqq/gamecenter/gameBuddy/GameBuddyModule:<init>	()V
    //   25: putstatic 17	com/tencent/mobileqq/gamecenter/gameBuddy/GameBuddyModule:a	Lcom/tencent/mobileqq/gamecenter/gameBuddy/GameBuddyModule;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 17	com/tencent/mobileqq/gamecenter/gameBuddy/GameBuddyModule:a	Lcom/tencent/mobileqq/gamecenter/gameBuddy/GameBuddyModule;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localGameBuddyModule	GameBuddyModule
    //   40	5	0	localObject1	java.lang.Object
    //   46	5	0	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("module_game_buddy", 2, "action = " + paramString + ", params = " + paramBundle + ",callbackId=" + paramInt);
    }
    if ("action_check_aio_type".equals(paramString))
    {
      paramString = paramBundle.getString("uin_value");
      paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramBundle == null) {
        break label140;
      }
      paramBundle = (FriendsManager)paramBundle.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((paramBundle == null) || (TextUtils.isEmpty(paramString)) || (!paramBundle.b(paramString))) {
        break label148;
      }
    }
    label140:
    label148:
    for (int i = 0;; i = 10009)
    {
      paramString = new Bundle();
      paramString.putInt("uin_type", i);
      callbackResult(paramInt, EIPCResult.createResult(0, paramString));
      return null;
      QLog.w("module_game_buddy", 1, "app is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.gameBuddy.GameBuddyModule
 * JD-Core Version:    0.7.0.1
 */