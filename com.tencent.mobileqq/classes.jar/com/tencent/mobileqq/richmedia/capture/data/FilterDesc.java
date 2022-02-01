package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FilterDesc
{
  public Bundle bundle;
  public String display;
  public String iconMD5;
  public String iconurl;
  public int id;
  public String name;
  public int predownload;
  public String resMD5;
  public ArrayList<String> resNameList;
  public String resRootPath;
  public String respicname;
  public String resurl;
  public int subId;
  public int type;
  public int version;
  
  public FilterDesc() {}
  
  public FilterDesc(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt4)
  {
    this.id = paramInt1;
    this.subId = paramInt2;
    this.predownload = paramInt3;
    this.resurl = paramString1;
    this.resMD5 = paramString2;
    this.iconurl = paramString3;
    this.iconMD5 = paramString4;
    this.name = paramString5;
    this.type = paramInt4;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.id = paramInt1;
    this.predownload = paramInt2;
    this.resurl = paramString1;
    this.resMD5 = paramString2;
    this.iconurl = paramString3;
    this.iconMD5 = paramString4;
    this.name = paramString5;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3)
  {
    this.id = paramInt1;
    this.predownload = paramInt2;
    this.resurl = paramString1;
    this.resMD5 = paramString2;
    this.iconurl = paramString3;
    this.iconMD5 = paramString4;
    this.name = paramString5;
    this.type = paramInt3;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, int paramInt4)
  {
    this.id = paramInt1;
    this.predownload = paramInt2;
    this.resurl = paramString1;
    this.resMD5 = paramString2;
    this.iconurl = paramString3;
    this.iconMD5 = paramString4;
    this.name = paramString5;
    this.type = paramInt3;
    this.version = paramInt4;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, int paramInt4, String paramString6)
  {
    this.id = paramInt1;
    this.predownload = paramInt2;
    this.resurl = paramString1;
    this.resMD5 = paramString2;
    this.iconurl = paramString3;
    this.iconMD5 = paramString4;
    this.name = paramString5;
    this.type = paramInt3;
    this.version = paramInt4;
    this.respicname = paramString6;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6)
  {
    this(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt3);
    this.resRootPath = paramString6;
  }
  
  public static ArrayList<FilterDesc> parse(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          try
          {
            if (!localJSONObject.has("filterid")) {
              break label332;
            }
            j = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
            int k;
            if (localJSONObject.has("type")) {
              k = Integer.valueOf(localJSONObject.getString("type")).intValue();
            } else {
              k = QQAVImageFilterConstants.getFilterType(j);
            }
            if (!localJSONObject.has("predownload")) {
              break label337;
            }
            m = Integer.valueOf(localJSONObject.optString("predownload", "0")).intValue();
            String str1 = localJSONObject.optString("resurl", "");
            String str2 = localJSONObject.optString("md5", "");
            if (localJSONObject.has("resurl_android"))
            {
              str1 = localJSONObject.optString("resurl_android", "");
              str2 = localJSONObject.optString("md5_android", "");
            }
            String str4 = localJSONObject.optString("iconUrl");
            String str5 = localJSONObject.optString("iconmd5");
            Object localObject1 = localJSONObject.optString("name");
            if (localJSONObject.has("name_android")) {
              localObject1 = localJSONObject.optString("name_android", "");
            }
            String str3 = localJSONObject.optString("display", "");
            Object localObject2 = str3;
            if (TextUtils.isEmpty(str3)) {
              localObject2 = localObject1;
            }
            localObject1 = new FilterDesc(j, m, str1, str2, str4, str5, (String)localObject1, k, localJSONObject.optInt("version", 0), localJSONObject.optString("respicname", ""));
            ((FilterDesc)localObject1).display = ((String)localObject2);
            localArrayList.add(localObject1);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          i += 1;
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return localArrayList;
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
      label332:
      int j = 0;
      continue;
      label337:
      int m = 0;
    }
  }
  
  public String getFileNameWithoutExtension(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return paramString;
      }
      int i = paramString.lastIndexOf(".");
      int j = paramString.lastIndexOf(File.separator);
      if (j == -1)
      {
        if (i == -1) {
          return paramString;
        }
        return paramString.substring(0, i);
      }
      if (i == -1) {
        return paramString.substring(j + 1);
      }
      if (j < i) {
        return paramString.substring(j + 1, i);
      }
      str = paramString.substring(j + 1);
    }
    return str;
  }
  
  public String getIconFile(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(this.name);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public String getResFold(String paramString)
  {
    String str = this.resurl;
    if (str != null)
    {
      if (str.equals("")) {
        return "";
      }
      str = getFileNameWithoutExtension(this.resurl);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public boolean isEmptyFilter()
  {
    int i = this.id;
    return (i == -1) || (i == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.FilterDesc
 * JD-Core Version:    0.7.0.1
 */