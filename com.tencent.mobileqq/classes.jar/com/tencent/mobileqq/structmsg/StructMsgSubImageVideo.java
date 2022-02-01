package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import anvx;
import bdnt;
import bdnz;
import bdpl;
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
  
  public StructMsgSubImageVideo(bdpl parambdpl)
  {
    super(parambdpl);
    if (parambdpl.a == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = parambdpl.a.iterator();
      while (localIterator.hasNext())
      {
        parambdpl = (bdpl)localIterator.next();
        Object localObject;
        if ((parambdpl == null) || (!"item".equals(parambdpl.b)))
        {
          localObject = new StringBuilder().append("StructMsgSubImageVideo: null or wrong node ");
          if (parambdpl == null) {}
          for (parambdpl = "null";; parambdpl = parambdpl.b)
          {
            Log.i("StructMsgSubImageVideo", parambdpl);
            break;
          }
        }
        if ((parambdpl.a == null) || (parambdpl.a.isEmpty()))
        {
          Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: no child in node");
        }
        else
        {
          localObject = parambdpl.a("apptype");
          if (!"10".equals(localObject))
          {
            Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: wrong app type " + (String)localObject);
          }
          else
          {
            localObject = parambdpl.a("type");
            if ("0".equals(localObject)) {
              this.videoItem = StructMsgSubImageVideo.VideoItem.access$000(parambdpl);
            } else if ("1".equals(localObject)) {
              this.imageItem = StructMsgSubImageVideo.ImageItem.access$100(parambdpl);
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
    return anvx.a(2131713998);
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
    bdnt localbdnt = new bdnt(this, new bdnz());
    try
    {
      localbdnt.setOutput(paramByteArrayOutputStream, paramString);
      localbdnt.startDocument(paramString, Boolean.valueOf(true));
      localbdnt.startTag(null, "msg");
      localbdnt.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localbdnt.attribute(null, "flag", String.valueOf(this.mFlag));
      localbdnt.attribute(null, "brief", this.mMsgBrief);
      if (this.videoItem != null) {
        this.videoItem.toXml(localbdnt);
      }
      if (this.imageItem != null) {
        this.imageItem.toXml(localbdnt);
      }
      localbdnt.endTag(null, "msg");
      localbdnt.endDocument();
      localbdnt.flush();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo
 * JD-Core Version:    0.7.0.1
 */