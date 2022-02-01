package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoIpcServer;
import com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelIpcModule;
import com.tencent.mobileqq.qipc.QIPCModule;

public class EmoticonPanelIpcServiceImpl
  implements IEmoticonPanelIpcService
{
  public QIPCModule onCreateModule(String paramString)
  {
    if ("EmoticonIPCModule".equals(paramString)) {
      return EmoticonIPCModule.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return CameraEmoIpcServer.a();
    }
    if ("module_emoticon_mainpanel".equals(paramString)) {
      return EmoticonMainPanelIpcModule.getInstance();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoticonPanelIpcServiceImpl
 * JD-Core Version:    0.7.0.1
 */