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
    if ((this.mCharacters != null) && (this.mCharacters.size() > 0))
    {
      this.mStartTime = ((LyricCharacter)this.mCharacters.get(0)).mStartTime;
      paramString = (LyricCharacter)this.mCharacters.get(this.mCharacters.size() - 1);
      long l = paramString.mStartTime;
      this.mEndTime = (paramString.mDuration + l);
    }
  }
  
  private void drawAttachInfo(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramInt1 = this.mNormalOffsetX + paramInt1;
    if ((this.mLeftAttachInfo != null) && (this.mLeftAttachInfo.mBitmap != null) && (!this.mLeftAttachInfo.mBitmap.isRecycled()))
    {
      paramPaint = new Rect(paramInt1 - this.mLeftAttachInfo.mPadding - this.mLeftAttachInfo.mBitmap.getWidth(), (int)(paramInt2 - paramPaint.getTextSize() + 2.0F), paramInt1 - this.mLeftAttachInfo.mPadding, (int)(this.mLeftAttachInfo.mBitmap.getHeight() + paramInt2 - paramPaint.getTextSize() + 2.0F));
      paramCanvas.drawBitmap(this.mLeftAttachInfo.mBitmap, null, paramPaint, null);
    }
  }
  
  public void drawLyricContour(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = this.mHighLightOffsetX;; i = this.mNormalOffsetX)
    {
      paramInt1 = i + paramInt1;
      paramCanvas.drawText(this.mText, paramInt1 - 1, paramInt2 - 1, paramPaint);
      paramCanvas.drawText(this.mText, paramInt1, paramInt2 - 1, paramPaint);
      paramCanvas.drawText(this.mText, paramInt1 + 1, paramInt2 - 1, paramPaint);
      paramCanvas.drawText(this.mText, paramInt1 + 1, paramInt2, paramPaint);
      paramCanvas.drawText(this.mText, paramInt1 + 1, paramInt2 + 1, paramPaint);
      paramCanvas.drawText(this.mText, paramInt1, paramInt2 + 1, paramPaint);
      paramCanvas.drawText(this.mText, paramInt1 - 1, paramInt2 + 1, paramPaint);
      paramCanvas.drawText(this.mText, paramInt1 - 1, paramInt2, paramPaint);
      return;
    }
  }
  
  public long getEndTime()
  {
    if ((this.mCharacters != null) && (this.mCharacters.size() > 0))
    {
      LyricCharacter localLyricCharacter = (LyricCharacter)this.mCharacters.get(this.mCharacters.size() - 1);
      long l = localLyricCharacter.mStartTime;
      return localLyricCharacter.mDuration + l;
    }
    return 0L;
  }
  
  public long getStartTime()
  {
    if ((this.mCharacters != null) && (this.mCharacters.size() > 0)) {
      return ((LyricCharacter)this.mCharacters.get(0)).mStartTime;
    }
    return 0L;
  }
  
  public void paint(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, Paint paramPaint3, int paramInt3, float paramFloat1, float paramFloat2, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int i = this.mHighLightOffsetX;
    paramFloat2 += this.mHighLightOffsetX;
    paramPaint3.setShader(new LinearGradient(paramFloat2, paramInt2, paramFloat2 + paramFloat1, paramInt2, paramArrayOfInt, paramArrayOfFloat, Shader.TileMode.CLAMP));
    if (paramInt3 > 0)
    {
      paramArrayOfInt = (LyricCharacter)this.mCharacters.get(paramInt3 - 1);
      paramCanvas.drawText(this.mText.substring(0, Math.min(paramArrayOfInt.mEnd, this.mText.length())), paramInt1 + i, paramInt2, paramPaint2);
    }
    paramPaint2 = (LyricCharacter)this.mCharacters.get(paramInt3);
    if (paramInt3 == this.mCharacters.size() - 1) {}
    for (paramPaint2 = this.mText.substring(paramPaint2.mStart, this.mText.length());; paramPaint2 = this.mText.substring(paramPaint2.mStart, Math.min(paramPaint2.mEnd, this.mText.length())))
    {
      paramCanvas.drawText(paramPaint2, paramFloat2, paramInt2, paramPaint3);
      if (paramInt3 < this.mCharacters.size() - 1)
      {
        paramPaint2 = (LyricCharacter)this.mCharacters.get(paramInt3 + 1);
        paramCanvas.drawText(this.mText.substring(paramPaint2.mStart, this.mText.length()), paramFloat2 + paramFloat1, paramInt2, paramPaint1);
      }
      return;
    }
  }
  
  public void paint(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = this.mHighLightOffsetX;; i = this.mNormalOffsetX)
    {
      paramCanvas.drawText(this.mText, i + paramInt1, paramInt2, paramPaint);
      return;
    }
  }
  
  public void paintMarkCharacter(Canvas paramCanvas, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint1, Paint paramPaint2, Paint paramPaint3, Paint paramPaint4, boolean paramBoolean, float paramFloat)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    int i;
    label16:
    label39:
    Object localObject;
    float f1;
    if (paramBoolean)
    {
      i = this.mHighLightOffsetX;
      Paint.FontMetrics localFontMetrics = paramPaint2.getFontMetrics();
      int j = 0;
      i = paramInt2 + i;
      paramInt2 = paramInt1;
      paramInt1 = j;
      if (paramInt1 < this.mCharacters.size())
      {
        localObject = (LyricCharacter)this.mCharacters.get(paramInt1);
        localObject = this.mText.substring(((LyricCharacter)localObject).mStart, ((LyricCharacter)localObject).mEnd);
        f1 = paramPaint2.measureText((String)localObject);
        float f2 = paramPaint2.getTextSize();
        if (paramArrayOfInt[paramInt2] == PractiveConst.NO_MARK_CHARACTER) {
          break label207;
        }
        paramCanvas.drawRect(i, paramInt3 + localFontMetrics.top + localFontMetrics.bottom - paramFloat, i + f1, f2 + paramInt3 + localFontMetrics.top + localFontMetrics.bottom + paramFloat, paramPaint1);
        paramCanvas.drawText((String)localObject, i, paramInt3, paramPaint2);
      }
    }
    for (;;)
    {
      i = (int)(i + f1);
      paramInt2 += 1;
      paramInt1 += 1;
      break label39;
      break;
      i = this.mNormalOffsetX;
      break label16;
      label207:
      if (paramBoolean) {
        paramCanvas.drawText((String)localObject, i, paramInt3, paramPaint3);
      } else {
        paramCanvas.drawText((String)localObject, i, paramInt3, paramPaint4);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.data.SentenceUI
 * JD-Core Version:    0.7.0.1
 */