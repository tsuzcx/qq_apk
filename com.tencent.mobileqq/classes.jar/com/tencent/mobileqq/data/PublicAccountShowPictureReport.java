package com.tencent.mobileqq.data;

import android.text.TextUtils;
import bdll;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountShowPictureReport
{
  public String articleId;
  public String imgCount;
  public boolean isReport;
  public int leave_mode = 2;
  private HashSet<Integer> pic_index_arr;
  public String puin;
  public int slide_number;
  private long time_on_show_end;
  private long time_on_show_start;
  public String uin;
  
  public void addPicIndex(int paramInt)
  {
    if (this.pic_index_arr == null) {
      this.pic_index_arr = new HashSet();
    }
    this.pic_index_arr.add(Integer.valueOf(paramInt));
  }
  
  public void parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      parse(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void parse(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    reset();
    this.uin = paramJSONObject.optString("uin");
    this.puin = paramJSONObject.optString("puin");
    this.articleId = paramJSONObject.optString("articleId");
    this.imgCount = paramJSONObject.optString("imgCount");
    this.isReport = paramJSONObject.optBoolean("isReport");
  }
  
  public void report(QQAppInterface paramQQAppInterface)
  {
    if (!this.isReport) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.pic_index_arr != null)
    {
      Iterator localIterator = this.pic_index_arr.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((Integer)localIterator.next()).append(",");
      }
    }
    bdll.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", this.puin, "0X80066AB", "0X80066AB", this.slide_number - 1, Integer.parseInt(this.imgCount), 0, this.articleId, localStringBuilder.toString(), this.leave_mode + "", this.time_on_show_end - this.time_on_show_start + "");
  }
  
  public void reset()
  {
    this.isReport = false;
    if (this.pic_index_arr != null) {
      this.pic_index_arr.clear();
    }
    this.leave_mode = 2;
    this.slide_number = 0;
    this.time_on_show_start = 0L;
    this.time_on_show_end = 0L;
  }
  
  public void showEnd()
  {
    this.time_on_show_end = System.currentTimeMillis();
  }
  
  public void showStart()
  {
    this.time_on_show_start = System.currentTimeMillis();
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", this.uin);
      localJSONObject.put("puin", this.puin);
      localJSONObject.put("articleId", this.articleId);
      localJSONObject.put("imgCount", this.imgCount);
      localJSONObject.put("isReport", this.isReport);
      label63:
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublicAccountShowPictureReport
 * JD-Core Version:    0.7.0.1
 */