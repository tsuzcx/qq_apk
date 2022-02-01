package com.tencent.mobileqq.emoticonview.ipc;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class EmoticonMainPanelChildIpcModule
  extends QIPCModule
{
  public static final String NAME = "module_emoticon_child_mainpanel";
  public static final String OTHER_PROCESS_CALLBACK = "other_process_callback";
  public static final String OTHER_RIGISTER_CALLBACK = "other_rigister_callback";
  public static final String PARAMTER_FOUR = "paramter_four";
  public static final String PARAMTER_ONE = "paramter_one";
  public static final String PARAMTER_THREE = "paramter_three";
  public static final String PARAMTER_TWO = "paramter_two";
  public static final String PROCESS_NAME = "process_name";
  public static final String TAG = "EmoticonMainPanelChildIpcModule";
  public static EmoticonMainPanelChildIpcModule mInstance;
  public String processName;
  
  public EmoticonMainPanelChildIpcModule()
  {
    super("module_emoticon_child_mainpanel");
  }
  
  /* Error */
  public static EmoticonMainPanelChildIpcModule getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 45	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelChildIpcModule:mInstance	Lcom/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelChildIpcModule;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 45	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelChildIpcModule:mInstance	Lcom/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelChildIpcModule;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelChildIpcModule
    //   21: dup
    //   22: invokespecial 47	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelChildIpcModule:<init>	()V
    //   25: putstatic 45	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelChildIpcModule:mInstance	Lcom/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelChildIpcModule;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 45	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelChildIpcModule:mInstance	Lcom/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelChildIpcModule;
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
    //   34	5	0	localEmoticonMainPanelChildIpcModule	EmoticonMainPanelChildIpcModule
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private EIPCResult otherProcessCallBack(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {
      return EIPCResult.createExceptionResult(new RuntimeException("params is null."));
    }
    paramBundle.setClassLoader(EmoticonPackage.class.getClassLoader());
    paramAppRuntime = paramBundle.getString("module_emoticon_child_mainpanel");
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanelChildIpcModule", 4, new Object[] { "name: ", paramAppRuntime });
    }
    if ("emojilistener_loadend".equals(paramAppRuntime)) {
      EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"), paramBundle.getBundle("paramter_three"));
    }
    for (;;)
    {
      return EIPCResult.createSuccessResult(null);
      if ("emojilistener_emoticonjson".equals(paramAppRuntime)) {
        EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"));
      } else if ("emojilistener_emoticoncover".equals(paramAppRuntime)) {
        EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"), paramBundle.getInt("paramter_three"), paramBundle.getInt("paramter_four"));
      } else if ("emojilistener_packagestart".equals(paramAppRuntime)) {
        EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"));
      } else if ("emojilistener_packagemoved".equals(paramAppRuntime)) {
        EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"), paramBundle.getInt("paramter_three"));
      } else if ("emojilistener_packagedeleted".equals(paramAppRuntime)) {
        EmojiListenerManager.a().b((EmoticonPackage)paramBundle.getSerializable("paramter_one"));
      } else if ("emojilistener_packageadded".equals(paramAppRuntime)) {
        EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"), null);
      } else if ("emojilistener_packageadded_one".equals(paramAppRuntime)) {
        EmojiListenerManager.a().c((EmoticonPackage)paramBundle.getSerializable("paramter_one"));
      } else if ("emojilistener_packagefail".equals(paramAppRuntime)) {
        EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"), paramBundle.getInt("paramter_three"), null);
      } else if ("emojilistener_packagesucc".equals(paramAppRuntime)) {
        EmojiListenerManager.a().d((EmoticonPackage)paramBundle.getSerializable("paramter_one"));
      } else if ("emojilistener_package_progress".equals(paramAppRuntime)) {
        EmojiListenerManager.a().b((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"), paramBundle.getInt("paramter_three"));
      } else if ("emojilistener_destory".equals(paramAppRuntime)) {
        EmojiListenerManager.a().a();
      }
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ("other_process_callback".equals(paramString)) {
      return otherProcessCallBack(localAppRuntime, paramString, paramBundle, paramInt);
    }
    return EIPCResult.createExceptionResult(new RuntimeException("no match call."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelChildIpcModule
 * JD-Core Version:    0.7.0.1
 */