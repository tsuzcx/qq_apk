package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.channel_button.channel_button.Section;

public class ChannelSection
{
  public long a;
  public String b;
  public String c;
  public List<TabChannelCoverInfo> d = new ArrayList();
  
  public ChannelSection(long paramLong, String paramString1, String paramString2)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public ChannelSection(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optLong("id");
    this.b = paramJSONObject.optString("name");
    this.c = paramJSONObject.optString("text");
  }
  
  public ChannelSection(channel_button.Section paramSection)
  {
    this.a = paramSection.uint64_section_id.get();
    this.b = paramSection.str_section_name.get();
    this.c = paramSection.str_note_text.get();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.a);
      localJSONObject.put("name", this.b);
      localJSONObject.put("text", this.c);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection
 * JD-Core Version:    0.7.0.1
 */