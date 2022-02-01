package com.tencent.securemodule;

import java.io.Serializable;

public final class i
  implements Serializable
{
  public static final i A = new i(26, 26, "EP_King_SuperUser");
  public static final i B = new i(27, 27, "EP_Secure_SDK_Ign");
  public static final i C = new i(28, 28, "EP_Tracker");
  public static final i D = new i(29, 29, "EP_TencentUser");
  public static final i E = new i(30, 30, "EP_Album");
  public static final i F = new i(31, 31, "EP_WeShare");
  public static final i G = new i(32, 32, "EP_Tencent_Cleaner");
  public static final i H = new i(33, 35, "EP_Secure_Mini");
  public static final i I = new i(34, 40, "EP_GameAssistant_SDK");
  public static final i J = new i(35, 41, "EP_QQDownloader_SDK");
  public static final i K = new i(36, 42, "EP_END");
  private static i[] M = new i[37];
  public static final i a = new i(0, 0, "EP_None");
  public static final i b = new i(1, 1, "EP_Secure");
  public static final i c = new i(2, 2, "EP_Phonebook");
  public static final i d = new i(3, 3, "EP_Pim");
  public static final i e = new i(4, 4, "EP_QQPhonebook");
  public static final i f = new i(5, 5, "EP_QZone");
  public static final i g = new i(6, 6, "EP_MobileQQ_Secure");
  public static final i h = new i(7, 7, "EP_QQBrowse_Secure");
  public static final i i = new i(8, 8, "EP_XiaoYou");
  public static final i j = new i(9, 9, "EP_Secure_Eng");
  public static final i k = new i(10, 10, "EP_WBlog");
  public static final i l = new i(11, 11, "EP_Phonebook_Eng");
  public static final i m = new i(12, 12, "EP_AppAssistant");
  public static final i n = new i(13, 13, "EP_Secure_SDK");
  public static final i o = new i(14, 14, "EP_KingRoot");
  public static final i p = new i(15, 15, "EP_Secure_SDK_Pay");
  public static final i q = new i(16, 16, "EP_Secure_Jailbreak");
  public static final i r = new i(17, 17, "EP_KingUser");
  public static final i s = new i(18, 18, "EP_Pim_Pro");
  public static final i t = new i(19, 19, "EP_Pim_Jailbreak");
  public static final i u = new i(20, 20, "EP_PhonebookPro");
  public static final i v = new i(21, 21, "EP_PowerManager");
  public static final i w = new i(22, 22, "EP_BenchMark");
  public static final i x = new i(23, 23, "EP_SecurePro_Enhance");
  public static final i y = new i(24, 24, "EP_Pim_Eng");
  public static final i z = new i(25, 25, "EP_SMS_Fraud_Killer");
  private int N;
  private String O = new String();
  
  private i(int paramInt1, int paramInt2, String paramString)
  {
    this.O = paramString;
    this.N = paramInt2;
    M[paramInt1] = this;
  }
  
  public static i a(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      localObject = M;
      if (i1 >= localObject.length) {
        break;
      }
      if (localObject[i1].a() == paramInt) {
        return M[i1];
      }
      i1 += 1;
    }
    if (L) {
      return null;
    }
    Object localObject = new AssertionError();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public int a()
  {
    return this.N;
  }
  
  public String toString()
  {
    return this.O;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.i
 * JD-Core Version:    0.7.0.1
 */