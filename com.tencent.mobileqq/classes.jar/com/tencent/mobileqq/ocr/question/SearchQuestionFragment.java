package com.tencent.mobileqq.ocr.question;

import agcw;
import agcy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.OcrImageUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SearchQuestionFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  public static String a;
  public Activity a;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ARCloudFileUpload jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload;
  ScanSuccessView jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
  public WeakReferenceHandler a;
  boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public String b;
  boolean jdField_b_of_type_Boolean;
  public String c;
  String d;
  
  static
  {
    File localFile = new File(AppConstants.aJ, "ocr");
    if ((!localFile.exists()) && (!localFile.mkdir())) {
      QLog.d("SearchQuestionFragment", 1, "OcrHandler mkdir ocr fail");
    }
    if (localFile.exists())
    {
      localFile = new File(localFile, "question");
      if ((!localFile.exists()) && (!localFile.mkdir())) {
        QLog.d("SearchQuestionFragment", 1, "OcrHandler mkdir question fail");
      }
      jdField_a_of_type_JavaLangString = localFile.getAbsolutePath();
    }
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("pic_path", paramString);
    localIntent.addFlags(603979776);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.a(paramContext, localIntent, SearchQuestionFragment.class);
  }
  
  public String a()
  {
    return String.format("%s_%s_%05d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public void a(String paramString)
  {
    Object localObject = new File(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("SearchQuestionFragment", 2, "searchQuestion path:" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("SearchQuestionFragment", 1, "search question sourcePath is empty!");
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
      return;
    }
    if (!((File)localObject).exists())
    {
      QLog.d("SearchQuestionFragment", 1, "search question file is not exists, path:" + paramString);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
      return;
    }
    if (!OcrImageUtil.a(paramString))
    {
      QLog.d("SearchQuestionFragment", 1, "preProcessPic sourcePath is empty!");
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
      return;
    }
    String str = ((File)localObject).getName();
    localObject = paramString;
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      str = new File(jdField_a_of_type_JavaLangString, str).getAbsolutePath();
      localObject = paramString;
      if (OcrImageUtil.a(paramString, str)) {
        localObject = str;
      }
    }
    paramString = new BitmapFactory.Options();
    paramString.inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)localObject, paramString);
    int i = paramString.outHeight;
    int j = paramString.outWidth;
    paramString = new ARCloudReqFileInfo();
    paramString.jdField_a_of_type_JavaLangString = ((String)localObject);
    paramString.jdField_a_of_type_Int = 0;
    paramString.jdField_b_of_type_Int = i;
    paramString.jdField_c_of_type_Int = j;
    if (QLog.isColorLevel()) {
      QLog.d("SearchQuestionFragment", 2, "searchQuestion picSize:" + new File((String)localObject).length() / 1024L + "KB, uploadPath: " + (String)localObject);
    }
    localObject = new ARCloudReqInfo();
    this.c = a();
    ((ARCloudReqInfo)localObject).jdField_a_of_type_JavaLangString = this.c;
    ((ARCloudReqInfo)localObject).jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo = paramString;
    ((ARCloudReqInfo)localObject).jdField_b_of_type_Int = 900000000;
    ((ARCloudReqInfo)localObject).jdField_a_of_type_Int = 900000000;
    ((ARCloudReqInfo)localObject).jdField_a_of_type_Long = 512L;
    ((ARCloudReqInfo)localObject).jdField_c_of_type_Int = 0;
    ((ARCloudReqInfo)localObject).jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((ARCloudReqInfo)localObject).jdField_b_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((ARCloudReqInfo)localObject).jdField_c_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchQuestionFragment", 2, "searchQuestion reqInfo:" + localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a((ARCloudReqInfo)localObject, new agcy(this, (ARCloudReqInfo)localObject));
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(0, 30000L);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
      return true;
    case 0: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439060, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      ReportController.b(null, "dc00898", "", "", "0X80085D2", "0X80085D2", 0, 0, "", "", "", "");
      return true;
    case 2: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439048, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return true;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439047, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return true;
    case 4: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439060, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      ReportController.b(null, "dc00898", "", "", "0X80085D2", "0X80085D2", 0, 0, "", "", "", "");
      return true;
    case 6: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439061, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      ReportController.b(null, "dc00898", "", "", "0X80085D2", "0X80085D2", 0, 0, "", "", "", "");
      return true;
    case 7: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439041, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.d = ((String)paramMessage.obj);
      if (!TextUtils.isEmpty(this.d))
      {
        paramMessage = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
        paramMessage.putExtra("url", this.d);
        startActivity(paramMessage);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        ReportController.b(null, "dc00898", "", "", "0X80085D1", "0X80085D1", 0, 0, "", "", "", "");
        return true;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(6);
      return true;
    }
    this.jdField_b_of_type_Boolean = true;
    this.d = ((String)paramMessage.obj);
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
      return;
    }
    throw new IllegalStateException("Only allowed in main progress");
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131492971));
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setShowProgress(false);
    this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText("正在搜索题目...");
    this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
    this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ScreenUtil.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, paramLayoutInflater);
    paramLayoutInflater = new RelativeLayout.LayoutParams(AIOUtils.a(40.0F, getResources()), AIOUtils.a(40.0F, getResources()));
    paramLayoutInflater.addRule(14);
    paramLayoutInflater.addRule(12);
    paramLayoutInflater.bottomMargin = AIOUtils.a(40.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842902);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131433015));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, paramLayoutInflater);
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if (!TextUtils.isEmpty(this.d))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", this.d);
        startActivity(localIntent);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        ReportController.b(null, "dc00898", "", "", "0X80085D1", "0X80085D1", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(6);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getArguments();
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload = new ARCloudFileUpload(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
    this.jdField_b_of_type_JavaLangString = paramView.getString("pic_path", "");
    ThreadManager.postImmediately(new agcw(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.question.SearchQuestionFragment
 * JD-Core Version:    0.7.0.1
 */