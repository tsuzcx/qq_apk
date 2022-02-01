package com.tencent.mobileqq.emosm.favroaming;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class FavroamingManager$6
  extends EmotionJsonDownloadListener
{
  FavroamingManager$6(FavroamingManager paramFavroamingManager) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (!this.a.a.containsKey(paramEmoticonPackage.epId)) {
      return;
    }
    EmojiManager localEmojiManager = (EmojiManager)FavroamingManager.l(this.a).getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onJsonComplete, start download fav emoticon: " + paramEmoticonPackage.epId);
      }
      paramInt = paramBundle.getInt("jsonType", EmojiManager.c);
      paramBundle = new File(EmoticonUtils.emoticonJsonFilePath.replace("[epId]", paramEmoticonPackage.epId));
      ArrayList localArrayList = new ArrayList();
      ReqInfo localReqInfo = new ReqInfo();
      if (paramBundle.exists()) {}
      for (paramBundle = FileUtils.a(paramBundle);; paramBundle = null)
      {
        paramBundle = EmotionJsonUtils.a(FavroamingManager.m(this.a), paramEmoticonPackage, paramInt, paramBundle, localArrayList, localReqInfo);
        if (paramBundle == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "parse Json Error:" + paramBundle);
        }
        VasReportUtils.a("emotionType", "emotionActionFav", "2", paramEmoticonPackage.epId, "", "", paramBundle, "", "", "");
        return;
      }
      this.a.a(paramEmoticonPackage, localEmojiManager, localArrayList, localReqInfo);
      this.a.a(paramEmoticonPackage, localEmojiManager);
      return;
    }
    this.a.a(paramEmoticonPackage);
    VasReportUtils.a("emotionType", "emotionActionFav", "1", paramEmoticonPackage.epId, "", NetworkUtil.b(FavroamingManager.n(this.a).getApplication()) + "", paramInt + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.6
 * JD-Core Version:    0.7.0.1
 */