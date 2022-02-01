package com.tencent.weseevideo.editor.sticker.music.lyric.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import com.tencent.weseevideo.editor.sticker.music.lyric.constant.PractiveConst;
import java.util.ArrayList;

public class SentenceUI
{
  private static final String TAG = "SentenceUI";
  public final ArrayList<LyricCharacter> mCharacters;
  public long mEndTime = 0L;
  private final int mHighLightOffsetX;
  public SentenceAttachInfo mLeftAttachInfo = null;
  private final int mNormalOffsetX;
  public long mStartTime = 0L;
  public final String mText;
  
  public SentenceUI(String paramString, int paramInt1, int paramInt2, ArrayList<LyricCharacter> paramArrayList)
  {
    this.mNormalOffsetX = paramInt1;
    this.mHighLightOffsetX = paramInt2;
    this.mText = paramString;
    this.mCharacters = paramArrayList;
    paramString = this.mCharacters;
    if ((paramString != null) && (paramString.size() > 0))
    {
      this.mStartTime = ((LyricCharacter)this.mCharacters.get(0)).mStartTime;
      paramString = this.mCharacters;
      paramString = (LyricCharacter)paramString.get(paramString.size() - 1);
      this.mEndTime = (paramString.mStartTime + paramString.mDuration);
    }
  }
  
  private void drawAttachInfo(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramInt1 += this.mNormalOffsetX;
    SentenceAttachInfo localSentenceAttachInfo = this.mLeftAttachInfo;
    if ((localSentenceAttachInfo != null) && (localSentenceAttachInfo.mBitmap != null) && (!this.mLeftAttachInfo.mBitmap.isRecycled()))
    {
      paramPaint = new Rect(paramInt1 - this.mLeftAttachInfo.mPadding - this.mLeftAttachInfo.mBitmap.getWidth(), (int)(paramInt2 - paramPaint.getTextSize() + 2.0F), paramInt1 - this.mLeftAttachInfo.mPadding, (int)(paramInt2 + this.mLeftAttachInfo.mBitmap.getHeight() - paramPaint.getTextSize() + 2.0F));
      paramCanvas.drawBitmap(this.mLeftAttachInfo.mBitmap, null, paramPaint, null);
    }
  }
  
