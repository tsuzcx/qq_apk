package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;

public class VipClubJsPlugin
  extends VasWebviewJsPluginV2
{
  public static final String BUSINESS_NAME = "vipclub";
  private static final String TAG = "VipClubJsPlugin";
  
  public VipClubJsPlugin()
  {
    super("vipclub");
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="type", method="paySuccess")
  public void paySuccess(Object paramObject)
  {
    if ((paramObject instanceof String)) {}
    for (int i = Integer.parseInt((String)paramObject);; i = ((Number)paramObject).intValue())
    {
      QLog.e("VipClubJsPlugin", 1, "paySuccess: " + paramObject);
      paramObject = new Bundle();
      paramObject.putInt("type", i);
      QIPCClientHelper.getInstance().callServer("VasCommonIPCModule", "paySuccess", paramObject, null);
      return;
      if (!(paramObject instanceof Number)) {
        break;
      }
    }
    if (paramObject == null)
    {
      QLog.e("VipClubJsPlugin", 1, "paySuccess type is null");
      return;
    }
    QLog.e("VipClubJsPlugin", 1, "paySuccess wrong type: " + paramObject.getClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin
 * JD-Core Version:    0.7.0.1
 */