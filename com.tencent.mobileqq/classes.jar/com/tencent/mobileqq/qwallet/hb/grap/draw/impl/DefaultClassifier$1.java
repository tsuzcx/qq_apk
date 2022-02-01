package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import java.util.Comparator;

class DefaultClassifier$1
  implements Comparator<DefaultClassifier.ClassItem>
{
  DefaultClassifier$1(DefaultClassifier paramDefaultClassifier) {}
  
  public int a(DefaultClassifier.ClassItem paramClassItem1, DefaultClassifier.ClassItem paramClassItem2)
  {
    if (paramClassItem2.a - paramClassItem1.a > 0.0F) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DefaultClassifier.1
 * JD-Core Version:    0.7.0.1
 */