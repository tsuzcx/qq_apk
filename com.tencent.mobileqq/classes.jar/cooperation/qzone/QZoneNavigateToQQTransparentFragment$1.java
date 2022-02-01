package cooperation.qzone;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.ISendMsgInterface;
import com.tencent.qphone.base.util.QLog;

class QZoneNavigateToQQTransparentFragment$1
  implements ExtendFriendSendMsgHelper.ISendMsgInterface
{
  QZoneNavigateToQQTransparentFragment$1(QZoneNavigateToQQTransparentFragment paramQZoneNavigateToQQTransparentFragment, FragmentActivity paramFragmentActivity) {}
  
  public void enterAio(String paramString1, String paramString2)
  {
    QZoneNavigateToQQTransparentFragment.enterAio(this.val$activity, paramString1, paramString2);
  }
  
  public void showCampusVerifyDialog(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    QZoneNavigateToQQTransparentFragment.showCampusVerifyDialog(this.val$activity, paramBoolean, paramInt, paramString1, paramString2);
  }
  
  public void showMatchCountDialog()
  {
    QZoneNavigateToQQTransparentFragment.access$000(this.val$activity);
  }
  
  public void showToast(int paramInt)
  {
    if (this.val$activity == null)
    {
      QLog.d("QZoneNavigateToQQTransparentFragment", 1, "sendMsgDirectly()-> showToast() activity is null just return");
      return;
    }
    QZoneNavigateToQQTransparentFragment.access$100(this.val$activity, this.val$activity.getString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneNavigateToQQTransparentFragment.1
 * JD-Core Version:    0.7.0.1
 */