package com.tencent.mobileqq.portal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.QFragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class RedPacketShowerFragment
  extends QPublicBaseFragment
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  QFragmentActivity jdField_a_of_type_AndroidSupportV4AppQFragmentActivity;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new RedPacketShowerFragment.2(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  private final int jdField_e_of_type_Int = 1000;
  String jdField_e_of_type_JavaLangString;
  private final int jdField_f_of_type_Int = 25;
  String jdField_f_of_type_JavaLangString;
  private final int g = 1;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidSupportV4AppQFragmentActivity = getActivity();
    Bundle localBundle = this.jdField_a_of_type_AndroidSupportV4AppQFragmentActivity.getIntent().getExtras();
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketShowerFragment", 2, new Object[] { "initUI", localBundle });
    }
    try
    {
      localBundle.getInt("key_business_id", -1);
      this.jdField_a_of_type_Int = localBundle.getInt("key_award_type", -1);
      this.jdField_c_of_type_Int = localBundle.getInt("key_business_id", -1);
      this.jdField_d_of_type_Int = localBundle.getInt("key_promotion_id", -1);
      this.jdField_b_of_type_Int = localBundle.getInt("k_state", -1);
      this.jdField_f_of_type_JavaLangString = localBundle.getString("k_pack_id");
      this.jdField_e_of_type_JavaLangString = localBundle.getString("key_url");
      this.jdField_a_of_type_JavaLangString = localBundle.getString("key_business_name");
      this.jdField_b_of_type_JavaLangString = localBundle.getString("key_business_logo");
      this.jdField_c_of_type_JavaLangString = localBundle.getString("key_business_name_pic");
      this.jdField_d_of_type_JavaLangString = localBundle.getString("active_id");
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketShowerFragment", 2, "initUI packId " + this.jdField_f_of_type_JavaLangString + "businessNamePic " + this.jdField_c_of_type_JavaLangString);
      }
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      Bitmap localBitmap = localSpringFestivalEntryManager.a(this.jdField_c_of_type_JavaLangString, "");
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketShowerFragment", 2, "initUI bitmap = " + localBitmap);
      }
      if (localBitmap == null) {
        localSpringFestivalEntryManager.a(new RedPacketShowerFragment.1(this, this.jdField_c_of_type_JavaLangString, localSpringFestivalEntryManager));
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilMap.put("jackpot_id", this.jdField_d_of_type_Int + "");
        if (this.jdField_a_of_type_JavaLangString != null) {
          this.jdField_a_of_type_JavaUtilMap.put("business_name", this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilMap.put("business_id", this.jdField_c_of_type_Int + "");
        if (this.jdField_d_of_type_JavaLangString != null) {
          this.jdField_a_of_type_JavaUtilMap.put("active_id", this.jdField_d_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilMap.put("ext2", localBundle.getLong("key_current_brush_progress_ms") + "");
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketShowerFragment", 2, new Object[] { "initUI mParam", this.jdField_a_of_type_JavaUtilMap });
        }
        SpringHbReporter.a(ReportConstant.Event.o, 0, 0, this.jdField_a_of_type_JavaUtilMap, "exp", true);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RedPacketShowerFragment", 2, "getExtra Exception", localException);
      getActivity().finish();
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369785);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369786));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369783));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364107));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369787));
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    paramActivity.overridePendingTransition(2130772315, 2130771992);
  }
  
  public boolean a()
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long >= 1000L) {
      bool = true;
    }
    this.jdField_a_of_type_Long = l;
    return bool;
  }
  
  public boolean d_()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (getActivity() != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561566, paramViewGroup, false);
      if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        b();
        a();
      }
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketShowerFragment
 * JD-Core Version:    0.7.0.1
 */