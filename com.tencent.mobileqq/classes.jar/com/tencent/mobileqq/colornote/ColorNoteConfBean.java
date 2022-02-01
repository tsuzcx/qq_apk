package com.tencent.mobileqq.colornote;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ColorNoteConfBean
{
  int a = -1;
  
  public static ColorNoteConfBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        ColorNoteConfBean localColorNoteConfBean = new ColorNoteConfBean();
        localColorNoteConfBean.a = new JSONObject(paramString).getInt("maxcount");
        com.tencent.mobileqq.colornote.data.ColorNoteProxy.a = localColorNoteConfBean.a;
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteConfigProcessor", 2, "ColorNoteConfigProcessor onParsed maxcount " + localColorNoteConfBean.a);
        }
        return localColorNoteConfBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ColorNoteConfigProcessor", 2, "ColorNoteConfigProcessor onParsed erro " + paramString.toString());
    return null;
  }
  
  public int a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteConfBean
 * JD-Core Version:    0.7.0.1
 */