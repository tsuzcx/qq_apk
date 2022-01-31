package com.tencent.mobileqq.graytip;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class UniteGrayTipParam
{
  public static final int[] a;
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  protected boolean a;
  public int b;
  public String b;
  protected boolean b;
  public int[] b;
  public int c;
  public String c;
  protected boolean c;
  public int d;
  public String d;
  public boolean d = true;
  public boolean e;
  public boolean f = true;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 131073, 131078, 135176, 1376257, 2097153, 2097154, 2097155, 2097156, 1245186, 1245187, 65560, 2359297, 65560, 655362, 2424833, 2490369, 2555907, 1179651, 2686977, 2621441, 2359298, 3145729, 2555906, 3145729, 3211265, 135178, 135179, 655369, 655376 };
  }
  
  public UniteGrayTipParam(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  private void a()
  {
    if (this.jdField_c_of_type_Int == -5020)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if (this.jdField_c_of_type_Int == -5021)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (this.jdField_c_of_type_Int == -5022)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (this.jdField_c_of_type_Int == -5023)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Int = -5040;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 >= paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.e(UniteGrayTipUtil.jdField_a_of_type_JavaLangString, 2, new Object[] { "revoke msg UniteGrayTipParam addHightlightItem start >= end error,start=", Integer.valueOf(paramInt1), ",end=", Integer.valueOf(paramInt2) });
      }
      return;
    }
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject1 = null;
    int k = 0;
    String str = null;
    int j;
    label72:
    Object localObject2;
    int i;
    Object localObject3;
    Object localObject4;
    label240:
    long l;
    if (paramBundle == null)
    {
      j = -1;
      localObject2 = localObject7;
      i = k;
      localObject3 = localObject5;
      localObject4 = localObject6;
      switch (j)
      {
      default: 
        localObject4 = localObject6;
        localObject3 = localObject5;
        i = k;
        localObject2 = localObject7;
      case 4: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 17: 
      case 18: 
      case 22: 
      case 25: 
      case 26: 
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        l = 0L;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong((String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label457;
        }
        paramBundle = "#FF00a5e0";
        k = Color.parseColor(paramBundle);
        this.jdField_a_of_type_JavaUtilArrayList.add(new MessageForGrayTips.HightlightItem(paramInt1, paramInt2, l, i, j, (String)localObject3, (String)localObject4, str, null, k));
        return;
      }
      catch (NumberFormatException paramBundle) {}
      j = paramBundle.getInt("key_action");
      localObject1 = paramBundle.getString("textColor");
      str = paramBundle.getString("image_resource");
      break label72;
      localObject2 = paramBundle.getString("troop_mem_uin");
      if (paramBundle.getBoolean("need_update_nick"))
      {
        i = 1;
        localObject3 = localObject5;
        localObject4 = localObject6;
        break label240;
      }
      i = 0;
      continue;
      localObject3 = paramBundle.getString("key_action_DATA");
      localObject4 = paramBundle.getString("key_a_action_DATA");
      localObject2 = localObject7;
      i = k;
      break label240;
      localObject2 = paramBundle.getString("troop_mem_uin");
      i = k;
      localObject3 = localObject5;
      localObject4 = localObject6;
      break label240;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(UniteGrayTipUtil.jdField_a_of_type_JavaLangString, 2, "getHightlightMsgText ==>NumberFormatException");
      return;
      label457:
      paramBundle = (Bundle)localObject1;
    }
  }
  
  public boolean a()
  {
    boolean bool = MsgProxyUtils.i(this.jdField_c_of_type_Int);
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (arrayOfInt[i] == this.jdField_b_of_type_Int) {
        j = 1;
      }
      i += 1;
    }
    return (bool) && (j != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipParam
 * JD-Core Version:    0.7.0.1
 */