  public void drawLyricContour(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = this.mHighLightOffsetX;
    } else {
      i = this.mNormalOffsetX;
    }
    paramInt1 += i;
    String str = this.mText;
    float f1 = paramInt1 - 1;
    float f4 = paramInt2 - 1;
    paramCanvas.drawText(str, f1, f4, paramPaint);
    str = this.mText;
    float f2 = paramInt1;
    paramCanvas.drawText(str, f2, f4, paramPaint);
    str = this.mText;
    float f3 = paramInt1 + 1;
    paramCanvas.drawText(str, f3, f4, paramPaint);
    str = this.mText;
    f4 = paramInt2;
    paramCanvas.drawText(str, f3, f4, paramPaint);
    str = this.mText;
    float f5 = paramInt2 + 1;
    paramCanvas.drawText(str, f3, f5, paramPaint);
    paramCanvas.drawText(this.mText, f2, f5, paramPaint);
    paramCanvas.drawText(this.mText, f1, f5, paramPaint);
    paramCanvas.drawText(this.mText, f1, f4, paramPaint);
  }
  
  public long getEndTime()
  {
    Object localObject = this.mCharacters;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.mCharacters;
      localObject = (LyricCharacter)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      return ((LyricCharacter)localObject).mStartTime + ((LyricCharacter)localObject).mDuration;
    }
    return 0L;
  }
  
  public long getStartTime()
  {
    ArrayList localArrayList = this.mCharacters;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return ((LyricCharacter)this.mCharacters.get(0)).mStartTime;
    }
    return 0L;
  }
  
  public void paint(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, Paint paramPaint3, int paramInt3, float paramFloat1, float paramFloat2, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int i = this.mHighLightOffsetX;
    paramFloat2 += i;
    float f = paramInt2;
    paramFloat1 = paramFloat2 + paramFloat1;
    paramPaint3.setShader(new LinearGradient(paramFloat2, f, paramFloat1, f, paramArrayOfInt, paramArrayOfFloat, Shader.TileMode.CLAMP));
    if (paramInt3 > 0)
    {
      paramArrayOfInt = (LyricCharacter)this.mCharacters.get(paramInt3 - 1);
      paramCanvas.drawText(this.mText.substring(0, Math.min(paramArrayOfInt.mEnd, this.mText.length())), paramInt1 + i, f, paramPaint2);
    }
    paramPaint2 = (LyricCharacter)this.mCharacters.get(paramInt3);
    if (paramInt3 == this.mCharacters.size() - 1) {
      paramPaint2 = this.mText.substring(paramPaint2.mStart, this.mText.length());
    } else {
      paramPaint2 = this.mText.substring(paramPaint2.mStart, Math.min(paramPaint2.mEnd, this.mText.length()));
    }
    paramCanvas.drawText(paramPaint2, paramFloat2, f, paramPaint3);
    if (paramInt3 < this.mCharacters.size() - 1)
    {
      paramPaint2 = (LyricCharacter)this.mCharacters.get(paramInt3 + 1);
      paramCanvas.drawText(this.mText.substring(paramPaint2.mStart, this.mText.length()), paramFloat1, f, paramPaint1);
    }
  }
  
  public void paint(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = this.mHighLightOffsetX;
    } else {
      i = this.mNormalOffsetX;
    }
    paramCanvas.drawText(this.mText, paramInt1 + i, paramInt2, paramPaint);
  }
  
  public void paintMarkCharacter(Canvas paramCanvas, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint1, Paint paramPaint2, Paint paramPaint3, Paint paramPaint4, boolean paramBoolean, float paramFloat)
  {
    Object localObject1 = this;
    if (paramArrayOfInt == null) {
      return;
    }
    if (paramBoolean) {
      i = ((SentenceUI)localObject1).mHighLightOffsetX;
    } else {
      i = ((SentenceUI)localObject1).mNormalOffsetX;
    }
    localObject1 = paramPaint2.getFontMetrics();
    int i = paramInt2 + i;
    paramInt2 = 0;
    for (;;)
    {
      Object localObject2 = this;
      if (paramInt2 >= ((SentenceUI)localObject2).mCharacters.size()) {
        break;
      }
      LyricCharacter localLyricCharacter = (LyricCharacter)((SentenceUI)localObject2).mCharacters.get(paramInt2);
      localObject2 = ((SentenceUI)localObject2).mText.substring(localLyricCharacter.mStart, localLyricCharacter.mEnd);
      float f1 = paramPaint2.measureText((String)localObject2);
      float f2 = paramPaint2.getTextSize();
      if (paramArrayOfInt[paramInt1] != PractiveConst.NO_MARK_CHARACTER)
      {
        float f3 = i;
        float f4 = paramInt3;
        paramCanvas.drawRect(f3, ((Paint.FontMetrics)localObject1).top + f4 + ((Paint.FontMetrics)localObject1).bottom - paramFloat, f3 + f1, f2 + f4 + ((Paint.FontMetrics)localObject1).top + ((Paint.FontMetrics)localObject1).bottom + paramFloat, paramPaint1);
        paramCanvas.drawText((String)localObject2, f3, f4, paramPaint2);
      }
      for (;;)
      {
        break;
        if (paramBoolean) {
          paramCanvas.drawText((String)localObject2, i, paramInt3, paramPaint3);
        } else {
          paramCanvas.drawText((String)localObject2, i, paramInt3, paramPaint4);
        }
      }
      i = (int)(i + f1);
      paramInt2 += 1;
      paramInt1 += 1;
    }
  }
  
  public void paintWithContour(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, boolean paramBoolean)
  {
    drawAttachInfo(paramCanvas, paramInt1, paramInt2, paramPaint1);
    if (paramBoolean) {
      drawLyricContour(paramCanvas, paramInt1, paramInt2, paramPaint2, false);
    }
    paint(paramCanvas, paramInt1, paramInt2, paramPaint1, false);
  }
  
  public void setLeftAttachInfo(SentenceAttachInfo paramSentenceAttachInfo)
  {
    this.mLeftAttachInfo = paramSentenceAttachInfo;
  }
  
  public String toString()
  {
    return String.format("SentenceUI -> mNormalOffsetX:%d, mHighLightOffsetX:%d", new Object[] { Integer.valueOf(this.mNormalOffsetX), Integer.valueOf(this.mHighLightOffsetX) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.data.SentenceUI
 * JD-Core Version:    0.7.0.1
 */