package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.CommercialDrainageManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmotionJsonUtils
{
  public static String a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseSmallJson: parseSmallJson start");
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: app is null");
      }
      return "app is null";
    }
    if (paramEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: ep is null");
      }
      return "ep is null";
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: data is null");
      }
      return "json data is null";
    }
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: params is null");
      }
      return "params is null";
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(13);
    Object localObject1;
    Object localObject2;
    String str1;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "utf-8"));
      long l = paramArrayOfByte.getLong("timestamp");
      paramQQAppInterface = paramArrayOfByte.getJSONObject("data");
      localObject1 = paramQQAppInterface.getJSONArray("baseInfo");
      localObject2 = paramQQAppInterface.getJSONArray("operationInfo");
      if ((localObject1 == null) || (localObject2 == null)) {
        break label1014;
      }
      localObject1 = (JSONObject)((JSONArray)localObject1).get(0);
      localObject2 = (JSONObject)((JSONArray)localObject2).get(0);
      str1 = ((JSONObject)localObject1).getString("name");
      paramEmoticonPackage.isAPNG = (((JSONObject)localObject1).optInt("isAPNG", 0) + 1);
      if (paramEmoticonPackage.isAPNG == 2) {
        paramEmoticonPackage.rscType = 2;
      }
      j = paramEmoticonPackage.extraFlags & 0x1;
      if (!((JSONObject)localObject1).has("isOriginal")) {
        break label1008;
      }
      i = ((JSONObject)localObject1).getInt("isOriginal");
      if (j != 0) {
        break label638;
      }
      paramEmoticonPackage.extraFlags |= i;
      label279:
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson original = " + i + ", ep.extraFlags = " + paramEmoticonPackage.extraFlags);
      }
      j = 0;
      i = 6;
      if (paramArrayOfByte.has("type")) {
        i = paramArrayOfByte.getInt("type");
      }
      if (((JSONObject)localObject2).has("feeType")) {
        j = ((JSONObject)localObject2).getInt("feeType");
      }
      paramEmoticonPackage.localVersion = ((int)(l / 1000L));
      paramEmoticonPackage.name = str1;
      paramEmoticonPackage.mark = "";
      paramEmoticonPackage.type = i;
      paramEmoticonPackage.mobileFeetype = j;
      paramEmoticonPackage.jobType = 4;
      if ((paramEmoticonPackage.mobileFeetype != 1) && ((paramEmoticonPackage.epId == null) || (!"10278".equals(paramEmoticonPackage.epId)))) {
        break label709;
      }
      paramEmoticonPackage.wordingId = 1L;
    }
    catch (JSONException paramQQAppInterface)
    {
      for (;;)
      {
        int m;
        paramQQAppInterface.printStackTrace();
        paramArrayOfByte = paramQQAppInterface.toString();
        QLog.e("EmotionJsonUtils", 1, "parseSmallJson: fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
        return paramArrayOfByte;
        paramArrayOfByte = localEmoticonManager.b(paramEmoticonPackage.epId);
        if (paramArrayOfByte == null) {
          break;
        }
        paramEmoticonPackage.wordingId = paramArrayOfByte.wordingId;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("EmotionJsonUtils", 1, "parseSmallJson: fail OutOfMemoryError  exception=" + paramQQAppInterface.toString());
        return null;
        paramEmoticonPackage.wordingId = -1L;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label494:
      label638:
      paramQQAppInterface.printStackTrace();
      label709:
      paramArrayOfByte = paramQQAppInterface.toString();
      QLog.e("EmotionJsonUtils", 1, "parseSmallJson: fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
      return paramArrayOfByte;
    }
    localEmoticonManager.a(paramEmoticonPackage);
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseSmallJson: ep = " + paramEmoticonPackage);
    }
    paramArrayOfByte = paramQQAppInterface.getJSONArray("itemInfo");
    m = paramArrayOfByte.length();
    int i = 1;
    int j = 0;
    String str2;
    if (j < m)
    {
      paramQQAppInterface = paramArrayOfByte.getJSONObject(j);
      localObject1 = paramQQAppInterface.getString("id");
      localObject2 = paramQQAppInterface.getString("name");
      str2 = paramQQAppInterface.getString("character");
      str1 = paramEmoticonPackage.epId;
      paramQQAppInterface = localEmoticonManager.a(str1, (String)localObject1);
      if (paramQQAppInterface == null)
      {
        if (paramInt == EmojiManager.c) {
          break label1005;
        }
        paramQQAppInterface = new Emoticon();
        paramQQAppInterface.eId = ((String)localObject1);
        paramQQAppInterface.epId = str1;
        paramQQAppInterface.name = ((String)localObject2);
        paramQQAppInterface.character = str2;
        paramQQAppInterface.jobType = 3;
        i = 1;
      }
    }
    for (;;)
    {
      if (paramQQAppInterface == null)
      {
        if (!QLog.isColorLevel()) {
          break label1018;
        }
        QLog.d("EmotionJsonUtils", 2, "emoticon json update, cannot find emoticon from epId: " + str1);
        break label1018;
        if (j <= 0) {
          break label279;
        }
        paramEmoticonPackage.extraFlags &= i;
        break label279;
        if ((((String)localObject1).equals(paramQQAppInterface.eId)) && (str1.equals(paramQQAppInterface.epId)) && (((String)localObject2).equals(paramQQAppInterface.name))) {
          break label1033;
        }
        paramQQAppInterface.eId = ((String)localObject1);
        paramQQAppInterface.epId = str1;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface.name = ((String)localObject2);
        }
        if (TextUtils.isEmpty(str2)) {
          break label1027;
        }
        paramQQAppInterface.character = str2;
        break label1027;
      }
      int k = 0;
      if (EmoticonUtils.a(paramEmoticonPackage)) {
        k = 1;
      }
      paramQQAppInterface.isSound = paramEmoticonPackage.hasSound;
      paramArrayList.add(paramQQAppInterface);
      if ((i != 0) && (k == 0)) {
        localEmoticonManager.a(paramQQAppInterface);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson :emoticon eId[" + (String)localObject1 + "]eName[" + (String)localObject2 + "]");
        break label1018;
        return null;
        label1005:
        continue;
        label1008:
        i = 0;
        break;
        label1014:
        return "parseSmallJson:json data is error";
      }
      label1018:
      j += 1;
      break label494;
      label1027:
      i = 1;
      continue;
      label1033:
      i = 0;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList paramArrayList, ReqInfo paramReqInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseJson : parseJson start");
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : ap is null");
      }
      return "app is null";
    }
    if (paramEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : ep is null");
      }
      return "ep is null";
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : json data is null");
      }
      return "json data is null";
    }
    if ((paramArrayList == null) || (paramReqInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : params is null");
      }
      return "params is null";
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(13);
    String str1;
    Object localObject1;
    Object localObject5;
    int i;
    Object localObject2;
    Object localObject4;
    String str2;
    int k;
    int j;
    label388:
    label473:
    label490:
    label509:
    int m;
    label528:
    int n;
    label547:
    boolean bool;
    label583:
    int i1;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "utf-8"));
      str1 = paramArrayOfByte.getString("id");
      localObject1 = paramArrayOfByte.getString("name");
      localObject5 = paramArrayOfByte.optJSONObject("diversionConfig");
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 1, "diversionConfig = " + localObject5);
      }
      if (localObject5 != null)
      {
        i = ((JSONObject)localObject5).optInt("diversionType");
        paramQQAppInterface = ((JSONObject)localObject5).optString("diversionName");
        localObject2 = ((JSONObject)localObject5).optString("copywriting");
        localObject3 = ((JSONObject)localObject5).optString("jumpUrl");
        localObject4 = ((JSONObject)localObject5).optString("displayImg");
        long l1 = ((JSONObject)localObject5).optLong("beginTime");
        long l2 = ((JSONObject)localObject5).optLong("endTime");
        str2 = ((JSONObject)localObject5).optString("wording");
        localObject5 = ((JSONObject)localObject5).optString("from");
        paramEmoticonPackage.copywritingType = i;
        paramEmoticonPackage.copywritingContent = ((String)localObject2);
        paramEmoticonPackage.jumpUrl = ((String)localObject3);
        paramEmoticonPackage.imageUrl = ((String)localObject4);
        paramEmoticonPackage.diversionName = paramQQAppInterface;
        paramEmoticonPackage.beginTime = l1;
        paramEmoticonPackage.endTime = l2;
        paramEmoticonPackage.buttonWording = str2;
        paramEmoticonPackage.comeFom = ((String)localObject5);
      }
      k = paramEmoticonPackage.extraFlags & 0x1;
      if (!paramArrayOfByte.has("isOriginal")) {
        break label2202;
      }
      i = paramArrayOfByte.getInt("isOriginal");
      if (paramArrayOfByte.optInt("isApng") != 1) {
        break label2221;
      }
      j = 2;
      paramEmoticonPackage.isAPNG = j;
      if (k != 0) {
        break label1507;
      }
      paramEmoticonPackage.extraFlags |= i;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson original = " + i + ", ep.extraFlags = " + paramEmoticonPackage.extraFlags);
      }
      if (!paramArrayOfByte.has("mark")) {
        break label2196;
      }
      paramQQAppInterface = paramArrayOfByte.getString("mark");
      if (!paramArrayOfByte.has("type")) {
        break label2190;
      }
      j = paramArrayOfByte.getInt("type");
      if (!paramArrayOfByte.has("feetype")) {
        break label2184;
      }
      k = paramArrayOfByte.getInt("feetype");
      if (!paramArrayOfByte.has("rscType")) {
        break label2178;
      }
      m = paramArrayOfByte.getInt("rscType");
      if (!paramArrayOfByte.has("updateTime")) {
        break label2172;
      }
      n = paramArrayOfByte.getInt("updateTime");
      if (!paramArrayOfByte.has("ringtype")) {
        break label2163;
      }
      localObject2 = paramArrayOfByte.getString("ringtype");
      if (!"1".equals(localObject2)) {
        break label1579;
      }
      bool = true;
      i = 1;
    }
    catch (JSONException paramQQAppInterface)
    {
      for (;;)
      {
        Object localObject3;
        int i2;
        paramQQAppInterface.printStackTrace();
        paramArrayOfByte = paramQQAppInterface.toString();
        QLog.e("EmotionJsonUtils", 1, "parseJson: PARSE_EMOTICON_JSON fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
        return paramArrayOfByte;
        if ("2".equals(localObject2)) {
          return "qFace are not supported";
        }
        if (!"4".equals(localObject2)) {
          break label2163;
        }
        bool = false;
        i = 4;
        continue;
        if (paramQQAppInterface == null) {
          break;
        }
        paramEmoticonPackage.wordingId = paramQQAppInterface.wordingId;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label601:
      label1129:
      paramQQAppInterface.printStackTrace();
      label834:
      label1507:
      paramArrayOfByte = paramQQAppInterface.toString();
      label1076:
      label1346:
      QLog.d("EmotionJsonUtils", 1, "parseJson: PARSE_EMOTICON_JSON fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
      label1579:
      return paramArrayOfByte;
    }
    if ((paramArrayOfByte.has("type")) && (1 == j))
    {
      i1 = 3;
      i2 = 0;
      if (paramArrayOfByte.has("downloadcount")) {
        i2 = paramArrayOfByte.getInt("downloadcount");
      }
      paramEmoticonPackage.epId = str1;
      paramEmoticonPackage.name = ((String)localObject1);
      paramEmoticonPackage.mark = paramQQAppInterface;
      paramEmoticonPackage.type = j;
      paramEmoticonPackage.mobileFeetype = k;
      paramEmoticonPackage.hasSound = bool;
      paramEmoticonPackage.subType = i;
      paramEmoticonPackage.downloadCount = i2;
      paramEmoticonPackage.jobType = i1;
      if (paramEmoticonPackage.copywritingType != CommercialDrainageManager.a)
      {
        paramEmoticonPackage.extraFlags |= 0x4;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionJsonUtils", 2, "parseJson, ep.extraFlags = " + paramEmoticonPackage.extraFlags);
        }
      }
      if ((paramArrayOfByte.has("type")) && (4 == j)) {
        paramEmoticonPackage.jobType = 5;
      }
      paramEmoticonPackage.rscType = m;
      if (paramInt != EmojiManager.c) {
        paramEmoticonPackage.localVersion = n;
      }
      paramQQAppInterface = localEmoticonManager.b(str1);
      if (paramQQAppInterface != null)
      {
        paramEmoticonPackage.status = paramQQAppInterface.status;
        paramEmoticonPackage.valid = paramQQAppInterface.valid;
      }
      if ((paramEmoticonPackage.mobileFeetype == 1) || ((str1 != null) && ("10278".equals(str1))) || (paramEmoticonPackage.jobType == 1))
      {
        paramEmoticonPackage.wordingId = 1L;
        if ((paramArrayOfByte != null) && (paramArrayOfByte.has("operationInfo")))
        {
          paramQQAppInterface = paramArrayOfByte.getJSONArray("operationInfo");
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
          {
            i = 0;
            j = paramQQAppInterface.length();
          }
        }
      }
    }
    for (;;)
    {
      if (i < j)
      {
        localObject1 = paramQQAppInterface.getJSONObject(i);
        if ((localObject1 == null) || (!((JSONObject)localObject1).has("platform")) || (!"3".equals(((JSONObject)localObject1).getString("platform")))) {
          break label2227;
        }
        if (((JSONObject)localObject1).has("minVersion"))
        {
          paramQQAppInterface = ((JSONObject)localObject1).getString("minVersion");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            paramEmoticonPackage.minQQVersion = paramQQAppInterface;
          }
        }
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.has("childEmojiId")))
      {
        paramQQAppInterface = paramArrayOfByte.getString("childEmojiId");
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          paramQQAppInterface = paramQQAppInterface.split(",");
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0))
          {
            paramQQAppInterface = paramQQAppInterface[0];
            if (!TextUtils.isEmpty(paramQQAppInterface))
            {
              if (QLog.isColorLevel()) {
                QLog.d("EmotionJsonUtils", 2, "parseJson, child magic, id=" + paramQQAppInterface);
              }
              paramEmoticonPackage.childEpId = paramQQAppInterface;
            }
          }
        }
      }
      if (paramEmoticonPackage.isAPNG == 2)
      {
        paramQQAppInterface = paramArrayOfByte.optString("supportApngSize");
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          paramEmoticonPackage.supportSize = paramQQAppInterface;
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.has("commDiyText"))) {
          paramEmoticonPackage.businessExtra = paramArrayOfByte.getJSONArray("commDiyText").toString();
        }
        localEmoticonManager.a(paramEmoticonPackage);
        i1 = localEmoticonManager.a(str1);
        if (!EmoticonUtils.a(paramEmoticonPackage)) {
          break label2151;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionJsonUtils", 2, "parseJson: ep = " + paramEmoticonPackage + " ,update :" + bool);
        }
        localObject3 = paramArrayOfByte.getJSONArray("imgs");
        i2 = ((JSONArray)localObject3).length();
        i = 1;
        localObject4 = new ArrayList();
        k = 0;
      }
      for (j = 0;; j = m)
      {
        if (k < i2)
        {
          paramArrayOfByte = ((JSONArray)localObject3).getJSONObject(k);
          str2 = paramArrayOfByte.getString("id");
          localObject5 = paramArrayOfByte.getString("name");
          if (QLog.isColorLevel()) {
            QLog.d("EmotionJsonUtils", 2, "parseJson: emotion.id:" + str2);
          }
          if (!paramArrayOfByte.has("wWidthInPhone")) {
            break label2145;
          }
        }
        label2133:
        label2145:
        for (m = paramArrayOfByte.getInt("wWidthInPhone");; m = 0)
        {
          if (paramArrayOfByte.has("wHeightInPhone")) {}
          for (n = paramArrayOfByte.getInt("wHeightInPhone");; n = 0)
          {
            if (paramArrayOfByte.has("keywords"))
            {
              paramQQAppInterface = paramArrayOfByte.getJSONArray("keywords");
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                paramQQAppInterface.put(localObject5);
              }
              paramQQAppInterface = paramQQAppInterface.toString();
              if (!paramArrayOfByte.has("diyText")) {
                break label2133;
              }
              paramArrayOfByte = paramArrayOfByte.getJSONArray("diyText");
              if (paramArrayOfByte == null) {
                break label2133;
              }
            }
            for (paramArrayOfByte = paramArrayOfByte.toString();; paramArrayOfByte = "")
            {
              localObject2 = localEmoticonManager.a(str1, str2);
              if (localObject2 == null)
              {
                localObject1 = localObject2;
                if (paramInt != EmojiManager.c)
                {
                  localObject1 = new Emoticon();
                  ((Emoticon)localObject1).eId = str2;
                  ((Emoticon)localObject1).epId = str1;
                  ((Emoticon)localObject1).name = ((String)localObject5);
                  ((Emoticon)localObject1).width = m;
                  ((Emoticon)localObject1).height = n;
                  ((Emoticon)localObject1).keywords = paramQQAppInterface;
                  ((Emoticon)localObject1).businessExtra = paramArrayOfByte;
                  i = 1;
                }
              }
              for (;;)
              {
                if (localObject1 != null) {
                  break label1914;
                }
                m = j;
                if (!QLog.isColorLevel()) {
                  break label2208;
                }
                QLog.d("EmotionJsonUtils", 2, "emoticon json update, cannot find emoticon from epId: " + str1);
                m = j;
                break label2208;
                if (k <= 0) {
                  break;
                }
                paramEmoticonPackage.extraFlags &= i;
                break;
                paramEmoticonPackage.wordingId = -1L;
                break label834;
                if ((paramArrayOfByte == null) || (!paramArrayOfByte.has("supportSize"))) {
                  break label1076;
                }
                paramEmoticonPackage.supportSize = paramArrayOfByte.getJSONArray("supportSize").toString();
                break label1076;
                paramQQAppInterface = "[" + (String)localObject5 + "]";
                break label1346;
                if ((!str2.equals(((Emoticon)localObject2).eId)) || (!str1.equals(((Emoticon)localObject2).epId)) || (!((String)localObject5).equals(((Emoticon)localObject2).name)))
                {
                  ((Emoticon)localObject2).eId = str2;
                  ((Emoticon)localObject2).epId = str1;
                  if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                    ((Emoticon)localObject2).name = ((String)localObject5);
                  }
                  ((Emoticon)localObject2).width = m;
                  ((Emoticon)localObject2).height = n;
                  ((Emoticon)localObject2).keywords = paramQQAppInterface;
                  ((Emoticon)localObject2).businessExtra = paramArrayOfByte;
                  i = 1;
                  localObject1 = localObject2;
                }
                else
                {
                  i = 0;
                  if (!paramQQAppInterface.equals(((Emoticon)localObject2).keywords))
                  {
                    i = 1;
                    ((Emoticon)localObject2).keywords = paramQQAppInterface;
                  }
                  localObject1 = localObject2;
                  if (!paramArrayOfByte.equals(((Emoticon)localObject2).businessExtra))
                  {
                    i = 1;
                    ((Emoticon)localObject2).businessExtra = paramArrayOfByte;
                    localObject1 = localObject2;
                  }
                }
              }
              label1914:
              if (paramEmoticonPackage.jobType == 0) {
                ((Emoticon)localObject1).jobType = 0;
              }
              for (;;)
              {
                if (TextUtils.isEmpty(((Emoticon)localObject1).encryptKey)) {
                  j = 1;
                }
                ((Emoticon)localObject1).isSound = paramEmoticonPackage.hasSound;
                paramArrayList.add(localObject1);
                if (i1 != -1)
                {
                  ((Emoticon)localObject1).extensionWidth = i1;
                  ((Emoticon)localObject1).extensionHeight = i1;
                }
                if ((i != 0) && (!bool)) {
                  ((ArrayList)localObject4).add(localObject1);
                }
                m = j;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("EmotionJsonUtils", 2, "paseJson: emoticon eId[" + str2 + "]eName[" + (String)localObject5 + "]");
                m = j;
                break;
                if (paramEmoticonPackage.jobType == 1) {
                  return "qFace are not supported";
                }
                if (paramEmoticonPackage.jobType == 3) {
                  ((Emoticon)localObject1).jobType = 2;
                } else if (paramEmoticonPackage.jobType == 5) {
                  ((Emoticon)localObject1).jobType = 4;
                }
              }
              localEmoticonManager.b((List)localObject4);
              if (j == 0) {}
              for (bool = true;; bool = false)
              {
                paramReqInfo.a = bool;
                return null;
              }
            }
          }
        }
        label2151:
        bool = false;
        break label1129;
        i1 = 0;
        break label601;
        label2163:
        bool = false;
        i = 0;
        break label583;
        label2172:
        n = 0;
        break label547;
        label2178:
        m = 0;
        break label528;
        label2184:
        k = 0;
        break label509;
        label2190:
        j = 0;
        break label490;
        label2196:
        paramQQAppInterface = "";
        break label473;
        label2202:
        i = 0;
        break;
        label2208:
        k += 1;
      }
      label2221:
      j = 0;
      break label388;
      label2227:
      i += 1;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DownloadTask paramDownloadTask, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    if ((paramQQAppInterface == null) && (paramDownloadTask == null)) {}
    EmoticonPackage localEmoticonPackage;
    do
    {
      return null;
      localObject = paramDownloadTask.a();
      localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    } while (localEmoticonPackage == null);
    int i = ((Bundle)localObject).getInt("jsonType", EmojiManager.b);
    File localFile = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
    Object localObject = new ReqInfo();
    paramDownloadTask = localArrayList;
    if (localFile != null)
    {
      if (localFile.exists()) {
        paramDownloadTask = FileUtils.a(localFile);
      }
    }
    else
    {
      localArrayList = new ArrayList();
      if (!paramBoolean) {
        break label165;
      }
    }
    label165:
    for (paramQQAppInterface = a(paramQQAppInterface, localEmoticonPackage, i, paramDownloadTask, localArrayList);; paramQQAppInterface = a(paramQQAppInterface, localEmoticonPackage, i, paramDownloadTask, localArrayList, (ReqInfo)localObject))
    {
      if ((QLog.isColorLevel()) && (paramQQAppInterface != null)) {
        QLog.d("EmotionJsonUtils", 2, "handleJsonFileDownload : json parse result = " + paramQQAppInterface);
      }
      return paramQQAppInterface;
      paramDownloadTask = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmotionJsonUtils
 * JD-Core Version:    0.7.0.1
 */