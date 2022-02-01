package com.tencent.mobileqq.colornote.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ColorNoteRecentConfBean
{
  private int a = 1;
  
  public static ColorNoteRecentConfBean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteRecentConfBean", 2, String.format("parse content=%s", new Object[] { paramString }));
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        ColorNoteRecentConfBean localColorNoteRecentConfBean = new ColorNoteRecentConfBean();
        localColorNoteRecentConfBean.a = new JSONObject(paramString).getInt("ifrecent");
        return localColorNoteRecentConfBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ColorNoteRecentConfBean", 2, "ColorNoteRecentConfBean parse err: ", paramString);
    return null;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteRecentConfBean
 * JD-Core Version:    0.7.0.1
 */