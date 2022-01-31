package com.tencent.weiyun.cmd;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.weiyun.WeiyunLiteGlobal;
import com.tencent.weiyun.WeiyunLiteGlobal.HostInterface;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.UIHelper;
import com.tencent.weiyun.utils.Utils;
import java.io.File;

class CommandManager$1
  extends WeiyunSDKContext
{
  CommandManager$1(CommandManager paramCommandManager) {}
  
  public String getAccessToken()
  {
    return null;
  }
  
  public String getCachePath()
  {
    return CommandManager.access$000(this.this$0).getFilesDir().toString();
  }
  
  public String getDeviceId()
  {
    return Utils.getDeviceId(CommandManager.access$000(this.this$0));
  }
  
  public String getDeviceInfo()
  {
    return "";
  }
  
  public String getDeviceName()
  {
    return Build.MODEL;
  }
  
  public int getLoginType()
  {
    return 0;
  }
  
  public int getNetworkType()
  {
    return NetworkUtils.getNetworkTypeDiff4G(CommandManager.access$000(this.this$0));
  }
  
  public String getOpenID()
  {
    return null;
  }
  
  public String getOpenKey()
  {
    return null;
  }
  
  public int getPlatform()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public String getRefreshToken()
  {
    return null;
  }
  
  public long[] getScreenSize()
  {
    return new long[] { UIHelper.getWindowScreenWidth(CommandManager.access$000(this.this$0)), UIHelper.getWindowScreenHeight(CommandManager.access$000(this.this$0)) };
  }
  
  public long getUin()
  {
    return WeiyunLiteGlobal.getInstance().getHostInterface().getCurrentUin();
  }
  
  public String getWifiBssid()
  {
    String str2 = NetworkUtils.getWifiBSSID(CommandManager.access$000(this.this$0));
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public void sendRequest(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    WeiyunLiteGlobal.getInstance().getHostInterface().sendRequest(paramString, paramArrayOfByte, new CommandManager.1.1(this, paramLong, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.cmd.CommandManager.1
 * JD-Core Version:    0.7.0.1
 */