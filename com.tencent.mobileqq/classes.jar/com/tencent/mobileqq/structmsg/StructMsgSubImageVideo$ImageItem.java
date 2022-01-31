package com.tencent.mobileqq.structmsg;

import android.util.Log;
import axuo;
import axwg;
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
  
  private static ImageItem a(axwg paramaxwg)
  {
    Iterator localIterator = paramaxwg.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (axwg)localIterator.next();
      if ("title".equals(((axwg)localObject3).b)) {
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      break;
      if ("picture".equals(((axwg)localObject3).b))
      {
        localObject1 = localObject3;
        continue;
        if (localObject1 == null)
        {
          Log.i("StructMsgSubImageVideo", "parseImageNode: null imageNode");
          return null;
        }
        localObject3 = new ImageItem();
        ((ImageItem)localObject3).schema = paramaxwg.a("url");
        if (localObject2 == null) {}
        for (paramaxwg = "";; paramaxwg = localObject2.jdField_a_of_type_JavaLangString)
        {
          ((ImageItem)localObject3).title = paramaxwg;
          ((ImageItem)localObject3).imageUrl = localObject1.a("cover");
          return localObject3;
        }
      }
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.title = paramObjectInput.readUTF();
    this.imageUrl = paramObjectInput.readUTF();
    this.schema = paramObjectInput.readUTF();
  }
  
  public void toXml(axuo paramaxuo)
  {
    paramaxuo.startTag(null, "item");
    paramaxuo.attribute(null, "apptype", "10");
    paramaxuo.attribute(null, "type", "0");
    paramaxuo.attribute(null, "url", this.schema);
    paramaxuo.startTag(null, "title");
    if (this.title == null)
    {
      str = "";
      paramaxuo.text(str);
      paramaxuo.endTag(null, "title");
      paramaxuo.startTag(null, "picture");
      if (this.imageUrl != null) {
        break label124;
      }
    }
    label124:
    for (String str = "";; str = this.imageUrl)
    {
      paramaxuo.attribute(null, "cover", str);
      paramaxuo.endTag(null, "picture");
      paramaxuo.endTag(null, "item");
      return;
      str = this.title;
      break;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    if (this.title == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.imageUrl != null) {
        break label60;
      }
      str = "";
      label27:
      paramObjectOutput.writeUTF(str);
      if (this.schema != null) {
        break label68;
      }
    }
    label60:
    label68:
    for (String str = "";; str = this.schema)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.title;
      break;
      str = this.imageUrl;
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.ImageItem
 * JD-Core Version:    0.7.0.1
 */