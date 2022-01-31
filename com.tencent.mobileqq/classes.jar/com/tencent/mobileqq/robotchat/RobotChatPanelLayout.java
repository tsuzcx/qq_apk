package com.tencent.mobileqq.robotchat;

import agvc;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import ayfn;
import bclg;
import bcpg;
import bcro;
import bcrq;
import bcrr;
import bdne;
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
  
  private String a(String paramString1, String paramString2, bcrq parambcrq, bcpg parambcpg)
  {
    String str = "";
    int i;
    if (parambcrq.jdField_b_of_type_Boolean)
    {
      parambcrq.jdField_b_of_type_Boolean = false;
      parambcpg.a();
      i = parambcrq.jdField_b_of_type_Bcrr.c.indexOf("content=");
      paramString2 = str;
      if (i > 0) {
        paramString2 = parambcrq.jdField_b_of_type_Bcrr.c.substring(i + 8);
      }
      str = parambcrq.jdField_b_of_type_Bcrr.jdField_a_of_type_JavaLangString;
      parambcpg = paramString2;
      paramString2 = str;
    }
    for (;;)
    {
      b("1", paramString1, parambcpg, parambcrq);
      return paramString2;
      str = parambcrq.a.jdField_a_of_type_JavaLangString;
      parambcrq.jdField_b_of_type_Boolean = true;
      parambcpg.a(paramString1, paramString2);
      i = parambcrq.a.c.indexOf("content=");
      if (i > 0)
      {
        parambcpg = parambcrq.a.c.substring(i + 8);
        paramString2 = str;
      }
      else
      {
        parambcpg = "";
        paramString2 = str;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Bcpg == null) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_Bcpg.a("1", paramString);
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
  
  public String a(bcrq parambcrq)
  {
    if (this.jdField_a_of_type_Bcpg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      parambcrq = null;
    }
    String str;
    do
    {
      return parambcrq;
      str = a(this.jdField_a_of_type_JavaLangString, this.b, parambcrq, this.jdField_a_of_type_Bcpg);
      parambcrq = str;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "talking: " + str);
    return str;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bcrq parambcrq)
  {
    if (this.jdField_a_of_type_Bcpg == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    do
    {
      return;
      a(getContext(), parambcrq.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "send to robot: " + parambcrq.a.jdField_a_of_type_JavaLangString);
  }
  
  public void a(bcrq parambcrq, String paramString)
  {
    bclg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "0X800A48C", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, agvc paramagvc, bcro parambcro)
  {
    super.a(paramString1, paramString2, paramagvc, parambcro);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (this.jdField_a_of_type_Bcpg == null) {
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
        int i = bdne.ao(getContext(), "1_" + paramString1);
        this.jdField_a_of_type_Bcpg.a(l, i, new ayfn(this, l, i, paramString1, parambcro));
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
  
  public void b(bcrq parambcrq)
  {
    if (this.jdField_a_of_type_Bcpg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    int i = parambcrq.a.c.indexOf("content=");
    if (i > 0) {}
    for (String str = parambcrq.a.c.substring(i + 8);; str = null)
    {
      a(getContext(), parambcrq.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      a("1", this.jdField_a_of_type_JavaLangString, str, parambcrq);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "send to server: " + parambcrq.a.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout
 * JD-Core Version:    0.7.0.1
 */