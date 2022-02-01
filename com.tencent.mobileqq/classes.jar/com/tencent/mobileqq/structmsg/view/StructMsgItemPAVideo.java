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
  public View.OnClickListener a;
  private URLDrawableDownListener.Adapter a;
  public String ac = null;
  private String ad = null;
  private String ae = null;
  
  public StructMsgItemPAVideo()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new StructMsgItemPAVideo.1(this);
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new StructMsgItemPAVideo.2(this);
    this.jdField_a_of_type_JavaLangString = "pavideo";
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
      paramView.setId(2131368633);
      paramView.setContentDescription(paramBundle.getString(2131694551));
      paramView.setDisplayRuleDef(CustomScaleType.a);
      paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramView.setContentDescription(paramBundle.getText(2131719258));
    }
    paramView.setTag(this);
    try
    {
      paramBundle = paramBundle.getDrawable(2130841816);
    }
    catch (OutOfMemoryError paramBundle)
    {
      label97:
      boolean bool;
      break label97;
    }
    paramBundle = null;
    if (TextUtils.isEmpty(this.ac))
    {
      paramView.setBackgroundDrawable(paramBundle);
    }
    else
    {
      paramBundle = URLDrawable.getDrawable(this.ac, i, i, paramBundle, paramBundle);
      if ((!AbsDownloader.hasFile(this.ac)) && (URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext))) {
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
        paramView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        paramView.setBackgroundColor(15790320);
      }
      paramView.setBackgroundDrawable(paramBundle);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramView;
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131377989) {
        return (StructMsgForGeneralShare)paramView.getTag(2131377989);
      }
    }
    return null;
  }
  
  public String a()
  {
    return "pavideo";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ac = paramObjectInput.readUTF();
    this.ad = paramObjectInput.readUTF();
    if (this.jdField_a_of_type_Int > 5)
    {
      this.ae = paramObjectInput.readUTF();
      this.j = paramObjectInput.readUTF();
      this.k = paramObjectInput.readUTF();
      this.l = paramObjectInput.readUTF();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    Object localObject = this.ac;
    String str = "";
    if (localObject == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    localObject = this.ad;
    if (localObject == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.jdField_a_of_type_Int > 5)
    {
      localObject = this.ae;
      if (localObject == null) {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.j != null) {
        localObject = this.j;
      } else {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.k != null) {
        localObject = this.k;
      } else {
        localObject = "";
      }
      paramObjectOutput.writeUTF((String)localObject);
      localObject = str;
      if (this.l != null) {
        localObject = this.l;
      }
      paramObjectOutput.writeUTF((String)localObject);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "pavideo");
    paramXmlSerializer.attribute(null, "cover", this.ac);
    paramXmlSerializer.attribute(null, "src", this.ad);
    if (this.jdField_a_of_type_Int > 5)
    {
      paramXmlSerializer.attribute(null, "video_info", this.ae);
      if (!TextUtils.isEmpty(this.j)) {
        paramXmlSerializer.attribute(null, "index", this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        paramXmlSerializer.attribute(null, "index_name", this.k);
      }
      if (!TextUtils.isEmpty(this.l)) {
        paramXmlSerializer.attribute(null, "index_type", this.l);
      }
    }
    paramXmlSerializer.endTag(null, "pavideo");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.ac = paramStructMsgNode.a("cover");
    this.ad = paramStructMsgNode.a("src");
    if (this.jdField_a_of_type_Int > 5)
    {
      this.ae = paramStructMsgNode.a("video_info");
      this.j = paramStructMsgNode.a("index");
      this.k = paramStructMsgNode.a("index_name");
      this.l = paramStructMsgNode.a("index_type");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo
 * JD-Core Version:    0.7.0.1
 */