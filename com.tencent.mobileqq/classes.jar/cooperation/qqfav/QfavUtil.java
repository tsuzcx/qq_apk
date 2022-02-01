package cooperation.qqfav;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class QfavUtil
{
  private static final Map<String, List<Field>> a = new HashMap();
  
  public static int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 1006)
      {
        if (paramInt != 3000) {
          return 1;
        }
        return 3;
      }
      return 5;
    }
    return 2;
  }
  
  public static long a(List<byte[]> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return -1L;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        long l = a((byte[])paramList.next());
        if (l > 0L) {
          return l;
        }
      }
    }
    return -1L;
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    long l = -1L;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 16) {
        return -1L;
      }
      if (a(paramArrayOfByte, 8) != 5L) {
        return -1L;
      }
      l = a(paramArrayOfByte, 16);
    }
    return l;
  }
  
  private static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l = l << 8 | paramArrayOfByte[(i + paramInt)] & 0xFF;
      i += 1;
    }
    return l;
  }
  
  public static ContentValues a(AppInterface paramAppInterface, FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean)
  {
    if ((paramFileManagerEntity == null) && (TextUtils.isEmpty(paramString))) {
      return null;
    }
    if ((!paramBoolean) && (paramFileManagerEntity == null)) {
      return null;
    }
    QfavRequestQueue.a().a = true;
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = FileManagerUtil.a(paramFileManagerEntity);
    }
    String str1;
    if (i == 5)
    {
      str1 = paramFileManagerEntity.strFilePath;
      paramBoolean = true;
    }
    else
    {
      str1 = paramString;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(str1))) {
      paramString = new File(str1);
    } else {
      paramString = null;
    }
    if (paramFileManagerEntity != null) {
      paramString = paramFileManagerEntity.fileName.getBytes();
    } else if (paramString != null) {
      paramString = paramString.getName().getBytes();
    } else {
      paramString = null;
    }
    if (paramString.length >= 256)
    {
      new ContentValues().put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692202));
      return null;
    }
    if (i != 1)
    {
      if ((i != 2) && (i != 3)) {
        if (i != 4)
        {
          if (i != 5)
          {
            new ContentValues().put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692204));
            return null;
          }
        }
        else if ((104 == paramFileManagerEntity.busId) && (paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
        {
          new ContentValues().put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692201));
          return null;
        }
      }
    }
    else if ((paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
    {
      new ContentValues().put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692201));
      return null;
    }
    if (paramFileManagerEntity != null)
    {
      String str2 = paramFileManagerEntity.selfUin;
      paramString = paramFileManagerEntity.peerUin;
      paramBoolean = paramFileManagerEntity.bSend;
      int j = paramFileManagerEntity.peerType;
      paramString = str2;
      if (j != 1)
      {
        paramString = str2;
        if (j != 1000)
        {
          paramString = str2;
          if (j != 1004)
          {
            paramString = str2;
            if (j != 3000)
            {
              paramString = str2;
              if (!paramFileManagerEntity.bSend) {
                paramString = paramFileManagerEntity.peerUin;
              }
            }
          }
        }
      }
      if (TextUtils.isEmpty(paramString)) {
        paramAppInterface.getCurrentAccountUin();
      }
    }
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4) {
          paramAppInterface = "";
        } else {
          paramAppInterface = paramFileManagerEntity.strTroopFilePath;
        }
      }
      else if (TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey))
      {
        paramAppInterface = paramFileManagerEntity.WeiYunFileId;
      }
      else
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append(paramFileManagerEntity.WeiYunDirKey);
        paramAppInterface.append(paramFileManagerEntity.WeiYunFileId);
        paramAppInterface = paramAppInterface.toString();
      }
    }
    else {
      paramAppInterface = paramFileManagerEntity.Uuid;
    }
    paramString = new ContentValues();
    paramString.put("fileCloudType", Integer.valueOf(i));
    if (paramFileManagerEntity != null)
    {
      paramString.put("fileUuId", paramAppInterface);
      paramString.put("fileSize", Long.valueOf(paramFileManagerEntity.fileSize));
      paramString.put("fileName", paramFileManagerEntity.fileName);
      paramString.put("fileMd5", paramFileManagerEntity.strFileMd5);
      paramString.put("filePath", paramFileManagerEntity.getFilePath());
      paramString.put("fileThumbPath", paramFileManagerEntity.strThumbPath);
      paramString.put("filePeerType", Integer.valueOf(paramFileManagerEntity.peerType));
      paramString.put("fileBid", Integer.valueOf(paramFileManagerEntity.busId));
      return paramString;
    }
    paramString.put("filePath", str1);
    return paramString;
  }
  
  public static ContentValues a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (paramWeiYunFileInfo == null) {
      return null;
    }
    Object localObject;
    if (TextUtils.isEmpty(paramWeiYunFileInfo.b))
    {
      localObject = paramWeiYunFileInfo.jdField_a_of_type_JavaLangString;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramWeiYunFileInfo.b);
      ((StringBuilder)localObject).append(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fileCloudType", Integer.valueOf(2));
    localContentValues.put("fileUuId", (String)localObject);
    localContentValues.put("fileSize", Long.valueOf(paramWeiYunFileInfo.jdField_a_of_type_Long));
    localContentValues.put("fileName", paramWeiYunFileInfo.c);
    localContentValues.put("fileMd5", paramWeiYunFileInfo.i);
    localContentValues.put("filePath", paramWeiYunFileInfo.h);
    localContentValues.put("fileThumbPath", "");
    localContentValues.put("filePeerType", Integer.valueOf(0));
    localContentValues.put("fileBid", Integer.valueOf(25));
    localContentValues.put("fileSha1", paramWeiYunFileInfo.j);
    return localContentValues;
  }
  
  static ContentValues a(Entity paramEntity, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = a(paramEntity).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Field)localIterator.next();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(((Field)localObject2).getName());
      String str = ((StringBuilder)localObject1).toString();
      if (!((Field)localObject2).isAccessible()) {
        ((Field)localObject2).setAccessible(true);
      }
      localObject1 = null;
      try
      {
        localObject2 = ((Field)localObject2).get(paramEntity);
        localObject1 = localObject2;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      StringBuilder localStringBuilder;
      if ((localObject1 instanceof Entity))
      {
        localObject1 = (Entity)localObject1;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(".");
        localContentValues.putAll(a((Entity)localObject1, localStringBuilder.toString()));
      }
      else if ((localObject1 instanceof Integer))
      {
        localContentValues.put(str, (Integer)localObject1);
      }
      else if ((localObject1 instanceof Long))
      {
        localContentValues.put(str, (Long)localObject1);
      }
      else if ((localObject1 instanceof String))
      {
        localContentValues.put(str, (String)localObject1);
      }
      else if ((localObject1 instanceof byte[]))
      {
        localContentValues.put(str, (byte[])localObject1);
      }
      else if ((localObject1 instanceof Short))
      {
        localContentValues.put(str, (Short)localObject1);
      }
      else
      {
        boolean bool = localObject1 instanceof Boolean;
        if (bool) {
          localContentValues.put(str, (Boolean)localObject1);
        } else if ((localObject1 instanceof Double)) {
          localContentValues.put(str, (Double)localObject1);
        } else if ((localObject1 instanceof Float)) {
          localContentValues.put(str, (Float)localObject1);
        } else if ((localObject1 instanceof Byte)) {
          localContentValues.put(str, (Byte)localObject1);
        } else if (bool) {
          localContentValues.put(str, (Boolean)localObject1);
        } else if ((localObject1 instanceof List)) {
          try
          {
            localObject1 = (List)localObject1;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(".");
            localContentValues.putAll(a((List)localObject1, localStringBuilder.toString()));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localContentValues;
  }
  
  private static ContentValues a(List<Entity> paramList, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("n");
      localContentValues.put(((StringBuilder)localObject).toString(), Integer.valueOf(paramList.size()));
      int i = 0;
      while (i < paramList.size())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(".-");
        localContentValues.put(((StringBuilder)localObject).toString(), ((Entity)paramList.get(i)).getClass().getName());
        localObject = (Entity)paramList.get(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(i);
        localStringBuilder.append(".");
        localContentValues.putAll(a((Entity)localObject, localStringBuilder.toString()));
        i += 1;
      }
    }
    return localContentValues;
  }
  
  public static ContentValues a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 16) {
        return null;
      }
      if (a(paramArrayOfByte, 8) != 3L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav", 2, "unParcelStructMsg, is not structMsg");
        }
        return null;
      }
      return a(paramArrayOfByte, 16, paramArrayOfByte.length - 16);
    }
    return null;
  }
  
  public static ContentValues a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, paramInt1, paramInt2);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (ContentValues)ContentValues.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public static Entity a(ContentValues paramContentValues, String paramString)
  {
    return a(paramContentValues, paramString, "");
  }
  
  private static Entity a(ContentValues paramContentValues, String paramString1, String paramString2)
  {
    try
    {
      Entity localEntity = (Entity)Class.forName(paramString1).newInstance();
      paramString1 = localEntity;
      if (localEntity == null) {
        break label625;
      }
      paramString1 = localEntity;
      if (paramContentValues == null) {
        break label625;
      }
      paramString1 = a(localEntity).iterator();
      while (paramString1.hasNext())
      {
        Field localField = (Field)paramString1.next();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(localField.getName());
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = localField.getType();
        boolean bool = Entity.class.isAssignableFrom((Class)localObject2);
        Object localObject3;
        if (bool)
        {
          localObject2 = ((Class)localObject2).getName();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(".");
          localObject1 = a(paramContentValues, (String)localObject2, ((StringBuilder)localObject3).toString());
          localEntity.setStatus(1002);
          localField.set(localEntity, localObject1);
        }
        else if (localObject2 == List.class)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(".n");
          int j = paramContentValues.getAsInteger(((StringBuilder)localObject2).toString()).intValue();
          localObject2 = new ArrayList();
          int i = 0;
          while (i < j)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(".");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append(".-");
            localObject3 = paramContentValues.getAsString(((StringBuilder)localObject3).toString());
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(".");
            localStringBuilder.append(i);
            localStringBuilder.append(".");
            ((ArrayList)localObject2).add(a(paramContentValues, (String)localObject3, localStringBuilder.toString()));
            i += 1;
          }
          localField.set(localEntity, localObject2);
        }
        else if (localObject2 == Long.TYPE)
        {
          localField.set(localEntity, paramContentValues.getAsLong((String)localObject1));
        }
        else if (localObject2 == Integer.TYPE)
        {
          localField.set(localEntity, paramContentValues.getAsInteger((String)localObject1));
        }
        else if (localObject2 == String.class)
        {
          localField.set(localEntity, paramContentValues.getAsString((String)localObject1));
        }
        else if (localObject2 == Byte.TYPE)
        {
          localField.set(localEntity, paramContentValues.getAsByte((String)localObject1));
        }
        else if (localObject2 == [B.class)
        {
          localField.set(localEntity, paramContentValues.getAsByteArray((String)localObject1));
        }
        else if (localObject2 == Short.TYPE)
        {
          localField.set(localEntity, paramContentValues.getAsShort((String)localObject1));
        }
        else if (localObject2 == Boolean.TYPE)
        {
          localField.set(localEntity, paramContentValues.getAsBoolean((String)localObject1));
        }
        else if (localObject2 == Float.TYPE)
        {
          localField.set(localEntity, paramContentValues.getAsFloat((String)localObject1));
        }
        else if (localObject2 == Double.TYPE)
        {
          localField.set(localEntity, paramContentValues.getAsDouble((String)localObject1));
        }
      }
      if (localEntity.getId() != -1L)
      {
        localEntity.setStatus(1001);
        return localEntity;
      }
      localEntity.setStatus(1002);
      return localEntity;
    }
    catch (Exception paramContentValues)
    {
      label623:
      label625:
      break label623;
    }
    paramString1 = null;
    return paramString1;
  }
  
  public static AbsStructMsg a(List<byte[]> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AbsStructMsg localAbsStructMsg = a((byte[])paramList.next());
        if (localAbsStructMsg != null) {
          return localAbsStructMsg;
        }
      }
    }
    return null;
  }
  
  public static AbsStructMsg a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 16) {
        return null;
      }
      if (a(paramArrayOfByte, 8) != 2L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav", 2, "unParcelStructMsg, is not structMsg");
        }
        return null;
      }
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 16];
      System.arraycopy(paramArrayOfByte, 16, arrayOfByte, 0, paramArrayOfByte.length - 16);
      return StructMsgFactory.a(arrayOfByte);
    }
    return null;
  }
  
  public static StructMsgItemImage a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare.getItemCount() > 0)
    {
      paramStructMsgForImageShare = paramStructMsgForImageShare.getItemByIndex(0);
      if ((paramStructMsgForImageShare instanceof StructMsgItemLayoutDefault))
      {
        paramStructMsgForImageShare = (StructMsgItemLayoutDefault)paramStructMsgForImageShare;
        if ((paramStructMsgForImageShare.a.size() > 0) && ((paramStructMsgForImageShare.a.get(0) instanceof StructMsgItemImage))) {
          return (StructMsgItemImage)paramStructMsgForImageShare.a.get(0);
        }
      }
    }
    return null;
  }
  
  public static QfavMergeData.MessageData a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 16) {
        return null;
      }
      if (a(paramArrayOfByte, 8) != 1L) {
        return null;
      }
      Object localObject2 = Parcel.obtain();
      ((Parcel)localObject2).unmarshall(paramArrayOfByte, 16, paramArrayOfByte.length - 16);
      ((Parcel)localObject2).setDataPosition(0);
      Object localObject1 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)localObject2);
      ((Parcel)localObject2).recycle();
      paramArrayOfByte = ((Bundle)localObject1).getString("entityNickName");
      localObject2 = ((Bundle)localObject1).getString("sEntityClassName");
      localObject2 = a((ContentValues)((Bundle)localObject1).getParcelable("cvEntityContents"), (String)localObject2);
      if ((localObject2 instanceof ChatMessage))
      {
        if ((localObject2 instanceof MessageForStructing))
        {
          localObject1 = ((Bundle)localObject1).getByteArray("sEntityData");
          if (localObject1 != null)
          {
            localObject1 = StructMsgFactory.a((byte[])localObject1);
            ((MessageForStructing)localObject2).structingMsg = ((AbsStructMsg)localObject1);
          }
          return new QfavMergeData.MessageData((ChatMessage)localObject2, paramArrayOfByte);
        }
        return new QfavMergeData.MessageData((ChatMessage)localObject2, paramArrayOfByte);
      }
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    return str;
  }
  
  private static String a(Node paramNode)
  {
    if (paramNode.getNodeType() == 3)
    {
      paramNode = paramNode.getNodeValue();
    }
    else
    {
      localObject = new StringBuilder();
      int j = paramNode.getChildNodes().getLength();
      int i = 0;
      while (i < j)
      {
        Node localNode = paramNode.getChildNodes().item(i);
        if ((localNode != null) && (localNode.getNodeType() == 3)) {
          ((StringBuilder)localObject).append(localNode.getNodeValue());
        }
        i += 1;
      }
      paramNode = ((StringBuilder)localObject).toString();
    }
    Object localObject = paramNode;
    if (paramNode == null) {
      localObject = "";
    }
    return localObject;
  }
  
  private static List<Field> a(Entity paramEntity)
  {
    Class localClass = paramEntity.getClass();
    Object localObject1 = (List)a.get(localClass);
    paramEntity = (Entity)localObject1;
    if (localObject1 == null)
    {
      paramEntity = new ArrayList();
      localObject1 = localClass.getFields();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!Modifier.isStatic(localObject2.getModifiers())) {
          paramEntity.add(localObject2);
        }
        i += 1;
      }
      a.put(localClass.getName(), paramEntity);
    }
    return paramEntity;
  }
  
  public static List<QfavMergeData> a(List<byte[]> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (byte[])paramList.next();
        long l1 = a((byte[])localObject, 8);
        if (l1 != 2L)
        {
          long l2;
          if (l1 == 1L)
          {
            l2 = a((byte[])localObject, 0);
            localObject = a((byte[])localObject);
            if (localObject != null) {
              localArrayList.add(new QfavMergeData(l2, l1, ((QfavMergeData.MessageData)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage, ((QfavMergeData.MessageData)localObject).jdField_a_of_type_JavaLangString));
            } else if (QLog.isColorLevel()) {
              QLog.i("qqfav", 2, "unparcelMergeMsg is null");
            }
          }
          else if (l1 == 3L)
          {
            l2 = a((byte[])localObject, 0);
            localObject = a((byte[])localObject);
            if (localObject != null) {
              localArrayList.add(new QfavMergeData(l2, l1, (ContentValues)localObject));
            }
          }
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public static Map<String, String> a(List<byte[]> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Map localMap = a((byte[])paramList.next());
        if (localMap != null) {
          return localMap;
        }
      }
    }
    return null;
  }
  
  public static Map<String, String> a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 16) {
        return null;
      }
      if (a(paramArrayOfByte, 8) != 4L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav", 2, "unParcelStructMsg, is not structMsg");
        }
        return null;
      }
      localObject = Parcel.obtain();
      ((Parcel)localObject).unmarshall(paramArrayOfByte, 16, paramArrayOfByte.length - 16);
      ((Parcel)localObject).setDataPosition(0);
      ContentValues localContentValues = (ContentValues)ContentValues.CREATOR.createFromParcel((Parcel)localObject);
      ((Parcel)localObject).recycle();
      if (localContentValues == null) {
        return null;
      }
      paramArrayOfByte = new HashMap();
      Iterator localIterator = localContentValues.keySet().iterator();
      for (;;)
      {
        localObject = paramArrayOfByte;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
        paramArrayOfByte.put(localObject, localContentValues.getAsString((String)localObject));
      }
    }
    return localObject;
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("dumpFileInfo，cloudtype:");
      paramString3.append(paramInt1);
      paramString3.append(" bid:");
      paramString3.append(paramInt2);
      paramString3.append(" uuid：");
      paramString3.append(paramString1);
      paramString3.append(" troopfilepath:");
      paramString3.append(paramString2);
      paramString3.append(" name:");
      paramString3.append(paramString5);
      paramString3.append(" size:");
      paramString3.append(paramLong);
      paramString3.append(" md5:");
      paramString3.append(paramString6);
      paramString3.append(" path:");
      paramString3.append(paramString7);
      QLog.d("qqfav", 2, paramString3.toString());
    }
  }
  
  public static void a(long paramLong, List<QfavMergeData> paramList1, List<QfavMergeData> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return;
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        QfavMergeData localQfavMergeData = (QfavMergeData)paramList1.next();
        if (localQfavMergeData.b == paramLong) {
          paramList2.add(localQfavMergeData);
        }
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast localQQToast = QQToast.a(paramContext, paramInt2, paramInt1, 2000);
    paramInt1 = paramContext.getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(paramContext, 5.0F);
    paramContext = Looper.getMainLooper();
    if (Thread.currentThread() != paramContext.getThread())
    {
      new Handler(paramContext).post(new QfavUtil.1(localQQToast, paramInt1));
      return;
    }
    localQQToast.b(paramInt1);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramString = QQToast.a(paramContext, paramInt, paramString, 2000);
    paramInt = paramContext.getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(paramContext, 5.0F);
    paramContext = Looper.getMainLooper();
    if (Thread.currentThread() != paramContext.getThread())
    {
      new Handler(paramContext).post(new QfavUtil.2(paramString, paramInt));
      return;
    }
    paramString.b(paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, List<ChatMessage> paramList, Map<String, String> paramMap, ArrayList<byte[]> paramArrayList)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    if ((paramList == null) || (paramList.size() <= 0))
    {
      paramList = MultiMsgManager.a().a(paramQQAppInterface, paramMessageForStructing.uniseq);
      paramMap = null;
    }
    if (paramList == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)localIterator.next();
          if (paramMap != null)
          {
            paramList = (String)paramMap.get(MsgProxyUtils.a(localChatMessage));
            paramArrayList.add(a(paramQQAppInterface, paramMessageForStructing.uniseq, localChatMessage, paramList));
            if (!a(localChatMessage)) {
              continue;
            }
            a(paramQQAppInterface, (MessageForStructing)localChatMessage, null, null, paramArrayList);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        paramMessageForStructing = new StringBuilder();
        paramMessageForStructing.append("parcelMergeMsg exception:");
        paramMessageForStructing.append(paramQQAppInterface);
        QLog.e("qqfav", 2, paramMessageForStructing.toString());
      }
      paramList = null;
    }
  }
  
  private static void a(MessageForFile paramMessageForFile)
  {
    if (paramMessageForFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "dumpFileInfo， messageforfile is null");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "dumpFileInfo， MessageForFile:");
      }
      a(paramMessageForFile.fileName, paramMessageForFile.filePath, paramMessageForFile.fileSize, paramMessageForFile.extStr);
    }
  }
  
  private static void a(MessageForTroopFile paramMessageForTroopFile)
  {
    if (paramMessageForTroopFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "dumpFileInfo， messageforfile is null");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "dumpFileInfo， MessageForTroopFile:");
      }
      a(paramMessageForTroopFile.fileName, paramMessageForTroopFile.uuid, paramMessageForTroopFile.fileSize, paramMessageForTroopFile.extStr);
    }
  }
  
  private static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "dumpFileInfo， entity is null");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "dumpFileInfo， entity");
      }
      a(FileManagerUtil.a(paramFileManagerEntity), paramFileManagerEntity.busId, paramFileManagerEntity.Uuid, paramFileManagerEntity.strTroopFilePath, paramFileManagerEntity.WeiYunDirKey, paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.strFileMd5, paramFileManagerEntity.getFilePath());
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences("mobileQQ", i);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("qfav_click_red_point_");
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (!((SharedPreferences)localObject1).getBoolean((String)localObject2, false)) {
      ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, true).commit();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("favorites_entry_red_point_");
    ((StringBuilder)localObject2).append(paramString);
    paramString = ((StringBuilder)localObject2).toString();
    if (!((SharedPreferences)localObject1).getBoolean(paramString, false)) {
      ((SharedPreferences)localObject1).edit().putBoolean(paramString, true).commit();
    }
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dumpFileInfo， name:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" size:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" strExtInfo:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" path or uuid:");
      localStringBuilder.append(paramString2);
      QLog.d("qqfav", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("QfavEdit", i);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplicationImpl.sApplication.getRuntime().getAccount());
      localStringBuilder.append("QfavEdit");
      boolean bool = ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setEditFlag:");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(",suc:");
        ((StringBuilder)localObject).append(bool);
        QLog.i("qqfav", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static boolean a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("QfavEdit", i);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplicationImpl.sApplication.getRuntime().getAccount());
      localStringBuilder.append("QfavEdit");
      return ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
    }
    return true;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (!SystemUtil.a())
    {
      a(paramActivity, 2131693771, 1);
      return false;
    }
    if (SystemUtil.a() < 500L)
    {
      a(paramActivity, 2131693770, 1);
      return false;
    }
    return true;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    if (paramChatMessage == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      bool1 = bool2;
      if (paramChatMessage.structingMsg != null)
      {
        bool1 = bool2;
        if (paramChatMessage.structingMsg.mMsgServiceID == 35) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("mobileQQ", i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qfav_unsupport_msg_dialog_flag_");
    localStringBuilder.append(paramString);
    return ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramString != null)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = new File(paramString).length();
      }
    }
    return (paramString != null) && (l > 10485760L);
  }
  
  private static byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int j;
    for (int i = 0; i < 8; i = j)
    {
      j = i + 1;
      arrayOfByte[i] = ((byte)(int)(paramLong >> 64 - j * 8 & 0xFF));
    }
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong1, long paramLong2)
  {
    return a(paramLong1, 5L, a(paramLong2));
  }
  
  private static byte[] a(long paramLong1, long paramLong2, Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      return a(paramLong1, paramLong2, (byte[])null);
    }
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return a(paramLong1, paramLong2, paramParcelable);
  }
  
  private static byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    int i;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      i = paramArrayOfByte.length + 16;
    } else {
      i = 16;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(a(paramLong1), 0, arrayOfByte, 0, 8);
    System.arraycopy(a(paramLong2), 0, arrayOfByte, 8, 8);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 16, paramArrayOfByte.length);
    }
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg == null) {
      return null;
    }
    return a(paramLong, 2L, paramAbsStructMsg.getBytes());
  }
  
  public static byte[] a(long paramLong, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() != 0))
    {
      ContentValues localContentValues = new ContentValues();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localContentValues.put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      return a(paramLong, 4L, localContentValues);
    }
    return null;
  }
  
  public static byte[] a(ContentValues paramContentValues)
  {
    if (paramContentValues == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    paramContentValues.writeToParcel(localParcel, 0);
    paramContentValues = localParcel.marshall();
    localParcel.recycle();
    return paramContentValues;
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, long paramLong, ChatMessage paramChatMessage, String paramString)
  {
    if (paramChatMessage == null) {
      return null;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = MultiFavoriteHelper.a(paramQQAppInterface, paramChatMessage);
    }
    if ((!(paramChatMessage instanceof MessageForFile)) && (!(paramChatMessage instanceof MessageForTroopFile)) && (!(paramChatMessage instanceof MessageForDLFile)))
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putParcelable("cvEntityContents", a(paramChatMessage, ""));
      paramQQAppInterface.putString("sEntityClassName", paramChatMessage.getClass().getName());
      paramQQAppInterface.putString("entityNickName", str);
      if ((paramChatMessage instanceof MessageForStructing))
      {
        paramChatMessage = (MessageForStructing)paramChatMessage;
        if (paramChatMessage.structingMsg != null) {
          paramQQAppInterface.putByteArray("sEntityData", paramChatMessage.structingMsg.getBytes());
        }
      }
      return a(paramLong, 1L, paramQQAppInterface);
    }
    return b(paramQQAppInterface, paramLong, paramChatMessage, str);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int i = paramArrayOfByte[0];
    byte[] arrayOfByte = new byte[paramArrayOfByte.length - 1];
    System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, arrayOfByte.length);
    paramArrayOfByte = arrayOfByte;
    if (i == 1) {
      paramArrayOfByte = StructMsgUtils.a(arrayOfByte);
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public static String[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 945	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore 5
    //   5: aload 5
    //   7: invokevirtual 949	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   10: new 951	java/io/ByteArrayInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 954	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: invokevirtual 960	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   21: invokeinterface 966 1 0
    //   26: astore 5
    //   28: aconst_null
    //   29: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +17 -> 49
    //   35: aload 5
    //   37: ldc_w 968
    //   40: invokeinterface 973 2 0
    //   45: astore_0
    //   46: goto +5 -> 51
    //   49: aconst_null
    //   50: astore_0
    //   51: aload 5
    //   53: invokeinterface 974 1 0
    //   58: astore 18
    //   60: aload 18
    //   62: invokeinterface 563 1 0
    //   67: istore_3
    //   68: aconst_null
    //   69: astore 8
    //   71: aload 8
    //   73: astore 9
    //   75: aload 9
    //   77: astore 7
    //   79: aload 7
    //   81: astore 6
    //   83: aload 6
    //   85: astore 5
    //   87: iconst_0
    //   88: istore_1
    //   89: aload_0
    //   90: astore 10
    //   92: aload 8
    //   94: astore 11
    //   96: aload 9
    //   98: astore 12
    //   100: aload 7
    //   102: astore 13
    //   104: aload 6
    //   106: astore 14
    //   108: aload 5
    //   110: astore 15
    //   112: iload_1
    //   113: iload_3
    //   114: if_icmpge +1004 -> 1118
    //   117: aload 18
    //   119: iload_1
    //   120: invokeinterface 567 2 0
    //   125: astore 15
    //   127: aload 15
    //   129: invokeinterface 977 1 0
    //   134: astore 16
    //   136: aload 16
    //   138: ldc_w 978
    //   141: invokevirtual 981	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifeq +664 -> 808
    //   147: aload 15
    //   149: invokeinterface 558 1 0
    //   154: astore 19
    //   156: aload 6
    //   158: astore 10
    //   160: iconst_0
    //   161: istore_2
    //   162: aload 5
    //   164: astore 6
    //   166: aload 10
    //   168: astore 5
    //   170: aload 5
    //   172: astore 11
    //   174: aload 5
    //   176: astore 12
    //   178: aload 5
    //   180: astore 13
    //   182: iload_2
    //   183: aload 19
    //   185: invokeinterface 563 1 0
    //   190: if_icmpge +556 -> 746
    //   193: aload 5
    //   195: astore 11
    //   197: aload 5
    //   199: astore 12
    //   201: aload 5
    //   203: astore 13
    //   205: aload 19
    //   207: iload_2
    //   208: invokeinterface 567 2 0
    //   213: astore 10
    //   215: aload 5
    //   217: astore 11
    //   219: aload 5
    //   221: astore 12
    //   223: aload 5
    //   225: astore 13
    //   227: aload 10
    //   229: invokeinterface 977 1 0
    //   234: ldc_w 983
    //   237: invokevirtual 981	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   240: istore 4
    //   242: iload 4
    //   244: ifeq +88 -> 332
    //   247: aload 8
    //   249: astore 15
    //   251: aload 7
    //   253: astore 16
    //   255: aload 5
    //   257: astore 14
    //   259: aload 6
    //   261: astore 17
    //   263: aload 5
    //   265: astore 11
    //   267: aload 5
    //   269: astore 12
    //   271: aload 5
    //   273: astore 13
    //   275: aload 5
    //   277: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   280: ifeq +443 -> 723
    //   283: aload 5
    //   285: astore 11
    //   287: aload 5
    //   289: astore 12
    //   291: aload 5
    //   293: astore 13
    //   295: aload 10
    //   297: invokeinterface 987 1 0
    //   302: ldc_w 989
    //   305: invokeinterface 995 2 0
    //   310: invokeinterface 554 1 0
    //   315: astore 14
    //   317: aload 8
    //   319: astore 15
    //   321: aload 7
    //   323: astore 16
    //   325: aload 6
    //   327: astore 17
    //   329: goto +394 -> 723
    //   332: aload 5
    //   334: astore 11
    //   336: aload 5
    //   338: astore 12
    //   340: aload 5
    //   342: astore 13
    //   344: aload 10
    //   346: invokeinterface 977 1 0
    //   351: ldc_w 997
    //   354: invokevirtual 981	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   357: ifeq +73 -> 430
    //   360: aload 8
    //   362: astore 15
    //   364: aload 7
    //   366: astore 16
    //   368: aload 5
    //   370: astore 14
    //   372: aload 6
    //   374: astore 17
    //   376: aload 5
    //   378: astore 11
    //   380: aload 5
    //   382: astore 12
    //   384: aload 5
    //   386: astore 13
    //   388: aload 8
    //   390: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   393: ifeq +330 -> 723
    //   396: aload 5
    //   398: astore 11
    //   400: aload 5
    //   402: astore 12
    //   404: aload 5
    //   406: astore 13
    //   408: aload 10
    //   410: invokestatic 999	cooperation/qqfav/QfavUtil:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   413: astore 15
    //   415: aload 7
    //   417: astore 16
    //   419: aload 5
    //   421: astore 14
    //   423: aload 6
    //   425: astore 17
    //   427: goto +296 -> 723
    //   430: aload 5
    //   432: astore 11
    //   434: aload 5
    //   436: astore 12
    //   438: aload 5
    //   440: astore 13
    //   442: aload 10
    //   444: invokeinterface 977 1 0
    //   449: ldc_w 1001
    //   452: invokevirtual 981	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   455: ifeq +73 -> 528
    //   458: aload 8
    //   460: astore 15
    //   462: aload 7
    //   464: astore 16
    //   466: aload 5
    //   468: astore 14
    //   470: aload 6
    //   472: astore 17
    //   474: aload 5
    //   476: astore 11
    //   478: aload 5
    //   480: astore 12
    //   482: aload 5
    //   484: astore 13
    //   486: aload 7
    //   488: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   491: ifeq +232 -> 723
    //   494: aload 5
    //   496: astore 11
    //   498: aload 5
    //   500: astore 12
    //   502: aload 5
    //   504: astore 13
    //   506: aload 10
    //   508: invokestatic 999	cooperation/qqfav/QfavUtil:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   511: astore 16
    //   513: aload 8
    //   515: astore 15
    //   517: aload 5
    //   519: astore 14
    //   521: aload 6
    //   523: astore 17
    //   525: goto +198 -> 723
    //   528: aload 8
    //   530: astore 15
    //   532: aload 7
    //   534: astore 16
    //   536: aload 5
    //   538: astore 14
    //   540: aload 6
    //   542: astore 17
    //   544: aload 5
    //   546: astore 11
    //   548: aload 5
    //   550: astore 12
    //   552: aload 5
    //   554: astore 13
    //   556: aload 10
    //   558: invokeinterface 977 1 0
    //   563: ldc_w 1003
    //   566: invokevirtual 981	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   569: ifeq +154 -> 723
    //   572: aload 5
    //   574: astore 11
    //   576: aload 5
    //   578: astore 12
    //   580: aload 5
    //   582: astore 13
    //   584: aload 10
    //   586: invokeinterface 987 1 0
    //   591: astore 20
    //   593: aload 5
    //   595: astore 10
    //   597: aload 5
    //   599: astore 11
    //   601: aload 5
    //   603: astore 12
    //   605: aload 5
    //   607: astore 13
    //   609: aload 5
    //   611: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   614: ifeq +32 -> 646
    //   617: aload 5
    //   619: astore 11
    //   621: aload 5
    //   623: astore 12
    //   625: aload 5
    //   627: astore 13
    //   629: aload 20
    //   631: ldc_w 989
    //   634: invokeinterface 995 2 0
    //   639: invokeinterface 554 1 0
    //   644: astore 10
    //   646: aload 8
    //   648: astore 15
    //   650: aload 7
    //   652: astore 16
    //   654: aload 10
    //   656: astore 14
    //   658: aload 6
    //   660: astore 17
    //   662: aload 10
    //   664: astore 11
    //   666: aload 10
    //   668: astore 12
    //   670: aload 10
    //   672: astore 13
    //   674: aload 6
    //   676: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   679: ifeq +44 -> 723
    //   682: aload 10
    //   684: astore 11
    //   686: aload 10
    //   688: astore 12
    //   690: aload 10
    //   692: astore 13
    //   694: aload 20
    //   696: ldc_w 1005
    //   699: invokeinterface 995 2 0
    //   704: invokeinterface 554 1 0
    //   709: astore 17
    //   711: aload 10
    //   713: astore 14
    //   715: aload 7
    //   717: astore 16
    //   719: aload 8
    //   721: astore 15
    //   723: iload_2
    //   724: iconst_1
    //   725: iadd
    //   726: istore_2
    //   727: aload 15
    //   729: astore 8
    //   731: aload 16
    //   733: astore 7
    //   735: aload 14
    //   737: astore 5
    //   739: aload 17
    //   741: astore 6
    //   743: goto -573 -> 170
    //   746: aload 8
    //   748: astore 10
    //   750: aload 9
    //   752: astore 11
    //   754: aload 7
    //   756: astore 12
    //   758: aload 5
    //   760: astore 13
    //   762: aload 6
    //   764: astore 14
    //   766: goto +139 -> 905
    //   769: astore 10
    //   771: aload 6
    //   773: astore 5
    //   775: aload 11
    //   777: astore 6
    //   779: goto +205 -> 984
    //   782: astore 10
    //   784: aload 6
    //   786: astore 5
    //   788: aload 12
    //   790: astore 6
    //   792: goto +245 -> 1037
    //   795: astore 10
    //   797: aload 6
    //   799: astore 5
    //   801: aload 13
    //   803: astore 6
    //   805: goto +285 -> 1090
    //   808: aload 8
    //   810: astore 10
    //   812: aload 9
    //   814: astore 11
    //   816: aload 7
    //   818: astore 12
    //   820: aload 6
    //   822: astore 13
    //   824: aload 5
    //   826: astore 14
    //   828: aload 16
    //   830: ldc_w 1007
    //   833: invokevirtual 981	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   836: ifeq +69 -> 905
    //   839: aload 8
    //   841: astore 10
    //   843: aload 9
    //   845: astore 11
    //   847: aload 7
    //   849: astore 12
    //   851: aload 6
    //   853: astore 13
    //   855: aload 5
    //   857: astore 14
    //   859: aload 9
    //   861: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   864: ifeq +41 -> 905
    //   867: aload 15
    //   869: invokeinterface 987 1 0
    //   874: ldc_w 1009
    //   877: invokeinterface 995 2 0
    //   882: invokeinterface 554 1 0
    //   887: astore 11
    //   889: aload 5
    //   891: astore 14
    //   893: aload 6
    //   895: astore 13
    //   897: aload 7
    //   899: astore 12
    //   901: aload 8
    //   903: astore 10
    //   905: iload_1
    //   906: iconst_1
    //   907: iadd
    //   908: istore_1
    //   909: aload 10
    //   911: astore 8
    //   913: aload 11
    //   915: astore 9
    //   917: aload 12
    //   919: astore 7
    //   921: aload 13
    //   923: astore 6
    //   925: aload 14
    //   927: astore 5
    //   929: goto -840 -> 89
    //   932: astore 10
    //   934: goto +50 -> 984
    //   937: astore 10
    //   939: goto +98 -> 1037
    //   942: astore 10
    //   944: goto +146 -> 1090
    //   947: astore 10
    //   949: goto +17 -> 966
    //   952: astore 10
    //   954: goto +65 -> 1019
    //   957: astore 10
    //   959: goto +113 -> 1072
    //   962: astore 10
    //   964: aconst_null
    //   965: astore_0
    //   966: aconst_null
    //   967: astore 8
    //   969: aconst_null
    //   970: astore 9
    //   972: aload 9
    //   974: astore 7
    //   976: aload 7
    //   978: astore 6
    //   980: aload 6
    //   982: astore 5
    //   984: aload 10
    //   986: invokevirtual 1010	java/io/IOException:printStackTrace	()V
    //   989: aload_0
    //   990: astore 10
    //   992: aload 8
    //   994: astore 11
    //   996: aload 9
    //   998: astore 12
    //   1000: aload 7
    //   1002: astore 13
    //   1004: aload 6
    //   1006: astore 14
    //   1008: aload 5
    //   1010: astore 15
    //   1012: goto +106 -> 1118
    //   1015: astore 10
    //   1017: aconst_null
    //   1018: astore_0
    //   1019: aconst_null
    //   1020: astore 8
    //   1022: aconst_null
    //   1023: astore 9
    //   1025: aload 9
    //   1027: astore 7
    //   1029: aload 7
    //   1031: astore 6
    //   1033: aload 6
    //   1035: astore 5
    //   1037: aload 10
    //   1039: invokevirtual 1011	org/xml/sax/SAXException:printStackTrace	()V
    //   1042: aload_0
    //   1043: astore 10
    //   1045: aload 8
    //   1047: astore 11
    //   1049: aload 9
    //   1051: astore 12
    //   1053: aload 7
    //   1055: astore 13
    //   1057: aload 6
    //   1059: astore 14
    //   1061: aload 5
    //   1063: astore 15
    //   1065: goto +53 -> 1118
    //   1068: astore 10
    //   1070: aconst_null
    //   1071: astore_0
    //   1072: aconst_null
    //   1073: astore 8
    //   1075: aconst_null
    //   1076: astore 9
    //   1078: aload 9
    //   1080: astore 7
    //   1082: aload 7
    //   1084: astore 6
    //   1086: aload 6
    //   1088: astore 5
    //   1090: aload 10
    //   1092: invokevirtual 1012	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1095: aload 5
    //   1097: astore 15
    //   1099: aload 6
    //   1101: astore 14
    //   1103: aload 7
    //   1105: astore 13
    //   1107: aload 9
    //   1109: astore 12
    //   1111: aload 8
    //   1113: astore 11
    //   1115: aload_0
    //   1116: astore 10
    //   1118: bipush 6
    //   1120: anewarray 90	java/lang/String
    //   1123: dup
    //   1124: iconst_0
    //   1125: aload 11
    //   1127: aastore
    //   1128: dup
    //   1129: iconst_1
    //   1130: aload 10
    //   1132: aastore
    //   1133: dup
    //   1134: iconst_2
    //   1135: aload 12
    //   1137: aastore
    //   1138: dup
    //   1139: iconst_3
    //   1140: aload 13
    //   1142: aastore
    //   1143: dup
    //   1144: iconst_4
    //   1145: aload 14
    //   1147: aastore
    //   1148: dup
    //   1149: iconst_5
    //   1150: aload 15
    //   1152: aastore
    //   1153: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1154	0	paramArrayOfByte	byte[]
    //   88	821	1	i	int
    //   161	566	2	j	int
    //   67	48	3	k	int
    //   240	3	4	bool	boolean
    //   3	1093	5	localObject1	Object
    //   81	1019	6	localObject2	Object
    //   77	1027	7	localObject3	Object
    //   69	1043	8	localObject4	Object
    //   73	1035	9	localObject5	Object
    //   90	659	10	localObject6	Object
    //   769	1	10	localIOException1	java.io.IOException
    //   782	1	10	localSAXException1	org.xml.sax.SAXException
    //   795	1	10	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   810	100	10	localObject7	Object
    //   932	1	10	localIOException2	java.io.IOException
    //   937	1	10	localSAXException2	org.xml.sax.SAXException
    //   942	1	10	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   947	1	10	localIOException3	java.io.IOException
    //   952	1	10	localSAXException3	org.xml.sax.SAXException
    //   957	1	10	localParserConfigurationException3	javax.xml.parsers.ParserConfigurationException
    //   962	23	10	localIOException4	java.io.IOException
    //   990	1	10	arrayOfByte1	byte[]
    //   1015	23	10	localSAXException4	org.xml.sax.SAXException
    //   1043	1	10	arrayOfByte2	byte[]
    //   1068	23	10	localParserConfigurationException4	javax.xml.parsers.ParserConfigurationException
    //   1116	15	10	arrayOfByte3	byte[]
    //   94	1032	11	localObject8	Object
    //   98	1038	12	localObject9	Object
    //   102	1039	13	localObject10	Object
    //   106	1040	14	localObject11	Object
    //   110	1041	15	localObject12	Object
    //   134	695	16	localObject13	Object
    //   261	479	17	localObject14	Object
    //   58	60	18	localNodeList1	NodeList
    //   154	52	19	localNodeList2	NodeList
    //   591	104	20	localNamedNodeMap	org.w3c.dom.NamedNodeMap
    // Exception table:
    //   from	to	target	type
    //   182	193	769	java/io/IOException
    //   205	215	769	java/io/IOException
    //   227	242	769	java/io/IOException
    //   275	283	769	java/io/IOException
    //   295	317	769	java/io/IOException
    //   344	360	769	java/io/IOException
    //   388	396	769	java/io/IOException
    //   408	415	769	java/io/IOException
    //   442	458	769	java/io/IOException
    //   486	494	769	java/io/IOException
    //   506	513	769	java/io/IOException
    //   556	572	769	java/io/IOException
    //   584	593	769	java/io/IOException
    //   609	617	769	java/io/IOException
    //   629	646	769	java/io/IOException
    //   674	682	769	java/io/IOException
    //   694	711	769	java/io/IOException
    //   182	193	782	org/xml/sax/SAXException
    //   205	215	782	org/xml/sax/SAXException
    //   227	242	782	org/xml/sax/SAXException
    //   275	283	782	org/xml/sax/SAXException
    //   295	317	782	org/xml/sax/SAXException
    //   344	360	782	org/xml/sax/SAXException
    //   388	396	782	org/xml/sax/SAXException
    //   408	415	782	org/xml/sax/SAXException
    //   442	458	782	org/xml/sax/SAXException
    //   486	494	782	org/xml/sax/SAXException
    //   506	513	782	org/xml/sax/SAXException
    //   556	572	782	org/xml/sax/SAXException
    //   584	593	782	org/xml/sax/SAXException
    //   609	617	782	org/xml/sax/SAXException
    //   629	646	782	org/xml/sax/SAXException
    //   674	682	782	org/xml/sax/SAXException
    //   694	711	782	org/xml/sax/SAXException
    //   182	193	795	javax/xml/parsers/ParserConfigurationException
    //   205	215	795	javax/xml/parsers/ParserConfigurationException
    //   227	242	795	javax/xml/parsers/ParserConfigurationException
    //   275	283	795	javax/xml/parsers/ParserConfigurationException
    //   295	317	795	javax/xml/parsers/ParserConfigurationException
    //   344	360	795	javax/xml/parsers/ParserConfigurationException
    //   388	396	795	javax/xml/parsers/ParserConfigurationException
    //   408	415	795	javax/xml/parsers/ParserConfigurationException
    //   442	458	795	javax/xml/parsers/ParserConfigurationException
    //   486	494	795	javax/xml/parsers/ParserConfigurationException
    //   506	513	795	javax/xml/parsers/ParserConfigurationException
    //   556	572	795	javax/xml/parsers/ParserConfigurationException
    //   584	593	795	javax/xml/parsers/ParserConfigurationException
    //   609	617	795	javax/xml/parsers/ParserConfigurationException
    //   629	646	795	javax/xml/parsers/ParserConfigurationException
    //   674	682	795	javax/xml/parsers/ParserConfigurationException
    //   694	711	795	javax/xml/parsers/ParserConfigurationException
    //   117	156	932	java/io/IOException
    //   828	839	932	java/io/IOException
    //   859	889	932	java/io/IOException
    //   117	156	937	org/xml/sax/SAXException
    //   828	839	937	org/xml/sax/SAXException
    //   859	889	937	org/xml/sax/SAXException
    //   117	156	942	javax/xml/parsers/ParserConfigurationException
    //   828	839	942	javax/xml/parsers/ParserConfigurationException
    //   859	889	942	javax/xml/parsers/ParserConfigurationException
    //   51	68	947	java/io/IOException
    //   51	68	952	org/xml/sax/SAXException
    //   51	68	957	javax/xml/parsers/ParserConfigurationException
    //   5	46	962	java/io/IOException
    //   5	46	1015	org/xml/sax/SAXException
    //   5	46	1068	javax/xml/parsers/ParserConfigurationException
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3000) {
        return 3;
      }
      return 5;
    }
    return 4;
  }
  
  public static void b(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("mobileQQ", i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qfav_unsupport_msg_dialog_flag_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (!((SharedPreferences)localObject).getBoolean(paramString, false)) {
      ((SharedPreferences)localObject).edit().putBoolean(paramString, true).commit();
    }
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    if (paramChatMessage == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      bool1 = bool2;
      if (paramChatMessage.structingMsg != null)
      {
        bool1 = bool2;
        if (paramChatMessage.structingMsg.mMsgServiceID == 14) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static byte[] b(QQAppInterface paramQQAppInterface, long paramLong, ChatMessage paramChatMessage, String paramString)
  {
    boolean bool = paramChatMessage instanceof MessageForTroopFile;
    FileManagerEntity localFileManagerEntity = null;
    if ((!bool) && (!(paramChatMessage instanceof MessageForFile))) {
      return null;
    }
    QfavBuilder localQfavBuilder = new QfavBuilder(3);
    if ((paramChatMessage instanceof MessageForFile))
    {
      localObject = (MessageForFile)paramChatMessage;
      a((MessageForFile)localObject);
      if (paramChatMessage.isMultiMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav", 2, "parcelFileMsg create new entity");
        }
        localObject = MultiFavoriteHelper.a(paramQQAppInterface, paramChatMessage);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav", 2, "parcelFileMsg get entity from db");
        }
        localObject = FileManagerUtil.a(paramQQAppInterface, (MessageForFile)localObject);
      }
      a((FileManagerEntity)localObject);
      if (localObject != null) {
        localQfavBuilder.a(paramQQAppInterface, null, (FileManagerEntity)localObject, paramChatMessage, true);
      } else if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "entity == null");
      }
    }
    else if (bool)
    {
      MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
      a(localMessageForTroopFile);
      if (paramChatMessage.isMultiMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav", 2, "parcelFileMsg, isMultiMsg T, create new entity");
        }
        localObject = MultiFavoriteHelper.a(paramQQAppInterface, paramChatMessage);
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.d("qqfav", 2, "parcelFileMsg, isMultiMsg T, find in db");
        }
        localObject = TroopFileUtils.a(paramQQAppInterface, localMessageForTroopFile);
        if (localObject != null)
        {
          localFileManagerEntity = MultiFavoriteHelper.a((TroopFileStatusInfo)localObject);
          localObject = TroopFileManager.a(paramQQAppInterface, ((TroopFileStatusInfo)localObject).b);
          if ((localObject != null) && (localFileManagerEntity != null) && (!TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)))
          {
            TroopFileInfo localTroopFileInfo = ((TroopFileManager)localObject).a(localFileManagerEntity.strTroopFilePath);
            localObject = localFileManagerEntity;
            if (localTroopFileInfo != null)
            {
              localFileManagerEntity.lastTime = localTroopFileInfo.c;
              localFileManagerEntity.selfUin = String.valueOf(localTroopFileInfo.b);
              localObject = localFileManagerEntity;
            }
          }
          else
          {
            localObject = localFileManagerEntity;
            if (QLog.isColorLevel())
            {
              QLog.d("qqfav", 2, "troopFileManager != null or fileManagerEntity4Favorite.strTroopFilePath == null");
              localObject = localFileManagerEntity;
            }
          }
        }
        else
        {
          localObject = localFileManagerEntity;
          if (QLog.isColorLevel())
          {
            QLog.d("qqfav", 2, "info == null");
            localObject = localFileManagerEntity;
          }
        }
      }
      a((FileManagerEntity)localObject);
      MultiFavoriteHelper.a((FileManagerEntity)localObject, localMessageForTroopFile);
      if (localObject != null) {
        localQfavBuilder.a(paramQQAppInterface, null, (FileManagerEntity)localObject, localMessageForTroopFile, true);
      } else if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "fileManagerEntity4Favorite == null");
      }
    }
    else if ((paramChatMessage instanceof MessageForDLFile))
    {
      localObject = (MessageForDLFile)paramChatMessage;
      int i = ((MessageForDLFile)localObject).deviceType;
      l = ((MessageForDLFile)localObject).associatedId;
      localObject = paramQQAppInterface.getMessageFacade().a(i).a(l);
      if (localObject != null) {
        localObject = ((DataLineMsgRecord)localObject).path;
      } else {
        localObject = "";
      }
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject)) {
        localQfavBuilder.a(paramQQAppInterface, null, (String)localObject);
      }
    }
    paramQQAppInterface = new ContentValues();
    Object localObject = (ContentValues)localQfavBuilder.a().getExtras().getParcelable("fileContents");
    if (localObject != null) {
      paramQQAppInterface.put("fileContents", a((ContentValues)localObject));
    }
    localObject = MsgProxyUtils.a(paramChatMessage);
    long l = paramChatMessage.time;
    paramQQAppInterface.put("sUin", (String)localObject);
    paramQQAppInterface.put("time", Long.valueOf(l));
    paramQQAppInterface.put("entityNickName", paramString);
    return a(paramLong, 3L, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.QfavUtil
 * JD-Core Version:    0.7.0.1
 */