package com.tencent.mobileqq.troop.homework.recite.data;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;

public class WordInfo
  implements Serializable
{
  public static final int COLOR_DEFAULT = Color.parseColor("#424245");
  public static final int COLOR_DEFAULT_PINYIN = Color.parseColor("#777777");
  public static final int COLOR_GRAY = -7829368;
  public static final int COLOR_REMIND = -7829368;
  public static final int COLOR_WRONG = Color.parseColor("#FF7474");
  public int color = this.colors[0];
  public int colorPinyin = this.colorsPinyin[0];
  private int[] colors = { COLOR_DEFAULT, COLOR_WRONG, -7829368, -7829368 };
  private int[] colorsPinyin = { COLOR_DEFAULT_PINYIN, COLOR_WRONG, -7829368, -7829368 };
  public boolean isDetected;
  public boolean isReminded;
  public int paragraphPos;
  public ArrayList<String> pinyin2Detect = new ArrayList();
  public String pinyin2Display;
  public String text;
  public int wordPos;
  
  public WordInfo() {}
  
  public WordInfo(String paramString1, String paramString2)
  {
    this.text = paramString2;
    this.pinyin2Display = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {
      this.pinyin2Detect.add(paramString1);
    }
    this.color = this.colors[0];
  }
  
  public int getStatus()
  {
    int i = 0;
    while (i < this.colors.length)
    {
      if (this.color == this.colors[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public boolean isNormalWord()
  {
    return !TextUtils.isEmpty(this.pinyin2Display);
  }
  
  public boolean isPinyinDetectRight(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if ((this.pinyin2Detect == null) || (this.pinyin2Detect.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReciteDetect.WordInfo", 2, "pinyin2Detect is empty, text:" + this.text + " targetPinyin = " + paramString);
        }
        return true;
      }
      int i = 0;
      while (i < this.pinyin2Detect.size())
      {
        if (paramString.equalsIgnoreCase(((String)this.pinyin2Detect.get(i)).replace("​", ""))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void resetStatus()
  {
    this.color = COLOR_DEFAULT;
    this.isReminded = false;
    this.isDetected = false;
  }
  
  public void setColor(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.colors.length))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReciteDetect.WordInfo", 2, "setColor status error:" + paramInt);
      }
      return;
    }
    this.color = this.colors[paramInt];
    this.colorPinyin = this.colorsPinyin[paramInt];
  }
  
  public String toString()
  {
    return "WordInfo{text='" + this.text + '\'' + ", pinyin2Display='" + this.pinyin2Display + '\'' + ", pinyin2Detect=" + this.pinyin2Detect.toString() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.data.WordInfo
 * JD-Core Version:    0.7.0.1
 */