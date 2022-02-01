package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.Messenger;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.IPresendPicMgr.Stub;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.util.Arrays;

class RichmediaClient$2
  extends ICallBack.Stub
{
  RichmediaClient$2(RichmediaClient paramRichmediaClient) {}
  
  public Bundle a(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramInt == 16)
    {
      LOG.a("PTV.RichmediaClient", "ICallBack.Stub() getData start. ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER");
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
      StringBuilder localStringBuilder = null;
      if ((localPresendPicMgr != null) && (localPresendPicMgr.jdField_a_of_type_Boolean))
      {
        paramBundle = new Messenger(localPresendPicMgr.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr$PresendHandler).getBinder();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ICallBack.Stub() getData. ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER , b = ");
        localStringBuilder.append(paramBundle);
        LOG.a("PTV.RichmediaClient", localStringBuilder.toString());
      }
      else
      {
        paramBundle = localStringBuilder;
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER failed, presendMgr is null or disable preCompress,presendMgr = ");
          paramBundle.append(localPresendPicMgr);
          QLog.d("PTV.RichmediaClient", 2, paramBundle.toString());
          paramBundle = localStringBuilder;
        }
      }
      if (paramBundle != null)
      {
        localBundle.putParcelable("key_presend_mgr_handler", new BinderWarpper(paramBundle));
        localBundle.putInt("PhotoConst.PHOTO_COUNT", localPresendPicMgr.a());
      }
    }
    return localBundle;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendRequest. cmd = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",data = ");
    ((StringBuilder)localObject).append(paramBundle);
    LOG.a("PTV.RichmediaClient", ((StringBuilder)localObject).toString());
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6) {
                return;
              }
              paramBundle = paramBundle.getIntArray("key_compress_config");
              if ((paramBundle != null) && (paramBundle.length >= 9))
              {
                com.tencent.mobileqq.pic.compress.AbstractPicType.d = paramBundle[0];
                com.tencent.mobileqq.pic.compress.AbstractPicType.e = paramBundle[1];
                com.tencent.mobileqq.pic.compress.AbstractPicType.f = paramBundle[2];
                com.tencent.mobileqq.pic.compress.AbstractPicType.g = paramBundle[3];
                com.tencent.mobileqq.pic.compress.AbstractPicType.h = paramBundle[4];
                com.tencent.mobileqq.pic.compress.AbstractPicType.i = paramBundle[5];
                com.tencent.mobileqq.pic.compress.AbstractPicType.a = paramBundle[6];
                com.tencent.mobileqq.pic.compress.AbstractPicType.b = paramBundle[7];
                com.tencent.mobileqq.pic.compress.AbstractPicType.c = paramBundle[8];
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("ICALLBACK_CMD_INIT_COMPRESS_CONFIG, compressConfig = ");
                  ((StringBuilder)localObject).append(Arrays.toString(paramBundle));
                  QLog.d("PTV.RichmediaClient", 2, ((StringBuilder)localObject).toString());
                }
              }
            }
            else
            {
              paramInt = paramBundle.getInt("key_presend_cancel_type");
              paramBundle = PresendPicMgr.a();
              if (paramBundle != null)
              {
                paramBundle.a(paramInt);
                paramBundle.b();
              }
            }
          }
          else
          {
            localObject = paramBundle.getString("key_presend_path");
            paramInt = paramBundle.getInt("key_presend_cancel_type");
            paramBundle = PresendPicMgr.a();
            if ((localObject != null) && (paramBundle != null)) {
              paramBundle.b((String)localObject, paramInt);
            }
          }
        }
        else
        {
          localObject = paramBundle.getString("key_presend_path");
          paramInt = paramBundle.getInt("entrance", 0);
          paramBundle = PresendPicMgr.a();
          if ((localObject != null) && (paramBundle != null)) {
            paramBundle.a((String)localObject, 1052, paramInt);
          }
        }
      }
      else
      {
        paramBundle = (BinderWarpper)paramBundle.getParcelable("binder_presendService");
        if (paramBundle != null)
        {
          localObject = PresendPicMgr.a();
          if (localObject != null) {
            ((PresendPicMgr)localObject).b();
          }
          paramBundle = PresendPicMgr.b(IPresendPicMgr.Stub.a(paramBundle.a));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ICALLBACK_CMD_INIT_PRESEND_PIC_MGR  presendMgr = ");
          ((StringBuilder)localObject).append(paramBundle);
          LOG.a("PTV.RichmediaClient", ((StringBuilder)localObject).toString());
          return;
        }
        LOG.a("PTV.RichmediaClient", "ICALLBACK_CMD_INIT_PRESEND_PIC_MGR  failed, bw is null ! ");
      }
    }
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ICallBack.Stub() compress start. info.src = ");
    localStringBuilder.append(paramCompressInfo.c);
    localStringBuilder.append(",uuid = ");
    localStringBuilder.append(paramCompressInfo.a);
    LOG.a("PTV.RichmediaClient", localStringBuilder.toString());
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramCompressInfo);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ICallBack.Stub() compress finish. info = ");
    localStringBuilder.append(paramCompressInfo);
    LOG.a("PTV.RichmediaClient", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaClient.2
 * JD-Core Version:    0.7.0.1
 */