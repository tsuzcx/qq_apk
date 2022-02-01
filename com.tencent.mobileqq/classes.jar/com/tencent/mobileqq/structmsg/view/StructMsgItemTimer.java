package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemTimer
  extends StructMsgItemSummary
{
  private String as;
  private String at;
  protected long c;
  protected long d;
  protected boolean d;
  protected long e;
  protected int q;
  protected int r;
  
  public StructMsgItemTimer()
  {
    this.a = "timer";
  }
  
  private long a()
  {
    boolean bool = this.jdField_d_of_type_Boolean;
    long l1 = 0L;
    if (!bool)
    {
      l1 = MessageCache.a();
      long l2 = this.c;
      int i = this.q;
      l1 = l2 + i - l1;
      if (l1 < 0L)
      {
        this.jdField_d_of_type_Boolean = true;
        return 0L;
      }
      if (l1 > 0L)
      {
        if (l1 >= i) {
          return i;
        }
      }
      else {
        this.jdField_d_of_type_Boolean = true;
      }
    }
    return l1;
  }
  
  private SpannableStringBuilder a(long paramLong)
  {
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-91585);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.as);
    localSpannableStringBuilder.append('\n');
    if (paramLong > 0L)
    {
      int i = localSpannableStringBuilder.length();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(paramLong));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131714407));
      localObject = ((StringBuilder)localObject).toString();
      localSpannableStringBuilder.append((CharSequence)localObject);
      localSpannableStringBuilder.append(this.ai);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan, i, ((String)localObject).length() + i, 33);
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(this.at);
    return localSpannableStringBuilder;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof CountdownTextView)))
    {
      paramContext = (CountdownTextView)paramView;
      paramContext.a(a(), new StructMsgItemTimer.1(this, paramContext));
      paramContext.setTag(this);
      return paramContext;
    }
    paramContext = new CountdownTextView(paramContext);
    paramContext.setId(2131379601);
    paramContext.setTag(this);
    paramContext.setMaxLines(3);
    paramContext.setTextColor(-10987432);
    paramContext.setTextSize(2, 12.0F);
    long l = a();
    if (this.ai != null) {
      paramContext.setText(a(l));
    }
    paramContext.a(l, new StructMsgItemTimer.2(this, paramContext));
    return paramContext;
  }
  
  public String a()
  {
    return "Timer";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.as = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.at = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.c = paramObjectInput.readLong();
    this.q = paramObjectInput.readInt();
    this.r = paramObjectInput.readInt();
    this.jdField_d_of_type_Long = paramObjectInput.readLong();
    this.e = paramObjectInput.readLong();
    this.jdField_d_of_type_Boolean = paramObjectInput.readBoolean();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.as;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.at;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    paramObjectOutput.writeLong(this.c);
    paramObjectOutput.writeInt(this.q);
    paramObjectOutput.writeInt(this.r);
    paramObjectOutput.writeLong(this.jdField_d_of_type_Long);
    paramObjectOutput.writeLong(this.e);
    paramObjectOutput.writeBoolean(this.jdField_d_of_type_Boolean);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "timer");
    paramXmlSerializer.attribute(null, "st", String.valueOf(this.c));
    paramXmlSerializer.attribute(null, "dr", String.valueOf(this.q));
    paramXmlSerializer.attribute(null, "index", String.valueOf(this.r));
    if (!TextUtils.isEmpty(this.as)) {
      paramXmlSerializer.attribute(null, "summary", this.as);
    }
    if (!TextUtils.isEmpty(this.at)) {
      paramXmlSerializer.attribute(null, "ending", this.at);
    }
    paramXmlSerializer.text(this.ai);
    paramXmlSerializer.endTag(null, "timer");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.c = StructMsgUtils.a(paramStructMsgNode.a("st"));
    this.q = StructMsgUtils.a(paramStructMsgNode.a("dr"));
    this.r = StructMsgUtils.a(paramStructMsgNode.a("index"));
    this.as = MessageUtils.a(paramStructMsgNode.a("summary"), false);
    this.at = MessageUtils.a(paramStructMsgNode.a("st"), false);
    this.ai = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTimer
 * JD-Core Version:    0.7.0.1
 */