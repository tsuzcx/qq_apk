package com.tencent.mobileqq.data;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
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
  extends Entity
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
  @notColumn
  public boolean bHighLight;
  public long cardDisplayTimestamp = 0L;
  public String category;
  public String city;
  public String country;
  public int friendStatus;
  public short gender = 255;
  public boolean hasQZoneUpdate;
  public String mobile_name;
  @notColumn
  public List<MayKnowRecommend.MayKnowRecommendLabel> msgLabel;
  public byte[] msgLabelByte;
  public String nick;
  public String province;
  public String recommendReason;
  public String remark;
  @Deprecated
  public String richBuffer;
  public byte[] richSingature;
  @notColumn
  public RichStatus richStatus;
  public int sourceId = 0;
  public int tabID = 23;
  public int timestamp;
  public String uin;
  
  private static List<MayKnowRecommend.MayKnowRecommendLabel> convert0xc26ToMayKnowRecommendLabel(List<oidb_0xc26.Label> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() != 0))
    {
      int k = 0;
      while (k < paramList.size())
      {
        MayKnowRecommend.MayKnowRecommendLabel localMayKnowRecommendLabel = new MayKnowRecommend.MayKnowRecommendLabel();
        int i;
        int j;
        if (((oidb_0xc26.Label)paramList.get(k)).has())
        {
          oidb_0xc26.Label localLabel = (oidb_0xc26.Label)((oidb_0xc26.Label)paramList.get(k)).get();
          if (localLabel.bytes_name.has()) {
            localMayKnowRecommendLabel.bytes_name = localLabel.bytes_name.get().toStringUtf8();
          }
          if (localLabel.uint32_label_type.has()) {
            localMayKnowRecommendLabel.uint32_label_type = localLabel.uint32_label_type.get();
          }
          if (localLabel.edging_color.has()) {
            i = Color.rgb(((oidb_0xc26.Color)localLabel.edging_color.get()).uint32_r.get(), ((oidb_0xc26.Color)localLabel.edging_color.get()).uint32_g.get(), ((oidb_0xc26.Color)localLabel.edging_color.get()).uint32_b.get());
          } else {
            i = 0;
          }
          if (localLabel.text_color.has()) {
            j = Color.rgb(((oidb_0xc26.Color)localLabel.text_color.get()).uint32_r.get(), ((oidb_0xc26.Color)localLabel.text_color.get()).uint32_g.get(), ((oidb_0xc26.Color)localLabel.text_color.get()).uint32_b.get());
          } else {
            j = 0;
          }
        }
        else
        {
          j = 0;
          i = 0;
        }
        localMayKnowRecommendLabel.edging_color = i;
        localMayKnowRecommendLabel.text_color = j;
        localArrayList.add(localMayKnowRecommendLabel);
        k += 1;
      }
    }
    return localArrayList;
  }
  
  private static List<oidb_0xc26.Label> convertPushLabelTo0xc26Label(List<SubMsgType0x111.Label> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (SubMsgType0x111.Label)localIterator.next();
        oidb_0xc26.Label localLabel = new oidb_0xc26.Label();
        localLabel.setHasFlag(true);
        if (paramList.bytes_name.has()) {
          localLabel.bytes_name.set(paramList.bytes_name.get());
        }
        SubMsgType0x111.Color localColor;
        oidb_0xc26.Color localColor1;
        if (paramList.edging_color.has())
        {
          localColor = (SubMsgType0x111.Color)paramList.edging_color.get();
          localColor1 = new oidb_0xc26.Color();
          localColor1.uint32_b.set(localColor.uint32_b.get());
          localColor1.uint32_g.set(localColor.uint32_g.get());
          localColor1.uint32_r.set(localColor.uint32_r.get());
          localLabel.edging_color.set(localColor1);
        }
        if (paramList.text_color.has())
        {
          localColor = (SubMsgType0x111.Color)paramList.text_color.get();
          localColor1 = new oidb_0xc26.Color();
          localColor1.uint32_b.set(localColor.uint32_b.get());
          localColor1.uint32_g.set(localColor.uint32_g.get());
          localColor1.uint32_r.set(localColor.uint32_r.get());
          localLabel.text_color.set(localColor1);
        }
        if (paramList.uint32_label_type.has()) {
          localLabel.uint32_label_type.set(paramList.uint32_label_type.get());
        }
        localArrayList.add(localLabel);
      }
    }
    paramList = null;
    return paramList;
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
    while (localIterator.hasNext())
    {
      oidb_0xc26.MayKnowPerson localMayKnowPerson = (oidb_0xc26.MayKnowPerson)localIterator.next();
      boolean bool1 = localMayKnowPerson.uint64_uin.has();
      Object localObject2 = "";
      if (bool1) {
        paramList = String.valueOf(localMayKnowPerson.uint64_uin.get());
      } else {
        paramList = "";
      }
      if (TextUtils.isEmpty(paramList))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MayKnowRecommend", 1, "covServerDataToLocal, uint64_uin is null");
        }
      }
      else
      {
        MayKnowRecommend localMayKnowRecommend = new MayKnowRecommend();
        localMayKnowRecommend.tabID = paramInt2;
        localMayKnowRecommend.uin = paramList;
        if (localMayKnowPerson.bytes_nick.has()) {
          localObject1 = localMayKnowPerson.bytes_nick.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.nick = ((String)localObject1);
        if (localMayKnowPerson.bytes_remark.has()) {
          localObject1 = localMayKnowPerson.bytes_remark.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.remark = ((String)localObject1);
        boolean bool2 = localMayKnowPerson.uint32_age.has();
        bool1 = false;
        if (bool2) {
          i = localMayKnowPerson.uint32_age.get();
        } else {
          i = 0;
        }
        localMayKnowRecommend.age = ((short)i);
        if (localMayKnowPerson.bytes_country.has()) {
          localObject1 = localMayKnowPerson.bytes_country.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.country = ((String)localObject1);
        if (localMayKnowPerson.bytes_province.has()) {
          localObject1 = localMayKnowPerson.bytes_province.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.province = ((String)localObject1);
        if (localMayKnowPerson.bytes_city.has()) {
          localObject1 = localMayKnowPerson.bytes_city.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.city = ((String)localObject1);
        bool2 = localMayKnowPerson.uint32_gender.has();
        int j = -1;
        if (bool2) {
          i = localMayKnowPerson.uint32_gender.get();
        } else {
          i = -1;
        }
        localMayKnowRecommend.gender = ((short)i);
        if (localMayKnowPerson.bytes_catelogue.has()) {
          localObject1 = localMayKnowPerson.bytes_catelogue.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.category = ((String)localObject1);
        bool2 = localMayKnowPerson.bytes_alghrithm.has();
        Object localObject3 = null;
        if (bool2) {
          localObject1 = localMayKnowPerson.bytes_alghrithm.get().toByteArray();
        } else {
          localObject1 = null;
        }
        localMayKnowRecommend.algBuffer = ((byte[])localObject1);
        if (localMayKnowPerson.uint32_qzone.has()) {
          i = localMayKnowPerson.uint32_qzone.get();
        } else {
          i = 0;
        }
        if (i != 0) {
          bool1 = true;
        }
        localMayKnowRecommend.hasQZoneUpdate = bool1;
        if (localMayKnowPerson.bytes_reason.has()) {
          localObject1 = localMayKnowPerson.bytes_reason.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.recommendReason = ((String)localObject1);
        if (localMayKnowPerson.bytes_richbuffer.has()) {
          localObject1 = localMayKnowPerson.bytes_richbuffer.get().toByteArray();
        } else {
          localObject1 = null;
        }
        localMayKnowRecommend.richSingature = ((byte[])localObject1);
        oidb_0xc26.AddFriendSource localAddFriendSource = (oidb_0xc26.AddFriendSource)localMayKnowPerson.msg_android_source.get();
        Object localObject1 = localObject3;
        if (localMayKnowPerson.bytes_additive.has()) {
          localObject1 = localMayKnowPerson.bytes_additive.get().toByteArray();
        }
        localMayKnowRecommend.additive = ((byte[])localObject1);
        if (localAddFriendSource.uint32_source.has()) {
          i = localAddFriendSource.uint32_source.get();
        } else {
          i = -1;
        }
        localMayKnowRecommend.addFriendsource = i;
        int i = j;
        if (localAddFriendSource.uint32_sub_source.has()) {
          i = localAddFriendSource.uint32_sub_source.get();
        }
        localMayKnowRecommend.addFriendSubSource = i;
        localMayKnowRecommend.timestamp = paramInt1;
        localObject1 = localObject2;
        if (localMayKnowPerson.bytes_mobile_name.has()) {
          localObject1 = localMayKnowPerson.bytes_mobile_name.get().toStringUtf8();
        }
        localMayKnowRecommend.mobile_name = ((String)localObject1);
        localMayKnowRecommend.sourceId = localMayKnowPerson.uint32_sourceid.get();
        if ((localMayKnowPerson.bytes_mobile_name.has()) && (QLog.isColorLevel()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("covServerDataToLocal, mobile_name: ");
          ((StringBuilder)localObject1).append(localMayKnowRecommend.mobile_name);
          ((StringBuilder)localObject1).append("  uin: ");
          ((StringBuilder)localObject1).append(paramList);
          QLog.i("MayKnowRecommend", 1, ((StringBuilder)localObject1).toString());
        }
        if (localMayKnowPerson.rpt_msg_labels.has())
        {
          paramList = localMayKnowPerson.rpt_msg_labels.get();
          if (paramList != null)
          {
            localObject1 = new ByteArrayOutputStream(localMayKnowPerson.rpt_msg_labels.computeSize(1));
            try
            {
              localObject2 = CodedOutputStreamMicro.newInstance((OutputStream)localObject1);
              localMayKnowPerson.rpt_msg_labels.writeTo((CodedOutputStreamMicro)localObject2, 1);
              ((CodedOutputStreamMicro)localObject2).flush();
              localMayKnowRecommend.msgLabelByte = ((ByteArrayOutputStream)localObject1).toByteArray();
            }
            catch (IOException localIOException)
            {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("covServerDataToLocal, rpt_msg_labels error: ");
                ((StringBuilder)localObject2).append(localIOException.toString());
                QLog.i("MayKnowRecommend", 1, ((StringBuilder)localObject2).toString());
              }
            }
            localMayKnowRecommend.msgLabel = convert0xc26ToMayKnowRecommendLabel(paramList);
          }
        }
        localArrayList.add(localMayKnowRecommend);
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
    while (localIterator.hasNext())
    {
      SubMsgType0x111.MayKnowPerson localMayKnowPerson = (SubMsgType0x111.MayKnowPerson)localIterator.next();
      boolean bool1 = localMayKnowPerson.uint64_uin.has();
      Object localObject2 = "";
      if (bool1) {
        paramList = String.valueOf(localMayKnowPerson.uint64_uin.get());
      } else {
        paramList = "";
      }
      if (TextUtils.isEmpty(paramList))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MayKnowRecommend", 1, "covServerDataToLocal, uint64_uin is null");
        }
      }
      else
      {
        MayKnowRecommend localMayKnowRecommend = new MayKnowRecommend();
        localMayKnowRecommend.tabID = 23;
        localMayKnowRecommend.uin = paramList;
        if (localMayKnowPerson.bytes_nick.has()) {
          localObject1 = localMayKnowPerson.bytes_nick.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.nick = ((String)localObject1);
        if (localMayKnowPerson.bytes_remark.has()) {
          localObject1 = localMayKnowPerson.bytes_remark.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.remark = ((String)localObject1);
        boolean bool2 = localMayKnowPerson.uint32_age.has();
        bool1 = false;
        if (bool2) {
          i = localMayKnowPerson.uint32_age.get();
        } else {
          i = 0;
        }
        localMayKnowRecommend.age = ((short)i);
        if (localMayKnowPerson.bytes_country.has()) {
          localObject1 = localMayKnowPerson.bytes_country.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.country = ((String)localObject1);
        if (localMayKnowPerson.bytes_province.has()) {
          localObject1 = localMayKnowPerson.bytes_province.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.province = ((String)localObject1);
        if (localMayKnowPerson.bytes_city.has()) {
          localObject1 = localMayKnowPerson.bytes_city.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.city = ((String)localObject1);
        bool2 = localMayKnowPerson.uint32_gender.has();
        int j = -1;
        if (bool2) {
          i = localMayKnowPerson.uint32_gender.get();
        } else {
          i = -1;
        }
        localMayKnowRecommend.gender = ((short)i);
        if (localMayKnowPerson.bytes_catelogue.has()) {
          localObject1 = localMayKnowPerson.bytes_catelogue.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.category = ((String)localObject1);
        bool2 = localMayKnowPerson.bytes_alghrithm.has();
        Object localObject3 = null;
        if (bool2) {
          localObject1 = localMayKnowPerson.bytes_alghrithm.get().toByteArray();
        } else {
          localObject1 = null;
        }
        localMayKnowRecommend.algBuffer = ((byte[])localObject1);
        if (localMayKnowPerson.uint32_qzone.has()) {
          i = localMayKnowPerson.uint32_qzone.get();
        } else {
          i = 0;
        }
        if (i != 0) {
          bool1 = true;
        }
        localMayKnowRecommend.hasQZoneUpdate = bool1;
        if (localMayKnowPerson.bytes_reason.has()) {
          localObject1 = localMayKnowPerson.bytes_reason.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        localMayKnowRecommend.recommendReason = ((String)localObject1);
        if (localMayKnowPerson.bytes_richbuffer.has()) {
          localObject1 = localMayKnowPerson.bytes_richbuffer.get().toByteArray();
        } else {
          localObject1 = null;
        }
        localMayKnowRecommend.richSingature = ((byte[])localObject1);
        SubMsgType0x111.AddFriendSource localAddFriendSource = (SubMsgType0x111.AddFriendSource)localMayKnowPerson.msg_android_source.get();
        Object localObject1 = localObject3;
        if (localMayKnowPerson.bytes_additive.has()) {
          localObject1 = localMayKnowPerson.bytes_additive.get().toByteArray();
        }
        localMayKnowRecommend.additive = ((byte[])localObject1);
        if (localAddFriendSource.uint32_source.has()) {
          i = localAddFriendSource.uint32_source.get();
        } else {
          i = -1;
        }
        localMayKnowRecommend.addFriendsource = i;
        int i = j;
        if (localAddFriendSource.uint32_sub_source.has()) {
          i = localAddFriendSource.uint32_sub_source.get();
        }
        localMayKnowRecommend.addFriendSubSource = i;
        localMayKnowRecommend.timestamp = ((int)(paramLong / 1000L));
        localMayKnowRecommend.cardDisplayTimestamp = 0L;
        localObject1 = localObject2;
        if (localMayKnowPerson.bytes_mobile_name.has()) {
          localObject1 = localMayKnowPerson.bytes_mobile_name.get().toStringUtf8();
        }
        localMayKnowRecommend.mobile_name = ((String)localObject1);
        if ((localMayKnowPerson.bytes_mobile_name.has()) && (QLog.isColorLevel()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("covServerDataToLocal, mobile_name: ");
          ((StringBuilder)localObject1).append(localMayKnowRecommend.mobile_name);
          ((StringBuilder)localObject1).append("  uin: ");
          ((StringBuilder)localObject1).append(paramList);
          QLog.i("MayKnowRecommend", 1, ((StringBuilder)localObject1).toString());
        }
        if (localMayKnowPerson.rpt_msg_labels.has())
        {
          paramList = convertPushLabelTo0xc26Label(localMayKnowPerson.rpt_msg_labels.get());
          if (paramList != null)
          {
            localObject1 = new PBRepeatMessageField(oidb_0xc26.Label.class);
            ((PBRepeatMessageField)localObject1).addAll(paramList);
            localObject1 = new ByteArrayOutputStream(((PBRepeatMessageField)localObject1).computeSize(1));
            try
            {
              localObject2 = CodedOutputStreamMicro.newInstance((OutputStream)localObject1);
              localMayKnowPerson.rpt_msg_labels.writeTo((CodedOutputStreamMicro)localObject2, 1);
              ((CodedOutputStreamMicro)localObject2).flush();
              localMayKnowRecommend.msgLabelByte = ((ByteArrayOutputStream)localObject1).toByteArray();
            }
            catch (IOException localIOException)
            {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("covServerPushDataToLocal, rpt_msg_labels error: ");
                ((StringBuilder)localObject2).append(localIOException.toString());
                QLog.i("MayKnowRecommend", 1, ((StringBuilder)localObject2).toString());
              }
            }
            localMayKnowRecommend.msgLabel = convert0xc26ToMayKnowRecommendLabel(paramList);
          }
        }
        localArrayList.add(localMayKnowRecommend);
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
  
  protected void postRead()
  {
    Object localObject = this.msgLabelByte;
    if ((localObject != null) && (localObject.length > 0))
    {
      CodedInputStreamMicro localCodedInputStreamMicro = CodedInputStreamMicro.newInstance((byte[])localObject);
      localObject = PBField.initRepeatMessage(oidb_0xc26.Label.class);
      try
      {
        while (!localCodedInputStreamMicro.isAtEnd())
        {
          localCodedInputStreamMicro.readTag();
          ((PBRepeatMessageField)localObject).readFrom(localCodedInputStreamMicro);
        }
        StringBuilder localStringBuilder;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("postRead, error: ");
          localStringBuilder.append(localException.toString());
          QLog.i("MayKnowRecommend", 1, localStringBuilder.toString());
        }
        this.msgLabel = convert0xc26ToMayKnowRecommendLabel(((PBRepeatMessageField)localObject).get());
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MayKnowRecommend:{");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(",");
    localStringBuilder.append(this.nick);
    localStringBuilder.append(",");
    localStringBuilder.append(this.cardDisplayTimestamp);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MayKnowRecommend
 * JD-Core Version:    0.7.0.1
 */