import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class phx
  implements phy<BEAN, COOKIE>
{
  phx(phu paramphu, pht parampht) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Phu.a.addAll(paramArrayList);
    if (paramBoolean1)
    {
      phu.a(this.jdField_a_of_type_Phu, paramCOOKIE);
      paramArrayList = this.jdField_a_of_type_Phu;
      if (paramBoolean2) {
        break label68;
      }
    }
    label68:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      phu.a(paramArrayList, paramBoolean2);
      this.jdField_a_of_type_Pht.a(paramBoolean1, this.jdField_a_of_type_Phu.a, paramInt2, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     phx
 * JD-Core Version:    0.7.0.1
 */