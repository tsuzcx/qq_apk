package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle.TitleTextView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgTextElement
  extends AbsStructMsgElement
  implements View.OnClickListener
{
  private static int aM = 11;
  public String aA;
  protected String aB;
  protected String aC;
  protected String aD;
  protected boolean aE = false;
  protected boolean aF = false;
  public String aG;
  protected String au;
  protected String av;
  protected String aw;
  protected String ax;
  protected String ay;
  protected String az;
  
  public AbsStructMsgTextElement()
  {
    this.a = aM;
  }
  
  public AbsStructMsgTextElement(String paramString1, String paramString2)
  {
    this.a = aM;
    this.b = paramString2;
    this.aA = paramString1;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && (c().isInstance(paramView)))
    {
      paramView = (TextView)paramView;
    }
    else
    {
      paramView = a(paramContext);
      paramView.setId(f());
    }
    paramView.setTag(this);
    if (this.aF) {
      paramView.setSingleLine(true);
    } else if (!this.aE) {
      paramView.setMaxLines(d());
    }
    if ((this.aF) || (!this.aE)) {
      paramView.setEllipsize(g());
    }
    paramContext = a(paramContext.getResources());
    if (paramContext != null)
    {
      paramView.setTextColor(paramContext.a);
      paramView.requestLayout();
      paramView.setTypeface(Typeface.DEFAULT, paramContext.b);
      paramView.setTextSize(paramContext.c);
      paramView.setLineSpacing(AIOUtils.b(h() * 1.0F / 2.0F, paramView.getResources()), 1.0F);
      if (paramContext.h == true) {
        paramView.getPaint().setFlags(8);
      }
      if (paramContext.j == true) {
        paramView.getPaint().setFlags(16);
      }
      boolean bool = false;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("pre_dialog", false);
      }
      if ((bool) && (!TextUtils.isEmpty(this.aG))) {
        paramContext.e = this.aG;
      }
      if ((paramContext.i != null) && (!paramContext.i.equals("")) && (paramContext.i.trim().equals("1")))
      {
        paramView.setText(Html.fromHtml(paramContext.e));
        return paramView;
      }
      paramView.setText(paramContext.e);
      return paramView;
    }
    paramView.setText("");
    return paramView;
  }
  
  public TextView a(Context paramContext)
  {
    if (StructMsgItemTitle.TitleTextView.class.isAssignableFrom(c())) {
      return new StructMsgItemTitle.TitleTextView(paramContext);
    }
    return new EllipsizingTextView(paramContext, null);
  }
  
  public AbsStructMsgTextElement.RichText a(Resources paramResources)
  {
    paramResources = new AbsStructMsgTextElement.RichText();
    try
    {
      if (!TextUtils.isEmpty(this.av))
      {
        paramResources.a = Color.parseColor(this.av);
      }
      else
      {
        if (TextUtils.isEmpty(this.au)) {
          i = i();
        } else {
          i = Color.parseColor(this.au);
        }
        paramResources.a = i;
      }
    }
    catch (Exception localException1)
    {
      int i;
      label66:
      break label66;
    }
    paramResources.a = i();
    label136:
    try
    {
      if (TextUtils.isEmpty(this.aw)) {
        i = n();
      } else {
        i = Integer.parseInt(this.aw);
      }
      paramResources.b = i;
    }
    catch (Exception localException2)
    {
      label105:
      break label105;
    }
    try
    {
      if (TextUtils.isEmpty(this.aB)) {
        i = 0;
      } else {
        i = Integer.parseInt(this.aB);
      }
      paramResources.d = i;
    }
    catch (Exception localException3)
    {
      break label136;
    }
    paramResources.d = 0;
    paramResources.h = false;
    if ((paramResources.b < 0) || (paramResources.b >= 4))
    {
      if (paramResources.b == 4) {
        paramResources.h = true;
      } else if (paramResources.b == 5) {
        paramResources.j = true;
      }
      paramResources.b = n();
    }
    try
    {
      if (!TextUtils.isEmpty(this.ay))
      {
        paramResources.c = Integer.parseInt(this.ay);
      }
      else
      {
        if (TextUtils.isEmpty(this.ax)) {
          i = j();
        } else {
          i = Integer.parseInt(this.ax);
        }
        paramResources.c = i;
      }
    }
    catch (Exception localException4)
    {
      label253:
      break label253;
    }
    if (paramResources.c < 1) {
      paramResources.c = j();
    }
    paramResources.c /= 2;
    if (TextUtils.isEmpty(e())) {
      return null;
    }
    paramResources.e = e();
    paramResources.i = this.az;
    return paramResources;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (this.a == 1)
    {
      this.aA = MessageUtils.a(paramObjectInput.readUTF(), false);
      return;
    }
    if (this.a == 2)
    {
      this.au = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.aw = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ax = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.aA = MessageUtils.a(paramObjectInput.readUTF(), false);
      return;
    }
    if (this.a == 3)
    {
      this.au = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.aw = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ax = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.aA = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.az = MessageUtils.a(paramObjectInput.readUTF(), false);
      return;
    }
    if (this.a >= 4)
    {
      this.au = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.aw = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ax = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.aA = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.az = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.aB = MessageUtils.a(paramObjectInput.readUTF(), false);
      if (this.a >= 11)
      {
        this.aC = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.aD = MessageUtils.a(paramObjectInput.readUTF(), false);
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    int i = this.a;
    Object localObject1 = "";
    Object localObject2;
    if (i == 1)
    {
      localObject2 = this.aA;
      if (localObject2 != null) {
        localObject1 = MessageUtils.a((String)localObject2, false);
      }
      paramObjectOutput.writeUTF((String)localObject1);
      return;
    }
    if (this.a == 2)
    {
      String str = this.au;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      paramObjectOutput.writeUTF((String)localObject2);
      str = this.aw;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      paramObjectOutput.writeUTF((String)localObject2);
      str = this.ax;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      paramObjectOutput.writeUTF((String)localObject2);
      localObject2 = this.aA;
      if (localObject2 != null) {
        localObject1 = MessageUtils.a((String)localObject2, false);
      }
      paramObjectOutput.writeUTF((String)localObject1);
      return;
    }
    if (this.a == 3)
    {
      localObject2 = this.au;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.aw;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.ax;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject1 = this.aA;
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = MessageUtils.a((String)localObject1, false);
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.az;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      return;
    }
    if (this.a >= 4)
    {
      localObject2 = this.au;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.aw;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.ax;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject1 = this.aA;
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = MessageUtils.a((String)localObject1, false);
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.az;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.aB;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      if (this.a >= 11)
      {
        localObject2 = this.aC;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
        localObject2 = this.aD;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
      }
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.b);
    if (this.aA != null)
    {
      if (!TextUtils.isEmpty(this.ax)) {
        paramXmlSerializer.attribute(null, "size", this.ax);
      }
      if (!TextUtils.isEmpty(this.au)) {
        paramXmlSerializer.attribute(null, "color", this.au);
      }
      if (!TextUtils.isEmpty(this.aw)) {
        paramXmlSerializer.attribute(null, "style", this.aw);
      }
      if (!TextUtils.isEmpty(this.az)) {
        paramXmlSerializer.attribute(null, "html", this.az);
      }
      if (!TextUtils.isEmpty(this.aB)) {
        paramXmlSerializer.attribute(null, "type", this.aB);
      }
      if (!TextUtils.isEmpty(this.aC)) {
        paramXmlSerializer.attribute(null, "maxLines", this.aC);
      }
      if (!TextUtils.isEmpty(this.aD)) {
        paramXmlSerializer.attribute(null, "lineSpace", this.aD);
      }
      paramXmlSerializer.text(this.aA);
    }
    paramXmlSerializer.endTag(null, this.b);
  }
  
  public void a(boolean paramBoolean)
  {
    this.aF = paramBoolean;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.au = paramStructMsgNode.a("color");
    this.aw = paramStructMsgNode.a("style");
    this.ax = paramStructMsgNode.a("size");
    this.aA = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    this.az = paramStructMsgNode.a("html");
    this.aB = paramStructMsgNode.a("type");
    this.aC = paramStructMsgNode.a("maxLines");
    this.aD = paramStructMsgNode.a("lineSpace");
    return true;
  }
  
  public void b(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      this.aA = StringUtil.toDBC(paramString);
      return;
    }
    this.aA = paramString;
  }
  
  protected Class<? extends TextView> c()
  {
    return TextView.class;
  }
  
  public void c(String paramString)
  {
    this.av = paramString;
  }
  
  public int d()
  {
    if (!TextUtils.isEmpty(this.aC)) {}
    try
    {
      int i = Integer.parseInt(this.aC);
      return i;
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    return 2;
  }
  
  public void d(String paramString)
  {
    this.ay = paramString;
  }
  
  public String e()
  {
    String str2 = this.aA;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.aA = str1;
    return this.aA;
  }
  
  public void e(String paramString)
  {
    this.aG = paramString;
  }
  
  protected abstract int f();
  
  public void f(String paramString)
  {
    this.au = paramString;
  }
  
  protected TextUtils.TruncateAt g()
  {
    return TextUtils.TruncateAt.END;
  }
  
  public void g(String paramString)
  {
    this.ax = paramString;
  }
  
  protected int h()
  {
    if (!TextUtils.isEmpty(this.aD)) {}
    try
    {
      int i = Integer.parseInt(this.aD);
      return i;
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    return 0;
  }
  
  public void h(String paramString)
  {
    this.aD = paramString;
  }
  
  public int i()
  {
    return -16777216;
  }
  
  public void i(String paramString)
  {
    this.aC = paramString;
  }
  
  public int j()
  {
    return 26;
  }
  
  public String k()
  {
    return this.ax;
  }
  
  public String l()
  {
    return this.au;
  }
  
  public String m()
  {
    return this.aw;
  }
  
  public int n()
  {
    return 0;
  }
  
  public void o()
  {
    this.aE = true;
  }
  
  public String p()
  {
    return this.aB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgTextElement
 * JD-Core Version:    0.7.0.1
 */