package com.tencent.mobileqq.data;

import android.graphics.Color;
import android.text.TextUtils;
import aukm;
import aulx;
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
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111.Color;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111.Label;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111.MayKnowPerson;

public class MayKnowRecommend
  extends aukm
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
  @aulx
  public boolean bHighLight;
  public long cardDisplayTimestamp;
  public String category;
  public String city;
  public String country;
  public int friendStatus;
  public short gender = 255;
  public boolean hasQZoneUpdate;
  public String mobile_name;
  @aulx
  public List<MayKnowRecommend.MayKnowRecommendLabel> msgLabel;
  public byte[] msgLabelByte;
  public String nick;
  public String province;
  public String recommendReason;
  public String remark;
  @Deprecated
  public String richBuffer;
  public byte[] richSingature;
  @aulx
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
  
  private static List<oidb_0xc26.Label> convertPushLabelTo0xc26Label(List<SubMsgType0x111.Label> paramList)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SubMsgType0x111.Label localLabel = (SubMsgType0x111.Label)paramList.next();
        oidb_0xc26.Label localLabel1 = new oidb_0xc26.Label();
        localLabel1.setHasFlag(true);
        if (localLabel.bytes_name.has()) {
          localLabel1.bytes_name.set(localLabel.bytes_name.get());
        }
        SubMsgType0x111.Color localColor;
        oidb_0xc26.Color localColor1;
        if (localLabel.edging_color.has())
        {
          localColor = (SubMsgType0x111.Color)localLabel.edging_color.get();
          localColor1 = new oidb_0xc26.Color();
          localColor1.uint32_b.set(localColor.uint32_b.get());
          localColor1.uint32_g.set(localColor.uint32_g.get());
          localColor1.uint32_r.set(localColor.uint32_r.get());
          localLabel1.edging_color.set(localColor1);
        }
        if (localLabel.text_color.has())
        {
          localColor = (SubMsgType0x111.Color)localLabel.text_color.get();
          localColor1 = new oidb_0xc26.Color();
          localColor1.uint32_b.set(localColor.uint32_b.get());
          localColor1.uint32_g.set(localColor.uint32_g.get());
          localColor1.uint32_r.set(localColor.uint32_r.get());
          localLabel1.text_color.set(localColor1);
        }
        if (localLabel.uint32_label_type.has()) {
          localLabel1.uint32_label_type.set(localLabel.uint32_label_type.get());
        }
        localArrayList.add(localLabel1);
      }
    }
    return localArrayList;
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
            break label105;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("MayknowRecommendManager", 1, "covServerDataToLocal, uint64_uin is null");
          break;
        }
        label105:
        MayKnowRecommend localMayKnowRecommend = new MayKnowRecommend();
        localMayKnowRecommend.tabID = paramInt2;
        localMayKnowRecommend.uin = paramList;
        Object localObject1;
        label150:
        label181:
        int i;
        label208:
        label239:
        boolean bool;
        label270:
        label301:
        label328:
        label359:
        Object localObject2;
        if (localMayKnowPerson.bytes_nick.has())
        {
          localObject1 = localMayKnowPerson.bytes_nick.get().toStringUtf8();
          localMayKnowRecommend.nick = ((String)localObject1);
          if (!localMayKnowPerson.bytes_remark.has()) {
            break label799;
          }
          localObject1 = localMayKnowPerson.bytes_remark.get().toStringUtf8();
          localMayKnowRecommend.remark = ((String)localObject1);
          if (!localMayKnowPerson.uint32_age.has()) {
            break label807;
          }
          i = localMayKnowPerson.uint32_age.get();
          localMayKnowRecommend.age = ((short)i);
          if (!localMayKnowPerson.bytes_country.has()) {
            break label812;
          }
          localObject1 = localMayKnowPerson.bytes_country.get().toStringUtf8();
          localMayKnowRecommend.country = ((String)localObject1);
          if (!localMayKnowPerson.bytes_province.has()) {
            break label820;
          }
          localObject1 = localMayKnowPerson.bytes_province.get().toStringUtf8();
          localMayKnowRecommend.province = ((String)localObject1);
          if (!localMayKnowPerson.bytes_city.has()) {
            break label828;
          }
          localObject1 = localMayKnowPerson.bytes_city.get().toStringUtf8();
          localMayKnowRecommend.city = ((String)localObject1);
          if (!localMayKnowPerson.uint32_gender.has()) {
            break label836;
          }
          i = localMayKnowPerson.uint32_gender.get();
          localMayKnowRecommend.gender = ((short)i);
          if (!localMayKnowPerson.bytes_catelogue.has()) {
            break label841;
          }
          localObject1 = localMayKnowPerson.bytes_catelogue.get().toStringUtf8();
          localMayKnowRecommend.category = ((String)localObject1);
          if (!localMayKnowPerson.bytes_alghrithm.has()) {
            break label849;
          }
          localObject1 = localMayKnowPerson.bytes_alghrithm.get().toByteArray();
          label390:
          localMayKnowRecommend.algBuffer = ((byte[])localObject1);
          if (!localMayKnowPerson.uint32_qzone.has()) {
            break label855;
          }
          i = localMayKnowPerson.uint32_qzone.get();
          label417:
          if (i != 0) {
            break label860;
          }
          bool = false;
          label424:
          localMayKnowRecommend.hasQZoneUpdate = bool;
          if (!localMayKnowPerson.bytes_reason.has()) {
            break label866;
          }
          localObject1 = localMayKnowPerson.bytes_reason.get().toStringUtf8();
          label455:
          localMayKnowRecommend.recommendReason = ((String)localObject1);
          if (!localMayKnowPerson.bytes_richbuffer.has()) {
            break label874;
          }
          localObject1 = localMayKnowPerson.bytes_richbuffer.get().toByteArray();
          label486:
          localMayKnowRecommend.richSingature = ((byte[])localObject1);
          localObject2 = (oidb_0xc26.AddFriendSource)localMayKnowPerson.msg_android_source.get();
          if (!localMayKnowPerson.bytes_additive.has()) {
            break label880;
          }
          localObject1 = localMayKnowPerson.bytes_additive.get().toByteArray();
          label530:
          localMayKnowRecommend.additive = ((byte[])localObject1);
          if (!((oidb_0xc26.AddFriendSource)localObject2).uint32_source.has()) {
            break label886;
          }
          i = ((oidb_0xc26.AddFriendSource)localObject2).uint32_source.get();
          label557:
          localMayKnowRecommend.addFriendsource = i;
          if (!((oidb_0xc26.AddFriendSource)localObject2).uint32_sub_source.has()) {
            break label891;
          }
          i = ((oidb_0xc26.AddFriendSource)localObject2).uint32_sub_source.get();
          label583:
          localMayKnowRecommend.addFriendSubSource = i;
          localMayKnowRecommend.timestamp = paramInt1;
          if (!localMayKnowPerson.bytes_mobile_name.has()) {
            break label896;
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
          break label150;
          label799:
          localObject1 = "";
          break label181;
          label807:
          i = 0;
          break label208;
          label812:
          localObject1 = "";
          break label239;
          label820:
          localObject1 = "";
          break label270;
          label828:
          localObject1 = "";
          break label301;
          label836:
          i = -1;
          break label328;
          label841:
          localObject1 = "";
          break label359;
          label849:
          localObject1 = null;
          break label390;
          label855:
          i = 0;
          break label417;
          label860:
          bool = true;
          break label424;
          label866:
          localObject1 = "";
          break label455;
          label874:
          localObject1 = null;
          break label486;
          label880:
          localObject1 = null;
          break label530;
          label886:
          i = -1;
          break label557;
          label891:
          i = -1;
          break label583;
          label896:
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
    for (;;)
    {
      if (localIterator.hasNext())
      {
        SubMsgType0x111.MayKnowPerson localMayKnowPerson = (SubMsgType0x111.MayKnowPerson)localIterator.next();
        if (localMayKnowPerson.uint64_uin.has()) {}
        for (paramList = String.valueOf(localMayKnowPerson.uint64_uin.get());; paramList = "")
        {
          if (!TextUtils.isEmpty(paramList)) {
            break label105;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("MayknowRecommendManager", 1, "covServerDataToLocal, uint64_uin is null");
          break;
        }
        label105:
        MayKnowRecommend localMayKnowRecommend = new MayKnowRecommend();
        localMayKnowRecommend.tabID = 23;
        localMayKnowRecommend.uin = paramList;
        Object localObject1;
        label151:
        label182:
        int i;
        label209:
        label240:
        boolean bool;
        label271:
        label302:
        label329:
        label360:
        Object localObject2;
        if (localMayKnowPerson.bytes_nick.has())
        {
          localObject1 = localMayKnowPerson.bytes_nick.get().toStringUtf8();
          localMayKnowRecommend.nick = ((String)localObject1);
          if (!localMayKnowPerson.bytes_remark.has()) {
            break label815;
          }
          localObject1 = localMayKnowPerson.bytes_remark.get().toStringUtf8();
          localMayKnowRecommend.remark = ((String)localObject1);
          if (!localMayKnowPerson.uint32_age.has()) {
            break label823;
          }
          i = localMayKnowPerson.uint32_age.get();
          localMayKnowRecommend.age = ((short)i);
          if (!localMayKnowPerson.bytes_country.has()) {
            break label828;
          }
          localObject1 = localMayKnowPerson.bytes_country.get().toStringUtf8();
          localMayKnowRecommend.country = ((String)localObject1);
          if (!localMayKnowPerson.bytes_province.has()) {
            break label836;
          }
          localObject1 = localMayKnowPerson.bytes_province.get().toStringUtf8();
          localMayKnowRecommend.province = ((String)localObject1);
          if (!localMayKnowPerson.bytes_city.has()) {
            break label844;
          }
          localObject1 = localMayKnowPerson.bytes_city.get().toStringUtf8();
          localMayKnowRecommend.city = ((String)localObject1);
          if (!localMayKnowPerson.uint32_gender.has()) {
            break label852;
          }
          i = localMayKnowPerson.uint32_gender.get();
          localMayKnowRecommend.gender = ((short)i);
          if (!localMayKnowPerson.bytes_catelogue.has()) {
            break label857;
          }
          localObject1 = localMayKnowPerson.bytes_catelogue.get().toStringUtf8();
          localMayKnowRecommend.category = ((String)localObject1);
          if (!localMayKnowPerson.bytes_alghrithm.has()) {
            break label865;
          }
          localObject1 = localMayKnowPerson.bytes_alghrithm.get().toByteArray();
          label391:
          localMayKnowRecommend.algBuffer = ((byte[])localObject1);
          if (!localMayKnowPerson.uint32_qzone.has()) {
            break label871;
          }
          i = localMayKnowPerson.uint32_qzone.get();
          label418:
          if (i != 0) {
            break label876;
          }
          bool = false;
          label425:
          localMayKnowRecommend.hasQZoneUpdate = bool;
          if (!localMayKnowPerson.bytes_reason.has()) {
            break label882;
          }
          localObject1 = localMayKnowPerson.bytes_reason.get().toStringUtf8();
          label456:
          localMayKnowRecommend.recommendReason = ((String)localObject1);
          if (!localMayKnowPerson.bytes_richbuffer.has()) {
            break label890;
          }
          localObject1 = localMayKnowPerson.bytes_richbuffer.get().toByteArray();
          label487:
          localMayKnowRecommend.richSingature = ((byte[])localObject1);
          localObject2 = (SubMsgType0x111.AddFriendSource)localMayKnowPerson.msg_android_source.get();
          if (!localMayKnowPerson.bytes_additive.has()) {
            break label896;
          }
          localObject1 = localMayKnowPerson.bytes_additive.get().toByteArray();
          label531:
          localMayKnowRecommend.additive = ((byte[])localObject1);
          if (!((SubMsgType0x111.AddFriendSource)localObject2).uint32_source.has()) {
            break label902;
          }
          i = ((SubMsgType0x111.AddFriendSource)localObject2).uint32_source.get();
          label558:
          localMayKnowRecommend.addFriendsource = i;
          if (!((SubMsgType0x111.AddFriendSource)localObject2).uint32_sub_source.has()) {
            break label907;
          }
          i = ((SubMsgType0x111.AddFriendSource)localObject2).uint32_sub_source.get();
          label584:
          localMayKnowRecommend.addFriendSubSource = i;
          localMayKnowRecommend.timestamp = ((int)(paramLong / 1000L));
          localMayKnowRecommend.cardDisplayTimestamp = 0L;
          if (!localMayKnowPerson.bytes_mobile_name.has()) {
            break label912;
          }
          localObject1 = localMayKnowPerson.bytes_mobile_name.get().toStringUtf8();
          localMayKnowRecommend.mobile_name = ((String)localObject1);
          if ((localMayKnowPerson.bytes_mobile_name.has()) && (QLog.isColorLevel())) {
            QLog.i("MayKnowRecommend", 1, "covServerDataToLocal, mobile_name: " + localMayKnowRecommend.mobile_name + "  uin: " + paramList);
          }
          if (localMayKnowPerson.rpt_msg_labels.has())
          {
            paramList = convertPushLabelTo0xc26Label(localMayKnowPerson.rpt_msg_labels.get());
            if (paramList != null)
            {
              localObject1 = new PBRepeatMessageField(oidb_0xc26.Label.class);
              ((PBRepeatMessageField)localObject1).addAll(paramList);
              localObject1 = new ByteArrayOutputStream(((PBRepeatMessageField)localObject1).computeSize(1));
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
          break label151;
          label815:
          localObject1 = "";
          break label182;
          label823:
          i = 0;
          break label209;
          label828:
          localObject1 = "";
          break label240;
          label836:
          localObject1 = "";
          break label271;
          label844:
          localObject1 = "";
          break label302;
          label852:
          i = -1;
          break label329;
          label857:
          localObject1 = "";
          break label360;
          label865:
          localObject1 = null;
          break label391;
          label871:
          i = 0;
          break label418;
          label876:
          bool = true;
          break label425;
          label882:
          localObject1 = "";
          break label456;
          label890:
          localObject1 = null;
          break label487;
          label896:
          localObject1 = null;
          break label531;
          label902:
          i = -1;
          break label558;
          label907:
          i = -1;
          break label584;
          label912:
          localObject1 = "";
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("MayknowRecommendManager", 1, "covServerPushDataToLocal, rpt_msg_labels error: " + localIOException.toString());
            }
          }
        }
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