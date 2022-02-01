package com.tencent.mobileqq.struct;

import com.tencent.common.app.AppInterface;
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
  public boolean hasShow;
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
    switch (paramInt)
    {
    default: 
      paramString = BaseApplicationImpl.getContext().getString(2131695348);
    }
    for (;;)
    {
      return paramString;
      paramString = BaseApplicationImpl.getContext().getString(2131697863);
      continue;
      paramString = BaseApplicationImpl.getContext().getString(2131690950);
      continue;
      paramString = BaseApplicationImpl.getContext().getString(2131698076);
      continue;
      paramString = BaseApplicationImpl.getContext().getString(2131692876);
    }
  }
  
  public static int parseAdColor(int paramInt, boolean paramBoolean, String paramString)
  {
    int j = 0;
    int i;
    if (paramString == null) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
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
            label28:
            i = -1;
          }
        }
        if (j == 0) {
          break label102;
        }
      }
      String str;
      label102:
      while (!paramBoolean)
      {
        return i;
        str = paramString;
        if (paramString.startsWith("#")) {
          str = paramString.replace("#", "");
        }
        if (str.length() <= 6) {
          break label158;
        }
        paramString = str.substring(str.length() - 6, str.length());
        i = 1;
        break;
        i = -1;
        break label28;
      }
      switch (paramInt)
      {
      default: 
        return i;
      case 0: 
        return -33153;
      case 1: 
        return -23224;
      case 2: 
        return -10249473;
      case 3: 
        return -627103;
      }
      return -35755;
      label158:
      i = 1;
      paramString = str;
    }
  }
  
  public static final void reportTValue(AppInterface paramAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str;
    switch (paramInt2)
    {
    case 6: 
    case 7: 
    default: 
      str = null;
      if (str == null) {
        return;
      }
      break;
    case 0: 
      if (paramBoolean) {}
      for (str = "0X8005B64";; str = "0X8005B65") {
        break;
      }
    case 4: 
      if (paramBoolean) {}
      for (str = "0X8005684";; str = "0X8005685") {
        break;
      }
    case 3: 
      if (paramBoolean) {}
      for (str = "0X8005682";; str = "0X8005683") {
        break;
      }
    case 2: 
      if (paramBoolean) {}
      for (str = "0X8005680";; str = "0X8005681") {
        break;
      }
    case 1: 
      if (paramBoolean) {}
      for (str = "0X800567E";; str = "0X800567F") {
        break;
      }
    case 5: 
      if (paramBoolean) {}
      for (str = "0X8005ADA";; str = "0X8005ADB") {
        break;
      }
    case 8: 
      if (paramBoolean) {}
      for (str = "0X800621F";; str = "0X8006220") {
        break;
      }
    case 9: 
      if (paramBoolean) {}
      for (str = "0X8006833";; str = "0X8006834") {
        break;
      }
    }
    paramAppInterface.reportClickEvent("CliOper", "", "", str, str, 0, 0, Integer.toString(paramInt1), "", "", "");
  }
  
  public int compareTo(AdData paramAdData)
  {
    if (this.position > paramAdData.position) {
      return 1;
    }
    if (this.position == paramAdData.position) {
      return 0;
    }
    return -1;
  }
  
  public boolean parseJson(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.length() == 0)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      String str = paramString;
      if (paramString.endsWith(",}"))
      {
        paramString = paramString.substring(0, paramString.length() - 2);
        str = paramString + "}";
      }
      try
      {
        paramString = new JSONObject(str);
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
        str = paramString.optString("bg_color");
        this.bgColor = parseAdColor(this.ad_source, true, str);
        str = paramString.optString("font_color");
        this.fontColor = parseAdColor(this.ad_source, false, str);
        str = paramString.optString("corner_wording");
        this.wording = getWording(this.ad_source, str);
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
        if ((this.img_url == null) || (!this.img_url.startsWith("http"))) {
          return false;
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.struct.AdData
 * JD-Core Version:    0.7.0.1
 */