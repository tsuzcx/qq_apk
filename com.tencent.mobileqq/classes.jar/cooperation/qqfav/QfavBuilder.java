package cooperation.qqfav;

import amwi;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class QfavBuilder
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
    if (paramBoolean) {}
    for (paramLong = 4L;; paramLong = 1L) {
      return paramString1.a("lCategory", paramLong);
    }
  }
  
  public static QfavBuilder a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("shortVideoBusiType", Integer.valueOf(paramIntent.getIntExtra("from_busi_type", 1)));
    localContentValues.put("shortVideoDuration", Integer.valueOf(paramIntent.getIntExtra("file_send_duration", 0)));
    localContentValues.put("shortVideoFormat", Integer.valueOf(paramIntent.getIntExtra("file_format", 0)));
    Object localObject = paramIntent.getStringExtra("file_send_path");
    localContentValues.put("shortVideoLocalPath", (String)localObject);
    localContentValues.put("shortVideoMd5", paramIntent.getStringExtra("file_shortvideo_md5"));
    long l;
    if (new File((String)localObject).exists())
    {
      l = new File((String)localObject).length();
      localContentValues.put("shortVideoSize", Long.valueOf(l));
      String str = paramIntent.getStringExtra("file_name");
      localContentValues.put("shortVideoFileName", str.substring(str.lastIndexOf('/') + 1, str.length()));
      localContentValues.put("shortVideoThumbHeight", Integer.valueOf(paramIntent.getIntExtra("thumbfile_send_height", 0)));
      localContentValues.put("shortVideoThumbMd5", paramIntent.getStringExtra("thumbfile_md5"));
      if (!new File((String)localObject).exists()) {
        break label322;
      }
    }
    label322:
    for (int i = (int)new File((String)localObject).length();; i = paramIntent.getIntExtra("file_thumb_Size", 0))
    {
      localContentValues.put("shortVideoThumbSize", Integer.valueOf(i));
      localContentValues.put("shortVideoThumbWidth", Integer.valueOf(paramIntent.getIntExtra("thumbfile_send_width", 0)));
      localContentValues.put("shortVideoThumbLocalPath", paramIntent.getStringExtra("thumbfile_send_path"));
      localContentValues.put("shortVideoUuid", paramIntent.getStringExtra("file_uuid"));
      localObject = new QfavBuilder(5);
      ((QfavBuilder)localObject).a.putExtra("shortVideoContents", localContentValues);
      return ((QfavBuilder)localObject).c(paramIntent.getStringExtra("from_uin"));
      l = 0L;
      break;
    }
  }
  
  public static QfavBuilder a(MessageForShortVideo paramMessageForShortVideo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("shortVideoDuration", Integer.valueOf(paramMessageForShortVideo.videoFileTime));
    localContentValues.put("shortVideoFileTYPE", Integer.valueOf(paramMessageForShortVideo.fileType));
    localContentValues.put("shortVideoFormat", Integer.valueOf(paramMessageForShortVideo.videoFileFormat));
    localContentValues.put("shortVideoMd5", paramMessageForShortVideo.md5);
    int i;
    String str;
    if (paramMessageForShortVideo.busiType == 0)
    {
      i = 1;
      localContentValues.put("shortVideoBusiType", Integer.valueOf(i));
      str = ShortVideoUtils.a(paramMessageForShortVideo);
      localContentValues.put("shortVideoLocalPath", str);
      long l2 = paramMessageForShortVideo.videoFileSize;
      l1 = l2;
      if (str != null)
      {
        l1 = l2;
        if (new File(str).exists()) {
          l1 = new File(str).length();
        }
      }
      localContentValues.put("shortVideoSize", Long.valueOf(l1));
      if (str != null) {
        break label329;
      }
      str = "";
      label163:
      localContentValues.put("shortVideoFileName", str.substring(str.lastIndexOf('/') + 1, str.length()));
      localContentValues.put("shortVideoThumbHeight", Integer.valueOf(paramMessageForShortVideo.thumbHeight));
      localContentValues.put("shortVideoThumbMd5", paramMessageForShortVideo.thumbMD5);
      localContentValues.put("shortVideoThumbWidth", Integer.valueOf(paramMessageForShortVideo.thumbWidth));
      str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      if (!new File(str).exists()) {
        break label332;
      }
    }
    label329:
    label332:
    for (long l1 = new File(str).length();; l1 = paramMessageForShortVideo.thumbFileSize)
    {
      localContentValues.put("shortVideoThumbSize", Long.valueOf(l1));
      localContentValues.put("shortVideoThumbLocalPath", str);
      localContentValues.put("shortVideoUuid", paramMessageForShortVideo.uuid);
      paramMessageForShortVideo = new QfavBuilder(5);
      paramMessageForShortVideo.a.putExtra("shortVideoContents", localContentValues);
      return paramMessageForShortVideo;
      i = paramMessageForShortVideo.busiType;
      break;
      break label163;
    }
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
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      if ((4 == paramInt) || (5 == paramInt)) {
        paramString2 = String.valueOf(paramLong1);
      }
      return new QfavBuilder(2).b("sMD5", paramString1).b("sPath", paramString3).a("nPicType", paramInt).b("sPicId", paramString2).a("lSize", paramLong2);
    }
  }
  
  public static QfavBuilder a(String paramString1, String paramString2)
  {
    return new QfavBuilder(1).b("sText", paramString2).b("sTitle", paramString1);
  }
  
  public static QfavBuilder a(ArrayList paramArrayList, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong, String paramString3)
  {
    paramArrayList = new QfavBuilder(8).a("sPathList", paramArrayList).b("sTitle", paramString1).a("bOnlyPic", paramBoolean1).b("sText", paramString2).a("bAppShare", paramBoolean2).a("lAppId", paramLong).b("sAppName", paramString3);
    if (paramBoolean2) {}
    for (paramLong = 4L;; paramLong = 1L) {
      return paramArrayList.a("lCategory", paramLong);
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getStringExtra("lUin");
      if (paramIntent.getBooleanExtra("bFailed", false)) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      QfavHelper.a(paramActivity, str, bool, null, false);
      return;
    }
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
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {
      return this;
    }
    return a(paramQQAppInterface, paramMessageRecord, paramMessageRecord.senderuin, paramMessageRecord.frienduin, paramMessageRecord.issend, paramMessageRecord.istroop);
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    int i = QfavUtil.a(paramInt2);
    String str2 = "";
    long l6 = 0L;
    Object localObject4 = "";
    long l5 = 0L;
    String str1;
    long l4;
    Object localObject2;
    long l3;
    Object localObject1;
    Object localObject3;
    long l2;
    if (TextUtils.isEmpty(paramString1))
    {
      i = 1;
      paramInt2 = 0;
      str1 = paramString2;
      l4 = l5;
      localObject2 = localObject4;
      paramString1 = str2;
      l3 = l6;
      for (;;)
      {
        try
        {
          if (!MsgUtils.a(paramInt1)) {
            continue;
          }
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = str2;
          l3 = l6;
          localObject1 = paramQQAppInterface.getCurrentNickname();
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = (String)localObject1;
          l3 = l6;
          l1 = Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue();
          localObject3 = localObject4;
          l2 = l5;
          label123:
          localObject4 = localObject1;
          if (paramMessageRecord != null)
          {
            localObject4 = localObject1;
            l4 = l2;
            localObject2 = localObject3;
            paramString1 = (String)localObject1;
            l3 = l1;
            if (AnonymousChatHelper.a(paramMessageRecord))
            {
              l4 = l2;
              localObject2 = localObject3;
              paramString1 = (String)localObject1;
              l3 = l1;
              if (paramMessageRecord.selfuin != null)
              {
                localObject4 = localObject1;
                l4 = l2;
                localObject2 = localObject3;
                paramString1 = (String)localObject1;
                l3 = l1;
                if (paramMessageRecord.selfuin.equals(paramMessageRecord.senderuin)) {}
              }
              else
              {
                l4 = l2;
                localObject2 = localObject3;
                paramString1 = (String)localObject1;
                l3 = l1;
                localObject4 = BaseApplicationImpl.getContext().getString(2131431727);
              }
            }
          }
          l4 = l2;
          localObject2 = localObject3;
          paramString1 = (String)localObject4;
          l3 = l1;
          localObject1 = TroopBusinessUtil.a(paramMessageRecord);
          paramMessageRecord = (MessageRecord)localObject4;
          if (localObject1 == null) {
            break label955;
          }
          l4 = l2;
          localObject2 = localObject3;
          paramString1 = (String)localObject4;
          l3 = l1;
          paramMessageRecord = ((TroopBusinessUtil.TroopBusinessMessage)localObject1).c;
        }
        catch (Exception paramString2)
        {
          label291:
          label458:
          l2 = l3;
          label402:
          label546:
          paramQQAppInterface = localObject2;
          paramMessageRecord = paramString1;
          long l1 = l4;
          paramString1 = paramString2;
          paramString1.printStackTrace();
          l3 = l1;
          continue;
          localObject1 = str1;
          continue;
          localObject1 = paramString2;
          continue;
        }
        if (1000 != paramInt2) {
          continue;
        }
        l4 = l2;
        localObject2 = localObject3;
        paramString1 = paramMessageRecord;
        l3 = l1;
        localObject1 = (TroopManager)paramQQAppInterface.getManager(51);
        if (localObject1 == null) {
          continue;
        }
        l4 = l2;
        localObject2 = localObject3;
        paramString1 = paramMessageRecord;
        l3 = l1;
        localObject1 = ((TroopManager)localObject1).b(str1);
        l4 = l2;
        localObject2 = localObject3;
        paramString1 = paramMessageRecord;
        l3 = l1;
        localObject3 = ContactUtils.a(paramQQAppInterface, (String)localObject1, true);
        l4 = l2;
        localObject2 = localObject3;
        paramString1 = paramMessageRecord;
        l3 = l1;
        l2 = Long.valueOf((String)localObject1).longValue();
        paramString1 = (String)localObject3;
        if (paramInt2 != 1004)
        {
          localObject1 = paramString1;
          l3 = l2;
          if (paramInt2 != 3000) {}
        }
        else if (paramInt2 == 1004)
        {
          paramString2 = str1;
        }
        try
        {
          localObject1 = ContactUtils.c(paramQQAppInterface, paramString2);
          paramString1 = (String)localObject1;
          l3 = Long.valueOf(paramString2).longValue();
          paramQQAppInterface = (QQAppInterface)localObject1;
          l2 = l1;
          return a(i, l2, paramMessageRecord, l3, paramQQAppInterface);
        }
        catch (Exception paramString2)
        {
          paramQQAppInterface = paramString1;
          l3 = l2;
          paramString1 = paramString2;
          l2 = l1;
          l1 = l3;
          continue;
        }
        if (paramInt2 != 1006) {
          break label984;
        }
        l2 = l5;
        localObject3 = localObject4;
        localObject1 = str2;
        l1 = l6;
        if (str1 != null)
        {
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = str2;
          l3 = l6;
          localObject1 = ContactUtils.b(paramQQAppInterface, str1, paramInt2);
          l1 = 0L;
          l2 = l5;
          localObject3 = localObject4;
          continue;
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = str2;
          l3 = l6;
          localObject1 = ContactUtils.b(paramQQAppInterface, paramString2, paramInt2);
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = (String)localObject1;
          l3 = l6;
          l1 = Long.valueOf(paramString2).longValue();
          l2 = l5;
          localObject3 = localObject4;
        }
      }
    }
    for (;;)
    {
      label607:
      l4 = l5;
      localObject2 = localObject4;
      paramString1 = str2;
      l3 = l6;
      localObject3 = ContactUtils.b(paramQQAppInterface, str1, 0);
      localObject1 = localObject3;
      l4 = l5;
      localObject2 = localObject4;
      paramString1 = (String)localObject3;
      l3 = l6;
      if (((String)localObject3).equals(str1))
      {
        localObject1 = localObject3;
        if (paramInt2 == 3000)
        {
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = (String)localObject3;
          l3 = l6;
          localObject1 = ContactUtils.a(paramQQAppInterface, paramString2, str1);
        }
      }
      l4 = l5;
      localObject2 = localObject4;
      paramString1 = (String)localObject1;
      l3 = l6;
      l1 = Long.valueOf(str1).longValue();
      if (1 == paramInt2)
      {
        l4 = l5;
        localObject2 = localObject4;
        paramString1 = (String)localObject1;
        l3 = l1;
      }
      for (localObject3 = ContactUtils.a(paramQQAppInterface, paramString2, true);; localObject3 = ContactUtils.c(paramQQAppInterface, paramString2))
      {
        l4 = l5;
        localObject2 = localObject3;
        paramString1 = (String)localObject1;
        l3 = l1;
        l2 = Long.valueOf(paramString2).longValue();
        break;
        l4 = l5;
        localObject2 = localObject4;
        paramString1 = (String)localObject1;
        l3 = l1;
      }
      label955:
      label984:
      do
      {
        l4 = l5;
        localObject2 = localObject4;
        paramString1 = str2;
        l3 = l6;
        localObject1 = ContactUtils.b(paramQQAppInterface, str1, paramInt2);
        l4 = l5;
        localObject2 = localObject4;
        paramString1 = (String)localObject1;
        l3 = l6;
        l1 = Long.valueOf(str1).longValue();
        l2 = l5;
        localObject3 = localObject4;
        break label123;
        do
        {
          paramString1 = (String)localObject3;
          break label402;
          do
          {
            localObject1 = localObject3;
            l3 = l2;
            break label458;
            str1 = paramString1;
            break;
          } while ((2 != i) && (3 != i));
          if (1 == paramInt2) {
            break label291;
          }
        } while (1000 != paramInt2);
        break label291;
        if ((paramInt2 == 1004) || (paramInt2 == 1000)) {
          break label546;
        }
        if (paramInt2 == 1) {
          break label607;
        }
      } while (paramInt2 != 3000);
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
  
  public QfavBuilder a(String paramString, ArrayList paramArrayList)
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
    Object localObject2 = null;
    boolean bool = b(paramActivity, paramString, -1, null);
    Object localObject1 = localObject2;
    if (!bool)
    {
      localObject1 = localObject2;
      if (this.a != null) {
        localObject1 = paramActivity.getString(this.a.getIntExtra("nReasonInt", 2131431591));
      }
    }
    QfavHelper.a(paramActivity, paramString, bool, (String)localObject1, false);
    return bool;
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
    }
    for (;;)
    {
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
      paramIntent = this.a;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    String str = FileUtil.a(paramFileManagerEntity.fileName);
    int m = 6;
    if (paramChatMessage == null) {
      m = 7;
    }
    int j = -1;
    int i = j;
    switch (paramFileManagerEntity.getCloudType())
    {
    default: 
      i = j;
    }
    while (paramFileManagerEntity.fileName.getBytes().length >= 256)
    {
      if (!paramBoolean) {
        QfavUtil.a(paramActivity, 2131431595, 1);
      }
      QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80010, m, i, str, null);
      return false;
      if (3000 == paramFileManagerEntity.peerType)
      {
        i = 106;
      }
      else
      {
        i = 3;
        continue;
        i = paramFileManagerEntity.busId;
        continue;
        i = 25;
      }
    }
    int i1 = FileManagerUtil.a(paramFileManagerEntity);
    switch (i1)
    {
    case 3: 
    default: 
      if (!paramBoolean) {
        QfavUtil.a(paramActivity, 2131431593, 0);
      }
      QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80003, m, i, str, null);
      return false;
    case 1: 
      if ((paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
      {
        if (!paramBoolean) {
          QfavUtil.a(paramActivity, 2131431594, 1);
        }
        QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80011, m, i, str, null);
        return false;
      }
      break;
    case 4: 
      if ((104 == paramFileManagerEntity.busId) && (paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
      {
        if (!paramBoolean) {
          QfavUtil.a(paramActivity, 2131431594, 1);
        }
        QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80011, m, i, str, null);
        return false;
      }
      break;
    }
    Object localObject;
    if (paramChatMessage != null)
    {
      a(paramQQAppInterface, paramChatMessage);
      localObject = "";
      paramChatMessage = (ChatMessage)localObject;
    }
    label408:
    label605:
    int k;
    switch (i1)
    {
    default: 
      paramChatMessage = (ChatMessage)localObject;
    case 3: 
      localObject = new ContentValues();
      ((ContentValues)localObject).put("fileUuId", paramChatMessage);
      ((ContentValues)localObject).put("fileCloudType", Integer.valueOf(i1));
      ((ContentValues)localObject).put("fileSize", Long.valueOf(paramFileManagerEntity.fileSize));
      ((ContentValues)localObject).put("fileName", paramFileManagerEntity.fileName);
      ((ContentValues)localObject).put("fileMd5", paramFileManagerEntity.strFileMd5);
      ((ContentValues)localObject).put("filePath", paramFileManagerEntity.getFilePath());
      ((ContentValues)localObject).put("fileThumbPath", paramFileManagerEntity.strThumbPath);
      ((ContentValues)localObject).put("filePeerType", Integer.valueOf(paramFileManagerEntity.peerType));
      this.a.putExtra("fileContents", (Parcelable)localObject);
      if (!paramBoolean)
      {
        paramBoolean = b(paramActivity, paramQQAppInterface.getAccount(), -1, null);
        paramChatMessage = null;
        paramFileManagerEntity = paramChatMessage;
        if (!paramBoolean)
        {
          paramFileManagerEntity = paramChatMessage;
          if (this.a != null) {
            paramFileManagerEntity = paramActivity.getString(this.a.getIntExtra("nReasonInt", 2131431591));
          }
        }
        paramQQAppInterface.runOnUiThread(new amwi(this, paramActivity, paramQQAppInterface, paramBoolean, paramFileManagerEntity));
        QfavReport.a(paramQQAppInterface, "User_AddFav", 6, 0, m, i, str, null);
        return paramBoolean;
        paramChatMessage = paramFileManagerEntity.selfUin;
        localObject = paramFileManagerEntity.peerUin;
        if (paramFileManagerEntity.bSend)
        {
          k = 1;
          label647:
          int n = 0;
          switch (paramFileManagerEntity.peerType)
          {
          default: 
            j = n;
            if (!paramFileManagerEntity.bSend)
            {
              paramChatMessage = paramFileManagerEntity.peerUin;
              j = n;
            }
            label717:
            if (TextUtils.isEmpty(paramChatMessage))
            {
              paramChatMessage = paramQQAppInterface.getCurrentAccountUin();
              k = 1;
            }
            break;
          }
        }
      }
      break;
    }
    for (;;)
    {
      a(paramQQAppInterface, null, paramChatMessage, (String)localObject, k, j);
      break;
      k = 0;
      break label647;
      j = 1;
      break label717;
      j = 3000;
      break label717;
      j = 1004;
      break label717;
      paramChatMessage = paramFileManagerEntity.Uuid;
      break label408;
      paramChatMessage = paramFileManagerEntity.strTroopFilePath;
      break label408;
      if (TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey))
      {
        paramChatMessage = paramFileManagerEntity.WeiYunFileId;
        break label408;
      }
      paramChatMessage = paramFileManagerEntity.WeiYunDirKey + paramFileManagerEntity.WeiYunFileId;
      break label408;
      paramBoolean = b(paramActivity, paramQQAppInterface.getAccount(), -1, null);
      break label605;
    }
  }
  
  public QfavBuilder b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    return a(paramQQAppInterface, paramMessageRecord).a("lCreateTime", paramMessageRecord.time * 1000L);
  }
  
  public QfavBuilder b(String paramString1, String paramString2)
  {
    this.a.putExtra(paramString1, paramString2);
    return this;
  }
  
  public QfavBuilder b(String paramString, ArrayList paramArrayList)
  {
    this.a.putExtra(paramString, paramArrayList);
    return this;
  }
  
  public boolean b(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    if (paramActivity == null) {
      return false;
    }
    this.a.putExtra("nOperation", 0);
    this.a.putExtra("lCollectTime", System.currentTimeMillis());
    if (paramIntent != null)
    {
      paramIntent.putExtras(this.a);
      switch (paramIntent.getIntExtra("nType", 0))
      {
      }
    }
    String str;
    do
    {
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
      paramIntent = this.a;
      break;
      str = paramIntent.getStringExtra("sPath");
    } while ((paramIntent.getIntExtra("nPicType", 1) != 1) || (!QfavUtil.a(str, paramIntent.getLongExtra("lSize", -1L))));
    paramIntent.putExtra("nReasonInt", 2131431654);
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 1, "QfavBuilder.add: picture too big [" + str + "]");
    }
    QfavReport.a(null, "Net_AddFav", 3, 3, -3);
    return false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.QfavBuilder
 * JD-Core Version:    0.7.0.1
 */