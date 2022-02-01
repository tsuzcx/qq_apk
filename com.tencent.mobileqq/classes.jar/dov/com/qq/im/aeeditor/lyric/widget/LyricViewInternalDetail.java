package dov.com.qq.im.aeeditor.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import bpam;
import bpcy;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.LyricCharacter;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.SentenceAttachInfo;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.SentenceUI;
import java.util.ArrayList;

public class LyricViewInternalDetail
  extends LyricViewInternalBase
{
  public LyricViewInternalDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric == null) || (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.isEmpty()))
    {
      Log.e("LyricViewInternalDetail", "computeHilightWhileScrolling -> mLineLyric == null");
      return 0;
    }
    int i = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size();
    int j;
    if (this.jdField_c_of_type_Boolean)
    {
      j = this.r;
      i = this.s;
    }
    for (;;)
    {
      int k = 0;
      for (;;)
      {
        int m = i;
        if (j <= i)
        {
          m = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(j)).getUiLineSize();
          int n = this.jdField_d_of_type_Int;
          k = (m - 1) * this.e + n * m + this.e + k;
          if (paramInt < k) {
            m = j;
          }
        }
        else
        {
          bpam.a("LyricViewInternalDetail", "computeHilightWhileScrolling() y => " + paramInt + ",position => " + m);
          return m;
        }
        j += 1;
      }
      i -= 1;
      j = 0;
    }
  }
  
  public int a(int paramInt)
  {
    super.a(paramInt);
    paramInt = d(this.jdField_d_of_type_Int + paramInt);
    postInvalidate();
    return paramInt;
  }
  
  public void a()
  {
    if (this.jdField_l_of_type_Int != 70) {}
    label169:
    label184:
    for (;;)
    {
      return;
      int k = this.jdField_d_of_type_Int;
      int m = this.e;
      int n = this.t;
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences;
      if (localArrayList != null)
      {
        int i = localArrayList.size();
        int j;
        if (this.jdField_c_of_type_Boolean)
        {
          i = this.r;
          j = this.s;
        }
        for (;;)
        {
          if (n > j) {
            break label184;
          }
          j = 0;
          while (i < n)
          {
            j += ((Sentence)localArrayList.get(i)).getUiLineSize();
            i += 1;
          }
          i = this.A;
          if (this.z > 0) {
            if (this.z >= this.A) {
              break label169;
            }
          }
          for (i = this.z;; i = this.A)
          {
            n = this.jdField_k_of_type_Int;
            this.v = ((j - (int)(i * 0.3F) + 1) * (k + m) + n);
            if (this.v >= 0) {
              break;
            }
            this.v = 0;
            return;
          }
          j = i - 1;
          i = 0;
        }
      }
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt)
  {
    this.jdField_k_of_type_Int = ((int)(((View)((View)getParent()).getParent()).getMeasuredHeight() * 0.3F) + this.jdField_d_of_type_Int / 2);
    int k = this.jdField_d_of_type_Int + this.e;
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences;
    int m = localArrayList.size();
    int j = this.t;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    int n;
    label110:
    Sentence localSentence;
    if (i >= m)
    {
      i = m - 1;
      if (localArrayList.isEmpty()) {
        return;
      }
      n = paramInt + c();
      paramInt = this.jdField_k_of_type_Int;
      j = 0;
      if (j > m - 1) {
        return;
      }
      localSentence = (Sentence)localArrayList.get(j);
      if (j != i) {
        break label221;
      }
      if ((!this.h) || (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mType != 2) || (this.jdField_l_of_type_Boolean)) {
        break label195;
      }
      a(localSentence, paramCanvas, n, paramInt);
      paramInt = localSentence.getUiLineSize() * k + paramInt;
    }
    for (;;)
    {
      j += 1;
      break label110;
      break;
      label195:
      a(localSentence, paramCanvas, n, paramInt, true);
      paramInt = localSentence.getUiLineSize() * k + paramInt;
      continue;
      label221:
      a(localSentence, paramCanvas, n, paramInt, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramInt = localSentence.getUiLineSize() * k + paramInt;
    }
  }
  
  public void a(bpcy parambpcy)
  {
    super.a(parambpcy);
    this.x = ((this.jdField_d_of_type_Int + this.e) * 2);
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      ArrayList localArrayList1;
      int n;
      int i1;
      Paint localPaint;
      int j;
      try
      {
        localArrayList1 = paramSentence.getUILyricLineList();
        n = localArrayList1.size();
        i1 = this.u;
        localPaint = this.b;
        if ((!this.i) || (paramSentence.mNormalLeftAttachInfo == null)) {
          break label806;
        }
        localPaint.setColor(paramSentence.mNormalLeftAttachInfo.mSentenceColor);
      }
      finally {}
      if (k < n)
      {
        SentenceUI localSentenceUI = (SentenceUI)localArrayList1.get(k);
        if (localSentenceUI.mCharacters == null) {
          break label803;
        }
        if (localSentenceUI.mCharacters.size() <= 0) {
          break label812;
        }
        ArrayList localArrayList2 = localSentenceUI.mCharacters;
        int i2 = localArrayList2.size();
        int i3 = localSentenceUI.mText.length();
        int m;
        float f3;
        float f2;
        float f1;
        long l;
        float f4;
        if (k == 0)
        {
          m = this.e;
          if (this.jdField_k_of_type_Boolean) {
            localSentenceUI.drawLyricContour(paramCanvas, paramInt1, paramInt2 + m, this.jdField_f_of_type_AndroidGraphicsPaint, true);
          }
          if ((localSentenceUI.mStartTime > i1) || (localSentenceUI.mEndTime < i1)) {
            continue;
          }
          f3 = 0.0F;
          f2 = 0.0F;
          paramSentence = null;
          j = 0;
          i = 0;
          if (i >= i2) {
            break label796;
          }
          paramSentence = (LyricCharacter)localArrayList2.get(i);
          LyricCharacter localLyricCharacter = null;
          if (i < i2 - 1) {
            localLyricCharacter = (LyricCharacter)localArrayList2.get(i + 1);
          }
          if ((paramSentence.mStartTime > i1) || (localLyricCharacter == null) || (localLyricCharacter.mStartTime <= i1)) {
            continue;
          }
          f1 = (float)(i1 - paramSentence.mStartTime);
          l = paramSentence.mDuration;
          f1 /= (float)l;
          f2 = f1;
          f3 = f1;
          if (paramSentence != null)
          {
            f1 = paramInt1;
            f4 = f1;
            if (i == 0) {}
          }
        }
        try
        {
          if (i3 >= ((LyricCharacter)localArrayList2.get(i - 1)).mEnd)
          {
            f4 = this.b.measureText(localSentenceUI.mText.substring(0, ((LyricCharacter)localArrayList2.get(i - 1)).mEnd));
            f1 = f4 + f1;
            f4 = f1;
            if (i != i2 - 1) {
              continue;
            }
          }
        }
        catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
        {
          try
          {
            f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(paramSentence.mStart, i3));
            j = localPaint.getColor();
            i2 = this.jdField_c_of_type_AndroidGraphicsPaint.getColor();
            localSentenceUI.paint(paramCanvas, paramInt1, paramInt2 + m, this.jdField_c_of_type_AndroidGraphicsPaint, localPaint, this.jdField_d_of_type_AndroidGraphicsPaint, i, f1, f4, new int[] { j, i2 }, new float[] { f3, f2 });
            paramInt2 = this.g + m + paramInt2;
            break label812;
            m = this.e + this.jdField_f_of_type_Int;
            continue;
            if ((paramSentence.mStartTime <= i1) && (paramSentence.mStartTime + paramSentence.mDuration >= i1))
            {
              f1 = (float)(i1 - paramSentence.mStartTime);
              l = paramSentence.mDuration;
              f3 = f1 / (float)l;
              f2 = f3;
              continue;
            }
            j = i;
            i += 1;
            continue;
            f4 = this.b.measureText(localSentenceUI.mText.substring(0, i3));
            f1 = f4 + f1;
            continue;
            localStringIndexOutOfBoundsException = localStringIndexOutOfBoundsException;
            f4 = this.b.measureText(localSentenceUI.mText.substring(0, i3));
            f4 = f1 + f4;
            continue;
            if (localSentenceUI.mText.length() >= paramSentence.mEnd)
            {
              f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(paramSentence.mStart, paramSentence.mEnd));
              continue;
            }
            f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(paramSentence.mStart, i3));
            continue;
          }
          catch (StringIndexOutOfBoundsException paramSentence)
          {
            f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(0, i3));
            continue;
          }
        }
        if (localSentenceUI.getEndTime() < i1)
        {
          localSentenceUI.paint(paramCanvas, paramInt1, paramInt2 + m, localPaint, true);
          continue;
        }
        localSentenceUI.paint(paramCanvas, paramInt1, paramInt2 + m, this.jdField_c_of_type_AndroidGraphicsPaint, true);
        continue;
      }
      else
      {
        return;
      }
      label796:
      int i = j;
      continue;
      label803:
      break label812;
      label806:
      int k = 0;
      continue;
      label812:
      k += 1;
    }
  }
  
  public int b()
  {
    if (this.jdField_l_of_type_Int != 70) {}
    int m;
    int n;
    ArrayList localArrayList;
    do
    {
      return 0;
      m = this.jdField_d_of_type_Int;
      n = this.e;
      localArrayList = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences;
    } while (localArrayList == null);
    int i = localArrayList.size();
    int j;
    if (this.jdField_c_of_type_Boolean)
    {
      i = this.r;
      j = this.s;
    }
    for (;;)
    {
      int k = 0;
      while (i < j)
      {
        k += ((Sentence)localArrayList.get(i)).getUiLineSize();
        i += 1;
      }
      i = this.A;
      if (this.z > 0) {
        if (this.z >= this.A) {
          break label139;
        }
      }
      label139:
      for (i = this.z;; i = this.A) {
        return this.jdField_k_of_type_Int + (k - (int)(i * 0.3F) + 1) * (m + n);
      }
      j = i - 1;
      i = 0;
    }
  }
  
  public int b(int paramInt)
  {
    super.b(paramInt);
    paramInt = d(this.jdField_d_of_type_Int + paramInt);
    postInvalidate();
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewInternalDetail
 * JD-Core Version:    0.7.0.1
 */