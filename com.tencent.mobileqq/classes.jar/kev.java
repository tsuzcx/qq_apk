import android.content.res.Resources;
import com.tencent.av.AVLog;
import com.tencent.av.ui.VoiceChangeData;
import com.tencent.av.ui.VoiceChangeData.GetDrawableCallack;
import com.tencent.av.ui.VoiceChangeData.VoiceInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public class kev
  implements URLDrawable.URLDrawableListener
{
  public kev(VoiceChangeData paramVoiceChangeData, VoiceChangeData.GetDrawableCallack paramGetDrawableCallack, URLDrawable paramURLDrawable, Resources paramResources, VoiceChangeData.VoiceInfo paramVoiceInfo) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    AVLog.e(VoiceChangeData.b, "getDrawable|urldrawable load failed. url = " + this.jdField_a_of_type_ComTencentAvUiVoiceChangeData$VoiceInfo.b);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    AVLog.e(VoiceChangeData.b, "getDrawable|urldrawable load failed. url = " + this.jdField_a_of_type_ComTencentAvUiVoiceChangeData$VoiceInfo.b);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    AVLog.a(VoiceChangeData.b, "getDrawable|urldrawable load successed.");
    if (this.jdField_a_of_type_ComTencentAvUiVoiceChangeData$GetDrawableCallack != null) {
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeData$GetDrawableCallack.a(this.jdField_a_of_type_ComTencentAvUiVoiceChangeData.a(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_AndroidContentResResources));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kev
 * JD-Core Version:    0.7.0.1
 */