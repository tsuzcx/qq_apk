package com.tencent.mobileqq.kandian.biz.fastweb.data;

import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import org.json.JSONObject;

public class MiniAppData
  extends ProteusItemData
{
  public String a;
  public String b;
  public String c;
  public boolean d;
  public int e;
  
  public MiniAppData(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    String str1;
    if (this.d) {
      str1 = "已添加";
    } else {
      str1 = "稍后看";
    }
    String str2;
    if (this.d) {
      str2 = "1";
    } else {
      str2 = "0";
    }
    paramJSONObject.put("watch_later_text", str1);
    paramJSONObject.put("watch_later_selected", str2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppData{miniProgramName='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", miniAppMovieName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", miniRowKey='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isWatchLater=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", totalTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.data.MiniAppData
 * JD-Core Version:    0.7.0.1
 */