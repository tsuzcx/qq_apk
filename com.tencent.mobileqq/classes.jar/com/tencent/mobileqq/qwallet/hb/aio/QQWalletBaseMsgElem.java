package com.tencent.mobileqq.qwallet.hb.aio;

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

public class QQWalletBaseMsgElem
{
  public int a;
  public String a;
  public List<QQWalletBaseMsgElem.AAPayer> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  @Deprecated
  public String k;
  public int l;
  @Deprecated
  public String l;
  public int m;
  @Deprecated
  public String m;
  public int n;
  public String n;
  public int o;
  
  public QQWalletBaseMsgElem()
  {
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_JavaLangString = "";
  }
  
  public QQWalletBaseMsgElem(im_msg_body.QQWalletAioElem paramQQWalletAioElem)
  {
    int i1 = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_JavaLangString = "";
    if (paramQQWalletAioElem == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramQQWalletAioElem.uint32_background.get();
    this.jdField_b_of_type_Int = paramQQWalletAioElem.uint32_icon.get();
    this.jdField_a_of_type_JavaLangString = paramQQWalletAioElem.bytes_title.get().toStringUtf8();
    this.jdField_b_of_type_JavaLangString = paramQQWalletAioElem.bytes_subtitle.get().toStringUtf8();
    this.jdField_c_of_type_JavaLangString = paramQQWalletAioElem.bytes_content.get().toStringUtf8();
    this.jdField_d_of_type_JavaLangString = paramQQWalletAioElem.bytes_linkurl.get().toStringUtf8();
    this.jdField_e_of_type_JavaLangString = paramQQWalletAioElem.bytes_blackstripe.get().toStringUtf8();
    this.jdField_f_of_type_JavaLangString = paramQQWalletAioElem.bytes_notice.get().toStringUtf8();
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = "";
    }
    if (this.jdField_e_of_type_JavaLangString == null) {
      this.jdField_e_of_type_JavaLangString = "";
    }
    if (this.jdField_f_of_type_JavaLangString == null) {
      this.jdField_f_of_type_JavaLangString = "";
    }
    this.jdField_a_of_type_Int |= 0xFF000000;
    if (paramQQWalletAioElem.uint32_title_color.has())
    {
      this.jdField_c_of_type_Int = paramQQWalletAioElem.uint32_title_color.get();
      this.jdField_c_of_type_Int |= 0xFF000000;
    }
    else
    {
      this.jdField_c_of_type_Int = -1;
    }
    if (paramQQWalletAioElem.uint32_subtitle_color.has())
    {
      this.jdField_d_of_type_Int = paramQQWalletAioElem.uint32_subtitle_color.get();
      this.jdField_d_of_type_Int |= 0xFF000000;
    }
    else
    {
      this.jdField_d_of_type_Int = -1;
    }
    if (paramQQWalletAioElem.bytes_actions_priority.has()) {
      this.jdField_g_of_type_JavaLangString = paramQQWalletAioElem.bytes_actions_priority.get().toStringUtf8();
    } else {
      this.jdField_g_of_type_JavaLangString = "";
    }
    if (paramQQWalletAioElem.bytes_jump_url.has()) {
      this.jdField_h_of_type_JavaLangString = paramQQWalletAioElem.bytes_jump_url.get().toStringUtf8();
    } else {
      this.jdField_h_of_type_JavaLangString = "";
    }
    if (paramQQWalletAioElem.bytes_native_android.has()) {
      this.jdField_i_of_type_JavaLangString = paramQQWalletAioElem.bytes_native_android.get().toStringUtf8();
    } else {
      this.jdField_i_of_type_JavaLangString = "";
    }
    if (paramQQWalletAioElem.bytes_iconurl.has()) {
      this.jdField_j_of_type_JavaLangString = paramQQWalletAioElem.bytes_iconurl.get().toStringUtf8();
    } else {
      this.jdField_j_of_type_JavaLangString = "";
    }
    if (paramQQWalletAioElem.uint32_content_color.has())
    {
      this.jdField_e_of_type_Int = paramQQWalletAioElem.uint32_content_color.get();
      this.jdField_e_of_type_Int |= 0xFF000000;
    }
    else
    {
      this.jdField_e_of_type_Int = -1;
    }
    if (paramQQWalletAioElem.uint32_content_bgcolor.has())
    {
      this.jdField_f_of_type_Int = paramQQWalletAioElem.uint32_content_bgcolor.get();
      this.jdField_f_of_type_Int |= 0xFF000000;
    }
    else
    {
      this.jdField_f_of_type_Int = -1;
    }
    if (paramQQWalletAioElem.bytes_aio_image_left.has()) {
      this.jdField_k_of_type_JavaLangString = paramQQWalletAioElem.bytes_aio_image_left.get().toStringUtf8();
    } else {
      this.jdField_k_of_type_JavaLangString = "";
    }
    if (paramQQWalletAioElem.bytes_aio_image_right.has()) {
      this.jdField_l_of_type_JavaLangString = paramQQWalletAioElem.bytes_aio_image_right.get().toStringUtf8();
    } else {
      this.jdField_l_of_type_JavaLangString = "";
    }
    if (paramQQWalletAioElem.bytes_cft_image.has()) {
      this.jdField_m_of_type_JavaLangString = paramQQWalletAioElem.bytes_cft_image.get().toStringUtf8();
    } else {
      this.jdField_m_of_type_JavaLangString = "";
    }
    this.jdField_g_of_type_Int = 12000;
    if (paramQQWalletAioElem.bytes_pb_reserve.has()) {}
    for (;;)
    {
      try
      {
        qqwalletaio_resv.qqwalletaio_elem_resv localqqwalletaio_elem_resv = new qqwalletaio_resv.qqwalletaio_elem_resv();
        localqqwalletaio_elem_resv.mergeFrom(paramQQWalletAioElem.bytes_pb_reserve.get().toByteArray());
        if (localqqwalletaio_elem_resv.sound_record_duration.has()) {
          this.jdField_g_of_type_Int = localqqwalletaio_elem_resv.sound_record_duration.get();
        }
        if (localqqwalletaio_elem_resv.uint32_resource_type.has()) {
          this.jdField_h_of_type_Int = localqqwalletaio_elem_resv.uint32_resource_type.get();
        }
        if (localqqwalletaio_elem_resv.uint32_skin_id.has()) {
          this.jdField_i_of_type_Int = localqqwalletaio_elem_resv.uint32_skin_id.get();
        }
        if (localqqwalletaio_elem_resv.uint32_effects_id.has()) {
          this.jdField_j_of_type_Int = localqqwalletaio_elem_resv.uint32_effects_id.get();
        }
        if (localqqwalletaio_elem_resv.int32_special_pop_id.has()) {
          this.jdField_k_of_type_Int = localqqwalletaio_elem_resv.int32_special_pop_id.get();
        }
        if (localqqwalletaio_elem_resv.rpt_payer.has())
        {
          paramQQWalletAioElem = localqqwalletaio_elem_resv.rpt_payer.get();
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
          if (i1 < paramQQWalletAioElem.size())
          {
            qqwalletaio_resv.Payer localPayer = (qqwalletaio_resv.Payer)paramQQWalletAioElem.get(i1);
            if (localPayer == null) {
              break label957;
            }
            QQWalletBaseMsgElem.AAPayer localAAPayer = new QQWalletBaseMsgElem.AAPayer();
            if (localPayer.uint64_uin.has()) {
              localAAPayer.jdField_a_of_type_Long = localPayer.uint64_uin.get();
            }
            if (localPayer.uint32_amount.has()) {
              localAAPayer.jdField_a_of_type_Int = localPayer.uint32_amount.get();
            }
            this.jdField_a_of_type_JavaUtilList.add(localAAPayer);
            break label957;
          }
        }
        if (localqqwalletaio_elem_resv.uint32_subjectid.has()) {
          this.jdField_l_of_type_Int = localqqwalletaio_elem_resv.uint32_subjectid.get();
        }
        if (localqqwalletaio_elem_resv.uint32_hb_from.has()) {
          this.jdField_m_of_type_Int = localqqwalletaio_elem_resv.uint32_hb_from.get();
        }
        if (localqqwalletaio_elem_resv.uint32_song_id.has()) {
          this.jdField_n_of_type_Int = localqqwalletaio_elem_resv.uint32_song_id.get();
        }
        if (localqqwalletaio_elem_resv.uint32_song_flag.has()) {
          this.o = localqqwalletaio_elem_resv.uint32_song_flag.get();
        }
        if (localqqwalletaio_elem_resv.bytes_idiom_alpha.has())
        {
          this.jdField_n_of_type_JavaLangString = localqqwalletaio_elem_resv.bytes_idiom_alpha.get().toStringUtf8();
          return;
        }
      }
      catch (Throwable paramQQWalletAioElem)
      {
        paramQQWalletAioElem.printStackTrace();
      }
      return;
      label957:
      i1 += 1;
    }
  }
  
