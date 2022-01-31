import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.MagicPlayListener;
import java.lang.ref.WeakReference;

public class jgl
  implements Runnable
{
  public jgl(MagicfaceBaseDecoder paramMagicfaceBaseDecoder, String paramString) {}
  
  public void run()
  {
    MagicfaceBaseDecoder.MagicPlayListener localMagicPlayListener = (MagicfaceBaseDecoder.MagicPlayListener)this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.a.get();
    if (localMagicPlayListener != null) {
      localMagicPlayListener.b(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jgl
 * JD-Core Version:    0.7.0.1
 */