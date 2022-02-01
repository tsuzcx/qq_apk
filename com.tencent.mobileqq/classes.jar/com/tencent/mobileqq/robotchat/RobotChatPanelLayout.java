package com.tencent.mobileqq.robotchat;

import aifq;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import bbdv;
import bfpx;
import bftx;
import bfwg;
import bfwi;
import bfwj;
import bgsg;
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
  
  private String a(String paramString1, String paramString2, bfwi parambfwi, bftx parambftx)
  {
    String str = "";
    int i;
    if (parambfwi.jdField_b_of_type_Boolean)
    {
      parambfwi.jdField_b_of_type_Boolean = false;
      parambftx.a();
      i = parambfwi.jdField_b_of_type_Bfwj.c.indexOf("content=");
      paramString2 = str;
      if (i > 0) {
        paramString2 = parambfwi.jdField_b_of_type_Bfwj.c.substring(i + 8);
      }
      str = parambfwi.jdField_b_of_type_Bfwj.jdField_a_of_type_JavaLangString;
      parambftx = paramString2;
      paramString2 = str;
    }
    for (;;)
    {
      b("1", paramString1, parambftx, parambfwi);
      return paramString2;
      str = parambfwi.a.jdField_a_of_type_JavaLangString;
      parambfwi.jdField_b_of_type_Boolean = true;
      parambftx.a(paramString1, paramString2);
      i = parambfwi.a.c.indexOf("content=");
      if (i > 0)
      {
        parambftx = parambfwi.a.c.substring(i + 8);
        paramString2 = str;
      }
      else
      {
        parambftx = "";
        paramString2 = str;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Bftx == null) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_Bftx.a("1", paramString);
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
  
  public String a(bfwi parambfwi)
  {
    if (this.jdField_a_of_type_Bftx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      parambfwi = null;
    }
    String str;
    do
    {
      return parambfwi;
      str = a(this.jdField_a_of_type_JavaLangString, this.b, parambfwi, this.jdField_a_of_type_Bftx);
      parambfwi = str;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "talking: " + str);
    return str;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bfwi parambfwi)
  {
    if (this.jdField_a_of_type_Bftx == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    do
    {
      return;
      a(getContext(), parambfwi.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "send to robot: " + parambfwi.a.jdField_a_of_type_JavaLangString);
  }
  
  public void a(bfwi parambfwi, String paramString)
  {
    bfpx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "0X800A48C", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, aifq paramaifq, bfwg parambfwg)
  {
    super.a(paramString1, paramString2, paramaifq, parambfwg);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (this.jdField_a_of_type_Bftx == null) {
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
        int i = bgsg.ao(getContext(), "1_" + paramString1);
        this.jdField_a_of_type_Bftx.a(l, i, new bbdv(this, l, i, paramString1, parambfwg));
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
  
  public void b(bfwi parambfwi)
  {
    if (this.jdField_a_of_type_Bftx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    int i = parambfwi.a.c.indexOf("content=");
    if (i > 0) {}
    for (String str = parambfwi.a.c.substring(i + 8);; str = null)
    {
      a(getContext(), parambfwi.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      a("1", this.jdField_a_of_type_JavaLangString, str, parambfwi);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "send to server: " + parambfwi.a.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout
 * JD-Core Version:    0.7.0.1
 */