package com.tencent.mobileqq.emoticonview;

import amsx;
import android.util.SparseIntArray;
import asfa;
import axfj;
import bdll;
import begd;
import behh;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ReportWorker
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<EmoticonMainPanel> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public ReportWorker(String paramString, boolean paramBoolean, EmoticonMainPanel paramEmoticonMainPanel, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEmoticonMainPanel);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    int i = 0;
    label35:
    int j;
    int k;
    if (i < localStringBuilder.length())
    {
      j = localStringBuilder.codePointAt(i);
      if ((j != 20) || (i >= localStringBuilder.length() - 1)) {
        break label592;
      }
      k = localStringBuilder.charAt(i + 1);
      if ((k >= begd.jdField_a_of_type_Int) && (250 != k)) {
        break label245;
      }
      if (250 != k) {
        break label702;
      }
      k = 10;
    }
    label702:
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A3", 0, 0, k + "", "", "", "");
      if (behh.a(k)) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "0X800812E", ApolloUtil.b(this.jdField_a_of_type_Int), 0, new String[] { String.valueOf(k), String.valueOf(amsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) });
      }
      axfj.b("0", 1);
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("ReportWorker", 2, "report emoji send amount, index:" + k);
        j = i;
      }
      label245:
      do
      {
        i = j + 1;
        break label35;
        break;
        j = i;
      } while (k != 255);
      if (i + 4 >= localStringBuilder.length()) {
        break;
      }
      Object localObject = new char[4];
      localObject[0] = localStringBuilder.charAt(i + 4);
      localObject[1] = localStringBuilder.charAt(i + 3);
      localObject[2] = localStringBuilder.charAt(i + 2);
      localObject[3] = localStringBuilder.charAt(i + 1);
      j = 0;
      if (j < 3)
      {
        if (localObject[j] == 'ú') {
          localObject[j] = 10;
        }
        for (;;)
        {
          j += 1;
          break;
          if (localObject[j] == 'þ') {
            localObject[j] = 13;
          }
        }
      }
      localObject = asfa.a((char[])localObject);
      if ((localObject != null) && (localObject.length == 2))
      {
        k = localObject[0];
        j = localObject[1];
      }
      for (;;)
      {
        int n = -1;
        int m = n;
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          m = n;
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
            m = ((EmoticonMainPanel)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(Integer.toString(k));
          }
        }
        String str = Integer.toString(m);
        if (this.jdField_a_of_type_Boolean) {}
        for (localObject = "0X800588C";; localObject = "0X80057AF")
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", (String)localObject, 0, 0, k + "", j + "", str, "");
          axfj.b("0", 5);
          if (QLog.isColorLevel()) {
            QLog.d("ReportWorker", 2, "report small emoticon send amount, epId:" + k + ",eId:" + j + ",tabOrder:" + str);
          }
          j = i + 4;
          break;
        }
        label592:
        k = begd.jdField_a_of_type_AndroidUtilSparseIntArray.get(j, -1);
        j = i;
        if (k < 0) {
          break;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A4", 0, 0, k + "", "", "", "");
        axfj.b("0", 1);
        j = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReportWorker", 2, "report system emoticon send amount, emoIdx:" + k);
        j = i;
        break;
        j = 0;
        k = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ReportWorker
 * JD-Core Version:    0.7.0.1
 */