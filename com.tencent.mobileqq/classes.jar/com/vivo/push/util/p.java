package com.vivo.push.util;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class p
{
  public static InsideNotificationItem a(String paramString)
  {
    InsideNotificationItem localInsideNotificationItem = new InsideNotificationItem();
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        o.a("MessageConvertUtil", "notify msg pack to obj is null");
        return null;
      }
      paramString = new JSONArray(paramString);
      localInsideNotificationItem.setTargetType(paramString.getInt(0));
      localInsideNotificationItem.setTragetContext(paramString.getString(1));
      localInsideNotificationItem.setTitle(paramString.getString(2));
      localInsideNotificationItem.setContent(paramString.getString(3));
      localInsideNotificationItem.setNotifyType(paramString.getInt(4));
      localInsideNotificationItem.setPurePicUrl(paramString.getString(5));
      localInsideNotificationItem.setIconUrl(paramString.getString(6));
      localInsideNotificationItem.setCoverUrl(paramString.getString(7));
      localInsideNotificationItem.setSkipContent(paramString.getString(8));
      localInsideNotificationItem.setSkipType(paramString.getInt(9));
      localInsideNotificationItem.setShowTime(paramString.getBoolean(10));
      if (paramString.length() > 11) {
        localInsideNotificationItem.setParams(l.a(new JSONObject(paramString.getString(11))));
      }
      if (paramString.length() > 15)
      {
        localInsideNotificationItem.setAppType(paramString.getInt(12));
        localInsideNotificationItem.setReactPackage(paramString.getString(13));
        localInsideNotificationItem.setIsShowBigPicOnMobileNet(paramString.getBoolean(14));
        localInsideNotificationItem.setSuitReactVersion(paramString.getString(15));
      }
      if (paramString.length() > 16) {
        localInsideNotificationItem.setMessageType(paramString.getInt(16));
      }
      if (paramString.length() > 18)
      {
        localInsideNotificationItem.setIsMacroReplace(paramString.getInt(17));
        localInsideNotificationItem.setAdClickCheckUrl(paramString.getString(18));
      }
      if (paramString.length() > 19) {
        localInsideNotificationItem.setCompatibleType(paramString.getInt(19));
      }
      if (paramString.length() > 20)
      {
        localInsideNotificationItem.setInnerPriority(paramString.getInt(20));
        return localInsideNotificationItem;
      }
    }
    catch (JSONException paramString)
    {
      o.a("MessageConvertUtil", "notify msg pack to obj error", paramString);
    }
    return localInsideNotificationItem;
  }
  
  public static UPSNotificationMessage a(InsideNotificationItem paramInsideNotificationItem)
  {
    UPSNotificationMessage localUPSNotificationMessage = new UPSNotificationMessage();
    localUPSNotificationMessage.setTargetType(paramInsideNotificationItem.getTargetType());
    localUPSNotificationMessage.setTragetContext(paramInsideNotificationItem.getTragetContent());
    localUPSNotificationMessage.setTitle(paramInsideNotificationItem.getTitle());
    localUPSNotificationMessage.setContent(paramInsideNotificationItem.getContent());
    localUPSNotificationMessage.setNotifyType(paramInsideNotificationItem.getNotifyType());
    localUPSNotificationMessage.setPurePicUrl(paramInsideNotificationItem.getPurePicUrl());
    localUPSNotificationMessage.setIconUrl(paramInsideNotificationItem.getIconUrl());
    localUPSNotificationMessage.setCoverUrl(paramInsideNotificationItem.getCoverUrl());
    localUPSNotificationMessage.setSkipContent(paramInsideNotificationItem.getSkipContent());
    localUPSNotificationMessage.setSkipType(paramInsideNotificationItem.getSkipType());
    localUPSNotificationMessage.setShowTime(paramInsideNotificationItem.isShowTime());
    localUPSNotificationMessage.setMsgId(paramInsideNotificationItem.getMsgId());
    localUPSNotificationMessage.setParams(paramInsideNotificationItem.getParams());
    return localUPSNotificationMessage;
  }
  
  public static String b(InsideNotificationItem paramInsideNotificationItem)
  {
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramInsideNotificationItem.getTargetType());
    localJSONArray.put(paramInsideNotificationItem.getTragetContent());
    localJSONArray.put(paramInsideNotificationItem.getTitle());
    localJSONArray.put(paramInsideNotificationItem.getContent());
    localJSONArray.put(paramInsideNotificationItem.getNotifyType());
    localJSONArray.put(paramInsideNotificationItem.getPurePicUrl());
    localJSONArray.put(paramInsideNotificationItem.getIconUrl());
    localJSONArray.put(paramInsideNotificationItem.getCoverUrl());
    localJSONArray.put(paramInsideNotificationItem.getSkipContent());
    localJSONArray.put(paramInsideNotificationItem.getSkipType());
    localJSONArray.put(paramInsideNotificationItem.isShowTime());
    if (paramInsideNotificationItem.getParams() != null) {
      localJSONArray.put(new JSONObject(paramInsideNotificationItem.getParams()));
    } else {
      localJSONArray.put("{}");
    }
    localJSONArray.put(paramInsideNotificationItem.getAppType());
    localJSONArray.put(paramInsideNotificationItem.getReactPackage());
    localJSONArray.put(paramInsideNotificationItem.isShowBigPicOnMobileNet());
    localJSONArray.put(paramInsideNotificationItem.getSuitReactVersion());
    localJSONArray.put(paramInsideNotificationItem.getMessageType());
    localJSONArray.put(paramInsideNotificationItem.getIsMacroReplace());
    localJSONArray.put(paramInsideNotificationItem.getAdClickCheckUrl());
    localJSONArray.put(paramInsideNotificationItem.getCompatibleType());
    localJSONArray.put(paramInsideNotificationItem.getInnerPriority());
    return localJSONArray.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.p
 * JD-Core Version:    0.7.0.1
 */