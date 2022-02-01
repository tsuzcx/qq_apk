package com.vivo.push.model;

import android.text.TextUtils;
import com.vivo.push.util.l;
import com.vivo.push.util.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UnvarnishedMessage
{
  private static final String TAG = "UnvarnishedMessage";
  private String mMessage;
  private long mMsgId;
  private Map<String, String> mParams = new HashMap();
  private int mTargetType;
  private String mTragetContent;
  
  public UnvarnishedMessage() {}
  
  public UnvarnishedMessage(String paramString)
  {
    packToObj(paramString);
  }
  
  private void packToObj(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        o.a("UnvarnishedMessage", "unvarnishedMsg pack to obj is null");
        return;
      }
      paramString = new JSONArray(paramString);
      this.mTargetType = paramString.optInt(0);
      this.mTragetContent = paramString.getString(1);
      this.mMessage = paramString.getString(2);
      this.mParams = l.a(new JSONObject(paramString.getString(3)));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      o.a("UnvarnishedMessage", "unvarnishedMsg pack to obj error", paramString);
    }
  }
  
  public String getMessage()
  {
    return this.mMessage;
  }
  
  public long getMsgId()
  {
    return this.mMsgId;
  }
  
  public Map<String, String> getParams()
  {
    return this.mParams;
  }
  
  public int getTargetType()
  {
    return this.mTargetType;
  }
  
  public String getTragetContent()
  {
    return this.mTragetContent;
  }
  
  public void setMessage(String paramString)
  {
    this.mMessage = paramString;
  }
  
  public void setMsgId(long paramLong)
  {
    this.mMsgId = paramLong;
  }
  
  public void setParams(Map<String, String> paramMap)
  {
    this.mParams = paramMap;
  }
  
  public void setTargetType(int paramInt)
  {
    this.mTargetType = paramInt;
  }
  
  public void setTragetContent(String paramString)
  {
    this.mTragetContent = paramString;
  }
  
  public String unpackToJson()
  {
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(this.mTargetType);
    localJSONArray.put(this.mTragetContent);
    localJSONArray.put(this.mMessage);
    Map localMap = this.mParams;
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    localJSONArray.put(localObject);
    return localJSONArray.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.model.UnvarnishedMessage
 * JD-Core Version:    0.7.0.1
 */