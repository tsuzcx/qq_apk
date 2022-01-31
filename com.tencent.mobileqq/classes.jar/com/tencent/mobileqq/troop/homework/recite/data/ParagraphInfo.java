package com.tencent.mobileqq.troop.homework.recite.data;

import amsl;
import android.text.TextUtils;
import bcyk;
import bcym;
import com.tencent.mobileqq.troop.homework.recite.ui.PinyinTextView;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParagraphInfo
  implements Serializable
{
  @bcyk(a="con_py_tone_mark")
  public String con_py_tone_mark;
  @bcyk(a="content_html")
  public String content_html;
  @bcyk(a="content_pinyin")
  public String content_pinyin;
  @bcym
  private String[] mContents;
  @bcym
  private String[] mDisplayPinyins;
  @bcym
  private String[] mOriginalPinyins;
  @bcym
  public int paragraphPos = -1;
  @bcyk(a="pid")
  public int pid;
  @bcym
  public List<WordInfo> wordList;
  
  public String[] generateOrGetContents()
  {
    int i = 0;
    if (this.mContents != null) {
      return this.mContents;
    }
    if (TextUtils.isEmpty(this.content_html)) {
      return new String[0];
    }
    this.content_html = amsl.a(this.content_html.trim()).replace("​", "");
    this.mContents = new String[this.content_html.length()];
    while (i < this.content_html.length())
    {
      char c = this.content_html.charAt(i);
      String str = c + "";
      this.mContents[i] = str;
      i += 1;
    }
    return this.mContents;
  }
  
  public String[] generateOrGetPinyinWithTone()
  {
    if (this.mDisplayPinyins != null) {
      return this.mDisplayPinyins;
    }
    if (TextUtils.isEmpty(this.con_py_tone_mark)) {
      return generateOrgetDisplayPinyins();
    }
    this.con_py_tone_mark = this.con_py_tone_mark.replace("​", " ");
    this.mDisplayPinyins = this.con_py_tone_mark.split(" ");
    return this.mDisplayPinyins;
  }
  
  public List<WordInfo> generateOrGetWordInfoList(int paramInt)
  {
    if (this.wordList != null) {
      return this.wordList;
    }
    generateOrgetOriginalPinyins();
    generateOrGetPinyinWithTone();
    generateOrGetContents();
    this.wordList = new ArrayList(this.mContents.length);
    if (this.mDisplayPinyins == null) {
      return this.wordList;
    }
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        if (i < this.mContents.length)
        {
          WordInfo localWordInfo = new WordInfo();
          localWordInfo.paragraphPos = paramInt;
          localWordInfo.wordPos = i;
          localWordInfo.text = this.mContents[i];
          if (!PinyinTextView.a(localWordInfo.text))
          {
            localWordInfo.pinyin2Display = this.mDisplayPinyins[i];
            Object localObject = this.mOriginalPinyins[i];
            ArrayList localArrayList = new ArrayList();
            j = ((String)localObject).indexOf("[");
            if (j != -1)
            {
              localArrayList.add(((String)localObject).substring(0, j));
              localObject = ((String)localObject).substring(j + 1, ((String)localObject).length() - 1);
              if (((String)localObject).contains("，"))
              {
                localObject = ((String)localObject).split("，");
                break label317;
                if (j < localObject.length)
                {
                  localArrayList.add(localObject[j]);
                  j += 1;
                  continue;
                }
              }
              else
              {
                localObject = ((String)localObject).split(",");
                break label317;
              }
            }
            else
            {
              localArrayList.add(localObject);
            }
            localWordInfo.pinyin2Detect = localArrayList;
          }
          else
          {
            this.wordList.add(localWordInfo);
            i += 1;
          }
        }
        else
        {
          return this.wordList;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(ParagraphInfo.class.getSimpleName(), 2, "IndexOutOfBoundsException:" + localIndexOutOfBoundsException.toString());
        }
      }
      label317:
      if (localIndexOutOfBoundsException != null) {
        j = 0;
      }
    }
  }
  
  public String[] generateOrgetDisplayPinyins()
  {
    if (this.mDisplayPinyins != null) {
      return this.mDisplayPinyins;
    }
    if (TextUtils.isEmpty(this.content_pinyin)) {
      return new String[0];
    }
    this.content_pinyin = this.content_pinyin.replace("​", " ");
    this.mDisplayPinyins = this.content_pinyin.split(" ");
    int i = 0;
    while (i < this.mDisplayPinyins.length)
    {
      int j = this.mDisplayPinyins[i].indexOf("[");
      if (j > 0) {
        this.mDisplayPinyins[i] = this.mDisplayPinyins[i].substring(0, j);
      }
      i += 1;
    }
    return this.mDisplayPinyins;
  }
  
  public String[] generateOrgetOriginalPinyins()
  {
    if (this.mOriginalPinyins != null) {
      return this.mOriginalPinyins;
    }
    if (TextUtils.isEmpty(this.content_pinyin)) {
      return new String[0];
    }
    this.content_pinyin = this.content_pinyin.trim();
    this.mOriginalPinyins = this.content_pinyin.split(" ");
    return this.mOriginalPinyins;
  }
  
  public void resetWordsReciteStatus()
  {
    if (this.wordList != null)
    {
      Iterator localIterator = this.wordList.iterator();
      while (localIterator.hasNext()) {
        ((WordInfo)localIterator.next()).resetStatus();
      }
    }
  }
  
  public void setWordColor(int paramInt)
  {
    if (this.wordList == null) {
      generateOrGetWordInfoList(this.paragraphPos);
    }
    if (this.wordList != null)
    {
      Iterator localIterator = this.wordList.iterator();
      while (localIterator.hasNext()) {
        ((WordInfo)localIterator.next()).setColor(paramInt);
      }
    }
  }
  
  public String toString()
  {
    return "ParagraphInfo{content_html='" + this.content_html + '\'' + ", content_pinyin='" + this.content_pinyin + '\'' + ", pid=" + this.pid + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo
 * JD-Core Version:    0.7.0.1
 */