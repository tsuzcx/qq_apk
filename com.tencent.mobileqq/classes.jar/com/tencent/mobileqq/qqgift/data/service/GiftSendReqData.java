package com.tencent.mobileqq.qqgift.data.service;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class GiftSendReqData
{
  public long a = 0L;
  public long b = 0L;
  public int c = 0;
  public int d = 0;
  public ConcurrentHashMap<String, String> e = new ConcurrentHashMap();
  public ConcurrentHashMap<String, String> f = new ConcurrentHashMap();
  
  public String a()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() != 0))
    {
      localObject = new JSONObject();
      Iterator localIterator = this.e.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        try
        {
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue());
        }
        catch (JSONException localJSONException)
        {
          label82:
          break label82;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GiftSendReqData", 4, "toExtJsonData error");
        }
      }
      return ((JSONObject)localObject).toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.data.service.GiftSendReqData
 * JD-Core Version:    0.7.0.1
 */