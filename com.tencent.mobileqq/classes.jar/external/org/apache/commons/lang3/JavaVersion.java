package external.org.apache.commons.lang3;

public enum JavaVersion
{
  JAVA_0_9(1.5F, "0.9"),  JAVA_1_1(1.1F, "1.1"),  JAVA_1_2(1.2F, "1.2"),  JAVA_1_3(1.3F, "1.3"),  JAVA_1_4(1.4F, "1.4"),  JAVA_1_5(1.5F, "1.5"),  JAVA_1_6(1.6F, "1.6"),  JAVA_1_7(1.7F, "1.7"),  JAVA_1_8(1.8F, "1.8");
  
  private String name;
  private float value;
  
  private JavaVersion(float paramFloat, String paramString)
  {
    this.value = paramFloat;
    this.name = paramString;
  }
  
  static JavaVersion get(String paramString)
  {
    if ("0.9".equals(paramString)) {
      return JAVA_0_9;
    }
    if ("1.1".equals(paramString)) {
      return JAVA_1_1;
    }
    if ("1.2".equals(paramString)) {
      return JAVA_1_2;
    }
    if ("1.3".equals(paramString)) {
      return JAVA_1_3;
    }
    if ("1.4".equals(paramString)) {
      return JAVA_1_4;
    }
    if ("1.5".equals(paramString)) {
      return JAVA_1_5;
    }
    if ("1.6".equals(paramString)) {
      return JAVA_1_6;
    }
    if ("1.7".equals(paramString)) {
      return JAVA_1_7;
    }
    if ("1.8".equals(paramString)) {
      return JAVA_1_8;
    }
    return null;
  }
  
  static JavaVersion getJavaVersion(String paramString)
  {
    return get(paramString);
  }
  
  public boolean atLeast(JavaVersion paramJavaVersion)
  {
    return this.value >= paramJavaVersion.value;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.JavaVersion
 * JD-Core Version:    0.7.0.1
 */