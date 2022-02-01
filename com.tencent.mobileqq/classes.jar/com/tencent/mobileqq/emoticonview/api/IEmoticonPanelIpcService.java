package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEmoticonPanelIpcService
  extends QRouteApi
{
  public static final String CAMERAEMOIPC_SERVER_NAME = "CameraEmoIpcServer";
  public static final String EMOTICON_IPC_NAME = "EmoticonIPCModule";
  public static final String EMOTICON_MAINPANEL_IPC_NAME = "module_emoticon_mainpanel";
  
  public abstract QIPCModule onCreateModule(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService
 * JD-Core Version:    0.7.0.1
 */