package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;

class FavoritesProxyImpl$1
  implements Runnable
{
  FavoritesProxyImpl$1(FavoritesProxyImpl paramFavoritesProxyImpl, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArrayList paramArrayList, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, Context paramContext) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    String str1 = this.b;
    String str2 = this.c;
    String str3 = this.d;
    String str4 = this.e;
    boolean bool = QfavBuilder.a(8, (String)localObject, str1, str2, str3, str4, str4, null, true, 0L).b("sBizDataList", this.jdField_a_of_type_JavaUtilArrayList).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).a(this.jdField_a_of_type_AndroidContentContext);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addToQQFavorites done, res = ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("FavoritesProxyImpl", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.FavoritesProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */