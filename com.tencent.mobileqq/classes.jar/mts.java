import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public final class mts
  implements Runnable
{
  public mts(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = this.a.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + this.a.getCurrentAccountUin(), 0);
    if (localObject != null) {}
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_name", PublicAccountConfigUtil.jdField_f_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_icon", PublicAccountConfigUtil.jdField_g_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_delete", PublicAccountConfigUtil.jdField_a_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("service_folder_redclean_after_enter", PublicAccountConfigUtil.p);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots", PublicAccountConfigUtil.jdField_b_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload", PublicAccountConfigUtil.e);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_wifi", PublicAccountConfigUtil.jdField_f_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_4G", PublicAccountConfigUtil.jdField_g_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_3G", PublicAccountConfigUtil.jdField_h_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_2G", PublicAccountConfigUtil.jdField_i_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("public_account_bottom_bar", PublicAccountConfigUtil.l);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_image_preload", PublicAccountConfigUtil.jdField_j_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putString("kandian_feeds_fling_LToR_host", PublicAccountConfigUtil.jdField_h_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putBoolean("readInJoy_ip_connect", PublicAccountConfigUtil.m);
      ((SharedPreferences.Editor)localObject).putInt("readInJoy_ip_connect_full_report", PublicAccountConfigUtil.jdField_a_of_type_Int);
      ((SharedPreferences.Editor)localObject).putString("readInJoy_ip_connect_report_tail", PublicAccountConfigUtil.jdField_k_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putBoolean("readInJoy_loading_img", PublicAccountConfigUtil.n);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots_delete", PublicAccountConfigUtil.jdField_c_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("big_data_share_channel", PublicAccountConfigUtil.o);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_enable", PublicAccountConfigUtil.jdField_b_of_type_Int);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_photo_rule", PublicAccountConfigUtil.jdField_c_of_type_Int);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_slide_photocounts", PublicAccountConfigUtil.d);
      ((SharedPreferences.Editor)localObject).putBoolean("ad_preload_tool_process", PublicAccountConfigUtil.jdField_k_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putString("key_read_in_joy_preload_tool_config", PublicAccountConfigUtil.jdField_i_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putString("key_read_in_joy_release_service_config", PublicAccountConfigUtil.jdField_j_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "updatePublicAccountCenterUrlConfigData error", localException);
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mts
 * JD-Core Version:    0.7.0.1
 */