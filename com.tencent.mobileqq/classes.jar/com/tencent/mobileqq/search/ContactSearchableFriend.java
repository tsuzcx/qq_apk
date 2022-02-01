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
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  public String a;
  public String b;
  public String c;
  public String d;
  private String e;
  private String f;
  
  @SuppressLint({"DefaultLocale"})
  public ContactSearchableFriend(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    this.aa = paramLong2;
    this.e = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.length() != 0))
    {
      this.jdField_a_of_type_JavaLangString = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, 1).toLowerCase();
      this.b = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, 2).toLowerCase();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.name != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.length() != 0))
    {
      this.c = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, 1).toLowerCase();
      this.d = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, 2).toLowerCase();
    }
    b();
  }
  
  private String f()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected long a()
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 0);
    if (localMessage != null) {
      return localMessage.time;
    }
    return 0L;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public Friends a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends;
  }
  
  public String a()
  {
    if (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 0)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689695);
    }
    return this.e;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
    String str4 = null;
    if (str1 != null) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.toLowerCase();
    } else {
      str1 = null;
    }
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name != null) {
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.toLowerCase();
    } else {
      str2 = null;
    }
    String str3;
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin != null) {
      str3 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
    } else {
      str3 = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias != null) {
      str4 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    }
    String str5 = this.jdField_a_of_type_JavaLangString;
    String str6 = this.b;
    String str7 = this.c;
    String str8 = this.d;
    paramString = paramString.toLowerCase();
    this.Z = -9223372036854775808L;
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
            l1 = IContactSearchable.w;
          } else {
            l1 = IContactSearchable.v;
          }
          if ((m < 0) && (!str1.equals(str5))) {
            l2 = IContactSearchable.s;
          } else {
            l2 = IContactSearchable.r;
          }
          l1 = l1 + l2 + 0L;
        }
      }
      else
      {
        l2 = IContactSearchable.u;
        if ((!str1.equals(paramString)) && (!str1.equals(str5))) {
          l1 = IContactSearchable.s;
        } else {
          l1 = IContactSearchable.r;
        }
        l1 = l2 + l1 + 0L;
      }
      l2 = l1;
      if (this.Z < l1)
      {
        this.Z = l1;
        this.jdField_a_of_type_Int = 2;
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
            l1 = IContactSearchable.w;
          } else {
            l1 = IContactSearchable.v;
          }
          if ((m < 0) && (!str2.equals(str7))) {
            l2 = IContactSearchable.s;
          } else {
            l2 = IContactSearchable.r;
          }
          l1 += l2;
          TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark);
        }
        else
        {
          l2 = IContactSearchable.u;
          if ((!str2.equals(paramString)) && (!str2.equals(str7))) {
            l1 = IContactSearchable.s;
          } else {
            l1 = IContactSearchable.r;
          }
          l1 = l2 + l1;
          TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark);
        }
        l2 = l1 + 0L;
        label670:
        l1 = l2;
        if (this.Z < l2)
        {
          this.Z = l2;
          this.jdField_a_of_type_Int = 1;
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
          l2 = IContactSearchable.u + IContactSearchable.r;
          l1 = l2;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark))
          {
            TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name);
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
          l2 = IContactSearchable.w + IContactSearchable.r;
          l1 = l2;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark))
          {
            TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name);
            l1 = l2;
          }
        }
        l2 = l1;
        if (this.Z < l1)
        {
          this.Z = l1;
          this.jdField_a_of_type_Int = 3;
          l2 = l1;
        }
      }
    }
    if (1 != this.jdField_a_of_type_ComTencentMobileqqDataFriends.cSpecialFlag)
    {
      l1 = l2;
      if (str3 != null)
      {
        if (str3.equals(paramString))
        {
          l2 = IContactSearchable.u + IContactSearchable.r;
          l1 = l2;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark))
          {
            TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name);
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
            l1 = IContactSearchable.v;
          } else {
            l1 = IContactSearchable.w;
          }
          l2 = l1 + IContactSearchable.r;
          l1 = l2;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark))
          {
            TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name);
            l1 = l2;
          }
        }
      }
      if (this.Z < l1)
      {
        this.Z = l1;
        this.jdField_a_of_type_Int = 0;
      }
    }
    if (this.Z != -9223372036854775808L) {
      this.Z += this.aa;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    String str = this.f;
    if (str != null) {
      return String.format("(%s)", new Object[] { str });
    }
    return null;
  }
  
  public int c()
  {
    return 1;
  }
  
  public String c()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
    String str3 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
    String str4 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
    int i = this.jdField_a_of_type_Int;
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
            str1 = String.format("%s", new Object[] { ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends) });
            this.f = str4;
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
            this.f = str3;
            return str1;
          }
        }
      }
      else
      {
        if ((str1 != null) && (str1.length() != 0))
        {
          str1 = String.format("%s", new Object[] { str1 });
          this.f = str3;
          return str1;
        }
        str1 = String.format("%s", new Object[] { str3 });
        this.f = f();
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
      this.f = f();
      return str1;
    }
    return str2;
  }
  
  public String d()
  {
    return "";
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableFriend
 * JD-Core Version:    0.7.0.1
 */