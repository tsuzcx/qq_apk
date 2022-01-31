package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloGameBtnData;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloGameData
  extends Entity
  implements Serializable
{
  public static final String TAG = "ApolloGameData";
  public String actUrl;
  public int actionId;
  public long appId;
  public String bigCoverBgColor;
  public String bigCoverUrl;
  public String developerName;
  public String developerUrl;
  public String gameBtns;
  @unique
  public int gameId;
  public int hasOwnArk;
  public String homeButtonAction;
  public String hotChatBtns;
  public String hotChatCode;
  public boolean isFeatured;
  @notColumn
  public boolean isSetting;
  public int isShow;
  public int isSupportStandBy;
  @notColumn
  public long lastRequestOpenKey;
  public String listCoverUrl;
  public String logoUrl;
  public String maxVer;
  public String minVer;
  public String name;
  public int needOpenKey;
  public String officialAccountHead;
  public String officialAccountUin;
  @notColumn
  public String openKey;
  public int screenMode;
  public String toolUrl;
  @notColumn
  public int type;
  public int viewMode;
  
  private ArrayList parseBtnInfo(String paramString, QQAppInterface paramQQAppInterface)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return localArrayList;
    }
    for (;;)
    {
      int i;
      try
      {
        paramQQAppInterface = (ApolloDaoManager)paramQQAppInterface.getManager(154);
        paramString = new JSONArray(paramString);
        if ((paramQQAppInterface == null) || (paramString == null)) {
          break label203;
        }
        if (paramString.length() != 0) {
          break label206;
        }
      }
      catch (Exception paramString)
      {
        ApolloGameBtnData localApolloGameBtnData;
        QLog.e("ApolloGameData", 1, paramString, new Object[0]);
        long l2 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloGameData", 2, new Object[] { "[parseBtnInfo], costT:", Long.valueOf(l2 - l1) });
        return localArrayList;
      }
      if (i < paramString.length())
      {
        paramQQAppInterface = paramString.optJSONObject(i);
        if (paramQQAppInterface != null)
        {
          localApolloGameBtnData = new ApolloGameBtnData();
          localApolloGameBtnData.jdField_a_of_type_Int = paramQQAppInterface.optInt("src");
          localApolloGameBtnData.jdField_b_of_type_Int = paramQQAppInterface.optInt("mode");
          localApolloGameBtnData.jdField_a_of_type_JavaLangString = paramQQAppInterface.optString("normalBkgUrl");
          localApolloGameBtnData.jdField_b_of_type_JavaLangString = paramQQAppInterface.optString("playingUrl");
          localArrayList.add(localApolloGameBtnData);
        }
      }
      else
      {
        label203:
        return localArrayList;
        label206:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public ArrayList getGameBtnInfo(QQAppInterface paramQQAppInterface)
  {
    return parseBtnInfo(this.gameBtns, paramQQAppInterface);
  }
  
  public ApolloGameBtnData getHomeActionBtn(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(this.homeButtonAction))) {}
    do
    {
      return null;
      QLog.e("ApolloGameData", 1, "[getHomeActionBtnInfo] invalid para");
      paramQQAppInterface = parseBtnInfo(this.homeButtonAction, paramQQAppInterface);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0));
    return (ApolloGameBtnData)paramQQAppInterface.get(0);
  }
  
  public ArrayList getHotChatBtnInfo(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.hotChatBtns)) || ("{}".equals(this.hotChatBtns)) || ("[]".equals(this.hotChatBtns))) {
      return parseBtnInfo(this.gameBtns, paramQQAppInterface);
    }
    return parseBtnInfo(this.hotChatBtns, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloGameData
 * JD-Core Version:    0.7.0.1
 */