package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemTd
  extends AbsStructMsgTextElement
{
  public boolean c = false;
  public boolean d = true;
  public int o = 0;
  public int p = 48;
  public int q = 1;
  public int r = 1;
  
  public StructMsgItemTd()
  {
    this(null);
  }
  
  public StructMsgItemTd(String paramString)
  {
    super(paramString, "td");
  }
  
  public TextView a(Context paramContext)
  {
    return new TextView(paramContext);
  }
  
  public String a()
  {
    return "td";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.r = paramObjectInput.readInt();
    this.p = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.r);
    paramObjectOutput.writeInt(this.p);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    paramXmlSerializer.attribute(null, "weight", String.valueOf(this.r));
    paramXmlSerializer.attribute(null, "align", String.valueOf(this.p));
    paramXmlSerializer.endTag(null, this.a);
    super.a(paramXmlSerializer);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    try
    {
      localObject = paramStructMsgNode.a("weight");
      j = 0;
      if (localObject == null) {
        break label211;
      }
      i = Integer.parseInt((String)localObject);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Object localObject;
        int j;
        HashMap localHashMap;
        continue;
        label211:
        int i = 0;
      }
    }
    this.r = i;
    localObject = paramStructMsgNode.a("align");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      localHashMap = new HashMap();
      localHashMap.put("left", Integer.valueOf(3));
      localHashMap.put("right", Integer.valueOf(5));
      localHashMap.put("top", Integer.valueOf(48));
      localHashMap.put("bottom", Integer.valueOf(80));
      localHashMap.put("center", Integer.valueOf(17));
      i = j;
      while (i < localObject.length)
      {
        if (!TextUtils.isEmpty(localObject[i]))
        {
          String str = localObject[i].toLowerCase();
          if (localHashMap.containsKey(str))
          {
            j = this.p;
            this.p = (((Integer)localHashMap.get(str)).intValue() | j);
          }
        }
        i += 1;
      }
      this.r = 1;
    }
    return super.a(paramStructMsgNode);
  }
  
  public int b()
  {
    return this.q;
  }
  
  protected int c()
  {
    return 2131379906;
  }
  
  public int e()
  {
    if ((this.c) && (this.o != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int f()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTd
 * JD-Core Version:    0.7.0.1
 */