package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.QQWalletAioElem;
import tencent.im.qqwallet.qqwalletaio_resv.Payer;
import tencent.im.qqwallet.qqwalletaio_resv.qqwalletaio_elem_resv;

public class QQWalletTransferMsgElem
{
  public String actionsPriority;
  @Deprecated
  public String aioImageLeft;
  @Deprecated
  public String aioImageRight;
  public int background;
  public String blackStripe;
  @Deprecated
  public String cftImage;
  public String content;
  public int contentBgColor;
  public int contentColor;
  public int effectsId;
  public int hbFrom;
  public int icon;
  public String iconUrl;
  public String jumpUrl;
  public String lastPinyin = "";
  public String linkUrl;
  public String nativeAndroid;
  public String notice;
  public List<QQWalletTransferMsgElem.AAPayer> payerList;
  public int resourceType;
  public int skinId;
  public int songFlag;
  public int songId;
  public int soundRecordDuration;
  public int special_pop_id;
  public String subTitle;
  public int subtitleColor;
  public int themeId;
  public String title;
  public int titleColor;
  
  public QQWalletTransferMsgElem() {}
  
  public QQWalletTransferMsgElem(im_msg_body.QQWalletAioElem paramQQWalletAioElem)
  {
    if (paramQQWalletAioElem == null) {}
    for (;;)
    {
      return;
      this.background = paramQQWalletAioElem.uint32_background.get();
      this.icon = paramQQWalletAioElem.uint32_icon.get();
      this.title = paramQQWalletAioElem.bytes_title.get().toStringUtf8();
      this.subTitle = paramQQWalletAioElem.bytes_subtitle.get().toStringUtf8();
      this.content = paramQQWalletAioElem.bytes_content.get().toStringUtf8();
      this.linkUrl = paramQQWalletAioElem.bytes_linkurl.get().toStringUtf8();
      this.blackStripe = paramQQWalletAioElem.bytes_blackstripe.get().toStringUtf8();
      this.notice = paramQQWalletAioElem.bytes_notice.get().toStringUtf8();
      if (this.linkUrl == null) {
        this.linkUrl = "";
      }
      if (this.blackStripe == null) {
        this.blackStripe = "";
      }
      if (this.notice == null) {
        this.notice = "";
      }
      this.background |= 0xFF000000;
      if (paramQQWalletAioElem.uint32_title_color.has())
      {
        this.titleColor = paramQQWalletAioElem.uint32_title_color.get();
        this.titleColor |= 0xFF000000;
        if (!paramQQWalletAioElem.uint32_subtitle_color.has()) {
          break label754;
        }
        this.subtitleColor = paramQQWalletAioElem.uint32_subtitle_color.get();
        this.subtitleColor |= 0xFF000000;
        label235:
        if (!paramQQWalletAioElem.bytes_actions_priority.has()) {
          break label762;
        }
        this.actionsPriority = paramQQWalletAioElem.bytes_actions_priority.get().toStringUtf8();
        label259:
        if (!paramQQWalletAioElem.bytes_jump_url.has()) {
          break label771;
        }
        this.jumpUrl = paramQQWalletAioElem.bytes_jump_url.get().toStringUtf8();
        label283:
        if (!paramQQWalletAioElem.bytes_native_android.has()) {
          break label780;
        }
        this.nativeAndroid = paramQQWalletAioElem.bytes_native_android.get().toStringUtf8();
        label307:
        if (!paramQQWalletAioElem.bytes_iconurl.has()) {
          break label789;
        }
        this.iconUrl = paramQQWalletAioElem.bytes_iconurl.get().toStringUtf8();
        label331:
        if (!paramQQWalletAioElem.uint32_content_color.has()) {
          break label798;
        }
        this.contentColor = paramQQWalletAioElem.uint32_content_color.get();
        this.contentColor |= 0xFF000000;
        label363:
        if (!paramQQWalletAioElem.uint32_content_bgcolor.has()) {
          break label806;
        }
        this.contentBgColor = paramQQWalletAioElem.uint32_content_bgcolor.get();
        this.contentBgColor |= 0xFF000000;
        label395:
        if (!paramQQWalletAioElem.bytes_aio_image_left.has()) {
          break label814;
        }
        this.aioImageLeft = paramQQWalletAioElem.bytes_aio_image_left.get().toStringUtf8();
        label419:
        if (!paramQQWalletAioElem.bytes_aio_image_right.has()) {
          break label823;
        }
        this.aioImageRight = paramQQWalletAioElem.bytes_aio_image_right.get().toStringUtf8();
        label443:
        if (!paramQQWalletAioElem.bytes_cft_image.has()) {
          break label832;
        }
        this.cftImage = paramQQWalletAioElem.bytes_cft_image.get().toStringUtf8();
        label467:
        this.soundRecordDuration = 12000;
        if (!paramQQWalletAioElem.bytes_pb_reserve.has()) {
          continue;
        }
      }
      try
      {
        qqwalletaio_resv.qqwalletaio_elem_resv localqqwalletaio_elem_resv = new qqwalletaio_resv.qqwalletaio_elem_resv();
        localqqwalletaio_elem_resv.mergeFrom(paramQQWalletAioElem.bytes_pb_reserve.get().toByteArray());
        if (localqqwalletaio_elem_resv.sound_record_duration.has()) {
          this.soundRecordDuration = localqqwalletaio_elem_resv.sound_record_duration.get();
        }
        if (localqqwalletaio_elem_resv.uint32_resource_type.has()) {
          this.resourceType = localqqwalletaio_elem_resv.uint32_resource_type.get();
        }
        if (localqqwalletaio_elem_resv.uint32_skin_id.has()) {
          this.skinId = localqqwalletaio_elem_resv.uint32_skin_id.get();
        }
        if (localqqwalletaio_elem_resv.uint32_effects_id.has()) {
          this.effectsId = localqqwalletaio_elem_resv.uint32_effects_id.get();
        }
        if (localqqwalletaio_elem_resv.int32_special_pop_id.has()) {
          this.special_pop_id = localqqwalletaio_elem_resv.int32_special_pop_id.get();
        }
        if (localqqwalletaio_elem_resv.rpt_payer.has())
        {
          paramQQWalletAioElem = localqqwalletaio_elem_resv.rpt_payer.get();
          this.payerList = new ArrayList();
          int i = 0;
          for (;;)
          {
            if (i < paramQQWalletAioElem.size())
            {
              qqwalletaio_resv.Payer localPayer = (qqwalletaio_resv.Payer)paramQQWalletAioElem.get(i);
              if (localPayer != null)
              {
                QQWalletTransferMsgElem.AAPayer localAAPayer = new QQWalletTransferMsgElem.AAPayer();
                if (localPayer.uint64_uin.has()) {
                  localAAPayer.uin = localPayer.uint64_uin.get();
                }
                if (localPayer.uint32_amount.has()) {
                  localAAPayer.amount = localPayer.uint32_amount.get();
                }
                this.payerList.add(localAAPayer);
              }
              i += 1;
              continue;
              this.titleColor = -1;
              break;
              label754:
              this.subtitleColor = -1;
              break label235;
              label762:
              this.actionsPriority = "";
              break label259;
              label771:
              this.jumpUrl = "";
              break label283;
              label780:
              this.nativeAndroid = "";
              break label307;
              label789:
              this.iconUrl = "";
              break label331;
              label798:
              this.contentColor = -1;
              break label363;
              label806:
              this.contentBgColor = -1;
              break label395;
              label814:
              this.aioImageLeft = "";
              break label419;
              label823:
              this.aioImageRight = "";
              break label443;
              label832:
              this.cftImage = "";
              break label467;
            }
          }
        }
        if (localqqwalletaio_elem_resv.uint32_subjectid.has()) {
          this.themeId = localqqwalletaio_elem_resv.uint32_subjectid.get();
        }
        if (localqqwalletaio_elem_resv.uint32_hb_from.has()) {
          this.hbFrom = localqqwalletaio_elem_resv.uint32_hb_from.get();
        }
        if (localqqwalletaio_elem_resv.uint32_song_id.has()) {
          this.songId = localqqwalletaio_elem_resv.uint32_song_id.get();
        }
        if (localqqwalletaio_elem_resv.uint32_song_flag.has()) {
          this.songFlag = localqqwalletaio_elem_resv.uint32_song_flag.get();
        }
        if (localqqwalletaio_elem_resv.bytes_idiom_alpha.has())
        {
          this.lastPinyin = localqqwalletaio_elem_resv.bytes_idiom_alpha.get().toStringUtf8();
          return;
        }
      }
      catch (Throwable paramQQWalletAioElem)
      {
        paramQQWalletAioElem.printStackTrace();
      }
    }
  }
  
