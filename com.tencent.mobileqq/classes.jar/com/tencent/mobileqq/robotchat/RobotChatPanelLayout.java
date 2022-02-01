package com.tencent.mobileqq.robotchat;

import aipj;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import bbwo;
import bgpy;
import bgty;
import bgwh;
import bgwj;
import bgwk;
import bhsi;
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
  
  private String a(String paramString1, String paramString2, bgwj parambgwj, bgty parambgty)
  {
    String str = "";
    int i;
    if (parambgwj.jdField_b_of_type_Boolean)
    {
      parambgwj.jdField_b_of_type_Boolean = false;
      parambgty.a();
      i = parambgwj.jdField_b_of_type_Bgwk.c.indexOf("content=");
      paramString2 = str;
      if (i > 0) {
        paramString2 = parambgwj.jdField_b_of_type_Bgwk.c.substring(i + 8);
      }
      str = parambgwj.jdField_b_of_type_Bgwk.jdField_a_of_type_JavaLangString;
      parambgty = paramString2;
      paramString2 = str;
    }
    for (;;)
    {
      b("1", paramString1, parambgty, parambgwj);
      return paramString2;
      str = parambgwj.a.jdField_a_of_type_JavaLangString;
      parambgwj.jdField_b_of_type_Boolean = true;
      parambgty.a(paramString1, paramString2);
      i = parambgwj.a.c.indexOf("content=");
      if (i > 0)
      {
        parambgty = parambgwj.a.c.substring(i + 8);
        paramString2 = str;
      }
      else
      {
        parambgty = "";
        paramString2 = str;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Bgty == null) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_Bgty.a("1", paramString);
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
  
  public String a(bgwj parambgwj)
  {
    if (this.jdField_a_of_type_Bgty == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      parambgwj = null;
    }
    String str;
    do
    {
      return parambgwj;
      str = a(this.jdField_a_of_type_JavaLangString, this.b, parambgwj, this.jdField_a_of_type_Bgty);
      parambgwj = str;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "talking: " + str);
    return str;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bgwj parambgwj)
  {
    if (this.jdField_a_of_type_Bgty == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    do
    {
      return;
      a(getContext(), parambgwj.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "send to robot: " + parambgwj.a.jdField_a_of_type_JavaLangString);
  }
  
  public void a(bgwj parambgwj, String paramString)
  {
    bgpy.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "0X800A48C", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, aipj paramaipj, bgwh parambgwh)
  {
    super.a(paramString1, paramString2, paramaipj, parambgwh);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (this.jdField_a_of_type_Bgty == null) {
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
        int i = bhsi.ao(getContext(), "1_" + paramString1);
        this.jdField_a_of_type_Bgty.a(l, i, new bbwo(this, l, i, paramString1, parambgwh));
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
  
  public void b(bgwj parambgwj)
  {
    if (this.jdField_a_of_type_Bgty == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    int i = parambgwj.a.c.indexOf("content=");
    if (i > 0) {}
    for (String str = parambgwj.a.c.substring(i + 8);; str = null)
    {
      a(getContext(), parambgwj.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      a("1", this.jdField_a_of_type_JavaLangString, str, parambgwj);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "send to server: " + parambgwj.a.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout
 * JD-Core Version:    0.7.0.1
 */