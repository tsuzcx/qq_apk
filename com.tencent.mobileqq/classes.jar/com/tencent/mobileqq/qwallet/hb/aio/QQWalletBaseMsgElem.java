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
  public int A;
  public int B;
  public int C;
  public String D;
  public int a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public int j;
  public String k;
  public String l;
  public String m;
  public String n;
  public int o;
  public int p;
  @Deprecated
  public String q;
  @Deprecated
  public String r;
  @Deprecated
  public String s;
  public int t;
  public int u;
  public int v;
  public int w;
  public int x;
  public List<QQWalletBaseMsgElem.AAPayer> y;
  public int z;
  
  public QQWalletBaseMsgElem()
  {
    this.A = 0;
    this.D = "";
  }
  
  public QQWalletBaseMsgElem(im_msg_body.QQWalletAioElem paramQQWalletAioElem)
  {
    int i1 = 0;
    this.A = 0;
    this.D = "";
    if (paramQQWalletAioElem == null) {
      return;
    }
    this.a = paramQQWalletAioElem.uint32_background.get();
    this.b = paramQQWalletAioElem.uint32_icon.get();
    this.c = paramQQWalletAioElem.bytes_title.get().toStringUtf8();
    this.d = paramQQWalletAioElem.bytes_subtitle.get().toStringUtf8();
    this.e = paramQQWalletAioElem.bytes_content.get().toStringUtf8();
    this.f = paramQQWalletAioElem.bytes_linkurl.get().toStringUtf8();
    this.g = paramQQWalletAioElem.bytes_blackstripe.get().toStringUtf8();
    this.h = paramQQWalletAioElem.bytes_notice.get().toStringUtf8();
    if (this.f == null) {
      this.f = "";
    }
    if (this.g == null) {
      this.g = "";
    }
    if (this.h == null) {
      this.h = "";
    }
    this.a |= 0xFF000000;
    if (paramQQWalletAioElem.uint32_title_color.has())
    {
      this.i = paramQQWalletAioElem.uint32_title_color.get();
      this.i |= 0xFF000000;
    }
    else
    {
      this.i = -1;
    }
    if (paramQQWalletAioElem.uint32_subtitle_color.has())
    {
      this.j = paramQQWalletAioElem.uint32_subtitle_color.get();
      this.j |= 0xFF000000;
    }
    else
    {
      this.j = -1;
    }
    if (paramQQWalletAioElem.bytes_actions_priority.has()) {
      this.k = paramQQWalletAioElem.bytes_actions_priority.get().toStringUtf8();
    } else {
      this.k = "";
    }
    if (paramQQWalletAioElem.bytes_jump_url.has()) {
      this.l = paramQQWalletAioElem.bytes_jump_url.get().toStringUtf8();
    } else {
      this.l = "";
    }
    if (paramQQWalletAioElem.bytes_native_android.has()) {
      this.m = paramQQWalletAioElem.bytes_native_android.get().toStringUtf8();
    } else {
      this.m = "";
    }
    if (paramQQWalletAioElem.bytes_iconurl.has()) {
      this.n = paramQQWalletAioElem.bytes_iconurl.get().toStringUtf8();
    } else {
      this.n = "";
    }
    if (paramQQWalletAioElem.uint32_content_color.has())
    {
      this.o = paramQQWalletAioElem.uint32_content_color.get();
      this.o |= 0xFF000000;
    }
    else
    {
      this.o = -1;
    }
    if (paramQQWalletAioElem.uint32_content_bgcolor.has())
    {
      this.p = paramQQWalletAioElem.uint32_content_bgcolor.get();
      this.p |= 0xFF000000;
    }
    else
    {
      this.p = -1;
    }
    if (paramQQWalletAioElem.bytes_aio_image_left.has()) {
      this.q = paramQQWalletAioElem.bytes_aio_image_left.get().toStringUtf8();
    } else {
      this.q = "";
    }
    if (paramQQWalletAioElem.bytes_aio_image_right.has()) {
      this.r = paramQQWalletAioElem.bytes_aio_image_right.get().toStringUtf8();
    } else {
      this.r = "";
    }
    if (paramQQWalletAioElem.bytes_cft_image.has()) {
      this.s = paramQQWalletAioElem.bytes_cft_image.get().toStringUtf8();
    } else {
      this.s = "";
    }
    this.t = 12000;
    if (paramQQWalletAioElem.bytes_pb_reserve.has()) {}
    for (;;)
    {
      try
      {
        qqwalletaio_resv.qqwalletaio_elem_resv localqqwalletaio_elem_resv = new qqwalletaio_resv.qqwalletaio_elem_resv();
        localqqwalletaio_elem_resv.mergeFrom(paramQQWalletAioElem.bytes_pb_reserve.get().toByteArray());
        if (localqqwalletaio_elem_resv.sound_record_duration.has()) {
          this.t = localqqwalletaio_elem_resv.sound_record_duration.get();
        }
        if (localqqwalletaio_elem_resv.uint32_resource_type.has()) {
          this.u = localqqwalletaio_elem_resv.uint32_resource_type.get();
        }
        if (localqqwalletaio_elem_resv.uint32_skin_id.has()) {
          this.v = localqqwalletaio_elem_resv.uint32_skin_id.get();
        }
        if (localqqwalletaio_elem_resv.uint32_effects_id.has()) {
          this.w = localqqwalletaio_elem_resv.uint32_effects_id.get();
        }
        if (localqqwalletaio_elem_resv.int32_special_pop_id.has()) {
          this.x = localqqwalletaio_elem_resv.int32_special_pop_id.get();
        }
        if (localqqwalletaio_elem_resv.rpt_payer.has())
        {
          paramQQWalletAioElem = localqqwalletaio_elem_resv.rpt_payer.get();
          this.y = new ArrayList();
          if (i1 < paramQQWalletAioElem.size())
          {
            qqwalletaio_resv.Payer localPayer = (qqwalletaio_resv.Payer)paramQQWalletAioElem.get(i1);
            if (localPayer == null) {
              break label957;
            }
            QQWalletBaseMsgElem.AAPayer localAAPayer = new QQWalletBaseMsgElem.AAPayer();
            if (localPayer.uint64_uin.has()) {
              localAAPayer.a = localPayer.uint64_uin.get();
            }
            if (localPayer.uint32_amount.has()) {
              localAAPayer.b = localPayer.uint32_amount.get();
            }
            this.y.add(localAAPayer);
            break label957;
          }
        }
        if (localqqwalletaio_elem_resv.uint32_subjectid.has()) {
          this.z = localqqwalletaio_elem_resv.uint32_subjectid.get();
        }
        if (localqqwalletaio_elem_resv.uint32_hb_from.has()) {
          this.A = localqqwalletaio_elem_resv.uint32_hb_from.get();
        }
        if (localqqwalletaio_elem_resv.uint32_song_id.has()) {
          this.B = localqqwalletaio_elem_resv.uint32_song_id.get();
        }
        if (localqqwalletaio_elem_resv.uint32_song_flag.has()) {
          this.C = localqqwalletaio_elem_resv.uint32_song_flag.get();
        }
        if (localqqwalletaio_elem_resv.bytes_idiom_alpha.has())
        {
          this.D = localqqwalletaio_elem_resv.bytes_idiom_alpha.get().toStringUtf8();
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
        if ((this.y != null) && (this.y.size() > 0))
        {
          JSONArray localJSONArray = new JSONArray();
          i1 = 0;
          if (i1 < this.y.size())
          {
            QQWalletBaseMsgElem.AAPayer localAAPayer = (QQWalletBaseMsgElem.AAPayer)this.y.get(i1);
            if (localAAPayer == null) {
              break label145;
            }
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("uin", localAAPayer.a);
            localJSONObject2.put("amount", localAAPayer.b);
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
        this.y = new ArrayList();
        int i1 = 0;
        while (i1 < paramString.length())
        {
          JSONObject localJSONObject = paramString.optJSONObject(i1);
          if (localJSONObject != null)
          {
            QQWalletBaseMsgElem.AAPayer localAAPayer = new QQWalletBaseMsgElem.AAPayer();
            localAAPayer.a = localJSONObject.optLong("uin");
            localAAPayer.b = localJSONObject.optInt("amount");
            this.y.add(localAAPayer);
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
    if (this.y == null) {
      return false;
    }
    int i1 = 0;
    while (i1 < this.y.size())
    {
      QQWalletBaseMsgElem.AAPayer localAAPayer = (QQWalletBaseMsgElem.AAPayer)this.y.get(i1);
      if ((localAAPayer != null) && (localAAPayer.a == paramLong)) {
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
    localStringBuilder.append(this.t);
    localStringBuilder.append(",resourceType=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(",themeId=");
    localStringBuilder.append(this.z);
    localStringBuilder.append(",skinId=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(",effectsId=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(",special_pop_id=");
    localStringBuilder.append(this.x);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem
 * JD-Core Version:    0.7.0.1
 */