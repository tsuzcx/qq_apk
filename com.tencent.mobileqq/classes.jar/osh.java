import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;

final class osh
  implements aqfy
{
  osh(WeakReference paramWeakReference, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (osg.a() == paramInt1)
    {
      aqgm.a().a(paramInt1);
      osg.a(-1);
      if ((2 != paramInt2) && (1 != paramInt2)) {
        break label124;
      }
    }
    label124:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      Object localObject = localContext;
      if (localContext == null) {
        localObject = BaseApplicationImpl.getContext();
      }
      if ((-1 == paramInt2) && (this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (localObject != null)) {
        pqx.b((Context)localObject, this.jdField_a_of_type_JavaLangString);
      }
      localObject = this.b;
      if (this.jdField_a_of_type_Boolean) {}
      for (paramInt2 = i;; paramInt2 = 0)
      {
        pqb.a((String)localObject, paramInt1, paramInt2);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osh
 * JD-Core Version:    0.7.0.1
 */