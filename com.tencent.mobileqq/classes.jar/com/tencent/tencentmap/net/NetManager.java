package com.tencent.tencentmap.net;

import android.content.Context;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.http.HttpCanceler;
import java.util.HashMap;

public class NetManager
{
  private static NetManager a;
  
  public static NetManager getInstance()
  {
    try
    {
      if (a == null) {
        a = new NetManager();
      }
      NetManager localNetManager = a;
      return localNetManager;
    }
    finally {}
  }
  
  public NetResponse doGet(String paramString)
  {
    paramString = com.tencent.map.tools.net.NetManager.getInstance().doGet(paramString);
    if (paramString != null) {
      return new NetResponse(paramString);
    }
    return null;
  }
  
  public NetResponse doGet(String paramString, int paramInt, HttpCanceler paramHttpCanceler)
  {
    paramString = com.tencent.map.tools.net.NetManager.getInstance().doGet(paramString, paramInt, paramHttpCanceler);
    if (paramString != null) {
      return new NetResponse(paramString);
    }
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doGet(paramString1, paramString2);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doGet(paramString1, paramString2, paramInt);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doGet(paramString1, paramString2, paramInt1, paramInt2, paramHashMap, null);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doGet(paramString1, paramString2, paramInt1, paramInt2, paramHashMap, paramHttpCanceler);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt, HttpCanceler paramHttpCanceler)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doGet(paramString1, paramString2, paramInt, paramHttpCanceler);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doGet(paramString1, paramString2, paramInt, paramHashMap, paramHttpCanceler);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doPost(paramString1, paramString2, paramArrayOfByte);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doPost(paramString1, paramString2, paramArrayOfByte, paramInt);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doPost(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2, paramHashMap, null);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HttpCanceler paramHttpCanceler)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doPost(paramString1, paramString2, paramArrayOfByte, paramInt, paramHttpCanceler);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, HashMap<String, String> paramHashMap, int paramInt2)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doPost(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2, paramHashMap, null);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doPost(paramString1, paramString2, paramArrayOfByte, paramInt, paramHashMap, paramHttpCanceler);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler, int paramInt2)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doPost(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2, paramHashMap, paramHttpCanceler);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public NetResponse doPost(String paramString, byte[] paramArrayOfByte)
  {
    paramString = com.tencent.map.tools.net.NetManager.getInstance().doPost(paramString, paramArrayOfByte);
    if (paramString != null) {
      return new NetResponse(paramString);
    }
    return null;
  }
  
  public NetResponse doPost(String paramString, byte[] paramArrayOfByte, int paramInt, HttpCanceler paramHttpCanceler)
  {
    paramString = com.tencent.map.tools.net.NetManager.getInstance().doPost(paramString, paramArrayOfByte, paramInt, paramHttpCanceler);
    if (paramString != null) {
      return new NetResponse(paramString);
    }
    return null;
  }
  
  public NetResponse doPostNoBuffer(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramString1 = com.tencent.map.tools.net.NetManager.getInstance().doPostNoBuffer(paramString1, paramString2, paramArrayOfByte);
    if (paramString1 != null) {
      return new NetResponse(paramString1);
    }
    return null;
  }
  
  public void doRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler)
  {
    com.tencent.map.tools.net.NetManager.getInstance().doRangePost(paramString1, paramArrayOfByte, paramString2, paramString3, paramString4, paramString5, paramHttpCanceler);
  }
  
  public void setAdapter(Context paramContext, NetAdapter paramNetAdapter)
  {
    com.tencent.map.tools.net.NetManager.getInstance().setAdapter(paramContext, paramNetAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.net.NetManager
 * JD-Core Version:    0.7.0.1
 */