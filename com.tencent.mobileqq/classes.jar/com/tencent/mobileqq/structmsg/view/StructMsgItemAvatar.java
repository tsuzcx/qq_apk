package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemAvatar
  extends AbsStructMsgElement
{
  public int au;
  public String av;
  public String aw;
  
  public StructMsgItemAvatar()
  {
    this.b = "head";
  }
  
  public StructMsgItemAvatar(int paramInt, String paramString1, String paramString2)
  {
    this();
    this.au = paramInt;
    this.av = paramString1;
    this.aw = paramString2;
  }
  
  public View a(Context paramContext, View paramView, int paramInt, Bundle paramBundle)
  {
    Object localObject2 = paramContext.getResources();
    LinearLayout localLinearLayout;
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      paramView = (ImageView)localLinearLayout.findViewById(2131448286);
      paramBundle = (ImageView)localLinearLayout.findViewById(2131448289);
      localObject1 = (TextView)localLinearLayout.findViewById(2131448287);
    }
    else
    {
      localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setId(2131448288);
      localLinearLayout.setOrientation(1);
      int i = this.au;
      int j = 53;
      if (i == 4) {
        i = 53;
      } else {
        i = 180;
      }
      if (this.au != 4) {
        j = 135;
      }
      i = paramBundle.getInt("bundle_args_cover_width", AIOUtils.b(i, (Resources)localObject2));
      j = paramBundle.getInt("bundle_args_cover_height", AIOUtils.b(j, (Resources)localObject2));
      localObject1 = new FrameLayout(paramContext);
      paramView = new LinearLayout.LayoutParams(i, j);
      paramView.gravity = 1;
      ((FrameLayout)localObject1).setLayoutParams(paramView);
      localLinearLayout.addView((View)localObject1);
      if (paramInt == 4)
      {
        i = paramBundle.getInt("bundle_args_avatar_width", AIOUtils.b(50.0F, (Resources)localObject2));
        j = paramBundle.getInt("bundle_args_avatar_height", AIOUtils.b(50.0F, (Resources)localObject2));
        paramView = new ImageView(paramContext);
        paramView.setId(2131448286);
        paramBundle = new FrameLayout.LayoutParams(i, j);
        paramBundle.gravity = 17;
        ((FrameLayout)localObject1).addView(paramView, paramBundle);
        paramBundle = new ImageView(paramContext);
        paramBundle.setId(2131448289);
        ((FrameLayout)localObject1).addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
        localObject1 = null;
      }
      else
      {
        i = paramBundle.getInt("bundle_args_avatar_width", AIOUtils.b(80.0F, (Resources)localObject2));
        j = paramBundle.getInt("bundle_args_avatar_height", AIOUtils.b(80.0F, (Resources)localObject2));
        paramView = new ImageView(paramContext);
        paramView.setId(2131448286);
        paramBundle = new FrameLayout.LayoutParams(i, j);
        paramBundle.gravity = 17;
        ((FrameLayout)localObject1).addView(paramView, paramBundle);
        paramBundle = new ImageView(paramContext);
        paramBundle.setId(2131448289);
        ((FrameLayout)localObject1).addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
        localObject1 = new TextView(paramContext);
        ((TextView)localObject1).setId(2131448287);
        localObject3 = new LinearLayout.LayoutParams(AIOUtils.b(180.0F, (Resources)localObject2), -2);
        ((LinearLayout.LayoutParams)localObject3).gravity = 1;
        ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(5.0F, (Resources)localObject2);
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((TextView)localObject1).setGravity(1);
        localLinearLayout.addView((View)localObject1);
      }
    }
    Object localObject3 = ImageUtil.m();
    localObject2 = localObject3;
    if ((paramContext instanceof BaseActivity)) {
      localObject2 = FaceDrawable.getFaceDrawable(((BaseActivity)paramContext).app, 1, this.av, 3, (Drawable)localObject3, (Drawable)localObject3);
    }
    paramView.setImageDrawable((Drawable)localObject2);
    if (paramBundle != null) {
      if (paramInt == 2) {
        paramBundle.setImageResource(2130852658);
      } else if (paramInt == 1) {
        paramBundle.setImageResource(2130852660);
      } else if (paramInt == 3) {
        paramBundle.setImageResource(2130852659);
      } else if (paramInt == 4) {
        paramBundle.setImageResource(2130852657);
      }
    }
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(this.aw);
      ((TextView)localObject1).setTextSize(2, 20.0F);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    }
    return localLinearLayout;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, this.au, paramBundle);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.av = paramObjectInput.readUTF();
    this.aw = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.av;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.aw;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "head");
    String str2 = this.av;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializer.attribute(null, "uin", str1);
    str2 = this.aw;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializer.attribute(null, "nick", str1);
    paramXmlSerializer.endTag(null, "head");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return false;
    }
    String str2 = paramStructMsgNode.a("uin");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.av = str1;
    str1 = paramStructMsgNode.a("nick");
    paramStructMsgNode = str1;
    if (str1 == null) {
      paramStructMsgNode = "";
    }
    this.aw = paramStructMsgNode;
    return true;
  }
  
  public String b()
  {
    return "Avatar";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemAvatar
 * JD-Core Version:    0.7.0.1
 */