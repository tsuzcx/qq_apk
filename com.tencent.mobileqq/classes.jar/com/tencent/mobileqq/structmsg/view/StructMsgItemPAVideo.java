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
    if ((paramView != null) && ((paramView instanceof AnyScaleTypeImageView))) {
      paramView = (PAHighLightImageView)paramView;
    }
    for (;;)
    {
      paramView.setTag(this);
      try
      {
        paramBundle = paramBundle.getDrawable(2130841925);
        if (TextUtils.isEmpty(this.ac))
        {
          paramView.setBackgroundDrawable(paramBundle);
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          }
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramView;
          paramView = new PAHighLightImageView(paramContext);
          paramView.setId(2131368907);
          paramView.setContentDescription(paramBundle.getString(2131694583));
          paramView.setDisplayRuleDef(CustomScaleType.a);
          paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          paramView.setContentDescription(paramBundle.getText(2131719540));
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          paramBundle = null;
        }
        paramBundle = URLDrawable.getDrawable(this.ac, i, i, paramBundle, paramBundle);
        if (AbsDownloader.hasFile(this.ac)) {
          break label191;
        }
      }
    }
    label191:
    boolean bool;
    if (!URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext))
    {
      bool = true;
      label194:
      paramBundle.setAutoDownload(bool);
      if (paramBundle.getStatus() != 1) {
        break label227;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      paramView.setBackgroundDrawable(paramBundle);
      break;
      bool = false;
      break label194;
      label227:
      paramView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      paramView.setBackgroundColor(15790320);
    }
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131378578) {
        return (StructMsgForGeneralShare)paramView.getTag(2131378578);
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
    if (this.ac != null)
    {
      str = this.ac;
      paramObjectOutput.writeUTF(str);
      if (this.ad == null) {
        break label134;
      }
      str = this.ad;
      label36:
      paramObjectOutput.writeUTF(str);
      if (this.jdField_a_of_type_Int > 5)
      {
        if (this.ae == null) {
          break label140;
        }
        str = this.ae;
        label63:
        paramObjectOutput.writeUTF(str);
        if (this.j == null) {
          break label146;
        }
        str = this.j;
        label82:
        paramObjectOutput.writeUTF(str);
        if (this.k == null) {
          break label152;
        }
        str = this.k;
        label101:
        paramObjectOutput.writeUTF(str);
        if (this.l == null) {
          break label158;
        }
      }
    }
    label134:
    label140:
    label146:
    label152:
    label158:
    for (String str = this.l;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      str = "";
      break label36;
      str = "";
      break label63;
      str = "";
      break label82;
      str = "";
      break label101;
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
    if (paramStructMsgNode == null) {}
    do
    {
      return true;
      this.ac = paramStructMsgNode.a("cover");
      this.ad = paramStructMsgNode.a("src");
    } while (this.jdField_a_of_type_Int <= 5);
    this.ae = paramStructMsgNode.a("video_info");
    this.j = paramStructMsgNode.a("index");
    this.k = paramStructMsgNode.a("index_name");
    this.l = paramStructMsgNode.a("index_type");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo
 * JD-Core Version:    0.7.0.1
 */