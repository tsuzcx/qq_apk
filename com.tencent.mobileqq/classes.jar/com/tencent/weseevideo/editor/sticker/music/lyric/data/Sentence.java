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
    ArrayList localArrayList1 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    if (paramArrayList.hasNext())
    {
      LyricCharacter localLyricCharacter2 = (LyricCharacter)paramArrayList.next();
      if (j <= localLyricCharacter2.mStart)
      {
        if (k == paramArrayOfString.length - 1)
        {
          i = this.mText.length();
        }
        else
        {
          m += paramArrayOfString[k].length();
          k += 1;
          i = paramString.indexOf(paramArrayOfString[k], m);
        }
      }
      else
      {
        n = j;
        j = i;
        i = n;
      }
      ArrayList<LyricCharacter> localArrayList = paramArrayList;
      int i3 = j;
      int i1 = k;
      int i2 = m;
      int n = i;
      LyricCharacter localLyricCharacter1 = localLyricCharacter2;
      if (localLyricCharacter2.mStart >= j)
      {
        localArrayList = paramArrayList;
        i3 = j;
        i1 = k;
        i2 = m;
        n = i;
        localLyricCharacter1 = localLyricCharacter2;
        if (i >= localLyricCharacter2.mEnd)
        {
          localArrayList1.add(localLyricCharacter2);
          localArrayList = paramArrayList;
          label207:
          n = j;
          break label457;
        }
      }
      for (;;)
      {
        if ((localLyricCharacter1.mStart < n) && (localLyricCharacter1.mEnd > n))
        {
          long l = ((float)localLyricCharacter1.mDuration * 1.0F * (n - localLyricCharacter1.mStart) / (localLyricCharacter1.mEnd - localLyricCharacter1.mStart));
          paramArrayList = new LyricCharacter(localLyricCharacter1.mStartTime, l, localLyricCharacter1.mStart, n);
          localLyricCharacter1 = new LyricCharacter(localLyricCharacter1.mStartTime + l, localLyricCharacter1.mDuration - l, n, localLyricCharacter1.mEnd);
          localArrayList1.add(paramArrayList);
        }
        if (n < localLyricCharacter1.mEnd)
        {
          if (i1 == paramArrayOfString.length - 1)
          {
            i = this.mText.length();
          }
          else
          {
            i2 += paramArrayOfString[i1].length();
            i1 += 1;
            i = paramString.indexOf(paramArrayOfString[i1], i2);
          }
          j = n;
          n = i;
          i = j;
          k = i1;
          m = i2;
        }
        else
        {
          i = i3;
          m = i2;
          k = i1;
        }
        if (n >= localLyricCharacter1.mEnd)
        {
          localArrayList1.add(localLyricCharacter1);
          j = i;
          i = n;
          break label207;
          label457:
          paramArrayList = localArrayList;
          j = i;
          i = n;
          break;
        }
        i3 = i;
        i1 = k;
        i2 = m;
      }
    }
    return localArrayList1;
  }
  
  public void generateUILyricLineList(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramPaint1;
    if (TextUtils.isEmpty(this.mText)) {
      return;
    }
    this.mUILine.clear();
    int j = (int)((Paint)localObject1).measureText(this.mText);
    int i4 = 0;
    int i = 0;
    if (j <= paramInt)
    {
      if (!paramBoolean2)
      {
        i = paramInt - (int)paramPaint2.measureText(this.mText) >> 1;
        paramInt = paramInt - j >> 1;
      }
      else
      {
        paramInt = 0;
      }
      paramPaint1 = new SentenceUI(this.mText, i, paramInt, this.mCharacters);
      paramPaint2 = this.mBitmapLeftAttachInfo;
      if (paramPaint2 != null) {
        paramPaint1.mLeftAttachInfo = paramPaint2;
      } else {
        paramPaint1.mLeftAttachInfo = this.mNormalLeftAttachInfo;
      }
      this.mUILine.add(paramPaint1);
      return;
    }
    if (paramBoolean1)
    {
      paramPaint1 = new SentenceUI(this.mText, 0, 0, this.mCharacters);
      paramPaint2 = this.mBitmapLeftAttachInfo;
      if (paramPaint2 != null) {
        paramPaint1.mLeftAttachInfo = paramPaint2;
      } else {
        paramPaint1.mLeftAttachInfo = this.mNormalLeftAttachInfo;
      }
      this.mUILine.add(paramPaint1);
      return;
    }
    String[] arrayOfString = LyricDataUtil.wrap(this.mText, (Paint)localObject1, paramInt, paramInt);
    j = arrayOfString.length;
    if (j > 0)
    {
      localObject1 = this.mCharacters;
      if (localObject1 != null)
      {
        localObject1 = rerangeLyricCharacterList(this.mText, arrayOfString, (ArrayList)localObject1);
        this.mUICharacters = ((ArrayList)localObject1);
      }
      else
      {
        localObject1 = null;
      }
      int i3 = 0;
      int m = 0;
      int i5 = 0;
      int n = 0;
      int i1 = 0;
      int k = 0;
      int i7;
      for (i = 0; i4 < j; i = i7)
      {
        Object localObject2 = arrayOfString[i4];
        i7 = ((String)localObject2).length();
        if (!paramBoolean2)
        {
          k = paramInt - (int)paramPaint2.measureText((String)localObject2) >> 1;
          i = paramInt - (int)paramPaint1.measureText((String)localObject2) >> 1;
        }
        int i6;
        int i2;
        if (localObject1 != null)
        {
          i6 = i3 + i7;
          localObject2 = new ArrayList();
          i2 = i1;
          i3 = n;
          while (m < ((ArrayList)localObject1).size())
          {
            LyricCharacter localLyricCharacter = (LyricCharacter)((ArrayList)localObject1).get(m);
            i1 = i3;
            n = i2;
            if (i4 != 0)
            {
              i1 = i3;
              n = i2;
              if (i5 == m)
              {
                i1 = i6 - i7;
                i2 = localLyricCharacter.mStart;
                n = i1;
                i1 = i2 - i1;
              }
            }
            if ((localLyricCharacter.mStart <= i6) && (localLyricCharacter.mEnd >= i6))
            {
              if (i4 == 0)
              {
                ((ArrayList)localObject2).add(new LyricCharacter(localLyricCharacter.mStartTime, localLyricCharacter.mDuration, localLyricCharacter.mStart, i7));
              }
              else
              {
                i2 = localLyricCharacter.mStart;
                ((ArrayList)localObject2).add(new LyricCharacter(localLyricCharacter.mStartTime, localLyricCharacter.mDuration, i2 - n - i1, i7));
              }
              i3 = i;
              i = j;
              m += 1;
              i5 = m;
              i2 = n;
              j = k;
              k = i3;
              break label700;
            }
            if (i4 == 0)
            {
              ((ArrayList)localObject2).add(localLyricCharacter);
            }
            else
            {
              i2 = localLyricCharacter.mStart;
              i3 = localLyricCharacter.mEnd;
              ((ArrayList)localObject2).add(new LyricCharacter(localLyricCharacter.mStartTime, localLyricCharacter.mDuration, i2 - n - i1, i3 - n - i1));
            }
            m += 1;
            i3 = i1;
            i2 = n;
          }
          n = i;
          i1 = i3;
          i = j;
          j = k;
          k = n;
        }
        else
        {
          i2 = j;
          j = k;
          localObject2 = null;
          k = i;
          i = i2;
          i2 = i1;
          i1 = n;
          i6 = i3;
        }
        label700:
        if (i4 == 0)
        {
          localObject2 = new SentenceUI(arrayOfString[i4], j, k, (ArrayList)localObject2);
          ((SentenceUI)localObject2).mLeftAttachInfo = this.mBitmapLeftAttachInfo;
        }
        else
        {
          localObject2 = new SentenceUI(arrayOfString[i4], j, k, (ArrayList)localObject2);
          ((SentenceUI)localObject2).mLeftAttachInfo = this.mNormalLeftAttachInfo;
        }
        i7 = k;
        k = j;
        this.mUILine.add(localObject2);
        i4 += 1;
        j = i;
        i3 = i6;
        n = i1;
        i1 = i2;
      }
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
    Object localObject = this.mUICharacters;
    if (localObject == null) {
      return paramArrayOfInt;
    }
    localObject = new int[((ArrayList)localObject).size()];
    int i = 0;
    int j = 0;
    while (i < this.mCharacters.size())
    {
      LyricCharacter localLyricCharacter = (LyricCharacter)this.mCharacters.get(i);
      while ((j < this.mUICharacters.size()) && (isInCharacter(localLyricCharacter, (LyricCharacter)this.mUICharacters.get(j))))
      {
        localObject[j] = paramArrayOfInt[i];
        j += 1;
      }
      i += 1;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence
 * JD-Core Version:    0.7.0.1
 */