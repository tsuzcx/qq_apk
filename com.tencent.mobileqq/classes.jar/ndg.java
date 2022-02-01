import com.tencent.avgame.gameroom.stage.StageView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

public class ndg
  implements nbb
{
  public ndg(StageView paramStageView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StageView", 2, "onLoad " + paramLottieDrawable);
    }
    if (paramLottieDrawable != null)
    {
      this.a.b = paramLottieDrawable;
      this.a.b.addAnimatorListener(new ndh(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndg
 * JD-Core Version:    0.7.0.1
 */