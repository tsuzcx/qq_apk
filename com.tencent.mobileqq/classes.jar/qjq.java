import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class qjq
  implements qjs<BEAN, COOKIE>
{
  qjq(qjn paramqjn, qjm paramqjm) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Qjn.a.addAll(paramArrayList);
    if (paramBoolean1)
    {
      qjn.a(this.jdField_a_of_type_Qjn, paramCOOKIE);
      paramArrayList = this.jdField_a_of_type_Qjn;
      if (paramBoolean2) {
        break label68;
      }
    }
    label68:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      qjn.a(paramArrayList, paramBoolean2);
      this.jdField_a_of_type_Qjm.a(paramBoolean1, this.jdField_a_of_type_Qjn.a, paramInt2, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjq
 * JD-Core Version:    0.7.0.1
 */