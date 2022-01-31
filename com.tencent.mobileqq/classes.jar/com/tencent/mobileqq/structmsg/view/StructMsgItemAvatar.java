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
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemAvatar
  extends AbsStructMsgElement
{
  public int e;
  public String u;
  public String v;
  
  public StructMsgItemAvatar()
  {
    this.a = "head";
  }
  
  public StructMsgItemAvatar(int paramInt, String paramString1, String paramString2)
  {
    this();
    this.e = paramInt;
    this.u = paramString1;
    this.v = paramString2;
  }
  
  public View a(Context paramContext, View paramView, int paramInt, Bundle paramBundle)
  {
    Object localObject2 = paramContext.getResources();
    LinearLayout localLinearLayout;
    Object localObject1;
    Object localObject3;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localObject1 = (ImageView)localLinearLayout.findViewById(2131362332);
      paramBundle = (ImageView)localLinearLayout.findViewById(2131362333);
      paramView = (TextView)localLinearLayout.findViewById(2131362334);
      localObject3 = ImageUtil.a();
      localObject2 = localObject3;
      if ((paramContext instanceof BaseActivity)) {
        localObject2 = FaceDrawable.a(((BaseActivity)paramContext).app, 1, this.u, 3, (Drawable)localObject3, (Drawable)localObject3);
      }
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if (paramBundle != null)
      {
        if (paramInt != 2) {
          break label594;
        }
        paramBundle.setImageResource(2130846167);
      }
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.setText(this.v);
        paramView.setTextSize(2, 20.0F);
        paramView.setTextColor(-1);
        paramView.setSingleLine();
        paramView.setEllipsize(TextUtils.TruncateAt.END);
      }
      return localLinearLayout;
      localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setId(2131362331);
      localLinearLayout.setOrientation(1);
      if (this.e == 4)
      {
        i = 53;
        label193:
        if (this.e != 4) {
          break label406;
        }
      }
      label406:
      for (int j = 53;; j = 135)
      {
        i = paramBundle.getInt("bundle_args_cover_width", AIOUtils.a(i, (Resources)localObject2));
        j = paramBundle.getInt("bundle_args_cover_height", AIOUtils.a(j, (Resources)localObject2));
        paramView = new FrameLayout(paramContext);
        localObject1 = new LinearLayout.LayoutParams(i, j);
        ((LinearLayout.LayoutParams)localObject1).gravity = 1;
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localLinearLayout.addView(paramView);
        if (paramInt != 4) {
          break label414;
        }
        i = paramBundle.getInt("bundle_args_avatar_width", AIOUtils.a(50.0F, (Resources)localObject2));
        j = paramBundle.getInt("bundle_args_avatar_height", AIOUtils.a(50.0F, (Resources)localObject2));
        localObject1 = new ImageView(paramContext);
        ((ImageView)localObject1).setId(2131362332);
        paramBundle = new FrameLayout.LayoutParams(i, j);
        paramBundle.gravity = 17;
        paramView.addView((View)localObject1, paramBundle);
        paramBundle = new ImageView(paramContext);
        paramBundle.setId(2131362333);
        paramView.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
        paramView = null;
        break;
        i = 180;
        break label193;
      }
      label414:
      int i = paramBundle.getInt("bundle_args_avatar_width", AIOUtils.a(80.0F, (Resources)localObject2));
      j = paramBundle.getInt("bundle_args_avatar_height", AIOUtils.a(80.0F, (Resources)localObject2));
      localObject1 = new ImageView(paramContext);
      ((ImageView)localObject1).setId(2131362332);
      paramBundle = new FrameLayout.LayoutParams(i, j);
      paramBundle.gravity = 17;
      paramView.addView((View)localObject1, paramBundle);
      paramBundle = new ImageView(paramContext);
      paramBundle.setId(2131362333);
      paramView.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
      paramView = new TextView(paramContext);
      paramView.setId(2131362334);
      localObject3 = new LinearLayout.LayoutParams(AIOUtils.a(180.0F, (Resources)localObject2), -2);
      ((LinearLayout.LayoutParams)localObject3).gravity = 1;
      ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(5.0F, (Resources)localObject2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramView.setGravity(1);
      localLinearLayout.addView(paramView);
      break;
      label594:
      if (paramInt == 1) {
        paramBundle.setImageResource(2130846169);
      } else if (paramInt == 3) {
        paramBundle.setImageResource(2130846168);
      } else if (paramInt == 4) {
        paramBundle.setImageResource(2130846166);
      }
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, this.e, paramBundle);
  }
  
  public String a()
  {
    return "Avatar";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.u = paramObjectInput.readUTF();
    this.v = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.u == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.v != null) {
        break label48;
      }
    }
    label48:
    for (String str = "";; str = this.v)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.u;
      break;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "head");
    if (this.u == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uin", str);
      if (this.v != null) {
        break label71;
      }
    }
    label71:
    for (String str = "";; str = this.v)
    {
      paramXmlSerializer.attribute(null, "nick", str);
      paramXmlSerializer.endTag(null, "head");
      return;
      str = this.u;
      break;
    }
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
    this.u = str1;
    str1 = paramStructMsgNode.a("nick");
    paramStructMsgNode = str1;
    if (str1 == null) {
      paramStructMsgNode = "";
    }
    this.v = paramStructMsgNode;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemAvatar
 * JD-Core Version:    0.7.0.1
 */