import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class rod
  extends rny
  implements rog
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString = "ReadInjoyPlayer<" + Integer.toHexString(hashCode()) + ">";
  public rof a;
  private String b;
  private String c;
  
  public rod(int paramInt)
  {
    super(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_Rof = new rof(paramInt, this);
    a(this.jdField_a_of_type_Rof);
  }
  
  private void a(String paramString, long paramLong)
  {
    if (paramString == null) {
      return;
    }
    a(paramString, 2, paramLong);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, 2, paramLong, paramInt);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(this.b);
    boolean bool2 = TextUtils.isEmpty(this.c);
    int i;
    int j;
    if ((!bool1) || (!bool2))
    {
      i = 1;
      if ((!bool1) && (!this.b.equals(paramString1))) {
        break label89;
      }
      j = 1;
      label49:
      if ((!bool2) && (!this.c.equals(paramString2))) {
        break label95;
      }
    }
    label89:
    label95:
    for (int k = 1;; k = 0)
    {
      if ((i == 0) || (j == 0) || (k == 0)) {
        break label101;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label49;
    }
    label101:
    return false;
  }
  
  private void b(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    osf.a().a(paramString, "PubAccountArticleCenter.GetUrlByVid", new roe(this, paramString, paramLong, paramInt));
  }
  
  private void c(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    a(paramString, paramString, 2, paramLong, paramInt);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByBusiType: vid=" + paramString1 + ", url=" + paramString2 + ", busiType=" + paramInt1);
    }
    if (rnw.a(paramInt1))
    {
      a(paramString1, paramLong);
      return;
    }
    if ((paramInt1 == 2) || ((paramInt1 == 6) && (!TextUtils.isEmpty(paramString1))))
    {
      b(paramString1, paramLong, paramInt2);
      return;
    }
    if (paramInt1 == 5)
    {
      c(paramString1, paramLong, paramInt2);
      return;
    }
    a(paramString2, paramLong, paramInt2);
  }
  
  public void a(qlq paramqlq)
  {
    paramqlq.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramqlq.i = b();
    paramqlq.j = c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rod
 * JD-Core Version:    0.7.0.1
 */