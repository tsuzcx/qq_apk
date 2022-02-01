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
    if (this.e.equals("LOCAL")) {
      if (!this.f.equals("1")) {}
    }
    label24:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label24;
              break label24;
              break label24;
              do
              {
                return;
              } while ((this.f.equals("2")) || (this.f.equals("4")) || (this.f.equals("5")) || (this.f.equals("6")) || (!this.f.equals("7")));
              return;
            } while ((this.e.equals("WAP")) || (this.e.equals("TMTWAP")) || (this.e.equals("WAPI")) || (this.e.equals("TMTWAPI")) || (this.e.equals("VOICECALL")));
            if (!this.e.equals("QQMSG")) {
              break;
            }
          } while (!this.jdField_c_of_type_JavaLangString.equals("AUTO"));
          return;
        } while ((this.e.equals("AUTOQQMSG")) || (this.e.equals("HTTP")) || (this.e.equals("AUTOSMS")));
        if (!this.e.equals("USERSMS")) {
          break;
        }
      } while (!this.jdField_c_of_type_JavaLangString.equals("AUTO"));
      return;
    } while (!this.e.equals("RESET"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.ADMsg
 * JD-Core Version:    0.7.0.1
 */