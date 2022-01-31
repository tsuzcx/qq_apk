package com.tencent.mobileqq.data;

import akhp;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageForApollo
  extends ChatMessage
{
  public static final int FAKE_MSG_ACTION_ID = 99999;
  public static final String RESERVE_JSON_KEY_3D_MESSAGE = "mApollo3DMessage";
  public static final String RESERVE_JSON_KEY_ACTION_TYPE = "actionType";
  public static final String RESERVE_JSON_KEY_ARK = "arkInfo";
  public static final String RESERVE_JSON_KEY_AUDIOID = "audioID";
  public static final String RESERVE_JSON_KEY_AUDIO_START_TIME = "audioStartTime";
  public static final String RESERVE_JSON_KEY_COMMINFO = "commInfo";
  public static final String RESERVE_JSON_KEY_EXTEND_JSON = "extendJson";
  public static final String RESERVE_JSON_KEY_GAMEID = "gameId";
  public static final String RESERVE_JSON_KEY_GAMEMODE = "gameMode";
  public static final String RESERVE_JSON_KEY_GAMENAME = "gameName";
  public static final String RESERVE_JSON_KEY_GAMESTATUS = "gameStatus";
  public static final String RESERVE_JSON_KEY_GAMESTATUS_STAMP = "gmUpdateStamp";
  public static final String RESERVE_JSON_KEY_GAME_EXTEND_JSON = "gameExtendJson";
  public static final String RESERVE_JSON_KEY_INPUTTEXT = "inputText";
  public static final String RESERVE_JSON_KEY_MSGTYPE = "msgTyep";
  public static final String RESERVE_JSON_KEY_OVER_TYPE = "gameOverType";
  public static final String RESERVE_JSON_KEY_PLAYERLIST = "playerList";
  public static final String RESERVE_JSON_KEY_ROOMID = "roomid";
  public static final String RESERVE_JSON_KEY_ROOMVOL = "roomVol";
  public static final String RESERVE_JSON_KEY_WINNERLIST = "winnerList";
  public static final String RESERVE_JSON_KEY_WINRECORD = "winRecord";
  public static final String RESERVE_JSON_KEY_WINUIN = "winUin";
  private static final String TAG = "MessageForApollo";
  public int actionType;
  public int audioId;
  public float audioStartTime = 0.0F;
  public String commInfo;
  public String extendJson;
  public String gameArkInfo;
  public String gameExtendJson;
  public int gameId;
  public String gameName;
  public int gameStatus;
  public long gameStatusStamp;
  public boolean hasPlayed;
  public String inputText;
  public int isPlayDefaultAudio;
  public Apollo3DMessage mApollo3DMessage;
  public MessageForArkApp mApolloGameArkMsg;
  public ApolloMessage mApolloMessage;
  public int mGameMode;
  public int msgType;
  public int overType;
  public List<Long> playerList = new ArrayList();
  public long roomId;
  public int roomVol;
  public long signTs;
  public String winRecord;
  public List<Long> winnerList = new ArrayList();
  public long winnerUin;
  
  protected void doParse()
  {
    try
    {
      this.mApolloMessage = ((ApolloMessage)akhp.a(this.msgData));
      this.hasPlayed = this.mApolloMessage.isPlayed;
      this.msg = ApolloUtil.a(this);
      if (!TextUtils.isEmpty(this.mApolloMessage.extStr))
      {
        JSONObject localJSONObject = new JSONObject(this.mApolloMessage.extStr);
        this.inputText = localJSONObject.optString("inputText");
        this.audioId = localJSONObject.optInt("audioID");
        if (localJSONObject.has("audioStartTime")) {
          this.audioStartTime = ((float)localJSONObject.getDouble("audioStartTime"));
        }
        this.msgType = localJSONObject.optInt("msgTyep");
        this.gameId = localJSONObject.optInt("gameId");
        this.mGameMode = localJSONObject.optInt("gameMode");
        this.roomId = localJSONObject.optLong("roomid");
        this.gameStatus = localJSONObject.optInt("gameStatus");
        this.roomVol = localJSONObject.optInt("roomVol");
        this.gameStatusStamp = localJSONObject.optLong("gmUpdateStamp");
        JSONArray localJSONArray;
        int i;
        if (localJSONObject.has("playerList"))
        {
          this.playerList.clear();
          localJSONArray = localJSONObject.getJSONArray("playerList");
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            i = 0;
            while (i < localJSONArray.length())
            {
              this.playerList.add(Long.valueOf(localJSONArray.getLong(i)));
              i += 1;
            }
          }
        }
        if (localJSONObject.has("winnerList"))
        {
          this.winnerList.clear();
          localJSONArray = localJSONObject.getJSONArray("winnerList");
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            i = 0;
            while (i < localJSONArray.length())
            {
              this.winnerList.add(Long.valueOf(localJSONArray.getLong(i)));
              i += 1;
            }
          }
        }
        this.winnerUin = localJSONObject.optLong("winUin");
        this.winRecord = localJSONObject.optString("winRecord");
        this.gameName = localJSONObject.optString("gameName");
        this.extendJson = localJSONObject.optString("extendJson");
        if (this.gameStatus == 0) {
          this.gameStatus = ApolloUtil.a(this.extendJson, "gameStatus");
        }
        this.actionType = localJSONObject.optInt("actionType");
        this.gameArkInfo = localJSONObject.optString("arkInfo");
        this.commInfo = localJSONObject.optString("commInfo");
        this.gameExtendJson = localJSONObject.optString("gameExtendJson");
        this.overType = localJSONObject.optInt("gameOverType");
        localJSONObject = localJSONObject.optJSONObject("mApollo3DMessage");
        if (localJSONObject != null)
        {
          if (this.mApollo3DMessage == null) {
            this.mApollo3DMessage = new Apollo3DMessage();
          }
          this.mApollo3DMessage.setMessageWithJSONObject(localJSONObject);
        }
        printGameStatusInfo();
      }
      if ((TextUtils.isEmpty(this.inputText)) && (this.istroop == 0) && (this.mApolloMessage.text != null)) {
        this.inputText = new String(this.mApolloMessage.text);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.mApolloMessage == null)
      {
        this.mApolloMessage = new ApolloMessage();
        this.mApolloMessage.isPlayed = true;
        this.mApolloMessage.extStr = "{}";
        this.mApolloMessage.id = 99999;
        this.mApolloMessage.name = ApolloUtil.a();
        QLog.e("MessageForApollo", 1, "mApolloMessage == null, make fake Message.");
      }
      if (this.msgData != null) {
        QLog.e("MessageForApollo", 1, " Apollo doParse error, msgData->" + Arrays.toString(this.msgData));
      }
      QLog.e("MessageForApollo", 1, " Apollo doParse error, e->" + localThrowable.getMessage());
    }
  }
  
  public boolean is3dAction()
  {
    return (this.mApollo3DMessage != null) && (ApolloActionData.isAction3DModel(this.mApollo3DMessage.actionID_3D));
  }
  
  public boolean isBarrageMode()
  {
    if (this.mApolloMessage == null) {}
    while (128 != (this.mApolloMessage.flag & 0x80)) {
      return false;
    }
    return true;
  }
  
  public boolean isDoubleAction()
  {
    boolean bool = true;
    if (this.mApolloMessage == null) {
      return false;
    }
    if ((1 == (this.mApolloMessage.flag >> 2 & 0x1)) && (this.mApolloMessage.peer_uin > 0L)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean isHasOwnArk()
  {
    boolean bool = true;
    if (this.mApolloMessage == null) {
      return false;
    }
    if (1 == (this.mApolloMessage.flag >> 8 & 0x1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    if (this.mApolloMessage != null) {}
    try
    {
      this.mApolloMessage.isPlayed = this.hasPlayed;
      this.msgData = akhp.a(this.mApolloMessage);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForApollo", 1, "isSend:" + isSend() + " Apollo prewrite error：" + localException.getMessage());
    }
  }
  
  public void printGameStatusInfo() {}
  
  public void updateGameStatus(MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {
      return;
    }
    this.gameStatus = paramMessageForApollo.gameStatus;
    this.gameStatusStamp = paramMessageForApollo.gameStatusStamp;
    this.mGameMode = paramMessageForApollo.mGameMode;
    this.commInfo = paramMessageForApollo.commInfo;
    this.gameArkInfo = paramMessageForApollo.gameArkInfo;
    this.playerList.clear();
    Object localObject = paramMessageForApollo.playerList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject).next();
      this.playerList.add(localLong);
    }
    this.roomVol = paramMessageForApollo.roomVol;
    switch (this.gameStatus)
    {
    }
    for (;;)
    {
      printGameStatusInfo();
      return;
      this.winnerUin = paramMessageForApollo.winnerUin;
      this.winRecord = paramMessageForApollo.winRecord;
      this.overType = paramMessageForApollo.overType;
      this.winnerList.clear();
      paramMessageForApollo = paramMessageForApollo.winnerList.iterator();
      while (paramMessageForApollo.hasNext())
      {
        localObject = (Long)paramMessageForApollo.next();
        this.winnerList.add(localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForApollo
 * JD-Core Version:    0.7.0.1
 */