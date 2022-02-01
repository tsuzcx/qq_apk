package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class AIOEmotionFragment$EmoticonDetailJsonDownloader
  extends EmotionJsonDownloadListener
{
  private int b;
  private Context c;
  private IPicEmoticonInfo d;
  private QQAppInterface e;
  private SessionInfo f;
  private QQProgressDialog g;
  
  public AIOEmotionFragment$EmoticonDetailJsonDownloader(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, IPicEmoticonInfo paramIPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog)
  {
    this.b = paramInt;
    this.e = paramQQAppInterface;
    this.c = paramContext;
    this.d = paramIPicEmoticonInfo;
    this.f = paramSessionInfo;
    this.g = paramQQProgressDialog;
  }
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onJsonComplete:");
      paramBundle.append(paramEmoticonPackage.epId);
      paramBundle.append(" ,currEpid:");
      paramBundle.append(this.d.getEmoticon().epId);
      QLog.d("AIOEmotionFragment", 2, paramBundle.toString());
    }
    int i = this.b;
    if (i == 32)
    {
      boolean bool;
      if ((paramInt == 0) && (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.d.getEmoticon().epId))) {
        bool = true;
      } else {
        bool = false;
      }
      AIOEmotionFragment.a(this.a, bool);
      return;
    }
    if (paramInt == 0)
    {
      if (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.d.getEmoticon().epId)) {
        return;
      }
      this.e.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      MarketFaceItemBuilder.a(this.b, this.c, this.e, paramEmoticonPackage, this.d, this.f, this.g, true);
      paramBundle = this.a.f.obtainMessage(1000);
      paramBundle.obj = paramEmoticonPackage.name;
      this.a.f.sendMessage(paramBundle);
      return;
    }
    MarketFaceItemBuilder.a(1000 + i, this.c, this.e, paramEmoticonPackage, this.d, this.f, this.g, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.EmoticonDetailJsonDownloader
 * JD-Core Version:    0.7.0.1
 */