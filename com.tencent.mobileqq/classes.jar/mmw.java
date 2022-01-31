import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;

public class mmw
  extends lij
{
  public mmw(VideoInviteActivity paramVideoInviteActivity) {}
  
  protected void a()
  {
    super.a();
    this.a.h();
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_e_of_type_Int, this.a.c, this.a.jdField_e_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.a.jdField_a_of_type_Lid.z, this.a.jdField_a_of_type_Lid.p);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    if (TextUtils.equals(this.a.c, paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onClose  wrong uin: " + this.a.c + ", " + paramString);
      }
    }
    while (this.a.jdField_a_of_type_Lid.i()) {
      return;
    }
    mwk.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if ((this.a.l) && (this.a.jdField_a_of_type_Mkb != null) && (!this.a.f()))
    {
      this.a.jdField_a_of_type_Mkb.a(new mmx(this, paramInt));
      return;
    }
    this.a.a().a(this.a.c, 251);
    this.a.a().b(251);
    this.a.a().b(this.a.c, paramInt);
    this.a.jdField_e_of_type_Boolean = true;
    QLog.d(this.a.jdField_a_of_type_JavaLangString, 1, "onClose()-> else ->finish  ");
    this.a.finish();
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onGetStrangeFace uin = " + paramString);
    }
    if ((this.a.jdField_a_of_type_AndroidWidgetImageView != null) && (this.a.jdField_e_of_type_Int == 25)) {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((this.a.c != null) && (this.a.c.equals(paramString)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(this.a.jdField_a_of_type_JavaLangString, 4, "onDestroyUI, peer[" + paramString + "], isQuit[" + paramBoolean + "]");
      }
      if (paramBoolean)
      {
        mwk.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((!this.a.l) || (this.a.jdField_a_of_type_Mkb == null) || (this.a.f())) {
          break label187;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i(this.a.jdField_a_of_type_JavaLangString, 4, "onDestroyUI, outAnim, peer[" + paramString + "], isQuit[" + paramBoolean + "]");
        }
        this.a.jdField_a_of_type_Mkb.a(new mmy(this));
      }
    }
    return;
    label187:
    if (QLog.isDevelopLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 4, "onDestroyUI, noAnim, peer[" + paramString + "], isQuit[" + paramBoolean + "]");
    }
    this.a.jdField_e_of_type_Boolean = paramBoolean;
    this.a.finish();
  }
  
  protected void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected void c(int paramInt)
  {
    QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onPlayAnnimate, id[" + paramInt + "], mFunCallId[" + this.a.j + "]");
    if (paramInt != this.a.j) {}
    do
    {
      return;
      int i = becr.a();
      String str = becr.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
      File localFile = new File(str);
      int j = this.a.jdField_a_of_type_Lid.d;
      if ((localFile != null) && (localFile.exists()) && (this.a.jdField_a_of_type_Lid.g != 4) && ((j == 1) || (j == 0)) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = becr.a((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
        }
        if (becr.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, str, i, null, paramInt, false))
        {
          this.a.a(true);
          ImmersiveUtils.a(false, this.a.getWindow());
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "VideoInviteFull onPlayAnnimate finish id:" + paramInt);
  }
  
  protected void d(String paramString)
  {
    super.d(paramString);
    if (this.a.jdField_e_of_type_Int == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "VideoInviteActivity onGetQCallNickName nickName:" + paramString);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.a.d = paramString;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mmw
 * JD-Core Version:    0.7.0.1
 */