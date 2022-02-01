import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

public class ndo
  implements URLDrawable.URLDrawableListener
{
  public ndo(GuessPictureStageView paramGuessPictureStageView, mzp parammzp) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessPictureStageView", 2, "urlDrawable load failed and throwable" + paramThrowable);
    }
    bdll.b(null, "dc00898", "", "", "0X800B0FA", "0X800B0FA", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView.b();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessPictureStageView", 2, "urlDrawable load success");
    }
    bdll.b(null, "dc00898", "", "", "0X800B0F5", "0X800B0F5", 0, 0, "", "", "", "");
    paramURLDrawable = nic.a(paramURLDrawable.getCurrDrawable());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView.a = paramURLDrawable;
    GuessPictureStageView localGuessPictureStageView = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView;
    if (this.jdField_a_of_type_Mzp.c == 0) {}
    for (int i = 10;; i = this.jdField_a_of_type_Mzp.c)
    {
      GuessPictureStageView.a(localGuessPictureStageView, paramURLDrawable, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndo
 * JD-Core Version:    0.7.0.1
 */