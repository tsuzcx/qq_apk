package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.app.MobileQQ;

public class ContactSearchableFriend
  extends IContactSearchable
{
  public String a;
  private Friends af;
  private String ag;
  private int ah;
  private String ai;
  private QQAppInterface aj;
  public String b;
  public String c;
  public String d;
  
  @SuppressLint({"DefaultLocale"})
  public ContactSearchableFriend(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong1, long paramLong2)
  {
    this.af = paramFriends;
    this.ae = paramLong2;
    this.ag = paramString;
    this.aj = paramQQAppInterface;
    if ((this.af.remark != null) && (this.af.remark.length() != 0))
    {
      this.a = ChnToSpell.b(this.af.remark, 1).toLowerCase();
      this.b = ChnToSpell.b(this.af.remark, 2).toLowerCase();
    }
    if ((this.af.name != null) && (this.af.name.length() != 0))
    {
      this.c = ChnToSpell.b(this.af.name, 1).toLowerCase();
      this.d = ChnToSpell.b(this.af.name, 2).toLowerCase();
    }
    p();
  }
  
  private String r()
  {
    if (!TextUtils.isEmpty(this.af.alias)) {
      return this.af.alias;
    }
    return this.af.uin;
  }
  
  public String a()
  {
    if (CrmUtils.a(this.aj, this.af.uin, 0)) {
      return this.aj.getApplication().getString(2131886307);
    }
    return this.ag;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    String str1 = this.af.remark;
    String str4 = null;
    if (str1 != null) {
      str1 = this.af.remark.toLowerCase();
    } else {
      str1 = null;
    }
    String str2;
    if (this.af.name != null) {
      str2 = this.af.name.toLowerCase();
    } else {
      str2 = null;
    }
    String str3;
    if (this.af.uin != null) {
      str3 = this.af.uin;
    } else {
      str3 = null;
    }
    if (this.af.alias != null) {
      str4 = this.af.alias;
    }
    String str5 = this.a;
    String str6 = this.b;
    String str7 = this.c;
    String str8 = this.d;
    paramString = paramString.toLowerCase();
    this.ad = -9223372036854775808L;
    int k = -1;
    int m;
    int i;
    int j;
    if ((str1 != null) && (str1.length() != 0))
    {
      if ((!str1.equals(paramString)) && ((str5 == null) || (!str5.equals(paramString))) && ((str6 == null) || (!str6.equals(paramString))))
      {
        m = str1.indexOf(paramString);
        if (str5 != null) {
          i = str5.indexOf(paramString);
        } else {
          i = -1;
        }
        if (str6 != null) {
          j = str6.indexOf(paramString);
        } else {
          j = -1;
        }
        if ((m < 0) && (i < 0) && (j < 0))
        {
          l1 = -9223372036854775808L;
        }
        else
        {
          if ((m != 0) && (i != 0) && (j != 0)) {
            l1 = IContactSearchable.A;
          } else {
            l1 = IContactSearchable.z;
          }
          if ((m < 0) && (!str1.equals(str5))) {
            l2 = IContactSearchable.w;
          } else {
            l2 = IContactSearchable.v;
          }
          l1 = l1 + l2 + 0L;
        }
      }
      else
      {
        l2 = IContactSearchable.y;
        if ((!str1.equals(paramString)) && (!str1.equals(str5))) {
          l1 = IContactSearchable.w;
        } else {
          l1 = IContactSearchable.v;
        }
        l1 = l2 + l1 + 0L;
      }
      l2 = l1;
      if (this.ad < l1)
      {
        this.ad = l1;
        this.ah = 2;
        l2 = l1;
      }
    }
    else
    {
      l2 = -9223372036854775808L;
    }
    long l1 = l2;
    if (str2 != null)
    {
      l1 = l2;
      if (str2.length() != 0)
      {
        if ((!str2.equals(paramString)) && ((str7 == null) || (!str7.equals(paramString))) && ((str8 == null) || (!str8.equals(paramString))))
        {
          m = str2.indexOf(paramString);
          if (str7 != null) {
            i = str7.indexOf(paramString);
          } else {
            i = -1;
          }
          j = k;
          if (str8 != null) {
            j = str8.indexOf(paramString);
          }
          if ((m < 0) && (i < 0) && (j < 0)) {
            break label670;
          }
          if ((m != 0) && (i != 0) && (j != 0)) {
            l1 = IContactSearchable.A;
          } else {
            l1 = IContactSearchable.z;
          }
          if ((m < 0) && (!str2.equals(str7))) {
            l2 = IContactSearchable.w;
          } else {
            l2 = IContactSearchable.v;
          }
          l1 += l2;
          TextUtils.isEmpty(this.af.remark);
        }
        else
        {
          l2 = IContactSearchable.y;
          if ((!str2.equals(paramString)) && (!str2.equals(str7))) {
            l1 = IContactSearchable.w;
          } else {
            l1 = IContactSearchable.v;
          }
          l1 = l2 + l1;
          TextUtils.isEmpty(this.af.remark);
        }
        l2 = l1 + 0L;
        label670:
        l1 = l2;
        if (this.ad < l2)
        {
          this.ad = l2;
          this.ah = 1;
          l1 = l2;
        }
      }
    }
    long l2 = l1;
    if (str4 != null)
    {
      l2 = l1;
      if (str4.length() != 0)
      {
        if (str4.equals(paramString))
        {
          l2 = IContactSearchable.y + IContactSearchable.v;
          l1 = l2;
          if (TextUtils.isEmpty(this.af.remark))
          {
            TextUtils.isEmpty(this.af.name);
            l1 = l2;
          }
        }
        for (;;)
        {
          l1 += 0L;
          break;
          if (str4.indexOf(paramString) < 0) {
            break;
          }
          l2 = IContactSearchable.A + IContactSearchable.v;
          l1 = l2;
          if (TextUtils.isEmpty(this.af.remark))
          {
            TextUtils.isEmpty(this.af.name);
            l1 = l2;
          }
        }
        l2 = l1;
        if (this.ad < l1)
        {
          this.ad = l1;
          this.ah = 3;
          l2 = l1;
        }
      }
    }
    if (1 != this.af.cSpecialFlag)
    {
      l1 = l2;
      if (str3 != null)
      {
        if (str3.equals(paramString))
        {
          l2 = IContactSearchable.y + IContactSearchable.v;
          l1 = l2;
          if (TextUtils.isEmpty(this.af.remark))
          {
            TextUtils.isEmpty(this.af.name);
            l1 = l2;
          }
        }
        for (;;)
        {
          l1 += 0L;
          break;
          i = str3.indexOf(paramString);
          l1 = l2;
          if (i < 0) {
            break;
          }
          if (i == 0) {
            l1 = IContactSearchable.z;
          } else {
            l1 = IContactSearchable.A;
          }
          l2 = l1 + IContactSearchable.v;
          l1 = l2;
          if (TextUtils.isEmpty(this.af.remark))
          {
            TextUtils.isEmpty(this.af.name);
            l1 = l2;
          }
        }
      }
      if (this.ad < l1)
      {
        this.ad = l1;
        this.ah = 0;
      }
    }
    if (this.ad != -9223372036854775808L) {
      this.ad += this.ae;
    }
  }
  
  public String b()
  {
    String str = this.ai;
    if (str != null) {
      return String.format("(%s)", new Object[] { str });
    }
    return null;
  }
  
  public String c()
  {
    String str1 = this.af.remark;
    String str3 = this.af.name;
    String str4 = this.af.alias;
    String str2 = this.af.uin;
    int i = this.ah;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          if (((str3 != null) && (str3.length() != 0)) || ((str1 != null) && (str1.length() != 0)))
          {
            str1 = String.format("%s", new Object[] { ContactUtils.a(this.af) });
            this.ai = str4;
            return str1;
          }
          return str4;
        }
        str2 = str1;
        if (str3 != null)
        {
          str2 = str1;
          if (str3.length() != 0)
          {
            str1 = String.format("%s", new Object[] { str1 });
            this.ai = str3;
            return str1;
          }
        }
      }
      else
      {
        if ((str1 != null) && (str1.length() != 0))
        {
          str1 = String.format("%s", new Object[] { str1 });
          this.ai = str3;
          return str1;
        }
        str1 = String.format("%s", new Object[] { str3 });
        this.ai = r();
        return str1;
      }
    }
    else if (((str3 != null) && (str3.length() != 0)) || ((str1 != null) && (str1.length() != 0)))
    {
      str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = str3;
      }
      str1 = String.format("%s", new Object[] { str2 });
      this.ai = r();
      return str1;
    }
    return str2;
  }
  
  public String d()
  {
    return "";
  }
  
  public int e()
  {
    return this.ah;
  }
  
  protected long f()
  {
    Message localMessage = this.aj.getMessageFacade().getLastMessage(this.af.uin, 0);
    if (localMessage != null) {
      return localMessage.time;
    }
    return 0L;
  }
  
  public int g()
  {
    return 0;
  }
  
  public Friends h()
  {
    return this.af;
  }
  
  public Drawable i()
  {
    return null;
  }
  
  public String j()
  {
    return this.af.uin;
  }
  
  public int k()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableFriend
 * JD-Core Version:    0.7.0.1
 */