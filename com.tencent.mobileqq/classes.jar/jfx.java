import com.tencent.av.AVLog;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.MagicPlayListener;
import com.tencent.av.business.manager.magicface.MagicfacePlayer;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;

public class jfx
  implements MagicfaceBaseDecoder.MagicPlayListener
{
  public jfx(MagicfacePlayer paramMagicfacePlayer) {}
  
  public void a(String paramString)
  {
    AVLog.c("AVMagicfacePlayer", "play video begin." + paramString);
    if (this.a.jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener != null) {
      this.a.jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener.a(paramString);
    }
  }
  
  public void a(String arg1, int paramInt)
  {
    AVLog.c("AVMagicfacePlayer", "play video end." + ??? + "|" + paramInt);
    if (this.a.jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener != null) {
      this.a.jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener.a(???, paramInt);
    }
    if (MagicfacePlayer.a(this.a) != null)
    {
      MagicfacePlayer.a(this.a).a();
      MagicfacePlayer.a(this.a, null);
    }
    synchronized (this.a)
    {
      if ((this.a.jdField_b_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData != null)) {
        this.a.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData, this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener, this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener);
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    AVLog.c("AVMagicfacePlayer", "play audio end.");
    this.a.a(this.a.jdField_a_of_type_JavaLangString);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    AVLog.c("AVMagicfacePlayer", "play audio begin.");
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString, 100);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfx
 * JD-Core Version:    0.7.0.1
 */