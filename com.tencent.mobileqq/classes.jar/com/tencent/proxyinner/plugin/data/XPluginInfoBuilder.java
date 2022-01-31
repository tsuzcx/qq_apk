package com.tencent.proxyinner.plugin.data;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.txproxy.InitParam;
import com.tencent.txproxy.RunPluginParams;

public class XPluginInfoBuilder
{
  public static Intent setInitParam(String paramString, Intent paramIntent, InitParam paramInitParam)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (localIntent.getExtras() != null) {
      localIntent.getExtras().clear();
    }
    try
    {
      localIntent.putExtra("sourceVersion", paramInitParam.mSourceVersion);
      localIntent.putExtra("sourceID", paramInitParam.mSourceId);
      localIntent.putExtra("pluginid", paramString);
      localIntent.putExtra("hosttype", String.valueOf(paramInitParam.mChannelId));
      localIntent.putExtra("pluginflag", true);
      localIntent.putExtra("sourceChannelId", Integer.parseInt(paramInitParam.mChannelId));
      return localIntent;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return localIntent;
  }
  
  public static Intent setLauncherParam(Intent paramIntent, RunPluginParams paramRunPluginParams)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (localIntent.getExtras() != null) {
      localIntent.getExtras().clear();
    }
    localIntent.putExtra("vastype", paramRunPluginParams.mVasType);
    localIntent.putExtra("authtype", paramRunPluginParams.mAuthType);
    localIntent.putExtra("appid", paramRunPluginParams.mAppid);
    localIntent.putExtra("fromid", paramRunPluginParams.mFromId);
    localIntent.putExtra("roomid", paramRunPluginParams.mRoomId);
    localIntent.putExtra("authkey", paramRunPluginParams.mAuthKey);
    localIntent.putExtra("authid", paramRunPluginParams.mAuthId);
    localIntent.putExtra("vasname", paramRunPluginParams.mVasName);
    localIntent.putExtra("nickname", paramRunPluginParams.mNickName);
    localIntent.putExtra("roomname", paramRunPluginParams.mRoomName);
    localIntent.putExtra("age", paramRunPluginParams.mAge);
    localIntent.putExtra("gender", paramRunPluginParams.mGender);
    localIntent.putExtra("birthyear", paramRunPluginParams.mBirthYear);
    localIntent.putExtra("birthmonth", paramRunPluginParams.mBirthMonth);
    localIntent.putExtra("birthday", paramRunPluginParams.mBirthDay);
    localIntent.putExtra("addrCountry", paramRunPluginParams.mAddr_country);
    localIntent.putExtra("addrProv", paramRunPluginParams.mAddr_province);
    localIntent.putExtra("addrCity", paramRunPluginParams.mAddr_city);
    localIntent.putExtra("hometownCountry", paramRunPluginParams.mHometown_country);
    localIntent.putExtra("hometownProv", paramRunPluginParams.mHometown_province);
    localIntent.putExtra("hometownCity", paramRunPluginParams.mHometown_city);
    localIntent.putExtra("launchername", paramRunPluginParams.mLauncherName);
    localIntent.putExtra("needconfirmnetwork", paramRunPluginParams.mNeedConfirmNetworkBeforeDownload);
    localIntent.putExtra("proxy_version", 7L);
    if (!TextUtils.isEmpty(paramRunPluginParams.vasSchema)) {
      localIntent.putExtra("vasschema", paramRunPluginParams.vasSchema);
    }
    if ((paramRunPluginParams.intent != null) && (paramRunPluginParams.intent.getExtras() != null)) {
      localIntent.putExtras(paramRunPluginParams.intent);
    }
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.data.XPluginInfoBuilder
 * JD-Core Version:    0.7.0.1
 */