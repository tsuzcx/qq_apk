public class sra
  extends sqy
{
  public int d = -1;
  public int e = -1;
  
  public sra() {}
  
  public sra(spl paramspl)
  {
    super(paramspl);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TreeGatherConfig =[");
    localStringBuilder.append(" mStartGatherLevel=").append(this.d);
    localStringBuilder.append(" mEndGatherLevel=").append(this.e);
    localStringBuilder.append("] ");
    return localStringBuilder.toString() + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sra
 * JD-Core Version:    0.7.0.1
 */