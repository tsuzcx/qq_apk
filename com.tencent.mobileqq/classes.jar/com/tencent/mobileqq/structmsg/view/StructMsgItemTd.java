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
  public int aM = 0;
  public boolean aN = false;
  public boolean aO = true;
  public int aP = 48;
  public int aQ = 1;
  public int aR = 1;
  
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
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.aR = paramObjectInput.readInt();
    this.aP = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.aR);
    paramObjectOutput.writeInt(this.aP);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.b);
    paramXmlSerializer.attribute(null, "weight", String.valueOf(this.aR));
    paramXmlSerializer.attribute(null, "align", String.valueOf(this.aP));
    paramXmlSerializer.endTag(null, this.b);
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
    this.aR = i;
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
            j = this.aP;
            this.aP = (((Integer)localHashMap.get(str)).intValue() | j);
          }
        }
        i += 1;
      }
      this.aR = 1;
    }
    return super.a(paramStructMsgNode);
  }
  
  public String b()
  {
    return "td";
  }
  
  public int d()
  {
    return this.aQ;
  }
  
  protected int f()
  {
    return 2131448780;
  }
  
  public int i()
  {
    if ((this.aN) && (this.aM != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int j()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTd
 * JD-Core Version:    0.7.0.1
 */