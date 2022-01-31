package com.tencent.qqmini.sdk.minigame.proxy;

import android.os.Bundle;
import bgtx;
import com.tencent.qqmini.sdk.core.proxy.CmdProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;

public class MiniGameCmdProxyImpl
  implements CmdProxy
{
  public void handleMiniAppCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (("cmd_queue_mini_process_load_apkg".equals(paramString)) || ("cmd_remove_mini_process_load_apkg".equals(paramString)) || ("cmd_main_process_load_pkg".equals(paramString)) || ("cmd_main_process_download_pkg".equals(paramString))) {
      bgtx.a(paramString, paramBundle, paramMiniCmdCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.proxy.MiniGameCmdProxyImpl
 * JD-Core Version:    0.7.0.1
 */