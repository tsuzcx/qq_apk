package com.tencent.mobileqq.portal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class RedPacketShowerFragment
  extends QPublicBaseFragment
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new RedPacketShowerFragment.2(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getExtras();
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
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initUI packId ");
        ((StringBuilder)localObject1).append(this.jdField_f_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("businessNamePic ");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
        QLog.d("RedPacketShowerFragment", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      Object localObject2 = ((SpringFestivalEntryManager)localObject1).a(this.jdField_c_of_type_JavaLangString, "");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initUI bitmap = ");
        localStringBuilder.append(localObject2);
        QLog.d("RedPacketShowerFragment", 2, localStringBuilder.toString());
      }
      if (localObject2 == null) {
        ((SpringFestivalEntryManager)localObject1).a(new RedPacketShowerFragment.1(this, this.jdField_c_of_type_JavaLangString, (SpringFestivalEntryManager)localObject1));
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = this.jdField_a_of_type_JavaUtilMap;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_d_of_type_Int);
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("jackpot_id", ((StringBuilder)localObject2).toString());
      if (this.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilMap.put("business_name", this.jdField_a_of_type_JavaLangString);
      }
      localObject1 = this.jdField_a_of_type_JavaUtilMap;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_Int);
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("business_id", ((StringBuilder)localObject2).toString());
      if (this.jdField_d_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilMap.put("active_id", this.jdField_d_of_type_JavaLangString);
      }
      localObject1 = this.jdField_a_of_type_JavaUtilMap;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localBundle.getLong("key_current_brush_progress_ms"));
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("ext2", ((StringBuilder)localObject2).toString());
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketShowerFragment", 2, new Object[] { "initUI mParam", this.jdField_a_of_type_JavaUtilMap });
      }
      SpringHbReporter.a(ReportConstant.Event.o, 0, 0, this.jdField_a_of_type_JavaUtilMap, "exp", true);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369475);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369476));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369473));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364028));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369477));
  }
  
  public boolean a()
  {
    long l = System.currentTimeMillis();
    boolean bool;
    if (l - this.jdField_a_of_type_Long >= 1000L) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Long = l;
    return bool;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772343, 2130772004);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = getQBaseActivity();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561407, paramViewGroup, false);
      if ((paramBundle.getAppRuntime() instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle.getAppRuntime());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        b();
        a();
      }
    }
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketShowerFragment
 * JD-Core Version:    0.7.0.1
 */