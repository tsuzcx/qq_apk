import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class q
  extends o
  implements p
{
  public static boolean a;
  protected int a;
  private long jdField_a_of_type_Long;
  protected Paint a;
  protected Path a;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  protected ETTextView a;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  protected List<List<w>> a;
  private s jdField_a_of_type_S;
  protected int[] a;
  protected int b;
  protected Canvas b;
  protected Paint b;
  protected List<w> b;
  protected boolean b;
  protected int[] b;
  protected int c;
  protected Canvas c;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private List<w> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  protected int[] c;
  protected int d;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private List<w> jdField_d_of_type_JavaUtilList;
  private boolean jdField_d_of_type_Boolean;
  protected int[] d;
  protected int[] e;
  protected int f;
  protected int[] f;
  protected int g;
  protected int[] g;
  protected int h;
  private int[] h;
  protected int i;
  protected int j;
  private int[] j;
  protected int k;
  protected int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  
  public q(ETTextView paramETTextView, ETFont paramETFont)
  {
    this.jdField_h_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_g_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = paramETTextView;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    k();
    this.jdField_a_of_type_S = new s();
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  private w a()
  {
    if (this.jdField_d_of_type_JavaUtilList.isEmpty()) {
      return new w();
    }
    return (w)this.jdField_d_of_type_JavaUtilList.remove(0);
  }
  
  @TargetApi(16)
  private void a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    k();
    paramInt2 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if ((paramInt2 == -2147483648) || (paramInt2 == 1073741824)) {}
    int i5;
    for (this.jdField_f_of_type_Int = Math.min(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMaxWidth, paramInt1);; this.jdField_f_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMaxWidth)
    {
      this.jdField_g_of_type_Int = 0;
      this.m = 0;
      this.p = 0;
      this.q = 0;
      this.s = 0;
      this.t = 0;
      this.u = 0;
      this.r = 1;
      this.w = 0;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingRight();
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
      this.jdField_d_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingBottom();
      this.v = (this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
      if (Build.VERSION.SDK_INT >= 16) {
        this.t = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getMaxEms();
      }
      this.u = this.v;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList.clear();
      paramInt1 = this.jdField_d_of_type_JavaUtilList.size();
      i5 = paramCharSequence.length();
      if ((paramInt1 >= i5) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
        break;
      }
      while (paramInt1 < i5)
      {
        if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_d_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.remove(0));
        }
        paramInt1 += 1;
      }
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_j_of_type_ArrayOfInt = new int[i5];
    Object localObject = new int[i5];
    int i1 = 0;
    int i3 = 0;
    paramInt2 = 0;
    int i2;
    if (paramInt2 < i5)
    {
      localObject[paramInt2] = paramCharSequence.charAt(paramInt2);
      if (((localObject[paramInt2] >= 97) && (localObject[paramInt2] <= 122)) || ((localObject[paramInt2] >= 65) && (localObject[paramInt2] <= 90))) {
        if (i3 == 0)
        {
          paramInt1 = 1;
          i2 = paramInt2;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        i3 = paramInt1;
        i1 = i2;
        break;
        paramInt1 = i3;
        i2 = i1;
        if (paramInt2 == i5 - 1)
        {
          paramInt1 = 0;
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(i1, i5 - i1);
          i2 = i1;
          continue;
          paramInt1 = i3;
          i2 = i1;
          if (i3 != 0)
          {
            paramInt1 = 0;
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(i1, paramInt2 - i1);
            i2 = i1;
          }
        }
      }
    }
    float f2 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize();
    int i4 = (int)f2;
    l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, (int[])localObject, i4, this.jdField_j_of_type_ArrayOfInt);
    paramInt1 = 0;
    float f1;
    if (paramInt1 < i5)
    {
      i1 = this.jdField_j_of_type_ArrayOfInt[paramInt1];
      paramInt2 = i1;
      if (i1 <= 0)
      {
        f1 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint().measureText(String.valueOf((char)localObject[paramInt1]));
        if (f1 <= 0.0F) {
          break label622;
        }
      }
      for (;;)
      {
        paramInt2 = (int)(f1 * k.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) / k.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId));
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt1));
        this.jdField_j_of_type_ArrayOfInt[paramInt1] = paramInt2;
        paramInt1 += 1;
        break;
        label622:
        f1 = i4;
      }
    }
    CharacterStyle[] arrayOfCharacterStyle;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject = (Spanned)paramCharSequence;
      arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), CharacterStyle.class);
      this.jdField_a_of_type_S.a((Spanned)localObject);
      Arrays.sort(arrayOfCharacterStyle, this.jdField_a_of_type_S);
    }
    for (;;)
    {
      this.jdField_j_of_type_Int = ((int)(k.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) * f2 / k.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId)));
      i2 = (int)(k.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) * f2 / k.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId));
      CharacterStyle localCharacterStyle;
      int i6;
      boolean bool;
      if ((localObject != null) && (arrayOfCharacterStyle != null) && (arrayOfCharacterStyle.length > 0))
      {
        i1 = 0;
        i3 = arrayOfCharacterStyle.length;
        paramInt1 = 0;
        while (paramInt1 < i3)
        {
          localCharacterStyle = arrayOfCharacterStyle[paramInt1];
          if ((localCharacterStyle instanceof RelativeSizeSpan))
          {
            paramInt2 = ((Spanned)localObject).getSpanStart(localCharacterStyle);
            i5 = ((Spanned)localObject).getSpanEnd(localCharacterStyle);
            f1 = ((RelativeSizeSpan)localCharacterStyle).getSizeChange();
            while (paramInt2 < i5)
            {
              i6 = this.jdField_j_of_type_ArrayOfInt[paramInt2];
              this.jdField_j_of_type_ArrayOfInt[paramInt2] = ((int)(i6 * f1));
              paramInt2 += 1;
            }
          }
          paramInt1 += 1;
        }
        paramInt2 = 0;
        paramInt1 = i1;
        if (paramInt2 < arrayOfCharacterStyle.length)
        {
          localCharacterStyle = arrayOfCharacterStyle[paramInt2];
          i3 = ((Spanned)localObject).getSpanStart(localCharacterStyle);
          i1 = ((Spanned)localObject).getSpanEnd(localCharacterStyle);
          if (i1 == ((Spanned)localObject).length())
          {
            bool = true;
            label917:
            if ((i3 <= paramInt1) || (i1 <= i3) || (!a(fn.a(paramCharSequence, paramInt1, i3), paramInt1, i4, 0, false, i2))) {
              break label1082;
            }
          }
        }
        else
        {
          label951:
          if (Build.VERSION.SDK_INT < 16) {
            break label1545;
          }
        }
      }
      label1280:
      label1542:
      label1545:
      for (paramInt2 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getMaxLines();; paramInt2 = 0)
      {
        f1 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint().getFontMetrics().bottom;
        this.jdField_i_of_type_Int = 0;
        this.jdField_h_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        i5 = this.jdField_a_of_type_JavaUtilList.size();
        i1 = 0;
        i2 = 0;
        if ((i1 >= i5) || (i1 >= paramInt2))
        {
          if (this.m < this.v) {
            this.jdField_f_of_type_Int = (this.m + this.jdField_a_of_type_Int + this.jdField_b_of_type_Int);
          }
          this.jdField_g_of_type_Int = (this.jdField_d_of_type_Int + i2 + this.jdField_c_of_type_Int);
          return;
          bool = false;
          break label917;
          label1082:
          if ((localCharacterStyle instanceof ClickableSpan)) {
            if (a(fn.a(paramCharSequence, i3, i1), i3, i4, 1, bool, i2)) {
              break label951;
            }
          }
          for (;;)
          {
            if ((paramInt2 == arrayOfCharacterStyle.length - 1) && (!bool) && (a(fn.a(paramCharSequence, i1, ((Spanned)localObject).length()), i1, i4, 0, true, i2))) {
              break label1280;
            }
            paramInt2 += 1;
            paramInt1 = i1;
            break;
            if (((localCharacterStyle instanceof QQText.EmoticonSpan)) || ((localCharacterStyle instanceof bank)))
            {
              if (!a(localCharacterStyle, i3, i1, 2, bool)) {
                continue;
              }
              break label951;
            }
            if ((localCharacterStyle instanceof RelativeSizeSpan))
            {
              if (!a((RelativeSizeSpan)localCharacterStyle, fn.a(paramCharSequence, i3, i1), i3, i4, 3, bool, i2)) {
                continue;
              }
              break label951;
            }
            n.b("FounderColorLayout", "Un Know CharacterStyle   start:" + i3 + "  end:" + i1);
          }
          break label951;
          a(paramCharSequence, 0, i4, 0, true, i2);
          break label951;
        }
        paramCharSequence = (List)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((paramCharSequence == null) || (paramCharSequence.isEmpty()))
        {
          if (i1 == i5 - 1) {}
          for (paramInt1 = 0;; paramInt1 = this.jdField_j_of_type_Int)
          {
            paramInt1 += i2 + i4;
            i1 += 1;
            i2 = paramInt1;
            break;
          }
        }
        this.jdField_i_of_type_Int = Math.max(this.jdField_i_of_type_Int, paramCharSequence.size());
        paramInt1 = 0;
        i6 = paramCharSequence.size();
        i3 = 0;
        label1395:
        if (i3 < i6)
        {
          localObject = (w)paramCharSequence.get(i3);
          if (((w)localObject).jdField_c_of_type_Int <= paramInt1) {
            break label1542;
          }
          paramInt1 = ((w)localObject).jdField_c_of_type_Int;
        }
        for (;;)
        {
          i3 += 1;
          break label1395;
          i6 = paramCharSequence.size();
          i3 = 0;
          while (i3 < i6)
          {
            localObject = (w)paramCharSequence.get(i3);
            ((w)localObject).jdField_e_of_type_Int = (paramInt1 - ((w)localObject).jdField_c_of_type_Int + i2 - (int)((1.0F - ((w)localObject).jdField_c_of_type_Int / paramInt1) * f1));
            i3 += 1;
          }
          if (i1 == i5 - 1) {}
          for (i3 = 0;; i3 = this.jdField_j_of_type_Int)
          {
            paramInt1 = i3 + (i2 + paramInt1);
            break;
          }
        }
      }
      localObject = null;
      arrayOfCharacterStyle = null;
    }
  }
  
  private void a(Canvas paramCanvas, w paramw)
  {
    if ((paramw.jdField_b_of_type_Int <= 0) || (paramw.jdField_c_of_type_Int <= 0)) {
      return;
    }
    BitmapShader localBitmapShader = k.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex, paramw.jdField_b_of_type_Int, paramw.jdField_c_of_type_Int);
    Bitmap localBitmap2;
    Bitmap localBitmap1;
    if (localBitmapShader == null)
    {
      localBitmap2 = Bitmap.createBitmap(paramw.jdField_b_of_type_Int, paramw.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
      localBitmap1 = Bitmap.createBitmap(paramw.jdField_b_of_type_Int, paramw.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
      switch (l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, localBitmap2, localBitmap1, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex))
      {
      default: 
        localBitmap2 = Bitmap.createBitmap(paramw.jdField_b_of_type_Int, paramw.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
        if (this.jdField_c_of_type_AndroidGraphicsCanvas == null) {
          this.jdField_c_of_type_AndroidGraphicsCanvas = new Canvas(localBitmap2);
        }
        break;
      }
    }
    for (;;)
    {
      if (localBitmap1 != null) {
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, null);
      }
      if (localBitmapShader != null) {
        this.jdField_d_of_type_AndroidGraphicsPaint.setShader(localBitmapShader);
      }
      this.jdField_d_of_type_AndroidGraphicsPaint.setTextSize(paramw.jdField_c_of_type_Int);
      this.jdField_c_of_type_AndroidGraphicsCanvas.drawText(String.valueOf(paramw.jdField_a_of_type_Char), 0.0F, (int)(paramw.jdField_c_of_type_Int / 2.0F - (this.jdField_d_of_type_AndroidGraphicsPaint.descent() + this.jdField_d_of_type_AndroidGraphicsPaint.ascent()) / 2.0F), this.jdField_d_of_type_AndroidGraphicsPaint);
      paramCanvas.drawBitmap(localBitmap2, paramw.jdField_d_of_type_Int, paramw.jdField_e_of_type_Int, this.jdField_d_of_type_AndroidGraphicsPaint);
      localBitmap2.recycle();
      return;
      localBitmap2.recycle();
      localBitmap1.recycle();
      localBitmap1 = null;
      break;
      localBitmapShader = new BitmapShader(localBitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      k.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex, paramw.jdField_b_of_type_Int, paramw.jdField_c_of_type_Int, localBitmapShader);
      localBitmap1.recycle();
      localBitmap1 = null;
      break;
      localBitmapShader = new BitmapShader(localBitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      k.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex, paramw.jdField_b_of_type_Int, paramw.jdField_c_of_type_Int, localBitmapShader);
      k.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex, paramw.jdField_b_of_type_Int, paramw.jdField_c_of_type_Int, localBitmap1);
      break;
      localBitmap1 = k.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex, paramw.jdField_b_of_type_Int, paramw.jdField_c_of_type_Int);
      break;
      this.jdField_c_of_type_AndroidGraphicsCanvas.setBitmap(localBitmap2);
    }
  }
  
  private boolean a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject;
    if ((paramCharacterStyle instanceof QQText.EmoticonSpan))
    {
      localObject = ((QQText.EmoticonSpan)paramCharacterStyle).getDrawable().getBounds();
      paramInt2 = ((Rect)localObject).width();
      paramInt1 = ((Rect)localObject).height();
    }
    for (;;)
    {
      localObject = a();
      ((w)localObject).jdField_a_of_type_Char = 65535;
      ((w)localObject).jdField_a_of_type_Boolean = false;
      ((w)localObject).jdField_b_of_type_Int = paramInt2;
      ((w)localObject).jdField_c_of_type_Int = paramInt1;
      ((w)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle = paramCharacterStyle;
      ((w)localObject).jdField_a_of_type_Int = paramInt3;
      if (this.u < ((w)localObject).jdField_b_of_type_Int)
      {
        this.q = Math.max(this.p, this.q);
        this.p = ((w)localObject).jdField_b_of_type_Int;
        this.r += 1;
        this.w = 0;
        ((w)localObject).jdField_d_of_type_Int = this.w;
        ((w)localObject).jdField_f_of_type_Int = this.r;
        this.w = ((w)localObject).jdField_b_of_type_Int;
        this.u = (this.v - ((w)localObject).jdField_b_of_type_Int);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
        this.jdField_c_of_type_JavaUtilList = new ArrayList();
        this.jdField_c_of_type_JavaUtilList.add(localObject);
        this.jdField_b_of_type_JavaUtilList.add(localObject);
        label220:
        if (this.w > this.m) {
          this.m = this.w;
        }
        this.s += 1;
        if ((this.t <= 0) || (this.s < this.t)) {
          break label402;
        }
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
        bool = true;
      }
      label402:
      while (!paramBoolean)
      {
        return bool;
        if (!(paramCharacterStyle instanceof bank)) {
          break label423;
        }
        localObject = (bank)paramCharacterStyle;
        paramInt2 = ((bank)localObject).a();
        paramInt1 = ((bank)localObject).b();
        break;
        this.p += ((w)localObject).jdField_b_of_type_Int;
        ((w)localObject).jdField_d_of_type_Int = this.w;
        ((w)localObject).jdField_f_of_type_Int = this.r;
        this.u -= ((w)localObject).jdField_b_of_type_Int;
        this.w += ((w)localObject).jdField_b_of_type_Int;
        this.jdField_c_of_type_JavaUtilList.add(localObject);
        this.jdField_b_of_type_JavaUtilList.add(localObject);
        break label220;
      }
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
      return false;
      label423:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
  
  private boolean a(RelativeSizeSpan paramRelativeSizeSpan, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    float f2 = paramRelativeSizeSpan.getSizeChange();
    int i5 = paramCharSequence.length();
    int i2 = 0;
    while (i2 < i5)
    {
      char c1 = paramCharSequence.charAt(i2);
      paramRelativeSizeSpan = a();
      if (c1 == '\n')
      {
        paramRelativeSizeSpan.jdField_a_of_type_Boolean = false;
        paramRelativeSizeSpan.jdField_a_of_type_Int = paramInt3;
        paramRelativeSizeSpan.jdField_b_of_type_Int = 0;
        paramRelativeSizeSpan.jdField_c_of_type_Int = paramInt4;
        paramRelativeSizeSpan.jdField_a_of_type_Char = c1;
        paramRelativeSizeSpan.jdField_d_of_type_Int = this.w;
        paramRelativeSizeSpan.jdField_f_of_type_Int = this.r;
        this.u = this.v;
        this.r += 1;
        this.w = 0;
        this.q = Math.max(this.p, this.q);
        this.p = 0;
        this.jdField_c_of_type_JavaUtilList.add(paramRelativeSizeSpan);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
        this.jdField_c_of_type_JavaUtilList = new ArrayList();
        this.jdField_b_of_type_JavaUtilList.add(paramRelativeSizeSpan);
        if ((i2 == i5 - 1) && (paramBoolean)) {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
        }
        i2 += 1;
      }
      else
      {
        int i4 = 0;
        int i1 = 0;
        int i3 = i4;
        if (this.jdField_a_of_type_AndroidUtilSparseIntArray.size() > 0)
        {
          int i6 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1 + i2);
          i3 = i4;
          if (i6 > 0)
          {
            i4 = 0;
            for (;;)
            {
              i3 = i1;
              if (i4 >= i6) {
                break;
              }
              i3 = this.jdField_j_of_type_ArrayOfInt[(paramInt1 + i2 + i4)];
              i4 += 1;
              i1 = i3 + i1;
            }
          }
        }
        float f1;
        if (paramInt1 + i2 < this.jdField_j_of_type_ArrayOfInt.length)
        {
          f1 = this.jdField_j_of_type_ArrayOfInt[(paramInt1 + i2)];
          label327:
          paramRelativeSizeSpan.jdField_a_of_type_Boolean = this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt1 + i2));
          paramRelativeSizeSpan.jdField_a_of_type_Int = paramInt3;
          paramRelativeSizeSpan.jdField_b_of_type_Int = ((int)f1);
          if (!paramRelativeSizeSpan.jdField_a_of_type_Boolean) {
            break label598;
          }
          i1 = paramInt2;
          label369:
          paramRelativeSizeSpan.jdField_c_of_type_Int = ((int)(i1 * f2));
          paramRelativeSizeSpan.jdField_a_of_type_Char = c1;
          if ((this.u >= paramRelativeSizeSpan.jdField_b_of_type_Int) && ((this.u >= i3) || (this.w == 0))) {
            break label605;
          }
          this.q = Math.max(this.p, this.q);
          this.p = paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.r += 1;
          this.w = 0;
          paramRelativeSizeSpan.jdField_d_of_type_Int = this.w;
          paramRelativeSizeSpan.jdField_f_of_type_Int = this.r;
          this.w = paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.u = (this.v - paramRelativeSizeSpan.jdField_b_of_type_Int);
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
          this.jdField_c_of_type_JavaUtilList = new ArrayList();
          this.jdField_c_of_type_JavaUtilList.add(paramRelativeSizeSpan);
        }
        for (;;)
        {
          if (this.w > this.m) {
            this.m = this.w;
          }
          this.s += 1;
          if ((this.t <= 0) || (this.s < this.t)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
          return true;
          f1 = paramInt2 * f2;
          break label327;
          label598:
          i1 = paramInt4;
          break label369;
          label605:
          this.p += paramRelativeSizeSpan.jdField_b_of_type_Int;
          paramRelativeSizeSpan.jdField_d_of_type_Int = this.w;
          paramRelativeSizeSpan.jdField_f_of_type_Int = this.r;
          this.u -= paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.w += paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.jdField_c_of_type_JavaUtilList.add(paramRelativeSizeSpan);
        }
      }
    }
    return false;
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    int i5 = paramCharSequence.length();
    int i2 = 0;
    while (i2 < i5)
    {
      char c1 = paramCharSequence.charAt(i2);
      w localw = a();
      if (c1 == '\n')
      {
        localw.jdField_a_of_type_Boolean = false;
        localw.jdField_a_of_type_Int = paramInt3;
        localw.jdField_b_of_type_Int = 0;
        localw.jdField_c_of_type_Int = paramInt4;
        localw.jdField_a_of_type_Char = c1;
        localw.jdField_d_of_type_Int = this.w;
        localw.jdField_f_of_type_Int = this.r;
        this.u = this.v;
        this.r += 1;
        this.w = 0;
        this.q = Math.max(this.p, this.q);
        this.p = 0;
        this.jdField_c_of_type_JavaUtilList.add(localw);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
        this.jdField_c_of_type_JavaUtilList = new ArrayList();
        this.jdField_b_of_type_JavaUtilList.add(localw);
        if ((i2 == i5 - 1) && (paramBoolean)) {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
        }
        i2 += 1;
      }
      else
      {
        int i4 = 0;
        int i1 = 0;
        int i3 = i4;
        if (this.jdField_a_of_type_AndroidUtilSparseIntArray.size() > 0)
        {
          int i6 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1 + i2);
          i3 = i4;
          if (i6 > 0)
          {
            i4 = 0;
            for (;;)
            {
              i3 = i1;
              if (i4 >= i6) {
                break;
              }
              i3 = this.jdField_j_of_type_ArrayOfInt[(paramInt1 + i2 + i4)];
              i4 += 1;
              i1 = i3 + i1;
            }
          }
        }
        float f1;
        if (paramInt1 + i2 < this.jdField_j_of_type_ArrayOfInt.length)
        {
          f1 = this.jdField_j_of_type_ArrayOfInt[(paramInt1 + i2)];
          label331:
          localw.jdField_a_of_type_Boolean = this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt1 + i2));
          localw.jdField_a_of_type_Int = paramInt3;
          localw.jdField_b_of_type_Int = ((int)f1);
          if (!localw.jdField_a_of_type_Boolean) {
            break label605;
          }
          i1 = paramInt2;
          label376:
          localw.jdField_c_of_type_Int = i1;
          localw.jdField_a_of_type_Char = c1;
          if ((this.u >= localw.jdField_b_of_type_Int) && ((this.u >= i3) || (this.w == 0))) {
            break label612;
          }
          this.q = Math.max(this.p, this.q);
          this.p = localw.jdField_b_of_type_Int;
          this.r += 1;
          this.w = 0;
          localw.jdField_d_of_type_Int = this.w;
          localw.jdField_f_of_type_Int = this.r;
          this.w = localw.jdField_b_of_type_Int;
          this.u = (this.v - localw.jdField_b_of_type_Int);
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
          this.jdField_c_of_type_JavaUtilList = new ArrayList();
          this.jdField_c_of_type_JavaUtilList.add(localw);
        }
        for (;;)
        {
          if (this.w > this.m) {
            this.m = this.w;
          }
          this.s += 1;
          if ((this.t <= 0) || (this.s < this.t)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
          return true;
          f1 = paramInt2;
          break label331;
          label605:
          i1 = paramInt4;
          break label376;
          label612:
          this.p += localw.jdField_b_of_type_Int;
          localw.jdField_d_of_type_Int = this.w;
          localw.jdField_f_of_type_Int = this.r;
          this.u -= localw.jdField_b_of_type_Int;
          this.w += localw.jdField_b_of_type_Int;
          this.jdField_c_of_type_JavaUtilList.add(localw);
        }
      }
    }
    return false;
  }
  
  private void k()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_c_of_type_JavaUtilList == null) {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_d_of_type_JavaUtilList == null) {
      this.jdField_d_of_type_JavaUtilList = new ArrayList();
    }
    if ((this.n <= 0) || (this.o <= 0))
    {
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getResources().getDisplayMetrics();
      this.n = localDisplayMetrics.widthPixels;
      this.o = localDisplayMetrics.heightPixels;
    }
    if (this.jdField_c_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_c_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    if (this.jdField_d_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_d_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_d_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseIntArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    }
    if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i5 = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(this.jdField_g_of_type_ArrayOfInt);
    int i6 = this.jdField_g_of_type_ArrayOfInt[0];
    int i7 = this.jdField_g_of_type_ArrayOfInt[1];
    int i3 = 0;
    int i2 = 0;
    List localList;
    Object localObject;
    int i1;
    label78:
    int i4;
    if (i3 < this.jdField_a_of_type_JavaUtilList.size())
    {
      localList = (List)this.jdField_a_of_type_JavaUtilList.get(i3);
      localObject = localList.iterator();
      i1 = -2147483648;
      if (((Iterator)localObject).hasNext())
      {
        w localw = (w)((Iterator)localObject).next();
        i4 = this.jdField_c_of_type_Int;
        int i8 = localw.jdField_e_of_type_Int;
        i4 = localw.jdField_c_of_type_Int + (i4 + i8);
        if (i4 <= i1) {
          break label274;
        }
        i1 = i4;
      }
    }
    label274:
    for (;;)
    {
      break label78;
      i4 = i5;
      if (i1 < paramInt2 - i7)
      {
        if (i3 == this.jdField_a_of_type_JavaUtilList.size() - 1) {
          i4 = i5;
        }
      }
      else
      {
        while (i4 < localList.size())
        {
          localObject = (w)localList.get(i4);
          paramInt2 = this.jdField_a_of_type_Int;
          i1 = ((w)localObject).jdField_d_of_type_Int;
          if (paramInt1 - i6 <= ((w)localObject).jdField_b_of_type_Int + (paramInt2 + i1)) {
            return i2 + i4;
          }
          i4 += 1;
        }
        return localList.size() + i2;
      }
      i1 = localList.size();
      i3 += 1;
      i2 += i1;
      break;
      return -1;
    }
  }
  
  public int a(int paramInt1, int paramInt2, gj paramgj)
  {
    int i1 = 0;
    while (i1 < this.jdField_b_of_type_JavaUtilList.size())
    {
      w localw = (w)this.jdField_b_of_type_JavaUtilList.get(i1);
      if ((paramInt1 >= localw.jdField_d_of_type_Int) && (paramInt1 <= localw.jdField_d_of_type_Int + localw.jdField_b_of_type_Int) && (paramInt2 >= localw.jdField_e_of_type_Int))
      {
        int i2 = localw.jdField_e_of_type_Int;
        if (paramInt2 <= localw.jdField_c_of_type_Int + i2) {
          return paramgj.b(i1);
        }
      }
      i1 += 1;
    }
    return -1;
  }
  
  protected Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = k.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex, paramInt1, paramInt2);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, localBitmap2, null);
      k.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex, paramInt1, paramInt2, localBitmap2);
      localBitmap1 = localBitmap2;
      if (l.jdField_a_of_type_Boolean)
      {
        n.a("FounderColorLayout", "create new under line bitmap.... width:" + paramInt1 + "  height:" + paramInt2);
        localBitmap1 = localBitmap2;
      }
    }
    return localBitmap1;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new r(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int i2 = this.jdField_b_of_type_JavaUtilList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      if ((i1 < paramInt1) || (i1 >= paramInt2)) {}
      for (;;)
      {
        i1 += 1;
        break;
        w localw = (w)this.jdField_b_of_type_JavaUtilList.get(i1);
        Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        float f1 = this.jdField_a_of_type_Int + localw.jdField_d_of_type_Int;
        float f2 = this.jdField_c_of_type_Int + localw.jdField_e_of_type_Int;
        float f3 = this.jdField_a_of_type_Int + localw.jdField_d_of_type_Int + localw.jdField_b_of_type_Int;
        int i3 = this.jdField_c_of_type_Int;
        int i4 = localw.jdField_e_of_type_Int;
        localPath.addRect(f1, f2, f3, localw.jdField_c_of_type_Int + (i3 + i4), Path.Direction.CW);
      }
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (!paramBoolean) {
      i1 = paramInt - 1;
    }
    paramInt = i1;
    if (i1 >= this.jdField_b_of_type_JavaUtilList.size())
    {
      paramInt = this.jdField_b_of_type_JavaUtilList.size() - 1;
      paramBoolean = false;
    }
    if (paramInt < 0) {
      return;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(paramArrayOfInt);
    w localw = (w)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.jdField_a_of_type_Int + localw.jdField_d_of_type_Int;
      paramInt = paramArrayOfInt[1];
      i1 = this.jdField_c_of_type_Int;
      i2 = localw.jdField_e_of_type_Int;
      paramArrayOfInt[1] = (localw.jdField_c_of_type_Int + (i1 + i2) + paramInt);
      return;
    }
    paramArrayOfInt[0] += this.jdField_a_of_type_Int + localw.jdField_d_of_type_Int + localw.jdField_b_of_type_Int;
    paramInt = paramArrayOfInt[1];
    i1 = this.jdField_c_of_type_Int;
    int i2 = localw.jdField_e_of_type_Int;
    paramArrayOfInt[1] = (localw.jdField_c_of_type_Int + (i1 + i2) + paramInt);
  }
  
  protected void a(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(-256);
    localPaint.setStrokeWidth(1.0F);
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramCanvas.drawRect(this.jdField_a_of_type_Int + this.jdField_b_of_type_ArrayOfInt[i1], this.jdField_c_of_type_Int + this.jdField_c_of_type_ArrayOfInt[i1], this.jdField_a_of_type_Int + this.jdField_b_of_type_ArrayOfInt[i1] + this.jdField_d_of_type_ArrayOfInt[i1], this.jdField_c_of_type_Int + this.jdField_c_of_type_ArrayOfInt[i1] + this.jdField_e_of_type_ArrayOfInt[i1], localPaint);
      i1 += 1;
    }
  }
  
  protected void a(String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
    }
  }
  
  protected boolean a()
  {
    if (!a(this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int)) {
      return false;
    }
    int i2 = this.jdField_b_of_type_JavaUtilList.size();
    if (i2 <= 0) {
      return false;
    }
    if (this.x != i2) {
      this.jdField_a_of_type_ArrayOfInt = new int[i2];
    }
    if ((this.x < i2) || (this.x - i2 > 100))
    {
      this.jdField_b_of_type_ArrayOfInt = new int[i2];
      this.jdField_c_of_type_ArrayOfInt = new int[i2];
      this.jdField_d_of_type_ArrayOfInt = new int[i2];
      this.jdField_e_of_type_ArrayOfInt = new int[i2];
    }
    this.x = i2;
    this.jdField_b_of_type_Boolean = true;
    int i1 = 0;
    while (i1 < i2)
    {
      w localw = (w)this.jdField_b_of_type_JavaUtilList.get(i1);
      this.jdField_a_of_type_ArrayOfInt[i1] = localw.jdField_a_of_type_Char;
      this.jdField_b_of_type_ArrayOfInt[i1] = localw.jdField_d_of_type_Int;
      this.jdField_c_of_type_ArrayOfInt[i1] = localw.jdField_e_of_type_Int;
      this.jdField_d_of_type_ArrayOfInt[i1] = localw.jdField_b_of_type_Int;
      this.jdField_e_of_type_ArrayOfInt[i1] = localw.jdField_c_of_type_Int;
      if (localw.jdField_a_of_type_Int != 2) {
        this.jdField_b_of_type_Boolean = false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (b())
    {
      a("FounderColorLayout::onDraw view宽高为0或超过屏幕尺寸！");
      return false;
    }
    if (!a())
    {
      a("FounderColorLayout::onDraw 创建bitmap失败！");
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      a(amtj.a(2131703982));
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfInt.length <= 0)
    {
      a(amtj.a(2131703981));
      return false;
    }
    c();
    b(paramCanvas);
    long l1 = System.nanoTime();
    int i1 = k.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation) && (!this.jdField_b_of_type_Boolean) && (i1 == 3) && (this.jdField_h_of_type_Int > 0) && (this.jdField_h_of_type_Int < 6))
    {
      l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_i_of_type_ArrayOfInt);
      j();
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
      if (this.jdField_e_of_type_Int == 0) {
        b();
      }
      if (l.jdField_a_of_type_Boolean)
      {
        long l2 = System.nanoTime();
        n.b("FounderColorLayout", "动画帧耗时 frameIndex:" + this.jdField_e_of_type_Int + "  行：" + this.jdField_h_of_type_Int + "  列：" + this.jdField_i_of_type_Int + "  耗时：" + (float)(l2 - l1) / 1000000.0F + "ms");
        if (this.jdField_e_of_type_Int == 0) {
          a("drawAnimationText.....");
        }
      }
      return true;
    }
    if ((!this.jdField_b_of_type_Boolean) && (i1 == 5))
    {
      l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex);
      j();
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
      return true;
    }
    this.jdField_f_of_type_ArrayOfInt = new int[0];
    l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.k, this.jdField_f_of_type_ArrayOfInt, this.l);
    j();
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
    return true;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
  {
    if ((this.jdField_a_of_type_Long == paramLong) && (this.jdField_d_of_type_Boolean == paramBoolean) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(paramETFont)) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.isCacheMeasureResult())) {
      return this.jdField_h_of_type_ArrayOfInt;
    }
    if (this.jdField_a_of_type_Long != paramLong)
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
      }
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.isFounderAnimating = false;
      }
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_e_of_type_Int = 0;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(-1, null, 0.0F);
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(paramETFont);
    this.jdField_h_of_type_ArrayOfInt[0] = View.MeasureSpec.getSize(paramInt1);
    this.jdField_h_of_type_ArrayOfInt[1] = View.MeasureSpec.getSize(paramInt2);
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath)) || (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getVisibility() == 8)) {
      return this.jdField_h_of_type_ArrayOfInt;
    }
    CharSequence localCharSequence = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText();
    if (TextUtils.isEmpty(localCharSequence)) {
      return this.jdField_h_of_type_ArrayOfInt;
    }
    paramLong = System.nanoTime();
    a(paramInt1, paramInt2, localCharSequence);
    double d1 = (float)(System.nanoTime() - paramLong) / 1000000.0F;
    if (l.jdField_a_of_type_Boolean) {
      n.a("FounderColorLayout", "字数：" + localCharSequence.length() + "   字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "px   排版耗时：" + d1 + "ms");
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
      gi.a("action_measure", paramETFont.mFontId, 4, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText().length(), d1);
    }
    if (b()) {
      return this.jdField_h_of_type_ArrayOfInt;
    }
    this.jdField_h_of_type_ArrayOfInt[0] = this.jdField_f_of_type_Int;
    this.jdField_h_of_type_ArrayOfInt[1] = this.jdField_g_of_type_Int;
    return this.jdField_h_of_type_ArrayOfInt;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (b())) {}
    do
    {
      return;
      if (k.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) < 3)
      {
        n.b("FounderColorLayout", "当前字体未加载或不支持动画..." + this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath);
        return;
      }
      if ((this.jdField_h_of_type_Int <= 0) || (this.jdField_h_of_type_Int > 5) || (this.jdField_b_of_type_Boolean))
      {
        n.b("FounderColorLayout", "0行或超过5行不支持播放动画..." + this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath);
        return;
      }
    } while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
    {
      h();
      return;
    }
    this.jdField_e_of_type_Int = 0;
    l.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_i_of_type_ArrayOfInt);
    if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
    {
      h();
      return;
    }
    n.b("FounderColorLayout", "StartAnimation......动画帧数和帧间隔数据异常 animInfo:" + Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
  }
  
  protected void b(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.hasSelected()) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.highlightBackgroundColor());
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected boolean b()
  {
    int i4 = 1;
    int i1;
    int i2;
    label41:
    int i3;
    if (this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int <= 0)
    {
      i1 = 1;
      if (this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int > 0) {
        break label101;
      }
      i2 = 1;
      if (this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int <= this.n) {
        break label106;
      }
      i3 = 1;
      label64:
      if (this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int <= this.o) {
        break label111;
      }
    }
    for (;;)
    {
      return i3 | 0x0 | i1 | i2 | i4;
      i1 = 0;
      break;
      label101:
      i2 = 0;
      break label41;
      label106:
      i3 = 0;
      break label64;
      label111:
      i4 = 0;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
  }
  
  public void e()
  {
    super.e();
    this.jdField_b_of_type_AndroidGraphicsCanvas = null;
    this.jdField_c_of_type_AndroidGraphicsCanvas = null;
  }
  
  protected void j()
  {
    int i2 = (int)(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() / 15.0F);
    int i1;
    label47:
    w localw;
    if (this.jdField_b_of_type_AndroidGraphicsCanvas == null)
    {
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      int i3 = this.jdField_b_of_type_JavaUtilList.size();
      i1 = 0;
      if (i1 >= i3) {
        return;
      }
      localw = (w)this.jdField_b_of_type_JavaUtilList.get(i1);
      switch (localw.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (localw.jdField_a_of_type_Boolean) {
        a(this.jdField_b_of_type_AndroidGraphicsCanvas, localw);
      }
      i1 += 1;
      break label47;
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      break;
      Object localObject = a(localw.jdField_b_of_type_Int, i2);
      this.jdField_b_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject, localw.jdField_d_of_type_Int, localw.jdField_e_of_type_Int + localw.jdField_c_of_type_Int - i2, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      continue;
      this.jdField_b_of_type_AndroidGraphicsCanvas.drawRect(localw.jdField_d_of_type_Int, localw.jdField_e_of_type_Int, localw.jdField_d_of_type_Int + localw.jdField_b_of_type_Int, localw.jdField_e_of_type_Int + localw.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      if ((localw.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof QQText.EmoticonSpan))
      {
        ((QQText.EmoticonSpan)localw.jdField_a_of_type_AndroidTextStyleCharacterStyle).draw(this.jdField_b_of_type_AndroidGraphicsCanvas, null, 0, 0, localw.jdField_d_of_type_Int, localw.jdField_e_of_type_Int, localw.jdField_e_of_type_Int + localw.jdField_c_of_type_Int, localw.jdField_e_of_type_Int + localw.jdField_c_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
      else if ((localw.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof bank))
      {
        localObject = (bank)localw.jdField_a_of_type_AndroidTextStyleCharacterStyle;
        ((bank)localObject).jdField_a_of_type_Boolean = false;
        ((bank)localObject).draw(this.jdField_b_of_type_AndroidGraphicsCanvas, null, 0, 0, localw.jdField_d_of_type_Int, localw.jdField_e_of_type_Int, localw.jdField_e_of_type_Int, localw.jdField_e_of_type_Int + localw.jdField_c_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     q
 * JD-Core Version:    0.7.0.1
 */