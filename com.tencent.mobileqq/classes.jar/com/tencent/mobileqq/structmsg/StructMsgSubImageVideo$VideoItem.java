package com.tencent.mobileqq.structmsg;

import android.util.Log;
import bdnt;
import bdpl;
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
  
  private static VideoItem a(bdpl parambdpl)
  {
    Iterator localIterator = parambdpl.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (bdpl)localIterator.next();
      if ("title".equals(((bdpl)localObject3).b)) {
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      break;
      if ("video".equals(((bdpl)localObject3).b))
      {
        localObject1 = localObject3;
        continue;
        if (localObject1 == null)
        {
          Log.i("StructMsgSubImageVideo", "parseVideoNode: null videoNode");
          return null;
        }
        localObject3 = new VideoItem();
        ((VideoItem)localObject3).schema = parambdpl.a("url");
        if (localObject2 == null) {}
        for (parambdpl = "";; parambdpl = localObject2.jdField_a_of_type_JavaLangString)
        {
          ((VideoItem)localObject3).title = parambdpl;
          ((VideoItem)localObject3).coverUrl = localObject1.a("cover");
          ((VideoItem)localObject3).videoUrl = localObject1.a("url");
          try
          {
            ((VideoItem)localObject3).width = Integer.parseInt(localObject1.a("width"));
            ((VideoItem)localObject3).height = Integer.parseInt(localObject1.a("height"));
            return localObject3;
          }
          catch (NumberFormatException parambdpl)
          {
            Log.w("StructMsgSubImageVideo", "parseVideoNode: wrong width or height param", parambdpl);
            return localObject3;
          }
        }
      }
    }
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
  
  public void toXml(bdnt parambdnt)
  {
    parambdnt.startTag(null, "item");
    parambdnt.attribute(null, "apptype", "10");
    parambdnt.attribute(null, "type", "0");
    parambdnt.attribute(null, "url", this.schema);
    parambdnt.startTag(null, "title");
    if (this.title == null)
    {
      str = "";
      parambdnt.text(str);
      parambdnt.endTag(null, "title");
      parambdnt.startTag(null, "video");
      if (this.coverUrl != null) {
        break label173;
      }
      str = "";
      label90:
      parambdnt.attribute(null, "cover", str);
      if (this.videoUrl != null) {
        break label181;
      }
    }
    label173:
    label181:
    for (String str = "";; str = this.videoUrl)
    {
      parambdnt.attribute(null, "url", str);
      parambdnt.attribute(null, "width", Integer.toString(this.width));
      parambdnt.attribute(null, "height", Integer.toString(this.height));
      parambdnt.endTag(null, "video");
      parambdnt.endTag(null, "item");
      return;
      str = this.title;
      break;
      str = this.coverUrl;
      break label90;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    if (this.title == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.coverUrl != null) {
        break label97;
      }
      str = "";
      label27:
      paramObjectOutput.writeUTF(str);
      if (this.videoUrl != null) {
        break label105;
      }
      str = "";
      label44:
      paramObjectOutput.writeUTF(str);
      if (this.schema != null) {
        break label113;
      }
    }
    label97:
    label105:
    label113:
    for (String str = "";; str = this.schema)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.width);
      paramObjectOutput.writeInt(this.height);
      return;
      str = this.title;
      break;
      str = this.coverUrl;
      break label27;
      str = this.videoUrl;
      break label44;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.VideoItem
 * JD-Core Version:    0.7.0.1
 */