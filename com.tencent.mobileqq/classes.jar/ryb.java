import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.LikeAnimationInfo;
import com.tencent.mobileqq.app.BusinessObserver;

public class ryb
  implements BusinessObserver
{
  public ryb(rya paramrya) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Bundle))) {}
    while (!paramBoolean) {
      return;
    }
    paramObject = (Bundle)paramObject;
    rya.a(this.a, (LikeAnimationInfo)paramObject.getParcelable("key_like_animation_info"));
    bkwm.a();
    bkwm.a(rya.a(this.a));
    rya.a(this.a, rya.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryb
 * JD-Core Version:    0.7.0.1
 */