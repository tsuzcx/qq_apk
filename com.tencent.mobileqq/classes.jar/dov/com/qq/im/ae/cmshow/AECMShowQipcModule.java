package dov.com.qq.im.ae.cmshow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.cmshow.config.AECMShowConfigManager;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AEQLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AECMShowQipcModule
  extends QIPCModule
{
  private List<AEResInfo> a = new ArrayList();
  
  private AECMShowQipcModule(String paramString)
  {
    super(paramString);
    this.a.add(AEResInfo.b);
    this.a.add(AEResInfo.c);
    this.a.add(AEResInfo.j);
    this.a.add(AEResInfo.k);
  }
  
  public static AECMShowQipcModule a()
  {
    return AECMShowQipcModule.InstanceHolder.a;
  }
  
  private void a(int paramInt)
  {
    QLog.d("AECMShowQipcModule", 1, " handleDownloadAERes ");
    AECMShowQipcModule.CmShowAEDownloadCallBack localCmShowAEDownloadCallBack = new AECMShowQipcModule.CmShowAEDownloadCallBack(this, paramInt);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      AEResInfo localAEResInfo = (AEResInfo)localIterator.next();
      if (AEResUtil.b(localAEResInfo))
      {
        AEQLog.b("AECMShowQipcModule", "[handleDownloadAERes], resInfo=" + localAEResInfo + " local file exists");
        localCmShowAEDownloadCallBack.onAEDownloadFinish(localAEResInfo, "", true, 0);
      }
      else
      {
        AEQLog.b("AECMShowQipcModule", "[handleDownloadAERes], resInfo=" + localAEResInfo + " start download");
        AEResManager.a().a(localAEResInfo, localCmShowAEDownloadCallBack, false);
      }
    }
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("key_resource_id_list"))) {}
    for (paramBundle = paramBundle.getStringArrayList("key_resource_id_list");; paramBundle = null)
    {
      if (CollectionUtils.isEmpty(paramBundle))
      {
        callbackResult(paramInt, EIPCResult.createResult(-102, null));
        return;
      }
      AECMShowResourceManager.a().a(paramBundle, new AECMShowQipcModule.2(this, paramInt));
      return;
    }
  }
  
  public static void a(@Nullable EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("AECMShowQipcModule", "action_download_ae_res", null, paramEIPCResultCallback);
  }
  
  public static void a(@NonNull ArrayList<String> paramArrayList, @Nullable AECMShowResourceManager.CMJoyEssentialDownloadCallback paramCMJoyEssentialDownloadCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("key_resource_id_list", paramArrayList);
    QIPCClientHelper.getInstance().callServer("AECMShowQipcModule", "action_download_essential_resource", localBundle, new AECMShowQipcModule.1(paramCMJoyEssentialDownloadCallback));
  }
  
  private void b(int paramInt)
  {
    int i = AECMShowConfigManager.a().a();
    int j = AECMShowConfigManager.a().b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_CMSHOW_IMG_MAX_LENGTH", Integer.valueOf(i));
    localHashMap.put("KEY_CMSHOW_IMG_QUALITY", Integer.valueOf(j));
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_request_image_param", localHashMap);
    callbackResult(paramInt, EIPCResult.createSuccessResult(localBundle));
  }
  
  public static void b(@Nullable EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("AECMShowQipcModule", "action_get_request_image_param", null, paramEIPCResultCallback);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_download_essential_resource".equals(paramString)) {
      a(paramBundle, paramInt);
    }
    for (;;)
    {
      return null;
      if ("action_download_ae_res".equals(paramString)) {
        a(paramInt);
      } else if ("action_get_request_image_param".equals(paramString)) {
        b(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowQipcModule
 * JD-Core Version:    0.7.0.1
 */