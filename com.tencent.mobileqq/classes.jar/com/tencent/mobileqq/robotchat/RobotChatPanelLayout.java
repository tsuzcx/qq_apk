package com.tencent.mobileqq.robotchat;

import aifq;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import bbwy;
import bghs;
import bgls;
import bgoa;
import bgoc;
import bgod;
import bhhr;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
  
  private String a(String paramString1, String paramString2, bgoc parambgoc, bgls parambgls)
  {
    String str = "";
    int i;
    if (parambgoc.jdField_b_of_type_Boolean)
    {
      parambgoc.jdField_b_of_type_Boolean = false;
      parambgls.a();
      i = parambgoc.jdField_b_of_type_Bgod.c.indexOf("content=");
      paramString2 = str;
      if (i > 0) {
        paramString2 = parambgoc.jdField_b_of_type_Bgod.c.substring(i + 8);
      }
      str = parambgoc.jdField_b_of_type_Bgod.jdField_a_of_type_JavaLangString;
      parambgls = paramString2;
      paramString2 = str;
    }
    for (;;)
    {
      b("1", paramString1, parambgls, parambgoc);
      return paramString2;
      str = parambgoc.a.jdField_a_of_type_JavaLangString;
      parambgoc.jdField_b_of_type_Boolean = true;
      parambgls.a(paramString1, paramString2);
      i = parambgoc.a.c.indexOf("content=");
      if (i > 0)
      {
        parambgls = parambgoc.a.c.substring(i + 8);
        paramString2 = str;
      }
      else
      {
        parambgls = "";
        paramString2 = str;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Bgls == null) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_Bgls.a("1", paramString);
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
  
  public String a(bgoc parambgoc)
  {
    if (this.jdField_a_of_type_Bgls == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      parambgoc = null;
    }
    String str;
    do
    {
      return parambgoc;
      str = a(this.jdField_a_of_type_JavaLangString, this.b, parambgoc, this.jdField_a_of_type_Bgls);
      parambgoc = str;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "talking: " + str);
    return str;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bgoc parambgoc)
  {
    if (this.jdField_a_of_type_Bgls == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    do
    {
      return;
      a(getContext(), parambgoc.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "send to robot: " + parambgoc.a.jdField_a_of_type_JavaLangString);
  }
  
  public void a(bgoc parambgoc, String paramString)
  {
    bghs.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "0X800A48C", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, aifq paramaifq, bgoa parambgoa)
  {
    super.a(paramString1, paramString2, paramaifq, parambgoa);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (this.jdField_a_of_type_Bgls == null) {
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
        int i = bhhr.ap(getContext(), "1_" + paramString1);
        this.jdField_a_of_type_Bgls.a(l, i, new bbwy(this, l, i, paramString1, parambgoa));
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
  
  public void b(bgoc parambgoc)
  {
    if (this.jdField_a_of_type_Bgls == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    int i = parambgoc.a.c.indexOf("content=");
    if (i > 0) {}
    for (String str = parambgoc.a.c.substring(i + 8);; str = null)
    {
      a(getContext(), parambgoc.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      a("1", this.jdField_a_of_type_JavaLangString, str, parambgoc);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "send to server: " + parambgoc.a.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout
 * JD-Core Version:    0.7.0.1
 */