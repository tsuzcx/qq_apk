package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Parcelable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.mobileqq.emoticonview.IEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SystemAndEmojiEmoticonInfoSender
  implements IEmoticonInfoSender<SystemAndEmojiEmoticonInfo>
{
  private static final String TAG = "SystemAndEmojiEmoticonInfoSender";
  
  public static void addToCommonUsed(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
    localSmallYellowItem.id.set(paramInt1);
    if (paramInt2 == 1) {}
    for (paramInt2 = 1;; paramInt2 = 2)
    {
      localSmallYellowItem.type.set(paramInt2);
      long l = System.currentTimeMillis();
      localSmallYellowItem.ts.set(l);
      String str2 = "";
      String str1 = str2;
      if (paramSessionInfo != null)
      {
        str1 = str2;
        if (!android.text.TextUtils.isEmpty(paramSessionInfo.b)) {
          str1 = paramSessionInfo.b;
        }
      }
      QLog.d("SystemAndEmojiEmoticonInfoSender", 1, "send saveemoji type = " + paramInt2 + ";id = " + paramInt1 + ";ts = " + l + ";troopUin = " + str1);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (CommonUsedSystemEmojiManager)paramQQAppInterface.getManager(QQManagerFactory.COMMONUSED_SYSTEM_EMOJI_MANAGERT);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.saveSystemEmojiInfoToCahce(localSmallYellowItem);
        }
      }
      return;
    }
  }
  
  public void send(SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (paramSystemAndEmojiEmoticonInfo == null) {}
    int i;
    int j;
    boolean bool;
    do
    {
      return;
      i = paramSystemAndEmojiEmoticonInfo.emotionType;
      j = paramSystemAndEmojiEmoticonInfo.code;
      bool = paramSystemAndEmojiEmoticonInfo.isCommonUsed;
    } while (j == -1);
    paramContext = (SessionInfo)paramParcelable;
    int k = paramEditText.getSelectionStart();
    int m = paramEditText.getSelectionEnd();
    paramParcelable = paramEditText.getEditableText();
    if (i == 1) {}
    for (paramSystemAndEmojiEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(j);; paramSystemAndEmojiEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getEmojiString(j))
    {
      paramParcelable.replace(k, m, paramSystemAndEmojiEmoticonInfo);
      paramEditText.requestFocus();
      if ((paramAppRuntime instanceof QQAppInterface)) {
        addToCommonUsed((QQAppInterface)paramAppRuntime, paramContext, j, i);
      }
      if (bool) {
        ReportController.b(paramAppRuntime, "CliOper", "", "", "ep_mall", "0X800717F", 0, 0, i + "", j + "", "", "");
      }
      if (((paramAppRuntime instanceof QQAppInterface)) && (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(j)) && (paramContext != null))
      {
        paramSystemAndEmojiEmoticonInfo = (QQAppInterface)paramAppRuntime;
        VipUtils.a(paramSystemAndEmojiEmoticonInfo, "cmshow", "Apollo", "0X800812C", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramContext.jdField_a_of_type_Int), 0, new String[] { String.valueOf(j), String.valueOf(((IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus(paramSystemAndEmojiEmoticonInfo)) });
        ApolloDtReportUtil.a("aio", "cm_emoji", "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(paramSystemAndEmojiEmoticonInfo)).b(ApolloDtReportUtil.a(paramContext.jdField_a_of_type_Int)).c(String.valueOf(j)).f(ApolloDtReportUtil.b(paramSystemAndEmojiEmoticonInfo)).b(paramContext.jdField_a_of_type_JavaLangString).a());
      }
      QQSysAndEmojiResMgr.getInstance().getResImpl(i).reportEmoClick(j, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.SystemAndEmojiEmoticonInfoSender
 * JD-Core Version:    0.7.0.1
 */