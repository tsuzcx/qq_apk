package com.tencent.mobileqq.robotchat;

import aeis;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import avgg;
import azgu;
import azks;
import azna;
import aznc;
import aznd;
import baig;
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
  
  private String a(String paramString1, String paramString2, aznc paramaznc, azks paramazks)
  {
    String str = "";
    int i;
    if (paramaznc.jdField_b_of_type_Boolean)
    {
      paramaznc.jdField_b_of_type_Boolean = false;
      paramazks.a();
      i = paramaznc.jdField_b_of_type_Aznd.c.indexOf("content=");
      paramString2 = str;
      if (i > 0) {
        paramString2 = paramaznc.jdField_b_of_type_Aznd.c.substring(i + 8);
      }
      str = paramaznc.jdField_b_of_type_Aznd.jdField_a_of_type_JavaLangString;
      paramazks = paramString2;
      paramString2 = str;
    }
    for (;;)
    {
      b("1", paramString1, paramazks, paramaznc);
      return paramString2;
      str = paramaznc.a.jdField_a_of_type_JavaLangString;
      paramaznc.jdField_b_of_type_Boolean = true;
      paramazks.a(paramString1, paramString2);
      i = paramaznc.a.c.indexOf("content=");
      if (i > 0)
      {
        paramazks = paramaznc.a.c.substring(i + 8);
        paramString2 = str;
      }
      else
      {
        paramazks = "";
        paramString2 = str;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Azks == null) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_Azks.a("1", paramString);
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
  
  public String a(aznc paramaznc)
  {
    if (this.jdField_a_of_type_Azks == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      paramaznc = null;
    }
    String str;
    do
    {
      return paramaznc;
      str = a(this.jdField_a_of_type_JavaLangString, this.b, paramaznc, this.jdField_a_of_type_Azks);
      paramaznc = str;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "talking: " + str);
    return str;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(aznc paramaznc)
  {
    if (this.jdField_a_of_type_Azks == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    do
    {
      return;
      a(getContext(), paramaznc.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "send to robot: " + paramaznc.a.jdField_a_of_type_JavaLangString);
  }
  
  public void a(aznc paramaznc, String paramString)
  {
    azgu.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "0X800A48C", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, aeis paramaeis, azna paramazna)
  {
    super.a(paramString1, paramString2, paramaeis, paramazna);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (this.jdField_a_of_type_Azks == null) {
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
        int i = baig.an(getContext(), "1_" + paramString1);
        this.jdField_a_of_type_Azks.a(l, i, new avgg(this, l, i, paramString1, paramazna));
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
  
  public void b(aznc paramaznc)
  {
    if (this.jdField_a_of_type_Azks == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    int i = paramaznc.a.c.indexOf("content=");
    if (i > 0) {}
    for (String str = paramaznc.a.c.substring(i + 8);; str = null)
    {
      a(getContext(), paramaznc.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      a("1", this.jdField_a_of_type_JavaLangString, str, paramaznc);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "send to server: " + paramaznc.a.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout
 * JD-Core Version:    0.7.0.1
 */