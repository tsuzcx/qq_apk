package com.tencent.mobileqq.newfriend.config;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class NewFriendContactGuideConfBean
{
  private static final String i = HardCodeUtil.a(2131892507);
  private static final String j = HardCodeUtil.a(2131892506);
  private static final String k = HardCodeUtil.a(2131892504);
  private static final String l = HardCodeUtil.a(2131892512);
  private static final String m = HardCodeUtil.a(2131892511);
  private static final String n = HardCodeUtil.a(2131892509);
  private static final String o = HardCodeUtil.a(2131892508);
  private static final String p = HardCodeUtil.a(2131892505);
  private static final String q = HardCodeUtil.a(2131892513);
  private static final String r = HardCodeUtil.a(2131892510);
  private static final String s = HardCodeUtil.a(2131892502);
  private static final String t = HardCodeUtil.a(2131892501);
  private static final String u = HardCodeUtil.a(2131892515);
  private static final String v = HardCodeUtil.a(2131892514);
  public boolean a = false;
  public int b = 3;
  public final NewFriendContactGuideConfBean.UIElement c = new NewFriendContactGuideConfBean.UIElement(i, j, k);
  public final NewFriendContactGuideConfBean.UIElement d = new NewFriendContactGuideConfBean.UIElement(l, m, n);
  public final NewFriendContactGuideConfBean.UIElement e = new NewFriendContactGuideConfBean.UIElement(o, "", p);
  public final NewFriendContactGuideConfBean.UIElement f = new NewFriendContactGuideConfBean.UIElement(q, "", r);
  public final NewFriendContactGuideConfBean.UIElement g = new NewFriendContactGuideConfBean.UIElement(s, "", t);
  public final NewFriendContactGuideConfBean.UIElement h = new NewFriendContactGuideConfBean.UIElement(u, "", v);
  
  public static NewFriendContactGuideConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    NewFriendContactGuideConfBean localNewFriendContactGuideConfBean = new NewFriendContactGuideConfBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int i2 = paramArrayOfQConfItem.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramArrayOfQConfItem[i1];
        if (localObject != null)
        {
          localObject = ((QConfItem)localObject).b;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localNewFriendContactGuideConfBean.a = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localNewFriendContactGuideConfBean.b = localJSONObject.optInt("totalCount", 0);
            a(localNewFriendContactGuideConfBean.c, localJSONObject.optJSONObject("unauthorized"), i, j, k);
            a(localNewFriendContactGuideConfBean.d, localJSONObject.optJSONObject("unbound"), l, m, k);
            a(localNewFriendContactGuideConfBean.e, localJSONObject.optJSONObject("contactsListUnauthorized"), o, "", p);
            a(localNewFriendContactGuideConfBean.f, localJSONObject.optJSONObject("contactsListUnbinding"), q, "", r);
            a(localNewFriendContactGuideConfBean.g, localJSONObject.optJSONObject("contactsListInactive"), s, "", t);
            a(localNewFriendContactGuideConfBean.h, localJSONObject.optJSONObject("contactsListUnmatched"), u, "", v);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse: ");
            localStringBuilder.append((String)localObject);
            QLog.i("NewFriendContactGuideConfBean", 2, localStringBuilder.toString());
          }
        }
        i1 += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("parse: ");
      paramArrayOfQConfItem.append(localNewFriendContactGuideConfBean);
      QLog.i("NewFriendContactGuideConfBean", 2, paramArrayOfQConfItem.toString());
    }
    return localNewFriendContactGuideConfBean;
  }
  
  private static void a(NewFriendContactGuideConfBean.UIElement paramUIElement, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramUIElement == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramUIElement.a = paramJSONObject.optString("title", paramString1);
      paramUIElement.b = paramJSONObject.optString("subTitle", paramString2);
      paramUIElement.c = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramUIElement.a = paramString1;
    paramUIElement.b = paramString2;
    paramUIElement.c = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NewFriendContactGuideConfBean(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean
 * JD-Core Version:    0.7.0.1
 */