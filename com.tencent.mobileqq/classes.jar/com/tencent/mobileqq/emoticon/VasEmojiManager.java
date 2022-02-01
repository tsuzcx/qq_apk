package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class VasEmojiManager
  implements IVasEmojiManager
{
  public BaseQQAppInterface a;
  public IEmojiManagerService b;
  public ConcurrentHashMap<String, Bundle> c = new ConcurrentHashMap();
  private DownloadListener d = new VasEmojiManager.2(this);
  
  public VasEmojiManager(AppInterface paramAppInterface)
  {
    this.a = ((BaseQQAppInterface)paramAppInterface);
    this.b = ((IEmojiManagerService)this.a.getRuntimeService(IEmojiManagerService.class));
  }
  
  private String a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    File localFile = new File(EmotionPanelConstans.emoticonJsonFilePath.replace("[epId]", paramString1));
    boolean bool;
    if (localFile.exists()) {
      bool = localFile.delete();
    } else {
      bool = true;
    }
    if (!bool) {
      return "delete jsonFile failed.";
    }
    if (!paramFile.renameTo(localFile)) {
      return "rename tmpJsonFile failed.";
    }
    FileUtils.deleteDirectory(paramString2);
    paramFile = new File(paramString2);
    if (paramFile.exists()) {
      return "delete h5magic failed.";
    }
    if (!new File(paramString3).renameTo(paramFile)) {
      return "rename tmpUnzipPath failed.";
    }
    a().generateFileList(paramString1, paramString2);
    return null;
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, boolean paramBoolean, Bundle paramBundle)
  {
    IEmojiManagerService localIEmojiManagerService = a();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramBundle.putSerializable("emoticonList", paramArrayList);
    localIEmojiManagerService.addThumbTask(localArrayList, localHashMap, paramEmoticonPackage, paramBundle);
    int i = localIEmojiManagerService.addEmotionTaskByList(paramEmoticonPackage, paramArrayList, localArrayList, localHashMap, paramBundle, 6);
    if (i != 0)
    {
      paramEmoticonPackage = new StringBuilder();
      paramEmoticonPackage.append("downloadOthers error : ");
      paramEmoticonPackage.append(i);
      QLog.e("VasEmojiManager", 1, paramEmoticonPackage.toString());
      return;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("vipEmoticonKey_");
    paramArrayList.append(paramEmoticonPackage.epId);
    paramArrayList = new DownloadTask(localArrayList, localHashMap, paramArrayList.toString());
    paramArrayList.J = true;
    if (localArrayList.size() == 0)
    {
      paramArrayList.a(paramBundle);
      paramArrayList.a(3);
      this.d.onDone(paramArrayList);
    }
    else
    {
      localIEmojiManagerService.getDownloader().startDownload(paramArrayList, this.d, paramBundle);
    }
    localIEmojiManagerService.addH5MagicChildDownloadTask(paramEmoticonPackage, paramBoolean);
  }
  
  private boolean a(String paramString, Bundle paramBundle, EmoticonPackage paramEmoticonPackage)
  {
    for (;;)
    {
      try
      {
        bool = paramBundle.getBoolean("newPkgAdd");
        str1 = paramEmoticonPackage.epId;
      }
      finally
      {
        boolean bool;
        String str1;
        String str2;
        Object localObject2;
        String str3;
        ReqInfo localReqInfo;
        File localFile;
        BaseQQAppInterface localBaseQQAppInterface;
        int i;
        continue;
        throw paramString;
        continue;
        Object localObject1 = null;
        continue;
        continue;
      }
      try
      {
        str2 = EmotionPanelConstans.H5MagicRootPath.replace("[epId]", str1);
        localObject1 = str2.replace("h5magic", "tmp_unzip");
        FileUtils.uncompressZip(paramString, (String)localObject1, false);
        paramString = new StringBuilder();
        paramString.append((String)localObject1);
        paramString.append("h5.zip");
        paramString = paramString.toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("h5magic");
        str3 = ((StringBuilder)localObject2).toString();
        if (!new File(paramString).exists())
        {
          QLog.e("VasEmojiManager", 1, "h5.zip is not exist");
          return false;
        }
        FileUtils.uncompressZip(paramString, str3, false);
        localObject2 = new ArrayList();
        localReqInfo = new ReqInfo();
        paramString = new StringBuilder();
        paramString.append((String)localObject1);
        paramString.append(str1);
        paramString.append("_android.json");
        localFile = new File(paramString.toString());
        try
        {
          if (!localFile.exists()) {
            continue;
          }
          localObject1 = FileUtils.fileToBytes(localFile);
        }
        catch (OutOfMemoryError paramString)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("OutOfMemoryError e = ");
          ((StringBuilder)localObject1).append(paramString.getMessage());
          QLog.e("VasEmojiManager", 1, ((StringBuilder)localObject1).toString());
          continue;
        }
        localBaseQQAppInterface = this.a;
        i = EmojiManagerServiceConstant.JSON_EMOSM_MALL;
        paramString = (String)localObject2;
        localObject1 = EmotionJsonUtils.parseJson(localBaseQQAppInterface, paramEmoticonPackage, i, (byte[])localObject1, (ArrayList)localObject2, localReqInfo);
        if (localObject1 != null)
        {
          paramString = new StringBuilder();
          paramString.append("parseJsonError: ");
          paramString.append((String)localObject1);
          QLog.e("VasEmojiManager", 1, paramString.toString());
          return false;
        }
        if (paramEmoticonPackage.jobType != 5)
        {
          paramString = new StringBuilder();
          paramString.append("not support jobType: ");
          paramString.append(paramEmoticonPackage.jobType);
          QLog.e("VasEmojiManager", 1, paramString.toString());
          return false;
        }
        localObject1 = a();
        if ((!localReqInfo.encryptKeysSuccess) && (paramEmoticonPackage.jobType != 4))
        {
          i = 0;
          localReqInfo.strGetKeySeq = null;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("addEmoticonsTask| fetchEncryptKeys count=");
            ((StringBuilder)localObject2).append(i);
            QLog.d("VasEmojiManager", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = paramEmoticonPackage.epId;
          ((IEmojiManagerService)localObject1).fetchEmoticonEncryptKeys((String)localObject2, paramString, localReqInfo);
          i += 1;
          if (!localReqInfo.encryptKeysSuccess) {
            if (i < 3) {
              continue;
            }
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("addEmoticonsTask| fetchEncryptKeys count=");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(" encryptKeysSuccess=");
            ((StringBuilder)localObject1).append(localReqInfo.encryptKeysSuccess);
            QLog.d("VasEmojiManager", 2, ((StringBuilder)localObject1).toString());
          }
          if (!localReqInfo.encryptKeysSuccess)
          {
            paramString = new StringBuilder();
            paramString.append("addEmoticonsTask| fetchEncryptKeys fail epId=");
            paramString.append(paramEmoticonPackage.epId);
            paramString.append(" encryptGetKeySeq=");
            paramString.append(localReqInfo.strGetKeySeq);
            paramString.append(" encryptKeysResultCode");
            paramString.append(localReqInfo.encryptKeysResultCode);
            QLog.e("VasEmojiManager", 1, paramString.toString());
            return false;
          }
        }
        localObject1 = a(str1, str2, str3, localFile);
        if (localObject1 != null)
        {
          paramString = new StringBuilder();
          paramString.append("moveFiles error: ");
          paramString.append((String)localObject1);
          QLog.e("VasEmojiManager", 1, paramString.toString());
          return false;
        }
        a(paramEmoticonPackage, paramString, bool, paramBundle);
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("VasEmojiManager", 1, "", paramString);
        return false;
      }
    }
  }
  
  public IEmojiManagerService a()
  {
    return this.b;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bqmall.android.h5magic.");
    ((StringBuilder)localObject).append(paramEmoticonPackage.epId);
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    if (this.c.contains(paramEmoticonPackage.epId)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    localBundle.putBoolean("newPkgAdd", paramBoolean1);
    localBundle.putBoolean("wifiAutoDownload", paramBoolean2);
    localBundle.putBoolean("isUpdate", EmoticonPanelUtils.a(paramEmoticonPackage));
    localBundle.putLong("vas_download_start", System.currentTimeMillis());
    this.c.put(paramEmoticonPackage.epId, localBundle);
    a().getStatusMap().put(paramEmoticonPackage.epId, new TaskStatus(paramEmoticonPackage.epId, null));
    ThreadManager.post(new VasEmojiManager.1(this, (String)localObject, paramEmoticonPackage), 5, null, true);
  }
  
  public void complete(String paramString, int paramInt)
  {
    if (paramInt != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("complete error: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.e("VasEmojiManager", 1, ((StringBuilder)localObject1).toString());
    }
    String str = VasEmojiManagerContstant.getEpId(paramString);
    Object localObject2 = (Bundle)this.c.remove(str);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new Bundle();
      EmoticonPackage localEmoticonPackage = ((IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(str);
      localObject1 = localEmoticonPackage;
      if (localEmoticonPackage == null)
      {
        localObject1 = new EmoticonPackage();
        ((EmoticonPackage)localObject1).name = HardCodeUtil.a(2131897795);
        ((EmoticonPackage)localObject1).epId = str;
        ((EmoticonPackage)localObject1).jobType = 5;
        ((EmoticonPackage)localObject1).type = 1;
        ((EmoticonPackage)localObject1).aio = true;
        ((EmoticonPackage)localObject1).isMagicFaceDownloading = true;
      }
      ((Bundle)localObject2).putSerializable("emoticonPackage", (Serializable)localObject1);
      ((Bundle)localObject2).putBoolean("newPkgAdd", false);
      ((Bundle)localObject2).putBoolean("wifiAutoDownload", false);
      ((Bundle)localObject2).putBoolean("isUpdate", EmoticonPanelUtils.a((EmoticonPackage)localObject1));
      ((Bundle)localObject2).putLong("vas_download_start", System.currentTimeMillis());
      localObject1 = localObject2;
    }
    localObject2 = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
    if ((paramInt != 0) || (!a(VasEmojiManagerContstant.getSavePath(paramString), (Bundle)localObject1, (EmoticonPackage)localObject2))) {
      ((IEmojiManagerService)this.a.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().notifyPackageFail((EmoticonPackage)localObject2, paramInt, 8, this.a);
    }
    a().getStatusMap().remove(str);
  }
  
  public ConcurrentHashMap<String, Bundle> getParamMap()
  {
    return this.c;
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    paramString = VasEmojiManagerContstant.getEpId(paramString);
    TaskStatus localTaskStatus = (TaskStatus)a().getStatusMap().get(paramString);
    if (localTaskStatus != null) {
      localTaskStatus.setPercent((float)paramLong1 * 100.0F / (float)paramLong2);
    }
    paramString = (Bundle)this.c.get(paramString);
    if (paramString != null)
    {
      paramString = (EmoticonPackage)paramString.getSerializable("emoticonPackage");
      ((IEmojiManagerService)this.a.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().notifyPackageProgress(paramString, (int)paramLong1, (int)paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.VasEmojiManager
 * JD-Core Version:    0.7.0.1
 */