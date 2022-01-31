import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.utils.SparkDot;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class jle
  extends VideoObserver
{
  public jle(GuildMultiActivity paramGuildMultiActivity) {}
  
  protected void a()
  {
    GuildMultiActivity.a(this.a, false);
    super.a();
  }
  
  protected void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(38, paramInt);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUtilsSparkDot != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUtilsSparkDot.setVisibility(0);
      if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramInt != 0)) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 3000L);
      }
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.e(GuildMultiActivity.jdField_a_of_type_JavaLangString, 2, "onGetStrangeFace");
    }
    this.a.runOnUiThread(new jlh(this));
  }
  
  protected void c(int paramInt)
  {
    Object localObject;
    if (paramInt == 3)
    {
      localObject = this.a.getResources().getString(2131429205);
      String str = this.a.getResources().getString(2131429207);
      localObject = DialogUtil.a(this.a, 230).setMessage((CharSequence)localObject).setTitle(str).setNegativeButton(2131433029, new jlg(this));
      if (!UITools.a(this.a)) {
        break label93;
      }
    }
    label93:
    for (paramInt = 2131429208;; paramInt = 2131429209)
    {
      ((QQCustomDialog)localObject).setPositiveButton(paramInt, new jlf(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jle
 * JD-Core Version:    0.7.0.1
 */