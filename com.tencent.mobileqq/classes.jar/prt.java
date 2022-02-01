import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class prt
  implements prv<BEAN, COOKIE>
{
  prt(prq paramprq, prp paramprp) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Prq.a.addAll(paramArrayList);
    if (paramBoolean1)
    {
      prq.a(this.jdField_a_of_type_Prq, paramCOOKIE);
      paramArrayList = this.jdField_a_of_type_Prq;
      if (paramBoolean2) {
        break label68;
      }
    }
    label68:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      prq.a(paramArrayList, paramBoolean2);
      this.jdField_a_of_type_Prp.a(paramBoolean1, this.jdField_a_of_type_Prq.a, paramInt2, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prt
 * JD-Core Version:    0.7.0.1
 */