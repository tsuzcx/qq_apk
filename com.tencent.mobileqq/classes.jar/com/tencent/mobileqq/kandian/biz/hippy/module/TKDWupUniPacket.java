package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import java.util.HashMap;

public class TKDWupUniPacket
  extends UniPacket
{
  public static String TAG = "TKDWupUniPacket";
  
  public byte[] getRawResponseData(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      if (!this._data.containsKey(paramString1)) {
        return null;
      }
      paramString1 = (HashMap)this._data.get(paramString1);
      if (paramString1 == null) {
        return null;
      }
      return (byte[])paramString1.get(paramString2);
    }
    return null;
  }
  
  public HashMap<String, byte[]> getRspDataMap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this._data.containsKey(paramString)) {
      return null;
    }
    return (HashMap)this._data.get(paramString);
  }
  
  public void putRawRequestData(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString2, paramArrayOfByte);
    this._data.put(paramString1, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDWupUniPacket
 * JD-Core Version:    0.7.0.1
 */