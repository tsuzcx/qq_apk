package com.tencent.mobileqq.gameparty;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_StartGameMessage;

class GamePartyManager$3
  implements GamePartyManager.AsyncRequestCallback
{
  GamePartyManager$3(GamePartyManager paramGamePartyManager, long paramLong1, SubMsgType0xaa.GameTeam_StartGameMessage paramGameTeam_StartGameMessage, long paramLong2, boolean paramBoolean) {}
  
  public void a(String paramString)
  {
    localQQAppInterface = (QQAppInterface)GamePartyManager.a(this.e).get();
    if (localQQAppInterface == null) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("result").getJSONArray("team_list");
      if (paramString.length() > 0)
      {
        i = 0;
        paramString = paramString.getJSONObject(0);
      }
    }
    catch (JSONException paramString)
    {
      int i;
      int j;
      label64:
      StringBuilder localStringBuilder;
      boolean bool;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handlePushMsg_StartGame, getTeamContext finished, parse json error e = ");
        localStringBuilder.append(paramString);
        QLog.d("GamePartyManager", 2, localStringBuilder.toString());
      }
      if (this.d)
      {
        ReportCenter.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2044", "1", false);
        return;
      }
      ReportCenter.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2043", "1", false);
      return;
    }
    try
    {
      j = paramString.getInt("expire");
      i = j;
    }
    catch (JSONException localJSONException)
    {
      break label64;
    }
    j = i;
    if (i <= 0) {
      j = GamePartyManager.a;
    }
    i = paramString.getInt("status");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlePushMsg_StartGame, getTeamContext finished, deltaTime = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", expire = ");
      localStringBuilder.append(j);
      localStringBuilder.append(", status = ");
      localStringBuilder.append(i);
      QLog.d("GamePartyManager", 2, localStringBuilder.toString());
    }
    if (this.a < j)
    {
      paramString = paramString.getJSONObject("leader");
      bool = localQQAppInterface.getCurrentAccountUin().equals(paramString.getString("uin"));
      if ((i > 0) && (i < 5))
      {
        paramString = new Intent(localQQAppInterface.getApp().getApplicationContext(), PromptDialogActivity.class);
        paramString.addFlags(268435456);
        paramString.putExtra("title", this.b.str_title.get());
        paramString.putExtra("summary", this.b.str_summary.get());
        paramString.putExtra("picUrl", this.b.str_picUrl.get());
        paramString.putExtra("appid", this.b.str_appid.get());
        paramString.putExtra("packageName", this.b.str_packageName.get());
        paramString.putExtra("gamedata", this.b.str_gamedata.get());
        paramString.putExtra("leader", bool);
        paramString.putExtra("createMsgTime", this.c);
        localQQAppInterface.getApp().startActivity(paramString);
        if (this.d)
        {
          ReportCenter.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2044", "0", false);
          return;
        }
        ReportCenter.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2043", "0", false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gameparty.GamePartyManager.3
 * JD-Core Version:    0.7.0.1
 */