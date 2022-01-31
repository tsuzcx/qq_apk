import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class ott
  implements Runnable
{
  public ott(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int i = 0;
    int k = (int)(20.0F * QRDisplayActivity.a(this.a));
    int j = this.a.jdField_c_of_type_AndroidViewView.getWidth() - k * 2;
    k = this.a.jdField_c_of_type_AndroidViewView.getHeight() - k * 2;
    if ((j >= 540) && (k >= 740))
    {
      this.a.jdField_d_of_type_Int = 540;
      this.a.jdField_e_of_type_Int = 740;
      if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        ThreadManager.post(new otu(this), 8, null, false);
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle == null)
      {
        this.a.jdField_a_of_type_AndroidOsBundle = new Bundle();
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("bkgRes", 0);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("nameClr", -16777216);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("tipsClr", -8947849);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("B", -16777216);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("W", 16777215);
        this.a.jdField_a_of_type_AndroidOsBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("head", 1);
      }
      if (this.a.jdField_c_of_type_Int == 5) {
        break label606;
      }
      if (this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix == null) {
        this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = this.a.a(this.a.jdField_c_of_type_JavaLangString, this.a.jdField_c_of_type_Int, -1);
      }
      if (this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix == null) {
        break label491;
      }
      this.a.f();
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidViewView.post(this.a.jdField_b_of_type_JavaLangRunnable);
      return;
      if (j * 740 < k * 540) {
        this.a.jdField_d_of_type_Int = j;
      }
      for (this.a.jdField_e_of_type_Int = ((int)(j / 540.0D * 740.0D));; this.a.jdField_e_of_type_Int = k)
      {
        localObject1 = this.a.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.a.jdField_d_of_type_Int;
        ((ViewGroup.LayoutParams)localObject1).height = this.a.jdField_e_of_type_Int;
        this.a.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = this.a.jdField_d_of_type_AndroidViewView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.a.jdField_d_of_type_Int;
        ((ViewGroup.LayoutParams)localObject1).height = this.a.jdField_e_of_type_Int;
        this.a.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
        this.a.jdField_d_of_type_Int = ((int)(k / 740.0D * 540.0D));
      }
      label491:
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
      }
      Object localObject2 = (TicketManager)this.a.app.getManager(2);
      Object localObject1 = this.a.app.getAccount();
      localObject2 = ((TicketManager)localObject2).getSkey((String)localObject1);
      Intent localIntent = this.a.getIntent();
      String str = localIntent.getStringExtra("uin");
      i = localIntent.getIntExtra("type", 1);
      QRUtils.a(this.a.app, this.a, str, i, (String)localObject1, (String)localObject2, new otv(this, str, i));
      continue;
      label606:
      localObject1 = this.a.getSharedPreferences("qrcode", 0);
      this.a.jdField_b_of_type_Long = ((SharedPreferences)localObject1).getLong("discussionvalidtime" + this.a.jdField_c_of_type_JavaLangString, 0L);
      this.a.jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("discussion" + this.a.jdField_c_of_type_JavaLangString, null);
      this.a.jdField_e_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("discussionfullSig" + this.a.jdField_c_of_type_JavaLangString, null);
      if (this.a.jdField_b_of_type_Long - System.currentTimeMillis() / 1000L > 0L) {
        i = 1;
      }
      this.a.findViewById(2131367559).setOnClickListener(this.a);
      if ((this.a.jdField_d_of_type_JavaLangString == null) || (this.a.jdField_e_of_type_JavaLangString == null) || (i == 0)) {
        break label851;
      }
      ((TextView)this.a.findViewById(2131367558)).setText(this.a.jdField_d_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = QRUtils.a(this.a.jdField_d_of_type_JavaLangString, -1);
      this.a.f();
    }
    label851:
    if (QLog.isDevelopLevel()) {
      QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.a.jdField_c_of_type_JavaLangString), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ott
 * JD-Core Version:    0.7.0.1
 */