  public String generateJsonParams()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      if ((this.payerList == null) || (this.payerList.size() <= 0)) {
        break label126;
      }
      localJSONArray = new JSONArray();
      i = 0;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        int i;
        QQWalletTransferMsgElem.AAPayer localAAPayer;
        JSONObject localJSONObject2;
        label126:
        if (QLog.isDevelopLevel())
        {
          localJSONException.printStackTrace();
          continue;
          i += 1;
        }
      }
    }
    if (i < this.payerList.size())
    {
      localAAPayer = (QQWalletTransferMsgElem.AAPayer)this.payerList.get(i);
      if (localAAPayer != null)
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("uin", localAAPayer.uin);
        localJSONObject2.put("amount", localAAPayer.amount);
        localJSONArray.put(localJSONObject2);
      }
    }
    else
    {
      localJSONObject1.put("payers", localJSONArray);
      return localJSONObject1.toString();
    }
  }
  
  public boolean isInAAPayer(long paramLong)
  {
    if (this.payerList == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.payerList.size())
      {
        QQWalletTransferMsgElem.AAPayer localAAPayer = (QQWalletTransferMsgElem.AAPayer)this.payerList.get(i);
        if ((localAAPayer != null) && (localAAPayer.uin == paramLong)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void readJsonParams(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("payers");
      if ((paramString != null) && (paramString.length() > 0))
      {
        this.payerList = new ArrayList();
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.optJSONObject(i);
          if (localJSONObject != null)
          {
            QQWalletTransferMsgElem.AAPayer localAAPayer = new QQWalletTransferMsgElem.AAPayer();
            localAAPayer.uin = localJSONObject.optLong("uin");
            localAAPayer.amount = localJSONObject.optInt("amount");
            this.payerList.add(localAAPayer);
          }
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isDevelopLevel()) {
        paramString.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "soundRecordDuration=" + this.soundRecordDuration + ",resourceType=" + this.resourceType + ",themeId=" + this.themeId + ",skinId=" + this.skinId + ",effectsId=" + this.effectsId + ",special_pop_id=" + this.special_pop_id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsgElem
 * JD-Core Version:    0.7.0.1
 */