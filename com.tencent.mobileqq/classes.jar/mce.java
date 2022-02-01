import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable;
import com.tencent.av.ui.BaseInviteFloatBarUICtr.2;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.MobileQQ;

public abstract class mce
{
  public static int a;
  long jdField_a_of_type_Long = 0L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  public VideoAppInterface a;
  BaseGaInvite.GetGaFaceRunnable jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new BaseInviteFloatBarUICtr.2(this);
  public final String a;
  public lff a;
  lnf jdField_a_of_type_Lnf = new mcf(this);
  public mlb a;
  boolean jdField_a_of_type_Boolean = false;
  long[] jdField_a_of_type_ArrayOfLong = null;
  public int b;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = null;
  int c;
  public String c;
  String d = null;
  
  static
  {
    jdField_a_of_type_Int = 6000;
  }
  
  public mce()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Lff = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.b());
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy");
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable != null) {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a();
    }
    if (this.jdField_a_of_type_Mlb != null)
    {
      this.jdField_a_of_type_Mlb.a();
      this.jdField_a_of_type_Mlb = null;
    }
    b();
  }
  
  public void a(String paramString)
  {
    String str = String.valueOf(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Mlb != null) {}
    for (TextView localTextView = this.jdField_a_of_type_Mlb.a();; localTextView = null)
    {
      this.jdField_b_of_type_JavaLangString = BaseGaInvite.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localTextView, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, str, this.jdField_a_of_type_ArrayOfLong);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, str, null, true, false);
      if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable == null) {
        this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = new BaseGaInvite.GetGaFaceRunnable(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_Lnf);
      }
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a(paramString);
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshUI, isMultiCall[" + mrl.b(this.jdField_b_of_type_Int) + "], multiIncomingCall[" + paramBoolean + "], mUinType[" + this.jdField_b_of_type_Int + "], mIsAudioMode[" + this.jdField_a_of_type_Boolean + "]");
    }
    String str = this.jdField_c_of_type_JavaLangString;
    int j = this.jdField_b_of_type_Int;
    if (mrl.b(this.jdField_b_of_type_Int)) {
      a("refreshUI");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mlb == null)
      {
        this.jdField_a_of_type_Mlb = new mlb(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
        this.jdField_a_of_type_Mlb.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_JavaLangString);
        localObject = new Date();
        localObject = new SimpleDateFormat("HH:mm").format((Date)localObject);
        this.jdField_a_of_type_Mlb.b((String)localObject);
        this.jdField_a_of_type_Mlb.a(this.jdField_a_of_type_Boolean, mrl.b(this.jdField_b_of_type_Int), paramBoolean);
        if (mrl.b(this.jdField_b_of_type_Int)) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Int);
        }
      }
      Object localObject = (Vibrator)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getSystemService("vibrator");
      if (localObject != null) {
        ((Vibrator)localObject).vibrate(200L);
      }
      return;
      int i = j;
      localObject = str;
      if (this.jdField_a_of_type_Lff != null)
      {
        i = j;
        localObject = str;
        if (this.jdField_a_of_type_Lff.A == 1)
        {
          i = j;
          localObject = str;
          if (this.jdField_b_of_type_Int == 9500)
          {
            i = j;
            localObject = str;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Lff.p))
            {
              localObject = this.jdField_a_of_type_Lff.p;
              i = 0;
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject, this.d, true, true);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, (String)localObject, this.d);
      if ((this.jdField_b_of_type_Int == 25) && (this.jdField_b_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
      {
        if (this.jdField_a_of_type_Lff != null) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Lff.a();
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "refreshUI mPeerName = " + this.jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mce
 * JD-Core Version:    0.7.0.1
 */