import java.util.HashMap;

public class qzz
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  
  public qzz(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_sceneType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_curIndexDiff", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_preIndexDiff", String.valueOf(this.c));
    localHashMap.put("param_timeInterval", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_isPull", String.valueOf(this.jdField_a_of_type_Boolean));
    localHashMap.put("param_isAutoPlay", String.valueOf(this.jdField_b_of_type_Boolean));
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("mSceneType: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mCurIndexDiff: ").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mPreIndexDiff: ").append(this.c);
    localStringBuilder.append(", mTimeInterval: ").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mIsPull: ").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mIsAutoPlay: ").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qzz
 * JD-Core Version:    0.7.0.1
 */