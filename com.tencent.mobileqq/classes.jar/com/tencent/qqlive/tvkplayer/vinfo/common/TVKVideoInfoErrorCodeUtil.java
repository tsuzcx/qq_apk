package com.tencent.qqlive.tvkplayer.vinfo.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class TVKVideoInfoErrorCodeUtil
{
  private static HashMap<String, Integer> sErrorCodeMap = new HashMap();
  
  static
  {
    sErrorCodeMap.put("ConnectException", Integer.valueOf(3));
    sErrorCodeMap.put("FileNotFoundException", Integer.valueOf(8));
    sErrorCodeMap.put("SSLException", Integer.valueOf(16));
    sErrorCodeMap.put("SSLHandshakeException", Integer.valueOf(17));
    sErrorCodeMap.put("SSLKeyException", Integer.valueOf(18));
    sErrorCodeMap.put("SSLPeerUnverifiedException", Integer.valueOf(19));
    sErrorCodeMap.put("SSLProtocolException", Integer.valueOf(20));
    sErrorCodeMap.put("SocketException", Integer.valueOf(21));
    sErrorCodeMap.put("SocketTimeoutException", Integer.valueOf(5));
    HashMap localHashMap = sErrorCodeMap;
    Integer localInteger = Integer.valueOf(15);
    localHashMap.put("XmlPullParserException", localInteger);
    sErrorCodeMap.put("UnknownHostException", Integer.valueOf(2));
    sErrorCodeMap.put("UnsupportedEncodingException", localInteger);
  }
  
  public static int getErrCodeByThrowable(Throwable paramThrowable)
  {
    int j = 1;
    if (paramThrowable == null) {
      return 1;
    }
    Iterator localIterator = sErrorCodeMap.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      i = j;
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramThrowable.toString().contains((CharSequence)localEntry.getKey()));
    int i = ((Integer)localEntry.getValue()).intValue();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoErrorCodeUtil
 * JD-Core Version:    0.7.0.1
 */