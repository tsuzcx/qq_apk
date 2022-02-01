package com.tencent.mobileqq.structmsg;

import android.util.Log;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.List;

public class StructMsgSubImageVideo$VideoItem
  implements Externalizable
{
  public String coverUrl;
  public int height;
  public String schema;
  public String title;
  public String videoUrl;
  public int width;
  
  private static VideoItem a(StructMsgNode paramStructMsgNode)
  {
    Iterator localIterator = paramStructMsgNode.d.iterator();
    Object localObject1 = null;
    Object localObject2 = localObject1;
    while (localIterator.hasNext())
    {
      localObject3 = (StructMsgNode)localIterator.next();
      if ("title".equals(((StructMsgNode)localObject3).b)) {
        localObject2 = localObject3;
      } else if ("video".equals(((StructMsgNode)localObject3).b)) {
        localObject1 = localObject3;
      }
    }
    if (localObject1 == null)
    {
      Log.i("StructMsgSubImageVideo", "parseVideoNode: null videoNode");
      return null;
    }
    Object localObject3 = new VideoItem();
    ((VideoItem)localObject3).schema = paramStructMsgNode.a("url");
    if (localObject2 == null) {
      paramStructMsgNode = "";
    } else {
      paramStructMsgNode = localObject2.a;
    }
    ((VideoItem)localObject3).title = paramStructMsgNode;
    ((VideoItem)localObject3).coverUrl = localObject1.a("cover");
    ((VideoItem)localObject3).videoUrl = localObject1.a("url");
    try
    {
      ((VideoItem)localObject3).width = Integer.parseInt(localObject1.a("width"));
      ((VideoItem)localObject3).height = Integer.parseInt(localObject1.a("height"));
      return localObject3;
    }
    catch (NumberFormatException paramStructMsgNode)
    {
      Log.w("StructMsgSubImageVideo", "parseVideoNode: wrong width or height param", paramStructMsgNode);
    }
    return localObject3;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.title = paramObjectInput.readUTF();
    this.coverUrl = paramObjectInput.readUTF();
    this.videoUrl = paramObjectInput.readUTF();
    this.schema = paramObjectInput.readUTF();
    this.width = paramObjectInput.readInt();
    this.height = paramObjectInput.readInt();
  }
  
  public void toXml(AbsStructMsg.XmlSerializerWithFilter paramXmlSerializerWithFilter)
  {
    paramXmlSerializerWithFilter.startTag(null, "item");
    paramXmlSerializerWithFilter.attribute(null, "apptype", "10");
    paramXmlSerializerWithFilter.attribute(null, "type", "0");
    paramXmlSerializerWithFilter.attribute(null, "url", this.schema);
    paramXmlSerializerWithFilter.startTag(null, "title");
    String str2 = this.title;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializerWithFilter.text(str1);
    paramXmlSerializerWithFilter.endTag(null, "title");
    paramXmlSerializerWithFilter.startTag(null, "video");
    str2 = this.coverUrl;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializerWithFilter.attribute(null, "cover", str1);
    str2 = this.videoUrl;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializerWithFilter.attribute(null, "url", str1);
    paramXmlSerializerWithFilter.attribute(null, "width", Integer.toString(this.width));
    paramXmlSerializerWithFilter.attribute(null, "height", Integer.toString(this.height));
    paramXmlSerializerWithFilter.endTag(null, "video");
    paramXmlSerializerWithFilter.endTag(null, "item");
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    String str2 = this.title;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.coverUrl;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.videoUrl;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.schema;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    paramObjectOutput.writeInt(this.width);
    paramObjectOutput.writeInt(this.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.VideoItem
 * JD-Core Version:    0.7.0.1
 */