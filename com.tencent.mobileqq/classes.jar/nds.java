import com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

public class nds
  implements URLDrawable.URLDrawableListener
{
  public nds(GuessSongStageView paramGuessSongStageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("GuessSongStageView", 2, "onLoadFialed " + paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d("GuessSongStageView", 2, "onLoadSuccessed ");
    if ((paramURLDrawable != null) && (paramURLDrawable.getCurrDrawable() != null) && (this.a.a != null) && (this.a.a.getImageAsset("image_6") != null))
    {
      paramURLDrawable = GuessSongStageView.a(this.a, paramURLDrawable, 280, 280);
      this.a.a.updateBitmap("image_6", paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nds
 * JD-Core Version:    0.7.0.1
 */