package com.tencent.mobileqq.search.searchengine;

import aypy;
import ayql;
import java.util.List;

class PublicAccountSearchEngine$1
  implements Runnable
{
  PublicAccountSearchEngine$1(PublicAccountSearchEngine paramPublicAccountSearchEngine, ayql paramayql, aypy paramaypy) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_Ayql);
    if (this.jdField_a_of_type_Aypy != null) {
      this.jdField_a_of_type_Aypy.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */