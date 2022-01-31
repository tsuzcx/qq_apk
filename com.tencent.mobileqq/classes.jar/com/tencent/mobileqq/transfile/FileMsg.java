package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMsg
{
  static String[] a;
  static String[] b;
  private static String[] d;
  public static String w = "defaultTag";
  public static String y = "richfile";
  public int a;
  public long a;
  public BaseTransProcessor a;
  public FileMsg.StepBaseInfo a;
  public FileMsg.StepTransInfo a;
  public HttpMsg a;
  public File a;
  public InputStream a;
  public OutputStream a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public FileMsg.StepBaseInfo b;
  public FileMsg.StepTransInfo b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public FileMsg.StepBaseInfo c;
  public String c;
  public String[] c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public long g;
  public String g;
  public int h = -1;
  public long h;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s = "";
  public String t = "";
  public String u;
  public String v = "";
  public String x = w;
  public String z = "";
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "up", "down", "down" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "file", "pic", "ptt", "video", "map", "thumbpic", "emo", "multimsg" };
    jdField_d_of_type_ArrayOfJavaLangString = new String[] { "LogEventSignalSigFinish", "LogEventSignalUrlFinish", "LogEventRetry", "LogEventFlowUp", "LogEventFlowDown" };
  }
  
  public FileMsg()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    this.jdField_g_of_type_Long = System.currentTimeMillis();
  }
  
  public FileMsg(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    try
    {
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      this.p = paramString1;
      this.jdField_a_of_type_Int = paramInt;
      if (paramString2 == null) {
        return;
      }
      if (paramInt == 0)
      {
        this.jdField_c_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaIoFile = new File(this.jdField_c_of_type_JavaLangString);
        if (this.jdField_a_of_type_JavaIoFile.exists())
        {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
          paramInt = paramString2.lastIndexOf(".");
          if ((paramInt >= 0) && (paramInt < paramString2.length())) {
            this.jdField_b_of_type_JavaLangString = paramString2.substring(paramInt).toLowerCase();
          }
        }
        a(paramString2);
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    this.jdField_g_of_type_JavaLangString = paramString2;
  }
  
  public static String a()
  {
    try
    {
      Thread.sleep(10L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(paramString);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoOutputStream != null) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      this.jdField_a_of_type_JavaIoOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("8pic", 2, "exception io FileMsg, " + localIOException.toString());
        }
        localIOException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    FileMsg.StepTransInfo localStepTransInfo;
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.jdField_b_of_type_Int += 1;
      return;
    case 4: 
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.e += paramInt2;
      return;
    case 3: 
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.d += paramInt2;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.c = true;
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoInputStream != null) {
        this.jdField_a_of_type_JavaIoInputStream.close();
      }
      label14:
      this.jdField_a_of_type_JavaIoInputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileMsg
 * JD-Core Version:    0.7.0.1
 */