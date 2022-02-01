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
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPrice;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.StringUtil;
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
  public ArrayList<AbsStructMsgElement> a;
  public int o;
  protected int p;
  protected int q;
  public int r;
  
  protected AbsStructMsgItem()
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_r_of_type_Int = b();
  }
  
  protected AbsStructMsgItem(Collection<AbsStructMsgElement> paramCollection)
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramCollection);
    this.jdField_r_of_type_Int = b();
  }
  
  private boolean b()
  {
    int i = this.jdField_p_of_type_Int;
    return (i >= 0) && (i <= 3);
  }
  
  public int a(Context paramContext, int paramInt)
  {
    return (int)(TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics()) + 0.5F);
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return b(paramContext, paramView, paramBundle);
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(b());
    localStringBuffer.append(this.jdField_o_of_type_Int);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuffer.append(((AbsStructMsgElement)((Iterator)localObject).next()).a());
      }
    }
    return localStringBuffer.toString();
  }
  
  public void a(View paramView)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      int i = a();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return;
            }
            paramView.setBackgroundResource(2130838253);
            return;
          }
          paramView.setBackgroundResource(2130838254);
          return;
        }
        paramView.setBackgroundResource(2130838256);
        return;
      }
      paramView.setBackgroundResource(2130838255);
    }
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
      ((AbsStructMsgTextElement)paramAbsStructMsgElement).ac = null;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAbsStructMsgElement);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_a_of_type_Int = paramObjectInput.readInt();
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int <= 18))
    {
      this.b = paramObjectInput.readUTF();
      this.jdField_c_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_d_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_e_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_f_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_g_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_m_of_type_Int = paramObjectInput.readInt();
      this.jdField_o_of_type_Int = paramObjectInput.readInt();
      if ((2 <= this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Int <= 18)) {
        this.jdField_p_of_type_Int = paramObjectInput.readInt();
      }
      int m = paramObjectInput.readInt();
      int k = 0;
      int i = 1;
      while (k < m)
      {
        String str = paramObjectInput.readUTF();
        Object localObject;
        if ("item".equals(str))
        {
          localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
        }
        else
        {
          localObject = StructMsgElementFactory.a(str);
          int j = i;
          if ("button".equals(str))
          {
            ((AbsStructMsgElement)localObject).aa = String.valueOf(i);
            ((AbsStructMsgElement)localObject).ab = this.ab;
            j = i + 1;
          }
          if ((localObject != null) && (AbsStructMsgItem.class.isInstance(localObject))) {
            paramObjectInput.readInt();
          }
          i = j;
        }
        str = b();
        if ((str != null) && (localObject != null) && ((localObject instanceof StructMsgItemCover))) {
          if ((!str.endsWith("Layout4")) && (!str.endsWith("Layout2")) && (!str.endsWith("Layout9")))
          {
            if (str.endsWith("Layout3")) {
              ((StructMsgItemCover)localObject).t = StructMsgItemCover.jdField_r_of_type_Int;
            }
          }
          else {
            ((StructMsgItemCover)localObject).t = StructMsgItemCover.jdField_q_of_type_Int;
          }
        }
        if (localObject != null)
        {
          ((AbsStructMsgElement)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          ((AbsStructMsgElement)localObject).a(paramObjectInput);
          a((AbsStructMsgElement)localObject);
        }
        k += 1;
      }
      if ((this.jdField_a_of_type_Int >= 3) && (this.jdField_a_of_type_Int <= 18))
      {
        this.jdField_h_of_type_JavaLangString = paramObjectInput.readUTF();
        if (this.jdField_a_of_type_Int > 5)
        {
          this.jdField_j_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_k_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_l_of_type_JavaLangString = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 8) {
          this.jdField_i_of_type_JavaLangString = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 9)
        {
          this.n = paramObjectInput.readUTF();
          this.jdField_o_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_p_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_m_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_q_of_type_JavaLangString = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 10)
        {
          this.jdField_c_of_type_Int = paramObjectInput.readInt();
          this.jdField_r_of_type_JavaLangString = paramObjectInput.readUTF();
          this.s = paramObjectInput.readUTF();
          this.t = paramObjectInput.readUTF();
          this.u = paramObjectInput.readUTF();
          this.v = paramObjectInput.readUTF();
          this.jdField_d_of_type_Int = paramObjectInput.readInt();
          this.w = paramObjectInput.readUTF();
          this.x = paramObjectInput.readUTF();
          this.y = paramObjectInput.readUTF();
          this.z = paramObjectInput.readUTF();
          this.A = paramObjectInput.readUTF();
          this.jdField_e_of_type_Int = paramObjectInput.readInt();
          this.B = paramObjectInput.readUTF();
          this.C = paramObjectInput.readUTF();
          this.D = paramObjectInput.readUTF();
          this.E = paramObjectInput.readUTF();
          this.F = paramObjectInput.readUTF();
          this.G = paramObjectInput.readUTF();
          this.H = paramObjectInput.readUTF();
          this.I = paramObjectInput.readUTF();
          this.J = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 11)
        {
          this.K = paramObjectInput.readUTF();
          this.L = paramObjectInput.readUTF();
          this.M = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 12)
        {
          this.N = paramObjectInput.readUTF();
          this.O = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 13) {
          this.jdField_f_of_type_Int = paramObjectInput.readInt();
        }
        if (this.jdField_a_of_type_Int > 14)
        {
          this.jdField_g_of_type_Int = paramObjectInput.readInt();
          this.jdField_h_of_type_Int = paramObjectInput.readInt();
        }
        if (this.jdField_a_of_type_Int > 15)
        {
          this.P = paramObjectInput.readUTF();
          this.Q = paramObjectInput.readUTF();
          this.R = paramObjectInput.readUTF();
          this.jdField_i_of_type_Int = paramObjectInput.readInt();
          this.jdField_j_of_type_Int = paramObjectInput.readInt();
          this.jdField_k_of_type_Int = paramObjectInput.readInt();
          this.jdField_l_of_type_Int = paramObjectInput.readInt();
          this.S = paramObjectInput.readUTF();
          this.T = paramObjectInput.readUTF();
          this.U = paramObjectInput.readUTF();
          this.V = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 16) {
          this.W = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 17)
        {
          this.X = paramObjectInput.readUTF();
          this.Y = paramObjectInput.readUTF();
        }
      }
      return;
    }
    paramObjectInput = new IOException("structmsg_version_error");
    for (;;)
    {
      throw paramObjectInput;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_r_of_type_Int);
    paramObjectOutput.writeInt(this.jdField_a_of_type_Int);
    Object localObject = this.b;
    String str1 = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = this.b;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.jdField_c_of_type_JavaLangString == null) {
      localObject = "";
    } else {
      localObject = this.jdField_c_of_type_JavaLangString;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.jdField_d_of_type_JavaLangString == null) {
      localObject = "";
    } else {
      localObject = this.jdField_d_of_type_JavaLangString;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.jdField_e_of_type_JavaLangString == null) {
      localObject = "";
    } else {
      localObject = this.jdField_e_of_type_JavaLangString;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.jdField_f_of_type_JavaLangString == null) {
      localObject = "";
    } else {
      localObject = this.jdField_f_of_type_JavaLangString;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.jdField_g_of_type_JavaLangString == null) {
      localObject = "";
    } else {
      localObject = this.jdField_g_of_type_JavaLangString;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.jdField_m_of_type_Int);
    paramObjectOutput.writeInt(this.jdField_o_of_type_Int);
    paramObjectOutput.writeInt(this.jdField_p_of_type_Int);
    paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mVersion: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.i("getStructMsgFromXmlBuff", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
    }
    if ((this.jdField_a_of_type_Int >= 3) && (this.jdField_a_of_type_Int <= 18))
    {
      if (this.jdField_h_of_type_JavaLangString == null) {
        localObject = "";
      } else {
        localObject = this.jdField_h_of_type_JavaLangString;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_a_of_type_Int > 5)
      {
        if (this.jdField_j_of_type_JavaLangString == null) {
          localObject = "";
        } else {
          localObject = this.jdField_j_of_type_JavaLangString;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_k_of_type_JavaLangString == null) {
          localObject = "";
        } else {
          localObject = this.jdField_k_of_type_JavaLangString;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_l_of_type_JavaLangString == null) {
          localObject = "";
        } else {
          localObject = this.jdField_l_of_type_JavaLangString;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 8)
      {
        if (this.jdField_i_of_type_JavaLangString == null) {
          localObject = "";
        } else {
          localObject = this.jdField_i_of_type_JavaLangString;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 9)
      {
        if (this.n == null) {
          localObject = "";
        } else {
          localObject = this.n;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_o_of_type_JavaLangString == null) {
          localObject = "";
        } else {
          localObject = this.jdField_o_of_type_JavaLangString;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_p_of_type_JavaLangString == null) {
          localObject = "";
        } else {
          localObject = this.jdField_p_of_type_JavaLangString;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_m_of_type_JavaLangString == null) {
          localObject = "";
        } else {
          localObject = this.jdField_m_of_type_JavaLangString;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_q_of_type_JavaLangString == null) {
          localObject = "";
        } else {
          localObject = this.jdField_q_of_type_JavaLangString;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 10)
      {
        paramObjectOutput.writeInt(this.jdField_c_of_type_Int);
        localObject = this.jdField_r_of_type_JavaLangString;
        String str2 = "0";
        if (localObject == null) {
          localObject = "0";
        } else {
          localObject = this.jdField_r_of_type_JavaLangString;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.s == null) {
          localObject = str2;
        } else {
          localObject = this.s;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.t == null) {
          localObject = "";
        } else {
          localObject = this.t;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.u == null) {
          localObject = "";
        } else {
          localObject = this.u;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.v == null) {
          localObject = "";
        } else {
          localObject = this.v;
        }
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
        if (this.w == null) {
          localObject = "";
        } else {
          localObject = this.w;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.x == null) {
          localObject = "";
        } else {
          localObject = this.x;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.y == null) {
          localObject = "";
        } else {
          localObject = this.y;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.z == null) {
          localObject = "";
        } else {
          localObject = this.z;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.A == null) {
          localObject = "";
        } else {
          localObject = this.A;
        }
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.jdField_e_of_type_Int);
        if (this.B == null) {
          localObject = "";
        } else {
          localObject = this.B;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.C == null) {
          localObject = "";
        } else {
          localObject = this.C;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.D == null) {
          localObject = "";
        } else {
          localObject = this.D;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.E == null) {
          localObject = "";
        } else {
          localObject = this.E;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.F == null) {
          localObject = "";
        } else {
          localObject = this.F;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.G == null) {
          localObject = "";
        } else {
          localObject = this.G;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.H == null) {
          localObject = "";
        } else {
          localObject = this.H;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.I == null) {
          localObject = "";
        } else {
          localObject = this.I;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.J == null) {
          localObject = "";
        } else {
          localObject = this.J;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 11)
      {
        if (this.K == null) {
          localObject = "";
        } else {
          localObject = this.K;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.L == null) {
          localObject = "";
        } else {
          localObject = this.L;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.M == null) {
          localObject = "";
        } else {
          localObject = this.M;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 12)
      {
        if (this.N == null) {
          localObject = "";
        } else {
          localObject = this.N;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.O == null) {
          localObject = "";
        } else {
          localObject = this.O;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 13) {
        paramObjectOutput.writeInt(this.jdField_f_of_type_Int);
      }
      if (this.jdField_a_of_type_Int > 14)
      {
        paramObjectOutput.writeInt(this.jdField_g_of_type_Int);
        paramObjectOutput.writeInt(this.jdField_h_of_type_Int);
      }
      if (this.jdField_a_of_type_Int > 15)
      {
        if (this.P == null) {
          localObject = "";
        } else {
          localObject = this.P;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.Q == null) {
          localObject = "";
        } else {
          localObject = this.Q;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.R == null) {
          localObject = "";
        } else {
          localObject = this.R;
        }
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.jdField_i_of_type_Int);
        paramObjectOutput.writeInt(this.jdField_j_of_type_Int);
        paramObjectOutput.writeInt(this.jdField_k_of_type_Int);
        paramObjectOutput.writeInt(this.jdField_l_of_type_Int);
        if (this.S == null) {
          localObject = "";
        } else {
          localObject = this.S;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.T == null) {
          localObject = "";
        } else {
          localObject = this.T;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.U == null) {
          localObject = "";
        } else {
          localObject = this.U;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.V == null) {
          localObject = "";
        } else {
          localObject = this.V;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 16)
      {
        if (this.W == null) {
          localObject = "";
        } else {
          localObject = this.W;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 17)
      {
        if (this.X == null) {
          localObject = "";
        } else {
          localObject = this.X;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.Y == null) {
          localObject = str1;
        } else {
          localObject = this.Y;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
    }
  }
  
  public void a(String paramString)
  {
    a(new StructMsgItemSummary(paramString));
    a(new StructMsgItemHr());
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_o_of_type_Int = paramInt;
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
    this.jdField_o_of_type_Int = paramInt;
    a(new StructMsgItemCover(paramString1, paramString4));
    a(new StructMsgItemTitle(paramString2));
    a(new StructMsgItemSummary(paramString3));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.jdField_o_of_type_Int = paramInt;
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
    int i = this.jdField_r_of_type_Int;
    if (i < 0) {
      localObject = "0";
    } else {
      localObject = String.valueOf(i);
    }
    paramXmlSerializer.attribute(null, "layout", (String)localObject);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "action", this.jdField_c_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "actionData", this.jdField_d_of_type_JavaLangString);
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
    if (this.jdField_m_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "flag", String.valueOf(this.jdField_m_of_type_Int));
    }
    i = this.jdField_o_of_type_Int;
    if (i != 0) {
      paramXmlSerializer.attribute(null, "mode", String.valueOf(i));
    }
    i = this.jdField_p_of_type_Int;
    if (i != 0) {
      paramXmlSerializer.attribute(null, "bg", String.valueOf(i));
    }
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "businessData", this.jdField_h_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "commonData", this.jdField_i_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "index", this.jdField_j_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "index_name", this.jdField_k_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "index_type", this.jdField_l_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "canvas", this.jdField_o_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "rurl", this.jdField_m_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "disType", this.jdField_p_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.n)) {
      paramXmlSerializer.attribute(null, "tid", this.n);
    }
    if (!TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "apurl", this.jdField_q_of_type_JavaLangString);
    }
    if (this.jdField_c_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "action_type", String.valueOf(this.jdField_c_of_type_Int));
    }
    if (!TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "advertiser_id", this.jdField_r_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.s)) {
      paramXmlSerializer.attribute(null, "aid", this.s);
    }
    if (!TextUtils.isEmpty(this.t)) {
      paramXmlSerializer.attribute(null, "app_download_schema", this.t);
    }
    if (!TextUtils.isEmpty(this.u)) {
      paramXmlSerializer.attribute(null, "canvas_json", this.u);
    }
    if (!TextUtils.isEmpty(this.v)) {
      paramXmlSerializer.attribute(null, "customized_invoke_url", this.v);
    }
    if (this.jdField_d_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "dest_type", String.valueOf(this.jdField_d_of_type_Int));
    }
    if (!TextUtils.isEmpty(this.w)) {
      paramXmlSerializer.attribute(null, "effect_url", this.w);
    }
    if (!TextUtils.isEmpty(this.x)) {
      paramXmlSerializer.attribute(null, "landing_page", this.x);
    }
    if (!TextUtils.isEmpty(this.y)) {
      paramXmlSerializer.attribute(null, "landing_page_report_url", this.y);
    }
    if (!TextUtils.isEmpty(this.z)) {
      paramXmlSerializer.attribute(null, "noco_id", this.z);
    }
    if (!TextUtils.isEmpty(this.A)) {
      paramXmlSerializer.attribute(null, "product_id", this.A);
    }
    if (this.jdField_e_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "product_type", String.valueOf(this.jdField_e_of_type_Int));
    }
    if (this.jdField_f_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "mini_program_type", String.valueOf(this.jdField_f_of_type_Int));
    }
    if (!TextUtils.isEmpty(this.B)) {
      paramXmlSerializer.attribute(null, "rl", this.B);
    }
    if (!TextUtils.isEmpty(this.C)) {
      paramXmlSerializer.attribute(null, "subordinate_product_id", this.C);
    }
    if (!TextUtils.isEmpty(this.D)) {
      paramXmlSerializer.attribute(null, "traceid", this.D);
    }
    if (!TextUtils.isEmpty(this.E)) {
      paramXmlSerializer.attribute(null, "via", this.E);
    }
    if (!TextUtils.isEmpty(this.F)) {
      paramXmlSerializer.attribute(null, "video_url", this.F);
    }
    if (!TextUtils.isEmpty(this.G)) {
      paramXmlSerializer.attribute(null, "appname", this.G);
    }
    if (!TextUtils.isEmpty(this.H)) {
      paramXmlSerializer.attribute(null, "customized_invoke_url", this.H);
    }
    if (!TextUtils.isEmpty(this.I)) {
      paramXmlSerializer.attribute(null, "pkg_name", this.I);
    }
    if (!TextUtils.isEmpty(this.J)) {
      paramXmlSerializer.attribute(null, "pkgurl", this.J);
    }
    if (!TextUtils.isEmpty(this.L)) {
      paramXmlSerializer.attribute(null, "api_exposure_monitor_url", this.L);
    }
    if (!TextUtils.isEmpty(this.K)) {
      paramXmlSerializer.attribute(null, "api_click_monitor_url", this.K);
    }
    if (!TextUtils.isEmpty(this.M)) {
      paramXmlSerializer.attribute(null, "trace_info_aid", this.M);
    }
    if (!TextUtils.isEmpty(this.N)) {
      paramXmlSerializer.attribute(null, "corporate_image_name", this.N);
    }
    if (!TextUtils.isEmpty(this.O)) {
      paramXmlSerializer.attribute(null, "corporate_logo", this.O);
    }
    if (this.jdField_g_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.jdField_g_of_type_Int));
    }
    if (this.jdField_h_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "is_hidden", String.valueOf(this.jdField_h_of_type_Int));
    }
    if (!TextUtils.isEmpty(this.P)) {
      paramXmlSerializer.attribute(null, "negative_feedback_url", this.P);
    }
    if (!TextUtils.isEmpty(this.Q)) {
      paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.Q);
    }
    if (!TextUtils.isEmpty(this.R)) {
      paramXmlSerializer.attribute(null, "sdk_click_monitor_url", this.R);
    }
    if (this.jdField_i_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "media_duration", String.valueOf(this.jdField_i_of_type_Int));
    }
    if (this.jdField_j_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "video_file_size", String.valueOf(this.jdField_j_of_type_Int));
    }
    if (this.jdField_k_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "app_score_num", String.valueOf(this.jdField_k_of_type_Int));
    }
    if (this.jdField_l_of_type_Int != 0) {
      paramXmlSerializer.attribute(null, "download_num", String.valueOf(this.jdField_l_of_type_Int));
    }
    if (!TextUtils.isEmpty(this.S)) {
      paramXmlSerializer.attribute(null, "universal_link", this.S);
    }
    if (!TextUtils.isEmpty(this.T)) {
      paramXmlSerializer.attribute(null, "sdk_data", this.T);
    }
    if (!TextUtils.isEmpty(this.U)) {
      paramXmlSerializer.attribute(null, "tencent_video_id", this.U);
    }
    if (!TextUtils.isEmpty(this.V)) {
      paramXmlSerializer.attribute(null, "view_id", this.V);
    }
    if (!TextUtils.isEmpty(this.W)) {
      paramXmlSerializer.attribute(null, "qgg_ext", this.W);
    }
    if (!TextUtils.isEmpty(this.X)) {
      paramXmlSerializer.attribute(null, "adInfo", this.X);
    }
    if (!TextUtils.isEmpty(this.Y)) {
      paramXmlSerializer.attribute(null, "is_report_click", this.Y);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return a() == 1;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.jdField_c_of_type_JavaLangString = paramStructMsgNode.a("action");
    this.jdField_d_of_type_JavaLangString = paramStructMsgNode.a("actionData");
    this.jdField_e_of_type_JavaLangString = paramStructMsgNode.a("a_actionData");
    this.jdField_f_of_type_JavaLangString = paramStructMsgNode.a("i_actionData");
    this.b = paramStructMsgNode.a("url");
    this.jdField_g_of_type_JavaLangString = paramStructMsgNode.a("brief");
    this.jdField_q_of_type_JavaLangString = paramStructMsgNode.a("apurl");
    Object localObject1 = paramStructMsgNode.a("flag");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.jdField_m_of_type_Int = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label112:
      break label112;
    }
    this.jdField_m_of_type_Int = 0;
    localObject1 = paramStructMsgNode.a("mode");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.jdField_o_of_type_Int = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      label146:
      break label146;
    }
    this.jdField_o_of_type_Int = 0;
    localObject1 = paramStructMsgNode.a("bg");
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label249;
      }
      if (((String)localObject1).startsWith("#")) {
        this.jdField_p_of_type_Int = Color.parseColor((String)localObject1);
      } else {
        this.jdField_p_of_type_Int = Integer.parseInt((String)localObject1);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label203:
      label249:
      Object localObject2;
      break label203;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Item bg value is ");
      ((StringBuilder)localObject1).append(this.jdField_p_of_type_Int);
      QLog.i("AbsStructMsgItem", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_h_of_type_JavaLangString = paramStructMsgNode.a("businessData");
    this.jdField_i_of_type_JavaLangString = paramStructMsgNode.a("commonData");
    this.jdField_j_of_type_JavaLangString = paramStructMsgNode.a("index");
    this.jdField_k_of_type_JavaLangString = paramStructMsgNode.a("index_name");
    this.jdField_l_of_type_JavaLangString = paramStructMsgNode.a("index_type");
    this.jdField_o_of_type_JavaLangString = paramStructMsgNode.a("canvas");
    this.jdField_m_of_type_JavaLangString = paramStructMsgNode.a("rurl");
    this.jdField_p_of_type_JavaLangString = paramStructMsgNode.a("disType");
    this.n = paramStructMsgNode.a("tid");
    if (this.jdField_a_of_type_Int > 10)
    {
      localObject1 = paramStructMsgNode.a;
      if (localObject1 != null)
      {
        localObject2 = ((StructMsgNode)localObject1).a("action_type");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
    }
    try
    {
      this.jdField_c_of_type_Int = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException5)
    {
      label398:
      label433:
      break label398;
    }
    this.jdField_c_of_type_Int = 0;
    localObject2 = ((StructMsgNode)localObject1).a("dest_type");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      this.jdField_d_of_type_Int = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException6)
    {
      break label433;
    }
    this.jdField_d_of_type_Int = 0;
    localObject2 = ((StructMsgNode)localObject1).a("product_type");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      this.jdField_e_of_type_Int = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException7)
    {
      label468:
      break label468;
    }
    this.jdField_e_of_type_Int = 0;
    this.jdField_r_of_type_JavaLangString = ((StructMsgNode)localObject1).a("advertiser_id");
    this.s = ((StructMsgNode)localObject1).a("aid");
    this.t = ((StructMsgNode)localObject1).a("app_download_schema");
    this.u = ((StructMsgNode)localObject1).a("canvas_json");
    this.v = ((StructMsgNode)localObject1).a("customized_invoke_url");
    this.w = ((StructMsgNode)localObject1).a("effect_url");
    this.x = ((StructMsgNode)localObject1).a("landing_page");
    this.y = ((StructMsgNode)localObject1).a("landing_page_report_url");
    this.z = ((StructMsgNode)localObject1).a("noco_id");
    this.A = ((StructMsgNode)localObject1).a("product_id");
    this.B = ((StructMsgNode)localObject1).a("rl");
    this.C = ((StructMsgNode)localObject1).a("subordinate_product_id");
    this.D = ((StructMsgNode)localObject1).a("traceid");
    this.E = ((StructMsgNode)localObject1).a("via");
    this.F = ((StructMsgNode)localObject1).a("video_url");
    this.G = ((StructMsgNode)localObject1).a("appname");
    this.H = ((StructMsgNode)localObject1).a("customized_invoke_url");
    this.I = ((StructMsgNode)localObject1).a("pkg_name");
    this.J = ((StructMsgNode)localObject1).a("pkgurl");
    this.jdField_q_of_type_JavaLangString = ((StructMsgNode)localObject1).a("apurl");
    if (this.jdField_a_of_type_Int > 11)
    {
      localObject1 = paramStructMsgNode.a;
      if (localObject1 != null)
      {
        this.K = ((StructMsgNode)localObject1).a("api_click_monitor_url");
        this.L = ((StructMsgNode)localObject1).a("api_exposure_monitor_url");
        this.M = ((StructMsgNode)localObject1).a("trace_info_aid");
      }
    }
    if (this.jdField_a_of_type_Int > 12)
    {
      localObject1 = paramStructMsgNode.a;
      if (localObject1 != null)
      {
        this.N = ((StructMsgNode)localObject1).a("corporate_image_name");
        this.O = ((StructMsgNode)localObject1).a("corporate_logo");
      }
    }
    if (this.jdField_a_of_type_Int > 13)
    {
      localObject1 = paramStructMsgNode.a.a("mini_program_type");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      this.jdField_f_of_type_Int = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      label854:
      break label854;
    }
    this.jdField_f_of_type_Int = 0;
    if (this.jdField_a_of_type_Int > 14)
    {
      localObject1 = paramStructMsgNode.a;
      if (localObject1 != null)
      {
        localObject2 = ((StructMsgNode)localObject1).a("tab_id");
        if (StringUtil.a((String)localObject2)) {}
      }
    }
    try
    {
      this.jdField_g_of_type_Int = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException8)
    {
      label909:
      label944:
      break label909;
    }
    this.jdField_g_of_type_Int = 0;
    localObject1 = ((StructMsgNode)localObject1).a("is_hidden");
    if (!StringUtil.a((String)localObject1)) {}
    try
    {
      this.jdField_h_of_type_Int = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException4)
    {
      break label944;
    }
    this.jdField_h_of_type_Int = 0;
    if (this.jdField_a_of_type_Int > 15)
    {
      localObject1 = paramStructMsgNode.a;
      this.P = ((StructMsgNode)localObject1).a("negative_feedback_url");
      this.Q = ((StructMsgNode)localObject1).a("sdk_exposure_monitor_url");
      this.R = ((StructMsgNode)localObject1).a("sdk_click_monitor_url");
      localObject2 = ((StructMsgNode)localObject1).a("media_duration");
      if (StringUtil.a((String)localObject2)) {}
    }
    try
    {
      this.jdField_i_of_type_Int = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException9)
    {
      label1030:
      break label1030;
    }
    this.jdField_i_of_type_Int = 0;
    localObject2 = ((StructMsgNode)localObject1).a("video_file_size");
    if (!StringUtil.a((String)localObject2)) {}
    try
    {
      this.jdField_j_of_type_Int = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException10)
    {
      label1065:
      break label1065;
    }
    this.jdField_j_of_type_Int = 0;
    localObject2 = ((StructMsgNode)localObject1).a("app_score_num");
    if (!StringUtil.a((String)localObject2)) {}
    try
    {
      this.jdField_k_of_type_Int = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException11)
    {
      label1100:
      break label1100;
    }
    this.jdField_k_of_type_Int = 0;
    localObject2 = ((StructMsgNode)localObject1).a("download_num");
    if (!StringUtil.a((String)localObject2)) {}
    try
    {
      this.jdField_l_of_type_Int = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException12)
    {
      label1135:
      int k;
      int i;
      break label1135;
    }
    this.jdField_l_of_type_Int = 0;
    this.S = ((StructMsgNode)localObject1).a("universal_link");
    this.T = ((StructMsgNode)localObject1).a("sdk_data");
    this.U = ((StructMsgNode)localObject1).a("tencent_video_id");
    this.V = ((StructMsgNode)localObject1).a("view_id");
    if (this.jdField_a_of_type_Int > 16) {
      this.W = paramStructMsgNode.a.a("qgg_ext");
    }
    if (this.jdField_a_of_type_Int > 17)
    {
      localObject1 = paramStructMsgNode.a;
      this.X = ((StructMsgNode)localObject1).a("adInfo");
      this.Y = ((StructMsgNode)localObject1).a("is_report_click");
    }
    k = paramStructMsgNode.a();
    i = 0;
    while (i < k)
    {
      localObject2 = paramStructMsgNode.a(i);
      if (localObject2 != null) {
        if ("item".equals(((StructMsgNode)localObject2).b)) {
          localObject1 = ((StructMsgNode)localObject2).a("layout");
        }
      }
      try
      {
        int j;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          j = Integer.parseInt((String)localObject1);
        } else {
          j = 0;
        }
        localObject1 = StructMsgElementFactory.a(j);
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        label1330:
        break label1330;
      }
      if (QLog.isColorLevel())
      {
        paramStructMsgNode = new StringBuilder();
        paramStructMsgNode.append("Item layout value is ");
        paramStructMsgNode.append(0);
        QLog.i("AbsStructMsgItem", 2, paramStructMsgNode.toString());
      }
      return false;
      localObject1 = StructMsgElementFactory.a(((StructMsgNode)localObject2).b);
      if (localObject1 == null) {
        return false;
      }
      if (((AbsStructMsgElement)localObject1).a((StructMsgNode)localObject2))
      {
        a((AbsStructMsgElement)localObject1);
        i += 1;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  protected abstract int b();
  
  public abstract View b(Context paramContext, View paramView, Bundle paramBundle);
  
  public abstract String b();
  
  public void b(int paramInt)
  {
    this.jdField_o_of_type_Int = paramInt;
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
      int n = a();
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            if (n == 3) {
              paramView.setBackgroundResource(2130838253);
            }
          }
          else {
            paramView.setBackgroundResource(2130838254);
          }
        }
        else {
          paramView.setBackgroundResource(2130838256);
        }
      }
      else {
        paramView.setBackgroundResource(2130838255);
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setPadding(i, j, k, m);
      localObject = paramView.findViewById(2131368633);
      if ((localObject != null) && ((localObject instanceof PAHighLightImageView)))
      {
        ((PAHighLightImageView)localObject).a();
        return;
      }
      paramView = paramView.findViewById(2131377977);
      if ((paramView != null) && ((paramView instanceof PAHighLightImageView))) {
        ((PAHighLightImageView)paramView).a();
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_r_of_type_Int = 0;
    a(new StructMsgItemImage(paramString));
  }
  
  public void c(View paramView)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      int i = paramView.getPaddingLeft();
      int j = paramView.getPaddingTop();
      int k = paramView.getPaddingRight();
      int m = paramView.getPaddingBottom();
      int n = a();
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            if (n == 3) {
              paramView.setBackgroundResource(2130838269);
            }
          }
          else {
            paramView.setBackgroundResource(2130838266);
          }
        }
        else {
          paramView.setBackgroundResource(2130838270);
        }
      }
      else {
        paramView.setBackgroundResource(2130838267);
      }
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(i, j, k, m);
    }
  }
  
  @TargetApi(16)
  protected void d(View paramView)
  {
    if ((b()) && (a()))
    {
      int i = this.jdField_p_of_type_Int;
      if (i != 1)
      {
        if (i == 2) {
          if (!TextUtils.isEmpty(this.b)) {
            this.jdField_q_of_type_Int = 2130838258;
          } else {
            this.jdField_q_of_type_Int = 2130838283;
          }
        }
      }
      else if (!TextUtils.isEmpty(this.b)) {
        this.jdField_q_of_type_Int = 2130838257;
      } else {
        this.jdField_q_of_type_Int = 2130838271;
      }
      if ((paramView != null) && (a() == 1))
      {
        i = this.jdField_q_of_type_Int;
        if (i != 0)
        {
          paramView.setBackgroundResource(i);
          return;
        }
        paramView.setBackgroundResource(2130838256);
      }
    }
    else if ((a()) && (this.jdField_p_of_type_Int != 0))
    {
      float f = AIOUtils.b(4.0F, paramView.getResources());
      StateListDrawable localStateListDrawable = StructMsgUtils.a(paramView.getResources(), this.jdField_p_of_type_Int, new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      if (localStateListDrawable != null)
      {
        if (Build.VERSION.SDK_INT < 16)
        {
          paramView.setBackgroundDrawable(localStateListDrawable);
          return;
        }
        paramView.setBackground(localStateListDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgItem
 * JD-Core Version:    0.7.0.1
 */