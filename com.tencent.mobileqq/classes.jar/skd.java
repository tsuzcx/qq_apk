import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.LikeAnimationInfo;
import com.tencent.mobileqq.app.BusinessObserver;

public class skd
  implements BusinessObserver
{
  public skd(skc paramskc) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Bundle))) {}
    while (!paramBoolean) {
      return;
    }
    paramObject = (Bundle)paramObject;
    skc.a(this.a, (LikeAnimationInfo)paramObject.getParcelable("key_like_animation_info"));
    bmhv.a();
    bmhv.a(skc.a(this.a));
    skc.a(this.a, skc.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skd
 * JD-Core Version:    0.7.0.1
 */