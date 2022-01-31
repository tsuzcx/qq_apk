import android.text.TextUtils;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.random.RandomWebProtocol.OnRequestListener;
import java.util.Iterator;
import java.util.List;

public class jmr
  extends Thread
{
  public jmr(RandomWebProtocol paramRandomWebProtocol, String paramString1, String paramString2) {}
  
  public void run()
  {
    jna localjna = new jna(this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "null"))) {
      localjna.a = this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.b, this.jdField_a_of_type_JavaLangString);
    }
    if (localjna.a != null) {}
    for (int i = 0;; i = -1)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a.iterator();
      while (localIterator.hasNext()) {
        ((RandomWebProtocol.OnRequestListener)localIterator.next()).a(i, localjna);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jmr
 * JD-Core Version:    0.7.0.1
 */