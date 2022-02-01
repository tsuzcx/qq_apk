package rx.observers;

final class SerializedObserver$FastList
{
  Object[] array;
  int size;
  
  public void add(Object paramObject)
  {
    int i = this.size;
    Object[] arrayOfObject2 = this.array;
    Object[] arrayOfObject1;
    if (arrayOfObject2 == null)
    {
      arrayOfObject1 = new Object[16];
      this.array = arrayOfObject1;
    }
    else
    {
      arrayOfObject1 = arrayOfObject2;
      if (i == arrayOfObject2.length)
      {
        arrayOfObject1 = new Object[(i >> 2) + i];
        System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, i);
        this.array = arrayOfObject1;
      }
    }
    arrayOfObject1[i] = paramObject;
    this.size = (i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.observers.SerializedObserver.FastList
 * JD-Core Version:    0.7.0.1
 */