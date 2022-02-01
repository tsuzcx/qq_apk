package com.tencent.mobileqq.qqconnectface.impl;

import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.identification.IdentificationActivityHelper;
import com.tencent.mobileqq.identification.IdentificationIpcServer;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class IdentificationApiImpl
  implements IIdentificationApi
{
  public WebViewPlugin createIdentificationPlugin()
  {
    return new IdentificationApiPlugin();
  }
  
  public Class<?> getDeleteFaceFragment()
  {
    return DeleteFaceFragment.class;
  }
  
  public QIPCModule getIdentityIpcServer()
  {
    return IdentificationIpcServer.a();
  }
  
  public void preResDownload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqconnectface.impl.IdentificationApiImpl
 * JD-Core Version:    0.7.0.1
 */