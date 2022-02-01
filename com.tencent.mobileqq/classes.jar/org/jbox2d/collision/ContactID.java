package org.jbox2d.collision;

public class ContactID
  implements Comparable<ContactID>
{
  public byte indexA;
  public byte indexB;
  public byte typeA;
  public byte typeB;
  
  public ContactID() {}
  
  public ContactID(ContactID paramContactID)
  {
    set(paramContactID);
  }
  
  public int compareTo(ContactID paramContactID)
  {
    return getKey() - paramContactID.getKey();
  }
  
  public void flip()
  {
    byte b = this.indexA;
    this.indexA = this.indexB;
    this.indexB = b;
    b = this.typeA;
    this.typeA = this.typeB;
    this.typeB = b;
  }
  
  public int getKey()
  {
    return this.indexA << 24 | this.indexB << 16 | this.typeA << 8 | this.typeB;
  }
  
  public boolean isEqual(ContactID paramContactID)
  {
    return getKey() == paramContactID.getKey();
  }
  
  public void set(ContactID paramContactID)
  {
    this.indexA = paramContactID.indexA;
    this.indexB = paramContactID.indexB;
    this.typeA = paramContactID.typeA;
    this.typeB = paramContactID.typeB;
  }
  
  public void zero()
  {
    this.indexA = 0;
    this.indexB = 0;
    this.typeA = 0;
    this.typeB = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.ContactID
 * JD-Core Version:    0.7.0.1
 */