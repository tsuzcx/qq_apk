package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.structmsg.AbsStructMsg.XmlSerializerWithFilter;
import com.tencent.mobileqq.structmsg.QQXmlSerializer;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

final class TroopUtils$5
  extends StructMsgForGeneralShare
{
  protected void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    AbsStructMsg.XmlSerializerWithFilter localXmlSerializerWithFilter = new AbsStructMsg.XmlSerializerWithFilter(this, new QQXmlSerializer());
    try
    {
      localXmlSerializerWithFilter.setOutput(paramByteArrayOutputStream, paramString);
      localXmlSerializerWithFilter.startDocument(paramString, null);
      localXmlSerializerWithFilter.startTag(null, "msg");
      localXmlSerializerWithFilter.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localXmlSerializerWithFilter.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgBrief == null) {
        paramByteArrayOutputStream = "";
      } else {
        paramByteArrayOutputStream = this.mMsgBrief;
      }
      localXmlSerializerWithFilter.attribute(null, "brief", paramByteArrayOutputStream);
      toContentXml(localXmlSerializerWithFilter);
      localXmlSerializerWithFilter.startTag(null, "source");
      localXmlSerializerWithFilter.endTag(null, "source");
      localXmlSerializerWithFilter.endTag(null, "msg");
      localXmlSerializerWithFilter.endDocument();
      localXmlSerializerWithFilter.flush();
      return;
    }
    catch (Exception paramByteArrayOutputStream)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberUtil", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.5
 * JD-Core Version:    0.7.0.1
 */