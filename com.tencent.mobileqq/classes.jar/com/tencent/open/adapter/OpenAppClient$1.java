package com.tencent.open.adapter;

import bjom;
import bjoq;
import com.tencent.open.downloadnew.common.NoticeParam;

final class OpenAppClient$1
  implements Runnable
{
  public void run()
  {
    NoticeParam localNoticeParam = new NoticeParam();
    localNoticeParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localNoticeParam.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localNoticeParam.d = this.c;
    localNoticeParam.f = this.d;
    localNoticeParam.c = "";
    localNoticeParam.e = this.e;
    localNoticeParam.jdField_b_of_type_Int = 4;
    localNoticeParam.jdField_a_of_type_AndroidContentIntent = bjoq.a(this.f, this.g, this.jdField_a_of_type_Int);
    bjom.a().a(localNoticeParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient.1
 * JD-Core Version:    0.7.0.1
 */