package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qwallet.widget.QQWalletTransferBubbleView;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemLayout19
  extends AbsStructMsgItem
{
  protected String az;
  
  private void a(Context paramContext, AbsStructMsgElement paramAbsStructMsgElement, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    paramAbsStructMsgElement = (StructMsgItemCover)paramAbsStructMsgElement;
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("logo url = ");
      paramBundle.append(paramAbsStructMsgElement.av);
      QLog.d("StructMsgItemLayout19", 2, paramBundle.toString());
    }
    if (TextUtils.isEmpty(paramAbsStructMsgElement.av)) {
      return;
    }
    try
    {
      new URL(paramAbsStructMsgElement.av);
      paramBundle = paramContext.getResources();
      int i = AIOUtils.b(44.0F, paramBundle);
      paramContext = new URLImageView(paramContext);
      paramContext.setAdjustViewBounds(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, AIOUtils.b(16.0F, paramBundle), AIOUtils.b(18.0F, paramBundle), AIOUtils.b(14.0F, paramBundle));
      localLayoutParams.addRule(11);
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      paramContext.setLayoutParams(localLayoutParams);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestWidth = i;
      paramBundle.mRequestHeight = i;
      paramAbsStructMsgElement = URLDrawable.getDrawable(paramAbsStructMsgElement.av, paramBundle);
      paramAbsStructMsgElement.setAutoDownload(true);
      if (paramAbsStructMsgElement.getStatus() == 2) {
        paramAbsStructMsgElement.restartDownload();
      }
      paramContext.setImageDrawable(paramAbsStructMsgElement);
      paramContext.setId(2131446445);
      paramViewGroup.addView(paramContext);
      return;
    }
    catch (MalformedURLException paramContext) {}
  }
  
  private void a(Context paramContext, AbsStructMsgElement paramAbsStructMsgElement, Bundle paramBundle, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = (TextView)paramAbsStructMsgElement.a(paramContext, null, paramBundle);
    paramAbsStructMsgElement = new RelativeLayout.LayoutParams(-2, -2);
    paramAbsStructMsgElement.setMargins(AIOUtils.b(19.0F, localResources), AIOUtils.b(4.5F, localResources), 0, 0);
    paramAbsStructMsgElement.addRule(3, 2131446446);
    if (paramBoolean)
    {
      paramAbsStructMsgElement.addRule(0, 2131446445);
      paramAbsStructMsgElement.addRule(9);
    }
    paramContext.setLayoutParams(paramAbsStructMsgElement);
    paramContext.setSingleLine();
    paramViewGroup.addView(paramContext);
  }
  
  private void a(Context paramContext, AbsStructMsgElement paramAbsStructMsgElement, Bundle paramBundle, QQWalletTransferBubbleView paramQQWalletTransferBubbleView)
  {
    try
    {
      i = Color.parseColor(((StructMsgItemRemark)paramAbsStructMsgElement).q());
    }
    catch (Exception localException)
    {
      int i;
      label15:
      Resources localResources;
      break label15;
    }
    i = Color.parseColor("#ffffff");
    paramQQWalletTransferBubbleView.setBubbleBackground(2130849134, i, true);
    localResources = paramContext.getResources();
    paramContext = (TextView)paramAbsStructMsgElement.a(paramContext, null, paramBundle);
    paramAbsStructMsgElement = new RelativeLayout.LayoutParams(-2, -2);
    paramAbsStructMsgElement.setMargins(AIOUtils.b(19.0F, localResources), 0, 0, 0);
    paramAbsStructMsgElement.addRule(15);
    paramContext.setLayoutParams(paramAbsStructMsgElement);
    paramQQWalletTransferBubbleView.addView(paramContext);
  }
  
  private void b(Context paramContext, AbsStructMsgElement paramAbsStructMsgElement, Bundle paramBundle, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = (TextView)paramAbsStructMsgElement.a(paramContext, null, paramBundle);
    paramAbsStructMsgElement = new RelativeLayout.LayoutParams(-2, -2);
    paramAbsStructMsgElement.setMargins(AIOUtils.b(19.0F, localResources), AIOUtils.b(11.0F, localResources), 0, 0);
    if (paramBoolean)
    {
      paramAbsStructMsgElement.addRule(0, 2131446445);
      paramAbsStructMsgElement.addRule(9);
    }
    paramContext.setLayoutParams(paramAbsStructMsgElement);
    paramContext.setSingleLine();
    paramContext.setId(2131446446);
    paramViewGroup.addView(paramContext);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "read external");
    }
    super.a(paramObjectInput);
    this.az = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "write external");
    }
    super.a(paramObjectOutput);
    String str2 = this.az;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "to xml");
    }
    if (!TextUtils.isEmpty(this.az)) {
      paramXmlSerializer.attribute(null, "url", this.az);
    }
    super.a(paramXmlSerializer);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    boolean bool = super.a(paramStructMsgNode);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "from xml");
    }
    this.az = paramStructMsgNode.a("bgColor");
    return bool;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = paramContext.getResources();
    int j = 0;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
    }
    else
    {
      paramView = new LinearLayout(paramContext);
      paramView.setOrientation(1);
      paramView.setGravity(1);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, AIOUtils.b(3.0F, (Resources)localObject1), 0, 0);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramView.setId(2131446444);
    }
    Object localObject2 = new QQWalletTransferBubbleView(paramContext);
    ((QQWalletTransferBubbleView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, AIOUtils.b(74.0F, (Resources)localObject1)));
    try
    {
      i = Color.parseColor(this.az);
    }
    catch (Exception localException)
    {
      int i;
      label134:
      Object localObject3;
      boolean bool;
      int k;
      break label134;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("parse item bg color failure, color = ");
      ((StringBuilder)localObject3).append(this.az);
      QLog.d("StructMsgItemLayout19", 2, ((StringBuilder)localObject3).toString());
    }
    i = Color.parseColor("#18b4ed");
    ((QQWalletTransferBubbleView)localObject2).setBubbleBackground(2130849133, i, true);
    paramView.addView((View)localObject2);
    localObject3 = new QQWalletTransferBubbleView(paramContext);
    ((QQWalletTransferBubbleView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-1, AIOUtils.b(25.0F, (Resources)localObject1)));
    paramView.addView((View)localObject3);
    localObject1 = this.ax.iterator();
    bool = false;
    while (((Iterator)localObject1).hasNext())
    {
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject1).next();
      if ((localAbsStructMsgElement instanceof StructMsgItemCover))
      {
        a(paramContext, localAbsStructMsgElement, paramBundle, (ViewGroup)localObject2);
        bool = true;
      }
    }
    k = this.ax.size();
    i = j;
    while (i < k)
    {
      localObject1 = (AbsStructMsgElement)this.ax.get(i);
      if ((localObject1 instanceof StructMsgItemTitle)) {
        b(paramContext, (AbsStructMsgElement)localObject1, paramBundle, (ViewGroup)localObject2, bool);
      } else if ((localObject1 instanceof StructMsgItemSummary)) {
        a(paramContext, (AbsStructMsgElement)localObject1, paramBundle, (ViewGroup)localObject2, bool);
      } else if ((localObject1 instanceof StructMsgItemRemark)) {
        a(paramContext, (AbsStructMsgElement)localObject1, paramBundle, (QQWalletTransferBubbleView)localObject3);
      }
      i += 1;
    }
    return paramView;
  }
  
  protected int c()
  {
    return 19;
  }
  
  public String e()
  {
    return "Layout19";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout19
 * JD-Core Version:    0.7.0.1
 */