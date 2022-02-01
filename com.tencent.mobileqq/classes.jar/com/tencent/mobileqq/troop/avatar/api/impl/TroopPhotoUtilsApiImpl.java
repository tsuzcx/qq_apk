package com.tencent.mobileqq.troop.avatar.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortraitInfo;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.GroupPicListInfo;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.RspBody;

public class TroopPhotoUtilsApiImpl
  implements ITroopPhotoUtilsApi
{
  public static final int CMD_TYPE_AVATAR = 1;
  public static final int CMD_TYPE_COVER = 0;
  public static final float FIX_SCALE_HW_COVER = 0.5653333F;
  public static final String TAG = "TroopPhotoUtilsApiImpl";
  
  private boolean getIsKeepClipInfo(int paramInt)
  {
    return paramInt == 102;
  }
  
  private boolean isNumeric(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public void cacheFileFromLocal(int paramInt, String paramString1, String paramString2)
  {
    String str = String.valueOf(paramInt);
    ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    Object localObject = getURL4TroopPhoto(localITroopAvatarUtilApi.getArtWork(localITroopAvatarUtilApi.getAvatarAddress(str, paramString2, 1)));
    if (localObject != null)
    {
      paramInt = copySdcardFile(paramString1, AbsDownloader.getFilePath(((URL)localObject).toString()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cacheFileFromLocal origin photo,result:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("TroopPhotoUtilsApiImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
    paramString2 = getURL4TroopPhoto(localITroopAvatarUtilApi.getThumbPhoto(localITroopAvatarUtilApi.getAvatarAddress(str, paramString2, 1)));
    if (paramString2 != null)
    {
      paramInt = saveBitmapToFile(paramString1, AbsDownloader.getFilePath(paramString2.toString()));
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("cacheFileFromLocal thumb photo,result:");
        paramString1.append(paramInt);
        QLog.d("TroopPhotoUtilsApiImpl", 2, paramString1.toString());
      }
    }
  }
  
  public int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != -1))
    {
      if (paramInt2 == -1) {
        return 1;
      }
      paramInt1 = getInSampleSize(paramInt1, paramInt2, paramOptions.outHeight, paramOptions.outWidth);
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoUtilsApiImpl", 2, String.format("calculateInSampleSize [%d,%d,%d]", new Object[] { Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight), Integer.valueOf(paramInt1) }));
      }
      return paramInt1;
    }
    return 1;
  }
  
  /* Error */
  public int copySdcardFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 152	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: new 157	java/io/FileOutputStream
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: sipush 8192
    //   27: newarray byte
    //   29: astore 4
    //   31: aload_1
    //   32: aload 4
    //   34: invokevirtual 164	java/io/InputStream:read	([B)I
    //   37: istore_3
    //   38: iload_3
    //   39: ifle +14 -> 53
    //   42: aload_2
    //   43: aload 4
    //   45: iconst_0
    //   46: iload_3
    //   47: invokevirtual 170	java/io/OutputStream:write	([BII)V
    //   50: goto -19 -> 31
    //   53: aload_1
    //   54: invokevirtual 173	java/io/InputStream:close	()V
    //   57: goto +8 -> 65
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   65: aload_2
    //   66: invokevirtual 177	java/io/OutputStream:close	()V
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: astore 5
    //   80: aload_1
    //   81: astore 4
    //   83: aload 5
    //   85: astore_1
    //   86: goto +33 -> 119
    //   89: goto +73 -> 162
    //   92: astore 6
    //   94: aload 5
    //   96: astore_2
    //   97: aload_1
    //   98: astore 4
    //   100: aload 6
    //   102: astore_1
    //   103: goto +16 -> 119
    //   106: aload 4
    //   108: astore_2
    //   109: goto +53 -> 162
    //   112: astore_1
    //   113: aconst_null
    //   114: astore 4
    //   116: aload 5
    //   118: astore_2
    //   119: aload 4
    //   121: ifnull +18 -> 139
    //   124: aload 4
    //   126: invokevirtual 173	java/io/InputStream:close	()V
    //   129: goto +10 -> 139
    //   132: astore 4
    //   134: aload 4
    //   136: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   139: aload_2
    //   140: ifnull +15 -> 155
    //   143: aload_2
    //   144: invokevirtual 177	java/io/OutputStream:close	()V
    //   147: goto +8 -> 155
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   155: aload_1
    //   156: athrow
    //   157: aconst_null
    //   158: astore_1
    //   159: aload 4
    //   161: astore_2
    //   162: aload_1
    //   163: ifnull +15 -> 178
    //   166: aload_1
    //   167: invokevirtual 173	java/io/InputStream:close	()V
    //   170: goto +8 -> 178
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   178: aload_2
    //   179: ifnull +14 -> 193
    //   182: aload_2
    //   183: invokevirtual 177	java/io/OutputStream:close	()V
    //   186: iconst_m1
    //   187: ireturn
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   193: iconst_m1
    //   194: ireturn
    //   195: astore_1
    //   196: goto -39 -> 157
    //   199: astore_2
    //   200: goto -94 -> 106
    //   203: astore 4
    //   205: goto -116 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	TroopPhotoUtilsApiImpl
    //   0	208	1	paramString1	String
    //   0	208	2	paramString2	String
    //   37	10	3	i	int
    //   1	124	4	localObject1	Object
    //   132	28	4	localIOException	IOException
    //   203	1	4	localException	java.lang.Exception
    //   4	1	5	localObject2	Object
    //   78	39	5	localObject3	Object
    //   92	9	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   53	57	60	java/io/IOException
    //   65	69	71	java/io/IOException
    //   24	31	78	finally
    //   31	38	78	finally
    //   42	50	78	finally
    //   15	24	92	finally
    //   6	15	112	finally
    //   124	129	132	java/io/IOException
    //   143	147	150	java/io/IOException
    //   166	170	173	java/io/IOException
    //   182	186	188	java/io/IOException
    //   6	15	195	java/lang/Exception
    //   15	24	199	java/lang/Exception
    //   24	31	203	java/lang/Exception
    //   31	38	203	java/lang/Exception
    //   42	50	203	java/lang/Exception
  }
  
  public boolean deleteFoder(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isFile())
      {
        paramFile.delete();
      }
      else if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int i = 0;
          while (i < arrayOfFile.length)
          {
            deleteFoder(arrayOfFile[i]);
            i += 1;
          }
        }
      }
      if (!paramFile.delete()) {
        return false;
      }
    }
    return true;
  }
  
  public String getAllPicFromDb(List<TroopClipPic> paramList, TroopInfo paramTroopInfo)
  {
    String str = AvatarInfo.a;
    if (paramTroopInfo == null) {
      return str;
    }
    paramList.addAll(paramTroopInfo.mTroopPicList);
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("getAllPicFromDb infs=%s", new Object[] { Arrays.toString(paramList.toArray()) }));
    }
    return str;
  }
  
  public int getBusiByType(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return 0;
      }
      return 103;
    }
    return 102;
  }
  
  public void getClipRect(Rect paramRect, String paramString)
  {
    paramRect.set(0, 0, 0, 0);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("_");
      if ((paramString.length == 4) && (isNumeric(paramString[0])) && (isNumeric(paramString[1])) && (isNumeric(paramString[2])) && (isNumeric(paramString[3])))
      {
        int i = Integer.valueOf(paramString[0]).intValue();
        int j = Integer.valueOf(paramString[1]).intValue();
        int k = Integer.valueOf(paramString[2]).intValue();
        int m = Integer.valueOf(paramString[3]).intValue();
        if ((i >= 0) && (j >= 0) && (k > i) && (m > j)) {
          paramRect.set(i, j, k, m);
        }
      }
    }
  }
  
  public Point getClipRectSize(Activity paramActivity, int paramInt)
  {
    Point localPoint = new Point();
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    int i;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels) {
      i = localDisplayMetrics.widthPixels;
    } else {
      i = localDisplayMetrics.heightPixels;
    }
    if (paramInt != 102)
    {
      paramInt = i - Utils.a(65.0F, paramActivity.getResources());
      localPoint.set(paramInt, paramInt);
      return localPoint;
    }
    localPoint.set(i, getScaledCoverHeight(i));
    return localPoint;
  }
  
  public String getClipStr(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt4);
    return localStringBuilder.toString();
  }
  
  public String getCoverFromDb(List<AvatarInfo> paramList, TroopInfo paramTroopInfo)
  {
    String str = AvatarInfo.a;
    if (paramTroopInfo == null) {
      return str;
    }
    Iterator localIterator = paramTroopInfo.mTroopPicList.iterator();
    while (localIterator.hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
      if (localTroopClipPic.type == 1) {
        str = localTroopClipPic.id;
      } else {
        paramList.add(AvatarInfo.a(localTroopClipPic, paramTroopInfo.mTroopVerifyingPics));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("getCoverFromDb infs=%s", new Object[] { Arrays.toString(paramList.toArray()) }));
    }
    return str;
  }
  
  public String getErrText(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return paramContext.getString(2131718782);
    }
    if (paramInt == 1) {
      return paramContext.getString(2131696086);
    }
    if (paramInt == 2) {
      return paramContext.getString(2131696085);
    }
    if (paramInt == 3) {
      return paramContext.getString(2131696087);
    }
    if (paramInt == 5) {
      return paramContext.getString(2131696084);
    }
    if (paramInt == 100) {
      return paramContext.getString(2131696068);
    }
    if (paramInt == 101) {
      return paramContext.getString(2131696069);
    }
    if (paramInt == 102) {
      return paramContext.getString(2131696066);
    }
    if (paramInt == 103) {
      return paramContext.getString(2131696070);
    }
    if (paramInt == 1793) {
      return paramContext.getString(2131693355);
    }
    return paramContext.getString(2131696083);
  }
  
  public int getInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    int i = paramInt4;
    paramInt4 = paramInt3;
    paramInt3 = j;
    while ((paramInt4 > paramInt2) || (i > paramInt1))
    {
      j = Math.round(paramInt4 / paramInt2);
      int k = Math.round(i / paramInt1);
      if (j <= k) {
        j = k;
      }
      if (j < 2) {
        break;
      }
      i /= 2;
      paramInt4 /= 2;
      paramInt3 *= 2;
    }
    return paramInt3;
  }
  
  public int getPicsFrom88d(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait, List<TroopClipPic> paramList)
  {
    int n = paramGroupHeadPortrait.uint32_default_id.get();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_info.get().iterator();
    for (;;)
    {
      boolean bool = paramGroupHeadPortrait.hasNext();
      int m = 0;
      if (!bool) {
        break;
      }
      oidb_0x88d.GroupHeadPortraitInfo localGroupHeadPortraitInfo = (oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next();
      TroopClipPic localTroopClipPic = new TroopClipPic();
      localTroopClipPic.id = String.valueOf(localGroupHeadPortraitInfo.rpt_uint32_pic_id.get());
      int i;
      if (localGroupHeadPortraitInfo.uint32_left_x.has()) {
        i = localGroupHeadPortraitInfo.uint32_left_x.get();
      } else {
        i = 0;
      }
      int j;
      if (localGroupHeadPortraitInfo.uint32_left_y.has()) {
        j = localGroupHeadPortraitInfo.uint32_left_y.get();
      } else {
        j = 0;
      }
      int k;
      if (localGroupHeadPortraitInfo.uint32_right_x.has()) {
        k = localGroupHeadPortraitInfo.uint32_right_x.get();
      } else {
        k = 0;
      }
      if (localGroupHeadPortraitInfo.uint32_right_y.has()) {
        m = localGroupHeadPortraitInfo.uint32_right_y.get();
      }
      if ((i >= 0) && (j >= 0) && (k >= 0) && (m >= 0)) {
        localTroopClipPic.clipInfo = getClipStr(i, j, k, m);
      }
      if (n == localGroupHeadPortraitInfo.rpt_uint32_pic_id.get()) {
        localTroopClipPic.type = 1;
      }
      paramList.add(localTroopClipPic);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoUtilsApiImpl", 2, String.format("getPicsFrom88d avatarId=%d %s", new Object[] { Integer.valueOf(n), Arrays.toString(paramList.toArray()) }));
    }
    return n;
  }
  
  public int getPicsFrom8b8(oidb_0x8b8.RspBody paramRspBody, List<TroopClipPic> paramList)
  {
    int n = paramRspBody.uint32_default_id.get();
    if ((paramRspBody.rpt_msg_pic_list_info.has()) && (paramRspBody.rpt_msg_pic_list_info.get().size() > 0))
    {
      paramRspBody = paramRspBody.rpt_msg_pic_list_info.get().iterator();
      while (paramRspBody.hasNext())
      {
        oidb_0x8b8.GroupPicListInfo localGroupPicListInfo = (oidb_0x8b8.GroupPicListInfo)paramRspBody.next();
        if (localGroupPicListInfo.uint32_pic_id.get() > 0)
        {
          TroopClipPic localTroopClipPic = new TroopClipPic();
          localTroopClipPic.id = String.valueOf(localGroupPicListInfo.uint32_pic_id.get());
          int i;
          if (localGroupPicListInfo.uint32_left_x.has()) {
            i = localGroupPicListInfo.uint32_left_x.get();
          } else {
            i = 0;
          }
          int j;
          if (localGroupPicListInfo.uint32_left_y.has()) {
            j = localGroupPicListInfo.uint32_left_y.get();
          } else {
            j = 0;
          }
          int k;
          if (localGroupPicListInfo.uint32_right_x.has()) {
            k = localGroupPicListInfo.uint32_right_x.get();
          } else {
            k = 0;
          }
          int m;
          if (localGroupPicListInfo.uint32_right_y.has()) {
            m = localGroupPicListInfo.uint32_right_y.get();
          } else {
            m = 0;
          }
          if ((i >= 0) && (j >= 0) && (k >= 0) && (m >= 0)) {
            localTroopClipPic.clipInfo = getClipStr(i, j, k, m);
          }
          if (n == localGroupPicListInfo.uint32_pic_id.get()) {
            localTroopClipPic.type = 1;
          }
          paramList.add(localTroopClipPic);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoUtilsApiImpl", 2, String.format("getPicsFrom8b8 avatarId=%d %s", new Object[] { Integer.valueOf(n), Arrays.toString(paramList.toArray()) }));
    }
    return n;
  }
  
  public int getScaledCoverHeight(int paramInt)
  {
    return (int)(paramInt * 0.5653333F);
  }
  
  public int getShapeOfBusi(int paramInt)
  {
    if (paramInt != 102) {
      return 0;
    }
    return 1;
  }
  
  public int getSubcmdByType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    return -1;
  }
  
  public URL getURL4TroopPhoto(String paramString)
  {
    String str = Uri.parse(paramString).getScheme();
    if ((!TextUtils.isEmpty(str)) && ((str.equals("http")) || (str.equals("https"))))
    {
      try
      {
        paramString = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).nearbyImgDownloader_convertURL(paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label109;
        }
      }
      QLog.i("Q.troopinfo", 2, paramString.toString());
    }
    else
    {
      try
      {
        paramString = new File(paramString).toURL();
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, paramString.toString());
        }
      }
    }
    label109:
    return null;
  }
  
  public String getUploadPhotoTempPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (SystemUtil.a())
    {
      localStringBuilder.append(AppConstants.SDCARD_PATH_TROOPPHOTO);
      localStringBuilder.append("tmp/");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("_photo.tmp");
      return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    }
    localStringBuilder.append(MobileQQ.sMobileQQ.getBaseContext().getFilesDir());
    localStringBuilder.append("/tmp/");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_photo.tmp");
    return localStringBuilder.toString();
  }
  
  public int saveBitmapToFile(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return -1;
    }
    Object localObject = new File(paramString1);
    BitmapFactory.Options localOptions = BaseImageUtil.a(((File)localObject).getPath(), 100);
    do
    {
      try
      {
        localObject = BaseImageUtil.a(((File)localObject).getPath(), localOptions);
        paramString2 = new File(paramString2);
        if (paramString2.exists()) {
          return 0;
        }
        try
        {
          int i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).readPictureDegree(paramString1);
          paramString1 = (String)localObject;
          if (i == 0) {
            continue;
          }
          paramString1 = BaseImageUtil.b((Bitmap)localObject, i);
        }
        catch (IOException paramString1)
        {
          paramString1.printStackTrace();
          return -1;
        }
        BaseImageUtil.a(paramString1, paramString2);
        return 0;
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        return -1;
      }
    } while (paramString1 != null);
    return -1;
  }
  
  public Set<String> setVerifyingAvatarPicId(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait)
  {
    int i = paramGroupHeadPortrait.uint32_verifying_pic_cnt.get();
    int j = paramGroupHeadPortrait.rpt_msg_verifyingpic_info.size();
    if ((i != j) && (QLog.isColorLevel())) {
      QLog.d("TroopInfo", 2, String.format("wrong data from server! uint32_verifying_pic_cnt = %d not equals rpt_msg_verifyingpic_info's size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    HashSet localHashSet = new HashSet();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_verifyingpic_info.get().iterator();
    while (paramGroupHeadPortrait.hasNext()) {
      localHashSet.add(String.valueOf(((oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next()).rpt_uint32_pic_id.get()));
    }
    return localHashSet;
  }
  
  public void startPhotoEdit(Activity paramActivity, Intent paramIntent, String paramString, int paramInt)
  {
    Point localPoint = getClipRectSize(paramActivity, paramInt);
    paramIntent.putExtra("Business_Origin", paramInt);
    paramIntent.putExtra("BUSINESS_ORIGIN_NEW", paramInt);
    paramIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
    paramIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1024);
    paramIntent.putExtra("PhotoConst.ORIGIN_WITH_CLIPINFO", getIsKeepClipInfo(paramInt));
    paramIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).startPhotoEdit(paramIntent, paramActivity, paramActivity.getClass().getName(), localPoint.x, localPoint.y, 640, 640, paramString, getUploadPhotoTempPath());
  }
  
  public void startPhotoEdit(Activity paramActivity, String paramString, int paramInt)
  {
    startPhotoEdit(paramActivity, new Intent(), paramString, paramInt);
  }
  
  public void startPhotoList(Activity paramActivity, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
    localBundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localBundle.putBoolean("PhotoConst.IS_SINGLE_MODE", bool);
    localBundle.putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localBundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localBundle.putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    paramActivity.overridePendingTransition(2130771993, 2130771991);
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).startPhotoList(paramActivity, localBundle);
  }
  
  public void startPhotoListEdit(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent();
    Point localPoint = getClipRectSize(paramActivity, paramInt);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", paramInt);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", paramInt);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1024);
    localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
    localIntent.putExtra("PhotoConst.ORIGIN_WITH_CLIPINFO", getIsKeepClipInfo(paramInt));
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).startPhotoListEdit(localIntent, paramActivity, paramActivity.getClass().getName(), localPoint.x, localPoint.y, 640, 640, getUploadPhotoTempPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.api.impl.TroopPhotoUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */