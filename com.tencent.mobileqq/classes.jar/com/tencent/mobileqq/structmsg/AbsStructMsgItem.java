package com.tencent.mobileqq.structmsg;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemContent;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout14;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPrice;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgItem
  extends AbsStructMsgElement
{
  public ArrayList a;
  public int e;
  public int f;
  protected int g;
  public int h;
  
  public AbsStructMsgItem()
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_h_of_type_Int = b();
  }
  
  public AbsStructMsgItem(Collection paramCollection)
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramCollection);
    this.jdField_h_of_type_Int = b();
  }
  
  private boolean b()
  {
    return (this.jdField_f_of_type_Int >= 0) && (this.jdField_f_of_type_Int <= 3);
  }
  
  public int a(Context paramContext)
  {
    return (int)(TypedValue.applyDimension(1, 10.0F, paramContext.getResources().getDisplayMetrics()) + 0.5F);
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return b(paramContext, paramView, paramBundle);
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(b()).append(this.jdField_e_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuffer.append(((AbsStructMsgElement)localIterator.next()).a());
      }
    }
    return localStringBuffer.toString();
  }
  
  public void a(View paramView)
  {
    if (!TextUtils.isEmpty(this.b)) {}
    switch (a())
    {
    default: 
      return;
    case 0: 
      paramView.setBackgroundResource(2130837918);
      return;
    case 1: 
      paramView.setBackgroundResource(2130837919);
      return;
    case 2: 
      paramView.setBackgroundResource(2130837917);
      return;
    }
    paramView.setBackgroundResource(2130837916);
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramAbsShareMsg);
    }
  }
  
  public void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if (((paramAbsStructMsgElement instanceof AbsStructMsgTextElement)) && (!b())) {
      ((AbsStructMsgTextElement)paramAbsStructMsgElement).u = null;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAbsStructMsgElement);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_a_of_type_Int = paramObjectInput.readInt();
    int k;
    int i;
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int <= 10))
    {
      this.b = paramObjectInput.readUTF();
      this.jdField_c_of_type_JavaLangString = paramObjectInput.readUTF();
      this.d = paramObjectInput.readUTF();
      this.jdField_e_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_f_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_g_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_c_of_type_Int = paramObjectInput.readInt();
      this.jdField_e_of_type_Int = paramObjectInput.readInt();
      if ((2 <= this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Int <= 10)) {
        this.jdField_f_of_type_Int = paramObjectInput.readInt();
      }
      int m = paramObjectInput.readInt();
      k = 0;
      i = 1;
      if (k < m)
      {
        str = paramObjectInput.readUTF();
        if ("item".equals(str)) {
          localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
        }
      }
    }
    for (;;)
    {
      label182:
      str = b();
      if ((str != null) && (localObject != null) && ((localObject instanceof StructMsgItemCover)))
      {
        if ((!str.endsWith("Layout4")) && (!str.endsWith("Layout2")) && (!str.endsWith("Layout9"))) {
          break label350;
        }
        ((StructMsgItemCover)localObject).j = StructMsgItemCover.jdField_g_of_type_Int;
      }
      int j;
      for (;;)
      {
        if (localObject != null)
        {
          ((AbsStructMsgElement)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          ((AbsStructMsgElement)localObject).a(paramObjectInput);
          a((AbsStructMsgElement)localObject);
        }
        k += 1;
        break;
        localObject = StructMsgElementFactory.a(str);
        j = i;
        if ("button".equals(str))
        {
          ((AbsStructMsgElement)localObject).s = String.valueOf(i);
          ((AbsStructMsgElement)localObject).t = this.t;
          j = i + 1;
        }
        if ((localObject == null) || (!AbsStructMsgItem.class.isInstance(localObject))) {
          break label528;
        }
        paramObjectInput.readInt();
        i = j;
        break label182;
        label350:
        if (str.endsWith("Layout3")) {
          ((StructMsgItemCover)localObject).j = StructMsgItemCover.jdField_h_of_type_Int;
        }
      }
      if ((this.jdField_a_of_type_Int >= 3) && (this.jdField_a_of_type_Int <= 10))
      {
        this.jdField_h_of_type_JavaLangString = paramObjectInput.readUTF();
        if (this.jdField_a_of_type_Int > 5)
        {
          this.j = paramObjectInput.readUTF();
          this.k = paramObjectInput.readUTF();
          this.l = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 8) {
          this.i = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 9)
        {
          this.n = paramObjectInput.readUTF();
          this.o = paramObjectInput.readUTF();
          this.p = paramObjectInput.readUTF();
          this.m = paramObjectInput.readUTF();
          this.q = paramObjectInput.readUTF();
        }
      }
      return;
      throw new IOException("structmsg_version_error");
      label528:
      i = j;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_h_of_type_Int);
    paramObjectOutput.writeInt(this.jdField_a_of_type_Int);
    if (this.b == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label222;
      }
      localObject = "";
      label59:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.d != null) {
        break label230;
      }
      localObject = "";
      label77:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_e_of_type_JavaLangString != null) {
        break label238;
      }
      localObject = "";
      label95:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label246;
      }
      localObject = "";
      label113:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_g_of_type_JavaLangString != null) {
        break label254;
      }
    }
    label222:
    label230:
    label238:
    label246:
    label254:
    for (Object localObject = "";; localObject = this.jdField_g_of_type_JavaLangString)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.jdField_c_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_e_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_f_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.b;
      break;
      localObject = this.jdField_c_of_type_JavaLangString;
      break label59;
      localObject = this.d;
      break label77;
      localObject = this.jdField_e_of_type_JavaLangString;
      break label95;
      localObject = this.jdField_f_of_type_JavaLangString;
      break label113;
    }
    if ((this.jdField_a_of_type_Int >= 3) && (this.jdField_a_of_type_Int <= 10))
    {
      if (this.jdField_h_of_type_JavaLangString != null) {
        break label486;
      }
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_a_of_type_Int > 5)
      {
        if (this.j != null) {
          break label494;
        }
        localObject = "";
        label316:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.k != null) {
          break label502;
        }
        localObject = "";
        label334:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.l != null) {
          break label510;
        }
        localObject = "";
        label352:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 8)
      {
        if (this.i != null) {
          break label518;
        }
        localObject = "";
        label379:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 9)
      {
        if (this.n != null) {
          break label526;
        }
        localObject = "";
        label406:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.o != null) {
          break label534;
        }
        localObject = "";
        label424:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.p != null) {
          break label542;
        }
        localObject = "";
        label442:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.m != null) {
          break label550;
        }
        localObject = "";
        label460:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.q != null) {
          break label558;
        }
      }
    }
    label518:
    label526:
    label534:
    label542:
    label550:
    label558:
    for (localObject = "";; localObject = this.q)
    {
      paramObjectOutput.writeUTF((String)localObject);
      return;
      label486:
      localObject = this.jdField_h_of_type_JavaLangString;
      break;
      label494:
      localObject = this.j;
      break label316;
      label502:
      localObject = this.k;
      break label334;
      label510:
      localObject = this.l;
      break label352;
      localObject = this.i;
      break label379;
      localObject = this.n;
      break label406;
      localObject = this.o;
      break label424;
      localObject = this.p;
      break label442;
      localObject = this.m;
      break label460;
    }
  }
  
  public void a(String paramString)
  {
    a(new StructMsgItemSummary(paramString));
    a(new StructMsgItemHr());
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_e_of_type_Int = paramInt;
    a(new StructMsgItemCover(paramString1, paramString3));
    a(new StructMsgItemTitle(""));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, 0, "0");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(paramString1, paramString2, paramString3, paramInt, "0");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.jdField_e_of_type_Int = paramInt;
    a(new StructMsgItemCover(paramString1, paramString4));
    a(new StructMsgItemTitle(paramString2));
    a(new StructMsgItemSummary(paramString3));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      a(new StructMsgItemTitle(paramString2));
    }
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      a(new StructMsgItemCover(paramString1));
    }
    if ((paramString3 != null) && (!paramString3.equals(""))) {
      a(new StructMsgItemSummary(paramString3));
    }
    if ((paramString4 != null) && (!paramString4.equals(""))) {
      a(new StructMsgItemPrice(paramString4, paramString5));
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_h_of_type_Int < 0) {}
    for (Object localObject = "0";; localObject = String.valueOf(this.jdField_h_of_type_Int))
    {
      paramXmlSerializer.attribute(null, "layout", (String)localObject);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "action", this.jdField_c_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.d)) {
        paramXmlSerializer.attribute(null, "actionData", this.d);
      }
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "a_actionData", this.jdField_e_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "i_actionData", this.jdField_f_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.b)) {
        paramXmlSerializer.attribute(null, "url", this.b);
      }
      if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "brief", this.jdField_g_of_type_JavaLangString);
      }
      if (this.jdField_c_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "flag", String.valueOf(this.jdField_c_of_type_Int));
      }
      if (this.jdField_e_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "mode", String.valueOf(this.jdField_e_of_type_Int));
      }
      if (this.jdField_f_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "bg", String.valueOf(this.jdField_f_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "businessData", this.jdField_h_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.i)) {
        paramXmlSerializer.attribute(null, "commonData", this.i);
      }
      if (!TextUtils.isEmpty(this.j)) {
        paramXmlSerializer.attribute(null, "index", this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        paramXmlSerializer.attribute(null, "index_name", this.k);
      }
      if (!TextUtils.isEmpty(this.l)) {
        paramXmlSerializer.attribute(null, "index_type", this.l);
      }
      if (!TextUtils.isEmpty(this.o)) {
        paramXmlSerializer.attribute(null, "canvas", this.o);
      }
      if (!TextUtils.isEmpty(this.m)) {
        paramXmlSerializer.attribute(null, "rurl", this.m);
      }
      if (!TextUtils.isEmpty(this.p)) {
        paramXmlSerializer.attribute(null, "disType", this.p);
      }
      if (!TextUtils.isEmpty(this.n)) {
        paramXmlSerializer.attribute(null, "tid", this.n);
      }
      if (!TextUtils.isEmpty(this.q)) {
        paramXmlSerializer.attribute(null, "apurl", this.q);
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramXmlSerializer);
      }
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return a() == 1;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramStructMsgNode == null) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      this.jdField_c_of_type_JavaLangString = paramStructMsgNode.a("action");
      this.d = paramStructMsgNode.a("actionData");
      this.jdField_e_of_type_JavaLangString = paramStructMsgNode.a("a_actionData");
      this.jdField_f_of_type_JavaLangString = paramStructMsgNode.a("i_actionData");
      this.b = paramStructMsgNode.a("url");
      this.jdField_g_of_type_JavaLangString = paramStructMsgNode.a("brief");
      this.q = paramStructMsgNode.a("apurl");
      String str = paramStructMsgNode.a("flag");
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        this.jdField_c_of_type_Int = Integer.parseInt(str);
        str = paramStructMsgNode.a("mode");
        if (TextUtils.isEmpty(str)) {}
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          this.jdField_e_of_type_Int = Integer.parseInt(str);
          label142:
          str = paramStructMsgNode.a("bg");
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              if (!str.startsWith("#")) {
                break label331;
              }
            }
            label304:
            label331:
            for (this.jdField_f_of_type_Int = Color.parseColor(str);; this.jdField_f_of_type_Int = Integer.parseInt(localNumberFormatException2))
            {
              this.jdField_h_of_type_JavaLangString = paramStructMsgNode.a("businessData");
              this.i = paramStructMsgNode.a("commonData");
              this.j = paramStructMsgNode.a("index");
              this.k = paramStructMsgNode.a("index_name");
              this.l = paramStructMsgNode.a("index_type");
              this.o = paramStructMsgNode.a("canvas");
              this.m = paramStructMsgNode.a("rurl");
              this.p = paramStructMsgNode.a("disType");
              this.n = paramStructMsgNode.a("tid");
              int k = paramStructMsgNode.a();
              int i = 0;
              for (;;)
              {
                if (i >= k) {
                  break label585;
                }
                localStructMsgNode = paramStructMsgNode.a(i);
                if (localStructMsgNode != null) {
                  break;
                }
                i += 1;
              }
              localNumberFormatException1 = localNumberFormatException1;
              this.jdField_c_of_type_Int = 0;
              break;
              localNumberFormatException2 = localNumberFormatException2;
              this.jdField_e_of_type_Int = 0;
              break label142;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            StructMsgNode localStructMsgNode;
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("AbsStructMsgItem", 2, "Item bg value is " + this.jdField_f_of_type_Int);
              }
            }
            Object localObject;
            if ("item".equals(localStructMsgNode.b)) {
              localObject = localStructMsgNode.a("layout");
            }
            do
            {
              AbsStructMsgElement localAbsStructMsgElement;
              do
              {
                do
                {
                  do
                  {
                    try
                    {
                      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
                      for (int j = Integer.parseInt((String)localObject);; j = 0)
                      {
                        localObject = StructMsgElementFactory.a(j);
                        bool1 = bool2;
                        if (localObject == null) {
                          break;
                        }
                        bool1 = bool2;
                        if (!((AbsStructMsgElement)localObject).a(localStructMsgNode)) {
                          break;
                        }
                        a((AbsStructMsgElement)localObject);
                        break label304;
                      }
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                    }
                    catch (NumberFormatException paramStructMsgNode)
                    {
                      bool1 = bool2;
                    }
                    QLog.i("AbsStructMsgItem", 2, "Item layout value is " + 0);
                    return false;
                    localAbsStructMsgElement = StructMsgElementFactory.a(localStructMsgNode.b);
                    localObject = localAbsStructMsgElement;
                  } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null);
                  localObject = localAbsStructMsgElement;
                } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID != 70);
                localObject = localAbsStructMsgElement;
              } while (b() != 14);
              localObject = localAbsStructMsgElement;
            } while (StructMsgItemLayout14.a(localStructMsgNode.b));
            a(new StructMsgItemContent("本版本不支持的附件类型"));
            return true;
          }
        }
      }
    }
    label585:
    return true;
  }
  
  public abstract int b();
  
  public abstract View b(Context paramContext, View paramView, Bundle paramBundle);
  
  public abstract String b();
  
  public void b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void b(View paramView)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      Object localObject = paramView.getLayoutParams();
      int i = paramView.getPaddingLeft();
      int j = paramView.getPaddingTop();
      int k = paramView.getPaddingRight();
      int m = paramView.getPaddingBottom();
      switch (a())
      {
      default: 
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setPadding(i, j, k, m);
        localObject = paramView.findViewById(2131361925);
        if ((localObject != null) && ((localObject instanceof PAHighLightImageView))) {
          ((PAHighLightImageView)localObject).a();
        }
        break;
      }
    }
    do
    {
      return;
      paramView.setBackgroundResource(2130837918);
      break;
      paramView.setBackgroundResource(2130837919);
      break;
      paramView.setBackgroundResource(2130837917);
      break;
      paramView.setBackgroundResource(2130837916);
      break;
      paramView = paramView.findViewById(2131362097);
    } while ((paramView == null) || (!(paramView instanceof PAHighLightImageView)));
    ((PAHighLightImageView)paramView).a();
  }
  
  public void b(String paramString)
  {
    this.jdField_h_of_type_Int = 0;
    a(new StructMsgItemImage(paramString));
  }
  
  public void c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    int j;
    int k;
    int m;
    if (!TextUtils.isEmpty(this.b))
    {
      localLayoutParams = paramView.getLayoutParams();
      i = paramView.getPaddingLeft();
      j = paramView.getPaddingTop();
      k = paramView.getPaddingRight();
      m = paramView.getPaddingBottom();
      switch (a())
      {
      }
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(i, j, k, m);
      return;
      paramView.setBackgroundResource(2130837926);
      continue;
      paramView.setBackgroundResource(2130837929);
      continue;
      paramView.setBackgroundResource(2130837925);
      continue;
      paramView.setBackgroundResource(2130837928);
    }
  }
  
  @TargetApi(16)
  public void d(View paramView)
  {
    if ((b()) && (a())) {
      switch (this.jdField_f_of_type_Int)
      {
      default: 
        if ((paramView != null) && (a() == 1))
        {
          if (this.jdField_g_of_type_Int == 0) {
            break label128;
          }
          paramView.setBackgroundResource(this.jdField_g_of_type_Int);
        }
        break;
      }
    }
    label128:
    StateListDrawable localStateListDrawable;
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(this.b))
        {
          this.jdField_g_of_type_Int = 2130837920;
          break;
        }
        this.jdField_g_of_type_Int = 2130837930;
        break;
        if (!TextUtils.isEmpty(this.b))
        {
          this.jdField_g_of_type_Int = 2130837921;
          break;
        }
        this.jdField_g_of_type_Int = 2130837931;
        break;
        paramView.setBackgroundResource(2130837919);
        return;
      } while ((!a()) || (this.jdField_f_of_type_Int == 0));
      int i = AIOUtils.a(4.0F, paramView.getResources());
      float f1 = i;
      float f2 = i;
      float f3 = i;
      float f4 = i;
      localStateListDrawable = StructMsgUtils.a(paramView.getResources(), this.jdField_f_of_type_Int, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F });
    } while (localStateListDrawable == null);
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(localStateListDrawable);
      return;
    }
    paramView.setBackground(localStateListDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgItem
 * JD-Core Version:    0.7.0.1
 */