package dov.com.qq.im.capture.banner;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import antt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.util.QIMFileUtils;
import java.io.File;

public class QIMCaptureBannerManager
  extends IQIMManager
{
  public static Object a;
  public static String a;
  public QIMCaptureBannerConfig a;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaLangString = QIMFileUtils.a().getAbsolutePath() + File.separator + "banner_config";
  }
  
  public QIMCaptureBannerManager()
  {
    c();
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= paramLong2) {}
    long l;
    do
    {
      return false;
      l = NetConnInfoCenter.getServerTimeMillis();
    } while ((l < paramLong1) || (l > paramLong2));
    return true;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig != null)
    {
      if (!paramBoolean) {
        break label36;
      }
      if (this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig.update) {
        QIMCaptureBannerConfig.saveBannerConfig(a(), this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig, jdField_a_of_type_JavaLangString);
      }
    }
    return;
    label36:
    QIMCaptureBannerConfig.saveBannerConfig(a(), this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig, jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig.mBannerEnable)
      {
        bool1 = bool2;
        if (a(this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig.mBeginTime, this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig.mEndTime)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig = null;
  }
  
  public void b(boolean paramBoolean)
  {
    a().getPreferences().edit().putBoolean("key_tip_has_shown", paramBoolean).commit();
  }
  
  public boolean b()
  {
    return a().getPreferences().getBoolean("key_tip_has_shown", false);
  }
  
  public void c()
  {
    ThreadManager.post(new antt(this), 8, null, true);
  }
  
  public void c(boolean paramBoolean)
  {
    a().getPreferences().edit().putBoolean("key_blur_has_shown", paramBoolean).commit();
  }
  
  public boolean c()
  {
    return a().getPreferences().getBoolean("key_blur_has_shown", false);
  }
  
  public void d(boolean paramBoolean)
  {
    a().getPreferences().edit().putBoolean("key_red_dot_has_shown", paramBoolean).commit();
  }
  
  public boolean d()
  {
    return a().getPreferences().getBoolean("key_red_dot_has_shown", false);
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig != null) && (this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig.mAnimItem != null)) {
      return this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig.mAnimItem.mEnable;
    }
    return false;
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig != null)
    {
      if (!a()) {
        break label129;
      }
      localRedDotItem = this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig.mRedDotItem;
      if ((localRedDotItem != null) && (localRedDotItem.needShow))
      {
        if (localRedDotItem.hasShow) {
          break label113;
        }
        l = NetConnInfoCenter.getServerTimeMillis();
        if (localRedDotItem.startShow <= 0L) {
          break label98;
        }
        if (l - localRedDotItem.startShow < localRedDotItem.showTime) {
          break label96;
        }
        localRedDotItem.hasShow = true;
        this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig.update = true;
        if (QLog.isColorLevel()) {
          QLog.d("QIMCaptureBannerManager", 2, "needShowRedDot out of time");
        }
      }
    }
    label96:
    label98:
    label113:
    while (!QLog.isColorLevel())
    {
      do
      {
        QIMCaptureBannerConfig.RedDotItem localRedDotItem;
        long l;
        return false;
        return true;
        this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig.update = true;
        localRedDotItem.startShow = l;
        return true;
      } while (!QLog.isColorLevel());
      QLog.d("QIMCaptureBannerManager", 2, "needShowRedDot hasShow");
      return false;
    }
    label129:
    QLog.d("QIMCaptureBannerManager", 2, "needShowBanner banner is close");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager
 * JD-Core Version:    0.7.0.1
 */