import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.MagicPlayListener;
import java.lang.ref.WeakReference;

public class jfu
  implements Runnable
{
  public jfu(MagicfaceBaseDecoder paramMagicfaceBaseDecoder, String paramString, int paramInt) {}
  
  public void run()
  {
    MagicfaceBaseDecoder.MagicPlayListener localMagicPlayListener = (MagicfaceBaseDecoder.MagicPlayListener)this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.a.get();
    if (localMagicPlayListener != null) {
      localMagicPlayListener.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfu
 * JD-Core Version:    0.7.0.1
 */