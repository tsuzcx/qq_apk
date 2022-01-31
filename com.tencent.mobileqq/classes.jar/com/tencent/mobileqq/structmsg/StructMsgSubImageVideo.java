package com.tencent.mobileqq.structmsg;

import ajjy;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import awuk;
import awuq;
import awwc;
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
  
  public StructMsgSubImageVideo(awwc paramawwc)
  {
    super(paramawwc);
    if (paramawwc.a == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramawwc.a.iterator();
      while (localIterator.hasNext())
      {
        paramawwc = (awwc)localIterator.next();
        Object localObject;
        if ((paramawwc == null) || (!"item".equals(paramawwc.b)))
        {
          localObject = new StringBuilder().append("StructMsgSubImageVideo: null or wrong node ");
          if (paramawwc == null) {}
          for (paramawwc = "null";; paramawwc = paramawwc.b)
          {
            Log.i("StructMsgSubImageVideo", paramawwc);
            break;
          }
        }
        if ((paramawwc.a == null) || (paramawwc.a.isEmpty()))
        {
          Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: no child in node");
        }
        else
        {
          localObject = paramawwc.a("apptype");
          if (!"10".equals(localObject))
          {
            Log.i("StructMsgSubImageVideo", "StructMsgSubImageVideo: wrong app type " + (String)localObject);
          }
          else
          {
            localObject = paramawwc.a("type");
            if ("0".equals(localObject)) {
              this.videoItem = StructMsgSubImageVideo.VideoItem.access$000(paramawwc);
            } else if ("1".equals(localObject)) {
              this.imageItem = StructMsgSubImageVideo.ImageItem.access$100(paramawwc);
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
    return ajjy.a(2131648825);
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
    awuk localawuk = new awuk(this, new awuq());
    try
    {
      localawuk.setOutput(paramByteArrayOutputStream, paramString);
      localawuk.startDocument(paramString, Boolean.valueOf(true));
      localawuk.startTag(null, "msg");
      localawuk.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localawuk.attribute(null, "flag", String.valueOf(this.mFlag));
      localawuk.attribute(null, "brief", this.mMsgBrief);
      if (this.videoItem != null) {
        this.videoItem.toXml(localawuk);
      }
      if (this.imageItem != null) {
        this.imageItem.toXml(localawuk);
      }
      localawuk.endTag(null, "msg");
      localawuk.endDocument();
      localawuk.flush();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgSubImageVideo
 * JD-Core Version:    0.7.0.1
 */