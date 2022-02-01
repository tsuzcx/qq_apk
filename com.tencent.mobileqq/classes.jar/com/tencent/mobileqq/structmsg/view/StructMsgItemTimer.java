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
  protected long aP;
  protected int aQ;
  protected int aR;
  protected long aS;
  protected long aT;
  protected boolean aU;
  private String aV;
  private String aW;
  
  public StructMsgItemTimer()
  {
    this.b = "timer";
  }
  
  private SpannableStringBuilder a(long paramLong)
  {
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-91585);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.aV);
    localSpannableStringBuilder.append('\n');
    if (paramLong > 0L)
    {
      int i = localSpannableStringBuilder.length();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(paramLong));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131911918));
      localObject = ((StringBuilder)localObject).toString();
      localSpannableStringBuilder.append((CharSequence)localObject);
      localSpannableStringBuilder.append(this.aA);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan, i, ((String)localObject).length() + i, 33);
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(this.aW);
    return localSpannableStringBuilder;
  }
  
  private long q()
  {
    boolean bool = this.aU;
    long l1 = 0L;
    if (!bool)
    {
      l1 = MessageCache.c();
      long l2 = this.aP;
      int i = this.aQ;
      l1 = l2 + i - l1;
      if (l1 < 0L)
      {
        this.aU = true;
        return 0L;
      }
      if (l1 > 0L)
      {
        if (l1 >= i) {
          return i;
        }
      }
      else {
        this.aU = true;
      }
    }
    return l1;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof CountdownTextView)))
    {
      paramContext = (CountdownTextView)paramView;
      paramContext.a(q(), new StructMsgItemTimer.1(this, paramContext));
      paramContext.setTag(this);
      return paramContext;
    }
    paramContext = new CountdownTextView(paramContext);
    paramContext.setId(2131448360);
    paramContext.setTag(this);
    paramContext.setMaxLines(3);
    paramContext.setTextColor(-10987432);
    paramContext.setTextSize(2, 12.0F);
    long l = q();
    if (this.aA != null) {
      paramContext.setText(a(l));
    }
    paramContext.a(l, new StructMsgItemTimer.2(this, paramContext));
    return paramContext;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.aV = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.aW = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.aP = paramObjectInput.readLong();
    this.aQ = paramObjectInput.readInt();
    this.aR = paramObjectInput.readInt();
    this.aS = paramObjectInput.readLong();
    this.aT = paramObjectInput.readLong();
    this.aU = paramObjectInput.readBoolean();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.aV;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.aW;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    paramObjectOutput.writeLong(this.aP);
    paramObjectOutput.writeInt(this.aQ);
    paramObjectOutput.writeInt(this.aR);
    paramObjectOutput.writeLong(this.aS);
    paramObjectOutput.writeLong(this.aT);
    paramObjectOutput.writeBoolean(this.aU);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "timer");
    paramXmlSerializer.attribute(null, "st", String.valueOf(this.aP));
    paramXmlSerializer.attribute(null, "dr", String.valueOf(this.aQ));
    paramXmlSerializer.attribute(null, "index", String.valueOf(this.aR));
    if (!TextUtils.isEmpty(this.aV)) {
      paramXmlSerializer.attribute(null, "summary", this.aV);
    }
    if (!TextUtils.isEmpty(this.aW)) {
      paramXmlSerializer.attribute(null, "ending", this.aW);
    }
    paramXmlSerializer.text(this.aA);
    paramXmlSerializer.endTag(null, "timer");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.aP = StructMsgUtils.b(paramStructMsgNode.a("st"));
    this.aQ = StructMsgUtils.a(paramStructMsgNode.a("dr"));
    this.aR = StructMsgUtils.a(paramStructMsgNode.a("index"));
    this.aV = MessageUtils.a(paramStructMsgNode.a("summary"), false);
    this.aW = MessageUtils.a(paramStructMsgNode.a("st"), false);
    this.aA = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
  
  public String b()
  {
    return "Timer";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTimer
 * JD-Core Version:    0.7.0.1
 */