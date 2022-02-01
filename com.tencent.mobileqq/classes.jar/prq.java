import android.support.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class prq<BEAN, COOKIE>
  implements prl<BEAN>
{
  protected int a;
  @Nullable
  private COOKIE jdField_a_of_type_JavaLangObject = null;
  private String jdField_a_of_type_JavaLangString = "";
  protected CopyOnWriteArrayList<BEAN> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public prq()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, List<BEAN> paramList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString, prk<BEAN> paramprk)
  {
    this.jdField_a_of_type_Boolean = true;
    if ((paramBoolean2) && (paramInt1 >= 0)) {
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (this.jdField_b_of_type_Boolean) {
      if (paramBoolean2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(paramList);
        a(paramList);
        this.jdField_a_of_type_JavaLangObject = paramCOOKIE;
        if (!paramBoolean3)
        {
          paramBoolean1 = true;
          this.d = paramBoolean1;
        }
      }
      else
      {
        paramprk.a(paramBoolean2, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
      }
    }
    do
    {
      return;
      paramBoolean1 = false;
      break;
      if (paramBoolean2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(paramList);
        this.jdField_a_of_type_JavaLangObject = paramCOOKIE;
        if (!paramBoolean3) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          this.d = paramBoolean1;
          paramprk.a(true, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
          return;
        }
      }
      this.c = true;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_JavaLangString = paramString;
    } while (paramBoolean1);
    paramprk.a(false, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
  }
  
  public abstract void a(@Nullable COOKIE paramCOOKIE, prv<BEAN, COOKIE> paramprv);
  
  public abstract void a(List<BEAN> paramList);
  
  public void a(prp<BEAN> paramprp)
  {
    a(this.jdField_a_of_type_JavaLangObject, new prt(this, paramprp));
  }
  
  public abstract void a(pru<BEAN> parampru);
  
  public void a(boolean paramBoolean, prk<BEAN> paramprk)
  {
    a();
    if (paramBoolean) {
      a(new prr(this, paramprk));
    }
    a(null, new prs(this, paramBoolean, paramprk));
  }
  
  public boolean a()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prq
 * JD-Core Version:    0.7.0.1
 */