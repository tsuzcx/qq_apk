package com.tencent.mobileqq.qassistant.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qassistant.core.FriendSortHelper;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.qassistant.data.RecordInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.ConfirmSendInfo;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CommandUtils
{
  public static int a()
  {
    try
    {
      String str = BaseActivity.sTopActivity.getActivityName();
      if ("SplashActivity_MainFragment".equals(str))
      {
        if (FrameHelperActivity.b()) {
          return 8;
        }
        int i = MainFragment.a().a();
        if (i == FrameControllerUtil.jdField_a_of_type_Int) {
          return 1;
        }
        if (i == FrameControllerUtil.c) {
          return 2;
        }
        if (i == FrameControllerUtil.g) {
          return 9;
        }
        if (i == FrameControllerUtil.d) {
          return 10;
        }
      }
      else if (!"SplashActivity_ChatFragment".equals(str)) {}
      switch (ChatFragment.a().a.a.jdField_a_of_type_Int)
      {
      default: 
        if ("FriendProfileCardActivity".equals(str)) {
          return 7;
        }
        if ("UniteSearchActivity".equals(str)) {
          return 12;
        }
        if ("QQSettingSettingActivity".equals(str)) {
          return 13;
        }
        boolean bool = "AssistantSettingActivity".equals(str);
        if (bool) {
          return 14;
        }
        break;
      }
    }
    catch (Exception localException) {}
    return 15;
    return 5;
    return 4;
    return 3;
    return 6;
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
    long l1 = 0L;
    if (paramSet.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramSet.next();
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(localFileInfo);
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
      }
      for (;;)
      {
        paramArrayList1.add(Uri.parse(localFileInfo.c()));
        long l2 = localForwardFileInfo.d();
        paramArrayList.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        if (!TextUtils.isEmpty(localFileManagerEntity.strMiddleThumPath)) {
          localForwardFileInfo.f(localFileManagerEntity.strMiddleThumPath);
        } else {
          localForwardFileInfo.f(localFileManagerEntity.strThumbPath);
        }
      }
    }
    return l1;
  }
  
  public static CommandInfo a()
  {
    return new CommandInfo(12, BaseApplicationImpl.getContext().getString(2131720611));
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
      String str = String.format(BaseApplicationImpl.getContext().getString(2131720604), new Object[] { paramFriendItemInfo.jdField_b_of_type_JavaLangString });
      Object localObject = str;
      if (paramBoolean1)
      {
        if (!paramFriendItemInfo.jdField_a_of_type_Boolean) {
          break label157;
        }
        localObject = String.format(BaseApplicationImpl.getContext().getString(2131720601), new Object[] { paramFriendItemInfo.jdField_b_of_type_JavaLangString });
      }
      for (;;)
      {
        localObject = new CommandInfo(1, (String)localObject, localJumpInfo);
        ((CommandInfo)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
        ((CommandInfo)localObject).jdField_a_of_type_JavaUtilList.add(paramFriendItemInfo);
        return localObject;
        label157:
        localObject = str;
        if (paramFriendItemInfo.jdField_a_of_type_Float < FriendSortHelper.a()) {
          localObject = String.format(BaseApplicationImpl.getContext().getString(2131719676), new Object[] { paramFriendItemInfo.jdField_b_of_type_JavaLangString });
        }
      }
    }
    return null;
  }
  
  public static CommandInfo a(VoiceAssiatantRespInfo.ConfirmSendInfo paramConfirmSendInfo)
  {
    return new CommandInfo(9, BaseApplicationImpl.getContext().getString(2131720622), paramConfirmSendInfo);
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
    return new CommandInfo(7, String.format(BaseApplicationImpl.getContext().getString(2131720605), new Object[] { paramString }), paramList);
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
    return localTime.year + "-" + (localTime.month + 1) + "-" + localTime.monthDay;
  }
  
  public static void a(List<String> paramList, Activity paramActivity)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    Bundle localBundle;
    Intent localIntent;
    long l;
    ArrayList localArrayList;
    HashSet localHashSet;
    try
    {
      localBundle = new Bundle();
      localIntent = new Intent();
      l = 0L;
      localArrayList = new ArrayList();
      localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localHashSet.add(new FileInfo((String)paramList.next()));
      }
      paramList = new ArrayList();
    }
    catch (FileNotFoundException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    if (localHashSet.size() > 0) {
      l = a(localHashSet, localArrayList, paramList) + 0L;
    }
    localBundle.putInt("forward_type", 0);
    localBundle.putParcelableArrayList("fileinfo_array", localArrayList);
    localBundle.putBoolean("not_forward", true);
    localIntent.putExtra("sendMultiple", true);
    localBundle.putParcelableArrayList("android.intent.extra.STREAM", paramList);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("foward_editbar", true);
    localIntent.putExtra("forward_type", 0);
    paramList = HardCodeUtil.a(2131709603);
    if (localArrayList.size() == 1) {
      paramList = HardCodeUtil.a(2131709605) + FileManagerUtil.d(((ForwardFileInfo)localArrayList.get(0)).d()) + HardCodeUtil.a(2131709602) + FileUtil.a(((ForwardFileInfo)localArrayList.get(0)).d()) + "。";
    }
    for (;;)
    {
      localIntent.putExtra("forward_text", paramList);
      localIntent.putExtra("k_favorites", false);
      ForwardBaseOption.a(paramActivity, localIntent, 103);
      return;
      if (localArrayList.size() > 1) {
        paramList = HardCodeUtil.a(2131709606) + FileManagerUtil.d(((ForwardFileInfo)localArrayList.get(0)).d()) + HardCodeUtil.a(2131709607) + localArrayList.size() + HardCodeUtil.a(2131709608) + FileUtil.a(l) + "。";
      }
    }
  }
  
  public static CommandInfo b()
  {
    return new CommandInfo(6, BaseApplicationImpl.getContext().getString(2131720622));
  }
  
  public static void b(List<String> paramList, Activity paramActivity)
  {
    QLog.flushLog();
    ShareAppLogHelper localShareAppLogHelper = new ShareAppLogHelper(paramActivity);
    localShareAppLogHelper.a(new CommandUtils.3(paramList, paramActivity));
    long l1 = System.currentTimeMillis();
    long l2 = l1 - 600000L;
    Object localObject = String.format("%02d", new Object[] { Integer.valueOf(a(l2)) });
    paramList = String.format("%02d", new Object[] { Integer.valueOf(a(l1)) });
    String str = a(l2);
    paramActivity = a(l1);
    localObject = ShareAppLogHelper.a(str + "-" + (String)localObject, "-");
    paramList = ShareAppLogHelper.a(paramActivity + "-" + paramList, "-");
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CommandUtils.4(localShareAppLogHelper, (Time)localObject, paramList), 500L);
  }
  
  public static CommandInfo c()
  {
    return new CommandInfo(0, BaseApplicationImpl.getContext().getString(2131720612));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.CommandUtils
 * JD-Core Version:    0.7.0.1
 */