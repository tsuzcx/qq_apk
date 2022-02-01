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
import com.tencent.mobileqq.util.DisplayUtil;
import org.jetbrains.annotations.Nullable;

public class rvt
  extends rvr
  implements scn
{
  private rvu a;
  
  public rvt(ruw paramruw, rvu paramrvu)
  {
    super(paramruw, paramrvu);
    this.a = paramrvu;
    paramruw = rwv.b(ruw.a(paramruw));
    if (paramruw[1] / paramruw[0] >= 1.97D)
    {
      paramrvu.d = paramrvu.s.getLayoutParams().height;
      paramrvu.s.setBackgroundDrawable(null);
    }
    paramrvu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout.a(this);
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.q) {
      paramVideoInfo.a = VideoFeedsStressFollowLayout.StressState.Shrink;
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout.setVideoInfo(paramVideoInfo);
    this.a.jdField_a_of_type_Scd.a(paramVideoInfo.a);
  }
  
  protected int a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.o) {
      return 2130843161;
    }
    return 2130843163;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843159;
    }
    return 2130843162;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    super.a(paramVideoInfo);
    e(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    rvu.a(this.a).setHeadImgByUin(ruw.a(this.d).getLongAccountUin());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.q) {
        this.a.j.setVisibility(0);
      }
      rvu.a(this.a).setVisibility(0);
      return;
    }
    this.a.j.setVisibility(8);
    rvu.a(this.a).setVisibility(8);
  }
  
  protected void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    e(paramVideoInfo);
    if (paramVideoInfo.a == VideoFeedsStressFollowLayout.StressState.Stretched)
    {
      if (this.a.jdField_a_of_type_Rsm == null) {
        return;
      }
      this.a.jdField_a_of_type_Rsm.a().setVisibility(8);
      return;
    }
    super.b(paramVideoInfo, paramBoolean);
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    rwv.b(this.a.A, paramVideoInfo.e, "评论");
    this.a.m.setImageResource(2130843158);
  }
  
  public void d(@Nullable VideoInfo paramVideoInfo)
  {
    long l2 = -1L;
    sdj localsdj;
    if (paramVideoInfo != null)
    {
      ruw.a(this.d, paramVideoInfo.j, paramVideoInfo.b, paramVideoInfo.p);
      if (this.a.jdField_a_of_type_Ryo == null) {
        break label129;
      }
      localsdj = this.a.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj;
      paramVideoInfo = new sie(paramVideoInfo);
      if (localsdj == null) {
        break label135;
      }
    }
    label129:
    label135:
    for (long l1 = localsdj.a();; l1 = -1L)
    {
      paramVideoInfo = paramVideoInfo.a(l1);
      l1 = l2;
      if (localsdj != null) {
        l1 = localsdj.b();
      }
      odq.a(null, "", "0X80078FD", "0X80078FD", 0, 0, "3", "", "", paramVideoInfo.c(l1).ad(1).M(0).a().a(), false);
      return;
      localsdj = null;
      break;
    }
  }
  
  public void l(boolean paramBoolean)
  {
    super.l(paramBoolean);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.f.getLayoutParams();
    if (paramBoolean) {}
    for (int i = DisplayUtil.dip2px(ruw.a(this.d), 86.0F);; i = DisplayUtil.dip2px(ruw.a(this.d), 5.0F))
    {
      localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, i, localMarginLayoutParams.bottomMargin);
      this.a.f.setLayoutParams(localMarginLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvt
 * JD-Core Version:    0.7.0.1
 */