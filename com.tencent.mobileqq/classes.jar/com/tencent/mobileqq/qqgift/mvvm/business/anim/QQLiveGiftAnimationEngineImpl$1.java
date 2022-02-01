package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class QQLiveGiftAnimationEngineImpl$1
  extends LinkedHashMap
{
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.QQLiveGiftAnimationEngineImpl.1
 * JD-Core Version:    0.7.0.1
 */