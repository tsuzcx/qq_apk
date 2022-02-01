package com.tencent.mobileqq.service.message;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Text;

public class QParsePBMsgElemsDefaultTextElem
{
  protected long a;
  private AtTroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataAtTroopMemberInfo;
  protected MessageInfo a;
  protected StringBuilder a;
  private ArrayList<AtTroopMemberInfo> jdField_a_of_type_JavaUtilArrayList;
  protected AppRuntime a;
  protected im_msg_body.Elem a;
  protected boolean a;
  protected byte[] a;
  private AtTroopMemberInfo b;
  protected StringBuilder b;
  
  public QParsePBMsgElemsDefaultTextElem(AppRuntime paramAppRuntime, StringBuilder paramStringBuilder1, long paramLong, MessageInfo paramMessageInfo, ArrayList<AtTroopMemberInfo> paramArrayList, AtTroopMemberInfo paramAtTroopMemberInfo1, AtTroopMemberInfo paramAtTroopMemberInfo2, byte[] paramArrayOfByte, StringBuilder paramStringBuilder2, boolean paramBoolean, im_msg_body.Elem paramElem)
  {
    this.jdField_a_of_type_JavaLangStringBuilder = paramStringBuilder1;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo = paramMessageInfo;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqDataAtTroopMemberInfo = paramAtTroopMemberInfo1;
    this.jdField_b_of_type_ComTencentMobileqqDataAtTroopMemberInfo = paramAtTroopMemberInfo2;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_b_of_type_JavaLangStringBuilder = paramStringBuilder2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem = paramElem;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte)
  {
    int j = 0;
    int n = PkgTools.getShortData(paramArrayOfByte, 0);
    int i = 2;
    while ((j < n) && (i < 2048))
    {
      AtTroopMemberInfo localAtTroopMemberInfo1 = new AtTroopMemberInfo();
      if ((j == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataAtTroopMemberInfo == null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataAtTroopMemberInfo = localAtTroopMemberInfo1;
      }
      if (!localAtTroopMemberInfo1.readFrom(paramArrayOfByte, i)) {
        return;
      }
      int k = i + localAtTroopMemberInfo1.length();
      localAtTroopMemberInfo1.startPos = ((short)(localAtTroopMemberInfo1.startPos + paramInt));
      int m = (short)(j + 1);
      if (localAtTroopMemberInfo1.isIncludingAll()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b(13, this.jdField_a_of_type_Long);
      }
      j = m;
      i = k;
      if (localAtTroopMemberInfo1.isIncludingMe(this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin()))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b(24, this.jdField_a_of_type_Long);
        AtTroopMemberInfo localAtTroopMemberInfo2 = this.jdField_a_of_type_ComTencentMobileqqDataAtTroopMemberInfo;
        j = m;
        i = k;
        if (localAtTroopMemberInfo1 != localAtTroopMemberInfo2)
        {
          j = m;
          i = k;
          if (this.jdField_b_of_type_ComTencentMobileqqDataAtTroopMemberInfo == null)
          {
            j = m;
            i = k;
            if (localAtTroopMemberInfo2.isIncludingMe(this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin()))
            {
              this.jdField_b_of_type_ComTencentMobileqqDataAtTroopMemberInfo = localAtTroopMemberInfo1;
              j = m;
              i = k;
            }
          }
        }
      }
    }
  }
  
  @Nullable
  private QParsePBMsgElemsDefaultTextElem b()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType:Text;\n");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return this;
    }
    Object localObject1 = (im_msg_body.Text)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.text.get();
    int i = this.jdField_b_of_type_JavaLangStringBuilder.length();
    if (((im_msg_body.Text)localObject1).str.has())
    {
      localObject2 = QMessageUtils.a(((im_msg_body.Text)localObject1).str.get().toStringUtf8(), false);
      this.jdField_b_of_type_JavaLangStringBuilder.append((String)localObject2);
    }
    if (!((im_msg_body.Text)localObject1).attr_6_buf.has()) {
      return null;
    }
    localObject1 = ((im_msg_body.Text)localObject1).attr_6_buf.get();
    if (localObject1 != null) {
      localObject1 = ((ByteStringMicro)localObject1).toByteArray();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo;
    if ((localObject2 != null) && ((((MessageInfo)localObject2).jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo.jdField_a_of_type_Int == 1)) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (localObject1 != null) && (localObject1.length != 0)) {
      b(i, (byte[])localObject1);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo;
    if (localObject2 != null)
    {
      if ((!((MessageInfo)localObject2).jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(24, this.jdField_a_of_type_Long)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(13, this.jdField_a_of_type_Long)) && (this.jdField_b_of_type_ComTencentMobileqqDataAtTroopMemberInfo != null)) {
        return null;
      }
      if (localObject1 != null)
      {
        if (localObject1.length == 0) {
          return null;
        }
        a(i, (byte[])localObject1);
      }
    }
    return null;
  }
  
  private void b(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    int k = PkgTools.getShortData(paramArrayOfByte, 0);
    int j = 2;
    while ((i < k) && (j < 2048))
    {
      AtTroopMemberInfo localAtTroopMemberInfo = new AtTroopMemberInfo();
      if (!localAtTroopMemberInfo.readFrom(paramArrayOfByte, j)) {
        return;
      }
      j += localAtTroopMemberInfo.length();
      localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + paramInt));
      i = (short)(i + 1);
      this.jdField_a_of_type_JavaUtilArrayList.add(localAtTroopMemberInfo);
    }
  }
  
  public AtTroopMemberInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataAtTroopMemberInfo;
  }
  
  public QParsePBMsgElemsDefaultTextElem a()
  {
    if (this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.text.has())
    {
      QParsePBMsgElemsDefaultTextElem localQParsePBMsgElemsDefaultTextElem = b();
      if (localQParsePBMsgElemsDefaultTextElem != null) {
        return localQParsePBMsgElemsDefaultTextElem;
      }
    }
    else
    {
      a();
    }
    return this;
  }
  
  protected void a() {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public AtTroopMemberInfo b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqDataAtTroopMemberInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.QParsePBMsgElemsDefaultTextElem
 * JD-Core Version:    0.7.0.1
 */