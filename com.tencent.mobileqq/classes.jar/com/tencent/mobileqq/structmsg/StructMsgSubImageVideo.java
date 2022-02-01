package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class StructMsgSubImageVideo
  extends AbsStructMsg
{
  private StructMsgSubImageVideo.ImageItem imageItem;
  private StructMsgSubImageVideo.VideoItem videoItem;
  
  StructMsgSubImageVideo() {}
  
  StructMsgSubImageVideo(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  StructMsgSubImageVideo(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    if (paramStructMsgNode.d == null) {
      return;
    }
    Iterator localIterator = paramStructMsgNode.d.iterator();
    while (localIterator.hasNext())
    {
      paramStructMsgNode = (StructMsgNode)localIterator.next();
      Object localObject;
      if ((paramStructMsgNode != null) && ("item".equals(paramStructMsgNode.b)))
      {
        if ((paramStructMsgNode.d != null) && (!paramStructMsgNode.d.isEmpty()))
        {
          localObject = paramStructMsgNode.a("apptype");
          if (!"10".equals(localObject))
          {
            paramStructMsgNode = new StringBuilder();
            paramStructMsgNode.append("StructMsgSubImageVideo: wrong app type ");
            paramStructMsgNode.append((String)localObject);
            Log.i("StructMsgSubImageVideo", paramStructMsgNode.toString());
          }
          else
          {
            localObject = paramStructMsgNode.a("type");
            if ("0".equals(localObject))
            {
              this.videoItem = StructMsgSubImageVideo.VideoItem.access$000(paramStructMsgNode);
            }
            else if ("1".equals(localObject))
            {
              this.imageItem = StructMsgSubImageVideo.ImageItem.access$100(paramStructMsgNode);
            }
            else
            {
              paramStructMsgNode = new StringBuilder();
              paramStructMsgNode.append("StructMsgSubImageVideo: wrong type ");
              paramStructMsgNode.append((String)localObject);
              Log.i("StructMsgSubImageVideo", paramStructMsgNode.toString());
            }
          }
        }
        else
        {
          Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: no child in node");
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StructMsgSubImageVideo: null or wrong node ");
        if (paramStructMsgNode == null) {
          paramStructMsgNode = "null";
        } else {
          paramStructMsgNode = paramStructMsgNode.b;
        }
        ((StringBuilder)localObject).append(paramStructMsgNode);
        Log.i("StructMsgSubImageVideo", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgSubImageVideo", 2, localIOException.getMessage());
      }
    }
    return null;
  }
  
  public StructMsgSubImageVideo.ImageItem getImageItem()
  {
    return this.imageItem;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    paramContext = new View(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(600, 600));
    paramContext.setBackgroundColor(-65536);
    return paramContext;
  }
  
  public String getSourceName()
  {
    return HardCodeUtil.a(2131911926);
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    return null;
  }
  
  public StructMsgSubImageVideo.VideoItem getVideoItem()
  {
    return this.videoItem;
  }
  
  public boolean isValid()
  {
    return (this.videoItem != null) || (this.imageItem != null);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int i = paramObjectInput.readInt();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readExternal: ");
    localStringBuilder.append(i);
    Log.i("StructMsgSubImageVideo", localStringBuilder.toString());
    this.mMsgBrief = paramObjectInput.readUTF();
    this.mFlag = paramObjectInput.readInt();
    i = paramObjectInput.readInt();
    if ((i & 0x1) != 0)
    {
      if (this.videoItem == null) {
        this.videoItem = new StructMsgSubImageVideo.VideoItem();
      }
      this.videoItem.readExternal(paramObjectInput);
    }
    if ((i & 0x10) != 0)
    {
      if (this.imageItem == null) {
        this.imageItem = new StructMsgSubImageVideo.ImageItem();
      }
      this.imageItem.readExternal(paramObjectInput);
    }
  }
  
  protected void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    AbsStructMsg.XmlSerializerWithFilter localXmlSerializerWithFilter = new AbsStructMsg.XmlSerializerWithFilter(this, new QQXmlSerializer());
    try
    {
      localXmlSerializerWithFilter.setOutput(paramByteArrayOutputStream, paramString);
      localXmlSerializerWithFilter.startDocument(paramString, Boolean.valueOf(true));
      localXmlSerializerWithFilter.startTag(null, "msg");
      localXmlSerializerWithFilter.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localXmlSerializerWithFilter.attribute(null, "flag", String.valueOf(this.mFlag));
      localXmlSerializerWithFilter.attribute(null, "brief", this.mMsgBrief);
      if (this.videoItem != null) {
        this.videoItem.toXml(localXmlSerializerWithFilter);
      }
      if (this.imageItem != null) {
        this.imageItem.toXml(localXmlSerializerWithFilter);
      }
      localXmlSerializerWithFilter.endTag(null, "msg");
      localXmlSerializerWithFilter.endDocument();
      localXmlSerializerWithFilter.flush();
      return;
    }
    catch (IOException paramByteArrayOutputStream)
    {
      Log.w("StructMsgSubImageVideo", "toXml: ", paramByteArrayOutputStream);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    int i = 1;
    paramObjectOutput.writeInt(1);
    paramObjectOutput.writeUTF(this.mMsgBrief);
    paramObjectOutput.writeInt(this.mFlag);
    if (this.videoItem == null) {
      i = 0;
    }
    int j = i;
    if (this.imageItem != null) {
      j = i | 0x10;
    }
    paramObjectOutput.writeInt(j);
    Object localObject = this.videoItem;
    if (localObject != null) {
      ((StructMsgSubImageVideo.VideoItem)localObject).writeExternal(paramObjectOutput);
    }
    localObject = this.imageItem;
    if (localObject != null) {
      ((StructMsgSubImageVideo.ImageItem)localObject).writeExternal(paramObjectOutput);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo
 * JD-Core Version:    0.7.0.1
 */