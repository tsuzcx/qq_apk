package com.tencent.mobileqq.qassistant.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.home.impl.BaseFrameControllerUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qassistant.api.IQAssistantTempApi;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.FriendSortHelper;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.qassistant.data.RecordInfo;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import mqq.app.MobileQQ;

public class CommandUtils
{
  public static int a()
  {
    int i = 15;
    try
    {
      String str = QBaseActivity.sTopActivity.getActivityName();
      if ("SplashActivity_MainFragment".equals(str))
      {
        if (QQSettingMe.a()) {
          return 8;
        }
        int j = ((IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class)).getMainFragmentCurrentTab();
        if (j == BaseFrameControllerUtil.jdField_a_of_type_Int) {
          return 1;
        }
        if (j == BaseFrameControllerUtil.c) {
          return 2;
        }
        if (j == BaseFrameControllerUtil.g) {
          return 9;
        }
        if (j == BaseFrameControllerUtil.d) {
          return 10;
        }
      }
      else
      {
        if ("SplashActivity_ChatFragment".equals(str))
        {
          i = ((IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class)).getChatFragmentCurrentType();
          if (i == 0) {
            break label182;
          }
          if (i == 1) {
            break label180;
          }
          if (i == 3000) {
            break label177;
          }
          return 5;
        }
        if ("FriendProfileCardActivity".equals(str)) {
          return 7;
        }
        if ("UniteSearchActivity".equals(str)) {
          return 12;
        }
      }
      if ("QQSettingSettingActivity".equals(str)) {
        return 13;
      }
      boolean bool = "AssistantSettingActivity".equals(str);
      if (bool) {
        i = 14;
      }
      return i;
    }
    catch (Exception localException)
    {
      return 15;
    }
    label177:
    return 6;
    label180:
    return 3;
    label182:
    return 4;
  }
  
