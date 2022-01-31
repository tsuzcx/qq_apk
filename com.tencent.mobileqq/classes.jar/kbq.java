import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;

public class kbq
  extends VideoObserver
{
  public kbq(VideoInviteActivity paramVideoInviteActivity) {}
  
  protected void a()
  {
    super.a();
    this.a.h();
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_d_of_type_Int, this.a.c, this.a.jdField_e_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.A, this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.n);
    }
  }
  
  protected void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (TextUtils.equals(this.a.c, paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteActivity", 2, "onClose  wrong uin: " + this.a.c + ", " + paramString);
      }
    }
    do
    {
      return;
      super.a(paramInt, paramString);
    } while ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.d()));
    TraeHelper.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if ((this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) && ((this.a instanceof VideoInviteFull)))
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new kbr(this, paramInt));
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.c, 0);
    this.a.jdField_a_of_type_ComTencentAvVideoController.b(251);
    this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.c, paramInt);
    this.a.jdField_e_of_type_Boolean = true;
    this.a.finish();
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "onGetStrangeFace uin = " + paramString);
    }
    if ((this.a.jdField_a_of_type_AndroidWidgetImageView != null) && (this.a.jdField_d_of_type_Int == 25)) {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)) && (paramBoolean))
    {
      TraeHelper.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) && ((this.a instanceof VideoInviteFull))) {
        this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new kbs(this));
      }
    }
    else
    {
      return;
    }
    this.a.jdField_e_of_type_Boolean = paramBoolean;
    this.a.finish();
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "VideoInviteActivity onPlayAnnimate receive id:" + paramInt);
    }
    int i = VipFunCallManager.a();
    String str = VipFunCallManager.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
    File localFile = new File(str);
    int j = this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_Int;
    if ((localFile != null) && (localFile.exists()) && (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.g != 4) && ((j == 1) || (j == 0)) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = VipFunCallManager.a((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      }
      if (VipFunCallManager.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, str, i, null, paramInt, false))
      {
        this.a.b(true);
        if (ImmersiveUtils.a()) {
          ImmersiveUtils.a(VideoInviteActivity.a(this.a), false);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "VideoInviteFull onPlayAnnimate finish id:" + paramInt);
    }
  }
  
  protected void d(String paramString)
  {
    super.d(paramString);
    if (this.a.jdField_d_of_type_Int == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteActivity", 2, "VideoInviteActivity onGetQCallNickName nickName:" + paramString);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.a.jdField_d_of_type_JavaLangString = paramString;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_d_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbq
 * JD-Core Version:    0.7.0.1
 */