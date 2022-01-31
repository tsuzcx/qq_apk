package com.tencent.mobileqq.structmsg;

import android.util.Log;
import axuo;
import axwg;
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
  
  private static VideoItem a(axwg paramaxwg)
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
      if ("video".equals(((axwg)localObject3).b))
      {
        localObject1 = localObject3;
        continue;
        if (localObject1 == null)
        {
          Log.i("StructMsgSubImageVideo", "parseVideoNode: null videoNode");
          return null;
        }
        localObject3 = new VideoItem();
        ((VideoItem)localObject3).schema = paramaxwg.a("url");
        if (localObject2 == null) {}
        for (paramaxwg = "";; paramaxwg = localObject2.jdField_a_of_type_JavaLangString)
        {
          ((VideoItem)localObject3).title = paramaxwg;
          ((VideoItem)localObject3).coverUrl = localObject1.a("cover");
          ((VideoItem)localObject3).videoUrl = localObject1.a("url");
          try
          {
            ((VideoItem)localObject3).width = Integer.parseInt(localObject1.a("width"));
            ((VideoItem)localObject3).height = Integer.parseInt(localObject1.a("height"));
            return localObject3;
          }
          catch (NumberFormatException paramaxwg)
          {
            Log.w("StructMsgSubImageVideo", "parseVideoNode: wrong width or height param", paramaxwg);
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
      paramaxuo.startTag(null, "video");
      if (this.coverUrl != null) {
        break label173;
      }
      str = "";
      label90:
      paramaxuo.attribute(null, "cover", str);
      if (this.videoUrl != null) {
        break label181;
      }
    }
    label173:
    label181:
    for (String str = "";; str = this.videoUrl)
    {
      paramaxuo.attribute(null, "url", str);
      paramaxuo.attribute(null, "width", Integer.toString(this.width));
      paramaxuo.attribute(null, "height", Integer.toString(this.height));
      paramaxuo.endTag(null, "video");
      paramaxuo.endTag(null, "item");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.VideoItem
 * JD-Core Version:    0.7.0.1
 */