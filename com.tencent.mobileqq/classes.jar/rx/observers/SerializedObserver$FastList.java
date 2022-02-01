package rx.observers;

final class SerializedObserver$FastList
{
  Object[] array;
  int size;
  
  public void add(Object paramObject)
  {
    int i = this.size;
    Object localObject = this.array;
    if (localObject == null)
    {
      localObject = new Object[16];
      this.array = ((Object[])localObject);
    }
    for (;;)
    {
      localObject[i] = paramObject;
      this.size = (i + 1);
      return;
      if (i == localObject.length)
      {
        Object[] arrayOfObject = new Object[(i >> 2) + i];
        System.arraycopy(localObject, 0, arrayOfObject, 0, i);
        this.array = arrayOfObject;
        localObject = arrayOfObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.observers.SerializedObserver.FastList
 * JD-Core Version:    0.7.0.1
 */