package com.tencent.mobileqq.richstatus;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class StatusXmlHandler
  extends DefaultHandler
{
  private SparseArray<ActionInfo> a;
  private ArrayList<StateTag> b;
  private StateTag c;
  private ArrayList<Integer> d;
  private Stack<ActionInfo> e;
  private ActionInfo f;
  private ArrayList<ActionInfo> g;
  private HashMap<String, Integer> h = new HashMap();
  private StringBuilder i = new StringBuilder();
  private boolean j = false;
  
  public StatusXmlHandler()
  {
    this.h.put("StateList", Integer.valueOf(1));
    this.h.put("SubStateList", Integer.valueOf(2));
    this.h.put("RichState", Integer.valueOf(3));
    this.h.put("ActionId", Integer.valueOf(4));
    this.h.put("Display", Integer.valueOf(5));
    this.h.put("ActionName", Integer.valueOf(6));
    this.h.put("Describe", Integer.valueOf(7));
    this.h.put("IconURL", Integer.valueOf(8));
    this.h.put("TinyIcon", Integer.valueOf(9));
    this.h.put("Type", Integer.valueOf(10));
    this.h.put("Parameter", Integer.valueOf(11));
    this.h.put("DataURL", Integer.valueOf(12));
    this.h.put("CoverURL", Integer.valueOf(13));
    this.h.put("NativeList", Integer.valueOf(14));
    this.h.put("ListParam", Integer.valueOf(15));
    this.h.put("NativeDetail", Integer.valueOf(16));
    this.h.put("DetailParam", Integer.valueOf(17));
    this.h.put("Tags", Integer.valueOf(18));
    this.h.put("StateTag", Integer.valueOf(19));
    this.h.put("TagName", Integer.valueOf(20));
    this.h.put("IdList", Integer.valueOf(21));
    this.h.put("Action_id", Integer.valueOf(22));
  }
  
  public SparseArray<ActionInfo> a()
  {
    return this.a;
  }
  
  public ArrayList<StateTag> b()
  {
    return this.b;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.j) {
      this.i.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void endDocument()
  {
    super.endDocument();
    int k = 0;
    while (k < this.b.size())
    {
      Object localObject = (StateTag)this.b.get(k);
      if (((StateTag)localObject).b != null)
      {
        localObject = ((StateTag)localObject).b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          int m = ((Integer)((Iterator)localObject).next()).intValue();
          ActionInfo localActionInfo = (ActionInfo)this.a.get(m);
          if ((localActionInfo != null) && (localActionInfo.g == 2))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("filter xml name = ");
              localStringBuilder.append(localActionInfo.e);
              QLog.d("RichStatus", 2, localStringBuilder.toString());
            }
            ((Iterator)localObject).remove();
          }
        }
      }
      k += 1;
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.j = false;
    paramString1 = this.i.toString();
    paramString2 = (Integer)this.h.get(paramString2);
    if (paramString2 == null) {
      return;
    }
    int k = paramString2.intValue();
    if (k != 20)
    {
      if (k != 22) {
        switch (k)
        {
        default: 
          return;
        case 17: 
          this.f.o = paramString1;
          return;
        case 16: 
          this.f.n = paramString1;
          return;
        case 15: 
          this.f.m = paramString1;
          return;
        case 14: 
          this.f.l = paramString1;
          return;
        case 13: 
          this.f.j = paramString1;
          return;
        case 12: 
          this.f.i = paramString1;
          return;
        case 11: 
          this.f.h = paramString1;
          return;
        case 10: 
          if ("0".equals(paramString1))
          {
            this.f.g = 4;
            return;
          }
          if ("1".equals(paramString1))
          {
            this.f.g = 3;
            return;
          }
          if ("2".equals(paramString1))
          {
            this.f.g = 2;
            return;
          }
          if (!"4".equals(paramString1)) {
            break;
          }
          this.f.g = 5;
          return;
        case 9: 
          this.f.d = paramString1;
          return;
        case 8: 
          this.f.c = paramString1;
          return;
        case 7: 
          this.f.e = paramString1;
          return;
        case 6: 
          this.f.f = paramString1;
          return;
        case 5: 
          this.f.a = Boolean.parseBoolean(paramString1);
          return;
        case 4: 
          try
          {
            this.f.b = Integer.parseInt(paramString1);
            return;
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          paramString2 = new StringBuilder();
          paramString2.append(paramString1.toString());
          paramString2.append(", ");
          paramString2.append(paramString1.getStackTrace().toString());
          QLog.d("Q.richstatus.xml", 2, paramString2.toString());
          return;
        case 3: 
          if (this.f.b == 0) {
            break;
          }
          this.a.put(this.f.b, this.f);
          if (this.f.a) {
            this.g.add(this.f);
          }
          this.f = null;
          return;
        case 1: 
        case 2: 
          this.f = ((ActionInfo)this.e.pop());
          if (this.g.size() == 0) {
            this.f.k = null;
          }
          if (this.e.size() <= 0) {
            break;
          }
          this.g = ((ActionInfo)this.e.lastElement()).k;
          return;
        }
      } else {
        this.d.add(Integer.valueOf(Integer.parseInt(paramString1)));
      }
    }
    else {
      this.c.a = paramString1;
    }
  }
  
  public void startDocument()
  {
    this.a = new SparseArray();
    this.b = new ArrayList();
    this.c = new StateTag();
    this.e = new Stack();
    this.f = new ActionInfo(-1);
    this.a.put(-1, this.f);
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.j = true;
    paramString1 = this.i;
    paramString1.replace(0, paramString1.length(), "");
    if ((!"StateList".equals(paramString2)) && (!"SubStateList".equals(paramString2)))
    {
      if ("RichState".equals(paramString2))
      {
        this.f = new ActionInfo(-1);
        return;
      }
      if ("StateTag".equals(paramString2))
      {
        this.c = new StateTag();
        this.b.add(this.c);
        return;
      }
      if ("IdList".equals(paramString2))
      {
        this.d = new ArrayList();
        this.c.b = this.d;
      }
    }
    else
    {
      this.g = new ArrayList();
      paramString1 = this.f;
      paramString1.k = this.g;
      this.e.push(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusXmlHandler
 * JD-Core Version:    0.7.0.1
 */