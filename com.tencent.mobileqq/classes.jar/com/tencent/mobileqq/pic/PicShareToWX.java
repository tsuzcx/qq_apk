package com.tencent.mobileqq.pic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import aogj;
import aolf;
import awfe;
import awff;
import awfg;
import awfh;
import ayrd;
import azmj;
import azmz;
import batw;
import baub;
import bepp;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
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
  private static volatile PicShareToWX jdField_a_of_type_ComTencentMobileqqPicPicShareToWX;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private awfe jdField_a_of_type_Awfe;
  private baub jdField_a_of_type_Baub;
  public bepp a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PicShareToWX.TimeoutRunnable jdField_a_of_type_ComTencentMobileqqPicPicShareToWX$TimeoutRunnable;
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
      azmj.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
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
    paramString = new awfg();
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
      azmz.a(BaseApplication.getContext()).a(null, "actPicShareToWX", paramBoolean, 0L, 0L, localHashMap, null);
      return;
      localHashMap.put("param_succ_flag", "0");
    }
  }
  
  public int a(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(2131298914);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bepp = null;
    this.jdField_a_of_type_Baub = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Awfe = null;
    this.b = 0;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp(paramContext, a(paramContext));
    }
    this.jdField_a_of_type_Bepp.c(2131698772);
    this.jdField_a_of_type_Bepp.show();
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramContext);
    a(paramQQAppInterface, paramString);
  }
  
  public void a(awfe paramawfe, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_Awfe = paramawfe;
    this.b = paramInt1;
    a(paramQQAppInterface, paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    baub localbaub = new baub();
    localbaub.b = 66;
    localbaub.i = paramString;
    this.jdField_a_of_type_Long = new File(paramString).length();
    localbaub.jdField_a_of_type_Awfy = new awfh(this, paramString);
    localbaub.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Baub = localbaub;
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(localbaub);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX$TimeoutRunnable = new PicShareToWX.TimeoutRunnable(this, null);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX$TimeoutRunnable, 5000L);
  }
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWX", 1, "doShareToWX");
    }
    aolf localaolf = (aolf)aogj.a().a(530);
    awff localawff = new awff(this, paramInt);
    String str = localaolf.jdField_b_of_type_JavaLangString + "url=" + ayrd.b(paramString);
    WXShareHelper.a().a(localawff);
    WXShareHelper.a().a(str, paramString, localaolf.jdField_a_of_type_JavaLangString, paramBitmap, localaolf.c, localaolf.d, localaolf.jdField_b_of_type_Boolean, localaolf.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    return ((aolf)aogj.a().a(530)).jdField_a_of_type_Boolean;
  }
  
  public boolean a(File paramFile)
  {
    aolf localaolf = (aolf)aogj.a().a(530);
    return paramFile.length() < localaolf.jdField_a_of_type_Long;
  }
  
  public boolean a(String paramString)
  {
    paramString = new File(paramString);
    aolf localaolf = (aolf)aogj.a().a(530);
    return paramString.length() < localaolf.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720020, 0).a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bepp != null) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX
 * JD-Core Version:    0.7.0.1
 */