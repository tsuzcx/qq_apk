import android.text.TextUtils;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.random.RandomWebProtocol.OnRequestListener;
import java.util.Iterator;
import java.util.List;

public class jld
  extends Thread
{
  public jld(RandomWebProtocol paramRandomWebProtocol, String paramString1, String paramString2) {}
  
  public void run()
  {
    jlm localjlm = new jlm(this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "null"))) {
      localjlm.a = this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.b, this.jdField_a_of_type_JavaLangString);
    }
    if (localjlm.a != null) {}
    for (int i = 0;; i = -1)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a.iterator();
      while (localIterator.hasNext()) {
        ((RandomWebProtocol.OnRequestListener)localIterator.next()).a(i, localjlm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jld
 * JD-Core Version:    0.7.0.1
 */