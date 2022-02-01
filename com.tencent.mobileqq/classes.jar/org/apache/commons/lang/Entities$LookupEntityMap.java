package org.apache.commons.lang;

class Entities$LookupEntityMap
  extends Entities.PrimitiveEntityMap
{
  private static final int LOOKUP_TABLE_SIZE = 256;
  private String[] lookupTable;
  
  private void createLookupTable()
  {
    this.lookupTable = new String[256];
    int i = 0;
    while (i < 256)
    {
      this.lookupTable[i] = super.name(i);
      i += 1;
    }
  }
  
  private String[] lookupTable()
  {
    if (this.lookupTable == null) {
      createLookupTable();
    }
    return this.lookupTable;
  }
  
  public String name(int paramInt)
  {
    if (paramInt < 256) {
      return lookupTable()[paramInt];
    }
    return super.name(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.Entities.LookupEntityMap
 * JD-Core Version:    0.7.0.1
 */