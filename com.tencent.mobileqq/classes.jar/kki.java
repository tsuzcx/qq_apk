import com.tencent.av.widget.shimmer.ShimmerTextView;

public class kki
  implements Runnable
{
  public kki(ShimmerTextView paramShimmerTextView) {}
  
  public void run()
  {
    ShimmerTextView localShimmerTextView = this.a;
    localShimmerTextView.a += 1;
    if (this.a.a >= 50) {
      this.a.a = 0;
    }
    this.a.setGradientX(this.a.getWidth() * this.a.a / 50);
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kki
 * JD-Core Version:    0.7.0.1
 */