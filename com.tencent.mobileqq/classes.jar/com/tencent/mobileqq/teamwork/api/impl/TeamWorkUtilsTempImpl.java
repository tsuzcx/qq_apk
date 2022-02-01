package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TenDocHistoryTabEmptyTipsBean;
import com.tencent.mobileqq.config.business.tendoc.TenDocHistoryTabEmptyTipsProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocStructMsgGrayTipsConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocStructMsgGrayTipsConfigProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.imcore.proxy.utils.ContactUtilsProxy;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.teamwork.CommonUtils;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.oidb.cmd0x857.TroopTips0x857.TroopFormGrayTipsInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;

public class TeamWorkUtilsTempImpl
  implements ITeamWorkUtilsTemp
{
  private static final String TAG = "TeamWorkUtils";
  
  private static String getTroopFormGrayContent(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return null;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TeamWorkUtils");
      ((StringBuilder)localObject1).append(TeamWorkConstants.i);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("troopFormLog getTroopFormGrayContent =.");
      ((StringBuilder)localObject2).append(paramString1);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      if (TextUtils.isEmpty(paramString1)) {
        return null;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramString1);
      int k = 0;
      int j;
      for (int i = 0; localMatcher.find(); i = j)
      {
        j = localMatcher.start();
        int m = localMatcher.end();
        localObject1 = paramString1.substring(j + 1, m);
        localSpannableStringBuilder.append(paramString1.substring(k, j));
        k = i;
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          k = i;
          if (((JSONObject)localObject1).has("uin"))
          {
            k = i;
            String str1 = ((JSONObject)localObject1).getString("uin");
            k = i;
            String str2 = paramAppInterface.getCurrentAccountUin();
            k = i;
            if (!TextUtils.isEmpty(paramString2))
            {
              k = i;
              localObject1 = ((ITroopMemberNameService)paramAppInterface.getRuntimeService(ITroopMemberNameService.class, "all")).getTroopMemberNameRemarkFirst(paramString2, str1);
            }
            else
            {
              k = i;
              localObject1 = ContactUtils.f(localQQAppInterface, str1);
            }
            j = i;
            localObject2 = localObject1;
            k = i;
            if (!TextUtils.isEmpty(str2))
            {
              j = i;
              localObject2 = localObject1;
              k = i;
              if (str2.equals(str1))
              {
                j = i;
                localObject2 = localObject1;
                if (i == 0)
                {
                  k = i;
                  localObject2 = ITeamWorkUtils.TROOP_FORM_GREY_NICKNAME;
                  j = 1;
                }
              }
            }
            k = j;
            localSpannableStringBuilder.append((CharSequence)localObject2);
          }
          else
          {
            k = i;
            j = i;
            if (((JSONObject)localObject1).has("text"))
            {
              k = i;
              j = i;
              if (((JSONObject)localObject1).has("isLink"))
              {
                k = i;
                j = i;
                if (((JSONObject)localObject1).getString("isLink").equals("1"))
                {
                  k = i;
                  localObject1 = ((JSONObject)localObject1).getString("text");
                  k = i;
                  j = i;
                  if (!TextUtils.isEmpty((CharSequence)localObject1))
                  {
                    k = i;
                    localSpannableStringBuilder.append((CharSequence)localObject1);
                    j = i;
                  }
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          j = k;
        }
        k = m + 1;
      }
      if (k != paramString1.length()) {
        localSpannableStringBuilder.append(paramString1.subSequence(k, paramString1.length()));
      }
      return localSpannableStringBuilder.toString();
    }
    return null;
  }
  
  private void tdDocMessageRecordSaveToFMDB(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      paramAppInterface = (QQAppInterface)paramAppInterface;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
        if (localMessageForStructing.structingMsg != null)
        {
          if (TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgUrl)) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TeamWorkConstants.i, 2, "tencentdoc also need insert into fm db");
          }
          msg_comm.Msg localMsg = new msg_comm.Msg();
          Object localObject1 = new msg_comm.MsgHead();
          localMsg.msg_head.set((MessageMicro)localObject1);
          ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_uid.set(localMessageForStructing.longMsgId);
          ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_time.set((int)localMessageForStructing.time);
          if ((localMessageForStructing.senderuin != null) && (localMessageForStructing.frienduin != null) && (localMessageForStructing.selfuin != null)) {
            if (localMessageForStructing.senderuin.equals(localMessageForStructing.frienduin))
            {
              ((msg_comm.MsgHead)localMsg.msg_head.get()).from_uin.set(Long.parseLong(localMessageForStructing.senderuin));
              ((msg_comm.MsgHead)localMsg.msg_head.get()).to_uin.set(Long.parseLong(localMessageForStructing.selfuin));
            }
            else
            {
              ((msg_comm.MsgHead)localMsg.msg_head.get()).from_uin.set(Long.parseLong(localMessageForStructing.senderuin));
              ((msg_comm.MsgHead)localMsg.msg_head.get()).to_uin.set(Long.parseLong(localMessageForStructing.frienduin));
            }
          }
          if (localMessageForStructing.istroop == 1)
          {
            localObject1 = new msg_comm.C2CTmpMsgHead();
            ((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.set((MessageMicro)localObject1);
            ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.get()).service_type.set(1);
            if (localMessageForStructing.frienduin != null) {
              ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.get()).group_code.set(Integer.parseInt(localMessageForStructing.frienduin));
            }
          }
          ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_seq.set((short)(int)localMessageForStructing.msgseq);
          localObject1 = new im_msg_body.NotOnlineFile();
          ((im_msg_body.NotOnlineFile)localObject1).uint32_file_type.set(0);
          ((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(localMessageForStructing.structingMsg.mMsgUrl));
          ((im_msg_body.NotOnlineFile)localObject1).uint64_file_size.set(0L);
          ((im_msg_body.NotOnlineFile)localObject1).uint32_subcmd.set(1);
          Object localObject2;
          if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
          {
            localObject2 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
            if (TextUtils.isEmpty(((StructMsgForGeneralShare)localObject2).mContentCover)) {
              ((StructMsgForGeneralShare)localObject2).mContentCover = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTDDocFileThumbUrl(((StructMsgForGeneralShare)localObject2).mMsgUrl);
            }
            if (!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject2).mContentTitle)) {
              ((im_msg_body.NotOnlineFile)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(((StructMsgForGeneralShare)localObject2).mContentTitle));
            }
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("structmsg_service_id", ((StructMsgForGeneralShare)localObject2).mMsgServiceID);
              localJSONObject.put("stuctmsg_bytes", Base64.encodeToString(((StructMsgForGeneralShare)localObject2).getBytes(), 0));
              localJSONObject.put("structmsg_uniseq", paramMessageRecord.uniseq);
              localJSONObject.put("accostType", ((StructMsgForGeneralShare)localObject2).sourceAccoutType);
            }
            catch (JSONException paramMessageRecord)
            {
              if (QLog.isColorLevel()) {
                QLog.e(TeamWorkConstants.i, 2, paramMessageRecord.getMessage());
              }
            }
            ((im_msg_body.NotOnlineFile)localObject1).bytes_note.set(ByteStringMicro.copyFromUtf8(((StructMsgForGeneralShare)localObject2).mContentCover));
            ((im_msg_body.NotOnlineFile)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(localJSONObject.toString().getBytes()));
          }
          paramMessageRecord = new ArrayList(paramAppInterface.getFileManagerProxy().b()).iterator();
          while (paramMessageRecord.hasNext())
          {
            localObject2 = (FileManagerEntity)paramMessageRecord.next();
            if ((((FileManagerEntity)localObject2).Uuid != null) && (((FileManagerEntity)localObject2).Uuid.equalsIgnoreCase(localMessageForStructing.structingMsg.mMsgUrl)))
            {
              ((FileManagerEntity)localObject2).srvTime = (localMessageForStructing.time * 1000L);
              ((FileManagerEntity)localObject2).bDelInFM = false;
              paramAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject2);
              return;
            }
          }
          ThreadManager.getUIHandler().post(new TeamWorkUtilsTempImpl.4(this, paramAppInterface, localMsg, (im_msg_body.NotOnlineFile)localObject1, localMessageForStructing));
        }
      }
    }
  }
  
  public void addTeamWorkGrayTips(AppInterface paramAppInterface, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2, String paramString3)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      DocsGrayTipsInfo localDocsGrayTipsInfo = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).paseDocsGrayTipsInfoFromJson(paramString2, paramString1, paramString3);
      if (localDocsGrayTipsInfo != null)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TeamWorkUtils");
        ((StringBuilder)localObject1).append(TeamWorkConstants.i);
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addTeamWorkGrayTips. docsGrayTipsInfo = ");
        ((StringBuilder)localObject2).append(localDocsGrayTipsInfo.toString());
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        if ((!TextUtils.isEmpty(localDocsGrayTipsInfo.c)) && (Integer.valueOf(localDocsGrayTipsInfo.c).intValue() == 1))
        {
          int i;
          if (paramInt == 1)
          {
            i = TencentDocStructMsgGrayTipsConfigProcessor.a().b();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("TeamWorkUtils");
            ((StringBuilder)localObject1).append(TeamWorkConstants.i);
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("addTeamWorkGrayTips. groupFlag = ");
            ((StringBuilder)localObject2).append(i);
            QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            if (i == 0) {
              return;
            }
            i = SharedPreUtils.aF(paramAppInterface.getApp(), paramAppInterface.getCurrentAccountUin()) + 1;
            int j = TencentDocStructMsgGrayTipsConfigProcessor.a().a();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("TeamWorkUtils");
            ((StringBuilder)localObject1).append(TeamWorkConstants.i);
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("addTeamWorkGrayTips. groupShowedCount = ");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(", groupShowCount = ");
            ((StringBuilder)localObject2).append(j);
            QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            if (i > j) {
              return;
            }
            SharedPreUtils.T(paramAppInterface.getApp(), paramAppInterface.getCurrentAccountUin(), i);
          }
          else
          {
            if (TencentDocStructMsgGrayTipsConfigProcessor.a().d() == 0) {
              return;
            }
            i = SharedPreUtils.aE(paramAppInterface.getApp(), paramAppInterface.getCurrentAccountUin()) + 1;
            if (i > TencentDocStructMsgGrayTipsConfigProcessor.a().c()) {
              return;
            }
            SharedPreUtils.S(paramAppInterface.getApp(), paramAppInterface.getCurrentAccountUin(), i);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("TeamWorkUtils");
            ((StringBuilder)localObject1).append(TeamWorkConstants.i);
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("yunying gray tip showed count = ");
            ((StringBuilder)localObject2).append(i);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
        }
        localObject2 = new MessageForUniteGrayTip();
        if (paramInt == 1)
        {
          localObject1 = new UniteGrayTipParam(paramString1, paramAppInterface.getCurrentAccountUin(), localDocsGrayTipsInfo.e, 1, -5020, 3276802, paramLong2);
          ((MessageForUniteGrayTip)localObject2).shmsgseq = (paramLong1 + 1L);
        }
        else
        {
          localObject1 = new UniteGrayTipParam(paramString1, paramAppInterface.getCurrentAccountUin(), localDocsGrayTipsInfo.e, 0, -5020, 3276802, paramLong2);
        }
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 33);
        localBundle.putString("textColor", "#40A0FF");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("@#@");
        localStringBuilder.append(String.valueOf(((MessageForUniteGrayTip)localObject2).uniseq));
        localBundle.putString("key_action_DATA", localStringBuilder.toString());
        localBundle.putString("key_a_action_DATA", paramString3);
        localBundle.putString("troop_mem_uin", paramString1);
        paramString1 = localDocsGrayTipsInfo.a();
        ((UniteGrayTipParam)localObject1).a(paramString1[0], paramString1[1], localBundle);
        paramString1 = (QQAppInterface)paramAppInterface;
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramString1, (UniteGrayTipParam)localObject1);
        UniteGrayTipMsgUtil.a(paramString1, (MessageForUniteGrayTip)localObject2);
        if ("1".equals(localDocsGrayTipsInfo.d))
        {
          if (paramInt == 1) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          ReportController.b(null, "CliOper", "", "", "0X80095F2", "0X80095F2", paramInt, 0, "", "", "", "");
        }
        else if ("2".equals(localDocsGrayTipsInfo.d))
        {
          if (paramInt == 1) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          ReportController.b(null, "CliOper", "", "", "0X80095F1", "0X80095F1", paramInt, 0, "", "", "", "");
        }
        if (localDocsGrayTipsInfo.s.equals(TeamWorkConstants.k)) {
          ReportController.b(paramAppInterface, "dc00898", "", "", "0X8009C78", "0X8009C78", 0, 0, "", "", "", "");
        }
      }
      else
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("TeamWorkUtils");
        paramAppInterface.append(TeamWorkConstants.i);
        QLog.e(paramAppInterface.toString(), 1, "addTeamWorkGrayTips. docsGrayTipsInfo is null.");
      }
    }
  }
  
  public void configHistoryTabEmptyTips(TextView paramTextView, View.OnClickListener paramOnClickListener)
  {
    if (paramTextView == null) {
      return;
    }
    Object localObject2 = TenDocHistoryTabEmptyTipsProcessor.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new TenDocHistoryTabEmptyTipsBean();
    }
    localObject2 = ((TenDocHistoryTabEmptyTipsBean)localObject1).a();
    String str = ((TenDocHistoryTabEmptyTipsBean)localObject1).b();
    if (TextUtils.isEmpty(str))
    {
      paramTextView.setText((CharSequence)localObject2);
      return;
    }
    int k = ((String)localObject2).indexOf(str);
    if (k < 0)
    {
      paramTextView.setText(((TenDocHistoryTabEmptyTipsBean)localObject1).a());
      return;
    }
    int j = str.length() + k;
    int i = j;
    if (j > ((String)localObject2).length()) {
      i = ((String)localObject2).length();
    }
    j = Color.parseColor("#4D94FF");
    int m = Color.parseColor("#804D94FF");
    localObject1 = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { m, j });
    localObject2 = new SpannableString((CharSequence)localObject2);
    ((SpannableString)localObject2).setSpan(new DatingCommentTextView.TouchableSpan(paramOnClickListener, (ColorStateList)localObject1), k, i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject2);
    paramTextView.setFocusable(false);
    paramTextView.setClickable(false);
    paramTextView.setLongClickable(false);
  }
  
  public List<ChatMessage> createChatMsgListFromTencentDocs(List<TencentDocData> paramList, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (CommonUtils.a(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (TencentDocData)paramList.next();
        MessageForStructing localMessageForStructing = new MessageForStructing();
        localMessageForStructing.structingMsg = new StructMsgForGeneralShare();
        localMessageForStructing.senderuin = String.valueOf(((TencentDocData)localObject).sendUin);
        localMessageForStructing.selfuin = paramString1;
        localMessageForStructing.frienduin = paramString2;
        localMessageForStructing.issend = 1;
        localMessageForStructing.msgtype = -2011;
        localMessageForStructing.time = ((TencentDocData)localObject).aioTime;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgAction = ((TencentDocData)localObject).action;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceAction = ((TencentDocData)localObject).sourceAction;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgServiceID = ((TencentDocData)localObject).serviceId;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentCover = ((TencentDocData)localObject).docIcon;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentSummary = ((TencentDocData)localObject).summary;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentTitle = ((TencentDocData)localObject).getTitle();
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceIcon = ((TencentDocData)localObject).icon;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceName = ((TencentDocData)localObject).sourceName;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgBrief = ((TencentDocData)localObject).getBriefDes(BaseApplication.getContext());
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceUrl = ((TencentDocData)localObject).url;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceAppid = ((TencentDocData)localObject).appid;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgUrl = ((TencentDocData)localObject).docUrl;
        localObject = new StructMsgItemLayout2();
        ((AbsStructMsgItem)localObject).b(0);
        StructMsgItemCover localStructMsgItemCover = new StructMsgItemCover(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentCover);
        localStructMsgItemCover.t = StructMsgItemCover.q;
        ((AbsStructMsgItem)localObject).a(localStructMsgItemCover);
        ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentTitle));
        ((AbsStructMsgItem)localObject).a(new StructMsgItemSummary(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentSummary));
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mStructMsgItemLists.add(localObject);
        localArrayList.add(localMessageForStructing);
      }
    }
    return localArrayList;
  }
  
  public void forwardTencentDoc(Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity != null) && (paramFileManagerEntity.bombData != null)) {
      try
      {
        Intent localIntent = new Intent();
        Object localObject = new JSONObject(new String(paramFileManagerEntity.bombData));
        paramFileManagerEntity = new Bundle();
        paramFileManagerEntity.putInt("forward_type", -3);
        paramFileManagerEntity.putInt("structmsg_service_id", ((JSONObject)localObject).getInt("structmsg_service_id"));
        paramFileManagerEntity.putByteArray("stuctmsg_bytes", Base64.decode(((JSONObject)localObject).getString("stuctmsg_bytes"), 0));
        paramFileManagerEntity.putLong("structmsg_uniseq", ((JSONObject)localObject).getLong("structmsg_uniseq"));
        paramFileManagerEntity.putInt("accostType", ((JSONObject)localObject).getInt("accostType"));
        paramFileManagerEntity.putBoolean("forwardDirect", true);
        localObject = new Intent();
        ((Intent)localObject).putExtra("forward_type", -3);
        ((Intent)localObject).putExtras(paramFileManagerEntity);
        localIntent.putExtra("forwardDirect", true);
        ForwardBaseOption.a(paramActivity, (Intent)localObject, 103, -1);
        return;
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    QLog.i("TeamWorkUtils", 1, "forwardRecentFileRecord. tencentDoc data is null");
  }
  
  public String getTeamWorkHandlerName()
  {
    return ITeamWorkHandler.class.getName();
  }
  
  public String getTroopFormGrayParameter(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface)))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      StringBuilder localStringBuilder;
      if (paramInt == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("groupid=");
        localStringBuilder.append(paramString);
        localStringBuilder.append("&groupname=");
        localStringBuilder.append(ContactUtilsProxy.b(paramAppInterface, paramString, false));
        localStringBuilder.append("&uinType=");
        localStringBuilder.append(paramInt);
        return localStringBuilder.toString();
      }
      if (paramInt == 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("groupid=");
        localStringBuilder.append(paramString);
        localStringBuilder.append("&groupname=");
        localStringBuilder.append(ContactUtils.f(paramAppInterface, paramString));
        localStringBuilder.append("&uinType=");
        localStringBuilder.append(paramInt);
        return localStringBuilder.toString();
      }
      return "";
    }
    return null;
  }
  
  public void insertTroopFormGrayTips(AppInterface paramAppInterface, MessageMicro paramMessageMicro)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      if ((paramMessageMicro != null) && ((paramMessageMicro instanceof SubMsgType0x119.MsgBody)))
      {
        paramMessageMicro = (SubMsgType0x119.MsgBody)paramMessageMicro;
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TeamWorkUtils");
        ((StringBuilder)localObject1).append(TeamWorkConstants.i);
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("troopFormLog insertTroopFormGrayTips c2c = ");
        ((StringBuilder)localObject2).append(paramMessageMicro.toString());
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        localObject1 = paramAppInterface.getApp().getString(2131719869);
        localObject2 = paramMessageMicro.bytes_opt_bytes_url.get().toStringUtf8();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramMessageMicro.uint64_writer_uin.get());
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(paramMessageMicro.uint64_creator_uin.get());
        ((StringBuilder)localObject4).append("");
        localObject4 = ((StringBuilder)localObject4).toString();
        String str = paramMessageMicro.bytes_rich_content.get().toStringUtf8();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopFormLog insertTroopFormGrayTips url = ");
        localStringBuilder.append((String)localObject2);
        QLog.i("TeamWorkUtils", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopFormLog insertTroopFormGrayTips writerUin = ");
        localStringBuilder.append((String)localObject3);
        QLog.i("TeamWorkUtils", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopFormLog insertTroopFormGrayTips creatorUin = ");
        localStringBuilder.append((String)localObject4);
        QLog.i("TeamWorkUtils", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopFormLog insertTroopFormGrayTips context = ");
        localStringBuilder.append(str);
        QLog.i("TeamWorkUtils", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopFormLog insertTroopFormGrayTips creator_nick = ");
        localStringBuilder.append(paramMessageMicro.bytes_creator_nick.get().toStringUtf8());
        QLog.i("TeamWorkUtils", 1, localStringBuilder.toString());
        paramMessageMicro = paramAppInterface.getCurrentUin();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramMessageMicro)))
        {
          if ((!paramMessageMicro.equals(localObject3)) && (!paramMessageMicro.equals(localObject4))) {
            return;
          }
          str = getTroopFormGrayContent(localQQAppInterface, str, "");
          if (TextUtils.isEmpty(str)) {
            return;
          }
          int i = str.indexOf((String)localObject1);
          if (i == -1) {
            return;
          }
          new Thread(new TeamWorkUtilsTempImpl.2(this, paramMessageMicro, (String)localObject3, (String)localObject4, paramAppInterface, str, (String)localObject2, localQQAppInterface, i, (String)localObject1)).start();
          return;
        }
        return;
      }
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("TeamWorkUtils");
      paramAppInterface.append(TeamWorkConstants.i);
      QLog.e(paramAppInterface.toString(), 1, "troopFormLog insertTroopFormGrayTipsInfo is null.");
    }
  }
  
  public void insertTroopFormGrayTips(AppInterface paramAppInterface, MessageMicro paramMessageMicro, String paramString)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      if ((paramMessageMicro != null) && ((paramMessageMicro instanceof TroopTips0x857.TroopFormGrayTipsInfo)))
      {
        Object localObject2 = (TroopTips0x857.TroopFormGrayTipsInfo)paramMessageMicro;
        paramMessageMicro = new StringBuilder();
        paramMessageMicro.append("TeamWorkUtils");
        paramMessageMicro.append(TeamWorkConstants.i);
        paramMessageMicro = paramMessageMicro.toString();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("troopFormLog insertTroopFormGrayTips troop = ");
        ((StringBuilder)localObject1).append(localObject2.toString());
        QLog.i(paramMessageMicro, 1, ((StringBuilder)localObject1).toString());
        paramMessageMicro = paramAppInterface.getApp().getString(2131719869);
        localObject1 = ((TroopTips0x857.TroopFormGrayTipsInfo)localObject2).bytes_opt_bytes_url.get().toStringUtf8();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((TroopTips0x857.TroopFormGrayTipsInfo)localObject2).uint64_writer_uin.get());
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((TroopTips0x857.TroopFormGrayTipsInfo)localObject2).uint64_creator_uin.get());
        ((StringBuilder)localObject4).append("");
        localObject4 = ((StringBuilder)localObject4).toString();
        String str = ((TroopTips0x857.TroopFormGrayTipsInfo)localObject2).bytes_rich_content.get().toStringUtf8();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopFormLog insertTroopFormGrayTips url = ");
        localStringBuilder.append((String)localObject1);
        QLog.i("TeamWorkUtils", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopFormLog insertTroopFormGrayTips writerUin = ");
        localStringBuilder.append((String)localObject3);
        QLog.i("TeamWorkUtils", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopFormLog insertTroopFormGrayTips creatorUin = ");
        localStringBuilder.append((String)localObject4);
        QLog.i("TeamWorkUtils", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopFormLog insertTroopFormGrayTips context = ");
        localStringBuilder.append(str);
        QLog.i("TeamWorkUtils", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopFormLog insertTroopFormGrayTips creator_nick = ");
        localStringBuilder.append(((TroopTips0x857.TroopFormGrayTipsInfo)localObject2).bytes_creator_nick.get().toStringUtf8());
        QLog.i("TeamWorkUtils", 1, localStringBuilder.toString());
        paramAppInterface = paramAppInterface.getCurrentUin();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramAppInterface)))
        {
          if ((!paramAppInterface.equals(localObject3)) && (!paramAppInterface.equals(localObject4))) {
            return;
          }
          paramAppInterface = getTroopFormGrayContent(localQQAppInterface, str, paramString);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("troopFormLog insertTroopFormGrayTips tips = ");
          ((StringBuilder)localObject2).append(paramAppInterface);
          QLog.i("TeamWorkUtils", 1, ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("troopFormLog insertTroopFormGrayTips troopUin = ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.i("TeamWorkUtils", 1, ((StringBuilder)localObject2).toString());
          if (TextUtils.isEmpty(paramAppInterface)) {
            return;
          }
          int i = paramAppInterface.indexOf(paramMessageMicro);
          if (i == -1) {
            return;
          }
          new Thread(new TeamWorkUtilsTempImpl.1(this, paramString, paramAppInterface, localQQAppInterface, (String)localObject1, i, paramMessageMicro)).start();
          return;
        }
        return;
      }
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("TeamWorkUtils");
      paramAppInterface.append(TeamWorkConstants.i);
      QLog.e(paramAppInterface.toString(), 1, "troopFormLog insertTroopFormGrayTips Info is null.");
    }
  }
  
  public boolean isPreloadToolProcess(AppInterface paramAppInterface)
  {
    paramAppInterface = (ITeamWorkHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
    if (paramAppInterface != null) {
      return paramAppInterface.getPreloadToolProcess();
    }
    return false;
  }
  
  public boolean isTeamWorkStructMsg(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord.structingMsg != null) && (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mMsgUrl)) && ((paramMessageRecord.structingMsg.mMsgUrl.contains("docx.qq.com")) || (paramMessageRecord.structingMsg.mMsgUrl.contains("docs.qq.com")))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isTencentDocsAssistantEnable(AppInterface paramAppInterface)
  {
    paramAppInterface = (ITeamWorkHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
    if (paramAppInterface != null) {
      return paramAppInterface.getEnableTencentDocsAssistant();
    }
    return false;
  }
  
  public void onGetGroupAuthDocsGrayTipsInfo(AppInterface paramAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      try
      {
        DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramArrayOfObject[0];
        String str = (String)paramArrayOfObject[1];
        long l = ((Long)paramArrayOfObject[2]).longValue();
        if (paramAppInterface.getApp().getString(2131719549).equals(str))
        {
          paramContext = ((QQAppInterface)paramAppInterface).getMessageFacade().a(localDocsGrayTipsInfo.jdField_a_of_type_JavaLangString, 1, l);
          if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
          {
            paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
            if (paramArrayOfObject.tipParam != null) {
              paramArrayOfObject.tipParam.a();
            }
            paramArrayOfObject.updateUniteGrayTipMsg((QQAppInterface)paramAppInterface, str);
            paramAppInterface = new Message();
            paramArrayOfObject = new Bundle();
            paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
            paramAppInterface.setData(paramArrayOfObject);
            paramAppInterface.what = 78;
            paramAppInterface.arg1 = 0;
            paramMqqHandler.sendMessage(paramAppInterface);
          }
        }
        else
        {
          QQToast.a(paramContext, str, 0).a();
        }
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("TeamWorkUtils");
        paramAppInterface.append(TeamWorkConstants.i);
        paramAppInterface = paramAppInterface.toString();
        paramContext = new StringBuilder();
        paramContext.append(" onGetGroupAuth  isSuccess = ");
        paramContext.append(paramBoolean);
        paramContext.append(" tips =");
        paramContext.append(str);
        QLog.i(paramAppInterface, 1, paramContext.toString());
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramContext = new StringBuilder();
        paramContext.append("TeamWorkUtils");
        paramContext.append(TeamWorkConstants.i);
        paramContext = paramContext.toString();
        paramMqqHandler = new StringBuilder();
        paramMqqHandler.append(" onGetGroupAuth  exception = ");
        paramMqqHandler.append(paramAppInterface.toString());
        QLog.e(paramContext, 1, paramMqqHandler.toString());
      }
    }
  }
  
  public void onGetUserAuthDocsGrayTipsInfo(AppInterface paramAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      try
      {
        DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramArrayOfObject[0];
        String str = (String)paramArrayOfObject[1];
        long l = ((Long)paramArrayOfObject[2]).longValue();
        if (paramAppInterface.getApp().getString(2131719549).equals(str))
        {
          paramContext = ((QQAppInterface)paramAppInterface).getMessageFacade().a(localDocsGrayTipsInfo.jdField_a_of_type_JavaLangString, 0, l);
          if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
          {
            paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
            if (paramArrayOfObject.tipParam != null) {
              paramArrayOfObject.tipParam.a();
            }
            paramArrayOfObject.updateUniteGrayTipMsg((QQAppInterface)paramAppInterface, str);
            paramAppInterface = new Message();
            paramArrayOfObject = new Bundle();
            paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
            paramAppInterface.setData(paramArrayOfObject);
            paramAppInterface.what = 78;
            paramAppInterface.arg1 = 0;
            paramMqqHandler.sendMessage(paramAppInterface);
          }
        }
        else
        {
          QQToast.a(paramContext, str, 0).a();
        }
        paramAppInterface = TeamWorkConstants.i;
        paramContext = new StringBuilder();
        paramContext.append(" onGetUserAuth  isSuccess = ");
        paramContext.append(paramBoolean);
        paramContext.append(" tips =");
        paramContext.append(str);
        QLog.i(paramAppInterface, 2, paramContext.toString());
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramContext = TeamWorkConstants.i;
        paramMqqHandler = new StringBuilder();
        paramMqqHandler.append(" onGetUserAuth  exception = ");
        paramMqqHandler.append(paramAppInterface.toString());
        QLog.e(paramContext, 2, paramMqqHandler.toString());
      }
    }
  }
  
  public void onSetGroupAuthDocsGrayTipsInfo(AppInterface paramAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TeamWorkUtils");
        ((StringBuilder)localObject1).append(TeamWorkConstants.i);
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" onSetGroupAuth  isSuccess = ");
        ((StringBuilder)localObject2).append(paramBoolean);
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        localObject2 = (DocsGrayTipsInfo)paramArrayOfObject[0];
        localObject1 = (String)paramArrayOfObject[1];
        long l = ((Long)paramArrayOfObject[2]).longValue();
        if (paramBoolean)
        {
          paramContext = ((QQAppInterface)paramAppInterface).getMessageFacade().a(((DocsGrayTipsInfo)localObject2).jdField_a_of_type_JavaLangString, 1, l);
          if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
          {
            paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
            if (paramArrayOfObject.tipParam != null) {
              paramArrayOfObject.tipParam.a();
            }
            paramArrayOfObject.updateUniteGrayTipMsg((QQAppInterface)paramAppInterface, (String)localObject1);
            paramAppInterface = new Message();
            paramArrayOfObject = new Bundle();
            paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
            paramAppInterface.setData(paramArrayOfObject);
            paramAppInterface.what = 78;
            paramAppInterface.arg1 = 0;
            paramMqqHandler.sendMessage(paramAppInterface);
          }
        }
        else
        {
          QQToast.a(paramContext, (CharSequence)localObject1, 0).a();
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramContext = new StringBuilder();
        paramContext.append("TeamWorkUtils");
        paramContext.append(TeamWorkConstants.i);
        paramContext = paramContext.toString();
        paramMqqHandler = new StringBuilder();
        paramMqqHandler.append(" onSetGroupAuth  exception  = ");
        paramMqqHandler.append(paramAppInterface.toString());
        QLog.e(paramContext, 1, paramMqqHandler.toString());
      }
    }
  }
  
  public void onSetUserAuthDocsGrayTipsInfo(AppInterface paramAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      try
      {
        String str = TeamWorkConstants.i;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" onSetUserAuth  isSuccess = ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i(str, 2, ((StringBuilder)localObject).toString());
        localObject = (DocsGrayTipsInfo)paramArrayOfObject[0];
        str = (String)paramArrayOfObject[1];
        long l = ((Long)paramArrayOfObject[2]).longValue();
        if (paramBoolean)
        {
          paramContext = ((QQAppInterface)paramAppInterface).getMessageFacade().a(((DocsGrayTipsInfo)localObject).jdField_a_of_type_JavaLangString, 0, l);
          if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
          {
            paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
            if (paramArrayOfObject.tipParam != null) {
              paramArrayOfObject.tipParam.a();
            }
            paramArrayOfObject.updateUniteGrayTipMsg((QQAppInterface)paramAppInterface, str);
            paramAppInterface = new Message();
            paramArrayOfObject = new Bundle();
            paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
            paramAppInterface.setData(paramArrayOfObject);
            paramAppInterface.what = 78;
            paramAppInterface.arg1 = 0;
            paramMqqHandler.sendMessage(paramAppInterface);
          }
        }
        else
        {
          QQToast.a(paramContext, str, 0).a();
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramContext = TeamWorkConstants.i;
        paramMqqHandler = new StringBuilder();
        paramMqqHandler.append(" onSetUserAuth  exception  = ");
        paramMqqHandler.append(paramAppInterface.toString());
        QLog.e(paramContext, 1, paramMqqHandler.toString());
      }
    }
  }
  
  public void openTroopTemplatePreviewUrlWithCheck(AppInterface paramAppInterface, Activity paramActivity, int paramInt, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      String str = QFileUtils.a((QQAppInterface)paramAppInterface, paramLong1, paramLong3);
      if (!TextUtils.isEmpty(str))
      {
        QQToast.a(paramActivity, str, 0).a();
        return;
      }
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).openGroupPadTemplateListUrl(paramAppInterface, paramActivity, paramInt, paramString, paramLong1, paramLong2);
    }
  }
  
  public void processTDDocFileUrl(String paramString)
  {
    processTDDocFileUrl(paramString, null);
  }
  
  public void processTDDocFileUrl(String paramString, ChatMessage paramChatMessage)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str1;
    Object localObject;
    if (paramChatMessage != null)
    {
      str1 = paramChatMessage.senderuin;
      localObject = paramChatMessage.frienduin;
    }
    else
    {
      str1 = null;
      localObject = str1;
    }
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      String str2 = localQQAppInterface.getCurrentAccountUin();
      JSONObject localJSONObject = TeamWorkHandlerUtils.a(paramString, str2);
      if (localJSONObject.getInt("retcode") == 0)
      {
        TencentDocData localTencentDocData = new TencentDocData();
        TencentDocData.obtainFromJsonObject(localJSONObject, null, localTencentDocData);
        localTencentDocData.docUrl = paramString;
        paramString = str1;
        if (str1 == null) {
          paramString = str2;
        }
        localTencentDocData.sendUin = Long.parseLong(paramString);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = str2;
        }
        localTencentDocData.aioTime = (System.currentTimeMillis() / 1000L);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(localTencentDocData);
        paramString = createChatMsgListFromTencentDocs((List)localObject, str2, paramString).iterator();
        while (paramString.hasNext())
        {
          localObject = (ChatMessage)paramString.next();
          if (paramChatMessage != null) {
            ((ChatMessage)localObject).istroop = paramChatMessage.istroop;
          }
          tdDocMessageRecordSaveToFMDB((MessageRecord)localObject, localQQAppInterface);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TeamWorkUtils", 2, paramString, new Object[0]);
      }
    }
  }
  
  public void scheduleAddTDFileMessageRecord(AppInterface paramAppInterface)
  {
    TeamWorkUtilsTempImpl.ProcessTDFileScheduler.a(paramAppInterface).a();
  }
  
  public void sendDocCooperationShare(AppInterface paramAppInterface, Activity paramActivity, TencentDocData paramTencentDocData, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      Object localObject = TencentDocLocalCooperationProcessor.a();
      boolean bool;
      if (localObject != null) {
        bool = ((TencentDocLocalCooperationBean)localObject).a(paramTeamWorkFileImportInfo.b);
      } else {
        bool = false;
      }
      int i;
      if (((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000)) && (TextUtils.isEmpty(paramTeamWorkFileImportInfo.n))) {
        i = 1;
      } else {
        i = 0;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_flag_from_plugin", true);
      localIntent.putExtra("k_forward_show_direct_share_tips", true);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_type", 95);
      localIntent.putExtra("pluginName", "web_share");
      localIntent.putExtra("image_url_remote", paramTencentDocData.docIcon);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentNickname());
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131714583));
      if (bool) {
        paramAppInterface = HardCodeUtil.a(2131714574);
      } else {
        paramAppInterface = HardCodeUtil.a(2131714587);
      }
      ((StringBuilder)localObject).append(paramAppInterface);
      ((StringBuilder)localObject).append("《");
      ((StringBuilder)localObject).append(paramTencentDocData.title);
      ((StringBuilder)localObject).append("》");
      localObject = ((StringBuilder)localObject).toString();
      paramAppInterface = (AppInterface)localObject;
      if (localObject != null)
      {
        paramAppInterface = (AppInterface)localObject;
        if (((String)localObject).length() > 45)
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append(((String)localObject).substring(0, 45));
          paramAppInterface.append("…");
          paramAppInterface = paramAppInterface.toString();
        }
      }
      localIntent.putExtra("title", paramAppInterface);
      localObject = paramTencentDocData.summary;
      paramAppInterface = (AppInterface)localObject;
      if (localObject != null)
      {
        paramAppInterface = (AppInterface)localObject;
        if (((String)localObject).length() > 60)
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append(((String)localObject).substring(0, 60));
          paramAppInterface.append("…");
          paramAppInterface = paramAppInterface.toString();
        }
      }
      localIntent.putExtra("desc", paramAppInterface);
      localIntent.putExtra("detail_url", paramTencentDocData.docUrl);
      localIntent.putExtra("struct_share_key_content_action", "web");
      localIntent.putExtra("struct_share_key_source_action", "web");
      localIntent.putExtra("struct_share_key_source_icon", "https://docs.qq.com/desktop/favicon.ico");
      localIntent.putExtra("app_name", paramActivity.getString(2131719569));
      localIntent.putExtra("source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2097154");
      localIntent.putExtra("forward _key_nojump", true);
      paramAppInterface = StructMsgFactory.a(localIntent.getExtras());
      if (paramAppInterface != null)
      {
        localIntent.putExtra("stuctmsg_bytes", paramAppInterface.getBytes());
        if (i != 0)
        {
          localIntent.putExtra("uintype", paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
          localIntent.putExtra("uin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
          localIntent.putExtra("troop_uin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
          localIntent.putExtra("uinname", ContactUtils.a(localQQAppInterface, paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, paramTeamWorkFileImportInfo.jdField_a_of_type_Int));
        }
        paramAppInterface = new StringBuilder(HardCodeUtil.a(2131714547));
        if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 3000))
        {
          if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0) {
            paramAppInterface.append("好友");
          }
        }
        else {
          paramAppInterface.append("群成员");
        }
        if (bool) {
          paramAppInterface.append("一起编辑文档：");
        } else {
          paramAppInterface.append("一起查看文档：");
        }
        localIntent.putExtra("key_send_tips", paramAppInterface.toString());
        if (i == 0) {
          TenDocLogReportHelper.a(null, "0X800A5A1");
        } else {
          TenDocLogReportHelper.a(null, "0X800A5A2");
        }
        if (i != 0) {
          paramAppInterface = DirectForwardActivity.class;
        } else {
          paramAppInterface = ForwardRecentActivity.class;
        }
        localIntent.setClass(paramActivity, paramAppInterface);
        paramActivity.startActivityForResult(localIntent, 2864);
      }
    }
  }
  
  public void sendTDoc2Chat(AppInterface paramAppInterface, FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      Intent localIntent = new Intent();
      localIntent.putExtra("type", ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTDocFileType(paramFileManagerEntity.Uuid));
      localIntent.putExtra("miniprogram_image_url", paramFileManagerEntity.strThumbPath);
      localIntent.putExtra("key_flag_from_plugin", false);
      localIntent.putExtra("isFromShare", true);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_type", 95);
      localIntent.putExtra("detail_url", paramFileManagerEntity.Uuid);
      localIntent.putExtra("image_url_remote", paramFileManagerEntity.strThumbPath);
      localIntent.putExtra("req_share_id", 101458937L);
      localIntent.putExtra("source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2");
      localIntent.putExtra("app_name", HardCodeUtil.a(2131714592));
      localIntent.putExtra("struct_share_key_source_icon", "https://docs.qq.com/desktop/favicon.ico");
      localIntent.putExtra("struct_share_key_source_action", "web");
      localIntent.putExtra("pubUin", "");
      localIntent.putExtra("struct_uin", "");
      Object localObject = paramFileManagerEntity.fileName;
      paramAppInterface = (AppInterface)localObject;
      if (localObject != null)
      {
        paramAppInterface = (AppInterface)localObject;
        if (((String)localObject).length() > 45)
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append(((String)localObject).substring(0, 45));
          paramAppInterface.append("…");
          paramAppInterface = paramAppInterface.toString();
        }
      }
      String str = HardCodeUtil.a(2131714615);
      localIntent.putExtra("title", paramAppInterface);
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.length() > 60)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str.substring(0, 60));
          ((StringBuilder)localObject).append("…");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      localIntent.putExtra("desc", (String)localObject);
      localIntent.putExtra("forward_thumb", paramFileManagerEntity.strThumbPath);
      localIntent.putExtra("struct_share_key_content_action", "web");
      localIntent.putExtra("req_share_id", -1L);
      localIntent.putExtra("brief_key", BaseApplicationImpl.sApplication.getString(2131696401, new Object[] { paramAppInterface }));
      localIntent.putExtra("to_uin", paramString);
      localIntent.putExtra("uin_type", paramInt);
      localObject = localIntent.getExtras();
      paramAppInterface = StructMsgFactory.a((Bundle)localObject);
      paramInt = ((Bundle)localObject).getInt("uin_type");
      paramFileManagerEntity = ((Bundle)localObject).getString("to_uin");
      paramString = ((Bundle)localObject).getString("docs_gray_tips_info_json");
      localObject = ((Bundle)localObject).getString("detail_url");
      if (paramAppInterface != null)
      {
        paramAppInterface.mExtraData = "aioPlusPanelTencentDoc";
        ShareMsgHelper.a(localQQAppInterface, paramFileManagerEntity, paramInt, paramAppInterface, null, paramString, (String)localObject);
      }
    }
  }
  
  public void setPreloadToolProcess(AppInterface paramAppInterface, boolean paramBoolean)
  {
    SharedPreUtils.c(paramAppInterface.getApp(), paramAppInterface.getCurrentUin(), "tencent_docs_config_preload_tool_process", paramBoolean);
    paramAppInterface = (ITeamWorkHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
    if (paramAppInterface != null) {
      paramAppInterface.setPreloadToolProcess(paramBoolean);
    }
  }
  
  public void setTencentDocsAssitantEnable(AppInterface paramAppInterface, boolean paramBoolean)
  {
    SharedPreUtils.c(paramAppInterface.getApp(), paramAppInterface.getCurrentUin(), "tencent_docs_config_enable_assistant", paramBoolean);
    paramAppInterface = (ITeamWorkHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
    if (paramAppInterface != null) {
      paramAppInterface.setEnableTencentDocsAssistant(paramBoolean);
    }
  }
  
  public void tryAddTDFileMessageRecord(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    paramAppInterface = TeamWorkUtilsTempImpl.ProcessTDFileScheduler.a(paramAppInterface);
    paramAppInterface.a(paramMessageRecord);
    paramAppInterface.a();
  }
  
  /* Error */
  public void tryProcessTDDocMessageRecord(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +474 -> 475
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: instanceof 158
    //   13: ifeq +156 -> 169
    //   16: aload_1
    //   17: checkcast 158	com/tencent/mobileqq/data/MessageForStructing
    //   20: astore_1
    //   21: aload_1
    //   22: getfield 162	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   25: ifnull +143 -> 168
    //   28: aload_1
    //   29: getfield 162	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   32: getfield 167	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   35: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +4 -> 42
    //   41: return
    //   42: aload_1
    //   43: getfield 162	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   46: getfield 167	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   49: invokestatic 1355	com/tencent/mobileqq/filemanager/data/FMConstants:a	(Ljava/lang/String;)Z
    //   52: ifeq +423 -> 475
    //   55: aload_1
    //   56: getfield 162	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   59: instanceof 296
    //   62: ifeq +62 -> 124
    //   65: aload_1
    //   66: getfield 162	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   69: checkcast 296	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   72: astore 4
    //   74: aload 4
    //   76: getfield 306	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mMsgUrl	Ljava/lang/String;
    //   79: aload_1
    //   80: getfield 225	com/tencent/mobileqq/data/MessageForStructing:selfuin	Ljava/lang/String;
    //   83: invokestatic 1107	com/tencent/mobileqq/teamwork/TeamWorkHandlerUtils:a	(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    //   86: astore 5
    //   88: aload 5
    //   90: ldc_w 1109
    //   93: invokevirtual 817	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   96: ifne +28 -> 124
    //   99: aload 4
    //   101: aload 5
    //   103: ldc_w 1357
    //   106: invokevirtual 1360	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   109: checkcast 90	org/json/JSONObject
    //   112: ldc_w 1191
    //   115: invokevirtual 1360	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   118: checkcast 81	java/lang/String
    //   121: putfield 312	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mContentTitle	Ljava/lang/String;
    //   124: aload_0
    //   125: aload_1
    //   126: aload_2
    //   127: invokespecial 1125	com/tencent/mobileqq/teamwork/api/impl/TeamWorkUtilsTempImpl:tdDocMessageRecordSaveToFMDB	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/common/app/AppInterface;)V
    //   130: return
    //   131: astore 4
    //   133: goto +26 -> 159
    //   136: astore 4
    //   138: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -17 -> 124
    //   144: getstatic 33	com/tencent/mobileqq/teamwork/TeamWorkConstants:i	Ljava/lang/String;
    //   147: iconst_2
    //   148: aload 4
    //   150: invokevirtual 358	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   153: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: goto -32 -> 124
    //   159: aload_0
    //   160: aload_1
    //   161: aload_2
    //   162: invokespecial 1125	com/tencent/mobileqq/teamwork/api/impl/TeamWorkUtilsTempImpl:tdDocMessageRecordSaveToFMDB	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/common/app/AppInterface;)V
    //   165: aload 4
    //   167: athrow
    //   168: return
    //   169: aload_1
    //   170: instanceof 1362
    //   173: ifeq +271 -> 444
    //   176: aload_1
    //   177: checkcast 1362	com/tencent/mobileqq/data/MessageForArkApp
    //   180: astore_1
    //   181: aload_1
    //   182: getfield 1366	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   185: getfield 1371	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   188: astore_2
    //   189: aload_2
    //   190: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifeq +4 -> 197
    //   196: return
    //   197: new 90	org/json/JSONObject
    //   200: dup
    //   201: aload_2
    //   202: invokespecial 93	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   205: astore_2
    //   206: ldc_w 1373
    //   209: aload_1
    //   210: getfield 1366	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   213: getfield 1376	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   216: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: istore_3
    //   220: iload_3
    //   221: ifeq +62 -> 283
    //   224: aload_2
    //   225: ldc_w 1378
    //   228: invokevirtual 99	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   231: ifeq +244 -> 475
    //   234: aload_2
    //   235: ldc_w 1378
    //   238: invokevirtual 1382	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   241: astore_2
    //   242: aload_2
    //   243: ifnull +232 -> 475
    //   246: aload_2
    //   247: ldc_w 1384
    //   250: invokevirtual 1387	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   253: astore_2
    //   254: aload_2
    //   255: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifne +217 -> 475
    //   261: aload_2
    //   262: invokestatic 1355	com/tencent/mobileqq/filemanager/data/FMConstants:a	(Ljava/lang/String;)Z
    //   265: ifeq +210 -> 475
    //   268: aload_0
    //   269: aload_2
    //   270: ldc_w 1389
    //   273: invokevirtual 1393	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   276: iconst_0
    //   277: aaload
    //   278: aload_1
    //   279: invokevirtual 1087	com/tencent/mobileqq/teamwork/api/impl/TeamWorkUtilsTempImpl:processTDDocFileUrl	(Ljava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   282: return
    //   283: ldc_w 1395
    //   286: aload_1
    //   287: getfield 1366	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   290: getfield 1376	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   293: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   296: ifeq +62 -> 358
    //   299: aload_2
    //   300: ldc_w 1397
    //   303: invokevirtual 99	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   306: ifeq +169 -> 475
    //   309: aload_2
    //   310: ldc_w 1397
    //   313: invokevirtual 1382	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   316: astore_2
    //   317: aload_2
    //   318: ifnull +157 -> 475
    //   321: aload_2
    //   322: ldc_w 1384
    //   325: invokevirtual 1387	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   328: astore_2
    //   329: aload_2
    //   330: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   333: ifne +142 -> 475
    //   336: aload_2
    //   337: invokestatic 1355	com/tencent/mobileqq/filemanager/data/FMConstants:a	(Ljava/lang/String;)Z
    //   340: ifeq +135 -> 475
    //   343: aload_0
    //   344: aload_2
    //   345: ldc_w 1389
    //   348: invokevirtual 1393	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   351: iconst_0
    //   352: aaload
    //   353: aload_1
    //   354: invokevirtual 1087	com/tencent/mobileqq/teamwork/api/impl/TeamWorkUtilsTempImpl:processTDDocFileUrl	(Ljava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   357: return
    //   358: ldc_w 1399
    //   361: aload_1
    //   362: getfield 1366	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   365: getfield 1376	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   368: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   371: ifeq +104 -> 475
    //   374: aload_2
    //   375: ldc_w 1401
    //   378: invokevirtual 99	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   381: ifeq +94 -> 475
    //   384: aload_2
    //   385: ldc_w 1401
    //   388: invokevirtual 1404	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   391: astore_2
    //   392: aload_2
    //   393: ifnull +82 -> 475
    //   396: aload_2
    //   397: ldc_w 1406
    //   400: invokevirtual 1387	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   403: astore_2
    //   404: aload_2
    //   405: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifne +67 -> 475
    //   411: aload_2
    //   412: invokestatic 1355	com/tencent/mobileqq/filemanager/data/FMConstants:a	(Ljava/lang/String;)Z
    //   415: ifeq +60 -> 475
    //   418: aload_0
    //   419: aload_2
    //   420: aload_1
    //   421: invokevirtual 1087	com/tencent/mobileqq/teamwork/api/impl/TeamWorkUtilsTempImpl:processTDDocFileUrl	(Ljava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   424: return
    //   425: astore_1
    //   426: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +46 -> 475
    //   432: getstatic 33	com/tencent/mobileqq/teamwork/TeamWorkConstants:i	Ljava/lang/String;
    //   435: iconst_2
    //   436: aload_1
    //   437: invokevirtual 358	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   440: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: return
    //   444: aload_1
    //   445: instanceof 1408
    //   448: ifeq +27 -> 475
    //   451: aload_1
    //   452: checkcast 1408	com/tencent/mobileqq/data/MessageForText
    //   455: astore_1
    //   456: aload_1
    //   457: getfield 1411	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   460: invokestatic 1355	com/tencent/mobileqq/filemanager/data/FMConstants:a	(Ljava/lang/String;)Z
    //   463: ifeq +12 -> 475
    //   466: aload_0
    //   467: aload_1
    //   468: getfield 1411	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   471: aload_1
    //   472: invokevirtual 1087	com/tencent/mobileqq/teamwork/api/impl/TeamWorkUtilsTempImpl:processTDDocFileUrl	(Ljava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   475: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	TeamWorkUtilsTempImpl
    //   0	476	1	paramMessageRecord	MessageRecord
    //   0	476	2	paramAppInterface	AppInterface
    //   219	2	3	bool	boolean
    //   72	28	4	localStructMsgForGeneralShare	StructMsgForGeneralShare
    //   131	1	4	localObject	Object
    //   136	30	4	localJSONException	JSONException
    //   86	16	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   55	124	131	finally
    //   138	156	131	finally
    //   55	124	136	org/json/JSONException
    //   197	220	425	org/json/JSONException
    //   224	242	425	org/json/JSONException
    //   246	282	425	org/json/JSONException
    //   283	317	425	org/json/JSONException
    //   321	357	425	org/json/JSONException
    //   358	392	425	org/json/JSONException
    //   396	424	425	org/json/JSONException
  }
  
  public void tryProcessTDDocMessageRecordAsync(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    ThreadManager.postImmediately(new TeamWorkUtilsTempImpl.3(this, paramMessageRecord, paramAppInterface), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl
 * JD-Core Version:    0.7.0.1
 */