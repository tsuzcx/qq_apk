package com.tencent.mobileqq.structmsg.view;

import android.text.TextUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemTd
  extends AbsStructMsgTextElement
{
  public boolean c;
  public boolean d = true;
  public int e;
  public int f = 48;
  public int g = 1;
  public int h = 1;
  
  public StructMsgItemTd()
  {
    this(null);
  }
  
  public StructMsgItemTd(String paramString)
  {
    super(paramString, "td");
  }
  
  public String a()
  {
    return "td";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.h = paramObjectInput.readInt();
    this.f = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.h);
    paramObjectOutput.writeInt(this.f);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    paramXmlSerializer.attribute(null, "weight", String.valueOf(this.h));
    paramXmlSerializer.attribute(null, "align", String.valueOf(this.f));
    paramXmlSerializer.endTag(null, this.a);
    super.a(paramXmlSerializer);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    try
    {
      Object localObject = paramStructMsgNode.a("weight");
      if (localObject != null) {}
      for (int i = Integer.parseInt((String)localObject);; i = 0)
      {
        this.h = i;
        localObject = paramStructMsgNode.a("align");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split("\\|");
        HashMap localHashMap = new HashMap();
        localHashMap.put("left", Integer.valueOf(3));
        localHashMap.put("right", Integer.valueOf(5));
        localHashMap.put("top", Integer.valueOf(48));
        localHashMap.put("bottom", Integer.valueOf(80));
        localHashMap.put("center", Integer.valueOf(17));
        i = 0;
        while (i < localObject.length)
        {
          if (!TextUtils.isEmpty(localObject[i]))
          {
            String str = localObject[i].toLowerCase();
            if (localHashMap.containsKey(str))
            {
              int j = this.f;
              this.f = (((Integer)localHashMap.get(str)).intValue() | j);
            }
          }
          i += 1;
        }
      }
      return super.a(paramStructMsgNode);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.h = 1;
    }
  }
  
  public int b()
  {
    return this.g;
  }
  
  protected int c()
  {
    return 2131361927;
  }
  
  public int d()
  {
    if ((this.c) && (this.e != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int e()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTd
 * JD-Core Version:    0.7.0.1
 */