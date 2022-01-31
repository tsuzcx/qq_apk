package com.tencent.mobileqq.data;

import aifb;
import aiyu;
import android.text.TextUtils;
import atmo;
import atnz;
import atoc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloGameData
  extends atmo
  implements Serializable
{
  public static final String TAG = "ApolloGameData";
  private static final long serialVersionUID = 1L;
  public int actionId;
  public long appId;
  public String developerName;
  public String gameAppPkgName;
  public String gameAppid;
  @atoc
  public int gameId;
  public int hasOwnArk;
  public boolean isFeatured;
  public boolean isGameApp;
  @atnz
  public boolean isSetting;
  public int isShow;
  @atnz
  public long lastRequestOpenKey;
  public String listCoverUrl;
  public String logoUrl;
  public String maxVer;
  public String minVer;
  public String name;
  public int needOpenKey;
  public String officialAccountUin;
  @atnz
  public String openKey;
  public int screenMode;
  @atnz
  public int tagType;
  @atnz
  public String tagUrl;
  public String toolUrl;
  @atnz
  public int type;
  public int viewMode;
  
  private ArrayList<aifb> parseBtnInfo(String paramString, QQAppInterface paramQQAppInterface)
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
        paramQQAppInterface = (aiyu)paramQQAppInterface.getManager(155);
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
        aifb localaifb;
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
          localaifb = new aifb();
          localaifb.jdField_a_of_type_Int = paramQQAppInterface.optInt("src");
          localaifb.jdField_b_of_type_Int = paramQQAppInterface.optInt("mode");
          localaifb.jdField_a_of_type_JavaLangString = paramQQAppInterface.optString("normalBkgUrl");
          localaifb.jdField_b_of_type_JavaLangString = paramQQAppInterface.optString("playingUrl");
          localArrayList.add(localaifb);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloGameData
 * JD-Core Version:    0.7.0.1
 */