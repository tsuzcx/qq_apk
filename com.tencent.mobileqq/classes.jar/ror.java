import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout.StressState;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import org.jetbrains.annotations.Nullable;

public class ror
  extends rop
  implements rvj
{
  private ros a;
  
  public ror(rnu paramrnu, ros paramros)
  {
    super(paramrnu, paramros);
    this.a = paramros;
    paramrnu = rpt.b(rnu.a(paramrnu));
    if (paramrnu[1] / paramrnu[0] >= 1.97D)
    {
      paramros.d = paramros.s.getLayoutParams().height;
      paramros.s.setBackgroundDrawable(null);
    }
    paramros.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout.a(this);
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.n) {
      paramVideoInfo.a = VideoFeedsStressFollowLayout.StressState.Shrink;
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout.setVideoInfo(paramVideoInfo);
    this.a.jdField_a_of_type_Ruz.a(paramVideoInfo.a);
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843103;
    }
    return 2130843105;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    super.a(paramVideoInfo);
    e(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    ros.a(this.a).setHeadImgByUin(rnu.a(this.d).getLongAccountUin());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.n) {
        this.a.j.setVisibility(0);
      }
      ros.a(this.a).setVisibility(0);
      return;
    }
    this.a.j.setVisibility(8);
    ros.a(this.a).setVisibility(8);
  }
  
  protected void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    e(paramVideoInfo);
    if (paramVideoInfo.a == VideoFeedsStressFollowLayout.StressState.Stretched)
    {
      if (this.a.jdField_a_of_type_Rlm == null) {
        return;
      }
      this.a.jdField_a_of_type_Rlm.a().setVisibility(8);
      return;
    }
    super.b(paramVideoInfo, paramBoolean);
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    rpt.b(this.a.A, paramVideoInfo.e, "评论");
    this.a.m.setImageResource(2130843102);
  }
  
  public void d(@Nullable VideoInfo paramVideoInfo)
  {
    long l2 = -1L;
    rwf localrwf;
    if (paramVideoInfo != null)
    {
      rnu.a(this.d, paramVideoInfo.j, paramVideoInfo.b, paramVideoInfo.p);
      if (this.a.jdField_a_of_type_Rrm == null) {
        break label129;
      }
      localrwf = this.a.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf;
      paramVideoInfo = new sbg(paramVideoInfo);
      if (localrwf == null) {
        break label135;
      }
    }
    label129:
    label135:
    for (long l1 = localrwf.a();; l1 = -1L)
    {
      paramVideoInfo = paramVideoInfo.a(l1);
      l1 = l2;
      if (localrwf != null) {
        l1 = localrwf.b();
      }
      ocd.a(null, "", "0X80078FD", "0X80078FD", 0, 0, "3", "", "", paramVideoInfo.c(l1).ad(1).M(0).a().a(), false);
      return;
      localrwf = null;
      break;
    }
  }
  
  public void l(boolean paramBoolean)
  {
    super.l(paramBoolean);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.f.getLayoutParams();
    if (paramBoolean) {}
    for (int i = bhgr.a(rnu.a(this.d), 86.0F);; i = bhgr.a(rnu.a(this.d), 5.0F))
    {
      localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, i, localMarginLayoutParams.bottomMargin);
      this.a.f.setLayoutParams(localMarginLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ror
 * JD-Core Version:    0.7.0.1
 */