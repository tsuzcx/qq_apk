package dov.com.qq.im.aeeditor.module.edit;

import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.aeeditor.AEEditorPath.AISCENE.FILES;
import java.io.File;

class AEEditorCommonEditFragment$11
  implements Runnable
{
  AEEditorCommonEditFragment$11(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new AEEditorCommonEditFragment.11.1(this);
    localHttpNetReq.mReqUrl = "https://downv6.qq.com/shadow_qqcamera/ProcessAnimation_b9f8fc550f1535b445b564bfbe0d82c5.zip";
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File(AEEditorPath.AISCENE.FILES.e).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mExcuteTimeLimit = 30000L;
    try
    {
      ((IHttpEngineService)this.this$0.getActivity().getAppInterface().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.11
 * JD-Core Version:    0.7.0.1
 */