import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.MagicPlayListener;
import java.lang.ref.WeakReference;

public class jhw
  implements Runnable
{
  public jhw(MagicfaceBaseDecoder paramMagicfaceBaseDecoder, String paramString) {}
  
  public void run()
  {
    MagicfaceBaseDecoder.MagicPlayListener localMagicPlayListener = (MagicfaceBaseDecoder.MagicPlayListener)this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.a.get();
    if (localMagicPlayListener != null) {
      localMagicPlayListener.a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jhw
 * JD-Core Version:    0.7.0.1
 */