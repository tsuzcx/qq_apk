package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils.OptionIdMapping;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeErrorType;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeMsgInfo;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeSwitchDefMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPErrorType;
import com.tencent.thumbplayer.api.TPCommonEnum.TPMsgInfo;
import com.tencent.thumbplayer.api.TPCommonEnum.TPOptionalId;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPErrorCode;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPPropertyID;
import com.tencent.thumbplayer.api.connection.TPPlayerConnectionConstant;
import com.tencent.thumbplayer.tplayer.TPOptionalIDInternal;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.reflect.Field;

public class TPNativeKeyMapUtil
{
  private static final String TAG = "TPNativeKeyMapUtil";
  
  public static int convertToNativeConnectionAction(int paramInt)
  {
    try
    {
      localClass = Class.forName(TPPlayerConnectionConstant.class.getName());
      arrayOfField = localClass.getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      Field[] arrayOfField;
      int j;
      Object localObject;
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
      TPLogUtil.w("TPNativeKeyMapUtil", "convertToNativeConnectionAction, tpConnectionAction: " + paramInt + " not recognition, return -1");
      return -1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        int i;
        TPLogUtil.e("TPNativeKeyMapUtil", localIllegalAccessException);
        continue;
        label142:
        i += 1;
      }
    }
    if (i < j)
    {
      localObject = arrayOfField[i];
      if (!((Field)localObject).getType().toString().equals("int")) {
        break label142;
      }
      ((Field)localObject).setAccessible(true);
      if (paramInt != ((Field)localObject).getInt(localClass)) {
        break label142;
      }
      localObject = (TPNativeKeyMap.MapConnectionAction)((Field)localObject).getAnnotation(TPNativeKeyMap.MapConnectionAction.class);
      if (localObject == null) {
        break label142;
      }
      i = ((TPNativeKeyMap.MapConnectionAction)localObject).value();
      return i;
    }
  }
  
  public static int convertToNativeConnectionConfig(int paramInt)
  {
    try
    {
      localClass = Class.forName(TPPlayerConnectionConstant.class.getName());
      arrayOfField = localClass.getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      Field[] arrayOfField;
      int j;
      Object localObject;
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
      TPLogUtil.w("TPNativeKeyMapUtil", "convertToNativeConnectionConfig, tpConnectionConfig: " + paramInt + " not recognition, return -1");
      return -1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        int i;
        TPLogUtil.e("TPNativeKeyMapUtil", localIllegalAccessException);
        continue;
        label142:
        i += 1;
      }
    }
    if (i < j)
    {
      localObject = arrayOfField[i];
      if (!((Field)localObject).getType().toString().equals("int")) {
        break label142;
      }
      ((Field)localObject).setAccessible(true);
      if (paramInt != ((Field)localObject).getInt(localClass)) {
        break label142;
      }
      localObject = (TPNativeKeyMap.MapConnectionConfig)((Field)localObject).getAnnotation(TPNativeKeyMap.MapConnectionConfig.class);
      if (localObject == null) {
        break label142;
      }
      i = ((TPNativeKeyMap.MapConnectionConfig)localObject).value();
      return i;
    }
  }
  
  public static TPThumbPlayerUtils.OptionIdMapping convertToNativeInitConfig(@TPCommonEnum.TPOptionalId int paramInt)
  {
    try
    {
      localObject1 = Class.forName(TPOptionalID.class.getName());
      arrayOfField = ((Class)localObject1).getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject1;
      Field[] arrayOfField;
      int j;
      Object localObject2;
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
      TPLogUtil.w("TPNativeKeyMapUtil", "convertToNativeInitConfig, tpInitConfig: " + paramInt + " not recognition, return null");
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        int i;
        TPLogUtil.e("TPNativeKeyMapUtil", localIllegalAccessException);
        continue;
        label156:
        i += 1;
      }
    }
    if (i < j)
    {
      localObject2 = arrayOfField[i];
      if (!((Field)localObject2).getType().toString().equals("int")) {
        break label156;
      }
      ((Field)localObject2).setAccessible(true);
      if (paramInt != ((Field)localObject2).getInt(localObject1)) {
        break label156;
      }
      localObject2 = (TPNativeKeyMap.MapInitConfig)((Field)localObject2).getAnnotation(TPNativeKeyMap.MapInitConfig.class);
      if (localObject2 == null) {
        break label156;
      }
      localObject1 = new TPThumbPlayerUtils.OptionIdMapping(((TPNativeKeyMap.MapInitConfig)localObject2).type(), ((TPNativeKeyMap.MapInitConfig)localObject2).value());
      return localObject1;
    }
  }
  
  public static TPThumbPlayerUtils.OptionIdMapping convertToNativeOptionalId(@TPCommonEnum.TPOptionalId int paramInt)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping2 = convertToPublicNativeOptionalId(paramInt);
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping1 = localOptionIdMapping2;
    if (localOptionIdMapping2 == null) {
      localOptionIdMapping1 = convertToPrivateNativeOptionalId(paramInt);
    }
    return localOptionIdMapping1;
  }
  
  private static TPThumbPlayerUtils.OptionIdMapping convertToNativeOptionalIdInternal(@TPCommonEnum.TPOptionalId int paramInt, Class paramClass)
  {
    for (;;)
    {
      int i;
      try
      {
        Field[] arrayOfField = paramClass.getDeclaredFields();
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          Object localObject = arrayOfField[i];
          if (!((Field)localObject).getType().toString().equals("int")) {
            break label137;
          }
          ((Field)localObject).setAccessible(true);
          if (paramInt != ((Field)localObject).getInt(paramClass)) {
            break label137;
          }
          localObject = (TPNativeKeyMap.MapOptionalId)((Field)localObject).getAnnotation(TPNativeKeyMap.MapOptionalId.class);
          if (localObject == null) {
            break label137;
          }
          paramClass = new TPThumbPlayerUtils.OptionIdMapping(((TPNativeKeyMap.MapOptionalId)localObject).type(), ((TPNativeKeyMap.MapOptionalId)localObject).value());
          return paramClass;
        }
      }
      catch (IllegalAccessException paramClass)
      {
        TPLogUtil.e("TPNativeKeyMapUtil", paramClass);
        TPLogUtil.w("TPNativeKeyMapUtil", "convertToNativeOptionalIdInternal, tpOptionalId: " + paramInt + " not recognition, return null");
        return null;
      }
      label137:
      i += 1;
    }
  }
  
  public static int convertToNativePropertyId(int paramInt)
  {
    try
    {
      localClass = Class.forName(TPPropertyID.class.getName());
      arrayOfField = localClass.getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      Field[] arrayOfField;
      int j;
      Object localObject;
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
      TPLogUtil.w("TPNativeKeyMapUtil", "convertToNativePropertyId, tpPropertyId: " + paramInt + " not recognition, return -1");
      return -1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        int i;
        TPLogUtil.e("TPNativeKeyMapUtil", localIllegalAccessException);
        continue;
        label142:
        i += 1;
      }
    }
    if (i < j)
    {
      localObject = arrayOfField[i];
      if (!((Field)localObject).getType().toString().equals("int")) {
        break label142;
      }
      ((Field)localObject).setAccessible(true);
      if (paramInt != ((Field)localObject).getInt(localClass)) {
        break label142;
      }
      localObject = (TPNativeKeyMap.MapPropertyId)((Field)localObject).getAnnotation(TPNativeKeyMap.MapPropertyId.class);
      if (localObject == null) {
        break label142;
      }
      i = ((TPNativeKeyMap.MapPropertyId)localObject).value();
      return i;
    }
  }
  
  @TPCommonEnum.NativeSeekMode
  public static int convertToNativeSeekMode(@TPCommonEnum.TPSeekMode int paramInt)
  {
    try
    {
      localClass = Class.forName(ITPPlayer.class.getName());
      arrayOfField = localClass.getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      Field[] arrayOfField;
      int j;
      Object localObject;
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
      TPLogUtil.w("TPNativeKeyMapUtil", "convertToNativeSeekMode, seek mode is invalid(" + paramInt + "), return default mode instead");
      return 2;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        int i;
        TPLogUtil.e("TPNativeKeyMapUtil", localIllegalAccessException);
        continue;
        label142:
        i += 1;
      }
    }
    if (i < j)
    {
      localObject = arrayOfField[i];
      if (!((Field)localObject).getType().toString().equals("int")) {
        break label142;
      }
      ((Field)localObject).setAccessible(true);
      if (paramInt != ((Field)localObject).getInt(localClass)) {
        break label142;
      }
      localObject = (TPNativeKeyMap.MapSeekMode)((Field)localObject).getAnnotation(TPNativeKeyMap.MapSeekMode.class);
      if (localObject == null) {
        break label142;
      }
      i = ((TPNativeKeyMap.MapSeekMode)localObject).value();
      return i;
    }
  }
  
  @TPCommonEnum.NativeSwitchDefMode
  public static int convertToNativeSwitchDefMode(@TPCommonEnum.TPSwitchDefMode int paramInt)
  {
    try
    {
      localClass = Class.forName(ITPPlayer.class.getName());
      arrayOfField = localClass.getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      Field[] arrayOfField;
      int j;
      Object localObject;
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
      TPLogUtil.w("TPNativeKeyMapUtil", "convertToNativeSwitchDefMode, player switch definition mode is invalid(" + paramInt + "), return default mode instead");
      return 2;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        int i;
        TPLogUtil.e("TPNativeKeyMapUtil", localIllegalAccessException);
        continue;
        label142:
        i += 1;
      }
    }
    if (i < j)
    {
      localObject = arrayOfField[i];
      if (!((Field)localObject).getType().toString().equals("int")) {
        break label142;
      }
      ((Field)localObject).setAccessible(true);
      if (paramInt != ((Field)localObject).getInt(localClass)) {
        break label142;
      }
      localObject = (TPNativeKeyMap.MapSwitchDefMode)((Field)localObject).getAnnotation(TPNativeKeyMap.MapSwitchDefMode.class);
      if (localObject == null) {
        break label142;
      }
      i = ((TPNativeKeyMap.MapSwitchDefMode)localObject).value();
      return i;
    }
  }
  
  private static TPThumbPlayerUtils.OptionIdMapping convertToPrivateNativeOptionalId(@TPCommonEnum.TPOptionalId int paramInt)
  {
    try
    {
      TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = convertToNativeOptionalIdInternal(paramInt, Class.forName(TPOptionalIDInternal.class.getName()));
      return localOptionIdMapping;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
    }
    return null;
  }
  
  private static TPThumbPlayerUtils.OptionIdMapping convertToPublicNativeOptionalId(@TPCommonEnum.TPOptionalId int paramInt)
  {
    try
    {
      TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = convertToNativeOptionalIdInternal(paramInt, Class.forName(TPOptionalID.class.getName()));
      return localOptionIdMapping;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
    }
    return null;
  }
  
  @TPCommonEnum.TPErrorType
  public static int convertToTPErrorType(@TPCommonEnum.NativeErrorType int paramInt)
  {
    try
    {
      localClass = Class.forName(TPErrorCode.class.getName());
      arrayOfField = localClass.getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      Field[] arrayOfField;
      int j;
      Field localField;
      TPNativeKeyMap.MapErrorType localMapErrorType;
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
      TPLogUtil.w("TPNativeKeyMapUtil", "convertToTPErrorType, nativeErrorType: " + paramInt + " not recognition, return 1001");
      return 1001;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        int i;
        TPLogUtil.e("TPNativeKeyMapUtil", localIllegalAccessException);
        continue;
        label144:
        i += 1;
      }
    }
    if (i < j)
    {
      localField = arrayOfField[i];
      if (!localField.getType().toString().equals("int")) {
        break label144;
      }
      localField.setAccessible(true);
      localMapErrorType = (TPNativeKeyMap.MapErrorType)localField.getAnnotation(TPNativeKeyMap.MapErrorType.class);
      if ((localMapErrorType == null) || (paramInt != localMapErrorType.value())) {
        break label144;
      }
      i = localField.getInt(localClass);
      return i;
    }
  }
  
  @TPCommonEnum.TPMsgInfo
  public static int convertToTPMsgInfo(@TPCommonEnum.NativeMsgInfo int paramInt)
  {
    try
    {
      localClass = Class.forName(TPPlayerMsg.class.getName());
      arrayOfField = localClass.getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      Field[] arrayOfField;
      int j;
      Field localField;
      TPNativeKeyMap.MapMsgInfo localMapMsgInfo;
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
      TPLogUtil.w("TPNativeKeyMapUtil", "convertToTPMsgInfo, nativeMsgInfo: " + paramInt + " not recognition, return TP_PLAYER_INFO_LONG0_UNKNOW");
      return -1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        int i;
        TPLogUtil.e("TPNativeKeyMapUtil", localIllegalAccessException);
        continue;
        label142:
        i += 1;
      }
    }
    if (i < j)
    {
      localField = arrayOfField[i];
      if (!localField.getType().toString().equals("int")) {
        break label142;
      }
      localField.setAccessible(true);
      localMapMsgInfo = (TPNativeKeyMap.MapMsgInfo)localField.getAnnotation(TPNativeKeyMap.MapMsgInfo.class);
      if ((localMapMsgInfo == null) || (paramInt != localMapMsgInfo.value())) {
        break label142;
      }
      i = localField.getInt(localClass);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil
 * JD-Core Version:    0.7.0.1
 */