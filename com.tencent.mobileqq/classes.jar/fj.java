import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETSegment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class fj
{
  public int a;
  public long a;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  public ETFont a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList<fm> jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
  public AtomicBoolean a;
  public boolean a;
  private fn[] jdField_a_of_type_ArrayOfFn;
  public int b;
  public ETFont b;
  private ArrayList<CharacterStyle> b;
  public boolean b;
  public int c;
  private ArrayList<fo> jdField_c_of_type_JavaUtilArrayList = new ArrayList(16);
  private boolean jdField_c_of_type_Boolean;
  int d = -1;
  private int e;
  private int f;
  private int g;
  
  public fj()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(4);
    this.jdField_b_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, "", 24.0F);
  }
  
  private int a(char paramChar1, char paramChar2)
  {
    return (paramChar1 << '\n') + paramChar2 - 56613888;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramCharSequence == null) {
      return "";
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramCharSequence.length()) {
      paramInt1 = paramCharSequence.length();
    }
    paramInt2 = paramInt1 - i;
    if (paramInt2 <= 0) {
      return "";
    }
    char[] arrayOfChar = new char[paramInt2];
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      arrayOfChar[paramInt1] = paramCharSequence.charAt(paramInt1 + i);
      paramInt1 += 1;
    }
    return String.valueOf(arrayOfChar);
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.jdField_a_of_type_ArrayOfFn == null) || (this.jdField_a_of_type_ArrayOfFn.length == 0)) {
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = ((fm)localIterator.next()).a();
      if (localObject == null) {
        return null;
      }
      localObject = ((ArrayList)localObject).iterator();
      int j = i;
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        fh localfh = (fh)((Iterator)localObject).next();
        if (localfh == null) {
          return null;
        }
        String str = localfh.a();
        if (str != null)
        {
          localfh.a(j);
          j += str.length();
          localStringBuilder.append(str);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if ((this.jdField_a_of_type_JavaLangCharSequence != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      if ((this.jdField_a_of_type_JavaLangCharSequence instanceof Spanned)) {
        b();
      }
    }
    else {
      return;
    }
    a(this.jdField_a_of_type_JavaLangCharSequence.toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
  }
  
  private void a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramCharacterStyle = new fm(paramCharacterStyle, paramInt1, paramInt2, paramInt3, paramBoolean);
    paramCharacterStyle.a(this.g);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramCharacterStyle);
  }
  
  private void a(ETEngine paramETEngine, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfFn != null) {
      this.jdField_a_of_type_ArrayOfFn = null;
    }
    int m = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    int j = 0;
    int k = 0;
    Object localObject1;
    while (i < m)
    {
      localObject1 = (fm)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      k = ((fm)localObject1).a(paramETEngine, paramInt, j, k);
      j = ((fm)localObject1).a();
      i += 1;
    }
    k += 1;
    this.jdField_a_of_type_ArrayOfFn = new fn[k];
    paramInt = 0;
    while (paramInt < k)
    {
      this.jdField_a_of_type_ArrayOfFn[paramInt] = new fn();
      paramInt += 1;
    }
    paramInt = 0;
    Object localObject2;
    while (paramInt < m)
    {
      localObject1 = ((fm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a();
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (fh)((ArrayList)localObject1).get(i);
        j = ((fh)localObject2).e();
        if ((j >= 0) && (j < k)) {
          this.jdField_a_of_type_ArrayOfFn[j].a((fh)localObject2);
        }
        i += 1;
      }
      paramInt += 1;
    }
    paramInt = 0;
    i = 0;
    while (paramInt < k)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfFn[paramInt];
      ((fn)localObject1).a(paramETEngine, 0, i, this.jdField_a_of_type_Int);
      localObject2 = ((fn)localObject1).a().iterator();
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        fh localfh = (fh)((Iterator)localObject2).next();
        fo[] arrayOffo = localfh.a(paramETEngine, j, i, ((fn)localObject1).a(), paramInt);
        if ((arrayOffo != null) && (arrayOffo.length > 0)) {
          Collections.addAll(this.jdField_c_of_type_JavaUtilArrayList, arrayOffo);
        }
        j += localfh.c();
      }
      i += ((fn)localObject1).a();
      paramInt += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    paramString = new fm(paramString, paramInt1, paramInt2, paramETFont, paramBoolean);
    paramString.a(this.g);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = new fm(paramString, paramInt1, paramInt2, paramETFont, paramBoolean1);
    paramString.a(this.g);
    paramString.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Object[] a()
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      return this.jdField_b_of_type_JavaUtilArrayList.toArray();
    }
    return null;
  }
  
  private int b()
  {
    if ((this.jdField_a_of_type_ArrayOfFn == null) || (this.jdField_a_of_type_ArrayOfFn.length == 0)) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfFn.length;
    return this.jdField_a_of_type_ArrayOfFn[(i - 1)].b();
  }
  
  private void b()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    Object localObject = (Spanned)this.jdField_a_of_type_JavaLangCharSequence;
    CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), CharacterStyle.class);
    fl[] arrayOffl = new fl[arrayOfCharacterStyle.length];
    if ((arrayOffl == null) || (arrayOffl.length == 0))
    {
      a(this.jdField_a_of_type_JavaLangCharSequence.toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      return;
    }
    int i = 0;
    while (i < arrayOfCharacterStyle.length)
    {
      arrayOffl[i] = new fl();
      arrayOffl[i].jdField_a_of_type_Int = ((Spanned)localObject).getSpanStart(arrayOfCharacterStyle[i]);
      arrayOffl[i].jdField_b_of_type_Int = ((Spanned)localObject).getSpanEnd(arrayOfCharacterStyle[i]);
      arrayOffl[i].jdField_a_of_type_AndroidTextStyleCharacterStyle = arrayOfCharacterStyle[i];
      i += 1;
    }
    Arrays.sort(arrayOffl, new fk());
    i = 0;
    int j = 0;
    label176:
    int m;
    int k;
    if (i < arrayOfCharacterStyle.length)
    {
      m = arrayOffl[i].jdField_a_of_type_Int;
      k = arrayOffl[i].jdField_b_of_type_Int;
      if (m - j > 0) {
        a(a(this.jdField_a_of_type_JavaLangCharSequence, j, m).toString(), j, m, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      }
      if (k - m > 0)
      {
        if (!(arrayOffl[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof ClickableSpan)) {
          break label379;
        }
        if ((m <= 0) || (this.jdField_a_of_type_JavaLangCharSequence.charAt(m - 1) != '\024')) {
          break label610;
        }
      }
    }
    label610:
    for (j = m + 1;; j = m)
    {
      a(a(this.jdField_a_of_type_JavaLangCharSequence, j, k).toString(), j, k, this.jdField_b_of_type_ComEtrumpMixlayoutETFont, true);
      for (;;)
      {
        if ((i == arrayOfCharacterStyle.length - 1) && (k < this.jdField_a_of_type_JavaLangCharSequence.length())) {
          a(a(this.jdField_a_of_type_JavaLangCharSequence, k, this.jdField_a_of_type_JavaLangCharSequence.length()).toString(), k, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
        }
        i += 1;
        j = k;
        break label176;
        break;
        label379:
        if ((arrayOffl[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof bain))
        {
          localObject = (bain)arrayOffl[i].jdField_a_of_type_AndroidTextStyleCharacterStyle;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          a((CharacterStyle)localObject, this.jdField_b_of_type_JavaUtilArrayList.indexOf(localObject), m, k, false);
        }
        else if ((arrayOffl[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof RelativeSizeSpan))
        {
          localObject = a(this.jdField_a_of_type_JavaLangCharSequence, m, k);
          RelativeSizeSpan localRelativeSizeSpan = (RelativeSizeSpan)arrayOffl[i].jdField_a_of_type_AndroidTextStyleCharacterStyle;
          ETFont localETFont = new ETFont(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize());
          localETFont.copy(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
          localETFont.setSize(localRelativeSizeSpan.getSizeChange() * this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize());
          a(((CharSequence)localObject).toString(), m, k, localETFont, false, true);
        }
        else if ((arrayOffl[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof axye))
        {
          localObject = (axye)arrayOffl[i].jdField_a_of_type_AndroidTextStyleCharacterStyle;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          a((CharacterStyle)localObject, this.jdField_b_of_type_JavaUtilArrayList.indexOf(localObject), m, k, false);
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ArrayOfFn != null) {
      return this.jdField_a_of_type_ArrayOfFn.length;
    }
    return 0;
  }
  
  int a(int paramInt)
  {
    int j = this.jdField_a_of_type_ArrayOfFn.length;
    int i = 0;
    while (i < j)
    {
      fn localfn = this.jdField_a_of_type_ArrayOfFn[i];
      int k = localfn.d();
      if (paramInt < localfn.a() + k) {
        return i;
      }
      i += 1;
    }
    return j - 1;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int j = a(paramInt2);
    int k = this.jdField_c_of_type_JavaUtilArrayList.size();
    int i = k - 1;
    paramInt2 = 0;
    if (paramInt2 < k)
    {
      fo localfo = (fo)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
      if (localfo.jdField_a_of_type_Int == j)
      {
        if (paramInt1 > localfo.jdField_a_of_type_AndroidGraphicsRect.right) {
          break label87;
        }
        return paramInt2;
      }
      if (localfo.jdField_a_of_type_Int <= j) {}
    }
    else
    {
      return i + 1;
    }
    for (;;)
    {
      paramInt2 += 1;
      break;
      label87:
      i = paramInt2;
    }
  }
  
  Rect a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfFn.length)) {
      return null;
    }
    fn localfn = this.jdField_a_of_type_ArrayOfFn[paramInt];
    paramInt = localfn.c();
    int i = localfn.d();
    return new Rect(paramInt, i, this.jdField_b_of_type_Int + paramInt, i + localfn.a());
  }
  
  public bain a(int paramInt1, int paramInt2)
  {
    int i = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    fn[] arrayOffn = this.jdField_a_of_type_ArrayOfFn;
    int j = arrayOffn.length;
    if (i < j)
    {
      Object localObject = arrayOffn[i];
      localRect.left = ((fn)localObject).c();
      localRect.top = ((fn)localObject).d();
      localRect.right = (localRect.left + ((fn)localObject).b());
      localRect.bottom = (localRect.top + ((fn)localObject).a());
      if (!localRect.contains(paramInt1, paramInt2)) {}
      do
      {
        i += 1;
        break;
        localObject = ((fn)localObject).a(paramInt1);
      } while (localObject == null);
      return ((fh)localObject).a();
    }
    return null;
  }
  
  public ETDecoration a(ETEngine paramETEngine, boolean paramBoolean)
  {
    if (paramETEngine == null) {
      return null;
    }
    String str = a();
    int j = b();
    int k = a();
    ETSegment[] arrayOfETSegment = a(paramETEngine);
    Object[] arrayOfObject = a();
    int i;
    if (!paramBoolean)
    {
      this.d = -1;
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        if (((CharacterStyle)this.jdField_b_of_type_JavaUtilArrayList.get(i) instanceof axye)) {
          this.d = i;
        }
      }
      else {
        return ETDecoration.createDecoration(paramETEngine, str, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, j, k, arrayOfETSegment, arrayOfObject, this.jdField_c_of_type_Boolean, this.f, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, paramBoolean);
      }
      i += 1;
    }
  }
  
  fo a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_c_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (fo)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ArrayOfFn == null) {}
    for (;;)
    {
      return;
      fn[] arrayOffn = this.jdField_a_of_type_ArrayOfFn;
      int k = arrayOffn.length;
      int j = 0;
      int i = paramInt2;
      paramInt2 = j;
      while (paramInt2 < k)
      {
        fn localfn = arrayOffn[paramInt2];
        localfn.a(paramCanvas, paramInt1, i);
        i += localfn.a();
        paramInt2 += 1;
      }
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int j = 2048;
    if (paramCanvas == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    int n;
    int i;
    if (paramBitmap != null)
    {
      n = paramBitmap.getWidth();
      i = paramBitmap.getHeight();
      if (Build.VERSION.SDK_INT < 14) {
        break label234;
      }
      paramInt1 = paramCanvas.getMaximumBitmapHeight();
    }
    for (paramInt2 = paramCanvas.getMaximumBitmapWidth();; paramInt2 = j)
    {
      if ((n <= paramInt2) && (i <= paramInt1)) {
        paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      }
      for (;;)
      {
        paramCanvas.restore();
        return;
        Rect localRect = new Rect(0, 0, 0, 0);
        while (i > 0)
        {
          int k;
          if (i >= paramInt1)
          {
            k = paramInt1;
            localRect.left = 0;
            localRect.bottom += k;
            j = n;
            label136:
            if (j <= 0) {
              break label211;
            }
            if (j < paramInt2) {
              break label204;
            }
          }
          label204:
          for (int m = paramInt2;; m = j)
          {
            j -= m;
            localRect.right += m;
            paramCanvas.drawBitmap(paramBitmap, localRect, localRect, null);
            localRect.left = (m + localRect.left);
            break label136;
            k = i;
            break;
          }
          label211:
          localRect.top = (k + localRect.top);
          i -= k;
        }
      }
      label234:
      paramInt1 = 2048;
    }
  }
  
  @TargetApi(14)
  public final void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, boolean paramBoolean)
  {
    if ((paramETEngine == null) || (paramBitmap == null))
    {
      break label8;
      break label8;
    }
    label8:
    int n;
    int j;
    int i;
    Object localObject1;
    int k;
    label174:
    for (;;)
    {
      return;
      if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int > 0))
      {
        n = paramBitmap.getHeight();
        if ((paramETDecoration == null) || (2 != paramETDecoration.getDecorationType())) {
          break label176;
        }
        j = 0;
        i = 0;
        if (paramBoolean)
        {
          paramETDecoration.drawScene(paramBitmap, 0, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
          return;
        }
        localObject1 = paramETDecoration.mMargins;
        if (localObject1 != null)
        {
          j = ((Rect)localObject1).left;
          i = ((Rect)localObject1).top;
        }
        paramETDecoration.drawBackground(paramBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
        if (this.jdField_a_of_type_ArrayOfFn == null) {
          break;
        }
        paramETDecoration = this.jdField_a_of_type_ArrayOfFn;
        int i1 = paramETDecoration.length;
        int m = 0;
        k = i;
        i = m;
        for (;;)
        {
          if (i >= i1) {
            break label174;
          }
          localObject1 = paramETDecoration[i];
          ((fn)localObject1).a(paramETEngine, paramBitmap, null, j, k);
          k += ((fn)localObject1).a();
          if (k >= n) {
            break;
          }
          i += 1;
        }
      }
    }
    label176:
    if (!paramBoolean) {
      paramETDecoration = null;
    }
    for (;;)
    {
      if ((paramETDecoration != null) && (1 == paramETDecoration.getDecorationType())) {
        paramETDecoration.drawBackground(paramBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      }
      if (this.jdField_a_of_type_ArrayOfFn != null)
      {
        j = 0;
        localObject1 = this.jdField_a_of_type_ArrayOfFn;
        k = localObject1.length;
        i = 0;
      }
      for (;;)
      {
        if (i < k)
        {
          Object localObject2 = localObject1[i];
          localObject2.a(paramETEngine, paramBitmap, paramETDecoration, 0, j);
          j += localObject2.a();
          if (j < n) {}
        }
        else
        {
          if ((paramETDecoration == null) || (1 != paramETDecoration.getDecorationType())) {
            break;
          }
          paramETDecoration.drawForeground(paramBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
          return;
        }
        i += 1;
      }
    }
  }
  
  public boolean a(ETEngine paramETEngine, int paramInt1, CharSequence paramCharSequence, ETFont paramETFont, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.e = paramInt1;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.f = paramInt3;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_b_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.copy(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.setColor(paramInt2);
    }
    a();
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    a(paramETEngine, paramInt1);
    if (this.jdField_a_of_type_ArrayOfFn == null) {
      throw new Exception("measure textLines fail");
    }
    int j = this.jdField_a_of_type_ArrayOfFn.length;
    paramInt2 = 0;
    paramInt3 = 0;
    paramInt1 = 0;
    int k;
    if (paramInt2 < j)
    {
      int i = this.jdField_a_of_type_ArrayOfFn[paramInt2].b();
      k = this.jdField_a_of_type_ArrayOfFn[paramInt2].a();
      if (i <= paramInt1) {
        break label254;
      }
      paramInt1 = i;
    }
    label254:
    for (;;)
    {
      paramInt3 += k;
      paramInt2 += 1;
      break;
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt3;
      if ((this.jdField_b_of_type_Int <= 0) || (this.jdField_c_of_type_Int <= 0)) {
        throw new Exception("mesure fail mWidth=" + this.jdField_b_of_type_Int + ",mHeight" + this.jdField_c_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return true;
    }
  }
  
  public ETSegment[] a(ETEngine paramETEngine)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ArrayOfFn == null) {
      return null;
    }
    fn[] arrayOffn = this.jdField_a_of_type_ArrayOfFn;
    int n = arrayOffn.length;
    int k = 0;
    int j = 0;
    int i = 0;
    fn localfn;
    int m;
    label74:
    fh localfh;
    ETSegment localETSegment;
    Object localObject2;
    int i1;
    int i2;
    if (k < n)
    {
      localfn = arrayOffn[k];
      Object localObject1 = localfn.a();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      m = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localfh = (fh)((Iterator)localObject1).next();
        if (localfh == null) {
          return null;
        }
        localETSegment = new ETSegment();
        localETSegment.type = 0;
        localETSegment.codePoint = -1;
        localETSegment.textOffset = 0;
        localETSegment.textLength = 0;
        localETSegment.lineNum = 0;
        localETSegment.textSize = 0;
        localETSegment.x = 0;
        localETSegment.y = 0;
        localObject2 = localfh.a();
        if (localObject2 == null) {
          break label513;
        }
        localETSegment.textLength = ((String)localObject2).length();
        localETSegment.textOffset = i;
        localETSegment.type = 0;
        i = ((String)localObject2).length() + i;
        i1 = localfn.a();
        i2 = localfh.d();
        int i3 = localfn.e();
        int i4 = localfh.a(paramETEngine);
        localETSegment.x = m;
        localETSegment.y = (i1 - i2 + j - (i3 - i4));
      }
    }
    label513:
    for (;;)
    {
      localObject2 = localfh.b();
      if (localObject2 != null)
      {
        localETSegment.textLength = 1;
        localETSegment.type = 1;
        localETSegment.codePoint = a(((String)localObject2).charAt(0), ((String)localObject2).charAt(1));
        i1 = localfn.a();
        i2 = localfh.d();
        localETSegment.x = m;
        localETSegment.y = (i1 - i2 + j);
      }
      i1 = localfh.b();
      if (i1 > -1)
      {
        localETSegment.type = 2;
        localETSegment.codePoint = i1;
        i1 = localfn.a();
        i2 = localfh.d();
        localETSegment.x = m;
        localETSegment.y = (i1 - i2 + j);
        localObject2 = localfh.a();
        if ((localObject2 instanceof axye))
        {
          localObject2 = (axye)localObject2;
          ((axye)localObject2).jdField_a_of_type_Float = m;
          ((axye)localObject2).b = localETSegment.y;
        }
      }
      localETSegment.textSize = localfh.a();
      localETSegment.lineNum = localfh.e();
      localArrayList.add(localETSegment);
      m = localfh.c() + m;
      break label74;
      m = localfn.a();
      k += 1;
      j += m;
      break;
      return (ETSegment[])localArrayList.toArray(new ETSegment[localArrayList.size()]);
    }
  }
  
  public fo[] a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfFn == null) || (paramInt >= this.jdField_a_of_type_ArrayOfFn.length)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      fo localfo = (fo)localIterator.next();
      if (localfo.jdField_a_of_type_Int == paramInt) {
        localArrayList.add(localfo);
      }
    }
    return (fo[])localArrayList.toArray(new fo[0]);
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    int i = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    fn[] arrayOffn = this.jdField_a_of_type_ArrayOfFn;
    int j = arrayOffn.length;
    if (i < j)
    {
      Object localObject = arrayOffn[i];
      localRect.left = ((fn)localObject).c();
      localRect.top = ((fn)localObject).d();
      localRect.right = (localRect.left + ((fn)localObject).b());
      localRect.bottom = (localRect.top + ((fn)localObject).a());
      if (!localRect.contains(paramInt1, paramInt2)) {}
      do
      {
        i += 1;
        break;
        localObject = ((fn)localObject).a(paramInt1);
      } while (localObject == null);
      return ((fh)localObject).a().b();
    }
    return -1;
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int j = 0;
    Object localObject1;
    int i;
    int k;
    if ((this.d > -1) && (this.d < this.jdField_b_of_type_JavaUtilArrayList.size()))
    {
      localObject1 = (axye)this.jdField_b_of_type_JavaUtilArrayList.get(this.d);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontSize);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontColor);
      i = ((axye)localObject1).b();
      k = (int)((axye)localObject1).b;
      ((axye)localObject1).jdField_a_of_type_Boolean = false;
      ((axye)localObject1).draw(paramCanvas, null, 0, 0, ((axye)localObject1).jdField_a_of_type_Float, (int)((axye)localObject1).b, 0, i + k, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_ArrayOfFn == null) {}
    for (;;)
    {
      return;
      localObject1 = this.jdField_a_of_type_ArrayOfFn;
      k = localObject1.length;
      i = paramInt2;
      paramInt2 = j;
      while (paramInt2 < k)
      {
        Object localObject2 = localObject1[paramInt2];
        localObject2.b(paramCanvas, paramInt1, i);
        i += localObject2.a();
        paramInt2 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fj
 * JD-Core Version:    0.7.0.1
 */