package com.tencent.mobileqq.data;

import amlz;
import android.text.TextUtils;
import ankc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
  private static final long serialVersionUID = 1L;
  public int actionId;
  public long appId;
  public String developerName;
  public String gameAppPkgName;
  public String gameAppid;
  @unique
  public int gameId;
  public int hasOwnArk;
  public boolean isFeatured;
  public boolean isGameApp;
  @notColumn
  public boolean isSetting;
  public int isShow;
  @notColumn
  public long lastRequestOpenKey;
  public String listCoverUrl;
  public String logoUrl;
  public String maxVer;
  public String minVer;
  public String name;
  public int needOpenKey;
  public String officialAccountUin;
  @notColumn
  public String openKey;
  public int screenMode;
  @notColumn
  public int tagType;
  @notColumn
  public String tagUrl;
  public String toolUrl;
  @notColumn
  public int type;
  public int viewMode;
  
  private ArrayList<amlz> parseBtnInfo(String paramString, QQAppInterface paramQQAppInterface)
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
        paramQQAppInterface = (ankc)paramQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
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
        amlz localamlz;
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
          localamlz = new amlz();
          localamlz.jdField_a_of_type_Int = paramQQAppInterface.optInt("src");
          localamlz.jdField_b_of_type_Int = paramQQAppInterface.optInt("mode");
          localamlz.jdField_a_of_type_JavaLangString = paramQQAppInterface.optString("normalBkgUrl");
          localamlz.jdField_b_of_type_JavaLangString = paramQQAppInterface.optString("playingUrl");
          localArrayList.add(localamlz);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloGameData
 * JD-Core Version:    0.7.0.1
 */