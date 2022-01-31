package com.tencent.mobileqq.data;

import android.graphics.Color;
import android.text.TextUtils;
import atmo;
import atnz;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xc26.AddFriendSource;
import tencent.im.oidb.oidb_0xc26.Color;
import tencent.im.oidb.oidb_0xc26.Label;
import tencent.im.oidb.oidb_0xc26.MayKnowPerson;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111.AddFriendSource;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111.MayKnowPerson;

public class MayKnowRecommend
  extends atmo
  implements Serializable
{
  public static final int INVALID_ADDFRIEND_SOURCE = -1;
  private static final int SOURCEID_FROM_CONTACT = 102;
  public static final int TAB_ID_FOR_MAY_KNOW_RECOMMEND = 23;
  private static final String TAG = "MayKnowRecommend";
  private static final long serialVersionUID = 1L;
  public int addFriendSubSource = -1;
  public int addFriendsource = -1;
  public byte[] additive;
  public short age;
  public byte[] algBuffer;
  @atnz
  public boolean bHighLight;
  public long cardDisplayTimestamp;
  public String category;
  public String city;
  public String country;
  public int friendStatus;
  public short gender = 255;
  public boolean hasQZoneUpdate;
  public String mobile_name;
  @atnz
  public List<MayKnowRecommend.MayKnowRecommendLabel> msgLabel;
  public byte[] msgLabelByte;
  public String nick;
  public String province;
  public String recommendReason;
  public String remark;
  @Deprecated
  public String richBuffer;
  public byte[] richSingature;
  @atnz
  public RichStatus richStatus;
  public int sourceId;
  public int tabID = 23;
  public int timestamp;
  public String uin;
  
  private static List<MayKnowRecommend.MayKnowRecommendLabel> convert0xc26ToMayKnowRecommendLabel(List<oidb_0xc26.Label> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int k;
    MayKnowRecommend.MayKnowRecommendLabel localMayKnowRecommendLabel;
    int i;
    label194:
    int j;
    if ((paramList != null) && (paramList.size() != 0))
    {
      k = 0;
      if (k < paramList.size())
      {
        localMayKnowRecommendLabel = new MayKnowRecommend.MayKnowRecommendLabel();
        if (!((oidb_0xc26.Label)paramList.get(k)).has()) {
          break label302;
        }
        oidb_0xc26.Label localLabel = (oidb_0xc26.Label)((oidb_0xc26.Label)paramList.get(k)).get();
        if (localLabel.bytes_name.has()) {
          localMayKnowRecommendLabel.bytes_name = localLabel.bytes_name.get().toStringUtf8();
        }
        if (localLabel.uint32_label_type.has()) {
          localMayKnowRecommendLabel.uint32_label_type = localLabel.uint32_label_type.get();
        }
        if (!localLabel.edging_color.has()) {
          break label297;
        }
        i = Color.rgb(((oidb_0xc26.Color)localLabel.edging_color.get()).uint32_r.get(), ((oidb_0xc26.Color)localLabel.edging_color.get()).uint32_g.get(), ((oidb_0xc26.Color)localLabel.edging_color.get()).uint32_b.get());
        if (!localLabel.text_color.has()) {
          break label292;
        }
        j = Color.rgb(((oidb_0xc26.Color)localLabel.text_color.get()).uint32_r.get(), ((oidb_0xc26.Color)localLabel.text_color.get()).uint32_g.get(), ((oidb_0xc26.Color)localLabel.text_color.get()).uint32_b.get());
      }
    }
    for (;;)
    {
      localMayKnowRecommendLabel.edging_color = i;
      localMayKnowRecommendLabel.text_color = j;
      localArrayList.add(localMayKnowRecommendLabel);
      k += 1;
      break;
      return localArrayList;
      label292:
      j = 0;
      continue;
      label297:
      i = 0;
      break label194;
      label302:
      j = 0;
      i = 0;
    }
  }
  
  public static ArrayList<MayKnowRecommend> covServerDataToLocal(List<oidb_0xc26.MayKnowPerson> paramList, int paramInt)
  {
    return covServerDataToLocal(paramList, paramInt, 23);
  }
  
  public static ArrayList<MayKnowRecommend> covServerDataToLocal(List<oidb_0xc26.MayKnowPerson> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        oidb_0xc26.MayKnowPerson localMayKnowPerson = (oidb_0xc26.MayKnowPerson)localIterator.next();
        if (localMayKnowPerson.uint64_uin.has()) {}
        for (paramList = String.valueOf(localMayKnowPerson.uint64_uin.get());; paramList = "")
        {
          if (!TextUtils.isEmpty(paramList)) {
            break label104;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("MayknowRecommendManager", 1, "covServerDataToLocal, uint64_uin is null");
          break;
        }
        label104:
        MayKnowRecommend localMayKnowRecommend = new MayKnowRecommend();
        localMayKnowRecommend.tabID = paramInt2;
        localMayKnowRecommend.uin = paramList;
        Object localObject1;
        label149:
        label180:
        int i;
        label207:
        label238:
        boolean bool;
        label269:
        label300:
        label327:
        label358:
        Object localObject2;
        if (localMayKnowPerson.bytes_nick.has())
        {
          localObject1 = localMayKnowPerson.bytes_nick.get().toStringUtf8();
          localMayKnowRecommend.nick = ((String)localObject1);
          if (!localMayKnowPerson.bytes_remark.has()) {
            break label797;
          }
          localObject1 = localMayKnowPerson.bytes_remark.get().toStringUtf8();
          localMayKnowRecommend.remark = ((String)localObject1);
          if (!localMayKnowPerson.uint32_age.has()) {
            break label804;
          }
          i = localMayKnowPerson.uint32_age.get();
          localMayKnowRecommend.age = ((short)i);
          if (!localMayKnowPerson.bytes_country.has()) {
            break label809;
          }
          localObject1 = localMayKnowPerson.bytes_country.get().toStringUtf8();
          localMayKnowRecommend.country = ((String)localObject1);
          if (!localMayKnowPerson.bytes_province.has()) {
            break label816;
          }
          localObject1 = localMayKnowPerson.bytes_province.get().toStringUtf8();
          localMayKnowRecommend.province = ((String)localObject1);
          if (!localMayKnowPerson.bytes_city.has()) {
            break label823;
          }
          localObject1 = localMayKnowPerson.bytes_city.get().toStringUtf8();
          localMayKnowRecommend.city = ((String)localObject1);
          if (!localMayKnowPerson.uint32_gender.has()) {
            break label830;
          }
          i = localMayKnowPerson.uint32_gender.get();
          localMayKnowRecommend.gender = ((short)i);
          if (!localMayKnowPerson.bytes_catelogue.has()) {
            break label835;
          }
          localObject1 = localMayKnowPerson.bytes_catelogue.get().toStringUtf8();
          localMayKnowRecommend.category = ((String)localObject1);
          if (!localMayKnowPerson.bytes_alghrithm.has()) {
            break label842;
          }
          localObject1 = localMayKnowPerson.bytes_alghrithm.get().toByteArray();
          label389:
          localMayKnowRecommend.algBuffer = ((byte[])localObject1);
          if (!localMayKnowPerson.uint32_qzone.has()) {
            break label848;
          }
          i = localMayKnowPerson.uint32_qzone.get();
          label416:
          if (i != 0) {
            break label853;
          }
          bool = false;
          label423:
          localMayKnowRecommend.hasQZoneUpdate = bool;
          if (!localMayKnowPerson.bytes_reason.has()) {
            break label859;
          }
          localObject1 = localMayKnowPerson.bytes_reason.get().toStringUtf8();
          label454:
          localMayKnowRecommend.recommendReason = ((String)localObject1);
          if (!localMayKnowPerson.bytes_richbuffer.has()) {
            break label866;
          }
          localObject1 = localMayKnowPerson.bytes_richbuffer.get().toByteArray();
          label485:
          localMayKnowRecommend.richSingature = ((byte[])localObject1);
          localObject2 = (oidb_0xc26.AddFriendSource)localMayKnowPerson.msg_android_source.get();
          if (!localMayKnowPerson.bytes_additive.has()) {
            break label872;
          }
          localObject1 = localMayKnowPerson.bytes_additive.get().toByteArray();
          label529:
          localMayKnowRecommend.additive = ((byte[])localObject1);
          if (!((oidb_0xc26.AddFriendSource)localObject2).uint32_source.has()) {
            break label878;
          }
          i = ((oidb_0xc26.AddFriendSource)localObject2).uint32_source.get();
          label556:
          localMayKnowRecommend.addFriendsource = i;
          if (!((oidb_0xc26.AddFriendSource)localObject2).uint32_sub_source.has()) {
            break label883;
          }
          i = ((oidb_0xc26.AddFriendSource)localObject2).uint32_sub_source.get();
          label582:
          localMayKnowRecommend.addFriendSubSource = i;
          localMayKnowRecommend.timestamp = paramInt1;
          if (!localMayKnowPerson.bytes_mobile_name.has()) {
            break label888;
          }
          localObject1 = localMayKnowPerson.bytes_mobile_name.get().toStringUtf8();
          localMayKnowRecommend.mobile_name = ((String)localObject1);
          localMayKnowRecommend.sourceId = localMayKnowPerson.uint32_sourceid.get();
          if ((localMayKnowPerson.bytes_mobile_name.has()) && (QLog.isColorLevel())) {
            QLog.i("MayknowRecommendManager", 1, "covServerDataToLocal, mobile_name: " + localMayKnowRecommend.mobile_name + "  uin: " + paramList);
          }
          if (localMayKnowPerson.rpt_msg_labels.has())
          {
            paramList = localMayKnowPerson.rpt_msg_labels.get();
            if (paramList != null) {
              localObject1 = new ByteArrayOutputStream(localMayKnowPerson.rpt_msg_labels.computeSize(1));
            }
          }
        }
        try
        {
          localObject2 = CodedOutputStreamMicro.newInstance((OutputStream)localObject1);
          localMayKnowPerson.rpt_msg_labels.writeTo((CodedOutputStreamMicro)localObject2, 1);
          ((CodedOutputStreamMicro)localObject2).flush();
          localMayKnowRecommend.msgLabelByte = ((ByteArrayOutputStream)localObject1).toByteArray();
          localMayKnowRecommend.msgLabel = convert0xc26ToMayKnowRecommendLabel(paramList);
          localArrayList.add(localMayKnowRecommend);
          continue;
          localObject1 = "";
          break label149;
          label797:
          localObject1 = "";
          break label180;
          label804:
          i = 0;
          break label207;
          label809:
          localObject1 = "";
          break label238;
          label816:
          localObject1 = "";
          break label269;
          label823:
          localObject1 = "";
          break label300;
          label830:
          i = -1;
          break label327;
          label835:
          localObject1 = "";
          break label358;
          label842:
          localObject1 = null;
          break label389;
          label848:
          i = 0;
          break label416;
          label853:
          bool = true;
          break label423;
          label859:
          localObject1 = "";
          break label454;
          label866:
          localObject1 = null;
          break label485;
          label872:
          localObject1 = null;
          break label529;
          label878:
          i = -1;
          break label556;
          label883:
          i = -1;
          break label582;
          label888:
          localObject1 = "";
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("MayknowRecommendManager", 1, "covServerDataToLocal, rpt_msg_labels error: " + localIOException.toString());
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<MayKnowRecommend> covServerPushDataToLocal(List<SubMsgType0x111.MayKnowPerson> paramList, long paramLong)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      SubMsgType0x111.MayKnowPerson localMayKnowPerson = (SubMsgType0x111.MayKnowPerson)localIterator.next();
      if (localMayKnowPerson.uint64_uin.has()) {}
      for (paramList = String.valueOf(localMayKnowPerson.uint64_uin.get());; paramList = "")
      {
        if (!TextUtils.isEmpty(paramList)) {
          break label104;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MayknowRecommendManager", 1, "covServerDataToLocal, uint64_uin is null");
        break;
      }
      label104:
      MayKnowRecommend localMayKnowRecommend = new MayKnowRecommend();
      localMayKnowRecommend.tabID = 23;
      localMayKnowRecommend.uin = paramList;
      label150:
      label181:
      int i;
      label208:
      label239:
      boolean bool;
      if (localMayKnowPerson.bytes_nick.has())
      {
        localObject = localMayKnowPerson.bytes_nick.get().toStringUtf8();
        localMayKnowRecommend.nick = ((String)localObject);
        if (!localMayKnowPerson.bytes_remark.has()) {
          break label712;
        }
        localObject = localMayKnowPerson.bytes_remark.get().toStringUtf8();
        localMayKnowRecommend.remark = ((String)localObject);
        if (!localMayKnowPerson.uint32_age.has()) {
          break label719;
        }
        i = localMayKnowPerson.uint32_age.get();
        localMayKnowRecommend.age = ((short)i);
        if (!localMayKnowPerson.bytes_country.has()) {
          break label724;
        }
        localObject = localMayKnowPerson.bytes_country.get().toStringUtf8();
        localMayKnowRecommend.country = ((String)localObject);
        if (!localMayKnowPerson.bytes_province.has()) {
          break label731;
        }
        localObject = localMayKnowPerson.bytes_province.get().toStringUtf8();
        label270:
        localMayKnowRecommend.province = ((String)localObject);
        if (!localMayKnowPerson.bytes_city.has()) {
          break label738;
        }
        localObject = localMayKnowPerson.bytes_city.get().toStringUtf8();
        label301:
        localMayKnowRecommend.city = ((String)localObject);
        if (!localMayKnowPerson.uint32_gender.has()) {
          break label745;
        }
        i = localMayKnowPerson.uint32_gender.get();
        label328:
        localMayKnowRecommend.gender = ((short)i);
        if (!localMayKnowPerson.bytes_catelogue.has()) {
          break label750;
        }
        localObject = localMayKnowPerson.bytes_catelogue.get().toStringUtf8();
        label359:
        localMayKnowRecommend.category = ((String)localObject);
        if (!localMayKnowPerson.bytes_alghrithm.has()) {
          break label757;
        }
        localObject = localMayKnowPerson.bytes_alghrithm.get().toByteArray();
        label390:
        localMayKnowRecommend.algBuffer = ((byte[])localObject);
        if (!localMayKnowPerson.uint32_qzone.has()) {
          break label763;
        }
        i = localMayKnowPerson.uint32_qzone.get();
        label417:
        if (i != 0) {
          break label768;
        }
        bool = false;
        label424:
        localMayKnowRecommend.hasQZoneUpdate = bool;
        if (!localMayKnowPerson.bytes_reason.has()) {
          break label774;
        }
        localObject = localMayKnowPerson.bytes_reason.get().toStringUtf8();
        label455:
        localMayKnowRecommend.recommendReason = ((String)localObject);
        if (!localMayKnowPerson.bytes_richbuffer.has()) {
          break label781;
        }
        localObject = localMayKnowPerson.bytes_richbuffer.get().toByteArray();
        label486:
        localMayKnowRecommend.richSingature = ((byte[])localObject);
        SubMsgType0x111.AddFriendSource localAddFriendSource = (SubMsgType0x111.AddFriendSource)localMayKnowPerson.msg_android_source.get();
        if (!localMayKnowPerson.bytes_additive.has()) {
          break label787;
        }
        localObject = localMayKnowPerson.bytes_additive.get().toByteArray();
        label530:
        localMayKnowRecommend.additive = ((byte[])localObject);
        if (!localAddFriendSource.uint32_source.has()) {
          break label793;
        }
        i = localAddFriendSource.uint32_source.get();
        label557:
        localMayKnowRecommend.addFriendsource = i;
        if (!localAddFriendSource.uint32_sub_source.has()) {
          break label798;
        }
        i = localAddFriendSource.uint32_sub_source.get();
        label583:
        localMayKnowRecommend.addFriendSubSource = i;
        localMayKnowRecommend.timestamp = ((int)(paramLong / 1000L));
        localMayKnowRecommend.cardDisplayTimestamp = 0L;
        if (!localMayKnowPerson.bytes_mobile_name.has()) {
          break label803;
        }
      }
      label768:
      label774:
      label781:
      label787:
      label793:
      label798:
      label803:
      for (Object localObject = localMayKnowPerson.bytes_mobile_name.get().toStringUtf8();; localObject = "")
      {
        localMayKnowRecommend.mobile_name = ((String)localObject);
        if ((localMayKnowPerson.bytes_mobile_name.has()) && (QLog.isColorLevel())) {
          QLog.i("MayKnowRecommend", 1, "covServerDataToLocal, mobile_name: " + localMayKnowRecommend.mobile_name + "  uin: " + paramList);
        }
        localArrayList.add(localMayKnowRecommend);
        break;
        localObject = "";
        break label150;
        label712:
        localObject = "";
        break label181;
        label719:
        i = 0;
        break label208;
        label724:
        localObject = "";
        break label239;
        label731:
        localObject = "";
        break label270;
        label738:
        localObject = "";
        break label301;
        label745:
        i = -1;
        break label328;
        label750:
        localObject = "";
        break label359;
        label757:
        localObject = null;
        break label390;
        label763:
        i = 0;
        break label417;
        bool = true;
        break label424;
        localObject = "";
        break label455;
        localObject = null;
        break label486;
        localObject = null;
        break label530;
        i = -1;
        break label557;
        i = -1;
        break label583;
      }
    }
    return localArrayList;
  }
  
  public String getDisplayName(boolean paramBoolean)
  {
    if ((this.sourceId == 102) && (paramBoolean) && (!TextUtils.isEmpty(this.mobile_name)) && (!TextUtils.isEmpty(this.mobile_name.trim()))) {
      return this.mobile_name;
    }
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    if (!TextUtils.isEmpty(this.nick)) {
      return this.nick;
    }
    return this.uin;
  }
  
  public String getRecommendName(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.mobile_name)) && (!TextUtils.isEmpty(this.mobile_name.trim()))) {
      return this.mobile_name;
    }
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    return null;
  }
  
  public RichStatus getRichStatus()
  {
    if (this.richStatus == null) {
      this.richStatus = RichStatus.parseStatus(this.richSingature);
    }
    return this.richStatus;
  }
  
  public void postRead()
  {
    if ((this.msgLabelByte != null) && (this.msgLabelByte.length > 0))
    {
      CodedInputStreamMicro localCodedInputStreamMicro = CodedInputStreamMicro.newInstance(this.msgLabelByte);
      PBRepeatMessageField localPBRepeatMessageField = PBField.initRepeatMessage(oidb_0xc26.Label.class);
      try
      {
        while (!localCodedInputStreamMicro.isAtEnd())
        {
          localCodedInputStreamMicro.readTag();
          localPBRepeatMessageField.readFrom(localCodedInputStreamMicro);
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MayKnowRecommend", 1, "postRead, error: " + localException.toString());
        }
        this.msgLabel = convert0xc26ToMayKnowRecommendLabel(localPBRepeatMessageField.get());
      }
    }
  }
  
  public String toString()
  {
    return "MayKnowRecommend:{" + this.uin + "," + this.nick + "," + this.cardDisplayTimestamp + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MayKnowRecommend
 * JD-Core Version:    0.7.0.1
 */