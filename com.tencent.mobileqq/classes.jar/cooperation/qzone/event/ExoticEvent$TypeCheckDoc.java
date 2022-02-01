package cooperation.qzone.event;

import java.util.LinkedList;
import java.util.List;

class ExoticEvent$TypeCheckDoc
{
  private Object copyParam;
  private final Object originParam;
  private boolean pass;
  private final List<Integer> types;
  
  public ExoticEvent$TypeCheckDoc(TypeCheckDoc paramTypeCheckDoc, Object paramObject)
  {
    this.types = paramTypeCheckDoc.types;
    this.originParam = paramObject;
    this.pass = paramTypeCheckDoc.pass;
    this.copyParam = this.originParam;
  }
  
  private ExoticEvent$TypeCheckDoc(Object paramObject)
  {
    this.types = new LinkedList();
    this.originParam = paramObject;
    this.pass = true;
    this.copyParam = this.originParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.event.ExoticEvent.TypeCheckDoc
 * JD-Core Version:    0.7.0.1
 */