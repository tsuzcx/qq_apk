package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class GuildMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars
  extends EmotionJsonDownloadListener
{
  private int a;
  private Context b;
  private IPicEmoticonInfo c;
  private QQAppInterface d;
  private SessionInfo e;
  private QQProgressDialog f;
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, IPicEmoticonInfo paramIPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog)
  {
    this.a = paramInt;
    this.d = paramQQAppInterface;
    this.b = paramContext;
    this.c = paramIPicEmoticonInfo;
    this.e = paramSessionInfo;
    this.f = paramQQProgressDialog;
  }
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onJsonComplete:");
      paramBundle.append(paramEmoticonPackage.epId);
      QLog.d("MarketFaceItemBuilder", 2, paramBundle.toString());
    }
    if (paramInt == 0)
    {
      if (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.c.getEmoticon().epId)) {
        return;
      }
      this.d.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      GuildMarketFaceItemBuilder.a(this.a, this.b, this.d, paramEmoticonPackage, this.c, this.e, this.f);
      return;
    }
    GuildMarketFaceItemBuilder.a(this.a + 1000, this.b, this.d, paramEmoticonPackage, this.c, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars
 * JD-Core Version:    0.7.0.1
 */