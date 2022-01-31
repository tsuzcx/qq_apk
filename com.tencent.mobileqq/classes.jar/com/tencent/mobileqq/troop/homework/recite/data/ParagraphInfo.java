package com.tencent.mobileqq.troop.homework.recite.data;

import android.text.TextUtils;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.troop.homework.recite.ui.PinyinTextView;
import com.tencent.mobileqq.util.JSONUtils.FieldName;
import com.tencent.mobileqq.util.JSONUtils.NotKey;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParagraphInfo
  implements Serializable
{
  @JSONUtils.FieldName(a="content_html")
  public String content_html;
  @JSONUtils.FieldName(a="content_pinyin")
  public String content_pinyin;
  @JSONUtils.NotKey
  private String[] mContents;
  @JSONUtils.NotKey
  private String[] mDisplayPinyins;
  @JSONUtils.NotKey
  private String[] mOriginalPinyins;
  @JSONUtils.NotKey
  public int paragraphPos = -1;
  @JSONUtils.FieldName(a="pid")
  public int pid;
  @JSONUtils.NotKey
  public List wordList;
  
  public String[] generateOrGetContents()
  {
    int i = 0;
    if (this.mContents != null) {
      return this.mContents;
    }
    if (TextUtils.isEmpty(this.content_html)) {
      return new String[0];
    }
    this.content_html = ArConfigUtils.a(this.content_html.trim()).replace("​", "");
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
  
  public List generateOrGetWordInfoList(int paramInt)
  {
    if (this.wordList != null) {
      return this.wordList;
    }
    generateOrgetOriginalPinyins();
    generateOrgetDisplayPinyins();
    generateOrGetContents();
    this.wordList = new ArrayList(this.mContents.length);
    int i = 0;
    try
    {
      while (i < this.mContents.length)
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
          int j = ((String)localObject).indexOf("[");
          if (j != -1)
          {
            localArrayList.add(((String)localObject).substring(0, j));
            localObject = ((String)localObject).substring(j + 1, ((String)localObject).length() - 1).split(",");
            j = 0;
            while (j < localObject.length)
            {
              localArrayList.add(localObject[j]);
              j += 1;
            }
          }
          localArrayList.add(localObject);
          localWordInfo.pinyin2Detect = localArrayList;
        }
        this.wordList.add(localWordInfo);
        i += 1;
      }
      return this.wordList;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(ParagraphInfo.class.getSimpleName(), 2, "IndexOutOfBoundsException:" + localIndexOutOfBoundsException.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo
 * JD-Core Version:    0.7.0.1
 */