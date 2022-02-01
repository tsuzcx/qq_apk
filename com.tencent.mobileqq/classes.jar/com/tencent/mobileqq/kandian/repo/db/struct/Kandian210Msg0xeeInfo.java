package com.tencent.mobileqq.kandian.repo.db.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.AccountInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.ContextInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.ControlInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.ExtraInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.NotifyInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.OrangeControlInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.OrdinaryPushInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.PictureInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.SocialPushInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.StatisticsInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.StyleSheet;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.UGCPushInfo;

public class Kandian210Msg0xeeInfo
  implements Serializable
{
  public static final int APP_IN_PUSH_FOR_KANDIAN_ARTICLE = 2000002;
  public static final int APP_IN_PUSH_FOR_KANDIAN_ARTICLE_2 = 1000001;
  public static final int APP_IN_PUSH_FOR_KANDIAN_VIDEO = 2000001;
  public static final int BUBBLE_TYPE = 1;
  public static final int DEFAULT_ARK_ENABLE = 0;
  public static final int DEFAULT_TYPE = 0;
  public static final int DIALOG_TYPE = 2;
  public static final String KANDIAN_0X210_EE = "kandian_push_0x210_ee";
  public static final String TAG = "Kandian210Msg0xeeInfo";
  public int bid;
  public String msgId;
  public long msgSeq;
  public ArrayList<Kandian210Msg0xeeInfo.NotifyInfo> notifyInfos;
  
  private static void a(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if ((paramNotifyInfo.msg_style_sheet.has()) && (paramNotifyInfo.msg_style_sheet.get() != null))
    {
      paramNotifyInfo = (submsgtype0xee.StyleSheet)paramNotifyInfo.msg_style_sheet.get();
      boolean bool = paramNotifyInfo.enum_style_type.has();
      int j = 0;
      if (bool) {
        i = paramNotifyInfo.enum_style_type.get();
      } else {
        i = 0;
      }
      paramNotifyInfo1.styleType = i;
      int i = j;
      if (paramNotifyInfo.uint32_ark_enable.has()) {
        i = paramNotifyInfo.uint32_ark_enable.get();
      }
      paramNotifyInfo1.arkEnable = i;
      paramNotifyInfo1.sceneType = paramNotifyInfo.uint64_scene.get();
      paramNotifyInfo1.duration = paramNotifyInfo.uint32_duration.get();
      paramNotifyInfo1.endTime = paramNotifyInfo.uint64_end_time.get();
    }
  }
  
  private static void b(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if ((paramNotifyInfo.msg_ordinary_push_info.has()) && (paramNotifyInfo.msg_ordinary_push_info.get() != null))
    {
      paramNotifyInfo1.ordinaryPushInfo = new Kandian210Msg0xeeInfo.OrdinaryPushInfo();
      paramNotifyInfo = (submsgtype0xee.OrdinaryPushInfo)paramNotifyInfo.msg_ordinary_push_info.get();
      if ((paramNotifyInfo.msg_label_control_info.has()) && (paramNotifyInfo.msg_label_control_info.get() != null))
      {
        paramNotifyInfo1.ordinaryPushInfo.orangeControlInfo = new Kandian210Msg0xeeInfo.OrangeControlInfo();
        submsgtype0xee.OrangeControlInfo localOrangeControlInfo = (submsgtype0xee.OrangeControlInfo)paramNotifyInfo.msg_label_control_info.get();
        paramNotifyInfo1 = paramNotifyInfo1.ordinaryPushInfo.orangeControlInfo;
        if (localOrangeControlInfo.bytes_color.has()) {
          paramNotifyInfo = localOrangeControlInfo.bytes_color.get().toStringUtf8();
        } else {
          paramNotifyInfo = null;
        }
        paramNotifyInfo1.color = paramNotifyInfo;
        paramNotifyInfo1.fontSize = localOrangeControlInfo.uint32_font_size.get();
      }
    }
  }
  
  private static void c(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if ((paramNotifyInfo.msg_social_push_info.has()) && (paramNotifyInfo.msg_social_push_info.get() != null))
    {
      paramNotifyInfo1.socialPushInfo = new Kandian210Msg0xeeInfo.SocialPushInfo();
      submsgtype0xee.SocialPushInfo localSocialPushInfo = (submsgtype0xee.SocialPushInfo)paramNotifyInfo.msg_social_push_info.get();
      paramNotifyInfo1.socialPushInfo.feedsId = localSocialPushInfo.uint64_feeds_id.get();
      Kandian210Msg0xeeInfo.SocialPushInfo localSocialPushInfo1 = paramNotifyInfo1.socialPushInfo;
      boolean bool = localSocialPushInfo.string_biu_reason.has();
      Object localObject = null;
      if (bool) {
        paramNotifyInfo = localSocialPushInfo.string_biu_reason.get().toStringUtf8();
      } else {
        paramNotifyInfo = null;
      }
      localSocialPushInfo1.biuReason = paramNotifyInfo;
      paramNotifyInfo1 = paramNotifyInfo1.socialPushInfo;
      paramNotifyInfo = localObject;
      if (localSocialPushInfo.string_biu_comment.has()) {
        paramNotifyInfo = localSocialPushInfo.string_biu_comment.get().toStringUtf8();
      }
      paramNotifyInfo1.biuComment = paramNotifyInfo;
    }
  }
  
  private static void d(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if ((paramNotifyInfo.msg_ugc_push_info.has()) && (paramNotifyInfo.msg_ugc_push_info.get() != null))
    {
      paramNotifyInfo1.ugcPushInfo = new Kandian210Msg0xeeInfo.UGCPushInfo();
      paramNotifyInfo = (submsgtype0xee.UGCPushInfo)paramNotifyInfo.msg_ugc_push_info.get();
      paramNotifyInfo1.ugcPushInfo.feedsId = paramNotifyInfo.uint64_feeds_id.get();
      paramNotifyInfo1 = paramNotifyInfo1.ugcPushInfo;
      if (paramNotifyInfo.string_ugc_reason.has()) {
        paramNotifyInfo = paramNotifyInfo.string_ugc_reason.get().toStringUtf8();
      } else {
        paramNotifyInfo = null;
      }
      paramNotifyInfo1.ugcReason = paramNotifyInfo;
    }
  }
  
  public static Kandian210Msg0xeeInfo decodeFromPbBytes(byte[] paramArrayOfByte)
  {
    Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = new Kandian210Msg0xeeInfo();
    for (;;)
    {
      try
      {
        Object localObject = new submsgtype0xee.MsgBody();
        ((submsgtype0xee.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        localKandian210Msg0xeeInfo.bid = ((submsgtype0xee.MsgBody)localObject).uint32_bid.get();
        localKandian210Msg0xeeInfo.msgSeq = ((submsgtype0xee.MsgBody)localObject).uint64_seq.get();
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("receive push 0xee, bid = ");
          paramArrayOfByte.append(localKandian210Msg0xeeInfo.bid);
          paramArrayOfByte.append(" msgSeq=");
          paramArrayOfByte.append(localKandian210Msg0xeeInfo.msgSeq);
          QLog.d("Kandian210Msg0xeeInfo", 2, paramArrayOfByte.toString());
        }
        if ((((submsgtype0xee.MsgBody)localObject).bytes_id.has()) && (((submsgtype0xee.MsgBody)localObject).bytes_id.get() != null)) {
          localKandian210Msg0xeeInfo.msgId = ((submsgtype0xee.MsgBody)localObject).bytes_id.get().toStringUtf8();
        }
        if (((submsgtype0xee.MsgBody)localObject).rpt_msg_notify_list.has())
        {
          if (((submsgtype0xee.MsgBody)localObject).rpt_msg_notify_list.get() == null) {
            return null;
          }
          if (localKandian210Msg0xeeInfo.notifyInfos == null) {
            localKandian210Msg0xeeInfo.notifyInfos = new ArrayList();
          }
          paramArrayOfByte = ((submsgtype0xee.MsgBody)localObject).rpt_msg_notify_list.get().iterator();
          if (paramArrayOfByte.hasNext())
          {
            localObject = (submsgtype0xee.NotifyInfo)paramArrayOfByte.next();
            Kandian210Msg0xeeInfo.NotifyInfo localNotifyInfo = new Kandian210Msg0xeeInfo.NotifyInfo();
            a((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
            if (((submsgtype0xee.NotifyInfo)localObject).enum_apppush_type.has())
            {
              i = ((submsgtype0xee.NotifyInfo)localObject).enum_apppush_type.get();
              localNotifyInfo.appPushType = i;
              b((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
              c((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
              d((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
              e((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
              f((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
              g((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
              h((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
              i((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
              localKandian210Msg0xeeInfo.notifyInfos.add(localNotifyInfo);
            }
          }
          else
          {
            return localKandian210Msg0xeeInfo;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.w("Kandian210Msg0xeeInfo", 1, "receive push 0xee, parse msgBody err,", paramArrayOfByte);
        return null;
      }
      int i = -1;
    }
  }
  
  private static void e(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if ((paramNotifyInfo.msg_context_info.has()) && (paramNotifyInfo.msg_context_info.get() != null))
    {
      submsgtype0xee.ContextInfo localContextInfo = (submsgtype0xee.ContextInfo)paramNotifyInfo.msg_context_info.get();
      paramNotifyInfo1.contextId = localContextInfo.uint64_id.get();
      boolean bool = localContextInfo.bytes_brief.has();
      Object localObject = null;
      if (bool) {
        paramNotifyInfo = localContextInfo.bytes_brief.get().toStringUtf8();
      } else {
        paramNotifyInfo = null;
      }
      paramNotifyInfo1.contextBrief = paramNotifyInfo;
      if (localContextInfo.bytes_jump_url.has()) {
        paramNotifyInfo = localContextInfo.bytes_jump_url.get().toStringUtf8();
      } else {
        paramNotifyInfo = null;
      }
      paramNotifyInfo1.pictureJumpURL = paramNotifyInfo;
      if (localContextInfo.bytes_orange_word.has()) {
        paramNotifyInfo = localContextInfo.bytes_orange_word.get().toStringUtf8();
      } else {
        paramNotifyInfo = null;
      }
      paramNotifyInfo1.orangeWord = paramNotifyInfo;
      if (localContextInfo.bytes_title.has()) {
        paramNotifyInfo = localContextInfo.bytes_title.get().toStringUtf8();
      } else {
        paramNotifyInfo = null;
      }
      paramNotifyInfo1.contextTitle = paramNotifyInfo;
      if (paramNotifyInfo1.picturesURLList == null) {
        paramNotifyInfo1.picturesURLList = new ArrayList();
      }
      if ((localContextInfo.rpt_msg_pic_list.has()) && (localContextInfo.rpt_msg_pic_list.get() != null))
      {
        paramNotifyInfo = localContextInfo.rpt_msg_pic_list.get().iterator();
        while (paramNotifyInfo.hasNext())
        {
          submsgtype0xee.PictureInfo localPictureInfo = (submsgtype0xee.PictureInfo)paramNotifyInfo.next();
          if ((localPictureInfo.has()) && (localPictureInfo.get() != null) && (((submsgtype0xee.PictureInfo)localPictureInfo.get()).bytes_url.has()) && (((submsgtype0xee.PictureInfo)localPictureInfo.get()).bytes_url.get() != null)) {
            paramNotifyInfo1.picturesURLList.add(((submsgtype0xee.PictureInfo)localPictureInfo.get()).bytes_url.get().toStringUtf8());
          }
        }
      }
      int i;
      if (localContextInfo.enum_context_type.has()) {
        i = localContextInfo.enum_context_type.get();
      } else {
        i = 0;
      }
      paramNotifyInfo1.contextType = i;
      paramNotifyInfo = localObject;
      if (localContextInfo.bytes_video_brief.has()) {
        paramNotifyInfo = localContextInfo.bytes_video_brief.get().toStringUtf8();
      }
      paramNotifyInfo1.videoBrief = paramNotifyInfo;
    }
  }
  
  private static void f(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if ((paramNotifyInfo.msg_account_info.has()) && (paramNotifyInfo.msg_account_info.get() != null))
    {
      submsgtype0xee.AccountInfo localAccountInfo = (submsgtype0xee.AccountInfo)paramNotifyInfo.msg_account_info.get();
      paramNotifyInfo1.uin = localAccountInfo.uint64_id.get();
      boolean bool = localAccountInfo.bytes_name.has();
      Object localObject = null;
      if (bool) {
        paramNotifyInfo = localAccountInfo.bytes_name.get().toStringUtf8();
      } else {
        paramNotifyInfo = null;
      }
      paramNotifyInfo1.username = paramNotifyInfo;
      paramNotifyInfo = localObject;
      if (localAccountInfo.bytes_icon_url.has()) {
        paramNotifyInfo = localAccountInfo.bytes_icon_url.get().toStringUtf8();
      }
      paramNotifyInfo1.userIconURL = paramNotifyInfo;
    }
  }
  
  private static void g(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if ((paramNotifyInfo.msg_extra_info.has()) && (paramNotifyInfo.msg_extra_info.get() != null))
    {
      submsgtype0xee.ExtraInfo localExtraInfo = (submsgtype0xee.ExtraInfo)paramNotifyInfo.msg_extra_info.get();
      boolean bool = localExtraInfo.bytes_ext.has();
      Object localObject = null;
      if (bool) {
        paramNotifyInfo = localExtraInfo.bytes_ext.get().toStringUtf8();
      } else {
        paramNotifyInfo = null;
      }
      paramNotifyInfo1.extInfo = paramNotifyInfo;
      paramNotifyInfo = localObject;
      if (localExtraInfo.bytes_cookie.has()) {
        paramNotifyInfo = localExtraInfo.bytes_cookie.get().toStringUtf8();
      }
      paramNotifyInfo1.extCookie = paramNotifyInfo;
      if (!TextUtils.isEmpty(paramNotifyInfo1.extCookie)) {
        try
        {
          paramNotifyInfo1.folderStatus = Long.valueOf(new JSONObject(paramNotifyInfo1.extCookie).getString("folder_status")).longValue();
          return;
        }
        catch (Exception paramNotifyInfo)
        {
          paramNotifyInfo1 = new StringBuilder();
          paramNotifyInfo1.append("handleExtraInfo error!  msg=");
          paramNotifyInfo1.append(paramNotifyInfo);
          QLog.d("Kandian210Msg0xeeInfo", 1, paramNotifyInfo1.toString());
        }
      }
    }
  }
  
  public static Kandian210Msg0xeeInfo getKandian210Msg0xeeInfoFromSp(QQAppInterface paramQQAppInterface)
  {
    return (Kandian210Msg0xeeInfo)RIJSPUtils.a(paramQQAppInterface, "kandian_push_0x210_ee", true);
  }
  
  private static void h(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if (paramNotifyInfo.msg_statistics_info.has())
    {
      paramNotifyInfo = (submsgtype0xee.StatisticsInfo)paramNotifyInfo.msg_statistics_info.get();
      paramNotifyInfo1.strategyID = paramNotifyInfo.uint64_strategy_id.get();
      paramNotifyInfo1.algorithmID = paramNotifyInfo.uint64_algorithm_id.get();
      paramNotifyInfo1.folderStatus = paramNotifyInfo.uint64_folder_status.get();
    }
  }
  
  private static void i(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if ((paramNotifyInfo.msg_control_info.has()) && (paramNotifyInfo.msg_control_info.get() != null))
    {
      paramNotifyInfo = (submsgtype0xee.ControlInfo)paramNotifyInfo.msg_control_info.get();
      paramNotifyInfo1.commentLength = paramNotifyInfo.uint32_comment_length.get();
      paramNotifyInfo1.showLine = paramNotifyInfo.uint32_show_line.get();
      paramNotifyInfo1.fontSize = paramNotifyInfo.uint32_font_size.get();
    }
  }
  
  public static void removeKandian210Msg0xeeInfoFromSp()
  {
    RIJSPUtils.a("kandian_push_0x210_ee", true);
  }
  
  public static void writeToSpAsync(Kandian210Msg0xeeInfo paramKandian210Msg0xeeInfo)
  {
    RIJSPUtils.a("kandian_push_0x210_ee", paramKandian210Msg0xeeInfo, true);
  }
  
  public boolean isArticleAppInPush()
  {
    int i = this.bid;
    return (i == 2000002) || (i == 1000001);
  }
  
  public boolean isVideoAppInPush()
  {
    return this.bid == 2000001;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Kandian210Msg0xeeInfo{msgId='");
    localStringBuilder.append(this.msgId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msgSeq=");
    localStringBuilder.append(this.msgSeq);
    localStringBuilder.append(", bid=");
    localStringBuilder.append(this.bid);
    localStringBuilder.append(", notifyInfos=");
    localStringBuilder.append(this.notifyInfos);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo
 * JD-Core Version:    0.7.0.1
 */