import android.graphics.drawable.BitmapDrawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class mip
  extends AnimateUtils.AnimationAdapter
{
  mip(mio parammio) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadinjoyTabFrame.a(this.a.a, true);
    if ((ReadinjoyTabFrame.b(this.a.a).getDrawable() instanceof BitmapDrawable)) {
      ReadinjoyTabFrame.a(this.a.a).setImageBitmap(((BitmapDrawable)ReadinjoyTabFrame.b(this.a.a).getDrawable()).getBitmap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mip
 * JD-Core Version:    0.7.0.1
 */