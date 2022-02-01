package com.tencent.mobileqq.imaxad;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.c2s.imax.IMaxService.RspBody;

public class ImaxAdPresenter$IMaxServiceObserver
  extends ProtoUtils.AppProtocolObserver
{
  int b = 0;
  AdvertisementItem c;
  WeakReference<QQAppInterface> d;
  
  public ImaxAdPresenter$IMaxServiceObserver(ImaxAdPresenter paramImaxAdPresenter, int paramInt)
  {
    this.b = paramInt;
  }
  
  public ImaxAdPresenter$IMaxServiceObserver(ImaxAdPresenter paramImaxAdPresenter, AdvertisementItem paramAdvertisementItem, QQAppInterface paramQQAppInterface)
  {
    this.c = paramAdvertisementItem;
    this.d = new WeakReference(paramQQAppInterface);
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new IMaxService.RspBody();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCode == ");
      localStringBuilder.append(paramInt);
      QLog.i("ImaxAdNetPresenter", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ImaxAdNetPresenter", 2, "request service success");
        }
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((!paramBundle.has()) || (paramBundle.int32_ret.get() != 0)) {
          break label326;
        }
        paramInt = paramBundle.int32_type.get();
        if ((paramInt == 2) && (this.b == 3))
        {
          Toast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131903710), 0).show();
          return;
        }
        if (paramInt != 1) {
          break label326;
        }
        if (paramBundle.int32_exposure_flag.get() == 1)
        {
          paramArrayOfByte = (QQAppInterface)this.d.get();
          if (paramArrayOfByte == null)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.d("ImaxAdNetPresenter", 2, "request EXPOSURE succ ,but app == null");
            return;
          }
          AdvertisementRecentUserManager.a().a(paramArrayOfByte, 1, this.c);
          this.c.f = true;
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdNetPresenter", 2, "do exposure Report");
          }
          this.e.a(this.c);
          ReportController.a(paramArrayOfByte, "dc00898", "", this.c.g.a, "0X8009129", "0X8009129", 0, 0, this.c.g.c, "", PublicAccountAdUtil.c(), this.c.g.b);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label326;
        }
        QLog.d("ImaxAdNetPresenter", 2, "exposure already limited");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("ImaxAdNetPresenter", 2, "request service fail");
      }
      if (this.b == 3) {
        Toast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131903709), 0).show();
      }
    }
    label326:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdPresenter.IMaxServiceObserver
 * JD-Core Version:    0.7.0.1
 */