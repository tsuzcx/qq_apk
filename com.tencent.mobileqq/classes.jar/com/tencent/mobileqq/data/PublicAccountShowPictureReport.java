package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
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
    Object localObject2 = new StringBuilder();
    Object localObject1 = this.pic_index_arr;
    if (localObject1 != null)
    {
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ((StringBuilder)localObject2).append((Integer)((Iterator)localObject1).next());
        ((StringBuilder)localObject2).append(",");
      }
    }
    localObject1 = this.puin;
    int i = this.slide_number;
    int j = Integer.parseInt(this.imgCount);
    String str = this.articleId;
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.leave_mode);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.time_on_show_end - this.time_on_show_start);
    localStringBuilder.append("");
    ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80066AB", "0X80066AB", i - 1, j, 0, str, (String)localObject2, (String)localObject3, localStringBuilder.toString());
  }
  
  public void reset()
  {
    this.isReport = false;
    HashSet localHashSet = this.pic_index_arr;
    if (localHashSet != null) {
      localHashSet.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublicAccountShowPictureReport
 * JD-Core Version:    0.7.0.1
 */