  public String a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      int i1;
      try
      {
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          JSONArray localJSONArray = new JSONArray();
          i1 = 0;
          if (i1 < this.jdField_a_of_type_JavaUtilList.size())
          {
            QQWalletBaseMsgElem.AAPayer localAAPayer = (QQWalletBaseMsgElem.AAPayer)this.jdField_a_of_type_JavaUtilList.get(i1);
            if (localAAPayer == null) {
              break label145;
            }
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("uin", localAAPayer.jdField_a_of_type_Long);
            localJSONObject2.put("amount", localAAPayer.jdField_a_of_type_Int);
            localJSONArray.put(localJSONObject2);
            break label145;
          }
          localJSONObject1.put("payers", localJSONArray);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException.printStackTrace();
        }
      }
      return localJSONObject1.toString();
      label145:
      i1 += 1;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("payers");
      if ((paramString != null) && (paramString.length() > 0))
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        int i1 = 0;
        while (i1 < paramString.length())
        {
          JSONObject localJSONObject = paramString.optJSONObject(i1);
          if (localJSONObject != null)
          {
            QQWalletBaseMsgElem.AAPayer localAAPayer = new QQWalletBaseMsgElem.AAPayer();
            localAAPayer.jdField_a_of_type_Long = localJSONObject.optLong("uin");
            localAAPayer.jdField_a_of_type_Int = localJSONObject.optInt("amount");
            this.jdField_a_of_type_JavaUtilList.add(localAAPayer);
          }
          i1 += 1;
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
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      QQWalletBaseMsgElem.AAPayer localAAPayer = (QQWalletBaseMsgElem.AAPayer)this.jdField_a_of_type_JavaUtilList.get(i1);
      if ((localAAPayer != null) && (localAAPayer.jdField_a_of_type_Long == paramLong)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("soundRecordDuration=");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append(",resourceType=");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append(",themeId=");
    localStringBuilder.append(this.jdField_l_of_type_Int);
    localStringBuilder.append(",skinId=");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append(",effectsId=");
    localStringBuilder.append(this.jdField_j_of_type_Int);
    localStringBuilder.append(",special_pop_id=");
    localStringBuilder.append(this.jdField_k_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem
 * JD-Core Version:    0.7.0.1
 */