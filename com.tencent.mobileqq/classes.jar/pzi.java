import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class pzi
  implements pzk<BEAN, COOKIE>
{
  pzi(pzf parampzf, pze parampze) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Pzf.a.addAll(paramArrayList);
    if (paramBoolean1)
    {
      pzf.a(this.jdField_a_of_type_Pzf, paramCOOKIE);
      paramArrayList = this.jdField_a_of_type_Pzf;
      if (paramBoolean2) {
        break label68;
      }
    }
    label68:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      pzf.a(paramArrayList, paramBoolean2);
      this.jdField_a_of_type_Pze.a(paramBoolean1, this.jdField_a_of_type_Pzf.a, paramInt2, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzi
 * JD-Core Version:    0.7.0.1
 */