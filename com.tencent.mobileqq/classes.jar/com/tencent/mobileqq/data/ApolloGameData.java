package com.tencent.mobileqq.data;

import akns;
import aliw;
import android.text.TextUtils;
import awge;
import awhp;
import awhs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloGameData
  extends awge
  implements Serializable
{
  public static final String TAG = "ApolloGameData";
  private static final long serialVersionUID = 1L;
  public int actionId;
  public long appId;
  public String developerName;
  public String gameAppPkgName;
  public String gameAppid;
  @awhs
  public int gameId;
  public int hasOwnArk;
  public boolean isFeatured;
  public boolean isGameApp;
  @awhp
  public boolean isSetting;
  public int isShow;
  @awhp
  public long lastRequestOpenKey;
  public String listCoverUrl;
  public String logoUrl;
  public String maxVer;
  public String minVer;
  public String name;
  public int needOpenKey;
  public String officialAccountUin;
  @awhp
  public String openKey;
  public int screenMode;
  @awhp
  public int tagType;
  @awhp
  public String tagUrl;
  public String toolUrl;
  @awhp
  public int type;
  public int viewMode;
  
  private ArrayList<akns> parseBtnInfo(String paramString, QQAppInterface paramQQAppInterface)
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
        paramQQAppInterface = (aliw)paramQQAppInterface.getManager(155);
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
        akns localakns;
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
          localakns = new akns();
          localakns.jdField_a_of_type_Int = paramQQAppInterface.optInt("src");
          localakns.jdField_b_of_type_Int = paramQQAppInterface.optInt("mode");
          localakns.jdField_a_of_type_JavaLangString = paramQQAppInterface.optString("normalBkgUrl");
          localakns.jdField_b_of_type_JavaLangString = paramQQAppInterface.optString("playingUrl");
          localArrayList.add(localakns);
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
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ApolloGameData{");
    localStringBuffer.append("gameId=").append(this.gameId).append(",name:").append(this.name).append(",isShow:").append(this.isShow).append(",min:").append(this.minVer).append(",max:").append(this.maxVer).append(",viewMode:").append(this.viewMode);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloGameData
 * JD-Core Version:    0.7.0.1
 */