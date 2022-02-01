package com.tencent.mobileqq.colornote.data;

import android.text.TextUtils;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ColorNoteConfBean
{
  int a = -1;
  
  public static ColorNoteConfBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      localObject = new ColorNoteConfBean();
      ((ColorNoteConfBean)localObject).a = new JSONObject(paramString).optInt("maxcount", ColorNoteConstants.a);
      ColorNoteConstants.a = ((ColorNoteConfBean)localObject).a;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("ColorNoteConfigProcessor onParsed maxcount ");
        paramString.append(((ColorNoteConfBean)localObject).a);
        QLog.e("ColorNoteConfigProcessor", 2, paramString.toString());
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ColorNoteConfigProcessor onParsed erro ");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("ColorNoteConfigProcessor", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public int a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteConfBean
 * JD-Core Version:    0.7.0.1
 */