import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class pxm
  implements pxo<BEAN, COOKIE>
{
  pxm(pxj parampxj, pxi parampxi) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Pxj.a.addAll(paramArrayList);
    if (paramBoolean1)
    {
      pxj.a(this.jdField_a_of_type_Pxj, paramCOOKIE);
      paramArrayList = this.jdField_a_of_type_Pxj;
      if (paramBoolean2) {
        break label68;
      }
    }
    label68:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      pxj.a(paramArrayList, paramBoolean2);
      this.jdField_a_of_type_Pxi.a(paramBoolean1, this.jdField_a_of_type_Pxj.a, paramInt2, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxm
 * JD-Core Version:    0.7.0.1
 */