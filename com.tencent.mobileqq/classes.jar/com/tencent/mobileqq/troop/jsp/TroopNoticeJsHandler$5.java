package com.tencent.mobileqq.troop.jsp;

import org.json.JSONArray;
import org.json.JSONException;

class TroopNoticeJsHandler$5
  implements Runnable
{
  TroopNoticeJsHandler$5(TroopNoticeJsHandler paramTroopNoticeJsHandler, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(this.a);
      int i = 0;
      int j = localJSONArray.length();
      while (i < j)
      {
        String str = localJSONArray.get(i).toString();
        this.this$0.c(str);
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.5
 * JD-Core Version:    0.7.0.1
 */