package com.tencent.mobileqq.emosm.api.impl;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class FavroamingManagerServiceImpl$6
  extends EmotionJsonDownloadListener
{
  FavroamingManagerServiceImpl$6(FavroamingManagerServiceImpl paramFavroamingManagerServiceImpl) {}
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (!this.a.downMap.containsKey(paramEmoticonPackage.epId)) {
      return;
    }
    Object localObject1 = (IEmojiManagerService)FavroamingManagerServiceImpl.access$1300(this.a).getRuntimeService(IEmojiManagerService.class);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onJsonComplete, start download fav emoticon: ");
        ((StringBuilder)localObject2).append(paramEmoticonPackage.epId);
        QLog.d("FavroamingManager", 2, ((StringBuilder)localObject2).toString());
      }
      paramInt = paramBundle.getInt("jsonType", EmojiManagerServiceConstant.JSON_EMOSM_MALL);
      paramBundle = new File(EmotionPanelConstans.emoticonJsonFilePath.replace("[epId]", paramEmoticonPackage.epId));
      Object localObject2 = new ArrayList();
      ReqInfo localReqInfo = new ReqInfo();
      if (paramBundle.exists()) {
        paramBundle = FileUtils.fileToBytes(paramBundle);
      } else {
        paramBundle = null;
      }
      paramBundle = EmotionJsonUtils.parseJson(FavroamingManagerServiceImpl.access$1400(this.a), paramEmoticonPackage, paramInt, paramBundle, (ArrayList)localObject2, localReqInfo);
      if (paramBundle != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parse Json Error:");
          ((StringBuilder)localObject1).append(paramBundle);
          QLog.d("FavroamingManager", 2, ((StringBuilder)localObject1).toString());
        }
        VasReportUtils.a("emotionType", "emotionActionFav", "2", paramEmoticonPackage.epId, "", "", paramBundle, "", "", "");
        return;
      }
      this.a.fetchEmoticonEncryptKeys(paramEmoticonPackage, (IEmojiManagerService)localObject1, (ArrayList)localObject2, localReqInfo);
      this.a.onJsonCompleteSuccess(paramEmoticonPackage, (IEmojiManagerService)localObject1);
      return;
    }
    this.a.onJsonCompleteFail(paramEmoticonPackage);
    paramEmoticonPackage = paramEmoticonPackage.epId;
    paramBundle = new StringBuilder();
    paramBundle.append(NetworkUtil.getNetworkType(FavroamingManagerServiceImpl.access$1500(this.a).getApplication()));
    paramBundle.append("");
    paramBundle = paramBundle.toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("");
    VasReportUtils.a("emotionType", "emotionActionFav", "1", paramEmoticonPackage, "", paramBundle, ((StringBuilder)localObject1).toString(), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */