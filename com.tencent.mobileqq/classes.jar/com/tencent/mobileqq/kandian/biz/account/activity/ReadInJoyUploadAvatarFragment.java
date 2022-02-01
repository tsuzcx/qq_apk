package com.tencent.mobileqq.kandian.biz.account.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.constant.IReadInJoyUploadAvatarFragmentConst;
import com.tencent.mobileqq.kandian.biz.ugc.video.transfer.FileUploadController.FileUploadListener;
import com.tencent.mobileqq.kandian.biz.ugc.video.transfer.ImageUploadController;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.TicketManager;

public class ReadInJoyUploadAvatarFragment
  extends IphoneTitleBarFragment
  implements IReadInJoyUploadAvatarFragmentConst
{
  protected static String a = "ReadInJoyUploadAvatarFragment";
  protected ProgressDialog a;
  protected Handler a;
  FileUploadController.FileUploadListener a;
  
  public ReadInJoyUploadAvatarFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferFileUploadController$FileUploadListener = new ReadInJoyUploadAvatarFragment.4(this);
  }
  
  private void a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    new ImageUploadController(BaseApplicationImpl.getContext(), localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferFileUploadController$FileUploadListener).a(paramString, true, 2);
  }
  
  private void a(String paramString, Handler paramHandler, int paramInt)
  {
    Bundle localBundle = new Bundle();
    Object localObject1 = getBaseActivity();
    if (localObject1 != null)
    {
      if (((BaseActivity)localObject1).app == null) {
        return;
      }
      Object localObject2 = ((BaseActivity)localObject1).app;
      Object localObject3 = (TicketManager)((QQAppInterface)localObject2).getManager(2);
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      localObject2 = ((TicketManager)localObject3).getSkey(((QQAppInterface)localObject2).getCurrentAccountUin());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("uin=o");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(";skey=");
      ((StringBuilder)localObject3).append((String)localObject2);
      localBundle.putString("Cookie", ((StringBuilder)localObject3).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(TroopUtils.a((String)localObject2));
      localBundle.putString("bkn", ((StringBuilder)localObject1).toString());
      localBundle.putString("dataType", "base64");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramInt);
      localBundle.putString("type", ((StringBuilder)localObject1).toString());
      ThreadManager.executeOnSubThread(new ReadInJoyUploadAvatarFragment.3(this, paramString, localBundle, paramHandler));
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 != 2) {
      a(paramString, new ReadInJoyUploadAvatarFragment.2(this, Looper.getMainLooper()), paramInt2);
    } else {
      a(paramString);
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uploadFile: from:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" paths:");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(HardCodeUtil.a(2131712830), HardCodeUtil.a(2131712830));
    setLeftViewName(2131694836);
    paramLayoutInflater = getBaseActivity();
    if (paramLayoutInflater == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "doOnCreateView activity = null");
      return;
    }
    RIJDtReportHelper.a.a(getBaseActivity());
    this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyUploadAvatarFragment.1(this, paramLayoutInflater));
    paramViewGroup = paramLayoutInflater.getIntent();
    paramBundle = paramViewGroup.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    int i = paramViewGroup.getIntExtra("from", 0);
    if ((paramBundle == null) || (paramBundle.isEmpty()))
    {
      Intent localIntent = paramLayoutInflater.getIntent();
      Bundle localBundle = new Bundle();
      localBundle.putInt("retCode", 2);
      localBundle.putString("msg", HardCodeUtil.a(2131712811));
      localIntent.putExtra("Bundle", localBundle);
      paramLayoutInflater.setResult(-1, localIntent);
      paramLayoutInflater.finish();
    }
    int j = paramViewGroup.getIntExtra("type", 1);
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      a(i, (String)paramBundle.get(0), j);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131560311;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  protected boolean isTransparent()
  {
    return true;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ProgressDialog localProgressDialog = this.jdField_a_of_type_AndroidAppProgressDialog;
    if (localProgressDialog != null) {
      localProgressDialog.dismiss();
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.activity.ReadInJoyUploadAvatarFragment
 * JD-Core Version:    0.7.0.1
 */