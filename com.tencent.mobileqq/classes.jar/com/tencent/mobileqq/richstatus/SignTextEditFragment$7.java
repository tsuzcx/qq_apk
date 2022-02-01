package com.tencent.mobileqq.richstatus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class SignTextEditFragment$7
  implements IStatusListener
{
  SignTextEditFragment$7(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onChangeStatus reslut=%d status=%s", new Object[] { Integer.valueOf(paramInt), paramRichStatus }));
    }
    int i;
    if ((paramRichStatus != null) && (paramRichStatus != RichStatus.getEmptyStatus()))
    {
      i = 1;
    }
    else
    {
      if (paramInt == 100) {
        QQToast.makeText(BaseApplication.context, 2, HardCodeUtil.a(2131911555), 0).show();
      } else {
        QQToast.makeText(BaseApplication.context, 1, HardCodeUtil.a(2131911547), 0).show();
      }
      i = 0;
    }
    if ((paramObject instanceof TipsInfo))
    {
      paramRichStatus = (TipsInfo)paramObject;
      SignTextEditFragment.b(this.a, paramRichStatus.errorDesc);
      if (TextUtils.isEmpty(SignTextEditFragment.b(this.a))) {
        SignTextEditFragment.b(this.a, paramRichStatus.wording);
      }
    }
    if (paramInt == 100)
    {
      SignTextEditFragment.a(this.a, false);
      paramRichStatus = this.a;
      paramRichStatus.t = true;
      paramRichStatus.p = new RichStatus(null);
      this.a.p.copyFrom(SignTextEditFragment.c(this.a).b(true));
      paramObject = this.a.r.getAccount();
      paramRichStatus = paramObject;
      if (paramObject == null) {
        paramRichStatus = "noLogin";
      }
      paramRichStatus = this.a.r.getApp().getSharedPreferences(paramRichStatus, 4).edit();
      paramObject = new StringBuilder();
      paramObject.append("sign_location_id_");
      paramObject.append(this.a.r.getCurrentAccountUin());
      paramRichStatus.putString(paramObject.toString(), SignTextEditFragment.d(this.a)).commit();
      if (this.a.isAdded()) {
        SignTextEditFragment.b(this.a, false);
      }
      paramRichStatus = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      paramObject = paramRichStatus.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.r.getCurrentAccountUin());
      localStringBuilder.append("edit_signature_version_826");
      paramObject.putBoolean(localStringBuilder.toString(), true);
      int j = i;
      if (3 == this.a.s)
      {
        SignatureManagerForTool.a().addObserver(this.a.z);
        paramObject = SignatureManagerForTool.a().a(this.a.p.tplId);
        if ((Integer.parseInt(paramObject.b) != this.a.p.tplId) && (paramObject.a.get()))
        {
          SignTextEditFragment.e(this.a).set(true);
          this.a.w.postDelayed(new SignTextEditFragment.7.1(this), 1500L);
          return;
        }
        j = i;
        if (Integer.parseInt(paramObject.b) > 0)
        {
          j = i;
          if (paramObject.B < 2)
          {
            paramObject = new StringBuilder();
            paramObject.append(this.a.r.getCurrentAccountUin());
            paramObject.append("new_signature_version_826");
            j = i;
            if (paramRichStatus.getBoolean(paramObject.toString(), true))
            {
              SignatureEditManager.a(this.a.getBaseActivity(), this.a.getBaseActivity().app, 0, "signature_chouti");
              j = 0;
            }
          }
        }
      }
      if (j != 0)
      {
        paramRichStatus = this.a;
        paramRichStatus.a(paramInt, SignTextEditFragment.b(paramRichStatus));
      }
      this.a.onBackEvent();
      return;
    }
    if (i != 0)
    {
      paramRichStatus = this.a;
      paramRichStatus.a(paramInt, SignTextEditFragment.b(paramRichStatus));
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.7
 * JD-Core Version:    0.7.0.1
 */