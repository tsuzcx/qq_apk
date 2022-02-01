import com.tencent.avgame.gameroom.stage.StageView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

public class nlf
  implements nhz
{
  public nlf(StageView paramStageView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StageView", 2, "onLoad " + paramLottieDrawable);
    }
    if (paramLottieDrawable != null)
    {
      this.a.b = paramLottieDrawable;
      this.a.b.addAnimatorListener(new nlg(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlf
 * JD-Core Version:    0.7.0.1
 */