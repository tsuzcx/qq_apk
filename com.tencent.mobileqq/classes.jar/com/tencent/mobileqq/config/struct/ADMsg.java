package com.tencent.mobileqq.config.struct;

import com.tencent.mobileqq.config.Command;
import com.tencent.mobileqq.config.CommandListener;

public class ADMsg
  implements CommandListener
{
  private static Command h;
  private static Command i;
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  private Command j = null;
  private ADMsg.TextBox k = null;
  
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
      this.c.equals("AUTO");
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
      this.c.equals("AUTO");
      return;
    }
    this.e.equals("RESET");
  }
  
  public void a(boolean paramBoolean)
  {
    Command[] arrayOfCommand = new Command[2];
    if ((this.d != null) && (!this.e.equals("")))
    {
      if (this.j == null) {
        this.j = new Command(this.d, 1, 1);
      }
      arrayOfCommand[0] = this.j;
    }
    if (paramBoolean)
    {
      arrayOfCommand[1] = i;
      return;
    }
    arrayOfCommand[1] = h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.ADMsg
 * JD-Core Version:    0.7.0.1
 */