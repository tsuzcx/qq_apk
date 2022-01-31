package rx.subjects;

final class ReplaySubject$NodeList<T>
{
  final ReplaySubject.NodeList.Node<T> head = new ReplaySubject.NodeList.Node(null);
  int size;
  ReplaySubject.NodeList.Node<T> tail = this.head;
  
  public void addLast(T paramT)
  {
    ReplaySubject.NodeList.Node localNode = this.tail;
    paramT = new ReplaySubject.NodeList.Node(paramT);
    localNode.next = paramT;
    this.tail = paramT;
    this.size += 1;
  }
  
  public void clear()
  {
    this.tail = this.head;
    this.size = 0;
  }
  
  public boolean isEmpty()
  {
    return this.size == 0;
  }
  
  public T removeFirst()
  {
    if (this.head.next == null) {
      throw new IllegalStateException("Empty!");
    }
    ReplaySubject.NodeList.Node localNode = this.head.next;
    this.head.next = localNode.next;
    if (this.head.next == null) {
      this.tail = this.head;
    }
    this.size -= 1;
    return localNode.value;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.subjects.ReplaySubject.NodeList
 * JD-Core Version:    0.7.0.1
 */