  public static int a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.hour;
  }
  
  private static long a(Set<FileInfo> paramSet, ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    paramSet = paramSet.iterator();
    long l = 0L;
    while (paramSet.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramSet.next();
      FileManagerEntity localFileManagerEntity = QQFileManagerUtil.a(localFileInfo);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10000);
      localForwardFileInfo.d(localFileManagerEntity.getCloudType());
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.d(localFileManagerEntity.fileName);
      localForwardFileInfo.c(localFileManagerEntity.uniseq);
      localForwardFileInfo.c(localFileManagerEntity.WeiYunFileId);
      localForwardFileInfo.d(localFileManagerEntity.fileSize);
      localForwardFileInfo.a(localFileManagerEntity.getFilePath());
      localForwardFileInfo.b(localFileManagerEntity.Uuid);
      if (!TextUtils.isEmpty(localFileManagerEntity.strLargeThumPath)) {
        localForwardFileInfo.f(localFileManagerEntity.strLargeThumPath);
      } else if (!TextUtils.isEmpty(localFileManagerEntity.strMiddleThumPath)) {
        localForwardFileInfo.f(localFileManagerEntity.strMiddleThumPath);
      } else {
        localForwardFileInfo.f(localFileManagerEntity.strThumbPath);
      }
      paramArrayList1.add(Uri.parse(localFileInfo.c()));
      l += localForwardFileInfo.d();
      paramArrayList.add(localForwardFileInfo);
    }
    return l;
  }
  
  public static CommandInfo a()
  {
    return new CommandInfo(12, MobileQQ.sMobileQQ.getString(2131720326));
  }
  
  public static CommandInfo a(ConfirmSendInfo paramConfirmSendInfo)
  {
    return new CommandInfo(9, MobileQQ.sMobileQQ.getString(2131720337), paramConfirmSendInfo);
  }
  
  public static CommandInfo a(FriendItemInfo paramFriendItemInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramFriendItemInfo != null)
    {
      JumpInfo localJumpInfo = new JumpInfo(115);
      localJumpInfo.jdField_a_of_type_JavaLangString = paramFriendItemInfo.jdField_a_of_type_JavaLangString;
      localJumpInfo.jdField_b_of_type_JavaLangString = paramFriendItemInfo.jdField_b_of_type_JavaLangString;
      localJumpInfo.jdField_b_of_type_Int = paramFriendItemInfo.jdField_a_of_type_Int;
      localJumpInfo.jdField_a_of_type_Boolean = false;
      localJumpInfo.jdField_b_of_type_Boolean = paramBoolean1;
      localJumpInfo.c = paramBoolean2;
      String str = String.format(MobileQQ.sMobileQQ.getString(2131720319), new Object[] { paramFriendItemInfo.jdField_b_of_type_JavaLangString });
      Object localObject = str;
      if (paramBoolean1) {
        if (paramFriendItemInfo.jdField_a_of_type_Boolean)
        {
          localObject = String.format(MobileQQ.sMobileQQ.getString(2131720316), new Object[] { paramFriendItemInfo.jdField_b_of_type_JavaLangString });
        }
        else
        {
          localObject = str;
          if (paramFriendItemInfo.jdField_a_of_type_Float < FriendSortHelper.a()) {
            localObject = String.format(MobileQQ.sMobileQQ.getString(2131719395), new Object[] { paramFriendItemInfo.jdField_b_of_type_JavaLangString });
          }
        }
      }
      localObject = new CommandInfo(1, (String)localObject, localJumpInfo);
      ((CommandInfo)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
      ((CommandInfo)localObject).jdField_a_of_type_JavaUtilList.add(paramFriendItemInfo);
      return localObject;
    }
    return null;
  }
  
  public static CommandInfo a(String paramString)
  {
    return new CommandInfo(2, paramString);
  }
  
  public static CommandInfo a(String paramString, CommandInfo paramCommandInfo)
  {
    paramString = new CommandInfo(4, paramString);
    if (paramCommandInfo != null)
    {
      paramString.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo = paramCommandInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo;
      paramString.jdField_a_of_type_JavaUtilList = paramCommandInfo.jdField_a_of_type_JavaUtilList;
    }
    return paramString;
  }
  
  public static CommandInfo a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new RecordInfo(paramString1, paramString2, paramString3);
    paramString2 = new CommandInfo(5, "");
    paramString2.jdField_a_of_type_ComTencentMobileqqQassistantDataRecordInfo = paramString1;
    return paramString2;
  }
  
  public static CommandInfo a(String paramString, List<FriendItemInfo> paramList)
  {
    return new CommandInfo(7, String.format(MobileQQ.sMobileQQ.getString(2131720320), new Object[] { paramString }), paramList);
  }
  
  public static CommandInfo a(String paramString, boolean paramBoolean)
  {
    paramString = new CommandInfo(3, paramString);
    paramString.jdField_a_of_type_Boolean = paramBoolean;
    return paramString;
  }
  
  public static CommandInfo a(boolean paramBoolean)
  {
    CommandInfo localCommandInfo = new CommandInfo(10, "");
    localCommandInfo.jdField_b_of_type_Boolean = paramBoolean;
    return localCommandInfo;
  }
  
  public static String a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localTime.year);
    localStringBuilder.append("-");
    localStringBuilder.append(localTime.month + 1);
    localStringBuilder.append("-");
    localStringBuilder.append(localTime.monthDay);
    return localStringBuilder.toString();
  }
  
  public static List<String> a(String paramString, int paramInt)
  {
    PriorityQueue localPriorityQueue = new PriorityQueue(11, new CommandUtils.1());
    paramString = new File(paramString).listFiles(new CommandUtils.2());
    LinkedList localLinkedList = new LinkedList();
    if (paramString == null) {
      return localLinkedList;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lastModified:");
      localStringBuilder.append(localObject.lastModified());
      localStringBuilder.append(",file:");
      localStringBuilder.append(localObject.getPath());
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
      localPriorityQueue.offer(localObject);
      i += 1;
    }
    while ((localLinkedList.size() < paramInt) && (!localPriorityQueue.isEmpty())) {
      localLinkedList.add(((File)localPriorityQueue.poll()).getPath());
    }
    return localLinkedList;
  }
  
  public static void a(List<String> paramList, Activity paramActivity)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      try
      {
        Bundle localBundle = new Bundle();
        Intent localIntent = new Intent();
        long l = 0L;
        ArrayList localArrayList = new ArrayList();
        HashSet localHashSet = new HashSet();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localHashSet.add(new FileInfo((String)paramList.next()));
        }
        paramList = new ArrayList();
        if (localHashSet.size() > 0) {
          l = 0L + a(localHashSet, localArrayList, paramList);
        }
        localBundle.putInt("forward_type", 0);
        localBundle.putParcelableArrayList("fileinfo_array", localArrayList);
        localBundle.putBoolean("not_forward", true);
        localIntent.putExtra("sendMultiple", true);
        localBundle.putParcelableArrayList("android.intent.extra.STREAM", paramList);
        localIntent.putExtras(localBundle);
        localIntent.putExtra("foward_editbar", true);
        localIntent.putExtra("forward_type", 0);
        paramList = HardCodeUtil.a(2131709609);
        int i = localArrayList.size();
        if (i == 1)
        {
          paramList = new StringBuilder();
          paramList.append(HardCodeUtil.a(2131709611));
          paramList.append(QQFileManagerUtil.b(((ForwardFileInfo)localArrayList.get(0)).d()));
          paramList.append(HardCodeUtil.a(2131709608));
          paramList.append(FileUtil.a(((ForwardFileInfo)localArrayList.get(0)).d()));
          paramList.append("。");
          paramList = paramList.toString();
        }
        else if (localArrayList.size() > 1)
        {
          paramList = new StringBuilder();
          paramList.append(HardCodeUtil.a(2131709612));
          paramList.append(QQFileManagerUtil.b(((ForwardFileInfo)localArrayList.get(0)).d()));
          paramList.append(HardCodeUtil.a(2131709613));
          paramList.append(localArrayList.size());
          paramList.append(HardCodeUtil.a(2131709614));
          paramList.append(FileUtil.a(l));
          paramList.append("。");
          paramList = paramList.toString();
        }
        localIntent.putExtra("forward_text", paramList);
        localIntent.putExtra("k_favorites", false);
        ((IForwardOption)QRoute.api(IForwardOption.class)).startForwardActivityForResult(paramActivity, localIntent, 103);
        return;
      }
      catch (FileNotFoundException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public static CommandInfo b()
  {
    return new CommandInfo(6, MobileQQ.sMobileQQ.getString(2131720337));
  }
  
  public static void b(List<String> paramList, Activity paramActivity)
  {
    QLog.flushLog();
    ShareAppLogHelper localShareAppLogHelper = new ShareAppLogHelper(paramActivity);
    localShareAppLogHelper.a(new CommandUtils.3(paramList, paramActivity));
    long l1 = System.currentTimeMillis();
    long l2 = l1 - 600000L;
    Object localObject1 = String.format("%02d", new Object[] { Integer.valueOf(a(l2)) });
    paramList = String.format("%02d", new Object[] { Integer.valueOf(a(l1)) });
    Object localObject2 = a(l2);
    paramActivity = a(l1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("-");
    localStringBuilder.append((String)localObject1);
    localObject1 = ShareAppLogHelper.a(localStringBuilder.toString(), "-");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramActivity);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(paramList);
    paramList = ShareAppLogHelper.a(((StringBuilder)localObject2).toString(), "-");
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CommandUtils.4(localShareAppLogHelper, (Time)localObject1, paramList), 500L);
  }
  
  public static CommandInfo c()
  {
    return new CommandInfo(0, MobileQQ.sMobileQQ.getString(2131720327));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.CommandUtils
 * JD-Core Version:    0.7.0.1
 */