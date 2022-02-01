package com.tencent.weseevideo.editor.sticker.music.lyric.data;

import android.graphics.Paint;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lyric
{
  public static final int LYRIC_TYPE_LRC = 1;
  public static final int LYRIC_TYPE_QRC = 2;
  private static final String TAG = "Lyric";
  private Sentence mLastHitSentence;
  private int mLastHitSentenceNo;
  public ArrayList<SentenceUI> mListSentenceUI = new ArrayList();
  @Deprecated
  public int mOffset;
  public ArrayList<Sentence> mSentences;
  public int mType;
  private int mUILineCount = 0;
  
  public Lyric(int paramInt1, int paramInt2, ArrayList<Sentence> paramArrayList)
  {
    this.mType = paramInt1;
    this.mOffset = paramInt2;
    this.mSentences = paramArrayList;
  }
  
  public void clear()
  {
    this.mUILineCount = 0;
    if (this.mSentences != null) {
      this.mSentences.clear();
    }
    if (this.mListSentenceUI != null) {
      this.mListSentenceUI.clear();
    }
    this.mLastHitSentence = null;
    this.mLastHitSentenceNo = 0;
  }
  
  public void copy(Lyric paramLyric)
  {
    this.mType = paramLyric.mType;
    this.mOffset = paramLyric.mOffset;
    if (this.mSentences == null) {
      this.mSentences = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = paramLyric.mSentences.iterator();
      while (localIterator.hasNext())
      {
        Sentence localSentence = (Sentence)localIterator.next();
        this.mSentences.add(localSentence.getCopy());
      }
      this.mSentences.clear();
    }
    this.mUILineCount = paramLyric.getUILineSize();
    Log.d("Lyric", "copy -> mType : " + this.mType);
  }
  
  public int countSentence(int paramInt1, int paramInt2)
  {
    if (isEmpty()) {}
    do
    {
      return 0;
      paramInt1 = findLineNoByStartTime(paramInt1);
      paramInt2 = findEndLineByStartTime(paramInt2);
    } while ((paramInt1 < 0) || (paramInt2 < paramInt1));
    return paramInt2 - paramInt1 + 1;
  }
  
  public String findCharacterByTime(long paramLong)
  {
    if ((this.mSentences == null) || (this.mSentences.isEmpty()) || (paramLong < 0L)) {
      return null;
    }
    int j = this.mSentences.size();
    int i = 0;
    while (i < j)
    {
      Sentence localSentence = (Sentence)this.mSentences.get(i);
      String str2;
      Object localObject;
      if ((paramLong >= localSentence.mStartTime) && (paramLong <= localSentence.mStartTime + localSentence.mDuration))
      {
        str2 = localSentence.mText;
        if (localSentence.mCharacters != null)
        {
          j = localSentence.mCharacters.size();
          if (j > 0)
          {
            i = 0;
            localObject = null;
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i < j)
          {
            LyricCharacter localLyricCharacter = (LyricCharacter)localSentence.mCharacters.get(i);
            if (i < j - 1) {
              localObject = (LyricCharacter)localSentence.mCharacters.get(i + 1);
            }
            if ((localLyricCharacter.mStartTime <= paramLong) && (localObject != null) && (((LyricCharacter)localObject).mStartTime > paramLong))
            {
              if (i == j - 1) {}
              try
              {
                return localSentence.mText.substring(localLyricCharacter.mStart, localSentence.mText.length());
              }
              catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException1)
              {
                localStringIndexOutOfBoundsException1.printStackTrace();
                return str2;
              }
              if (localSentence.mText.length() >= localLyricCharacter.mEnd) {
                return localSentence.mText.substring(localLyricCharacter.mStart, localLyricCharacter.mEnd);
              }
              localObject = localSentence.mText.substring(localLyricCharacter.mStart, localSentence.mText.length());
              return localObject;
            }
            if ((localLyricCharacter.mStartTime <= paramLong) && (localLyricCharacter.mStartTime + localLyricCharacter.mDuration >= paramLong))
            {
              if (i == j - 1) {}
              try
              {
                return localSentence.mText.substring(localLyricCharacter.mStart, localSentence.mText.length());
              }
              catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException2)
              {
                String str1;
                localStringIndexOutOfBoundsException2.printStackTrace();
                return str2;
              }
              if (localSentence.mText.length() >= localLyricCharacter.mEnd) {
                return localSentence.mText.substring(localLyricCharacter.mStart, localLyricCharacter.mEnd);
              }
              str1 = localSentence.mText.substring(localLyricCharacter.mStart, localSentence.mText.length());
              return str1;
            }
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
      }
      return str2;
    }
    return null;
  }
  
  public int findEndLineByStartTime(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      Log.w("Lyric", "findEndLineByStartTime -> illegal time");
      i = 0;
      return i;
    }
    ArrayList localArrayList = this.mSentences;
    if (localArrayList == null)
    {
      Log.w("Lyric", "findEndLineByStartTime -> sentence data not found");
      return -1;
    }
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      Sentence localSentence = (Sentence)localArrayList.get(j);
      if (localSentence == null) {}
      while (paramInt > localSentence.mStartTime)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j != k) {
        break;
      }
      return k - 1;
    }
  }
  
  public int findLineNo(int paramInt)
  {
    return findLineNoByStartTime(paramInt);
  }
  
  public int findLineNoByEndTime(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findLineNoByEndTime -> illegal time");
      paramInt = 0;
    }
    for (;;)
    {
      return paramInt;
      ArrayList localArrayList = this.mSentences;
      if (localArrayList == null)
      {
        Log.w("Lyric", "findLineNoByEndTime -> sentence data not found");
        return -1;
      }
      int j = localArrayList.size();
      int i = 0;
      if (i < j)
      {
        Sentence localSentence = (Sentence)localArrayList.get(i);
        if (localSentence == null) {}
        while (localSentence.mStartTime + localSentence.mDuration < paramInt)
        {
          i += 1;
          break;
        }
      }
      for (paramInt = i; i == j; paramInt = 0) {
        return j - 1;
      }
    }
  }
  
  public int findLineNoByStartTime(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findLineNoByStartTime -> illegal time");
      return -1;
    }
    if ((this.mSentences == null) || (this.mSentences.size() == 0))
    {
      Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
      return -1;
    }
    ArrayList localArrayList = this.mSentences;
    int k = localArrayList.size();
    if ((this.mLastHitSentence != null) && (this.mLastHitSentence.mStartTime < paramInt)) {
      if (this.mLastHitSentenceNo < k - 1)
      {
        if (((Sentence)localArrayList.get(this.mLastHitSentenceNo + 1)).mStartTime > paramInt) {
          return this.mLastHitSentenceNo;
        }
      }
      else {
        return this.mLastHitSentenceNo;
      }
    }
    for (int i = this.mLastHitSentenceNo;; i = 0)
    {
      int j = i;
      if (j < k)
      {
        Sentence localSentence = (Sentence)localArrayList.get(j);
        if (localSentence == null) {}
        while (localSentence.mStartTime <= paramInt)
        {
          j += 1;
          break;
        }
      }
      for (paramInt = j - 1;; paramInt = 0)
      {
        i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        if (j == k) {}
        for (paramInt = k - 1;; paramInt = i)
        {
          this.mLastHitSentenceNo = paramInt;
          this.mLastHitSentence = ((Sentence)localArrayList.get(paramInt));
          return paramInt;
        }
      }
    }
  }
  
  public String findTextByTime(long paramLong)
  {
    if ((this.mSentences == null) || (this.mSentences.isEmpty()) || (paramLong < 0L)) {
      return null;
    }
    int j = this.mSentences.size();
    int i = 0;
    while (i < j)
    {
      Sentence localSentence = (Sentence)this.mSentences.get(i);
      if ((paramLong >= localSentence.mStartTime) && (paramLong <= localSentence.mStartTime + localSentence.mDuration)) {
        return localSentence.mText;
      }
      i += 1;
    }
    return null;
  }
  
  public int floorLineNoByEndTime(int paramInt)
  {
    int i;
    if ((paramInt < 0) || (isEmpty()))
    {
      Log.w("Lyric", "floorLineNoByEndTime -> illegal time");
      i = 0;
      return i;
    }
    ArrayList localArrayList = this.mSentences;
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      Sentence localSentence = (Sentence)localArrayList.get(j);
      if (localSentence == null) {}
      while (localSentence.mStartTime + localSentence.mDuration <= paramInt)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j != k) {
        break;
      }
      return k - 1;
    }
  }
  
  public void generateUiLyricLineList(Paint paramPaint1, Paint paramPaint2, int paramInt)
  {
    generateUiLyricLineList(paramPaint1, paramPaint2, paramInt, false, false);
  }
  
  public void generateUiLyricLineList(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean)
  {
    generateUiLyricLineList(paramPaint1, paramPaint2, paramInt, paramBoolean, false);
  }
  
  public void generateUiLyricLineList(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.d("Lyric", String.format("generateUiLyricLineList -> width:%d, isSingleLine:%b, isLeftAlign:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    this.mListSentenceUI.clear();
    this.mUILineCount = 0;
    if (this.mSentences != null)
    {
      Iterator localIterator = this.mSentences.iterator();
      while (localIterator.hasNext())
      {
        Sentence localSentence = (Sentence)localIterator.next();
        localSentence.generateUILyricLineList(paramPaint1, paramPaint2, paramInt, paramBoolean1, paramBoolean2);
        this.mUILineCount += localSentence.getUiLineSize();
        this.mListSentenceUI.addAll(localSentence.mUILine);
      }
    }
  }
  
  public int getEndTime()
  {
    if (isEmpty()) {
      return 0;
    }
    Sentence localSentence = (Sentence)this.mSentences.get(this.mSentences.size() - 1);
    long l = localSentence.mStartTime;
    return (int)(localSentence.mDuration + l);
  }
  
  public Sentence getSentence(int paramInt)
  {
    if (isEmpty()) {}
    while (this.mSentences.size() <= paramInt) {
      return null;
    }
    return (Sentence)this.mSentences.get(paramInt);
  }
  
  public List<Sentence> getSentenceList()
  {
    return this.mSentences;
  }
  
  public String getSentenceText(int paramInt)
  {
    if (isEmpty()) {}
    while (this.mSentences.size() <= paramInt) {
      return null;
    }
    return ((Sentence)this.mSentences.get(paramInt)).mText;
  }
  
  public int getStartTime()
  {
    if (isEmpty()) {
      return 0;
    }
    return (int)((Sentence)this.mSentences.get(0)).mStartTime;
  }
  
  public int[] getTimeArray()
  {
    if (isEmpty()) {
      return null;
    }
    int j = this.mSentences.size();
    int[] arrayOfInt = new int[j * 2];
    int i = 0;
    if (i < j)
    {
      Sentence localSentence = (Sentence)this.mSentences.get(i);
      if (localSentence != null)
      {
        arrayOfInt[(i * 2)] = ((int)localSentence.mStartTime);
        arrayOfInt[(i * 2 + 1)] = ((int)(localSentence.mStartTime + localSentence.mDuration));
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfInt[(i * 2)] = 0;
        arrayOfInt[(i * 2 + 1)] = 0;
      }
    }
    return arrayOfInt;
  }
  
  public int getUILineSize()
  {
    return this.mUILineCount;
  }
  
  public boolean isEmpty()
  {
    return (this.mSentences == null) || (this.mSentences.size() == 0);
  }
  
  public int size()
  {
    if (this.mSentences != null) {
      return this.mSentences.size();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.mSentences == null) {
      return "";
    }
    int i = 0;
    while (i < this.mSentences.size())
    {
      Sentence localSentence = (Sentence)this.mSentences.get(i);
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.mStartTime);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.mText);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.mDuration + localSentence.mStartTime);
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric
 * JD-Core Version:    0.7.0.1
 */