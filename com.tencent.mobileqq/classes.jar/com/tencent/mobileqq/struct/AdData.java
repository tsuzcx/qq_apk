package com.tencent.mobileqq.struct;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;

public class AdData
  implements Serializable, Comparable<AdData>
{
  public static final int UI_PICTURE = 2;
  public static final int UI_PICTURE_and_TEXT = 3;
  public String actionData;
  public int ad_source;
  public String avatarBgGif;
  public int bgColor;
  public String content;
  public String content2;
  public String contentColor;
  public String distance;
  public String expose_url;
  public int fontColor;
  public String hasAvatarAnimation;
  public boolean hasShow = false;
  public long id;
  public int idType;
  public String img_url;
  public String jump_url;
  public String logo_url;
  public String nowBoardcastGif;
  public String nowBoardcastWording;
  public int picType = 1;
  public int position;
  public String title;
  public int typeUI;
  public String wording;
  
  public static String getWording(int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return BaseApplicationImpl.getContext().getString(2131696042);
          }
          return BaseApplicationImpl.getContext().getString(2131693170);
        }
        return BaseApplicationImpl.getContext().getString(2131699020);
      }
      return BaseApplicationImpl.getContext().getString(2131691103);
    }
    return BaseApplicationImpl.getContext().getString(2131698739);
  }
  
  public static int parseAdColor(int paramInt, boolean paramBoolean, String paramString)
  {
    m = 0;
    int k;
    if (paramString == null)
    {
      k = 0;
    }
    else
    {
      String str = paramString;
      if (paramString.startsWith("#")) {
        str = paramString.replace("#", "");
      }
      paramString = str;
      if (str.length() > 6) {
        paramString = str.substring(str.length() - 6, str.length());
      }
      k = 1;
    }
    n = -1;
    j = m;
    i = n;
    if (k != 0) {}
    try
    {
      i = Integer.parseInt(paramString, 16);
      i |= 0xFF000000;
      j = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        j = m;
        i = n;
      }
    }
    if (j != 0) {
      return i;
    }
    j = i;
    if (paramBoolean)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4) {
                return i;
              }
              return -35755;
            }
            return -627103;
          }
          return -10249473;
        }
        return -23224;
      }
      j = -33153;
    }
    return j;
  }
  
  public int compareTo(AdData paramAdData)
  {
    int i = this.position;
    int j = paramAdData.position;
    if (i > j) {
      return 1;
    }
    if (i == j) {
      return 0;
    }
    return -1;
  }
  
  public boolean parseJson(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      Object localObject = paramString;
      if (paramString.endsWith(",}"))
      {
        paramString = paramString.substring(0, paramString.length() - 2);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("}");
        localObject = ((StringBuilder)localObject).toString();
      }
      try
      {
        paramString = new JSONObject((String)localObject);
        this.title = paramString.optString("title");
        this.content = paramString.optString("content");
        this.content2 = paramString.optString("content2");
        this.typeUI = paramString.optInt("type");
        this.img_url = paramString.optString("img_url");
        if (this.img_url != null) {
          this.img_url = this.img_url.trim();
        }
        this.jump_url = paramString.optString("jump_url");
        this.actionData = paramString.optString("actionData");
        this.expose_url = paramString.optString("expose_url");
        localObject = paramString.optString("bg_color");
        this.bgColor = parseAdColor(this.ad_source, true, (String)localObject);
        localObject = paramString.optString("font_color");
        this.fontColor = parseAdColor(this.ad_source, false, (String)localObject);
        localObject = paramString.optString("corner_wording");
        this.wording = getWording(this.ad_source, (String)localObject);
        this.distance = paramString.optString("distance");
        this.id = paramString.optLong("id");
        this.idType = paramString.optInt("id_type");
        if (paramString.has("pic_type")) {
          this.picType = paramString.optInt("pic_type");
        }
        this.logo_url = paramString.optString("logo_url");
        if (paramString.has("content_color")) {
          this.contentColor = paramString.optString("content_color");
        }
        if (paramString.has("content_color")) {
          this.hasAvatarAnimation = paramString.optString("hasAvatarAnimation");
        }
        if (paramString.has("content_color")) {
          this.avatarBgGif = paramString.optString("avatarBgGif");
        }
        if (paramString.has("content_color")) {
          this.nowBoardcastWording = paramString.optString("nowBoardcastWording");
        }
        if (paramString.has("content_color")) {
          this.nowBoardcastGif = paramString.optString("nowBoardcastGif");
        }
        paramString = this.img_url;
        if (paramString != null) {
          return paramString.startsWith("http");
        }
        return false;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w(AdData.class.getSimpleName(), 2, paramString.getMessage());
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.struct.AdData
 * JD-Core Version:    0.7.0.1
 */