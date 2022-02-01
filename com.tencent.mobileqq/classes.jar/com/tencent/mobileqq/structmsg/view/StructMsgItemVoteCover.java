package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.structmsg.StructMsgNode;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemVoteCover
  extends StructMsgItemCover
{
  public StructMsgItemVoteCover()
  {
    this.b = "vote";
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "vote");
    String str;
    if (this.av == null) {
      str = "";
    } else {
      str = this.av;
    }
    paramXmlSerializer.attribute(null, "cover", str);
    paramXmlSerializer.endTag(null, "vote");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    paramStructMsgNode = paramStructMsgNode.a("cover");
    if (paramStructMsgNode == null) {
      paramStructMsgNode = "";
    }
    this.av = paramStructMsgNode;
    return true;
  }
  
  public String b()
  {
    return "VoteCover";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVoteCover
 * JD-Core Version:    0.7.0.1
 */