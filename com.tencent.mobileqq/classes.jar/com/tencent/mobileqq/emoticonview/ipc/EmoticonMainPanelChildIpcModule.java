package com.tencent.mobileqq.emoticonview.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

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
  
  public static EmoticonMainPanelChildIpcModule getInstance()
  {
    try
    {
      if (mInstance == null) {
        try
        {
          if (mInstance == null) {
            mInstance = new EmoticonMainPanelChildIpcModule();
          }
        }
        finally {}
      }
      EmoticonMainPanelChildIpcModule localEmoticonMainPanelChildIpcModule = mInstance;
      return localEmoticonMainPanelChildIpcModule;
    }
    finally {}
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
    } else if ("emojilistener_emoticonjson".equals(paramAppRuntime)) {
      EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"));
    } else if ("emojilistener_emoticoncover".equals(paramAppRuntime)) {
      EmojiListenerManager.a().notifyEmoticonCoverListener((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"), paramBundle.getInt("paramter_three"), paramBundle.getInt("paramter_four"));
    } else if ("emojilistener_packagestart".equals(paramAppRuntime)) {
      EmojiListenerManager.a().notifyPackageStart((EmoticonPackage)paramBundle.getSerializable("paramter_one"));
    } else if ("emojilistener_packagemoved".equals(paramAppRuntime)) {
      EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"), paramBundle.getInt("paramter_three"));
    } else if ("emojilistener_packagedeleted".equals(paramAppRuntime)) {
      EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"));
    } else if ("emojilistener_packageadded".equals(paramAppRuntime)) {
      EmojiListenerManager.a().a((EmoticonPackage)paramBundle.getSerializable("paramter_one"), null);
    } else if ("emojilistener_packageadded_one".equals(paramAppRuntime)) {
      EmojiListenerManager.a().b((EmoticonPackage)paramBundle.getSerializable("paramter_one"));
    } else if ("emojilistener_packagefail".equals(paramAppRuntime)) {
      EmojiListenerManager.a().notifyPackageFail((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"), paramBundle.getInt("paramter_three"), null);
    } else if ("emojilistener_packagesucc".equals(paramAppRuntime)) {
      EmojiListenerManager.a().c((EmoticonPackage)paramBundle.getSerializable("paramter_one"));
    } else if ("emojilistener_package_progress".equals(paramAppRuntime)) {
      EmojiListenerManager.a().notifyPackageProgress((EmoticonPackage)paramBundle.getSerializable("paramter_one"), paramBundle.getInt("paramter_two"), paramBundle.getInt("paramter_three"));
    } else if ("emojilistener_destory".equals(paramAppRuntime)) {
      EmojiListenerManager.a().b();
    }
    return EIPCResult.createSuccessResult(null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
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