package com.tencent.mobileqq.config.struct;

import com.tencent.mobileqq.config.Command;
import com.tencent.mobileqq.config.CommandListener;

public class ADMsg
  implements CommandListener
{
  private static Command jdField_a_of_type_ComTencentMobileqqConfigCommand;
  private static Command b;
  private ADMsg.TextBox jdField_a_of_type_ComTencentMobileqqConfigStructADMsg$TextBox = null;
  public String a;
  public String b;
  private Command c;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public ADMsg()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_c_of_type_ComTencentMobileqqConfigCommand = null;
  }
  
  public void a()
  {
    if (this.e.equals("LOCAL"))
    {
      if (this.f.equals("1")) {
        return;
      }
      if (this.f.equals("2")) {
        return;
      }
      if (this.f.equals("4")) {
        return;
      }
      if (this.f.equals("5")) {
        return;
      }
      if (this.f.equals("6")) {
        return;
      }
      this.f.equals("7");
      return;
    }
    if (this.e.equals("WAP")) {
      return;
    }
    if (this.e.equals("TMTWAP")) {
      return;
    }
    if (this.e.equals("WAPI")) {
      return;
    }
    if (this.e.equals("TMTWAPI")) {
      return;
    }
    if (this.e.equals("VOICECALL")) {
      return;
    }
    if (this.e.equals("QQMSG"))
    {
      this.jdField_c_of_type_JavaLangString.equals("AUTO");
      return;
    }
    if (this.e.equals("AUTOQQMSG")) {
      return;
    }
    if (this.e.equals("HTTP")) {
      return;
    }
    if (this.e.equals("AUTOSMS")) {
      return;
    }
    if (this.e.equals("USERSMS"))
    {
      this.jdField_c_of_type_JavaLangString.equals("AUTO");
      return;
    }
    this.e.equals("RESET");
  }
  
  public void a(boolean paramBoolean)
  {
    Command[] arrayOfCommand = new Command[2];
    if ((this.d != null) && (!this.e.equals("")))
    {
      if (this.jdField_c_of_type_ComTencentMobileqqConfigCommand == null) {
        this.jdField_c_of_type_ComTencentMobileqqConfigCommand = new Command(this.d, 1, 1);
      }
      arrayOfCommand[0] = this.jdField_c_of_type_ComTencentMobileqqConfigCommand;
    }
    if (paramBoolean)
    {
      arrayOfCommand[1] = jdField_b_of_type_ComTencentMobileqqConfigCommand;
      return;
    }
    arrayOfCommand[1] = jdField_a_of_type_ComTencentMobileqqConfigCommand;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.ADMsg
 * JD-Core Version:    0.7.0.1
 */