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
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private VasResController jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController;
  private VasResDrawable jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable;
  private SignatureAdapter.TplListener jdField_a_of_type_ComTencentMobileqqVasAdapterSignatureAdapter$TplListener;
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new SignatureAdapter.1(this);
  private boolean jdField_a_of_type_Boolean;
  private RichStatus jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
  private boolean jdField_b_of_type_Boolean = false;
  
  public SignatureAdapter(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime)
  {
    this(paramVasResDrawable, paramAppRuntime, 2130846437);
  }
  
  public SignatureAdapter(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable = paramVasResDrawable;
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController = paramVasResDrawable.a();
    paramVasResDrawable.a().jdField_a_of_type_Int = 2130847798;
    paramVasResDrawable.a().b = paramInt;
    paramVasResDrawable.a().jdField_a_of_type_JavaLangString = "sig_cover";
    paramVasResDrawable.a().e = 103;
    if (paramAppRuntime != null) {
      paramVasResDrawable.a("my_uin", paramAppRuntime.getAccount());
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("downloadDone isMainThread:");
      if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId())
      {
        bool = true;
        QLog.d("SignatureAdapter", 2, bool);
      }
    }
    else
    {
      if (paramBundle != null) {
        i = paramBundle.getInt("resType");
      }
      switch (i)
      {
      }
    }
    do
    {
      return;
      bool = false;
      break;
    } while ((3 != paramInt) && (paramInt != 0));
    ThreadManager.excute(new SignatureAdapter.3(this, paramBundle), 128, null, true);
  }
  
  public void a(SignatureAdapter.TplListener paramTplListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAdapterSignatureAdapter$TplListener = paramTplListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a();
    SignatureManagerForTool.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    SignatureTemplateInfo localSignatureTemplateInfo = SignatureManagerForTool.a().a(i);
    if (!localSignatureTemplateInfo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if ((localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem == null) || (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.c))) {
        break label120;
      }
      this.jdField_a_of_type_JavaLangString = localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.c;
    }
    for (;;)
    {
      SignatureManagerForTool.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqVasAdapterSignatureAdapter$TplListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqVasAdapterSignatureAdapter$TplListener.load(localSignatureTemplateInfo);
      }
      if (!SignatureManager.a(localSignatureTemplateInfo)) {
        break;
      }
      ThreadManager.excute(new SignatureAdapter.2(this, i, localSignatureTemplateInfo), 128, null, true);
      return;
      label120:
      if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
        this.jdField_a_of_type_JavaLangString = localSignatureTemplateInfo.s;
      } else {
        this.jdField_a_of_type_JavaLangString = localSignatureTemplateInfo.k;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a().sendEmptyMessage(10001);
  }
  
  public void c()
  {
    SignatureManagerForTool.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter
 * JD-Core Version:    0.7.0.1
 */