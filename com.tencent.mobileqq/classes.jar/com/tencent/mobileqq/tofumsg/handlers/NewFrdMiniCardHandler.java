package com.tencent.mobileqq.tofumsg.handlers;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.base.config.ProfileConfig;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.tofumsg.TofuDataBaseHandler;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.BasicProfileData;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.LabelInfo;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.QZoneInfo;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.Quest;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.ReqBody;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.RspBody;
import tencent.im.oidb.cmd0xe9b.oidb_0xe9b.SelectedPicInfo;

public class NewFrdMiniCardHandler
  extends TofuDataBaseHandler
{
  public NewFrdMiniCardHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(oidb_0xe9b.RspBody paramRspBody)
  {
    StringBuilder localStringBuilder = new StringBuilder("parsePbToStr fields:");
    JSONObject localJSONObject = new JSONObject();
    localStringBuilder.append("hasBaseProfile=");
    boolean bool1 = a(localJSONObject, paramRspBody);
    localStringBuilder.append(bool1);
    localStringBuilder.append(",");
    localStringBuilder.append("hasPL=");
    boolean bool2 = b(localJSONObject, paramRspBody);
    localStringBuilder.append(bool2);
    localStringBuilder.append(",");
    localStringBuilder.append("hasQzone=");
    boolean bool3 = c(localJSONObject, paramRspBody);
    localStringBuilder.append(bool3);
    localStringBuilder.append(",");
    localStringBuilder.append("hasNicePics=");
    boolean bool4 = d(localJSONObject, paramRspBody);
    localStringBuilder.append(bool4);
    localStringBuilder.append(",");
    localStringBuilder.append("hasSign=");
    boolean bool5 = e(localJSONObject, paramRspBody);
    localStringBuilder.append(bool5);
    localStringBuilder.append(",");
    localStringBuilder.append("hasAskAnonymously=");
    boolean bool6 = f(localJSONObject, paramRspBody);
    localStringBuilder.append(bool6);
    QLog.i("Tofu_NewFrdMiniCardHandler", 1, localStringBuilder.toString());
    if ((!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5) && (!bool6)) {
      return null;
    }
    return localJSONObject.toString();
  }
  
  private void a(Exception paramException, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(",");
      localStringBuilder.append(paramException.getMessage());
      QLog.d("Tofu_NewFrdMiniCardHandler", 2, localStringBuilder.toString(), paramException);
    }
  }
  
  private boolean a(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    if (paramRspBody.msg_basic_profile.has())
    {
      paramRspBody = (oidb_0xe9b.BasicProfileData)paramRspBody.msg_basic_profile.get();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (paramRspBody.uint32_age.has()) {
          localJSONObject.put("age", paramRspBody.uint32_age.get());
        }
        if (paramRspBody.uint32_gender.has()) {
          localJSONObject.put("gender", paramRspBody.uint32_gender.get());
        }
        if (paramRspBody.bytes_place.has()) {
          localJSONObject.put("place", paramRspBody.bytes_place.get().toStringUtf8());
        }
        if (paramRspBody.bytes_addfrd_src.has()) {
          localJSONObject.put("addfrd_src", paramRspBody.bytes_addfrd_src.get().toStringUtf8());
        }
        if (paramRspBody.uint32_comm_frd_num.has()) {
          localJSONObject.put("commfrd_num", paramRspBody.uint32_comm_frd_num.get());
        }
        paramJSONObject.put("field_baseprofile", localJSONObject);
        if (QLog.isColorLevel())
        {
          QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldBaseProfile %s", new Object[] { localJSONObject }));
          return true;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject, "fillWithFieldBaseProfile");
      }
      return true;
    }
    return false;
  }
  
  private boolean b(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    JSONArray localJSONArray;
    int i;
    if ((paramRspBody.rpt_msg_label.has()) && (paramRspBody.rpt_msg_label.size() > 0))
    {
      paramRspBody = paramRspBody.rpt_msg_label.get();
      localJSONArray = new JSONArray();
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < paramRspBody.size())
        {
          oidb_0xe9b.LabelInfo localLabelInfo = (oidb_0xe9b.LabelInfo)paramRspBody.get(i);
          if ((localLabelInfo == null) || (!localLabelInfo.bytes_name.has())) {
            break label147;
          }
          localJSONArray.put(i, localLabelInfo.bytes_name.get().toStringUtf8());
          break label147;
        }
        paramJSONObject.put("field_personal_labels", localJSONArray);
        if (QLog.isColorLevel())
        {
          QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldPersonalityLabel %s", new Object[] { localJSONArray }));
          return true;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject, "fillWithFieldPersonalityLabel");
      }
      return true;
      return false;
      label147:
      i += 1;
    }
  }
  
  private boolean c(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    if (paramRspBody.msg_qzone_info.has())
    {
      paramRspBody = (oidb_0xe9b.QZoneInfo)paramRspBody.msg_qzone_info.get();
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      try
      {
        if (paramRspBody.bytes_space_name.has()) {
          localJSONObject.put("space_name", paramRspBody.bytes_space_name.get().toStringUtf8());
        }
        if (paramRspBody.bytes_update_content.has()) {
          localJSONObject.put("update_content", paramRspBody.bytes_update_content.get().toStringUtf8());
        }
        if ((paramRspBody.str_newly_img_url.has()) && (paramRspBody.str_newly_img_url.size() > 0))
        {
          int i = 0;
          while (i < paramRspBody.str_newly_img_url.get().size())
          {
            localJSONArray.put(i, ((String)paramRspBody.str_newly_img_url.get(i)).toString());
            i += 1;
          }
        }
        localJSONObject.put("img_urls", localJSONArray);
        paramJSONObject.put("field_qzone", localJSONObject);
        if (QLog.isColorLevel())
        {
          QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldQzone %s", new Object[] { localJSONObject }));
          return true;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject, "fillWithFieldQzone");
      }
      return true;
    }
    return false;
  }
  
  private boolean d(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    if ((paramRspBody.rpt_msg_selected_pic.has()) && (paramRspBody.rpt_msg_selected_pic.size() > 0))
    {
      paramRspBody = paramRspBody.rpt_msg_selected_pic.get();
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      try
      {
        while (i < paramRspBody.size())
        {
          oidb_0xe9b.SelectedPicInfo localSelectedPicInfo = (oidb_0xe9b.SelectedPicInfo)paramRspBody.get(i);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("ori", localSelectedPicInfo.str_ori_pic_url.get());
          localJSONObject.put("medium", localSelectedPicInfo.str_medium_pic_url.get());
          localJSONArray.put(i, localJSONObject);
          i += 1;
        }
        paramJSONObject.put("field_nicepics", localJSONArray);
        if (QLog.isColorLevel())
        {
          QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldNicePics %s", new Object[] { localJSONArray }));
          return true;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject, "fillWithFieldNicePics");
      }
      return true;
    }
    return false;
  }
  
  private boolean e(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    if ((paramRspBody.rpt_bytes_longnick.has()) && (paramRspBody.rpt_bytes_longnick.size() > 0)) {
      try
      {
        paramRspBody = ((ByteStringMicro)paramRspBody.rpt_bytes_longnick.get().get(0)).toByteArray();
        Object localObject = RichStatus.parseStatus(paramRspBody);
        int i = ((RichStatus)localObject).actionId;
        String str = ((RichStatus)localObject).getActionAndData();
        localObject = ((RichStatus)localObject).getPlainText();
        if ((i == 0) && (TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject))) {
          return false;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("actionId", i);
        localJSONObject.put("actionAndData", str);
        localJSONObject.put("plainText", localObject);
        if (QLog.isColorLevel())
        {
          if (paramRspBody == null) {
            i = -1;
          } else {
            i = paramRspBody.length;
          }
          QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldSign %s [bytes=%d]", new Object[] { localJSONObject, Integer.valueOf(i) }));
        }
        paramJSONObject.put("sign", localJSONObject);
        return true;
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject, "fillWithFieldSign");
        return true;
      }
    }
    return false;
  }
  
  private boolean f(JSONObject paramJSONObject, oidb_0xe9b.RspBody paramRspBody)
  {
    if (!new ProfileConfig(this.a, null).isSwitchEnable(13)) {
      return false;
    }
    if ((paramRspBody.rpt_msg_quests.has()) && (paramRspBody.rpt_msg_quests.size() > 0))
    {
      try
      {
        paramRspBody = (oidb_0xe9b.Quest)paramRspBody.rpt_msg_quests.get().get(0);
        JSONObject localJSONObject = new JSONObject();
        if (paramRspBody.str_id.has()) {
          localJSONObject.put("key_question_id", paramRspBody.str_id.get());
        }
        if (paramRspBody.str_quest.has()) {
          localJSONObject.put("key_question_str", paramRspBody.str_quest.get());
        }
        if (paramRspBody.uint64_quest_uin.has()) {
          localJSONObject.put("key_question_uin", paramRspBody.uint64_quest_uin.get());
        }
        if (paramRspBody.uint64_time.has()) {
          localJSONObject.put("key_question_time", paramRspBody.uint64_time.get());
        }
        if (paramRspBody.str_ans.has()) {
          localJSONObject.put("key_answer_str", paramRspBody.str_ans.get());
        }
        paramJSONObject.put("key_ask_anonymously", localJSONObject);
        if (QLog.isColorLevel())
        {
          QLog.i("Tofu_NewFrdMiniCardHandler", 2, String.format("fillWithFieldAskAnonymously %s", new Object[] { localJSONObject }));
          return true;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject, "fillWithFieldAskAnonymously");
      }
      return true;
    }
    return false;
  }
  
  public int a()
  {
    return 11;
  }
  
  public String a(TofuItem paramTofuItem)
  {
    if ((paramTofuItem.bytesFromServer != null) && (paramTofuItem.bytesFromServer.length > 0))
    {
      Object localObject = new oidb_0xe9b.RspBody();
      try
      {
        ((oidb_0xe9b.RspBody)localObject).mergeFrom(paramTofuItem.bytesFromServer);
        paramTofuItem = a((oidb_0xe9b.RspBody)localObject);
        return paramTofuItem;
      }
      catch (InvalidProtocolBufferMicroException paramTofuItem)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getBusDataFromRspBytes exception=");
        ((StringBuilder)localObject).append(paramTofuItem.getMessage());
        QLog.d("Tofu_NewFrdMiniCardHandler", 1, ((StringBuilder)localObject).toString(), paramTofuItem);
        return null;
      }
    }
    int i;
    if (paramTofuItem.bytesFromServer == null) {
      i = -1;
    } else {
      i = paramTofuItem.bytesFromServer.length;
    }
    QLog.d("Tofu_NewFrdMiniCardHandler", 1, new Object[] { "getBusDataFromRsp bytesFromServer size=", Integer.valueOf(i) });
    return null;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool3 = b();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean a(BeancurdMsg paramBeancurdMsg)
  {
    return true;
  }
  
  public byte[] a(TofuItem paramTofuItem)
  {
    oidb_0xe9b.ReqBody localReqBody = new oidb_0xe9b.ReqBody();
    localReqBody.uint64_fuin.set(paramTofuItem.frdUin);
    return localReqBody.toByteArray();
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.handlers.NewFrdMiniCardHandler
 * JD-Core Version:    0.7.0.1
 */