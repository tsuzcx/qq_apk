package com.tencent.mobileqq.search.searchengine;

import bbff;
import bbfs;
import java.util.List;

class PublicAccountSearchEngine$1
  implements Runnable
{
  PublicAccountSearchEngine$1(PublicAccountSearchEngine paramPublicAccountSearchEngine, bbfs parambbfs, bbff parambbff) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_Bbfs);
    if (this.jdField_a_of_type_Bbff != null) {
      this.jdField_a_of_type_Bbff.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */