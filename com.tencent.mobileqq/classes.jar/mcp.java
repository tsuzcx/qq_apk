public class mcp
  extends mco
{
  public final int a;
  public final boolean a;
  public final String c;
  
  public mcp(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    super(6100, null);
    a(paramLong, null);
    this.c = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    return "mId[" + this.c + "], mFrom[" + this.jdField_a_of_type_Int + "], mSender[" + this.jdField_a_of_type_Boolean + "], seq[" + a() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mcp
 * JD-Core Version:    0.7.0.1
 */