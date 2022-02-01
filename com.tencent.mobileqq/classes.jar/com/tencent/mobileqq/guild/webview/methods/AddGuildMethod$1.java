package com.tencent.mobileqq.guild.webview.methods;

import com.google.gson.Gson;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class AddGuildMethod$1
  implements EIPCResultCallback
{
  AddGuildMethod$1(AddGuildMethod paramAddGuildMethod) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    try
    {
      paramEIPCResult = AddGuildMethod.AddGuildResult.a(paramEIPCResult.data);
      paramEIPCResult = new Gson().toJson(paramEIPCResult);
      this.a.a(paramEIPCResult);
      return;
    }
    catch (Exception paramEIPCResult)
    {
      this.a.a(paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.AddGuildMethod.1
 * JD-Core Version:    0.7.0.1
 */