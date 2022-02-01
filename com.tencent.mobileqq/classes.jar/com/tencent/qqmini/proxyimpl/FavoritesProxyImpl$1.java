package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import bkog;
import bmad;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FavoritesProxyImpl$1
  implements Runnable
{
  public FavoritesProxyImpl$1(bkog parambkog, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArrayList paramArrayList, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, Context paramContext) {}
  
  public void run()
  {
    boolean bool = bmad.a(8, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e, this.e, null, true, 0L).b("sBizDataList", this.jdField_a_of_type_JavaUtilArrayList).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).a(this.jdField_a_of_type_AndroidContentContext);
    QLog.d("FavoritesProxyImpl", 2, "addToQQFavorites done, res = " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.FavoritesProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */