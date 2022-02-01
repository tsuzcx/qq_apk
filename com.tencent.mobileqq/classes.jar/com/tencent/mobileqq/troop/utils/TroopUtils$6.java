package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import org.xmlpull.v1.XmlSerializer;

final class TroopUtils$6
  extends StructMsgItemCover
{
  TroopUtils$6(String paramString)
  {
    super(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    String str;
    if (this.ac == null) {
      str = "";
    } else {
      str = this.ac;
    }
    paramXmlSerializer.attribute(null, "cover", str);
    paramXmlSerializer.endTag(null, "picture");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.6
 * JD-Core Version:    0.7.0.1
 */