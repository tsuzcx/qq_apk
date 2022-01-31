package com.tencent.mobileqq.structmsg;

import alpo;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import azqi;
import azqo;
import azsa;
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
  
  public StructMsgSubImageVideo() {}
  
  StructMsgSubImageVideo(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public StructMsgSubImageVideo(azsa paramazsa)
  {
    super(paramazsa);
    if (paramazsa.a == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramazsa.a.iterator();
      while (localIterator.hasNext())
      {
        paramazsa = (azsa)localIterator.next();
        Object localObject;
        if ((paramazsa == null) || (!"item".equals(paramazsa.b)))
        {
          localObject = new StringBuilder().append("StructMsgSubImageVideo: null or wrong node ");
          if (paramazsa == null) {}
          for (paramazsa = "null";; paramazsa = paramazsa.b)
          {
            Log.i("StructMsgSubImageVideo", paramazsa);
            break;
          }
        }
        if ((paramazsa.a == null) || (paramazsa.a.isEmpty()))
        {
          Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: no child in node");
        }
        else
        {
          localObject = paramazsa.a("apptype");
          if (!"10".equals(localObject))
          {
            Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: wrong app type " + (String)localObject);
          }
          else
          {
            localObject = paramazsa.a("type");
            if ("0".equals(localObject)) {
              this.videoItem = StructMsgSubImageVideo.VideoItem.access$000(paramazsa);
            } else if ("1".equals(localObject)) {
              this.imageItem = StructMsgSubImageVideo.ImageItem.access$100(paramazsa);
            } else {
              Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: wrong type " + (String)localObject);
            }
          }
        }
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
    return alpo.a(2131714997);
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
    Log.i("StructMsgSubImageVideo", "readExternal: " + i);
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
    azqi localazqi = new azqi(this, new azqo());
    try
    {
      localazqi.setOutput(paramByteArrayOutputStream, paramString);
      localazqi.startDocument(paramString, Boolean.valueOf(true));
      localazqi.startTag(null, "msg");
      localazqi.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localazqi.attribute(null, "flag", String.valueOf(this.mFlag));
      localazqi.attribute(null, "brief", this.mMsgBrief);
      if (this.videoItem != null) {
        this.videoItem.toXml(localazqi);
      }
      if (this.imageItem != null) {
        this.imageItem.toXml(localazqi);
      }
      localazqi.endTag(null, "msg");
      localazqi.endDocument();
      localazqi.flush();
      return;
    }
    catch (IOException paramByteArrayOutputStream)
    {
      Log.w("StructMsgSubImageVideo", "toXml: ", paramByteArrayOutputStream);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    int i = 1;
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(1);
    paramObjectOutput.writeUTF(this.mMsgBrief);
    paramObjectOutput.writeInt(this.mFlag);
    if (this.videoItem != null) {}
    for (;;)
    {
      int j = i;
      if (this.imageItem != null) {
        j = i | 0x10;
      }
      paramObjectOutput.writeInt(j);
      if (this.videoItem != null) {
        this.videoItem.writeExternal(paramObjectOutput);
      }
      if (this.imageItem != null) {
        this.imageItem.writeExternal(paramObjectOutput);
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo
 * JD-Core Version:    0.7.0.1
 */