import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRedPacketShareController.2;

public class sbv
  implements PopupWindow.OnDismissListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private rar jdField_a_of_type_Rar;
  private sbx jdField_a_of_type_Sbx;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  
  public sbv(Context paramContext, boolean paramBoolean, View paramView1, View paramView2, sbx paramsbx)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_Sbx = paramsbx;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_AndroidViewView = paramView2;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Rar = new rar(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Rar.setOnDismissListener(this);
    this.jdField_a_of_type_Rar.b();
    this.jdField_a_of_type_Rar.a(RIJRedPacketManager.a().a());
    this.jdField_a_of_type_Rar.a(RIJRedPacketManager.a().e());
    this.jdField_a_of_type_Rar.b(3);
    if (this.jdField_a_of_type_AndroidViewView.getWidth() > 0)
    {
      this.jdField_a_of_type_Rar.showAsDropDown(this.jdField_a_of_type_AndroidViewView, -bgtn.a(6.0F), -bgtn.a(10.0F));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.post(new VideoFeedsRedPacketShareController.2(this));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    int j = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    int i;
    if ((a(paramVideoInfo)) && (bmqa.n()))
    {
      i = 1;
      if ((this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) || (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0)) {
        break label86;
      }
      label43:
      if ((paramVideoInfo.c) || (i == 0) || (TextUtils.isEmpty(paramVideoInfo.w)) || (j == 0)) {
        break label91;
      }
      bmqa.e();
      a();
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    }
    label86:
    label91:
    while (this.jdField_a_of_type_Rar == null)
    {
      return;
      i = 0;
      break;
      j = 0;
      break label43;
    }
    this.jdField_a_of_type_Rar.dismiss();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Rar != null) && (this.jdField_a_of_type_Rar.isShowing());
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
      if ((paramVideoInfo == null) || (paramVideoInfo.g == null) || (!TextUtils.isEmpty(paramVideoInfo.w))) {
        j = 1;
      }
      if ((j == 0) && (!paramVideoInfo.c) && (i != 0)) {
        break;
      }
      return;
    }
    RIJRedPacketManager.a().a(paramVideoInfo.g, new sbw(this, paramVideoInfo));
  }
  
  public void onDismiss()
  {
    if ((this.jdField_a_of_type_Sbx != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      this.jdField_a_of_type_Sbx.b(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbv
 * JD-Core Version:    0.7.0.1
 */