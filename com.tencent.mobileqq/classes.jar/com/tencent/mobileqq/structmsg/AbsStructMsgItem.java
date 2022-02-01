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
  public int au;
  protected int av;
  protected int aw;
  public ArrayList<AbsStructMsgElement> ax;
  public int ay;
  
  protected AbsStructMsgItem()
  {
    this.b = "item";
    this.ax = new ArrayList();
    this.ay = c();
  }
  
  protected AbsStructMsgItem(Collection<AbsStructMsgElement> paramCollection)
  {
    this.b = "item";
    this.ax = new ArrayList(paramCollection);
    this.ay = c();
  }
  
  private boolean f()
  {
    int i = this.av;
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
  
  public void a(View paramView)
  {
    if (!TextUtils.isEmpty(this.d))
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
            paramView.setBackgroundResource(2130838312);
            return;
          }
          paramView.setBackgroundResource(2130838313);
          return;
        }
        paramView.setBackgroundResource(2130838315);
        return;
      }
      paramView.setBackgroundResource(2130838314);
    }
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    Iterator localIterator = this.ax.iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramAbsShareMsg);
    }
  }
  
  public void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if (((paramAbsStructMsgElement instanceof AbsStructMsgTextElement)) && (!f())) {
      ((AbsStructMsgTextElement)paramAbsStructMsgElement).au = null;
    }
    this.ax.add(paramAbsStructMsgElement);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    this.a = paramObjectInput.readInt();
    if ((this.a > 0) && (this.a <= 18))
    {
      this.d = paramObjectInput.readUTF();
      this.e = paramObjectInput.readUTF();
      this.f = paramObjectInput.readUTF();
      this.g = paramObjectInput.readUTF();
      this.h = paramObjectInput.readUTF();
      this.i = paramObjectInput.readUTF();
      this.al = paramObjectInput.readInt();
      this.au = paramObjectInput.readInt();
      if ((2 <= this.a) && (this.a <= 18)) {
        this.av = paramObjectInput.readInt();
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
            ((AbsStructMsgElement)localObject).an = String.valueOf(i);
            ((AbsStructMsgElement)localObject).ap = this.ap;
            j = i + 1;
          }
          if ((localObject != null) && (AbsStructMsgItem.class.isInstance(localObject))) {
            paramObjectInput.readInt();
          }
          i = j;
        }
        str = e();
        if ((str != null) && (localObject != null) && ((localObject instanceof StructMsgItemCover))) {
          if ((!str.endsWith("Layout4")) && (!str.endsWith("Layout2")) && (!str.endsWith("Layout9")))
          {
            if (str.endsWith("Layout3")) {
              ((StructMsgItemCover)localObject).aC = StructMsgItemCover.aA;
            }
          }
          else {
            ((StructMsgItemCover)localObject).aC = StructMsgItemCover.az;
          }
        }
        if (localObject != null)
        {
          ((AbsStructMsgElement)localObject).as = this.as;
          ((AbsStructMsgElement)localObject).a(paramObjectInput);
          a((AbsStructMsgElement)localObject);
        }
        k += 1;
      }
      if ((this.a >= 3) && (this.a <= 18))
      {
        this.j = paramObjectInput.readUTF();
        if (this.a > 5)
        {
          this.l = paramObjectInput.readUTF();
          this.m = paramObjectInput.readUTF();
          this.n = paramObjectInput.readUTF();
        }
        if (this.a > 8) {
          this.k = paramObjectInput.readUTF();
        }
        if (this.a > 9)
        {
          this.p = paramObjectInput.readUTF();
          this.q = paramObjectInput.readUTF();
          this.r = paramObjectInput.readUTF();
          this.o = paramObjectInput.readUTF();
          this.s = paramObjectInput.readUTF();
        }
        if (this.a > 10)
        {
          this.t = paramObjectInput.readInt();
          this.u = paramObjectInput.readUTF();
          this.v = paramObjectInput.readUTF();
          this.w = paramObjectInput.readUTF();
          this.x = paramObjectInput.readUTF();
          this.y = paramObjectInput.readUTF();
          this.z = paramObjectInput.readInt();
          this.A = paramObjectInput.readUTF();
          this.B = paramObjectInput.readUTF();
          this.C = paramObjectInput.readUTF();
          this.D = paramObjectInput.readUTF();
          this.E = paramObjectInput.readUTF();
          this.F = paramObjectInput.readInt();
          this.G = paramObjectInput.readUTF();
          this.H = paramObjectInput.readUTF();
          this.I = paramObjectInput.readUTF();
          this.J = paramObjectInput.readUTF();
          this.K = paramObjectInput.readUTF();
          this.L = paramObjectInput.readUTF();
          this.M = paramObjectInput.readUTF();
          this.N = paramObjectInput.readUTF();
          this.O = paramObjectInput.readUTF();
        }
        if (this.a > 11)
        {
          this.Q = paramObjectInput.readUTF();
          this.R = paramObjectInput.readUTF();
          this.S = paramObjectInput.readUTF();
        }
        if (this.a > 12)
        {
          this.T = paramObjectInput.readUTF();
          this.U = paramObjectInput.readUTF();
        }
        if (this.a > 13) {
          this.P = paramObjectInput.readInt();
        }
        if (this.a > 14)
        {
          this.V = paramObjectInput.readInt();
          this.W = paramObjectInput.readInt();
        }
        if (this.a > 15)
        {
          this.X = paramObjectInput.readUTF();
          this.Y = paramObjectInput.readUTF();
          this.Z = paramObjectInput.readUTF();
          this.aa = paramObjectInput.readInt();
          this.ab = paramObjectInput.readInt();
          this.ac = paramObjectInput.readInt();
          this.ad = paramObjectInput.readInt();
          this.ae = paramObjectInput.readUTF();
          this.af = paramObjectInput.readUTF();
          this.ag = paramObjectInput.readUTF();
          this.ah = paramObjectInput.readUTF();
        }
        if (this.a > 16) {
          this.ai = paramObjectInput.readUTF();
        }
        if (this.a > 17)
        {
          this.aj = paramObjectInput.readUTF();
          this.ak = paramObjectInput.readUTF();
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
    paramObjectOutput.writeUTF(this.b);
    paramObjectOutput.writeInt(this.ay);
    paramObjectOutput.writeInt(this.a);
    Object localObject = this.d;
    String str1 = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = this.d;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.e == null) {
      localObject = "";
    } else {
      localObject = this.e;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.f == null) {
      localObject = "";
    } else {
      localObject = this.f;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.g == null) {
      localObject = "";
    } else {
      localObject = this.g;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.h == null) {
      localObject = "";
    } else {
      localObject = this.h;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.i == null) {
      localObject = "";
    } else {
      localObject = this.i;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.al);
    paramObjectOutput.writeInt(this.au);
    paramObjectOutput.writeInt(this.av);
    paramObjectOutput.writeInt(this.ax.size());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mVersion: ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("getStructMsgFromXmlBuff", 2, ((StringBuilder)localObject).toString());
    localObject = this.ax.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
    }
    if ((this.a >= 3) && (this.a <= 18))
    {
      if (this.j == null) {
        localObject = "";
      } else {
        localObject = this.j;
      }
      paramObjectOutput.writeUTF((String)localObject);
      if (this.a > 5)
      {
        if (this.l == null) {
          localObject = "";
        } else {
          localObject = this.l;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.m == null) {
          localObject = "";
        } else {
          localObject = this.m;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.n == null) {
          localObject = "";
        } else {
          localObject = this.n;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.a > 8)
      {
        if (this.k == null) {
          localObject = "";
        } else {
          localObject = this.k;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.a > 9)
      {
        if (this.p == null) {
          localObject = "";
        } else {
          localObject = this.p;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.q == null) {
          localObject = "";
        } else {
          localObject = this.q;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.r == null) {
          localObject = "";
        } else {
          localObject = this.r;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.o == null) {
          localObject = "";
        } else {
          localObject = this.o;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.s == null) {
          localObject = "";
        } else {
          localObject = this.s;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.a > 10)
      {
        paramObjectOutput.writeInt(this.t);
        localObject = this.u;
        String str2 = "0";
        if (localObject == null) {
          localObject = "0";
        } else {
          localObject = this.u;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.v == null) {
          localObject = str2;
        } else {
          localObject = this.v;
        }
        paramObjectOutput.writeUTF((String)localObject);
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
        paramObjectOutput.writeInt(this.z);
        if (this.A == null) {
          localObject = "";
        } else {
          localObject = this.A;
        }
        paramObjectOutput.writeUTF((String)localObject);
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
        paramObjectOutput.writeInt(this.F);
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
      if (this.a > 11)
      {
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
        if (this.S == null) {
          localObject = "";
        } else {
          localObject = this.S;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.a > 12)
      {
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
      }
      if (this.a > 13) {
        paramObjectOutput.writeInt(this.P);
      }
      if (this.a > 14)
      {
        paramObjectOutput.writeInt(this.V);
        paramObjectOutput.writeInt(this.W);
      }
      if (this.a > 15)
      {
        if (this.X == null) {
          localObject = "";
        } else {
          localObject = this.X;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.Y == null) {
          localObject = "";
        } else {
          localObject = this.Y;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.Z == null) {
          localObject = "";
        } else {
          localObject = this.Z;
        }
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.aa);
        paramObjectOutput.writeInt(this.ab);
        paramObjectOutput.writeInt(this.ac);
        paramObjectOutput.writeInt(this.ad);
        if (this.ae == null) {
          localObject = "";
        } else {
          localObject = this.ae;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.af == null) {
          localObject = "";
        } else {
          localObject = this.af;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.ag == null) {
          localObject = "";
        } else {
          localObject = this.ag;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.ah == null) {
          localObject = "";
        } else {
          localObject = this.ah;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.a > 16)
      {
        if (this.ai == null) {
          localObject = "";
        } else {
          localObject = this.ai;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.a > 17)
      {
        if (this.aj == null) {
          localObject = "";
        } else {
          localObject = this.aj;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (this.ak == null) {
          localObject = str1;
        } else {
          localObject = this.ak;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.au = paramInt;
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
    this.au = paramInt;
    a(new StructMsgItemCover(paramString1, paramString4));
    a(new StructMsgItemTitle(paramString2));
    a(new StructMsgItemSummary(paramString3));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.au = paramInt;
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
    paramXmlSerializer.startTag(null, this.b);
    int i = this.ay;
    if (i < 0) {
      localObject = "0";
    } else {
      localObject = String.valueOf(i);
    }
    paramXmlSerializer.attribute(null, "layout", (String)localObject);
    if (!TextUtils.isEmpty(this.e)) {
      paramXmlSerializer.attribute(null, "action", this.e);
    }
    if (!TextUtils.isEmpty(this.f)) {
      paramXmlSerializer.attribute(null, "actionData", this.f);
    }
    if (!TextUtils.isEmpty(this.g)) {
      paramXmlSerializer.attribute(null, "a_actionData", this.g);
    }
    if (!TextUtils.isEmpty(this.h)) {
      paramXmlSerializer.attribute(null, "i_actionData", this.h);
    }
    if (!TextUtils.isEmpty(this.d)) {
      paramXmlSerializer.attribute(null, "url", this.d);
    }
    if (!TextUtils.isEmpty(this.i)) {
      paramXmlSerializer.attribute(null, "brief", this.i);
    }
    if (this.al != 0) {
      paramXmlSerializer.attribute(null, "flag", String.valueOf(this.al));
    }
    i = this.au;
    if (i != 0) {
      paramXmlSerializer.attribute(null, "mode", String.valueOf(i));
    }
    i = this.av;
    if (i != 0) {
      paramXmlSerializer.attribute(null, "bg", String.valueOf(i));
    }
    if (!TextUtils.isEmpty(this.j)) {
      paramXmlSerializer.attribute(null, "businessData", this.j);
    }
    if (!TextUtils.isEmpty(this.k)) {
      paramXmlSerializer.attribute(null, "commonData", this.k);
    }
    if (!TextUtils.isEmpty(this.l)) {
      paramXmlSerializer.attribute(null, "index", this.l);
    }
    if (!TextUtils.isEmpty(this.m)) {
      paramXmlSerializer.attribute(null, "index_name", this.m);
    }
    if (!TextUtils.isEmpty(this.n)) {
      paramXmlSerializer.attribute(null, "index_type", this.n);
    }
    if (!TextUtils.isEmpty(this.q)) {
      paramXmlSerializer.attribute(null, "canvas", this.q);
    }
    if (!TextUtils.isEmpty(this.o)) {
      paramXmlSerializer.attribute(null, "rurl", this.o);
    }
    if (!TextUtils.isEmpty(this.r)) {
      paramXmlSerializer.attribute(null, "disType", this.r);
    }
    if (!TextUtils.isEmpty(this.p)) {
      paramXmlSerializer.attribute(null, "tid", this.p);
    }
    if (!TextUtils.isEmpty(this.s)) {
      paramXmlSerializer.attribute(null, "apurl", this.s);
    }
    if (this.t != 0) {
      paramXmlSerializer.attribute(null, "action_type", String.valueOf(this.t));
    }
    if (!TextUtils.isEmpty(this.u)) {
      paramXmlSerializer.attribute(null, "advertiser_id", this.u);
    }
    if (!TextUtils.isEmpty(this.v)) {
      paramXmlSerializer.attribute(null, "aid", this.v);
    }
    if (!TextUtils.isEmpty(this.w)) {
      paramXmlSerializer.attribute(null, "app_download_schema", this.w);
    }
    if (!TextUtils.isEmpty(this.x)) {
      paramXmlSerializer.attribute(null, "canvas_json", this.x);
    }
    if (!TextUtils.isEmpty(this.y)) {
      paramXmlSerializer.attribute(null, "customized_invoke_url", this.y);
    }
    if (this.z != 0) {
      paramXmlSerializer.attribute(null, "dest_type", String.valueOf(this.z));
    }
    if (!TextUtils.isEmpty(this.A)) {
      paramXmlSerializer.attribute(null, "effect_url", this.A);
    }
    if (!TextUtils.isEmpty(this.B)) {
      paramXmlSerializer.attribute(null, "landing_page", this.B);
    }
    if (!TextUtils.isEmpty(this.C)) {
      paramXmlSerializer.attribute(null, "landing_page_report_url", this.C);
    }
    if (!TextUtils.isEmpty(this.D)) {
      paramXmlSerializer.attribute(null, "noco_id", this.D);
    }
    if (!TextUtils.isEmpty(this.E)) {
      paramXmlSerializer.attribute(null, "product_id", this.E);
    }
    if (this.F != 0) {
      paramXmlSerializer.attribute(null, "product_type", String.valueOf(this.F));
    }
    if (this.P != 0) {
      paramXmlSerializer.attribute(null, "mini_program_type", String.valueOf(this.P));
    }
    if (!TextUtils.isEmpty(this.G)) {
      paramXmlSerializer.attribute(null, "rl", this.G);
    }
    if (!TextUtils.isEmpty(this.H)) {
      paramXmlSerializer.attribute(null, "subordinate_product_id", this.H);
    }
    if (!TextUtils.isEmpty(this.I)) {
      paramXmlSerializer.attribute(null, "traceid", this.I);
    }
    if (!TextUtils.isEmpty(this.J)) {
      paramXmlSerializer.attribute(null, "via", this.J);
    }
    if (!TextUtils.isEmpty(this.K)) {
      paramXmlSerializer.attribute(null, "video_url", this.K);
    }
    if (!TextUtils.isEmpty(this.L)) {
      paramXmlSerializer.attribute(null, "appname", this.L);
    }
    if (!TextUtils.isEmpty(this.M)) {
      paramXmlSerializer.attribute(null, "customized_invoke_url", this.M);
    }
    if (!TextUtils.isEmpty(this.N)) {
      paramXmlSerializer.attribute(null, "pkg_name", this.N);
    }
    if (!TextUtils.isEmpty(this.O)) {
      paramXmlSerializer.attribute(null, "pkgurl", this.O);
    }
    if (!TextUtils.isEmpty(this.R)) {
      paramXmlSerializer.attribute(null, "api_exposure_monitor_url", this.R);
    }
    if (!TextUtils.isEmpty(this.Q)) {
      paramXmlSerializer.attribute(null, "api_click_monitor_url", this.Q);
    }
    if (!TextUtils.isEmpty(this.S)) {
      paramXmlSerializer.attribute(null, "trace_info_aid", this.S);
    }
    if (!TextUtils.isEmpty(this.T)) {
      paramXmlSerializer.attribute(null, "corporate_image_name", this.T);
    }
    if (!TextUtils.isEmpty(this.U)) {
      paramXmlSerializer.attribute(null, "corporate_logo", this.U);
    }
    if (this.V != 0) {
      paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.V));
    }
    if (this.W != 0) {
      paramXmlSerializer.attribute(null, "is_hidden", String.valueOf(this.W));
    }
    if (!TextUtils.isEmpty(this.X)) {
      paramXmlSerializer.attribute(null, "negative_feedback_url", this.X);
    }
    if (!TextUtils.isEmpty(this.Y)) {
      paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.Y);
    }
    if (!TextUtils.isEmpty(this.Z)) {
      paramXmlSerializer.attribute(null, "sdk_click_monitor_url", this.Z);
    }
    if (this.aa != 0) {
      paramXmlSerializer.attribute(null, "media_duration", String.valueOf(this.aa));
    }
    if (this.ab != 0) {
      paramXmlSerializer.attribute(null, "video_file_size", String.valueOf(this.ab));
    }
    if (this.ac != 0) {
      paramXmlSerializer.attribute(null, "app_score_num", String.valueOf(this.ac));
    }
    if (this.ad != 0) {
      paramXmlSerializer.attribute(null, "download_num", String.valueOf(this.ad));
    }
    if (!TextUtils.isEmpty(this.ae)) {
      paramXmlSerializer.attribute(null, "universal_link", this.ae);
    }
    if (!TextUtils.isEmpty(this.af)) {
      paramXmlSerializer.attribute(null, "sdk_data", this.af);
    }
    if (!TextUtils.isEmpty(this.ag)) {
      paramXmlSerializer.attribute(null, "tencent_video_id", this.ag);
    }
    if (!TextUtils.isEmpty(this.ah)) {
      paramXmlSerializer.attribute(null, "view_id", this.ah);
    }
    if (!TextUtils.isEmpty(this.ai)) {
      paramXmlSerializer.attribute(null, "qgg_ext", this.ai);
    }
    if (!TextUtils.isEmpty(this.aj)) {
      paramXmlSerializer.attribute(null, "adInfo", this.aj);
    }
    if (!TextUtils.isEmpty(this.ak)) {
      paramXmlSerializer.attribute(null, "is_report_click", this.ak);
    }
    Object localObject = this.ax.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, this.b);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.e = paramStructMsgNode.a("action");
    this.f = paramStructMsgNode.a("actionData");
    this.g = paramStructMsgNode.a("a_actionData");
    this.h = paramStructMsgNode.a("i_actionData");
    this.d = paramStructMsgNode.a("url");
    this.i = paramStructMsgNode.a("brief");
    this.s = paramStructMsgNode.a("apurl");
    Object localObject1 = paramStructMsgNode.a("flag");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.al = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label112:
      break label112;
    }
    this.al = 0;
    localObject1 = paramStructMsgNode.a("mode");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      this.au = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      label146:
      break label146;
    }
    this.au = 0;
    localObject1 = paramStructMsgNode.a("bg");
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label249;
      }
      if (((String)localObject1).startsWith("#")) {
        this.av = Color.parseColor((String)localObject1);
      } else {
        this.av = Integer.parseInt((String)localObject1);
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
      ((StringBuilder)localObject1).append(this.av);
      QLog.i("AbsStructMsgItem", 2, ((StringBuilder)localObject1).toString());
    }
    this.j = paramStructMsgNode.a("businessData");
    this.k = paramStructMsgNode.a("commonData");
    this.l = paramStructMsgNode.a("index");
    this.m = paramStructMsgNode.a("index_name");
    this.n = paramStructMsgNode.a("index_type");
    this.q = paramStructMsgNode.a("canvas");
    this.o = paramStructMsgNode.a("rurl");
    this.r = paramStructMsgNode.a("disType");
    this.p = paramStructMsgNode.a("tid");
    if (this.a > 10)
    {
      localObject1 = paramStructMsgNode.e;
      if (localObject1 != null)
      {
        localObject2 = ((StructMsgNode)localObject1).a("action_type");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
    }
    try
    {
      this.t = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException5)
    {
      label398:
      label433:
      break label398;
    }
    this.t = 0;
    localObject2 = ((StructMsgNode)localObject1).a("dest_type");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      this.z = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException6)
    {
      break label433;
    }
    this.z = 0;
    localObject2 = ((StructMsgNode)localObject1).a("product_type");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      this.F = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException7)
    {
      label468:
      break label468;
    }
    this.F = 0;
    this.u = ((StructMsgNode)localObject1).a("advertiser_id");
    this.v = ((StructMsgNode)localObject1).a("aid");
    this.w = ((StructMsgNode)localObject1).a("app_download_schema");
    this.x = ((StructMsgNode)localObject1).a("canvas_json");
    this.y = ((StructMsgNode)localObject1).a("customized_invoke_url");
    this.A = ((StructMsgNode)localObject1).a("effect_url");
    this.B = ((StructMsgNode)localObject1).a("landing_page");
    this.C = ((StructMsgNode)localObject1).a("landing_page_report_url");
    this.D = ((StructMsgNode)localObject1).a("noco_id");
    this.E = ((StructMsgNode)localObject1).a("product_id");
    this.G = ((StructMsgNode)localObject1).a("rl");
    this.H = ((StructMsgNode)localObject1).a("subordinate_product_id");
    this.I = ((StructMsgNode)localObject1).a("traceid");
    this.J = ((StructMsgNode)localObject1).a("via");
    this.K = ((StructMsgNode)localObject1).a("video_url");
    this.L = ((StructMsgNode)localObject1).a("appname");
    this.M = ((StructMsgNode)localObject1).a("customized_invoke_url");
    this.N = ((StructMsgNode)localObject1).a("pkg_name");
    this.O = ((StructMsgNode)localObject1).a("pkgurl");
    this.s = ((StructMsgNode)localObject1).a("apurl");
    if (this.a > 11)
    {
      localObject1 = paramStructMsgNode.e;
      if (localObject1 != null)
      {
        this.Q = ((StructMsgNode)localObject1).a("api_click_monitor_url");
        this.R = ((StructMsgNode)localObject1).a("api_exposure_monitor_url");
        this.S = ((StructMsgNode)localObject1).a("trace_info_aid");
      }
    }
    if (this.a > 12)
    {
      localObject1 = paramStructMsgNode.e;
      if (localObject1 != null)
      {
        this.T = ((StructMsgNode)localObject1).a("corporate_image_name");
        this.U = ((StructMsgNode)localObject1).a("corporate_logo");
      }
    }
    if (this.a > 13)
    {
      localObject1 = paramStructMsgNode.e.a("mini_program_type");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      this.P = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      label854:
      break label854;
    }
    this.P = 0;
    if (this.a > 14)
    {
      localObject1 = paramStructMsgNode.e;
      if (localObject1 != null)
      {
        localObject2 = ((StructMsgNode)localObject1).a("tab_id");
        if (StringUtil.isEmpty((String)localObject2)) {}
      }
    }
    try
    {
      this.V = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException8)
    {
      label909:
      label944:
      break label909;
    }
    this.V = 0;
    localObject1 = ((StructMsgNode)localObject1).a("is_hidden");
    if (!StringUtil.isEmpty((String)localObject1)) {}
    try
    {
      this.W = Integer.parseInt((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException4)
    {
      break label944;
    }
    this.W = 0;
    if (this.a > 15)
    {
      localObject1 = paramStructMsgNode.e;
      this.X = ((StructMsgNode)localObject1).a("negative_feedback_url");
      this.Y = ((StructMsgNode)localObject1).a("sdk_exposure_monitor_url");
      this.Z = ((StructMsgNode)localObject1).a("sdk_click_monitor_url");
      localObject2 = ((StructMsgNode)localObject1).a("media_duration");
      if (StringUtil.isEmpty((String)localObject2)) {}
    }
    try
    {
      this.aa = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException9)
    {
      label1030:
      break label1030;
    }
    this.aa = 0;
    localObject2 = ((StructMsgNode)localObject1).a("video_file_size");
    if (!StringUtil.isEmpty((String)localObject2)) {}
    try
    {
      this.ab = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException10)
    {
      label1065:
      break label1065;
    }
    this.ab = 0;
    localObject2 = ((StructMsgNode)localObject1).a("app_score_num");
    if (!StringUtil.isEmpty((String)localObject2)) {}
    try
    {
      this.ac = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException11)
    {
      label1100:
      break label1100;
    }
    this.ac = 0;
    localObject2 = ((StructMsgNode)localObject1).a("download_num");
    if (!StringUtil.isEmpty((String)localObject2)) {}
    try
    {
      this.ad = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException12)
    {
      label1135:
      int k;
      int i;
      break label1135;
    }
    this.ad = 0;
    this.ae = ((StructMsgNode)localObject1).a("universal_link");
    this.af = ((StructMsgNode)localObject1).a("sdk_data");
    this.ag = ((StructMsgNode)localObject1).a("tencent_video_id");
    this.ah = ((StructMsgNode)localObject1).a("view_id");
    if (this.a > 16) {
      this.ai = paramStructMsgNode.e.a("qgg_ext");
    }
    if (this.a > 17)
    {
      localObject1 = paramStructMsgNode.e;
      this.aj = ((StructMsgNode)localObject1).a("adInfo");
      this.ak = ((StructMsgNode)localObject1).a("is_report_click");
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
  
  public abstract View b(Context paramContext, View paramView, Bundle paramBundle);
  
  public String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(e());
    localStringBuffer.append(this.au);
    Object localObject = this.ax;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuffer.append(((AbsStructMsgElement)((Iterator)localObject).next()).b());
      }
    }
    return localStringBuffer.toString();
  }
  
  public void b(View paramView)
  {
    if (!TextUtils.isEmpty(this.d))
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
              paramView.setBackgroundResource(2130838312);
            }
          }
          else {
            paramView.setBackgroundResource(2130838313);
          }
        }
        else {
          paramView.setBackgroundResource(2130838315);
        }
      }
      else {
        paramView.setBackgroundResource(2130838314);
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setPadding(i, j, k, m);
      localObject = paramView.findViewById(2131435545);
      if ((localObject != null) && ((localObject instanceof PAHighLightImageView)))
      {
        ((PAHighLightImageView)localObject).a();
        return;
      }
      paramView = paramView.findViewById(2131446464);
      if ((paramView != null) && ((paramView instanceof PAHighLightImageView))) {
        ((PAHighLightImageView)paramView).a();
      }
    }
  }
  
  public void b(String paramString)
  {
    a(new StructMsgItemSummary(paramString));
    a(new StructMsgItemHr());
  }
  
  protected abstract int c();
  
  public void c(int paramInt)
  {
    this.au = paramInt;
  }
  
  public void c(View paramView)
  {
    if (!TextUtils.isEmpty(this.d))
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
              paramView.setBackgroundResource(2130838328);
            }
          }
          else {
            paramView.setBackgroundResource(2130838325);
          }
        }
        else {
          paramView.setBackgroundResource(2130838329);
        }
      }
      else {
        paramView.setBackgroundResource(2130838326);
      }
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(i, j, k, m);
    }
  }
  
  public void c(String paramString)
  {
    this.ay = 0;
    a(new StructMsgItemImage(paramString));
  }
  
  @TargetApi(16)
  protected void d(View paramView)
  {
    if ((f()) && (d()))
    {
      int i = this.av;
      if (i != 1)
      {
        if (i == 2) {
          if (!TextUtils.isEmpty(this.d)) {
            this.aw = 2130838317;
          } else {
            this.aw = 2130838331;
          }
        }
      }
      else if (!TextUtils.isEmpty(this.d)) {
        this.aw = 2130838316;
      } else {
        this.aw = 2130838330;
      }
      if ((paramView != null) && (a() == 1))
      {
        i = this.aw;
        if (i != 0)
        {
          paramView.setBackgroundResource(i);
          return;
        }
        paramView.setBackgroundResource(2130838315);
      }
    }
    else if ((d()) && (this.av != 0))
    {
      float f = AIOUtils.b(4.0F, paramView.getResources());
      StateListDrawable localStateListDrawable = StructMsgUtils.a(paramView.getResources(), this.av, new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
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
  
  public boolean d()
  {
    return a() == 1;
  }
  
  public abstract String e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgItem
 * JD-Core Version:    0.7.0.1
 */