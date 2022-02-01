package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.model.CommercialDrainageManagerConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmotionJsonUtils
{
  public static final String TAG = "EmotionJsonUtils";
  
  public static String handleJsonFileDownload(AppInterface paramAppInterface, DownloadTask paramDownloadTask, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    if ((paramAppInterface == null) && (paramDownloadTask == null)) {
      return null;
    }
    Object localObject = paramDownloadTask.a();
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (localEmoticonPackage == null) {
      return null;
    }
    int i = ((Bundle)localObject).getInt("jsonType", EmojiManagerServiceConstant.JSON_EMOSM_MALL);
    File localFile = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
    localObject = new ReqInfo();
    paramDownloadTask = localArrayList;
    if (localFile != null)
    {
      paramDownloadTask = localArrayList;
      if (localFile.exists()) {
        paramDownloadTask = FileUtils.fileToBytes(localFile);
      }
    }
    localArrayList = new ArrayList();
    if (paramBoolean) {
      paramAppInterface = parseSmallJson(paramAppInterface, localEmoticonPackage, i, paramDownloadTask, localArrayList);
    } else {
      paramAppInterface = parseJson(paramAppInterface, localEmoticonPackage, i, paramDownloadTask, localArrayList, (ReqInfo)localObject);
    }
    if ((QLog.isColorLevel()) && (paramAppInterface != null))
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("handleJsonFileDownload : json parse result = ");
      paramDownloadTask.append(paramAppInterface);
      QLog.d("EmotionJsonUtils", 2, paramDownloadTask.toString());
    }
    return paramAppInterface;
  }
  
  protected static void parseItemInfoJson(EmoticonPackage paramEmoticonPackage, int paramInt1, ArrayList<Emoticon> paramArrayList, IEmoticonManagerService paramIEmoticonManagerService, JSONArray paramJSONArray, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    while (i < paramInt2)
    {
      Object localObject = paramJSONArray.getJSONObject(i);
      String str1 = ((JSONObject)localObject).getString("id");
      String str2 = ((JSONObject)localObject).getString("name");
      String str4 = ((JSONObject)localObject).getString("character");
      String str3 = paramEmoticonPackage.epId;
      Emoticon localEmoticon = paramIEmoticonManagerService.syncFindEmoticonById(str3, str1);
      if (localEmoticon == null)
      {
        localObject = localEmoticon;
        if (paramInt1 != EmojiManagerServiceConstant.JSON_EMOSM_KEYWORD)
        {
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = str1;
          ((Emoticon)localObject).epId = str3;
          ((Emoticon)localObject).name = str2;
          ((Emoticon)localObject).character = str4;
          ((Emoticon)localObject).jobType = 3;
        }
      }
      else
      {
        for (;;)
        {
          paramBoolean = true;
          break;
          if ((str1.equals(localEmoticon.eId)) && (str3.equals(localEmoticon.epId)) && (str2.equals(localEmoticon.name)))
          {
            paramBoolean = false;
            localObject = localEmoticon;
            break;
          }
          localEmoticon.eId = str1;
          localEmoticon.epId = str3;
          if (!TextUtils.isEmpty(str2)) {
            localEmoticon.name = str2;
          }
          localObject = localEmoticon;
          if (!TextUtils.isEmpty(str4))
          {
            localEmoticon.character = str4;
            localObject = localEmoticon;
          }
        }
      }
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("emoticon json update, cannot find emoticon from epId: ");
          ((StringBuilder)localObject).append(str3);
          QLog.d("EmotionJsonUtils", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        boolean bool = EmoticonPanelUtils.a(paramEmoticonPackage);
        ((Emoticon)localObject).isSound = paramEmoticonPackage.hasSound;
        paramArrayList.add(localObject);
        if ((paramBoolean) && (!bool)) {
          paramIEmoticonManagerService.saveEmoticon((Emoticon)localObject);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseSmallJson :emoticon eId[");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append("]eName[");
          ((StringBuilder)localObject).append(str2);
          ((StringBuilder)localObject).append("]");
          QLog.d("EmotionJsonUtils", 2, ((StringBuilder)localObject).toString());
        }
      }
      i += 1;
    }
  }
  
  public static String parseJson(AppInterface paramAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList<Emoticon> paramArrayList, ReqInfo paramReqInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseJson : parseJson start");
    }
    String str = parseJsonParamsVerify(paramAppInterface, paramEmoticonPackage, paramArrayOfByte, paramArrayList, paramReqInfo);
    if (str != null) {
      return str;
    }
    paramAppInterface = (IEmoticonManagerService)paramAppInterface.getRuntimeService(IEmoticonManagerService.class, "");
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "utf-8"));
      str = paramArrayOfByte.getString("id");
      Object localObject = paramArrayOfByte.getString("name");
      parseJsonDiversionConfig(paramEmoticonPackage, paramArrayOfByte);
      localObject = parseJsonApng(paramEmoticonPackage, paramInt, paramAppInterface, paramArrayOfByte, str, (String)localObject, "");
      if (localObject != null) {
        return localObject;
      }
      if (paramEmoticonPackage.isAPNG == 2)
      {
        localObject = paramArrayOfByte.optString("supportApngSize");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramEmoticonPackage.supportSize = ((String)localObject);
        }
      }
      else if (paramArrayOfByte.has("supportSize"))
      {
        paramEmoticonPackage.supportSize = paramArrayOfByte.getJSONArray("supportSize").toString();
      }
      if (paramArrayOfByte.has("commDiyText")) {
        paramEmoticonPackage.businessExtra = paramArrayOfByte.getJSONArray("commDiyText").toString();
      }
      paramAppInterface.saveEmoticonPackage(paramEmoticonPackage);
      int i = paramAppInterface.getExtensionSizeByScreenSize(str);
      boolean bool = EmoticonPanelUtils.a(paramEmoticonPackage);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseJson: ep = ");
        ((StringBuilder)localObject).append(paramEmoticonPackage);
        ((StringBuilder)localObject).append(" ,update :");
        ((StringBuilder)localObject).append(bool);
        QLog.d("EmotionJsonUtils", 2, ((StringBuilder)localObject).toString());
      }
      paramAppInterface = parseJsonImgs(paramEmoticonPackage, paramInt, paramArrayList, paramReqInfo, paramAppInterface, paramArrayOfByte, str, i, bool);
      if (paramAppInterface != null) {
        return paramAppInterface;
      }
      return null;
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      paramArrayOfByte = paramAppInterface.toString();
      paramArrayList = new StringBuilder();
      paramArrayList.append("parseJson: PARSE_EMOTICON_JSON fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=");
      paramArrayList.append(paramEmoticonPackage.epId);
      paramArrayList.append(" exception=");
      paramArrayList.append(paramAppInterface.toString());
      QLog.d("EmotionJsonUtils", 1, paramArrayList.toString());
      return paramArrayOfByte;
    }
    catch (JSONException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      paramArrayOfByte = paramAppInterface.toString();
      paramArrayList = new StringBuilder();
      paramArrayList.append("parseJson: PARSE_EMOTICON_JSON fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=");
      paramArrayList.append(paramEmoticonPackage.epId);
      paramArrayList.append(" exception=");
      paramArrayList.append(paramAppInterface.toString());
      QLog.e("EmotionJsonUtils", 1, paramArrayList.toString());
    }
    return paramArrayOfByte;
  }
  
  protected static String parseJsonApng(EmoticonPackage paramEmoticonPackage, int paramInt, IEmoticonManagerService paramIEmoticonManagerService, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    int k = paramEmoticonPackage.extraFlags & 0x1;
    if (paramJSONObject.has("isOriginal")) {
      i = paramJSONObject.getInt("isOriginal");
    } else {
      i = 0;
    }
    int j;
    if (paramJSONObject.optInt("isApng") == 1) {
      j = 2;
    } else {
      j = 0;
    }
    paramEmoticonPackage.isAPNG = j;
    if (k == 0) {
      paramEmoticonPackage.extraFlags |= i;
    } else if (k > 0) {
      paramEmoticonPackage.extraFlags &= i;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseJson original = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", ep.extraFlags = ");
      ((StringBuilder)localObject).append(paramEmoticonPackage.extraFlags);
      QLog.d("EmotionJsonUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramJSONObject.has("mark")) {
      paramString3 = paramJSONObject.getString("mark");
    }
    if (paramJSONObject.has("type")) {
      j = paramJSONObject.getInt("type");
    } else {
      j = 0;
    }
    if (paramJSONObject.has("feetype")) {
      k = paramJSONObject.getInt("feetype");
    } else {
      k = 0;
    }
    int m;
    if (paramJSONObject.has("rscType")) {
      m = paramJSONObject.getInt("rscType");
    } else {
      m = 0;
    }
    int n;
    if (paramJSONObject.has("updateTime")) {
      n = paramJSONObject.getInt("updateTime");
    } else {
      n = 0;
    }
    if (paramJSONObject.has("ringtype"))
    {
      localObject = paramJSONObject.getString("ringtype");
      if ("1".equals(localObject))
      {
        bool = true;
        i = 1;
        break label358;
      }
      if ("2".equals(localObject)) {
        return "qFace are not supported";
      }
      if ("4".equals(localObject))
      {
        bool = false;
        i = 4;
        break label358;
      }
    }
    boolean bool = false;
    int i = 0;
    label358:
    int i1;
    if ((paramJSONObject.has("type")) && (1 == j)) {
      i1 = 3;
    } else {
      i1 = 0;
    }
    int i2;
    if (paramJSONObject.has("downloadcount")) {
      i2 = paramJSONObject.getInt("downloadcount");
    } else {
      i2 = 0;
    }
    paramEmoticonPackage.epId = paramString1;
    paramEmoticonPackage.name = paramString2;
    paramEmoticonPackage.mark = paramString3;
    paramEmoticonPackage.type = j;
    paramEmoticonPackage.mobileFeetype = k;
    paramEmoticonPackage.hasSound = bool;
    paramEmoticonPackage.subType = i;
    paramEmoticonPackage.downloadCount = i2;
    paramEmoticonPackage.jobType = i1;
    parseJsonToEp(paramEmoticonPackage, paramInt, paramIEmoticonManagerService, paramJSONObject, paramString1, m, j, n);
    parseJsonOperationInfo(paramEmoticonPackage, paramJSONObject);
    parseJsonChildEmojiId(paramEmoticonPackage, paramJSONObject);
    return null;
  }
  
  protected static void parseJsonChildEmojiId(EmoticonPackage paramEmoticonPackage, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("childEmojiId")))
    {
      paramJSONObject = paramJSONObject.getString("childEmojiId");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = paramJSONObject.split(",");
        if ((paramJSONObject != null) && (paramJSONObject.length > 0))
        {
          paramJSONObject = paramJSONObject[0];
          if (!TextUtils.isEmpty(paramJSONObject))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("parseJson, child magic, id=");
              localStringBuilder.append(paramJSONObject);
              QLog.d("EmotionJsonUtils", 2, localStringBuilder.toString());
            }
            paramEmoticonPackage.childEpId = paramJSONObject;
          }
        }
      }
    }
  }
  
  protected static void parseJsonDiversionConfig(EmoticonPackage paramEmoticonPackage, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("diversionConfig");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("diversionConfig = ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.d("EmotionJsonUtils", 1, ((StringBuilder)localObject).toString());
    }
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("diversionType");
      localObject = paramJSONObject.optString("diversionName");
      String str1 = paramJSONObject.optString("copywriting");
      String str2 = paramJSONObject.optString("jumpUrl");
      String str3 = paramJSONObject.optString("displayImg");
      long l1 = paramJSONObject.optLong("beginTime");
      long l2 = paramJSONObject.optLong("endTime");
      String str4 = paramJSONObject.optString("wording");
      paramJSONObject = paramJSONObject.optString("from");
      paramEmoticonPackage.copywritingType = i;
      paramEmoticonPackage.copywritingContent = str1;
      paramEmoticonPackage.jumpUrl = str2;
      paramEmoticonPackage.imageUrl = str3;
      paramEmoticonPackage.diversionName = ((String)localObject);
      paramEmoticonPackage.beginTime = l1;
      paramEmoticonPackage.endTime = l2;
      paramEmoticonPackage.buttonWording = str4;
      paramEmoticonPackage.comeFom = paramJSONObject;
    }
  }
  
  protected static String parseJsonImgs(EmoticonPackage paramEmoticonPackage, int paramInt1, ArrayList<Emoticon> paramArrayList, ReqInfo paramReqInfo, IEmoticonManagerService paramIEmoticonManagerService, JSONObject paramJSONObject, String paramString, int paramInt2, boolean paramBoolean)
  {
    JSONArray localJSONArray = paramJSONObject.getJSONArray("imgs");
    int j = localJSONArray.length();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = true;
    int k = 0;
    while (k < j)
    {
      JSONObject localJSONObject = localJSONArray.getJSONObject(k);
      String str1 = localJSONObject.getString("id");
      String str2 = localJSONObject.getString("name");
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJson: emotion.id:");
        paramJSONObject.append(str1);
        QLog.d("EmotionJsonUtils", 2, paramJSONObject.toString());
      }
      int m;
      if (localJSONObject.has("wWidthInPhone")) {
        m = localJSONObject.getInt("wWidthInPhone");
      } else {
        m = 0;
      }
      int n;
      if (localJSONObject.has("wHeightInPhone")) {
        n = localJSONObject.getInt("wHeightInPhone");
      } else {
        n = 0;
      }
      String str3 = parseJsonKeywords(localJSONObject, str2);
      if (localJSONObject.has("diyText"))
      {
        paramJSONObject = localJSONObject.getJSONArray("diyText");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.toString();
          break label215;
        }
      }
      paramJSONObject = "";
      label215:
      Object localObject = paramIEmoticonManagerService.syncFindEmoticonById(paramString, str1);
      if (localObject == null)
      {
        if (paramInt1 != EmojiManagerServiceConstant.JSON_EMOSM_KEYWORD)
        {
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = str1;
          ((Emoticon)localObject).epId = paramString;
          ((Emoticon)localObject).name = str2;
          ((Emoticon)localObject).width = m;
          ((Emoticon)localObject).height = n;
          ((Emoticon)localObject).keywords = str3;
          ((Emoticon)localObject).businessExtra = paramJSONObject;
          paramJSONObject = (JSONObject)localObject;
        }
      }
      else {
        for (;;)
        {
          bool = true;
          localObject = paramJSONObject;
          break;
          if ((str1.equals(((Emoticon)localObject).eId)) && (paramString.equals(((Emoticon)localObject).epId)) && (str2.equals(((Emoticon)localObject).name)))
          {
            if (!str3.equals(((Emoticon)localObject).keywords))
            {
              ((Emoticon)localObject).keywords = str3;
              bool = true;
            }
            else
            {
              bool = false;
            }
            if (!paramJSONObject.equals(((Emoticon)localObject).businessExtra))
            {
              ((Emoticon)localObject).businessExtra = paramJSONObject;
              paramJSONObject = (JSONObject)localObject;
            }
            else
            {
              break;
            }
          }
          else
          {
            ((Emoticon)localObject).eId = str1;
            ((Emoticon)localObject).epId = paramString;
            if (!TextUtils.isEmpty(str2)) {
              ((Emoticon)localObject).name = str2;
            }
            ((Emoticon)localObject).width = m;
            ((Emoticon)localObject).height = n;
            ((Emoticon)localObject).keywords = str3;
            ((Emoticon)localObject).businessExtra = paramJSONObject;
            paramJSONObject = (JSONObject)localObject;
          }
        }
      }
      if (localObject == null)
      {
        m = i;
        if (QLog.isColorLevel())
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("emoticon json update, cannot find emoticon from epId: ");
          paramJSONObject.append(paramString);
          QLog.d("EmotionJsonUtils", 2, paramJSONObject.toString());
          m = i;
        }
      }
      else
      {
        paramJSONObject = parseJsonJobType(paramEmoticonPackage, (Emoticon)localObject);
        if (paramJSONObject != null) {
          return paramJSONObject;
        }
        if (TextUtils.isEmpty(((Emoticon)localObject).encryptKey)) {
          i = 1;
        }
        ((Emoticon)localObject).isSound = paramEmoticonPackage.hasSound;
        parseJsonVoiceData(paramEmoticonPackage, paramArrayList, paramInt2, paramBoolean, bool, localArrayList, localJSONObject, str1, str2, (Emoticon)localObject);
        m = i;
      }
      k += 1;
      i = m;
    }
    paramIEmoticonManagerService.saveEmoticons(localArrayList);
    if (paramEmoticonPackage.newSoundEp) {
      paramIEmoticonManagerService.saveEmoticonPackage(paramEmoticonPackage);
    }
    paramReqInfo.encryptKeysSuccess = (i ^ 0x1);
    return null;
  }
  
  private static String parseJsonJobType(EmoticonPackage paramEmoticonPackage, Emoticon paramEmoticon)
  {
    if (paramEmoticonPackage.jobType == 0)
    {
      paramEmoticon.jobType = 0;
    }
    else
    {
      if (paramEmoticonPackage.jobType == 1) {
        return "qFace are not supported";
      }
      if (paramEmoticonPackage.jobType == 3) {
        paramEmoticon.jobType = 2;
      } else if (paramEmoticonPackage.jobType == 5) {
        paramEmoticon.jobType = 4;
      }
    }
    return null;
  }
  
  private static String parseJsonKeywords(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("keywords"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("keywords");
      if (!TextUtils.isEmpty(paramString)) {
        paramJSONObject.put(paramString);
      }
      return paramJSONObject.toString();
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("[");
    paramJSONObject.append(paramString);
    paramJSONObject.append("]");
    return paramJSONObject.toString();
  }
  
  protected static void parseJsonOperationInfo(EmoticonPackage paramEmoticonPackage, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("operationInfo")))
    {
      paramJSONObject = paramJSONObject.getJSONArray("operationInfo");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        int i = 0;
        int j = paramJSONObject.length();
        while (i < j)
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          if ((localJSONObject != null) && (localJSONObject.has("platform")) && ("3".equals(localJSONObject.getString("platform"))))
          {
            if (!localJSONObject.has("minVersion")) {
              break;
            }
            paramJSONObject = localJSONObject.getString("minVersion");
            if (TextUtils.isEmpty(paramJSONObject)) {
              break;
            }
            paramEmoticonPackage.minQQVersion = paramJSONObject;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected static String parseJsonParamsVerify(AppInterface paramAppInterface, EmoticonPackage paramEmoticonPackage, byte[] paramArrayOfByte, ArrayList<Emoticon> paramArrayList, ReqInfo paramReqInfo)
  {
    if (paramAppInterface == null)
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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 1))
    {
      if ((paramArrayList != null) && (paramReqInfo != null)) {
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : params is null");
      }
      return "params is null";
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseJson : json data is null");
    }
    return "json data is null";
  }
  
  protected static void parseJsonToEp(EmoticonPackage paramEmoticonPackage, int paramInt1, IEmoticonManagerService paramIEmoticonManagerService, JSONObject paramJSONObject, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramEmoticonPackage.copywritingType != CommercialDrainageManagerConstants.a)
    {
      paramEmoticonPackage.extraFlags |= 0x4;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseJson, ep.extraFlags = ");
        localStringBuilder.append(paramEmoticonPackage.extraFlags);
        QLog.d("EmotionJsonUtils", 2, localStringBuilder.toString());
      }
    }
    if ((paramJSONObject.has("type")) && (4 == paramInt3)) {
      paramEmoticonPackage.jobType = 5;
    }
    paramEmoticonPackage.rscType = paramInt2;
    if (paramInt1 != EmojiManagerServiceConstant.JSON_EMOSM_KEYWORD) {
      paramEmoticonPackage.localVersion = paramInt4;
    }
    paramIEmoticonManagerService = paramIEmoticonManagerService.syncFindTabEmoticonPackageById(paramString);
    if (paramIEmoticonManagerService != null)
    {
      paramEmoticonPackage.status = paramIEmoticonManagerService.status;
      paramEmoticonPackage.valid = paramIEmoticonManagerService.valid;
    }
    if ((paramEmoticonPackage.mobileFeetype != 1) && ((paramString == null) || (!"10278".equals(paramString))) && (paramEmoticonPackage.jobType != 1))
    {
      if (paramIEmoticonManagerService != null)
      {
        paramEmoticonPackage.wordingId = paramIEmoticonManagerService.wordingId;
        return;
      }
      paramEmoticonPackage.wordingId = -1L;
      return;
    }
    paramEmoticonPackage.wordingId = 1L;
  }
  
  private static void parseJsonVoiceData(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ArrayList<Emoticon> paramArrayList2, JSONObject paramJSONObject, String paramString1, String paramString2, Emoticon paramEmoticon)
  {
    paramJSONObject = paramJSONObject.optJSONObject("voiceData");
    if (paramJSONObject != null)
    {
      paramEmoticon.backColor = paramJSONObject.optString("backcolor", null);
      paramEmoticon.volumeColor = paramJSONObject.optString("fontcolor", null);
      paramJSONObject = paramJSONObject.optString("heightItems", null);
      paramEmoticon.voicePrint = paramJSONObject;
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramEmoticon.voicePrintItems = paramEmoticon.parseSoundPrintString();
        paramEmoticonPackage.newSoundEp = true;
      }
    }
    paramArrayList1.add(paramEmoticon);
    if (paramInt != -1)
    {
      paramEmoticon.extensionWidth = paramInt;
      paramEmoticon.extensionHeight = paramInt;
    }
    if ((paramBoolean2) && (!paramBoolean1)) {
      paramArrayList2.add(paramEmoticon);
    }
    if (QLog.isColorLevel())
    {
      paramEmoticonPackage = new StringBuilder();
      paramEmoticonPackage.append("paseJson: emoticon eId[");
      paramEmoticonPackage.append(paramString1);
      paramEmoticonPackage.append("]eName[");
      paramEmoticonPackage.append(paramString2);
      paramEmoticonPackage.append("]");
      QLog.d("EmotionJsonUtils", 2, paramEmoticonPackage.toString());
    }
  }
  
  public static String parseSmallJson(AppInterface paramAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList<Emoticon> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseSmallJson: parseSmallJson start");
    }
    if (paramAppInterface == null)
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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 1))
    {
      if (paramArrayList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionJsonUtils", 2, "parseSmallJson: params is null");
        }
        return "params is null";
      }
      paramAppInterface = (IEmoticonManagerService)paramAppInterface.getRuntimeService(IEmoticonManagerService.class, "");
      try
      {
        paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "utf-8"));
        long l = paramArrayOfByte.getLong("timestamp");
        JSONObject localJSONObject = paramArrayOfByte.getJSONObject("data");
        JSONArray localJSONArray1 = localJSONObject.getJSONArray("baseInfo");
        JSONArray localJSONArray2 = localJSONObject.getJSONArray("operationInfo");
        if ((localJSONArray1 != null) && (localJSONArray2 != null))
        {
          parseSmallPackageJson(paramEmoticonPackage, paramInt, paramArrayList, paramAppInterface, paramArrayOfByte, l, localJSONObject, localJSONArray1, localJSONArray2);
          return null;
        }
        return "parseSmallJson:json data is error";
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        paramArrayOfByte = paramAppInterface.toString();
        paramArrayList = new StringBuilder();
        paramArrayList.append("parseSmallJson: fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=");
        paramArrayList.append(paramEmoticonPackage.epId);
        paramArrayList.append(" exception=");
        paramArrayList.append(paramAppInterface.toString());
        QLog.e("EmotionJsonUtils", 1, paramArrayList.toString());
        return paramArrayOfByte;
      }
      catch (OutOfMemoryError paramAppInterface)
      {
        paramEmoticonPackage = new StringBuilder();
        paramEmoticonPackage.append("parseSmallJson: fail OutOfMemoryError  exception=");
        paramEmoticonPackage.append(paramAppInterface.toString());
        QLog.e("EmotionJsonUtils", 1, paramEmoticonPackage.toString());
        return null;
      }
      catch (JSONException paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        paramArrayOfByte = paramAppInterface.toString();
        paramArrayList = new StringBuilder();
        paramArrayList.append("parseSmallJson: fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=");
        paramArrayList.append(paramEmoticonPackage.epId);
        paramArrayList.append(" exception=");
        paramArrayList.append(paramAppInterface.toString());
        QLog.e("EmotionJsonUtils", 1, paramArrayList.toString());
        return paramArrayOfByte;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseSmallJson: data is null");
    }
    return "json data is null";
  }
  
  protected static void parseSmallPackageJson(EmoticonPackage paramEmoticonPackage, int paramInt, ArrayList<Emoticon> paramArrayList, IEmoticonManagerService paramIEmoticonManagerService, JSONObject paramJSONObject1, long paramLong, JSONObject paramJSONObject2, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    int j = 0;
    paramJSONArray1 = (JSONObject)paramJSONArray1.get(0);
    paramJSONArray2 = (JSONObject)paramJSONArray2.get(0);
    String str = paramJSONArray1.getString("name");
    paramEmoticonPackage.isAPNG = (paramJSONArray1.optInt("isAPNG", 0) + 1);
    if (paramEmoticonPackage.isAPNG == 2) {
      paramEmoticonPackage.rscType = 2;
    }
    int k = paramEmoticonPackage.extraFlags & 0x1;
    if (paramJSONArray1.has("isOriginal")) {
      i = paramJSONArray1.getInt("isOriginal");
    } else {
      i = 0;
    }
    if (k == 0) {
      paramEmoticonPackage.extraFlags |= i;
    } else if (k > 0) {
      paramEmoticonPackage.extraFlags &= i;
    }
    if (QLog.isColorLevel())
    {
      paramJSONArray1 = new StringBuilder();
      paramJSONArray1.append("parseSmallJson original = ");
      paramJSONArray1.append(i);
      paramJSONArray1.append(", ep.extraFlags = ");
      paramJSONArray1.append(paramEmoticonPackage.extraFlags);
      QLog.d("EmotionJsonUtils", 2, paramJSONArray1.toString());
    }
    int i = 6;
    if (paramJSONObject1.has("type")) {
      i = paramJSONObject1.getInt("type");
    }
    if (paramJSONArray2.has("feeType")) {
      j = paramJSONArray2.getInt("feeType");
    }
    paramEmoticonPackage.localVersion = ((int)(paramLong / 1000L));
    paramEmoticonPackage.name = str;
    paramEmoticonPackage.mark = "";
    paramEmoticonPackage.type = i;
    paramEmoticonPackage.mobileFeetype = j;
    paramEmoticonPackage.jobType = 4;
    if ((paramEmoticonPackage.mobileFeetype != 1) && ((paramEmoticonPackage.epId == null) || (!"10278".equals(paramEmoticonPackage.epId))))
    {
      paramJSONObject1 = paramIEmoticonManagerService.syncFindTabEmoticonPackageById(paramEmoticonPackage.epId);
      if (paramJSONObject1 != null) {
        paramEmoticonPackage.wordingId = paramJSONObject1.wordingId;
      } else {
        paramEmoticonPackage.wordingId = -1L;
      }
    }
    else
    {
      paramEmoticonPackage.wordingId = 1L;
    }
    paramIEmoticonManagerService.saveEmoticonPackage(paramEmoticonPackage);
    if (QLog.isColorLevel())
    {
      paramJSONObject1 = new StringBuilder();
      paramJSONObject1.append("parseSmallJson: ep = ");
      paramJSONObject1.append(paramEmoticonPackage);
      QLog.d("EmotionJsonUtils", 2, paramJSONObject1.toString());
    }
    paramJSONObject1 = paramJSONObject2.getJSONArray("itemInfo");
    parseItemInfoJson(paramEmoticonPackage, paramInt, paramArrayList, paramIEmoticonManagerService, paramJSONObject1, paramJSONObject1.length(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmotionJsonUtils
 * JD-Core Version:    0.7.0.1
 */