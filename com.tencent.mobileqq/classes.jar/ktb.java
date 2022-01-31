import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout.OnDraggingListener;
import com.tencent.mobileqq.util.DisplayUtil;

public class ktb
  implements DragFrameLayout.OnDraggingListener
{
  public ktb(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 - paramInt3 > DisplayUtil.a(this.a, 60.0F))
    {
      PublicAccountAdvertisementActivity.a(this.a);
      PublicAccountAdvertisementActivity.b(this.a);
      this.a.finish();
      return;
    }
    PublicAccountAdvertisementActivity.a(this.a).a();
  }
  
  public boolean a()
  {
    return (!PublicAccountAdvertisementActivity.a(this.a)) && (!PublicAccountAdvertisementActivity.b(this.a)) && (PublicAccountAdvertisementActivity.c(this.a));
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ktb
 * JD-Core Version:    0.7.0.1
 */