package com.tencent.mobileqq.search.searchengine;

import bcmd;
import bcmq;
import java.util.List;

class PublicAccountSearchEngine$1
  implements Runnable
{
  PublicAccountSearchEngine$1(PublicAccountSearchEngine paramPublicAccountSearchEngine, bcmq parambcmq, bcmd parambcmd) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_Bcmq);
    if (this.jdField_a_of_type_Bcmd != null) {
      this.jdField_a_of_type_Bcmd.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */