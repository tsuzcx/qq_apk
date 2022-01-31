package com.tencent.ttpic.model;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.util.LogUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WMLogic
{
  private static final String TAG = WMLogic.class.getSimpleName();
  private static final String TYPE_CASE = "case";
  public static final String TYPE_COUNTDOWN = "countdown";
  private static final String TYPE_RANGE = "range";
  public static final String TYPE_SINCE = "since";
  public String compare;
  public String data;
  public List<WMLogicPair> range;
  public String type;
  public List<WMLogicPair> wmcase;
  
  public String getValue(String paramString)
  {
    String str = "";
    if (this.type.equals("case"))
    {
      paramString = LogicDataManager.getInstance().getValue(this.data);
      Iterator localIterator = this.wmcase.iterator();
      do
      {
        localObject = str;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (WMLogicPair)localIterator.next();
      } while (!((WMLogicPair)localObject).key.equals(paramString));
      localObject = ((WMLogicPair)localObject).value;
    }
    int i;
    int j;
    label361:
    do
    {
      for (;;)
      {
        return localObject;
        if (this.type.equals("range")) {
          try
          {
            paramString = LogicDataManager.getInstance().getValue(this.data);
            i = 0;
            for (;;)
            {
              localObject = str;
              if (i >= this.range.size()) {
                break;
              }
              if ((Integer.parseInt(paramString) <= Integer.parseInt(((WMLogicPair)this.range.get(i)).key)) || (i == this.range.size() - 1))
              {
                paramString = ((WMLogicPair)this.range.get(i)).value;
                return paramString;
              }
              i += 1;
            }
            if (!this.type.equals("since")) {
              break label361;
            }
          }
          catch (NumberFormatException paramString)
          {
            LogUtil.e(TAG, paramString.getMessage());
            return "";
          }
        }
      }
      localObject = new SimpleDateFormat("yyyy-MM-dd");
      if (!TextUtils.isEmpty(paramString))
      {
        j = VideoUtil.daysBetween(paramString, ((SimpleDateFormat)localObject).format(new Date()));
        i = 0;
      }
      for (;;)
      {
        paramString = str;
        if (i < this.range.size())
        {
          if ((j <= Integer.parseInt(((WMLogicPair)this.range.get(i)).key)) || (i == this.range.size() - 1)) {
            paramString = ((WMLogicPair)this.range.get(i)).value;
          }
        }
        else
        {
          return String.format(paramString, new Object[] { Integer.valueOf(j) });
          paramString = this.compare;
          break;
        }
        i += 1;
      }
      localObject = str;
    } while (!this.type.equals("countdown"));
    Object localObject = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    if (!TextUtils.isEmpty(paramString))
    {
      j = VideoUtil.daysBetween((String)localObject, paramString);
      i = 0;
    }
    for (;;)
    {
      paramString = str;
      if (i < this.range.size())
      {
        if ((j <= Integer.parseInt(((WMLogicPair)this.range.get(i)).key)) || (i == this.range.size() - 1)) {
          paramString = ((WMLogicPair)this.range.get(i)).value;
        }
      }
      else
      {
        return String.format(paramString, new Object[] { Integer.valueOf(j) });
        paramString = this.compare;
        break;
      }
      i += 1;
    }
  }
  
  public void setCompare(String paramString1, String paramString2)
  {
    if (this.type.equals("since"))
    {
      paramString2 = VideoPrefsUtil.getDefaultPrefs().getString("prefs_key_watermark_since_" + paramString2, "");
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString2;
      }
      for (;;)
      {
        this.compare = paramString1;
        return;
      }
    }
    if (this.type.equals("countdown"))
    {
      paramString2 = VideoPrefsUtil.getDefaultPrefs().getString("prefs_key_watermark_countdown_" + paramString2, "");
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString2;
      }
      for (;;)
      {
        this.compare = paramString1;
        return;
      }
    }
    this.compare = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.WMLogic
 * JD-Core Version:    0.7.0.1
 */