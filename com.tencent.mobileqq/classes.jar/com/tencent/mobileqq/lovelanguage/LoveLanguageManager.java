package com.tencent.mobileqq.lovelanguage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class LoveLanguageManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d = true;
  private boolean e = true;
  
  public LoveLanguageManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = d();
    if (SharedPreUtils.af(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()) == 1)
    {
      bool = true;
      this.b = bool;
      if (SharedPreUtils.ag(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()) != 1) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      if (QLog.isColorLevel()) {
        QLog.d("LoveLanguageManager", 2, new Object[] { "love language new instance mJoinActivity= ", Boolean.valueOf(this.jdField_a_of_type_Boolean), ",mActivityOpen=", Boolean.valueOf(this.b), ",grayOpen=", Boolean.valueOf(this.c) });
      }
      return;
      bool = false;
      break;
    }
  }
  
  public static String a(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString))
    {
      str1 = null;
      return str1;
    }
    long l = System.currentTimeMillis();
    int i = 0;
    int k = paramString.length();
    int j = 0;
    label27:
    int m;
    int n;
    if (j < k)
    {
      m = 0;
      for (;;)
      {
        if (m < LoveLanguageConfig.a.length)
        {
          String str2 = LoveLanguageConfig.a[m];
          n = str2.length() + j;
          if (n <= k)
          {
            str1 = paramString.substring(j, n);
            if (str2.equals(str1.toLowerCase()))
            {
              str2 = LoveLanguageConfig.a(m, str1);
              String str3 = paramString.substring(0, j);
              paramString = paramString.substring(n, k);
              paramString = str3 + str2 + paramString;
              m = paramString.length();
              if (QLog.isColorLevel()) {
                QLog.d("LoveLanguageManager", 2, new Object[] { "love language handleLoveLanguageDiaplay = ", str1, ",code=", Integer.valueOf(str2.charAt(1)) });
              }
              n = i + 1;
              k = j + 1;
              if (n < 20) {
                break label267;
              }
              str1 = paramString;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("LoveLanguageManager", 2, new Object[] { "love language handleLoveLanguageDiaplay count = ", Integer.valueOf(n), ",cost =", Long.valueOf(Math.abs(System.currentTimeMillis() - l)) });
              return paramString;
            }
          }
          m += 1;
          continue;
          label267:
          i = m;
        }
      }
    }
    for (j = n;; j = n)
    {
      m = j;
      j = k + 1;
      k = i;
      i = m;
      break label27;
      str1 = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LoveLanguageManager", 2, new Object[] { "love language handleLoveLanguageConvert count = ", Integer.valueOf(i), ",cost =", Long.valueOf(Math.abs(System.currentTimeMillis() - l)) });
      return paramString;
      m = k;
      n = i;
      k = j;
      i = m;
    }
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoveLanguageManager", 2, "love language report 0X8009167");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009167", "0X8009167", 0, 0, "", "", "", "");
  }
  
  public static void a(ChatMessage paramChatMessage)
  {
    int j = 3;
    int i;
    if ((paramChatMessage != null) && (paramChatMessage.msgtype == -1000) && ("1".equals(paramChatMessage.getExtInfoFromExtStr(MessageConstants.m))))
    {
      paramChatMessage.removeExtInfoToExtStr(MessageConstants.m);
      if (QLog.isColorLevel())
      {
        if (paramChatMessage.msg == null) {
          break label100;
        }
        i = paramChatMessage.msg.length();
        if (i < 3) {
          break label111;
        }
        i = j;
      }
    }
    label100:
    label111:
    for (;;)
    {
      if (i > 0) {}
      for (paramChatMessage = paramChatMessage.msg.substring(0, i);; paramChatMessage = "")
      {
        QLog.d("LoveLanguageManager", 2, new Object[] { "love language handleMultiMsg remove extrstr to null :msgDta[0-2]=", paramChatMessage });
        return;
        i = 0;
        break;
      }
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && ("1".equals(paramMessageRecord.getExtInfoFromExtStr(MessageConstants.m)));
  }
  
  public static String b(String paramString)
  {
    long l = System.currentTimeMillis();
    int i = 0;
    int k = paramString.length();
    int j = 0;
    int m;
    if (j < k)
    {
      if ((paramString.charAt(j) != '\021') || (paramString.charAt(j) != '\021')) {
        break label229;
      }
      StringBuilder localStringBuilder = new StringBuilder(128);
      if ((j >= k - 3) || (!LoveLanguageConfig.a(paramString.charAt(j + 1)))) {
        break label229;
      }
      k = j + 4;
      String str2 = LoveLanguageConfig.a(paramString.substring(j, k));
      String str3 = paramString.substring(0, j);
      String str1 = "";
      if (k <= paramString.length() - 1) {
        str1 = paramString.substring(k, paramString.length());
      }
      localStringBuilder.append(str3).append(str2).append(str1);
      paramString = localStringBuilder.toString();
      m = paramString.length();
      k = str2.length() + j - 1;
      j = m;
      i += 1;
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = m;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("LoveLanguageManager", 2, new Object[] { "love language handleLoveLanguageCodeString count = ", Integer.valueOf(i), ",cost =", Long.valueOf(Math.abs(System.currentTimeMillis() - l)) });
      }
      return paramString;
      label229:
      m = k;
      k = j;
      j = m;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (-1 == paramString.indexOf('\021')) {
      return false;
    }
    return true;
  }
  
  private boolean d()
  {
    boolean bool = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getBoolean("sp_key_love_language_mark_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
    if (QLog.isColorLevel()) {
      QLog.d("LoveLanguageManager", 2, "love language get local mJoinActivity = " + bool);
    }
    return bool;
  }
  
  public int a(EditText paramEditText)
  {
    this.d = false;
    Object localObject1 = paramEditText.getText().toString();
    long l = System.currentTimeMillis();
    int n = ((String)localObject1).length();
    int i = 0;
    int k;
    for (int j = 0; i < n; j = k)
    {
      int i1 = i;
      int m = n;
      Object localObject2 = localObject1;
      k = j;
      if (((String)localObject1).charAt(i) == '\021')
      {
        i1 = i;
        m = n;
        localObject2 = localObject1;
        k = j;
        if (i < n - 3)
        {
          i1 = i;
          m = n;
          localObject2 = localObject1;
          k = j;
          if (LoveLanguageConfig.a(((String)localObject1).charAt(i + 1)))
          {
            k = i + 4;
            localObject1 = LoveLanguageConfig.a(((String)localObject1).substring(i, k));
            paramEditText.getEditableText().replace(i, k, (CharSequence)localObject1);
            localObject2 = paramEditText.getText().toString();
            m = ((String)localObject2).length();
            i1 = i + ((String)localObject1).length() - 1;
            k = j + 1;
          }
        }
      }
      i = i1 + 1;
      n = m;
      localObject1 = localObject2;
    }
    this.d = true;
    if (QLog.isColorLevel()) {
      QLog.d("LoveLanguageManager", 2, new Object[] { "love language handleLoveLanguageRevert count = ", Integer.valueOf(j), ",cost =", Long.valueOf(Math.abs(System.currentTimeMillis() - l)), ",send:", localObject1 });
    }
    a();
    return j;
  }
  
  public void a(EditText paramEditText)
  {
    if ((!this.d) || (paramEditText == null)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = paramEditText.getText().toString();
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    this.d = false;
    int j = ((String)localObject1).length();
    int i = 0;
    long l = System.currentTimeMillis();
    int m = -1;
    int k = 0;
    String str;
    Object localObject2;
    if (k < j) {
      if (((String)localObject1).charAt(k) == '\021') {
        if (i >= 20)
        {
          j = k + 4;
          str = LoveLanguageConfig.a(((String)localObject1).substring(k, j));
          localObject2 = paramEditText.getEditableText().subSequence(0, k);
          localObject1 = paramEditText.getEditableText().subSequence(j, ((String)localObject1).length());
          paramEditText.setText(localObject2 + str + localObject1);
          localObject1 = paramEditText.getText().toString();
          if (QLog.isColorLevel()) {
            QLog.d("LoveLanguageManager", 2, new Object[] { "love language handleLoveLanguageConvert replace content:", localObject1 });
          }
          j = ((String)localObject1).length();
          k = str.length() + k - 1;
        }
      }
    }
    for (;;)
    {
      k += 1;
      break;
      i += 1;
      k = k + 4 - 1;
      continue;
      label549:
      if (i < 20)
      {
        int n = 0;
        label242:
        if (n < LoveLanguageConfig.a.length)
        {
          localObject2 = LoveLanguageConfig.a[n];
          int i2 = ((String)localObject2).length() + k;
          int i1;
          if (i2 <= j)
          {
            str = ((String)localObject1).substring(k, i2);
            if (((String)localObject2).equals(str.toLowerCase()))
            {
              j = paramEditText.getSelectionEnd();
              localObject2 = LoveLanguageConfig.a(n, str);
              paramEditText.getEditableText().replace(k, i2, (CharSequence)localObject2);
              localObject1 = paramEditText.getText().toString();
              n = ((String)localObject1).length();
              if (QLog.isColorLevel()) {
                QLog.d("LoveLanguageManager", 2, new Object[] { "love language handleLoveLanguageConvert = ", str, ",code=", Integer.valueOf(((String)localObject2).charAt(1)), ",pos1=", Integer.valueOf(((String)localObject2).charAt(2)), ",pos2=", Integer.valueOf(((String)localObject2).charAt(3)) });
              }
              i1 = k + 4 - 1;
              if ((j < k) || (j >= i2)) {
                break label549;
              }
            }
          }
          for (j = i1 + 1;; j = m)
          {
            k = i1;
            i += 1;
            m = j;
            j = n;
            break;
            n += 1;
            break label242;
            if (QLog.isColorLevel()) {
              QLog.d("LoveLanguageManager", 2, new Object[] { "love language handleLoveLanguageConvert count = ", Integer.valueOf(i), ",cost =", Long.valueOf(Math.abs(System.currentTimeMillis() - l)) });
            }
            if (m > 0) {
              paramEditText.setSelection(m);
            }
            paramEditText.requestFocus();
            this.d = true;
            return;
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoveLanguageManager", 2, new Object[] { "love language setJoinLoveLanguageActivity = ", Boolean.valueOf(paramBoolean) });
    }
    if (d() != paramBoolean)
    {
      PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit().putBoolean("sp_key_love_language_mark_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramBoolean).commit();
      if (QLog.isColorLevel()) {
        QLog.d("LoveLanguageManager", 2, "love language save mJoinActivity = " + paramBoolean);
      }
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    if (QLog.isColorLevel()) {
      QLog.d("LoveLanguageManager", 2, new Object[] { "love language handleActivityStatus  mActivityOpen= ", Boolean.valueOf(this.b), ",isGrayOpen=", Boolean.valueOf(paramBoolean2) });
    }
  }
  
  public boolean a()
  {
    boolean bool;
    if (this.c) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoveLanguageManager", 2, new Object[] { "love language isJoinAndOpenLoveLanguage = ", Boolean.valueOf(bool) });
      }
      return bool;
      if ((this.jdField_a_of_type_Boolean) && (this.b)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.toLowerCase();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < LoveLanguageConfig.a.length)
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains(LoveLanguageConfig.a[i]))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.lovelanguage.LoveLanguageManager
 * JD-Core Version:    0.7.0.1
 */