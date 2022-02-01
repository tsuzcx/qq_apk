package com.tencent.mobileqq.kandian.biz.pts.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicChannelDataModel
  extends Entity
{
  @notColumn
  public static final String TAG = "DynamicChannelDataModel";
  public int channelID;
  @notColumn
  public TemplateBean mTemplateBean;
  public String proteusData;
  public long recommendSeq;
  public String styleID;
  public String uniqueID;
  
  public static String getStyleIDFromProteusData(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          str1 = new JSONObject(paramString).getString("style_ID");
        }
      }
      catch (JSONException paramString)
      {
        QLog.d("DynamicChannelDataModel", 2, "getStyleIDFromProteusData, e = ", paramString);
        str1 = str2;
      }
    }
    QLog.d("DynamicChannelDataModel", 2, new Object[] { "getStyleIDFromProteusData, styleID = ", str1 });
    return str1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uniqueID = ");
    localStringBuilder.append(this.uniqueID);
    localStringBuilder.append(", channelID = ");
    localStringBuilder.append(this.channelID);
    localStringBuilder.append(", styleID = ");
    localStringBuilder.append(this.styleID);
    localStringBuilder.append(", recommendSeq = ");
    localStringBuilder.append(this.recommendSeq);
    localStringBuilder.append(", proteusData = ");
    localStringBuilder.append(this.proteusData);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel
 * JD-Core Version:    0.7.0.1
 */