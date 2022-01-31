import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import java.util.ArrayList;

public class fm
{
  private int jdField_a_of_type_Int;
  private CharacterStyle jdField_a_of_type_AndroidTextStyleCharacterStyle;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<fh> jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  
  public fm(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidTextStyleCharacterStyle = paramCharacterStyle;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public fm(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  private int a(ETEngine paramETEngine, String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return 0;
    }
    long l = paramETEngine.native_textLayoutLock(paramString, this.f, 1073741823, this.g, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
    int j = paramETEngine.native_textLayoutLineTotal(l);
    if (j < 1)
    {
      paramETEngine.native_textLayoutUnlock(l);
      return 0;
    }
    if (paramETEngine.native_textLayoutHasPreLine(l) == true)
    {
      localObject = new fh("");
      ((fh)localObject).d(this.e);
      ((fh)localObject).e(0);
      ((fh)localObject).a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      this.g = 0;
      this.e += 1;
    }
    Object localObject = new fh[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new fh("");
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      int k = paramETEngine.native_textLayoutLineRangeFrom(l, i);
      int m = paramETEngine.native_textLayoutLineRangeTo(l, i);
      int n = paramETEngine.native_textLayoutLineWidth(l, i);
      int i1 = paramETEngine.native_textLayoutLineHeight(l, i);
      localObject[i].a(paramString.substring(k, m));
      localObject[i].b(n);
      localObject[i].c(i1);
      localObject[i].d(this.e + i);
      localObject[i].e(0);
      localObject[i].a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject[i]);
      i += 1;
    }
    if (paramString.substring(paramString.length() - 1).equals("\n"))
    {
      paramString = new fh("");
      paramString.d(this.e + j);
      paramString.e(0);
      paramString.a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      this.g = 0;
      i = j + 1;
    }
    for (;;)
    {
      this.e += i - 1;
      paramETEngine.native_textLayoutUnlock(l);
      return i;
      if (j == 1)
      {
        this.g += localObject[0].c();
        i = j;
      }
      else
      {
        this.g = localObject[(j - 1)].c();
        i = j;
      }
    }
  }
  
  private void a(CharacterStyle paramCharacterStyle, int paramInt)
  {
    if (paramCharacterStyle == null) {
      return;
    }
    int i;
    if ((paramCharacterStyle instanceof bain)) {
      i = ((bain)paramCharacterStyle).a().getBounds().width();
    }
    for (;;)
    {
      label26:
      if (this.jdField_b_of_type_Boolean == true) {
        if (this.g != 0)
        {
          this.g = i;
          this.e += 1;
        }
      }
      for (;;)
      {
        paramCharacterStyle = new fh(paramCharacterStyle, paramInt);
        paramCharacterStyle.d(this.e);
        paramCharacterStyle.a(this);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharacterStyle);
        if ((this.jdField_b_of_type_Boolean != true) || (this.g == 0)) {
          break;
        }
        this.g = 0;
        this.e += 1;
        return;
        if (!(paramCharacterStyle instanceof axye)) {
          break label196;
        }
        i = ((axye)paramCharacterStyle).a();
        break label26;
        if (this.g == 0)
        {
          this.g = i;
        }
        else if (this.f < this.g + i)
        {
          this.g = i;
          this.e += 1;
        }
        else
        {
          this.g = (i + this.g);
        }
      }
      label196:
      i = 0;
    }
  }
  
  private void a(ETEngine paramETEngine)
  {
    int k = -1;
    int n = this.jdField_a_of_type_JavaLangString.length();
    int j = 0;
    if (j < n)
    {
      int m;
      int i;
      if ((Character.isHighSurrogate(this.jdField_a_of_type_JavaLangString.charAt(j))) && (j + 1 < n) && (Character.isLowSurrogate(this.jdField_a_of_type_JavaLangString.charAt(j + 1))))
      {
        a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(k + 1, j));
        a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(j, j + 2));
        m = j + 1;
        i = m;
      }
      for (;;)
      {
        j = m + 1;
        k = i;
        break;
        m = j;
        i = k;
        if (j + 1 == n)
        {
          a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(k + 1, n));
          i = n;
          m = j;
        }
      }
    }
  }
  
  private void a(ETEngine paramETEngine, String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i = paramETEngine.sysMeasureText(paramString, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize(), 0, 0, 0, 0, 0, 0, 0);
    int j = paramETEngine.sysFontHeight(paramString, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize(), 0, 0, 0, 0, 0, 0, 0);
    if (this.f < this.g + i)
    {
      this.g = i;
      this.e += 1;
    }
    for (;;)
    {
      paramETEngine = new fh(paramString);
      paramETEngine.b(i);
      paramETEngine.c(j);
      paramETEngine.d(this.e);
      paramETEngine.e(1);
      paramETEngine.a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramETEngine);
      return;
      this.g += i;
    }
  }
  
  private void b(ETEngine paramETEngine)
  {
    int m = -1;
    int n = this.jdField_a_of_type_JavaLangString.length();
    int i = 0;
    if (i < n)
    {
      char c1 = this.jdField_a_of_type_JavaLangString.charAt(i);
      int k;
      int j;
      if ((Character.isHighSurrogate(c1)) && (i + 1 < n) && (Character.isLowSurrogate(this.jdField_a_of_type_JavaLangString.charAt(i + 1))))
      {
        a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(m + 1, i));
        a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(i, i + 2));
        k = i + 1;
        j = k;
      }
      for (;;)
      {
        i = k + 1;
        m = j;
        break;
        if (!paramETEngine.native_isPaintableChar(c1, this.jdField_a_of_type_ComEtrumpMixlayoutETFont))
        {
          a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(m + 1, i));
          a(paramETEngine, String.valueOf(c1));
          j = i;
          k = i;
        }
        else
        {
          k = i;
          j = m;
          if (i + 1 == n)
          {
            a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(m + 1, n));
            j = n;
            k = i;
          }
        }
      }
    }
  }
  
  protected int a()
  {
    return this.g;
  }
  
  public int a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.e = paramInt3;
    this.f = paramInt1;
    this.g = paramInt2;
    if (this.jdField_a_of_type_AndroidTextStyleCharacterStyle != null)
    {
      a(this.jdField_a_of_type_AndroidTextStyleCharacterStyle, this.jdField_a_of_type_Int);
      return this.e;
    }
    if ((paramETEngine == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return this.e;
    }
    if (ETEngine.getInstance().isEnableCallbackDrawing()) {
      a(paramETEngine);
    }
    for (;;)
    {
      return this.e;
      b(paramETEngine);
    }
  }
  
  public ETFont a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
  }
  
  public ArrayList<fh> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fm
 * JD-Core Version:    0.7.0.1
 */