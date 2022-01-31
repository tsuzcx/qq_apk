package com.tencent.mobileqq.lovelanguage;

import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.manager.Manager;

public class LoveLanguageManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  
  public LoveLanguageManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  public static void a(ChatMessage paramChatMessage) {}
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public static String b(String paramString)
  {
    return paramString;
  }
  
  public static boolean b(String paramString)
  {
    return false;
  }
  
  public int a(EditText paramEditText)
  {
    return 0;
  }
  
  public void a(EditText paramEditText) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.lovelanguage.LoveLanguageManager
 * JD-Core Version:    0.7.0.1
 */