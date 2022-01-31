package com.tencent.mobileqq.structmsg;

import android.util.Log;
import azur;
import azwj;
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
  
  private static ImageItem a(azwj paramazwj)
  {
    Iterator localIterator = paramazwj.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (azwj)localIterator.next();
      if ("title".equals(((azwj)localObject3).b)) {
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      break;
      if ("picture".equals(((azwj)localObject3).b))
      {
        localObject1 = localObject3;
        continue;
        if (localObject1 == null)
        {
          Log.i("StructMsgSubImageVideo", "parseImageNode: null imageNode");
          return null;
        }
        localObject3 = new ImageItem();
        ((ImageItem)localObject3).schema = paramazwj.a("url");
        if (localObject2 == null) {}
        for (paramazwj = "";; paramazwj = localObject2.jdField_a_of_type_JavaLangString)
        {
          ((ImageItem)localObject3).title = paramazwj;
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
  
  public void toXml(azur paramazur)
  {
    paramazur.startTag(null, "item");
    paramazur.attribute(null, "apptype", "10");
    paramazur.attribute(null, "type", "0");
    paramazur.attribute(null, "url", this.schema);
    paramazur.startTag(null, "title");
    if (this.title == null)
    {
      str = "";
      paramazur.text(str);
      paramazur.endTag(null, "title");
      paramazur.startTag(null, "picture");
      if (this.imageUrl != null) {
        break label124;
      }
    }
    label124:
    for (String str = "";; str = this.imageUrl)
    {
      paramazur.attribute(null, "cover", str);
      paramazur.endTag(null, "picture");
      paramazur.endTag(null, "item");
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