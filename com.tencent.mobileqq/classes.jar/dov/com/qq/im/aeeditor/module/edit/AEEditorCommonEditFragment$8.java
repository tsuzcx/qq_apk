package dov.com.qq.im.aeeditor.module.edit;

import android.support.v4.app.FragmentActivity;
import bnsp;
import bnxl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AEEditorCommonEditFragment$8
  implements Runnable
{
  AEEditorCommonEditFragment$8(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new bnxl(this);
    localHttpNetReq.mReqUrl = "https://downv6.qq.com/shadow_qqcamera/ProcessAnimation_b9f8fc550f1535b445b564bfbe0d82c5.zip";
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File(bnsp.e).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mExcuteTimeLimit = 30000L;
    try
    {
      this.this$0.getActivity().getAppInterface().getNetEngine(0).sendReq(localHttpNetReq);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.8
 * JD-Core Version:    0.7.0.1
 */