package dov.com.qq.im.aeeditor.lyric.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.LyricCharacter;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.SentenceAttachInfo;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.SentenceUI;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class LyricViewInternalBase
  extends View
  implements LyricBaseInternalViewInterface
{
  protected int A;
  protected int B = -1;
  protected int C = 0;
  protected int D = 0;
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  protected final Paint a;
  protected final Handler a;
  protected Scroller a;
  protected Lyric a;
  protected final String a;
  public boolean a;
  protected int b;
  protected final Paint b;
  protected Lyric b;
  protected boolean b;
  protected int c;
  protected final Paint c;
  protected volatile boolean c;
  protected int d;
  protected final Paint d;
  protected volatile boolean d;
  protected int e;
  protected final Paint e;
  protected volatile boolean e;
  protected int f;
  protected final Paint f;
  protected volatile boolean f;
  protected int g;
  protected Paint g;
  protected volatile boolean g;
  protected int h;
  protected Paint h;
  protected volatile boolean h;
  protected int i;
  protected volatile boolean i;
  protected int j;
  protected volatile boolean j;
  protected int k;
  protected boolean k;
  protected int l;
  protected boolean l;
  protected int m = -1;
  protected int n = 3500;
  protected int o = -1;
  protected int p = -1;
  protected int q = -1;
  protected int r = 0;
  protected int s = 0;
  protected int t = 0;
  protected int u = 0;
  protected volatile int v = 0;
  protected int w;
  protected int x;
  protected volatile int y = 0;
  protected int z = -1;
  
  public LyricViewInternalBase(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public LyricViewInternalBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_f_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new LyricViewInternalBase.1(this, Looper.getMainLooper());
    this.jdField_d_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_g_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_h_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  protected static boolean a(Lyric paramLyric)
  {
    if ((paramLyric != null) && (paramLyric.mType == 2) && (paramLyric.mSentences != null)) {
      paramLyric = paramLyric.mSentences.iterator();
    }
    while (paramLyric.hasNext())
    {
      Sentence localSentence = (Sentence)paramLyric.next();
      if ((localSentence.mCharacters == null) || (localSentence.mCharacters.size() != 1))
      {
        return false;
        return false;
      }
    }
    return true;
  }
  
  private void b(Lyric paramLyric1, Lyric paramLyric2)
  {
    if (paramLyric1 != null)
    {
      b();
      Lyric localLyric = new Lyric(2, 0, null);
      localLyric.copy(paramLyric1);
      this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = localLyric;
      if ((paramLyric2 != null) && (paramLyric1.size() == paramLyric2.size()))
      {
        paramLyric1 = new Lyric(2, 0, null);
        paramLyric1.copy(paramLyric2);
      }
      for (this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = paramLyric1;; this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null))
      {
        setState(70);
        return;
      }
    }
    setState(40);
    this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
    this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
  }
  
  public int a()
  {
    return this.v;
  }
  
  public int a(int paramInt)
  {
    paramInt = this.t;
    this.jdField_e_of_type_Boolean = false;
    return paramInt;
  }
  
  protected int a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = paramSentence.getUILyricLineList();
    if (paramBoolean) {}
    int i1;
    for (paramSentence = this.jdField_b_of_type_AndroidGraphicsPaint;; paramSentence = this.jdField_a_of_type_AndroidGraphicsPaint)
    {
      int i3 = this.jdField_d_of_type_Int;
      int i4 = this.jdField_e_of_type_Int;
      int i2 = 0;
      i1 = paramInt2;
      paramInt2 = i2;
      while (paramInt2 < localArrayList.size())
      {
        ((SentenceUI)localArrayList.get(paramInt2)).paint(paramCanvas, paramInt1, i1 + this.jdField_e_of_type_Int, paramSentence, paramBoolean);
        i1 += i3 + i4;
        paramInt2 += 1;
      }
    }
    return i1;
  }
  
  public Lyric a()
  {
    return this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric;
  }
  
  public abstract void a();
  
  public void a(int paramInt1, int paramInt2)
  {
    this.t = paramInt1;
    this.u = paramInt2;
    a();
    postInvalidate();
  }
  
  protected void a(Canvas paramCanvas, int paramInt) {}
  
  protected void a(Canvas paramCanvas, Paint paramPaint, String paramString, int paramInt1, int paramInt2)
  {
    Log.d("ModuleLyricViewInternal", "drawString -> str:" + paramString + ", y:" + paramInt2);
    Rect localRect = new Rect();
    paramString = paramString.split("\n");
    int i2 = this.jdField_e_of_type_Int;
    int i1 = 0;
    while (i1 < paramString.length)
    {
      int i3 = getWidth();
      int i4 = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString[i1]);
      paramCanvas.drawText(paramString[i1], (i3 - i4 >> 1) + paramInt1, paramInt2 + i2, paramPaint);
      paramPaint.getTextBounds(paramString[i1], 0, paramString[i1].length(), localRect);
      i2 += localRect.height() + 20;
      i1 += 1;
    }
  }
  
  protected void a(Lyric paramLyric1, Lyric paramLyric2)
  {
    try
    {
      boolean bool = this.jdField_c_of_type_Boolean;
      int i1 = this.p;
      int i2 = this.q;
      b(paramLyric1, paramLyric2);
      if (bool) {
        setSegment(i1, i2);
      }
      return;
    }
    finally {}
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      ArrayList localArrayList1;
      int i5;
      int i6;
      Paint localPaint;
      int i2;
      try
      {
        localArrayList1 = paramSentence.getUILyricLineList();
        i5 = localArrayList1.size();
        i6 = this.u;
        localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
        if ((!this.jdField_i_of_type_Boolean) || (paramSentence.mNormalLeftAttachInfo == null)) {
          break label801;
        }
        localPaint.setColor(paramSentence.mNormalLeftAttachInfo.mSentenceColor);
      }
      finally {}
      if (i3 < i5)
      {
        SentenceUI localSentenceUI = (SentenceUI)localArrayList1.get(i3);
        if (localSentenceUI.mCharacters == null) {
          break label798;
        }
        if (localSentenceUI.mCharacters.size() <= 0) {
          break label807;
        }
        ArrayList localArrayList2 = localSentenceUI.mCharacters;
        int i7 = localArrayList2.size();
        int i8 = localSentenceUI.mText.length();
        int i4;
        float f3;
        float f2;
        float f1;
        long l1;
        float f4;
        if (i3 == 0)
        {
          i4 = this.jdField_e_of_type_Int;
          if (this.jdField_k_of_type_Boolean) {
            localSentenceUI.drawLyricContour(paramCanvas, paramInt1, paramInt2 + i4, this.jdField_f_of_type_AndroidGraphicsPaint, true);
          }
          if ((localSentenceUI.mStartTime > i6) || (localSentenceUI.mEndTime < i6)) {
            continue;
          }
          f3 = 0.0F;
          f2 = 0.0F;
          paramSentence = null;
          i2 = 0;
          i1 = 0;
          if (i1 >= i7) {
            break label791;
          }
          paramSentence = (LyricCharacter)localArrayList2.get(i1);
          LyricCharacter localLyricCharacter = null;
          if (i1 < i7 - 1) {
            localLyricCharacter = (LyricCharacter)localArrayList2.get(i1 + 1);
          }
          if ((paramSentence.mStartTime > i6) || (localLyricCharacter == null) || (localLyricCharacter.mStartTime <= i6)) {
            continue;
          }
          f1 = (float)(i6 - paramSentence.mStartTime);
          l1 = paramSentence.mDuration;
          f1 /= (float)l1;
          f2 = f1;
          f3 = f1;
          if (paramSentence != null)
          {
            f1 = paramInt1;
            f4 = f1;
            if (i1 == 0) {}
          }
        }
        try
        {
          if (i8 >= ((LyricCharacter)localArrayList2.get(i1 - 1)).mEnd)
          {
            f4 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(0, ((LyricCharacter)localArrayList2.get(i1 - 1)).mEnd));
            f1 = f4 + f1;
            f4 = f1;
            if (i1 != i7 - 1) {
              continue;
            }
          }
        }
        catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
        {
          try
          {
            f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(paramSentence.mStart, i8));
            i2 = localPaint.getColor();
            i7 = this.jdField_c_of_type_AndroidGraphicsPaint.getColor();
            localSentenceUI.paint(paramCanvas, paramInt1, paramInt2 + i4, this.jdField_c_of_type_AndroidGraphicsPaint, localPaint, this.jdField_d_of_type_AndroidGraphicsPaint, i1, f1, f4, new int[] { i2, i7 }, new float[] { f3, f2 });
            paramInt2 = this.jdField_g_of_type_Int + i4 + paramInt2;
            break label807;
            i4 = this.jdField_f_of_type_Int;
            continue;
            if ((paramSentence.mStartTime <= i6) && (paramSentence.mStartTime + paramSentence.mDuration >= i6))
            {
              f1 = (float)(i6 - paramSentence.mStartTime);
              l1 = paramSentence.mDuration;
              f3 = f1 / (float)l1;
              f2 = f3;
              continue;
            }
            i2 = i1;
            i1 += 1;
            continue;
            f4 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(0, i8));
            f1 = f4 + f1;
            continue;
            localStringIndexOutOfBoundsException = localStringIndexOutOfBoundsException;
            f4 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(0, i8));
            f4 = f1 + f4;
            continue;
            if (localSentenceUI.mText.length() >= paramSentence.mEnd)
            {
              f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(paramSentence.mStart, paramSentence.mEnd));
              continue;
            }
            f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(paramSentence.mStart, i8));
            continue;
          }
          catch (StringIndexOutOfBoundsException paramSentence)
          {
            f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(0, i8));
            continue;
          }
        }
        if (localSentenceUI.getEndTime() < i6)
        {
          localSentenceUI.paint(paramCanvas, paramInt1, paramInt2 + i4, localPaint, true);
          continue;
        }
        localSentenceUI.paint(paramCanvas, paramInt1, paramInt2 + i4, this.jdField_c_of_type_AndroidGraphicsPaint, true);
        continue;
      }
      else
      {
        return;
      }
      label791:
      int i1 = i2;
      continue;
      label798:
      break label807;
      label801:
      int i3 = 0;
      continue;
      label807:
      i3 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramSentence = paramSentence.getUILyricLineList();
    int i3 = this.jdField_d_of_type_Int;
    int i4 = this.jdField_e_of_type_Int;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramSentence.size())
    {
      ((SentenceUI)paramSentence.get(paramInt2)).paint(paramCanvas, paramInt1, i1 + this.jdField_e_of_type_Int, paramPaint, false);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, boolean paramBoolean)
  {
    paramSentence = paramSentence.getUILyricLineList();
    int i3 = this.jdField_d_of_type_Int;
    int i4 = this.jdField_e_of_type_Int;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramSentence.size())
    {
      ((SentenceUI)paramSentence.get(paramInt2)).paintWithContour(paramCanvas, paramInt1, i1 + this.jdField_e_of_type_Int, paramPaint1, paramPaint2, paramBoolean);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  public void a(LyricViewAttribute paramLyricViewAttribute)
  {
    this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
    this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
    this.jdField_f_of_type_Int = paramLyricViewAttribute.jdField_i_of_type_Int;
    this.jdField_d_of_type_Int = paramLyricViewAttribute.jdField_c_of_type_Int;
    this.jdField_e_of_type_Int = paramLyricViewAttribute.jdField_h_of_type_Int;
    this.jdField_h_of_type_Int = paramLyricViewAttribute.jdField_d_of_type_Int;
    this.jdField_i_of_type_Int = paramLyricViewAttribute.jdField_e_of_type_Int;
    this.jdField_j_of_type_Int = paramLyricViewAttribute.jdField_f_of_type_Int;
    this.jdField_g_of_type_Int = paramLyricViewAttribute.jdField_g_of_type_Int;
    this.jdField_c_of_type_Int = paramLyricViewAttribute.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = paramLyricViewAttribute.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = paramLyricViewAttribute.jdField_a_of_type_Boolean;
    this.jdField_h_of_type_Boolean = paramLyricViewAttribute.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Int = paramLyricViewAttribute.jdField_k_of_type_Int;
    this.jdField_a_of_type_Boolean = paramLyricViewAttribute.jdField_c_of_type_Boolean;
    this.jdField_j_of_type_Boolean = paramLyricViewAttribute.jdField_d_of_type_Boolean;
    this.B = paramLyricViewAttribute.jdField_j_of_type_Int;
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_h_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_j_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_h_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_h_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setFakeBoldText(this.jdField_j_of_type_Boolean);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(this.jdField_b_of_type_Boolean);
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_b_of_type_Int);
    this.jdField_e_of_type_AndroidGraphicsPaint.setFakeBoldText(this.jdField_b_of_type_Boolean);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_e_of_type_AndroidGraphicsPaint.setAlpha(19);
    this.jdField_f_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_f_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_h_of_type_Int);
    this.jdField_f_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_f_of_type_AndroidGraphicsPaint.setAlpha(19);
    this.jdField_g_of_type_AndroidGraphicsPaint.setColor(paramLyricViewAttribute.n);
    this.jdField_g_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_h_of_type_AndroidGraphicsPaint.setColor(paramLyricViewAttribute.jdField_l_of_type_Int);
    this.jdField_h_of_type_AndroidGraphicsPaint.setTextSize(paramLyricViewAttribute.m);
    this.jdField_g_of_type_AndroidGraphicsPaint.setColor(paramLyricViewAttribute.n);
    this.jdField_k_of_type_Int = paramLyricViewAttribute.o;
  }
  
  public int b()
  {
    return 0;
  }
  
  public int b(int paramInt)
  {
    this.jdField_e_of_type_Boolean = true;
    return this.t;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    this.p = -1;
    this.q = -1;
    this.r = 0;
    this.s = 0;
    this.jdField_f_of_type_Boolean = false;
  }
  
  protected int c()
  {
    if (this.m == -1) {
      this.m = this.B;
    }
    return this.m;
  }
  
  protected int c(int paramInt)
  {
    return 0;
  }
  
  protected void c()
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_j_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
  }
  
  public void d()
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    switch (this.jdField_l_of_type_Int)
    {
    default: 
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        scrollTo(0, 0);
        this.jdField_a_of_type_AndroidWidgetScroller.setFinalX(0);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_JavaLangString, 0, this.jdField_k_of_type_Int);
      }
      return;
    }
    a(paramCanvas, 0);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 0;
    View localView = (View)((View)getParent()).getParent();
    int i2 = localView.getMeasuredWidth();
    int i3 = localView.getMeasuredHeight();
    if (this.jdField_l_of_type_Int == 70)
    {
      paramInt1 = i2 - (c() << 1);
      int i4 = this.jdField_d_of_type_Int;
      int i5 = this.jdField_e_of_type_Int;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, false, true);
        if ((this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) && (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size() == this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size()))
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label222;
          }
          this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, false, true);
        }
      }
      int i1;
      for (;;)
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label241;
        }
        i1 = this.r;
        for (;;)
        {
          paramInt1 = paramInt2;
          if (i1 > this.s) {
            break;
          }
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i1) != null) {
            paramInt1 = paramInt2 + ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i1)).getUiLineSize();
          }
          i1 += 1;
          paramInt2 = paramInt1;
        }
        this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
        break;
        label222:
        this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
      }
      label241:
      paramInt1 = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.getUILineSize();
      paramInt2 = paramInt1;
      if (this.jdField_g_of_type_Boolean)
      {
        paramInt2 = paramInt1;
        if (this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null)
        {
          paramInt2 = paramInt1;
          if (this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences != null) {
            if (this.jdField_c_of_type_Boolean)
            {
              i1 = this.r;
              paramInt2 = paramInt1;
              if (i1 <= this.s)
              {
                paramInt2 = paramInt1;
                if (i1 < this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size()) {
                  if (i1 >= 0) {
                    break label332;
                  }
                }
                label332:
                for (paramInt2 = paramInt1;; paramInt2 = paramInt1 + ((Sentence)this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i1)).getUiLineSize())
                {
                  i1 += 1;
                  paramInt1 = paramInt2;
                  break;
                }
              }
            }
            else
            {
              paramInt2 = paramInt1 + this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.getUILineSize();
            }
          }
        }
      }
      this.n = (paramInt2 * (i4 + i5));
      this.A = (i3 / (this.jdField_e_of_type_Int + this.jdField_d_of_type_Int) + 1);
      Log.d("ModuleLyricViewInternal", "onMeasure -> Show line count:" + this.A);
      setMeasuredDimension(i2, this.n + i3);
      return;
    }
    setMeasuredDimension(i2, i3);
  }
  
  public void setEffectEnable(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setLeftAlign(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    d();
  }
  
  public void setLineHeight(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setLyric(Lyric paramLyric1, Lyric paramLyric2)
  {
    Log.d("ModuleLyricViewInternal", "setLyric begin");
    this.jdField_d_of_type_Boolean = true;
    c();
    this.jdField_f_of_type_Boolean = false;
    if (paramLyric1 != null)
    {
      b();
      Lyric localLyric = new Lyric(2, 0, null);
      localLyric.copy(paramLyric1);
      this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = localLyric;
      if ((paramLyric2 != null) && (paramLyric1.size() == paramLyric2.size()))
      {
        paramLyric1 = new Lyric(2, 0, null);
        paramLyric1.copy(paramLyric2);
        this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = paramLyric1;
        this.jdField_l_of_type_Boolean = a(this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric);
        Log.w("ModuleLyricViewInternal", "setLyric -> is special qrc:" + this.jdField_l_of_type_Boolean);
        setState(70);
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      Log.d("ModuleLyricViewInternal", "setLyric end");
      return;
      Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
      this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
      break;
      Log.w("ModuleLyricViewInternal", "setLyric -> lyric is null");
      setState(40);
    }
  }
  
  public void setLyricPadding(int paramInt)
  {
    this.B = paramInt;
    d();
  }
  
  public void setMode(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setSegment(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 > paramInt1))
    {
      if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric == null) || (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.isEmpty())) {
        Log.e("ModuleLyricViewInternal", "setSegment -> lyric is empty");
      }
    }
    else
    {
      Log.e("ModuleLyricViewInternal", "setSegment -> the time of lyric is illegal");
      return;
    }
    if ((this.p == paramInt1) && (this.q == paramInt2))
    {
      Log.d("ModuleLyricViewInternal", "setSegment -> same start and end");
      return;
    }
    this.p = paramInt1;
    this.q = paramInt2;
    this.r = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.findLineNoByStartTime(paramInt1);
    this.s = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.findEndLineByStartTime(paramInt2);
    if ((this.r < 0) || (this.s < 0))
    {
      Log.e("ModuleLyricViewInternal", "setSegment -> lyric line number is illegal");
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void setState(int paramInt)
  {
    this.jdField_l_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
    if (this.jdField_b_of_type_AndroidGraphicsPaint != null) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
    if (this.jdField_c_of_type_AndroidGraphicsPaint != null) {
      this.jdField_c_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
    if (this.jdField_d_of_type_AndroidGraphicsPaint != null) {
      this.jdField_d_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
    if (this.jdField_e_of_type_AndroidGraphicsPaint != null) {
      this.jdField_e_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
    if (this.jdField_f_of_type_AndroidGraphicsPaint != null) {
      this.jdField_f_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewInternalBase
 * JD-Core Version:    0.7.0.1
 */