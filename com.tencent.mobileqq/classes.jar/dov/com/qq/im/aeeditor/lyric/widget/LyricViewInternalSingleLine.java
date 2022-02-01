package dov.com.qq.im.aeeditor.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;
import bobi;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.util.ArrayList;

public class LyricViewInternalSingleLine
  extends LyricViewInternalBase
{
  protected volatile boolean m;
  
  public LyricViewInternalSingleLine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Log.d("LyricViewInternalSL", "scrollToXPos() xoffset => " + paramInt1 + ",time => " + paramInt2, new Exception());
    if (this.m)
    {
      paramInt1 -= this.jdField_a_of_type_AndroidWidgetScroller.getFinalX();
      if (paramInt1 != 0) {
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidWidgetScroller.getFinalX(), this.jdField_a_of_type_AndroidWidgetScroller.getFinalY(), paramInt1, 0, paramInt2);
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.t != paramInt1)
    {
      this.m = false;
      scrollTo(0, 0);
      this.jdField_a_of_type_AndroidWidgetScroller.setFinalX(0);
    }
    super.a(paramInt1, paramInt2);
  }
  
  protected void a(Canvas paramCanvas, int paramInt)
  {
    if (this.jdField_d_of_type_Boolean) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences;
      int k = ((ArrayList)localObject).size();
      int j = this.t;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = i;
      if (i >= k) {
        j = k - 1;
      }
      if (!((ArrayList)localObject).isEmpty())
      {
        k = paramInt + c();
        paramInt = ((ArrayList)localObject).size() - 1;
        if (this.c)
        {
          i = this.r;
          paramInt = this.s;
        }
        while ((j >= i) && (j <= paramInt))
        {
          localObject = (Sentence)((ArrayList)localObject).get(j);
          if ((this.h) && (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mType == 2) && (!this.jdField_l_of_type_Boolean))
          {
            a((Sentence)localObject, paramCanvas, k, 0);
            return;
          }
          paramInt = k;
          if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mType == 1)
          {
            i = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(((Sentence)localObject).mText);
            if ((i <= this.o + (c() >> 1)) || (this.o == -1)) {
              break label270;
            }
            paramInt = k;
            if (!this.m)
            {
              this.m = true;
              b(i - this.o, (int)((Sentence)localObject).mDuration);
              paramInt = k;
            }
          }
          while (this.k)
          {
            a((Sentence)localObject, paramCanvas, paramInt, 0, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_e_of_type_AndroidGraphicsPaint, this.k);
            return;
            label270:
            paramInt = k;
            if (i > this.o) {
              paramInt = k - (i - this.o >> 1);
            }
          }
          a((Sentence)localObject, paramCanvas, paramInt, 0, this.jdField_a_of_type_AndroidGraphicsPaint);
          return;
          i = 0;
        }
      }
    }
  }
  
  public void computeScroll()
  {
    if ((this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) && (this.m))
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
    super.computeScroll();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = (View)((View)getParent()).getParent();
    int j = localView.getMeasuredWidth();
    int k = localView.getMeasuredHeight();
    if (this.jdField_d_of_type_Boolean)
    {
      setMeasuredDimension(j, k);
      return;
    }
    if (this.jdField_l_of_type_Int == 70)
    {
      int n;
      int i1;
      if ((this.w == j) && (this.f))
      {
        setMeasuredDimension(j, this.n + k);
        n = this.jdField_d_of_type_Int;
        i1 = this.jdField_e_of_type_Int;
        if (this.c)
        {
          if (this.s >= this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size())
          {
            Log.e("LyricViewInternalSL", "onMeasure -> mSongEndLine error");
            this.s = (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size() - 1);
          }
          int i = this.r;
          paramInt1 = 0;
          for (;;)
          {
            paramInt2 = paramInt1;
            if (i > this.s) {
              break;
            }
            paramInt2 = paramInt1;
            if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i) != null) {
              paramInt2 = paramInt1 + ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i)).getUiLineSize();
            }
            paramInt1 = paramInt2;
            if (this.g)
            {
              paramInt1 = paramInt2;
              if (this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null)
              {
                paramInt1 = paramInt2;
                if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size() == this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size())
                {
                  paramInt1 = paramInt2;
                  if (this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i) != null) {
                    paramInt1 = paramInt2 + ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i)).getUiLineSize();
                  }
                }
              }
            }
            i += 1;
          }
        }
      }
      else
      {
        this.w = j;
        paramInt1 = j - (c() << 1);
        this.o = paramInt1;
        if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mType == 1) {
          this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, true);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mType == 2)
          {
            a(bobi.a(this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric), null);
            this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
          }
          this.f = true;
          break;
          this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
        }
      }
      paramInt1 = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.getUILineSize();
      paramInt2 = paramInt1;
      if (this.g)
      {
        paramInt2 = paramInt1;
        if (this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null)
        {
          paramInt2 = paramInt1;
          if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size() == this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size()) {
            paramInt2 = paramInt1 + this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.getUILineSize();
          }
        }
      }
      this.n = (paramInt2 * (n + i1));
      setMeasuredDimension(j, this.n + k);
      return;
    }
    setMeasuredDimension(j, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewInternalSingleLine
 * JD-Core Version:    0.7.0.1
 */