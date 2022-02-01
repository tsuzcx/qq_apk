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
  private static volatile PicShareToWX h;
  public QQProgressDialog a;
  protected TransferRequest b;
  protected QQAppInterface c;
  protected Context d;
  protected int e;
  protected PicSTWXQIPCModule f;
  protected int g;
  private PicShareToWX.TimeoutRunnable i;
  private boolean j;
  private long k;
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramInt == 1)
    {
      if (paramBoolean) {
        str = "0X800A500";
      } else {
        str = "0X800A501";
      }
    }
    else if (paramInt == 2)
    {
      if (paramBoolean) {
        str = "0X800A503";
      } else {
        str = "0X800A504";
      }
    }
    else if (paramInt == 3)
    {
      if (paramBoolean) {
        str = "0X800A506";
      } else {
        str = "0X800A507";
      }
    }
    else {
      str = "";
    }
    ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
  }
  
  public static void a(String paramString, Context paramContext, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_pic_path", paramString);
    localBundle.putInt("param_from_type", paramInt);
    paramString = new PicShareToWX.2();
    QIPCClientHelper.getInstance().callServer("PicSTWXQIPCModule", "action_share_pic_to_wx", localBundle, paramString);
    b().a(paramContext);
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {
      localHashMap.put("param_succ_flag", "1");
    } else {
      localHashMap.put("param_succ_flag", "0");
    }
    localHashMap.put("param_picSize", String.valueOf(this.k));
    localHashMap.put("param_errorStep", String.valueOf(paramInt2));
    localHashMap.put("param_FailCode", String.valueOf(paramInt1));
    localHashMap.put("param_fromType", String.valueOf(this.e));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPicShareToWX", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static PicShareToWX b()
  {
    if (h == null) {
      try
      {
        if (h == null) {
          h = new PicShareToWX();
        }
      }
      finally {}
    }
    return h;
  }
  
  public void a()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.f = null;
    this.g = 0;
  }
  
  public void a(Context paramContext)
  {
    this.d = paramContext;
    if (this.a == null) {
      this.a = new QQProgressDialog(paramContext, b(paramContext));
    }
    this.a.c(2131896471);
    this.a.show();
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    this.e = paramInt;
    a(paramContext);
    a(paramQQAppInterface, paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.j = false;
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mFileType = 66;
    localTransferRequest.mLocalPath = paramString;
    this.k = new File(paramString).length();
    localTransferRequest.mUpCallBack = new PicShareToWX.ShareUpCallBack(this, paramString);
    localTransferRequest.mUniseq = System.currentTimeMillis();
    this.b = localTransferRequest;
    if (paramQQAppInterface != null)
    {
      this.c = paramQQAppInterface;
      paramQQAppInterface = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.transferAsync(localTransferRequest);
      }
    }
    this.i = new PicShareToWX.TimeoutRunnable(this, null);
    ThreadManager.getUIHandler().postDelayed(this.i, 5000L);
  }
  
  public void a(PicSTWXQIPCModule paramPicSTWXQIPCModule, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.e = paramInt2;
    this.f = paramPicSTWXQIPCModule;
    this.g = paramInt1;
    a(paramQQAppInterface, paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWX", 1, "doShareToWX");
    }
    PicShareToWXConfigProcessor.PicShareToWXConifgBean localPicShareToWXConifgBean = (PicShareToWXConfigProcessor.PicShareToWXConifgBean)QConfigManager.b().b(530);
    PicShareToWX.1 local1 = new PicShareToWX.1(this, paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localPicShareToWXConifgBean.d);
    ((StringBuilder)localObject).append("url=");
    ((StringBuilder)localObject).append(SearchUtils.h(paramString));
    localObject = ((StringBuilder)localObject).toString();
    WXShareHelper.a().a(local1);
    WXShareHelper.a().a((String)localObject, paramString, localPicShareToWXConifgBean.c, paramBitmap, localPicShareToWXConifgBean.g, localPicShareToWXConifgBean.h, localPicShareToWXConifgBean.e, localPicShareToWXConifgBean.f);
  }
  
  public boolean a(File paramFile)
  {
    PicShareToWXConfigProcessor.PicShareToWXConifgBean localPicShareToWXConifgBean = (PicShareToWXConfigProcessor.PicShareToWXConifgBean)QConfigManager.b().b(530);
    return paramFile.length() < localPicShareToWXConifgBean.b;
  }
  
  public boolean a(String paramString)
  {
    paramString = new File(paramString);
    PicShareToWXConfigProcessor.PicShareToWXConifgBean localPicShareToWXConifgBean = (PicShareToWXConfigProcessor.PicShareToWXConifgBean)QConfigManager.b().b(530);
    return paramString.length() < localPicShareToWXConifgBean.b;
  }
  
  public int b(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(2131299920);
  }
  
  public void c()
  {
    Context localContext = this.d;
    if (localContext != null) {
      QQToast.makeText(localContext, 2131916545, 0).show();
    }
  }
  
  public void d()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
  }
  
  public boolean e()
  {
    return ((PicShareToWXConfigProcessor.PicShareToWXConifgBean)QConfigManager.b().b(530)).a;
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX
 * JD-Core Version:    0.7.0.1
 */