package com.tencent.mobileqq.guild.vas.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GetGiftListRsp;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SharedPreferencesHelper
{
  private static final SharedPreferencesHelper a = new SharedPreferencesHelper();
  
  public static SharedPreferencesHelper a()
  {
    return a;
  }
  
  public void a(String paramString, giftList.GetGiftListRsp paramGetGiftListRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("giftlist_");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null).getPreferences();
    try
    {
      String str = new String(paramGetGiftListRsp.toByteArray(), "ISO8859_1");
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_saveTime");
      localEditor.putLong(localStringBuilder.toString(), System.currentTimeMillis() + paramGetGiftListRsp.duration.get() * 1000 * 20);
      ((SharedPreferences)localObject).edit().putString(paramString, str);
      ((SharedPreferences)localObject).edit().apply();
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.waitAppRuntime(null).getPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("giftlist_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_saveTime");
    long l = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    return System.currentTimeMillis() >= l;
  }
  
  public giftList.GetGiftListRsp b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("giftlist_");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    paramString = MobileQQ.sMobileQQ.waitAppRuntime(null).getPreferences().getString(paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      localObject = new giftList.GetGiftListRsp();
      ((giftList.GetGiftListRsp)localObject).mergeFrom(paramString.getBytes("ISO8859_1"));
      return localObject;
    }
    catch (InvalidProtocolBufferMicroException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.util.SharedPreferencesHelper
 * JD-Core Version:    0.7.0.1
 */