import android.graphics.drawable.BitmapDrawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class miu
  extends AnimateUtils.AnimationAdapter
{
  miu(mit parammit) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadinjoyTabFrame.a(this.a.a.a.a.a, true);
    if ((ReadinjoyTabFrame.b(this.a.a.a.a.a).getDrawable() instanceof BitmapDrawable)) {
      ReadinjoyTabFrame.a(this.a.a.a.a.a).setImageBitmap(((BitmapDrawable)ReadinjoyTabFrame.b(this.a.a.a.a.a).getDrawable()).getBitmap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     miu
 * JD-Core Version:    0.7.0.1
 */