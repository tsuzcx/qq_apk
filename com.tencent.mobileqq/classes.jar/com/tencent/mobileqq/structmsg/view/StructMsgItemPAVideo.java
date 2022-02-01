package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.CustomScaleType;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemPAVideo
  extends AbsStructMsgElement
{
  public String au = null;
  public View.OnClickListener av = new StructMsgItemPAVideo.1(this);
  private String aw = null;
  private String ax = null;
  private URLDrawableDownListener.Adapter ay = new StructMsgItemPAVideo.2(this);
  
  public StructMsgItemPAVideo()
  {
    this.b = "pavideo";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramContext.getResources();
    int i = paramBundle.getDisplayMetrics().widthPixels;
    if ((paramView != null) && ((paramView instanceof AnyScaleTypeImageView)))
    {
      paramView = (PAHighLightImageView)paramView;
    }
    else
    {
      paramView = new PAHighLightImageView(paramContext);
      paramView.setId(2131435545);
      paramView.setContentDescription(paramBundle.getString(2131892235));
      paramView.setDisplayRuleDef(CustomScaleType.a);
      paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramView.setContentDescription(paramBundle.getText(2131916810));
    }
    paramView.setTag(this);
    try
    {
      paramBundle = paramBundle.getDrawable(2130842733);
    }
    catch (OutOfMemoryError paramBundle)
    {
      label97:
      boolean bool;
      break label97;
    }
    paramBundle = null;
    if (TextUtils.isEmpty(this.au))
    {
      paramView.setBackgroundDrawable(paramBundle);
    }
    else
    {
      paramBundle = URLDrawable.getDrawable(this.au, i, i, paramBundle, paramBundle);
      if ((!AbsDownloader.hasFile(this.au)) && (URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext))) {
        bool = false;
      } else {
        bool = true;
      }
      paramBundle.setAutoDownload(bool);
      if (paramBundle.getStatus() == 1)
      {
        paramView.setBackgroundDrawable(null);
      }
      else
      {
        paramView.setURLDrawableDownListener(this.ay);
        paramView.setBackgroundColor(15790320);
      }
      paramView.setBackgroundDrawable(paramBundle);
    }
    if (this.ar != null)
    {
      paramView.setOnLongClickListener((View.OnLongClickListener)this.ar.get());
      paramView.setOnTouchListener((View.OnTouchListener)this.ar.get());
    }
    paramView.setOnClickListener(this.av);
    return paramView;
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131446476) {
        return (StructMsgForGeneralShare)paramView.getTag(2131446476);
      }
    }
    return null;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.au = paramObjectInput.readUTF();
    this.aw = paramObjectInput.readUTF();
    if (this.a > 5)
    {
      this.ax = paramObjectInput.readUTF();
      this.l = paramObjectInput.readUTF();
      this.m = paramObjectInput.readUTF();
      this.n = paramObjectInput.readUTF();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    Object localObject = this.au;
    String str = "";
    if (localObject == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    localObject = this.aw;
    if (localObject == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.a > 5)
    {
      localObject = this.ax;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.l != null) {
        localObject = this.l;
      } else {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.m != null) {
        localObject = this.m;
      } else {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      localObject = str;
      if (this.n != null) {
        localObject = this.n;
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "pavideo");
    paramXmlSerializer.attribute(null, "cover", this.au);
    paramXmlSerializer.attribute(null, "src", this.aw);
    if (this.a > 5)
    {
      paramXmlSerializer.attribute(null, "video_info", this.ax);
      if (!TextUtils.isEmpty(this.l)) {
        paramXmlSerializer.attribute(null, "index", this.l);
      }
      if (!TextUtils.isEmpty(this.m)) {
        paramXmlSerializer.attribute(null, "index_name", this.m);
      }
      if (!TextUtils.isEmpty(this.n)) {
        paramXmlSerializer.attribute(null, "index_type", this.n);
      }
    }
    paramXmlSerializer.endTag(null, "pavideo");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.au = paramStructMsgNode.a("cover");
    this.aw = paramStructMsgNode.a("src");
    if (this.a > 5)
    {
      this.ax = paramStructMsgNode.a("video_info");
      this.l = paramStructMsgNode.a("index");
      this.m = paramStructMsgNode.a("index_name");
      this.n = paramStructMsgNode.a("index_type");
    }
    return true;
  }
  
  public String b()
  {
    return "pavideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo
 * JD-Core Version:    0.7.0.1
 */