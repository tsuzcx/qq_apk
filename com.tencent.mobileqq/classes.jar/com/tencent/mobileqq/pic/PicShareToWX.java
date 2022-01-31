package com.tencent.mobileqq.pic;

import ampl;
import amub;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import aunx;
import auny;
import aunz;
import auoa;
import awwa;
import axqy;
import axrn;
import ayvx;
import aywc;
import bcqf;
import bcql;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
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
  private aunx jdField_a_of_type_Aunx;
  private aywc jdField_a_of_type_Aywc;
  public bcqf a;
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
      axqy.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
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
    paramString = new aunz();
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
      axrn.a(BaseApplication.getContext()).a(null, "actPicShareToWX", paramBoolean, 0L, 0L, localHashMap, null);
      return;
      localHashMap.put("param_succ_flag", "0");
    }
  }
  
  public int a(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(2131298865);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bcqf = null;
    this.jdField_a_of_type_Aywc = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Aunx = null;
    this.b = 0;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(paramContext, a(paramContext));
    }
    this.jdField_a_of_type_Bcqf.c(2131698477);
    this.jdField_a_of_type_Bcqf.show();
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramContext);
    a(paramQQAppInterface, paramString);
  }
  
  public void a(aunx paramaunx, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_Aunx = paramaunx;
    this.b = paramInt1;
    a(paramQQAppInterface, paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    aywc localaywc = new aywc();
    localaywc.b = 66;
    localaywc.i = paramString;
    this.jdField_a_of_type_Long = new File(paramString).length();
    localaywc.jdField_a_of_type_Auoq = new auoa(this, paramString);
    localaywc.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Aywc = localaywc;
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(localaywc);
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
    amub localamub = (amub)ampl.a().a(530);
    auny localauny = new auny(this, paramInt);
    String str = localamub.jdField_b_of_type_JavaLangString + "url=" + awwa.a(paramString);
    WXShareHelper.a().a(localauny);
    WXShareHelper.a().a(str, paramString, localamub.jdField_a_of_type_JavaLangString, paramBitmap, localamub.c, localamub.d, localamub.jdField_b_of_type_Boolean, localamub.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    return ((amub)ampl.a().a(530)).jdField_a_of_type_Boolean;
  }
  
  public boolean a(File paramFile)
  {
    amub localamub = (amub)ampl.a().a(530);
    return paramFile.length() < localamub.jdField_a_of_type_Long;
  }
  
  public boolean a(String paramString)
  {
    paramString = new File(paramString);
    amub localamub = (amub)ampl.a().a(530);
    return paramString.length() < localamub.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719488, 0).a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bcqf != null) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX
 * JD-Core Version:    0.7.0.1
 */