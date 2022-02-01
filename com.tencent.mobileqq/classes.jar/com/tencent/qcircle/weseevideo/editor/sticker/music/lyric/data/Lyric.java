package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data;

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
    ArrayList localArrayList = this.mSentences;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    localArrayList = this.mListSentenceUI;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.mLastHitSentence = null;
    this.mLastHitSentenceNo = 0;
  }
  
  public void copy(Lyric paramLyric)
  {
    this.mType = paramLyric.mType;
    this.mOffset = paramLyric.mOffset;
    Object localObject = this.mSentences;
    if (localObject == null) {
      this.mSentences = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    localObject = paramLyric.mSentences.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Sentence localSentence = (Sentence)((Iterator)localObject).next();
      this.mSentences.add(localSentence.getCopy());
    }
    this.mUILineCount = paramLyric.getUILineSize();
    paramLyric = new StringBuilder();
    paramLyric.append("copy -> mType : ");
    paramLyric.append(this.mType);
    Log.d("Lyric", paramLyric.toString());
  }
  
  public int countSentence(int paramInt1, int paramInt2)
  {
    if (isEmpty()) {
      return 0;
    }
    paramInt1 = findLineNoByStartTime(paramInt1);
    paramInt2 = findEndLineByStartTime(paramInt2);
    if (paramInt1 >= 0)
    {
      if (paramInt2 < paramInt1) {
        return 0;
      }
      return paramInt2 - paramInt1 + 1;
    }
    return 0;
  }
  
  public String findCharacterByTime(long paramLong)
  {
    Object localObject2 = this.mSentences;
    Object localObject1 = null;
    if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
    {
      if (paramLong < 0L) {
        return null;
      }
      int k = this.mSentences.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        Sentence localSentence = (Sentence)this.mSentences.get(i);
        if ((paramLong >= localSentence.mStartTime) && (paramLong <= localSentence.mStartTime + localSentence.mDuration))
        {
          localObject2 = localSentence.mText;
          if (localSentence.mCharacters != null)
          {
            k = localSentence.mCharacters.size();
            if (k > 0)
            {
              i = j;
              while (i < k)
              {
                LyricCharacter localLyricCharacter = (LyricCharacter)localSentence.mCharacters.get(i);
                j = k - 1;
                if (i < j) {
                  localObject1 = (LyricCharacter)localSentence.mCharacters.get(i + 1);
                }
                if ((localLyricCharacter.mStartTime <= paramLong) && (localObject1 != null) && (((LyricCharacter)localObject1).mStartTime > paramLong))
                {
                  if (i == j) {}
                  try
                  {
                    localObject1 = localSentence.mText.substring(localLyricCharacter.mStart, localSentence.mText.length());
                  }
                  catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException1)
                  {
                    localStringIndexOutOfBoundsException1.printStackTrace();
                    break;
                  }
                  if (localSentence.mText.length() >= localLyricCharacter.mEnd) {
                    localObject1 = localSentence.mText.substring(localLyricCharacter.mStart, localLyricCharacter.mEnd);
                  } else {
                    localObject1 = localSentence.mText.substring(localLyricCharacter.mStart, localSentence.mText.length());
                  }
                }
                else
                {
                  if ((localLyricCharacter.mStartTime > paramLong) || (localLyricCharacter.mStartTime + localLyricCharacter.mDuration < paramLong)) {
                    break label435;
                  }
                  if (i != j) {}
                }
                try
                {
                  String str = localSentence.mText.substring(localLyricCharacter.mStart, localSentence.mText.length());
                  break label422;
                  if (localSentence.mText.length() >= localLyricCharacter.mEnd) {
                    str = localSentence.mText.substring(localLyricCharacter.mStart, localLyricCharacter.mEnd);
                  } else {
                    str = localSentence.mText.substring(localLyricCharacter.mStart, localSentence.mText.length());
                  }
                  label422:
                  return str;
                }
                catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException2)
                {
                  localStringIndexOutOfBoundsException2.printStackTrace();
                }
                label435:
                i += 1;
              }
            }
          }
          return localObject2;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public int findEndLineByStartTime(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findEndLineByStartTime -> illegal time");
      return 0;
    }
    ArrayList localArrayList = this.mSentences;
    if (localArrayList == null)
    {
      Log.w("Lyric", "findEndLineByStartTime -> sentence data not found");
      return -1;
    }
    int k = localArrayList.size();
    int j = 0;
    while (j < k)
    {
      Sentence localSentence = (Sentence)localArrayList.get(j);
      if ((localSentence != null) && (paramInt <= localSentence.mStartTime))
      {
        paramInt = j - 1;
        break label96;
      }
      j += 1;
    }
    paramInt = 0;
    label96:
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (j == k) {
      i = k - 1;
    }
    return i;
  }
  
  public int findLineNo(int paramInt)
  {
    return findLineNoByStartTime(paramInt);
  }
  
  public int findLineNoByEndTime(int paramInt)
  {
    int k = 0;
    if (paramInt < 0)
    {
      Log.w("Lyric", "findLineNoByEndTime -> illegal time");
      return 0;
    }
    ArrayList localArrayList = this.mSentences;
    if (localArrayList == null)
    {
      Log.w("Lyric", "findLineNoByEndTime -> sentence data not found");
      return -1;
    }
    int m = localArrayList.size();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      Sentence localSentence = (Sentence)localArrayList.get(i);
      if ((localSentence != null) && (localSentence.mStartTime + localSentence.mDuration >= paramInt))
      {
        j = i;
        break;
      }
      i += 1;
    }
    if (i == m) {
      j = m - 1;
    }
    return j;
  }
  
  public int findLineNoByStartTime(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findLineNoByStartTime -> illegal time");
      return -1;
    }
    ArrayList localArrayList = this.mSentences;
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      localArrayList = this.mSentences;
      int k = localArrayList.size();
      Sentence localSentence = this.mLastHitSentence;
      if (localSentence != null)
      {
        long l1 = localSentence.mStartTime;
        long l2 = paramInt;
        if (l1 < l2)
        {
          i = this.mLastHitSentenceNo;
          if (i < k - 1)
          {
            if (((Sentence)localArrayList.get(i + 1)).mStartTime > l2) {
              return this.mLastHitSentenceNo;
            }
            i = this.mLastHitSentenceNo;
            break label133;
          }
          return i;
        }
      }
      int i = 0;
      label133:
      while (i < k)
      {
        localSentence = (Sentence)localArrayList.get(i);
        if ((localSentence != null) && (localSentence.mStartTime > paramInt))
        {
          paramInt = i - 1;
          break label187;
        }
        i += 1;
      }
      paramInt = 0;
      label187:
      int j = paramInt;
      if (paramInt < 0) {
        j = 0;
      }
      if (i == k) {
        j = k - 1;
      }
      this.mLastHitSentenceNo = j;
      this.mLastHitSentence = ((Sentence)localArrayList.get(j));
      return j;
    }
    Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
    return -1;
  }
  
  public String findTextByTime(long paramLong)
  {
    Object localObject = this.mSentences;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      if (paramLong < 0L) {
        return null;
      }
      int j = this.mSentences.size();
      int i = 0;
      while (i < j)
      {
        localObject = (Sentence)this.mSentences.get(i);
        if ((paramLong >= ((Sentence)localObject).mStartTime) && (paramLong <= ((Sentence)localObject).mStartTime + ((Sentence)localObject).mDuration)) {
          return ((Sentence)localObject).mText;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public int floorLineNoByEndTime(int paramInt)
  {
    if ((paramInt >= 0) && (!isEmpty()))
    {
      ArrayList localArrayList = this.mSentences;
      int k = localArrayList.size();
      int j = 0;
      while (j < k)
      {
        Sentence localSentence = (Sentence)localArrayList.get(j);
        if ((localSentence != null) && (localSentence.mStartTime + localSentence.mDuration > paramInt))
        {
          paramInt = j - 1;
          break label91;
        }
        j += 1;
      }
      paramInt = 0;
      label91:
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j == k) {
        i = k - 1;
      }
      return i;
    }
    Log.w("Lyric", "floorLineNoByEndTime -> illegal time");
    return 0;
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
    Object localObject = this.mSentences;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Sentence localSentence = (Sentence)((Iterator)localObject).next();
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
    Object localObject = this.mSentences;
    localObject = (Sentence)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    return (int)(((Sentence)localObject).mStartTime + ((Sentence)localObject).mDuration);
  }
  
  public Sentence getSentence(int paramInt)
  {
    if (isEmpty()) {
      return null;
    }
    if (this.mSentences.size() > paramInt) {
      return (Sentence)this.mSentences.get(paramInt);
    }
    return null;
  }
  
  public List<Sentence> getSentenceList()
  {
    return this.mSentences;
  }
  
  public String getSentenceText(int paramInt)
  {
    if (isEmpty()) {
      return null;
    }
    if (this.mSentences.size() > paramInt) {
      return ((Sentence)this.mSentences.get(paramInt)).mText;
    }
    return null;
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
    while (i < j)
    {
      Sentence localSentence = (Sentence)this.mSentences.get(i);
      int k;
      if (localSentence != null)
      {
        k = i * 2;
        arrayOfInt[k] = ((int)localSentence.mStartTime);
        arrayOfInt[(k + 1)] = ((int)(localSentence.mStartTime + localSentence.mDuration));
      }
      else
      {
        k = i * 2;
        arrayOfInt[k] = 0;
        arrayOfInt[(k + 1)] = 0;
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  public int getUILineSize()
  {
    return this.mUILineCount;
  }
  
  public boolean isEmpty()
  {
    ArrayList localArrayList = this.mSentences;
    return (localArrayList == null) || (localArrayList.size() == 0);
  }
  
  public int size()
  {
    ArrayList localArrayList = this.mSentences;
    if (localArrayList != null) {
      return localArrayList.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric
 * JD-Core Version:    0.7.0.1
 */