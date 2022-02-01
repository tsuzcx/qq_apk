package cooperation.qqfav;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class QfavBuilder
  implements Consts
{
  private Intent a;
  
  public QfavBuilder(int paramInt)
  {
    this.a = new Intent();
    this.a.putExtra("nType", paramInt);
  }
  
  public QfavBuilder(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  public static QfavBuilder a()
  {
    return new QfavBuilder(3);
  }
  
  public static QfavBuilder a(float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3)
  {
    return new QfavBuilder(7).b("sLocation", paramString2).b("sBrief", paramString3).b("sPublisher", paramString1).a("fLatitude", paramFloat1).a("fLongitude", paramFloat2);
  }
  
  public static QfavBuilder a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    String str6 = paramString1;
    String str5 = paramString2;
    String str4 = paramString3;
    String str3 = paramString4;
    String str2 = paramString5;
    String str1 = paramString6;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = QfavUtil.a(paramArrayOfByte);
      str6 = QfavUtil.a(paramArrayOfByte[0], paramString1);
      str5 = QfavUtil.a(paramArrayOfByte[1], paramString2);
      str4 = QfavUtil.a(paramArrayOfByte[2], paramString3);
      str3 = QfavUtil.a(paramArrayOfByte[3], paramString4);
      str2 = QfavUtil.a(paramArrayOfByte[4], paramString5);
      str1 = QfavUtil.a(paramArrayOfByte[5], paramString6);
    }
    paramString1 = new QfavBuilder(6).a("nLinkType", paramInt).b("sTitle", str6).b("sUrl", str5).a("bAppShare", paramBoolean).a("lAppId", paramLong).b("sPublisher", str4).b("sBrief", str3).b("sPath", str2).b("sResUrl", str1);
    if (paramBoolean) {
      paramLong = 4L;
    } else {
      paramLong = 1L;
    }
    return paramString1.a("lCategory", paramLong);
  }
  
  public static QfavBuilder a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    ContentValues localContentValues = new ContentValues();
    int j = paramIntent.getIntExtra("from_busi_type", 1);
    int i;
    if (j == 0) {
      i = 1;
    } else {
      i = j;
    }
    localContentValues.put("shortVideoBusiType", Integer.valueOf(i));
    localContentValues.put("shortVideoDuration", Integer.valueOf(paramIntent.getIntExtra("file_send_duration", 0)));
    localContentValues.put("shortVideoFormat", Integer.valueOf(paramIntent.getIntExtra("file_format", 0)));
    Object localObject = paramIntent.getStringExtra("file_send_path");
    localContentValues.put("shortVideoLocalPath", (String)localObject);
    localContentValues.put("shortVideoMd5", paramIntent.getStringExtra("file_shortvideo_md5"));
    long l;
    if (new File((String)localObject).exists()) {
      l = new File((String)localObject).length();
    } else {
      l = 0L;
    }
    localContentValues.put("shortVideoSize", Long.valueOf(l));
    String str = paramIntent.getStringExtra("file_name");
    localContentValues.put("shortVideoFileName", str.substring(str.lastIndexOf('/') + 1));
    localContentValues.put("shortVideoThumbHeight", Integer.valueOf(paramIntent.getIntExtra("thumbfile_send_height", 0)));
    localContentValues.put("shortVideoThumbMd5", paramIntent.getStringExtra("thumbfile_md5"));
    if (new File((String)localObject).exists()) {
      i = (int)new File((String)localObject).length();
    } else {
      i = paramIntent.getIntExtra("file_thumb_Size", 0);
    }
    localContentValues.put("shortVideoThumbSize", Integer.valueOf(i));
    localContentValues.put("shortVideoThumbWidth", Integer.valueOf(paramIntent.getIntExtra("thumbfile_send_width", 0)));
    localContentValues.put("shortVideoThumbLocalPath", paramIntent.getStringExtra("thumbfile_send_path"));
    localContentValues.put("shortVideoUuid", paramIntent.getStringExtra("file_uuid"));
    localObject = new QfavBuilder(5);
    ((QfavBuilder)localObject).a.putExtra("shortVideoContents", localContentValues);
    if (j == 0) {
      ((QfavBuilder)localObject).a.putExtra("sBizDataList", QfavHelper.a());
    }
    return ((QfavBuilder)localObject).c(paramIntent.getStringExtra("from_uin"));
  }
  
  public static QfavBuilder a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, List<ChatMessage> paramList, Map<String, String> paramMap)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      QfavBuilder localQfavBuilder = new QfavBuilder(8).c(paramMessageForStructing);
      if (!QfavUtil.a(paramMessageForStructing))
      {
        localQfavBuilder.c(paramMessageForStructing);
        return localQfavBuilder;
      }
      ArrayList localArrayList = new ArrayList();
      byte[] arrayOfByte = QfavUtil.a(paramMessageForStructing.uniseq, paramMessageForStructing.structingMsg);
      if (arrayOfByte != null) {
        localArrayList.add(arrayOfByte);
      }
      long l;
      if ((paramList != null) && (paramList.size() != 0)) {
        l = paramList.size();
      } else {
        l = 1L;
      }
      arrayOfByte = QfavUtil.a(paramMessageForStructing.uniseq, l);
      if (arrayOfByte != null) {
        localArrayList.add(arrayOfByte);
      }
      arrayOfByte = QfavUtil.a(-1L, paramMap);
      if (arrayOfByte != null) {
        localArrayList.add(arrayOfByte);
      }
      QfavUtil.a(paramQQAppInterface, paramMessageForStructing, paramList, paramMap, localArrayList);
      localQfavBuilder.b("sBizDataList", localArrayList);
      return localQfavBuilder;
    }
    return null;
  }
  
  public static QfavBuilder a(MessageForShortVideo paramMessageForShortVideo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("shortVideoDuration", Integer.valueOf(paramMessageForShortVideo.videoFileTime));
    localContentValues.put("shortVideoFileTYPE", Integer.valueOf(paramMessageForShortVideo.fileType));
    localContentValues.put("shortVideoFormat", Integer.valueOf(paramMessageForShortVideo.videoFileFormat));
    localContentValues.put("shortVideoMd5", paramMessageForShortVideo.md5);
    int i;
    if (paramMessageForShortVideo.busiType == 0) {
      i = 1;
    } else {
      i = paramMessageForShortVideo.busiType;
    }
    localContentValues.put("shortVideoBusiType", Integer.valueOf(i));
    String str = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
    localContentValues.put("shortVideoLocalPath", str);
    long l2 = paramMessageForShortVideo.videoFileSize;
    long l1 = l2;
    if (str != null)
    {
      l1 = l2;
      if (new File(str).exists()) {
        l1 = new File(str).length();
      }
    }
    localContentValues.put("shortVideoSize", Long.valueOf(l1));
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localContentValues.put("shortVideoFileName", ((String)localObject).substring(((String)localObject).lastIndexOf('/') + 1));
    localContentValues.put("shortVideoThumbHeight", Integer.valueOf(paramMessageForShortVideo.thumbHeight));
    localContentValues.put("shortVideoThumbMd5", paramMessageForShortVideo.thumbMD5);
    localContentValues.put("shortVideoThumbWidth", Integer.valueOf(paramMessageForShortVideo.thumbWidth));
    localObject = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (new File((String)localObject).exists()) {
      l1 = new File((String)localObject).length();
    } else {
      l1 = paramMessageForShortVideo.thumbFileSize;
    }
    localContentValues.put("shortVideoThumbSize", Long.valueOf(l1));
    localContentValues.put("shortVideoThumbLocalPath", (String)localObject);
    localContentValues.put("shortVideoUuid", paramMessageForShortVideo.uuid);
    localObject = new QfavBuilder(5);
    ((QfavBuilder)localObject).a.putExtra("shortVideoContents", localContentValues);
    if (paramMessageForShortVideo.busiType == 0) {
      ((QfavBuilder)localObject).a.putExtra("sBizDataList", QfavHelper.a());
    }
    return localObject;
  }
  
  public static QfavBuilder a(Entity paramEntity)
  {
    return new QfavBuilder(2).c(paramEntity);
  }
  
  public static QfavBuilder a(String paramString)
  {
    return new QfavBuilder(6).b("sUrl", paramString);
  }
  
  public static QfavBuilder a(String paramString1, int paramInt, String paramString2)
  {
    return new QfavBuilder(4).b("sPath", paramString1).a("nDuration", paramInt).b("sBrief", paramString2);
  }
  
  public static QfavBuilder a(String paramString1, int paramInt, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    paramInt = QfavUtil.b(paramInt);
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    if ((4 == paramInt) || (5 == paramInt)) {
      str = String.valueOf(paramLong1);
    }
    return new QfavBuilder(2).b("sMD5", paramString1).b("sPath", paramString3).a("nPicType", paramInt).b("sPicId", str).a("lSize", paramLong2);
  }
  
  public static QfavBuilder a(String paramString1, String paramString2)
  {
    return new QfavBuilder(1).b("sText", paramString2).b("sTitle", paramString1);
  }
  
  public static QfavBuilder a(ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong, String paramString3)
  {
    paramArrayList = new QfavBuilder(8).a("sPathList", paramArrayList).b("sTitle", paramString1).a("bOnlyPic", paramBoolean1).b("sText", paramString2).a("bAppShare", paramBoolean2).a("lAppId", paramLong).b("sAppName", paramString3);
    if (paramBoolean2) {
      paramLong = 4L;
    } else {
      paramLong = 1L;
    }
    return paramArrayList.a("lCategory", paramLong);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    if (paramIntent != null) {
      QfavHelper.a(paramActivity, paramIntent.getStringExtra("lUin"), paramIntent.getBooleanExtra("bFailed", false) ^ true, null, false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject1 = (MessageForArkApp)paramChatMessage;
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      if (((MessageForArkApp)localObject1).ark_app_message == null) {
        return;
      }
      localObject3 = (MessageForArkApp)ArkAppCenterCheckEvent.a(1, ((MessageForArkApp)localObject1).ark_app_message.appName, localObject1, localObject1);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = localObject1;
      }
      if (localObject2 != null) {
        if (((MessageForArkApp)localObject2).ark_app_message == null) {
          return;
        }
      }
    }
    label1038:
    label1039:
    label1048:
    label1053:
    do
    {
      for (;;)
      {
        try
        {
          localObject5 = new JSONObject(((MessageForArkApp)localObject2).ark_app_message.metaList);
          boolean bool = QQMapConstants.c.equals(((MessageForArkApp)localObject1).ark_app_message.appName);
          if (bool)
          {
            localObject4 = ((JSONObject)localObject5).getJSONObject("Location.Search");
            localObject1 = ((JSONObject)localObject4).getString("name");
            localObject2 = ((JSONObject)localObject4).getString("address");
            localObject3 = ((JSONObject)localObject4).getString("lat");
            localObject4 = ((JSONObject)localObject4).getString("lng");
            a(Float.parseFloat((String)localObject3), Float.parseFloat((String)localObject4), (String)localObject1, (String)localObject2, "").b(paramQQAppInterface, paramChatMessage).a((Activity)paramContext, paramChatMessage.senderuin);
            QfavReport.a(paramQQAppInterface, 11, 0, paramChatMessage.istroop);
            return;
          }
          bool = "com.tencent.structmsg".equals(((MessageForArkApp)localObject1).ark_app_message.appName);
          localObject4 = null;
          localObject3 = null;
          if (bool)
          {
            if (!((JSONObject)localObject5).has("music")) {
              break label1039;
            }
            localObject1 = ((JSONObject)localObject5).getJSONObject("music");
            i = 1;
            if (((JSONObject)localObject5).has("news")) {
              localObject1 = ((JSONObject)localObject5).getJSONObject("news");
            }
            if (localObject1 != null)
            {
              localObject3 = paramContext.getString(2131718597);
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(((JSONObject)localObject1).getString("title"));
              ((StringBuilder)localObject4).append("-");
              ((StringBuilder)localObject4).append(((JSONObject)localObject1).optString("desc"));
              localObject4 = ((StringBuilder)localObject4).toString();
              localObject5 = ((JSONObject)localObject1).optString("tag");
              str1 = ((JSONObject)localObject1).getString("preview");
              str2 = ((JSONObject)localObject1).getString("jumpUrl");
              str3 = ((JSONObject)localObject1).optString("musicUrl", "");
              localObject1 = Long.valueOf(((JSONObject)localObject1).getLong("appid"));
              if ((((Long)localObject1).longValue() == 100243533L) || (((Long)localObject1).longValue() == 100497308L) || (((Long)localObject1).longValue() == 100495085L) || (((Long)localObject1).longValue() == 205141L) || (((Long)localObject1).longValue() == 100895899L)) {
                break label1048;
              }
              if (!str2.startsWith("http")) {
                return;
              }
              localObject1 = ((MessageForArkApp)localObject2).ark_app_message.toAppXml().getBytes();
              localObject2 = new ArrayList();
              ((ArrayList)localObject2).add(localObject1);
              if (i == 0) {
                break label1053;
              }
              i = 4;
              a(i, (String)localObject3, str2, (String)localObject5, (String)localObject4, str1, str3, null, false, 0L).b("sBizDataList", (ArrayList)localObject2).b(paramQQAppInterface, paramChatMessage).a((Activity)paramContext, paramChatMessage.senderuin);
              QfavReport.a(paramQQAppInterface, 9, 0, paramChatMessage.istroop);
              return;
            }
            QfavReport.a(paramQQAppInterface, 8, 0, paramChatMessage.istroop);
            return;
          }
          if (!"com.tencent.miniapp_01".equals(((MessageForArkApp)localObject1).ark_app_message.appName)) {
            break label1038;
          }
          localObject1 = localObject4;
          if (!((JSONObject)localObject5).has("detail_1")) {
            break;
          }
          localObject1 = ((JSONObject)localObject5).getJSONObject("detail_1");
        }
        catch (Exception paramQQAppInterface)
        {
          Object localObject5;
          Object localObject4;
          String str1;
          String str2;
          String str3;
          long l;
          ArrayList localArrayList;
          QLog.e("qqfav", 1, paramQQAppInterface, new Object[0]);
        }
        localObject4 = ((JSONObject)localObject1).getString("title");
        localObject5 = ((JSONObject)localObject1).optString("desc");
        localObject3 = ((JSONObject)localObject1).getString("preview");
        str1 = ((JSONObject)localObject1).getString("url");
        str2 = ((JSONObject)localObject1).getString("icon");
        l = ((JSONObject)localObject1).getLong("appid");
        str3 = ((MessageForArkApp)localObject2).ark_app_message.promptText;
        localArrayList = new ArrayList();
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("appName", ((MessageForArkApp)localObject2).ark_app_message.appName);
        ((JSONObject)localObject1).put("appView", ((MessageForArkApp)localObject2).ark_app_message.appView);
        ((JSONObject)localObject1).put("metaData", ((MessageForArkApp)localObject2).ark_app_message.metaList);
        ((JSONObject)localObject1).put("appMinVersion", ((MessageForArkApp)localObject2).ark_app_message.appMinVersion);
        ((JSONObject)localObject1).put("appConfig", ((MessageForArkApp)localObject2).ark_app_message.config);
        ((JSONObject)localObject1).put("compatibleText", ((MessageForArkApp)localObject2).ark_app_message.compatibleText);
        ((JSONObject)localObject1).put("promptText", ((MessageForArkApp)localObject2).ark_app_message.promptText);
        ((JSONObject)localObject1).put("appDesc", localObject5);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("arkAppInfo", localObject1);
        localArrayList.add(((JSONObject)localObject2).toString().getBytes());
        localObject1 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = localObject3;
          if (!((String)localObject3).startsWith("http"))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("https://");
            ((StringBuilder)localObject1).append((String)localObject3);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramContext.getString(2131692218));
        ((StringBuilder)localObject2).append((String)localObject4);
        a(8, ((StringBuilder)localObject2).toString(), str1, str3, (String)localObject5, (String)localObject1, str2, null, false, Long.valueOf(l).longValue()).b("sBizDataList", localArrayList).b(paramQQAppInterface, paramChatMessage).a((Activity)paramContext, paramChatMessage.senderuin);
        return;
        return;
        int i = 0;
        localObject1 = localObject3;
        continue;
        i = 1;
        continue;
        i = 5;
      }
    } while (localObject1 != null);
  }
  
  public static QfavBuilder b(Entity paramEntity)
  {
    return new QfavBuilder(8).c(paramEntity);
  }
  
  public static QfavBuilder b(String paramString)
  {
    return new QfavBuilder(2).b("sPath", paramString);
  }
  
  public Intent a()
  {
    return this.a;
  }
  
  public QfavBuilder a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    this.a.putExtra("nAuthorType", paramInt).putExtra("lUin", paramLong1).putExtra("sName", paramString1).putExtra("lGroupUin", paramLong2).putExtra("sGroupName", paramString2);
    return this;
  }
  
  public QfavBuilder a(long paramLong)
  {
    return a("requestId", paramLong);
  }
  
  public QfavBuilder a(long paramLong, String paramString)
  {
    this.a.putExtra("nAuthorType", 1).putExtra("lUin", paramLong).putExtra("sName", paramString);
    return this;
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    return a(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue(), paramQQAppInterface.getCurrentNickname());
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      if (paramQQAppInterface == null) {
        return this;
      }
      return a(paramQQAppInterface, paramMessageRecord, paramMessageRecord.senderuin, paramMessageRecord.frienduin, paramMessageRecord.issend, paramMessageRecord.istroop);
    }
    return this;
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject2 = paramString2;
    String str1 = "";
    if (paramQQAppInterface == null) {
      return this;
    }
    int i = QfavUtil.a(paramInt2);
    Object localObject3;
    if (TextUtils.isEmpty(paramString1))
    {
      localObject3 = localObject2;
      paramInt2 = 0;
      i = 1;
    }
    else
    {
      localObject3 = paramString1;
    }
    long l2 = 0L;
    label655:
    label784:
    label791:
    for (;;)
    {
      long l1;
      try
      {
        if (MessageRecordInfo.a(paramInt1))
        {
          localObject1 = paramQQAppInterface.getCurrentNickname();
          paramString1 = (String)localObject1;
          try
          {
            l1 = Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue();
            paramString1 = str1;
            paramString2 = (String)localObject1;
            l3 = l2;
            l2 = l1;
            l1 = l3;
          }
          catch (Exception paramString2)
          {
            l1 = 0L;
            paramMessageRecord = "";
            paramQQAppInterface = paramString1;
            paramString1 = paramString2;
            break label655;
          }
        }
        else
        {
          if (paramInt2 != 1006) {
            break label702;
          }
          if (localObject3 == null) {
            break label688;
          }
          paramString2 = ContactUtils.a(paramQQAppInterface, (String)localObject3, paramInt2);
          l1 = 0L;
          paramString1 = "";
          continue;
          localObject1 = ContactUtils.a(paramQQAppInterface, (String)localObject3, paramInt2);
          paramString1 = (String)localObject1;
          l1 = Long.valueOf((String)localObject3).longValue();
          paramString1 = str1;
          continue;
          label178:
          str2 = ContactUtils.a(paramQQAppInterface, (String)localObject3, 0);
          paramString1 = str2;
          localObject1 = str2;
          if (str2.equals(localObject3))
          {
            localObject1 = str2;
            if (paramInt2 == 3000)
            {
              paramString1 = str2;
              localObject1 = ContactUtils.a(paramQQAppInterface, (String)localObject2, (String)localObject3);
            }
          }
          paramString1 = (String)localObject1;
          l1 = Long.valueOf((String)localObject3).longValue();
          if (1 == paramInt2) {}
          try
          {
            paramString1 = ContactUtils.a(paramQQAppInterface, (String)localObject2, true);
            continue;
            paramString1 = ContactUtils.b(paramQQAppInterface, (String)localObject2);
            str1 = paramString1;
            l2 = Long.valueOf(paramString2).longValue();
          }
          catch (Exception paramString1)
          {
            paramMessageRecord = str1;
            paramQQAppInterface = (QQAppInterface)localObject1;
            l3 = 0L;
            l2 = l1;
            l1 = l3;
            break label655;
          }
          label303:
          localObject1 = ContactUtils.a(paramQQAppInterface, (String)localObject2, paramInt2);
          paramString1 = (String)localObject1;
          l1 = Long.valueOf(paramString2).longValue();
          paramString1 = str1;
          continue;
        }
        label332:
        str1 = paramString2;
        if (paramMessageRecord != null)
        {
          str1 = paramString2;
          localObject1 = paramString2;
          str2 = paramString1;
        }
        try
        {
          if (AnonymousChatHelper.a(paramMessageRecord))
          {
            localObject1 = paramString2;
            str2 = paramString1;
            if (paramMessageRecord.selfuin != null)
            {
              str1 = paramString2;
              localObject1 = paramString2;
              str2 = paramString1;
              if (paramMessageRecord.selfuin.equals(paramMessageRecord.senderuin)) {}
            }
            else
            {
              localObject1 = paramString2;
              str2 = paramString1;
              str1 = BaseApplicationImpl.getContext().getString(2131690010);
            }
          }
          localObject1 = str1;
          str2 = paramString1;
          paramString2 = TroopBusinessUtil.a(paramMessageRecord);
          paramMessageRecord = str1;
          if (paramString2 == null) {
            break label738;
          }
          localObject1 = str1;
          str2 = paramString1;
          paramMessageRecord = paramString2.c;
        }
        catch (Exception paramString1)
        {
          paramQQAppInterface = (QQAppInterface)localObject1;
          paramMessageRecord = str2;
          break label655;
        }
        if (1000 != paramInt2) {
          break label791;
        }
        localObject1 = paramMessageRecord;
        str2 = paramString1;
        paramString2 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (paramString2 == null) {
          break label784;
        }
        localObject1 = paramMessageRecord;
        str2 = paramString1;
        paramString2 = paramString2.b((String)localObject3);
        localObject1 = paramMessageRecord;
        str2 = paramString1;
        paramString1 = ContactUtils.a(paramQQAppInterface, paramString2, true);
        localObject1 = paramMessageRecord;
        str2 = paramString1;
        l3 = Long.valueOf(paramString2).longValue();
        l1 = l3;
        if ((paramInt2 != 1004) && (paramInt2 != 3000))
        {
          localObject1 = paramMessageRecord;
          paramString2 = paramString1;
          l4 = l2;
          l3 = l1;
          break label673;
        }
        if (paramInt2 == 1004) {
          localObject2 = localObject3;
        }
        try
        {
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, (String)localObject2);
          try
          {
            l3 = Long.valueOf((String)localObject2).longValue();
            localObject1 = paramMessageRecord;
            paramString2 = paramQQAppInterface;
            l4 = l2;
          }
          catch (Exception paramString1)
          {
            paramString2 = paramQQAppInterface;
          }
          paramQQAppInterface = paramMessageRecord;
        }
        catch (Exception paramQQAppInterface)
        {
          paramString2 = paramString1;
          paramString1 = paramQQAppInterface;
        }
        paramMessageRecord = paramString2;
      }
      catch (Exception paramString1)
      {
        String str2;
        paramMessageRecord = "";
        l1 = 0L;
        paramQQAppInterface = str1;
      }
      paramString1.printStackTrace();
      long l3 = l1;
      long l4 = l2;
      paramString2 = paramMessageRecord;
      Object localObject1 = paramQQAppInterface;
      label673:
      label688:
      label702:
      label738:
      do
      {
        return a(i, l4, (String)localObject1, l3, paramString2);
        paramString1 = "";
        l1 = 0L;
        paramString2 = str1;
        break label332;
        if ((paramInt2 == 1004) || (paramInt2 == 1000)) {
          break label303;
        }
        if (paramInt2 == 1) {
          break label178;
        }
        if (paramInt2 != 3000) {
          break;
        }
        break label178;
        if (2 == i) {
          break label764;
        }
        localObject1 = paramMessageRecord;
        paramString2 = paramString1;
        l4 = l2;
        l3 = l1;
      } while (3 != i);
      label764:
      if ((1 != paramInt2) && (1000 != paramInt2))
      {
        continue;
        paramString2 = (String)localObject3;
        continue;
        paramString2 = (String)localObject2;
      }
    }
  }
  
  public QfavBuilder a(String paramString, float paramFloat)
  {
    this.a.putExtra(paramString, paramFloat);
    return this;
  }
  
  public QfavBuilder a(String paramString, int paramInt)
  {
    this.a.putExtra(paramString, paramInt);
    return this;
  }
  
  public QfavBuilder a(String paramString, long paramLong)
  {
    this.a.putExtra(paramString, paramLong);
    return this;
  }
  
  public QfavBuilder a(String paramString, ArrayList<String> paramArrayList)
  {
    this.a.putStringArrayListExtra(paramString, paramArrayList);
    return this;
  }
  
  public QfavBuilder a(String paramString, boolean paramBoolean)
  {
    this.a.putExtra(paramString, paramBoolean);
    return this;
  }
  
  public boolean a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131692185, null);
  }
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    if (paramActivity == null) {
      return false;
    }
    this.a.putExtra("nOperation", 1);
    this.a.putExtra("lCollectTime", System.currentTimeMillis());
    if (paramIntent != null) {
      paramIntent.putExtras(this.a);
    } else {
      paramIntent = this.a;
    }
    return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    QfavRequestQueue.a().a = true;
    if (paramActivity == null) {
      return false;
    }
    this.a.putExtra("nOperation", 0);
    this.a.putExtra("lCollectTime", System.currentTimeMillis());
    if (paramIntent != null) {
      paramIntent.putExtras(this.a);
    } else {
      paramIntent = this.a;
    }
    if (paramIntent.getIntExtra("nType", 0) == 2)
    {
      String str = paramIntent.getStringExtra("sPath");
      if ((paramIntent.getIntExtra("nPicType", 1) == 1) && (QfavUtil.a(str, paramIntent.getLongExtra("lSize", -1L))))
      {
        paramIntent.putExtra("nReasonInt", 2131694914);
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("QfavBuilder.add: picture too big [");
          paramActivity.append(str);
          paramActivity.append("]");
          QLog.i("qqfav", 1, paramActivity.toString());
        }
        QfavReport.a(null, "Net_AddFav", 3, 3, -3);
        return false;
      }
    }
    return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt, paramBoolean);
  }
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, QfavBuilder.OnAddFav paramOnAddFav)
  {
    Object localObject2 = null;
    boolean bool = b(paramActivity, paramString, -1, null);
    Object localObject1 = localObject2;
    if (!bool)
    {
      Intent localIntent = this.a;
      localObject1 = localObject2;
      if (localIntent != null) {
        localObject1 = paramActivity.getString(localIntent.getIntExtra("nReasonInt", 2131692186));
      }
    }
    QfavHelper.a(paramActivity, paramString, bool, (String)localObject1, false, paramInt);
    if (paramOnAddFav != null) {
      paramOnAddFav.b(bool);
    }
    return bool;
  }
  
  public boolean a(Context paramContext)
  {
    if (this.a == null) {
      return false;
    }
    QfavPluginProxyService.a();
    Bundle localBundle = this.a.getExtras();
    Object localObject = localBundle;
    if (localBundle == null) {
      localObject = new Bundle();
    }
    boolean bool = QfavPluginProxyService.a().a("com.tencent.qqfav", 4, (Bundle)localObject);
    localObject = null;
    if (!bool) {
      localObject = paramContext.getString(this.a.getIntExtra("nReasonInt", 2131692186));
    }
    QfavHelper.a(paramContext, "", bool, (String)localObject, false, 2131692185);
    return bool;
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt, Intent paramIntent)
  {
    QfavRequestQueue.a().a = true;
    if (paramContext == null) {
      return false;
    }
    this.a.putExtra("nOperation", 0);
    this.a.putExtra("lCollectTime", System.currentTimeMillis());
    if (paramIntent != null) {
      paramIntent.putExtras(this.a);
    } else {
      paramIntent = this.a;
    }
    if (paramIntent.getIntExtra("nType", 0) == 2)
    {
      String str = paramIntent.getStringExtra("sPath");
      if ((paramIntent.getIntExtra("nPicType", 1) == 1) && (QfavUtil.a(str, paramIntent.getLongExtra("lSize", -1L))))
      {
        paramIntent.putExtra("nReasonInt", 2131694914);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("QfavBuilder.add: picture too big [");
          paramContext.append(str);
          paramContext.append("]");
          QLog.i("qqfav", 1, paramContext.toString());
        }
        QfavReport.a(null, "Net_AddFav", 3, 3, -3);
        return false;
      }
    }
    return QfavPluginProxyActivity.a(paramContext, paramString, paramIntent, paramInt);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    return a(paramQQAppInterface, paramContext, paramFileManagerEntity, paramChatMessage, paramBoolean, "", false);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    return a(paramQQAppInterface, paramContext, null, null, false, paramString, true);
  }
  
  public QfavBuilder b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramMessageRecord);
    long l;
    if (paramMessageRecord == null) {
      l = new Date().getTime();
    } else {
      l = paramMessageRecord.time * 1000L;
    }
    return paramQQAppInterface.a("lCreateTime", l);
  }
  
  public QfavBuilder b(String paramString1, String paramString2)
  {
    this.a.putExtra(paramString1, paramString2);
    return this;
  }
  
  public QfavBuilder b(String paramString, ArrayList<byte[]> paramArrayList)
  {
    this.a.putExtra(paramString, paramArrayList);
    return this;
  }
  
  public boolean b(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    return a(paramActivity, paramString, paramInt, paramIntent, true);
  }
  
  public QfavBuilder c(Entity paramEntity)
  {
    this.a.putExtra("cvEntityContents", QfavUtil.a(paramEntity, ""));
    this.a.putExtra("sEntityClassName", paramEntity.getClass().getName());
    return this;
  }
  
  public QfavBuilder c(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      this.a.putExtra("nAuthorType", 1).putExtra("lUin", l);
      return this;
    }
    catch (Exception paramString) {}
    return this;
  }
  
  public boolean c(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    boolean bool = b(paramActivity, paramString, paramInt, paramIntent);
    QfavHelper.a(paramActivity, paramString, bool, "", false, 2131692185);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.QfavBuilder
 * JD-Core Version:    0.7.0.1
 */