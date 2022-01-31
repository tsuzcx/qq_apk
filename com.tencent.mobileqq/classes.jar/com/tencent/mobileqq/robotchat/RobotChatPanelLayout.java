package com.tencent.mobileqq.robotchat;

import aetn;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import awgb;
import bail;
import bamk;
import baos;
import baou;
import baov;
import bbkb;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class RobotChatPanelLayout
  extends RobotPanelLayoutBase
{
  public RobotChatPanelLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RobotChatPanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RobotChatPanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(String paramString1, String paramString2, baou parambaou, bamk parambamk)
  {
    String str = "";
    int i;
    if (parambaou.jdField_b_of_type_Boolean)
    {
      parambaou.jdField_b_of_type_Boolean = false;
      parambamk.a();
      i = parambaou.jdField_b_of_type_Baov.c.indexOf("content=");
      paramString2 = str;
      if (i > 0) {
        paramString2 = parambaou.jdField_b_of_type_Baov.c.substring(i + 8);
      }
      str = parambaou.jdField_b_of_type_Baov.jdField_a_of_type_JavaLangString;
      parambamk = paramString2;
      paramString2 = str;
    }
    for (;;)
    {
      b("1", paramString1, parambamk, parambaou);
      return paramString2;
      str = parambaou.a.jdField_a_of_type_JavaLangString;
      parambaou.jdField_b_of_type_Boolean = true;
      parambamk.a(paramString1, paramString2);
      i = parambaou.a.c.indexOf("content=");
      if (i > 0)
      {
        parambamk = parambaou.a.c.substring(i + 8);
        paramString2 = str;
      }
      else
      {
        parambamk = "";
        paramString2 = str;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Bamk == null) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_Bamk.a("1", paramString);
          if (paramString == null) {
            break label99;
          }
          try
          {
            cmd0x934.RspBody localRspBody = new cmd0x934.RspBody();
            localRspBody.mergeFrom(paramString);
            paramString = a(localRspBody);
            if ((paramString == null) || (paramString.size() <= 0)) {
              break;
            }
            a(false);
            a(paramString, true);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramString) {}
        } while (!QLog.isColorLevel());
        QLog.d("RobotChatPanelLayout", 2, paramString.getMessage());
        return;
      } while (!QLog.isColorLevel());
      QLog.d("RobotChatPanelLayout", 2, "listDatas is null");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "data is null");
  }
  
  public String a(baou parambaou)
  {
    if (this.jdField_a_of_type_Bamk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      parambaou = null;
    }
    String str;
    do
    {
      return parambaou;
      str = a(this.jdField_a_of_type_JavaLangString, this.b, parambaou, this.jdField_a_of_type_Bamk);
      parambaou = str;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "talking: " + str);
    return str;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(baou parambaou)
  {
    if (this.jdField_a_of_type_Bamk == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    do
    {
      return;
      a(getContext(), parambaou.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "send to robot: " + parambaou.a.jdField_a_of_type_JavaLangString);
  }
  
  public void a(baou parambaou, String paramString)
  {
    bail.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "0X800A48C", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, aetn paramaetn, baos parambaos)
  {
    super.a(paramString1, paramString2, paramaetn, parambaos);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (this.jdField_a_of_type_Bamk == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(paramString1);
        if (l == 0L) {
          continue;
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals(paramString1))) {
          a(false);
        }
        int i = bbkb.an(getContext(), "1_" + paramString1);
        this.jdField_a_of_type_Bamk.a(l, i, new awgb(this, l, i, paramString1, parambaos));
        return;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
    }
  }
  
  public void b(baou parambaou)
  {
    if (this.jdField_a_of_type_Bamk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    int i = parambaou.a.c.indexOf("content=");
    if (i > 0) {}
    for (String str = parambaou.a.c.substring(i + 8);; str = null)
    {
      a(getContext(), parambaou.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      a("1", this.jdField_a_of_type_JavaLangString, str, parambaou);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "send to server: " + parambaou.a.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout
 * JD-Core Version:    0.7.0.1
 */