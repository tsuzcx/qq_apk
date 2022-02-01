package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Parcelable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VasVipUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SystemAndEmojiEmoticonInfoSender
{
  private static final String TAG = "SystemAndEmojiEmoticonInfoSender";
  
  public static void addToCommonUsed(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2)
  {
    EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
    localSmallYellowItem.id.set(paramInt1);
    if (paramInt2 == 1) {
      paramInt2 = 1;
    } else {
      paramInt2 = 2;
    }
    localSmallYellowItem.type.set(paramInt2);
    long l = System.currentTimeMillis();
    localSmallYellowItem.ts.set(l);
    if ((paramBaseSessionInfo != null) && (!android.text.TextUtils.isEmpty(paramBaseSessionInfo.c))) {
      paramBaseSessionInfo = paramBaseSessionInfo.c;
    } else {
      paramBaseSessionInfo = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send saveemoji type = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(";id = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(";ts = ");
    localStringBuilder.append(l);
    localStringBuilder.append(";troopUin = ");
    localStringBuilder.append(paramBaseSessionInfo);
    QLog.d("SystemAndEmojiEmoticonInfoSender", 1, localStringBuilder.toString());
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface = (ICommonUsedSystemEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(ICommonUsedSystemEmojiManagerService.class);
      if (paramBaseQQAppInterface != null) {
        paramBaseQQAppInterface.saveSystemEmojiInfoToCahce(localSmallYellowItem);
      }
    }
  }
  
  public static void send(SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (paramSystemAndEmojiEmoticonInfo == null) {
      return;
    }
    int i = paramSystemAndEmojiEmoticonInfo.emotionType;
    int j = paramSystemAndEmojiEmoticonInfo.code;
    boolean bool1 = paramSystemAndEmojiEmoticonInfo.isCommonUsed;
    if (j == -1) {
      return;
    }
    paramContext = (BaseSessionInfo)paramParcelable;
    int k = paramEditText.getSelectionStart();
    int m = paramEditText.getSelectionEnd();
    paramParcelable = paramEditText.getEditableText();
    if (i == 1) {
      paramSystemAndEmojiEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(j);
    } else {
      paramSystemAndEmojiEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getEmojiString(j);
    }
    paramParcelable.replace(k, m, paramSystemAndEmojiEmoticonInfo);
    paramEditText.requestFocus();
    boolean bool2 = paramAppRuntime instanceof BaseQQAppInterface;
    if (bool2) {
      addToCommonUsed((BaseQQAppInterface)paramAppRuntime, paramContext, j, i);
    }
    if (bool1)
    {
      paramSystemAndEmojiEmoticonInfo = new StringBuilder();
      paramSystemAndEmojiEmoticonInfo.append(i);
      paramSystemAndEmojiEmoticonInfo.append("");
      paramSystemAndEmojiEmoticonInfo = paramSystemAndEmojiEmoticonInfo.toString();
      paramEditText = new StringBuilder();
      paramEditText.append(j);
      paramEditText.append("");
      ReportController.b(paramAppRuntime, "CliOper", "", "", "ep_mall", "0X800717F", 0, 0, paramSystemAndEmojiEmoticonInfo, paramEditText.toString(), "", "");
    }
    if ((bool2) && (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(j)) && (paramContext != null))
    {
      paramSystemAndEmojiEmoticonInfo = (BaseQQAppInterface)paramAppRuntime;
      VasVipUtils.a(paramSystemAndEmojiEmoticonInfo, "cmshow", "Apollo", "0X800812C", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramContext.a), 0, new String[] { String.valueOf(j), String.valueOf(((IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus()) });
      k = QQSysAndEmojiResMgr.getInstance().getResImpl(i).getServerId(j);
      paramAppRuntime = (IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class);
      paramAppRuntime.report("aio", "cm_emoji", "click", new DtReportParamsBuilder().a(paramAppRuntime.getApolloMode(paramSystemAndEmojiEmoticonInfo)).b(paramAppRuntime.getReportSessionType(paramContext.a)).f(String.valueOf(k)).f(paramAppRuntime.getUserStatus(paramSystemAndEmojiEmoticonInfo)).c(paramContext.b).a());
    }
    QQSysAndEmojiResMgr.getInstance().getResImpl(i).reportEmoClick(j, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.SystemAndEmojiEmoticonInfoSender
 * JD-Core Version:    0.7.0.1
 */