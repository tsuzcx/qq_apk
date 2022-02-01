package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.structmsg.StructMsgNode;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemVoteCover
  extends StructMsgItemCover
{
  public StructMsgItemVoteCover()
  {
    this.a = "vote";
  }
  
  public String a()
  {
    return "VoteCover";
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "vote");
    if (this.ac == null) {}
    for (String str = "";; str = this.ac)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "vote");
      return;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    paramStructMsgNode = paramStructMsgNode.a("cover");
    if (paramStructMsgNode != null) {}
    for (;;)
    {
      this.ac = paramStructMsgNode;
      return true;
      paramStructMsgNode = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVoteCover
 * JD-Core Version:    0.7.0.1
 */