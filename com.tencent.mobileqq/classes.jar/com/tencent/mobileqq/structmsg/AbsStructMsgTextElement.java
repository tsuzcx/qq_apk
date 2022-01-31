package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle.TitleTextView;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgTextElement
  extends AbsStructMsgElement
  implements View.OnClickListener
{
  public String A;
  protected String B;
  public String C;
  protected boolean a;
  protected boolean b;
  protected String u;
  protected String v;
  protected String w;
  public String x;
  protected String y;
  protected String z;
  
  public AbsStructMsgTextElement() {}
  
  public AbsStructMsgTextElement(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.A = paramString1;
  }
  
  public TextUtils.TruncateAt a()
  {
    return TextUtils.TruncateAt.END;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = false;
    if ((paramView != null) && (a().isInstance(paramView)))
    {
      paramView = (TextView)paramView;
      paramView.setTag(this);
      if (!this.jdField_b_of_type_Boolean) {
        break label241;
      }
      paramView.setSingleLine(true);
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
        paramView.setEllipsize(a());
      }
      paramContext = a(paramContext.getResources());
      if (paramContext == null) {
        break label269;
      }
      paramView.setTextColor(paramContext.jdField_a_of_type_Int);
      paramView.requestLayout();
      paramView.setTypeface(Typeface.DEFAULT, paramContext.jdField_b_of_type_Int);
      paramView.setTextSize(paramContext.c);
      if (paramContext.jdField_a_of_type_Boolean == true) {
        paramView.getPaint().setFlags(8);
      }
      if (paramContext.jdField_b_of_type_Boolean == true) {
        paramView.getPaint().setFlags(16);
      }
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("pre_dialog", false);
      }
      if ((bool) && (!TextUtils.isEmpty(this.C))) {
        paramContext.jdField_a_of_type_JavaLangString = this.C;
      }
      if ((paramContext.jdField_b_of_type_JavaLangString == null) || (paramContext.jdField_b_of_type_JavaLangString.equals("")) || (!paramContext.jdField_b_of_type_JavaLangString.trim().equals("1"))) {
        break label259;
      }
      paramView.setText(Html.fromHtml(paramContext.jdField_a_of_type_JavaLangString));
      return paramView;
      paramView = a(paramContext);
      paramView.setId(c());
      break;
      label241:
      if (!this.jdField_a_of_type_Boolean) {
        paramView.setMaxLines(b());
      }
    }
    label259:
    paramView.setText(paramContext.jdField_a_of_type_JavaLangString);
    return paramView;
    label269:
    paramView.setText("");
    return paramView;
  }
  
  public TextView a(Context paramContext)
  {
    if (StructMsgItemTitle.TitleTextView.class.isAssignableFrom(a())) {
      return new StructMsgItemTitle.TitleTextView(paramContext);
    }
    return new TextView(paramContext);
  }
  
  /* Error */
  public AbsStructMsgTextElement.RichText a(android.content.res.Resources paramResources)
  {
    // Byte code:
    //   0: new 77	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText
    //   3: dup
    //   4: invokespecial 186	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 188	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:v	Ljava/lang/String;
    //   12: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +151 -> 166
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 188	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:v	Ljava/lang/String;
    //   23: invokestatic 194	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   26: putfield 80	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_Int	I
    //   29: aload_0
    //   30: getfield 196	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:w	Ljava/lang/String;
    //   33: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +176 -> 212
    //   39: aload_0
    //   40: invokevirtual 199	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:f	()I
    //   43: istore_2
    //   44: aload_1
    //   45: iload_2
    //   46: putfield 95	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   49: aload_0
    //   50: getfield 201	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:B	Ljava/lang/String;
    //   53: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +167 -> 223
    //   59: iconst_0
    //   60: istore_2
    //   61: aload_1
    //   62: iload_2
    //   63: putfield 204	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:d	I
    //   66: aload_1
    //   67: iconst_0
    //   68: putfield 107	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_Boolean	Z
    //   71: aload_1
    //   72: getfield 95	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   75: iflt +11 -> 86
    //   78: aload_1
    //   79: getfield 95	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   82: iconst_4
    //   83: if_icmplt +24 -> 107
    //   86: aload_1
    //   87: getfield 95	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   90: iconst_4
    //   91: if_icmpne +152 -> 243
    //   94: aload_1
    //   95: iconst_1
    //   96: putfield 107	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_Boolean	Z
    //   99: aload_1
    //   100: aload_0
    //   101: invokevirtual 199	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:f	()I
    //   104: putfield 95	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   107: aload_0
    //   108: getfield 206	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:y	Ljava/lang/String;
    //   111: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +145 -> 259
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 206	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:y	Ljava/lang/String;
    //   122: invokestatic 211	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   125: putfield 102	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   128: aload_1
    //   129: getfield 102	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   132: iconst_1
    //   133: if_icmpge +11 -> 144
    //   136: aload_1
    //   137: aload_0
    //   138: invokevirtual 214	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:e	()I
    //   141: putfield 102	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   144: aload_1
    //   145: aload_1
    //   146: getfield 102	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   149: iconst_2
    //   150: idiv
    //   151: putfield 102	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   154: aload_0
    //   155: invokevirtual 216	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:b	()Ljava/lang/String;
    //   158: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifeq +132 -> 293
    //   164: aconst_null
    //   165: areturn
    //   166: aload_0
    //   167: getfield 218	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:u	Ljava/lang/String;
    //   170: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifeq +28 -> 201
    //   176: aload_0
    //   177: invokevirtual 220	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:d	()I
    //   180: istore_2
    //   181: aload_1
    //   182: iload_2
    //   183: putfield 80	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_Int	I
    //   186: goto -157 -> 29
    //   189: astore_3
    //   190: aload_1
    //   191: aload_0
    //   192: invokevirtual 220	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:d	()I
    //   195: putfield 80	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_Int	I
    //   198: goto -169 -> 29
    //   201: aload_0
    //   202: getfield 218	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:u	Ljava/lang/String;
    //   205: invokestatic 194	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   208: istore_2
    //   209: goto -28 -> 181
    //   212: aload_0
    //   213: getfield 196	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:w	Ljava/lang/String;
    //   216: invokestatic 211	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   219: istore_2
    //   220: goto -176 -> 44
    //   223: aload_0
    //   224: getfield 201	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:B	Ljava/lang/String;
    //   227: invokestatic 211	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   230: istore_2
    //   231: goto -170 -> 61
    //   234: astore_3
    //   235: aload_1
    //   236: iconst_0
    //   237: putfield 204	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:d	I
    //   240: goto -174 -> 66
    //   243: aload_1
    //   244: getfield 95	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   247: iconst_5
    //   248: if_icmpne -149 -> 99
    //   251: aload_1
    //   252: iconst_1
    //   253: putfield 117	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Boolean	Z
    //   256: goto -157 -> 99
    //   259: aload_0
    //   260: getfield 222	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:x	Ljava/lang/String;
    //   263: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifeq +16 -> 282
    //   269: aload_0
    //   270: invokevirtual 214	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:e	()I
    //   273: istore_2
    //   274: aload_1
    //   275: iload_2
    //   276: putfield 102	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   279: goto -151 -> 128
    //   282: aload_0
    //   283: getfield 222	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:x	Ljava/lang/String;
    //   286: invokestatic 211	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   289: istore_2
    //   290: goto -16 -> 274
    //   293: aload_1
    //   294: aload_0
    //   295: invokevirtual 216	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:b	()Ljava/lang/String;
    //   298: putfield 134	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   301: aload_1
    //   302: aload_0
    //   303: getfield 224	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:z	Ljava/lang/String;
    //   306: putfield 136	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   309: aload_1
    //   310: areturn
    //   311: astore_3
    //   312: goto -263 -> 49
    //   315: astore_3
    //   316: goto -188 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	AbsStructMsgTextElement
    //   0	319	1	paramResources	android.content.res.Resources
    //   43	247	2	i	int
    //   189	1	3	localException1	java.lang.Exception
    //   234	1	3	localException2	java.lang.Exception
    //   311	1	3	localException3	java.lang.Exception
    //   315	1	3	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   8	29	189	java/lang/Exception
    //   166	181	189	java/lang/Exception
    //   181	186	189	java/lang/Exception
    //   201	209	189	java/lang/Exception
    //   49	59	234	java/lang/Exception
    //   61	66	234	java/lang/Exception
    //   223	231	234	java/lang/Exception
    //   29	44	311	java/lang/Exception
    //   44	49	311	java/lang/Exception
    //   212	220	311	java/lang/Exception
    //   107	128	315	java/lang/Exception
    //   259	274	315	java/lang/Exception
    //   274	279	315	java/lang/Exception
    //   282	290	315	java/lang/Exception
  }
  
  public Class a()
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
    if (this.jdField_a_of_type_Int == 1) {
      this.A = MessageUtils.a(paramObjectInput.readUTF(), false);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        this.u = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.w = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.x = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.A = MessageUtils.a(paramObjectInput.readUTF(), false);
        return;
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        this.u = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.w = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.x = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.A = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.z = MessageUtils.a(paramObjectInput.readUTF(), false);
        return;
      }
    } while (this.jdField_a_of_type_Int < 4);
    this.u = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.w = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.x = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.A = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.z = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.B = MessageUtils.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.jdField_a_of_type_Int == 1) {
      if (this.A == null)
      {
        str = "";
        paramObjectOutput.writeUTF(str);
      }
    }
    label78:
    label95:
    label225:
    do
    {
      return;
      str = MessageUtils.a(this.A, false);
      break;
      if (this.jdField_a_of_type_Int == 2)
      {
        if (this.u == null)
        {
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.w != null) {
            break label128;
          }
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.x != null) {
            break label136;
          }
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.A != null) {
            break label144;
          }
        }
        for (str = "";; str = MessageUtils.a(this.A, false))
        {
          paramObjectOutput.writeUTF(str);
          return;
          str = this.u;
          break;
          str = this.w;
          break label78;
          str = this.x;
          break label95;
        }
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        if (this.u == null)
        {
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.w != null) {
            break label258;
          }
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.x != null) {
            break label266;
          }
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.A != null) {
            break label274;
          }
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.z != null) {
            break label286;
          }
        }
        for (str = "";; str = this.z)
        {
          paramObjectOutput.writeUTF(str);
          return;
          str = this.u;
          break;
          str = this.w;
          break label191;
          str = this.x;
          break label208;
          str = MessageUtils.a(this.A, false);
          break label225;
        }
      }
    } while (this.jdField_a_of_type_Int < 4);
    label128:
    label136:
    label144:
    label191:
    label208:
    if (this.u == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.w != null) {
        break label413;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.x != null) {
        break label421;
      }
      str = "";
      label346:
      paramObjectOutput.writeUTF(str);
      if (this.A != null) {
        break label429;
      }
      str = "";
      label363:
      paramObjectOutput.writeUTF(str);
      if (this.z != null) {
        break label441;
      }
      str = "";
      label380:
      paramObjectOutput.writeUTF(str);
      if (this.B != null) {
        break label449;
      }
    }
    label258:
    label266:
    label274:
    label286:
    label329:
    for (String str = "";; str = this.B)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.u;
      break;
      str = this.w;
      break label329;
      str = this.x;
      break label346;
      str = MessageUtils.a(this.A, false);
      break label363;
      str = this.z;
      break label380;
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      this.A = paramString;
      return;
    }
    this.A = StringUtil.f(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.A != null)
    {
      if (!TextUtils.isEmpty(this.x)) {
        paramXmlSerializer.attribute(null, "size", this.x);
      }
      if (!TextUtils.isEmpty(this.u)) {
        paramXmlSerializer.attribute(null, "color", this.u);
      }
      if (!TextUtils.isEmpty(this.w)) {
        paramXmlSerializer.attribute(null, "style", this.w);
      }
      paramXmlSerializer.text(this.A);
      if (!TextUtils.isEmpty(this.z)) {
        paramXmlSerializer.attribute(null, "html", this.z);
      }
      if (!TextUtils.isEmpty(this.B)) {
        paramXmlSerializer.attribute(null, "type", this.B);
      }
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
    this.u = paramStructMsgNode.a("color");
    this.w = paramStructMsgNode.a("style");
    this.x = paramStructMsgNode.a("size");
    this.A = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    this.z = paramStructMsgNode.a("html");
    this.B = paramStructMsgNode.a("type");
    return true;
  }
  
  public int b()
  {
    return 2;
  }
  
  public String b()
  {
    if (this.A == null) {}
    for (String str = "";; str = this.A)
    {
      this.A = str;
      return this.A;
    }
  }
  
  public void b(String paramString)
  {
    this.v = paramString;
  }
  
  public abstract int c();
  
  public String c()
  {
    return this.x;
  }
  
  public void c(String paramString)
  {
    this.y = paramString;
  }
  
  public int d()
  {
    return -16777216;
  }
  
  public String d()
  {
    return this.u;
  }
  
  public void d(String paramString)
  {
    this.C = paramString;
  }
  
  public int e()
  {
    return 26;
  }
  
  public String e()
  {
    return this.w;
  }
  
  public int f()
  {
    return 0;
  }
  
  public String f()
  {
    return this.B;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgTextElement
 * JD-Core Version:    0.7.0.1
 */