import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.qqstory.takevideo.dancemachine.VideoSharer;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class oic
  implements WXShareHelper.WXShareListener
{
  oic(oia paramoia, Bitmap paramBitmap) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share]  shareToWechat errorCode : " + paramBaseResp.errCode + "   errorStr : " + paramBaseResp.errCode + "  transaction : " + paramBaseResp.transaction + "  openId : " + paramBaseResp.openId + " type : " + paramBaseResp.getType());
    }
    if ((paramBaseResp.errCode != 0) && (paramBaseResp.errCode != -2)) {
      this.jdField_a_of_type_Oia.a.a.runOnUiThread(new oid(this));
    }
    if (paramBaseResp.errCode == 0)
    {
      if (VideoSharer.a(this.jdField_a_of_type_Oia.a) != 2) {
        break label180;
      }
      CaptureReportUtil.a("wechat_moments", VideoSharer.a(this.jdField_a_of_type_Oia.a));
    }
    label180:
    while (VideoSharer.a(this.jdField_a_of_type_Oia.a) != 1) {
      return;
    }
    CaptureReportUtil.a("wechat_friends", VideoSharer.a(this.jdField_a_of_type_Oia.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oic
 * JD-Core Version:    0.7.0.1
 */