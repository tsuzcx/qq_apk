import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRedPacketShareController.2;

public class rgx
  implements PopupWindow.OnDismissListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private qhj jdField_a_of_type_Qhj;
  private rcn jdField_a_of_type_Rcn;
  private rgz jdField_a_of_type_Rgz;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  
  public rgx(Context paramContext, boolean paramBoolean, View paramView1, View paramView2, rgz paramrgz)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_Rgz = paramrgz;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_AndroidViewView = paramView2;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Qhj = new qhj(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Qhj.setOnDismissListener(this);
    this.jdField_a_of_type_Qhj.b();
    this.jdField_a_of_type_Qhj.a(RIJRedPacketManager.a().a());
    this.jdField_a_of_type_Qhj.a(RIJRedPacketManager.a().e());
    this.jdField_a_of_type_Qhj.b(3);
    if (this.jdField_a_of_type_AndroidViewView.getWidth() > 0)
    {
      this.jdField_a_of_type_Qhj.showAsDropDown(this.jdField_a_of_type_AndroidViewView, -bdoo.a(6.0F), -bdoo.a(10.0F));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.post(new VideoFeedsRedPacketShareController.2(this));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    int k = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    int i;
    int j;
    if ((a(paramVideoInfo)) && (bkbq.o()))
    {
      i = 1;
      if ((this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) || (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0)) {
        break label111;
      }
      j = 1;
      label46:
      if ((this.jdField_a_of_type_Rcn == null) || (!this.jdField_a_of_type_Rcn.a())) {
        break label116;
      }
      label63:
      if ((paramVideoInfo.c) || (i == 0) || (TextUtils.isEmpty(paramVideoInfo.u)) || (k != 0) || (j == 0)) {
        break label122;
      }
      bkbq.e();
      a();
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    }
    label111:
    label116:
    label122:
    while (this.jdField_a_of_type_Qhj == null)
    {
      return;
      i = 0;
      break;
      j = 0;
      break label46;
      k = 0;
      break label63;
    }
    this.jdField_a_of_type_Qhj.dismiss();
  }
  
  public void a(rcn paramrcn)
  {
    this.jdField_a_of_type_Rcn = paramrcn;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Qhj != null) && (this.jdField_a_of_type_Qhj.isShowing());
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return (RIJRedPacketManager.a().c()) && (RIJRedPacketManager.a().e()) && (paramVideoInfo.k) && (this.jdField_a_of_type_Boolean);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    int j = 0;
    if ((RIJRedPacketManager.a().c()) && (RIJRedPacketManager.a().e()) && (this.jdField_a_of_type_Boolean)) {}
    for (int i = 1;; i = 0)
    {
      if ((paramVideoInfo == null) || (paramVideoInfo.g == null) || (!TextUtils.isEmpty(paramVideoInfo.u))) {
        j = 1;
      }
      if ((j == 0) && (!paramVideoInfo.c) && (i != 0)) {
        break;
      }
      return;
    }
    RIJRedPacketManager.a().a(paramVideoInfo.g, new rgy(this, paramVideoInfo));
  }
  
  public void onDismiss()
  {
    if ((this.jdField_a_of_type_Rgz != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      this.jdField_a_of_type_Rgz.b(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rgx
 * JD-Core Version:    0.7.0.1
 */