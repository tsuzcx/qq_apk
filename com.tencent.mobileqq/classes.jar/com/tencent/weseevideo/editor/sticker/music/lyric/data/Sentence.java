package com.tencent.weseevideo.editor.sticker.music.lyric.data;

import android.graphics.Paint;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class Sentence
{
  private static final String TAG = "Sentence";
  public SentenceAttachInfo mBitmapLeftAttachInfo = null;
  public ArrayList<LyricCharacter> mCharacters;
  public long mDuration;
  public SentenceAttachInfo mNormalLeftAttachInfo = null;
  public long mStartTime;
  public String mText;
  public ArrayList<LyricCharacter> mUICharacters;
  public ArrayList<SentenceUI> mUILine = new ArrayList();
  
  public Sentence() {}
  
  public Sentence(SentenceUI paramSentenceUI)
  {
    if (paramSentenceUI == null) {
      return;
    }
    this.mText = paramSentenceUI.mText;
    this.mCharacters = paramSentenceUI.mCharacters;
    this.mStartTime = paramSentenceUI.getStartTime();
    this.mDuration = (paramSentenceUI.getEndTime() - paramSentenceUI.getStartTime());
  }
  
  private boolean isInCharacter(LyricCharacter paramLyricCharacter1, LyricCharacter paramLyricCharacter2)
  {
    return (paramLyricCharacter2.mStart >= paramLyricCharacter1.mStart) && (paramLyricCharacter2.mEnd <= paramLyricCharacter1.mEnd);
  }
  
  private ArrayList<LyricCharacter> rerangeLyricCharacterList(String paramString, String[] paramArrayOfString, ArrayList<LyricCharacter> paramArrayList)
  {
    if (paramArrayOfString.length == 1) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    Iterator localIterator = paramArrayList.iterator();
    LyricCharacter localLyricCharacter;
    int j;
    int i1;
    int i3;
    if (localIterator.hasNext())
    {
      localLyricCharacter = (LyricCharacter)localIterator.next();
      j = i;
      i1 = n;
      int i2 = m;
      if (i <= localLyricCharacter.mStart)
      {
        if (m != paramArrayOfString.length - 1) {
          break label190;
        }
        j = this.mText.length();
        k = i;
        i2 = m;
        i1 = n;
      }
      for (;;)
      {
        paramArrayList = localLyricCharacter;
        m = j;
        n = i1;
        i = i2;
        i3 = k;
        if (localLyricCharacter.mStart < k) {
          break label243;
        }
        paramArrayList = localLyricCharacter;
        m = j;
        n = i1;
        i = i2;
        i3 = k;
        if (j < localLyricCharacter.mEnd) {
          break label243;
        }
        localArrayList.add(localLyricCharacter);
        i = j;
        n = i1;
        m = i2;
        break;
        label190:
        i1 = n + paramArrayOfString[m].length();
        i2 = m + 1;
        j = paramString.indexOf(paramArrayOfString[i2], i1);
        k = i;
      }
    }
    label348:
    label478:
    for (;;)
    {
      i3 = m;
      m = i;
      i = j;
      n = k;
      label243:
      if ((paramArrayList.mStart < m) && (paramArrayList.mEnd > m))
      {
        long l = (1.0F * (float)paramArrayList.mDuration * (m - paramArrayList.mStart) / (paramArrayList.mEnd - paramArrayList.mStart));
        localLyricCharacter = new LyricCharacter(paramArrayList.mStartTime, l, paramArrayList.mStart, m);
        paramArrayList = new LyricCharacter(paramArrayList.mStartTime + l, paramArrayList.mDuration - l, m, paramArrayList.mEnd);
        localArrayList.add(localLyricCharacter);
        if (m >= paramArrayList.mEnd) {
          break label461;
        }
        if (i == paramArrayOfString.length - 1)
        {
          k = this.mText.length();
          j = i;
          i = k;
          k = n;
        }
      }
      for (;;)
      {
        if (i < paramArrayList.mEnd) {
          break label478;
        }
        localArrayList.add(paramArrayList);
        i1 = m;
        n = k;
        m = j;
        k = i1;
        break;
        k = paramArrayOfString[i].length() + n;
        j = i + 1;
        i = paramString.indexOf(paramArrayOfString[j], k);
        continue;
        return localArrayList;
        break label348;
        k = n;
        j = i;
        i = m;
        m = i3;
      }
    }
  }
  
  public void generateUILyricLineList(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(this.mText)) {}
    int k;
    int j;
    String[] arrayOfString;
    int i7;
    do
    {
      return;
      this.mUILine.clear();
      k = (int)paramPaint1.measureText(this.mText);
      j = 0;
      i = 0;
      if (k <= paramInt)
      {
        if (!paramBoolean2)
        {
          j = paramInt - (int)paramPaint2.measureText(this.mText) >> 1;
          i = paramInt - k >> 1;
        }
        paramPaint1 = new SentenceUI(this.mText, j, i, this.mCharacters);
        if (this.mBitmapLeftAttachInfo != null) {}
        for (paramPaint1.mLeftAttachInfo = this.mBitmapLeftAttachInfo;; paramPaint1.mLeftAttachInfo = this.mNormalLeftAttachInfo)
        {
          this.mUILine.add(paramPaint1);
          return;
        }
      }
      if (paramBoolean1)
      {
        paramPaint1 = new SentenceUI(this.mText, 0, 0, this.mCharacters);
        if (this.mBitmapLeftAttachInfo != null) {}
        for (paramPaint1.mLeftAttachInfo = this.mBitmapLeftAttachInfo;; paramPaint1.mLeftAttachInfo = this.mNormalLeftAttachInfo)
        {
          this.mUILine.add(paramPaint1);
          return;
        }
      }
      arrayOfString = LyricDataUtil.wrap(this.mText, paramPaint1, paramInt, paramInt);
      i7 = arrayOfString.length;
    } while (i7 <= 0);
    int n = 0;
    int i = 0;
    ArrayList localArrayList;
    if (this.mCharacters != null)
    {
      localArrayList = rerangeLyricCharacterList(this.mText, arrayOfString, this.mCharacters);
      this.mUICharacters = localArrayList;
    }
    for (;;)
    {
      int i4 = 0;
      int i2 = 0;
      int i1 = 0;
      int m = 0;
      j = 0;
      k = 0;
      label259:
      Object localObject;
      int i6;
      int i3;
      label297:
      int i5;
      LyricCharacter localLyricCharacter;
      if (i4 < i7)
      {
        localObject = arrayOfString[i4];
        i6 = ((String)localObject).length();
        if (!paramBoolean2) {
          break label567;
        }
        i3 = i2;
        i2 = i1;
        i1 = i3;
        if (localArrayList == null) {
          break label811;
        }
        n += i6;
        localObject = new ArrayList();
        i5 = j;
        i3 = m;
        j = k;
        k = i5;
        if (i3 >= localArrayList.size()) {
          break label780;
        }
        localLyricCharacter = (LyricCharacter)localArrayList.get(i3);
        if ((i4 == 0) || (i != i3)) {
          break label765;
        }
        k = n - i6;
        m = localLyricCharacter.mStart;
        j = k;
        k = m - k;
        label393:
        if ((localLyricCharacter.mStart > n) || (localLyricCharacter.mEnd < n)) {
          break label643;
        }
        if (i4 != 0) {
          break label600;
        }
        ((ArrayList)localObject).add(new LyricCharacter(localLyricCharacter.mStartTime, localLyricCharacter.mDuration, localLyricCharacter.mStart, i6));
        label448:
        i = i3 + 1;
        i3 = i;
        m = n;
        n = k;
        k = i3;
      }
      for (;;)
      {
        if (i4 == 0) {
          localObject = new SentenceUI(arrayOfString[i4], i2, i1, (ArrayList)localObject);
        }
        for (((SentenceUI)localObject).mLeftAttachInfo = this.mBitmapLeftAttachInfo;; ((SentenceUI)localObject).mLeftAttachInfo = this.mNormalLeftAttachInfo)
        {
          this.mUILine.add(localObject);
          i6 = i4 + 1;
          i5 = n;
          n = k;
          i3 = m;
          i4 = i2;
          k = i5;
          m = i;
          i2 = i1;
          i = n;
          n = i3;
          i1 = i4;
          i4 = i6;
          break label259;
          break;
          label567:
          i2 = (int)paramPaint2.measureText((String)localObject);
          i1 = paramInt - (int)paramPaint1.measureText((String)localObject) >> 1;
          i2 = paramInt - i2 >> 1;
          break label297;
          label600:
          i = localLyricCharacter.mStart;
          ((ArrayList)localObject).add(new LyricCharacter(localLyricCharacter.mStartTime, localLyricCharacter.mDuration, i - j - k, i6));
          break label448;
          label643:
          if (i4 == 0) {
            ((ArrayList)localObject).add(localLyricCharacter);
          }
          for (;;)
          {
            m = k;
            i3 += 1;
            k = j;
            j = m;
            break;
            m = localLyricCharacter.mStart;
            i5 = localLyricCharacter.mEnd;
            ((ArrayList)localObject).add(new LyricCharacter(localLyricCharacter.mStartTime, localLyricCharacter.mDuration, m - j - k, i5 - j - k));
          }
          localObject = new SentenceUI(arrayOfString[i4], i2, i1, (ArrayList)localObject);
        }
        label765:
        m = j;
        j = k;
        k = m;
        break label393;
        label780:
        i5 = k;
        i6 = j;
        m = n;
        k = i;
        j = i5;
        n = i6;
        i = i3;
        continue;
        label811:
        i3 = k;
        i5 = m;
        localObject = null;
        m = n;
        k = i;
        n = i3;
        i = i5;
      }
      localArrayList = null;
    }
  }
  
  public Sentence getCopy()
  {
    Sentence localSentence = new Sentence();
    localSentence.mText = this.mText;
    localSentence.mDuration = this.mDuration;
    localSentence.mStartTime = this.mStartTime;
    if (this.mCharacters != null)
    {
      localSentence.mCharacters = new ArrayList();
      localSentence.mCharacters.addAll(this.mCharacters);
    }
    localSentence.mUILine.addAll(this.mUILine);
    return localSentence;
  }
  
  public ArrayList<SentenceUI> getUILyricLineList()
  {
    return this.mUILine;
  }
  
  public int getUiLineSize()
  {
    return this.mUILine.size();
  }
  
  public int[] marshalMarkCharacter(int[] paramArrayOfInt)
  {
    if (this.mUICharacters == null) {
      return paramArrayOfInt;
    }
    int[] arrayOfInt = new int[this.mUICharacters.size()];
    int j = 0;
    int i = 0;
    while (j < this.mCharacters.size())
    {
      LyricCharacter localLyricCharacter = (LyricCharacter)this.mCharacters.get(j);
      while ((i < this.mUICharacters.size()) && (isInCharacter(localLyricCharacter, (LyricCharacter)this.mUICharacters.get(i))))
      {
        arrayOfInt[i] = paramArrayOfInt[j];
        i += 1;
      }
      j += 1;
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence
 * JD-Core Version:    0.7.0.1
 */