package com.tencent.mobileqq.robotchat;

import ahkw;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import baqj;
import bezm;
import bfdm;
import bfft;
import bffv;
import bffw;
import bfyz;
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
  
  private String a(String paramString1, String paramString2, bffv parambffv, bfdm parambfdm)
  {
    String str = "";
    int i;
    if (parambffv.jdField_b_of_type_Boolean)
    {
      parambffv.jdField_b_of_type_Boolean = false;
      parambfdm.a();
      i = parambffv.jdField_b_of_type_Bffw.c.indexOf("content=");
      paramString2 = str;
      if (i > 0) {
        paramString2 = parambffv.jdField_b_of_type_Bffw.c.substring(i + 8);
      }
      str = parambffv.jdField_b_of_type_Bffw.jdField_a_of_type_JavaLangString;
      parambfdm = paramString2;
      paramString2 = str;
    }
    for (;;)
    {
      b("1", paramString1, parambfdm, parambffv);
      return paramString2;
      str = parambffv.a.jdField_a_of_type_JavaLangString;
      parambffv.jdField_b_of_type_Boolean = true;
      parambfdm.a(paramString1, paramString2);
      i = parambffv.a.c.indexOf("content=");
      if (i > 0)
      {
        parambfdm = parambffv.a.c.substring(i + 8);
        paramString2 = str;
      }
      else
      {
        parambfdm = "";
        paramString2 = str;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Bfdm == null) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_Bfdm.a("1", paramString);
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
  
  public String a(bffv parambffv)
  {
    if (this.jdField_a_of_type_Bfdm == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      parambffv = null;
    }
    String str;
    do
    {
      return parambffv;
      str = a(this.jdField_a_of_type_JavaLangString, this.b, parambffv, this.jdField_a_of_type_Bfdm);
      parambffv = str;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "talking: " + str);
    return str;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bffv parambffv)
  {
    if (this.jdField_a_of_type_Bfdm == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    do
    {
      return;
      a(getContext(), parambffv.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "send to robot: " + parambffv.a.jdField_a_of_type_JavaLangString);
  }
  
  public void a(bffv parambffv, String paramString)
  {
    bezm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "0X800A48C", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, ahkw paramahkw, bfft parambfft)
  {
    super.a(paramString1, paramString2, paramahkw, parambfft);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (this.jdField_a_of_type_Bfdm == null) {
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
        int i = bfyz.ap(getContext(), "1_" + paramString1);
        this.jdField_a_of_type_Bfdm.a(l, i, new baqj(this, l, i, paramString1, parambfft));
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
  
  public void b(bffv parambffv)
  {
    if (this.jdField_a_of_type_Bfdm == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    int i = parambffv.a.c.indexOf("content=");
    if (i > 0) {}
    for (String str = parambffv.a.c.substring(i + 8);; str = null)
    {
      a(getContext(), parambffv.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      a("1", this.jdField_a_of_type_JavaLangString, str, parambffv);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "send to server: " + parambffv.a.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout
 * JD-Core Version:    0.7.0.1
 */