import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.mobileqq.app.QQAppInterface;

public class rxw
  extends rxu
{
  private rxx a;
  
  public rxw(rwy paramrwy, rxx paramrxx)
  {
    super(paramrwy, paramrxx);
    this.a = paramrxx;
    paramrwy = ryx.b(rwy.a(paramrwy));
    if (paramrwy[1] / paramrwy[0] >= 1.97D)
    {
      paramrxx.d = paramrxx.s.getLayoutParams().height;
      paramrxx.s.setBackgroundDrawable(null);
    }
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843083;
    }
    return 2130843085;
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    rxx.a(this.a).setHeadImgByUin(rwy.a(this.d).getLongAccountUin());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.a.a.q) {
        this.a.k.setVisibility(0);
      }
      rxx.a(this.a).setVisibility(0);
      return;
    }
    this.a.k.setVisibility(8);
    rxx.a(this.a).setVisibility(8);
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    ryx.b(this.a.A, paramVideoInfo.e, "评论");
    this.a.m.setImageResource(2130843082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxw
 * JD-Core Version:    0.7.0.1
 */