package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.ImageItem;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.VasResDrawableAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class SignatureAdapter
  implements VasResAdapter, VasResDrawable.VasResDrawableAdapter
{
  private String a;
  private boolean b;
  private VasResController c;
  private RichStatus d;
  private RichStatus e = new RichStatus(null);
  private VasResDrawable f;
  private boolean g = false;
  private SignatureAdapter.TplListener h;
  private Observer i = new SignatureAdapter.1(this);
  
  public SignatureAdapter(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime)
  {
    this(paramVasResDrawable, paramAppRuntime, 2130847784);
  }
  
  public SignatureAdapter(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime, int paramInt)
  {
    this.f = paramVasResDrawable;
    this.c = paramVasResDrawable.a();
    paramVasResDrawable.d().b = 2130849325;
    paramVasResDrawable.d().c = paramInt;
    paramVasResDrawable.d().a = "sig_cover";
    paramVasResDrawable.d().g = 103;
    if (paramAppRuntime != null) {
      paramVasResDrawable.b("my_uin", paramAppRuntime.getAccount());
    }
  }
  
  public void a()
  {
    int j = this.c.b();
    SignatureManagerForTool.a().addObserver(this.i);
    SignatureTemplateInfo localSignatureTemplateInfo = SignatureManagerForTool.a().a(j);
    if (!localSignatureTemplateInfo.a.get())
    {
      if ((localSignatureTemplateInfo.D != null) && (!TextUtils.isEmpty(localSignatureTemplateInfo.D.e))) {
        this.a = localSignatureTemplateInfo.D.e;
      } else if (!TextUtils.isEmpty(localSignatureTemplateInfo.z)) {
        this.a = localSignatureTemplateInfo.z;
      } else {
        this.a = localSignatureTemplateInfo.p;
      }
      SignatureManagerForTool.a().deleteObserver(this.i);
      SignatureAdapter.TplListener localTplListener = this.h;
      if (localTplListener != null) {
        localTplListener.load(localSignatureTemplateInfo);
      }
    }
    if (SignatureManager.a(localSignatureTemplateInfo))
    {
      ThreadManager.excute(new SignatureAdapter.2(this, j, localSignatureTemplateInfo), 128, null, true);
      return;
    }
    this.b = false;
    this.c.a().sendEmptyMessage(10001);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadDone isMainThread:");
      if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("SignatureAdapter", 2, localStringBuilder.toString());
    }
    if (paramBundle != null) {
      j = paramBundle.getInt("resType");
    }
    if (j != 2) {
      return;
    }
    if ((3 == paramInt) || (paramInt == 0)) {
      ThreadManager.excute(new SignatureAdapter.3(this, paramBundle), 128, null, true);
    }
  }
  
  public void a(SignatureAdapter.TplListener paramTplListener)
  {
    this.h = paramTplListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b()
  {
    SignatureManagerForTool.a().deleteObserver(this.i);
  }
  
  public String c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter
 * JD-Core Version:    0.7.0.1
 */