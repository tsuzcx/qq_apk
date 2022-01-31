package com.tencent.mobileqq.structmsg;

import android.util.Log;
import azqi;
import azsa;
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
  
  private static ImageItem a(azsa paramazsa)
  {
    Iterator localIterator = paramazsa.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (azsa)localIterator.next();
      if ("title".equals(((azsa)localObject3).b)) {
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      break;
      if ("picture".equals(((azsa)localObject3).b))
      {
        localObject1 = localObject3;
        continue;
        if (localObject1 == null)
        {
          Log.i("StructMsgSubImageVideo", "parseImageNode: null imageNode");
          return null;
        }
        localObject3 = new ImageItem();
        ((ImageItem)localObject3).schema = paramazsa.a("url");
        if (localObject2 == null) {}
        for (paramazsa = "";; paramazsa = localObject2.jdField_a_of_type_JavaLangString)
        {
          ((ImageItem)localObject3).title = paramazsa;
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
  
  public void toXml(azqi paramazqi)
  {
    paramazqi.startTag(null, "item");
    paramazqi.attribute(null, "apptype", "10");
    paramazqi.attribute(null, "type", "0");
    paramazqi.attribute(null, "url", this.schema);
    paramazqi.startTag(null, "title");
    if (this.title == null)
    {
      str = "";
      paramazqi.text(str);
      paramazqi.endTag(null, "title");
      paramazqi.startTag(null, "picture");
      if (this.imageUrl != null) {
        break label124;
      }
    }
    label124:
    for (String str = "";; str = this.imageUrl)
    {
      paramazqi.attribute(null, "cover", str);
      paramazqi.endTag(null, "picture");
      paramazqi.endTag(null, "item");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.ImageItem
 * JD-Core Version:    0.7.0.1
 */