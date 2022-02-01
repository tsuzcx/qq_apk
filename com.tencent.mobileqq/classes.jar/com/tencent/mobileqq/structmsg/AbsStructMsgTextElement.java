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
  private static int o = 11;
  protected boolean a;
  protected String ac;
  protected String ad;
  protected String ae;
  protected String af;
  protected String ag;
  protected String ah;
  public String ai;
  protected String aj;
  protected String ak;
  protected String al;
  public String am;
  protected boolean b;
  
  public AbsStructMsgTextElement()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = o;
  }
  
  public AbsStructMsgTextElement(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = o;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.ai = paramString1;
  }
  
  protected TextUtils.TruncateAt a()
  {
    return TextUtils.TruncateAt.END;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && (a().isInstance(paramView)))
    {
      paramView = (TextView)paramView;
    }
    else
    {
      paramView = a(paramContext);
      paramView.setId(c());
    }
    paramView.setTag(this);
    if (this.jdField_b_of_type_Boolean) {
      paramView.setSingleLine(true);
    } else if (!this.jdField_a_of_type_Boolean) {
      paramView.setMaxLines(b());
    }
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
      paramView.setEllipsize(a());
    }
    paramContext = a(paramContext.getResources());
    if (paramContext != null)
    {
      paramView.setTextColor(paramContext.jdField_a_of_type_Int);
      paramView.requestLayout();
      paramView.setTypeface(Typeface.DEFAULT, paramContext.jdField_b_of_type_Int);
      paramView.setTextSize(paramContext.c);
      paramView.setLineSpacing(AIOUtils.b(d() * 1.0F / 2.0F, paramView.getResources()), 1.0F);
      if (paramContext.jdField_a_of_type_Boolean == true) {
        paramView.getPaint().setFlags(8);
      }
      if (paramContext.jdField_b_of_type_Boolean == true) {
        paramView.getPaint().setFlags(16);
      }
      boolean bool = false;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("pre_dialog", false);
      }
      if ((bool) && (!TextUtils.isEmpty(this.am))) {
        paramContext.jdField_a_of_type_JavaLangString = this.am;
      }
      if ((paramContext.jdField_b_of_type_JavaLangString != null) && (!paramContext.jdField_b_of_type_JavaLangString.equals("")) && (paramContext.jdField_b_of_type_JavaLangString.trim().equals("1")))
      {
        paramView.setText(Html.fromHtml(paramContext.jdField_a_of_type_JavaLangString));
        return paramView;
      }
      paramView.setText(paramContext.jdField_a_of_type_JavaLangString);
      return paramView;
    }
    paramView.setText("");
    return paramView;
  }
  
  public TextView a(Context paramContext)
  {
    if (StructMsgItemTitle.TitleTextView.class.isAssignableFrom(a())) {
      return new StructMsgItemTitle.TitleTextView(paramContext);
    }
    return new EllipsizingTextView(paramContext, null);
  }
  
  public AbsStructMsgTextElement.RichText a(Resources paramResources)
  {
    paramResources = new AbsStructMsgTextElement.RichText();
    try
    {
      if (!TextUtils.isEmpty(this.ad))
      {
        paramResources.jdField_a_of_type_Int = Color.parseColor(this.ad);
      }
      else
      {
        if (TextUtils.isEmpty(this.ac)) {
          i = e();
        } else {
          i = Color.parseColor(this.ac);
        }
        paramResources.jdField_a_of_type_Int = i;
      }
    }
    catch (Exception localException1)
    {
      int i;
      label66:
      break label66;
    }
    paramResources.jdField_a_of_type_Int = e();
    label136:
    try
    {
      if (TextUtils.isEmpty(this.ae)) {
        i = g();
      } else {
        i = Integer.parseInt(this.ae);
      }
      paramResources.jdField_b_of_type_Int = i;
    }
    catch (Exception localException2)
    {
      label105:
      break label105;
    }
    try
    {
      if (TextUtils.isEmpty(this.aj)) {
        i = 0;
      } else {
        i = Integer.parseInt(this.aj);
      }
      paramResources.d = i;
    }
    catch (Exception localException3)
    {
      break label136;
    }
    paramResources.d = 0;
    paramResources.jdField_a_of_type_Boolean = false;
    if ((paramResources.jdField_b_of_type_Int < 0) || (paramResources.jdField_b_of_type_Int >= 4))
    {
      if (paramResources.jdField_b_of_type_Int == 4) {
        paramResources.jdField_a_of_type_Boolean = true;
      } else if (paramResources.jdField_b_of_type_Int == 5) {
        paramResources.jdField_b_of_type_Boolean = true;
      }
      paramResources.jdField_b_of_type_Int = g();
    }
    try
    {
      if (!TextUtils.isEmpty(this.ag))
      {
        paramResources.c = Integer.parseInt(this.ag);
      }
      else
      {
        if (TextUtils.isEmpty(this.af)) {
          i = f();
        } else {
          i = Integer.parseInt(this.af);
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
      paramResources.c = f();
    }
    paramResources.c /= 2;
    if (TextUtils.isEmpty(b())) {
      return null;
    }
    paramResources.jdField_a_of_type_JavaLangString = b();
    paramResources.jdField_b_of_type_JavaLangString = this.ah;
    return paramResources;
  }
  
  protected Class<? extends TextView> a()
  {
    return TextView.class;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (this.jdField_a_of_type_Int == 1)
    {
      this.ai = MessageUtils.a(paramObjectInput.readUTF(), false);
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      this.ac = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ae = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.af = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ai = MessageUtils.a(paramObjectInput.readUTF(), false);
      return;
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      this.ac = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ae = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.af = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ai = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ah = MessageUtils.a(paramObjectInput.readUTF(), false);
      return;
    }
    if (this.jdField_a_of_type_Int >= 4)
    {
      this.ac = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ae = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.af = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ai = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.ah = MessageUtils.a(paramObjectInput.readUTF(), false);
      this.aj = MessageUtils.a(paramObjectInput.readUTF(), false);
      if (this.jdField_a_of_type_Int >= 11)
      {
        this.ak = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.al = MessageUtils.a(paramObjectInput.readUTF(), false);
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    int i = this.jdField_a_of_type_Int;
    Object localObject1 = "";
    Object localObject2;
    if (i == 1)
    {
      localObject2 = this.ai;
      if (localObject2 != null) {
        localObject1 = MessageUtils.a((String)localObject2, false);
      }
      paramObjectOutput.writeUTF((String)localObject1);
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      String str = this.ac;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      paramObjectOutput.writeUTF((String)localObject2);
      str = this.ae;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      paramObjectOutput.writeUTF((String)localObject2);
      str = this.af;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      paramObjectOutput.writeUTF((String)localObject2);
      localObject2 = this.ai;
      if (localObject2 != null) {
        localObject1 = MessageUtils.a((String)localObject2, false);
      }
      paramObjectOutput.writeUTF((String)localObject1);
      return;
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      localObject2 = this.ac;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.ae;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.af;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject1 = this.ai;
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = MessageUtils.a((String)localObject1, false);
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.ah;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      return;
    }
    if (this.jdField_a_of_type_Int >= 4)
    {
      localObject2 = this.ac;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.ae;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.af;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject1 = this.ai;
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = MessageUtils.a((String)localObject1, false);
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.ah;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      localObject2 = this.aj;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramObjectOutput.writeUTF((String)localObject1);
      if (this.jdField_a_of_type_Int >= 11)
      {
        localObject2 = this.ak;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
        localObject2 = this.al;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      this.ai = StringUtil.f(paramString);
      return;
    }
    this.ai = paramString;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.ai != null)
    {
      if (!TextUtils.isEmpty(this.af)) {
        paramXmlSerializer.attribute(null, "size", this.af);
      }
      if (!TextUtils.isEmpty(this.ac)) {
        paramXmlSerializer.attribute(null, "color", this.ac);
      }
      if (!TextUtils.isEmpty(this.ae)) {
        paramXmlSerializer.attribute(null, "style", this.ae);
      }
      if (!TextUtils.isEmpty(this.ah)) {
        paramXmlSerializer.attribute(null, "html", this.ah);
      }
      if (!TextUtils.isEmpty(this.aj)) {
        paramXmlSerializer.attribute(null, "type", this.aj);
      }
      if (!TextUtils.isEmpty(this.ak)) {
        paramXmlSerializer.attribute(null, "maxLines", this.ak);
      }
      if (!TextUtils.isEmpty(this.al)) {
        paramXmlSerializer.attribute(null, "lineSpace", this.al);
      }
      paramXmlSerializer.text(this.ai);
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.ac = paramStructMsgNode.a("color");
    this.ae = paramStructMsgNode.a("style");
    this.af = paramStructMsgNode.a("size");
    this.ai = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    this.ah = paramStructMsgNode.a("html");
    this.aj = paramStructMsgNode.a("type");
    this.ak = paramStructMsgNode.a("maxLines");
    this.al = paramStructMsgNode.a("lineSpace");
    return true;
  }
  
  public int b()
  {
    if (!TextUtils.isEmpty(this.ak)) {}
    try
    {
      int i = Integer.parseInt(this.ak);
      return i;
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    return 2;
  }
  
  public String b()
  {
    String str2 = this.ai;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ai = str1;
    return this.ai;
  }
  
  public void b(String paramString)
  {
    this.ad = paramString;
  }
  
  protected abstract int c();
  
  public String c()
  {
    return this.af;
  }
  
  public void c(String paramString)
  {
    this.ag = paramString;
  }
  
  protected int d()
  {
    if (!TextUtils.isEmpty(this.al)) {}
    try
    {
      int i = Integer.parseInt(this.al);
      return i;
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    return 0;
  }
  
  public String d()
  {
    return this.ac;
  }
  
  public void d(String paramString)
  {
    this.am = paramString;
  }
  
  public int e()
  {
    return -16777216;
  }
  
  public String e()
  {
    return this.ae;
  }
  
  public void e(String paramString)
  {
    this.ac = paramString;
  }
  
  public int f()
  {
    return 26;
  }
  
  public String f()
  {
    return this.aj;
  }
  
  public void f(String paramString)
  {
    this.af = paramString;
  }
  
  public int g()
  {
    return 0;
  }
  
  public void g(String paramString)
  {
    this.al = paramString;
  }
  
  public void h(String paramString)
  {
    this.ak = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgTextElement
 * JD-Core Version:    0.7.0.1
 */