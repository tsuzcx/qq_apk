import com.tencent.avgame.gameroom.stage.StageView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

public class ndf
  implements nbb
{
  public ndf(StageView paramStageView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StageView", 2, "COUNT_DOWN_5S_JSON onLoad lottieDrawable = " + paramLottieDrawable);
    }
    if (paramLottieDrawable != null)
    {
      this.a.a = paramLottieDrawable;
      StageView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndf
 * JD-Core Version:    0.7.0.1
 */