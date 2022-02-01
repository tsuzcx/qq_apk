package com.tencent.mobileqq.structmsg;

import android.util.Log;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.List;

public class StructMsgSubImageVideo$ImageItem
  implements Externalizable
{
  public String imageUrl;
  public String schema;
  public String title;
  
  private static ImageItem a(StructMsgNode paramStructMsgNode)
  {
    Iterator localIterator = paramStructMsgNode.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1 = null;
    Object localObject2 = localObject1;
    while (localIterator.hasNext())
    {
      localObject3 = (StructMsgNode)localIterator.next();
      if ("title".equals(((StructMsgNode)localObject3).b)) {
        localObject2 = localObject3;
      } else if ("picture".equals(((StructMsgNode)localObject3).b)) {
        localObject1 = localObject3;
      }
    }
    if (localObject1 == null)
    {
      Log.i("StructMsgSubImageVideo", "parseImageNode: null imageNode");
      return null;
    }
    Object localObject3 = new ImageItem();
    ((ImageItem)localObject3).schema = paramStructMsgNode.a("url");
    if (localObject2 == null) {
      paramStructMsgNode = "";
    } else {
      paramStructMsgNode = localObject2.jdField_a_of_type_JavaLangString;
    }
    ((ImageItem)localObject3).title = paramStructMsgNode;
    ((ImageItem)localObject3).imageUrl = localObject1.a("cover");
    return localObject3;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.title = paramObjectInput.readUTF();
    this.imageUrl = paramObjectInput.readUTF();
    this.schema = paramObjectInput.readUTF();
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
    paramXmlSerializerWithFilter.startTag(null, "picture");
    str2 = this.imageUrl;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializerWithFilter.attribute(null, "cover", str1);
    paramXmlSerializerWithFilter.endTag(null, "picture");
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
    str2 = this.imageUrl;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.ImageItem
 * JD-Core Version:    0.7.0.1
 */