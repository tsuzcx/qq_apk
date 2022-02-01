package org.apache.commons.lang;

class IntHashMap$Entry
{
  final int hash;
  final int key;
  Entry next;
  Object value;
  
  protected IntHashMap$Entry(int paramInt1, int paramInt2, Object paramObject, Entry paramEntry)
  {
    this.hash = paramInt1;
    this.key = paramInt2;
    this.value = paramObject;
    this.next = paramEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.IntHashMap.Entry
 * JD-Core Version:    0.7.0.1
 */