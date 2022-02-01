package com.tencent.mobileqq.pic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PicShareToWXConfigProcessor.PicShareToWXConifgBean;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class PicShareToWX
  implements IWXAPIEventHandler
{
  private static volatile PicShareToWX jdField_a_of_type_ComTencentMobileqqPicPicShareToWX = null;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PicSTWXQIPCModule jdField_a_of_type_ComTencentMobileqqPicPicSTWXQIPCModule;
  private PicShareToWX.TimeoutRunnable jdField_a_of_type_ComTencentMobileqqPicPicShareToWX$TimeoutRunnable;
  private TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  public QQProgressDialog a;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public static PicShareToWX a()
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPicShareToWX == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqPicPicShareToWX == null) {
        jdField_a_of_type_ComTencentMobileqqPicPicShareToWX = new PicShareToWX();
      }
      return jdField_a_of_type_ComTencentMobileqqPicPicShareToWX;
    }
    finally {}
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramInt == 1) {
      if (paramBoolean) {
        str = "0X800A500";
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      return;
      str = "0X800A501";
      continue;
      if (paramInt == 2)
      {
        if (paramBoolean) {}
        for (str = "0X800A503";; str = "0X800A504") {
          break;
        }
      }
      if (paramInt == 3)
      {
        if (paramBoolean) {}
        for (str = "0X800A506";; str = "0X800A507") {
          break;
        }
      }
      str = "";
    }
  }
  
  public static void a(String paramString, Context paramContext, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_pic_path", paramString);
    localBundle.putInt("param_from_type", paramInt);
    paramString = new PicShareToWX.2();
    QIPCClientHelper.getInstance().callServer("PicSTWXQIPCModule", "action_share_pic_to_wx", localBundle, paramString);
    a().a(paramContext);
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {
      localHashMap.put("param_succ_flag", "1");
    }
    for (;;)
    {
      localHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
      localHashMap.put("param_errorStep", String.valueOf(paramInt2));
      localHashMap.put("param_FailCode", String.valueOf(paramInt1));
      localHashMap.put("param_fromType", String.valueOf(this.jdField_a_of_type_Int));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPicShareToWX", paramBoolean, 0L, 0L, localHashMap, null);
      return;
      localHashMap.put("param_succ_flag", "0");
    }
  }
  
  public int a(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(2131299166);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqPicPicSTWXQIPCModule = null;
    this.b = 0;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramContext, a(paramContext));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131698459);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramContext);
    a(paramQQAppInterface, paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mFileType = 66;
    localTransferRequest.mLocalPath = paramString;
    this.jdField_a_of_type_Long = new File(paramString).length();
    localTransferRequest.mUpCallBack = new PicShareToWX.ShareUpCallBack(this, paramString);
    localTransferRequest.mUniseq = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = localTransferRequest;
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      paramQQAppInterface = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.transferAsync(localTransferRequest);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX$TimeoutRunnable = new PicShareToWX.TimeoutRunnable(this, null);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX$TimeoutRunnable, 5000L);
  }
  
  public void a(PicSTWXQIPCModule paramPicSTWXQIPCModule, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqPicPicSTWXQIPCModule = paramPicSTWXQIPCModule;
    this.b = paramInt1;
    a(paramQQAppInterface, paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWX", 1, "doShareToWX");
    }
    PicShareToWXConfigProcessor.PicShareToWXConifgBean localPicShareToWXConifgBean = (PicShareToWXConfigProcessor.PicShareToWXConifgBean)QConfigManager.a().a(530);
    PicShareToWX.1 local1 = new PicShareToWX.1(this, paramInt);
    String str = localPicShareToWXConifgBean.jdField_b_of_type_JavaLangString + "url=" + SearchUtils.b(paramString);
    WXShareHelper.a().a(local1);
    WXShareHelper.a().a(str, paramString, localPicShareToWXConifgBean.jdField_a_of_type_JavaLangString, paramBitmap, localPicShareToWXConifgBean.c, localPicShareToWXConifgBean.d, localPicShareToWXConifgBean.jdField_b_of_type_Boolean, localPicShareToWXConifgBean.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    return ((PicShareToWXConfigProcessor.PicShareToWXConifgBean)QConfigManager.a().a(530)).jdField_a_of_type_Boolean;
  }
  
  public boolean a(File paramFile)
  {
    PicShareToWXConfigProcessor.PicShareToWXConifgBean localPicShareToWXConifgBean = (PicShareToWXConfigProcessor.PicShareToWXConifgBean)QConfigManager.a().a(530);
    return paramFile.length() < localPicShareToWXConifgBean.jdField_a_of_type_Long;
  }
  
  public boolean a(String paramString)
  {
    paramString = new File(paramString);
    PicShareToWXConfigProcessor.PicShareToWXConifgBean localPicShareToWXConifgBean = (PicShareToWXConfigProcessor.PicShareToWXConifgBean)QConfigManager.a().a(530);
    return paramString.length() < localPicShareToWXConifgBean.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719292, 0).a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX
 * JD-Core Version:    0.7.0.1
 */