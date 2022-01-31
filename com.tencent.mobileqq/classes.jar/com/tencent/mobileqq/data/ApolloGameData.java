package com.tencent.mobileqq.data;

import akjd;
import aleh;
import android.text.TextUtils;
import awbv;
import awdg;
import awdj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloGameData
  extends awbv
  implements Serializable
{
  public static final String TAG = "ApolloGameData";
  private static final long serialVersionUID = 1L;
  public int actionId;
  public long appId;
  public String developerName;
  public String gameAppPkgName;
  public String gameAppid;
  @awdj
  public int gameId;
  public int hasOwnArk;
  public boolean isFeatured;
  public boolean isGameApp;
  @awdg
  public boolean isSetting;
  public int isShow;
  @awdg
  public long lastRequestOpenKey;
  public String listCoverUrl;
  public String logoUrl;
  public String maxVer;
  public String minVer;
  public String name;
  public int needOpenKey;
  public String officialAccountUin;
  @awdg
  public String openKey;
  public int screenMode;
  @awdg
  public int tagType;
  @awdg
  public String tagUrl;
  public String toolUrl;
  @awdg
  public int type;
  public int viewMode;
  
  private ArrayList<akjd> parseBtnInfo(String paramString, QQAppInterface paramQQAppInterface)
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
        paramQQAppInterface = (aleh)paramQQAppInterface.getManager(155);
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
        akjd localakjd;
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
          localakjd = new akjd();
          localakjd.jdField_a_of_type_Int = paramQQAppInterface.optInt("src");
          localakjd.jdField_b_of_type_Int = paramQQAppInterface.optInt("mode");
          localakjd.jdField_a_of_type_JavaLangString = paramQQAppInterface.optString("normalBkgUrl");
          localakjd.jdField_b_of_type_JavaLangString = paramQQAppInterface.optString("playingUrl");
          localArrayList.add(localakjd);
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